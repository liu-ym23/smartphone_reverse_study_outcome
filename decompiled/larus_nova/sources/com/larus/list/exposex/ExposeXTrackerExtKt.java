package com.larus.list.exposex;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import ki9.c;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import li9.b;
import li9.d;
import li9.e;
import li9.f;

/* JADX INFO: loaded from: classes30.dex */
public final class ExposeXTrackerExtKt {

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f355737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ExposeXTrackerExtKt$initExposeXTracker$scrollListener$1 f355738b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View.OnLayoutChangeListener f355739c;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f355737a.addOnScrollListener(this.f355738b);
            this.f355737a.addOnLayoutChangeListener(this.f355739c);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f355737a.removeOnScrollListener(this.f355738b);
            this.f355737a.removeOnLayoutChangeListener(this.f355739c);
            if ((r100.getContext() instanceof AppCompatActivity) == false) goto L10;
            Context r101 = r100.getContext();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            AppCompatActivity r102 = (AppCompatActivity) r101;
            if (r102.isFinishing() == false) goto L7;
        L8:
            e r103 = e.f509442a;
            int r104 = System.identityHashCode(r102);
            r103.getClass();
            e.f509443b.remove(r104);
            return;
        L7:
            if (r102.isDestroyed() == true) goto L8;
            return;
        }

        public a(RecyclerView r100, ExposeXTrackerExtKt$initExposeXTracker$scrollListener$1 r101, c r102) {
            this.f355737a = r100;
            this.f355738b = r101;
            this.f355739c = r102;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.larus.list.exposex.ExposeXTrackerExtKt$initExposeXTracker$scrollListener$1] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.view.View$OnLayoutChangeListener, ki9.c] */
    public static final void c(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final int r101 = System.identityHashCode(r100.getContext());
        ?? r102 = new ExposeXTrackerExtKt$initExposeXTracker$scrollListener$1(r101);
        ?? r103 = new c(r101);
        if (r100.isAttachedToWindow() == false) goto L5;
        r100.addOnScrollListener(r102);
        r100.addOnLayoutChangeListener(r103);
    L5:
        r100.addOnAttachStateChangeListener(new a(r100, r102, r103));
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
        e r102 = e.f509442a;
        int r103 = System.identityHashCode(r100);
        r102.getClass();
        e.f509443b.remove(r103);
        return;
    L10:
        if (r101.isDestroyed() == true) goto L11;
        return;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [li9.a] */
    public static final void e(final View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        e.f509442a.getClass();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        if (r100 == null) goto L28;
        int r102 = System.identityHashCode(r100.getContext());     // Catch: Throwable -> L18
        e.a r103 = e.f509443b.get(r102);     // Catch: Throwable -> L18
        if (Build.VERSION.SDK_INT < 24) goto L9;
        Set<f> r104 = r103.f509444a;     // Catch: Throwable -> L18
        final ?? r105 = new li9.a(r100);     // Catch: Throwable -> L18
        Object r106 = Boolean.valueOf(r104.removeIf(new b(r105)));     // Catch: Throwable -> L18
    L16:
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L18
        return;
    L9:
        Iterator<f> r107 = r103.f509444a.iterator();     // Catch: Throwable -> L18
    L11:
        if (r107.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(r107.next().a().get(), r100) == false) goto L11;
        r107.remove();     // Catch: Throwable -> L18
        goto L11
    L15:
        r106 = Unit.INSTANCE;     // Catch: Throwable -> L18
        goto L16
    L28:
        return;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static final void a(Context r100, final String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "cellIdPrefix");
        e r102 = e.f509442a;
        int r103 = System.identityHashCode(r100);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "cellIdPrefix");
        SparseArray<e.a> r104 = e.f509443b;
        e.a r105 = r104.get(r103);
        if (r105 == null) goto L13;
        CollectionsKt.removeAll(r105.f509444a, new li9.c(r101));
        CollectionsKt.removeAll(r105.f509445b, new d(r101));
        if (r105.f509444a.isEmpty() == true) goto L8;
        return;
    L8:
        if (r105.f509445b.isEmpty() == false) goto L12;
        r104.remove(r103);
        return;
    L12:
        return;
    }

    public static final void b(View r100, Function1<? super ki9.b, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "block");
        ki9.b r101 = new ki9.b();
        r110.invoke(r101);
        Intrinsics.checkNotNullParameter(r100, "view");
        Object r102 = null;
        if (r101.f503656a != null) goto L5;
    L8:
        ki9.a r111 = null;
    L9:
        if (r111 == null) goto L39;
        f r103 = new f(r111);
        e.f509442a.getClass();
        Intrinsics.checkNotNullParameter(r103, "traceModel");
        View r104 = r103.a().get();
        if (r104 != null) goto L13;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
        return;
    L19:
        Intrinsics.checkNotNullParameter(r103, "traceModel");
        View r106 = r103.a().get();
        if (r106 == null) goto L33;
        int r107 = System.identityHashCode(r106.getContext());
        SparseArray<e.a> r108 = e.f509443b;
        e.a r109 = r108.get(r107);
        if (r109 != null) goto L25;
        r109 = new e.a(new LinkedHashSet(), new LinkedHashSet());
        r108.put(r107, r109);
    L25:
        Set<f> r112 = r109.f509444a;
        Set<f> r113 = r112;
        Iterator<T> r114 = r112.iterator();
    L27:
        if (r114.hasNext() == false) goto L31;
        Object r115 = r114.next();
        if (Intrinsics.areEqual(((f) r115).a().get(), r106) == false) goto L27;
        r102 = r115;
    L31:
        TypeIntrinsics.asMutableCollection(r113).remove(r102);
        r109.f509444a.add(r103);
    L33:
        if (r111.f503655f == false) goto L40;
        e r116 = e.f509442a;
        int r117 = System.identityHashCode(r100.getContext());
        r116.getClass();
        e.a(r117, 0);
        return;
    L40:
        return;
    L13:
        e.a r118 = e.f509443b.get(System.identityHashCode(r104.getContext()));
        if (r118 != null) goto L16;
        r105 = false;
        goto L17
    L16:
        r105 = CollectionsKt.contains(r118.f509445b, r103.f509446a.a().invoke());
        goto L17
    L39:
        return;
    L5:
        if (r101.f503657b == null) goto L8;
        r111 = new ki9.a(r100, r101);
        goto L9
    }
}
