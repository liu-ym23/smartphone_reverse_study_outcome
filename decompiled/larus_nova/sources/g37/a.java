package g37;

import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.news.common.settings.SettingsUpdateListener;
import com.bytedance.news.common.settings.api.SettingsData;
import com.bytedance.news.common.settings.api.annotation.ILocalSettings;
import com.bytedance.news.common.settings.api.annotation.ISettings;
import com.bytedance.news.common.settings.api.model.SettingsRequestModel;
import com.bytedance.news.common.settings.api.request.RequestV3Service;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import m37.g;
import m37.i;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ConcurrentMap<String, a> f479821k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f479822l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f479823m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile c f479824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f479825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<SettingsUpdateListener, Boolean> f479826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f479827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f479828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f479829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile d f479830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f479831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f479832i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f479833j;

    /* JADX INFO: renamed from: g37.a$a, reason: collision with other inner class name */
    public class RunnableC5983a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f479834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f479835b;

        public final void a() {
            a r100 = this.f479835b;
            boolean r101 = this.f479834a;
            boolean r102 = r100.f479830g.f479840c.f479859h;
            r100.f479830g.f479840c.getClass();
            StringBuilder r103 = new StringBuilder();
            r100.f479830g.f479840c.getClass();
            i37.a r104 = i37.a.a(m37.a.getContext());
            String r105 = r100.f479829f;
            SharedPreferences r106 = r104.f488113a;
            String r107 = "";
            if (r106 == null) goto L7;
            r107 = r106.getString("key_ctx_info_" + r105, "");
        L7:
            if (TextUtils.isEmpty(r107) == true) goto L9;
            r103.append("&ctx_infos=");
            r103.append(r107);
        L9:
            String r108 = r103.toString();
            if (r102 == false) goto L81;
            long r109 = System.currentTimeMillis();
            boolean r110 = true;
            if (r101 == false) goto L14;
        L23:
            if (r101 == false) goto L25;
        L26:
            r100.f479833j = true;
            r100.f479832i = r109;
            h37.c r111 = null;
            if (TextUtils.isEmpty(r108) == true) goto L32;
            SettingsRequestModel r112 = new SettingsRequestModel();
            r112.urlParams = r108;
            if (r108.contains("pull_task_data") == false) goto L31;
            r112.isReturnCtxInfo = false;
        L34:
            RequestV3Service r113 = r100.f479830g.f479840c.f479862k;
            if (r110 == false) goto L38;
            if (r113 == null) goto L41;
            r111 = r113.requestV3(r112);
        L41:
            if (r111 != null) goto L43;
        L66:
            a.f479822l.put(r100.f479829f, Long.valueOf(System.currentTimeMillis()));
            a.f479823m.put(r100.f479829f, Boolean.FALSE);
            r100.f479833j = false;
            return;
        L43:
            if (r111.f483721a == false) goto L66;
            SettingsData r114 = r111.f483722b;
            if (r114 == null) goto L47;
            r100.f479827d.d(r114, r100.f479830g, a.f479823m.get(r100.f479829f).booleanValue());
        L47:
            i37.a r115 = i37.a.a(m37.a.getContext());
            String r116 = r100.f479829f;
            String r117 = r111.f483724d;
            monitor-enter(r115);
            r115.f488113a.edit().putString("key_ctx_info_" + r116, r117).apply();     // Catch: Throwable -> L63
            monitor-exit(r115);
            i37.a.a(m37.a.getContext()).b(r100.f479829f, r111.f483725e);
            SettingsData r118 = m37.f.b(m37.a.getContext()).d(r100.f479830g.f479840c.f479852a);
            if (r118 == null) goto L62;
            Iterator<Map.Entry<SettingsUpdateListener, Boolean>> r119 = r100.f479826c.entrySet().iterator();
        L55:
            if (r119.hasNext() == false) goto L62;
            Map.Entry<SettingsUpdateListener, Boolean> r120 = r119.next();
            if (r120 == null) goto L55;
            if (r120.getValue().booleanValue() == true) goto L60;
            r120.getKey().onSettingsUpdate(r118);
            goto L55
        L60:
            r100.f479825b.post(new b(r120, r118));
        L62:
            r100.f479831h = r109;
        L63:
            th = move-exception;
            throw th;
        L38:
            if (r113 == null) goto L40;
            r111 = r113.requestV3(r112);
            goto L41
        L40:
            r111 = r100.f479830g.f479839b.request();
            goto L41
        L31:
            r112.isReturnCtxInfo = true;
        L33:
            r110 = false;
            goto L34
        L32:
            r112 = null;
            goto L33
        L25:
            if ((r109 - r100.f479832i) > r100.f479830g.f479840c.f479856e) goto L26;
            return;
        L14:
            if ((r109 - r100.f479831h) > r100.f479830g.f479840c.f479855d) goto L71;
            return;
        L71:
            NetworkInfo r121 = ((ConnectivityManager) r100.f479830g.getContext().getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L68
            if (r121 == null) goto L21;
            if (r121.isConnected() == false) goto L21;
            boolean r122 = true;
        L22:
            if (r122 == true) goto L23;
            return;
        L21:
            r122 = false;
            goto L22
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

        public RunnableC5983a(a r100, boolean r101) {
            this.f479835b = r100;
            this.f479834a = r101;
        }
    }

    static {
        f479821k = new ConcurrentHashMap();
        f479822l = new ConcurrentHashMap();
        f479823m = new ConcurrentHashMap();
    }

    public final void a() {
        if (this.f479824a == null) goto L15;
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (this.f479824a == null) goto L8;
        d r100 = this.f479824a.create();     // Catch: Throwable -> L11
        r100.f479840c.f479852a = this.f479829f;     // Catch: Throwable -> L11
        m37.a.a(r100.getContext());     // Catch: Throwable -> L11
        this.f479830g = r100;     // Catch: Throwable -> L11
    L8:
        this.f479824a = null;     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
    L15:
        if (this.f479830g == null) goto L18;
        return;
    L18:
        throw new IllegalStateException("IndividualManager尚未被配置");
    }

    public a(String r100) {
        this.f479825b = new Handler(Looper.getMainLooper());
        this.f479826c = new ConcurrentHashMap();
        this.f479827d = new i();
        this.f479828e = new g();
        this.f479831h = 0;
        this.f479832i = 0;
        this.f479833j = false;
        this.f479829f = r100;
        f479823m.put(r100, Boolean.TRUE);
    }

    public static a c(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L19;
        ConcurrentMap<String, a> r101 = f479821k;
        a r102 = (a) ((ConcurrentHashMap) r101).get(r100);
        if (r102 == null) goto L7;
    L17:
        return r102;
    L7:
        monitor-enter(a.class);
        r102 = (a) ((ConcurrentHashMap) r101).get(r100);     // Catch: Throwable -> L15
        if (r102 != null) goto L11;
        r102 = new a(r100);     // Catch: Throwable -> L15
        ((ConcurrentHashMap) r101).putIfAbsent(r100, r102);     // Catch: Throwable -> L15
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L19:
        throw new IllegalArgumentException("settingsId不能为空");
    }

    public final <T> T b(Class<T> r100) {
        a();
        if (ISettings.class.isAssignableFrom(r100) == false) goto L7;
        return (T) this.f479827d.c(r100, this.f479830g, this.f479829f);
    L7:
        if (ILocalSettings.class.isAssignableFrom(r100) == false) goto L11;
        return (T) this.f479828e.c(r100, this.f479830g, this.f479829f);
    L11:
        throw new IllegalArgumentException("tClass必须是ISettings或ILocalSettings的子类");
    }

    public final void e(boolean r100) {
        a();
        if (this.f479833j == false) goto L5;
        return;
    L5:
        this.f479830g.f479840c.f479854c.execute(new RunnableC5983a(this, r100));
    }

    public final void d(SettingsUpdateListener r100, boolean r101) {
        this.f479826c.put(r100, Boolean.valueOf(r101));
    }
}
