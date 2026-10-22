package mt3;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PolarisFileWrapper f515608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static PolarisFileWrapper f515609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static PolarisFileWrapper f515610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PolarisFileWrapper f515611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static PolarisFileWrapper f515612e;

    public static synchronized File e() {
        monitor-enter(b.class);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (f515611d != null) goto L9;
        PolarisFileWrapper r100 = new PolarisFileWrapper(xu3.a.getContext().getFilesDir(), "apm6");     // Catch: Throwable -> L12
        f515611d = r100;     // Catch: Throwable -> L12
        if (r100.exists() == true) goto L9;
        f515611d.mkdirs();     // Catch: Throwable -> L12
    L9:
        PolarisFileWrapper r101 = f515611d;     // Catch: Throwable -> L12
        monitor-exit(b.class);
        return r101;
    }

    public static synchronized File a() {
        monitor-enter(b.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f515609b != null) goto L12;
        PolarisFileWrapper r100 = new PolarisFileWrapper(e(), "flush");     // Catch: Throwable -> L15
        if (r100.exists() == true) goto L9;
        r100.mkdirs();     // Catch: Throwable -> L15
    L9:
        f515609b = r100;     // Catch: Throwable -> L15
        if (xu3.a.a() == false) goto L12;
        List<String> r101 = a.f515607a;     // Catch: Throwable -> L15
        av3.b.a("APM-Slardar", "prepare FlushDirectory success. name=" + f515609b);     // Catch: Throwable -> L15
    L12:
        PolarisFileWrapper r102 = f515609b;     // Catch: Throwable -> L15
        monitor-exit(b.class);
        return r102;
    }

    public static synchronized File b() {
        monitor-enter(b.class);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (f515610c == null) goto L7;
    L16:
        PolarisFileWrapper r100 = f515610c;     // Catch: Throwable -> L19
        monitor-exit(b.class);
        return r100;
    L7:
        if (du3.a.o() == false) goto L9;
        PolarisFileWrapper r101 = new PolarisFileWrapper(e(), "persistent");     // Catch: Throwable -> L19
    L11:
        if (r101.exists() == true) goto L13;
        r101.mkdirs();     // Catch: Throwable -> L19
    L13:
        f515610c = r101;     // Catch: Throwable -> L19
        if (xu3.a.a() == false) goto L16;
        List<String> r102 = a.f515607a;     // Catch: Throwable -> L19
        av3.b.a("APM-Slardar", "prepare PersistentDirectory success. name=" + f515610c);     // Catch: Throwable -> L19
        goto L16
    L9:
        r101 = new PolarisFileWrapper(e(), "child_process_persistent");     // Catch: Throwable -> L19
        goto L11
    }

    public static synchronized File c() {
        monitor-enter(b.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (f515608a == null) goto L24;
    L18:
        PolarisFileWrapper r100 = f515608a;     // Catch: Throwable -> L21
        monitor-exit(b.class);
        return r100;
    L24:
        String r101 = du3.a.e().replace(".", "_").replace(":", "-") + ".bin";     // Catch: Exception -> L16 Throwable -> L21
        if (du3.a.o() == true) goto L9;
        r101 = du3.a.g() + "_" + r101;     // Catch: Exception -> L16 Throwable -> L21
    L9:
        PolarisFileWrapper r102 = new PolarisFileWrapper(b(), r101);     // Catch: Exception -> L16 Throwable -> L21
        if (r102.exists() == true) goto L12;
        r102.createNewFile();     // Catch: Exception -> L16 Throwable -> L21
    L12:
        f515608a = r102;     // Catch: Exception -> L16 Throwable -> L21
        if (xu3.a.a() == false) goto L18;
        List<String> r103 = a.f515607a;     // Catch: Exception -> L16 Throwable -> L21
        av3.b.a("APM-Slardar", "prepare PersistentFile success. fileName=" + f515608a);     // Catch: Exception -> L16 Throwable -> L21
    L16:
        e = move-exception;
        List<String> r104 = a.f515607a;     // Catch: Throwable -> L21
        av3.b.c("APM-Slardar", "prepare PersistentFile fail.", e);     // Catch: Throwable -> L21
        goto L18
    }

    public static synchronized File d() {
        monitor-enter(b.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f515612e != null) goto L12;
        PolarisFileWrapper r100 = new PolarisFileWrapper(e(), "flush_priority");     // Catch: Throwable -> L15
        if (r100.exists() == true) goto L9;
        r100.mkdirs();     // Catch: Throwable -> L15
    L9:
        f515612e = r100;     // Catch: Throwable -> L15
        if (xu3.a.a() == false) goto L12;
        List<String> r101 = a.f515607a;     // Catch: Throwable -> L15
        av3.b.a("APM-Slardar", "prepare PriorityFlushDirectory success. name=" + f515612e);     // Catch: Throwable -> L15
    L12:
        PolarisFileWrapper r102 = f515612e;     // Catch: Throwable -> L15
        monitor-exit(b.class);
        return r102;
    }
}
