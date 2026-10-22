package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.VivoPushException;
import com.vivo.push.util.ad;
import com.vivo.push.util.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile m f462395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f462396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f462397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f462398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f462399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f462400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f462401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Context f462402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f462403i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f462404j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private SparseArray<a> f462405k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f462406l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Boolean f462407m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private Long f462408n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f462409o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private IPushClientFactory f462410p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f462411q;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IPushActionListener f462412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private com.vivo.push.b.c f462413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private IPushActionListener f462414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Runnable f462415d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Object[] f462416e;

        public final void a() {
            Runnable r100 = this.f462415d;
            if (r100 != null) goto L6;
            com.vivo.push.util.t.a("PushClientManager", "task is null");
            return;
        L6:
            r100.run();
        }

        public final Object[] b() {
            return this.f462416e;
        }

        public final void a(IPushActionListener r100) {
            this.f462414c = r100;
        }

        public final void a(Runnable r100) {
            this.f462415d = r100;
        }

        public a(com.vivo.push.b.c r100, IPushActionListener r101) {
            this.f462413b = r100;
            this.f462412a = r101;
        }

        public final void a(int r100, Object... r101) {
            this.f462416e = r101;
            IPushActionListener r102 = this.f462414c;
            if (r102 == null) goto L5;
            r102.onStateChanged(r100);
        L5:
            IPushActionListener r103 = this.f462412a;
            if (r103 == null) goto L9;
            r103.onStateChanged(r100);
            return;
        }
    }

    public final void e() {
        this.f462404j = null;
        com.vivo.push.restructure.a.a().e().j();
    }

    public static synchronized m a() {
        monitor-enter(m.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f462395a != null) goto L7;
        f462395a = new m();     // Catch: Throwable -> L10
    L7:
        m r100 = f462395a;     // Catch: Throwable -> L10
        monitor-exit(m.class);
        return r100;
    }

    private boolean l() {
        if (this.f462407m != null) goto L12;
        if (k() >= 1230) goto L7;
    L9:
        boolean r100 = false;
    L10:
        this.f462407m = Boolean.valueOf(r100);
        goto L12
    L7:
        if (ah.d(this.f462402h) == false) goto L9;
        r100 = true;
    L12:
        return this.f462407m.booleanValue();
    }

    public final void b() throws VivoPushException {
        Context r100 = this.f462402h;
        if (r100 == null) goto L6;
        ah.b(r100);
        return;
    }

    public final boolean d() {
        if (this.f462402h != null) goto L6;
        com.vivo.push.util.t.d("PushClientManager", "support:context is null");
        return false;
    L6:
        Boolean r100 = Boolean.valueOf(l());
        this.f462407m = r100;
        return r100.booleanValue();
    }

    public final long k() {
        Context r100 = this.f462402h;
        if (r100 != null) goto L7;
        return -1;
    L7:
        if (this.f462408n != null) goto L10;
        this.f462408n = Long.valueOf(ah.a(r100));
    L10:
        return this.f462408n.longValue();
    }

    private m() {
        this.f462396b = -1;
        this.f462397c = -1;
        this.f462398d = -1;
        this.f462399e = -1;
        this.f462400f = -1;
        this.f462401g = -1;
        this.f462403i = true;
        this.f462405k = new SparseArray();
        this.f462406l = 0;
        this.f462410p = new l();
    }

    public static List<String> c() {
        String r100 = com.vivo.push.restructure.a.a().e().g();
        ArrayList r101 = new ArrayList();
    L11:
        com.vivo.push.restructure.a.a().e().h();
        r101.clear();
        com.vivo.push.util.t.d("PushClientManager", "getTags error");
    L12:
        return r101;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r101;
    L6:
        Iterator<String> r102 = new JSONObject(r100).keys();     // Catch: JSONException -> L11
    L8:
        if (r102.hasNext() == false) goto L12;
        r101.add(r102.next());     // Catch: JSONException -> L11
        goto L8
    }

    public final boolean f() {
        return this.f462409o;
    }

    public final boolean g() {
        return this.f462403i;
    }

    public final Context h() {
        return this.f462402h;
    }

    public final String i() {
        return this.f462404j;
    }

    public final int j() {
        return this.f462411q;
    }

    private synchronized a b(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L14;
    L10:
        monitor-exit(this);
        return null;
    L14:
        int r101 = CastIntegerProtector.parseInt(r100);     // Catch: Throwable -> L7 Exception -> L13
        a r102 = this.f462405k.get(r101);     // Catch: Throwable -> L7 Exception -> L13
        this.f462405k.delete(r101);     // Catch: Throwable -> L7 Exception -> L13
        monitor-exit(this);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    private void c(String r100) {
        t.a(new r(this, r100));
    }

    public final void a(v r100) {
        Context r101 = a().f462402h;
        if (r100 != null) goto L8;
        com.vivo.push.util.t.a("PushClientManager", "sendCommand, null command!");
        if (r101 == null) goto L16;
        com.vivo.push.util.t.c(r101, "[执行指令失败]指令空！");
        return;
    L16:
        return;
    L8:
        s r102 = this.f462410p.createTask(r100);
        if (r102 != null) goto L14;
        com.vivo.push.util.t.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(r100)));
        if (r101 == null) goto L17;
        com.vivo.push.util.t.c(r101, "[执行指令失败]指令" + r100 + "任务空！");
        return;
    L17:
        return;
    L14:
        com.vivo.push.util.t.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(r100)));
        t.a(r102, v.c());
    }

    public final synchronized void a(Context r100) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.f462402h != null) goto L6;
        this.f462402h = ContextDelegate.getContext(r100);     // Catch: Throwable -> L8
        this.f462409o = com.vivo.push.util.aa.c(r100, r100.getPackageName());     // Catch: Throwable -> L8
        ad.c().a(this.f462402h);     // Catch: Throwable -> L8
        a(new com.vivo.push.b.g());     // Catch: Throwable -> L8
        this.f462404j = com.vivo.push.restructure.a.a().e().i();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public static boolean a(long r100) {
        long r101 = SystemClock.elapsedRealtime();
        if (r100 != (-1)) goto L5;
        return true;
    L5:
        if (r101 > r100) goto L7;
        return true;
    L7:
        if (r101 >= (r100 + 2000)) goto L14;
        return false;
    L14:
        return true;
    }

    private synchronized String a(a r100) {
        monitor-enter(this);
        this.f462405k.put(this.f462406l, r100);     // Catch: Throwable -> L6
        int r101 = this.f462406l;     // Catch: Throwable -> L6
        this.f462406l = r101 + 1;     // Catch: Throwable -> L6
        String r102 = Integer.toString(r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r102;
    L6:
        th = move-exception;
        throw th;
    }

    public final void a(String r100) {
        this.f462404j = r100;
        com.vivo.push.restructure.a.a().e().e(r100);
    }

    public final void a(List<String> r100) {
        if (r100.contains(this.f462404j) == false) goto L6;
        e();
        return;
    }

    public final void a(boolean r100) {
        this.f462403i = r100;
    }

    public static /* synthetic */ a b(m r100, String r101) {
        return r100.b(r101);
    }

    public final int a(Intent r100, PushMessageCallback r101) {
        v r102 = this.f462410p.createReceiverCommand(r100);
        Context r103 = a().f462402h;
        if (r102 != null) goto L9;
        com.vivo.push.util.t.a("PushClientManager", "sendCommand, null command!");
        if (r103 == null) goto L22;
        com.vivo.push.util.t.c(r103, "[执行指令失败]指令空！");
        return 2805;
    L22:
        return 2805;
    L9:
        com.vivo.push.h.ab r104 = this.f462410p.createReceiveTask(r102);
        if (r104 != null) goto L16;
        com.vivo.push.util.t.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(r102)));
        if (r103 == null) goto L23;
        com.vivo.push.util.t.c(r103, "[执行指令失败]指令" + r102 + "任务空！");
        return 2806;
    L23:
        return 2806;
    L16:
        if (r103 != null) goto L18;
    L20:
        r104.a(r101);
        r104.run();
        return r104.c();
    L18:
        if ((r102 instanceof com.vivo.push.b.n) == true) goto L20;
        com.vivo.push.util.t.a(r103, "[接收指令]".concat(String.valueOf(r102)));
        goto L20
    }

    private a a(com.vivo.push.b.b r100, IPushActionListener r101) {
        a r102 = new a(r100, r101);
        String r103 = a(r102);
        r100.b(r103);
        r102.a(new o(this, r100, r103));
        return r102;
    }

    public final void a(String r100, int r101) {
        a r102 = b(r100);
        if (r102 == null) goto L6;
        r102.a(r101, new Object[0]);
        return;
    L6:
        com.vivo.push.util.t.d("PushClientManager", "notifyStatusChanged token is null");
    }

    private static boolean a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return true;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public static /* synthetic */ void a(m r100, String r101) {
        r100.c(r101);
    }

    public final void a(IPushActionListener r100, String r101, String r102) {
        if (this.f462402h != null) goto L8;
        if (r100 == null) goto L33;
        r100.onStateChanged(102);
        return;
    L33:
        return;
    L8:
        if (a(r101, r102) == false) goto L12;
        if (r100 == null) goto L34;
        r100.onStateChanged(10001);
        return;
    L34:
        return;
    L12:
        com.vivo.push.restructure.a.a().h().b();
        if (a(this.f462396b) == true) goto L17;
        if (r100 == null) goto L35;
        r100.onStateChanged(1002);
        return;
    L35:
        return;
    L17:
        this.f462396b = SystemClock.elapsedRealtime();
        String r103 = this.f462402h.getPackageName();
        a r104 = null;
        if (this.f462402h != null) goto L21;
        if (r100 == null) goto L29;
        r100.onStateChanged(102);
    L29:
        if (r104 != null) goto L31;
        return;
    L31:
        r104.a(new n(this, r104, r101, r102));
        r104.a();
        return;
    L21:
        com.vivo.push.b.b r105 = new com.vivo.push.b.b(true, r103);
        r105.f();
        r105.c(r101);
        r105.d(r102);
        r105.b(100);
        if (this.f462409o == true) goto L24;
        r104 = a(r105, r100);
        goto L29
    L24:
        if (l() == true) goto L27;
        if (r100 == null) goto L29;
        r100.onStateChanged(101);
        goto L29
    L27:
        r104 = a(r105, r100);
        goto L29
    }

    public final void b(IPushActionListener r100, String r101, String r102) {
        a(r100, r101, r102, 11);
    }

    public final void c(IPushActionListener r100, String r101, String r102) {
        a(r100, r101, r102, 1);
    }

    public final void a(String r100, int r101, Object... r102) {
        a r103 = b(r100);
        if (r103 == null) goto L6;
        r103.a(r101, r102);
        return;
    L6:
        com.vivo.push.util.t.d("PushClientManager", "notifyApp token is null");
    }

    public final void a(String r100, String r101, String r110, IPushActionListener r111) {
        if (this.f462402h != null) goto L8;
        if (r111 == null) goto L44;
        r111.onStateChanged(102);
        return;
    L44:
        return;
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L13;
        if (r111 == null) goto L45;
        r111.onStateChanged(30002);
        return;
    L45:
        return;
    L13:
        if (com.vivo.push.restructure.a.a().g().f() == true) goto L38;
        boolean r102 = false;
        if (TextUtils.isEmpty(this.f462404j) == true) goto L21;
        if (this.f462404j.equals(r100) == false) goto L21;
        if (r111 == null) goto L24;
        r111.onStateChanged(0);
    L24:
        r102 = true;
    L35:
        if (r102 == false) goto L38;
        return;
    L21:
        if (r100.length() <= 70) goto L26;
        if (r111 == null) goto L24;
        r111.onStateChanged(30003);
        goto L24
    L26:
        if (this.f462409o == false) goto L35;
        if (l() == true) goto L32;
        if (r111 == null) goto L24;
        r111.onStateChanged(101);
        goto L24
    L32:
        if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b()) == false) goto L35;
        if (r111 == null) goto L24;
        r111.onStateChanged(30001);
    L38:
        if (a(this.f462398d) == true) goto L42;
        if (r111 == null) goto L46;
        r111.onStateChanged(1002);
        return;
    L46:
        return;
    L42:
        ArrayList r103 = new ArrayList();
        r103.add(r100);
        com.vivo.push.b.a r104 = new com.vivo.push.b.a(true, this.f462402h.getPackageName(), r103);
        r104.b(100);
        r104.c(r101);
        r104.d(r110);
        this.f462398d = SystemClock.elapsedRealtime();
        String r105 = a(new a(r104, r111));
        r104.b(r105);
        a(r104);
        c(r105);
    }

    public final void b(String r100, String r101, String r102, IPushActionListener r110) {
        if (this.f462402h != null) goto L8;
        if (r110 == null) goto L41;
        r110.onStateChanged(102);
        return;
    L41:
        return;
    L8:
        if (TextUtils.isEmpty(this.f462404j) == false) goto L13;
        if (r110 == null) goto L42;
        r110.onStateChanged(0);
        return;
    L42:
        return;
    L13:
        if (TextUtils.isEmpty(r100) == false) goto L18;
        if (r110 == null) goto L43;
        r110.onStateChanged(30002);
        return;
    L43:
        return;
    L18:
        if (r100.length() <= 70) goto L23;
        if (r110 == null) goto L44;
        r110.onStateChanged(30003);
        return;
    L44:
        return;
    L23:
        if (a(this.f462399e) == true) goto L28;
        if (r110 == null) goto L45;
        r110.onStateChanged(1002);
        return;
    L45:
        return;
    L28:
        if (this.f462409o == true) goto L30;
    L39:
        ArrayList r103 = new ArrayList();
        r103.add(r100);
        com.vivo.push.b.a r104 = new com.vivo.push.b.a(false, this.f462402h.getPackageName(), r103);
        r104.b(100);
        r104.c(r101);
        r104.d(r102);
        this.f462399e = SystemClock.elapsedRealtime();
        String r105 = a(new a(r104, r110));
        r104.b(r105);
        a(r104);
        c(r105);
        return;
    L30:
        if (l() == true) goto L35;
        if (r110 == null) goto L46;
        r110.onStateChanged(101);
        return;
    L46:
        return;
    L35:
        if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b()) == false) goto L39;
        if (r110 == null) goto L47;
        r110.onStateChanged(30001);
        return;
    }

    public final void a(ArrayList<String> r100, String r101, String r110, IPushActionListener r111) {
        if (this.f462402h != null) goto L8;
        if (r111 == null) goto L47;
        r111.onStateChanged(102);
        return;
    L47:
        return;
    L8:
        if (a(this.f462400f) == true) goto L12;
        if (r111 == null) goto L48;
        r111.onStateChanged(1002);
        return;
    L48:
        return;
    L12:
        this.f462400f = SystemClock.elapsedRealtime();
        if (r100.size() >= 0) goto L18;
        if (r111 == null) goto L49;
        r111.onStateChanged(20002);
        return;
    L49:
        return;
    L18:
        if ((r100.size() + c().size()) <= 500) goto L22;
        if (r111 == null) goto L50;
        r111.onStateChanged(20004);
        return;
    L50:
        return;
    L22:
        Iterator<String> r102 = r100.iterator();
    L24:
        if (r102.hasNext() == false) goto L31;
        if (r102.next().length() <= 70) goto L24;
        if (r111 == null) goto L51;
        r111.onStateChanged(20003);
        return;
    L51:
        return;
    L31:
        if (this.f462409o == true) goto L33;
    L42:
        com.vivo.push.b.z r103 = new com.vivo.push.b.z(true, this.f462402h.getPackageName(), r100);
        r103.b(500);
        r103.c(r101);
        r103.d(r110);
        String r104 = a(new a(r103, r111));
        r103.b(r104);
        a(r103);
        c(r104);
        return;
    L33:
        if (l() == true) goto L38;
        if (r111 == null) goto L52;
        r111.onStateChanged(101);
        return;
    L52:
        return;
    L38:
        if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b()) == false) goto L42;
        if (r111 == null) goto L53;
        r111.onStateChanged(20001);
        return;
    }

    public final void b(ArrayList<String> r100, String r101, String r102, IPushActionListener r110) {
        if (this.f462402h != null) goto L8;
        if (r110 == null) goto L42;
        r110.onStateChanged(102);
        return;
    L42:
        return;
    L8:
        if (a(this.f462401g) == true) goto L12;
        if (r110 == null) goto L43;
        r110.onStateChanged(1002);
        return;
    L43:
        return;
    L12:
        this.f462401g = SystemClock.elapsedRealtime();
        if (r100.size() >= 0) goto L17;
        if (r110 == null) goto L44;
        r110.onStateChanged(20002);
        return;
    L44:
        return;
    L17:
        Iterator<String> r103 = r100.iterator();
    L19:
        if (r103.hasNext() == false) goto L26;
        if (r103.next().length() <= 70) goto L19;
        if (r110 == null) goto L45;
        r110.onStateChanged(20003);
        return;
    L45:
        return;
    L26:
        if (this.f462409o == true) goto L28;
    L37:
        com.vivo.push.b.z r104 = new com.vivo.push.b.z(false, this.f462402h.getPackageName(), r100);
        r104.b(500);
        r104.c(r101);
        r104.d(r102);
        String r105 = a(new a(r104, r110));
        r104.b(r105);
        a(r104);
        c(r105);
        return;
    L28:
        if (l() == true) goto L33;
        if (r110 == null) goto L46;
        r110.onStateChanged(101);
        return;
    L46:
        return;
    L33:
        if (TextUtils.isEmpty(com.vivo.push.restructure.a.a().h().b()) == false) goto L37;
        if (r110 == null) goto L47;
        r110.onStateChanged(20001);
        return;
    }

    private void a(IPushActionListener r100, String r101, String r110, int r111) {
        if (this.f462402h != null) goto L8;
        if (r100 == null) goto L22;
        r100.onStateChanged(102);
        return;
    L22:
        return;
    L8:
        if (a(r101, r110) == false) goto L13;
        if (r100 == null) goto L23;
        r100.onStateChanged(10001);
        return;
    L23:
        return;
    L13:
        if (a(this.f462397c) == true) goto L17;
        if (r100 == null) goto L24;
        r100.onStateChanged(1002);
        return;
    L24:
        return;
    L17:
        this.f462397c = SystemClock.elapsedRealtime();
        a r102 = a(r100, this.f462402h.getPackageName(), r101, r110, r111);
        if (r102 != null) goto L20;
        return;
    L20:
        r102.a(new p(this));
        r102.a();
    }

    private a a(IPushActionListener r100, String r101, String r102, String r103, int r104) {
        if (this.f462402h != null) goto L7;
        if (r100 == null) goto L6;
        r100.onStateChanged(102);
    L6:
        return null;
    L7:
        com.vivo.push.b.b r105 = new com.vivo.push.b.b(false, r101);
        r105.c(r102);
        r105.d(r103);
        if (r104 <= 0) goto L10;
        r105.a(r104);
    L10:
        r105.f();
        r105.b(100);
        if (this.f462409o == false) goto L20;
        if (l() == true) goto L17;
        if (r100 == null) goto L16;
        r100.onStateChanged(101);
    L16:
        return null;
    L17:
        a r106 = new a(r105, r100);
        String r107 = a(r106);
        r105.b(r107);
        r106.a(new q(this, r105, r107));
        return r106;
    L20:
        if (r105.a(this.f462402h) != 2) goto L24;
        return a(r105, r100);
    L24:
        return a(r105, r100);
    }
}
