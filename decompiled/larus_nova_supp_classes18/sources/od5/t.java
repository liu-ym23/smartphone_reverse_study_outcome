package od5;

import com.bytedance.ee.bear.list.cache.FolderSortStrategy;
import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.Flowable;
import java.util.ArrayList;
import mc5.a3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class t extends a3 {
    @Override // mc5.k
    public FolderSortStrategy getFilter() {
        return null;
    }

    public t(ce5.a r1) {
        super(r1);
    }

    @Override // mc5.k
    public void a(final ArrayList<Document> r3) {
        tt5.a.h("PinedCache", "clearAndSave()...");
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.b()).subscribe(new n(this, r3), new o());
    }

    @Override // mc5.k
    public void b(final ArrayList<Document> r3) {
        tt5.a.h("PinedCache", "save()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new r(this, r3), new s());
    }

    @Override // mc5.a3, mc5.k
    public void delete(final String r3) {
        tt5.a.h("PinedCache", "delete()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new p(this, r3), new q());
    }
}
