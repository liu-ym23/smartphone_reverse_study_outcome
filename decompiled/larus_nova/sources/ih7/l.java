package ih7;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f489900a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f489901b = null;

    public l() {
    }

    @Override // ih7.a
    public final boolean c(Context r100, Map<String, ?> r101) {
        return false;
    }

    @Override // ih7.a
    public final String tag() {
        return "permission_request";
    }

    static {
        f489901b = new l();
        f489900a = CollectionsKt.listOf(new Integer[]{102600, 102601});
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489900a;
    }

    @Override // ih7.a
    public final Set<Map<String, ?>> b(Object[] r110) {
        LinkedHashSet r100 = new LinkedHashSet();
        if (r110 != null) goto L5;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
    L30:
        return r100;
    L14:
        if (r110.length <= 1) goto L30;
        Object r102 = r110[0];
        Object r111 = r110[1];
        if (r102 == null) goto L30;
        if ((r102 instanceof Object[]) == false) goto L30;
        Object[] r103 = (Object[]) r102;
        if (r103.length <= 0) goto L30;
        int r104 = r103.length;
        int r105 = 0;
    L22:
        if (r105 >= r104) goto L30;
        Object r106 = r103[r105];
        if ((r106 instanceof String) == true) goto L26;
        r106 = null;
    L26:
        String r107 = (String) r106;
        if (r107 == null) goto L29;
        r100.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("extra_parameter_permissions", r107), TuplesKt.to("request_code", r111)}));
    L29:
        r105 = r105 + 1;
        goto L22
    L5:
        if (r110.length != 0) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == true) goto L11;
        r101 = false;
        goto L12
    L7:
        r108 = false;
        goto L8
    }

    @Override // ih7.a
    public final boolean d(Object[] r110, Map r111) {
        Object r112 = ((LinkedHashMap) r111).get("extra_parameter_permissions");
        if ((r112 instanceof String) == true) goto L5;
        r112 = null;
    L5:
        String r113 = (String) r112;
        int r100 = 0;
        if (r110 != null) goto L8;
    L14:
        boolean r101 = true;
    L15:
        if (r101 == true) goto L39;
        Object r114 = r110[0];
        if (r114 != null) goto L19;
        return false;
    L19:
        if ((r114 instanceof Object[]) == false) goto L41;
        Object[] r102 = (Object[]) r114;
        int r103 = r102.length;
        boolean r104 = false;
        int r105 = 0;
    L21:
        if (r100 >= r103) goto L33;
        Object r106 = r102[r100];
        int r107 = r105 + 1;
        if ((r106 instanceof String) == true) goto L25;
        r106 = null;
    L25:
        String r108 = (String) r106;
        if (TextUtils.isEmpty(r113) == true) goto L31;
        if (r108 == null) goto L31;
        if (r108.equals(r113) != true) goto L31;
        ((String[]) r114)[r105] = "";
        r104 = true;
    L31:
        r100 = r100 + 1;
        r105 = r107;
        goto L21
    L33:
        return r104;
    L41:
        return false;
    L39:
        return false;
    L8:
        if (r110.length != 0) goto L10;
        boolean r109 = true;
    L11:
        if (r109 == true) goto L14;
        r101 = false;
        goto L15
    L10:
        r109 = false;
        goto L11
    }
}
