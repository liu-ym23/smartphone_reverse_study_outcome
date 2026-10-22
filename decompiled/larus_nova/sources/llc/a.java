package llc;

import bytekn.foundation.logger.Logger;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.Unit;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Pair<c0.b, Object>> f509807a = null;

    static {
        f509807a = new ConcurrentHashMap();
    }

    public static void a(String r110, String r111) {
        ConcurrentHashMap<String, Pair<c0.b, Object>> r100 = f509807a;
        Pair<c0.b, Object> r101 = r100.get(r110);
        if (r101 == null) goto L19;
        Object r102 = r101.getSecond();
        monitor-enter(r102);
        r101.getSecond().notify();     // Catch: Throwable -> L11 Exception -> L13
        int r103 = r101.getFirst().a();     // Catch: Throwable -> L11 Exception -> L13
        if (r101.getFirst().b() != 0) goto L9;
        Logger.INSTANCE.d("LLL", "[结束][" + r111 + "][" + r110 + "][清空]");     // Catch: Throwable -> L11 Exception -> L13
        r100.remove(r110);     // Catch: Throwable -> L11 Exception -> L13
    L22:
    L15:
        monitor-exit(r102);
        return;
    L9:
        Logger.e$default(Logger.INSTANCE, "LLL", "[结束][" + r111 + "][" + r110 + "][" + r103 + ']', null, 4, null);     // Catch: Throwable -> L11 Exception -> L13
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L11 Exception -> L13
    L11:
        th = move-exception;
        throw th;
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L11
        goto L15
    }

    public static void b(String r100, String r101) {
        monitor-enter(a.class);
        ConcurrentHashMap<String, Pair<c0.b, Object>> r102 = f509807a;     // Catch: Throwable -> L30
        if (r102.get(r100) != null) goto L9;
        Logger.INSTANCE.d("LLL", "[开始][" + r101 + "][" + r100 + "][空]");     // Catch: Throwable -> L30
        r102.put(r100, new Pair(new c0.b(1), new Object()));     // Catch: Throwable -> L30
        monitor-exit(a.class);
        return;
    L9:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(a.class);
        Logger.INSTANCE.w("LLL", "[开始][" + r101 + "][" + r100 + "][等等]");
        Pair<c0.b, Object> r104 = r102.get(r100);
        if (r104 == null) goto L14;
        Object r105 = r104.getSecond();
    L15:
        if (r105 == null) goto L29;
        Object r106 = r104.getSecond();
        monitor-enter(r106);
        r104.getFirst().f21897a.incrementAndGet();     // Catch: Throwable -> L20 Exception -> L22
        r104.getSecond().wait();     // Catch: Throwable -> L20 Exception -> L22
    L24:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r106);
        return;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L29:
        return;
    L14:
        r105 = null;
    L30:
        th = move-exception;
        throw th;
    }
}
