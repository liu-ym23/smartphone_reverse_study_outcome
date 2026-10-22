package uc5;

import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public abstract class g extends mc5.a3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f549500b;

    public int c() {
        return 3;
    }

    @Override // mc5.k
    public final void a(final ArrayList<Document> r100) {
        tt5.a.h("PersonalCache", "clearAndSave()...");
        Flowable.just(this.f549500b).observeOn(fo5.d.b()).subscribe(new c(this, r100), new d());
    }

    @Override // mc5.k
    public final void b(ArrayList<Document> r100) {
        tt5.a.h("PersonalCache", "save()...");
        Flowable.just(r100).observeOn(fo5.d.b()).subscribe(new e(this), new f());
    }

    @Override // mc5.a3, mc5.k
    public void delete(final String r100) {
        tt5.a.h("PersonalCache", "delete()...");
        Flowable.just(r100).observeOn(fo5.d.b()).subscribe(new a(this, r100), new b());
    }

    public g(String r100, ce5.a r101) {
        super(r101);
        this.f549500b = r100;
    }
}
