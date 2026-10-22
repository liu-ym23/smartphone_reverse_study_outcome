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
public final class q implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f489912a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f489913b = null;

    public q() {
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
        return "tele_listen";
    }

    static {
        f489913b = new q();
        f489912a = CollectionsKt.listOf(100913);
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489912a;
    }

    @Override // ih7.a
    public final Set<Map<String, ?>> b(Object[] r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        if (r100 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
    L25:
        return r101;
    L14:
        if (r100.length < 2) goto L25;
        Object r103 = r100[1];
        if ((r103 instanceof Integer) == true) goto L18;
        r103 = null;
    L18:
        Integer r104 = (Integer) r103;
        if (r104 == null) goto L25;
        Pair[] r105 = new Pair[1];
        Integer r106 = Integer.valueOf(r104.intValue());
        if (r106 == null) goto L23;
        int r107 = r106.intValue();
    L24:
        r105[0] = TuplesKt.to("extra_parameter_events", Integer.valueOf(r107));
        r101.add(MapsKt.hashMapOf(r105));
        goto L25
    L23:
        r107 = -1;
        goto L24
    L5:
        if (r100.length != 0) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r108 = false;
        goto L8
    }
}
