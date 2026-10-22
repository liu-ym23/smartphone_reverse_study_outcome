package com.bytedance.applog.priority.original;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f192719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f192720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f192721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f192722d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f192719a, r101.f192719a) == true) goto L12;
        return false;
    L12:
        if (this.f192720b == r101.f192720b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f192721c, r101.f192721c) == true) goto L18;
        return false;
    L18:
        if (this.f192722d == r101.f192722d) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r100 = this.f192719a.hashCode() * 31;
        boolean r101 = this.f192720b;
        ?? r102 = r101;
        if (r101 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = (r100 + r102) * 31;
        JSONObject r104 = this.f192721c;
        if (r104 != null) goto L8;
        int r105 = 0;
    L9:
        int r106 = (r103 + r105) * 31;
        long r107 = this.f192722d;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L8:
        r105 = r104.hashCode();
        goto L9
    }

    public final String toString() {
        return "AppSessionLaunch(sessionId=" + this.f192719a + ", isForeground=" + this.f192720b + ", extraParams=" + this.f192721c + ", timestamp=" + this.f192722d + ')';
    }

    public a(String r100, boolean r101, JSONObject r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        this.f192719a = r100;
        this.f192720b = r101;
        this.f192721c = r102;
        this.f192722d = r103;
    }
}
