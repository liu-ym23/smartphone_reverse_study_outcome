package com.bytedance.ee.bear.contract;

import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import io.reactivex.Flowable;
import java.util.List;
import kd5.c2;
import kd5.f2;

/* JADX INFO: loaded from: classes16.dex */
public interface n {

    public interface a {
        void a(OfflineDoc r100);
    }

    public interface b {
        void d(String r100);

        void onPreloadFail(String r100);

        void onPreloadStart(String r100);
    }

    public interface c {
        void a();

        void disconnect();
    }

    public interface d {
        void a(String r100);
    }

    public interface e {
        void a(List<String> r100);

        void b(List<String> r100);
    }

    void a(long r100);

    void b(c2.g r100);

    void c(List r100);

    void d(String r100);

    void e(z45.j0.c r100);

    List<String> f();

    void g(List<OfflineDoc> r100);

    void h(List r100);

    void i(d r100);

    void j(OfflineDoc r100, f2 r101);

    void k(a r100);

    void l(List<OfflineDoc> r100);

    void m(List<String> r100);

    void n(List<OfflineDoc> r100);

    void o();

    void p(com.bytedance.ee.bear.list.list.b.f r100);

    void q(List<OfflineDoc> r100, int r101);

    void r(List<OfflineDoc> r100);

    void s(com.bytedance.ee.bear.list.list.b.C3265b r100);

    Flowable t();

    Flowable<Boolean> u();

    void v(com.bytedance.ee.bear.list.list.b.f r100);

    Flowable<Boolean> w();
}
