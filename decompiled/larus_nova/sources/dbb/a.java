package dbb;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f467841a;

    /* JADX INFO: renamed from: dbb.a$a, reason: collision with other inner class name */
    public interface InterfaceC5651a {
    }

    public interface b {
        InterfaceC5651a getDiskSP();
    }

    public a() {
    }

    public static b a() {
        if (f467841a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f467841a != null) goto L9;
        f467841a = (b) ClaymoreServiceLoader.loadFirst(b.class);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f467841a;
    }

    public static InterfaceC5651a b() {
        if (a() != null) goto L5;
        return null;
    L5:
        return a().getDiskSP();
    }
}
