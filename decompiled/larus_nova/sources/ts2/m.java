package ts2;

import com.bytedance.android.livesdk.room.state.RoomDataType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f547355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomDataType f547356b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L10;
        m r101 = (m) r100;
        if (this.f547355a == r101.f547355a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f547356b, r101.f547356b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f547355a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        RoomDataType r103 = this.f547356b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "OnRoomUpdateData(isRoomVisible=" + this.f547355a + ", roomDataType=" + this.f547356b + ")";
    }

    public m(boolean r100, RoomDataType r101) {
        Intrinsics.checkNotNullParameter(r101, "roomDataType");
        this.f547355a = r100;
        this.f547356b = r101;
    }
}
