package hq9;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareChannel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/larus/platform/model/LarkDriveMenuConfig;", "", "listContext", "Lcom/larus/platform/model/LarkDriveMenuSceneConfig;", "listContextMore", "homeMore", "homeSort", "<init>", "(Lcom/larus/platform/model/LarkDriveMenuSceneConfig;Lcom/larus/platform/model/LarkDriveMenuSceneConfig;Lcom/larus/platform/model/LarkDriveMenuSceneConfig;Lcom/larus/platform/model/LarkDriveMenuSceneConfig;)V", "getListContext", "()Lcom/larus/platform/model/LarkDriveMenuSceneConfig;", "getListContextMore", "getHomeMore", "getHomeSort", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e2 {

    @SerializedName("home_more")
    private final h2 homeMore;

    @SerializedName("home_sort")
    private final h2 homeSort;

    @SerializedName("list_context")
    private final h2 listContext;

    @SerializedName("list_context_more")
    private final h2 listContextMore;

    public e2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e2) == true) goto L8;
        return false;
    L8:
        e2 r101 = (e2) r100;
        if (Intrinsics.areEqual(this.listContext, r101.listContext) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.listContextMore, r101.listContextMore) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.homeMore, r101.homeMore) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.homeSort, r101.homeSort) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        h2 r100 = this.listContext;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        h2 r104 = this.listContextMore;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        h2 r107 = this.homeMore;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        h2 r110 = this.homeSort;
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

    public final String toString() {
        return "LarkDriveMenuConfig(listContext=" + this.listContext + ", listContextMore=" + this.listContextMore + ", homeMore=" + this.homeMore + ", homeSort=" + this.homeSort + ')';
    }

    public e2(int r410) {
        h2 r100 = new h2(CollectionsKt.listOf(new f2[]{new f2("ai", 100, 2), new f2("common", 200, 2), new f2("moreEntry", 300, 2)}), CollectionsKt.listOf(new g2[]{new g2(ShareChannel.ASK_DOUBAO, "ai", 100, null, 18), new g2("share", "common", 100, null, 18), new g2("download", "common", 200, null, 18), new g2("multi_select", "common", 300, null, 18), new g2("favorite", "common", 400, null, 18), new g2("copy_link", "common", 500, null, 18), new g2("more", "moreEntry", 100, "list_context_more", 2)}));
        h2 r101 = new h2(CollectionsKt.listOf(new f2("manage", 100, 2)), CollectionsKt.listOf(new g2[]{new g2("rename", "manage", 50, null, 18), new g2("move_to", "manage", 100, null, 18), new g2("add_shortcut", "manage", 200, null, 18), new g2("secret_setting", "manage", 300, null, 18), new g2("delete", "manage", 400, null, 18)}));
        h2 r110 = new h2(CollectionsKt.listOf(new f2[]{new f2("create", 100, 2), new f2("upload", 200, 2), new f2("viewMode", 300, 2), new f2("sortEntry", 400, 2)}), CollectionsKt.listOf(new g2[]{new g2("create_doc", "create", 100, null, 18), new g2("create_ppt", "create", 200, null, 18), new g2("create_sheet", "create", 300, null, 18), new g2("create_folder", "create", 400, null, 18), new g2("upload_image", "upload", 100, null, 18), new g2("upload_file", "upload", 200, null, 18), new g2("list_view", "viewMode", 100, null, 18), new g2("grid_view", "viewMode", 200, null, 18), new g2("sort", "sortEntry", 100, "home_sort", 2)}));
        h2 r102 = new h2(CollectionsKt.listOf(new f2("sortField", 100, 2)), CollectionsKt.listOf(new g2[]{new g2("sort_by_edit_time", "sortField", 100, null, 18), new g2("sort_by_create_time", "sortField", 200, null, 18), new g2("sort_by_share_time", "sortField", 300, null, 18), new g2("sort_by_visit_time", "sortField", 400, null, 18)}));
        this.listContext = r100;
        this.listContextMore = r101;
        this.homeMore = r110;
        this.homeSort = r102;
    }
}
