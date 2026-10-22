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
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f489906a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f489907b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f489908c = null;

    public o() {
    }

    @Override // ih7.a
    public final boolean d(Object[] r100, Map r101) {
        return false;
    }

    @Override // ih7.a
    public final String tag() {
        return "runtime_exec";
    }

    static {
        f489908c = new o();
        f489906a = CollectionsKt.listOf(102900);
        f489907b = CollectionsKt.listOf(new String[]{"pm list package", "pm list packages", "cat /proc/net/arp", "ifconfig"});
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489906a;
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
        if ((r103 instanceof String) == false) goto L18;
        r101.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("extra_parameter_cmd", r103)}));
    L33:
        return r101;
    L18:
        if ((r103 instanceof Object[]) == false) goto L33;
        Object[] r104 = (Object[]) r103;
        int r105 = r104.length;
        int r106 = 0;
    L20:
        if (r106 >= r105) goto L33;
        Object r107 = r104[r106];
        if ((r107 instanceof String) == false) goto L32;
        String r108 = StringsKt.trim((String) r107).toString();
        if (r108 != null) goto L26;
    L29:
        boolean r109 = true;
    L30:
        if (r109 == true) goto L32;
        r101.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("extra_parameter_cmd", r108)}));
        goto L32
    L26:
        if (r108.length() == 0) goto L29;
        r109 = false;
    L32:
        r106 = r106 + 1;
        goto L20
    L5:
        if (r100.length != 0) goto L7;
        boolean r110 = true;
    L8:
        if (r110 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r110 = false;
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
        if (CollectionsKt.contains(f489907b, r101.get("extra_parameter_cmd")) == false) goto L12;
        return false;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
