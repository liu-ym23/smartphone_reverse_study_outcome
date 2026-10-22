package com.larus.dora.impl.core.settingsconfig;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.media.MediaScene;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/larus/dora/impl/core/settingsconfig/DoraMultiDeviceConfig;", "", "doraG", "", MediaScene.DORA, "doraE", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getDoraG", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getDora", "getDoraE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraMultiDeviceConfig {

    @SerializedName(DoraObricDeviceHomeViewModel.DEFAULT_DEVICE_NAME)
    private final Boolean dora;

    @SerializedName("DoraE")
    private final Boolean doraE;

    @SerializedName("DoraG")
    private final Boolean doraG;

    public DoraMultiDeviceConfig() {
        this(null, null, null, 7, null);
    }

    public final Boolean getDora() {
        return this.dora;
    }

    public final Boolean getDoraE() {
        return this.doraE;
    }

    public final Boolean getDoraG() {
        return this.doraG;
    }

    public DoraMultiDeviceConfig(Boolean r100, Boolean r101, Boolean r102) {
        this.doraG = r100;
        this.dora = r101;
        this.doraE = r102;
    }

    public /* synthetic */ DoraMultiDeviceConfig(Boolean r100, Boolean r101, Boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
