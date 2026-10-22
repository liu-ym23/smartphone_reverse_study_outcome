package com.bytedance.ee.bear.document.at;

import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements kn4.l {

    public class a implements kn4.n {
        public final boolean d() {
            AccountService$Account r0 = ((h0) org.koin.java.a.a(h0.class)).G2();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isConsumer() == true) goto L7;
            return true;
        }

        public a() {
        }
    }

    public class b implements kn4.b {
        public b() {
        }

        public final void a(final AtObject r3) {
            if (r3 == null) goto L6;
            Flowable.just(r3).map(new g(r3)).flatMap(new h()).subscribeOn(fo5.d.e()).observeOn(fo5.d.e()).subscribe(new i(), new j());
            return;
        }
    }

    public l() {
    }

    public final bo4.c a() {
        ((i0) org.koin.java.a.a(i0.class)).a();
        return new bo4.c(new com.bytedance.ee.bear.document.at.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)), new b());
    }

    public final com.bytedance.ee.bear.atfinder.f b() {
        return e.c(m.a);
    }

    public final kn4.n c() {
        return new a();
    }

    public final boolean d() {
        return com.bytedance.ee.bear.appsetting.c.a.a.i("spacekit.mobile.docs_diy_icon", false);
    }

    public final kn4.k e() {
        return new com.bytedance.ee.bear.document.at.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class));
    }

    public final kn4.b f() {
        return new b();
    }
}
