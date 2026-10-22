package com.ss.android.lark.profile.core.di;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class c extends c0c.b implements com.ss.android.lark.profile.core.di.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.ss.android.lark.profile.core.di.a f438826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f438827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<com.ss.android.lark.profile.core.di.a> f438828d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.profile.core.di.a
    public final b38.b Q4() {
        return this.f438826b.Q4();
    }

    public c(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.ss.android.lark.profile.core.di.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), com.ss.android.lark.profile.core.di.a.class), com.ss.android.lark.profile.core.di.a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f438826b = r103.b();
        this.f438827c = r101;
        this.f438828d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        Log.i("ProfileNetClientGetterProxy", "preparing");
        v r102 = this.f438827c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        com.ss.android.lark.profile.core.di.a r104 = (com.ss.android.lark.profile.core.di.a) k.b(r102.c(r103), com.ss.android.lark.profile.core.di.a.class);
        this.f438828d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
