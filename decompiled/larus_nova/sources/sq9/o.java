package sq9;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u0011\u00101\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0017HÆ\u0003J½\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001J\u0013\u0010=\u001a\u00020\u00032\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020\bHÖ\u0001J\t\u0010@\u001a\u00020AHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001bR\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/platform/model/creation/CreativityLaunchConfig;", "", "hitCreationReverse", "", "showCreationTab", "showFeedUserInfo", "showDetailPageUserInfo", "sameStyleBtn", "", "alwaysShowBottomTab", "creationInstructions", "", "Lcom/larus/platform/model/creation/InstructionDTO;", "isNewDiscoverStyle", "isAlwaysShowFloatBtn", "creationMultiTab", "templateMultiTab", "storeActionBarLastTab", "showLikeBtn", "showMoreInspires", "needCreationPage", "showComments", "tplShortcutShowInfo", "Lcom/larus/platform/model/creation/TplShortcutShowInfo;", "<init>", "(ZZZZIZLjava/util/List;ZZZZZZZZZLcom/larus/platform/model/creation/TplShortcutShowInfo;)V", "getHitCreationReverse", "()Z", "getShowCreationTab", "getShowFeedUserInfo", "getShowDetailPageUserInfo", "getSameStyleBtn", "()I", "getAlwaysShowBottomTab", "getCreationInstructions", "()Ljava/util/List;", "getCreationMultiTab", "getTemplateMultiTab", "getStoreActionBarLastTab", "getShowLikeBtn", "getShowMoreInspires", "getNeedCreationPage", "getShowComments", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o {

    @SerializedName("always_show_bottom_tab")
    private final boolean alwaysShowBottomTab;

    @SerializedName("creation_instruction")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<x> creationInstructions;

    @SerializedName("creation_multi_tab")
    private final boolean creationMultiTab;

    @SerializedName("hit_creation_reverse")
    private final boolean hitCreationReverse;

    @SerializedName("show_float_btn")
    private final boolean isAlwaysShowFloatBtn;

    @SerializedName("new_discover_page")
    private final boolean isNewDiscoverStyle;

    @SerializedName("new_creation_page")
    private final boolean needCreationPage;

    @SerializedName("same_style_btn")
    private final int sameStyleBtn;

    @SerializedName("show_comments")
    private final boolean showComments;

    @SerializedName("show_creation_tab")
    private final boolean showCreationTab;

    @SerializedName("detail_page_show_use_info")
    private final boolean showDetailPageUserInfo;

    @SerializedName("feed_show_use_info")
    private final boolean showFeedUserInfo;

    @SerializedName("show_lick_btn")
    private final boolean showLikeBtn;

    @SerializedName("show_more_inspires")
    private final boolean showMoreInspires;

    @SerializedName("store_actionbar_last_tab")
    private final boolean storeActionBarLastTab;

    @SerializedName("template_multi_tab")
    private final boolean templateMultiTab;

    @SerializedName("tpl_shortcut_show_info")
    public final b0 tplShortcutShowInfo;

    public o() {
        this(false, false, false, false, null, false, false, false, false, false, false, false, 131071);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.hitCreationReverse == r101.hitCreationReverse) goto L12;
        return false;
    L12:
        if (this.showCreationTab == r101.showCreationTab) goto L15;
        return false;
    L15:
        if (this.showFeedUserInfo == r101.showFeedUserInfo) goto L18;
        return false;
    L18:
        if (this.showDetailPageUserInfo == r101.showDetailPageUserInfo) goto L21;
        return false;
    L21:
        if (this.sameStyleBtn == r101.sameStyleBtn) goto L24;
        return false;
    L24:
        if (this.alwaysShowBottomTab == r101.alwaysShowBottomTab) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.creationInstructions, r101.creationInstructions) == true) goto L30;
        return false;
    L30:
        if (this.isNewDiscoverStyle == r101.isNewDiscoverStyle) goto L33;
        return false;
    L33:
        if (this.isAlwaysShowFloatBtn == r101.isAlwaysShowFloatBtn) goto L36;
        return false;
    L36:
        if (this.creationMultiTab == r101.creationMultiTab) goto L39;
        return false;
    L39:
        if (this.templateMultiTab == r101.templateMultiTab) goto L42;
        return false;
    L42:
        if (this.storeActionBarLastTab == r101.storeActionBarLastTab) goto L45;
        return false;
    L45:
        if (this.showLikeBtn == r101.showLikeBtn) goto L48;
        return false;
    L48:
        if (this.showMoreInspires == r101.showMoreInspires) goto L51;
        return false;
    L51:
        if (this.needCreationPage == r101.needCreationPage) goto L54;
        return false;
    L54:
        if (this.showComments == r101.showComments) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.tplShortcutShowInfo, r101.tplShortcutShowInfo) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.hitCreationReverse == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.showCreationTab == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.showFeedUserInfo == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.showDetailPageUserInfo == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (((r106 + r107) * 31) + this.sameStyleBtn) * 31;
        if (this.alwaysShowBottomTab == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        List<x> r111 = this.creationInstructions;
        int r112 = 0;
        if (r111 != null) goto L25;
        int r113 = 0;
    L26:
        int r114 = (r110 + r113) * 31;
        if (this.isNewDiscoverStyle == false) goto L29;
        int r115 = 1231;
    L30:
        int r116 = (r114 + r115) * 31;
        if (this.isAlwaysShowFloatBtn == false) goto L33;
        int r117 = 1231;
    L34:
        int r118 = (r116 + r117) * 31;
        if (this.creationMultiTab == false) goto L37;
        int r119 = 1231;
    L38:
        int r120 = (r118 + r119) * 31;
        if (this.templateMultiTab == false) goto L41;
        int r121 = 1231;
    L42:
        int r122 = (r120 + r121) * 31;
        if (this.storeActionBarLastTab == false) goto L45;
        int r123 = 1231;
    L46:
        int r124 = (r122 + r123) * 31;
        if (this.showLikeBtn == false) goto L49;
        int r125 = 1231;
    L50:
        int r126 = (r124 + r125) * 31;
        if (this.showMoreInspires == false) goto L53;
        int r127 = 1231;
    L54:
        int r128 = (r126 + r127) * 31;
        if (this.needCreationPage == false) goto L57;
        int r129 = 1231;
    L58:
        int r130 = (r128 + r129) * 31;
        if (this.showComments == true) goto L62;
        r100 = 1237;
    L62:
        int r131 = (r130 + r100) * 31;
        b0 r132 = this.tplShortcutShowInfo;
        if (r132 == null) goto L67;
        r112 = r132.hashCode();
    L67:
        return r131 + r112;
    L57:
        r129 = 1237;
        goto L58
    L53:
        r127 = 1237;
        goto L54
    L49:
        r125 = 1237;
        goto L50
    L45:
        r123 = 1237;
        goto L46
    L41:
        r121 = 1237;
        goto L42
    L37:
        r119 = 1237;
        goto L38
    L33:
        r117 = 1237;
        goto L34
    L29:
        r115 = 1237;
        goto L30
    L25:
        r113 = r111.hashCode();
        goto L26
    L21:
        r109 = 1237;
        goto L22
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

    public final String toString() {
        return "CreativityLaunchConfig(hitCreationReverse=" + this.hitCreationReverse + ", showCreationTab=" + this.showCreationTab + ", showFeedUserInfo=" + this.showFeedUserInfo + ", showDetailPageUserInfo=" + this.showDetailPageUserInfo + ", sameStyleBtn=" + this.sameStyleBtn + ", alwaysShowBottomTab=" + this.alwaysShowBottomTab + ", creationInstructions=" + this.creationInstructions + ", isNewDiscoverStyle=" + this.isNewDiscoverStyle + ", isAlwaysShowFloatBtn=" + this.isAlwaysShowFloatBtn + ", creationMultiTab=" + this.creationMultiTab + ", templateMultiTab=" + this.templateMultiTab + ", storeActionBarLastTab=" + this.storeActionBarLastTab + ", showLikeBtn=" + this.showLikeBtn + ", showMoreInspires=" + this.showMoreInspires + ", needCreationPage=" + this.needCreationPage + ", showComments=" + this.showComments + ", tplShortcutShowInfo=" + this.tplShortcutShowInfo + ')';
    }

    public final List<x> a() {
        return this.creationInstructions;
    }

    public final boolean b() {
        return this.creationMultiTab;
    }

    public final boolean c() {
        return this.hitCreationReverse;
    }

    public final boolean d() {
        return this.needCreationPage;
    }

    public final int e() {
        return this.sameStyleBtn;
    }

    public final boolean f() {
        return this.showCreationTab;
    }

    public final boolean g() {
        return this.showFeedUserInfo;
    }

    public final boolean h() {
        return this.showMoreInspires;
    }

    public final boolean i() {
        return this.storeActionBarLastTab;
    }

    public final boolean j() {
        return this.templateMultiTab;
    }

    public final boolean k() {
        return this.isAlwaysShowFloatBtn;
    }

    public final boolean l() {
        return this.isNewDiscoverStyle;
    }

    public o(boolean r110, boolean r111, boolean r112, boolean r210, List r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, int r219) {
        if ((r219 & 2) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r219 & 4) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r219 & 8) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r219 & 32) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r219 & 64) == 0) goto L21;
        List r104 = null;
    L23:
        if ((r219 & 128) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r219 & 256) == 0) goto L29;
        boolean r113 = false;
    L31:
        if ((r219 & 512) == 0) goto L33;
        boolean r114 = false;
    L35:
        if ((r219 & 1024) == 0) goto L37;
        boolean r115 = false;
    L39:
        if ((r219 & 4096) == 0) goto L41;
        boolean r116 = true;
    L43:
        if ((r219 & 16384) == 0) goto L45;
        boolean r117 = false;
    L47:
        if ((r219 & 32768) == 0) goto L49;
        boolean r106 = false;
    L50:
        this.hitCreationReverse = false;
        this.showCreationTab = r100;
        this.showFeedUserInfo = r101;
        this.showDetailPageUserInfo = r102;
        this.sameStyleBtn = 0;
        this.alwaysShowBottomTab = r103;
        this.creationInstructions = r104;
        this.isNewDiscoverStyle = r105;
        this.isAlwaysShowFloatBtn = r113;
        this.creationMultiTab = r114;
        this.templateMultiTab = r115;
        this.storeActionBarLastTab = false;
        this.showLikeBtn = r116;
        this.showMoreInspires = false;
        this.needCreationPage = r117;
        this.showComments = r106;
        this.tplShortcutShowInfo = null;
        return;
    L49:
        r106 = r218;
        goto L50
    L45:
        r117 = r217;
        goto L47
    L41:
        r116 = r216;
        goto L43
    L37:
        r115 = r215;
        goto L39
    L33:
        r114 = r214;
        goto L35
    L29:
        r113 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
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
