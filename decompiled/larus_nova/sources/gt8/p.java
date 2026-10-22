package gt8;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p implements o.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f482666a;

    @Override // gt8.o.b
    public final void b() {
        o.b(this.f482666a);
    }

    public p(o r100) {
        this.f482666a = r100;
    }

    @Override // gt8.o.b
    public final void c(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "end");
        o.a(this.f482666a, r100);
    }

    @Override // gt8.o.b
    public final void a(float r100, float r101) {
        o r102 = this.f482666a;
        RectF r103 = r102.f482655q;
        float r104 = r103.top;
        if ((r101 - r104) > r102.D) goto L5;
        return;
    L5:
        if (r102.B == false) goto L9;
        float r105 = r103.right - ((r101 - r104) / r102.C);
        if (r105 < r102.f482640b.a().left) goto L10;
        RectF r106 = this.f482666a.f482655q;
        r106.left = r105;
        r106.bottom = r101;
    L10:
        this.f482666a.i();
        return;
    L9:
        r103.bottom = r101;
        goto L10
    }
}
