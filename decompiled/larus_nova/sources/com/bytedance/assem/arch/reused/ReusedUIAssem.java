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

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00020\u00012\u00020\u00062\u00020\u0007B\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/assem/arch/reused/ReusedUIAssem;", "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", "Lcom/bytedance/assem/arch/core/Assem;", "Lcom/bytedance/assem/arch/viewModel/e;", "Lcom/bytedance/tiktok/proxy/c;", "Lcom/bytedance/tiktok/proxy/b;", "", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class ReusedUIAssem<RECEIVER extends com.bytedance.tiktok.proxy.a> extends Assem implements com.bytedance.assem.arch.viewModel.e<RECEIVER>, com.bytedance.tiktok.proxy.c<RECEIVER>, com.bytedance.tiktok.proxy.a, com.bytedance.tiktok.proxy.b {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f192983w = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f192984h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArraySet<h<?, ?>> f192985i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f192986j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f192987k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f192988l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f192989m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f192990n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f192991o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f192992p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final s f192993q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public IResuedAssemProxy f192994r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f192995s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f192996t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f192997u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function0<Unit>> f192998v;

    @Override // com.bytedance.assem.arch.viewModel.e
    public final void F60() {
    }

    @Override // com.bytedance.tiktok.proxy.b
    public final LifecycleOwner aM() {
        return this;
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final RECEIVER dh() {
        return this;
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final LifecycleOwner fr() {
        return (LifecycleOwner) this.f192990n.getValue();
    }

    @Override // com.bytedance.tiktok.proxy.c
    public final RECEIVER oq() {
        return this;
    }

    public final LifecycleRegistry s() {
        return (LifecycleRegistry) this.f192992p.getValue();
    }

    public abstract void u();

    public abstract void v();

    public abstract void w(View r100);

    @Override // com.bytedance.assem.arch.viewModel.e
    public final com.bytedance.tiktok.proxy.b NY() {
        IResuedAssemProxy r100 = this.f192994r;
        if (r100 == null) goto L7;
        return (com.bytedance.tiktok.proxy.b) r100;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.tiktok.proxy.LifecycleOwnerHolder");
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final LifecycleOwner Tm() {
        return (LifecycleOwner) this.f192991o.getValue();
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public final void m() {
        this.f192854c.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        onResume();
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final com.bytedance.tiktok.proxy.c<RECEIVER> pF() {
        IResuedAssemProxy r100 = this.f192994r;
        if (r100 == null) goto L7;
        return (com.bytedance.tiktok.proxy.c) r100;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.tiktok.proxy.ReceiverHolder<RECEIVER>");
    }

    public final View r() {
        View r100 = this.f192984h;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("containerView");
    L5:
        return r100;
    }

    public final void t() {
        CopyOnWriteArraySet<h<?, ?>> r100 = this.f192985i;
        if (r100 == null) goto L8;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((h) r101.next()).a();
        goto L6
    L10:
        return;
    }

    public ReusedUIAssem() {
        this.f192985i = new CopyOnWriteArraySet();
        this.f192988l = true;
        this.f192989m = true;
        this.f192990n = LazyKt.lazy(new ReusedUIAssem$hostLifecycleOwner$2(this));
        this.f192991o = LazyKt.lazy(new ReusedUIAssem$reusedAssemLifecycleOwner$2(this));
        this.f192992p = LazyKt.lazy(new ReusedUIAssem$reusedAssemLifecycleRegistry$2(this));
        this.f192993q = new s();
        this.f192995s = LazyKt.lazy(ReusedUIAssem$reusedExecutor$2.INSTANCE);
        this.f192996t = LazyKt.lazy(ReusedUIAssem$lock$2.INSTANCE);
        this.f192997u = LazyKt.lazy(ReusedUIAssem$postTime$2.INSTANCE);
        this.f192998v = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public final void onCreate() {
        u();
        s().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        this.f192986j = true;
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public void onDestroy() {
        s().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.f192986j = false;
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public void onPause() {
        s().handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // com.bytedance.assem.arch.core.Assem
    public void onResume() {
        s().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        IResuedAssemProxy r100 = this.f192994r;
        if (r100 == null) goto L8;
        BehaviorSubject<a> r101 = r100.gl();
        if (r101 == null) goto L9;
        r101.onNext(new a(FireCase.HostResume, this));
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
        IResuedAssemProxy r100 = this.f192994r;
        if (r100 == null) goto L8;
        BehaviorSubject<a> r101 = r100.gl();
        if (r101 == null) goto L9;
        r101.onNext(new a(FireCase.HostStop, this));
        return;
    L9:
        return;
    }

    public final void p(View r100) {
        this.f192987k = true;
        w(r100);
        Iterator<Function0<Unit>> r101 = this.f192998v.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().invoke();
        goto L4
    L6:
        this.f192998v.clear();
    }

    @Override // com.bytedance.assem.arch.viewModel.e
    public final void vT(RenderStateVM r100, com.bytedance.assem.arch.viewModel.i r101, Function1 r102, Function2 r103) {
        com.bytedance.assem.arch.viewModel.e.a.a(this, r100, r101, r102, r103);
    }
}
