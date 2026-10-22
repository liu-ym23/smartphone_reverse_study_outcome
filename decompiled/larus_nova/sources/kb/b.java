package kb;

import com.bytedance.ies.bullet.core.r;
import com.bytedance.ies.bullet.core.s;
import kotlin.jvm.internal.Intrinsics;
import s26.d;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f502201a;

    public b(m16.b r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        Intrinsics.checkNotNullParameter(r101, "bid");
        d r102 = d.f540305c;
        e26.b r103 = (e26.b) d.f540305c.d(r101, e26.b.class);
        r r104 = null;
        if (r103 == null) goto L5;
        s r105 = r103.D(r100);
    L7:
        if ((r105 instanceof r) == false) goto L9;
        r104 = (r) r105;
    L9:
        this.f502201a = r104;
        return;
    L5:
        r105 = null;
        goto L7
    }
}
