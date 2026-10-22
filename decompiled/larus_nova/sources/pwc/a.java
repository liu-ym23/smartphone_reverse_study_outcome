package pwc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes42.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<KClass<?>, String> f530858a = null;

    static {
        f530858a = new ConcurrentHashMap();
    }

    public static final String a(KClass<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<KClass<?>, String> r101 = f530858a;
        String r102 = (String) ((ConcurrentHashMap) r101).get(r100);
        if (r102 != null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r103 = JvmClassMappingKt.getJavaClass(r100).getName();
        ((ConcurrentHashMap) r101).put(r100, r103);
        return r103;
    L6:
        return r102;
    }
}
