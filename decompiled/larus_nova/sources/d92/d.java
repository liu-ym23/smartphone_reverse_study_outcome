package d92;

import com.bytedance.android.live.core.utils.s1;
import kotlin.jvm.internal.Intrinsics;
import z82.g;
import z82.h;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements c92.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f467619a;

    public d() {
        new b92.b();
        this.f467619a = s1.f(134.0f);
    }

    @Override // c92.a
    public final z82.b a(a92.a r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        int r101 = r100.f2267a;
        Integer r102 = h.a(r101, r100.a());
        if (r102 == null) goto L17;
        int r103 = r102.intValue();
        int r104 = this.f467619a;
        g r105 = r100.f2271e;
        if (r100.f2269c == true) goto L7;
        r105.getClass();
    L10:
        int r106 = 0;
    L11:
        int r107 = r104 + r106;
        if (r100.f2272f == null) goto L14;
        int r108 = z82.a.a();
    L16:
        return new z82.b(r101, r103, r107 + r108, 0);
    L14:
        r108 = 0;
        goto L16
    L7:
        if (r105.f570909a == false) goto L10;
        r106 = r105.f570910b;
        goto L11
    L17:
        return null;
    }
}
