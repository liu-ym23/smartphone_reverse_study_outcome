package ya9;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class b extends ReplacementSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f567029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f567030b;

    public b(Drawable r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable");
        this.f567029a = r100;
        this.f567030b = r101;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint r100, CharSequence r101, int r102, int r103, Paint.FontMetricsInt r104) {
        Intrinsics.checkNotNullParameter(r100, "paint");
        return this.f567029a.getBounds().right + this.f567030b;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas r100, CharSequence r101, int r102, int r103, float r104, int r105, int r106, int r107, Paint r108) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r108, "paint");
        int r109 = r105 + (((r107 - r105) - this.f567029a.getBounds().height()) / 2);
        r100.save();
        r100.translate(r104, r109);
        this.f567029a.draw(r100);
        r100.restore();
    }
}
