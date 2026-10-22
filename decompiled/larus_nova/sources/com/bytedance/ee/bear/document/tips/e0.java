package com.bytedance.ee.bear.document.tips;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f222086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f0> f222087b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f222086a, ((e0) r100).f222086a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f222086a.hashCode();
    }

    public final String toString() {
        return "TipsData(data=" + this.f222086a + ')';
    }

    public e0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f222086a = r100;
        JSONArray r101 = new JSONObject(r100).optJSONArray("items");
        this.f222087b = new ArrayList();
        int r102 = r101.length() - 1;
        if (r102 < 0) goto L8;
        int r103 = 0;
    L5:
        ((ArrayList) this.f222087b).add(new f0(JSONArrayProtectorUtils.getJSONObject(r101, r103)));
        if (r103 == r102) goto L10;
        r103 = r103 + 1;
        goto L5
    L10:
        return;
    }
}
