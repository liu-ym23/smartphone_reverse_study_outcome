package op3;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Pair<d, d>, Integer> f524712a;

    public h() {
        d r100 = g.f524703a;
        d r101 = g.f524703a;
        d r102 = g.f524705c;
        d r103 = g.f524706d;
        d r104 = g.f524707e;
        d r105 = g.f524708f;
        d r106 = g.f524709g;
        d r107 = g.f524710h;
        d r108 = g.f524711i;
        d r109 = g.f524704b;
        this.f524712a = MapsKt.mapOf(new Pair[]{TuplesKt.to(TuplesKt.to(r101, r102), 0), TuplesKt.to(TuplesKt.to(r102, r103), 6), TuplesKt.to(TuplesKt.to(r102, r104), 6), TuplesKt.to(TuplesKt.to(r102, r105), 6), TuplesKt.to(TuplesKt.to(r103, r105), 4), TuplesKt.to(TuplesKt.to(r104, r105), 4), TuplesKt.to(TuplesKt.to(r105, r106), 3), TuplesKt.to(TuplesKt.to(r105, r107), 4), TuplesKt.to(TuplesKt.to(r106, r107), 3), TuplesKt.to(TuplesKt.to(r107, r108), 4), TuplesKt.to(TuplesKt.to(r108, r109), 6), TuplesKt.to(TuplesKt.to(r107, r109), 6)});
    }

    @Override // op3.e
    public final int a(d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r101, RemoteMessageConst.TO);
        Integer r102 = this.f524712a.get(TuplesKt.to(r100, r101));
        if (r102 != null) goto L7;
        return 0;
    L7:
        return r102.intValue();
    }
}
