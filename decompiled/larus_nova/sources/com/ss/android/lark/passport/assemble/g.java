package com.ss.android.lark.passport.assemble;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport.signinsdk_api.feature.listener.logout.LogoutReason;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LogoutReason f437696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List<User> f437697b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(LogoutReason r100, List<? extends User> r101) {
        this.f437696a = r100;
        this.f437697b = r101;
    }

    public final void a() {
        PassportLog.d(PassportUserApi.TAG, "dispatch logout success");
        LogoutReason r100 = this.f437696a;
        List<User> r101 = this.f437697b;
        ozb.a r102 = new ozb.a(r100, r101, r101);
        Iterator r103 = CollectionsKt.toMutableList(PassportUserApi.access$getLogoutListeners$cp()).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        ((ozb.c) r103.next()).b(r102);
        goto L4
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
