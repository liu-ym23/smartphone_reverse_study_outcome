package rc5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.offline.OfflineRenameData;
import com.bytedance.ee.bear.list.delete.DeleteExecutor;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.ListDocs;
import com.bytedance.ee.bear.list.dto.SpaceMakeCopyToSpaceResult;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public interface a {
    void A(Document r100);

    boolean B();

    com.bytedance.ee.bear.list.u0 C();

    void D(Context r100);

    String E(String r100);

    Flowable<Boolean> G(String r100);

    void H();

    Flowable<OfflineDoc> I(String r100);

    Flowable J(int r100, String r101, boolean r102);

    void K(String r100, com.bytedance.ee.bear.contract.c0.a r101);

    Flowable<Boolean> L(String r100);

    void M(String r100, int r101, boolean r102);

    Flowable<Boolean> N(long r100);

    Flowable<Boolean> O(String r100);

    void P(Context r100, String r101, int r102, boolean r103);

    void Q(String r100, String r101, int r102);

    DeleteExecutor R();

    Flowable<Boolean> S(String r100);

    void T(String r100, String r101);

    void U(com.bytedance.ee.bear.contract.j0 r100);

    void V();

    void W(String r100);

    void X(com.bytedance.ee.bear.contract.f0 r100);

    void Y(OfflineRenameData r100);

    void a();

    void b(Document r100, FragmentActivity r101);

    Flowable<Integer> c(List<String> r100);

    void d(List<String> r100);

    String e(Context r100, int r101, String r102);

    Flowable<DocVersion> f(String r100, int r101);

    Flowable<DocVersion> g(String r100, int r101);

    String getDocumentDefaultName(Context r100, int r101);

    Flowable<SpaceMakeCopyToSpaceResult> h(com.bytedance.ee.bear.contract.d0 r100);

    void handleSyncedDoc(OfflineDoc r100);

    String i(String r100);

    void j(String r100);

    void k(String r100, int r101);

    Flowable<Integer> l(List<String> r100);

    Flowable<ListDocs> m();

    void n(String r100, int r101, int r102, com.bytedance.ee.bear.contract.c0.a r103);

    ListDocs o();

    void p(com.bytedance.ee.bear.list.u0 r100);

    Disposable q(com.bytedance.ee.bear.contract.q0 r100);

    void r(com.bytedance.ee.bear.route.h r100);

    String s(String r100);

    Flowable<DocumentCreateInfo> t(com.bytedance.ee.bear.contract.k r100);

    void u(com.bytedance.ee.bear.contract.g0 r100);

    void v(String r100);

    Disposable w(com.bytedance.ee.bear.contract.q0 r100);

    boolean x();

    Flowable<Boolean> y(String r100, int r101, boolean r102);

    boolean z(int r100);
}
