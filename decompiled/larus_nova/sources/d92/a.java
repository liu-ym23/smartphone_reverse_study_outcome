package d92;

import com.bytedance.android.livesdk.config.qf0;
import kotlin.jvm.internal.Intrinsics;
import z82.g;
import z82.h;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements c92.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Float f467617a;

    public a() {
        new b92.b();
        this.f467617a = qf0.f121051a.getValue();
    }

    @Override // c92.a
    public final z82.b a(a92.a r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        int r101 = (int) ((r100.f2268b * 9.0f) / 16.0f);
        Integer r102 = h.a(r101, r100.a());
        if (r102 == null) goto L15;
        int r103 = r102.intValue();
        int r104 = (int) (this.f467617a.floatValue() * ((int) (r101 / 0.5625f)));
        g r105 = r100.f2271e;
        int r106 = 0;
        if (r100.f2269c == true) goto L7;
        r105.getClass();
    L10:
        int r107 = 0;
    L11:
        int r108 = r104 + r107;
        if (r100.f2272f == null) goto L17;
        r106 = z82.a.a();
    L17:
        return new z82.b(r101, r103, r108 + r106, (int) ((r100.f2267a - r101) / 2.0f));
    L7:
        if (r105.f570909a == false) goto L10;
        r107 = r105.f570910b;
        goto L11
    L15:
        return null;
    }
}
