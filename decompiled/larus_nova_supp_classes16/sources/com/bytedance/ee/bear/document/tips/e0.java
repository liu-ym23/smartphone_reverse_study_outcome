package com.bytedance.ee.bear.document.tips;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e0 {
    public final String a;
    public final List<f0> b;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof e0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((e0) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "TipsData(data=" + this.a + ')';
    }

    public e0(String r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        this.a = r5;
        JSONArray r6 = new JSONObject(r5).optJSONArray("items");
        this.b = new ArrayList();
        int r0 = r6.length() - 1;
        if (r0 < 0) goto L8;
        int r1 = 0;
    L5:
        ((ArrayList) this.b).add(new f0(JSONArrayProtectorUtils.getJSONObject(r6, r1)));
        if (r1 == r0) goto L10;
        r1 = r1 + 1;
        goto L5
    L10:
        return;
    }
}
