package com.bytedance.ies.sve_core;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sve_core.p;
import defpackage.DeepThinkTopHeaderComponent$runCollapseAnimation$2;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class PureViewImplDelegate<P extends p> implements r<P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Widget f248669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public P f248670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PureWidget<?> f248671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Fragment f248672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<x> f248673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<WidgetManager> f248674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<g> f248675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<u<?>> f248676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f248677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<u<?>, Function1<i, Unit>> f248678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<u<?>, Boolean> f248679k;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.sve_core.r
    public final void Zm() {
        f(j.g.f248692a);
        LifecycleOwner r100 = this.f248669a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L6:
        if ((r100 instanceof q) == true) goto L8;
        r100 = null;
    L8:
        q r101 = (q) r100;
        if (r101 == null) goto L18;
        List<q<?>> r102 = r101.Zo();
        if (r102 == null) goto L18;
        Iterator<T> r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L18;
        q r104 = (q) r103.next();
        if ((r104 instanceof r) == false) goto L14;
        ((r) r104).Zm();
    L18:
        Iterator r105 = ((ArrayList) this.f248675g).iterator();
    L20:
        if (r105.hasNext() == false) goto L22;
        ((g) r105.next()).dispose();
        goto L20
    L22:
        Iterator r106 = ((ArrayList) this.f248676h).iterator();
    L24:
        if (r106.hasNext() == false) goto L26;
        e().removeState((u) r106.next());
        goto L24
    L26:
        ((ArrayList) this.f248676h).clear();
        ((LinkedHashMap) this.f248679k).clear();
        ((LinkedHashMap) this.f248678j).clear();
        ((ArrayList) this.f248675g).clear();
        this.f248674f = null;
        ((ArrayList) this.f248673e).clear();
        this.f248672d = null;
        this.f248671c = null;
        this.f248670b = null;
    }

    public final PureWidget<P> a() {
        Widget r100 = this.f248669a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L6:
        if ((r100 instanceof PureWidget) == true) goto L9;
        r100 = null;
    L9:
        return (PureWidget) r100;
    }

    public final Pair<r<?>, Boolean> b() {
        PureWidget<?> r100 = this.f248671c;
        if (r100 == null) goto L7;
        return r100.f248681b.b();
    L7:
        return new Pair(this, Boolean.FALSE);
    }

    public final Store e() {
        Fragment r100 = this.f248672d;
        Store r101 = null;
        if (r100 == null) goto L5;
        Store r102 = d.c(r100);
    L6:
        if (r102 == null) goto L8;
        return r102;
    L8:
        PureWidget<?> r103 = this.f248671c;
        if (r103 == null) goto L11;
        r101 = r103.Eq();
    L11:
        if (r101 == null) goto L13;
        return r101;
    L13:
        Widget r104 = this.f248669a;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L17:
        if ((r104.context instanceof FragmentActivity) == false) goto L28;
        Widget r105 = this.f248669a;
        if (r105 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L21:
        Context r106 = r105.context;
        if (r106 == null) goto L26;
        FragmentActivity r107 = (FragmentActivity) r106;
        return (Store) new ViewModelProvider(r107, ViewModelProvider.AndroidViewModelFactory.getInstance(r107.getApplication())).get(Store.class);
    L26:
        throw new TypeCastException("null cannot be cast to non-null type android.support.v4.app.FragmentActivity");
    L28:
        throw new RuntimeException("activity must FragmentActivity");
    L5:
        r102 = null;
        goto L6
    }

    public PureViewImplDelegate() {
        this.f248673e = new ArrayList();
        this.f248675g = new ArrayList();
        this.f248676h = new ArrayList();
        this.f248678j = new LinkedHashMap();
        this.f248679k = new LinkedHashMap();
    }

    @Override // com.bytedance.ies.sve_core.r
    public final void Wo(i r100) {
        Iterator r101 = ((LinkedHashMap) this.f248678j).values().iterator();
    L4:
        if (r101.hasNext() == false) goto L7;
        ((Function1) r101.next()).invoke(r100);
        goto L4
    L7:
        if (r100.a() == false) goto L29;
        Pair<r<?>, Boolean> r102 = b();
        r<?> r103 = r102.component1();
        boolean r104 = r102.component2().booleanValue();
        r103.ki(r100);
        if (r104 == true) goto L32;
        r103.mo8366if(r100);
        Widget r105 = this.f248669a;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L13:
        Context r106 = r105.context;
        Fragment r107 = null;
        if ((r106 instanceof FragmentActivity) == true) goto L16;
        r106 = null;
    L16:
        FragmentActivity r108 = (FragmentActivity) r106;
        if (r108 == null) goto L21;
        FragmentManager r109 = r108.getSupportFragmentManager();
        if (r109 == null) goto L21;
        Fragment r110 = r109.findFragmentByTag("EFFECT_FRAGMENT_TAG");
    L23:
        if ((r110 instanceof EffectReportFragment) == false) goto L26;
        r107 = r110;
    L26:
        EffectReportFragment r111 = (EffectReportFragment) r107;
        if (r111 == null) goto L33;
        r111.S90(r100);
        return;
    L33:
        return;
    L21:
        r110 = null;
        goto L23
    L32:
        return;
    L29:
        ki(r100);
    }

    public final void f(j r100) {
        Iterator r101 = ((ArrayList) this.f248673e).iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        x r102 = (x) r101.next();
        if ((r100 instanceof j.f) == true) goto L7;
        if ((r100 instanceof j.h) == true) goto L10;
        if ((r100 instanceof j.g) == false) goto L4;
        r102.f248706a.e();
        goto L4
    L10:
        r102.f248706a.getClass();
        goto L4
    L7:
        r102.f248706a.d();
        goto L4
    }

    @Override // com.bytedance.ies.sve_core.r
    /* JADX INFO: renamed from: if, reason: not valid java name */
    public final void mo8366if(i r100) {
        Fragment r101 = this.f248672d;
        Fragment r102 = null;
        if (r101 == null) goto L7;
        FragmentManager r103 = r101.getChildFragmentManager();
        if (r103 == null) goto L7;
        Fragment r104 = r103.findFragmentByTag("EFFECT_FRAGMENT_TAG");
    L9:
        if ((r104 instanceof EffectReportFragment) == false) goto L12;
        r102 = r104;
    L12:
        EffectReportFragment r105 = (EffectReportFragment) r102;
        if (r105 == null) goto L16;
        r105.S90(r100);
        return;
    L16:
        return;
    L7:
        r104 = null;
        goto L9
    }

    @Override // com.bytedance.ies.sve_core.r
    public final void ki(i r100) {
        Iterator<T> r101 = this.f248673e.iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        x r102 = (x) r101.next();
        if ((r100 instanceof j.f) == true) goto L7;
        if ((r100 instanceof j.h) == true) goto L10;
        if ((r100 instanceof j.g) == true) goto L13;
        r102.f248706a.a(r102.f248707b.invoke(r100));
        goto L4
    L13:
        return;
    L10:
        return;
    L7:
        return;
    L15:
        LifecycleOwner r103 = this.f248669a;
        if (r103 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L19:
        if ((r103 instanceof q) == true) goto L21;
        r103 = null;
    L21:
        q r104 = (q) r103;
        if (r104 == null) goto L31;
        List<q<?>> r105 = r104.Zo();
        if (r105 == null) goto L41;
        Iterator<T> r106 = r105.iterator();
    L27:
        if (r106.hasNext() == false) goto L42;
        q r107 = (q) r106.next();
        if ((r107 instanceof r) == false) goto L27;
        ((r) r107).ki(r100);
        goto L27
    L42:
        return;
    L41:
        return;
    }

    @Override // com.bytedance.ies.sve_core.r
    public void update(P r100) {
        LifecycleOwner r101 = this.f248669a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L6:
        if ((r101 instanceof q) == true) goto L8;
        r101 = null;
    L8:
        q r102 = (q) r101;
        if (r102 == null) goto L12;
        r102.rm(r100);
        return;
    }

    @Override // com.bytedance.ies.sve_core.r
    public final PureViewImplDelegate X8(w r100, Function1 r101) {
        r100.f248704b = new v(this);
        List<x> r102 = this.f248673e;
        ArrayList r103 = (ArrayList) r102;
        r103.add(new x(r100, r101));
        if (this.f248677i == false) goto L5;
        r100.d();
    L5:
        return this;
    }

    public final <S extends s> Pair<o<S>, Function1<s, Unit>> g(final u<S> r100, S r101) {
        final Store r102 = e();
        Function1<s, Unit> r103 = new PureViewImplDelegate$useState$modify$1(r102, r100);
        return new Pair(r102.useState(r100, null, r101), r103);
    }

    @Override // com.bytedance.ies.sve_core.r
    public final <S extends s> r<P> Yk(final u<S> r100, final Function1<? super i, ? extends com.bytedance.ies.sve_core.a> r101, final Function2<? super S, ? super P, ? extends P> r102) {
        Object r103 = this.f248672d;
        if (r103 != null) goto L10;
        Widget r104 = this.f248669a;
        if (r104 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L8:
        r103 = r104.context;
    L10:
        if ((r103 instanceof LifecycleOwner) == true) goto L12;
        return this;
    L12:
        if (r101 == null) goto L15;
        final Store r105 = e();
        Function1<i, Unit> r106 = new PureViewImplDelegate$connectStore$$inlined$let$lambda$1(r101, r105, this, r100);
        this.f248678j.put(r100, r106);
    L15:
        if (this.f248679k.containsKey(r100) == false) goto L17;
        return this;
    L17:
        this.f248679k.put(r100, Boolean.TRUE);
        k r107 = g(r100, null).component1().a((LifecycleOwner) r103, new PureViewImplDelegate$connectStore$disposable$1(this, r102));
        ((ArrayList) this.f248675g).add(r107);
        return this;
    }

    public final PureViewImplDelegate c(Fragment r100, Integer r101, ViewGroup r102) {
        this.f248672d = r100;
        WeakReference<WidgetManager> r103 = this.f248674f;
        ViewGroup r104 = null;
        if (r103 == null) goto L5;
        WidgetManager r105 = r103.get();
    L6:
        if (r105 != null) goto L14;
        if (r102 != null) goto L13;
        if (r101 == null) goto L13;
        View r106 = r100.getView();
        if (r106 == null) goto L12;
        r104 = (ViewGroup) r106.findViewById(r101.intValue());
    L12:
        r102 = r104;
    L13:
        this.f248674f = new WeakReference(WidgetManager.of(r100, r102));
    L14:
        WeakReference<WidgetManager> r107 = this.f248674f;
        if (r107 == null) goto L22;
        WidgetManager r108 = r107.get();
        if (r108 == null) goto L22;
        if (r101 != null) goto L21;
        r108.load(r102, a(), false);
        goto L22
    L21:
        r108.load(r101.intValue(), a(), false);
    L22:
        return this;
    L5:
        r105 = null;
        goto L6
    }

    public final PureViewImplDelegate d(PureWidget r100, Integer r101, ViewGroup r102) {
        this.f248671c = r100;
        this.f248672d = r100.f248681b.f248672d;
        r100.enableSubWidgetManager();
        FragmentManager r103 = r100.widgetCallback.getWidgetManager().getFragmentManager();
        if (r103 == null) goto L5;
        r103.unregisterFragmentLifecycleCallbacks(r100.subWidgetManager.parentDestroyedCallback);
    L5:
        if (r101 == null) goto L7;
        r102 = (ViewGroup) r102.findViewById(r101.intValue());
    L7:
        WidgetManager r104 = r100.subWidgetManager;
        Widget r105 = this.f248669a;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L10:
        r104.load(r102, r105, false);
        return this;
    }

    @Override // com.bytedance.ies.sve_core.r
    public final <P, T> void lc(P r100, Function1<? super P, ? extends T> r101, Function2<? super T, ? super T, Boolean> r102, Function1<? super T, Unit> r103) {
        T r104 = r101.invoke(r100);
        if (r104 == null) goto L21;
        P r105 = this.f248670b;
        if (r105 != null) goto L9;
        r103.invoke(r104);
        return;
    L9:
        if (Intrinsics.areEqual(r105, r100) == false) goto L11;
        return;
    L11:
        DeepThinkTopHeaderComponent$runCollapseAnimation$2.a r106 = this.f248670b;
        T r107 = null;
        if ((r106 instanceof Object) == true) goto L14;
        r106 = null;
    L14:
        if (r106 == null) goto L16;
        r107 = r101.invoke(r106);
    L16:
        if (r107 != null) goto L18;
    L19:
        r103.invoke(r104);
        return;
    L18:
        if (r102.invoke(r107, r104).booleanValue() == false) goto L19;
        return;
    }
}
