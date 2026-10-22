package com.bytedance.ee.bear.list.share;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.folder.FolderSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y0 extends mc5.a3 {
    public final boolean b;

    @Override // mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("NewShareFolderListCache", "getFilter()...");
        mc5.j r0 = (mc5.j) this.a.a(mc5.j.class);
        if (this.b == false) goto L5;
        String r1 = "hidden_shared_folder";
    L6:
        FolderSortStrategy r2 = r0.m1(r1);
        if (r2 == null) goto L9;
        return r2;
    L9:
        if (this.b == false) goto L11;
        FolderSort r3 = FolderSort.NAME;
    L13:
        if (this.b == false) goto L15;
        String r5 = "hidden_shared_folder";
    L17:
        return new FolderSortStrategy(r5, FilterType.ALL.getType(), "", "", r3.getRank(), r3.getAsc());
    L15:
        r5 = "shared_folder_v2";
        goto L17
    L11:
        r3 = FolderSort.SHARED_TIME;
        goto L13
    L5:
        r1 = "shared_folder_v2";
        goto L6
    }

    @Override // mc5.k
    public final void a(final ArrayList<Document> r3) {
        tt5.a.h("NewShareFolderListCache", "clearAndSave()...");
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new s0(this, r3), new t0());
    }

    @Override // mc5.k
    public final void b(ArrayList<Document> r3) {
        tt5.a.h("NewShareFolderListCache", "save()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new w0(this), new x0());
    }

    @Override // mc5.a3, mc5.k
    public void delete(final String r3) {
        tt5.a.h("NewShareFolderListCache", "delete()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new u0(this, r3), new v0());
    }

    public y0(boolean r1, ce5.a r2) {
        super(r2);
        this.b = r1;
    }
}
