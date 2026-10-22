package com.ss.android.lark.officesdk.minutes.ui.foundation.dialog;

import android.os.Bundle;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmPanelHeightConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\t2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006%"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/foundation/dialog/MmPanelFragmentArgs;", "Ljava/io/Serializable;", "registryTag", "", "heightConfig", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;", "uiLaunchMode", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "isCancelable", "", "drawBehindNavigationBar", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;ZZ)V", "getRegistryTag", "()Ljava/lang/String;", "getHeightConfig", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHeightConfig;", "getUiLaunchMode", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingUILaunchMode;", "()Z", "getDrawBehindNavigationBar", "toBundle", "Landroid/os/Bundle;", "extraArgs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "Companion", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MmPanelFragmentArgs implements Serializable {
    public static final a Companion = null;
    private final boolean drawBehindNavigationBar;
    private final MmPanelHeightConfig heightConfig;
    private final boolean isCancelable;
    private final String registryTag;
    private final MmRecordingUILaunchMode uiLaunchMode;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ MmPanelFragmentArgs copy$default(MmPanelFragmentArgs r100, String r101, MmPanelHeightConfig r102, MmRecordingUILaunchMode r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.registryTag;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.heightConfig;
    L8:
        MmPanelHeightConfig r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.uiLaunchMode;
    L11:
        MmRecordingUILaunchMode r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isCancelable;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.drawBehindNavigationBar;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.registryTag;
    }

    public final MmPanelHeightConfig component2() {
        return this.heightConfig;
    }

    public final MmRecordingUILaunchMode component3() {
        return this.uiLaunchMode;
    }

    public final boolean component4() {
        return this.isCancelable;
    }

    public final boolean component5() {
        return this.drawBehindNavigationBar;
    }

    public final MmPanelFragmentArgs copy(String r100, MmPanelHeightConfig r101, MmRecordingUILaunchMode r110, boolean r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "registryTag");
        Intrinsics.checkNotNullParameter(r110, "uiLaunchMode");
        return new MmPanelFragmentArgs(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MmPanelFragmentArgs) == true) goto L8;
        return false;
    L8:
        MmPanelFragmentArgs r101 = (MmPanelFragmentArgs) r100;
        if (Intrinsics.areEqual(this.registryTag, r101.registryTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.heightConfig, r101.heightConfig) == true) goto L15;
        return false;
    L15:
        if (this.uiLaunchMode == r101.uiLaunchMode) goto L18;
        return false;
    L18:
        if (this.isCancelable == r101.isCancelable) goto L21;
        return false;
    L21:
        if (this.drawBehindNavigationBar == r101.drawBehindNavigationBar) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.registryTag.hashCode() * 31;
        MmPanelHeightConfig r101 = this.heightConfig;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + this.uiLaunchMode.hashCode()) * 31;
        int r104 = 1231;
        if (this.isCancelable == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.drawBehindNavigationBar == true) goto L15;
        r104 = 1237;
    L15:
        return r106 + r104;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "MmPanelFragmentArgs(registryTag=" + this.registryTag + ", heightConfig=" + this.heightConfig + ", uiLaunchMode=" + this.uiLaunchMode + ", isCancelable=" + this.isCancelable + ", drawBehindNavigationBar=" + this.drawBehindNavigationBar + ')';
    }

    public final boolean getDrawBehindNavigationBar() {
        return this.drawBehindNavigationBar;
    }

    public final MmPanelHeightConfig getHeightConfig() {
        return this.heightConfig;
    }

    public final String getRegistryTag() {
        return this.registryTag;
    }

    public final MmRecordingUILaunchMode getUiLaunchMode() {
        return this.uiLaunchMode;
    }

    public final boolean isCancelable() {
        return this.isCancelable;
    }

    public final Bundle toBundle(Bundle r100) {
        if (r100 != null) goto L5;
        r100 = new Bundle();
    L5:
        Bundle r101 = new Bundle(r100);
        r101.putSerializable("key_mm_panel_fragment_args", this);
        return r101;
    }

    public static /* synthetic */ Bundle toBundle$default(MmPanelFragmentArgs r100, Bundle r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.toBundle(r101);
    }

    public MmPanelFragmentArgs(String r100, MmPanelHeightConfig r101, MmRecordingUILaunchMode r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "registryTag");
        Intrinsics.checkNotNullParameter(r102, "uiLaunchMode");
        this.registryTag = r100;
        this.heightConfig = r101;
        this.uiLaunchMode = r102;
        this.isCancelable = r103;
        this.drawBehindNavigationBar = r104;
    }

    public /* synthetic */ MmPanelFragmentArgs(String r100, MmPanelHeightConfig r101, MmRecordingUILaunchMode r102, boolean r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 2) == 0) goto L5;
        r101 = null;
    L5:
        MmPanelHeightConfig r103 = r101;
        if ((r112 & 4) == 0) goto L8;
        r102 = MmRecordingUILaunchMode.UNKNOWN;
    L8:
        MmRecordingUILaunchMode r104 = r102;
        if ((r112 & 8) == 0) goto L11;
        boolean r105 = true;
    L13:
        if ((r112 & 16) == 0) goto L15;
        boolean r106 = false;
    L16:
        this(r100, r103, r104, r105, r106);
        return;
    L15:
        r106 = r111;
        goto L16
    L11:
        r105 = r110;
        goto L13
    }
}
