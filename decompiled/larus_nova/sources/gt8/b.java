package gt8;

import android.graphics.PointF;
import android.graphics.RectF;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends j.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f482588a;

    @Override // gt8.j.b
    public final void a() {
        d r100 = this.f482588a;
        r100.f482606k = true;
        r100.f482599d.e();
    }

    @Override // gt8.j.b
    public final void b() {
        d r100 = this.f482588a;
        r100.f482606k = true;
        r100.f482599d.b();
    }

    @Override // gt8.j.b
    public final void c() {
        FLogger.f375446a.d("ActionHelper", "onLocationChangeStart: " + this.f482588a.f482606k);
        this.f482588a.f482606k = false;
    }

    public b(d r100) {
        this.f482588a = r100;
    }

    @Override // gt8.j.b
    public final void d(RectF r100) {
        d r101 = this.f482588a;
        z r102 = r101.f482597b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        if (r102.b() == false) goto L5;
        r102.f482679d.set(r100);
        int r103 = ht8.a.f487145a;
        RectF r104 = r102.f482679d;
        ht8.a.c(r104, 90, r104.centerX(), r102.f482679d.centerY());
        r102.f482676a.set(r102.f482679d);
    L6:
        PointF r105 = r102.f482678c;
        r105.x = r100.centerX();
        PointF r106 = r102.f482678c;
        r106.y = r100.centerY();
        z.a r107 = r102.f482680e;
        if (r107 == null) goto L9;
        Intrinsics.checkNotNull(r107);
        r107.a();
    L9:
        r101.f482599d.d(r101.f482597b);
        return;
    L5:
        r102.f482676a.set(r100);
        goto L6
    }
}
