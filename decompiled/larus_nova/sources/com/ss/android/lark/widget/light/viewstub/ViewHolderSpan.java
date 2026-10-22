package com.ss.android.lark.widget.light.viewstub;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import android.text.style.ReplacementSpan;
import android.view.View;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class ViewHolderSpan extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f446330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f446331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f446332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f446333d;

    public static final class a {
    }

    static {
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
    }

    public final View a() {
        return (View) this.f446333d.getValue();
    }

    public ViewHolderSpan(f r100, h r101) {
        Intrinsics.checkNotNullParameter(r100, "coordinator");
        Intrinsics.checkNotNullParameter(r101, "viewStubSpan");
        this.f446330a = r100;
        this.f446331b = r101;
        this.f446333d = LazyKt.lazy(new ViewHolderSpan$targetView$2(this));
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r110) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        if ((r101 instanceof Spanned) == true) goto L5;
        return 0;
    L5:
        View r104 = a();
    L7:
        if (r102 < 0) goto L11;
        if (((Spanned) r101).charAt(r102) == '\n') goto L11;
        r102 = r102 - 1;
    L11:
        int r105 = r102 + 1;
    L12:
        Spanned r106 = (Spanned) r101;
        if (r103 >= r106.length()) goto L17;
        if (r106.charAt(r103) == '\n') goto L17;
        r103 = r103 + 1;
    L17:
        LeadingMarginSpan[] r107 = (LeadingMarginSpan[]) r106.getSpans(r105, r103, LeadingMarginSpan.class);
        int r108 = r107.length;
        int r109 = 0;
        int r111 = 0;
    L18:
        if (r109 >= r108) goto L20;
        r111 = r111 + r107[r109].getLeadingMargin(false);
        r109 = r109 + 1;
        goto L18
    L20:
        this.f446330a.b(r104, r111);
        if (this.f446332c == false) goto L23;
    L25:
        if (r110 == null) goto L27;
        int r112 = r104.getMeasuredHeight();
        int r113 = r110.bottom;
        r110.descent = r113;
        int r114 = r113 - r112;
        r110.top = r114;
        r110.ascent = r114;
    L27:
        this.f446332c = true;
        return r104.getMeasuredWidth();
    L23:
        if (r104.isLayoutRequested() == false) goto L25;
        r104.layout(0, 0, r104.getMeasuredWidth(), r104.getMeasuredHeight());
        goto L25
    }
}
