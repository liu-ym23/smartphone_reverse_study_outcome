package ih7;

import android.content.Context;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f489909a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Integer> f489910b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p f489911c = null;

    public p() {
    }

    @Override // ih7.a
    public final boolean d(Object[] r100, Map r101) {
        return false;
    }

    @Override // ih7.a
    public final String tag() {
        return "system_settings";
    }

    static {
        f489911c = new p();
        f489909a = CollectionsKt.listOf(new String[]{"android_id", "pps_oaid"});
        f489910b = CollectionsKt.listOf(new Integer[]{102003, 102004, 102027});
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489910b;
    }

    @Override // ih7.a
    public final Set<Map<String, ?>> b(Object[] r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        if (r100 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L21;
        Object r103 = r100[1];
        Pair[] r104 = new Pair[1];
        if ((r103 instanceof String) == true) goto L16;
        r103 = null;
    L16:
        String r105 = (String) r103;
        if (r105 != null) goto L20;
        r105 = "";
    L20:
        r104[0] = TuplesKt.to("extra_parameter_key", r105);
        r101.add(MapsKt.hashMapOf(r104));
    L21:
        return r101;
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
        if (r101 == null) goto L4;
        Object r102 = r101.get("extra_parameter_key");
    L5:
        if (r102 == null) goto L16;
        String r103 = (String) r102;
        if (r103.length() != 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
    L13:
        return true;
    L12:
        if (f489909a.contains(r103) == false) goto L13;
        return false;
    L9:
        r104 = false;
        goto L10
    L16:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L4:
        r102 = null;
        goto L5
    }
}
