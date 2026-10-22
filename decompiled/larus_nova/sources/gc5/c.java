package gc5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.sort.FilterType;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends uc5.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f480825c;

    @Override // mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("AINoteListCache", "getFilter()...");
        mc5.j r100 = (mc5.j) this.f512885a.a(mc5.j.class);
        int r101 = this.f480825c;
        if (r101 != 20) goto L5;
    L4:
        String r102 = "owned_by_me";
    L9:
        FolderSortStrategy r103 = r100.m1(r102);
        if (r103 != null) goto L19;
        int r104 = this.f480825c;
        if (r104 != 20) goto L14;
    L13:
        String r105 = "owned_by_me";
    L18:
        r103 = new FolderSortStrategy(r105, FilterType.ALL.getType(), "", "", FolderSort.NAME.getRank(), true);
        goto L19
    L14:
        if (r104 != 21) goto L16;
        r105 = "my_involved";
        goto L18
    L16:
        if (r104 != 22) goto L13;
        r105 = "ai_share_with_me";
    L19:
        return r103;
    L5:
        if (r101 != 21) goto L7;
        r102 = "my_involved";
        goto L9
    L7:
        if (r101 != 22) goto L4;
        r102 = "ai_share_with_me";
        goto L9
    }

    @Override // uc5.g
    public final int c() {
        return this.f480825c;
    }

    public c(ce5.a r100, int r101) {
        super("", r100);
        this.f480825c = r101;
    }
}
