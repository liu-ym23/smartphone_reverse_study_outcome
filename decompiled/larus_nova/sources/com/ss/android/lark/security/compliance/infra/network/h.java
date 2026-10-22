package com.ss.android.lark.security.compliance.infra.network;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f440445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f440446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonObject f440447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public T f440448d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (this.f440445a == r101.f440445a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f440446b, r101.f440446b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f440447c, r101.f440447c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f440445a * 31) + this.f440446b.hashCode()) * 31) + this.f440447c.hashCode();
    }

    public final String toString() {
        return "ResponseModel(code=" + this.f440445a + ", message=" + this.f440446b + ", originData=" + this.f440447c + ')';
    }

    public h(int r100, String r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "originData");
        this.f440445a = r100;
        this.f440446b = r101;
        this.f440447c = r102;
    }
}
