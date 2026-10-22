package rz6;

import android.graphics.PointF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class e implements m<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<xz6.a<PointF>> f539963a;

    @Override // rz6.m
    public final oz6.a<PointF, PointF> a() {
        boolean r100 = false;
        if (((xz6.a) ListProtector.get(this.f539963a, 0)).f565529d != null) goto L5;
        r100 = true;
    L5:
        if (r100 == false) goto L9;
        return new oz6.j(this.f539963a);
    L9:
        return new oz6.i(this.f539963a);
    }

    public e() {
        this.f539963a = Collections.singletonList(new xz6.a(new PointF(0.0f, 0.0f)));
    }

    public e(List<xz6.a<PointF>> r100) {
        this.f539963a = r100;
    }
}
