package l27;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mira.Mira;
import com.bytedance.mira.core.MetaManager;
import com.bytedance.mira.event.PluginEventManager;
import com.bytedance.mira.helper.PluginDirHelper;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.plugin.Plugin;
import com.bytedance.mira.plugin.PluginManager;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import k27.g;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f507145j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ExecutorService f507146k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static volatile e f507147l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f507148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f507149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<b> f507150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b> f507151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Long> f507152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<b> f507153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f507154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f507155h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f507156i;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f507157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f507158b;

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        L3:
            if (o27.c.a().f521787b == true) goto L5;
            this.f507158b.a();     // Catch: Throwable -> L7
        L5:
            this.f507158b.f507154g.postDelayed(this, this.f507157a * 1000);     // Catch: Throwable -> L7
        }

        public a(e r100, long r101) {
            this.f507158b = r100;
            this.f507157a = r101;
        }
    }

    static {
        f507145j = MiraLogger.TAG_DOWNLOAD.concat(e.class.getSimpleName());
        f507146k = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("ServerPluginConfigManager"));
    }

    public static e d() {
        if (f507147l != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f507147l != null) goto L9;
        f507147l = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f507147l;
    }

    public final void a() {
        if (this.f507148a == null) goto L6;
        MiraLogger.d(f507145j, "asyncFetchPlugins start");
        f507146k.execute(new l27.a(this));
        return;
    }

    public e() {
        this.f507150c = new CopyOnWriteArrayList();
        this.f507151d = new CopyOnWriteArrayList();
        this.f507152e = new ConcurrentHashMap();
        this.f507153f = new CopyOnWriteArrayList();
        this.f507154g = new Handler(Looper.getMainLooper());
        this.f507155h = null;
        this.f507156i = false;
    }

    public static boolean f(b r100) {
        Plugin r101 = Mira.getPlugin(r100.f507128a);
        if (r101 != null) goto L5;
    L39:
        return false;
    L5:
        if (r101.isVersionInstalled(r100.f507129b) == false) goto L39;
        if (PluginDirHelper.isPackageVersionDirExists(r100.f507128a, r100.f507129b) == false) goto L39;
        if (TextUtils.equals(r100.f507132e, r101.getInstalledMaxVersionMd5().toLowerCase()) == false) goto L37;
        r101.setHostCompatVersion(r100.f507129b, r100.f507138k, r100.f507139l);
        long r102 = new PolarisFileWrapper(PluginDirHelper.getSourceFile(r100.f507128a, r100.f507129b)).length();
        i27.a r103 = new i27.a(r100.f507128a, r100.f507129b, 3);
        r103.f488050d = r102;
        r103.f488051e = r102;
        r103.f488052f = System.currentTimeMillis();
        h27.c.a().c(r103);
        int r104 = r100.f507140m;
        if (r104 == 0) goto L15;
        if (r104 == 1) goto L15;
        boolean r105 = false;
    L16:
        if (r105 == true) goto L18;
    L20:
        r101.reuseExistVersion(r100.f507129b);
        int r106 = r100.f507129b;
        if (r106 > 0) goto L23;
    L34:
        boolean r107 = false;
    L35:
        if (r107 == true) goto L37;
        h27.a.f483619b.getClass();
        goto L37
    L23:
        if (r106 < r101.mMinVersionCode) goto L34;
        if (r106 > r101.mMaxVersionCode) goto L34;
        int r108 = PluginManager.getInstance().getHostUpdateVerCode();
        if (r108 == (-1)) goto L34;
        int r109 = MetaManager.getInst().getHostCompatibleMinVersion(r101.mPackageName, r106);
        int r110 = MetaManager.getInst().getHostCompatibleMaxVersion(r101.mPackageName, r106);
        if (r108 < r109) goto L34;
        if (r108 > r110) goto L34;
        if (r101.mLifeCycle > 4) goto L34;
        r107 = true;
        goto L35
    L18:
        if (PluginManager.getInstance().getPlugin(r100.f507128a).isUninstalled() == false) goto L20;
        h27.c.a().b(r103);
    L15:
        r105 = true;
    L37:
        k27.d.b().d(r100.f507128a, r100.f507129b, 2);
        n27.b.a("interceptPluginDownload", new String[]{"packageName:" + r100.f507128a + " downloadVersionCode:" + r100.f507129b});
        return true;
    }

    public final void h(long r100) {
        if (r100 >= 300) goto L5;
        return;
    L5:
        a r101 = this.f507155h;
        if (r101 == null) goto L8;
        this.f507154g.removeCallbacks(r101);
    L8:
        a r102 = new a(this, r100);
        this.f507155h = r102;
        this.f507154g.postDelayed(r102, r100 * 1000);
    }

    public final void c(String r100, int r101) {
        h27.a.f483619b.getClass();
        monitor-enter(this);
        Iterator r102 = ((CopyOnWriteArrayList) this.f507153f).iterator();     // Catch: Throwable -> L47
    L6:
        if (r102.hasNext() == false) goto L10;
        b r103 = (b) r102.next();     // Catch: Throwable -> L47
        if (TextUtils.equals(r103.f507128a, r100) == false) goto L6;
    L11:
        if (r103 != null) goto L18;
        Iterator r104 = ((CopyOnWriteArrayList) this.f507151d).iterator();     // Catch: Throwable -> L47
    L14:
        if (r104.hasNext() == false) goto L18;
        b r105 = (b) r104.next();     // Catch: Throwable -> L47
        if (TextUtils.equals(r105.f507128a, r100) == false) goto L14;
        r103 = r105;
    L18:
        h27.a.f483619b.getClass();     // Catch: Throwable -> L47
        i27.a r106 = (i27.a) ((HashMap) h27.c.a().f483624c).get(r100);     // Catch: Throwable -> L47
        if (r106 == null) goto L24;
        int r107 = r106.f488049c;     // Catch: Throwable -> L47
        if (r107 == 5) goto L23;
        if (r107 != 6) goto L24;
    L23:
        h27.d.a().c(r100);     // Catch: Throwable -> L47
    L24:
        h27.d r108 = h27.d.a();     // Catch: Throwable -> L47
        boolean r109 = false;
        if (r108.f483629b.containsKey(r100) == false) goto L30;
        Integer r110 = r108.f483629b.get(r100);     // Catch: Throwable -> L47
        if (r110 == null) goto L30;
        int r111 = r110.intValue();     // Catch: Throwable -> L47
    L31:
        r108.f483629b.put(r100, Integer.valueOf(r111 + 1));     // Catch: Throwable -> L47
        MiraLogger.d(MiraLogger.TAG_DOWNLOAD, String.format("addFlag %s", new Object[]{r100}));     // Catch: Throwable -> L47
        if (h27.d.a().b(r100) == false) goto L36;
        h27.d.a().c(r100);     // Catch: Throwable -> L47
        monitor-exit(this);     // Catch: Throwable -> L47
        return;
    L36:
        monitor-exit(this);     // Catch: Throwable -> L47
        if (r103 == null) goto L45;
        r103.f507137j = false;
        if ((this.f507148a.getApplicationInfo().flags & 2) == 0) goto L44;
        r109 = true;
    L44:
        g(r103, r101, r109);
        return;
    L45:
        i27.a r112 = new i27.a(r100, 0, 6);
        r112.f488053g = -101;
        h27.c.a().d(r112);
        h27.a.f483619b.getClass();
        h27.d.a().c(r100);
        MiraLogger.d(MiraLogger.TAG_DOWNLOAD, String.format("notifyStateChanged by downloadAndInstall => name = %s , status = %d", new Object[]{r100, Integer.valueOf(r112.f488049c)}));
        return;
    L30:
        r111 = 0;
        goto L31
    L10:
        r103 = null;
    L47:
        th = move-exception;
        throw th;
    }

    public final void e(JSONArray r100, JSONArray r101) {
        ArrayList r102 = new ArrayList();
        b(r100, r102, false);
        b(r101, r102, true);
        monitor-enter(this);
        ((CopyOnWriteArrayList) this.f507150c).clear();     // Catch: Throwable -> L47
        ((CopyOnWriteArrayList) this.f507151d).clear();     // Catch: Throwable -> L47
        ((CopyOnWriteArrayList) this.f507153f).clear();     // Catch: Throwable -> L47
        Iterator r103 = r102.iterator();     // Catch: Throwable -> L47
    L6:
        if (r103.hasNext() == false) goto L23;
        b r104 = (b) r103.next();     // Catch: Throwable -> L47
        int r105 = r104.f507140m;     // Catch: Throwable -> L47
        if (r105 != 3) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == true) goto L12;
        if (r105 != 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == true) goto L17;
        if (r105 != 1) goto L20;
        boolean r108 = true;
    L21:
        if (r108 == false) goto L6;
        ((CopyOnWriteArrayList) this.f507153f).add(r104);     // Catch: Throwable -> L47
        goto L6
    L20:
        r108 = false;
        goto L21
    L17:
        ((CopyOnWriteArrayList) this.f507151d).add(r104);     // Catch: Throwable -> L47
        goto L6
    L15:
        r107 = false;
        goto L16
    L12:
        r104.f507142o = true;     // Catch: Throwable -> L47
        ((CopyOnWriteArrayList) this.f507150c).add(r104);     // Catch: Throwable -> L47
        goto L6
    L10:
        r106 = false;
        goto L11
    L23:
        this.f507156i = true;     // Catch: Throwable -> L47
        Iterator r109 = ((CopyOnWriteArrayList) o27.e.a().f521791a).iterator();     // Catch: Throwable -> L47
    L25:
        if (r109.hasNext() == false) goto L29;
        ((o27.d) r109.next()).a();     // Catch: Exception -> L50 Throwable -> L47
        goto L25
    L29:
        n27.c.c().e();     // Catch: Throwable -> L47
        n27.c.c().e();     // Catch: Throwable -> L47
        List<b> r110 = this.f507151d;     // Catch: Throwable -> L47
        monitor-exit(this);
        if ((this.f507148a.getApplicationInfo().flags & 2) == 0) goto L36;
        boolean r111 = true;
    L37:
        Iterator r112 = ((CopyOnWriteArrayList) r110).iterator();
    L39:
        if (r112.hasNext() == false) goto L46;
        b r113 = (b) r112.next();
        if (r113.f507140m != 0) goto L43;
        boolean r114 = true;
    L44:
        if (r114 == false) goto L39;
        h27.a.f483619b.getClass();
        g(r113, 0, r111);
        goto L39
    L43:
        r114 = false;
        goto L44
    L46:
        return;
    L36:
        r111 = false;
    L47:
        th = move-exception;
        throw th;
    }

    public static void b(JSONArray r110, List r111, boolean r112) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (r110.length() < 0) goto L75;
        int r100 = 0;
    L9:
        if (r100 >= r110.length()) goto L76;
        JSONObject r101 = r110.optJSONObject(r100);
        if (r101 == null) goto L58;
        b r102 = c.d(r101, r112);     // Catch: JSONException -> L15
    L16:
        if (r102 == null) goto L58;
        if (r112 == true) goto L37;
        if (r102.f507135h == false) goto L23;
        Mira.unInstallPlugin(r102.f507128a);
        PluginEventManager.getInstance().notifyPluginEvent(40000, r102.f507128a, r102.f507129b, System.currentTimeMillis());
        MetaManager.getInst().setupDeleteReason(r102.f507128a, 41000);
        h27.a.f483619b.getClass();
        Mira.markOfflineFlag(r102.f507128a);
        goto L58
    L23:
        if (Mira.hasOfflineFlag(r102.f507128a) == false) goto L26;
        Mira.clearOfflineFlag(r102.f507128a);
    L26:
        if (r102.f507136i == false) goto L57;
        PluginEventManager.getInstance().notifyPluginEvent(40001, r102.f507128a, r102.f507129b, System.currentTimeMillis());
        if (r102.f507129b >= Mira.getInstalledPluginVersion(r102.f507128a)) goto L31;
        Mira.unInstallPlugin(r102.f507128a);
        MetaManager.getInst().setupDeleteReason(r102.f507128a, 41001);
    L31:
        if (r102.f507129b == 0) goto L33;
        boolean r103 = true;
    L34:
        if (r103 == true) goto L57;
    L33:
        r103 = false;
    L57:
        ((ArrayList) r111).add(r102);
        goto L58
    L37:
        if (r102.f507135h == false) goto L57;
        g r104 = g.a();
        String r105 = r102.f507128a;
        r104.getClass();
        File[] r106 = new PolarisFileWrapper(p27.b.b()).listFiles();
        if (r106 == null) goto L58;
        int r107 = r106.length;
        int r108 = 0;
    L42:
        if (r108 >= r107) goto L58;
        File r113 = r106[r108];
        String r114 = r113.getName();
        if (r114.contains(r105) == false) goto L56;
        if (r113.exists() == false) goto L49;
        r113.delete();
    L49:
        String r115 = r114.replaceAll("pre_download_", "").replaceAll("\\.jar", "");
        String[] r116 = r115.split("_");
        if (r116.length >= 3) goto L52;
        MiraLogger.d(g.f501615c, "PrePlugin : info length < 3 >>> ".concat(r114));
        String r109 = null;
        String r117 = null;
        int r118 = 0;
    L55:
        r104.c(r117, r118, r109, false);
        r104.d(r117, r118, false);
        goto L56
    L52:
        r118 = -1;
        r109 = r116[r116.length - 1];
        r118 = CastIntegerProtector.parseInt(r116[r116.length - 2]);     // Catch: Exception -> L60
    L54:
        r117 = r115.replaceAll("_" + r118 + "_" + r109, "");
    L56:
        r108 = r108 + 1;
    L15:
        r102 = null;
    L58:
        r100 = r100 + 1;
        goto L9
    L76:
        return;
    }

    public static void g(b r110, int r111, boolean r112) {
        Plugin r100 = Mira.getPlugin(r110.f507128a);     // Catch: Exception -> L18
        if (r100 == null) goto L11;
        if (r112 == false) goto L11;
        if (r100.mDisabledInDebug == false) goto L11;
        k27.d.b().d(r110.f507128a, r110.f507129b, 3);     // Catch: Exception -> L18
        String r113 = r110.f507128a;     // Catch: Exception -> L18
        i27.a r114 = new i27.a(r113, 0, 6);     // Catch: Exception -> L18
        r114.f488053g = -103;     // Catch: Exception -> L18
        h27.c.a().d(r114);     // Catch: Exception -> L18
        h27.a.f483619b.getClass();     // Catch: Exception -> L18
        h27.d.a().c(r110.f507128a);     // Catch: Exception -> L18
        MiraLogger.d(MiraLogger.TAG_DOWNLOAD, String.format("notifyStateChanged by startDownloadPlugin => name = %s , status = %d", new Object[]{r113, Integer.valueOf(r114.f488049c)}));     // Catch: Exception -> L18
        return;
    L11:
        if (f(r110) == false) goto L14;
        h27.a.f483619b.getClass();     // Catch: Exception -> L18
        h27.d.a().c(r110.f507128a);     // Catch: Exception -> L18
        return;
    L14:
        if (r100 == null) goto L16;
        r100.setHostCompatVersion(r110.f507129b, r110.f507138k, r110.f507139l);     // Catch: Exception -> L18
    L16:
        k27.d.b().a(null, r110, r110.f507141n, r111, true);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        String r101 = r110.f507128a;
        i27.a r115 = new i27.a(r101, 0, 6);
        r115.f488053g = -100;
        r115.f488055i = e;
        h27.c.a().d(r115);
        h27.a.f483619b.getClass();
        h27.d.a().c(r110.f507128a);
        MiraLogger.d(MiraLogger.TAG_DOWNLOAD, String.format("notifyStateChanged by startDownloadPlugin:catch => name = %s , status = %d", new Object[]{r101, Integer.valueOf(r115.f488049c)}));
        e.printStackTrace();
    }

    public static boolean i(b r100, List r101, boolean r102) {
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) r101;
        Iterator r104 = r103.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        b r105 = (b) r104.next();
        if (TextUtils.equals(r105.f507128a, r100.f507128a) == false) goto L4;
    L10:
        if (r105 == null) goto L15;
        r103.remove(r105);
        r103.add(r100);
        n27.c r106 = n27.c.c();
        monitor-enter(r106);
        monitor-exit(r106);
        return true;
    L15:
        if (r102 == false) goto L18;
        r103.add(r100);
        n27.c.c().d();
        return true;
    L18:
        return false;
    L8:
        r105 = null;
        goto L10
    }
}
