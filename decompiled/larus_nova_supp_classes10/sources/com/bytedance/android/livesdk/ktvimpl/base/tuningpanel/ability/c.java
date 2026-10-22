package com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability;

import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.ability.TuningEffectAbility;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c extends TuningEffectAbility {
    public c() {
    }

    public final void h(h r12) {
        Intrinsics.checkNotNullParameter(r12, "target");
        KtvContext.Companion.getClass();
        oe2.b r0 = (oe2.b) KtvContext.a.g().getKtvRoomProvider().getValue();
        if (r0 == null) goto L8;
        String r2 = r0.getEnterFrom();
        if (r2 == null) goto L8;
        String r8 = r2;
    L9:
        if (r0 == null) goto L14;
        String r3 = r0.c();
        if (r3 == null) goto L14;
        String r9 = r3;
    L15:
        if (r0 == null) goto L20;
        String r1 = r0.a();
        if (r1 == null) goto L20;
        String r10 = r1;
    L21:
        pb0.a r4 = pb0.b.a;
        String r5 = j.d();
        String r6 = j.a(null);
        String r7 = r12.d();
        String r11 = j.c();
        Intrinsics.checkNotNullParameter(r5, "liveType");
        Intrinsics.checkNotNullParameter(r6, "roomType");
        Intrinsics.checkNotNullParameter(r7, "effectName");
        Intrinsics.checkNotNullParameter(r11, "functionType");
        pb0.a r13 = pb0.b.a;
        if (r13 == null) goto L25;
        r13.q(r5, r6, r7, r11, r8, r9, r10);
        return;
    L25:
        return;
    L20:
        r10 = "";
    L14:
        r9 = "";
    L8:
        r8 = "";
        goto L9
    }
}
