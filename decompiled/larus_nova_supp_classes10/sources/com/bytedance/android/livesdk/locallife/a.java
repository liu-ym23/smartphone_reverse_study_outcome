package com.bytedance.android.livesdk.locallife;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements c {
    public final String a;
    public final String b;

    @Override // com.bytedance.android.livesdk.locallife.c
    public final void a(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "lifeExtraInfoJson");
        if (TextUtils.isEmpty(this.a) == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(this.a, "homepage_life") == false) goto L7;
    L8:
        String r0 = u.l().c(x.class).getMap().get("pos");
        int r1 = 1;
        if (r0 == null) goto L11;
        r1 = 1 + CastIntegerProtector.parseInt(r0);
    L11:
        r3.put("inner_card_order", String.valueOf(r1));
        r3.put("action_type", this.b);
        return;
    L7:
        if (Intrinsics.areEqual(this.a, "life_dual_idpt") == true) goto L8;
    }

    public a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "actionType");
        this.a = r2;
        this.b = r3;
    }
}
