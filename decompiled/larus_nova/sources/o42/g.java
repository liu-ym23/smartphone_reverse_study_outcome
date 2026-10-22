package o42;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseUser f521953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f521954b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f521953a, r101.f521953a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f521954b, r101.f521954b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        IBaseUser r100 = this.f521953a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f521954b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InviteLinkPublicScreenEvent(user=" + this.f521953a + ", source=" + this.f521954b + ")";
    }

    public g(User r100) {
        Intrinsics.checkNotNullParameter("public_screen_area", "source");
        this.f521953a = r100;
        this.f521954b = "public_screen_area";
    }
}
