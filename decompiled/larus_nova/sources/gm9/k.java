package gm9;

import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f481765a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<com.larus.network.b> f481766b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference<com.larus.network.a> f481767c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile com.larus.network.h f481768d;

    public k() {
    }

    static {
        f481765a = new k();
        f481766b = new CopyOnWriteArrayList();
        f481767c = new AtomicReference();
    }

    public static void b(com.larus.network.a r110) {
        CopyOnWriteArrayList<com.larus.network.b> r100 = f481766b;
        if ((!r100.isEmpty()) == false) goto L9;
        Iterator<com.larus.network.b> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        com.larus.network.b r102 = r101.next();
        k r103 = f481765a;
        Intrinsics.checkNotNull(r102);
        r103.a(r102, r110);
        goto L6
    L8:
        return;
    L9:
        String r104 = r110.f360099a;
        String r105 = r110.f360100b;
        String r106 = r110.f360101c;
        String r107 = r110.f360102d;
        String r108 = r110.f360103e;
        long r111 = r110.f360105g;
        Intrinsics.checkNotNullParameter(r104, "code");
        Intrinsics.checkNotNullParameter(r105, "rawActions");
        Intrinsics.checkNotNullParameter(r107, "host");
        Intrinsics.checkNotNullParameter(r108, "path");
        com.larus.network.a r109 = new com.larus.network.a(r104, r105, r106, r107, r108, true, r111);
        AtomicReference<com.larus.network.a> r112 = f481767c;
    L11:
        if (r112.compareAndSet(null, r109) == true) goto L12;
        if (r112.get() == null) goto L11;
        boolean r113 = false;
    L17:
        if (r113 == true) goto L20;
        FLogger.f375446a.i("FlowAccessControl", "Drop action while waiting for listener, host=" + r110.f360102d + ", path=" + r110.f360103e);
        return;
    L20:
        FLogger.f375446a.i("FlowAccessControl", "Cache first action=" + r109);
        CopyOnWriteArrayList<com.larus.network.b> r114 = f481766b;
        if ((!r114.isEmpty()) == false) goto L28;
        com.larus.network.a r115 = f481767c.getAndSet(null);
        if (r115 == null) goto L34;
        Iterator<com.larus.network.b> r116 = r114.iterator();
    L26:
        if (r116.hasNext() == false) goto L35;
        com.larus.network.b r117 = r116.next();
        k r118 = f481765a;
        Intrinsics.checkNotNull(r117);
        r118.a(r117, r115);
        goto L26
    L35:
        return;
    L34:
        return;
    L28:
        return;
    L12:
        r113 = true;
        goto L17
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        Unit r101 = null;
        if (r100 == null) goto L50;
        Request r102 = r100.request();
        if (r102 == null) goto L50;
        return r100.proceed(r102);
    L9:
        th = move-exception;
        if ((th instanceof CronetIOException) == false) goto L49;
        com.larus.network.h r103 = f481768d;
        if (r103 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r103 = null;
    L16:
        if (Intrinsics.areEqual(r103.b(), Boolean.FALSE) == true) goto L48;
        final String r104 = r102.getHost();
        final String r105 = "";
        if (r104 != null) goto L20;
        r104 = "";
    L20:
        String r106 = r102.getPath();
        if (r106 == null) goto L24;
        r105 = r106;
    L24:
        HashMap<String, HashSet<String>> r107 = r103.a();
        if (r107 == null) goto L27;
        HashSet<String> r108 = r107.get(r104);
    L29:
        if (r108 != null) goto L31;
    L53:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L42
        int r110 = l.f481769a;     // Catch: Throwable -> L42
        com.larus.network.a r111 = l.b(r102, th);     // Catch: Throwable -> L42
        if (r111 == null) goto L40;
        b(r111);     // Catch: Throwable -> L42
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L42
    L40:
        Object r112 = Result.m9449constructorimpl(r101);     // Catch: Throwable -> L42
    L44:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L55;
        FLogger.f375446a.e("FlowAccessControl", "Handle access control failed, host=" + r104 + ", path=" + r105, r113);
        throw th;
    L55:
        throw th;
    L42:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L44
    L31:
        if (r108.contains("*") == false) goto L33;
    L35:
        FLogger.f375446a.g("FlowAccessControl", new j(r104, r105));
        throw th;
    L33:
        if (r108.contains(r105) == true) goto L35;
    L27:
        r108 = null;
        goto L29
    L48:
        throw th;
    L49:
        throw th;
    L50:
        return null;
    }

    public final void a(final com.larus.network.b r100, final com.larus.network.a r101) {
        FLogger.f375446a.i("FlowAccessControl", "Dispatch action=" + r101);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        TTExecutors.getSerialThreadPool().execute(new i(this, r100, r101));     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        FLogger.f375446a.e("FlowAccessControl", "Schedule action listener failed, host=" + r101.f360102d, r104);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }
}
