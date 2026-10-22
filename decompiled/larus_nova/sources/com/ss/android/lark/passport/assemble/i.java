package com.ss.android.lark.passport.assemble;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ User f437700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f437701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f437702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List<User> f437703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ List<User> f437704e;

    public i(User r100, boolean r101, List r102, List r103) {
        this.f437700a = r100;
        this.f437701b = r101;
        this.f437702c = true;
        this.f437703d = r102;
        this.f437704e = r103;
    }

    public final void a() {
        StringBuilder r100 = new StringBuilder("dispatch login, user: ");
        User r101 = this.f437700a;
        if (r101 == null) goto L5;
        String r102 = r101.userId;
    L6:
        r100.append(r102);
        r100.append(", fast:");
        r100.append(this.f437701b);
        PassportLog.d(PassportUserApi.TAG, r100.toString());
        nzb.a r103 = new nzb.a(this.f437702c, this.f437701b, this.f437703d, this.f437704e, this.f437700a);
        Iterator r104 = CollectionsKt.toMutableList(PassportUserApi.access$getLoginListeners$cp()).iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        ((nzb.b) r104.next()).a(r103);
        goto L8
    L10:
        return;
    L5:
        r102 = null;
        goto L6
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
