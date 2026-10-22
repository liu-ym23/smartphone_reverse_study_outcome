package pd6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f528683a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<String, List<a>> f528684b = null;

    public d() {
    }

    static {
        f528683a = new d();
        f528684b = new HashMap();
    }

    @Override // pd6.b
    public final <T extends a> T a(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        HashMap<String, List<a>> r101 = f528684b;
        String r102 = r100.getQualifiedName();
        if (r102 != null) goto L7;
        r102 = r100.getSimpleName();
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        List<a> r103 = r101.get(r102);
        if (r103 == null) goto L10;
        a r104 = (a) CollectionsKt.first(r103);
    L12:
        if ((r104 instanceof a) == true) goto L14;
        return null;
    L14:
        return (T) r104;
    L10:
        r104 = null;
        goto L12
    }

    @Override // pd6.b
    public final <T extends a> List<T> b(KClass<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        HashMap<String, List<a>> r101 = f528684b;
        String r102 = r100.getQualifiedName();
        if (r102 != null) goto L7;
        r102 = r100.getSimpleName();
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        Collection r103 = r101.get(r102);
        if ((r103 instanceof List) == true) goto L12;
        return null;
    L12:
        return (List) r103;
    }

    @Override // pd6.b
    public final <T extends a> void c(KClass<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "impl");
        HashMap<String, List<a>> r102 = f528684b;
        String r103 = r100.getQualifiedName();
        if (r103 != null) goto L7;
        r103 = r100.getSimpleName();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        List<a> r104 = r102.get(r103);
        if (r104 != null) goto L10;
        r104 = new ArrayList();
        r102.put(r103, r104);
    L10:
        r104.add(r101);
    }
}
