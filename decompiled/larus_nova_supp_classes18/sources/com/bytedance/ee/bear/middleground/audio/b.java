package com.bytedance.ee.bear.middleground.audio;

import android.app.Application;
import com.bytedance.ee.bear.middleground.audio.asrsdk.AsrSDK;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements h {
    public i a;

    @Override // com.bytedance.ee.bear.middleground.audio.h
    public final void a() {
        i r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.v();
    }

    @Override // com.bytedance.ee.bear.middleground.audio.h
    public final void c() {
        i r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.x();
    }

    @Override // com.bytedance.ee.bear.middleground.audio.h
    public final void stopRecord() {
        i r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.u();
    }

    public b() {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        Application r1 = com.larksuite.framework.utils.b.a;
        r0.getClass();
        UserSession r2 = ((com.ss.android.lark.passportc.convention.a) k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b();
        boolean r3 = ((dn4.a) k.b(((v) k.a(r1, v.class)).c(r2), dn4.a.class)).a().isCurrentEnable("ccm.mobile.audio_input_optimize");
        if (this.a != null) goto L10;
        if (r3 == false) goto L7;
        this.a = g.a;
        return;
    L7:
        this.a = AsrSDK.a;
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.audio.h
    public final void b(String r2, Function3 r3) {
        i r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.w();
        this.a.y(r2, r3);
    }
}
