package mh8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import fh8.h;
import fh8.i;
import fh8.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import usc.e;
import usc.f;

/* JADX INFO: loaded from: classes25.dex */
public final class d extends FrameLayout implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hk9.a f513975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f513976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f513977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f513978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f513979e;

    @Override // usc.f
    public final void a() {
    }

    @Override // usc.f
    public final View asView() {
        return this;
    }

    @Override // usc.f
    public final Size c(TextView r100, e r101, Map<String, ? extends Object> r102) {
        return null;
    }

    @Override // usc.f
    public final void e() {
    }

    @Override // usc.f
    public final void f() {
    }

    public final void g() {
        String r100 = this.f513976b;
        a r101 = this.f513977c;
        if (r100 == null) goto L23;
        if (r101 == null) goto L23;
        if (Intrinsics.areEqual(r101.f513969a, r100) == true) goto L12;
        hk9.a r102 = this.f513975a;
        if (r102 == null) goto L27;
        r102.a();
        return;
    L27:
        return;
    L12:
        List<jc8.a> r103 = r101.f513970b;
        if (r103.isEmpty() == false) goto L18;
        hk9.a r104 = this.f513975a;
        if (r104 == null) goto L28;
        r104.a();
        return;
    L28:
        return;
    L18:
        hk9.a r105 = this.f513975a;
        if (r105 != null) goto L21;
        int r106 = ra8.a.f536852a;
        r105 = ra8.a.a(getContext());
        this.f513975a = r105;
        r105.setClipChildren(false);
        r105.setClipToPadding(false);
        addView(r105, new FrameLayout.LayoutParams(-1, -2));
    L21:
        int r107 = RangesKt.coerceAtLeast(this.f513978d.f513972a, 0);
        int r108 = RangesKt.coerceAtLeast(this.f513978d.f513973b, 0);
        r105.setPaddingRelative(r107, r105.getPaddingTop(), r108, r105.getPaddingBottom());
        r105.b(kc8.b.class, r101.f513971c);
        r105.b(c.class, this.f513978d);
        int r109 = ra8.a.f536852a;
        ra8.a.e(r105, r103, false);
        return;
    L23:
        hk9.a r110 = this.f513975a;
        if (r110 == null) goto L29;
        r110.a();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        hk9.a r100 = this.f513975a;
        if (r100 == null) goto L5;
        int r101 = ra8.a.f536852a;
        ra8.a.c(r100);
    L5:
        this.f513975a = null;
        removeAllViews();
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f513975a != null) goto L6;
        g();
        return;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f513978d = new c(0);
        setClipChildren(false);
        setClipToPadding(false);
    }

    @Override // usc.f
    public final Integer b(Size r100, TextView r101, Canvas r102, Paint r103) {
        Intrinsics.checkNotNullParameter(r100, "widgetSize");
        Intrinsics.checkNotNullParameter(r101, "textView");
        Intrinsics.checkNotNullParameter(r102, "canvas");
        Intrinsics.checkNotNullParameter(r103, "paint");
        return Integer.valueOf(this.f513979e);
    }

    @Override // usc.f
    public final Size d(TextView r100, Spanned r101, e r102, int r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "span");
        this.f513976b = r102.k();
        fh8.f r105 = h.b(r104);
        a r106 = null;
        if (r105 == null) goto L16;
        j r107 = r105.f477088r;
        if (r107 == null) goto L16;
        List<i> r108 = r107.f477123a;
        if (r108 == null) goto L16;
        Iterator<T> r109 = r108.iterator();
    L10:
        if (r109.hasNext() == false) goto L14;
        Object r110 = r109.next();
        if (Intrinsics.areEqual(((i) r110).a(), r102.k()) == false) goto L10;
    L15:
        i r111 = (i) r110;
    L18:
        if ((r111 instanceof a) == false) goto L20;
        r106 = (a) r111;
    L20:
        this.f513977c = r106;
        int r112 = gw8.e.a(r101, r101.getSpanStart(r102)) + r100.getPaddingStart();
        int r113 = r100.getPaddingEnd();
        this.f513978d = new c(r112, r113, Integer.valueOf(RangesKt.coerceAtLeast(r103, 0)));
        this.f513979e = -r112;
        g();
        int r114 = RangesKt.coerceAtLeast((r103 + r112) + r113, 0);
        measure(View.MeasureSpec.makeMeasureSpec(r114, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return new Size(r114, getMeasuredHeight());
    L14:
        r110 = null;
    L16:
        r111 = null;
        goto L18
    }
}
