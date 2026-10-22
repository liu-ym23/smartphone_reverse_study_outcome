package ft9;

import com.bytedance.news.common.settings.SettingsManager;
import hq9.v2;
import kotlin.Unit;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f478797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f478798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f478799c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile v2 f478800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f478801e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final e f478802f = null;

    /* JADX WARN: Type inference failed for: r0v3, types: [ft9.e] */
    static {
        f478797a = "";
        f478799c = new Object();
        f478802f = new e();
    }

    public static void a() {
        if (f478798b == true) goto L5;
        return;
    L5:
        k.f478804a.getClass();
        v2 r100 = k.f478814k;
        if (r100 == null) goto L15;
        Object r101 = f478799c;
        monitor-enter(r101);
        f478800d = r100;     // Catch: Throwable -> L12
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r101);
    L12:
        th = move-exception;
        throw th;
    L15:
        SettingsManager.updateSettings(true);
    }
}
