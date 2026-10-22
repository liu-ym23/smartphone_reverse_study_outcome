package d97;

import a97.g;
import c97.h;
import com.bytedance.reparo.core.i;
import java.io.File;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final File f467632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f467633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f467634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f467635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f467636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f467637g;

    public d(h r100, com.bytedance.reparo.core.g r101, i r102) {
        this.f467637g = false;
        this.f467633c = r100;
        this.f467632b = r100.f22881a;
        this.f467636f = new g(this, r101, r102);
    }

    public static d a(h r100, com.bytedance.reparo.core.g r101, i r102, c97.a r103) {
        d r104 = new d(r100, r101, r102);
        if (r100.f22882b == false) goto L8;
        if (w87.b.f(r100.f22883c) == true) goto L8;
        r104.f467634d = new c(r100.f22883c, r104);
    L8:
        if (r100.f22884d == true) goto L10;
    L12:
        return r104;
    L10:
        if (w87.b.g(r100.f22886f) == false) goto L12;
        r104.f467635e = new e(r100.f22881a, r100.f22886f, r102, r103);
        goto L12
    }
}
