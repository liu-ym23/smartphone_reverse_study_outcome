package com.bytedance.assem.arch.reused;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.ai.model.viewmodel.RenderStateVM;
import com.bytedance.assem.arch.core.Assem;
import com.bytedance.tiktok.proxy.a;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00020\u00012\u00020\u00062\u00020\u0007B\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/assem/arch/reused/ReusedUIAssem;", "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", "Lcom/bytedance/assem/arch/core/Assem;", "Lcom/bytedance/assem/arch/viewModel/e;", "Lcom/bytedance/tiktok/proxy/c;", "Lcom/bytedance/tiktok/proxy/b;", "", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class ReusedUIAssem<RECEIVER extends com.bytedance.tiktok.proxy.a> extends Assem implements com.bytedance.assem.arch.viewModel.e<RECEIVER>, com.bytedance.tiktok.proxy.c<RECEIVER>, com.bytedance.tiktok.proxy.a, com.bytedance.tiktok.proxy.b {
    public static final /* synthetic */ int w = 0;
    public View h;
    public final CopyOnWriteArraySet<h<?, ?>> i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final s q;
    public IResuedAssemProxy r;
    public final Lazy s;
    public final Lazy t;
    public final Lazy u;
    public final CopyOnWriteArrayList<Function0<Unit>> v;

    @Override // com.bytedance.assem.arch.viewModel.e
    public final void F60() {
    }

    public final LifecycleOwner aM() {
        return this;
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final RECEIVER dh() {
        return this;
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final LifecycleOwner fr() {
        return (LifecycleOwner) this.n.getValue();
    }

    public final RECEIVER oq() {
        return this;
    }

    public final LifecycleRegistry s() {
        return (LifecycleRegistry) this.p.getValue();
    }

    public abstract void u();

    public abstract void v();

    public abstract void w(View r1);

    @Override // com.bytedance.assem.arch.viewModel.e
    public final com.bytedance.tiktok.proxy.b NY() {
        com.bytedance.tiktok.proxy.b r0 = this.r;
        if (r0 == null) goto L7;
        return r0;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.tiktok.proxy.LifecycleOwnerHolder");
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final LifecycleOwner Tm() {
        return (LifecycleOwner) this.o.getValue();
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public final void m() {
        this.c.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        onResume();
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final com.bytedance.tiktok.proxy.c<RECEIVER> pF() {
        com.bytedance.tiktok.proxy.c<RECEIVER> r0 = this.r;
        if (r0 == null) goto L7;
        return r0;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.tiktok.proxy.ReceiverHolder<RECEIVER>");
    }

    public final View r() {
        View r0 = this.h;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L5:
        return r0;
    }

    public final void t() {
        CopyOnWriteArraySet<h<?, ?>> r0 = this.i;
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((h) r1.next()).a();
        goto L6
    L10:
        return;
    }

    public ReusedUIAssem() {
        this.i = new CopyOnWriteArraySet();
        this.l = true;
        this.m = true;
        this.n = LazyKt.lazy(new ReusedUIAssem$hostLifecycleOwner$2(this));
        this.o = LazyKt.lazy(new ReusedUIAssem$reusedAssemLifecycleOwner$2(this));
        this.p = LazyKt.lazy(new ReusedUIAssem$reusedAssemLifecycleRegistry$2(this));
        this.q = new s();
        this.s = LazyKt.lazy(ReusedUIAssem$reusedExecutor$2.INSTANCE);
        this.t = LazyKt.lazy(ReusedUIAssem$lock$2.INSTANCE);
        this.u = LazyKt.lazy(ReusedUIAssem$postTime$2.INSTANCE);
        this.v = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public final void onCreate() {
        u();
        s().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.j = true;
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public void onDestroy() {
        s().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.j = false;
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public void onPause() {
        s().handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public void onResume() {
        s().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        IResuedAssemProxy r0 = this.r;
        if (r0 == null) goto L8;
        BehaviorSubject<a> r1 = r0.gl();
        if (r1 == null) goto L9;
        r1.onNext(new a(FireCase.HostResume, this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public void onStart() {
        s().handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public void onStop() {
        s().handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        IResuedAssemProxy r0 = this.r;
        if (r0 == null) goto L8;
        BehaviorSubject<a> r1 = r0.gl();
        if (r1 == null) goto L9;
        r1.onNext(new a(FireCase.HostStop, this));
        return;
    L9:
        return;
    }

    public final void p(View r2) {
        this.k = true;
        w(r2);
        Iterator<Function0<Unit>> r3 = this.v.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r3.next().invoke();
        goto L4
    L6:
        this.v.clear();
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final void vT(RenderStateVM r1, com.bytedance.assem.arch.viewModel.i r2, Function1 r3, Function2 r4) {
        com.bytedance.assem.arch.viewModel.e.a.a(this, r1, r2, r3, r4);
    }
}
