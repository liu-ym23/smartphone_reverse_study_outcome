package com.bytedance.monitor.collector;

import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.Pair;
import b27.i;
import b27.j;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import es3.h;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public final class b extends AbsMonitor {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.monitor.collector.a f265587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f265588f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile int f265589g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f265590h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f265591i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f265592j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f265593k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f265594l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f265595m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f265596n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f265597o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f265598p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f265599q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f265600r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final bt3.f f265601s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile boolean f265602t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final a f265603u;

    /* JADX INFO: loaded from: classes21.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f265604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f265605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f265606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f265607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f265608e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f265609f;

        public final void a() {
            SystemClock.uptimeMillis();
            this.f265609f.getClass();
            throw null;
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

        public a(b r100) {
            this.f265609f = r100;
            this.f265604a = 0;
            this.f265606c = -1;
            this.f265607d = 0;
            this.f265608e = 0;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.monitor.collector.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes21.dex */
    public static class C3719b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f265610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f265611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f265612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f265613d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f265614e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f265615f;

        public C3719b() {
        }

        public final JSONObject a() {
            JSONObject r100 = new JSONObject();
            r100.put(DyPayConstant.KEY_START_TIME, this.f265610a);     // Catch: JSONException -> L5
            r100.put(ChameleonOpenTracker.ParamKey.COST, this.f265611b);     // Catch: JSONException -> L5
            r100.put("delay", this.f265612c);     // Catch: JSONException -> L5
            r100.put("isMessage", String.valueOf(this.f265613d));     // Catch: JSONException -> L5
            r100.put("seqNum", this.f265614e);     // Catch: JSONException -> L5
            r100.put("stack", this.f265615f);     // Catch: JSONException -> L5
        L7:
            return r100;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f265616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C3719b f265617b;
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f265618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f265619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f265620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f265621d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f265622e;

        public d() {
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f265623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f265624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f265625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f265626d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f265627e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f265628f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f265629g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c27.c f265630h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f265631i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public StackTraceElement[] f265632j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public StackTraceElement[] f265633k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f265634l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f265635m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public d f265636n;

        public e() {
        }

        public final JSONObject b() {
            JSONObject r100 = new JSONObject();
            r100.put("msg", j.a(this.f265631i));     // Catch: JSONException -> L5
            r100.put("cpuDuration", this.f265629g);     // Catch: JSONException -> L5
            r100.put("duration", this.f265628f);     // Catch: JSONException -> L5
            r100.put("type", this.f265626d);     // Catch: JSONException -> L5
            r100.put("messageCount", this.f265627e);     // Catch: JSONException -> L5
            r100.put("lastDuration", this.f265624b - this.f265625c);     // Catch: JSONException -> L5
            r100.put("start", this.f265623a);     // Catch: JSONException -> L5
            r100.put("end", this.f265624b);     // Catch: JSONException -> L5
            a(r100);     // Catch: JSONException -> L5
        L7:
            return r100;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        public final void a(JSONObject r100) throws JSONException {
            StackTraceElement[] r101 = this.f265632j;
            if (r101 == null) goto L5;
            r100.put("block_stack", j.b(r101));
        L5:
            r100.put("block_uuid", this.f265635m);
            StackTraceElement[] r102 = this.f265633k;
            if (r102 == null) goto L8;
            r100.put("sblock_stack", j.b(r102));
        L8:
            r100.put("sblock_uuid", this.f265635m);
            if (TextUtils.isEmpty(this.f265634l) == false) goto L12;
            r100.put("evil_msg", this.f265634l);
        L12:
            if (this.f265636n == null) goto L14;
            boolean r103 = true;
        L15:
            r100.put("belong_frame", r103);
            d r104 = this.f265636n;
            if (r104 == null) goto L18;
            r100.put("vsyncDelayTime", this.f265625c - (r104.f265618a / 1000000));
            r100.put("doFrameTime", (this.f265636n.f265619b / 1000000) - this.f265625c);
            d r105 = this.f265636n;
            r100.put("inputHandlingTime", (r105.f265620c / 1000000) - (r105.f265619b / 1000000));
            d r106 = this.f265636n;
            r100.put("animationsTime", (r106.f265621d / 1000000) - (r106.f265620c / 1000000));
            d r107 = this.f265636n;
            r100.put("performTraversalsTime", (r107.f265622e / 1000000) - (r107.f265621d / 1000000));
            r100.put("drawTime", this.f265624b - (this.f265636n.f265622e / 1000000));
        L18:
            c27.c r108 = this.f265630h;
            if (r108 == null) goto L22;
            r100.put("service_name", r108.f22209a);
            r100.put("service_what", this.f265630h.f22210b);
            r100.put("service_time", this.f265630h.f22211c);
            r100.put("service_thread", this.f265630h.f22213e);
            r100.put("service_token", this.f265630h.f22212d);
            return;
        L22:
            return;
        L14:
            r103 = false;
            goto L15
        }
    }

    /* JADX INFO: loaded from: classes21.dex */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f265637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f265638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f265639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<e> f265640d;

        public final List<e> a() {
            ArrayList r100 = new ArrayList();
            int r101 = 0;
            if (((ArrayList) this.f265640d).size() != this.f265637a) goto L12;
            int r102 = this.f265638b - 1;
        L6:
            if (r102 >= ((ArrayList) this.f265640d).size()) goto L9;
            r100.add((e) ListProtector.get(this.f265640d, r102));
            r102 = r102 + 1;
        L9:
            if (r101 >= (this.f265638b - 1)) goto L14;
            r100.add((e) ListProtector.get(this.f265640d, r101));
            r101 = r101 + 1;
        L14:
            return r100;
        L12:
            if (r101 >= ((ArrayList) this.f265640d).size()) goto L14;
            r100.add(ListProtector.get(this.f265640d, r101));
            r101 = r101 + 1;
            goto L12
        }

        public final e b() {
            int r100 = this.f265638b;
            if (r100 > 0) goto L7;
            return null;
        L7:
            return (e) ListProtector.get(this.f265640d, r100 - 1);
        }

        public f(int r100) {
            this.f265640d = new ArrayList();
            this.f265637a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final void d(int r100) {
    }

    public final JSONArray f() {
        return null;
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final Pair<String, ?> a() {
        return new Pair(this.f265559a, g());
    }

    public final JSONObject g() {
        long r100 = SystemClock.uptimeMillis();
        JSONObject r101 = new JSONObject();
        JSONArray r102 = new JSONArray();
        int r103 = 0;
        Iterator r104 = ((ArrayList) this.f265592j.a()).iterator();     // Catch: Throwable -> L58
        int r105 = 0;
    L5:
        if (r104.hasNext() == false) goto L11;
        e r106 = (e) r104.next();     // Catch: Throwable -> L58
        if (r106 == null) goto L5;
        r105 = r105 + 1;     // Catch: Throwable -> L58
        r102.put(r106.b().put("id", r105));     // Catch: Throwable -> L58
    L11:
        JSONObject r107 = new JSONObject();
        r107.put("message", this.f265598p);     // Catch: Throwable -> L60
        r107.put("currentMessageCost", r100 - this.f265594l);     // Catch: Throwable -> L60
        int r108 = this.f265595m;     // Catch: Throwable -> L60
        long r109 = -1;
        if (com.bytedance.monitor.collector.c.f265641j == false) goto L30;
        long r110 = MonitorJni.doGetCpuTime(r108);     // Catch: Throwable -> L59
        if (i.f17066b != (-1)) goto L28;
        long r111 = i.f17065a;     // Catch: Throwable -> L59
        if (r111 > 0) goto L27;
        r111 = Os.sysconf(OsConstants._SC_CLK_TCK);     // Catch: Throwable -> L59
        if (r111 > 0) goto L26;
        r111 = 100;
    L26:
        i.f17065a = r111;     // Catch: Throwable -> L59
    L27:
        i.f17066b = 1000 / r111;     // Catch: Throwable -> L59
    L28:
        r109 = r110 * i.f17066b;
    L30:
        r107.put("currentMessageCpu", r109 - this.f265596n);     // Catch: Throwable -> L60
        r107.put("messageCount", this.f265588f);     // Catch: Throwable -> L60
        r107.put("start", this.f265594l);     // Catch: Throwable -> L60
        r107.put("end", r100);     // Catch: Throwable -> L60
    L31:
        MessageQueue r112 = b27.f.b();
        JSONArray r113 = new JSONArray();
        if (r112 != null) goto L73;
    L64:
        r101.put("history_message", r102);     // Catch: JSONException -> L63
        r101.put("current_message", r107);     // Catch: JSONException -> L63
        r101.put("pending_messages", r113);     // Catch: JSONException -> L63
        r101.put("check_time_info", f());     // Catch: JSONException -> L63
    L57:
        return r101;
    L73:
        monitor-enter(r112);     // Catch: Throwable -> L62
        Message r114 = b27.f.c(r112);     // Catch: Throwable -> L53
        if (r114 != null) goto L39;
        monitor-exit(r112);     // Catch: Throwable -> L53
        goto L64
    L39:
        Message r115 = r114;
        int r116 = 0;
    L40:
        if (r115 == null) goto L51;
        if (r103 >= 100) goto L51;
        r103 = r103 + 1;     // Catch: Throwable -> L53
        r116 = r116 + 1;     // Catch: Throwable -> L53
        JSONObject r117 = i(r115, r100);     // Catch: Throwable -> L53
        r117.put("id", r116);     // Catch: JSONException -> L61 Throwable -> L53
    L45:
        r113.put(r117);     // Catch: Throwable -> L53
        Field r118 = b27.f.f17048c;     // Catch: Throwable -> L53
        if (r118 != null) goto L48;
        Field r119 = b27.f.a("android.os.Message").getDeclaredField(TeaEventTrack.ACTION_DRAMA_NEXT);     // Catch: Exception -> L50 Throwable -> L53
        b27.f.f17048c = r119;     // Catch: Exception -> L50 Throwable -> L53
        r119.setAccessible(true);     // Catch: Exception -> L50 Throwable -> L53
        r115 = (Message) b27.f.f17048c.get(r115);     // Catch: Exception -> L50 Throwable -> L53
    L50:
        r115 = null;
        goto L40
    L48:
        r115 = (Message) r118.get(r115);     // Catch: Exception -> L50 Throwable -> L53
    L51:
        monitor-exit(r112);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;     // Catch: Throwable -> L62
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final void c() {
        super.c();
        if (this.f265599q == true) goto L30;
        this.f265599q = true;
        int r100 = this.f265561c;
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L14;
        if (r100 != 2) goto L11;
    L13:
        this.f265590h = 300;
        this.f265591i = 200;
    L15:
        this.f265592j = new f(this.f265590h);
        b27.d r101 = new b27.d(this);
        CopyOnWriteArrayList<b27.a> r102 = b27.e.f17037d;
        monitor-enter(r102);
    L25:
        th = move-exception;
        throw th;
    L18:
        if (r102.contains(r101) == true) goto L22;
        r102.add(r101);     // Catch: Throwable -> L25
        if (h.f473717z.f473740w == false) goto L22;
        b27.e.g();     // Catch: Throwable -> L25
    L22:
        monitor-exit(r102);     // Catch: Throwable -> L25
        b27.f.c(b27.f.b());
        return;
    L11:
        if (r100 == 3) goto L13;
    L14:
        this.f265590h = 100;
        this.f265591i = 300;
        goto L15
    }

    public b(int r100) {
        super(r100, MonitorType.LOOPER_MONITOR);
        this.f265588f = 0;
        this.f265589g = 0;
        this.f265590h = 100;
        this.f265591i = 200;
        this.f265593k = -1;
        this.f265594l = -1;
        this.f265595m = -1;
        this.f265596n = -1;
        this.f265599q = false;
        this.f265600r = false;
        this.f265602t = false;
        this.f265603u = new a(this);
        c27.d r101 = c27.d.f22214b;
        Handler r102 = (Handler) d27.a.e();     // Catch: Throwable -> L6
        Field r103 = c27.a.a(Handler.class, "mCallback");     // Catch: Throwable -> L6
        r101.f22217a = (Handler.Callback) r103.get(r102);     // Catch: Throwable -> L6
        r103.set(r102, r101);     // Catch: Throwable -> L6
    L4:
        this.f265587e = new com.bytedance.monitor.collector.a(this);
        this.f265601s = null;
    }

    public static JSONObject i(Message r100, long r101) {
        JSONObject r102 = new JSONObject();
        r102.put(RemoteMessageConst.Notification.WHEN, r100.getWhen() - r101);     // Catch: JSONException -> L15
        if (r100.getCallback() == null) goto L6;
        r102.put("callback", String.valueOf(r100.getCallback()));     // Catch: JSONException -> L15
    L6:
        r102.put("what", r100.what);     // Catch: JSONException -> L15
        if (r100.getTarget() == null) goto L9;
        r102.put(PickerReporterConstants.KEY.TARGET, String.valueOf(r100.getTarget()));     // Catch: JSONException -> L15
    L10:
        r102.put("arg1", r100.arg1);     // Catch: JSONException -> L15
        r102.put("arg2", r100.arg2);     // Catch: JSONException -> L15
        Object r103 = r100.obj;     // Catch: JSONException -> L15
        if (r103 == null) goto L13;
        r102.put(MapBundleKey.MapObjKey.OBJ_SL_OBJ, String.valueOf(r103));     // Catch: JSONException -> L15
    L13:
        r102.put("start", r100.getWhen());     // Catch: JSONException -> L15
        r102.put("end", -1);     // Catch: JSONException -> L15
    L17:
        return r102;
    L9:
        r102.put("barrier", r100.arg1);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    @Override // com.bytedance.monitor.collector.AbsMonitor
    public final Pair<String, ?> b(long r100, long r101) {
        return new Pair(this.f265559a, g());
    L4:
        return null;
    }

    public static void e(b r110, boolean r111, long r112) {
        int r100 = r110.f265589g + 1;
        r110.f265589g = r100;
        r110.f265589g = r100 & 65535;
        r110.f265600r = false;
        if (r110.f265593k >= 0) goto L6;
        r110.f265593k = r112;
    L6:
        if (r110.f265594l >= 0) goto L9;
        r110.f265594l = r112;
    L9:
        if (r110.f265595m >= 0) goto L11;
        r110.f265595m = Process.myTid();
        r110.f265596n = SystemClock.currentThreadTimeMillis();
    L11:
        c27.c r113 = c27.d.f22215c;
        c27.d.f22215c = null;
        long r101 = r112 - r110.f265593k;
        long r102 = r110.f265591i;
        if (r101 > r102) goto L14;
        if (r113 != null) goto L14;
    L28:
        r110.f265594l = r112;
        return;
    L14:
        long r103 = r110.f265594l;
        if ((r112 - r103) > r102) goto L19;
        if (r113 != null) goto L19;
        r110.h(9, r112, r110.f265598p, true, null);
    L19:
        if (r111 == false) goto L25;
        if (r110.f265588f != 0) goto L23;
        r110.h(1, r112, "no message running", true, null);
        goto L28
    L23:
        r110.h(9, r103, r110.f265597o, true, null);
        r110.h(1, r112, "no message running", false, null);
        goto L28
    L25:
        if (r110.f265588f != 0) goto L27;
        r110.h(8, r112, r110.f265598p, true, r113);
        goto L28
    L27:
        r110.h(9, r103, r110.f265597o, false, null);
        r110.h(8, r112, r110.f265598p, true, r113);
        goto L28
    }

    public final void h(int r110, long r111, String r112, boolean r210, c27.c r211) {
        this.f265600r = true;
        f r100 = this.f265592j;
        e r101 = r100.f265639c;
        if (r101 == null) goto L5;
        r101.f265626d = r110;
        r100.f265639c = null;
    L6:
        r101.f265628f = r111 - this.f265593k;
        if (r210 == false) goto L9;
        long r113 = SystemClock.currentThreadTimeMillis();
        r101.f265629g = r113 - this.f265596n;
        this.f265596n = r113;
    L10:
        r101.f265627e = this.f265588f;
        r101.f265631i = r112;
        r101.f265623a = this.f265593k;
        r101.f265624b = r111;
        r101.f265625c = this.f265594l;
        if (r211 == null) goto L13;
        r101.f265630h = r211;
    L13:
        f r102 = this.f265592j;
        int r103 = ((ArrayList) r102.f265640d).size();
        int r104 = r102.f265637a;
        if (r103 >= r104) goto L16;
        ((ArrayList) r102.f265640d).add(r101);
        r102.f265638b = ((ArrayList) r102.f265640d).size();
    L17:
        this.f265588f = 0;
        this.f265593k = r111;
        return;
    L16:
        int r105 = r102.f265638b % r104;
        r102.f265638b = r105;
        e r106 = (e) ListProtector.set(r102.f265640d, r105, r101);
        r106.f265626d = -1;
        r106.f265627e = -1;
        r106.f265628f = -1;
        r106.f265631i = null;
        r106.f265632j = null;
        r106.f265633k = null;
        r106.f265634l = null;
        r106.f265635m = null;
        r106.f265636n = null;
        r106.f265630h = null;
        r102.f265639c = r106;
        r102.f265638b++;
        goto L17
    L9:
        r101.f265629g = -1;
        goto L10
    L5:
        r101 = new e();
        r101.f265626d = r110;
        goto L6
    }
}
