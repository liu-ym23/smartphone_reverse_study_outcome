package xn0;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f564608a = 0;

    @JvmStatic
    public static final synchronized void a() {
        monitor-enter(b.class);
        int r100 = a.f564607a;     // Catch: Throwable -> L7
        a.a(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("enable_vehook", "false"), TuplesKt.to("enable_push_so", "false")}));     // Catch: Throwable -> L7
        monitor-exit(b.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static {
    }
}
