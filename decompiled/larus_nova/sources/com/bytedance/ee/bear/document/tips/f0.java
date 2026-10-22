package com.bytedance.ee.bear.document.tips;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f222088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f222089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f222090c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f222088a, ((f0) r100).f222088a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f222088a.hashCode();
    }

    public final String toString() {
        return "TipsItem(jsonObj=" + this.f222088a + ')';
    }

    public f0(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObj");
        this.f222088a = r100;
        this.f222089b = r100.optString("id");
        r100.optString("base64Image");
        this.f222090c = r100.optString("text");
    }
}
