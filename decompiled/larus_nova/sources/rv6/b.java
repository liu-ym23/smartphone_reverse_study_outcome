package rv6;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends a {
    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline r100) {
        Intrinsics.checkNotNullParameter(r100, "outline");
        b();
        r100.setRoundRect(this.f539498h, this.f539497g);
    }

    public b(Resources r100, Bitmap r101) {
        super(r100, r101);
    }

    @Override // rv6.a
    public final void a(int r100, int r101, int r110, Rect r111, Rect r112) {
        Intrinsics.checkNotNullParameter(r111, "bounds");
        Intrinsics.checkNotNullParameter(r112, "outRect");
        Gravity.apply(r100, r101, r110, r111, r112, 0);
    }
}
