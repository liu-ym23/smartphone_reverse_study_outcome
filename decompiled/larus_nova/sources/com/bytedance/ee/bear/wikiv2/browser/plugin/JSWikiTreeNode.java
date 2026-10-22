package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\bK\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B±\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u000bHÆ\u0003J\t\u0010M\u001a\u00020\u0007HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0010HÆ\u0003J\t\u0010Q\u001a\u00020\u0010HÆ\u0003J\t\u0010R\u001a\u00020\u0010HÆ\u0003J\t\u0010S\u001a\u00020\u0010HÆ\u0003J\t\u0010T\u001a\u00020\u0010HÆ\u0003J\t\u0010U\u001a\u00020\u0010HÆ\u0003J\t\u0010V\u001a\u00020\u0007HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÙ\u0001\u0010Y\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010Z\u001a\u00020\u00102\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\u0007HÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u00105\"\u0004\b6\u00107R\u001a\u0010\u0011\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00105\"\u0004\b9\u00107R\u001a\u0010\u0012\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00105\"\u0004\b;\u00107R\u001a\u0010\u0013\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u00105\"\u0004\b<\u00107R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u00105\"\u0004\b=\u00107R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00105\"\u0004\b?\u00107R\u001a\u0010\u0016\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010$\"\u0004\bA\u0010&R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001c\"\u0004\bC\u0010\u001eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001c\"\u0004\bE\u0010\u001e¨\u0006_"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/JSWikiTreeNode;", "Lcom/bytedance/ee/util/io/NonProguard;", "spaceId", "", WikiFolderPushPlugin.WIKI_TOKEN, "objToken", "objType", "", "title", "parentWikiToken", "sortId", "", "wikiNodeType", "originWikiToken", "originSpaceId", "isStar", "", "hasChild", "secretKeyDelete", "isExplorerStar", "isExplorerPin", "originIsExternal", "entityDeleteFlag", "detailInfo", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;DILjava/lang/String;Ljava/lang/String;ZZZZZZILjava/lang/String;Ljava/lang/String;)V", "getSpaceId", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", "getWikiToken", "setWikiToken", "getObjToken", "setObjToken", "getObjType", "()I", "setObjType", "(I)V", "getTitle", com.alipay.sdk.m.x.d.f25925o, "getParentWikiToken", "setParentWikiToken", "getSortId", "()D", "setSortId", "(D)V", "getWikiNodeType", "setWikiNodeType", "getOriginWikiToken", "setOriginWikiToken", "getOriginSpaceId", "setOriginSpaceId", "()Z", "setStar", "(Z)V", "getHasChild", "setHasChild", "getSecretKeyDelete", "setSecretKeyDelete", "setExplorerStar", "setExplorerPin", "getOriginIsExternal", "setOriginIsExternal", "getEntityDeleteFlag", "setEntityDeleteFlag", "getDetailInfo", "setDetailInfo", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "", "hashCode", "toString", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSWikiTreeNode implements NonProguard {
    private String detailInfo;
    private int entityDeleteFlag;
    private boolean hasChild;
    private boolean isExplorerPin;
    private boolean isExplorerStar;
    private boolean isStar;
    private String objToken;
    private int objType;
    private boolean originIsExternal;
    private String originSpaceId;
    private String originWikiToken;
    private String parentWikiToken;
    private boolean secretKeyDelete;
    private double sortId;
    private String spaceId;
    private String title;
    private String url;
    private int wikiNodeType;
    private String wikiToken;

    public static /* synthetic */ JSWikiTreeNode copy$default(JSWikiTreeNode r110, String r111, String r112, String r210, int r211, String r212, String r213, double r214, int r215, String r216, String r217, boolean r218, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, int r315, String r316, String r317, int r318, Object r319) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = r110.spaceId;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = r110.wikiToken;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = r110.objToken;
    L15:
        if ((r318 & 8) == 0) goto L17;
        int r103 = r110.objType;
    L19:
        if ((r318 & 16) == 0) goto L21;
        String r104 = r110.title;
    L23:
        if ((r318 & 32) == 0) goto L25;
        String r105 = r110.parentWikiToken;
    L27:
        if ((r318 & 64) == 0) goto L29;
        double r106 = r110.sortId;
    L31:
        if ((r318 & 128) == 0) goto L33;
        int r113 = r110.wikiNodeType;
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r114 = r110.originWikiToken;
    L39:
        if ((r318 & 512) == 0) goto L41;
        String r115 = r110.originSpaceId;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        boolean r116 = r110.isStar;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        boolean r117 = r110.hasChild;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        boolean r118 = r110.secretKeyDelete;
    L54:
        boolean r320 = r118;
        if ((r318 & 8192) == 0) goto L57;
        boolean r119 = r110.isExplorerStar;
    L58:
        boolean r321 = r119;
        if ((r318 & 16384) == 0) goto L61;
        boolean r120 = r110.isExplorerPin;
    L62:
        boolean r322 = r120;
        if ((r318 & 32768) == 0) goto L65;
        boolean r121 = r110.originIsExternal;
    L66:
        boolean r323 = r121;
        if ((r318 & 65536) == 0) goto L69;
        int r122 = r110.entityDeleteFlag;
    L70:
        int r324 = r122;
        if ((r318 & 131072) == 0) goto L73;
        String r123 = r110.detailInfo;
    L75:
        if ((r318 & 262144) == 0) goto L77;
        String r107 = r110.url;
    L79:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r123, r107);
    L77:
        r107 = r317;
        goto L79
    L73:
        r123 = r316;
        goto L75
    L69:
        r122 = r315;
        goto L70
    L65:
        r121 = r314;
        goto L66
    L61:
        r120 = r313;
        goto L62
    L57:
        r119 = r312;
        goto L58
    L53:
        r118 = r311;
        goto L54
    L49:
        r117 = r310;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.spaceId;
    }

    public final String component10() {
        return this.originSpaceId;
    }

    public final boolean component11() {
        return this.isStar;
    }

    public final boolean component12() {
        return this.hasChild;
    }

    public final boolean component13() {
        return this.secretKeyDelete;
    }

    public final boolean component14() {
        return this.isExplorerStar;
    }

    public final boolean component15() {
        return this.isExplorerPin;
    }

    public final boolean component16() {
        return this.originIsExternal;
    }

    public final int component17() {
        return this.entityDeleteFlag;
    }

    public final String component18() {
        return this.detailInfo;
    }

    public final String component19() {
        return this.url;
    }

    public final String component2() {
        return this.wikiToken;
    }

    public final String component3() {
        return this.objToken;
    }

    public final int component4() {
        return this.objType;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.parentWikiToken;
    }

    public final double component7() {
        return this.sortId;
    }

    public final int component8() {
        return this.wikiNodeType;
    }

    public final String component9() {
        return this.originWikiToken;
    }

    public final JSWikiTreeNode copy(String r210, String r211, String r212, int r213, String r214, String r215, double r216, int r310, String r311, String r312, boolean r313, boolean r314, boolean r315, boolean r316, boolean r317, boolean r318, int r410, String r411, String r412) {
        return new JSWikiTreeNode(r210, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, r314, r315, r316, r317, r318, r410, r411, r412);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof JSWikiTreeNode) == true) goto L8;
        return false;
    L8:
        JSWikiTreeNode r101 = (JSWikiTreeNode) r100;
        if (Intrinsics.areEqual(this.spaceId, r101.spaceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.wikiToken, r101.wikiToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.objToken, r101.objToken) == true) goto L18;
        return false;
    L18:
        if (this.objType == r101.objType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.parentWikiToken, r101.parentWikiToken) == true) goto L27;
        return false;
    L27:
        if (Double.compare(this.sortId, r101.sortId) == 0) goto L30;
        return false;
    L30:
        if (this.wikiNodeType == r101.wikiNodeType) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.originWikiToken, r101.originWikiToken) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.originSpaceId, r101.originSpaceId) == true) goto L39;
        return false;
    L39:
        if (this.isStar == r101.isStar) goto L42;
        return false;
    L42:
        if (this.hasChild == r101.hasChild) goto L45;
        return false;
    L45:
        if (this.secretKeyDelete == r101.secretKeyDelete) goto L48;
        return false;
    L48:
        if (this.isExplorerStar == r101.isExplorerStar) goto L51;
        return false;
    L51:
        if (this.isExplorerPin == r101.isExplorerPin) goto L54;
        return false;
    L54:
        if (this.originIsExternal == r101.originIsExternal) goto L57;
        return false;
    L57:
        if (this.entityDeleteFlag == r101.entityDeleteFlag) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.detailInfo, r101.detailInfo) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        String r100 = this.spaceId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.wikiToken;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.objToken;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.objType) * 31;
        String r110 = this.title;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.parentWikiToken;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        long r116 = Double.doubleToLongBits(this.sortId);
        int r117 = (((r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31) + this.wikiNodeType) * 31;
        String r118 = this.originWikiToken;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        String r121 = this.originSpaceId;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        int r124 = 1231;
        if (this.isStar == false) goto L33;
        int r125 = 1231;
    L34:
        int r126 = (r123 + r125) * 31;
        if (this.hasChild == false) goto L37;
        int r127 = 1231;
    L38:
        int r128 = (r126 + r127) * 31;
        if (this.secretKeyDelete == false) goto L41;
        int r129 = 1231;
    L42:
        int r130 = (r128 + r129) * 31;
        if (this.isExplorerStar == false) goto L45;
        int r131 = 1231;
    L46:
        int r132 = (r130 + r131) * 31;
        if (this.isExplorerPin == false) goto L49;
        int r133 = 1231;
    L50:
        int r134 = (r132 + r133) * 31;
        if (this.originIsExternal == true) goto L54;
        r124 = 1237;
    L54:
        int r135 = (((r134 + r124) * 31) + this.entityDeleteFlag) * 31;
        String r136 = this.detailInfo;
        if (r136 != null) goto L57;
        int r137 = 0;
    L58:
        int r138 = (r135 + r137) * 31;
        String r139 = this.url;
        if (r139 == null) goto L63;
        r101 = r139.hashCode();
    L63:
        return r138 + r101;
    L57:
        r137 = r136.hashCode();
        goto L58
    L49:
        r133 = 1237;
        goto L50
    L45:
        r131 = 1237;
        goto L46
    L41:
        r129 = 1237;
        goto L42
    L37:
        r127 = 1237;
        goto L38
    L33:
        r125 = 1237;
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
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

    public String toString() {
        return "JSWikiTreeNode(spaceId=" + this.spaceId + ", wikiToken=" + this.wikiToken + ", objToken=" + this.objToken + ", objType=" + this.objType + ", title=" + this.title + ", parentWikiToken=" + this.parentWikiToken + ", sortId=" + this.sortId + ", wikiNodeType=" + this.wikiNodeType + ", originWikiToken=" + this.originWikiToken + ", originSpaceId=" + this.originSpaceId + ", isStar=" + this.isStar + ", hasChild=" + this.hasChild + ", secretKeyDelete=" + this.secretKeyDelete + ", isExplorerStar=" + this.isExplorerStar + ", isExplorerPin=" + this.isExplorerPin + ", originIsExternal=" + this.originIsExternal + ", entityDeleteFlag=" + this.entityDeleteFlag + ", detailInfo=" + this.detailInfo + ", url=" + this.url + ')';
    }

    public final String getDetailInfo() {
        return this.detailInfo;
    }

    public final int getEntityDeleteFlag() {
        return this.entityDeleteFlag;
    }

    public final boolean getHasChild() {
        return this.hasChild;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final int getObjType() {
        return this.objType;
    }

    public final boolean getOriginIsExternal() {
        return this.originIsExternal;
    }

    public final String getOriginSpaceId() {
        return this.originSpaceId;
    }

    public final String getOriginWikiToken() {
        return this.originWikiToken;
    }

    public final String getParentWikiToken() {
        return this.parentWikiToken;
    }

    public final boolean getSecretKeyDelete() {
        return this.secretKeyDelete;
    }

    public final double getSortId() {
        return this.sortId;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWikiNodeType() {
        return this.wikiNodeType;
    }

    public final String getWikiToken() {
        return this.wikiToken;
    }

    public final boolean isExplorerPin() {
        return this.isExplorerPin;
    }

    public final boolean isExplorerStar() {
        return this.isExplorerStar;
    }

    public final boolean isStar() {
        return this.isStar;
    }

    public final void setDetailInfo(String r100) {
        this.detailInfo = r100;
    }

    public final void setEntityDeleteFlag(int r100) {
        this.entityDeleteFlag = r100;
    }

    public final void setExplorerPin(boolean r100) {
        this.isExplorerPin = r100;
    }

    public final void setExplorerStar(boolean r100) {
        this.isExplorerStar = r100;
    }

    public final void setHasChild(boolean r100) {
        this.hasChild = r100;
    }

    public final void setObjToken(String r100) {
        this.objToken = r100;
    }

    public final void setObjType(int r100) {
        this.objType = r100;
    }

    public final void setOriginIsExternal(boolean r100) {
        this.originIsExternal = r100;
    }

    public final void setOriginSpaceId(String r100) {
        this.originSpaceId = r100;
    }

    public final void setOriginWikiToken(String r100) {
        this.originWikiToken = r100;
    }

    public final void setParentWikiToken(String r100) {
        this.parentWikiToken = r100;
    }

    public final void setSecretKeyDelete(boolean r100) {
        this.secretKeyDelete = r100;
    }

    public final void setSortId(double r100) {
        this.sortId = r100;
    }

    public final void setSpaceId(String r100) {
        this.spaceId = r100;
    }

    public final void setStar(boolean r100) {
        this.isStar = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setWikiNodeType(int r100) {
        this.wikiNodeType = r100;
    }

    public final void setWikiToken(String r100) {
        this.wikiToken = r100;
    }

    public JSWikiTreeNode(String r100, String r101, String r102, int r103, String r104, String r105, double r110, int r111, String r112, String r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r210, int r211, String r212, String r213) {
        this.spaceId = r100;
        this.wikiToken = r101;
        this.objToken = r102;
        this.objType = r103;
        this.title = r104;
        this.parentWikiToken = r105;
        this.sortId = r110;
        this.wikiNodeType = r111;
        this.originWikiToken = r112;
        this.originSpaceId = r113;
        this.isStar = r114;
        this.hasChild = r115;
        this.secretKeyDelete = r116;
        this.isExplorerStar = r117;
        this.isExplorerPin = r118;
        this.originIsExternal = r210;
        this.entityDeleteFlag = r211;
        this.detailInfo = r212;
        this.url = r213;
    }
}
