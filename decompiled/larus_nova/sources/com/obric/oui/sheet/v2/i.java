package com.obric.oui.sheet.v2;

import android.content.Context;
import android.content.res.Resources;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes34.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f402969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OSheetBase f402970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RadiusLayout f402971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f402972d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f402973e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f402974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f402975g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f402976h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f402977i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f402978j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public OSheet.HeightMode f402979k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f402980l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f402981m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public OSheetTitleBar f402982n;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f402983a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f402984b = null;

        static {
            int[] r100 = new int[OSheet.HeightMode.values().length];
            r100[OSheet.HeightMode.FULL_HEIGHT.ordinal()] = 1;
            r100[OSheet.HeightMode.WRAP_HEIGHT.ordinal()] = 2;
            f402983a = r100;
            int[] r101 = new int[OSheet.Header.values().length];
            r101[OSheet.Header.PAGE.ordinal()] = 1;
            r101[OSheet.Header.ACTION.ordinal()] = 2;
            r101[OSheet.Header.MODAL.ordinal()] = 3;
            r101[OSheet.Header.ONLY_TITLE.ordinal()] = 4;
            r101[OSheet.Header.PAGE_WITH_CLOSE.ordinal()] = 5;
            f402984b = r101;
        }
    }

    public final void a() {
        if (this.f402970b.q() == false) goto L5;
        int r100 = 0;
    L6:
        this.f402978j = (((this.f402977i - r100) - this.f402974f.getHeight()) - this.f402971c.getPaddingTop()) - this.f402971c.getPaddingBottom();
        return;
    L5:
        r100 = this.f402972d.getHeight();
        goto L6
    }

    public final void e() {
        this.f402971c.setMaxHeight(this.f402977i);
        OSheet.HeightMode r100 = this.f402979k;
        int r101 = a.f402983a[r100.ordinal()];
        boolean r102 = false;
        if (r101 != 1) goto L5;
        RadiusLayout r103 = this.f402971c;
        int r104 = this.f402977i;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r103.getLayoutParams().height = r104;
        r103.requestLayout();
        if ((this.f402975g instanceof LinearLayout) == false) goto L27;
        ViewGroup.LayoutParams r105 = this.f402973e.getLayoutParams();
        if (r105 == null) goto L26;
        LinearLayout.LayoutParams r106 = (LinearLayout.LayoutParams) r105;
        r106.weight = 1.0f;
        r106.height = 0;
        this.f402973e.setLayoutParams(r106);
    L30:
        this.f402975g.getLayoutParams().height = -1;
    L31:
        RadiusLayout r107 = this.f402971c;
        if (this.f402979k != OSheet.HeightMode.WRAP_HEIGHT) goto L34;
        r102 = true;
    L34:
        r107.setMeasureHeightUnspecified(r102);
        RadiusLayout r108 = this.f402971c;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if (r109 == null) goto L39;
        FrameLayout.LayoutParams r110 = (FrameLayout.LayoutParams) r109;
        r110.gravity = 81;
        r108.setLayoutParams(r110);
        return;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L27:
        ViewGroup.LayoutParams r111 = this.f402973e.getLayoutParams();
        if (r111 == null) goto L41;
        r111.height = -1;
        this.f402973e.setLayoutParams(r111);
        goto L30
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L5:
        if (r101 != 2) goto L31;
        RadiusLayout r112 = this.f402971c;
        Intrinsics.checkNotNullParameter(r112, "<this>");
        r112.getLayoutParams().height = -2;
        r112.requestLayout();
        if ((this.f402975g instanceof LinearLayout) == false) goto L14;
        ViewGroup.LayoutParams r113 = this.f402973e.getLayoutParams();
        if (r113 == null) goto L13;
        LinearLayout.LayoutParams r114 = (LinearLayout.LayoutParams) r113;
        r114.weight = 0.0f;
        r114.height = -2;
        this.f402973e.setLayoutParams(r114);
    L17:
        this.f402975g.getLayoutParams().height = -2;
        goto L31
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L14:
        ViewGroup.LayoutParams r115 = this.f402973e.getLayoutParams();
        if (r115 == null) goto L19;
        r115.height = -2;
        this.f402973e.setLayoutParams(r115);
        goto L17
    L19:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public final void f() {
        Resources r100 = this.f402969a.getResources();
        int r101 = WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).widthPixels;
        Context r102 = this.f402969a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (pla.e.a(r102) == false) goto L5;
        r101 = RangesKt.coerceAtMost(r101, pla.d.c(r102, 480));
    L5:
        RadiusLayout r103 = this.f402971c;
        Intrinsics.checkNotNullParameter(r103, "<this>");
        r103.getLayoutParams().width = r101;
        r103.requestLayout();
        float r104 = pla.d.e(this.f402969a, 36);
        this.f402971c.b(r104, r104, 0.0f, 0.0f);
        e();
    }

    public final void b(Size r100) {
        Intrinsics.checkNotNullParameter(r100, "fullWindowSize");
        d(r100);
        f();
        int r101 = SheetAnimStyle.f402960a;
        SheetAnimStyle.c(this.f402971c);
        a();
        this.f402971c.requestLayout();
    }

    public final void d(Size r100) {
        Intrinsics.checkNotNullParameter(r100, "fullWindowSize");
        if (r100.getWidth() <= r100.getHeight()) goto L5;
        this.f402977i = (int) (r100.getHeight() * 0.84f);
        return;
    L5:
        this.f402977i = (int) (r100.getHeight() * 0.93f);
    }

    public static void c(ViewGroup r100, View r101) {
        if (r101 == null) goto L12;
        if (r100 == null) goto L6;
        pla.j.f(r100);
    L6:
        if (r100 == null) goto L9;
        r100.removeAllViews();
    L9:
        if (r100 == null) goto L20;
        r100.addView(r101);
        return;
    L20:
        return;
    L12:
        if (r100 == null) goto L15;
        r100.removeAllViews();
    L15:
        if (r100 == null) goto L21;
        pla.j.e(r100);
        return;
    }

    public i(Context r100, OSheetBase r101, RadiusLayout r102, FrameLayout r103, FrameLayout r104, FrameLayout r105, ViewGroup r106, View r107) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, DocumentType.SHEET_NAME);
        Intrinsics.checkNotNullParameter(r102, "rootContainer");
        Intrinsics.checkNotNullParameter(r103, "headerContainer");
        Intrinsics.checkNotNullParameter(r104, "bodyContainer");
        Intrinsics.checkNotNullParameter(r105, "footerContainer");
        Intrinsics.checkNotNullParameter(r106, "scaffoldContainer");
        Intrinsics.checkNotNullParameter(r107, "dimView");
        this.f402969a = r100;
        this.f402970b = r101;
        this.f402971c = r102;
        this.f402972d = r103;
        this.f402973e = r104;
        this.f402974f = r105;
        this.f402975g = r106;
        this.f402976h = r107;
        this.f402979k = OSheet.HeightMode.WRAP_HEIGHT;
        this.f402981m = r102.getPaddingBottom();
    }
}
