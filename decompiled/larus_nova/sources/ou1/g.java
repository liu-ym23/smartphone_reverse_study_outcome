package ou1;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import ju1.h;
import ju1.n;
import ju1.o;
import ju1.p;
import ju1.q;
import ju1.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g implements nu1.f<q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nu1.b f526723a;

    public static final class a {
    }

    static {
    }

    public g() {
        nu1.a r100 = nu1.a.f520601a;
        Intrinsics.checkNotNullParameter(r100, "expressionExecutor");
        this.f526723a = r100;
    }

    @Override // nu1.f
    public final n a(h r100, Map r110) {
        q r101 = (q) r100;
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r110, "stateMap");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.j().iterator();
        float r104 = 0.0f;
        float r105 = 0.0f;
    L4:
        if (r103.hasNext() == false) goto L9;
        o r106 = (o) r103.next();
        if (Intrinsics.areEqual(this.f526723a.a(r106.a(), r110), Boolean.TRUE) == false) goto L4;
        r105 = r105 + (r106.b() * r106.c());
        r104 = r104 + r106.c();
        r102.add(r106);
        goto L4
    L9:
        if (r102.isEmpty() == true) goto L31;
        if (r104 <= 0) goto L31;
        float r107 = r105 / r104;
        Iterator<T> r108 = r101.k().iterator();
    L15:
        if (r108.hasNext() == false) goto L22;
        Object r109 = r108.next();
        if (r107 < ((p) r109).b()) goto L19;
        boolean r111 = true;
    L20:
        if (r111 == false) goto L15;
    L23:
        p r112 = (p) r109;
        if (r112 == null) goto L26;
        Integer r113 = Integer.valueOf(r112.a());
    L27:
        if (r113 != null) goto L43;
        return new r(r101.g(), true, r110, null);
    L43:
        return new r(r113.intValue(), false, r110, r102);
    L26:
        r113 = null;
        goto L27
    L19:
        r111 = false;
        goto L20
    L22:
        r109 = null;
    L31:
        return new r(r101.g(), true, r110, null);
    }
}
