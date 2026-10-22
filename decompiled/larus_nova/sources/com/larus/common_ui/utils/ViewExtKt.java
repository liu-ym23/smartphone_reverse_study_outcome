package com.larus.common_ui.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import bv8.i;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.u;
import com.larus.utils.w0;
import com.obric.assistant.chat.component.bottom.core.h;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import v19.g7;
import v19.h7;
import v19.l5;
import v19.w5;
import v19.x5;
import v19.y5;
import v19.z5;

/* JADX INFO: loaded from: classes4.dex */
public final class ViewExtKt {

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a implements Function1<Throwable, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f327829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewExtKt$awaitScrollEnd$2$listener$1 f327830b;

        public a(RecyclerView r100, ViewExtKt$awaitScrollEnd$2$listener$1 r101) {
            this.f327829a = r100;
            this.f327830b = r101;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Throwable r100) {
            this.f327829a.removeOnScrollListener(this.f327830b);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f327834a;

        public b(View r100) {
            this.f327834a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f327834a.setTag(R.id.animating_tag, Boolean.FALSE);
            e1.q(this.f327834a);
            this.f327834a.setAlpha(1.0f);
        }
    }

    public static final void d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 0) goto L5;
        return;
    L5:
        r100.setAlpha(0.0f);
        e1.x(r100);
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.0f, 1.0f});
        r101.setInterpolator(new l5());
        r101.setDuration(300);
        r101.start();
    }

    public static final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 8) goto L5;
        return;
    L5:
        if (r100.getVisibility() == 4) goto L10;
        r100.setTag(R.id.animating_tag, Boolean.TRUE);
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{1.0f, 0.0f});
        r101.setInterpolator(new l5());
        r101.setDuration(300);
        r101.addListener(new b(r100));
        r101.start();
        return;
    }

    public static final <F extends Fragment> F f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (F) FragmentManager.findFragment(r100);
    }

    public static final void g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (h(r100) == true) goto L5;
        return;
    L5:
        Context r101 = r100.getContext();
        if ((r101 instanceof Activity) == false) goto L8;
        Activity r102 = (Activity) r101;
    L9:
        if (r102 == null) goto L13;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L13;
        new WindowInsetsControllerCompat(r103, r100).hide(WindowInsetsCompat.Type.ime());
    L13:
        View r104 = r100.findFocus();
        if (r104 != null) goto L16;
        return;
    L16:
        r104.clearFocus();
        return;
    L8:
        r102 = null;
        goto L9
    }

    public static final boolean h(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r101 = false;
        if (z5.d() == false) goto L38;
        Intrinsics.checkNotNullParameter(r100, "view");
        Context r102 = r100.getContext();
    L5:
        boolean r103 = r102 instanceof Activity;
        if (r103 == true) goto L10;
        if ((r102 instanceof ContextWrapper) == false) goto L10;
        r102 = ((ContextWrapper) r102).getBaseContext();
    L10:
        FragmentActivity r104 = null;
        if (r103 == false) goto L13;
        Activity r105 = (Activity) r102;
    L14:
        if (r105 == null) goto L44;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L37;
        View r107 = z5.a(r106);
        if (r107 == null) goto L37;
        Rect r108 = new Rect();
        if (z5.c(r107, r108) == true) goto L25;
        r108 = null;
    L25:
        if (r108 == null) goto L45;
        int r109 = w0.f375484a;
        int r110 = w0.c(r105);
        int r111 = r108.bottom;
        if ((r105 instanceof FragmentActivity) == false) goto L30;
        r104 = (FragmentActivity) r105;
    L30:
        int r112 = (r110 - r111) - u.b(r104);
        if (r112 >= 150) goto L33;
        r112 = 0;
    L33:
        if (r112 <= 0) goto L46;
        r101 = true;
    L46:
        return r101;
    L45:
        return z5.b(r100);
    L37:
        return z5.b(r100);
    L44:
        return z5.b(r100);
    L13:
        r105 = null;
        goto L14
    L38:
        WindowInsetsCompat r113 = ViewCompat.getRootWindowInsets(r100);
        if (r113 != null) goto L41;
        return false;
    L41:
        return r113.isVisible(WindowInsetsCompat.Type.ime());
    }

    public static final <F extends Fragment> F i(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(FragmentManager.findFragment(r100));     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r102) == false) goto L11;
        r102 = null;
    L11:
        return (F) r102;
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final void a(View r100, final Function1<? super Insets, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(r100, new ViewExtKt$applyImeInsetsAnimation$1(r101));
    }

    public static final Object b(View r100, ContinuationImpl r101) {
        j r102 = new j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        h7 r103 = new h7(r100, r102);
        r102.i(new g7(r100, r103));
        r100.getViewTreeObserver().addOnGlobalLayoutListener(r103);
        Object r104 = r102.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L6:
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r104;
    L9:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.larus.common_ui.utils.ViewExtKt$awaitScrollEnd$2$listener$1] */
    public static final Object c(final RecyclerView r100, Continuation<? super Unit> r101) {
        final j r102 = new j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        ?? r103 = new ViewExtKt$awaitScrollEnd$2$listener$1(r100, r102);
        r102.i(new a(r100, r103));
        r100.addOnScrollListener(r103);
        Object r104 = r102.B();
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L6:
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r104;
    L9:
        return Unit.INSTANCE;
    }

    public static void k(View r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = 8;
        if (r101 != null) goto L6;
        r100.setVisibility(8);
        return;
    L6:
        if (r101.booleanValue() == false) goto L8;
        r102 = 0;
    L8:
        r100.setVisibility(r102);
    }

    public static void j(final View r100, final Function1 r101, final Function1 r102, int r103) {
        final Function1 r104 = null;
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = null;
    L8:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (z5.d() == false) goto L11;
        Intrinsics.checkNotNullParameter(r100, "view");
        z5.e(r100, new w5(r101), new x5(r104), new y5(r102));
        return;
    L11:
        WindowInsetsAnimationCompat.Callback r105 = new ViewExtKt$setImeAnimationCallback$1(r101, r104, r102, r100);
        ViewCompat.setWindowInsetsAnimationCallback(r100, null);
        ViewCompat.setWindowInsetsAnimationCallback(r100, r105);
    }

    public static final void m(View r100, Function1<? super Boolean, Unit> r101, Function1<? super Insets, Unit> r102, Function1<? super Boolean, Unit> r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(r100, new ViewExtKt$watchOnImeInsetsAnimationInternal$1(r101, null, r102, null, r110));
    }

    public static /* synthetic */ void n(View r100, Function1 r101, i r102, Function1 r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = null;
    L11:
        m(r100, r101, r102, r103);
    }

    public static void l(View r100, Function1 r101, h r110, Function2 r111, Function1 r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        Function1 r102 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        h r103 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        Function2 r104 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        Function1 r105 = null;
    L18:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ViewCompat.setWindowInsetsAnimationCallback(r100, new ViewExtKt$watchOnImeInsetsAnimationInternal$1(r102, null, r103, r104, r105));
        return;
    L17:
        r105 = r112;
        goto L18
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}
