package p0c;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile q0c.b f527315a;

    /* JADX INFO: renamed from: p0c.a$a, reason: collision with other inner class name */
    public static final class C7139a {
    }

    static {
    }

    public a() {
    }

    @JvmStatic
    public static final q0c.b a() {
        if (f527315a != null) goto L16;
        monitor-enter(a.class);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f527315a != null) goto L9;
        f527315a = (q0c.b) ClaymoreServiceLoader.loadFirst(q0c.b.class);     // Catch: Throwable -> L12
    L9:
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(a.class);
    L16:
        return f527315a;
    }
}
