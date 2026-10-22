package kt1;

import com.bytedance.android.livesdk.config.v2;
import com.bytedance.android.livesdk.diagnose.DiagnoseEngine;
import io.reactivex.disposables.Disposable;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f506012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Disposable f506013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static v2 f506014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile h f506015d;

    public h() {
    }

    public static void b() {
        f506012a = true;
        Disposable r100 = f506013b;
        if (r100 == null) goto L5;
        r100.dispose();
        f506013b = null;
    L5:
        ((ConcurrentHashMap) DiagnoseEngine.d().f121944e).clear();
        c r101 = c.b();
        r101.f506004a = false;
        LinkedList<JSONObject> r102 = r101.f506007d;
        monitor-enter(r102);
        r101.f506007d.clear();     // Catch: Throwable -> L38
        monitor-exit(r102);     // Catch: Throwable -> L38
        LinkedList<JSONObject> r103 = r101.f506008e;
        monitor-enter(r103);
        r101.f506008e.clear();     // Catch: Throwable -> L35
        monitor-exit(r103);     // Catch: Throwable -> L35
        LinkedList<JSONObject> r104 = r101.f506009f;
        monitor-enter(r104);
        r101.f506009f.clear();     // Catch: Throwable -> L32
        monitor-exit(r104);     // Catch: Throwable -> L32
        LinkedList<JSONObject> r105 = r101.f506010g;
        monitor-enter(r105);
        r101.f506010g.clear();     // Catch: Throwable -> L29
        monitor-exit(r105);     // Catch: Throwable -> L29
        LinkedList<JSONObject> r106 = r101.f506011h;
        monitor-enter(r106);
        r101.f506011h.clear();     // Catch: Throwable -> L26
        monitor-exit(r106);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    L32:
        th = move-exception;
        throw th;
    L35:
        th = move-exception;
        throw th;
    L38:
        th = move-exception;
        throw th;
    }

    public static h a() {
        if (f506015d != null) goto L15;
        monitor-enter(h.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f506015d != null) goto L9;
        f506015d = new h();     // Catch: Throwable -> L11
    L9:
        monitor-exit(h.class);     // Catch: Throwable -> L11
    L15:
        return f506015d;
    }
}
