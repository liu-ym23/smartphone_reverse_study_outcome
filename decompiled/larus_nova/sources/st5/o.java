package st5;

import com.ss.android.lark.log.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes19.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, k> f543573a;

    public o() {
        this.f543573a = new ConcurrentHashMap();
    }

    public final <T extends k> T a(Class<T> r100) {
        Map<String, k> r101 = this.f543573a;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        return (T) r102.get(r100.getCanonicalName());
    }

    public final void b(Class<? extends k> r100) {
        Class<?>[] r101 = r100.getInterfaces();     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        if (r101 != null) goto L6;
    L14:
        Log.i("ServiceManager", "no IWebService interface exists");     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        return;
    L6:
        if (r101.length == 0) goto L14;
        k r102 = r100.newInstance();     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        int r103 = r101.length;     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L26;
        Class<?> r105 = r101[r104];     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        if (k.class.isAssignableFrom(r105) == false) goto L13;
        Map<String, k> r106 = this.f543573a;     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        r107.put(r105.getCanonicalName(), r102);     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
    L13:
        r104 = r104 + 1;     // Catch: IllegalAccessException -> L16 InstantiationException -> L18
        goto L9
    L26:
        return;
    L16:
        e = move-exception;
        Log.e("ServiceManager", "illegal access", e);
        return;
    L18:
        e = move-exception;
        Log.e("ServiceManager", "instantiation error", e);
    }
}
