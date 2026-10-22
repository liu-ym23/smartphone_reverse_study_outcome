package ih7;

import android.content.Context;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f489896a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f489897b = null;

    public j() {
    }

    @Override // ih7.a
    public final boolean d(Object[] r100, Map r101) {
        return false;
    }

    @Override // ih7.a
    public final String tag() {
        return "package_info";
    }

    static {
        f489897b = new j();
        f489896a = CollectionsKt.listOf(new Integer[]{101312, 101313});
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489896a;
    }

    @Override // ih7.a
    public final Set<Map<String, ?>> b(Object[] r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        if (r100 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L16;
        Object r103 = r100[0];
        if ((r103 instanceof String) == false) goto L16;
        r101.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("extra_parameter_package_name", r103)}));
    L16:
        return r101;
    L5:
        if (r100.length != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r104 = false;
        goto L8
    }

    @Override // ih7.a
    public final boolean c(Context r100, Map<String, ?> r101) {
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("extra_parameter_package_name");
    L7:
        if ((r103 instanceof String) == false) goto L10;
        r102 = r103;
    L10:
        String r104 = (String) r102;
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
    L20:
        return true;
    L19:
        if (Intrinsics.areEqual(r104, r100.getPackageName()) == true) goto L20;
        return false;
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
        goto L17
    L5:
        r103 = null;
        goto L7
    }
}
