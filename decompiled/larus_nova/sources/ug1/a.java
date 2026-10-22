package ug1;

import com.bytedance.android.livesdk.chatroom.end.vip.models.RestartLiveStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RestartLiveStatus f549982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f549983b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f549982a, r101.f549982a) == true) goto L8;
        return false;
    L8:
        if (this.f549983b == r101.f549983b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        RestartLiveStatus r100 = this.f549982a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f549983b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveStateInfo(status=" + this.f549982a + ", roomInfo=" + this.f549983b + ")";
    }

    public /* synthetic */ a(RestartLiveStatus r100) {
        this(r100, 0);
    }

    public a(RestartLiveStatus r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "status");
        this.f549982a = r100;
        this.f549983b = r101;
    }
}
