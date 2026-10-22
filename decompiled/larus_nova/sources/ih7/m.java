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
public final class m implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f489902a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f489903b = null;

    public m() {
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
        return "permission_result";
    }

    static {
        f489903b = new m();
        f489902a = CollectionsKt.listOf(new Integer[]{102611, 102612});
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489902a;
    }

    @Override // ih7.a
    public final Set<Map<String, ?>> b(Object[] r110) {
        LinkedHashSet r100 = new LinkedHashSet();
        if (r110 != null) goto L5;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
    L32:
        return r100;
    L14:
        if (r110.length <= 2) goto L32;
        Object r102 = r110[1];
        Object r111 = r110[2];
        if (r102 == null) goto L32;
        if ((r102 instanceof Object[]) == false) goto L32;
        Object[] r103 = (Object[]) r102;
        if (r103.length <= 0) goto L32;
        if ((r111 instanceof int[]) == false) goto L32;
        int r104 = r103.length;
        int r105 = 0;
        int r106 = 0;
    L24:
        if (r105 >= r104) goto L32;
        Object r107 = r103[r105];
        int r108 = r106 + 1;
        if ((r107 instanceof String) == true) goto L28;
        r107 = null;
    L28:
        String r109 = (String) r107;
        if (r109 == null) goto L31;
        r100.add(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("extra_parameter_permissions", r109), TuplesKt.to("extra_parameter_result", Integer.valueOf(((int[]) r111)[r106]))}));
    L31:
        r105 = r105 + 1;
        r106 = r108;
        goto L24
    L5:
        if (r110.length != 0) goto L7;
        boolean r112 = true;
    L8:
        if (r112 == true) goto L11;
        r101 = false;
        goto L12
    L7:
        r112 = false;
        goto L8
    }
}
