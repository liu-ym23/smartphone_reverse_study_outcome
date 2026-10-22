package ou1;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Iterator;
import java.util.Map;
import ju1.h;
import ju1.i;
import ju1.j;
import ju1.k;
import ju1.n;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements nu1.f<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nu1.b f526722a;

    public static final class a {
    }

    static {
    }

    public e() {
        nu1.a r100 = nu1.a.f520601a;
        Intrinsics.checkNotNullParameter(r100, "expressionExecutor");
        this.f526722a = r100;
    }

    @Override // nu1.f
    public final n a(h r100, Map r101) {
        j r102 = (j) r100;
        Intrinsics.checkNotNullParameter(r102, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r101, "stateMap");
        CollectionsKt.sortedWith(r102.j(), new f());
        Iterator<T> r103 = r102.j().iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        i r104 = (i) r103.next();
        if (Intrinsics.areEqual(this.f526722a.a(r104.b(), r101), Boolean.TRUE) == false) goto L4;
        return new k(r104.a(), false);
    L9:
        return new k(r102.g(), true);
    }
}
