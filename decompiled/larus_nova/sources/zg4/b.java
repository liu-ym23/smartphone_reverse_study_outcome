package zg4;

import android.os.FileObserver;
import android.text.TextUtils;
import com.bytedance.crash.upload.CrashUploader;
import com.bytedance.crash.upload.n;
import com.bytedance.crash.util.j;
import com.bytedance.crash.util.l;
import com.bytedance.crash.util.p;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aiagent.messenger.stub.FlowNetworkIDLStub;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.ttm.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements Runnable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ConcurrentHashMap<com.bytedance.crash.monitor.f, b> f572045j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PolarisFileWrapper f572046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f572047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f572048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.crash.monitor.f f572049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f572050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f572051f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f572052g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<zg4.c> f572053h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f572054i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f572055a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f572055a.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(b r100) {
            this.f572055a = r100;
        }
    }

    /* JADX INFO: renamed from: zg4.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes15.dex */
    public class RunnableC8454b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f572056a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f572056a.e();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC8454b(b r100) {
            this.f572056a = r100;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f572057a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f572057a.f();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(b r100) {
            this.f572057a = r100;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public class d extends FileObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f572058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f572059b;

        public d(b r100, File r101) {
            this.f572059b = r100;
            super(r101.getAbsolutePath(), MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME);
            this.f572058a = r101;
        }

        @Override // android.os.FileObserver
        public final void onEvent(int r100, String r101) {
            if ((r100 & 8) == 0) goto L6;
            this.f572059b.i();
            return;
        }
    }

    static {
        f572045j = new ConcurrentHashMap();
    }

    public final void a() {
        if (TextUtils.isEmpty(this.f572049d.a()) == false) goto L5;
    L9:
        p.e("app id isEmpty：");
        if ((this.f572049d instanceof com.bytedance.crash.monitor.a) == false) goto L12;
        wh4.b.postDelayed(this, 200);
        return;
    L12:
        wh4.b.postDelayed(this, 500);
        return;
    L5:
        if (TextUtils.isEmpty(this.f572049d.d("")) == true) goto L9;
        wh4.b.f(this);
        c();
    }

    public final File b() {
        PolarisFileWrapper r100 = this.f572046a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(com.bytedance.crash.i.d(), FlowNetworkIDLStub.O_AUTO_CONFIGS_KEY);
        if (r101.exists() == true) goto L8;
        com.bytedance.crash.util.g.c(r101);
    L8:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, this.f572049d.a() + ".config");
        this.f572046a = r102;
        return r102;
    }

    public void c() {
        i();
        if (com.bytedance.crash.util.b.e(com.bytedance.crash.i.getContext(), com.bytedance.crash.util.b.c()) == false) goto L14;
        long r100 = System.currentTimeMillis() - this.f572052g;
        long r101 = this.f572048c * 1000;
        if (r100 <= r101) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        e();
        return;
    L13:
        wh4.b.postDelayed(new a(this), r101 - r100);
        return;
    L7:
        if (r100 < 0) goto L10;
        r102 = false;
        goto L11
    L14:
        d r103 = new d(this, b());
        if (r103.f572058a.exists() == false) goto L20;
    L17:
        r103.startWatching();
        return;
    L20:
        r103.f572058a.createNewFile();     // Catch: IOException -> L19
    }

    public final void e() {
        if (l.a() == true) goto L7;
        wh4.b.postDelayed(new RunnableC8454b(this), 300000);
        return;
    L7:
        if (f() == false) goto L9;
        long r100 = this.f572048c;
    L11:
        if (i.a() == false) goto L13;
        p.e("queryConfigFromRemote:" + r100);
    L13:
        wh4.b.postDelayed(new c(this), r100 * 1000);
        return;
    L9:
        r100 = Math.min(this.f572054i * 2, 600);
        this.f572054i = r100;
        goto L11
    }

    public final boolean f() {
        String r100 = n.e(g.f572072l.f572082j, this.f572049d);     // Catch: Throwable -> L16
        if (i.a() == false) goto L6;
        p.e("queryFromNet:" + r100);     // Catch: Throwable -> L16
    L6:
        byte[] r101 = CrashUploader.b(r100, null, DownloadHelper.GZIP, "GET", false, false).f203386d;     // Catch: Throwable -> L16
        if (r101 != null) goto L9;
    L15:
        return false;
    L9:
        if (r101.length <= 0) goto L15;
        JSONObject r102 = new JSONObject(new String(r101)).optJSONObject("ret");     // Catch: Throwable -> L16
        if (r102 == null) goto L18;
        return g(r102);
    L18:
        return false;
    L16:
        th = move-exception;
        ch4.c.c(th);
        goto L18
    }

    public final void i() {
        File r100 = b();
        String r101 = com.bytedance.crash.util.h.c(r100);     // Catch: Exception -> L5
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L21;
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L13
        this.f572052g = r102.optLong("monitor_configure_refresh_time");     // Catch: Exception -> L13
        if (i.a() == false) goto L11;
        p.e("updateFromLocal:" + this.f572049d.a() + " " + this.f572052g);     // Catch: Exception -> L13
    L11:
        h(r102);     // Catch: Exception -> L13
        d(r102);     // Catch: Exception -> L13
        return;
    L14:
        if (i.f572087c == true) goto L16;
        return;
    L16:
        return;
    L21:
        return;
    L5:
        r100.delete();
        r101 = null;
        goto L7
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

    public b(com.bytedance.crash.monitor.f r100) {
        this.f572048c = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
        this.f572050e = false;
        this.f572052g = -1;
        this.f572054i = 60000;
        this.f572049d = r100;
        this.f572053h = new CopyOnWriteArrayList();
        f572045j.put(r100, this);
    }

    private void d(JSONObject r100) {
        this.f572051f = true;
        List<zg4.c> r101 = this.f572053h;
        if (r101 == null) goto L13;
        Iterator r102 = ((CopyOnWriteArrayList) r101).iterator();
    L6:
        if (r102.hasNext() == false) goto L22;
        ((zg4.c) r102.next()).a(r100);     // Catch: Throwable -> L10
    L11:
        if (i.f572087c == false) goto L6;
        goto L6
    L22:
        return;
    }

    private void h(JSONObject r100) {
        if (j.g(r100) == false) goto L5;
        return;
    L5:
        this.f572047b = r100;
        if (r100 == null) goto L10;
        JSONObject r101 = r100.optJSONObject("general");
        if (r101 == null) goto L10;
        JSONObject r102 = r101.optJSONObject("slardar_api_settings");
    L12:
        if (r102 == null) goto L23;
        JSONObject r103 = r102.optJSONObject("fetch_setting");
        if (r103 == null) goto L17;
        this.f572048c = r103.optLong("fetch_setting_interval", AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);
    L17:
        if (this.f572048c >= 600) goto L20;
        this.f572048c = 600;
    L20:
        if (i.a() == false) goto L24;
        p.e("updateCurrentConfig:" + this.f572048c);
        return;
    L24:
        return;
    L23:
        return;
    L10:
        r102 = null;
        goto L12
    }

    public final boolean g(JSONObject r100) {
        if (i.a() == false) goto L6;
        p.e("saveConfig :" + r100);     // Catch: Exception -> L9
    L6:
        long r101 = System.currentTimeMillis();     // Catch: Exception -> L9
        this.f572052g = r101;     // Catch: Exception -> L9
        r100.put("monitor_configure_refresh_time", r101);     // Catch: Exception -> L9
        com.bytedance.crash.util.h.i(b(), r100);     // Catch: Exception -> L9
        h(r100);     // Catch: Exception -> L9
        d(r100);     // Catch: Exception -> L9
        return true;
    L10:
        if (i.f572087c == true) goto L12;
        return false;
    L12:
        return false;
    }
}
