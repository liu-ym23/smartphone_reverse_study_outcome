package com.bytedance.applog.priority.original;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AppSession {
    public final com.bytedance.applog.priority.h a;
    public final b b;
    public final f c;
    public volatile String d;
    public final MutexImpl e;
    public final Lazy f;

    public final SessionDatabase a() {
        return (SessionDatabase) this.f.getValue();
    }

    public final void b() {
        this.a.c.a("AppSession:packHistorySessionEvents", new AppSession$packHistorySessionEvents$1(this));
        AppSession$packHistorySessionEvents$2 r1 = new AppSession$packHistorySessionEvents$2(this, this.d, null);
        Intrinsics.checkNotNullParameter(r1, "block");
        CoroutineScope r3 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        BuildersKt.launch$default(r3, null, null, new CommonKt$runOnIOThread$1$1(r1, r3, null), 3, null);
    }

    public final com.bytedance.applog.priority.h getContext() {
        return this.a;
    }

    public final Unit e(final c r7) {
        this.a.c.a("AppSession:trackTerminate", new AppSession$trackTerminate$2(r7));
        final boolean r0 = this.c.a("terminate", Model$EventType.Terminate.getType(), LazyKt.lazy(new AppSession$trackTerminate$inserted$1(r7, this)));
        this.a.b.f.monitorIncreaseStats("priority_collect_terminate", 1);
        this.a.c.a("AppSession:trackTerminate", new AppSession$trackTerminate$3(r7, r0));
        if (r0 == false) goto L18;
        final String r8 = r7.a;
        Intrinsics.checkNotNullParameter(r8, "sessionId");
        this.a.c.a("AppSession:removeSessionTerminate", new AppSession$removeTerminate$1(r8));
        SessionDatabase r1 = a();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "sessionId");
        SQLiteDatabase r2 = r1.b().getWritableDatabase();
        r2.beginTransaction();     // Catch: Throwable -> L11
        SQLiteStatement r3 = r2.compileStatement("delete from " + r1.e + " where " + r1.f + " = ?");     // Catch: Throwable -> L11
        r3.clearBindings();     // Catch: Throwable -> L8
        r3.bindString(1, r8);     // Catch: Throwable -> L8
        r3.executeUpdateDelete();     // Catch: Throwable -> L8
        r2.setTransactionSuccessful();     // Catch: Throwable -> L8
        r3.close();     // Catch: Throwable -> L11
    L13:
        CommonKt.b(r2);
        this.a.c.a("AppSession:removeSessionTerminate", new AppSession$removeTerminate$2(r8));
        goto L18
    L8:
        th = move-exception;
        r3.close();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r1.a.b("SessionDatabase:remove", th, new SessionDatabase$removePages$1(r8));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CommonKt.b(r2);
        throw th;
    L18:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.applog.priority.original.AppSession] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.applog.priority.original.AppSession, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.applog.priority.original.AppSession, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [com.bytedance.applog.priority.original.AppSession] */
    /* JADX WARN: Type inference failed for: r8v9, types: [com.bytedance.applog.priority.original.AppSession] */
    public final Object c(String r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof AppSession$packHistorySessionEventsExcludeSession$1) == false) goto L7;
        AppSession$packHistorySessionEventsExcludeSession$1 r0 = (AppSession$packHistorySessionEventsExcludeSession$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r3 = r0.label;
        if (r3 == 0) goto L24;
        if (r3 == 1) goto L23;
        if (r3 == 2) goto L18;
        if (r3 != 3) goto L17;
        Iterator r16 = (Iterator) r0.L$1;
        AppSession r4 = (AppSession) r0.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L40
        r3 = r4;
    L35:
        if (r16.hasNext() == false) goto L44;
        c r17 = (c) r16.next();     // Catch: Throwable -> L40
        r0.L$0 = r3;     // Catch: Throwable -> L40
        r0.L$1 = r16;     // Catch: Throwable -> L40
        r0.L$2 = null;     // Catch: Throwable -> L40
        r0.label = 3;     // Catch: Throwable -> L40
        if (r3.e(r17) != r2) goto L35;
        return r2;
    L44:
        r3.e.unlock(null);
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        Iterator r18 = (Iterator) r0.L$2;
        String r5 = (String) r0.L$1;
        final ?? r8 = (AppSession) r0.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L21
        String r19 = r5;
        final ?? r6 = r8;
    L30:
        if (r18.hasNext() == false) goto L34;
        a r9 = (a) r18.next();     // Catch: Throwable -> L40
        r0.L$0 = r6;     // Catch: Throwable -> L40
        r0.L$1 = r19;     // Catch: Throwable -> L40
        r0.L$2 = r18;     // Catch: Throwable -> L40
        r0.label = 2;     // Catch: Throwable -> L40
        if (r6.d(r9, true) != r2) goto L30;
        return r2;
    L34:
        final List<c> r110 = r6.a().c(r19);     // Catch: Throwable -> L40
        r6.a.c.a("AppSession:packHistoryTerminates", new AppSession$packHistorySessionEventsExcludeSession$4(r6, r110));     // Catch: Throwable -> L40
        r16 = r110.iterator();     // Catch: Throwable -> L40
        r3 = r6;
    L21:
        th = th;
    L53:
        r8.a.c.b("AppSession:packHistoryTerminates", th, new AppSession$packHistorySessionEventsExcludeSession$6(r8));     // Catch: Throwable -> L46
        r3 = r8;
    L46:
        th = move-exception;
        r8.e.unlock(null);
        throw th;
    L23:
        r13 = (String) r0.L$1;
        AppSession r7 = (AppSession) r0.L$0;
        ResultKt.throwOnFailure(r15);
        final AppSession r10 = r7;
    L28:
        final List<a> r111 = r10.a().a();     // Catch: Throwable -> L40
        r10.a.c.a("AppSession:packHistorySessionEvents", new AppSession$packHistorySessionEventsExcludeSession$2(r10, r111));     // Catch: Throwable -> L40
        Iterator r112 = ((ArrayList) r111).iterator();     // Catch: Throwable -> L40
        r19 = r13;
        r18 = r112;
        r6 = r10;
        goto L30
    L24:
        ResultKt.throwOnFailure(r15);
        MutexImpl r113 = this.e;
        r0.L$0 = this;
        r0.L$1 = r13;
        r0.label = 1;
        if (r113.a(null, r0) != r2) goto L27;
        return r2;
    L27:
        r10 = this;
    L40:
        th = th;
        r8 = r3;
    L7:
        r0 = new AppSession$packHistorySessionEventsExcludeSession$1(this, r14);
        goto L8
    }

    public final Object d(final a r7, boolean r8) {
        this.a.c.a("AppSession:trackLaunch", new AppSession$trackLaunch$2(r7));
        final boolean r0 = this.c.a("launch", Model$EventType.Launch.getType(), LazyKt.lazy(new AppSession$trackLaunch$inserted$1(r7, this)));
        this.a.b.f.monitorIncreaseStats("priority_collect_launch", 1);
        this.a.c.a("AppSession:trackLaunch", new AppSession$trackLaunch$3(r7, r0));
        if (r0 == false) goto L19;
        if (r8 == false) goto L19;
        final String r9 = r7.a;
        Intrinsics.checkNotNullParameter(r9, "sessionId");
        this.a.c.a("AppSession:removeSessionLaunch", new AppSession$removeLaunch$1(r9));
        SessionDatabase r1 = a();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "sessionId");
        SQLiteDatabase r10 = r1.b().getWritableDatabase();
        r10.beginTransaction();     // Catch: Throwable -> L12
        SQLiteStatement r2 = r10.compileStatement("delete from " + r1.d + " where " + r1.f + " = ?");     // Catch: Throwable -> L12
        r2.clearBindings();     // Catch: Throwable -> L9
        r2.bindString(1, r9);     // Catch: Throwable -> L9
        r2.executeUpdateDelete();     // Catch: Throwable -> L9
        r10.setTransactionSuccessful();     // Catch: Throwable -> L9
        r2.close();     // Catch: Throwable -> L12
    L14:
        CommonKt.b(r10);
        this.a.c.a("AppSession:removeSessionLaunch", new AppSession$removeLaunch$2(r9));
        goto L19
    L9:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r1.a.b("SessionDatabase:removeLaunch", th, new SessionDatabase$removeLaunch$1(r9));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CommonKt.b(r10);
        throw th;
    L19:
        return Boxing.boxBoolean(r0);
    }

    public AppSession(com.bytedance.applog.priority.h r2, b r3, f r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "listener");
        Intrinsics.checkNotNullParameter(r4, "eventTracker");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = kotlinx.coroutines.sync.b.a();
        this.f = LazyKt.lazy(new AppSession$store$2(this));
    }
}
