package j3a;

import com.larus.voicecall.impl.ui.utils.NewThemeSwitchAvatar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f497150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NewThemeSwitchAvatar.AvatarType f497151b;

    public p() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f497150a == r101.f497150a) goto L12;
        return false;
    L12:
        if (this.f497151b == r101.f497151b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f497150a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f497151b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "RealtimeInterviewStatus(subtitleOpen=" + this.f497150a + ", showAvatarType=" + this.f497151b + ')';
    }

    public /* synthetic */ p(int r100) {
        this(false, NewThemeSwitchAvatar.AvatarType.BUBBLE);
    }

    public p(boolean r100, NewThemeSwitchAvatar.AvatarType r101) {
        Intrinsics.checkNotNullParameter(r101, "showAvatarType");
        this.f497150a = r100;
        this.f497151b = r101;
    }
}
