package qfc;

import android.graphics.PointF;
import android.graphics.RectF;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class b extends pfc.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f532779a;

    @Override // pfc.b.c
    public final void a() {
        a r100 = this.f532779a;
        r100.f532769k = true;
        ((x.a) r100.f532763e).f532846a.f532845b.f449172a = false;
    }

    @Override // pfc.b.c
    public final void b() {
        a r100 = this.f532779a;
        r100.f532769k = true;
        ((x.a) r100.f532763e).f532846a.f532845b.f449172a = false;
    }

    @Override // pfc.b.c
    public final void c() {
        Log.d("ActionHelper", "onLocationChangeStart" + this.f532779a.f532769k);
        this.f532779a.f532769k = false;
    }

    public b(a r100) {
        this.f532779a = r100;
    }

    @Override // pfc.b.c
    public final void d(RectF r100) {
        y r101 = this.f532779a.f532762d;
        if (r101.b() == false) goto L9;
        RectF r102 = r101.f532857d;
        if (r102 != null) goto L7;
        r101.f532857d = new RectF();
    L8:
        RectF r103 = r101.f532857d;
        r103.set(r100);
        com.ss.android.photoeditor.util.b.d(r103, 90, r101.f532857d.centerX(), r101.f532857d.centerY());
        r101.f532854a.set(r103);
    L10:
        PointF r104 = r101.f532856c;
        r104.x = r100.centerX();
        PointF r105 = r101.f532856c;
        r105.y = r100.centerY();
        y.a r106 = r101.f532858e;
        if (r106 == null) goto L13;
        ((j.a) r106).f532797a.f532796e = true;
    L13:
        a r107 = this.f532779a;
        a.e r108 = r107.f532763e;
        x.a r109 = (x.a) r108;
        r109.a(r107.f532762d);
        return;
    L7:
        r102.setEmpty();
        goto L8
    L9:
        r101.f532854a.set(r100);
        goto L10
    }
}
