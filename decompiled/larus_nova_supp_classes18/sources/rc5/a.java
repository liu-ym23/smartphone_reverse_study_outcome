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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {
    void A(Document r1);

    boolean B();

    com.bytedance.ee.bear.list.u0 C();

    void D(Context r1);

    String E(String r1);

    Flowable<Boolean> G(String r1);

    void H();

    Flowable<OfflineDoc> I(String r1);

    Flowable J(int r1, String r2, boolean r3);

    void K(String r1, com.bytedance.ee.bear.contract.c0.a r2);

    Flowable<Boolean> L(String r1);

    void M(String r1, int r2, boolean r3);

    Flowable<Boolean> N(long r1);

    Flowable<Boolean> O(String r1);

    void P(Context r1, String r2, int r3, boolean r4);

    void Q(String r1, String r2, int r3);

    DeleteExecutor R();

    Flowable<Boolean> S(String r1);

    void T(String r1, String r2);

    void U(com.bytedance.ee.bear.contract.j0 r1);

    void V();

    void W(String r1);

    void X(com.bytedance.ee.bear.contract.f0 r1);

    void Y(OfflineRenameData r1);

    void a();

    void b(Document r1, FragmentActivity r2);

    Flowable<Integer> c(List<String> r1);

    void d(List<String> r1);

    String e(Context r1, int r2, String r3);

    Flowable<DocVersion> f(String r1, int r2);

    Flowable<DocVersion> g(String r1, int r2);

    String getDocumentDefaultName(Context r1, int r2);

    Flowable<SpaceMakeCopyToSpaceResult> h(com.bytedance.ee.bear.contract.d0 r1);

    void handleSyncedDoc(OfflineDoc r1);

    String i(String r1);

    void j(String r1);

    void k(String r1, int r2);

    Flowable<Integer> l(List<String> r1);

    Flowable<ListDocs> m();

    void n(String r1, int r2, int r3, com.bytedance.ee.bear.contract.c0.a r4);

    ListDocs o();

    void p(com.bytedance.ee.bear.list.u0 r1);

    Disposable q(com.bytedance.ee.bear.contract.q0 r1);

    void r(com.bytedance.ee.bear.route.h r1);

    String s(String r1);

    Flowable<DocumentCreateInfo> t(com.bytedance.ee.bear.contract.k r1);

    void u(com.bytedance.ee.bear.contract.g0 r1);

    void v(String r1);

    Disposable w(com.bytedance.ee.bear.contract.q0 r1);

    boolean x();

    Flowable<Boolean> y(String r1, int r2, boolean r3);

    boolean z(int r1);
}
