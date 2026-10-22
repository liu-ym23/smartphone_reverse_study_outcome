package i3;

import com.google.gson.JsonObject;
import e3.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f488076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonObject f488077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f488078c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f488076a, r101.f488076a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f488077b, r101.f488077b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f488078c, r101.f488078c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f488076a.hashCode() * 31;
        JsonObject r101 = this.f488077b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f488078c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "BridgeCallInfo(methodName=" + this.f488076a + ", params=" + this.f488077b + ", bridgeContext=" + this.f488078c + ')';
    }

    public a(String r100, JsonObject r101, e3.a r102) {
        Intrinsics.checkNotNullParameter(r100, "methodName");
        Intrinsics.checkNotNullParameter(r102, "bridgeContext");
        this.f488076a = r100;
        this.f488077b = r101;
        this.f488078c = r102;
    }
}
