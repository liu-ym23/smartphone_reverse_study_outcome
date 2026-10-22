package mx4;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.m;
import com.bytedance.ee.bear.contract.m0;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.l7;
import com.bytedance.ee.bear.document.y7;
import com.bytedance.ee.bear.drive.services.d0;
import com.bytedance.ee.bear.drive.services.w;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jx4.t;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends lx4.a implements m0, d0 {
    public final com.bytedance.ee.bear.route.h b;
    public final m c;
    public final w d;
    public final t e;
    public boolean f;
    public final lx4.h g;
    public final f h;
    public mx4.b i;
    public final CompositeDisposable j;

    /* JADX INFO: renamed from: mx4.a$a, reason: collision with other inner class name */
    public static final class C0258a implements lx4.h.a {
        public final /* synthetic */ a a;

        @Override // lx4.h.a
        public final void dismiss() {
            this.a.s();
        }

        public C0258a(a r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void a() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void b() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void c() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void d() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void e() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void f() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void g() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void h() {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void i(DocException r1, Map r2) {
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void j() {
    }

    @Override // com.bytedance.ee.bear.drive.services.d0
    public final void k() {
        m(null);
    }

    @Override // lx4.g
    public final void l() {
        f r0 = this.h;
        if (r0 == null) goto L6;
        r0.c();
        return;
    }

    public final List<String> p() {
        List<Integer> r0 = this.h.a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(sbb.e.f(((Number) r2.next()).intValue()));
        goto L4
    L6:
        return r1;
    }

    public final void r() {
        tt5.a.h("DocAutoTestImpl2", BatterySceneData.OPT_START);
        l7 r1 = y7.j;
        y7.a.a.h("DocAutoTestImpl2");
        this.f = false;
        this.g.a();
        this.c.e(this);
        this.d.R0(this);
        mx4.b r0 = new mx4.b(this);
        this.i = r0;
        MutableLiveData<f.b> r2 = this.h.b;
        Intrinsics.checkNotNull(r0);
        r2.observeForever(r0);
        this.h.c();
    }

    public final void s() {
        tt5.a.h("DocAutoTestImpl2", "stop");
        l7 r1 = y7.j;
        y7.a.a.i("DocAutoTestImpl2");
        this.f = true;
        this.g.getClass();
        mx4.b r0 = this.i;
        if (r0 == null) goto L5;
        MutableLiveData<f.b> r2 = this.h.b;
        Intrinsics.checkNotNull(r0);
        r2.removeObserver(r0);
    L5:
        this.h.e.clear();
        this.j.clear();
        Preference r3 = this.e.a.findPreference("test_switch");
        if ((r3 instanceof CheckBoxPreference) == false) goto L8;
        CheckBoxPreference r4 = (CheckBoxPreference) r3;
    L9:
        if (r4 == null) goto L12;
        r4.setChecked(false);
        return;
    L12:
        return;
    L8:
        r4 = null;
        goto L9
    }

    @Override // lx4.a
    public final boolean n() {
        return this.f;
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void m(Map<String, String> r7) {
        this.j.clear();
        Disposable r8 = o(true, 4, 3);
        if (r8 == null) goto L6;
        this.j.add(r8);
        return;
    }

    public final void q(List<String> r4) {
        Intrinsics.checkNotNullParameter(r4, "types");
        f r1 = this.h;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "types");
        if (hu5.a.d(r4) == true) goto L8;
        r1.a.clear();
        Iterator r5 = ((ArrayList) r4).iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        String r0 = (String) r5.next();
        r1.a.add(Integer.valueOf(sbb.e.g(r0)));
        goto L6
    L10:
        return;
    }

    public a(Context r2, com.bytedance.ee.bear.route.h r3, m r4, w r5, t r6) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mRouterService");
        Intrinsics.checkNotNullParameter(r4, "mDocWebService");
        Intrinsics.checkNotNullParameter(r5, "mDriveService");
        Intrinsics.checkNotNullParameter(r6, "mGeneralDebugInfo");
        super(r3);
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.h = new f();
        this.j = new CompositeDisposable();
        this.g = new lx4.h(r2, new C0258a(this));
    }
}
