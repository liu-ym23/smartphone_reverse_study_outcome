package com.obric.aiagent.ipc.control;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.obric.aiagent.ipc.utils.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import n9a.i;

/* JADX INFO: loaded from: classes4.dex */
public final class BinderControl extends com.obric.aiagent.ipc.control.b<Intent, IBinder> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f384674q = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Intent f384675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f384676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Job f384677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile IBinder f384678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile com.obric.aiagent.ipc.control.b.a<IBinder> f384679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f384680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f384681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f384682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile boolean f384683k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile IBinder.DeathRecipient f384684l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f384685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f384686n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.obric.aiagent.ipc.control.a f384687o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final b f384688p;

    public static final class a {
    }

    public static final class b implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BinderControl f384689a;

        public static final class a implements IBinder.DeathRecipient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ BinderControl f384690a;

            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                BinderControl r100 = this.f384690a;
                monitor-enter(r100);
                int r101 = e.f384738a;     // Catch: Throwable -> L7
                StringBuilder r102 = new StringBuilder("binderDied: ");     // Catch: Throwable -> L7
                int r103 = BinderControl.f384674q;     // Catch: Throwable -> L7
                r102.append(r100.f());     // Catch: Throwable -> L7
                r102.append(", this=");     // Catch: Throwable -> L7
                r102.append(r100);     // Catch: Throwable -> L7
                e.a("IPCControl", r102.toString());     // Catch: Throwable -> L7
                BinderControl.e(r100);     // Catch: Throwable -> L7
                Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L7
                monitor-exit(r100);
                return;
            L7:
                th = move-exception;
                throw th;
            }

            public a(BinderControl r100, IBinder r101) {
                this.f384690a = r100;
            }
        }

        public b(BinderControl r100) {
            this.f384689a = r100;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            BinderControl r101 = this.f384689a;
            monitor-enter(r101);
        L24:
            th = move-exception;
            throw th;
        L5:
            if (r101.f384683k == true) goto L9;
            e.a("IPCControl", "onServiceDisconnected: ignore, not bound");     // Catch: Throwable -> L24
            monitor-exit(r101);
            return;
        L9:
            int r102 = e.f384738a;     // Catch: Throwable -> L24
            e.a("IPCControl", "onServiceDisconnected: " + r101.f() + ", this=" + r101);     // Catch: Throwable -> L24
            Job r103 = r101.f384677e;     // Catch: Throwable -> L24
            if (r103 == null) goto L12;
            Job.DefaultImpls.cancel$default(r103, null, 1, null);     // Catch: Throwable -> L24
        L12:
            r101.f384677e = null;     // Catch: Throwable -> L24
            r101.g();     // Catch: Throwable -> L24
            r101.f384678f = null;     // Catch: Throwable -> L24
            r101.i();     // Catch: Throwable -> L24
            r101.f384681i = false;     // Catch: Throwable -> L24
            com.obric.aiagent.ipc.control.b.a<IBinder> r104 = r101.f384679g;     // Catch: Throwable -> L24
            if (r104 == null) goto L16;
            r104.a();     // Catch: Throwable -> L24
        L16:
            if (r101.f384679g != null) goto L18;
        L20:
            e.a("IPCControl", "onServiceDisconnected: callback replaced, not rebind, this=" + this + ", callback=" + r101.f384679g + ",currentCallback=" + r104);     // Catch: Throwable -> L24
        L21:
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L24
            monitor-exit(r101);
            return;
        L18:
            if (r101.f384679g != r104) goto L20;
            r101.j(2);     // Catch: Throwable -> L24
            goto L21
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            BinderControl r102 = this.f384689a;
            monitor-enter(r102);
        L31:
            th = move-exception;
            throw th;
        L5:
            if (r102.f384683k == true) goto L9;
            e.a("IPCControl", "onServiceConnected: ignore, not bound");     // Catch: Throwable -> L31
            monitor-exit(r102);
            return;
        L9:
            if (r101 != null) goto L13;
            e.a("IPCControl", "onServiceConnected: service is null");     // Catch: Throwable -> L31
            monitor-exit(r102);
            return;
        L13:
            int r103 = e.f384738a;     // Catch: Throwable -> L31
            e.a("IPCControl", "onServiceConnected: " + r102.f() + ", this=" + r102);     // Catch: Throwable -> L31
            Job r104 = r102.f384677e;     // Catch: Throwable -> L31
            if (r104 == null) goto L16;
            Job.DefaultImpls.cancel$default(r104, null, 1, null);     // Catch: Throwable -> L31
        L16:
            r102.f384677e = null;     // Catch: Throwable -> L31
            r102.g();     // Catch: Throwable -> L31
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L19
            a r106 = new a(r102, r101);     // Catch: Throwable -> L19
            r101.linkToDeath(r106, 0);     // Catch: Throwable -> L19
            r102.f384684l = r106;     // Catch: Throwable -> L19
            r102.f384678f = r101;     // Catch: Throwable -> L19
            r102.f384681i = false;     // Catch: Throwable -> L19
            r102.f384680h = true;     // Catch: Throwable -> L19
            e.a("IPCControl", "onReady: " + r102.f() + ",callback = " + r102.f384679g + ", instance = " + r102.f384678f);     // Catch: Throwable -> L19
            Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
        L21:
            Throwable r108 = Result.m9452exceptionOrNullimpl(r107);     // Catch: Throwable -> L31
            if (r108 == null) goto L26;
            int r109 = e.f384738a;     // Catch: Throwable -> L31
            e.b("IPCControl", "onReady fail " + ExceptionsKt.stackTraceToString(r108), r108);     // Catch: Throwable -> L31
            r102.i();     // Catch: Throwable -> L31
            r102.f384678f = null;     // Catch: Throwable -> L31
            r102.j(3);     // Catch: Throwable -> L31
            monitor-exit(r102);
            return;
        L26:
            com.obric.aiagent.ipc.control.b.a<IBinder> r110 = r102.f384679g;     // Catch: Throwable -> L31
            if (r110 == null) goto L29;
            r110.b(r101);     // Catch: Throwable -> L31
            Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L31
        L29:
            monitor-exit(r102);
            return;
        L19:
            th = move-exception;
            Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L31
            r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L31
            goto L21
        }
    }

    static {
    }

    @Override // com.obric.aiagent.ipc.control.b
    public final com.obric.aiagent.ipc.control.b.c c() {
        monitor-enter(this);
        int r100 = e.f384738a;     // Catch: Throwable -> L13
        e.a("IPCControl", "forceRebind: forceRebinding=" + this.f384681i + ", isConnectionRegistered=" + this.f384683k + ", instance=" + this.f384678f);     // Catch: Throwable -> L13
        if (this.f384681i == false) goto L10;
        com.obric.aiagent.ipc.control.b.c r101 = new com.obric.aiagent.ipc.control.b.c();     // Catch: Throwable -> L13
        monitor-exit(this);
        return r101;
    L10:
        this.f384681i = true;     // Catch: Throwable -> L13
        com.obric.aiagent.ipc.control.b.c r102 = h();     // Catch: Throwable -> L13
        monitor-exit(this);
        return r102;
    L13:
        th = move-exception;
        throw th;
    }

    public final String f() {
        return this.f384675c.getAction();
    }

    public final void g() {
        IBinder.DeathRecipient r100 = this.f384684l;
        if (r100 == null) goto L15;
        IBinder r101 = this.f384678f;
        if (r101 != null) goto L13;
    L11:
        this.f384684l = null;
        return;
    L13:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r101.unlinkToDeath(r100, 0)));     // Catch: Throwable -> L8
    L10:
        Result.m9448boximpl(r103);
    L8:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void i() {
        if (this.f384683k == true) goto L6;
        e.a("IPCControl", "safeUnbind: ignore, not bound");
        return;
    L6:
        int r100 = e.f384738a;
        e.a("IPCControl", "safeUnbind: " + f());
        this.f384683k = false;
        g();
        Context r101 = getContext();
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        r101.unbindService(this.f384688p);     // Catch: Throwable -> L9
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L17;
        e.b("IPCControl", "safeUnbind error", r104);
        return;
    L17:
        return;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final com.obric.aiagent.ipc.control.b.c h() {
        i();
        e.a("IPCControl", "executeBind started");
        Context r100 = getContext();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(r100.bindService(this.f384675c, this.f384688p, 65)));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L10;
        int r104 = e.f384738a;
        e.b("IPCControl", "executeBind error: " + r103.getMessage(), r103);
    L10:
        Object r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == true) goto L14;
        r105 = r102;
    L14:
        Pair r106 = TuplesKt.to(r105, Result.m9452exceptionOrNullimpl(r102));
        boolean r107 = ((Boolean) r106.component1()).booleanValue();
        Throwable r108 = (Throwable) r106.component2();
        if (r107 == false) goto L21;
        this.f384683k = true;
        e.a("IPCControl", "bindService success");
        long r109 = this.f384687o.f384691a;
        Job r110 = this.f384677e;
        if (r110 == null) goto L19;
        Job.DefaultImpls.cancel$default(r110, null, 1, null);
    L19:
        this.f384677e = BuildersKt.launch$default(this.f384676d, null, null, new BinderControl$waitForService$1(r109, this, null), 3, null);
        return new com.obric.aiagent.ipc.control.b.c();
    L21:
        this.f384683k = false;
        if (this.f384680h == true) goto L32;
        e.a("IPCControl", "bindService failed");
        if ((r108 instanceof SecurityException) == false) goto L27;
        e.b("IPCControl", "createBinder exception", r108);
        this.f384681i = false;
        return new com.obric.aiagent.ipc.control.b.c(false, ((SecurityException) r108).getMessage());
    L27:
        this.f384681i = false;
        Intent r111 = com.obric.aiagent.ipc.control.b.C4585b.a(getContext(), this.f384675c);
        if (r111 == null) goto L30;
        this.f384675c.setAction(r111.getAction());
        this.f384675c.setPackage(r111.getPackage());
        this.f384675c.setComponent(r111.getComponent());
        goto L32
    L30:
        return new com.obric.aiagent.ipc.control.b.c(false, "No Service for " + f());
    L32:
        j(3);
        return new com.obric.aiagent.ipc.control.b.c();
    L5:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final void e(BinderControl r100) {
        if (r100.f384683k == true) goto L5;
        e.a("IPCControl", "onBinderDied: ignore, not bound");
        return;
    L5:
        int r101 = e.f384738a;
        e.a("IPCControl", "onBinderDied: " + r100.f() + ", this=" + r100);
        r100.g();
        r100.f384678f = null;
        r100.i();
        com.obric.aiagent.ipc.control.b.a<IBinder> r102 = r100.f384679g;
        if (r102 == null) goto L9;
        r102.a();
    L9:
        if (r100.f384679g != null) goto L11;
    L13:
        e.a("IPCControl", "onBinderDied: callback replaced, not rebind, this=" + r100 + ", callback=" + r100.f384679g + ",currentCallback=" + r102);
        return;
    L11:
        if (r100.f384679g != r102) goto L13;
        r100.j(2);
    }

    @Override // com.obric.aiagent.ipc.control.b
    public final com.obric.aiagent.ipc.control.b.c a(boolean r100) {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L5:
        if (this.f384682j == r100) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == false) goto L12;
        this.f384682j = r100;     // Catch: Throwable -> L26
        if (r100 == false) goto L12;
        this.f384685m = 200;     // Catch: Throwable -> L26
        this.f384686n = 1000;     // Catch: Throwable -> L26
    L12:
        int r102 = e.f384738a;     // Catch: Throwable -> L26
        e.a("IPCControl", "appStateChange: " + f() + ", foreground = " + this.f384682j + ", fgChanged = " + r101 + ",isConnectionRegistered = " + this.f384683k + ", instance = " + this.f384678f + ", this=" + this);     // Catch: Throwable -> L26
        if (r101 == true) goto L15;
    L23:
        com.obric.aiagent.ipc.control.b.c r103 = new com.obric.aiagent.ipc.control.b.c();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r103;
    L15:
        if (this.f384682j == false) goto L23;
        if (this.f384683k == true) goto L23;
        if (this.f384678f != null) goto L23;
        com.obric.aiagent.ipc.control.b.c r104 = h();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r104;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.obric.aiagent.ipc.control.b
    public final com.obric.aiagent.ipc.control.b.c b(i.a r100) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        monitor-enter(this);
        int r101 = e.f384738a;     // Catch: Throwable -> L34
        e.a("IPCControl", "createBinder for " + f() + ", foreground = " + this.f384682j + ", this=" + this);     // Catch: Throwable -> L34
        r100.getClass();     // Catch: Throwable -> L34
        IBinder r102 = this.f384678f;     // Catch: Throwable -> L34
        if (r102 == null) goto L10;
        r100.b(r102);     // Catch: Throwable -> L34
        this.f384679g = r100;     // Catch: Throwable -> L34
        com.obric.aiagent.ipc.control.b.c r103 = new com.obric.aiagent.ipc.control.b.c();     // Catch: Throwable -> L34
        monitor-exit(this);
        return r103;
    L10:
        if (this.f384683k == false) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L31;
        e.a("IPCControl", "createBinder: already connecting, replace callback and wait...");     // Catch: Throwable -> L34
        com.obric.aiagent.ipc.control.b.a<IBinder> r105 = this.f384679g;     // Catch: Throwable -> L34
        if (r105 == null) goto L20;
        r105.onDestroy();     // Catch: Throwable -> L34
    L20:
        this.f384679g = r100;     // Catch: Throwable -> L34
        if (this.f384677e == null) goto L23;
    L28:
        com.obric.aiagent.ipc.control.b.c r106 = new com.obric.aiagent.ipc.control.b.c();     // Catch: Throwable -> L34
        monitor-exit(this);
        return r106;
    L23:
        if (this.f384683k == false) goto L28;
        long r107 = this.f384687o.f384691a;     // Catch: Throwable -> L34
        Job r108 = this.f384677e;     // Catch: Throwable -> L34
        if (r108 == null) goto L27;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);     // Catch: Throwable -> L34
    L27:
        this.f384677e = BuildersKt.launch$default(this.f384676d, null, null, new BinderControl$waitForService$1(r107, this, null), 3, null);     // Catch: Throwable -> L34
        goto L28
    L31:
        this.f384679g = r100;     // Catch: Throwable -> L34
        com.obric.aiagent.ipc.control.b.c r109 = h();     // Catch: Throwable -> L34
        monitor-exit(this);
        return r109;
    L12:
        if (this.f384677e != null) goto L15;
        r104 = false;
    L34:
        th = move-exception;
        throw th;
    }

    public final void j(int r110) {
        if (r110 != 2) goto L5;
        long r100 = this.f384686n;
    L6:
        long r101 = r100;
        int r102 = e.f384738a;
        e.a("IPCControl", "scheduleRebind: reason = " + r110 + ", delay = " + r101);
        Job r103 = this.f384677e;
        if (r103 == null) goto L9;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L9:
        this.f384677e = BuildersKt.launch$default(this.f384676d, null, null, new BinderControl$scheduleRebind$1(r101, this, r110, null), 3, null);
        return;
    L5:
        r100 = this.f384685m;
        goto L6
    }

    public BinderControl(Context r100, Intent r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "intent");
        super(r100);
        this.f384675c = new Intent(r101);
        this.f384676d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getDefault()));
        this.f384685m = 200;
        this.f384686n = 1000;
        this.f384687o = new com.obric.aiagent.ipc.control.a(0);
        this.f384688p = new b(this);
    }

    public static final void d(BinderControl r100, int r101) {
        if (r101 != 2) goto L5;
        long r102 = Math.min(r100.f384687o.f384692b, r100.f384686n * ((long) 3));
        r100.f384686n = r102;
    L6:
        int r103 = e.f384738a;
        e.a("IPCControl", "increaseRebindDelay: reason = " + r101 + ", nextDelay = " + r102);
        return;
    L5:
        r102 = Math.min(r100.f384687o.f384693c, r100.f384685m * ((long) 3));
        r100.f384685m = r102;
        goto L6
    }
}
