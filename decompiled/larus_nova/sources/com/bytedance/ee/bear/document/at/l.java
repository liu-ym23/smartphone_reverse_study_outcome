package com.bytedance.ee.bear.document.at;

import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import io.reactivex.Flowable;

/* JADX INFO: loaded from: classes16.dex */
public final class l implements kn4.l {

    public class a implements kn4.n {
        @Override // kn4.n
        public final boolean d() {
            AccountService$Account r100 = ((h0) org.koin.java.a.a(h0.class)).G2();
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.isConsumer() == true) goto L7;
            return true;
        }

        public a() {
        }
    }

    public class b implements kn4.b {
        public b() {
        }

        @Override // kn4.b
        public final void a(final AtObject r100) {
            if (r100 == null) goto L6;
            Flowable.just(r100).map(new g(r100)).flatMap(new h()).subscribeOn(fo5.d.e()).observeOn(fo5.d.e()).subscribe(new i(), new j());
            return;
        }
    }

    public l() {
    }

    @Override // kn4.l
    public final bo4.c a() {
        ((i0) org.koin.java.a.a(i0.class)).a();
        return new bo4.c(new com.bytedance.ee.bear.document.at.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)), new b());
    }

    @Override // kn4.l
    public final com.bytedance.ee.bear.atfinder.f b() {
        return e.c(m.f219111a);
    }

    @Override // kn4.l
    public final kn4.n c() {
        return new a();
    }

    @Override // kn4.l
    public final boolean d() {
        return com.bytedance.ee.bear.appsetting.c.a.f206237a.i("spacekit.mobile.docs_diy_icon", false);
    }

    @Override // kn4.l
    public final kn4.k e() {
        return new com.bytedance.ee.bear.document.at.a((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class));
    }

    @Override // kn4.l
    public final kn4.b f() {
        return new b();
    }
}
