package com.bytedance.android.livesdk.locallife;

import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements c {
    public String a;
    public final boolean b;

    @Override // com.bytedance.android.livesdk.locallife.c
    public final void a(JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "lifeExtraInfoJson");
        if (this.b == false) goto L5;
        String r0 = "1";
    L6:
        r3.put("first_inner_item", r0);
        String r1 = this.a;
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L15;
        this.a = r3.optString("initial_recommend_info", "");
    L15:
        r3.put("recommend_info", this.a);
        return;
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
        goto L13
    L5:
        r0 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public i(String r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
