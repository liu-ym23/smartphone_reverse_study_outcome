package ig4;

import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.android.livesdk.utils.t6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f489734g;

    @Override // ig4.c
    public final float c(int r100) {
        return r100;
    }

    public d() {
    }

    @Override // ig4.c
    public final float d(int r100, int r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r102, "lyricsRect");
        return (r102.height() - r101) + t6.a(jc1.a.b(), 4.0f);
    }

    @Override // ig4.c
    public final void a(RectF r100, int r101, int r102, float r103, float r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "dynamicRectF");
        float r106 = r102;
        if ((this.f489734g % 2) != 0) goto L5;
        r100.set(0.0f, 0.0f, r104, r101 / 2.0f);
        return;
    L5:
        float r107 = r106 - r103;
        float r108 = r101;
        r100.set(r107, r108 / 2.0f, r104 + r107, r108);
    }
}
