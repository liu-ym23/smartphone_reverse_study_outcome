package com.ss.android.lark.passport.assemble;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.passport.signinsdk_api.feature.listener.logout.LogoutReason;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<User> f437695a;

    public f(LogoutReason r100, List r101) {
        this.f437695a = r101;
    }

    public final void a() {
        PassportLog.d(PassportUserApi.TAG, "dispatch logout begin");
        Iterator r100 = CollectionsKt.toMutableList(PassportUserApi.access$getLogoutListeners$cp()).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((ozb.c) r100.next()).a();
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
