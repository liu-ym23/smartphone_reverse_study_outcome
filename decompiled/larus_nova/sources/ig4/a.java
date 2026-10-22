package ig4;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends c {
    @Override // ig4.c
    public final float c(int r100) {
        return r100 / 2.0f;
    }

    public a() {
    }

    @Override // ig4.c
    public final void a(RectF r100, int r101, int r102, float r103, float r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "dynamicRectF");
        float r106 = r102;
        float r107 = ((r106 - r103) / 2.0f) + r104;
        if (r105 == false) goto L5;
        r100.set(r107, 0.0f, r106, (r101 / 2) + 5);
        return;
    L5:
        r100.set(0.0f, 0.0f, r107, r101);
    }
}
