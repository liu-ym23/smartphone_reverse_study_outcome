package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\bK\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B±\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u000bHÆ\u0003J\t\u0010M\u001a\u00020\u0007HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0010HÆ\u0003J\t\u0010Q\u001a\u00020\u0010HÆ\u0003J\t\u0010R\u001a\u00020\u0010HÆ\u0003J\t\u0010S\u001a\u00020\u0010HÆ\u0003J\t\u0010T\u001a\u00020\u0010HÆ\u0003J\t\u0010U\u001a\u00020\u0010HÆ\u0003J\t\u0010V\u001a\u00020\u0007HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÙ\u0001\u0010Y\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010Z\u001a\u00020\u00102\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\u0007HÖ\u0001J\t\u0010^\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001c\"\u0004\b2\u0010\u001eR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u00105\"\u0004\b6\u00107R\u001a\u0010\u0011\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00105\"\u0004\b9\u00107R\u001a\u0010\u0012\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00105\"\u0004\b;\u00107R\u001a\u0010\u0013\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u00105\"\u0004\b<\u00107R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u00105\"\u0004\b=\u00107R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00105\"\u0004\b?\u00107R\u001a\u0010\u0016\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010$\"\u0004\bA\u0010&R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u001c\"\u0004\bC\u0010\u001eR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001c\"\u0004\bE\u0010\u001e¨\u0006_"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/JSWikiTreeNode;", "Lcom/bytedance/ee/util/io/NonProguard;", "spaceId", "", WikiFolderPushPlugin.WIKI_TOKEN, "objToken", "objType", "", "title", "parentWikiToken", "sortId", "", "wikiNodeType", "originWikiToken", "originSpaceId", "isStar", "", "hasChild", "secretKeyDelete", "isExplorerStar", "isExplorerPin", "originIsExternal", "entityDeleteFlag", "detailInfo", ResourceData.KEY_URL, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;DILjava/lang/String;Ljava/lang/String;ZZZZZZILjava/lang/String;Ljava/lang/String;)V", "getSpaceId", "()Ljava/lang/String;", "setSpaceId", "(Ljava/lang/String;)V", "getWikiToken", "setWikiToken", "getObjToken", "setObjToken", "getObjType", "()I", "setObjType", "(I)V", "getTitle", "setTitle", "getParentWikiToken", "setParentWikiToken", "getSortId", "()D", "setSortId", "(D)V", "getWikiNodeType", "setWikiNodeType", "getOriginWikiToken", "setOriginWikiToken", "getOriginSpaceId", "setOriginSpaceId", "()Z", "setStar", "(Z)V", "getHasChild", "setHasChild", "getSecretKeyDelete", "setSecretKeyDelete", "setExplorerStar", "setExplorerPin", "getOriginIsExternal", "setOriginIsExternal", "getEntityDeleteFlag", "setEntityDeleteFlag", "getDetailInfo", "setDetailInfo", "getUrl", "setUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "equals", "other", "", "hashCode", "toString", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public static /* synthetic */ JSWikiTreeNode copy$default(JSWikiTreeNode r17, String r18, String r19, String r20, int r21, String r22, String r23, double r24, int r26, String r27, String r28, boolean r29, boolean r30, boolean r31, boolean r32, boolean r33, boolean r34, int r35, String r36, String r37, int r38, Object r39) {
        if ((r38 & 1) == 0) goto L5;
        String r2 = r17.spaceId;
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r3 = r17.wikiToken;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r4 = r17.objToken;
    L15:
        if ((r38 & 8) == 0) goto L17;
        int r5 = r17.objType;
    L19:
        if ((r38 & 16) == 0) goto L21;
        String r6 = r17.title;
    L23:
        if ((r38 & 32) == 0) goto L25;
        String r7 = r17.parentWikiToken;
    L27:
        if ((r38 & 64) == 0) goto L29;
        double r8 = r17.sortId;
    L31:
        if ((r38 & 128) == 0) goto L33;
        int r10 = r17.wikiNodeType;
    L35:
        if ((r38 & 256) == 0) goto L37;
        String r11 = r17.originWikiToken;
    L39:
        if ((r38 & 512) == 0) goto L41;
        String r12 = r17.originSpaceId;
    L43:
        if ((r38 & DocUserPermission.USER_PERM_FULL_ACCESS) == 0) goto L45;
        boolean r13 = r17.isStar;
    L47:
        if ((r38 & DocUserPermission.USER_PREVIEW) == 0) goto L49;
        boolean r14 = r17.hasChild;
    L51:
        if ((r38 & DocUserPermission.USER_PERCEIVE) == 0) goto L53;
        boolean r15 = r17.secretKeyDelete;
    L54:
        boolean r310 = r15;
        if ((r38 & 8192) == 0) goto L57;
        boolean r16 = r17.isExplorerStar;
    L58:
        boolean r311 = r16;
        if ((r38 & 16384) == 0) goto L61;
        boolean r110 = r17.isExplorerPin;
    L62:
        boolean r312 = r110;
        if ((r38 & 32768) == 0) goto L65;
        boolean r111 = r17.originIsExternal;
    L66:
        boolean r313 = r111;
        if ((r38 & 65536) == 0) goto L69;
        int r112 = r17.entityDeleteFlag;
    L70:
        int r314 = r112;
        if ((r38 & 131072) == 0) goto L73;
        String r113 = r17.detailInfo;
    L75:
        if ((r38 & 262144) == 0) goto L77;
        String r1 = r17.url;
    L79:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r113, r1);
    L77:
        r1 = r37;
        goto L79
    L73:
        r113 = r36;
        goto L75
    L69:
        r112 = r35;
        goto L70
    L65:
        r111 = r34;
        goto L66
    L61:
        r110 = r33;
        goto L62
    L57:
        r16 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L54
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r29;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
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

    public final JSWikiTreeNode copy(String r23, String r24, String r25, int r26, String r27, String r28, double r29, int r31, String r32, String r33, boolean r34, boolean r35, boolean r36, boolean r37, boolean r38, boolean r39, int r40, String r41, String r42) {
        return new JSWikiTreeNode(r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof JSWikiTreeNode) == true) goto L8;
        return false;
    L8:
        JSWikiTreeNode r9 = (JSWikiTreeNode) r8;
        if (Intrinsics.areEqual(this.spaceId, r9.spaceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.wikiToken, r9.wikiToken) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.objToken, r9.objToken) == true) goto L18;
        return false;
    L18:
        if (this.objType == r9.objType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.title, r9.title) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.parentWikiToken, r9.parentWikiToken) == true) goto L27;
        return false;
    L27:
        if (Double.compare(this.sortId, r9.sortId) == 0) goto L30;
        return false;
    L30:
        if (this.wikiNodeType == r9.wikiNodeType) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.originWikiToken, r9.originWikiToken) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.originSpaceId, r9.originSpaceId) == true) goto L39;
        return false;
    L39:
        if (this.isStar == r9.isStar) goto L42;
        return false;
    L42:
        if (this.hasChild == r9.hasChild) goto L45;
        return false;
    L45:
        if (this.secretKeyDelete == r9.secretKeyDelete) goto L48;
        return false;
    L48:
        if (this.isExplorerStar == r9.isExplorerStar) goto L51;
        return false;
    L51:
        if (this.isExplorerPin == r9.isExplorerPin) goto L54;
        return false;
    L54:
        if (this.originIsExternal == r9.originIsExternal) goto L57;
        return false;
    L57:
        if (this.entityDeleteFlag == r9.entityDeleteFlag) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.detailInfo, r9.detailInfo) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.url, r9.url) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public int hashCode() {
        String r0 = this.spaceId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.wikiToken;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.objToken;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + this.objType) * 31;
        String r10 = this.title;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.parentWikiToken;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        long r16 = Double.doubleToLongBits(this.sortId);
        int r17 = (((r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31) + this.wikiNodeType) * 31;
        String r18 = this.originWikiToken;
        if (r18 != null) goto L25;
        int r19 = 0;
    L26:
        int r20 = (r17 + r19) * 31;
        String r21 = this.originSpaceId;
        if (r21 != null) goto L29;
        int r22 = 0;
    L30:
        int r23 = (r20 + r22) * 31;
        int r24 = 1231;
        if (this.isStar == false) goto L33;
        int r25 = 1231;
    L34:
        int r26 = (r23 + r25) * 31;
        if (this.hasChild == false) goto L37;
        int r27 = 1231;
    L38:
        int r28 = (r26 + r27) * 31;
        if (this.secretKeyDelete == false) goto L41;
        int r29 = 1231;
    L42:
        int r30 = (r28 + r29) * 31;
        if (this.isExplorerStar == false) goto L45;
        int r31 = 1231;
    L46:
        int r32 = (r30 + r31) * 31;
        if (this.isExplorerPin == false) goto L49;
        int r33 = 1231;
    L50:
        int r34 = (r32 + r33) * 31;
        if (this.originIsExternal == true) goto L54;
        r24 = 1237;
    L54:
        int r35 = (((r34 + r24) * 31) + this.entityDeleteFlag) * 31;
        String r36 = this.detailInfo;
        if (r36 != null) goto L57;
        int r37 = 0;
    L58:
        int r38 = (r35 + r37) * 31;
        String r39 = this.url;
        if (r39 == null) goto L63;
        r1 = r39.hashCode();
    L63:
        return r38 + r1;
    L57:
        r37 = r36.hashCode();
        goto L58
    L49:
        r33 = 1237;
        goto L50
    L45:
        r31 = 1237;
        goto L46
    L41:
        r29 = 1237;
        goto L42
    L37:
        r27 = 1237;
        goto L38
    L33:
        r25 = 1237;
        goto L34
    L29:
        r22 = r21.hashCode();
        goto L30
    L25:
        r19 = r18.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
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

    public final void setDetailInfo(String r1) {
        this.detailInfo = r1;
    }

    public final void setEntityDeleteFlag(int r1) {
        this.entityDeleteFlag = r1;
    }

    public final void setExplorerPin(boolean r1) {
        this.isExplorerPin = r1;
    }

    public final void setExplorerStar(boolean r1) {
        this.isExplorerStar = r1;
    }

    public final void setHasChild(boolean r1) {
        this.hasChild = r1;
    }

    public final void setObjToken(String r1) {
        this.objToken = r1;
    }

    public final void setObjType(int r1) {
        this.objType = r1;
    }

    public final void setOriginIsExternal(boolean r1) {
        this.originIsExternal = r1;
    }

    public final void setOriginSpaceId(String r1) {
        this.originSpaceId = r1;
    }

    public final void setOriginWikiToken(String r1) {
        this.originWikiToken = r1;
    }

    public final void setParentWikiToken(String r1) {
        this.parentWikiToken = r1;
    }

    public final void setSecretKeyDelete(boolean r1) {
        this.secretKeyDelete = r1;
    }

    public final void setSortId(double r1) {
        this.sortId = r1;
    }

    public final void setSpaceId(String r1) {
        this.spaceId = r1;
    }

    public final void setStar(boolean r1) {
        this.isStar = r1;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setUrl(String r1) {
        this.url = r1;
    }

    public final void setWikiNodeType(int r1) {
        this.wikiNodeType = r1;
    }

    public final void setWikiToken(String r1) {
        this.wikiToken = r1;
    }

    public JSWikiTreeNode(String r4, String r5, String r6, int r7, String r8, String r9, double r10, int r12, String r13, String r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, int r21, String r22, String r23) {
        this.spaceId = r4;
        this.wikiToken = r5;
        this.objToken = r6;
        this.objType = r7;
        this.title = r8;
        this.parentWikiToken = r9;
        this.sortId = r10;
        this.wikiNodeType = r12;
        this.originWikiToken = r13;
        this.originSpaceId = r14;
        this.isStar = r15;
        this.hasChild = r16;
        this.secretKeyDelete = r17;
        this.isExplorerStar = r18;
        this.isExplorerPin = r19;
        this.originIsExternal = r20;
        this.entityDeleteFlag = r21;
        this.detailInfo = r22;
        this.url = r23;
    }
}
