package id5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.manualoffline.ManualOfflineSort;
import com.bytedance.ee.bear.list.sort.FilterType;
import io.reactivex.Flowable;
import java.util.ArrayList;
import mc5.a3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v extends a3 {
    @Override // mc5.k
    public final FolderSortStrategy getFilter() {
        tt5.a.h("ManualOfflineListCache", "getFilter()...");
        FolderSortStrategy r0 = ((mc5.j) this.a.a(mc5.j.class)).m1("manual_offline");
        if (r0 == null) goto L10;
        if (r0.getType() != FilterType.WIKI.getType()) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L10;
        return r0;
    L7:
        r1 = false;
    L10:
        return new FolderSortStrategy("manual_offline", FilterType.ALL.getType(), "", "", ManualOfflineSort.MODIFIED.getRank(), false);
    }

    public v(ce5.a r1) {
        super(r1);
    }

    @Override // mc5.k
    public final void a(final ArrayList<Document> r3) {
        tt5.a.h("ManualOfflineListCache", "clearAndSave ");
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new p(this, r3), new q());
    }

    @Override // mc5.k
    public final void b(ArrayList<Document> r3) {
        tt5.a.h("ManualOfflineListCache", "save()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new t(this), new u());
    }

    @Override // mc5.a3, mc5.k
    public void delete(String r3) {
        tt5.a.h("ManualOfflineListCache", "delete()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new r(this), new s());
    }
}
