package fu3;

import android.app.Activity;
import android.util.Pair;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile b f478859u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f478860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f478861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, HashMap<String, fu3.a>> f478862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, HashMap<String, fu3.a>> f478863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, HashMap<String, fu3.a>> f478864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<String, HashMap<String, fu3.a>> f478865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f478866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f478867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap<String, HashMap<String, fu3.a>> f478868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public HashMap<String, HashMap<String, fu3.a>> f478869j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f478870k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f478871l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public BlockingQueue<h> f478872m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f f478873n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f478874o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public fu3.c f478875p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public C5951b f478876q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f478877r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public a f478878s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile boolean f478879t;

    /* JADX INFO: loaded from: classes14.dex */
    public class a extends uu3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f478880a;

        public a(b r100) {
            this.f478880a = r100;
        }

        @Override // uu3.b, uu3.c
        public final void onBackground(Activity r100) {
            b r101 = this.f478880a;
            r101.getClass();
            long r102 = System.currentTimeMillis();
            long r103 = r102 - r101.f478870k;
            r101.f478870k = r102;
            if (r101.f478873n.f478888b == false) goto L5;
            r101.h(false);
        L5:
            r101.f(new h("command_change_to_background", r103));
        }

        @Override // uu3.b, uu3.c
        public final void onFront(Activity r100) {
            b r101 = this.f478880a;
            r101.getClass();
            long r102 = System.currentTimeMillis();
            long r103 = r102 - r101.f478870k;
            r101.f478870k = r102;
            if (r101.f478873n.f478888b == false) goto L5;
            r101.h(true);
        L5:
            r101.f(new h("command_change_to_front", r103));
        }
    }

    /* JADX INFO: renamed from: fu3.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes14.dex */
    public class C5951b extends cv3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f478881d;

        @Override // java.lang.Runnable
        public final void run() {
            b.a(this.f478881d, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public C5951b(b r100, long r101, long r102) {
            this.f478881d = r100;
            super(r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class c extends cv3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f478882d;

        @Override // java.lang.Runnable
        public final void run() {
            b.a(this.f478882d, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(b r100, long r101, long r102) {
            this.f478882d = r100;
            super(r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class d implements Comparator<Pair<String, Integer>> {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(Pair<String, Integer> r100, Pair<String, Integer> r101) {
            return ((Integer) r101.second).intValue() - ((Integer) r100.second).intValue();
        }
    }

    /* JADX INFO: loaded from: classes14.dex */
    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONObject f478883a;

        @Override // java.lang.Runnable
        public final void run() {
            jt3.a.b("apm_frequency_exception_monitor", this.f478883a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(JSONObject r100) {
            this.f478883a = r100;
        }
    }

    public final synchronized void j() {
        monitor-enter(this);
        this.f478861b = false;     // Catch: Throwable -> L23
        if (this.f478875p == null) goto L8;
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(this.f478875p);     // Catch: Throwable -> L23
    L8:
        if (this.f478877r == null) goto L11;
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(this.f478877r);     // Catch: Throwable -> L23
    L11:
        if (this.f478876q == null) goto L13;
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(this.f478876q);     // Catch: Throwable -> L23
    L13:
        uu3.a r100 = (uu3.a) qu3.c.a(uu3.a.class);     // Catch: Throwable -> L23
        if (r100 == null) goto L18;
        a r101 = this.f478878s;     // Catch: Throwable -> L23
        if (r101 == null) goto L18;
        r100.b(r101);     // Catch: Throwable -> L23
    L18:
        BlockingQueue<h> r102 = this.f478872m;     // Catch: Throwable -> L23
        if (r102 == null) goto L21;
        ((LinkedTransferQueue) r102).clear();     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static b g() {
        if (f478859u != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f478859u != null) goto L9;
        f478859u = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f478859u;
    }

    public b() {
        this.f478860a = false;
        this.f478861b = false;
        this.f478862c = new HashMap();
        this.f478863d = new HashMap();
        this.f478864e = new HashMap();
        this.f478865f = new HashMap();
        this.f478866g = 0;
        this.f478867h = 0;
        this.f478870k = 0;
        this.f478871l = 0;
        this.f478874o = 0;
        this.f478879t = true;
    }

    public static void b(b r110) throws InterruptedException, JSONException {
        h r100 = (h) ((LinkedTransferQueue) r110.f478872m).take();
        String r101 = r100.f478898a;
        boolean r102 = true;
        if (r101 == null) goto L44;
        long r103 = r100.f478899b;
        if (r101.startsWith("command_change_to_front") == false) goto L8;
        r110.d(true, r103);
    L62:
        r100.f478902e = false;
        return;
    L8:
        if (r100.f478898a.startsWith("command_change_to_background") == false) goto L11;
        r110.d(false, r103);
        goto L62
    L11:
        if (r100.f478898a.startsWith("command_check_front_exception") == false) goto L14;
        r110.e(true, r103);
        goto L62
    L14:
        if (r100.f478898a.startsWith("command_check_background_exception") == false) goto L17;
        r110.e(false, r103);
        goto L62
    L17:
        if (r100.f478898a.startsWith("command_report_data") == false) goto L62;
        HashMap<String, HashMap<String, fu3.a>> r104 = r110.f478868i;
        HashMap<String, HashMap<String, fu3.a>> r105 = r110.f478864e;
        if (r104 != r105) goto L21;
        r110.f478866g += r103;
    L23:
        if (r105.isEmpty() == true) goto L25;
    L27:
        JSONObject r106 = new JSONObject();
        if (r110.f478864e.isEmpty() == true) goto L32;
        JSONObject r107 = new JSONObject();
        if (r110.c(r110.f478864e, r110.f478866g, r107, true) == false) goto L32;
        r107.putOpt("duration", Long.valueOf(r110.f478866g));
        r106.putOpt(NewBroadcastMonitor.CAPTURE.FRONT, r107);
        boolean r108 = true;
    L34:
        if (r110.f478865f.isEmpty() == true) goto L38;
        JSONObject r109 = new JSONObject();
        if (r110.c(r110.f478865f, r110.f478867h, r109, false) == false) goto L38;
        r109.putOpt("duration", Long.valueOf(r110.f478867h));
        r106.putOpt("background", r109);
    L39:
        if (r102 == false) goto L43;
        r106.putOpt("sampling_rate", Integer.valueOf(r110.f478873n.f478895i));
        r106.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        bt3.b.d.f20539a.e(new fu3.e(r106));
        if (com.bytedance.apm.d.j() == false) goto L43;
        r106.toString();
    L43:
        r110.f478864e.clear();
        r110.f478865f.clear();
        r110.f478866g = 0;
        r110.f478867h = 0;
    L38:
        r102 = r108;
    L32:
        r108 = false;
        goto L34
    L25:
        if (r110.f478865f.isEmpty() == false) goto L27;
    L21:
        r110.f478867h += r103;
        goto L23
    L44:
        String r111 = r100.f478900c;
        String r112 = r100.f478901d;
        if (r110.f478873n.f478887a == false) goto L54;
        HashMap<String, fu3.a> r113 = r110.f478868i.get(r111);
        if (r113 != null) goto L49;
        HashMap<String, fu3.a> r114 = new HashMap();
        r110.f478868i.put(r111, r114);
        r114.put(r112, new fu3.a(1));
        goto L54
    L49:
        fu3.a r115 = r113.get(r112);
        if (r115 != null) goto L52;
        r113.put(r112, new fu3.a(1));
        goto L54
    L52:
        r115.f478858a++;
    L54:
        if (r110.f478873n.f478888b == false) goto L62;
        HashMap<String, fu3.a> r116 = r110.f478869j.get(r111);
        if (r116 != null) goto L58;
        HashMap<String, fu3.a> r117 = new HashMap();
        r110.f478869j.put(r111, r117);
        r117.put(r112, new fu3.a(1));
        goto L62
    L58:
        fu3.a r118 = r116.get(r112);
        if (r118 != null) goto L61;
        r116.put(r112, new fu3.a(1));
        goto L62
    L61:
        r118.f478858a++;
        goto L62
    }

    public final void f(h r100) {
        if (((LinkedTransferQueue) this.f478872m).offer(r100) == true) goto L8;
        if (com.bytedance.apm.d.j() == false) goto L8;
        Objects.toString(r100);
        ((LinkedTransferQueue) this.f478872m).size();
    L8:
        if (this.f478860a == true) goto L21;
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L11:
        if (this.f478860a == false) goto L15;
        monitor-exit(this);
        return;
    L15:
        this.f478860a = true;     // Catch: Throwable -> L18
        ThreadMethodProxy.start(new PthreadThreadV2(new fu3.d(this), "APM-FrequencyMonitor"));     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    }

    public final void h(boolean r110) {
        if (this.f478876q != null) goto L5;
    L12:
        f r100 = this.f478873n;
        int r101 = r100.f478889c;
        this.f478876q = new C5951b(this, r101 * 1000, r101 * 1000);
        int r102 = r100.f478890d;
        this.f478877r = new c(this, r102 * 1000, r102 * 1000);
    L13:
        this.f478871l = System.currentTimeMillis();
        cv3.b r103 = cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT);
        if (r110 == false) goto L16;
        cv3.a r111 = this.f478877r;
    L17:
        r103.c(r111);
        return;
    L16:
        r111 = this.f478876q;
        goto L17
    L5:
        if (this.f478877r == null) goto L12;
        cv3.b r104 = cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT);
        if (r110 == false) goto L10;
        cv3.a r105 = this.f478876q;
    L11:
        r104.b(r105);
        goto L13
    L10:
        r105 = this.f478877r;
        goto L11
    }

    public final synchronized void i(f r100) {
        monitor-enter(this);
        boolean r101 = r100.f478887a;     // Catch: Throwable -> L37
        if (r101 == true) goto L7;
        if (r101 == true) goto L7;
    L8:
        monitor-exit(this);
        return;
    L7:
        if (this.f478861b == true) goto L8;
        if (com.bytedance.apm.d.j() == false) goto L13;
        r100.toString();     // Catch: Throwable -> L37
    L13:
        this.f478873n = r100;     // Catch: Throwable -> L37
        this.f478872m = new LinkedTransferQueue();     // Catch: Throwable -> L37
        if (r100.f478887a == true) goto L16;
    L19:
        this.f478870k = System.currentTimeMillis();     // Catch: Throwable -> L37
        uu3.a r102 = (uu3.a) qu3.c.a(uu3.a.class);     // Catch: Throwable -> L37
        if (r102 == null) goto L35;
        boolean r103 = r102.isForeground();     // Catch: Throwable -> L37
        if (r103 == false) goto L24;
        HashMap<String, HashMap<String, fu3.a>> r104 = this.f478864e;     // Catch: Throwable -> L37
    L25:
        this.f478868i = r104;     // Catch: Throwable -> L37
        if (r103 == false) goto L28;
        HashMap<String, HashMap<String, fu3.a>> r105 = this.f478862c;     // Catch: Throwable -> L37
    L29:
        this.f478869j = r105;     // Catch: Throwable -> L37
        a r106 = new a(this);     // Catch: Throwable -> L37
        this.f478878s = r106;     // Catch: Throwable -> L37
        r102.a(r106);     // Catch: Throwable -> L37
        if (r100.f478888b == false) goto L32;
        h(r103);     // Catch: Throwable -> L37
    L32:
        this.f478861b = true;     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L28:
        r105 = this.f478863d;     // Catch: Throwable -> L37
        goto L29
    L24:
        r104 = this.f478865f;     // Catch: Throwable -> L37
        goto L25
    L35:
        monitor-exit(this);
        return;
    L16:
        if (this.f478875p != null) goto L18;
        long r107 = this.f478873n.f478894h * 1000;     // Catch: Throwable -> L37
        this.f478875p = new fu3.c(this, r107, r107);     // Catch: Throwable -> L37
    L18:
        cv3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(this.f478875p);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }

    public static void a(b r100, boolean r101) {
        r100.getClass();
        long r102 = System.currentTimeMillis();
        long r103 = r102 - r100.f478871l;
        r100.f478871l = r102;
        if (r101 == false) goto L5;
        String r104 = "command_check_front_exception";
    L6:
        r100.f(new h(r104, r103));
        return;
    L5:
        r104 = "command_check_background_exception";
        goto L6
    }

    public final void d(boolean r100, long r101) {
        this.f478862c.clear();
        this.f478863d.clear();
        if (r100 == false) goto L5;
        this.f478867h += r101;
        this.f478868i = this.f478864e;
        this.f478869j = this.f478862c;
        return;
    L5:
        this.f478866g += r101;
        this.f478868i = this.f478865f;
        this.f478869j = this.f478863d;
    }

    public final void e(boolean r110, long r210) throws JSONException {
        if (r110 == false) goto L5;
        HashMap<String, HashMap<String, fu3.a>> r100 = this.f478862c;
    L7:
        if (r100.isEmpty() == false) goto L9;
        return;
    L9:
        int r101 = this.f478873n.f478893g;
        if (r101 > 0) goto L12;
        return;
    L12:
        HashMap r102 = new HashMap();
        HashMap r103 = new HashMap();
        Iterator<Map.Entry<String, HashMap<String, fu3.a>>> r104 = r100.entrySet().iterator();
    L14:
        if (r104.hasNext() == false) goto L25;
        Map.Entry<String, HashMap<String, fu3.a>> r105 = r104.next();
        String r106 = r105.getKey();
        List r107 = (List) r103.get(r106);
        if (r107 != null) goto L18;
        r107 = new ArrayList();
        r103.put(r106, r107);
    L18:
        Iterator<Map.Entry<String, fu3.a>> r108 = r105.getValue().entrySet().iterator();
    L20:
        if (r108.hasNext() == false) goto L14;
        Map.Entry<String, fu3.a> r109 = r108.next();
        String r111 = r109.getKey();
        int r112 = r109.getValue().f478858a;
        r107.add(new Pair(r111, Integer.valueOf(r112)));
        fu3.a r113 = (fu3.a) r102.get(r106);
        if (r113 == null) goto L23;
        r113.f478858a += r112;
        goto L20
    L23:
        r102.put(r106, new fu3.a(r112));
        goto L20
    L25:
        Iterator r114 = r102.entrySet().iterator();
    L27:
        if (r114.hasNext() == false) goto L53;
        Map.Entry r115 = (Map.Entry) r114.next();
        float r116 = ((fu3.a) r115.getValue()).f478858a / (r210 * 1.6666667E-5f);
        f r117 = this.f478873n;
        float r118 = (10000.0f * r116) / r117.f478895i;
        String r119 = (String) r115.getKey();
        if (r110 == false) goto L34;
        Float r120 = r117.f478891e.get(r119);
        if (r120 != null) goto L33;
        float r121 = 1000.0f;
    L39:
        if (r118 <= r121) goto L51;
        List r122 = (List) r103.get(r115.getKey());
        Collections.sort(r122, new d());
        JSONObject r123 = new JSONObject();
        JSONArray r124 = new JSONArray();
        int r125 = 0;
    L42:
        if (r125 >= Math.min(r101, r122.size())) goto L48;
        JSONObject r126 = new JSONObject();
        Pair r127 = (Pair) ListProtector.get(r122, r125);
        if (r125 != 0) goto L47;
        r123.putOpt("exception_reason", r127.first);
    L47:
        r126.putOpt("key", r127.first);
        r126.putOpt("count", r127.second);
        r124.put(r126);
        r125 = r125 + 1;
        r101 = r101;
        r114 = r114;
        goto L42
    L48:
        int r128 = r101;
        Iterator r129 = r114;
        r123.putOpt("is_front", Integer.valueOf(r110 ? 1 : 0));
        r123.putOpt("category", r115.getKey());
        r123.putOpt(com.bytedance.android.ec.core.event.a.KEY_TOTAL_COUNT, Integer.valueOf(((fu3.a) r115.getValue()).f478858a));
        r123.putOpt("duration", Long.valueOf(r210));
        r123.putOpt("frequency_per_min", Float.valueOf(Math.round(r116 * 100.0f) / 100.0f));
        r123.putOpt("frequency_reduction", Float.valueOf(Math.round(r118 * 100.0f) / 100.0f));
        r123.putOpt("sampling_rate", Integer.valueOf(this.f478873n.f478895i));
        r123.putOpt("top_data", r124);
        r123.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        bt3.b.d.f20539a.e(new e(r123));
        if (com.bytedance.apm.d.j() == false) goto L52;
        r123.toString();
    L52:
        r101 = r128;
        r114 = r129;
        goto L27
    L51:
        r128 = r101;
        r129 = r114;
        goto L52
    L33:
        r121 = r120.floatValue();
        goto L39
    L34:
        Float r130 = r117.f478892f.get(r119);
        if (r130 != null) goto L37;
        r121 = 100.0f;
        goto L39
    L37:
        r121 = r130.floatValue();
        goto L39
    L53:
        r100.clear();
        return;
    L5:
        r100 = this.f478863d;
        goto L7
    }

    public final boolean c(HashMap<String, HashMap<String, fu3.a>> r110, long r111, JSONObject r112, boolean r113) throws JSONException {
        JSONArray r100 = new JSONArray();
        Iterator<Map.Entry<String, HashMap<String, fu3.a>>> r114 = r110.entrySet().iterator();
    L4:
        if (r114.hasNext() == false) goto L21;
        Map.Entry<String, HashMap<String, fu3.a>> r101 = r114.next();
        String r102 = r101.getKey();
        Iterator<Map.Entry<String, fu3.a>> r103 = r101.getValue().entrySet().iterator();
    L7:
        if (r103.hasNext() == false) goto L4;
        Map.Entry<String, fu3.a> r104 = r103.next();
        String r105 = r104.getKey();
        int r106 = r104.getValue().f478858a;
        float r107 = r106 / (r111 * 1.6666667E-5f);
        f r108 = this.f478873n;
        float r109 = (10000.0f * r107) / r108.f478895i;
        if (r113 == false) goto L14;
        Float r115 = r108.f478896j.get(r102);
        if (r115 != null) goto L13;
        float r116 = 20.0f;
    L19:
        if (r109 <= r116) goto L7;
        JSONObject r117 = new JSONObject();
        r117.putOpt("category", r102);
        r117.putOpt("key", r105);
        r117.putOpt("count", Integer.valueOf(r106));
        r117.putOpt("frequency_per_min", Float.valueOf(Math.round(r107 * 100.0f) / 100.0f));
        r117.putOpt("frequency_reduction", Float.valueOf(Math.round(r109 * 100.0f) / 100.0f));
        r100.put(r117);
        goto L7
    L13:
        r116 = r115.floatValue();
        goto L19
    L14:
        Float r118 = r108.f478897k.get(r102);
        if (r118 != null) goto L17;
        r116 = 2.0f;
        goto L19
    L17:
        r116 = r118.floatValue();
        goto L19
    L21:
        r112.putOpt("details", r100);
        if (r100.length() <= 0) goto L24;
        return true;
    L24:
        return false;
    }
}
