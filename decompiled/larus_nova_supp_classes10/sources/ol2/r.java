package ol2;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r extends ViewOutlineProvider {
    public float a;
    public final int b;
    public final int c;

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View r4, Outline r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Intrinsics.checkNotNullParameter(r5, "outline");
        r5.setRoundRect(new Rect(0, 0, this.b, this.c), this.a);
    }

    public r(float r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
