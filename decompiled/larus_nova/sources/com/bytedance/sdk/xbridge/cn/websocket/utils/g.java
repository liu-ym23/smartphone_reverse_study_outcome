package com.bytedance.sdk.xbridge.cn.websocket.utils;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f270282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f270283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONArray f270284c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f270282a, r101.f270282a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f270283b, r101.f270283b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f270284c, r101.f270284c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f270282a.hashCode() * 31;
        JSONObject r101 = this.f270283b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        JSONArray r105 = this.f270284c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RequestTask(url=" + this.f270282a + ", header=" + this.f270283b + ", protocols=" + this.f270284c + ')';
    }

    public g(String r100, JSONObject r101, JSONArray r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        this.f270282a = r100;
        this.f270283b = r101;
        this.f270284c = r102;
    }
}
