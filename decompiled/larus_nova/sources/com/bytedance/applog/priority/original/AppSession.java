package com.bytedance.applog.priority.original;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.lark.utils.statistics.PerfLog;
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

/* JADX INFO: loaded from: classes14.dex */
public final class AppSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.applog.priority.h f192638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f192639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f192640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile String f192641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutexImpl f192642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f192643f;

    public final SessionDatabase a() {
        return (SessionDatabase) this.f192643f.getValue();
    }

    public final void b() {
        this.f192638a.f192622c.a("AppSession:packHistorySessionEvents", new AppSession$packHistorySessionEvents$1(this));
        AppSession$packHistorySessionEvents$2 r100 = new AppSession$packHistorySessionEvents$2(this, this.f192641d, null);
        Intrinsics.checkNotNullParameter(r100, "block");
        CoroutineScope r101 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        BuildersKt.launch$default(r101, null, null, new CommonKt$runOnIOThread$1$1(r100, r101, null), 3, null);
    }

    public final com.bytedance.applog.priority.h getContext() {
        return this.f192638a;
    }

    public final Unit e(final c r100) {
        this.f192638a.f192622c.a("AppSession:trackTerminate", new AppSession$trackTerminate$2(r100));
        final boolean r101 = this.f192640c.a(EventVerify.TYPE_TERMINATE, Model$EventType.Terminate.getType(), LazyKt.lazy(new AppSession$trackTerminate$inserted$1(r100, this)));
        this.f192638a.f192621b.f192616f.monitorIncreaseStats("priority_collect_terminate", 1);
        this.f192638a.f192622c.a("AppSession:trackTerminate", new AppSession$trackTerminate$3(r100, r101));
        if (r101 == false) goto L18;
        final String r102 = r100.f192727a;
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        this.f192638a.f192622c.a("AppSession:removeSessionTerminate", new AppSession$removeTerminate$1(r102));
        SessionDatabase r103 = a();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "sessionId");
        SQLiteDatabase r104 = r103.b().getWritableDatabase();
        r104.beginTransaction();     // Catch: Throwable -> L11
        SQLiteStatement r105 = r104.compileStatement("delete from " + r103.f192695e + " where " + r103.f192696f + " = ?");     // Catch: Throwable -> L11
        r105.clearBindings();     // Catch: Throwable -> L8
        r105.bindString(1, r102);     // Catch: Throwable -> L8
        r105.executeUpdateDelete();     // Catch: Throwable -> L8
        r104.setTransactionSuccessful();     // Catch: Throwable -> L8
        r105.close();     // Catch: Throwable -> L11
    L13:
        CommonKt.b(r104);
        this.f192638a.f192622c.a("AppSession:removeSessionTerminate", new AppSession$removeTerminate$2(r102));
        goto L18
    L8:
        th = move-exception;
        r105.close();     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r103.f192691a.b("SessionDatabase:remove", th, new SessionDatabase$removePages$1(r102));     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CommonKt.b(r104);
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
    public final Object c(String r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof AppSession$packHistorySessionEventsExcludeSession$1) == false) goto L7;
        AppSession$packHistorySessionEventsExcludeSession$1 r100 = (AppSession$packHistorySessionEventsExcludeSession$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r103 = r100.label;
        if (r103 == 0) goto L24;
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L18;
        if (r103 != 3) goto L17;
        Iterator r113 = (Iterator) r100.L$1;
        AppSession r104 = (AppSession) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L40
        r103 = r104;
    L35:
        if (r113.hasNext() == false) goto L44;
        c r114 = (c) r113.next();     // Catch: Throwable -> L40
        r100.L$0 = r103;     // Catch: Throwable -> L40
        r100.L$1 = r113;     // Catch: Throwable -> L40
        r100.L$2 = null;     // Catch: Throwable -> L40
        r100.label = 3;     // Catch: Throwable -> L40
        if (r103.e(r114) != r102) goto L35;
        return r102;
    L44:
        r103.f192642e.unlock(null);
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        Iterator r115 = (Iterator) r100.L$2;
        String r105 = (String) r100.L$1;
        final ?? r106 = (AppSession) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L21
        String r116 = r105;
        final ?? r107 = r106;
    L30:
        if (r115.hasNext() == false) goto L34;
        a r108 = (a) r115.next();     // Catch: Throwable -> L40
        r100.L$0 = r107;     // Catch: Throwable -> L40
        r100.L$1 = r116;     // Catch: Throwable -> L40
        r100.L$2 = r115;     // Catch: Throwable -> L40
        r100.label = 2;     // Catch: Throwable -> L40
        if (r107.d(r108, true) != r102) goto L30;
        return r102;
    L34:
        final List<c> r117 = r107.a().c(r116);     // Catch: Throwable -> L40
        r107.f192638a.f192622c.a("AppSession:packHistoryTerminates", new AppSession$packHistorySessionEventsExcludeSession$4(r107, r117));     // Catch: Throwable -> L40
        r113 = r117.iterator();     // Catch: Throwable -> L40
        r103 = r107;
    L21:
        th = th;
    L53:
        r106.f192638a.f192622c.b("AppSession:packHistoryTerminates", th, new AppSession$packHistorySessionEventsExcludeSession$6(r106));     // Catch: Throwable -> L46
        r103 = r106;
    L46:
        th = move-exception;
        r106.f192642e.unlock(null);
        throw th;
    L23:
        r110 = (String) r100.L$1;
        AppSession r109 = (AppSession) r100.L$0;
        ResultKt.throwOnFailure(r112);
        final AppSession r118 = r109;
    L28:
        final List<a> r119 = r118.a().a();     // Catch: Throwable -> L40
        r118.f192638a.f192622c.a("AppSession:packHistorySessionEvents", new AppSession$packHistorySessionEventsExcludeSession$2(r118, r119));     // Catch: Throwable -> L40
        Iterator r120 = ((ArrayList) r119).iterator();     // Catch: Throwable -> L40
        r116 = r110;
        r115 = r120;
        r107 = r118;
        goto L30
    L24:
        ResultKt.throwOnFailure(r112);
        MutexImpl r121 = this.f192642e;
        r100.L$0 = this;
        r100.L$1 = r110;
        r100.label = 1;
        if (r121.a(null, r100) != r102) goto L27;
        return r102;
    L27:
        r118 = this;
    L40:
        th = th;
        r106 = r103;
    L7:
        r100 = new AppSession$packHistorySessionEventsExcludeSession$1(this, r111);
        goto L8
    }

    public final Object d(final a r100, boolean r101) {
        this.f192638a.f192622c.a("AppSession:trackLaunch", new AppSession$trackLaunch$2(r100));
        final boolean r102 = this.f192640c.a(EventVerify.TYPE_LAUNCH, Model$EventType.Launch.getType(), LazyKt.lazy(new AppSession$trackLaunch$inserted$1(r100, this)));
        this.f192638a.f192621b.f192616f.monitorIncreaseStats("priority_collect_launch", 1);
        this.f192638a.f192622c.a("AppSession:trackLaunch", new AppSession$trackLaunch$3(r100, r102));
        if (r102 == false) goto L19;
        if (r101 == false) goto L19;
        final String r103 = r100.f192719a;
        Intrinsics.checkNotNullParameter(r103, "sessionId");
        this.f192638a.f192622c.a("AppSession:removeSessionLaunch", new AppSession$removeLaunch$1(r103));
        SessionDatabase r104 = a();
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "sessionId");
        SQLiteDatabase r105 = r104.b().getWritableDatabase();
        r105.beginTransaction();     // Catch: Throwable -> L12
        SQLiteStatement r106 = r105.compileStatement("delete from " + r104.f192694d + " where " + r104.f192696f + " = ?");     // Catch: Throwable -> L12
        r106.clearBindings();     // Catch: Throwable -> L9
        r106.bindString(1, r103);     // Catch: Throwable -> L9
        r106.executeUpdateDelete();     // Catch: Throwable -> L9
        r105.setTransactionSuccessful();     // Catch: Throwable -> L9
        r106.close();     // Catch: Throwable -> L12
    L14:
        CommonKt.b(r105);
        this.f192638a.f192622c.a("AppSession:removeSessionLaunch", new AppSession$removeLaunch$2(r103));
        goto L19
    L9:
        th = move-exception;
        r106.close();     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        r104.f192691a.b("SessionDatabase:removeLaunch", th, new SessionDatabase$removeLaunch$1(r103));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CommonKt.b(r105);
        throw th;
    L19:
        return Boxing.boxBoolean(r102);
    }

    public AppSession(com.bytedance.applog.priority.h r100, b r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "listener");
        Intrinsics.checkNotNullParameter(r102, "eventTracker");
        this.f192638a = r100;
        this.f192639b = r101;
        this.f192640c = r102;
        this.f192642e = kotlinx.coroutines.sync.b.a();
        this.f192643f = LazyKt.lazy(new AppSession$store$2(this));
    }
}
