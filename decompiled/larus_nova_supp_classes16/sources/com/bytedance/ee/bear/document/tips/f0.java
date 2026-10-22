package com.bytedance.ee.bear.document.tips;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f0 {
    public final JSONObject a;
    public final String b;
    public final String c;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof f0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((f0) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "TipsItem(jsonObj=" + this.a + ')';
    }

    public f0(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "jsonObj");
        this.a = r2;
        this.b = r2.optString("id");
        r2.optString("base64Image");
        this.c = r2.optString("text");
    }
}
