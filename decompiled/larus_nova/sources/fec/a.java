package fec;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.ss.android.lark.widget.richtext.utils.c;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C5890a f476634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f476635b;

    /* JADX INFO: renamed from: fec.a$a, reason: collision with other inner class name */
    public static class C5890a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f476636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f476637b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f476638c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f476639d;

        public C5890a(String r100, float r101, float r102, int r103) {
            this.f476636a = r100;
            this.f476637b = r101;
            this.f476638c = r102;
            this.f476639d = r103;
        }
    }

    public a(C5890a r100) {
        Paint r101 = c.f448389a;
        r101.reset();
        r101.setAntiAlias(true);
        this.f476635b = r101;
        this.f476634a = r100;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean r100) {
        C5890a r101 = this.f476634a;
        return (int) ((r101.f476637b + r101.f476638c) + 0.5f);
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas r100, Paint r101, int r102, int r103, int r104, int r105, int r106, CharSequence r107, int r108, int r110, boolean r111, Layout r112) {
        this.f476635b.reset();
        this.f476635b.set(r101);
        this.f476635b.setAntiAlias(true);
        if (((Spanned) r107).getSpanStart(this) != r108) goto L6;
        C5890a r109 = this.f476634a;
        float r113 = r109.f476637b - this.f476635b.measureText(r109.f476636a);
        this.f476635b.setColor(this.f476634a.f476639d);
        r100.drawText(this.f476634a.f476636a, r113, r105, this.f476635b);
        return;
    }
}
