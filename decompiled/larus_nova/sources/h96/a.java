package h96;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, b> f484323a = null;

    static {
        f484323a = new ConcurrentHashMap();
    }

    public static b a(String r100) {
        ConcurrentHashMap<String, b> r101 = f484323a;
        b r102 = r101.get(r100);
        int r103 = f96.a.f475971a;
        f96.a.e("getService", MapsKt.mapOf(new Pair[]{TuplesKt.to("map", r101.toString()), TuplesKt.to("bid", r100), TuplesKt.to("bidService", String.valueOf(r102))}));
        return r102;
    }
}
