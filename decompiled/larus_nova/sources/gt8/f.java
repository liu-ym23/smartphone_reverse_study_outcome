package gt8;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f implements d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f482614a;

    @Override // gt8.d.b
    public int getType() {
        return 1;
    }

    public f(d r100) {
        this.f482614a = r100;
    }

    @Override // gt8.d.b
    public final void a(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        d r101 = this.f482614a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = r100.getAction();
        if (r102 != 0) goto L5;
        r101.f482602g = new PointF(r100.getX(), r100.getY());
        return;
    L5:
        if (r102 != 1) goto L7;
        FLogger.f375446a.d("ActionHelper", "handleSingleTouchEvent ACTION_UP");
        if (r101.f482604i.a(r101.f482597b.a(), r101.f482598c) == true) goto L16;
        r101.f482599d.b();
        return;
    L16:
        return;
    L7:
        if (r102 != 2) goto L18;
        float r103 = r100.getX() - r101.f482602g.x;
        float r104 = r100.getY();
        PointF r105 = r101.f482602g;
        float r106 = r104 - r105.y;
        r105.set(r100.getX(), r100.getY());
        d.c r107 = r101.f482599d;
        z r108 = r101.f482597b;
        r108.f482678c.offset(r103, r106);
        r107.d(r108);
        return;
    }
}
