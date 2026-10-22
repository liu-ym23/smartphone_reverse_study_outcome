package com.bytedance.awemeopen.domain.user;

import com.bytedance.awemeopen.bizmodels.user.j;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f198488a;

    public e(c r100) {
        this.f198488a = r100;
    }

    @Override // com.bytedance.awemeopen.bizmodels.user.j
    public final void a(com.bytedance.awemeopen.bizmodels.user.i r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        c r101 = this.f198488a;
        monitor-enter(r101);
        Iterator<j> r102 = r101.f198486c.iterator();     // Catch: Throwable -> L14
    L6:
        if (r102.hasNext() == false) goto L10;
        j r103 = r102.next();     // Catch: Throwable -> L14
        if (r103 == null) goto L6;
        r103.a(r100);     // Catch: Throwable -> L14
        goto L6
    L10:
        r101.f198486c.clear();     // Catch: Throwable -> L14
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r101);
        this.f198488a.f198485b = false;
        int r105 = c.f198483d;
        AoLogger.g("RefreshUserInfoProcessHelper", new Object[]{"refresh(),dispatchAutoLoginCallbacksSuccessAndClear()"});
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.awemeopen.bizmodels.user.j
    public final void onFail(Exception r100) {
        c r101 = this.f198488a;
        monitor-enter(r101);
        Iterator<j> r102 = r101.f198486c.iterator();     // Catch: Throwable -> L14
    L6:
        if (r102.hasNext() == false) goto L10;
        j r103 = r102.next();     // Catch: Throwable -> L14
        if (r103 == null) goto L6;
        r103.onFail(r100);     // Catch: Throwable -> L14
        goto L6
    L10:
        r101.f198486c.clear();     // Catch: Throwable -> L14
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r101);
        this.f198488a.f198485b = false;
        int r105 = c.f198483d;
        AoLogger.g("RefreshUserInfoProcessHelper", new Object[]{"refresh(),dispatchAutoLoginCallbacksFailAndClear()"});
        return;
    L14:
        th = move-exception;
        throw th;
    }
}
