package com.bytedance.locallife.groupon.struct.popup;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 !2\u00020\u0001:\u0001\"B7\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0018\u0010\u0017R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/popup/DialogUiConfig;", "", "Lcom/bytedance/locallife/groupon/struct/popup/LayoutConfig;", "component1", "component2", "Lcom/bytedance/locallife/groupon/struct/popup/GravityConfig;", "component3", "Lcom/bytedance/locallife/groupon/struct/popup/MarginConfig;", "component4", "widthConfig", "heightConfig", "gravityConfig", "marginConfig", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/bytedance/locallife/groupon/struct/popup/LayoutConfig;", "getWidthConfig", "()Lcom/bytedance/locallife/groupon/struct/popup/LayoutConfig;", "getHeightConfig", "Lcom/bytedance/locallife/groupon/struct/popup/GravityConfig;", "getGravityConfig", "()Lcom/bytedance/locallife/groupon/struct/popup/GravityConfig;", "Lcom/bytedance/locallife/groupon/struct/popup/MarginConfig;", "getMarginConfig", "()Lcom/bytedance/locallife/groupon/struct/popup/MarginConfig;", "<init>", "(Lcom/bytedance/locallife/groupon/struct/popup/LayoutConfig;Lcom/bytedance/locallife/groupon/struct/popup/LayoutConfig;Lcom/bytedance/locallife/groupon/struct/popup/GravityConfig;Lcom/bytedance/locallife/groupon/struct/popup/MarginConfig;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class DialogUiConfig {
    public static final int CONFIG_MODE_RATIO = 1;
    public static final int CONFIG_MODE_VALUE = 2;
    public static final a Companion = null;

    @SerializedName("layout_gravity")
    private final GravityConfig gravityConfig;

    @SerializedName("height_config")
    private final LayoutConfig heightConfig;

    @SerializedName("margin_config")
    private final MarginConfig marginConfig;

    @SerializedName("width_config")
    private final LayoutConfig widthConfig;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DialogUiConfig() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ DialogUiConfig copy$default(DialogUiConfig r100, LayoutConfig r101, LayoutConfig r102, GravityConfig r103, MarginConfig r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.widthConfig;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.heightConfig;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.gravityConfig;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.marginConfig;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final LayoutConfig component1() {
        return this.widthConfig;
    }

    public final LayoutConfig component2() {
        return this.heightConfig;
    }

    public final GravityConfig component3() {
        return this.gravityConfig;
    }

    public final MarginConfig component4() {
        return this.marginConfig;
    }

    public final DialogUiConfig copy(LayoutConfig r100, LayoutConfig r101, GravityConfig r102, MarginConfig r103) {
        return new DialogUiConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DialogUiConfig) == true) goto L8;
        return false;
    L8:
        DialogUiConfig r101 = (DialogUiConfig) r100;
        if (Intrinsics.areEqual(this.widthConfig, r101.widthConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.heightConfig, r101.heightConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.gravityConfig, r101.gravityConfig) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.marginConfig, r101.marginConfig) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        LayoutConfig r100 = this.widthConfig;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        LayoutConfig r104 = this.heightConfig;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        GravityConfig r107 = this.gravityConfig;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        MarginConfig r110 = this.marginConfig;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "DialogUiConfig(widthConfig=" + this.widthConfig + ", heightConfig=" + this.heightConfig + ", gravityConfig=" + this.gravityConfig + ", marginConfig=" + this.marginConfig + ')';
    }

    public final GravityConfig getGravityConfig() {
        return this.gravityConfig;
    }

    public final LayoutConfig getHeightConfig() {
        return this.heightConfig;
    }

    public final MarginConfig getMarginConfig() {
        return this.marginConfig;
    }

    public final LayoutConfig getWidthConfig() {
        return this.widthConfig;
    }

    public DialogUiConfig(LayoutConfig r100, LayoutConfig r101, GravityConfig r102, MarginConfig r103) {
        this.widthConfig = r100;
        this.heightConfig = r101;
        this.gravityConfig = r102;
        this.marginConfig = r103;
    }

    public /* synthetic */ DialogUiConfig(LayoutConfig r100, LayoutConfig r101, GravityConfig r102, MarginConfig r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
