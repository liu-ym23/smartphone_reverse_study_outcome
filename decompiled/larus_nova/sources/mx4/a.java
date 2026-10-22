package mx4;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.m;
import com.bytedance.ee.bear.contract.m0;
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

/* JADX INFO: loaded from: classes16.dex */
public final class a extends lx4.a implements m0, d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.route.h f516206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f516207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w f516208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f516209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f516210f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final lx4.h f516211g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f516212h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public mx4.b f516213i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f516214j;

    /* JADX INFO: renamed from: mx4.a$a, reason: collision with other inner class name */
    public static final class C6869a implements lx4.h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f516215a;

        @Override // lx4.h.a
        public final void dismiss() {
            this.f516215a.s();
        }

        public C6869a(a r100) {
            this.f516215a = r100;
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
    public final void i(DocException r100, Map r101) {
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
        f r100 = this.f516212h;
        if (r100 == null) goto L6;
        r100.c();
        return;
    }

    public final List<String> p() {
        List<Integer> r100 = this.f516212h.f516220a;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(sbb.e.f(((Number) r102.next()).intValue()));
        goto L4
    L6:
        return r101;
    }

    public final void r() {
        tt5.a.h("DocAutoTestImpl2", "start");
        l7 r100 = y7.f222541j;
        y7.a.f222551a.h("DocAutoTestImpl2");
        this.f516210f = false;
        this.f516211g.a();
        this.f516207c.e(this);
        this.f516208d.R0(this);
        mx4.b r101 = new mx4.b(this);
        this.f516213i = r101;
        MutableLiveData<f.b> r102 = this.f516212h.f516221b;
        Intrinsics.checkNotNull(r101);
        r102.observeForever(r101);
        this.f516212h.c();
    }

    public final void s() {
        tt5.a.h("DocAutoTestImpl2", "stop");
        l7 r100 = y7.f222541j;
        y7.a.f222551a.i("DocAutoTestImpl2");
        this.f516210f = true;
        this.f516211g.getClass();
        mx4.b r101 = this.f516213i;
        if (r101 == null) goto L5;
        MutableLiveData<f.b> r102 = this.f516212h.f516221b;
        Intrinsics.checkNotNull(r101);
        r102.removeObserver(r101);
    L5:
        this.f516212h.f516224e.clear();
        this.f516214j.clear();
        Preference r103 = this.f516209e.f500814a.findPreference("test_switch");
        if ((r103 instanceof CheckBoxPreference) == false) goto L8;
        CheckBoxPreference r104 = (CheckBoxPreference) r103;
    L9:
        if (r104 == null) goto L12;
        r104.setChecked(false);
        return;
    L12:
        return;
    L8:
        r104 = null;
        goto L9
    }

    @Override // lx4.a
    public final boolean n() {
        return this.f516210f;
    }

    @Override // com.bytedance.ee.bear.contract.m0
    public final void m(Map<String, String> r100) {
        this.f516214j.clear();
        Disposable r101 = o(true, 4, 3);
        if (r101 == null) goto L6;
        this.f516214j.add(r101);
        return;
    }

    public final void q(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "types");
        f r101 = this.f516212h;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "types");
        if (hu5.a.d(r100) == true) goto L8;
        r101.f516220a.clear();
        Iterator r102 = ((ArrayList) r100).iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        String r103 = (String) r102.next();
        r101.f516220a.add(Integer.valueOf(sbb.e.g(r103)));
        goto L6
    L10:
        return;
    }

    public a(Context r100, com.bytedance.ee.bear.route.h r101, m r102, w r103, t r104) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mRouterService");
        Intrinsics.checkNotNullParameter(r102, "mDocWebService");
        Intrinsics.checkNotNullParameter(r103, "mDriveService");
        Intrinsics.checkNotNullParameter(r104, "mGeneralDebugInfo");
        super(r101);
        this.f516206b = r101;
        this.f516207c = r102;
        this.f516208d = r103;
        this.f516209e = r104;
        this.f516212h = new f();
        this.f516214j = new CompositeDisposable();
        this.f516211g = new lx4.h(r100, new C6869a(this));
    }
}
