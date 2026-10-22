package gc5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.sort.FilterType;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends uc5.g {
    public final int c;

    @Override // mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("AINoteListCache", "getFilter()...");
        mc5.j r0 = (mc5.j) this.a.a(mc5.j.class);
        int r1 = this.c;
        if (r1 != 20) goto L5;
    L4:
        String r2 = "owned_by_me";
    L9:
        FolderSortStrategy r3 = r0.m1(r2);
        if (r3 != null) goto L19;
        int r4 = this.c;
        if (r4 != 20) goto L14;
    L13:
        String r9 = "owned_by_me";
    L18:
        r3 = new FolderSortStrategy(r9, FilterType.ALL.getType(), "", "", FolderSort.NAME.getRank(), true);
        goto L19
    L14:
        if (r4 != 21) goto L16;
        r9 = "my_involved";
        goto L18
    L16:
        if (r4 != 22) goto L13;
        r9 = "ai_share_with_me";
    L19:
        return r3;
    L5:
        if (r1 != 21) goto L7;
        r2 = "my_involved";
        goto L9
    L7:
        if (r1 != 22) goto L4;
        r2 = "ai_share_with_me";
        goto L9
    }

    @Override // uc5.g
    public final int c() {
        return this.c;
    }

    public c(ce5.a r2, int r3) {
        super("", r2);
        this.c = r3;
    }
}
