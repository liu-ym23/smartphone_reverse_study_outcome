package uf5;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class q0 implements com.bytedance.ee.bear.middleground.feed.export.bean.g {
    public final com.bytedance.ee.bear.rn.g a;

    public class a implements Consumer<String> {
        public a() {
        }

        public final void accept(Object r2) throws Exception {
            String r3 = (String) r2;
            tt5.a.h("RnFeedData", "translate success");
        }
    }

    public class b implements Consumer<Throwable> {
        public b() {
        }

        public final void accept(Object r2) throws Exception {
            tt5.a.j("RnFeedData", (Throwable) r2);
        }
    }

    public q0(final String r3, final sbb.e r4) {
        this.a = (com.bytedance.ee.bear.rn.g) org.koin.java.a.b(com.bytedance.ee.bear.rn.g.class, null, new o0(r3, r4));
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.g
    public void a(String r2, String r3) {
        Flowable<String> r4 = this.a.i(r2, r3);
        if (r4 != null) goto L5;
        r4 = Flowable.error(new Throwable("comment sdk error, please check it"));
    L5:
        r4.subscribe(new a(), new b());
    }
}
