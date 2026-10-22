package l22;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.interactivity.api.asr.UserActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseUser f507110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f507111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UserActionType f507112c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f507110a, r101.f507110a) == true) goto L8;
        return false;
    L8:
        if (this.f507111b == r101.f507111b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f507112c, r101.f507112c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        IBaseUser r100 = this.f507110a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f507111b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        UserActionType r105 = this.f507112c;
        if (r105 == null) goto L10;
        r101 = r105.hashCode();
    L10:
        return r104 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "UserAction(user=" + this.f507110a + ", timestamp=" + this.f507111b + ", type=" + this.f507112c + ")";
    }

    public final UserActionType getType() {
        return this.f507112c;
    }

    public h(IBaseUser r100, long r101, UserActionType r102) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r102, "type");
        this.f507110a = r100;
        this.f507111b = r101;
        this.f507112c = r102;
    }
}
