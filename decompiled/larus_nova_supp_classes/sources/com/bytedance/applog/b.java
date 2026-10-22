package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.applog.log.j;
import com.bytedance.applog.log.n;
import com.bytedance.applog.monitor.v3.EventStage;
import com.bytedance.applog.monitor.v3.StageEventType;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.params.CommonParamsWrapper;
import com.bytedance.applog.params.lifecycle.LifecycleValueObserver;
import com.bytedance.applog.priority.PriorityCallbackImpl;
import com.bytedance.applog.priority.PriorityWrapper;
import com.bytedance.applog.util.EventsSenderUtils;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.d0;
import com.bytedance.bdinstall.f0;
import com.bytedance.bdinstall.g0;
import com.bytedance.bdinstall.k;
import com.bytedance.bdinstall.n0;
import com.bytedance.bdinstall.r;
import com.bytedance.bdinstall.t;
import com.bytedance.bdinstall.t0;
import com.bytedance.bdinstall.u;
import com.bytedance.bdinstall.y;
import ex3.e;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import rw3.f;
import uw3.i;
import xw3.c;
import xw3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b implements g {
    public static final List<b> A0 = null;
    public static final AtomicInteger B0 = null;
    public static final long z0 = 0;
    public volatile boolean A;
    public final AtomicInteger B;
    public volatile boolean C;
    public volatile boolean D;
    public volatile boolean E;
    public volatile boolean F;
    public volatile boolean G;
    public volatile boolean H;
    public volatile int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public volatile int f1J;
    public volatile boolean K;
    public volatile HashSet<String> L;
    public volatile int M;
    public volatile int N;
    public volatile boolean O;
    public volatile boolean P;
    public volatile boolean Q;
    public volatile boolean R;
    public volatile boolean S;
    public volatile int T;
    public volatile kx3.b U;
    public final ax3.a V;
    public final e W;
    public volatile Long X;
    public volatile Integer Y;
    public volatile m Z;
    public final d a;
    public volatile IBDAccountCallback a0;
    public final xw3.a b;
    public final c b0;
    public final xw3.b c;
    public volatile boolean c0;
    public final zw3.a d;
    public volatile DataIsolateKey d0;
    public final ix3.c e;
    public volatile JSONObject e0;
    public final ix3.a f;
    public PriorityWrapper f0;
    public final nx3.b g;
    public volatile boolean g0;
    public final int h;
    public volatile boolean h0;
    public int i;
    public volatile ConcurrentHashMap<String, String> i0;
    public String j;
    public volatile boolean j0;
    public volatile Application k;
    public volatile boolean k0;
    public volatile zw3.b l;
    public volatile boolean l0;
    public volatile zw3.d m;
    public volatile boolean m0;
    public volatile f n;
    public volatile boolean n0;
    public final ow3.a o;
    public volatile boolean o0;
    public volatile boolean p;
    public volatile boolean p0;
    public volatile k q;
    public volatile boolean q0;
    public volatile Integer r;
    public volatile long r0;
    public volatile uw3.a s;
    public final a s0;
    public nx3.a t;
    public final n t0;
    public volatile Proxy u;
    public final AtomicBoolean u0;
    public volatile boolean v;
    public final List<String> v0;
    public final nw3.f w;
    public final ow3.d w0;
    public volatile boolean x;
    public final mw3.a x0;
    public volatile boolean y;
    public final fx3.e y0;
    public volatile boolean z;

    public class a extends com.bytedance.applog.log.b<CommonParamsWrapper> {
        public a() {
        }

        @Override // com.bytedance.applog.log.b
        public final CommonParamsWrapper a(Object[] r2) {
            return new CommonParamsWrapper(String.valueOf(hashCode()));
        }
    }

    @Override // com.bytedance.applog.g
    public final void D1() {
    }

    public final String N1() {
        if (this.m == null) goto L9;
        zw3.b r0 = this.m.d;
        if (r0.q != null) goto L8;
        r0.q = r0.c.getString("ab_sdk_version", XmlPullParser.NO_NAMESPACE);
    L8:
        return r0.q;
    L9:
        return null;
    }

    @Override // com.bytedance.applog.g
    public final void T() {
    }

    @Override // com.bytedance.applog.g
    public final void U(f r1) {
    }

    @Override // com.bytedance.applog.g
    public final void e1() {
    }

    @Override // com.bytedance.applog.g
    public final void n0() {
    }

    @Override // com.bytedance.applog.g
    public final void w1() {
        this.K = false;
        if (this.n == null) goto L6;
        this.n.m.obtainMessage(26, Boolean.FALSE).sendToTarget();
        return;
    }

    @Override // com.bytedance.applog.g
    public final void B1() {
        if (this.n == null) goto L6;
        this.n.a(false, 21, 0, null);
        return;
    }

    @Override // com.bytedance.applog.g
    public final i C() {
        if (this.n != null) goto L7;
        return null;
    L7:
        return this.n.t;
    }

    @Override // com.bytedance.applog.g
    public final void G0() {
        nx3.a r0 = this.t;
        if (r0 == null) goto L6;
        r0.a.clear();
        return;
    }

    @Override // com.bytedance.applog.g
    public final boolean J() {
        ((k) this.w.b()).getClass();
        if (k.a() == null) goto L8;
        return true;
    L8:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    @Override // com.bytedance.applog.g
    public final void N() {
        if (this.n == null) goto L5;
        f r0 = this.n;
        r0.m.removeMessages(14);
        r0.m.sendEmptyMessage(14);
    L5:
        this.W.b(StatsCountKeys.FLUSH_COUNT, 1);
    }

    public final com.bytedance.applog.params.c O1() {
        if (this.l0 == false) goto L6;
        return this.s0.b(new Object[0]);
    L6:
        return com.bytedance.applog.params.e.a;
    }

    public final int P1() {
        return this.B.get();
    }

    public final long Q1() {
        if (this.n != null) goto L7;
        return 0;
    L7:
        return this.n.k.j.incrementAndGet();
    }

    public final Object R1() {
        if (this.l != null) goto L6;
        this.t0.i("call getOpaquePayload after init plz.", new Object[0]);
        return null;
    L6:
        String r0 = this.l.e.getString("opaque_payload", null);
        if (r0 != null) goto L9;
        return null;
    L9:
        if (r0.isEmpty() == true) goto L20;
        Object r1 = new JSONObject(r0).opt("opaque_payload");     // Catch: Throwable -> L16
        if (r1 != JSONObject.NULL) goto L15;
        return null;
    L15:
        return r1;
    L22:
        return null;
    L20:
        return null;
    }

    public final PriorityWrapper S1() {
        if (this.D == true) goto L7;
        return null;
    L7:
        return this.f0;
    }

    @Override // com.bytedance.applog.g
    public final y V() {
        return this.w.b();
    }

    @Override // com.bytedance.applog.g
    public final void Z0() {
        if (this.n == null) goto L7;
        f r0 = this.n;
        Handler r1 = r0.m;
        if (r1 == null) goto L9;
        r1.removeMessages(28);
        r0.m.sendEmptyMessage(28);
        return;
    L9:
        return;
    L7:
        this.t0.s(null, "init priority failed for not init engine!", null, new Object[0]);
    }

    @Override // com.bytedance.applog.g
    public final boolean c() {
        Integer r0 = ((k) this.w.b()).g();
        if (r0 == null) goto L8;
        g84.c r1 = (g84.c) g84.e.a(g84.c.class, String.valueOf(r0));
        if (r1 == null) goto L8;
        return r1.c();
    L8:
        return false;
    }

    @Override // com.bytedance.applog.g
    public final Map<String, String> d() {
        k r0 = (k) this.w.b();
        if (r0.e() == true) goto L5;
    L9:
        return null;
    L5:
        if (r0.a == null) goto L9;
        r r1 = (r) g84.e.a(r.class, String.valueOf(r0.a.a));
        if (r1 == null) goto L9;
        return r1.d();
    }

    @Override // com.bytedance.applog.g
    public final String e0() {
        n0 r0 = this.w.c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    @Override // com.bytedance.applog.g
    public final void flush() {
        if (this.G == false) goto L7;
        N();
        return;
    L7:
        if (this.n == null) goto L9;
        this.n.j(null, true);
    L9:
        this.W.b(StatsCountKeys.FLUSH_COUNT, 1);
    }

    @Override // com.bytedance.applog.g
    public final void g() {
        if (this.n == null) goto L8;
        Handler r0 = this.n.m;
        if (r0 == null) goto L9;
        r0.obtainMessage(22, Boolean.FALSE).sendToTarget();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.applog.g
    public final int g1() {
        if (this.r == null) goto L7;
        return this.r.intValue();
    L7:
        if (this.l != null) goto L9;
        return 0;
    L9:
        return this.l.e.getInt("http_monitor_port", 0);
    }

    @Override // com.bytedance.applog.g
    public final String getAbSdkVersion() {
        if (this.n != null) goto L6;
        return null;
    L6:
        long r0 = this.n.k.a;
        IBDAccountCallback r2 = this.a0;
        if (r2 == null) goto L9;
        r0 = ((Long) r2.getOdinUserInfo().second).longValue();
    L9:
        String.valueOf(r0);
        return N1();
    }

    @Override // com.bytedance.applog.g
    public final com.bytedance.applog.params.b getCommonParams() {
        if (this.l0 == false) goto L6;
        return this.s0.b(new Object[0]);
    L6:
        return com.bytedance.applog.params.e.a;
    }

    @Override // com.bytedance.applog.g
    public final String getDid() {
        nw3.f r0 = this.w;
        if (TextUtils.isEmpty(r0.h) == false) goto L16;
        k r1 = (k) r0.b();
        if (r1.a != null) goto L7;
    L10:
        t.b("BDInstall#getDid error, not init yet!");
        n0 r2 = r1.q();
        if (r2 != null) goto L13;
        String r3 = null;
    L14:
        r0.h = r3;
        goto L16
    L13:
        r3 = r2.a;
        goto L14
    L7:
        if (r1.a.getContext() == null) goto L10;
        r3 = r1.h.b(new Object[]{r1.a.getContext()}).getDid();
    L16:
        return r0.h;
    }

    @Override // com.bytedance.applog.g
    public final JSONObject getHeader() {
        if (this.m != null) goto L7;
        this.t0.i("Init first please to get header", new Object[0]);
        return null;
    L7:
        return this.m.a();
    }

    @Override // com.bytedance.applog.g
    public final String getIid() {
        nw3.f r0 = this.w;
        if (TextUtils.isEmpty(r0.i) == false) goto L10;
        n0 r1 = r0.c();
        if (r1 == null) goto L7;
        String r2 = r1.b;
    L8:
        r0.i = r2;
        goto L10
    L7:
        r2 = null;
    L10:
        return r0.i;
    }

    @Override // com.bytedance.applog.g
    public final q getInitConfig() {
        if (this.l != null) goto L7;
        return null;
    L7:
        return this.l.b;
    }

    @Override // com.bytedance.applog.g
    public final g0 getNetClient() {
        g0 r0 = this.l.b.t;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.g;
    }

    @Override // com.bytedance.applog.g
    public final String getOpenUdid() {
        n0 r0 = this.w.c();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    @Override // com.bytedance.applog.g
    public final String getSessionId() {
        if (this.n != null) goto L7;
        return null;
    L7:
        return this.n.k.i;
    }

    @Override // com.bytedance.applog.g
    public final String getSsid() {
        nw3.f r0 = this.w;
        if (TextUtils.isEmpty(r0.j) == false) goto L10;
        n0 r1 = r0.c();
        if (r1 == null) goto L7;
        String r2 = r1.e;
    L8:
        r0.j = r2;
        goto L10
    L7:
        r2 = null;
    L10:
        return r0.j;
    }

    @Override // com.bytedance.applog.g
    public final String getUserID() {
        if (this.n != null) goto L7;
        return null;
    L7:
        return String.valueOf(this.n.k.a);
    }

    @Override // com.bytedance.applog.g
    public final String getUserUniqueID() {
        if (this.m != null) goto L5;
        return XmlPullParser.NO_NAMESPACE;
    L5:
        return this.m.d();
    }

    @Override // com.bytedance.applog.g
    public final boolean isNewUser() {
        return ((k) this.w.b()).m();
    }

    @Override // com.bytedance.applog.g
    public final boolean k0() {
        return ((k) this.w.b()).b();
    }

    @Override // com.bytedance.applog.g
    public final void l() {
        if (this.n == null) goto L8;
        Handler r0 = this.n.m;
        if (r0 == null) goto L9;
        r0.obtainMessage(22, Boolean.TRUE).sendToTarget();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.applog.g
    public final tw3.b l0() {
        if (this.q0 == true) goto L5;
    L7:
        tw3.c r0 = null;
    L8:
        if (r0 == null) goto L11;
        return r0;
    L11:
        return tw3.a.a;
    L5:
        if (this.n == null) goto L7;
        r0 = this.n.z;
        goto L8
    }

    @Override // com.bytedance.applog.g
    public final void onActivityPause() {
        this.o.onActivityPaused(null);
    }

    @Override // com.bytedance.applog.g
    public final void r1() {
        Integer r0 = ((k) this.w.b()).g();
        if (r0 == null) goto L10;
        g84.c r1 = (g84.c) g84.e.a(g84.c.class, String.valueOf(r0));
        if (r1 == null) goto L9;
        r1.getApi();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.applog.g
    public final void start() {
        if (this.p == true) goto L9;
        this.p = true;
        f r1 = this.n;
        if (r1.p == true) goto L7;
        r1.p = true;
        r1.m.sendEmptyMessage(1);
        r1.m.sendEmptyMessageDelayed(2, 200);
    L7:
        this.t0.l("System start!", new Object[0]);
        return;
    }

    @Override // com.bytedance.applog.g
    public final void stop() {
        this.t0.l("System stop!", new Object[0]);
        if (this.p == false) goto L6;
        this.p = false;
        return;
    }

    public final String toString() {
        return "AppLogInstance{id:" + this.h + ";appId:" + this.j + "}@" + hashCode();
    }

    @Override // com.bytedance.applog.g
    public final void y() {
        if (this.n == null) goto L6;
        this.n.e().getClass();
        return;
    }

    static {
        z0 = System.currentTimeMillis();
        A0 = new CopyOnWriteArrayList();
        B0 = new AtomicInteger(0);
    }

    public b() {
        this.a = new d();
        this.b = new xw3.a();
        this.c = new xw3.b();
        this.i = 0;
        this.j = XmlPullParser.NO_NAMESPACE;
        this.k = null;
        this.v = true;
        this.x = false;
        this.y = false;
        this.z = true;
        this.A = false;
        this.B = new AtomicInteger(0);
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = true;
        this.H = false;
        this.I = 5;
        this.f1J = 200;
        this.K = false;
        this.L = new HashSet();
        this.M = 200;
        this.N = 20;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = 8;
        this.U = null;
        this.V = new ax3.a();
        this.c0 = false;
        this.e0 = null;
        this.f0 = null;
        this.g0 = true;
        this.h0 = false;
        this.i0 = new ConcurrentHashMap();
        this.j0 = false;
        this.k0 = false;
        this.l0 = true;
        this.m0 = true;
        this.n0 = false;
        this.o0 = false;
        this.p0 = false;
        this.q0 = false;
        this.r0 = 0;
        this.s0 = new a();
        this.u0 = new AtomicBoolean(false);
        this.v0 = new CopyOnWriteArrayList();
        this.x0 = new mw3.a();
        this.y0 = new fx3.e();
        this.h = B0.getAndIncrement();
        this.t0 = new n();
        this.f = new ix3.a(this);
        this.b0 = new c(this);
        this.e = new ix3.c(this);
        this.g = new nx3.b(this);
        ((CopyOnWriteArrayList) A0).add(this);
        this.d = new zw3.a(this);
        this.w = new nw3.f(this);
        this.o = new ow3.a(this);
        this.W = new e();
        this.w0 = new ow3.d();
    }

    public final boolean T1() {
        q r0 = getInitConfig();
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.E;
    }

    @Override // com.bytedance.applog.g
    public final boolean c0() {
        if (getInitConfig() == null) goto L6;
        getInitConfig().getClass();
    L6:
        return this.E;
    }

    @Override // com.bytedance.applog.g
    public final boolean C0() {
        return this.x;
    }

    @Override // com.bytedance.applog.g
    public final fx3.e L1() {
        return this.y0;
    }

    @Override // com.bytedance.applog.g
    public final boolean P0() {
        return this.D;
    }

    @Override // com.bytedance.applog.g
    public final Integer Q0() {
        return this.Y;
    }

    @Override // com.bytedance.applog.g
    public final mw3.a R() {
        return this.x0;
    }

    @Override // com.bytedance.applog.g
    public final boolean U0() {
        return this.q0;
    }

    @Override // com.bytedance.applog.g
    public final e X() {
        return this.W;
    }

    @Override // com.bytedance.applog.g
    public final uw3.a Y() {
        return this.s;
    }

    @Override // com.bytedance.applog.g
    public final boolean Y0() {
        return this.z;
    }

    @Override // com.bytedance.applog.g
    public final boolean e() {
        return this.y;
    }

    @Override // com.bytedance.applog.g
    public final String getAid() {
        return this.j;
    }

    @Override // com.bytedance.applog.g
    public final String getAppId() {
        return this.j;
    }

    @Override // com.bytedance.applog.g
    public Context getContext() {
        return this.k;
    }

    @Override // com.bytedance.applog.g
    public final boolean getEncryptAndCompress() {
        return this.v;
    }

    @Override // com.bytedance.applog.g
    public final m h() {
        return this.Z;
    }

    @Override // com.bytedance.applog.g
    public final boolean i() {
        return this.p;
    }

    @Override // com.bytedance.applog.g
    public final boolean q0() {
        return this.p0;
    }

    @Override // com.bytedance.applog.g
    public final boolean q1() {
        return this.A;
    }

    @Override // com.bytedance.applog.g
    public final k u() {
        return this.q;
    }

    @Override // com.bytedance.applog.g
    public final IBDAccountCallback v() {
        return this.a0;
    }

    @Override // com.bytedance.applog.g
    public final boolean z1() {
        return this.C;
    }

    @Override // com.bytedance.applog.g
    public final void A(ow3.b r2) {
        this.o.i = r2;
    }

    @Override // com.bytedance.applog.g
    public final void A0(boolean r3) {
        this.m0 = r3;
        this.W.j("flush_threshold_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void A1(boolean r3) {
        this.c0 = r3;
        this.W.j("isolate_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void B(boolean r3) {
        if (this.n == null) goto L6;
        this.n.m.obtainMessage(27, Boolean.valueOf(r3)).sendToTarget();
        return;
    }

    @Override // com.bytedance.applog.g
    public final void B0(boolean r3) {
        this.E = r3;
        this.W.j("bg_session_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void C1(boolean r3) {
        this.W.a.c(r3);
        this.W.j("monitor_debug_mode", r3);
    }

    @Override // com.bytedance.applog.g
    public final void D(String r3) {
        ow3.d r0 = this.w0;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "id");
        r0.b = r3;
    }

    @Override // com.bytedance.applog.g
    public final void D0(long r4) {
        if (this.n != null) goto L5;
    L9:
        this.X = Long.valueOf(r4);
        return;
    L5:
        if (this.n.k == null) goto L9;
        if (this.n.k.a == r4) goto L11;
        this.n.k.a = r4;
        return;
    }

    @Override // com.bytedance.applog.g
    public final void E(String r9) {
        if (this.m == null) goto L18;
        zw3.d r0 = this.m;
        monitor-enter(r0);
        Set r1 = zw3.d.c(r0.d.c());     // Catch: Throwable -> L15
        Set r2 = zw3.d.c(r0.e.optString("ab_sdk_version"));     // Catch: Throwable -> L15
        r2.removeAll(r1);     // Catch: Throwable -> L15
        r2.addAll(zw3.d.c(r9));     // Catch: Throwable -> L15
        zw3.b r3 = r0.d;     // Catch: Throwable -> L15
        r3.n.t0.k(0, zw3.b.v, "setExternalAbVersion: {}", new Object[]{r9});     // Catch: Throwable -> L15
        r3.c.edit().putString("external_ab_version", r9).apply();     // Catch: Throwable -> L15
        r3.f = null;     // Catch: Throwable -> L15
        StringBuilder r10 = new StringBuilder();     // Catch: Throwable -> L15
        Iterator r4 = ((HashSet) r2).iterator();     // Catch: Throwable -> L15
    L8:
        if (r4.hasNext() == false) goto L12;
        r10.append((String) r4.next());     // Catch: Throwable -> L15
        if (r4.hasNext() == false) goto L8;
        r10.append(",");     // Catch: Throwable -> L15
        goto L8
    L12:
        r0.g(r10.toString());     // Catch: Throwable -> L15
        monitor-exit(r0);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.applog.g
    public final synchronized void E0(h r2) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.t != null) goto L6;
        this.t = new nx3.a();     // Catch: Throwable -> L12
    L6:
        nx3.a r0 = this.t;     // Catch: Throwable -> L12
        if (r2 == null) goto L9;
        r0.a.add(r2);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L9:
        r0.getClass();     // Catch: Throwable -> L12
        goto L10
    }

    @Override // com.bytedance.applog.g
    public final void F(boolean r3) {
        this.z = r3;
        this.W.j("tourist_mode_event_enable", r3);
        W1("游客模式采集事件", Boolean.valueOf(r3));
    }

    @Override // com.bytedance.applog.g
    public final void F0(int r3) {
        this.Y = Integer.valueOf(r3);
        e r0 = this.W;
        if (r3 <= 0) goto L5;
        boolean r4 = true;
    L6:
        r0.j("disable_personalization_enable", r4);
        return;
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.bytedance.applog.g
    public final void F1(int r5) {
        this.T = Math.min(Math.max(1, r5), 8);
        this.W.i("max_request_once_report", r5);
    }

    @Override // com.bytedance.applog.g
    public final void G(boolean r1) {
        this.p0 = r1;
    }

    @Override // com.bytedance.applog.g
    public final void H0(d0 r3) {
        k r0 = (k) this.w.b();
        if (r0.e() == false) goto L9;
        com.bytedance.bdinstall.f r1 = r0.i;
        if (r1.a != null) goto L10;
        if (r3 == null) goto L11;
        r1.a = r3;
        return;
    L11:
        return;
    L10:
        return;
    }

    @Override // com.bytedance.applog.g
    public final void H1(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L13;
        nw3.f r0 = this.w;
        if (r0.c == null) goto L11;
        nw3.g r1 = r0.c;
        JSONObject r2 = r1.b();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.has(r4) == false) goto L15;
        r2.remove(r4);
        JSONObject r5 = new JSONObject();
        nx3.k.d(r5, r2);
        r1.d(r5);
        return;
    L15:
        return;
    L11:
        r0.f.remove(r4);
        return;
    }

    @Override // com.bytedance.applog.g
    public final void I(boolean r8) {
        this.l0 = r8;
        if (this.l0 == true) goto L28;
        CommonParamsWrapper r9 = this.s0.b(new Object[0]);
        monitor-enter(r9);
        n.w().h(r9.b, "start to destroy common params wrapper...", new Object[0]);     // Catch: Throwable -> L25
        if ((!r9.e.isEmpty()) == false) goto L17;
        int r1 = r9.e.size();     // Catch: Throwable -> L25
        Iterator r3 = r9.e.values().iterator();     // Catch: Throwable -> L25
    L10:
        if (r3.hasNext() == false) goto L15;
        Iterator r4 = ((ConcurrentHashMap) r3.next()).values().iterator();     // Catch: Throwable -> L25
    L13:
        if (r4.hasNext() == false) goto L10;
        ((LifecycleValueObserver) r4.next()).a();     // Catch: Throwable -> L25
        goto L13
    L15:
        r9.e.clear();     // Catch: Throwable -> L25
        n.w().h(r9.b, "{} lifecycle observers has been destroyed...", new Object[]{Integer.valueOf(r1)});     // Catch: Throwable -> L25
    L17:
        if ((!r9.d.isEmpty()) == false) goto L23;
        int r2 = r9.d.size();     // Catch: Throwable -> L25
        Iterator r5 = r9.d.entrySet().iterator();     // Catch: Throwable -> L25
    L20:
        if (r5.hasNext() == false) goto L22;
        ((com.bytedance.applog.params.a) ((Map.Entry) r5.next()).getValue()).clear();     // Catch: Throwable -> L25
        goto L20
    L22:
        r9.d.clear();     // Catch: Throwable -> L25
        n.w().h(r9.b, "{} biz params object has been cleared...", new Object[]{Integer.valueOf(r2)});     // Catch: Throwable -> L25
    L23:
        monitor-exit(r9);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.applog.g
    public final void I0(boolean r3) {
        this.G = r3;
        this.W.j("flush_async_default_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void J0(boolean r2) {
        this.w0.a = r2;
    }

    @Override // com.bytedance.applog.g
    public final void J1(f0 r4) {
        if (getInitConfig() == null) goto L5;
        return;
    L5:
        if (this.u0.compareAndSet(false, true) == false) goto L9;
        j r0 = new com.bytedance.applog.log.e(r4);
        com.bytedance.applog.log.l.a.add(r0);
        O1().a();
        return;
    }

    @Override // com.bytedance.applog.g
    public final void K(ow3.b r2) {
        if (this.n == null) goto L6;
        this.n.e().j = r2;
        return;
    }

    @Override // com.bytedance.applog.g
    public final void K0(p r2) {
        d r0 = this.a;
        if (r2 == null) goto L5;
        r0.a.remove(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.bytedance.applog.g
    public final void L(n r2) {
        ax3.a r0 = this.V;
        if (r2 != null) goto L5;
        r0.getClass();
        return;
    L5:
        r0.a.add(r2);
    }

    @Override // com.bytedance.applog.g
    public final void L0(boolean r3) {
        this.j0 = r3;
        this.W.j("event_param_control_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void M(int r5) {
        zw3.a r0 = this.d;
        r0.getClass();
        r0.c = Math.min(r5, 200);
        this.W.i("max_cache_event_num", r5);
    }

    @Override // com.bytedance.applog.g
    public final void M0(boolean r1) {
        this.g0 = r1;
    }

    @Override // com.bytedance.applog.g
    public final void M1(kx3.b r1) {
        this.U = r1;
    }

    @Override // com.bytedance.applog.g
    public final void N0(boolean r3) {
        this.A = r3;
        W1("DAU虚高修复", Boolean.valueOf(r3));
        this.W.j("dau_fix", r3);
    }

    @Override // com.bytedance.applog.g
    public final void O0(boolean r3) {
        this.O = r3;
        this.W.j("migrate_old_applog_data_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void P(l r2) {
        c r0 = this.b0;
        if (r2 == null) goto L5;
        r0.b.remove(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.bytedance.applog.g
    public final void R0(r r2) {
        if (this.n == null) goto L6;
        f r0 = this.n;
        r0.l = r2;
        nw3.h r1 = r0.a;
        u r3 = r2.e;
        ((k) ((nw3.f) r1).b()).d(r3);
        return;
    }

    @Override // com.bytedance.applog.g
    public final void S(boolean r3) {
        this.k0 = r3;
        this.W.j("custom_header_control_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void T0(m r1) {
        this.Z = r1;
    }

    public final void V1(jx3.a r18) {
        r18.m = this.j;
        ow3.d r0 = this.w0;
        if (r0.a == false) goto L5;
        ow3.d.a r3 = new ow3.d.a(r0.b, r0.c, r0.d);
    L6:
        r18.u = r3;
        if ((r18 instanceof jx3.e) == false) goto L9;
    L12:
        this.W.b(StatsCountKeys.COLLECT_EVENT_COUNT, 1);
        int r1 = ax3.b.a(this.W, r18);
        r18.s = r1;
        if (r1 <= 0) goto L16;
        ax3.b.c(this.W, EventStage.PRE_PROCESS_START, r18);
    L16:
        if (this.c.b(1) == true) goto L25;
    L22:
        th = move-exception;
        this.t0.o(4, "notify event observerV2 before receive failed", th, new Object[0]);
        this.W.h("notify event observerV2 before receive failed", th, true);
        goto L25
    L19:
        if ((r18 instanceof jx3.e) == false) goto L25;
        jx3.e r2 = (jx3.e) r18;     // Catch: Throwable -> L22
        this.c.c(1, r2.B, r2.y, r2.z);     // Catch: Throwable -> L22
    L25:
        if (this.b.b(1) == true) goto L40;
    L37:
        th = move-exception;
        this.t0.o(4, "notify event observer before receive failed", th, new Object[0]);
        this.W.h("notify event observer before receive failed", th, true);
        goto L40
    L28:
        if ((r18 instanceof jx3.c) == false) goto L31;
        jx3.c r4 = (jx3.c) r18;     // Catch: Throwable -> L37
        this.b.c(1, r4.y, r4.z, r4.A, r4.C, r4.D, r4.B);     // Catch: Throwable -> L37
    L98:
        goto L40
    L31:
        if ((r18 instanceof jx3.e) == false) goto L34;
        jx3.e r5 = (jx3.e) r18;     // Catch: Throwable -> L37
        this.b.d(1, r5.B, r5.y);     // Catch: Throwable -> L37
        goto L98
    L34:
        if ((r18 instanceof jx3.d) == false) goto L98;
        jx3.d r6 = (jx3.d) r18;     // Catch: Throwable -> L37
        this.b.e(1, r6.z, r6.y);     // Catch: Throwable -> L37
    L40:
        if (this.n != null) goto L44;
        this.d.a(r18);
        if (r18.s <= 0) goto L89;
        ax3.b.c(this.W, EventStage.CACHED_BEFORE_HANDLE, r18);
    L89:
        if (r18.n() <= 1048576) goto L91;
        this.W.h("receive data too big (>1MB)", new Throwable(r18.toString()), true);
    L91:
        com.bytedance.applog.log.m.d("event_receive", r18);
        return;
    L44:
        f r7 = this.n;
        r7.getClass();
        if (r18.b != 0) goto L47;
        r7.c.t0.s(f.B, "receive zero ts", null, new Object[0]);
    L47:
        ArrayList r8 = r7.f;
        monitor-enter(r8);
        int r9 = r7.f.size();     // Catch: Throwable -> L93
        r7.f.add(r18);     // Catch: Throwable -> L93
        monitor-exit(r8);     // Catch: Throwable -> L93
        if (r18.s <= 0) goto L54;
        ax3.b.c(r7.c.W, EventStage.DATA_LIST_ADDED, r18);
    L54:
        boolean r10 = r18 instanceof jx3.j;
        if (r7.c.H == false) goto L65;
        if (r10 == false) goto L58;
    L63:
        r7.m.removeMessages(4);
        r7.m.sendEmptyMessage(4);
    L74:
        if (r18.s <= 0) goto L76;
        ax3.b.c(r7.c.W, EventStage.PRE_PROCESS_END, r18);
    L76:
        if (r10 == false) goto L89;
        ow3.c r11 = r7.x;
        r11.getClass();
        if (((jx3.j) r18).y <= 0) goto L80;
        r11.b.sendEmptyMessageDelayed(9999, 500);
        r11.d = Math.max(0, r11.d - 1);
        goto L89
    L80:
        r11.b.removeMessages(9999);
        r11.d++;
        if (r11.c == false) goto L84;
        r11.c = false;
        r11.a.t0.j("App first to frontend...", new Object[0]);
    L84:
        if (r11.e == false) goto L89;
        r11.e = false;
        r11.a.t0.j("App back to frontend...", new Object[0]);
        if (r11.a.getInitConfig() == null) goto L89;
        r11.a.getInitConfig().getClass();
        goto L89
    L58:
        if (((r9 + 1) % r7.c.I) == 0) goto L63;
        if (r7.m.hasMessages(4) == true) goto L74;
        r7.m.sendEmptyMessageDelayed(4, r7.c.f1J);
        goto L74
    L65:
        if ((r9 % 5) == 0) goto L67;
        if (r10 == false) goto L74;
    L67:
        r7.m.removeMessages(4);
        if (r9 != 0) goto L72;
        if (r10 == true) goto L72;
        r7.m.sendEmptyMessageDelayed(4, 200);
    L72:
        r7.m.sendEmptyMessage(4);
    L93:
        th = move-exception;
        throw th;
    L9:
        if ((r18 instanceof jx3.c) == true) goto L12;
        if ((r18 instanceof jx3.d) == false) goto L16;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.applog.g
    public final void W(boolean r3) {
        this.H = r3;
        this.W.j("insert_event_opt_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void Z(k r1) {
        this.q = r1;
    }

    @Override // com.bytedance.applog.g
    public final void a0(j r3) {
        xw3.b r0 = this.c;
        if (r3 == null) goto L10;
        Iterator r1 = ((ConcurrentHashMap) r0.a).entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L17;
        CopyOnWriteArraySet r2 = (CopyOnWriteArraySet) ((Map.Entry) r1.next()).getValue();
        if (r2 == null) goto L6;
        r2.remove(r3);
        goto L6
    L17:
        return;
    L10:
        r0.getClass();
    }

    @Override // com.bytedance.applog.g
    public final void b(Account r4) {
        nw3.f r0 = this.w;
        r0.getClass();
        monitor-enter(nw3.f.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r0.a == null) goto L7;
        r0.a.C = r4;     // Catch: Throwable -> L10
    L8:
        monitor-exit(nw3.f.class);     // Catch: Throwable -> L10
        return;
    L7:
        ((k) r0.b()).o(r4);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // com.bytedance.applog.g
    public final void b0(String r2) {
        ((CopyOnWriteArrayList) this.v0).add(r2);
    }

    @Override // com.bytedance.applog.g
    public final void b1(boolean r3) {
        this.o.h = r3;
        this.W.j("track_resume_event_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void c1(DataIsolateKey r1) {
        this.d0 = r1;
    }

    @Override // com.bytedance.applog.g
    public final void d0(boolean r1) {
        this.o0 = r1;
    }

    @Override // com.bytedance.applog.g
    public final void f(boolean r1) {
        this.S = r1;
    }

    @Override // com.bytedance.applog.g
    public final void f0(boolean r3) {
        this.R = r3;
        this.W.j("bdinstall_event_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void f1(long r1) {
        this.r0 = r1;
    }

    @Override // com.bytedance.applog.g
    public final void g0(boolean r3) {
        this.C = r3;
        this.W.j("priority_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void getSsidGroup(Map<String, String> r4) {
        n0 r0 = this.w.c();
        if (r0 == null) goto L17;
        String r1 = r0.a;
        if (TextUtils.isEmpty(r1) == true) goto L7;
        r4.put("device_id", r1);
    L7:
        String r2 = r0.b;
        if (TextUtils.isEmpty(r2) == true) goto L10;
        r4.put("install_id", r2);
    L10:
        String r3 = r0.c;
        if (TextUtils.isEmpty(r3) == true) goto L13;
        r4.put("openudid", r3);
    L13:
        String r5 = r0.d;
        if (TextUtils.isEmpty(r5) == true) goto L18;
        r4.put("clientudid", r5);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.applog.g
    public final void h0(String r6) {
        nw3.f r0 = this.w;
        Context r1 = getContext();
        r0.getClass();
        monitor-enter(nw3.f.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r0.a == null) goto L7;
        r0.a.x = r6;     // Catch: Throwable -> L13
    L11:
        monitor-exit(nw3.f.class);     // Catch: Throwable -> L13
        return;
    L7:
        k r2 = (k) r0.b();     // Catch: Throwable -> L13
        r2.getClass();     // Catch: Throwable -> L13
        if (r1 != null) goto L10;
        t.b("context is null when setUserAgent");     // Catch: Throwable -> L13
        goto L11
    L10:
        HashMap r3 = new HashMap();     // Catch: Throwable -> L13
        r3.put("user_agent", r6);     // Catch: Throwable -> L13
        r2.h.b(new Object[]{r1}).h(r1, r3, false);     // Catch: Throwable -> L13
        goto L11
    }

    @Override // com.bytedance.applog.g
    public final void h1(int r2) {
        this.f1J = Math.max(r2, 100);
    }

    @Override // com.bytedance.applog.g
    public final void i0(boolean r3) {
        if (r3 == false) goto L4;
        AtomicInteger r0 = this.B;
        r0.set(r0.get() | 2);
    L5:
        W1("Tea还原采样", Boolean.valueOf(r3));
        this.W.j("tea_sample_enable", r3);
        return;
    L4:
        AtomicInteger r1 = this.B;
        r1.set(r1.get() & (-3));
        goto L5
    }

    @Override // com.bytedance.applog.g
    public final void i1(int r5) {
        this.r = Integer.valueOf(r5);
        this.W.i("http_monitor_port", r5);
    }

    @Override // com.bytedance.applog.g
    public final void j(boolean r3) {
        if (r3 == false) goto L4;
        AtomicInteger r0 = this.B;
        r0.set(r0.get() | 1);
    L5:
        W1("事件采样", Boolean.valueOf(r3));
        this.W.j("normal_sample_enable", r3);
        return;
    L4:
        AtomicInteger r1 = this.B;
        r1.set(r1.get() & (-2));
        goto L5
    }

    @Override // com.bytedance.applog.g
    public final void j0(boolean r1) {
        this.n0 = r1;
    }

    @Override // com.bytedance.applog.g
    public final void j1(boolean r3) {
        this.y = r3;
        this.W.j("tourist_mode", r3);
        W1("游客模式", Boolean.valueOf(r3));
    }

    @Override // com.bytedance.applog.g
    public final void k(boolean r8) {
        if (this.n == null) goto L5;
        this.n.a(r8, 18, 0, null);
    L5:
        this.W.j("child_mode", r8);
    }

    @Override // com.bytedance.applog.g
    public final void k1(h r2) {
        nx3.a r0 = this.t;
        if (r0 == null) goto L8;
        if (r2 == null) goto L6;
        r0.a.remove(r2);
        return;
    L6:
        r0.getClass();
        return;
    }

    @Override // com.bytedance.applog.g
    public final void l1(i r3) {
        this.b.a(0, r3);
    }

    @Override // com.bytedance.applog.g
    public final void m1(boolean r3) {
        this.h0 = r3;
        this.W.j("event_forward_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void n(String r2) {
        a("touch_point", r2);
    }

    @Override // com.bytedance.applog.g
    public final void n1(l r2) {
        c r0 = this.b0;
        if (r2 == null) goto L5;
        r0.b.add(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.bytedance.applog.g
    public final void o(boolean r1) {
        this.D = r1;
    }

    @Override // com.bytedance.applog.g
    public final void o0(boolean r3) {
        this.Q = r3;
        this.W.j("pack_launch_desc", r3);
    }

    @Override // com.bytedance.applog.g
    public final void onActivityResumed(Activity r2) {
        if (r2 == null) goto L5;
        this.o.onActivityResumed(r2);
        return;
    }

    @Override // com.bytedance.applog.g
    public void onEvent(String r10) {
        Q("event_v1", r10, null, 0, 0, null);
    }

    @Override // com.bytedance.applog.g
    public void onEventV3(String r2) {
        U1(null, null, r2, null);
    }

    @Override // com.bytedance.applog.g
    public final void onPause(Context r4) {
        if ((r4 instanceof Activity) == false) goto L5;
        onActivityPause();
        return;
    L5:
        n r0 = this.t0;
        if (r4 != null) goto L8;
        String r5 = "null";
    L9:
        r0.s(null, "onPause context: ".concat(r5), null, new Object[0]);
        return;
    L8:
        r5 = r4.getClass().getName();
        goto L9
    }

    @Override // com.bytedance.applog.g
    public final void onResume(Context r4) {
        if ((r4 instanceof Activity) == false) goto L5;
        r4.hashCode();
        onActivityResumed((Activity) r4);
        return;
    L5:
        n r0 = this.t0;
        if (r4 != null) goto L8;
        String r5 = "null";
    L9:
        r0.s(null, "onResume context: ".concat(r5), null, new Object[0]);
        return;
    L8:
        r5 = r4.getClass().getName();
        goto L9
    }

    @Override // com.bytedance.applog.g
    public final void p0(boolean r1) {
        this.q0 = r1;
    }

    @Override // com.bytedance.applog.g
    public final void q(Proxy r2) {
        this.u = r2;
        if (r2 == null) goto L5;
        boolean r3 = true;
    L6:
        W1("HTTP代理", Boolean.valueOf(r3));
        return;
    L5:
        r3 = false;
        goto L6
    }

    @Override // com.bytedance.applog.g
    public final void r(JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        nw3.f r0 = this.w;
        Context r1 = getContext();
        r0.getClass();
        monitor-enter(nw3.f.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (r0.a == null) goto L9;
        r0.a.A = r6;     // Catch: Throwable -> L15
    L13:
        monitor-exit(nw3.f.class);     // Catch: Throwable -> L15
        return;
    L9:
        k r2 = (k) r0.b();     // Catch: Throwable -> L15
        r2.getClass();     // Catch: Throwable -> L15
        if (r1 != null) goto L12;
        t.b("context is null when setAppTrack");     // Catch: Throwable -> L15
        goto L13
    L12:
        HashMap r3 = new HashMap();     // Catch: Throwable -> L15
        r3.put("app_track", r6.toString());     // Catch: Throwable -> L15
        r2.h.b(new Object[]{r1}).h(r1, r3, false);     // Catch: Throwable -> L15
        goto L13
    }

    @Override // com.bytedance.applog.g
    public final void r0(int r2) {
        this.I = Math.max(r2, 1);
    }

    @Override // com.bytedance.applog.g
    public final boolean s(String r3) {
        if (P1() != 0) goto L5;
        return false;
    L5:
        if (this.n != null) goto L8;
        return false;
    L8:
        return this.n.i(r3, null);
    }

    @Override // com.bytedance.applog.g
    public final void setHeaderInfo(HashMap<String, Object> r3) {
        nw3.f r0 = this.w;
        if (r0.c == null) goto L5;
        r0.c.a(r3);
        return;
    L5:
        r0.f.putAll(r3);
    }

    @Override // com.bytedance.applog.g
    public final void setPageName(String r3) {
        ow3.d r0 = this.w0;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r3, "name");
        r0.c = r3;
    }

    @Override // com.bytedance.applog.g
    public final void setUserUniqueID(String r4) {
        if (this.n == null) goto L15;
        f r0 = this.n;
        String r1 = r0.h.d();
        if (TextUtils.isEmpty(r4) == false) goto L9;
        if (TextUtils.isEmpty(r1) == true) goto L9;
    L12:
        r0.c(r4);
    L13:
        r0.h.d.r = r4;
        return;
    L9:
        if (TextUtils.isEmpty(r4) == true) goto L13;
        if (TextUtils.equals(r4, r1) == true) goto L13;
    }

    @Override // com.bytedance.applog.g
    public final void t(long r17) {
        if (this.n == null) goto L24;
        f r2 = this.n;
        if (r2.j == null) goto L35;
        long r3 = System.currentTimeMillis();
        Iterator r5 = ((ArrayList) r2.j).iterator();
        long r6 = r17;
    L9:
        if (r5.hasNext() == false) goto L36;
        rw3.m r0 = (rw3.a) r5.next();
        if ((r0 instanceof rw3.m) == false) goto L9;
        rw3.m r8 = r0;
        if (r6 <= 0) goto L25;
        r8.j = r6;
    L25:
        r8.c(12);     // Catch: Throwable -> L18
    L20:
        r8.j = 0;
        if (r17 <= 0) goto L9;
        r6 = r17 - (System.currentTimeMillis() - r3);
        if (r6 > 0) goto L9;
        return;
    L18:
        th = move-exception;
        r2.c.t0.s(f.B, "force report by sender:{} failed", null, new Object[]{r8.i, th});
        goto L20
    L36:
        return;
    L35:
        return;
    }

    @Override // com.bytedance.applog.g
    public final void t1(boolean r4) {
        this.v = r4;
        e r0 = this.W;
        if (r4 == false) goto L5;
        long r1 = 1;
    L6:
        r0.i("encrypt_enable", r1);
        return;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.applog.g
    public final void u1(boolean r3) {
        this.F = r3;
        this.W.j("bg_session_report_after_pause_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void v1(IBDAccountCallback r1) {
        this.a0 = r1;
    }

    @Override // com.bytedance.applog.g
    public final void w0(boolean r3) {
        this.x = r3;
        W1("采集USER ID", Boolean.valueOf(r3));
        this.W.j("event_uid_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void x(boolean r3) {
        Integer r0 = ((k) this.w.b()).g();
        if (r0 == null) goto L8;
        g84.c r1 = (g84.c) g84.e.a(g84.c.class, String.valueOf(r0));
        if (r1 == null) goto L8;
        r1.getApi();
    L8:
        W1("新用户模式", Boolean.valueOf(r3));
        this.W.j("new_user_mode", r3);
    }

    @Override // com.bytedance.applog.g
    public final void x0(j r3) {
        this.c.a(0, r3);
    }

    @Override // com.bytedance.applog.g
    public final void x1(String r2) {
        ((CopyOnWriteArrayList) this.v0).remove(r2);
    }

    @Override // com.bytedance.applog.g
    public final void y1(i r4) {
        xw3.a r0 = this.b;
        if (r4 == null) goto L12;
        Iterator r1 = ((ConcurrentHashMap) r0.a).entrySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L21;
        CopyOnWriteArraySet r2 = (CopyOnWriteArraySet) ((Map.Entry) r1.next()).getValue();
        if (r2 == null) goto L6;
        if (r2.contains(r4) == false) goto L6;
        r2.remove(r4);
        goto L6
    L21:
        return;
    L12:
        r0.getClass();
    }

    @Override // com.bytedance.applog.g
    public final void z(boolean r3) {
        this.P = r3;
        this.W.j("terminate_immediately_enable", r3);
    }

    @Override // com.bytedance.applog.g
    public final void z0(p r2) {
        d r0 = this.a;
        if (r2 == null) goto L5;
        r0.a.add(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.bytedance.applog.g
    public final void E1(long r8, t0 r10) {
        if (this.n == null) goto L6;
        this.n.a(false, 20, r8, r10);
        return;
    }

    @Override // com.bytedance.applog.g
    public final void K1(int r2, i r3) {
        this.b.a(r2, r3);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.applog.g
    public final void O(Context r22, q r23) {
        monitor-enter(b.class);
    L60:
        th = move-exception;
        throw th;
    L5:
        if (TextUtils.isEmpty(r23.a) == true) goto L59;
        if (com.bytedance.applog.a.c(r23.a) == true) goto L57;
        n r1 = this.t0;     // Catch: Throwable -> L60
        String r2 = r23.a;     // Catch: Throwable -> L60
        r1.a = r2;     // Catch: Throwable -> L60
        ((ConcurrentHashMap) com.bytedance.applog.log.c.c).put(r2, r1);     // Catch: Throwable -> L60
        r1.j("Current logger bind to appId {}", new Object[]{r2});     // Catch: Throwable -> L60
        this.j = r23.a;     // Catch: Throwable -> L60
        this.k = (Application) r22.getApplicationContext();     // Catch: Throwable -> L60
        if (r23.E == true) goto L11;
    L16:
        this.t0.l("App:{} init begin...", new Object[]{this.j});     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r23.z) == false) goto L22;
        String r3 = com.bytedance.applog.a.b(this, "applog_stats");     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r3) == true) goto L22;
        r23.z = r3;     // Catch: Throwable -> L60
    L22:
        if (com.bytedance.applog.log.m.b() == true) goto L25;
        com.bytedance.applog.log.m.c("init_begin", new c(this, r23));     // Catch: Throwable -> L60
    L25:
        this.l = new zw3.b(this, this.k, r23);     // Catch: Throwable -> L60
        if (this.Z != null) goto L28;
        this.Z = new nx3.c(this, this.l);     // Catch: Throwable -> L60
    L28:
        this.m = new zw3.d(this, this.l, this.w);     // Catch: Throwable -> L60
        this.n = new f(this, this.l, this.m, this.w, r23.F, this.d, this.x0);     // Catch: Throwable -> L60
        if (r23.w == false) goto L31;
        this.k.registerActivityLifecycleCallbacks(this.o);     // Catch: Throwable -> L60
    L31:
        this.i = 1;     // Catch: Throwable -> L60
        this.p = r23.b;     // Catch: Throwable -> L60
        if (this.X == null) goto L35;
        D0(this.X.longValue());     // Catch: Throwable -> L60
        this.X = null;     // Catch: Throwable -> L60
    L35:
        if (this.D == false) goto L42;
        String[] r4 = this.n.h().a;     // Catch: Throwable -> L60
        String r14 = this.j;     // Catch: Throwable -> L60
        if (r4.length <= 0) goto L39;
        String r5 = r4[0];     // Catch: Throwable -> L60
    L40:
        this.f0 = new PriorityWrapper(r22, new com.bytedance.applog.priority.f(r14, r5, r23.E, this.x, this.v, new PriorityCallbackImpl(this), new com.bytedance.applog.priority.i(this)));     // Catch: Throwable -> L60
        goto L42
    L39:
        r5 = XmlPullParser.NO_NAMESPACE;
    L42:
        if (r23.x == false) goto L45;
        this.W.i("congestion_enable", 1);     // Catch: Throwable -> L60
    L45:
        if (r23.B == false) goto L48;
        this.W.i("event_filter_enable", 1);     // Catch: Throwable -> L60
    L48:
        if (r23.w == false) goto L50;
        this.W.i("handle_lifecycle_enable", 1);     // Catch: Throwable -> L60
    L50:
        com.bytedance.applog.log.m.e(this.j);     // Catch: Throwable -> L60
        this.t0.l("App:{} init end.", new Object[]{this.j});     // Catch: Throwable -> L60
        zw3.b r0 = this.l;     // Catch: Throwable -> L60
        r0.getClass();     // Catch: Throwable -> L60
        if (com.bytedance.applog.log.m.b() == true) goto L54;
        com.bytedance.applog.log.m.c("remote_settings", new zw3.c(r0));     // Catch: Throwable -> L60
    L54:
        monitor-exit(b.class);     // Catch: Throwable -> L60
        return;
    L11:
        if (this.u0.compareAndSet(false, true) == false) goto L16;
        f0 r6 = r23.e;     // Catch: Throwable -> L60
        if (r6 == null) goto L15;
        ((ConcurrentHashMap) com.bytedance.applog.log.l.b).put(this.j, new com.bytedance.applog.log.e(r6));     // Catch: Throwable -> L60
        goto L16
    L15:
        ((ConcurrentHashMap) com.bytedance.applog.log.l.b).put(this.j, new com.bytedance.applog.log.d(this));     // Catch: Throwable -> L60
        goto L16
    L57:
        throw new IllegalStateException("The app id is init already!");     // Catch: Throwable -> L60
    L59:
        throw new IllegalStateException("App id must not be empty!");     // Catch: Throwable -> L60
    }

    public final void W1(String r2, Object r3) {
        if (com.bytedance.applog.log.m.b() == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(this.j) == true) goto L9;
        com.bytedance.applog.log.m.c("update_config", new b(this, r2, r3));
        return;
    }

    @Override // com.bytedance.applog.g
    public final boolean X0(String r2, JSONObject r3) {
        if (P1() != 0) goto L5;
        return false;
    L5:
        if (this.n != null) goto L8;
        return false;
    L8:
        return this.n.i(r2, r3);
    }

    @Override // com.bytedance.applog.g
    public final void a(String r2, Object r3) {
        if (TextUtils.isEmpty(r2) == true) goto L9;
        HashMap r0 = new HashMap();
        r0.put(r2, r3);
        nw3.f r4 = this.w;
        if (r4.c == null) goto L7;
        r4.c.a(r0);
        return;
    L7:
        r4.f.putAll(r0);
        return;
    }

    @Override // com.bytedance.applog.g
    public final void a1(int r2, j r3) {
        this.c.a(r2, r3);
    }

    @Override // com.bytedance.applog.g
    public final void d1(String r3, Throwable r4) {
        this.W.h(r3, r4, true);
    }

    @Override // com.bytedance.applog.g
    public final void m(String r4, String r5) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
        this.t0.i("event name is empty", new Object[0]);
        return;
    L5:
        V1(new jx3.e(this.j, r4, r5, 0));
    }

    @Override // com.bytedance.applog.g
    public final void o1(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (r3 != null) goto L8;
        this.i0.remove(r2);
        return;
    L8:
        this.i0.put(r2, r3);
    }

    @Override // com.bytedance.applog.g
    public final void onEvent(String r10, String r11) {
        Q("event_v1", r10, r11, 0, 0, null);
    }

    @Override // com.bytedance.applog.g
    public final void onEventV3(String r6, Bundle r7) {
        if (r7 != null) goto L22;
    L17:
        JSONObject r1 = null;
    L18:
        U1(null, null, r6, r1);
        return;
    L22:
    L14:
        th = th;
        r1 = null;
    L16:
        this.t0.s(null, "parse bundle params failed", th, new Object[0]);
        this.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        goto L18
    L5:
        if (r7.isEmpty() == true) goto L17;
        r1 = new JSONObject();     // Catch: Throwable -> L14
        Iterator<String> r2 = r7.keySet().iterator();     // Catch: Throwable -> L12
    L9:
        if (r2.hasNext() == false) goto L18;
        String r3 = r2.next();     // Catch: Throwable -> L12
        r1.put(r3, r7.get(r3));     // Catch: Throwable -> L12
    L12:
        th = th;
        goto L16
    }

    @Override // com.bytedance.applog.g
    public final void onMiscEvent(String r10, JSONObject r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L15:
        this.t0.i("call onEventData with invalid params, return", new Object[0]);
        return;
    L5:
        if (r11.length() <= 0) goto L15;
        V1(new jx3.d(this.j, r10, r11));     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        if (this.W.f(r10) == false) goto L13;
        this.W.m(EventStage.PARAMS_INVALID_DROP, r10, String.valueOf(ex3.g.a.incrementAndGet()), System.currentTimeMillis(), StageEventType.LOG_DATA);
    L13:
        this.t0.s(null, "call onEventData get exception: ", e, new Object[0]);
    }

    @Override // com.bytedance.applog.g
    public final void p(String r2, int r3) {
        if (TextUtils.isEmpty(r2) == true) goto L6;
        this.o.a(r2, r3);
        return;
    }

    @Override // com.bytedance.applog.g
    public final void s0(boolean r9, String r10) {
        if (TextUtils.isEmpty(this.j) == false) goto L6;
        this.t0.i("Not init before change event sender", new Object[0]);
        return;
    L6:
        EventsSenderUtils.setEventsSenderEnable(this.j, r9, getContext());
        if (TextUtils.isEmpty(r10) == true) goto L9;
        EventsSenderUtils.setEventVerifyHost(this.j, r10);
    L9:
        this.W.j("et_enable", r9);
        e r11 = this.W;
        if (r11.a.b == false) goto L26;
        n.w().k(8, e.m, "setFeature string {} = {}", new Object[]{"et_host", r10});
        JSONObject r2 = r11.l;
        monitor-enter(r2);
        r11.l.put("et_host", r10);     // Catch: Throwable -> L16
    L18:
        monitor-exit(r2);     // Catch: Throwable -> L20
        return;
    L16:
        th = move-exception;
        n.w().k(8, e.m, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.applog.g
    public final void setAppLanguageAndRegion(String r6, String r7) {
        if (this.n == null) goto L6;
        f r0 = this.n;
        nw3.h r1 = r0.a;
        Context r2 = r0.getContext();
        k r3 = (k) ((nw3.f) r1).b();
        r3.getClass();
        HashMap r4 = new HashMap();
        r4.put("app_language", r6);
        r4.put("app_region", r7);
        r3.h.b(new Object[]{r2}).h(r2, r4, true);
        r0.n(r0.e, 0);
        return;
    }

    @Override // com.bytedance.applog.g
    public final void t0(String r2, int r3) {
        this.W.c(r2, r3);
    }

    @Override // com.bytedance.applog.g
    public final void u0(Context r4, JSONObject r5) {
        k r0 = (k) this.w.b();
        r0.getClass();
        HashMap r1 = new HashMap();
        r1.put("register_custom", r5);
        r0.h.b(new Object[]{r4}).c(r1);
    }

    @Override // com.bytedance.applog.g
    public final void v0(List<String> r6, boolean r7) {
        uw3.a.a r0 = uw3.a.c;
        uw3.c r1 = null;
        if (r6 != null) goto L5;
    L18:
        this.s = r1;
        e r2 = this.W;
        if (r6 == null) goto L24;
        if (r7 == false) goto L22;
        int r8 = 1;
    L23:
        long r9 = r8;
    L25:
        r2.i("custom_event_filter", r9);
        return;
    L22:
        r8 = 2;
        goto L23
    L24:
        r9 = 0;
        goto L25
    L5:
        if (r6.isEmpty() == true) goto L18;
        HashSet r3 = new HashSet();
        Iterator<String> r4 = r6.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        String r5 = r4.next();
        if (TextUtils.isEmpty(r5) == true) goto L8;
        r3.add(r5);
        goto L8
    L13:
        if (r3.isEmpty() == true) goto L18;
        if (r7 == false) goto L16;
        uw3.c r10 = new uw3.c(r3, null);
    L17:
        r1 = r10;
        goto L18
    L16:
        r10 = new uw3.b(r3, null);
        goto L17
    }

    @Override // com.bytedance.applog.g
    public final void onEventV3(String r2, JSONObject r3) {
        U1(null, null, r2, r3);
    }

    @Override // com.bytedance.applog.g
    public final <T> T G1(String r5, T r6, Class<T> r7) {
        T r1 = null;
        if (this.m == null) goto L19;
        zw3.d r0 = this.m;
        ix3.c r2 = r0.g.e;
        JSONObject r3 = r0.e;
        if (r3 == null) goto L22;
        r2.getClass();
        Object r8 = r3.opt(r5);
        if (r8 == null) goto L14;
        if (r7 == null) goto L14;
        r1 = r7.cast(r8);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r2.a.t0.s(Collections.singletonList("ApiParamsUtil"), "getValue cast failed", th, new Object[0]);
    L14:
        if (r1 == null) goto L18;
        r6 = r1;
    L18:
        return r6;
    L22:
        return (T) r2.a.G1(r5, r6, r7);
    L19:
        return null;
    }

    @Override // com.bytedance.applog.g
    public final void S0(String r8, String r9, int r10) {
        if (r10 >= 0) goto L7;
        this.t0.i("interval must not less than 0", new Object[0]);
        return;
    L7:
        if (this.e0 != null) goto L31;
        this.e0 = new JSONObject();
    L31:
        this.e0.put("interval", r10);     // Catch: Throwable -> L12
        this.e0.put("caller", r8);     // Catch: Throwable -> L12
        this.e0.put("unique_key", r9);     // Catch: Throwable -> L12
    L14:
        e r11 = this.W;
        JSONObject r12 = nx3.k.e(this.e0);
        if (r11.a.b == false) goto L33;
        n.w().k(8, e.m, "setFeature json {} = {}", new Object[]{"expected_batch_interval_config", r12});
        JSONObject r2 = r11.l;
        monitor-enter(r2);
        r11.l.put("expected_batch_interval_config", r12);     // Catch: Throwable -> L21
    L23:
        monitor-exit(r2);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        n.w().k(8, e.m, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L25
        goto L23
    L33:
        return;
    L12:
        th = move-exception;
        this.t0.s(null, "json build ExpectedBatchInterval failed", th, new Object[0]);
        this.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        goto L14
    }

    @Override // com.bytedance.applog.g
    public final void p1(boolean r8, long r9, t0 r11) {
        if (this.n == null) goto L5;
        this.n.a(r8, 19, r9, r11);
    L5:
        this.W.j("child_mode", r8);
    }

    @Override // com.bytedance.applog.g
    public final void s1(HashSet<String> r1, int r2, int r3) {
        this.L = r1;
        this.M = r2;
        this.N = r3;
        this.K = true;
        if (this.n == null) goto L6;
        this.n.m.obtainMessage(26, Boolean.TRUE).sendToTarget();
        return;
    }

    @Override // com.bytedance.applog.g
    public final void H(View r1, String r2, String r3, JSONObject r4) {
        U1(r1, r2, r3, r4);
    }

    @Override // com.bytedance.applog.g
    public final String I1(Context r3, StringBuilder r4, boolean r5, Level r6) {
        k r0 = (k) this.w.b();
        if (r0.e() == true) goto L7;
        return null;
    L7:
        return r0.i.a(r3, r4, r5, r6);
    }

    public final void U1(View r4, String r5, String r6, JSONObject r7) {
        if (TextUtils.isEmpty(r6) == false) goto L7;
        this.t0.i("event name is empty", new Object[0]);
        return;
    L7:
        if (this.p0 == false) goto L14;
        if (r4 == null) goto L13;
        com.bytedance.applog.map.api.c r0 = com.bytedance.applog.map.api.b.a;
        Intrinsics.checkNotNullParameter(r4, "view");
        com.bytedance.applog.map.api.c r1 = com.bytedance.applog.map.api.b.a;
        if (r5 != null) goto L12;
        r5 = "custom";
    L12:
        TuplesKt.to(r5, r4);
        r7 = r1.a(r7);
        goto L14
    L13:
        r7 = com.bytedance.applog.map.api.b.a.a(r7);
    L14:
        V1(new jx3.e(this.j, r6, X1(StageEventType.V3_EVENT, r6, null, r7), 0));
    }

    public final String X1(StageEventType r14, String r15, String r16, JSONObject r17) {
        if (r17 != null) goto L48;
        return null;
    L48:
        return r17.toString();
    L7:
        th = move-exception;
        this.t0.s(null, "event toString failed " + r15 + ", label: " + r16, th, new Object[0]);
        JSONObject r0 = nx3.k.e(r17);
        if (r0 == null) goto L45;
        q r3 = getInitConfig();
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L50:
    L54:
        return r0.toString();
    L27:
        e = move-exception;
        this.W.b(StatsCountKeys.MEM_ERROR_COUNT, 1);
        if (r4 == true) goto L31;
        this.t0.s(null, "event toString OOM tag: " + r15 + ", label: " + r16, e, new Object[0]);
        return null;
    L31:
        if (this.W.f(r15) == false) goto L34;
        this.W.m(EventStage.PARAMS_INVALID_DROP, r15, String.valueOf(ex3.g.a.incrementAndGet()), System.currentTimeMillis(), StageEventType.V3_EVENT);
    L34:
        throw new RuntimeException("event toString OOM tag: " + r15 + ", label: " + r16, e);
    L18:
        e = move-exception;
        this.W.b(StatsCountKeys.SOF_ERROR_COUNT, 1);
        if (r4 == true) goto L22;
        this.t0.s(null, "event toString stack overflow tag: " + r15 + ", label: " + r16, e, new Object[0]);
        return null;
    L22:
        if (this.W.f(r15) == false) goto L25;
        this.W.m(EventStage.PARAMS_INVALID_DROP, r15, String.valueOf(ex3.g.a.incrementAndGet()), System.currentTimeMillis(), r14);
    L25:
        throw new RuntimeException("event toString stack overflow tag: " + r15 + ", label: " + r16, e);
    L36:
        this.W.b(StatsCountKeys.CONCURRENT_MODIFY_ERROR_COUNT, 1);
        return r0.toString();
    L39:
        th = move-exception;
        if (this.W.f(r15) == false) goto L44;
        this.W.m(EventStage.PARAMS_INVALID_DROP, r15, String.valueOf(ex3.g.a.incrementAndGet()), System.currentTimeMillis(), r14);
    L44:
        throw new RuntimeException("event params exception tag: " + r15 + ", label: " + r16, th);
    L13:
        if ("local_test".equalsIgnoreCase(r3.c) == false) goto L15;
        r4 = true;
        goto L50
    L45:
        return null;
    }

    @Override // com.bytedance.applog.g
    public final void m0(Context r3, Map<String, String> r4, boolean r5, Level r6) {
        k r0 = (k) this.w.b();
        if (r0.e() == false) goto L6;
        r0.i.b(r3, r5, r4, r6);
        return;
    }

    @Override // com.bytedance.applog.g
    public final String w(Context r2, String r3, boolean r4, Level r5) {
        return I1(r2, new StringBuilder(r3), r4, r5);
    }

    @Override // com.bytedance.applog.g
    public final void V0(String r10, String r11, String r12, long r13, long r15) {
        Q(r10, r11, r12, r13, r15, null);
    }

    @Override // com.bytedance.applog.g
    public final void W0(String r7, Bundle r8, String r9, String r10, String r11) {
        if (TextUtils.isEmpty(r9) == true) goto L5;
    L8:
        String r12 = "second_app_" + r7;
        if (r8 != null) goto L29;
    L24:
        JSONObject r2 = null;
    L25:
        U1(null, null, r12, r2);
        return;
    L29:
    L21:
        th = th;
        r2 = null;
    L23:
        this.t0.s(null, "prepare params failed", th, new Object[0]);
        this.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        goto L25
    L11:
        if (r8.isEmpty() == true) goto L24;
        r2 = new JSONObject();     // Catch: Throwable -> L21
        Iterator<String> r3 = r8.keySet().iterator();     // Catch: Throwable -> L19
    L15:
        if (r3.hasNext() == false) goto L17;
        String r4 = r3.next();     // Catch: Throwable -> L19
        r2.put(r4, r8.get(r4));     // Catch: Throwable -> L19
        goto L15
    L17:
        r2.put("params_for_special", "second_app");     // Catch: Throwable -> L19
        r2.put("second_appid", r9);     // Catch: Throwable -> L19
        r2.put("second_appname", r10);     // Catch: Throwable -> L19
        r2.put("product_type", r11);     // Catch: Throwable -> L19
    L19:
        th = th;
        goto L23
    L5:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        this.t0.i("both second appid and second app name is empty, return", new Object[0]);
    }

    @Override // com.bytedance.applog.g
    public final void onInternalEventV3(String r5, JSONObject r6, String r7, String r8, String r9) {
        if (TextUtils.isEmpty(r7) == true) goto L5;
    L8:
        if (r6 != null) goto L10;
        r6 = new JSONObject();
    L10:
        String r10 = "second_app_" + r5;
        r6.put("params_for_special", "second_app");     // Catch: Throwable -> L13
        r6.put("second_appid", r7);     // Catch: Throwable -> L13
        r6.put("second_appname", r8);     // Catch: Throwable -> L13
        r6.put("product_type", r9);     // Catch: Throwable -> L13
    L15:
        U1(null, null, r10, r6);
        return;
    L13:
        th = move-exception;
        this.t0.s(null, "prepare params failed", th, new Object[0]);
        this.W.b(StatsCountKeys.JSON_ERROR_COUNT, 1);
        goto L15
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L8;
        this.t0.i("both second appid and second app name is empty, return", new Object[0]);
    }

    @Override // com.bytedance.applog.g
    public final void Q(String r13, String r14, String r15, long r16, long r18, JSONObject r20) {
        if (TextUtils.isEmpty(r13) == false) goto L5;
    L9:
        this.t0.i("category or tag is empty", new Object[0]);
        return;
    L5:
        if (TextUtils.isEmpty(r14) == true) goto L9;
        V1(new jx3.c(this.j, r13, r14, r15, r16, r18, X1(StageEventType.V1_EVENT, r14, r15, r20)));
    }

    @Override // com.bytedance.applog.g
    public final void y0(String r13, String r14, String r15, long r16, long r18, String r20) {
        if (TextUtils.isEmpty(r13) == false) goto L5;
    L9:
        this.t0.i("category or tag is empty", new Object[0]);
        return;
    L5:
        if (TextUtils.isEmpty(r14) == true) goto L9;
        V1(new jx3.c(this.j, r13, r14, r15, r16, r18, r20));
    }
}
