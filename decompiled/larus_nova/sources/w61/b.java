package w61;

import com.bytedance.android.live.room.api.messagewindow.container.MsgWindowPosition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f558398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MsgWindowPosition f558399b;

    public final String toString() {
        return "MsgWindowIdentity(roomId=" + this.f558398a + ", position=" + this.f558399b + ")";
    }

    public b() {
        this("", MsgWindowPosition.BOTTOM_RIGHT);
    }

    public final int hashCode() {
        String r100 = this.f558398a;
        int r101 = 0;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        int r103 = this.f558399b.ordinal() * 31;
        String r104 = this.f558398a;
        if (r104 == null) goto L16;
        r101 = r104.hashCode();
    L16:
        return r103 + r101;
    L11:
        return this.f558399b.ordinal();
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(b.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        b r102 = (b) r100;
        if ((!Intrinsics.areEqual(this.f558398a, r102.f558398a)) == false) goto L17;
        return false;
    L17:
        if (this.f558399b == r102.f558399b) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.room.api.messagewindow.container.MsgWindowIdentity");
    L8:
        r101 = null;
        goto L10
    }

    public b(String r100, MsgWindowPosition r101) {
        Intrinsics.checkNotNullParameter(r101, "position");
        this.f558398a = r100;
        this.f558399b = r101;
    }
}
