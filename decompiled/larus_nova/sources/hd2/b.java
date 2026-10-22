package hd2;

import com.bytedance.android.livesdk.ktvapi.concert_stage.models.DynamicConcertStatusChangeEventType;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DynamicConcertStatusChangeEventType f484586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JsonObject f484587b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f484586a, r101.f484586a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f484587b, r101.f484587b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        DynamicConcertStatusChangeEventType r100 = this.f484586a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        JsonObject r104 = this.f484587b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DynamicConcertStatusChangeEvent(eventType=" + this.f484586a + ", eventData=" + this.f484587b + ")";
    }

    public b(DynamicConcertStatusChangeEventType r100, JsonObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "eventData");
        this.f484586a = r100;
        this.f484587b = r101;
    }
}
