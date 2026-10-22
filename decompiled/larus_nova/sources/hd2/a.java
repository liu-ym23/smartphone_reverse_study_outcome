package hd2;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f484583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f484584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JsonObject f484585c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f484583a, r101.f484583a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f484584b, r101.f484584b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f484585c, r101.f484585c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f484583a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f484584b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        JsonObject r107 = this.f484585c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicConcertGetStatus(bizId=" + this.f484583a + ", type=" + this.f484584b + ", extra=" + this.f484585c + ")";
    }

    public final String getType() {
        return this.f484584b;
    }

    public a(String r100, String r101, JsonObject r102) {
        Intrinsics.checkNotNullParameter(r100, "bizId");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f484583a = r100;
        this.f484584b = r101;
        this.f484585c = r102;
    }
}
