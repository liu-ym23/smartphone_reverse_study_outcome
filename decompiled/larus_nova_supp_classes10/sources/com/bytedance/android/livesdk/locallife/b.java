package com.bytedance.android.livesdk.locallife;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements d {
    public final String a;
    public final String b;

    @Override // com.bytedance.android.livesdk.locallife.d
    public final void handle(Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "lifeExtraInfoMap");
        if (TextUtils.isEmpty(this.a) == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual("homepage_life", this.a) == false) goto L7;
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
        if (Intrinsics.areEqual("life_dual_idpt", this.a) == true) goto L8;
    }

    public b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "actionType");
        this.a = r2;
        this.b = r3;
    }
}
