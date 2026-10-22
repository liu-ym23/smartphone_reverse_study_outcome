package kq8;

import com.larus.bmhome.interactionpanel.m;
import com.larus.bmhome.interactionpanel.n;
import com.larus.bmhome.interactionpanel.v;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jq8.a f505610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Long> f505611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<n, z0<v>> f505612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateFlowImpl f505613d;

    public a(jq8.a r100, Function0<Long> r101) {
        Intrinsics.checkNotNullParameter(r100, "projection");
        Intrinsics.checkNotNullParameter(r101, "clock");
        this.f505610a = r100;
        this.f505611b = r101;
        this.f505612c = new LinkedHashMap();
        this.f505613d = j1.a(CollectionsKt.emptyList());
    }

    public final i1<v> a(n r100, List<m> r101) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "entries");
        LinkedHashMap r102 = (LinkedHashMap) this.f505612c;
        Object r103 = r102.get(r100);
        if (r103 != null) goto L6;
        jq8.a r104 = this.f505610a;
        long r105 = this.f505611b.invoke().longValue();
        r104.getClass();
        r103 = j1.a(jq8.a.a(r100, r101, r105));
        r102.put(r100, r103);
    L6:
        return (i1) r103;
    }
}
