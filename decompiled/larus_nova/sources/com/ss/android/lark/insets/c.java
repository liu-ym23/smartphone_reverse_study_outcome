package com.ss.android.lark.insets;

import android.graphics.Rect;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class c implements f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f427732n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FitSystemCoordinator f427733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OnApplyWindowInsetsListener f427734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f427735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f427736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f427737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f427738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f427739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f427740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f427741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f427742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f427743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int[] f427744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Rect f427745m;

    public static final class a {
    }

    static {
    }

    public abstract WindowInsetsControllerCompat u();

    public final void s() {
        int r100 = this.f427738f;
        boolean r101 = true;
        if (r100 != 0) goto L11;
        FitSystemCoordinator r102 = this.f427733a;
        if (r102 == null) goto L7;
        Boolean r103 = Boolean.valueOf(r102.isDarkMode());
    L8:
        int r104 = WindowInsetsUtils.f427723a;
        p(!Intrinsics.areEqual(r103, Boolean.TRUE));
        return;
    L7:
        r103 = null;
        goto L8
    L11:
        if (ColorUtils.calculateContrast(r100, -1) <= 3.0d) goto L14;
        r101 = false;
    L14:
        p(r101);
    }

    public final void t() {
        int r100 = this.f427737e;
        boolean r101 = true;
        if (r100 != 0) goto L11;
        FitSystemCoordinator r102 = this.f427733a;
        if (r102 == null) goto L7;
        Boolean r103 = Boolean.valueOf(r102.isDarkMode());
    L8:
        int r104 = WindowInsetsUtils.f427723a;
        v(!Intrinsics.areEqual(r103, Boolean.TRUE));
        return;
    L7:
        r103 = null;
        goto L8
    L11:
        if (ColorUtils.calculateContrast(r100, -1) <= 3.0d) goto L14;
        r101 = false;
    L14:
        v(r101);
    }

    public c() {
        this.f427744l = new int[2];
        this.f427745m = new Rect();
    }

    @Override // com.ss.android.lark.insets.f
    public final int a() {
        return this.f427737e;
    }

    @Override // com.ss.android.lark.insets.f
    public final boolean e() {
        return this.f427741i;
    }

    @Override // com.ss.android.lark.insets.f
    public final boolean g() {
        return this.f427742j;
    }

    @Override // com.ss.android.lark.insets.f
    public final int j() {
        return this.f427743k;
    }

    @Override // com.ss.android.lark.insets.f
    public final boolean m() {
        return this.f427739g;
    }

    @Override // com.ss.android.lark.insets.f
    public final void b(int r100) {
        this.f427737e = r100;
        FitSystemCoordinator r101 = this.f427733a;
        if (r101 == null) goto L6;
        r101.a().f427755f = r100;
        r101.invalidate();
    L6:
        if (this.f427735c == false) goto L9;
        t();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void c(boolean r100) {
        this.f427741i = r100;
        FitSystemCoordinator r101 = this.f427733a;
        if (r101 == null) goto L6;
        r101.requestLayout();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void f(boolean r100) {
        this.f427739g = r100;
        FitSystemCoordinator r101 = this.f427733a;
        if (r101 == null) goto L6;
        r101.requestLayout();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void h(boolean r100) {
        this.f427742j = r100;
        FitSystemCoordinator r101 = this.f427733a;
        if (r101 == null) goto L6;
        r101.requestLayout();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void i(int r100) {
        this.f427738f = r100;
        FitSystemCoordinator r101 = this.f427733a;
        if (r101 == null) goto L6;
        r101.a().f427756g = r100;
        r101.invalidate();
    L6:
        if (this.f427736d == false) goto L9;
        s();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void k(boolean r100) {
        this.f427735c = r100;
        if (r100 == false) goto L6;
        t();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void l(int r100) {
        this.f427743k = r100;
        FitSystemCoordinator r101 = this.f427733a;
        if (r101 == null) goto L6;
        r101.requestLayout();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void o(boolean r100) {
        this.f427740h = r100;
        FitSystemCoordinator r101 = this.f427733a;
        if (r101 == null) goto L6;
        r101.requestLayout();
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void p(boolean r100) {
        WindowInsetsControllerCompat r101 = u();
        if (r101 == null) goto L6;
        r101.setAppearanceLightNavigationBars(r100);
        return;
    }

    @Override // com.ss.android.lark.insets.f
    public final void r(boolean r100) {
        this.f427736d = r100;
        if (r100 == false) goto L6;
        s();
        return;
    }

    public final void v(boolean r100) {
        WindowInsetsControllerCompat r101 = u();
        if (r101 == null) goto L6;
        r101.setAppearanceLightStatusBars(r100);
        return;
    }
}
