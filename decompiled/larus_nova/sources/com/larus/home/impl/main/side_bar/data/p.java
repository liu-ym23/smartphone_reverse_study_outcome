package com.larus.home.impl.main.side_bar.data;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.lynx.jsbridge.LynxResourceModule;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\b\u0086\b\u0018\u00002\u00020\u0001Bß\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\u0012\b\u0002\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0005HÆ\u0003J\u0013\u0010<\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0013\u0010@\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0007HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0010\u0010D\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00103J\t\u0010E\u001a\u00020\u0018HÆ\u0003J\t\u0010F\u001a\u00020\u0018HÆ\u0003J\u0013\u0010G\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u001dHÆ\u0003J\u0011\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0003Jæ\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\u0012\b\u0002\u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u00072\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\u00182\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020\u0005HÖ\u0001J\t\u0010O\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010&R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00104\u001a\u0004\b2\u00103R\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u00105R\u0016\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u00105R \u0010\u001a\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010&¨\u0006P"}, d2 = {"Lcom/larus/home/impl/main/side_bar/data/SideBarComponent;", "", "id", "", "type", "", SlcCommonAction.KEY_ACTIONS, "", "Lcom/larus/home/impl/main/side_bar/data/Action;", "text", "subtitle", LynxResourceModule.FONT_TYPE, "Lcom/larus/home/impl/main/side_bar/data/Font;", "icons", "Lcom/larus/home/impl/main/side_bar/data/Icon;", ItemStyle.ITEM_STYLE_DIVIDER, "Lcom/larus/home/impl/main/side_bar/data/Divider;", "showConfig", "Lcom/larus/home/impl/main/side_bar/data/ShowConfig;", "pageConfig", "Lcom/larus/home/impl/main/side_bar/data/PageConfig;", "bizId", "", "isCollapsed", "", "isSticky", PromotionProductPrivilegesStruct.TAGS, "Lcom/larus/home/impl/main/side_bar/data/Tag;", "biz", "Lcom/larus/home/impl/main/side_bar/data/BizData;", "components", "<init>", "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/larus/home/impl/main/side_bar/data/Font;Ljava/util/List;Lcom/larus/home/impl/main/side_bar/data/Divider;Lcom/larus/home/impl/main/side_bar/data/ShowConfig;Lcom/larus/home/impl/main/side_bar/data/PageConfig;Ljava/lang/Long;ZZLjava/util/List;Lcom/larus/home/impl/main/side_bar/data/BizData;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getType", "()I", "getActions", "()Ljava/util/List;", "getText", "getSubtitle", "getFont", "()Lcom/larus/home/impl/main/side_bar/data/Font;", "getIcons", "getDivider", "()Lcom/larus/home/impl/main/side_bar/data/Divider;", "getShowConfig", "()Lcom/larus/home/impl/main/side_bar/data/ShowConfig;", "getPageConfig", "()Lcom/larus/home/impl/main/side_bar/data/PageConfig;", "getBizId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Z", "getTags", "getBiz", "()Lcom/larus/home/impl/main/side_bar/data/BizData;", "getComponents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/larus/home/impl/main/side_bar/data/Font;Ljava/util/List;Lcom/larus/home/impl/main/side_bar/data/Divider;Lcom/larus/home/impl/main/side_bar/data/ShowConfig;Lcom/larus/home/impl/main/side_bar/data/PageConfig;Ljava/lang/Long;ZZLjava/util/List;Lcom/larus/home/impl/main/side_bar/data/BizData;Ljava/util/List;)Lcom/larus/home/impl/main/side_bar/data/SideBarComponent;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class p {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<a> actions;

    @SerializedName("biz")
    private final b biz;

    @SerializedName(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID)
    private final Long bizId;

    @SerializedName("components")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<p> components;

    @SerializedName(ItemStyle.ITEM_STYLE_DIVIDER)
    private final f divider;

    @SerializedName(LynxResourceModule.FONT_TYPE)
    private final g font;

    @SerializedName("icons")
    private final List<i> icons;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f344531id;

    @SerializedName("is_collapsed")
    private final boolean isCollapsed;

    @SerializedName("is_sticky")
    private final boolean isSticky;

    @SerializedName(LynxMonitorService.KEY_PAGE_CONFIG)
    private final j pageConfig;

    @SerializedName("show_config")
    private final o showConfig;

    @SerializedName("subtitle")
    private final String subtitle;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<e1> tags;

    @SerializedName("text")
    private final String text;

    @SerializedName("type")
    private final int type;

    public p() {
        this(null, 0, null, null, null, null, null, null, null, 65535);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f344531id, r101.f344531id) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.subtitle, r101.subtitle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.font, r101.font) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.icons, r101.icons) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.divider, r101.divider) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.showConfig, r101.showConfig) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.pageConfig, r101.pageConfig) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.bizId, r101.bizId) == true) goto L42;
        return false;
    L42:
        if (this.isCollapsed == r101.isCollapsed) goto L45;
        return false;
    L45:
        if (this.isSticky == r101.isSticky) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.biz, r101.biz) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.components, r101.components) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f344531id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.type) * 31;
        List<a> r104 = this.actions;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.text;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.subtitle;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        g r113 = this.font;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<i> r116 = this.icons;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        f r119 = this.divider;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        o r122 = this.showConfig;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        j r125 = this.pageConfig;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Long r128 = this.bizId;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        int r131 = 1231;
        if (this.isCollapsed == false) goto L45;
        int r132 = 1231;
    L46:
        int r133 = (r130 + r132) * 31;
        if (this.isSticky == true) goto L50;
        r131 = 1237;
    L50:
        int r134 = (r133 + r131) * 31;
        List<e1> r135 = this.tags;
        if (r135 != null) goto L53;
        int r136 = 0;
    L54:
        int r137 = (r134 + r136) * 31;
        b r138 = this.biz;
        if (r138 != null) goto L57;
        int r139 = 0;
    L58:
        int r140 = (r137 + r139) * 31;
        List<p> r141 = this.components;
        if (r141 == null) goto L63;
        r101 = r141.hashCode();
    L63:
        return r140 + r101;
    L57:
        r139 = r138.hashCode();
        goto L58
    L53:
        r136 = r135.hashCode();
        goto L54
    L45:
        r132 = 1237;
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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

    public final String toString() {
        return "SideBarComponent(id=" + this.f344531id + ", type=" + this.type + ", actions=" + this.actions + ", text=" + this.text + ", subtitle=" + this.subtitle + ", font=" + this.font + ", icons=" + this.icons + ", divider=" + this.divider + ", showConfig=" + this.showConfig + ", pageConfig=" + this.pageConfig + ", bizId=" + this.bizId + ", isCollapsed=" + this.isCollapsed + ", isSticky=" + this.isSticky + ", tags=" + this.tags + ", biz=" + this.biz + ", components=" + this.components + ')';
    }

    public final List<a> b() {
        return this.actions;
    }

    public final b c() {
        return this.biz;
    }

    public final Long d() {
        return this.bizId;
    }

    public final List<p> e() {
        return this.components;
    }

    public final f f() {
        return this.divider;
    }

    public final List<i> g() {
        return this.icons;
    }

    public final int getType() {
        return this.type;
    }

    public final String h() {
        return this.f344531id;
    }

    public final j i() {
        return this.pageConfig;
    }

    public final o j() {
        return this.showConfig;
    }

    public final String k() {
        return this.subtitle;
    }

    public final List<e1> l() {
        return this.tags;
    }

    public final String m() {
        return this.text;
    }

    public final boolean n() {
        return this.isCollapsed;
    }

    public final boolean o() {
        return this.isSticky;
    }

    public static p a(p r210, List r211, b r212, List r213, int r214) {
        List<e1> r100 = null;
        if ((r214 & 1) == 0) goto L5;
        String r101 = r210.f344531id;
    L7:
        if ((r214 & 2) == 0) goto L9;
        int r102 = r210.type;
    L11:
        if ((r214 & 4) == 0) goto L13;
        List<a> r103 = r210.actions;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = r210.text;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = r210.subtitle;
    L23:
        if ((r214 & 32) == 0) goto L25;
        g r110 = r210.font;
    L27:
        if ((r214 & 64) == 0) goto L29;
        List r111 = r210.icons;
    L31:
        if ((r214 & 128) == 0) goto L33;
        f r112 = r210.divider;
    L35:
        if ((r214 & 256) == 0) goto L37;
        o r113 = r210.showConfig;
    L39:
        if ((r214 & 512) == 0) goto L41;
        j r114 = r210.pageConfig;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        Long r115 = r210.bizId;
    L47:
        if ((r214 & 2048) == 0) goto L49;
        boolean r116 = r210.isCollapsed;
    L51:
        if ((r214 & 4096) == 0) goto L53;
        boolean r117 = r210.isSticky;
    L55:
        if ((r214 & 8192) == 0) goto L57;
        r100 = r210.tags;
    L57:
        List<e1> r118 = r100;
        if ((r214 & 16384) == 0) goto L60;
        b r119 = r210.biz;
    L62:
        if ((r214 & 32768) == 0) goto L64;
        List r215 = r210.components;
    L65:
        r210.getClass();
        return new p(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r215);
    L64:
        r215 = r213;
        goto L65
    L60:
        r119 = r212;
        goto L62
    L53:
        r117 = false;
        goto L55
    L49:
        r116 = false;
        goto L51
    L45:
        r115 = null;
        goto L47
    L41:
        r114 = null;
        goto L43
    L37:
        r113 = null;
        goto L39
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = r211;
        goto L31
    L25:
        r110 = null;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = 0;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ p(String r210, int r211, List r212, String r213, List r214, f r215, o r216, j r217, List r218, int r310) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r310 & 2) == 0) goto L9;
        int r101 = ComponentTypeEnum.TOP_SECTION.getType();
    L11:
        if ((r310 & 4) == 0) goto L13;
        List r102 = null;
    L15:
        if ((r310 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r310 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r310 & 64) == 0) goto L25;
        List r110 = null;
    L27:
        if ((r310 & 128) == 0) goto L29;
        f r111 = null;
    L31:
        if ((r310 & 256) == 0) goto L33;
        o r112 = null;
    L35:
        if ((r310 & 512) == 0) goto L37;
        j r113 = null;
    L39:
        if ((r310 & 32768) == 0) goto L41;
        List r114 = null;
    L42:
        this(r100, r101, r102, r103, r104, null, r110, r111, r112, r113, null, false, false, null, null, r114);
        return;
    L41:
        r114 = r218;
        goto L42
    L37:
        r113 = r217;
        goto L39
    L33:
        r112 = r216;
        goto L35
    L29:
        r111 = r215;
        goto L31
    L25:
        r110 = r214;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public p(String r100, int r101, List<a> r102, String r103, String r104, g r105, List<i> r106, f r110, o r111, j r112, Long r113, boolean r114, boolean r115, List<e1> r116, b r117, List<p> r118) {
        this.f344531id = r100;
        this.type = r101;
        this.actions = r102;
        this.text = r103;
        this.subtitle = r104;
        this.font = r105;
        this.icons = r106;
        this.divider = r110;
        this.showConfig = r111;
        this.pageConfig = r112;
        this.bizId = r113;
        this.isCollapsed = r114;
        this.isSticky = r115;
        this.tags = r116;
        this.biz = r117;
        this.components = r118;
    }
}
