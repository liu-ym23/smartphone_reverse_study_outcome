package com.bytedance.ee.bear.contract;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import io.reactivex.Flowable;
import java.util.List;
import kd5.c2;
import kd5.f2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface n {

    public interface a {
        void a(OfflineDoc r1);
    }

    public interface b {
        void d(String r1);

        void onPreloadFail(String r1);

        void onPreloadStart(String r1);
    }

    public interface c {
        void a();

        void disconnect();
    }

    public interface d {
        void a(String r1);
    }

    public interface e {
        void a(List<String> r1);

        void b(List<String> r1);
    }

    void a(long r1);

    void b(c2.g r1);

    void c(List r1);

    void d(String r1);

    void e(z45.j0.c r1);

    List<String> f();

    void g(List<OfflineDoc> r1);

    void h(List r1);

    void i(d r1);

    void j(OfflineDoc r1, f2 r2);

    void k(a r1);

    void l(List<OfflineDoc> r1);

    void m(List<String> r1);

    void n(List<OfflineDoc> r1);

    void o();

    void p(com.bytedance.ee.bear.list.list.b.f r1);

    void q(List<OfflineDoc> r1, int r2);

    void r(List<OfflineDoc> r1);

    void s(com.bytedance.ee.bear.list.list.b.b r1);

    Flowable t();

    Flowable<Boolean> u();

    void v(com.bytedance.ee.bear.list.list.b.f r1);

    Flowable<Boolean> w();
}
