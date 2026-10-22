package com.obric.assistant.ipc;

import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.account.ObricXttTokenSyncServiceDelegate;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f389988a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f389989b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f389990c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile Job f389991d;

    public k() {
    }

    static {
        f389988a = new k();
        f389989b = new AtomicBoolean(false);
        f389990c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        ObricXttTokenSyncServiceDelegate.f392814a.a(null, null);     // Catch: Throwable -> L5
        FLogger.f375446a.i("ObricXttTokenSyncManager", "clearSnapshot reason=" + r100);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L13;
        FLogger.f375446a.e("ObricXttTokenSyncManager", "clearSnapshot failed reason=" + r100 + ": " + r103.getMessage(), r103);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "reason");
        AccountService r100 = AccountService.f365697a;
        if (r100.isLogin().booleanValue() == true) goto L32;
        a(r110 + ":not_login");
        return;
    L32:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L22
        String r102 = r100.getXTTToken();     // Catch: Throwable -> L22
        String r103 = r100.getUserId();     // Catch: Throwable -> L22
        boolean r104 = true;
        if (r102 != null) goto L9;
    L12:
        boolean r105 = true;
    L13:
        if (r105 == false) goto L16;
        FLogger.f375446a.w("ObricXttTokenSyncManager", "syncCurrentToken skipped: token empty reason=" + r110);     // Catch: Throwable -> L22
    L18:
        r104 = false;
    L20:
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(r104));     // Catch: Throwable -> L22
    L24:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L27;
        FLogger.f375446a.e("ObricXttTokenSyncManager", "syncCurrentToken failed reason=" + r110 + ": " + r107.getMessage(), r107);
    L27:
        Boolean r111 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r106) == false) goto L30;
        r106 = r111;
    L30:
        ((Boolean) r106).booleanValue();
        return;
    L16:
        if (StringsKt.isBlank(r103) == false) goto L19;
        FLogger.f375446a.w("ObricXttTokenSyncManager", "syncCurrentToken skipped: userId empty reason=" + r110);     // Catch: Throwable -> L22
        goto L18
    L19:
        ObricXttTokenSyncServiceDelegate.f392814a.a(r102, r103);     // Catch: Throwable -> L22
        BuildersKt.launch$default(f389990c, null, null, new ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1(r110, null), 3, null);     // Catch: Throwable -> L22
        FLogger.f375446a.i("ObricXttTokenSyncManager", "syncCurrentToken reason=" + r110 + " tokenLen=" + r102.length() + " userIdLen=" + r103.length());     // Catch: Throwable -> L22
        goto L20
    L9:
        if (StringsKt.isBlank(r102) == true) goto L12;
        r105 = false;
    L22:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }
}
