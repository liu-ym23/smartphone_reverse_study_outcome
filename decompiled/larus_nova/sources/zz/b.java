package zz;

import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStateUpdateEvent;
import com.bytedance.android.live.broadcast.api.framework.common.LiveRoomStateUpdateIntent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveRoomStateUpdateIntent f574014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveRoomStateUpdateEvent f574015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f574016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f574017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f574018e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f574014a, r101.f574014a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f574015b, r101.f574015b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f574016c, r101.f574016c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f574017d, r101.f574017d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f574018e, r101.f574018e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        LiveRoomStateUpdateIntent r100 = this.f574014a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LiveRoomStateUpdateEvent r104 = this.f574015b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f574016c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f574017d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.f574018e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveRoomStateUpdateRequest(intent=" + this.f574014a + ", role=" + this.f574015b + ", source=" + this.f574016c + ", reason=" + this.f574017d + ", params=" + this.f574018e + ')';
    }

    public b(LiveRoomStateUpdateIntent r100, LiveRoomStateUpdateEvent r101, String r102, String r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        Intrinsics.checkNotNullParameter(r101, "role");
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r103, "reason");
        this.f574014a = r100;
        this.f574015b = r101;
        this.f574016c = r102;
        this.f574017d = r103;
        this.f574018e = r104;
    }
}
