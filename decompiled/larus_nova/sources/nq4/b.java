package nq4;

import com.alibaba.fastjson.JSONObject;
import kotlin.jvm.internal.Intrinsics;
import nq4.d;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T extends d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f520121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f520122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a<T> f520123c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f520121a, r101.f520121a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f520122b, r101.f520122b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520123c, r101.f520123c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f520121a.hashCode() * 31) + this.f520122b.hashCode()) * 31) + this.f520123c.hashCode();
    }

    public final String toString() {
        return "AsyncFetchRequest(funcName=" + this.f520121a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r100, JSONObject r101, a<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        Intrinsics.checkNotNullParameter(r101, "funcParams");
        Intrinsics.checkNotNullParameter(r102, "parser");
        this.f520121a = r100;
        this.f520122b = r101;
        this.f520123c = r102;
    }
}
