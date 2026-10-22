package com.bytedance.awemeopen.writtenlayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public abstract class IWrittenLayout implements h, k, f, j, d, n, e, l, g, b, i, c, m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f199010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f199011b;

    public abstract View f();

    public final View j() {
        return (View) this.f199011b.getValue();
    }

    @Override // com.bytedance.awemeopen.writtenlayout.h, com.bytedance.awemeopen.writtenlayout.k, com.bytedance.awemeopen.writtenlayout.f, com.bytedance.awemeopen.writtenlayout.j, com.bytedance.awemeopen.writtenlayout.d, com.bytedance.awemeopen.writtenlayout.n, com.bytedance.awemeopen.writtenlayout.e, com.bytedance.awemeopen.writtenlayout.l, com.bytedance.awemeopen.writtenlayout.g, com.bytedance.awemeopen.writtenlayout.b, com.bytedance.awemeopen.writtenlayout.i, com.bytedance.awemeopen.writtenlayout.c, com.bytedance.awemeopen.writtenlayout.m
    public Context getContext() {
        return this.f199010a;
    }

    public IWrittenLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f199010a = r100;
        this.f199011b = LazyKt.lazy(new IWrittenLayout$view$2(this));
    }

    public static void d(RelativeLayout.LayoutParams r100) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.addRule(9);
    }

    public final int g(float r100) {
        float r101 = a.f199012a;
        return a.a(getContext(), r100);
    }

    public static void q(TextView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        r100.setTextColor(r100.getResources().getColor(r101));
    }

    public final void h(ViewGroup.LayoutParams r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        float r102 = a.f199012a;
        r100.height = a.a(getContext(), r101);
    }

    public final void i(ViewGroup.LayoutParams r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        float r102 = a.f199012a;
        r100.width = a.a(getContext(), r101);
    }

    public final LinearLayout.LayoutParams m(LinearLayout r100, Function1<? super LinearLayout.LayoutParams, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-1, -1);
        if (r101 == null) goto L5;
        r101.invoke(r102);
    L5:
        return r102;
    }

    public final FrameLayout n(ViewGroup.LayoutParams r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "lparams");
        FrameLayout r102 = new FrameLayout(getContext());
        r102.setLayoutParams(r100);
        r101.invoke(r102);
        return r102;
    }

    public final FrameLayout.LayoutParams v(FrameLayout r100, Function1<? super FrameLayout.LayoutParams, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2);
        if (r101 == null) goto L5;
        r101.invoke(r102);
    L5:
        return r102;
    }

    public final LinearLayout.LayoutParams w(LinearLayout r100, Function1<? super LinearLayout.LayoutParams, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        LinearLayout.LayoutParams r102 = new LinearLayout.LayoutParams(-2, -2);
        if (r101 == null) goto L5;
        r101.invoke(r102);
    L5:
        return r102;
    }

    public final RelativeLayout.LayoutParams x(RelativeLayout r100, Function1<? super RelativeLayout.LayoutParams, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        RelativeLayout.LayoutParams r102 = new RelativeLayout.LayoutParams(-2, -2);
        if (r101 == null) goto L5;
        r101.invoke(r102);
    L5:
        return r102;
    }

    public final AoImageView e(ViewGroup r100, ViewGroup.LayoutParams r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        Intrinsics.checkNotNullParameter(r101, "lparams");
        AoImageView r103 = new AoImageView(r100.getContext());
        if (r102 == null) goto L5;
        r102.invoke(r103);
    L5:
        r100.addView(r103, r101);
        return r103;
    }

    public final ImageView k(ViewGroup r100, ViewGroup.LayoutParams r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        Intrinsics.checkNotNullParameter(r101, "lparams");
        ImageView r103 = new ImageView(r100.getContext());
        if (r102 == null) goto L5;
        r102.invoke(r103);
    L5:
        r100.addView(r103, r101);
        return r103;
    }

    public final ImageView l(ViewGroup r100, ViewGroup.LayoutParams r101, Function1<? super ImageView, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        Intrinsics.checkNotNullParameter(r101, "lparams");
        return k(r100, r101, r102);
    }

    public final LinearLayout o(int r100, ViewGroup.LayoutParams r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r101, "lparams");
        LinearLayout r103 = new LinearLayout(getContext());
        r103.setOrientation(r100);
        r103.setLayoutParams(r101);
        r102.invoke(r103);
        return r103;
    }

    public final AppCompatTextView p(Integer r100, ViewGroup.LayoutParams r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r101, "lparams");
        AppCompatTextView r103 = new AppCompatTextView(getContext());
        if (r100 == null) goto L5;
        r103.setId(r100.intValue());
    L5:
        if (r102 == null) goto L7;
        r102.invoke(r103);
    L7:
        r103.setLayoutParams(r101);
        return r103;
    }

    public final AppCompatTextView r(ViewGroup r100, ViewGroup.LayoutParams r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        Intrinsics.checkNotNullParameter(r101, "lparams");
        return s(r100, null, r101, r102);
    }

    public final View t(ViewGroup r100, ViewGroup.LayoutParams r101, Function1<? super View, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        Intrinsics.checkNotNullParameter(r101, "lparams");
        return u(r100, r101, r102);
    }

    public final View u(ViewGroup r100, ViewGroup.LayoutParams r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        Intrinsics.checkNotNullParameter(r101, "lparams");
        View r103 = new View(r100.getContext());
        if (r102 == null) goto L5;
        r102.invoke(r103);
    L5:
        r100.addView(r103, r101);
        return r103;
    }

    public static void a(ViewGroup r100, View r101, ViewGroup.LayoutParams r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "lparams");
        b(r100, null, r101, r102, r103);
    }

    public static /* synthetic */ void c(IWrittenLayout r100, ViewGroup r101, View r102, ViewGroup.LayoutParams r103) {
        r100.getClass();
        a(r101, r102, r103, null);
    }

    public final AppCompatTextView s(ViewGroup r100, Integer r101, ViewGroup.LayoutParams r102, Function1 r103) {
        Intrinsics.checkNotNullParameter(r100, "$receiver");
        Intrinsics.checkNotNullParameter(r102, "lparams");
        AppCompatTextView r104 = p(r101, r102, r103);
        r100.addView(r104);
        return r104;
    }

    public static void b(ViewGroup r100, Integer r101, View r102, ViewGroup.LayoutParams r103, Function1 r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r103, "lparams");
        if (r101 == null) goto L5;
        r102.setId(r101.intValue());
    L5:
        if (r104 == null) goto L7;
        r104.invoke(r102);
    L7:
        r100.addView(r102, r103);
    }
}
