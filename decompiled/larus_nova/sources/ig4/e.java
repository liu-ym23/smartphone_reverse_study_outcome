package ig4;

import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f489735g;

    @Override // ig4.c
    public final float c(int r100) {
        return r100;
    }

    public e() {
        this.f489735g = t6.a(jc1.a.b(), 4.0f);
    }

    @Override // ig4.c
    public final ArrayList<Float> e(float r100) {
        Collections.fill(this.f489731c, Float.valueOf(r100 - this.f489733e));
        int r101 = this.f489731c.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L6;
        ArrayList<Float> r103 = this.f489731c;
        int r104 = (r103.size() - r102) - 1;
        ListProtector.set(r103, r104, Float.valueOf(((Float) ListProtector.get(r103, r104)).floatValue() - (r102 * ((this.f489732d * 2) + this.f489733e))));
        r102 = r102 + 1;
        goto L3
    L6:
        return this.f489731c;
    }

    @Override // ig4.c
    public final float d(int r100, int r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r102, "lyricsRect");
        return (r102.height() - r101) + this.f489735g;
    }

    @Override // ig4.c
    public final void a(RectF r100, int r101, int r102, float r103, float r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "dynamicRectF");
        float r106 = r102;
        float r107 = r106 - (r103 - r104);
        if (r105 == false) goto L5;
        r100.set(r107, 0.0f, r106, r101);
        return;
    L5:
        r100.set(0.0f, 0.0f, r107, r101);
    }
}
