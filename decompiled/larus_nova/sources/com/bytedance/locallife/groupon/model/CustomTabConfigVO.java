package com.bytedance.locallife.groupon.model;

import ar6.b;
import ar6.d;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0087\b\u0018\u0000 12\u00020\u0001:\u00012Ba\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b/\u00100J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jc\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0019\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b \u0010\u001fR\u001a\u0010\u0011\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b-\u0010,R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b.\u0010&¨\u00063"}, d2 = {"Lcom/bytedance/locallife/groupon/model/CustomTabConfigVO;", "", "", "component1", "component2", "", "component3", "Lar6/a;", "component4", "Lar6/b;", "component5", "Lar6/d;", "component6", "component7", "component8", "enableFixedTab", "hasScrollIndicator", "tabItemStyle", "tabItemBackground", "tabItemBackgroundRadius", "selectTabItemTextStyle", "unselectTabItemTextStyle", "tabContainerBackGround", "copy", "", "toString", "hashCode", "other", "equals", "Z", "getEnableFixedTab", "()Z", "getHasScrollIndicator", "I", "getTabItemStyle", "()I", "Lar6/a;", "getTabItemBackground", "()Lar6/a;", "Lar6/b;", "getTabItemBackgroundRadius", "()Lar6/b;", "Lar6/d;", "getSelectTabItemTextStyle", "()Lar6/d;", "getUnselectTabItemTextStyle", "getTabContainerBackGround", "<init>", "(ZZILar6/a;Lar6/b;Lar6/d;Lar6/d;Lar6/a;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class CustomTabConfigVO {
    public static final a Companion = null;
    public static final int TAB_ITEM_STYLE_BTN = 1;
    public static final int TAB_ITEM_STYLE_NORMAL = 0;

    @SerializedName("enable_fixed")
    private final boolean enableFixedTab;

    @SerializedName("has_scroll_indicator")
    private final boolean hasScrollIndicator;

    @SerializedName("select_tab_item_text_style")
    private final d selectTabItemTextStyle;

    @SerializedName("tab_container_background")
    private final ar6.a tabContainerBackGround;

    @SerializedName("tab_item_background")
    private final ar6.a tabItemBackground;

    @SerializedName("tab_item_background_radius")
    private final b tabItemBackgroundRadius;

    @SerializedName("tab_item_style")
    private final int tabItemStyle;

    @SerializedName("unselect_tab_item_text_style")
    private final d unselectTabItemTextStyle;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CustomTabConfigVO() {
        this(false, false, 0, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ CustomTabConfigVO copy$default(CustomTabConfigVO r100, boolean r110, boolean r111, int r112, ar6.a r113, b r114, d r115, d r116, ar6.a r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        boolean r101 = r100.enableFixedTab;
    L7:
        if ((r118 & 2) == 0) goto L9;
        boolean r102 = r100.hasScrollIndicator;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = r100.tabItemStyle;
    L15:
        if ((r118 & 8) == 0) goto L17;
        ar6.a r104 = r100.tabItemBackground;
    L19:
        if ((r118 & 16) == 0) goto L21;
        b r105 = r100.tabItemBackgroundRadius;
    L23:
        if ((r118 & 32) == 0) goto L25;
        d r106 = r100.selectTabItemTextStyle;
    L27:
        if ((r118 & 64) == 0) goto L29;
        d r107 = r100.unselectTabItemTextStyle;
    L31:
        if ((r118 & 128) == 0) goto L33;
        ar6.a r108 = r100.tabContainerBackGround;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final boolean component1() {
        return this.enableFixedTab;
    }

    public final boolean component2() {
        return this.hasScrollIndicator;
    }

    public final int component3() {
        return this.tabItemStyle;
    }

    public final ar6.a component4() {
        return this.tabItemBackground;
    }

    public final b component5() {
        return this.tabItemBackgroundRadius;
    }

    public final d component6() {
        return this.selectTabItemTextStyle;
    }

    public final d component7() {
        return this.unselectTabItemTextStyle;
    }

    public final ar6.a component8() {
        return this.tabContainerBackGround;
    }

    public final CustomTabConfigVO copy(boolean r110, boolean r111, int r112, ar6.a r113, b r114, d r115, d r116, ar6.a r117) {
        return new CustomTabConfigVO(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CustomTabConfigVO) == true) goto L8;
        return false;
    L8:
        CustomTabConfigVO r101 = (CustomTabConfigVO) r100;
        if (this.enableFixedTab == r101.enableFixedTab) goto L12;
        return false;
    L12:
        if (this.hasScrollIndicator == r101.hasScrollIndicator) goto L15;
        return false;
    L15:
        if (this.tabItemStyle == r101.tabItemStyle) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tabItemBackground, r101.tabItemBackground) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tabItemBackgroundRadius, r101.tabItemBackgroundRadius) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.selectTabItemTextStyle, r101.selectTabItemTextStyle) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.unselectTabItemTextStyle, r101.unselectTabItemTextStyle) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.tabContainerBackGround, r101.tabContainerBackGround) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.enableFixedTab == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.hasScrollIndicator == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (((r102 + r100) * 31) + this.tabItemStyle) * 31;
        ar6.a r104 = this.tabItemBackground;
        int r105 = 0;
        if (r104 != null) goto L13;
        int r106 = 0;
    L14:
        int r107 = (r103 + r106) * 31;
        b r108 = this.tabItemBackgroundRadius;
        if (r108 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r107 + r109) * 31;
        d r111 = this.selectTabItemTextStyle;
        if (r111 != null) goto L21;
        int r112 = 0;
    L22:
        int r113 = (r110 + r112) * 31;
        d r114 = this.unselectTabItemTextStyle;
        if (r114 != null) goto L25;
        int r115 = 0;
    L26:
        int r116 = (r113 + r115) * 31;
        ar6.a r117 = this.tabContainerBackGround;
        if (r117 == null) goto L31;
        r105 = r117.hashCode();
    L31:
        return r116 + r105;
    L25:
        r115 = r114.hashCode();
        goto L26
    L21:
        r112 = r111.hashCode();
        goto L22
    L17:
        r109 = r108.hashCode();
        goto L18
    L13:
        r106 = r104.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "CustomTabConfigVO(enableFixedTab=" + this.enableFixedTab + ", hasScrollIndicator=" + this.hasScrollIndicator + ", tabItemStyle=" + this.tabItemStyle + ", tabItemBackground=" + this.tabItemBackground + ", tabItemBackgroundRadius=" + this.tabItemBackgroundRadius + ", selectTabItemTextStyle=" + this.selectTabItemTextStyle + ", unselectTabItemTextStyle=" + this.unselectTabItemTextStyle + ", tabContainerBackGround=" + this.tabContainerBackGround + ')';
    }

    public final boolean getEnableFixedTab() {
        return this.enableFixedTab;
    }

    public final boolean getHasScrollIndicator() {
        return this.hasScrollIndicator;
    }

    public final d getSelectTabItemTextStyle() {
        return this.selectTabItemTextStyle;
    }

    public final ar6.a getTabContainerBackGround() {
        return this.tabContainerBackGround;
    }

    public final ar6.a getTabItemBackground() {
        return this.tabItemBackground;
    }

    public final b getTabItemBackgroundRadius() {
        return this.tabItemBackgroundRadius;
    }

    public final int getTabItemStyle() {
        return this.tabItemStyle;
    }

    public final d getUnselectTabItemTextStyle() {
        return this.unselectTabItemTextStyle;
    }

    public CustomTabConfigVO(boolean r100, boolean r101, int r102, ar6.a r103, b r104, d r105, d r106, ar6.a r107) {
        this.enableFixedTab = r100;
        this.hasScrollIndicator = r101;
        this.tabItemStyle = r102;
        this.tabItemBackground = r103;
        this.tabItemBackgroundRadius = r104;
        this.selectTabItemTextStyle = r105;
        this.unselectTabItemTextStyle = r106;
        this.tabContainerBackGround = r107;
    }

    public /* synthetic */ CustomTabConfigVO(boolean r110, boolean r111, int r112, ar6.a r113, b r114, d r115, d r116, ar6.a r117, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r210 & 2) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r210 & 4) == 0) goto L13;
        int r102 = 0;
    L15:
        if ((r210 & 8) == 0) goto L17;
        ar6.a r103 = null;
    L19:
        if ((r210 & 16) == 0) goto L21;
        b r104 = new b(CollectionsKt.arrayListOf(new Float[]{Float.valueOf(12.0f), Float.valueOf(12.0f), Float.valueOf(12.0f), Float.valueOf(12.0f)}), 30);
    L23:
        if ((r210 & 32) == 0) goto L25;
        d r105 = new d("#161823", "#161823", Float.valueOf(15.0f), 17);
    L27:
        if ((r210 & 64) == 0) goto L29;
        d r106 = new d("#161823E6", "#161823E6", Float.valueOf(15.0f), 17);
    L31:
        if ((r210 & 128) == 0) goto L33;
        ar6.a r107 = new ar6.a(CustomHeaderConfig.COLOR_LIGHT, "#1C1D1E");
    L34:
        this(r100, r101, r102, r103, r104, r105, r106, r107);
        return;
    L33:
        r107 = r117;
        goto L34
    L29:
        r106 = r116;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
