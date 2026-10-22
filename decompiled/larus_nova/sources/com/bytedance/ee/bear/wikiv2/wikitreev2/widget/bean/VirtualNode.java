package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/VirtualNode;", "", "rootToken", "", "spaceId", "wikiNodeType", "", "level", "title", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;III)V", "getRootToken", "()Ljava/lang/String;", "getSpaceId", "getWikiNodeType", "()I", "getLevel", "getTitle", "TITLE_ROOT_CLOUD_DOCUMENT", "TITLE_ROOT_SPACE", "TITLE_ROOT_SHARE", "TITLE_ROOT_PERSONAL", "TITLE_TOTAL_SHARE", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VirtualNode extends Enum<VirtualNode> {
    public static final a Companion = null;
    public static final VirtualNode TITLE_ROOT_CLOUD_DOCUMENT = null;
    public static final VirtualNode TITLE_ROOT_PERSONAL = null;
    public static final VirtualNode TITLE_ROOT_SHARE = null;
    public static final VirtualNode TITLE_ROOT_SPACE = null;
    public static final VirtualNode TITLE_TOTAL_SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VirtualNode[] f241727a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f241728b = null;
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
        public static boolean a(String r100) {
            VirtualNode[] r101 = b();
            int r102 = 0;
        L4:
            if (r102 >= 5) goto L12;
            if (Intrinsics.areEqual(r101[r102].getRootToken(), r100) == true) goto L7;
            r102 = r102 + 1;
            goto L4
        L7:
            return true;
        L12:
            return false;
        }
    }

    public static EnumEntries<VirtualNode> getEntries() {
        return f241728b;
    }

    @JvmStatic
    public static final boolean isVirtualNode(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    static {
        VirtualNode r100 = new VirtualNode("TITLE_ROOT_CLOUD_DOCUMENT", 0, "wikiroot%top_cloud_document_token", "wikiroot%top_cloud_document_spaceId", -5, 0, R.string.LarkCCM_NewCM_Sidebar_Section_PinnedDocs_Button);
        TITLE_ROOT_CLOUD_DOCUMENT = r100;
        VirtualNode r101 = new VirtualNode("TITLE_ROOT_SPACE", 1, "wikiroot%top_wiki_token", "wikiroot%top_wiki_spaceId", -5, 0, R.string.LarkCCM_NewCM_Sidebar_Section_PinnedWiki_Button);
        TITLE_ROOT_SPACE = r101;
        VirtualNode r102 = new VirtualNode("TITLE_ROOT_SHARE", 2, "wikiroot%title_root_share_token", "wikiroot%title_root_share_spaceId", -5, 0, R.string.LarkCCM_NewCM_Shared_Title);
        TITLE_ROOT_SHARE = r102;
        VirtualNode r103 = new VirtualNode("TITLE_ROOT_PERSONAL", 3, "wikiroot%title_root_personal_token", "wikiroot%title_root_personal_spaceId", -5, 0, R.string.LarkCCM_CM_MyLib_Menu);
        TITLE_ROOT_PERSONAL = r103;
        VirtualNode r104 = new VirtualNode("TITLE_TOTAL_SHARE", 4, "wikiroot%title_total_share_token", "wikiroot%title_total_share_spaceId", -6, 1, R.string.LarkCCM_NewCM_ViewAllSharedDocs_Menu);
        TITLE_TOTAL_SHARE = r104;
        VirtualNode[] r105 = {r100, r101, r102, r103, r104};
        f241727a = r105;
        f241728b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static VirtualNode[] values() {
        return (VirtualNode[]) f241727a.clone();
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
    public static final boolean isVirtualSpaceId(String r100) {
        Companion.getClass();
        VirtualNode[] r101 = a.b();
        int r102 = 0;
    L4:
        if (r102 >= 5) goto L12;
        if (Intrinsics.areEqual(r101[r102].getSpaceId(), r100) == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return true;
    L12:
        return false;
    }

    public static VirtualNode valueOf(String r100) {
        return (VirtualNode) r27.a.a(VirtualNode.class, r100);
    }

    public VirtualNode(String r100, int r101, String r102, String r103, int r104, int r105, int r106) {
        super(r100, r101);
        this.rootToken = r102;
        this.spaceId = r103;
        this.wikiNodeType = r104;
        this.level = r105;
        this.title = r106;
    }
}
