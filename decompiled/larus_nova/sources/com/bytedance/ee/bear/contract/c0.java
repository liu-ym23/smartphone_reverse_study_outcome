package com.bytedance.ee.bear.contract;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.offline.OfflineRenameData;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.tts.impl.model.TtsMetaModel$reload$2;
import com.bytedance.ee.bear.tts.meta.TtsMetaBean;
import io.reactivex.Flowable;
import java.util.List;
import kd5.b2;

/* JADX INFO: loaded from: classes16.dex */
public interface c0 {

    public interface a {
        void a();

        void b(boolean r100);

        void c();

        void d(int r100, Throwable r101, String r102, int r103);
    }

    public interface b {
        void a(boolean r100);

        void b(Document r100, long r101, b2 r102);
    }

    public interface c {
    }

    public interface d {
        void a(String r100);

        void b(String r100, String r101);

        void c();

        void d();

        void e(String r100, boolean r101);

        void f(String r100, boolean r101);

        void g();

        void h();
    }

    public interface e {
        void onFail();

        void onSuccess();
    }

    public interface f {
        void a(TtsMetaBean r100);

        void onError(Throwable r100);
    }

    String F(String r100);

    void G(String r100);

    void H();

    Flowable<OfflineDoc> I(String r100);

    Flowable J(int r100, String r101, boolean r102);

    void K(String r100, a r101);

    Flowable<Boolean> L(String r100);

    void M(String r100, int r101, boolean r102);

    Flowable<Boolean> N(long r100);

    void O(String r100);

    void P(Context r100, String r101, int r102, boolean r103);

    void Q(String r100, String r101, int r102);

    Flowable<Boolean> S(String r100);

    void T(String r100, String r101);

    void U(j0 r100);

    void V();

    void W(String r100);

    void X(f0 r100);

    void Y(OfflineRenameData r100);

    void Z();

    void a0(FragmentManager r100, String r101, String r102, int r103);

    void b0(String r100, int r101, TtsMetaModel$reload$2.a r102);

    int c(List<String> r100);

    List<Document> c0();

    int d(List<String> r100);

    void d0(d r100);

    void e0();

    void f0(String r100, String r101);

    long g0(so5.a r100);

    void h0(String r100);

    void handleSyncedDoc(OfflineDoc r100);

    String i(String r100);

    int i0(String r100);

    void j(String r100);

    Flowable<DocumentCreateInfo> j0(int r100, String r101, String r102, boolean r103);

    void k(String r100, int r101);

    List k0();

    int l(List<String> r100);

    void l0(String r100, int r101, boolean r102, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.l.a r103);

    List<String> m();

    void m0(int r100);

    void n(String r100, int r101, int r102, a r103);

    void n0(Document r100, boolean r101, String r102);

    List<String> o();

    void o0(String r100, boolean r101);

    so5.a p0(String r100);

    void q0(d r100);
}
