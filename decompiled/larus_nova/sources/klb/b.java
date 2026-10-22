package klb;

import android.graphics.Paint;
import android.text.Spanned;
import android.text.style.LineHeightSpan;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f504027a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f504028a;

        public a() {
        }
    }

    public b(a r100) {
        this.f504027a = r100;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        int r106 = ((Spanned) r100).getSpanEnd(this);
        boolean r107 = true;
        if (r106 != r102) goto L5;
    L8:
        if (r107 == false) goto L11;
        int r108 = r105.bottom;
        int r109 = (int) (((double) (this.f504027a.f504028a - (r108 - r105.top))) + 0.5d);
        r105.descent += r109;
        r105.bottom = r108 + r109;
        return;
    L11:
        return;
    L5:
        if (r106 == (r102 - 1)) goto L8;
        r107 = false;
        goto L8
    }
}
