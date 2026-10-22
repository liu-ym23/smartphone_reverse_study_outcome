package ig4;

import android.graphics.RectF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends c {
    @Override // ig4.c
    public final float c(int r100) {
        return 0.0f;
    }

    public b() {
    }

    @Override // ig4.c
    public final ArrayList<Float> e(float r100) {
        ListProtector.set(this.f489731c, 0, Float.valueOf(r100 + this.f489732d));
        ArrayList<Float> r101 = this.f489731c;
        ListProtector.set(r101, 1, Float.valueOf((((Number) ListProtector.get(r101, 0)).floatValue() + this.f489732d) + this.f489733e));
        ArrayList<Float> r102 = this.f489731c;
        ListProtector.set(r102, 2, Float.valueOf((((Number) ListProtector.get(r102, 1)).floatValue() + this.f489732d) + this.f489733e));
        return this.f489731c;
    }

    @Override // ig4.c
    public final void a(RectF r100, int r101, int r102, float r103, float r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "dynamicRectF");
        if (r105 == false) goto L5;
        r100.set(r104, 0.0f, r102, r101);
        return;
    L5:
        r100.set(0.0f, 0.0f, r104, r101);
    }
}
