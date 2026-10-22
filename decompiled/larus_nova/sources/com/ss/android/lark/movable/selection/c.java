package com.ss.android.lark.movable.selection;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<ViewGroup> f432775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<d, com.ss.android.lark.movable.selection.b> f432776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f432777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f432778d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f432779e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f432780f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f432781g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f432782h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ViewTreeObserverOnScrollChangedListenerC5143c f432783i;

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f432784a;

        public a(c r100) {
            this.f432784a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            this.f432784a.c();
        }
    }

    public static final class b implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f432785a;

        public b(c r100) {
            this.f432785a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            this.f432785a.c();
            return true;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.movable.selection.c$c, reason: collision with other inner class name */
    public static final class ViewTreeObserverOnScrollChangedListenerC5143c implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f432786a;

        public ViewTreeObserverOnScrollChangedListenerC5143c(c r100) {
            this.f432786a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            this.f432786a.c();
        }
    }

    public final void b() {
        if (this.f432780f == true) goto L5;
        return;
    L5:
        this.f432780f = false;
        View r100 = this.f432779e;
        if (r100 == null) goto L10;
        ViewTreeObserver r101 = r100.getViewTreeObserver();
        if (r101 == null) goto L10;
        r101.removeOnPreDrawListener(this.f432781g);
    L10:
        View r102 = this.f432779e;
        if (r102 == null) goto L15;
        ViewTreeObserver r103 = r102.getViewTreeObserver();
        if (r103 == null) goto L15;
        r103.removeOnGlobalLayoutListener(this.f432782h);
    L15:
        View r104 = this.f432779e;
        if (r104 == null) goto L20;
        ViewTreeObserver r105 = r104.getViewTreeObserver();
        if (r105 == null) goto L20;
        r105.removeOnScrollChangedListener(this.f432783i);
    L20:
        this.f432779e = null;
    }

    public final void c() {
        ViewGroup r100 = this.f432775a.invoke();
        Iterator r101 = ((LinkedHashMap) this.f432776b).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry r102 = (Map.Entry) r101.next();
        d((d) r102.getKey(), (com.ss.android.lark.movable.selection.b) r102.getValue(), r100);
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Function0<? extends ViewGroup> r100) {
        Intrinsics.checkNotNullParameter(r100, "mirrorContainerProvider");
        this.f432775a = r100;
        this.f432776b = new LinkedHashMap();
        this.f432777c = new int[2];
        this.f432778d = new int[2];
        this.f432781g = new b(this);
        this.f432782h = new a(this);
        this.f432783i = new ViewTreeObserverOnScrollChangedListenerC5143c(this);
    }

    public final void a(d r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        com.ss.android.lark.movable.selection.b r101 = this.f432776b.remove(r100);
        if (r101 == null) goto L10;
        ViewParent r102 = r101.getParent();
        if ((r102 instanceof ViewGroup) == false) goto L7;
        ViewGroup r103 = (ViewGroup) r102;
    L8:
        if (r103 == null) goto L10;
        r103.removeView(r101);
        goto L10
    L7:
        r103 = null;
    L10:
        r100.setIsGhost(false);
        if (this.f432776b.isEmpty() == false) goto L14;
        b();
        return;
    }

    public final void d(d r100, com.ss.android.lark.movable.selection.b r101, ViewGroup r110) {
        View r102 = r100.getView();
        Object r103 = r102.getParent();
        Integer r104 = null;
        if ((r103 instanceof View) == false) goto L5;
        View r105 = (View) r103;
    L6:
        if (r105 != null) goto L8;
        return;
    L8:
        if (r105 != r110) goto L10;
        return;
    L10:
        r101.setPivotX(r102.getPivotX());
        r101.setPivotY(r102.getPivotY());
        r101.setRotation(r102.getRotation());
        r101.setRotationX(r102.getRotationX());
        r101.setRotationY(r102.getRotationY());
        r101.setScaleX(r102.getScaleX());
        r101.setScaleY(r102.getScaleY());
        Integer r106 = Integer.valueOf(r102.getWidth());
        if (r106.intValue() <= 0) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == true) goto L17;
        r106 = null;
    L17:
        if (r106 == null) goto L19;
        int r108 = r106.intValue();
    L20:
        Integer r109 = Integer.valueOf(r102.getHeight());
        if (r109.intValue() <= 0) goto L23;
        boolean r111 = true;
    L24:
        if (r111 == false) goto L26;
        r104 = r109;
    L26:
        if (r104 == null) goto L28;
        int r112 = r104.intValue();
    L30:
        if (r101.getLayoutParams().width == r108) goto L32;
    L33:
        r101.getLayoutParams().width = r108;
        r101.getLayoutParams().height = r112;
        r101.requestLayout();
    L34:
        r105.getLocationOnScreen(this.f432777c);
        r110.getLocationOnScreen(this.f432778d);
        r101.setX((this.f432777c[0] + r102.getX()) - this.f432778d[0]);
        r101.setY((this.f432777c[1] + r102.getY()) - this.f432778d[1]);
        r101.invalidate();
        return;
    L32:
        if (r101.getLayoutParams().height == r112) goto L34;
    L28:
        r112 = r102.getMeasuredHeight();
        goto L30
    L23:
        r111 = false;
        goto L24
    L19:
        r108 = r102.getMeasuredWidth();
        goto L20
    L13:
        r107 = false;
        goto L14
    L5:
        r105 = null;
        goto L6
    }
}
