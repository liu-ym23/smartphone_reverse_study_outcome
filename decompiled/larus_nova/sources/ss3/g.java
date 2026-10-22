package ss3;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.util.o;
import com.bytedance.apm.util.v;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.services.slardar.config.IConfigManager;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends ss3.a {
    public static String B;
    public static String C;
    public v<d> A;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f543350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f543351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f543352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f543353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f543354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f543355l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f543356m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f543357n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f543358o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f543359p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f543360q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f543361r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f543362s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<a> f543363t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List<String> f543364u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List<String> f543365v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<String> f543366w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<String> f543367x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public v<b> f543368y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public v<b> f543369z;

    /* JADX INFO: loaded from: classes14.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f543370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f543371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f543372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f543373d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f543374e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<a> f543375f;

        public final JSONObject a() {
            JSONObject r100 = new JSONObject();
            String r101 = this.f543370a;     // Catch: JSONException -> L17
            if (r101.contains(g.B) == false) goto L7;
            r101 = r101.replace(g.B, "internal");     // Catch: JSONException -> L17
        L9:
            r100.put("path", r101);     // Catch: JSONException -> L17
            r100.put("size", this.f543371b);     // Catch: JSONException -> L17
            r100.put("size_rate", this.f543372c);     // Catch: JSONException -> L17
            r100.put("is_folder", this.f543373d);     // Catch: JSONException -> L17
            r100.put("report_type", this.f543374e);     // Catch: JSONException -> L17
            if (((ArrayList) this.f543375f).isEmpty() == true) goto L19;
            JSONArray r102 = new JSONArray();     // Catch: JSONException -> L17
            Iterator r103 = ((ArrayList) this.f543375f).iterator();     // Catch: JSONException -> L17
        L13:
            if (r103.hasNext() == false) goto L15;
            r102.put(((a) r103.next()).a());     // Catch: JSONException -> L17
            goto L13
        L15:
            r100.put("next_disk", r102);     // Catch: JSONException -> L17
        L19:
            return r100;
        L7:
            if (r101.contains(g.C) == false) goto L9;
            r101 = r101.replace(g.C, "external");     // Catch: JSONException -> L17
        L17:
            e = move-exception;
            e.printStackTrace();
            goto L19
        }

        public a() {
            this.f543374e = "normal";
            this.f543375f = new ArrayList();
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f543376a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f543377b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f543378c;

        public JSONObject a() {
            JSONObject r100 = new JSONObject();     // Catch: Exception -> L12
            String r101 = this.f543376a;     // Catch: Exception -> L12
            if (r101.contains(g.B) == false) goto L6;
            r101 = r101.replace(g.B, "internal");     // Catch: Exception -> L12
        L8:
            r100.put("name", r101);     // Catch: Exception -> L12
            r100.put("size", this.f543377b);     // Catch: Exception -> L12
            int r102 = this.f543378c;     // Catch: Exception -> L12
            if (r102 <= 0) goto L11;
            r100.put("num", r102);     // Catch: Exception -> L12
        L11:
            return r100;
        L6:
            if (r101.contains(g.C) == false) goto L8;
            r101 = r101.replace(g.C, "external");     // Catch: Exception -> L12
        L12:
            return null;
        }

        public b() {
        }

        @Override // java.lang.Comparable
        public int compareTo(Object r100) {
            long r101 = this.f543377b;
            long r102 = ((b) r100).f543377b;
            if (r101 != r102) goto L7;
            return 0;
        L7:
            if (r101 <= r102) goto L10;
            return 1;
        L10:
            return -1;
        }

        public b(String r100, long r101, int r102) {
            this.f543376a = r100;
            this.f543377b = r101;
            this.f543378c = r102;
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f543379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f543380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f543381c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f543382d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f543383e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f543384f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f543385g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f543386h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ g f543387i;

        public c(g r100) {
            this.f543387i = r100;
        }

        public final void a(long r100) {
            long r101 = this.f543381c + r100;
            this.f543381c = r101;
            int r102 = this.f543383e + 1;
            this.f543383e = r102;
            c r103 = this.f543380b;
            if (r103 == null) goto L43;
            int r104 = this.f543382d;
            if (r102 != r104) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L10;
            return;
        L10:
            if (this.f543386h == false) goto L12;
            r103.f543386h = true;
        L12:
            g r106 = this.f543387i;
            if (r101 >= r106.f543353j) goto L15;
        L27:
            this.f543380b.a(this.f543381c);
            if (this.f543384f == false) goto L31;
            this.f543387i.i(this.f543379a, this.f543381c, this.f543382d, this.f543385g);
        L31:
            if (TextUtils.equals(this.f543379a, g.B) == false) goto L34;
            g r107 = this.f543387i;
            r107.f543358o = this.f543381c;
            return;
        L34:
            if (TextUtils.equals(this.f543379a, g.C) == false) goto L37;
            g r108 = this.f543387i;
            r108.f543359p = this.f543381c;
            return;
        L37:
            if (TextUtils.equals(this.f543379a, this.f543387i.f543356m) == false) goto L40;
            g r109 = this.f543387i;
            r109.f543360q = this.f543381c;
            return;
        L40:
            if (TextUtils.equals(this.f543379a, this.f543387i.f543357n) == false) goto L48;
            g r110 = this.f543387i;
            r110.f543361r = this.f543381c;
            return;
        L48:
            return;
        L15:
            if (this.f543386h == true) goto L27;
            String r111 = this.f543379a;
            r106.getClass();
            if (com.bytedance.apm.d.j() == true) goto L20;
        L20:
            if (r101 <= 17179869184L) goto L23;
        L26:
            this.f543380b.f543386h = true;
            goto L27
        L23:
            if (r106.f543369z != null) goto L25;
            r106.f543369z = new v(r106.f543354k);
        L25:
            r106.f543369z.a(new b(r111, r101, r104));
            goto L26
        L7:
            r105 = false;
            goto L8
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public static class d extends b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f543388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f543389e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f543390f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f543391g;

        @Override // ss3.g.b
        public final JSONObject a() {
            JSONObject r100 = new JSONObject();     // Catch: Exception -> L13
            String r101 = this.f543388d;     // Catch: Exception -> L13
            if (r101.contains(g.B) == false) goto L6;
            r101 = r101.replace(g.B, "internal");     // Catch: Exception -> L13
        L8:
            r100.put("name", r101);     // Catch: Exception -> L13
            r100.put("size", this.f543389e);     // Catch: Exception -> L13
            int r102 = this.f543390f;     // Catch: Exception -> L13
            if (r102 <= 0) goto L11;
            r100.put("num", r102);     // Catch: Exception -> L13
        L11:
            r100.put("outdate_interval", this.f543391g);     // Catch: Exception -> L13
            return r100;
        L6:
            if (r101.contains(g.C) == false) goto L8;
            r101 = r101.replace(g.C, "external");     // Catch: Exception -> L13
        L13:
            return null;
        }

        @Override // ss3.g.b, java.lang.Comparable
        public final int compareTo(Object r100) {
            long r101 = this.f543391g;
            long r102 = ((d) r100).f543391g;
            if (r101 != r102) goto L7;
            return 0;
        L7:
            if (r101 <= r102) goto L10;
            return 1;
        L10:
            return -1;
        }

        public d(String r100, long r101, int r102, long r103) {
            this.f543388d = r100;
            this.f543389e = r101;
            this.f543390f = r102;
            this.f543391g = r103;
        }
    }

    @Override // ss3.a
    public final boolean c() {
        return true;
    }

    @Override // ss3.a
    public final long h() {
        return 120000;
    }

    @Override // ss3.a
    public final void e() {
        boolean r100 = this.f543333b;
        if (this.f543350g == true) goto L125;
        if (r100 == true) goto L7;
        return;
    L7:
        if (B != null) goto L39;
        Context r101 = com.bytedance.apm.d.getContext();
        r101.getPackageName();     // Catch: Exception -> L37
        B = r101.getFilesDir().getParent();     // Catch: Exception -> L37
        this.f543356m = r101.getCacheDir().getAbsolutePath();     // Catch: Exception -> L37
        C = r101.getExternalFilesDir(null).getParentFile().getAbsolutePath();     // Catch: Exception -> L37
        File r102 = r101.getExternalCacheDir();     // Catch: Exception -> L37
        if (r102 == null) goto L13;
        this.f543357n = r102.getAbsolutePath();     // Catch: Exception -> L37
    L13:
        List<String> r103 = this.f543365v;     // Catch: Exception -> L37
        if (r103 == null) goto L25;
        Iterator r104 = ((ArrayList) r103).iterator();     // Catch: Exception -> L37
    L18:
        if (r104.hasNext() == false) goto L25;
        String r105 = (String) r104.next();     // Catch: Exception -> L37
        if (r105.contains("internal") == true) goto L21;
        if (r105.contains("external") == false) goto L18;
        ((ArrayList) this.f543366w).add(r105.replace("external", C));     // Catch: Exception -> L37
        goto L18
    L21:
        ((ArrayList) this.f543366w).add(r105.replace("internal", B));     // Catch: Exception -> L37
    L25:
        List<String> r106 = this.f543364u;     // Catch: Exception -> L37
        if (r106 == null) goto L39;
        Iterator r107 = ((ArrayList) r106).iterator();     // Catch: Exception -> L37
    L28:
        if (r107.hasNext() == false) goto L39;
        String r108 = (String) r107.next();     // Catch: Exception -> L37
        if (r108.contains("internal") == true) goto L32;
        if (r108.contains("external") == false) goto L28;
        ((ArrayList) this.f543367x).add(r108.replace("external", C));     // Catch: Exception -> L37
        goto L28
    L32:
        ((ArrayList) this.f543367x).add(r108.replace("internal", B));     // Catch: Exception -> L37
    L37:
        this.f543362s = true;
    L39:
        if (this.f543362s == false) goto L97;
        this.f543350g = true;
        return;
    L97:
        if (this.f543351h == false) goto L46;
        k();     // Catch: Exception -> L95
        n(this.f543358o + this.f543359p, this.f543360q + this.f543361r, Environment.getDataDirectory().getTotalSpace() + Environment.getRootDirectory().getTotalSpace(), Environment.getDataDirectory().getFreeSpace());     // Catch: Exception -> L95
        com.bytedance.apm.internal.h r109 = com.bytedance.apm.internal.h.a.f190606a;     // Catch: Exception -> L95
        r109.f190605a.edit().putLong("check_disk_last_time", System.currentTimeMillis()).apply();     // Catch: Exception -> L95
    L96:
        goto L86
    L46:
        Context r110 = com.bytedance.apm.d.getContext();
        long r111 = 0;
        long r112 = -1;
        if (r110 != null) goto L101;
    L60:
        long r113 = -1;
    L61:
        Context r114 = com.bytedance.apm.d.getContext();     // Catch: Exception -> L95
        if (r114 != null) goto L105;
    L77:
        File r115 = Environment.getRootDirectory();     // Catch: Exception -> L95
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L82;
        long r116 = new StatFs(com.bytedance.apm.util.g.c(com.bytedance.apm.d.getContext()).getPath()).getTotalBytes();
    L107:
        r111 = new StatFs(r115.getPath()).getTotalBytes();     // Catch: Throwable -> L92
    L85:
        n(r113, r112, r116 + r111, Environment.getDataDirectory().getFreeSpace());     // Catch: Exception -> L95
    L82:
        r116 = 0;
        goto L107
    L105:
        if (TextUtils.isEmpty(r114.getPackageName()) == true) goto L77;
        File r117 = r114.getCacheDir();     // Catch: Throwable -> L91
        if (r117.exists() == false) goto L70;
        long r118 = com.bytedance.apm.util.b.c(r117);     // Catch: Throwable -> L91
    L71:
        File r119 = com.bytedance.apm.d.getContext().getExternalCacheDir();     // Catch: Throwable -> L91
        if (r119.exists() == false) goto L75;
        long r120 = com.bytedance.apm.util.b.c(r119);     // Catch: Throwable -> L91
    L76:
        r112 = r118 + r120;
        goto L77
    L75:
        r120 = 0;
        goto L76
    L70:
        r118 = 0;
        goto L71
    L101:
        PolarisFileWrapper r121 = new PolarisFileWrapper(r110.getFilesDir().getParent());     // Catch: Throwable -> L94
        if (r121.exists() == false) goto L60;
        long r122 = com.bytedance.apm.util.b.c(r121);     // Catch: Throwable -> L94
        File r123 = r110.getExternalFilesDir(null);     // Catch: Throwable -> L94
        if (r123 == null) goto L60;
        File r124 = r123.getParentFile();     // Catch: Throwable -> L94
        if (r124.exists() == false) goto L58;
        long r125 = com.bytedance.apm.util.b.c(r124);     // Catch: Throwable -> L94
    L59:
        r113 = r122 + r125;
        goto L61
    L58:
        r125 = 0;
    L86:
        this.f543350g = true;
        if (this.f543335d == false) goto L89;
        this.f543335d = false;
        bt3.b.d.f20539a.i(this);
    L89:
        ActivityLifeObserver.getInstance().unregister(this);
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).unregisterConfigListener(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v6 */
    public final void k() {
        int r100 = 2;
        char r110 = 0;
        int r111 = 1;
        String[] r101 = {B, C};
        this.f543363t = new ArrayList();
        int r112 = 0;
    L3:
        if (r112 >= r100) goto L75;
        String r102 = r101[r112];
        j(new PolarisFileWrapper(r102), r111, r111, this.f543363t);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        c r104 = new c(this);
        r104.f543379a = r102;
        r104.f543380b = new c(this);
        File[] r105 = r103.listFiles();
        if (r105 == null) goto L74;
        if (r105.length == 0) goto L74;
        r104.f543382d = r105.length;
        LinkedList r113 = new LinkedList();
        r113.offer(r104);
    L11:
        if (r113.isEmpty() == true) goto L74;
        int r114 = r113.size();
        int r115 = 0;
    L13:
        if (r115 >= r114) goto L11;
        c r106 = (c) r113.poll();
        if (r106 != null) goto L17;
        String[] r116 = r101;
    L73:
        r115 = r115 + 1;
        r101 = r116;
        r110 = 0;
        r111 = 1;
        goto L13
    L17:
        String r107 = r106.f543379a;
        PolarisFileWrapper r108 = new PolarisFileWrapper(r107);
        if (r108.exists() == true) goto L20;
    L72:
        r116 = r101;
        r106.f543380b.f543382d--;
        goto L73
    L20:
        if (((ArrayList) this.f543366w).contains(r107) == true) goto L72;
        r116 = r101;
        if (r108.isFile() == false) goto L49;
        long r109 = r108.length();
        if (r109 > 0) goto L27;
    L36:
        c r117 = r106.f543380b;
        if (r117 == null) goto L73;
        r117.a(r109);
        if (r106.f543380b.f543384f == true) goto L73;
        long r118 = System.currentTimeMillis() - r108.lastModified();
        if (r118 >= this.f543355l) goto L43;
    L45:
        r118 = 0;
    L47:
        if (r118 <= 0) goto L73;
        i(r107, r109, 0, r118);
        goto L73
    L43:
        if (r118 >= 62899200000L) goto L45;
    L27:
        if (com.bytedance.apm.d.j() == false) goto L30;
        String[] r119 = new String[r111];
        r119[r110] = "appendExceptionFileQueue: path: " + r107 + ", size: " + r109;
        ps3.b.a(r119);
    L30:
        if (r109 > 17179869184L) goto L36;
        if (this.f543368y != null) goto L35;
        this.f543368y = new v(this.f543354k);
    L35:
        this.f543368y.a(new b(r107, r109, r111));
        goto L36
    L49:
        File[] r120 = r108.listFiles();
        if (r120 != null) goto L52;
    L71:
        r106.f543380b.a(0);
        goto L73
    L52:
        if (r120.length == 0) goto L71;
        r106.f543382d = r120.length;
        int r121 = r120.length;
        int r122 = 0;
    L55:
        if (r122 >= r121) goto L73;
        File r123 = r120[r122];
        c r124 = new c(this);
        r124.f543380b = r106;
        r124.f543379a = r123.getAbsolutePath();
        if (r123.isDirectory() == false) goto L70;
        if (r106.f543384f == true) goto L70;
        long r125 = System.currentTimeMillis() - r123.lastModified();
        if (r125 >= this.f543355l) goto L63;
    L65:
        r125 = 0;
    L67:
        if (r125 <= 0) goto L70;
        r124.f543384f = true;
        r124.f543385g = r125;
        goto L70
    L63:
        if (r125 >= 62899200000L) goto L65;
    L70:
        r113.offer(r124);
        r122 = r122 + 1;
    L74:
        r112 = r112 + 1;
        r101 = r101;
        r100 = 2;
        r110 = 0;
        r111 = 1;
        goto L3
    L75:
        List<String> r126 = this.f543367x;
        if (r126 != null) goto L78;
    L83:
        Iterator r127 = ((ArrayList) this.f543363t).iterator();
    L85:
        if (r127.hasNext() == false) goto L96;
        a r128 = (a) r127.next();
        if ("normal".equals(r128.f543374e) == false) goto L85;
        List<a> r129 = r128.f543375f;
        if (r129 == null) goto L85;
        ArrayList r130 = (ArrayList) r129;
        if (r130.isEmpty() == true) goto L85;
        Iterator r131 = r130.iterator();
    L94:
        if (r131.hasNext() == false) goto L85;
        r128.f543371b += ((a) r131.next()).f543371b;
        goto L94
    L96:
        return;
    L78:
        if (((ArrayList) r126).size() <= 0) goto L83;
        Iterator r132 = ((ArrayList) this.f543367x).iterator();
    L81:
        if (r132.hasNext() == false) goto L83;
        j(new PolarisFileWrapper((String) r132.next()), 1, false, this.f543363t);
        goto L81
    }

    public g() {
        this.f543352i = 524288000;
        this.f543353j = 524288000;
        this.f543354k = 20;
        this.f543355l = 2592000000L;
        this.f543364u = new ArrayList();
        this.f543365v = new ArrayList();
        this.f543366w = new ArrayList();
        this.f543367x = new ArrayList();
        this.f543336e = UploadTypeInf.DISK;
    }

    public static long l(File r100) {
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
        long r106 = l(r105);     // Catch: Exception -> L16
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

    @Override // ss3.a
    public final void a(JSONObject r110) {
        boolean r100 = r110.optBoolean("dump_switch", true);
        this.f543351h = r100;
        if (r100 == false) goto L22;
        long r101 = com.bytedance.apm.internal.h.a.f190606a.f190605a.getLong("check_disk_last_time", 0);
        long r102 = System.currentTimeMillis() - r101;
        if (r102 >= 86400000) goto L10;
        if (r102 <= 0) goto L10;
        this.f543350g = true;
    L10:
        if (r110.optInt("dump_threshold") <= 0) goto L13;
        this.f543352i = (((long) r110.optInt("dump_threshold")) * 1024) * 1024;
    L13:
        if (r110.optInt("abnormal_folder_size") <= 0) goto L16;
        this.f543353j = (((long) r110.optInt("abnormal_folder_size")) * 1024) * 1024;
    L16:
        if (r110.optInt("dump_top_count") <= 0) goto L19;
        this.f543354k = r110.optInt("dump_top_count");
    L19:
        if (r110.optInt("outdated_days") <= 0) goto L21;
        this.f543355l = ((long) r110.optInt("outdated_days")) * 86400000;
    L21:
        this.f543364u = o.c(r110, "disk_customed_paths");
        this.f543365v = o.b(r110, "ignored_relative_paths");
    L22:
        this.f543350g = true;
    }

    public final boolean m(a r100) {
        Iterator r101 = ((ArrayList) this.f543366w).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        String r102 = (String) r101.next();
        if (r100.f543370a.contains(r102) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public final void i(String r110, long r111, int r112, long r113) {
        if (com.bytedance.apm.d.j() == false) goto L6;
        ps3.b.a(new String[]{"appendutdatedFileQueue: path: " + r110 + ", size: " + r111});
    L6:
        if (r111 >= WsConstants.DEFAULT_IO_LIMIT) goto L8;
        return;
    L8:
        if (r111 <= 17179869184L) goto L11;
        return;
    L11:
        if (this.A != null) goto L13;
        this.A = new v(this.f543354k);
    L13:
        this.A.a(new d(r110, r111, r112, r113));
    }

    public final void j(File r100, int r110, boolean r111, List<a> r112) {
        if (r110 <= 2) goto L5;
        return;
    L5:
        if (r100.exists() == false) goto L49;
        List<String> r101 = this.f543366w;
        ArrayList r102 = (ArrayList) r101;
        if (r102.contains(r100.getAbsolutePath()) == true) goto L51;
        int r103 = 0;
        if (r100.isDirectory() == false) goto L36;
        if (r111 == false) goto L35;
        File[] r104 = r100.listFiles();
        if (r104 != null) goto L15;
        return;
    L15:
        if (r104.length == 0) goto L47;
        int r105 = r104.length;
    L18:
        if (r103 >= r105) goto L52;
        File r106 = r104[r103];
        if (r106 == null) goto L33;
        if (r106.exists() == false) goto L33;
        List<String> r107 = this.f543366w;
        ArrayList r108 = (ArrayList) r107;
        if (r108.contains(r106.getAbsolutePath()) == true) goto L33;
        a r109 = new a();
        r109.f543373d = r106.isDirectory();
        r109.f543370a = r106.getAbsolutePath();
        if (r106.isDirectory() == false) goto L32;
        ArrayList r113 = new ArrayList();
        r109.f543375f = r113;
        if (r110 != 2) goto L31;
        r109.f543371b = l(r106);
    L31:
        j(r106, r110 + 1, r111, r113);
        r112.add(r109);
        goto L33
    L32:
        r109.f543371b = r106.length();
        r112.add(r109);
    L33:
        r103 = r103 + 1;
        goto L18
    L52:
        return;
    L47:
        return;
    L35:
        a r114 = new a();
        r114.f543373d = true;
        r114.f543374e = "custom";
        r114.f543370a = r100.getAbsolutePath();
        r114.f543371b = l(r100);
        r112.add(r114);
        return;
    L36:
        a r115 = new a();
        r115.f543373d = false;
        r115.f543370a = r100.getAbsolutePath();
        r115.f543371b = r100.length();
        if (r111 == true) goto L39;
        r115.f543374e = "custom";
    L39:
        r112.add(r115);
        return;
    L51:
        return;
    }

    public final void n(long r110, long r210, long r211, long r212) {
        if (com.bytedance.apm.d.j() == false) goto L6;
        ps3.b.a(new String[]{"disk: data: " + r110 + " , cache: " + r210 + " , total: " + r211 + " , free: " + r212});     // Catch: Exception -> L84
    L6:
        long r100 = 17179869184L;
        if (r110 <= 17179869184L) goto L9;
        long r111 = 17179869184L;
    L11:
        if (r210 > 17179869184L) goto L14;
        r100 = r210;
    L14:
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L84
        if (r110 <= 0) goto L18;
        r112.put("data", r111);     // Catch: Exception -> L84
    L18:
        if (r210 <= 0) goto L21;
        r112.put("cache", r100);     // Catch: Exception -> L84
    L21:
        if (r211 <= 0) goto L24;
        r112.put("total", r211 / 1073741824);     // Catch: Exception -> L84
    L24:
        if (r212 <= 0) goto L26;
        r112.put("rom_free", r212 / 1073741824);     // Catch: Exception -> L84
    L26:
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L84
        if (this.f543351h == true) goto L29;
    L82:
        ss3.a.g(new js3.e(UploadTypeInf.DISK, "storageUsed", r112, null, r101, 0));     // Catch: Exception -> L84
        return;
    L29:
        if (r111 <= this.f543352i) goto L82;
        if (this.f543368y == null) goto L40;
        JSONArray r102 = new JSONArray();     // Catch: Exception -> L84
        Iterator r103 = ((ArrayList) this.f543368y.b()).iterator();     // Catch: Exception -> L84
    L34:
        if (r103.hasNext() == false) goto L38;
        JSONObject r104 = ((b) r103.next()).a();     // Catch: Exception -> L84
        if (r104 == null) goto L34;
        r102.put(r104);     // Catch: Exception -> L84
        goto L34
    L38:
        r101.put("top_usage", r102);     // Catch: Exception -> L84
    L40:
        if (this.f543369z == null) goto L49;
        JSONArray r105 = new JSONArray();     // Catch: Exception -> L84
        Iterator r106 = ((ArrayList) this.f543369z.b()).iterator();     // Catch: Exception -> L84
    L43:
        if (r106.hasNext() == false) goto L47;
        JSONObject r107 = ((b) r106.next()).a();     // Catch: Exception -> L84
        if (r107 == null) goto L43;
        r105.put(r107);     // Catch: Exception -> L84
        goto L43
    L47:
        r101.put("exception_folders", r105);     // Catch: Exception -> L84
    L49:
        if (this.A == null) goto L57;
        JSONArray r108 = new JSONArray();     // Catch: Exception -> L84
        Iterator r109 = ((ArrayList) this.A.b()).iterator();     // Catch: Exception -> L84
    L52:
        if (r109.hasNext() == false) goto L56;
        JSONObject r113 = ((d) r109.next()).a();     // Catch: Exception -> L84
        if (r113 == null) goto L52;
        r108.put(r113);     // Catch: Exception -> L84
        goto L52
    L56:
        r101.put("outdated_files", r108);     // Catch: Exception -> L84
    L57:
        List<a> r114 = this.f543363t;     // Catch: Exception -> L84
        if (r114 != null) goto L60;
    L81:
        this.f543368y = null;     // Catch: Exception -> L84
        this.f543369z = null;     // Catch: Exception -> L84
        this.A = null;     // Catch: Exception -> L84
        this.f543363t = null;     // Catch: Exception -> L84
        goto L82
    L60:
        if (((ArrayList) r114).isEmpty() == true) goto L81;
        BigDecimal r115 = new BigDecimal(r111);     // Catch: Exception -> L84
        JSONArray r116 = new JSONArray();     // Catch: Exception -> L84
        Iterator r117 = ((ArrayList) this.f543363t).iterator();     // Catch: Exception -> L84
    L63:
        if (r117.hasNext() == false) goto L80;
        a r118 = (a) r117.next();     // Catch: Exception -> L84
        if (m(r118) == false) goto L67;
        r118.f543372c = 0.0f;     // Catch: Exception -> L84
    L68:
        List<a> r119 = r118.f543375f;     // Catch: Exception -> L84
        if (r119 == null) goto L79;
        ArrayList r120 = (ArrayList) r119;     // Catch: Exception -> L84
        if (r120.size() <= 0) goto L79;
        Iterator r121 = r120.iterator();     // Catch: Exception -> L84
    L74:
        if (r121.hasNext() == false) goto L79;
        a r122 = (a) r121.next();     // Catch: Exception -> L84
        if (m(r122) == true) goto L77;
        r122.f543372c = (float) new BigDecimal(r122.f543371b).divide(r115, 4, 4).doubleValue();     // Catch: Exception -> L84
        goto L74
    L77:
        r122.f543372c = 0.0f;     // Catch: Exception -> L84
    L79:
        r116.put(r118.a());     // Catch: Exception -> L84
        goto L63
    L67:
        r118.f543372c = (float) new BigDecimal(r118.f543371b).divide(r115, 4, 4).doubleValue();     // Catch: Exception -> L84
        goto L68
    L80:
        r101.put("disk_info", r116);     // Catch: Exception -> L84
        goto L81
    L9:
        r111 = r110;
    }
}
