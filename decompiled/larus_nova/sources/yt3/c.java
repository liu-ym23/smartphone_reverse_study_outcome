package yt3;

import android.app.Application;
import android.app.usage.StorageStats;
import android.app.usage.StorageStatsManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.util.v;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.impl.ota.g2.j0;
import java.io.File;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import xu3.e;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c f569064o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f569065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f569066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f569067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f569068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f569069e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f569070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f569071g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<String> f569072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f569073i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public zt3.a f569074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f569075k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f569076l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f569077m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f569078n;

    /* JADX INFO: loaded from: classes14.dex */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f569079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f569080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f569081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f569082d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f569083e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<a> f569084f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ c f569085g;

        public final String a() {
            String r100 = this.f569079a;
            String r101 = c.a(this.f569085g, r100);
            if (r101 == null) goto L6;
            r100 = r101;
        L6:
            if (r100.contains(this.f569085g.f569065a) == false) goto L9;
            return r100.replace(this.f569085g.f569065a, "internal");
        L9:
            if (r100.contains(this.f569085g.f569067c) == true) goto L11;
            return r100;
        L11:
            return r100.replace(this.f569085g.f569067c, "external");
        }

        public final JSONObject b() {
            JSONObject r100 = new JSONObject();
            r100.put("path", a());     // Catch: JSONException -> L11
            r100.put("size", this.f569080b);     // Catch: JSONException -> L11
            r100.put("size_rate", this.f569081c);     // Catch: JSONException -> L11
            r100.put("is_folder", this.f569082d);     // Catch: JSONException -> L11
            r100.put("report_type", this.f569083e);     // Catch: JSONException -> L11
            if (((ArrayList) this.f569084f).isEmpty() == true) goto L13;
            JSONArray r101 = new JSONArray();     // Catch: JSONException -> L11
            Iterator r102 = ((ArrayList) this.f569084f).iterator();     // Catch: JSONException -> L11
        L7:
            if (r102.hasNext() == false) goto L9;
            r101.put(((a) r102.next()).b());     // Catch: JSONException -> L11
            goto L7
        L9:
            r100.put("next_disk", r101);     // Catch: JSONException -> L11
        L13:
            return r100;
        L11:
            e = move-exception;
            e.printStackTrace();
            goto L13
        }

        public a(c r100) {
            this.f569085g = r100;
            this.f569083e = "normal";
            this.f569084f = new ArrayList();
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f569086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f569087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f569088c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f569089d;

        public final String a() {
            String r100 = this.f569086a;
            String r101 = c.a(this.f569089d, r100);
            if (r101 == null) goto L6;
            r100 = r101;
        L6:
            if (r100.contains(this.f569089d.f569065a) == false) goto L9;
            return r100.replace(this.f569089d.f569065a, "internal");
        L9:
            if (r100.contains(this.f569089d.f569067c) == true) goto L11;
            return r100;
        L11:
            return r100.replace(this.f569089d.f569067c, "external");
        }

        public JSONObject b() {
            JSONObject r100 = new JSONObject();     // Catch: Exception -> L6
            r100.put("name", a());     // Catch: Exception -> L6
            r100.put("size", this.f569087b);     // Catch: Exception -> L6
            int r101 = this.f569088c;     // Catch: Exception -> L6
            if (r101 <= 0) goto L5;
            r100.put("num", r101);     // Catch: Exception -> L6
        L5:
            return r100;
        L6:
            return null;
        }

        public b(c r100) {
            this.f569089d = r100;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r100) {
            long r101 = this.f569087b;
            long r102 = ((b) r100).f569087b;
            if (r101 != r102) goto L7;
            return 0;
        L7:
            if (r101 <= r102) goto L10;
            return 1;
        L10:
            return -1;
        }

        public b(c r100, String r101, long r102, int r103) {
            this.f569089d = r100;
            this.f569086a = r101;
            this.f569087b = r102;
            this.f569088c = r103;
        }
    }

    /* JADX INFO: renamed from: yt3.c$c, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes14.dex */
    public class C8381c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f569090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C8381c f569091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f569092c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f569093d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f569094e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f569095f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f569096g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ c f569097h;

        public C8381c(c r100) {
            this.f569097h = r100;
        }

        public final void a(long r110, v<b> r111, v<b> r210) {
            long r100 = this.f569092c + r110;
            this.f569092c = r100;
            boolean r101 = true;
            int r102 = this.f569094e + 1;
            this.f569094e = r102;
            C8381c r103 = this.f569091b;
            if (r103 == null) goto L37;
            int r112 = this.f569093d;
            if (r102 != r112) goto L7;
            boolean r104 = true;
        L8:
            if (r104 == true) goto L10;
            return;
        L10:
            if (this.f569096g == false) goto L12;
            r103.f569096g = true;
        L12:
            c r105 = this.f569097h;
            if (r100 >= r105.f569074j.f573570b) goto L15;
        L26:
            this.f569091b.a(this.f569092c, r111, r210);
            if (this.f569095f == false) goto L39;
            c r106 = this.f569097h;
            long r107 = this.f569092c;
            r106.getClass();
            if (r107 >= j0.G2_OTA_SPACE_CHECK_BYTES) goto L31;
        L33:
            r101 = false;
        L34:
            if (r101 == false) goto L40;
            c r108 = this.f569097h;
            String r109 = this.f569090a;
            long r113 = this.f569092c;
            int r114 = this.f569093d;
            r111.a(new d(r108, r109, r113, r114, r114));
            return;
        L40:
            return;
        L31:
            if (r107 > 17179869184L) goto L33;
        L39:
            return;
        L15:
            if (this.f569096g == true) goto L26;
            if (r100 >= 0) goto L19;
        L22:
            boolean r115 = true;
        L23:
            if (r115 == true) goto L25;
            r210.a(new b(r105, this.f569090a, r100, r112));
        L25:
            this.f569091b.f569096g = true;
            goto L26
        L19:
            if (r100 > 17179869184L) goto L22;
            r115 = false;
            goto L23
        L7:
            r104 = false;
            goto L8
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class d extends b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f569098e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f569099f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f569100g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f569101h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ c f569102i;

        private String a() {
            String r100 = this.f569098e;
            String r101 = c.a(this.f569102i, r100);
            if (r101 == null) goto L6;
            r100 = r101;
        L6:
            if (r100.contains(this.f569102i.f569065a) == false) goto L9;
            return r100.replace(this.f569102i.f569065a, "internal");
        L9:
            if (r100.contains(this.f569102i.f569067c) == true) goto L11;
            return r100;
        L11:
            return r100.replace(this.f569102i.f569067c, "external");
        }

        @Override // yt3.c.b
        public final JSONObject b() {
            JSONObject r100 = new JSONObject();     // Catch: Exception -> L7
            r100.put("name", a());     // Catch: Exception -> L7
            r100.put("size", this.f569099f);     // Catch: Exception -> L7
            int r101 = this.f569100g;     // Catch: Exception -> L7
            if (r101 <= 0) goto L5;
            r100.put("num", r101);     // Catch: Exception -> L7
        L5:
            r100.put("outdate_interval", this.f569101h);     // Catch: Exception -> L7
            return r100;
        L7:
            return null;
        }

        @Override // yt3.c.b, java.lang.Comparable
        public final int compareTo(Object r100) {
            long r101 = this.f569101h;
            long r102 = ((d) r100).f569101h;
            if (r101 != r102) goto L7;
            return 0;
        L7:
            if (r101 <= r102) goto L10;
            return 1;
        L10:
            return -1;
        }

        public d(c r100, String r101, long r102, int r103, long r104) {
            this.f569102i = r100;
            super(r100);
            this.f569098e = r101;
            this.f569099f = r102;
            this.f569100g = r103;
            this.f569101h = r104;
        }
    }

    static {
        f569064o = new c();
    }

    public static Pair j() {
        int r100 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L33
        long r101 = 0;
        if (r100 < 26) goto L16;
        StorageStatsManager r102 = (StorageStatsManager) xu3.a.getContext().getSystemService("storagestats");     // Catch: Throwable -> L33
        StorageManager r103 = (StorageManager) xu3.a.getContext().getSystemService("storage");     // Catch: Throwable -> L33
        Iterator<StorageVolume> r104 = r103.getStorageVolumes().iterator();     // Catch: Throwable -> L33
        long r105 = 0;
    L7:
        if (r104.hasNext() == false) goto L14;
        String r110 = r104.next().getUuid();     // Catch: Throwable -> L33
        if (r110 != null) goto L11;
        UUID r111 = StorageManager.UUID_DEFAULT;     // Catch: Throwable -> L33
    L12:
        r101 = r101 + r102.getTotalBytes(r111);     // Catch: Throwable -> L33
        r105 = r105 + r103.getAllocatableBytes(r111);     // Catch: Throwable -> L33
        goto L7
    L11:
        r111 = UUID.fromString(r110);     // Catch: Throwable -> L33
        goto L12
    L14:
        return new Pair(Long.valueOf((((r101 / 1000) / 1000) * 1024) * 1024), Long.valueOf((((r105 / 1000) / 1000) * 1024) * 1024));
    L16:
        if (r100 < 24) goto L27;
        List<StorageVolume> r106 = ((StorageManager) xu3.a.getContext().getSystemService("storage")).getStorageVolumes();     // Catch: Throwable -> L33
        if (e.b(r106) == false) goto L21;
        return null;
    L21:
        Iterator<StorageVolume> r107 = r106.iterator();     // Catch: Throwable -> L33
        long r108 = 0;
    L23:
        if (r107.hasNext() == false) goto L26;
        StorageVolume r112 = r107.next();     // Catch: Throwable -> L33
        File r113 = (File) m(r112.getClass(), "getPathFile", new Class[0]).invoke(r112, new Object[0]);     // Catch: Throwable -> L33
        r101 = r101 + r113.getTotalSpace();     // Catch: Throwable -> L33
        r108 = r108 + r113.getFreeSpace();     // Catch: Throwable -> L33
        goto L23
    L26:
        return new Pair(Long.valueOf((((r101 / 1000) / 1000) * 1024) * 1024), Long.valueOf((((r108 / 1000) / 1000) * 1024) * 1024));
    L27:
        StorageManager r109 = (StorageManager) xu3.a.getContext().getSystemService("storage");     // Catch: Throwable -> L33
        Iterator r114 = ((List) m(r109.getClass(), "getVolumes", new Class[0]).invoke(r109, new Object[0])).iterator();     // Catch: Throwable -> L33
        long r115 = 0;
    L29:
        if (r114.hasNext() == false) goto L32;
        Object r116 = r114.next();     // Catch: Throwable -> L33
        File r117 = (File) m(r116.getClass(), "getPathFile", new Class[0]).invoke(r116, new Object[0]);     // Catch: Throwable -> L33
        r115 = r115 + r117.getFreeSpace();     // Catch: Throwable -> L33
        r101 = r101 + r117.getFreeSpace();     // Catch: Throwable -> L33
        goto L29
    L32:
        return new Pair(Long.valueOf(r101), Long.valueOf(r115));
    L34:
        return new Pair(Long.valueOf(new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes() + new StatFs(Environment.getRootDirectory().getPath()).getTotalBytes()), Long.valueOf(new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes()));
    }

    public final long g() {
        if (Build.VERSION.SDK_INT < 26) goto L20;
        Application r100 = xu3.a.getContext();     // Catch: Throwable -> L17
        String r101 = r100.getPackageName();     // Catch: Throwable -> L17
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getDataDir().getParent(), r101);     // Catch: Throwable -> L17
        StorageStats r103 = ((StorageStatsManager) r100.getSystemService("storagestats")).queryStatsForUid(((StorageManager) r100.getSystemService("storage")).getUuidForPath(r102), r100.getPackageManager().getApplicationInfo(r101, 128).uid);     // Catch: Throwable -> L17
        if (xu3.a.a() == false) goto L7;
        r103.getAppBytes();     // Catch: Throwable -> L17
    L7:
        return r103.getAppBytes();
    L20:
        long r104 = h(new PolarisFileWrapper(xu3.a.getContext().getPackageManager().getApplicationInfo(xu3.a.getContext().getPackageName(), 0).sourceDir).getParentFile());     // Catch: Exception -> L15
        if (xu3.a.a() == false) goto L12;
        i();     // Catch: Exception -> L15
    L12:
        return ((r104 + i()) + this.f569075k) + this.f569076l;
    L15:
        return 0;
    }

    public c() {
        this.f569069e = false;
        this.f569075k = 0;
        this.f569076l = 0;
        this.f569077m = 0;
        this.f569078n = 0;
    }

    public static long i() {
        File[] r100 = xu3.a.getContext().getApplicationContext().getExternalMediaDirs();
        int r101 = r100.length;
        long r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102 = r102 + h(r100[r103]);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static JSONArray f(v r100) {
        JSONArray r101 = new JSONArray();
        Iterator r102 = ((ArrayList) r100.b()).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        JSONObject r103 = ((b) r102.next()).b();
        if (r103 == null) goto L4;
        r101.put(r103);
        goto L4
    L8:
        return r101;
    }

    public static long h(File r100) {
        long r101 = 0;
        File[] r102 = r100.listFiles();     // Catch: Exception -> L16
        if (r102 != null) goto L6;
    L15:
        return 0;
    L6:
        if (r102.length == 0) goto L15;
        int r103 = r102.length;     // Catch: Exception -> L16
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L18;
        File r105 = r102[r104];     // Catch: Exception -> L16
        if (r105.isDirectory() == false) goto L13;
        long r106 = h(r105);     // Catch: Exception -> L16
    L14:
        r101 = r101 + r106;
        r104 = r104 + 1;
        goto L9
    L13:
        r106 = r105.length();     // Catch: Exception -> L16
    L18:
        return r101;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }

    public final void d(List<C8381c> r100) {
        if (e.b(r100) == false) goto L5;
        return;
    L5:
        Iterator<C8381c> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L20;
        C8381c r102 = r101.next();
        if (TextUtils.equals(r102.f569090a, this.f569065a) == true) goto L10;
        if (TextUtils.equals(r102.f569090a, this.f569067c) == true) goto L13;
        if (TextUtils.equals(r102.f569090a, this.f569066b) == true) goto L16;
        if (TextUtils.equals(r102.f569090a, this.f569068d) == false) goto L7;
        this.f569078n = r102.f569092c;
        goto L7
    L16:
        this.f569077m = r102.f569092c;
        goto L7
    L13:
        this.f569076l = r102.f569092c;
        goto L7
    L10:
        this.f569075k = r102.f569092c;
        goto L7
    }

    public final boolean k(File r100) {
        if (e.b(this.f569070f) == false) goto L5;
        return false;
    L5:
        return this.f569070f.contains(r100.getAbsolutePath());
    }

    public final boolean l(a r100) {
        Iterator<String> r101 = this.f569070f.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        String r102 = r101.next();
        if (r100.f569079a.contains(r102) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final List<String> n(List<String> r100) {
        ArrayList r101 = new ArrayList();
        if (e.b(r100) == false) goto L5;
        return r101;
    L5:
        Iterator<String> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        String r103 = r102.next();
        if (r103.contains("internal") == true) goto L10;
        if (r103.contains("external") == false) goto L7;
        r101.add(r103.replace("external", this.f569067c));
        goto L7
    L10:
        r101.add(r103.replace("internal", this.f569065a));
        goto L7
    L14:
        return r101;
    }

    public static String a(c r100, String r101) {
        if (e.b(r100.f569072h) == true) goto L11;
        if (r101 == null) goto L11;
        Iterator<String> r102 = r100.f569072h.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();
        if (r101.startsWith(r103) == false) goto L7;
    L12:
        if (r103 == null) goto L19;
        if (r101 != null) goto L15;
        return null;
    L15:
        return r103 + r101.substring(r103.length()).replaceAll("[^/]", "*");
    L19:
        return null;
    L11:
        r103 = null;
        goto L12
    }

    public final long b(File r100, List<a> r101) {
        long r102 = 0;
        if (r100 != null) goto L5;
    L33:
        return r102;
    L5:
        if (r100.exists() == false) goto L33;
        if (k(r100) == true) goto L33;
        int r103 = 0;
        if (r100.isFile() == false) goto L16;
        long r104 = r100.length();
        if (r104 >= this.f569074j.f573571c) goto L14;
        return r104;
    L14:
        a r105 = new a(this);
        r105.f569082d = false;
        r105.f569079a = r100.getAbsolutePath();
        r105.f569080b = r104;
        ((ArrayList) r101).add(r105);
        return r104;
    L16:
        File[] r106 = r100.listFiles();
        if (r106 == null) goto L33;
        if (r106.length == 0) goto L33;
        a r107 = new a(this);
        r107.f569082d = r100.isDirectory();
        r107.f569079a = r100.getAbsolutePath();
        ArrayList r108 = new ArrayList();
        r107.f569084f = r108;
        ((ArrayList) r101).add(r107);
        int r109 = r106.length;
    L22:
        if (r103 >= r109) goto L32;
        File r110 = r106[r103];
        if (r110 == null) goto L31;
        if (r110.exists() == false) goto L31;
        if (k(r110) == true) goto L31;
        r102 = r102 + b(r110, r108);
    L31:
        r103 = r103 + 1;
        goto L22
    L32:
        r107.f569080b = r102;
        goto L33
    }

    public final JSONArray e(List<a> r100, long r110) {
        ArrayList r101 = (ArrayList) r100;
        if (r101.isEmpty() == true) goto L24;
        BigDecimal r102 = new BigDecimal(r110);
        JSONArray r111 = new JSONArray();
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L23;
        a r112 = (a) r103.next();
        if (l(r112) == false) goto L10;
        r112.f569081c = 0.0f;
    L11:
        List<a> r104 = r112.f569084f;
        if (r104 == null) goto L22;
        ArrayList r105 = (ArrayList) r104;
        if (r105.size() <= 0) goto L22;
        Iterator r106 = r105.iterator();
    L17:
        if (r106.hasNext() == false) goto L22;
        a r107 = (a) r106.next();
        if (l(r107) == true) goto L20;
        r107.f569081c = (float) new BigDecimal(r107.f569080b).divide(r102, 4, 4).doubleValue();
        goto L17
    L20:
        r107.f569081c = 0.0f;
    L22:
        r111.put(r112.b());
        goto L6
    L10:
        r112.f569081c = (float) new BigDecimal(r112.f569080b).divide(r102, 4, 4).doubleValue();
        goto L11
    L23:
        return r111;
    L24:
        return null;
    }

    public static Method m(Class r100, String r101, Class<?>... r102) {
        Method r103 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r100, new Object[]{r101, r102});     // Catch: Exception -> L4
        r103.setAccessible(true);     // Catch: Exception -> L4
        return r103;
    L4:
        return null;
    }

    /* JADX WARN: Failed to calculate best type for var: r18v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v3 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r18v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v4 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r18v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v5 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r18v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r18v6 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v10 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v10 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v10 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v3 ??, new type: com.bytedance.security.android.aopcheck.PolarisFileWrapper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r3v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v3 ??, new type: com.bytedance.security.android.aopcheck.PolarisFileWrapper
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /* JADX WARN: Failed to calculate best type for var: r6v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v3 ??, new type: long
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r3v10 ??, new type: long
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    public final java.util.List<yt3.c.C8381c> c(java.lang.String r27, com.bytedance.apm.util.v<yt3.c.b> r28, com.bytedance.apm.util.v<yt3.c.b> r29, com.bytedance.apm.util.v<yt3.c.b> r30, java.util.List<java.lang.String> r31) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006e: CONSTRUCTOR (r3v3 ?? I:com.bytedance.security.android.aopcheck.PolarisFileWrapper) = (r5v0 java.lang.String) A[DECLARE_VAR, MD:(java.lang.String):void (m)] (LINE:83886190) call: com.bytedance.security.android.aopcheck.PolarisFileWrapper.<init>(java.lang.String):void type: CONSTRUCTOR in method: yt3.c.c(java.lang.String, com.bytedance.apm.util.v<yt3.c$b>, com.bytedance.apm.util.v<yt3.c$b>, com.bytedance.apm.util.v<yt3.c$b>, java.util.List<java.lang.String>):java.util.List<yt3.c$c>, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: yt3.c.c(java.lang.String, com.bytedance.apm.util.v, com.bytedance.apm.util.v, com.bytedance.apm.util.v, java.util.List):java.util.List");
    }
}
