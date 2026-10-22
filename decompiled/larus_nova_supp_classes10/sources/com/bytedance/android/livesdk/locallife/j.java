package com.bytedance.android.livesdk.locallife;

import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements d {
    public String a;
    public final boolean b;

    @Override // com.bytedance.android.livesdk.locallife.d
    public final void handle(Map<String, Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "lifeExtraInfoMap");
        if (this.b == false) goto L5;
        String r0 = "1";
    L6:
        r3.put("first_inner_item", r0);
        String r1 = this.a;
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L21;
        Object r4 = r3.get("initial_recommend_info");
        if ((r4 instanceof String) == true) goto L17;
        r4 = null;
    L17:
        String r5 = (String) r4;
        if (r5 != null) goto L20;
        r5 = "";
    L20:
        this.a = r5;
    L21:
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

    public j(String r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }
}
