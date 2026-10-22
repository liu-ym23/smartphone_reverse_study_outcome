package com.bytedance.awemeopen.domain.user.login;

import android.app.Activity;
import com.bytedance.awemeopen.bizmodels.user.LoginMethod;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.awemeopen.bizmodels.user.f f198515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f198516b;

    public d(com.bytedance.awemeopen.bizmodels.user.f r100, c r101) {
        this.f198515a = r100;
        this.f198516b = r101;
    }

    @Override // com.bytedance.awemeopen.domain.user.login.e
    public final void a(LoginMethod r100, u64.b r101) {
        Intrinsics.checkNotNullParameter(r100, "loginMethod");
        Intrinsics.checkNotNullParameter(r101, "result");
        com.bytedance.awemeopen.bizmodels.user.f r102 = this.f198515a;
        Function4<Activity, LoginMethod, String, Map<String, String>, Unit> r103 = r102.f198228g;
        if (r103 == null) goto L5;
        Activity r104 = r102.getActivity();
        Intrinsics.checkNotNull(r104);
        com.bytedance.awemeopen.bizmodels.user.f r105 = this.f198515a;
        r103.invoke(r104, r100, r105.f198223b, r105.f198224c);
    L5:
        this.f198516b.getClass();
        c r106 = this.f198516b;
        com.bytedance.awemeopen.bizmodels.user.c r107 = com.bytedance.awemeopen.domain.user.b.a(r101);
        monitor-enter(r106);
        Iterator<com.bytedance.awemeopen.bizmodels.user.b> r108 = r106.f198514b.iterator();     // Catch: Throwable -> L16
    L9:
        if (r108.hasNext() == false) goto L13;
        com.bytedance.awemeopen.bizmodels.user.b r109 = r108.next();     // Catch: Throwable -> L16
        if (r109 == null) goto L9;
        r109.a(r107);     // Catch: Throwable -> L16
        goto L9
    L13:
        r106.f198514b.clear();     // Catch: Throwable -> L16
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r106);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.awemeopen.domain.user.login.e
    public final void b(LoginMethod r100, int r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "loginMethod");
        com.bytedance.awemeopen.bizmodels.user.f r101 = this.f198515a;
        Function6<Activity, LoginMethod, String, Map<String, String>, Integer, String, Unit> r102 = r101.f198229h;
        if (r102 == null) goto L5;
        Activity r103 = r101.getActivity();
        Intrinsics.checkNotNull(r103);
        com.bytedance.awemeopen.bizmodels.user.f r104 = this.f198515a;
        r102.invoke(r103, r100, r104.f198223b, r104.f198224c, Integer.valueOf(r110), r111);
    L5:
        this.f198516b.getClass();
        c r105 = this.f198516b;
        RuntimeException r112 = new RuntimeException(r111);
        monitor-enter(r105);
        Iterator<com.bytedance.awemeopen.bizmodels.user.b> r113 = r105.f198514b.iterator();     // Catch: Throwable -> L16
    L9:
        if (r113.hasNext() == false) goto L13;
        com.bytedance.awemeopen.bizmodels.user.b r106 = r113.next();     // Catch: Throwable -> L16
        if (r106 == null) goto L9;
        r106.onFail(r112);     // Catch: Throwable -> L16
        goto L9
    L13:
        r105.f198514b.clear();     // Catch: Throwable -> L16
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r105);
        return;
    L16:
        th = move-exception;
        throw th;
    }
}
