package dtc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.LineBackgroundSpan;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements LineBackgroundSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f470020a;

    public b(int r100) {
        this.f470020a = r100;
    }

    @Override // android.text.style.LineBackgroundSpan
    public final void drawBackground(Canvas r100, Paint r110, int r111, int r112, int r113, int r114, int r115, CharSequence r116, int r117, int r118, int r119) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Intrinsics.checkNotNullParameter(r110, "paint");
        Intrinsics.checkNotNullParameter(r116, "text");
        int r101 = r110.getColor();
        r110.setColor(this.f470020a);
        r100.drawRect(r111, r113, r112, r115, r110);
        r110.setColor(r101);
    }
}
