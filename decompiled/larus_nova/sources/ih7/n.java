package ih7;

import android.content.Context;
import android.hardware.Sensor;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f489904a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f489905b = null;

    public n() {
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
        return "reg_sensor";
    }

    static {
        f489905b = new n();
        f489904a = CollectionsKt.listOf(100700);
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489904a;
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
        int r103 = r100.length;
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L26;
        Object r105 = r100[r104];
        if ((r105 instanceof Sensor) == true) goto L19;
        r105 = null;
    L19:
        Sensor r106 = (Sensor) r105;
        if (r106 == null) goto L22;
        int r107 = r106.getType();
    L23:
        if (r107 <= 0) goto L25;
        r101.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("extra_parameter_type", Integer.valueOf(r107))}));
    L25:
        r104 = r104 + 1;
        goto L15
    L22:
        r107 = Integer.MIN_VALUE;
        goto L23
    L26:
        return r101;
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
