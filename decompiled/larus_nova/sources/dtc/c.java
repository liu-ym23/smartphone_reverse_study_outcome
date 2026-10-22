package dtc;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements LineHeightSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f470021a;

    public c(int r100) {
        this.f470021a = r100;
        if (r100 <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(("Height: %d must be positive" + r100).toString());
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r105, "fm");
        int r106 = r105.descent;
        int r107 = r106 - r105.ascent;
        if (r107 > 0) goto L5;
        return;
    L5:
        int r108 = Math.round(r106 * ((this.f470021a * 1.0f) / r107));
        r105.descent = r108;
        r105.ascent = r108 - this.f470021a;
    }
}
