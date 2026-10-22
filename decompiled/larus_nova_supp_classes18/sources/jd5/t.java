package jd5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.mine.MineSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import io.reactivex.Flowable;
import java.util.ArrayList;
import mc5.a3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class t extends a3 {
    public FolderSortStrategy b;

    @Override // mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("MineListCache", "getFilter()...");
        FolderSortStrategy r0 = ((mc5.j) this.a.a(mc5.j.class)).m1("mine");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new FolderSortStrategy("mine", FilterType.ALL.getType(), "", "", MineSort.MODIFIED_TIME.getRank(), false);
    }

    public t(ce5.a r1) {
        super(r1);
    }

    @Override // mc5.k
    public final void a(final ArrayList<Document> r3) {
        tt5.a.h("MineListCache", "clearAndSave()...");
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new l(this, r3), new m());
    }

    @Override // mc5.k
    public final void b(final ArrayList<Document> r3) {
        tt5.a.h("MineListCache", "save()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new p(this, r3), new q());
    }

    @Override // mc5.a3, mc5.k
    public void delete(final String r3) {
        tt5.a.h("MineListCache", "delete()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new n(this, r3), new o());
    }
}
