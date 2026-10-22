package o22;

import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonObject f521779b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f521778a, r101.f521778a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f521779b, r101.f521779b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f521778a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JsonObject r104 = this.f521779b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShowCarnivalRedPacketEggEvent(schema=" + this.f521778a + ", eventParams=" + this.f521779b + ")";
    }

    public e(String r100, JsonObject r101) {
        this.f521778a = r100;
        this.f521779b = r101;
        System.currentTimeMillis();
    }
}
