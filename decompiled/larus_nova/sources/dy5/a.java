package dy5;

import android.os.Process;
import by5.n;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f470529c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Long, ConcurrentHashMap<Long, JSONObject>> f470530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f470531b;

    public static a c() {
        if (f470529c != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f470529c != null) goto L9;
        f470529c = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f470529c;
    }

    public a() {
        this.f470530a = new ConcurrentHashMap();
        this.f470531b = false;
    }

    public static String a(long r100, long r101) {
        return r100 + "_" + r101;
    }

    public final JSONObject b(long r100, long r101) {
        ConcurrentHashMap<Long, JSONObject> r102 = this.f470530a.get(Long.valueOf(r100));
        if (r102 != null) goto L5;
    L8:
        c r103 = c.a.f470533a;
        String r104 = a(r100, r101);
        File r105 = by5.a.b();
        if (r105 == null) goto L15;
        byte[] r106 = xu3.b.b(new PolarisFileWrapper(r105, r104 + ".bin"));
        if (r106 == null) goto L15;
        JSONObject r107 = new JSONObject(new String(r106));     // Catch: Exception -> L34
    L17:
        if (n.f21462e == false) goto L20;
        fy5.c.a("header init:" + r100 + ":" + r101 + " " + a(r100, r101));
    L20:
        if (this.f470530a.containsKey(Long.valueOf(r100)) == true) goto L22;
        this.f470530a.put(Long.valueOf(r100), new ConcurrentHashMap());
    L22:
        if (r107 == null) goto L25;
        this.f470530a.get(Long.valueOf(r100)).put(Long.valueOf(r101), r107);
    L28:
        if (r107 != null) goto L30;
        fy5.c.b("APM-SDK", "header==null " + r100);
    L30:
        return r107;
    L25:
        monitor-enter(n.class);
        r107 = n.f21459b.get(Long.valueOf(r100));     // Catch: Throwable -> L31
        monitor-exit(n.class);
    L31:
        th = move-exception;
        throw th;
    L15:
        r107 = null;
        goto L17
    L5:
        if (r102.containsKey(Long.valueOf(r101)) == false) goto L8;
        return r102.get(Long.valueOf(r101));
    }

    public final long d(long r100, JSONObject r101) {
        long r102 = (System.currentTimeMillis() << 16) | ((long) Process.myPid());
        if (this.f470530a.containsKey(Long.valueOf(r100)) == true) goto L5;
        this.f470530a.put(Long.valueOf(r100), new ConcurrentHashMap());
    L5:
        this.f470530a.get(Long.valueOf(r100)).put(Long.valueOf(r102), r101);
        String r103 = a(r100, r102);
        if (n.f21462e == false) goto L8;
        fy5.c.a("header init:" + r100 + ":" + r103 + " " + r101);
    L8:
        c r104 = c.a.f470533a;
        FileChannel r105 = null;
        if (r101 != null) goto L46;
        r101 = null;
    L13:
        File r106 = by5.a.b();
        if (r106 == null) goto L26;
        if (r101 == null) goto L26;
        r105 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r106, r103 + ".bin")).getChannel();     // Catch: Throwable -> L20
        r105.write(ByteBuffer.wrap(r101.toString().getBytes()));     // Catch: Throwable -> L20
    L22:
        xu3.c.a(r105);
    L20:
        th = move-exception;
        fy5.c.b("APM", "header couldn't write file" + th.getMessage());     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        xu3.c.a(r105);
        throw th;
    L26:
        monitor-enter(this);
    L38:
        th = move-exception;
        throw th;
    L28:
        if (this.f470531b == false) goto L32;
        monitor-exit(this);
    L37:
        return r102;
    L32:
        this.f470531b = true;     // Catch: Throwable -> L38
        c r107 = c.a.f470533a;     // Catch: Throwable -> L38
        File r108 = by5.a.b();     // Catch: Throwable -> L38
        if (r108 == null) goto L36;
        r108.listFiles(new b());     // Catch: Throwable -> L38
    L36:
        monitor-exit(this);
        goto L37
    L46:
        r101 = new JSONObject(r101.toString());     // Catch: Exception -> L41
        goto L13
    }
}
