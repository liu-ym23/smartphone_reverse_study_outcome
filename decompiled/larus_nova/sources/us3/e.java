package us3;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final e f551472g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f551473h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f551474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ReferenceQueue<Object> f551475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f551476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.apm.config.a f551477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f551478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile f27.d f551479f;

    public e() {
    }

    static {
        f551472g = new e();
        f551473h = false;
    }

    public static void a(e r100) {
        r100.getClass();
        long r101 = System.currentTimeMillis();
        Runtime.getRuntime().gc();
        Thread.sleep(100);     // Catch: InterruptedException -> L8
        System.runFinalization();
        if (com.bytedance.apm.d.j() == false) goto L12;
        ps3.b.a(new String[]{"GC time done, cost: " + (System.currentTimeMillis() - r101) + " ms."});
        return;
    L12:
        return;
    L9:
        throw new AssertionError();
    }

    public static void b(e r100, vs3.b r101, String r110) {
        r100.getClass();
        if (com.bytedance.apm.d.j() == false) goto L5;
        ps3.b.a(new String[]{"Leak:" + r110});
    L5:
        Activity r111 = (Activity) r101.get();
        if (r111 != null) goto L9;
        return;
    L9:
        if (r100.f551477d.f190417d == false) goto L12;
        r100.f551474a.post(new c(r100, r101));
    L12:
        if (r100.f551477d.f190416c == false) goto L27;
        String r102 = r111.getClass().getName();
        boolean r103 = zs3.c.f573475a.getServiceSwitch("activity_leak_event");
        if (com.bytedance.apm.d.j() == false) goto L16;
        ps3.b.a(new String[]{"activity_leak_event : " + r103});
    L16:
        if (r103 == false) goto L25;
        if (TextUtils.isEmpty(r102) == true) goto L25;
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L22
        r104.put(r102, 1);     // Catch: Exception -> L22
        is3.a.h().b(new js3.b("activity_leak_event", r104));     // Catch: Exception -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
    L25:
        if (com.bytedance.apm.d.j() == false) goto L27;
        ps3.b.a(new String[]{"upload leak activity:" + r111.getLocalClassName()});
    L27:
        ((CopyOnWriteArraySet) r100.f551476c).remove(r101.f556982a);
        f r105 = r100.f551477d.f190418e;
        if (r105 == null) goto L33;
        r105.a(r111);
        return;
    }
}
