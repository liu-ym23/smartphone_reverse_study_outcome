package ts2;

import com.bytedance.android.livesdk.room.state.RoomDataType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f547348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomDataType f547349b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f547348a, r101.f547348a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f547349b, r101.f547349b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.f547348a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        RoomDataType r104 = this.f547349b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OnEnterRoomData(isOfficialChannel=" + this.f547348a + ", dataType=" + this.f547349b + ")";
    }

    public i(Boolean r100, RoomDataType r101) {
        Intrinsics.checkNotNullParameter(r101, "dataType");
        this.f547348a = r100;
        this.f547349b = r101;
    }
}
