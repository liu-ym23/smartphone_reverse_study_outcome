package com.obric.oui.animation.easy;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b<T extends View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f398738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<qu7.a> f398739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<jla.c<? super T>, jla.d> f398740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f398741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f398742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a<T> f398743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public jla.b.j f398744g;

    public interface a<T extends View> {
        void a(b<T> r100);

        void b(b<T> r100);

        void c(b<T> r100);
    }

    public final void e() {
        if (((ArrayList) this.f398739b).isEmpty() == true) goto L74;
        List r100 = CollectionsKt.toList(this.f398739b);
        ((ArrayList) this.f398739b).clear();
        a<T> r101 = this.f398743f;
        if (r101 == null) goto L9;
        r101.b(this);
    L9:
        Iterator r102 = r100.iterator();
    L11:
        if (r102.hasNext() == false) goto L92;
        qu7.a r103 = (qu7.a) r102.next();
        com.obric.oui.animation.easy.a r104 = r103.f534846b;
        jla.d r105 = r103.f534845a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r105, GXTemplateKey.GAIAX_ANIMATION);
        r105.f499585h = r104.f398731d;
        r105.f499584g = Float.MAX_VALUE;
        if (r104.f398729b == false) goto L16;
        r105.f499579b = r104.f398730c;
        r105.f499580c = true;
    L16:
        if (r105.f499592t != null) goto L18;
        r105.f499592t = new jla.e();
    L18:
        jla.e r106 = r105.f499592t;
        if (r104.f398732e == false) goto L21;
        float r107 = r104.f398734g;
    L23:
        if (r107 < 0.0f) goto L72;
        r106.f499596b = r107;
        r106.f499597c = false;
        if (r104.f398735h == false) goto L27;
        float r108 = r104.f398737j;
    L29:
        if (r108 <= 0.0f) goto L71;
        r106.f499595a = Math.sqrt(r108);
        r106.f499597c = false;
        r105.f499592t.f499603i = r104.f398728a;
        jla.d r109 = r103.f534845a;
        jla.e r110 = r109.f499592t;
        if (r110 == null) goto L69;
        double r111 = (float) r110.f499603i;
        if (r111 > r109.f499584g) goto L67;
        if (r111 < r109.f499585h) goto L65;
        double r112 = Math.abs(r109.f499587j * 0.75f);
        r110.f499598d = r112;
        r110.f499599e = r112 * 62.5d;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L62;
        boolean r113 = r109.f499583f;
        if (r113 == true) goto L11;
        if (r113 == true) goto L11;
        r109.f499583f = true;
        if (r109.f499580c == true) goto L44;
        r109.f499579b = r109.f499582e.a(r109.f499581d);
    L44:
        float r114 = r109.f499579b;
        if (r114 > r109.f499584g) goto L61;
        if (r114 < r109.f499585h) goto L61;
        ThreadLocal<jla.a> r115 = jla.a.f499559g;
        if (r115.get() != null) goto L51;
        r115.set(new jla.a());
    L51:
        jla.a r116 = r115.get();
        if (r116.f499561b.size() != 0) goto L58;
        if (r116.f499563d != null) goto L56;
        r116.f499563d = new jla.a.d(r116.f499562c);
    L56:
        jla.a.d r117 = r116.f499563d;
        r117.f499568b.postFrameCallback(r117.f499569c);
    L58:
        if (r116.f499561b.contains(r109) == true) goto L11;
        r116.f499561b.add(r109);
    L61:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    L62:
        ThreadMethodProxy.currentThread().getId();
        ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getId();
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L65:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L67:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L69:
        throw new UnsupportedOperationException("Incomplete com.obric.oui.animation.engine.SpringAnimation: Either final position or a spring force needs to be set.");
    L71:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    L27:
        r108 = r104.f398736i;
        goto L29
    L72:
        r106.getClass();
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    L21:
        r107 = r104.f398733f;
        goto L23
    L92:
        return;
    }

    public b(T r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f398738a = r100;
        this.f398739b = new ArrayList();
        this.f398740c = new LinkedHashMap();
        this.f398741d = 0.5f;
        this.f398742e = 1500.0f;
    }

    public static /* synthetic */ void b(b r100, float r101) {
        r100.a(com.obric.oui.popover.v2.f.f402406a, r101, ViewPropertySpringAnimator$animateProperty$2.INSTANCE);
    }

    public final void a(jla.c r100, float r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r102, "config");
        jla.d r103 = (jla.d) ((LinkedHashMap) this.f398740c).get(r100);
        if (r103 != null) goto L15;
        r103 = new jla.d(this.f398738a, r100);
        d r104 = new d(this);
        if (r103.f499583f == true) goto L14;
        if (r103.f499589l.contains(r104) == true) goto L9;
        r103.f499589l.add(r104);
    L9:
        c r105 = new c(this, r100, r104);
        if (r103.f499588k.contains(r105) == true) goto L12;
        r103.f499588k.add(r105);
    L12:
        this.f398740c.put(r100, r103);
        goto L15
    L14:
        throw new UnsupportedOperationException("Error: Update listeners must be added beforethe animation.");
    L15:
        com.obric.oui.animation.easy.a r106 = new com.obric.oui.animation.easy.a(r101);
        r102.invoke(r106);
        r106.f398733f = this.f398741d;
        r106.f398736i = this.f398742e;
        List<qu7.a> r107 = this.f398739b;
        ArrayList r108 = (ArrayList) r107;
        r108.add(new qu7.a(r103, r106));
    }

    public final void c(Function1 r100, Function1 r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetCostModule.TYPE_ON_START);
        Intrinsics.checkNotNullParameter(r101, "onCancel");
        Intrinsics.checkNotNullParameter(r102, "onEnd");
        this.f398743f = new e(r100, r101, r102);
    }

    public static /* synthetic */ void d(b r100, Function1 r101, Function1 r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        ViewPropertySpringAnimator$setListener$1 r104 = ViewPropertySpringAnimator$setListener$1.INSTANCE;
    L7:
        if ((r103 & 2) == 0) goto L10;
        r101 = ViewPropertySpringAnimator$setListener$2.INSTANCE;
    L10:
        if ((r103 & 4) == 0) goto L12;
        r102 = ViewPropertySpringAnimator$setListener$3.INSTANCE;
    L12:
        r100.c(r104, r101, r102);
        return;
    L5:
        r104 = null;
        goto L7
    }
}
