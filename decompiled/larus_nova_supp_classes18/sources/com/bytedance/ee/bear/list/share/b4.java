package com.bytedance.ee.bear.list.share;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.sort.FilterType;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b4 extends mc5.a3 {
    public FolderSortStrategy b;

    @Override // mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("SharedListCache", "getFilter()...");
        FolderSortStrategy r0 = ((mc5.j) this.a.a(mc5.j.class)).m1("shared");
        if (r0 != null) goto L6;
        r0 = new FolderSortStrategy("shared", FilterType.ALL.getType(), "", "", ShareFileSort.SHARE_TIME.getRank(), false);
    L6:
        if (this.a.d.isCurrentEnable("ccm.space.disable_share_edittime_sort") == true) goto L8;
        return r0;
    L8:
        if (ShareFileSort.MODIFIED_TIME.getRank() == r0.e) goto L10;
        return r0;
    L10:
        return new FolderSortStrategy("shared", FilterType.ALL.getType(), "", "", ShareFileSort.SHARE_TIME.getRank(), false);
    }

    public b4(ce5.a r1) {
        super(r1);
    }

    @Override // mc5.k
    public final void a(final ArrayList<Document> r3) {
        tt5.a.h("SharedListCache", "clearAndSave()...");
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new u3(this, r3), new v3());
    }

    @Override // mc5.k
    public final void b(final ArrayList<Document> r3) {
        tt5.a.h("SharedListCache", "save()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new y3(this, r3), new z3());
    }

    @Override // mc5.a3, mc5.k
    public void delete(final String r3) {
        tt5.a.h("SharedListCache", "delete()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new w3(this, r3), new x3());
    }
}
