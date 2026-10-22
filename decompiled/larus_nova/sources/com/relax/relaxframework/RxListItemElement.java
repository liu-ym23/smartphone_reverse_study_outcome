package com.relax.relaxframework;

import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class RxListItemElement extends RxAttributedElementImpl {
    public ReactiveRuntime A;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public q2 f404939x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f404940y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final WeakReference<o2> f404941z;

    public final ReactiveRuntime w0() {
        ReactiveRuntime r100 = this.A;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("reactiveRuntime");
        return null;
    }

    public final void x0(q2 r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "itemProps");
        q2 r102 = null;
        if (r101 == true) goto L9;
        q2 r103 = this.f404939x;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("___itemProps");
        r103 = null;
    L8:
        if (Intrinsics.areEqual(r103.f405226a, r100.f405226a) == false) goto L9;
    L10:
        if (r101 == true) goto L17;
        q2 r104 = this.f404939x;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("___itemProps");
    L16:
        if (Intrinsics.areEqual(r102.f405230e, r100.f405230e) == false) goto L17;
    L22:
        this.f404939x = r100;
        return;
    L14:
        r102 = r104;
    L17:
        ElementAttribute r105 = ElementAttribute.FullSpan;
        Boolean r106 = r100.f405230e;
        if (r106 == null) goto L20;
        boolean r107 = r106.booleanValue();
    L21:
        n0(r105, r107);
        goto L22
    L20:
        r107 = false;
    L9:
        m0(ElementAttribute.ItemKey, r100.f405226a);
        goto L10
    }

    public RxListItemElement(o2 r100, q2 r101, final Function0<? extends j5> r102) {
        Intrinsics.checkNotNullParameter(r100, "itemPool");
        Intrinsics.checkNotNullParameter(r101, "itemProps");
        Intrinsics.checkNotNullParameter(r102, "renderChildren");
        int r103 = l5.f405179a;
        RelaxInstance.Companion.getClass();
        super("list-item", Long.valueOf(RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().B()));
        this.f404939x = r101;
        this.f404941z = new WeakReference(r100);
        ReactiveRuntime r104 = new ReactiveRuntime();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.A = r104;
        j5 r105 = this.f404932u.getRootElement();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.relax.relaxframework.RxPageImpl");
        final WeakReference r106 = new WeakReference((RxPageImpl) r105);
        ReactiveRuntime r107 = w0();
        Function0<Unit> r108 = new AnonymousClass1(r106);
        r107.getClass();
        Intrinsics.checkNotNullParameter(r108, "cb");
        r107.f404864j = r108;
        ReactiveRuntime r109 = w0();
        OwnerImpl r110 = OwnerImpl.f404833g;
        if (r110 == null) goto L7;
        ReactiveRuntime r111 = r110.f404834a;
        if (r111 == null) goto L7;
        boolean r112 = r111.f404865k;
    L8:
        r109.f404865k = r112;
        long r113 = E();
        this.f404940y = RelaxInstance.access$getCurrentInstance$cp().getRendererFunction().e0(r113);
        x0(r101, true);
        t((j5) RelaxFrameworkKt.L(new AnonymousClass2(this, r102)));
        RelaxFrameworkKt.Y(new AnonymousClass3(this));
        return;
    L7:
        r112 = false;
        goto L8
    }
}
