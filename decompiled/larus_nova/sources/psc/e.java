package psc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class e extends DynamicDrawableSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f530601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f530602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f530603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f530604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f530605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f530606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<Drawable> f530607g;

    @Override // android.text.style.DynamicDrawableSpan
    public final Drawable getDrawable() {
        Drawable r100 = ContextCompat.getDrawable(this.f530601a, this.f530602b);
        if (r100 == null) goto L5;
        r100.setBounds(0, 0, r100.getIntrinsicWidth(), r100.getIntrinsicHeight());
        return r100;
    L5:
        return null;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        WeakReference<Drawable> r105 = this.f530607g;
        if (r105 == null) goto L5;
        Drawable r106 = r105.get();
    L6:
        if (r106 != null) goto L9;
        r106 = getDrawable();
        this.f530607g = new WeakReference(r106);
    L9:
        if (r106 != null) goto L11;
        return 0;
    L11:
        Rect r107 = r106.getBounds();
        if (r104 == null) goto L15;
        int r108 = -r107.bottom;
        r104.ascent = r108;
        r104.descent = 0;
        r104.top = r108;
        r104.bottom = 0;
    L15:
        return (r107.right + this.f530604d) + this.f530605e;
    L5:
        r106 = null;
        goto L6
    }

    public e(Context r100, int r101, int r102, int r103, int r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(1);
        this.f530601a = r100;
        this.f530602b = r101;
        this.f530603c = r102;
        this.f530604d = r103;
        this.f530605e = r104;
        this.f530606f = r105;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        WeakReference<Drawable> r109 = this.f530607g;
        if (r109 == null) goto L5;
        Drawable r110 = r109.get();
    L6:
        if (r110 != null) goto L8;
        r110 = getDrawable();
        this.f530607g = new WeakReference(r110);
    L8:
        if (r110 != null) goto L10;
        return;
    L10:
        r100.save();
        int r111 = r107 - r110.getBounds().bottom;
        int r112 = ((DynamicDrawableSpan) this).mVerticalAlignment;
        if (r112 != 1) goto L14;
        r111 = r111 - r108.getFontMetricsInt().descent;
    L16:
        r100.translate(r104 + this.f530605e, r111 - this.f530603c);
        if (this.f530606f == false) goto L19;
        int r113 = 255;
    L20:
        r110.setAlpha(r113);
        r110.draw(r100);
        r100.restore();
        return;
    L19:
        r113 = 127;
        goto L20
    L14:
        if (r112 != 2) goto L16;
        r111 = (r105 + ((r107 - r105) / 2)) - (r110.getBounds().height() / 2);
        goto L16
    L5:
        r110 = null;
        goto L6
    }
}
