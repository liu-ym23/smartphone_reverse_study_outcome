package kj5;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.c0;
import com.bytedance.ee.bear.contract.create.DocumentCreateInfo;
import com.bytedance.ee.bear.contract.d0;
import com.bytedance.ee.bear.contract.f0;
import com.bytedance.ee.bear.contract.g0;
import com.bytedance.ee.bear.contract.j0;
import com.bytedance.ee.bear.contract.k;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.offline.OfflineRenameData;
import com.bytedance.ee.bear.contract.q0;
import com.bytedance.ee.bear.list.delete.DeleteExecutor;
import com.bytedance.ee.bear.list.dto.DocVersion;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.ListDocs;
import com.bytedance.ee.bear.list.dto.SpaceMakeCopyToSpaceResult;
import com.bytedance.ee.bear.list.u0;
import com.bytedance.ee.bear.route.h;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements rc5.a {
    public u0 a;

    public static final class a implements u0 {
        public a() {
        }

        @Override // com.bytedance.ee.bear.list.u0
        public final void a() {
        }

        @Override // com.bytedance.ee.bear.list.u0
        public final void b(String r1) {
        }

        @Override // com.bytedance.ee.bear.list.u0
        public final void c(String r1) {
        }
    }

    @Override // rc5.a
    public final void A(Document r1) {
    }

    @Override // rc5.a
    public final boolean B() {
        return false;
    }

    @Override // rc5.a
    public final void D(Context r1) {
    }

    @Override // rc5.a
    public final String E(String r1) {
        return "";
    }

    @Override // rc5.a
    public final void H() {
    }

    @Override // rc5.a
    public final void K(String r1, c0.a r2) {
    }

    @Override // rc5.a
    public final void M(String r1, int r2, boolean r3) {
    }

    @Override // rc5.a
    public final void P(Context r1, String r2, int r3, boolean r4) {
    }

    @Override // rc5.a
    public final void Q(String r1, String r2, int r3) {
    }

    @Override // rc5.a
    public final void T(String r1, String r2) {
    }

    @Override // rc5.a
    public final void U(j0 r1) {
    }

    @Override // rc5.a
    public final void V() {
    }

    @Override // rc5.a
    public final void W(String r1) {
    }

    @Override // rc5.a
    public final void X(f0 r1) {
    }

    @Override // rc5.a
    public final void Y(OfflineRenameData r1) {
    }

    @Override // rc5.a
    public final void a() {
    }

    @Override // rc5.a
    public final void b(Document r1, FragmentActivity r2) {
    }

    @Override // rc5.a
    public final void d(List<String> r1) {
    }

    @Override // rc5.a
    public final String e(Context r1, int r2, String r3) {
        return "";
    }

    @Override // rc5.a
    public final String getDocumentDefaultName(Context r1, int r2) {
        return "";
    }

    @Override // rc5.a
    public final void handleSyncedDoc(OfflineDoc r1) {
    }

    @Override // rc5.a
    public final String i(String r1) {
        return "";
    }

    @Override // rc5.a
    public final void j(String r1) {
    }

    @Override // rc5.a
    public final void k(String r1, int r2) {
    }

    @Override // rc5.a
    public final void n(String r1, int r2, int r3, c0.a r4) {
    }

    @Override // rc5.a
    public final void r(h r1) {
    }

    @Override // rc5.a
    public final String s(String r1) {
        return "";
    }

    @Override // rc5.a
    public final void u(g0 r1) {
    }

    @Override // rc5.a
    public final void v(String r1) {
    }

    @Override // rc5.a
    public final boolean x() {
        return false;
    }

    @Override // rc5.a
    public final boolean z(int r1) {
        return false;
    }

    @Override // rc5.a
    public final DeleteExecutor R() {
        return new DeleteExecutor();
    }

    @Override // rc5.a
    public final Flowable<ListDocs> m() {
        return Flowable.just(new ListDocs());
    }

    @Override // rc5.a
    public final ListDocs o() {
        return new ListDocs();
    }

    public e() {
        this.a = new a();
    }

    @Override // rc5.a
    public final u0 C() {
        return this.a;
    }

    @Override // rc5.a
    public final Flowable<Boolean> G(String r1) {
        return Flowable.just(Boolean.FALSE);
    }

    @Override // rc5.a
    public final Flowable<OfflineDoc> I(String r3) {
        return Flowable.just(new OfflineDoc("", sbb.e.o.b));
    }

    @Override // rc5.a
    public final Flowable<Boolean> L(String r1) {
        return Flowable.just(Boolean.FALSE);
    }

    @Override // rc5.a
    public final Flowable<Boolean> N(long r1) {
        return Flowable.just(Boolean.FALSE);
    }

    @Override // rc5.a
    public final Flowable<Boolean> O(String r1) {
        return Flowable.just(Boolean.FALSE);
    }

    @Override // rc5.a
    public final Flowable<Boolean> S(String r1) {
        return Flowable.just(Boolean.FALSE);
    }

    @Override // rc5.a
    public final Flowable<Integer> c(List<String> r1) {
        return Flowable.just(0);
    }

    @Override // rc5.a
    public final Flowable<SpaceMakeCopyToSpaceResult> h(d0 r1) {
        return Flowable.empty();
    }

    @Override // rc5.a
    public final Flowable<Integer> l(List<String> r1) {
        return Flowable.just(0);
    }

    @Override // rc5.a
    public final void p(u0 r1) {
        if (r1 == null) goto L5;
        this.a = r1;
        return;
    }

    @Override // rc5.a
    public final Disposable q(q0 r1) {
        return Disposables.empty();
    }

    @Override // rc5.a
    public final Flowable<DocumentCreateInfo> t(k r1) {
        return Flowable.empty();
    }

    @Override // rc5.a
    public final Disposable w(q0 r1) {
        return Disposables.empty();
    }

    @Override // rc5.a
    public final Flowable<DocVersion> f(String r3, int r4) {
        return Flowable.just(new DocVersion(0, 1, null));
    }

    @Override // rc5.a
    public final Flowable<DocVersion> g(String r3, int r4) {
        return Flowable.just(new DocVersion(0, 1, null));
    }

    @Override // rc5.a
    public final Flowable J(int r1, String r2, boolean r3) {
        return Flowable.empty();
    }

    @Override // rc5.a
    public final Flowable<Boolean> y(String r1, int r2, boolean r3) {
        return Flowable.just(Boolean.FALSE);
    }
}
