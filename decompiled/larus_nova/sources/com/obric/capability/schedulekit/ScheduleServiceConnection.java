package com.obric.capability.schedulekit;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.obric.capabilitykit.common.ICapabilitySchedule;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class ScheduleServiceConnection implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ScheduleServiceConnection f396032a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f396033b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/capability/schedulekit/ScheduleServiceConnection$BindState;", "", "NotStart", "Started", "Connected", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1})
    public static final enum BindState extends Enum<BindState> {
        public static final BindState Connected = null;
        public static final BindState NotStart = null;
        public static final BindState Started = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BindState[] f396034a = null;

        public static BindState valueOf(String r100) {
            return (BindState) r27.a.a(BindState.class, r100);
        }

        public static BindState[] values() {
            return (BindState[]) f396034a.clone();
        }

        static {
            BindState r100 = new BindState("NotStart", 0);
            NotStart = r100;
            BindState r101 = new BindState("Started", 1);
            Started = r101;
            BindState r102 = new BindState("Connected", 2);
            Connected = r102;
            f396034a = new BindState[]{r100, r101, r102};
        }

        public BindState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBinder f396035a;

        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            via.b r100 = via.b.f555361a;
            ThreadMethodProxy.currentThread().getName();
            r100.a("ScheduleServiceConnection");
            this.f396035a.unlinkToDeath(this, 0);
            Object r101 = ScheduleServiceConnection.f396033b;
            monitor-enter(r101);
            ScheduleServiceConnection r102 = ScheduleServiceConnection.f396032a;     // Catch: Throwable -> L8
            BindState r103 = BindState.NotStart;     // Catch: Throwable -> L8
            r102.getClass();     // Catch: Throwable -> L8
            Intrinsics.checkNotNullParameter(r103, "<set-?>");     // Catch: Throwable -> L8
            ScheduleServiceConnection r104 = ScheduleServiceConnection.f396032a;     // Catch: Throwable -> L8
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r101);
            b.c();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public a(IBinder r100) {
            this.f396035a = r100;
        }
    }

    public ScheduleServiceConnection() {
    }

    static {
        f396032a = new ScheduleServiceConnection();
        f396033b = new Object();
        BindState r100 = BindState.NotStart;
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r100) {
        via.b r101 = via.b.f555361a;
        ThreadMethodProxy.currentThread().getName();
        r101.a("ScheduleServiceConnection");
        Object r102 = f396033b;
        monitor-enter(r102);
        BindState r103 = BindState.NotStart;     // Catch: Throwable -> L11
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r102);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
        uia.a.f550220a.getClass();     // Catch: Throwable -> L8
        throw new IllegalStateException("app module must call Apphost.setApphost()");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        b.c();
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        via.b.f555361a.a("ScheduleServiceConnection");
        Object r101 = f396033b;
        monitor-enter(r101);
        BindState r102 = BindState.NotStart;     // Catch: Throwable -> L8
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r101);
        b.c();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        via.b r102 = via.b.f555361a;
        ThreadMethodProxy.currentThread().getName();
        r102.a("ScheduleServiceConnection");
        monitor-enter(f396033b);
        BindState r103 = BindState.NotStart;     // Catch: Throwable -> L17
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        r101.linkToDeath(new a(r101), 0);     // Catch: Throwable -> L11
    L9:
        new d(ICapabilitySchedule.Stub.asInterface(r101));     // Catch: Throwable -> L11
        r102.a("ScheduleServiceConnection");     // Catch: Throwable -> L11
        b.b();     // Catch: Throwable -> L11
        throw null;     // Catch: Throwable -> L11
    L8:
        r101 = null;
    L11:
        th = move-exception;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L17
        Throwable r106 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));     // Catch: Throwable -> L17
        if (r106 == null) goto L23;
        via.b r107 = via.b.f555361a;     // Catch: Throwable -> L17
        ExceptionsKt.stackTraceToString(r106);     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter("ScheduleServiceConnection", "tag");     // Catch: Throwable -> L17
        int r108 = via.a.f555360a;     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter("ac_".concat("ScheduleServiceConnection"), "tag");     // Catch: Throwable -> L17
        return;
    L23:
        return;
    L17:
        th = move-exception;
        throw th;
    }
}
