package com.bytedance.ee.bear.tts.service;

import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import kotlin.jvm.internal.Intrinsics;
import mo5.e;
import mo5.f;
import mo5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends c0c.b implements e {
    public final /* synthetic */ e b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<e> d;

    public static final class a {
    }

    static {
    }

    @Override // mo5.e
    public final boolean N3(String r2) {
        Intrinsics.checkNotNullParameter(r2, "languageCode");
        return this.b.N3(r2);
    }

    @Override // mo5.e
    public final f V6(boolean r2) {
        return this.b.V6(r2);
    }

    @Override // mo5.e
    public final boolean Zb() {
        return this.b.Zb();
    }

    @Override // mo5.e
    public final g b2(String r8, int r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "objToken");
        return this.b.b2(r8, r9, r10, r11, r12);
    }

    @Override // mo5.e
    public final boolean canAutoPlay() {
        return this.b.canAutoPlay();
    }

    @Override // mo5.e
    public final boolean isEnable() {
        return this.b.isEnable();
    }

    @Override // mo5.e
    public final void onDestroy() {
        this.b.onDestroy();
    }

    @Override // mo5.e
    public final boolean z5() {
        return this.b.z5();
    }

    public final void lf(f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "toState");
        Intrinsics.checkNotNullParameter(r2, "toState");
        tt5.a.h("TtsServiceProxy", "destroy");
        ((e) this.d.c()).onDestroy();
    }

    public b(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<e> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), e.class), e.class);
        Intrinsics.checkNotNullParameter(r4, "passportService");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (e) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void qf(f0c.g r1, f0c.g r2) {
        v r3 = this.c;
        if (r2 == null) goto L6;
        UserSession r4 = r2.b;
        if (r4 == null) goto L6;
    L7:
        e r5 = (e) k.b(r3.c(r4), e.class);
        this.d.e(r5);
        return;
    L6:
        r4 = ContainerConstsKt.a();
        goto L7
    }
}
