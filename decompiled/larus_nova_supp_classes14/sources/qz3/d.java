package qz3;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.e;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.f0;
import com.bytedance.awemeopen.apps.framework.feed.pinch.utils.g;
import com.bytedance.awemeopen.apps.framework.feed.pinch.utils.h;
import com.bytedance.awemeopen.apps.framework.feed.pinch.utils.k;
import com.bytedance.awemeopen.apps.framework.feed.pinch.utils.l;
import com.bytedance.awemeopen.apps.framework.framework.livedata.DiscardFirstValueLiveData;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements b {
    public final MutableLiveData<Triple<Integer, Boolean, Float>> a;
    public final MutableLiveData<Boolean> b;
    public final MutableLiveData<Pair<Integer, Boolean>> c;
    public final DiscardFirstValueLiveData<r14.c> d;
    public final MutableLiveData<Boolean> e;
    public final MutableLiveData<Pair<Boolean, String>> f;
    public final DiscardFirstValueLiveData<Pair<String, Boolean>> g;
    public final MutableLiveData<Boolean> h;
    public final MutableLiveData<View> i;
    public final MutableLiveData<Boolean> j;
    public final MutableLiveData<sz3.a> k;
    public final MutableLiveData<Pair<Integer, Integer>> l;

    @Override // qz3.b
    public final void D(l r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
    }

    @Override // qz3.b
    public final void a(g r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
    }

    @Override // qz3.b
    public final void t() {
    }

    @Override // qz3.b
    public final boolean A() {
        Pair r0 = (Pair) this.f.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return ((Boolean) r0.getFirst()).booleanValue();
    }

    @Override // qz3.b
    public final boolean B() {
        return Intrinsics.areEqual(this.h.getValue(), Boolean.TRUE);
    }

    @Override // qz3.b
    public final void c() {
        this.i.postValue(null);
    }

    @Override // qz3.b
    public final void f() {
        this.b.setValue(Boolean.TRUE);
    }

    @Override // qz3.b
    public final boolean j() {
        Boolean r0 = (Boolean) this.e.getValue();
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.booleanValue();
    }

    @Override // qz3.b
    public final void m() {
        this.j.setValue(Boolean.TRUE);
    }

    @Override // qz3.b
    public final void n() {
        this.k.setValue(new sz3.a(null, ""));
    }

    public d() {
        this.a = new MutableLiveData();
        this.b = new MutableLiveData();
        new MutableLiveData();
        this.c = new MutableLiveData();
        this.d = new DiscardFirstValueLiveData();
        this.e = new MutableLiveData();
        this.f = new MutableLiveData();
        this.g = new DiscardFirstValueLiveData();
        this.h = new MutableLiveData();
        this.i = new MutableLiveData();
        this.j = new MutableLiveData();
        this.k = new MutableLiveData();
        this.l = new MutableLiveData();
    }

    @Override // qz3.b
    public final void e(Pair<Boolean, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "isScaleFixed");
        this.f.setValue(r2);
    }

    @Override // qz3.b
    public final void h(Observer<Triple<Integer, Boolean, Float>> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.a.removeObserver(r2);
    }

    @Override // qz3.b
    public final void k(Pair<Integer, Integer> r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.l.setValue(r2);
    }

    @Override // qz3.b
    public final void l(r14.c r2) {
        this.d.setValue(r2);
    }

    @Override // qz3.b
    public final void o(boolean r2) {
        this.h.setValue(Boolean.valueOf(r2));
    }

    @Override // qz3.b
    public final void q(Observer<Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "observe");
        this.h.removeObserver(r2);
    }

    @Override // qz3.b
    public final void r(e r2) {
        Intrinsics.checkNotNullParameter(r2, "observe");
        this.f.removeObserver(r2);
    }

    @Override // qz3.b
    public final void v(boolean r2) {
        this.e.setValue(Boolean.valueOf(r2));
    }

    @Override // qz3.b
    public final void w(h r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.f.observeForever(r2);
    }

    @Override // qz3.b
    public final void y(f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        this.d.removeObserver(r2);
    }

    @Override // qz3.b
    public final void z(sz3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.k.setValue(r2);
    }

    @Override // qz3.b
    public final void C(LifecycleOwner r2, Observer<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r2 != null) goto L5;
        return;
    L5:
        this.h.observe(r2, r3);
    }

    @Override // qz3.b
    public final void b(LifecycleOwner r2, k r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r2 != null) goto L5;
        return;
    L5:
        this.e.observe(r2, r3);
    }

    @Override // qz3.b
    public final void d(Integer r2, boolean r3) {
        this.c.setValue(TuplesKt.to(r2, Boolean.valueOf(r3)));
    }

    @Override // qz3.b
    public final void g(LifecycleOwner r2, com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.l r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r2 != null) goto L5;
        return;
    L5:
        this.l.observe(r2, r3);
    }

    @Override // qz3.b
    public final void i(LifecycleOwner r2, Observer<Triple<Integer, Boolean, Float>> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r2 != null) goto L5;
        return;
    L5:
        this.a.observe(r2, r3);
    }

    @Override // qz3.b
    public final void p(LifecycleOwner r2, f0 r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r2 != null) goto L5;
        return;
    L5:
        this.d.observe(r2, r3);
    }

    @Override // qz3.b
    public final void s(LifecycleOwner r2, com.bytedance.awemeopen.apps.framework.feed.pinch.ui.g r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r2 != null) goto L5;
        return;
    L5:
        this.k.observe(r2, r3);
    }

    @Override // qz3.b
    public final void u(LifecycleOwner r2, Observer<Pair<Boolean, String>> r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        if (r2 != null) goto L5;
        return;
    L5:
        this.f.observe(r2, r3);
    }

    @Override // qz3.b
    public final void x(Integer r3, boolean r4, float r5) {
        this.a.setValue(new Triple(r3, Boolean.valueOf(r4), Float.valueOf(r5)));
    }
}
