package com.bytedance.ee.bear.contract;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.offline.OfflineRenameData;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.tts.impl.model.TtsMetaModel;
import com.bytedance.ee.bear.tts.meta.TtsMetaBean;
import io.reactivex.Flowable;
import java.util.List;
import kd5.b2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface c0 {

    public interface a {
        void a();

        void b(boolean r1);

        void c();

        void d(int r1, Throwable r2, String r3, int r4);
    }

    public interface b {
        void a(boolean r1);

        void b(Document r1, long r2, b2 r4);
    }

    public interface c {
    }

    public interface d {
        void a(String r1);

        void b(String r1, String r2);

        void c();

        void d();

        void e(String r1, boolean r2);

        void f(String r1, boolean r2);

        void g();

        void h();
    }

    public interface e {
        void onFail();

        void onSuccess();
    }

    public interface f {
        void a(TtsMetaBean r1);

        void onError(Throwable r1);
    }

    String F(String r1);

    void G(String r1);

    void H();

    Flowable<OfflineDoc> I(String r1);

    Flowable J(int r1, String r2, boolean r3);

    void K(String r1, a r2);

    Flowable<Boolean> L(String r1);

    void M(String r1, int r2, boolean r3);

    Flowable<Boolean> N(long r1);

    void O(String r1);

    void P(Context r1, String r2, int r3, boolean r4);

    void Q(String r1, String r2, int r3);

    Flowable<Boolean> S(String r1);

    void T(String r1, String r2);

    void U(j0 r1);

    void V();

    void W(String r1);

    void X(f0 r1);

    void Y(OfflineRenameData r1);

    void Z();

    void a0(FragmentManager r1, String r2, String r3, int r4);

    void b0(String r1, int r2, TtsMetaModel.reload.2.a r3);

    int c(List<String> r1);

    List<Document> c0();

    int d(List<String> r1);

    void d0(d r1);

    void e0();

    void f0(String r1, String r2);

    long g0(so5.a r1);

    void h0(String r1);

    void handleSyncedDoc(OfflineDoc r1);

    String i(String r1);

    int i0(String r1);

    void j(String r1);

    Flowable<DocumentCreateInfo> j0(int r1, String r2, String r3, boolean r4);

    void k(String r1, int r2);

    List k0();

    int l(List<String> r1);

    void l0(String r1, int r2, boolean r3, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.l.a r4);

    List<String> m();

    void m0(int r1);

    void n(String r1, int r2, int r3, a r4);

    void n0(Document r1, boolean r2, String r3);

    List<String> o();

    void o0(String r1, boolean r2);

    so5.a p0(String r1);

    void q0(d r1);
}
