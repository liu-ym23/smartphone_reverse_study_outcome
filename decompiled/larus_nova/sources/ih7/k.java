package ih7;

import android.content.Context;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f489898a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f489899b = null;

    public k() {
    }

    @Override // ih7.a
    public final boolean d(Object[] r100, Map r101) {
        return false;
    }

    @Override // ih7.a
    public final String tag() {
        return "permission_check";
    }

    static {
        f489899b = new k();
        f489898a = CollectionsKt.listOf(new Integer[]{102607, 102608});
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489898a;
    }

    @Override // ih7.a
    public final Set<Map<String, ?>> b(Object[] r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = ArraysKt.firstOrNull(r100);
    L7:
        if ((r102 instanceof String) == false) goto L10;
        r101 = r102;
    L10:
        String r103 = (String) r101;
        if (r103 == null) goto L15;
        return SetsKt.mutableSetOf(new Map[]{MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra_parameter_permissions", r103)})});
    L15:
        return new LinkedHashSet();
    L5:
        r102 = null;
        goto L7
    }

    @Override // ih7.a
    public final boolean c(Context r100, Map<String, ?> r101) {
        if (r101 == null) goto L16;
        Object r102 = r101.get("extra_parameter_permissions");
        if (r102 != null) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r102, "android.permission.READ_PHONE_STATE") == false) goto L9;
    L14:
        return true;
    L9:
        if (Intrinsics.areEqual(r102, "android.permission.INTERNET") == true) goto L14;
        if (Intrinsics.areEqual(r102, "android.permission.ACCESS_WIFI_STATE") == true) goto L14;
        if (Intrinsics.areEqual(r102, "android.permission.ACCESS_NETWORK_STATE") == true) goto L14;
        return false;
    L16:
        return false;
    }
}
