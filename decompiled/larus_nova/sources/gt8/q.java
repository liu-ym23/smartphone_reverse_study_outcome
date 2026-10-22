package gt8;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class q implements o.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f482667a;

    @Override // gt8.o.b
    public final void b() {
        o.b(this.f482667a);
    }

    public q(o r100) {
        this.f482667a = r100;
    }

    @Override // gt8.o.b
    public final void c(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "end");
        o.a(this.f482667a, r100);
    }

    @Override // gt8.o.b
    public final void a(float r100, float r101) {
        o r102 = this.f482667a;
        boolean r103 = true;
        boolean r104 = false;
        if (r102.B == false) goto L8;
        RectF r105 = r102.f482655q;
        float r106 = r105.right;
        if ((r106 - r100) <= o.G) goto L7;
        r105.left = r100;
        r105.bottom = (r102.C * (r106 - r100)) + r105.top;
    L15:
        if (r103 == false) goto L18;
        r102.i();
        return;
    L18:
        return;
    L7:
        r103 = false;
        goto L15
    L8:
        RectF r107 = r102.f482655q;
        float r108 = r107.right - r100;
        int r109 = o.G;
        if (r108 <= r109) goto L12;
        r107.left = r100;
        r104 = true;
    L12:
        if ((r101 - r107.top) <= r109) goto L14;
        r107.bottom = r101;
        goto L15
    L14:
        r103 = r104;
        goto L15
    }
}
