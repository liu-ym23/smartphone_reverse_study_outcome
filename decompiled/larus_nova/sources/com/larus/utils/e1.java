package com.larus.utils;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class e1 {

    /* JADX INFO: loaded from: classes31.dex */
    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f375388a;

        public a(View r100) {
            this.f375388a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f375388a.setAlpha(1.0f);
        }
    }

    /* JADX INFO: loaded from: classes31.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f375389a;

        public b(View r100) {
            this.f375389a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            e1.o(this.f375389a);
            this.f375389a.setAlpha(1.0f);
        }
    }

    public static final Fragment k(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Context r101 = r100.getContext();
        if ((r101 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r102 = (FragmentActivity) r101;
    L6:
        if (r102 != null) goto L9;
        return null;
    L9:
        return l(r102.getSupportFragmentManager(), r100);
    L5:
        r102 = null;
        goto L6
    }

    public static final LayoutInflater m(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return LayoutInflater.from(r100.getContext());
    }

    public static final void o(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(8);
    }

    public static final void p(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (s(r100) == true) goto L5;
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

    public static final void q(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(4);
    }

    public static final boolean r(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean s(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        WindowInsetsCompat r101 = ViewCompat.getRootWindowInsets(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.isVisible(WindowInsetsCompat.Type.ime());
    }

    public static final void x(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(0);
    }

    public static final <T extends View> void b(T r100, View.OnClickListener r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        a(r100, 500, r101);
    }

    public static final <T extends View> void c(final T r100, final View.OnClickListener r101) {
        Intrinsics.checkNotNullParameter(r101, "listener");
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setTag(123400001, 500L);
        r100.setOnClickListener(new a1(r100, r101));
    }

    public static final <T extends View> void d(T r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        Intrinsics.checkNotNullParameter(r101, SendEventContainerMethodParamModel.EventKinds.onClick);
        if (r100 == null) goto L7;
        r100.setTag(123400001, 500L);
        r100.setOnClickListener(new b1(r100, r101));
        return;
    }

    public static final Drawable e(float r100, int r101) {
        GradientDrawable r102 = new GradientDrawable();
        r102.setShape(0);
        r102.setCornerRadius(r100);
        r102.setColor(r101);
        return r102;
    }

    public static final void h(View r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 0) goto L5;
        return;
    L5:
        r100.setAlpha(0.0f);
        x(r100);
        r100.animate().alpha(1.0f).setListener(new a(r100)).setDuration(r101).start();
    }

    public static final void i(View r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 8) goto L5;
        return;
    L5:
        r100.animate().alpha(0.0f).setListener(new b(r100)).setDuration(r101).start();
    }

    public static final Fragment l(FragmentManager r100, View r101) {
        int r102 = r100.getFragments().size();
    L3:
        r102 = r102 - 1;
        if ((-1) >= r102) goto L22;
        Fragment r103 = (Fragment) ListProtector.get(r100.getFragments(), r102);
        View r104 = r103.getView();
        if (r104 == null) goto L3;
        Fragment r105 = l(r103.getChildFragmentManager(), r101);
        if (r105 != null) goto L10;
        Object r106 = r101.getParent();
    L12:
        if (r106 == null) goto L19;
        if ((r106 instanceof View) == false) goto L19;
        if (Intrinsics.areEqual(r106, r104) == true) goto L19;
        r106 = ((View) r106).getParent();
    L19:
        if (Intrinsics.areEqual(r106, r104) == false) goto L3;
        return r103;
    L10:
        return r105;
    L22:
        return null;
    }

    public static final Point n(View r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "parent");
        int r102 = 0;
        int r103 = 0;
    L4:
        if (Intrinsics.areEqual(r100, r101) == true) goto L11;
        if (r100 == null) goto L11;
        r103 = r103 + r100.getLeft();
        r102 = r102 + r100.getTop();
        Object r104 = r100.getParent();
        if ((r104 instanceof View) == true) goto L8;
        r100 = null;
        goto L4
    L8:
        r100 = (View) r104;
    L11:
        return new Point(r103, r102);
    }

    public static final void v(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        GradientDrawable r102 = new GradientDrawable();
        r102.setShape(0);
        r102.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        r102.setColors(new int[]{0, r101});
        r100.setBackground(r102);
    }

    public static final void y(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public static final <T extends View> void a(final T r100, long r101, final View.OnClickListener r102) {
        Intrinsics.checkNotNullParameter(r102, "listener");
        if (r100 != null) goto L5;
        return;
    L5:
        r100.setTag(123400001, Long.valueOf(r101));
        r100.setOnClickListener(new d1(r100, r102));
    }

    public static final Drawable j(View r100, float r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return e(r101, ContextCompat.getColor(r100.getContext(), r102));
    }

    public static final void t(View r100, float r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setBackground(e(r101, ContextCompat.getColor(r100.getContext(), r102)));
    }

    public static final Drawable f(int r100, int r101, float r102, int r103) {
        GradientDrawable r104 = new GradientDrawable();
        r104.setShape(0);
        r104.setCornerRadius(r102);
        r104.setColor(r103);
        r104.setSize(r100, r101);
        return r104;
    }

    public static final void u(View r100, float r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        float[] r104 = {r101, r101, r101, r101, r101, r101, r101, r101};
        int r105 = ContextCompat.getColor(r100.getContext(), r102);
        int r106 = ContextCompat.getColor(r100.getContext(), r103);
        GradientDrawable r107 = new GradientDrawable();
        r107.setShape(0);
        r107.setCornerRadii(r104);
        r107.setColor(r105);
        GradientDrawable r108 = new GradientDrawable();
        r108.setShape(0);
        r108.setCornerRadii(r104);
        r108.setColor(r106);
        StateListDrawable r109 = new StateListDrawable();
        r109.addState(new int[]{R.attr.state_pressed}, r108);
        r109.addState(new int[0], r107);
        r100.setBackground(r109);
    }

    public static final void w(View r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r104 = ContextCompat.getColor(r100.getContext(), r103);
        GradientDrawable r105 = new GradientDrawable();
        r105.setShape(1);
        r105.setColor(r104);
        r105.setSize(r101, r102);
        r100.setBackground(r105);
    }

    public static final void g(final View r100, final int r110, final int r111, final int r112, final int r113) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.getParent();
        if ((r101 instanceof View) == false) goto L5;
        View r102 = (View) r101;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        final View r103 = r102;
        r102.post(new c1(r100, r110, r111, r112, r113, r103));
        return;
    L5:
        r102 = null;
        goto L6
    }
}
