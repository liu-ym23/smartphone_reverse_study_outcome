package h84;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdinstall.c1;
import com.bytedance.bdinstall.t;
import com.bytedance.bdinstall.v;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import i84.s;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class m extends e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile Pair<byte[], String> f484129j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile Pair<String, byte[]> f484130k;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f484132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f484133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f484134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f484135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile Map<String, String> f484136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f484137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f484138i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f484139a;

        @Override // java.lang.Runnable
        public final void run() {
            m r100 = this.f484139a;     // Catch: Throwable -> L4
            String r101 = r100.f484138i;     // Catch: Throwable -> L4
            b r102 = new b(r100);     // Catch: Throwable -> L4
            v.c(r101).execute(r102);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(m r100) {
            this.f484139a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f484140a;

        public final void a() {
            this.f484140a.f484137h.set(false);
        L14:
            th = move-exception;
            th.printStackTrace();
        L16:
            String r100 = "";
        L17:
            m r101 = this.f484140a;
            if ("mounted".equals(r101.f484131b) == false) goto L77;
            FileLock r102 = null;
            PolarisFileWrapper r103 = new PolarisFileWrapper(r101.f484135f);     // Catch: Throwable -> L33
            if (r103.exists() == false) goto L24;
        L26:
            RandomAccessFile r104 = new RandomAccessFile(new PolarisFileWrapper(r101.f484135f + HTTP.URL_DEFAULT + r101.f484133d), "rwd");     // Catch: Throwable -> L33
            r102 = r104.getChannel().lock();     // Catch: Throwable -> L31
            byte[] r105 = r101.j(r100);     // Catch: Throwable -> L31
            r104.setLength(0);     // Catch: Throwable -> L31
            r104.write(r105);     // Catch: Throwable -> L31
            if (r102 != null) goto L62;
        L58:
            r104.close();     // Catch: Exception -> L55
            return;
        L78:
            return;
        L62:
            r102.release();     // Catch: Exception -> L53
        L31:
            th = th;
        L72:
        L45:
            th = move-exception;
            if (r102 != null) goto L70;
        L50:
            if (r104 == null) goto L79;
            r104.close();     // Catch: Exception -> L54
            throw th;
        L80:
            throw th;
        L79:
            throw th;
        L70:
            r102.release();     // Catch: Exception -> L49
            goto L50
        L36:
            if ((th instanceof IOException) == true) goto L38;
            th.printStackTrace();     // Catch: Throwable -> L45
        L38:
            if (r102 != null) goto L66;
        L42:
            if (r104 != null) goto L58;
            return;
        L66:
            r102.release();     // Catch: Exception -> L41
            goto L42
        L24:
            if (r103.mkdirs() == true) goto L26;
            return;
        L33:
            th = th;
            r104 = null;
            goto L72
        L77:
            return;
        L4:
            if (this.f484140a.f484136g == null) goto L16;
            Map<String, String> r106 = this.f484140a.f484136g;     // Catch: Throwable -> L14
            if (r106 == null) goto L16;
            JSONObject r107 = new JSONObject();     // Catch: Throwable -> L14
            Iterator<Map.Entry<String, String>> r108 = r106.entrySet().iterator();     // Catch: Throwable -> L14
        L10:
            if (r108.hasNext() == false) goto L12;
            Map.Entry<String, String> r109 = r108.next();     // Catch: Throwable -> L14
            r107.put(r109.getKey(), r109.getValue());     // Catch: Throwable -> L14
            goto L10
        L12:
            r100 = r107.toString();     // Catch: Throwable -> L14
            goto L17
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(m r100) {
            this.f484140a = r100;
        }
    }

    @Override // h84.e
    public final String[] f() {
        String r100 = k("sim_serial_number");
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return null;
    L7:
        return r100.split("\n");
    }

    @Override // h84.e, h84.n
    public final String a(String r100) {
        return k(r100);
    }

    @Override // h84.e
    public final void d(String[] r100) {
        if (r100 == null) goto L6;
        l("sim_serial_number", TextUtils.join("\n", r100));
        return;
    }

    @Override // h84.e
    public final void e(List<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<String> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L11;
        String r102 = r101.next();
        if (this.f484136g == null) goto L10;
        this.f484136g.remove(r102);
    L10:
        l(r102, null);
        goto L6
    L11:
        super.e(r100);
    }

    public final String i(byte[] r100) {
        if (f484129j == null) goto L9;
        if (Arrays.equals(r100, (byte[]) f484129j.first) == false) goto L9;
        return (String) f484129j.second;
    L9:
        if (f484130k != null) goto L11;
    L21:
        String r101 = s.b(r100, this.f484134e);     // Catch: Throwable -> L16
    L18:
        if (r101 == null) goto L20;
        f484129j = new Pair(r100, r101);
    L20:
        return r101;
    L16:
        th = move-exception;
        th.printStackTrace();
        r101 = null;
        goto L18
    L11:
        if (Arrays.equals(r100, (byte[]) f484130k.second) == false) goto L21;
        return (String) f484130k.first;
    }

    public final byte[] j(String r100) {
        if (f484130k == null) goto L9;
        if (c1.f(r100, (String) f484130k.first) == false) goto L9;
        return (byte[]) f484130k.second;
    L9:
        if (f484129j != null) goto L11;
    L21:
        byte[] r101 = s.c(r100, this.f484134e);     // Catch: Throwable -> L16
    L18:
        if (r101 == null) goto L20;
        f484130k = new Pair(r100, r101);
    L20:
        return r101;
    L16:
        th = move-exception;
        th.printStackTrace();
        r101 = null;
        goto L18
    L11:
        if (c1.f(r100, (String) f484129j.second) == false) goto L21;
        return (byte[]) f484129j.first;
    }

    public final String k(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (this.f484136g == null) goto L9;
        String r101 = this.f484136g.get(r100);
        int r102 = t.f199790a;
        return r101;
    L9:
        if ("mounted".equals(this.f484131b) == true) goto L94;
        return null;
    L94:
    L59:
        th = th;
        RandomAccessFile r103 = null;
        FileLock r104 = null;
    L102:
    L74:
        th = move-exception;
        if (this.f484136g != null) goto L78;
        this.f484136g = new ConcurrentHashMap();
    L78:
        if (r104 != null) goto L110;
    L82:
        if (r103 == null) goto L119;
        r103.close();     // Catch: Exception -> L91
        throw th;
    L120:
        throw th;
    L119:
        throw th;
    L110:
        r104.release();     // Catch: Exception -> L81
        goto L82
    L62:
        if ((th instanceof IOException) == true) goto L65;
        th.printStackTrace();     // Catch: Throwable -> L74
    L65:
        if (this.f484136g != null) goto L67;
        this.f484136g = new ConcurrentHashMap();
    L67:
        if (r104 != null) goto L96;
    L71:
        if (r103 != null) goto L112;
    L73:
        return null;
    L112:
        r103.close();     // Catch: Exception -> L90
        goto L73
    L96:
        r104.release();     // Catch: Exception -> L70
        goto L71
    L12:
        if (new PolarisFileWrapper(this.f484135f).exists() == false) goto L14;
        PolarisFileWrapper r105 = new PolarisFileWrapper(this.f484135f + HTTP.URL_DEFAULT + this.f484133d);     // Catch: Throwable -> L59
        r103 = new RandomAccessFile(r105, "rwd");     // Catch: Throwable -> L59
        r104 = r103.getChannel().lock();     // Catch: Throwable -> L57
    L55:
        th = th;
        goto L102
    L20:
        if (r105.isFile() == false) goto L50;
        byte[] r106 = new byte[2049];     // Catch: Throwable -> L55
        int r107 = r103.read(r106, 0, 2049);     // Catch: Throwable -> L55
        if (r107 <= 0) goto L50;
        if (r107 >= 2049) goto L50;
        String r108 = i(Arrays.copyOf(r106, r107));     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r108) == false) goto L27;
        ConcurrentHashMap r109 = new ConcurrentHashMap();     // Catch: Throwable -> L55
    L32:
        this.f484136g = r109;     // Catch: Throwable -> L55
        if (TextUtils.isEmpty(r100) == true) goto L35;
        String r110 = this.f484136g.get(r100);     // Catch: Throwable -> L55
        int r111 = t.f199790a;     // Catch: Throwable -> L55
        if (this.f484136g != null) goto L45;
        this.f484136g = new ConcurrentHashMap();
    L45:
        if (r104 != null) goto L108;
    L104:
        r103.close();     // Catch: Exception -> L88
    L48:
        return r110;
    L108:
        r104.release();     // Catch: Exception -> L87
        goto L104
    L35:
        if (this.f484136g != null) goto L37;
        this.f484136g = new ConcurrentHashMap();
    L37:
        if (r104 != null) goto L106;
    L98:
        r103.close();     // Catch: Exception -> L86
    L40:
        return null;
    L106:
        r104.release();     // Catch: Exception -> L85
        goto L98
    L27:
        JSONObject r112 = new JSONObject(r108);     // Catch: Throwable -> L55
        Iterator<String> r113 = r112.keys();     // Catch: Throwable -> L55
        ConcurrentHashMap r114 = new ConcurrentHashMap();     // Catch: Throwable -> L55
    L29:
        if (r113.hasNext() == false) goto L31;
        String r115 = r113.next();     // Catch: Throwable -> L55
        r114.put(r115, (String) r112.get(r115));     // Catch: Throwable -> L55
        goto L29
    L31:
        r109 = r114;
    L50:
        if (this.f484136g != null) goto L52;
        this.f484136g = new ConcurrentHashMap();
    L52:
        if (r104 == null) goto L112;
        r104.release();     // Catch: Exception -> L89
    L57:
        th = th;
        r104 = null;
        goto L102
    L14:
        if (this.f484136g != null) goto L16;
        this.f484136g = new ConcurrentHashMap();
    L16:
        return null;
    }

    @Override // h84.e, h84.n
    public final void c(String r100, String r101) {
        l(r100, r101);
    }

    public final void l(String r100, String r101) {
        if (this.f484136g != null) goto L8;
        k(null);
        if (this.f484136g != null) goto L8;
        this.f484136g = new ConcurrentHashMap();
    L8:
        if (c1.f(this.f484136g.get(r100), r101) == false) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L16;
        if (this.f484136g.containsKey(r100) == false) goto L16;
        this.f484136g.remove(r100);
    L19:
        if (this.f484132c == true) goto L21;
        return;
    L21:
        if (this.f484137h.compareAndSet(false, true) == false) goto L25;
        v.b(this.f484138i).postDelayed(new a(this), 1000);
        return;
    L25:
        return;
    L16:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        this.f484136g.put(r100, r101);
        goto L19
    }

    public m(boolean r100, String r101, String r102, String r103, String r104) {
        this.f484137h = new AtomicBoolean(false);
        this.f484131b = Environment.getExternalStorageState();
        this.f484135f = r101;
        this.f484132c = r100;
        this.f484133d = r102;
        this.f484134e = r103;
        this.f484138i = r104;
    }
}
