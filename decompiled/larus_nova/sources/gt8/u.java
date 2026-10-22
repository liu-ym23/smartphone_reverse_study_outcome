package gt8;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class u implements o.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f482671a;

    @Override // gt8.o.b
    public final void b() {
        o.b(this.f482671a);
    }

    public u(o r100) {
        this.f482671a = r100;
    }

    @Override // gt8.o.b
    public final void c(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "end");
        o.a(this.f482671a, r100);
    }

    @Override // gt8.o.b
    public final void a(float r100, float r101) {
        o r102 = this.f482671a;
        RectF r103 = r102.f482655q;
        float r104 = r103.left;
        if ((r100 - r104) > o.G) goto L5;
        return;
    L5:
        if (r102.B == false) goto L7;
        r103.bottom = (r102.C * (r100 - r104)) + r103.top;
    L7:
        r103.right = r100;
        r102.i();
    }
}
