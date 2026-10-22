package com.bytedance.ee.bear.list.share;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.sort.FilterType;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i2 extends e {
    public FolderSortStrategy b;

    @Override // mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("ShareFileListCache", "getFilter()...");
        FolderSortStrategy r0 = ((mc5.j) this.a.a(mc5.j.class)).m1("shared_file");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new FolderSortStrategy("shared_file", FilterType.ALL.getType(), "", "", ShareFileSort.MODIFIED_TIME.getRank(), false);
    }

    public i2(ce5.a r1) {
        super(r1);
    }

    @Override // mc5.k
    public final void a(final ArrayList<Document> r3) {
        tt5.a.h("ShareFileListCache", "clearAndSave()...");
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new f2(this, r3), new g2());
    }
}
