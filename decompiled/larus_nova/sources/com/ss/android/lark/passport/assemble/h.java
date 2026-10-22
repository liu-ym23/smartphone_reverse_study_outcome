package com.ss.android.lark.passport.assemble;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.signinsdk_api.account.User;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ User f437698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ User f437699b;

    public h(User r100, User r101) {
        this.f437698a = r100;
        this.f437699b = r101;
    }

    public final void a() {
        StringBuilder r100 = new StringBuilder("dispatchUserListChanged:");
        User r101 = this.f437698a;
        List<? extends User> r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.userId;
    L6:
        r100.append(r103);
        r100.append(", new:");
        User r104 = this.f437699b;
        if (r104 == null) goto L9;
        String r105 = r104.userId;
    L10:
        r100.append(r105);
        PassportLog.d(PassportUserApi.TAG, r100.toString());
        List<? extends User> r106 = CollectionsKt.listOfNotNull(this.f437699b);
        User r107 = this.f437698a;
        if (r107 == null) goto L19;
        String r108 = r107.userId;
        User r109 = this.f437699b;
        if (r109 == null) goto L15;
        String r110 = r109.userId;
    L17:
        if (Intrinsics.areEqual(r108, r110) == true) goto L19;
        PassportLog.d(PassportUserApi.TAG, "remove");
        r102 = CollectionsKt.listOf(this.f437698a);
        goto L19
    L15:
        r110 = null;
    L19:
        Iterator r111 = CollectionsKt.toMutableList(PassportUserApi.access$getUserListChangeListeners$cp()).iterator();
    L21:
        if (r111.hasNext() == false) goto L25;
        mzb.a r112 = (mzb.a) r111.next();
        r112.p0(r106);
        if (r102 == null) goto L21;
        r112.l0(r102);
        goto L21
    L25:
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
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
