package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/ObricLazyInitConfig;", "", "enableIvyKitLazyInit", "", "enableAppletLazyInit", "enableTTVideoEngineLazyInit", "enableLocalLifeLazyInit", "enableECommerceLazyInit", "<init>", "(ZZZZZ)V", "getEnableIvyKitLazyInit", "()Z", "getEnableAppletLazyInit", "getEnableTTVideoEngineLazyInit", "getEnableLocalLifeLazyInit", "getEnableECommerceLazyInit", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricLazyInitConfig {

    @SerializedName("enable_applet_lazy_init")
    private final boolean enableAppletLazyInit;

    @SerializedName("enable_ecommerce_lazy_init")
    private final boolean enableECommerceLazyInit;

    @SerializedName("enable_ivykit_lazy_init")
    private final boolean enableIvyKitLazyInit;

    @SerializedName("enable_local_life_lazy_init")
    private final boolean enableLocalLifeLazyInit;

    @SerializedName("enable_tt_video_engine_lazy_init")
    private final boolean enableTTVideoEngineLazyInit;

    public ObricLazyInitConfig() {
        this(false, false, false, false, false, 31, null);
    }

    public static /* synthetic */ ObricLazyInitConfig copy$default(ObricLazyInitConfig r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.enableIvyKitLazyInit;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.enableAppletLazyInit;
    L8:
        boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.enableTTVideoEngineLazyInit;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.enableLocalLifeLazyInit;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.enableECommerceLazyInit;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.enableIvyKitLazyInit;
    }

    public final boolean component2() {
        return this.enableAppletLazyInit;
    }

    public final boolean component3() {
        return this.enableTTVideoEngineLazyInit;
    }

    public final boolean component4() {
        return this.enableLocalLifeLazyInit;
    }

    public final boolean component5() {
        return this.enableECommerceLazyInit;
    }

    public final ObricLazyInitConfig copy(boolean r100, boolean r101, boolean r110, boolean r111, boolean r112) {
        return new ObricLazyInitConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricLazyInitConfig) == true) goto L8;
        return false;
    L8:
        ObricLazyInitConfig r101 = (ObricLazyInitConfig) r100;
        if (this.enableIvyKitLazyInit == r101.enableIvyKitLazyInit) goto L12;
        return false;
    L12:
        if (this.enableAppletLazyInit == r101.enableAppletLazyInit) goto L15;
        return false;
    L15:
        if (this.enableTTVideoEngineLazyInit == r101.enableTTVideoEngineLazyInit) goto L18;
        return false;
    L18:
        if (this.enableLocalLifeLazyInit == r101.enableLocalLifeLazyInit) goto L21;
        return false;
    L21:
        if (this.enableECommerceLazyInit == r101.enableECommerceLazyInit) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableIvyKitLazyInit == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableAppletLazyInit == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableTTVideoEngineLazyInit == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.enableLocalLifeLazyInit == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.enableECommerceLazyInit == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricLazyInitConfig(enableIvyKitLazyInit=" + this.enableIvyKitLazyInit + ", enableAppletLazyInit=" + this.enableAppletLazyInit + ", enableTTVideoEngineLazyInit=" + this.enableTTVideoEngineLazyInit + ", enableLocalLifeLazyInit=" + this.enableLocalLifeLazyInit + ", enableECommerceLazyInit=" + this.enableECommerceLazyInit + ')';
    }

    public final boolean getEnableAppletLazyInit() {
        return this.enableAppletLazyInit;
    }

    public final boolean getEnableECommerceLazyInit() {
        return this.enableECommerceLazyInit;
    }

    public final boolean getEnableIvyKitLazyInit() {
        return this.enableIvyKitLazyInit;
    }

    public final boolean getEnableLocalLifeLazyInit() {
        return this.enableLocalLifeLazyInit;
    }

    public final boolean getEnableTTVideoEngineLazyInit() {
        return this.enableTTVideoEngineLazyInit;
    }

    public ObricLazyInitConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.enableIvyKitLazyInit = r100;
        this.enableAppletLazyInit = r101;
        this.enableTTVideoEngineLazyInit = r102;
        this.enableLocalLifeLazyInit = r103;
        this.enableECommerceLazyInit = r104;
    }

    public /* synthetic */ ObricLazyInitConfig(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        boolean r112 = false;
    L7:
        if ((r110 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r110 & 4) == 0) goto L13;
        boolean r106 = false;
    L15:
        if ((r110 & 8) == 0) goto L17;
        boolean r107 = false;
    L19:
        if ((r110 & 16) == 0) goto L21;
        boolean r113 = false;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
