package com.bytedance.applog.priority.original;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f192727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f192728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONArray f192729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f192730d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f192727a, r101.f192727a) == true) goto L12;
        return false;
    L12:
        if (this.f192728b == r101.f192728b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f192729c, r101.f192729c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f192730d, r101.f192730d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f192727a.hashCode() * 31;
        long r101 = this.f192728b;
        return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f192729c.hashCode()) * 31) + this.f192730d.hashCode();
    }

    public final String toString() {
        return "AppSessionTerminate(sessionId=" + this.f192727a + ", duration=" + this.f192728b + ", pageNames=" + this.f192729c + ", extraParams=" + this.f192730d + ')';
    }

    public c(String r100, JSONArray r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "pageNames");
        Intrinsics.checkNotNullParameter(r102, "extraParams");
        this.f192727a = r100;
        this.f192728b = 0;
        this.f192729c = r101;
        this.f192730d = r102;
    }
}
