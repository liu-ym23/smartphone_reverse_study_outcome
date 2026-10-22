package w16;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f557913b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, Object> f557914a;

    /* JADX INFO: renamed from: w16.a$a, reason: collision with other inner class name */
    public static final class C8059a {
        @JvmStatic
        public static a a(Map r100) {
            a r101 = new a();
            if (r100 == null) goto L10;
            Iterator r102 = r100.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            Map.Entry r103 = (Map.Entry) r102.next();
            Class<?> r104 = (Class) r103.getKey();
            Object r105 = r103.getValue();
            Intrinsics.checkNotNullParameter(r104, "clazz");
            if (r105 == null) goto L6;
            r101.f557914a.put(r104, r105);
        L10:
            return r101;
        }
    }

    static {
    }

    public a() {
        this.f557914a = new ConcurrentHashMap();
    }

    public final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Object r101 = this.f557914a.get(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r100.isAssignableFrom(r101.getClass()) == true) goto L8;
        r101 = null;
    L8:
        if (r101 != null) goto L10;
        return null;
    L10:
        return (T) r101;
    }
}
