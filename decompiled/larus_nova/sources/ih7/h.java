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

/* JADX INFO: loaded from: classes3.dex */
public final class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f489890a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f489891b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f489892c = null;

    public h() {
    }

    @Override // ih7.a
    public final boolean d(Object[] r100, Map r101) {
        return false;
    }

    @Override // ih7.a
    public final String tag() {
        return "system_properties";
    }

    static {
        f489892c = new h();
        f489890a = CollectionsKt.listOf("aliyun_uuid");
        f489891b = CollectionsKt.listOf(new Integer[]{101604, 101605, 101606, 101607});
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489891b;
    }

    @Override // ih7.a
    public final Set<Map<String, ?>> b(Object[] r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        if (r100 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return r101;
    L14:
        Object r103 = r100[0];
        if ((r103 instanceof String) == true) goto L17;
        r103 = null;
    L17:
        String r104 = (String) r103;
        if (r104 != null) goto L20;
    L23:
        boolean r105 = true;
    L24:
        if (r105 == true) goto L26;
        r101.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("extra_parameter_key", r104)}));
    L26:
        return r101;
    L20:
        if (r104.length() == 0) goto L23;
        r105 = false;
        goto L24
    L5:
        if (r100.length != 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r106 = false;
        goto L8
    }

    @Override // ih7.a
    public final boolean c(Context r100, Map<String, ?> r101) {
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
    L12:
        return true;
    L11:
        if (CollectionsKt.contains(f489890a, r101.get("extra_parameter_key")) == false) goto L12;
        return false;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
