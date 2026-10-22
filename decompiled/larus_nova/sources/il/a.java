package il;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Set<String>> f490296a;

    public a() {
        this.f490296a = new LinkedHashMap();
    }

    public static void a(a r100) {
        ((LinkedHashMap) r100.f490296a).clear();
    }

    public final boolean b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "id");
        Set r102 = (Set) ((LinkedHashMap) this.f490296a).get(r100);
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.contains(r101);
    }

    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "id");
        Set r102 = (Set) ((LinkedHashMap) this.f490296a).get(r100);
        if (r102 == null) goto L5;
        r102.add(r101);
        return;
    L5:
        this.f490296a.put(r100, SetsKt.mutableSetOf(new String[]{r101}));
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "id");
        Set r102 = (Set) ((LinkedHashMap) this.f490296a).get(r100);
        if (r102 == null) goto L6;
        r102.remove(r101);
        return;
    }

    public final void c(String r100, String r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "action");
        if (b(r100, r101) == true) goto L6;
        r102.invoke();
        d(r100, r101);
        return;
    }
}
