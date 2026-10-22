package uc5;

import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class g extends mc5.a3 {
    public final String b;

    public int c() {
        return 3;
    }

    @Override // mc5.k
    public final void a(final ArrayList<Document> r3) {
        tt5.a.h("PersonalCache", "clearAndSave()...");
        Flowable.just(this.b).observeOn(fo5.d.b()).subscribe(new c(this, r3), new d());
    }

    @Override // mc5.k
    public final void b(ArrayList<Document> r3) {
        tt5.a.h("PersonalCache", "save()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new e(this), new f());
    }

    @Override // mc5.a3, mc5.k
    public void delete(final String r3) {
        tt5.a.h("PersonalCache", "delete()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new a(this, r3), new b());
    }

    public g(String r1, ce5.a r2) {
        super(r2);
        this.b = r1;
    }
}
