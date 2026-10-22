package com.bytedance.flow_audio.impl.business.asr;

import com.bytedance.flow_audio.api.service.common.IKMPLoggerService;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes19.dex */
public final class FlowAsrCallbackDispatcher {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f243762i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jw5.a f243763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zw5.a f243764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f243765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f243766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f243767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public jw5.b f243768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f243769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f243770h;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jw5.b f243771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f243772b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f243771a, r101.f243771a) == true) goto L12;
            return false;
        L12:
            if (this.f243772b == r101.f243772b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f243771a.hashCode() * 31;
            long r101 = this.f243772b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "ListenerSnapshot(listener=" + this.f243771a + ", version=" + this.f243772b + ')';
        }

        public b(jw5.b r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            this.f243771a = r100;
            this.f243772b = r101;
        }
    }

    static {
        f243762i = zw5.b.a("FlowAsrCallbackDispatcher");
    }

    public final void a() {
        Object r100 = this.f243765c;
        monitor-enter(r100);
        this.f243768f = null;     // Catch: Throwable -> L9
        this.f243769g++;     // Catch: Throwable -> L9
        monitor-exit(r100);
        IKMPLoggerService r101 = lp7.a.f510233a;
        lp7.a.c(f243762i, this.f243764b.a("listener cleared"));
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void b(iw5.c r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        if (Intrinsics.areEqual(r110.f496225b, this.f243763a.getTaskId()) == true) goto L6;
        IKMPLoggerService r100 = lp7.a.f510233a;
        lp7.a.d(f243762i, this.f243764b.a("result ignored eventTaskId=" + r110.f496225b + " type=" + r110.f496226c));
        return;
    L6:
        Object r101 = this.f243765c;
        monitor-enter(r101);
        jw5.b r102 = this.f243768f;     // Catch: Throwable -> L19
        if (r102 == null) goto L12;
        b r103 = new b(r102, this.f243769g);     // Catch: Throwable -> L19
    L13:
        b r104 = r103;
        monitor-exit(r101);
        if (r104 == null) goto L24;
        BuildersKt.launch$default(this.f243767e, null, null, new FlowAsrCallbackDispatcher$dispatchResult$$inlined$notifyListener$1(this, r104, null, this, r110), 3, null);
        return;
    L24:
        return;
    L12:
        r103 = null;
    L19:
        th = move-exception;
        throw th;
    }

    public final void c(iw5.c r110) {
        Intrinsics.checkNotNullParameter(r110, "result");
        if (Intrinsics.areEqual(r110.f496225b, this.f243763a.getTaskId()) == true) goto L6;
        IKMPLoggerService r100 = lp7.a.f510233a;
        lp7.a.d(f243762i, this.f243764b.a("stream result ignored eventTaskId=" + r110.f496225b));
        return;
    L6:
        Object r101 = this.f243765c;
        monitor-enter(r101);
        jw5.b r102 = this.f243768f;     // Catch: Throwable -> L19
        if (r102 == null) goto L12;
        b r103 = new b(r102, this.f243769g);     // Catch: Throwable -> L19
    L13:
        b r104 = r103;
        monitor-exit(r101);
        if (r104 == null) goto L24;
        BuildersKt.launch$default(this.f243767e, null, null, new FlowAsrCallbackDispatcher$dispatchStreamResult$$inlined$notifyListener$1(this, r104, null, this, r110), 3, null);
        return;
    L24:
        return;
    L12:
        r103 = null;
    L19:
        th = move-exception;
        throw th;
    }

    public final void d(iw5.f r110) {
        Intrinsics.checkNotNullParameter(r110, "sentence");
        Object r100 = this.f243765c;
        monitor-enter(r100);
        jw5.b r101 = this.f243768f;     // Catch: Throwable -> L15
        if (r101 == null) goto L8;
        b r102 = new b(r101, this.f243769g);     // Catch: Throwable -> L15
    L9:
        b r103 = r102;
        monitor-exit(r100);
        if (r103 == null) goto L20;
        BuildersKt.launch$default(this.f243767e, null, null, new FlowAsrCallbackDispatcher$dispatchStreamSentence$$inlined$notifyListener$1(this, r103, null, this, r110), 3, null);
        return;
    L20:
        return;
    L8:
        r102 = null;
    L15:
        th = move-exception;
        throw th;
    }

    public final boolean e(String r100) {
        Object r101 = this.f243766d;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f243770h == true) goto L7;
        boolean r102 = true;
        this.f243770h = true;     // Catch: Throwable -> L13
    L8:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r101);
        if (r102 == true) goto L12;
        IKMPLoggerService r104 = lp7.a.f510233a;
        lp7.a.d(f243762i, this.f243764b.a("terminal callback ignored callback=".concat(r100)));
    L12:
        return r102;
    L7:
        r102 = false;
        goto L8
    }

    public FlowAsrCallbackDispatcher(o r100, zw5.a r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, "logContext");
        this.f243763a = r100;
        this.f243764b = r101;
        this.f243765c = new Object();
        this.f243766d = new Object();
        this.f243767e = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
    }
}
