package com.bytedance.ee.bear.list.share;

import com.bytedance.ee.bear.list.dto.Document;
import io.reactivex.Flowable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class e extends mc5.a3 {
    public e(ce5.a r1) {
        super(r1);
    }

    @Override // mc5.k
    public final void b(ArrayList<Document> r3) {
        tt5.a.h("ShareToMeListCache", "save()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new c(this), new d());
    }

    @Override // mc5.a3, mc5.k
    public void delete(final String r3) {
        tt5.a.h("ShareToMeListCache", "delete()...");
        Flowable.just(r3).observeOn(fo5.d.b()).subscribe(new a(this, r3), new b());
    }
}
