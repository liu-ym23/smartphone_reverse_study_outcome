package com.ss.android.lark.conditional.access.nopermission.interception;

import com.google.gson.Gson;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.utils.NoPermissionType;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.e0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f418092a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile Job f418093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile String f418094c;

    public b() {
    }

    static {
        f418092a = new b();
        f418094c = "";
    }

    public static void a() {
        String r100 = "";
        Job r101 = f418093b;
        if (r101 != null) goto L5;
    L81:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        String r103 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();     // Catch: Throwable -> L13
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        Object r104 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r104) == false) goto L18;
        r104 = "";
    L18:
        String r105 = (String) r104;
        boolean r106 = true;
        if (r105.length() != 0) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == false) goto L25;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "start: no foreground user, skip");
        return;
    L25:
        a.f418091a.getClass();
        String r108 = a.b().getString("no_permission_type", null);
        if (r108 != null) goto L28;
        r108 = "";
    L28:
        String r109 = a.b().getString("action_json", null);
        if (r109 == null) goto L33;
        r100 = r109;
    L33:
        if (r108.length() != 0) goto L35;
        boolean r110 = true;
    L37:
        if (r110 == false) goto L39;
    L71:
        c r111 = null;
    L72:
        if (r111 != null) goto L75;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "start: no persisted interception, skip");
        return;
    L75:
        f418094c = r105;
        int r112 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "start: probe begin, userId=" + r105 + ", traceId=" + r111.f418096b.getTraceId());
        f418093b = BuildersKt.launch$default(com.ss.android.lark.security.compliance.infra.base.a.f440424a, Dispatchers.getIO(), null, new InterceptionRestoreProber$start$1(r111, null), 2, null);
        return;
    L39:
        if (r100.length() == 0) goto L42;
        r106 = false;
    L42:
        if (r106 == true) goto L71;
        Object r113 = Result.m9449constructorimpl(NoPermissionType.valueOf(r108));     // Catch: Throwable -> L46
    L49:
        if (Result.m9452exceptionOrNullimpl(r113) == null) goto L52;
        int r114 = ScsLogger.f440428a;
        ScsLogger.c("SecurityPolicy_InterceptionPersistStore", "load: unknown NoPermissionType=" + r108 + ", clear corrupted entry");
        a.f418091a.getClass();
        a.a();
    L52:
        if (Result.m9455isFailureimpl(r113) == false) goto L54;
        r113 = null;
    L54:
        NoPermissionType r115 = (NoPermissionType) r113;
        if (r115 == null) goto L71;
        Gson r116 = e0.f444707a;     // Catch: Throwable -> L59
        Object r117 = Result.m9449constructorimpl((InternalSecurityAction) e0.a(r100, InternalSecurityAction.class));     // Catch: Throwable -> L59
    L61:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L65;
        int r119 = ScsLogger.f440428a;
        ScsLogger.c("SecurityPolicy_InterceptionPersistStore", "load: decode failed, clear corrupted entry, " + r118);
        a.f418091a.getClass();
        a.a();
    L65:
        if (Result.m9455isFailureimpl(r117) == false) goto L67;
        r117 = null;
    L67:
        InternalSecurityAction r120 = (InternalSecurityAction) r117;
        if (r120 == null) goto L71;
        int r121 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_InterceptionPersistStore", "load interception, type=" + r115.name() + ", traceId=" + r120.getTraceId());
        r111 = new c(r115, r120);
    L59:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L46:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L49
    L35:
        r110 = false;
        goto L37
    L21:
        r107 = false;
    L13:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L5:
        if (r101.isActive() == false) goto L81;
        ScsLogger.d("SecurityPolicy_InterceptionRestoreProber", "start: probe already running, skip");
    }
}
