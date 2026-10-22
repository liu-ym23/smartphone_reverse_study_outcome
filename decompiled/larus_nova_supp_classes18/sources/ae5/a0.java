package ae5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.sort.FilterType;
import io.reactivex.Flowable;
import java.util.ArrayList;
import mc5.a3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0 extends a3 {
    public FolderSortStrategy b;
    public final int c;
    public final String d;

    @Override // mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("StarListCache", "getFilter()...");
        FolderSortStrategy r0 = ((mc5.j) this.a.a(mc5.j.class)).m1(this.d);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L10;
        return r0;
    L10:
        return new FolderSortStrategy("star", FilterType.ALL.getType(), "", "", 0, false);
    L5:
        if (r0.getType() != FilterType.WIKI.getType()) goto L7;
        r1 = true;
        goto L8
    }

    public a0(ce5.a r1) {
        super(r1);
        this.c = 6;
        this.d = "star";
    }

    @Override // mc5.k
    public final void a(final ArrayList<Document> r3) {
        tt5.a.h("StarListCache", "clearAndSave");
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new v(this, r3), new w());
    }

    @Override // mc5.k
    public final void b(final ArrayList<Document> r3) {
        tt5.a.h("StarListCache", "save()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new x(this, r3), new y());
    }

    @Override // mc5.a3, mc5.k
    public void delete(String r3) {
        tt5.a.h("StarListCache", "delete()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new t(this), new u());
    }

    public a0(FolderSortStrategy r1, ce5.a r2) {
        super(r2);
        this.c = 15;
        this.d = "bitable_home_favorites";
        this.b = r1;
    }
}
