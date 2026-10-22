package com.larus.office.plugins.slides.orientation;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/office/plugins/slides/orientation/SetFullscreenModel;", "", "enable", "", "option", "Lcom/larus/office/plugins/slides/orientation/FullscreenOption;", "<init>", "(Ljava/lang/Boolean;Lcom/larus/office/plugins/slides/orientation/FullscreenOption;)V", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getOption", "()Lcom/larus/office/plugins/slides/orientation/FullscreenOption;", "setOption", "(Lcom/larus/office/plugins/slides/orientation/FullscreenOption;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SetFullscreenModel {

    @SerializedName("enable")
    private Boolean enable;

    @SerializedName("option")
    private FullscreenOption option;

    /* JADX WARN: Multi-variable type inference failed */
    public SetFullscreenModel() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final Boolean getEnable() {
        return this.enable;
    }

    public final FullscreenOption getOption() {
        return this.option;
    }

    public final void setEnable(Boolean r100) {
        this.enable = r100;
    }

    public final void setOption(FullscreenOption r100) {
        this.option = r100;
    }

    public SetFullscreenModel(Boolean r100, FullscreenOption r101) {
        this.enable = r100;
        this.option = r101;
    }

    public /* synthetic */ SetFullscreenModel(Boolean r100, FullscreenOption r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
