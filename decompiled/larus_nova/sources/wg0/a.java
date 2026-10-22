package wg0;

import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f559531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EnlargeGuestInfo.EnlargeGuestType f559532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f559533c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f559531a == r101.f559531a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f559532b, r101.f559532b) == true) goto L10;
        return false;
    L10:
        if (this.f559533c == r101.f559533c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public final int hashCode() {
        boolean r100 = this.f559531a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        EnlargeGuestInfo.EnlargeGuestType r104 = this.f559532b;
        if (r104 == null) goto L8;
        int r105 = r104.hashCode();
    L9:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f559533c;
        if (r107 == true) goto L14;
        r101 = r107;
    L14:
        return r106 + r101;
    L8:
        r105 = 0;
        goto L9
    }

    public final String toString() {
        return "PlayModeStateItem(isCPositionOpen=" + this.f559531a + ", enlargeGuestType=" + this.f559532b + ", isInteractiveSongOpen=" + this.f559533c + ")";
    }

    public /* synthetic */ a(int r100) {
        this(false, EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown, false);
    }

    public a(boolean r100, EnlargeGuestInfo.EnlargeGuestType r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "enlargeGuestType");
        this.f559531a = r100;
        this.f559532b = r101;
        this.f559533c = r102;
    }

    public static a a(a r100, boolean r101, EnlargeGuestInfo.EnlargeGuestType r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f559531a;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.f559532b;
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = r100.f559533c;
    L11:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "enlargeGuestType");
        return new a(r101, r102, r103);
    }
}
