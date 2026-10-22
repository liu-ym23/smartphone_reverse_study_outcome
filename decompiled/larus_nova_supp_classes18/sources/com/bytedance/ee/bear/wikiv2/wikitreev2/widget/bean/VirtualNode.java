package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/VirtualNode;", "", "rootToken", "", "spaceId", "wikiNodeType", "", "level", "title", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;III)V", "getRootToken", "()Ljava/lang/String;", "getSpaceId", "getWikiNodeType", "()I", "getLevel", "getTitle", "TITLE_ROOT_CLOUD_DOCUMENT", "TITLE_ROOT_SPACE", "TITLE_ROOT_SHARE", "TITLE_ROOT_PERSONAL", "TITLE_TOTAL_SHARE", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VirtualNode extends Enum<VirtualNode> {
    public static final a Companion = null;
    public static final VirtualNode TITLE_ROOT_CLOUD_DOCUMENT = null;
    public static final VirtualNode TITLE_ROOT_PERSONAL = null;
    public static final VirtualNode TITLE_ROOT_SHARE = null;
    public static final VirtualNode TITLE_ROOT_SPACE = null;
    public static final VirtualNode TITLE_TOTAL_SHARE = null;
    public static final /* synthetic */ VirtualNode[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int level;
    private final String rootToken;
    private final String spaceId;
    private final int title;
    private final int wikiNodeType;

    public static final class a {
        @JvmStatic
        public static VirtualNode[] b() {
            return new VirtualNode[]{VirtualNode.TITLE_ROOT_CLOUD_DOCUMENT, VirtualNode.TITLE_ROOT_SPACE, VirtualNode.TITLE_ROOT_SHARE, VirtualNode.TITLE_ROOT_PERSONAL, VirtualNode.TITLE_TOTAL_SHARE};
        }

        public a() {
        }

        @JvmStatic
        public static boolean a(String r4) {
            VirtualNode[] r0 = b();
            int r2 = 0;
        L4:
            if (r2 >= 5) goto L12;
            if (Intrinsics.areEqual(r0[r2].getRootToken(), r4) == true) goto L7;
            r2 = r2 + 1;
            goto L4
        L7:
            return true;
        L12:
            return false;
        }
    }

    public static EnumEntries<VirtualNode> getEntries() {
        return b;
    }

    @JvmStatic
    public static final boolean isVirtualNode(String r1) {
        Companion.getClass();
        return a.a(r1);
    }

    static {
        VirtualNode r8 = new VirtualNode("TITLE_ROOT_CLOUD_DOCUMENT", 0, "wikiroot%top_cloud_document_token", "wikiroot%top_cloud_document_spaceId", -5, 0, 2131889647);
        TITLE_ROOT_CLOUD_DOCUMENT = r8;
        VirtualNode r0 = new VirtualNode("TITLE_ROOT_SPACE", 1, "wikiroot%top_wiki_token", "wikiroot%top_wiki_spaceId", -5, 0, 2131889649);
        TITLE_ROOT_SPACE = r0;
        VirtualNode r1 = new VirtualNode("TITLE_ROOT_SHARE", 2, "wikiroot%title_root_share_token", "wikiroot%title_root_share_spaceId", -5, 0, 2131889638);
        TITLE_ROOT_SHARE = r1;
        VirtualNode r2 = new VirtualNode("TITLE_ROOT_PERSONAL", 3, "wikiroot%title_root_personal_token", "wikiroot%title_root_personal_spaceId", -5, 0, 2131888790);
        TITLE_ROOT_PERSONAL = r2;
        VirtualNode r3 = new VirtualNode("TITLE_TOTAL_SHARE", 4, "wikiroot%title_total_share_token", "wikiroot%title_total_share_spaceId", -6, 1, 2131889657);
        TITLE_TOTAL_SHARE = r3;
        VirtualNode[] r4 = {r8, r0, r1, r2, r3};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
        Companion = new a();
    }

    public static VirtualNode[] values() {
        return (VirtualNode[]) a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getRootToken() {
        return this.rootToken;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final int getTitle() {
        return this.title;
    }

    public final int getWikiNodeType() {
        return this.wikiNodeType;
    }

    @JvmStatic
    public static final boolean isVirtualSpaceId(String r4) {
        Companion.getClass();
        VirtualNode[] r0 = a.b();
        int r2 = 0;
    L4:
        if (r2 >= 5) goto L12;
        if (Intrinsics.areEqual(r0[r2].getSpaceId(), r4) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        return true;
    L12:
        return false;
    }

    public static VirtualNode valueOf(String r1) {
        return (VirtualNode) r27.a.a(VirtualNode.class, r1);
    }

    public VirtualNode(String r1, int r2, String r3, String r4, int r5, int r6, int r7) {
        super(r1, r2);
        this.rootToken = r3;
        this.spaceId = r4;
        this.wikiNodeType = r5;
        this.level = r6;
        this.title = r7;
    }
}
