package j77;

import android.content.Context;
import com.bytedance.push.settings.ILocalSettings;
import com.bytedance.push.settings.ISettings;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a87.i f497636a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f497637b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f497638c = null;

    static {
        a87.i r100 = new a87.i();
        f497636a = r100;
        f497637b = new g(r100);
        f497638c = new h();
    }

    public static <T> T a(Context r100, Class<T> r101) {
        if (ISettings.class.isAssignableFrom(r101) == false) goto L33;
        h r102 = f497638c;
        T r103 = (T) r102.f497634a.get(r101);
        if (r103 != null) goto L29;
        ConcurrentHashMap<Class<? extends ISettings>, Object> r104 = r102.f497635b;
        monitor-enter(r104);
    L25:
        th = move-exception;
        throw th;
    L9:
        if (r102.f497635b.containsKey(r101) == false) goto L11;
        Object r105 = r102.f497635b.get(r101);     // Catch: Throwable -> L25
    L12:
        if (r105 != null) goto L14;
        r105 = new Object();     // Catch: Throwable -> L25
        r102.f497635b.put(r101, r105);     // Catch: Throwable -> L25
    L14:
        monitor-exit(r104);     // Catch: Throwable -> L25
        monitor-enter(r105);
        ISettings r106 = r102.f497634a.get(r101);     // Catch: Throwable -> L22
        if (r106 != null) goto L19;
        ISettings r107 = h.a(r100, r101);     // Catch: Throwable -> L22
        r102.f497634a.put(r101, r107);     // Catch: Throwable -> L22
    L20:
        monitor-exit(r105);     // Catch: Throwable -> L22
        return (T) r107;
    L19:
        r107 = r106;
    L22:
        th = move-exception;
        throw th;
    L11:
        r105 = null;
        goto L12
    L29:
        if (r102.f497635b.containsKey(r101) == false) goto L43;
        r102.f497635b.remove(r101);
        return r103;
    L43:
        return r103;
    L33:
        if (ILocalSettings.class.isAssignableFrom(r101) == false) goto L37;
        return (T) f497637b.c(r100, r101);
    L37:
        throw new IllegalArgumentException("tClass must be child of ISettings or ILocalSettings");
    }
}
