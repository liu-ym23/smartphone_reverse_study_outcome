package com.bytedance.android.livesdk.locallife;

import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements c {
    public final boolean a;
    public final boolean b;

    @Override // com.bytedance.android.livesdk.locallife.c
    public final void a(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "lifeExtraInfoJson");
        if (this.a == true) goto L5;
    L7:
        String r0 = BDLocationException.ERROR_TIMEOUT;
    L8:
        r3.put("life_is_ad", r0);
        return;
    L5:
        if (this.b == false) goto L7;
        r0 = "1";
        goto L8
    }

    public e(boolean r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
