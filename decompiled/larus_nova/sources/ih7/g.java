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
public final class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f489888a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f489889b = null;

    public g() {
    }

    @Override // ih7.a
    public final boolean c(Context r100, Map<String, ?> r101) {
        return false;
    }

    @Override // ih7.a
    public final boolean d(Object[] r100, Map r101) {
        return false;
    }

    @Override // ih7.a
    public final String tag() {
        return "get_sensor";
    }

    static {
        f489889b = new g();
        f489888a = CollectionsKt.listOf(new Integer[]{100703, 100702});
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489888a;
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
        if ((r103 instanceof Integer) == true) goto L17;
        r103 = null;
    L17:
        Integer r104 = (Integer) r103;
        if (r104 == null) goto L20;
        int r105 = r104.intValue();
    L21:
        if (r105 > 0) goto L23;
        return r101;
    L23:
        r101.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("extra_parameter_type", Integer.valueOf(r105))}));
        return r101;
    L20:
        r105 = Integer.MIN_VALUE;
        goto L21
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
}
