package com.ss.android.lark.chat.service.impl;

import androidx.lifecycle.LiveData;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.entity.UserSession;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i1 extends c0c.b implements m6b.j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m6b.j f416513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.ss.android.lark.passportc.internal.v f416514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<m6b.j> f416515d;

    public static final class a {
    }

    static {
    }

    @Override // m6b.j
    public final LiveData<MessageTenantConfService.c> getConfig() {
        return this.f416513b.getConfig();
    }

    @Override // m6b.j
    public final void jd(boolean r100) {
        this.f416513b.jd(r100);
    }

    public i1(com.ss.android.lark.passportc.api.j r100, com.ss.android.lark.passportc.internal.v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<m6b.j> r103 = new com.ss.android.lark.passportc.convention.b(e0c.k.b(r101.c(r102), m6b.j.class), m6b.j.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f416513b = r103.b();
        this.f416514c = r101;
        this.f416515d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("MessageTenantConfServiceProxy", "preparing IMessageTenantConfService");
        com.ss.android.lark.passportc.internal.v r102 = this.f416514c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        m6b.j r104 = (m6b.j) e0c.k.b(r102.c(r103), m6b.j.class);
        this.f416515d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
