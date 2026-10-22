package com.bytedance.ies.sve_core;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.ies.sve_core.p;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005:\u0001\u0012J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ6\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/sve_core/PureWidget;", "Lcom/bytedance/ies/sve_core/p;", "P", "Lcom/bytedance/ies/sdk/widgets/Widget;", "Lcom/bytedance/ies/sve_core/q;", "Lcom/bytedance/ies/sve_core/r;", SlcElement.KEY_PROPS, "", "update", "(Lcom/bytedance/ies/sve_core/p;)V", "Landroidx/fragment/app/Fragment;", WidgetService.PARAM_FRAGMENT, "", "id", "Landroid/view/ViewGroup;", "parentView", "load", "(Landroid/support/v4/app/Fragment;Ljava/lang/Integer;Landroid/view/ViewGroup;)Lcom/bytedance/ies/sve_core/r;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "sve-core_release"}, k = 1, mv = {1, 4, 0})
public abstract class PureWidget<P extends p> extends Widget implements q<P>, r<P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<PureWidget<P>, Unit> f248680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PureViewImplDelegate f248681b;

    public static final class a {
    }

    static {
    }

    public PureWidget() {
        this(null);
    }

    public final PureViewImplDelegate Cq(PureWidget r100, Integer r101, ViewGroup r102) {
        PureViewImplDelegate r103 = this.f248681b;
        r103.d(r100, r101, r102);
        return r103;
    }

    public final Store Eq() {
        return this.f248681b.e();
    }

    public final <S extends s> Pair<o<S>, Function1<s, Unit>> Mq(u<S> r100, S r101) {
        return this.f248681b.g(r100, r101);
    }

    @Override // com.bytedance.ies.sve_core.r
    public final void Wo(i r100) {
        this.f248681b.Wo(r100);
    }

    @Override // com.bytedance.ies.sve_core.r
    public final PureViewImplDelegate X8(w r100, Function1 r101) {
        PureViewImplDelegate r102 = this.f248681b;
        r102.X8(r100, r101);
        return r102;
    }

    @Override // com.bytedance.ies.sve_core.r
    public <S extends s> r<P> Yk(u<S> r100, Function1<? super i, ? extends com.bytedance.ies.sve_core.a> r101, Function2<? super S, ? super P, ? extends P> r102) {
        PureViewImplDelegate r103 = this.f248681b;
        r103.Yk(r100, r101, r102);
        return r103;
    }

    public void Zm() {
        this.f248681b.Zm();
    }

    @Override // com.bytedance.ies.sve_core.r
    /* JADX INFO: renamed from: if */
    public final void mo8366if(i r100) {
        this.f248681b.mo8366if(r100);
    }

    @Override // com.bytedance.ies.sve_core.r
    public final void ki(i r100) {
        this.f248681b.ki(r100);
    }

    @Override // com.bytedance.ies.sve_core.r
    public final <P, T> void lc(P r100, Function1<? super P, ? extends T> r101, Function2<? super T, ? super T, Boolean> r102, Function1<? super T, Unit> r103) {
        this.f248681b.lc(r100, r101, r102, r103);
    }

    @Override // com.bytedance.ies.sve_core.r
    public void update(P r100) {
        this.f248681b.update(r100);
    }

    public void Fq() {
        Function1<PureWidget<P>, Unit> r100 = this.f248680a;
        if (r100 == null) goto L5;
        Unit r101 = r100.invoke(this);
    L5:
        PureViewImplDelegate r102 = this.f248681b;
        r102.getClass();
        r102.f(j.f.f248691a);
        r102.f248677i = true;
    }

    public void Gq() {
        Zm();
    }

    public final void Iq() {
        this.contentView.setVisibility(0);
    }

    public void Jq() {
        PureViewImplDelegate r100 = this.f248681b;
        WeakReference<WidgetManager> r101 = r100.f248674f;
        if (r101 == null) goto L5;
        WidgetManager r102 = r101.get();
    L6:
        if (r102 != null) goto L12;
        PureWidget<?> r103 = r100.f248671c;
        if (r103 == null) goto L14;
        WidgetManager r104 = r103.subWidgetManager;
        if (r104 == null) goto L15;
        r104.unload(r100.a());
        return;
    L15:
        return;
    L14:
        return;
    L12:
        r102.unload(r100.a());
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.ies.sve_core.q
    public List<q<?>> Zo() {
        WidgetManager r100 = this.subWidgetManager;
        if (r100 == null) goto L12;
        List<Widget> r101 = r100.widgets;
        if (r101 == null) goto L12;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L19;
        Object r104 = r103.next();
        if ((r104 instanceof PureWidget) == false) goto L8;
        r102.add(r104);
        goto L8
    L19:
        return r102;
    L12:
        return null;
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public void onDestroy() {
        super.onDestroy();
        Gq();
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public void onCreate() {
        super.onCreate();
        Fq();
    }

    public PureWidget(Object r100) {
        PureViewImplDelegate r101 = new PureViewImplDelegate();
        this.f248681b = r101;
        this.f248680a = null;
        r101.f248669a = this;
    }

    public final void Aq(Function1<? super h, Unit> r100) {
        Iterator r101 = ((ArrayList) this.f248681b.f248673e).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke(((x) r101.next()).f248706a);
        goto L4
    }

    public final <C extends e> C Kq(f<C> r100) {
        return (C) Store.useConstant$default(this.f248681b.e(), r100, null, 2, null);
    }

    public void rm(P r100) {
        wj(r100);
        wq(r100);
    }

    public void wq(P r100) {
        PureViewImplDelegate r101 = this.f248681b;
        r101.getClass();
        r101.f248670b = r100;
        r101.f(j.h.f248693a);
    }

    public r<P> Bq(PureWidget<?> r100, int r101) {
        PureViewImplDelegate r102 = this.f248681b;
        r102.f248671c = r100;
        r102.f248672d = r100.f248681b.f248672d;
        r100.enableSubWidgetManager();
        FragmentManager r103 = r100.widgetCallback.getWidgetManager().getFragmentManager();
        if (r103 == null) goto L5;
        r103.unregisterFragmentLifecycleCallbacks(r100.subWidgetManager.parentDestroyedCallback);
    L5:
        WidgetManager r104 = r100.subWidgetManager;
        Widget r105 = r102.f248669a;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L8:
        r104.load(r101, r105, false);
        return r102;
    }

    public final <S extends s> r<P> yq(u<S> r100, S r101) {
        PureViewImplDelegate r102 = this.f248681b;
        ((ArrayList) r102.f248676h).add(r100);
        r102.e().useState(r100, null, r101);
        return r102;
    }

    public final <S extends s, A extends com.bytedance.ies.sve_core.a> Pair<o<S>, Function1<com.bytedance.ies.sve_core.a, Unit>> Lq(final u<S> r100, Function2<? super S, ? super A, ? extends S> r101, S r102) {
        final Store r103 = this.f248681b.e();
        Function1<com.bytedance.ies.sve_core.a, Unit> r104 = new PureViewImplDelegate$useReducerState$dispatch$1(r103, r100);
        return new Pair(r103.useState(r100, r101, r102), r104);
    }

    public final <S extends s, A extends com.bytedance.ies.sve_core.a> r<P> xq(u<S> r100, Function2<? super S, ? super A, ? extends S> r101, S r102) {
        PureViewImplDelegate r103 = this.f248681b;
        ((ArrayList) r103.f248676h).add(r100);
        r103.e().useState(r100, r101, r102);
        return r103;
    }

    public <S extends s, C extends e> r<P> zq(final u<S> r100, f<C> r101, final Function1<? super i, ? extends com.bytedance.ies.sve_core.a> r102, final Function3<? super S, ? super C, ? super P, ? extends P> r103) {
        final PureViewImplDelegate r104 = this.f248681b;
        Object r105 = r104.f248672d;
        if (r105 != null) goto L10;
        Widget r106 = r104.f248669a;
        if (r106 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("widget");
    L8:
        r105 = r106.context;
    L10:
        if ((r105 instanceof LifecycleOwner) == true) goto L13;
    L19:
        return r104;
    L13:
        if (r104.f248679k.containsKey(r100) == true) goto L19;
        r104.f248679k.put(r100, Boolean.TRUE);
        if (r102 == null) goto L18;
        final Store r107 = r104.e();
        Function1<i, Unit> r108 = new PureViewImplDelegate$connectStoreWithConstant$$inlined$let$lambda$1(r102, r107, r104, r100);
        r104.f248678j.put(r100, r108);
    L18:
        o<S> r109 = r104.g(r100, null).component1();
        final e r110 = Store.useConstant$default(r104.e(), r101, null, 2, null);
        k r111 = r109.a((LifecycleOwner) r105, new PureViewImplDelegate$connectStoreWithConstant$disposable$1(r104, r103, r110));
        ((ArrayList) r104.f248675g).add(r111);
        goto L19
    }
}
