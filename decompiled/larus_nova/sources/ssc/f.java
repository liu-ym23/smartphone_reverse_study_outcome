package ssc;

import android.R;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import msc.s;

/* JADX INFO: loaded from: classes41.dex */
public final class f implements LeadingMarginSpan {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f543523d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f543524e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f543525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f543526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f543527c;

    static {
        f543523d = new int[]{R.attr.state_checked};
        f543524e = new int[0];
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        return this.f543525a.f515543c;
    }

    public f(s r100, Drawable r101, boolean r102) {
        this.f543525a = r100;
        this.f543526b = r101;
        this.f543527c = r102;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r110, int r111, boolean r112, Layout r113) {
        if (r112 == true) goto L4;
        return;
    L4:
        if (ftc.c.a(r110, r107, this) == false) goto L26;
        float r108 = r101.descent();
        float r109 = r101.ascent();
        int r114 = r100.save();
        int r115 = this.f543525a.f515543c;     // Catch: Throwable -> L20
        int r116 = (int) ((r108 - r109) + 0.5f);     // Catch: Throwable -> L20
        int r117 = (int) ((r115 * 0.75f) + 0.5f);     // Catch: Throwable -> L20
        int r118 = (int) ((r116 * 0.75f) + 0.5f);     // Catch: Throwable -> L20
        this.f543526b.setBounds(0, 0, r117, r118);     // Catch: Throwable -> L20
        if (this.f543526b.isStateful() == true) goto L10;
    L14:
        if (r103 <= 0) goto L16;
        int r119 = r102 + ((r115 - r117) / 2);     // Catch: Throwable -> L20
    L17:
        r100.translate(r119, ((int) ((r105 + r109) + 0.5f)) + ((r116 - r118) / 2));     // Catch: Throwable -> L20
        this.f543526b.draw(r100);     // Catch: Throwable -> L20
        r100.restoreToCount(r114);
        return;
    L16:
        r119 = (r102 - ((r115 - r117) / 2)) - r117;     // Catch: Throwable -> L20
        goto L17
    L10:
        if (this.f543527c == false) goto L12;
        int[] r120 = f543523d;     // Catch: Throwable -> L20
    L13:
        this.f543526b.setState(r120);     // Catch: Throwable -> L20
        goto L14
    L12:
        r120 = f543524e;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        r100.restoreToCount(r114);
        throw th;
    }
}
