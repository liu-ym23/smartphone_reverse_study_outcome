package x26;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import s26.d;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<Class<?>, Object>> f562251a = null;

    static {
        f562251a = new ConcurrentHashMap(3);
    }

    public static Object a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        return b("default_bid", r100);
    }

    public static Object b(String r100, Class r101) {
        Intrinsics.checkNotNullParameter(r101, "cls");
        ConcurrentHashMap r102 = (ConcurrentHashMap) f562251a;
        Map r103 = (Map) r102.get(r100);
        if (r103 != null) goto L12;
        d r104 = d.f540305c;
        d r105 = d.f540305c;
        if (r100 != null) goto L7;
        String r106 = "default_bid";
    L9:
        if (r105.e(r106) == false) goto L12;
        r103 = (Map) r102.get(r100);
        goto L12
    L7:
        r106 = r100;
    L12:
        if (r103 == null) goto L15;
        Object r107 = r103.get(r101);
        if (r107 == null) goto L15;
    L19:
        if (r107 != null) goto L22;
        return null;
    L22:
        return r107;
    L15:
        Map r108 = (Map) r102.get("default_bid");
        if (r108 == null) goto L18;
        r107 = r108.get(r101);
        goto L19
    L18:
        r107 = null;
        goto L19
    }

    public static void c(Object r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "service");
        d("default_bid", r100, r101);
    }

    @Deprecated(message = "为了平衡工作量提供的临时接口，请勿使用")
    public static void d(String r100, Object r101, Class r102) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "service");
        ConcurrentHashMap r103 = (ConcurrentHashMap) f562251a;
        Map r104 = (Map) r103.get(r100);
        if (r104 != null) goto L5;
        r104 = new ConcurrentHashMap(3);
        r103.put(r100, r104);
    L5:
        r104.put(r102, r101);
    }
}
