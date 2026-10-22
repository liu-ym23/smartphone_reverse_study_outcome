package ec1;

import com.bytedance.android.live.user.api.permission.PermissionChangeType;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f471997c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveRoomPermission f471998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PermissionChangeType f471999b;

    /* JADX INFO: renamed from: ec1.a$a, reason: collision with other inner class name */
    public static final class C5765a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f471998a, r101.f471998a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f471999b, r101.f471999b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        LiveRoomPermission r100 = this.f471998a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        PermissionChangeType r104 = this.f471999b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PermissionChangeInfo(changePermission=" + this.f471998a.f105077a + ':' + this.f471998a.f105078b + ", changeType=" + this.f471999b.getType() + ')';
    }

    public a(LiveRoomPermission r100, PermissionChangeType r101) {
        Intrinsics.checkNotNullParameter(r100, "changePermission");
        Intrinsics.checkNotNullParameter(r101, "changeType");
        this.f471998a = r100;
        this.f471999b = r101;
    }
}
