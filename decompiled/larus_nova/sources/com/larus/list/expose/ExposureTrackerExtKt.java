package com.larus.list.expose;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.ttnet.org.chromium.base.BaseSwitches;
import ii9.b;
import ii9.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import ji9.e;
import ji9.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class ExposureTrackerExtKt {

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f355733a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ExposureTrackerExtKt$initExposureTracker$scrollListener$1 f355734b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View.OnLayoutChangeListener f355735c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f355733a.addOnScrollListener(this.f355734b);
            this.f355733a.addOnLayoutChangeListener(this.f355735c);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f355733a.removeOnScrollListener(this.f355734b);
            this.f355733a.removeOnLayoutChangeListener(this.f355735c);
            if ((r100.getContext() instanceof AppCompatActivity) == false) goto L10;
            Context r101 = r100.getContext();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            AppCompatActivity r102 = (AppCompatActivity) r101;
            if (r102.isFinishing() == false) goto L7;
        L8:
            e r103 = e.f499240a;
            int r104 = System.identityHashCode(r102);
            r103.getClass();
            e.f499241b.remove(r104);
            return;
        L7:
            if (r102.isDestroyed() == true) goto L8;
            return;
        }

        public a(RecyclerView r100, ExposureTrackerExtKt$initExposureTracker$scrollListener$1 r101, c r102) {
            this.f355733a = r100;
            this.f355734b = r101;
            this.f355735c = r102;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.larus.list.expose.ExposureTrackerExtKt$initExposureTracker$scrollListener$1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View$OnLayoutChangeListener, ii9.c] */
    public static final void b(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final int r101 = System.identityHashCode(r100.getContext());
        ?? r102 = new ExposureTrackerExtKt$initExposureTracker$scrollListener$1(r101);
        ?? r103 = new c(r101);
        if (r100.isAttachedToWindow() == false) goto L5;
        r100.addOnScrollListener(r102);
        r100.addOnLayoutChangeListener(r103);
    L5:
        r100.addOnAttachStateChangeListener(new a(r100, r102, r103));
    }

    public static final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        e.f499240a.getClass();
        e.a(r100);
    }

    public static final void d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof AppCompatActivity) == false) goto L5;
        AppCompatActivity r101 = (AppCompatActivity) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isFinishing() == false) goto L10;
    L11:
        e r102 = e.f499240a;
        int r103 = System.identityHashCode(r101);
        r102.getClass();
        e.f499241b.remove(r103);
        return;
    L10:
        if (r101.isDestroyed() == true) goto L11;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public static final void a(View r100, Function1<? super b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        b r102 = new b();
        r101.invoke(r102);
        Intrinsics.checkNotNullParameter(r100, "view");
        if (r102.f490008a != null) goto L5;
    L8:
        ii9.a r103 = null;
    L9:
        if (r103 != null) goto L11;
        return;
    L11:
        e r104 = e.f499240a;
        String r105 = r103.f490002b.invoke();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "view");
        int r106 = System.identityHashCode(r100.getContext());
        Set<h> r107 = e.f499241b.get(r106);
        if (r107 == null) goto L23;
        Iterator<T> r108 = r107.iterator();
    L16:
        if (r108.hasNext() == false) goto L23;
        h r109 = (h) r108.next();
        if (Intrinsics.areEqual(r109.f499244c.get(), r100) == false) goto L16;
        if (r105 != null) goto L21;
    L22:
        boolean r110 = true;
    L24:
        if (r110 == false) goto L26;
        return;
    L26:
        e.f499240a.getClass();
        e.a(r100);
        h r111 = new h(r103);
        Intrinsics.checkNotNullParameter(r111, "traceModel");
        View r112 = r111.f499244c.get();
        if (r112 == null) goto L34;
        int r113 = System.identityHashCode(r112.getContext());
        SparseArray<Set<h>> r114 = e.f499241b;
        Set<h> r115 = r114.get(r113);
        if (r115 != null) goto L32;
        r115 = new HashSet();
        r114.put(r113, r115);
    L32:
        r115.add(r111);
    L34:
        if (r103.f490006f == false) goto L40;
        e.c(System.identityHashCode(r100.getContext()), 0);
        return;
    L40:
        return;
    L21:
        if (Intrinsics.areEqual(r109.f499242a.a().invoke(), r105) == true) goto L22;
    L23:
        r110 = false;
        goto L24
    L5:
        if (r102.f490009b == null) goto L8;
        r103 = new ii9.a(r100, r102);
        goto L9
    }
}
