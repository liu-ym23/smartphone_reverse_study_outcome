package com.larus.im.internal.database.slowtask;

import com.larus.im.internal.core.message.utils.e;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import com.larus.im.internal.database.utils.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public final class DBSlowTaskManager implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DBSlowTaskManager f348138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f348139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final buc.a f348140c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f348141d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f348142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Job f348143f;

    public DBSlowTaskManager() {
    }

    static {
        f348138a = new DBSlowTaskManager();
        f348139b = "";
        f348140c = buc.b.a(false);
        f348141d = LazyKt.lazy(new b());
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dbName");
        if (e.a().f348508a == true) goto L5;
        return;
    L5:
        com.larus.im.internal.delegate.a.f348188b.i("DBSlowTaskManager", "startWhenIdle, dbName:" + r100);
        if (f348139b.length() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        f348139b = r100;
        com.larus.im.internal.database.utils.e.c(new DBSlowTaskManager$startWhenIdle$1(null));
        return;
    L12:
        return;
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.larus.im.internal.database.utils.f
    public final void a(boolean r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L20
        com.larus.im.internal.delegate.a r102 = com.larus.im.internal.delegate.a.f348188b;     // Catch: Throwable -> L20
        StringBuilder r103 = new StringBuilder("onChangeIdle, isIdle:");     // Catch: Throwable -> L20
        r103.append(r100);     // Catch: Throwable -> L20
        r103.append(",hasRun:");     // Catch: Throwable -> L20
        buc.a r104 = f348140c;     // Catch: Throwable -> L20
        r103.append(r104);     // Catch: Throwable -> L20
        r103.append(",monitorCount:");     // Catch: Throwable -> L20
        r103.append(f348142e);     // Catch: Throwable -> L20
        r102.i("DBSlowTaskManager", r103.toString());     // Catch: Throwable -> L20
        if (r104.c() == false) goto L6;
    L18:
        CopyOnWriteArrayList<f> r105 = OmniDatabaseExtKt.f348152a;     // Catch: Throwable -> L20
        Intrinsics.checkNotNullParameter(this, "listener");     // Catch: Throwable -> L20
        OmniDatabaseExtKt.f348152a.remove(this);     // Catch: Throwable -> L20
        return;
    L6:
        if (((List) f348141d.getValue()).isEmpty() == true) goto L18;
        if (f348142e >= e.a().f348511d) goto L18;
        f348142e++;     // Catch: Throwable -> L20
        if (r100 == false) goto L13;
        f348143f = com.larus.im.internal.database.utils.e.c(new DBSlowTaskManager$onChangeIdle$1$1(this, null));     // Catch: Throwable -> L20
    L17:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L28;
        com.larus.im.internal.delegate.a.f348188b.e("DBSlowTaskManager", "onChangeIdle failed:" + r107);
        return;
    L28:
        return;
    L13:
        Job r108 = f348143f;     // Catch: Throwable -> L20
        if (r108 == null) goto L16;
        Job.DefaultImpls.cancel$default(r108, null, 1, null);     // Catch: Throwable -> L20
    L16:
        f348143f = null;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0084 -> B:26:0x0088). Please report as a decompilation issue!!! */
    public static final Object b(DBSlowTaskManager r100, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof DBSlowTaskManager$runTasks$1) == false) goto L7;
        DBSlowTaskManager$runTasks$1 r101 = (DBSlowTaskManager$runTasks$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        long r105 = r101.J$0;
        c r106 = (c) r101.L$1;
        Iterator r107 = (Iterator) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L31
    L26:
        long r108 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime() - r105;     // Catch: Throwable -> L31
        com.larus.im.internal.delegate.a.f348188b.i("DBSlowTaskManager", "runTask:" + r106.getName() + ",costTime:" + r108);     // Catch: Throwable -> L31
        if (r108 > e.a().f348512e) goto L42;
    L22:
        if (r107.hasNext() == false) goto L29;
        r106 = (c) r107.next();     // Catch: Throwable -> L31
        r105 = com.larus.im.internal.delegate.c.f348197a.elapsedRealtime();     // Catch: Throwable -> L31
        String r109 = f348139b;     // Catch: Throwable -> L31
        r101.L$0 = r107;     // Catch: Throwable -> L31
        r101.L$1 = r106;     // Catch: Throwable -> L31
        r101.J$0 = r105;     // Catch: Throwable -> L31
        r101.label = 1;     // Catch: Throwable -> L31
        if (r106.a(r109, r101) != r111) goto L26;
        return r111;
    L29:
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L38;
        com.larus.im.internal.delegate.a.f348188b.e("DBSlowTaskManager", "runTasks failed:" + r113);
    L38:
        return Unit.INSTANCE;
    L42:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L31
        buc.a r115 = f348140c;     // Catch: Throwable -> L31
        if (r115.c() == true) goto L40;
        r115.d(true);     // Catch: Throwable -> L31
        r107 = ((List) f348141d.getValue()).iterator();     // Catch: Throwable -> L31
        goto L22
    L40:
        return Unit.INSTANCE;
    L31:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new DBSlowTaskManager$runTasks$1(r100, r110);
        goto L8
    }
}
