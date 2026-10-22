package n0;

import android.graphics.PointF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements m<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<v0.a<PointF>> f516551a;

    @Override // n0.m
    public final j0.a<PointF, PointF> a() {
        boolean r100 = false;
        if (((v0.a) ListProtector.get(this.f516551a, 0)).f552277d != null) goto L5;
        r100 = true;
    L5:
        if (r100 == false) goto L9;
        return new j0.j(this.f516551a);
    L9:
        return new j0.i(this.f516551a);
    }

    public e() {
        this.f516551a = Collections.singletonList(new v0.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<v0.a<PointF>> r100) {
        this.f516551a = r100;
    }
}
