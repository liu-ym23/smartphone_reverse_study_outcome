package et0;

import com.bytedance.android.live.base.model.user.HonorWallElement;
import com.bytedance.android.live.base.model.user.ProfileFansClub;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f473862g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f473863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f473864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProfileFansClub f473865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f473866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f473867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f473868f;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (this.f473863a == r101.f473863a) goto L8;
        return false;
    L8:
        if (this.f473864b == r101.f473864b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f473865c, r101.f473865c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f473866d, r101.f473866d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f473867e, r101.f473867e) == true) goto L16;
        return false;
    L16:
        if (this.f473868f == r101.f473868f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        int r100 = this.f473863a * 31;
        boolean r101 = this.f473864b;
        ?? r102 = 1;
        ?? r103 = r101;
        if (r101 == false) goto L5;
        r103 = 1;
    L5:
        int r104 = (r100 + r103) * 31;
        ProfileFansClub r105 = this.f473865c;
        int r106 = 0;
        if (r105 == null) goto L8;
        int r107 = r105.hashCode();
    L9:
        int r108 = (r104 + r107) * 31;
        String r109 = this.f473866d;
        if (r109 == null) goto L12;
        int r110 = r109.hashCode();
    L13:
        int r111 = (r108 + r110) * 31;
        k r112 = this.f473867e;
        if (r112 == null) goto L16;
        r106 = r112.hashCode();
    L16:
        int r113 = (r111 + r106) * 31;
        boolean r114 = this.f473868f;
        if (r114 == true) goto L21;
        r102 = r114;
    L21:
        return r113 + r102;
    L12:
        r110 = 0;
        goto L13
    L8:
        r107 = 0;
        goto L9
    }

    public final String toString() {
        return "FansClubData(type=" + this.f473863a + ", showFansCount=" + this.f473864b + ", fansClubInfo=" + this.f473865c + ", clubName=" + this.f473866d + ", fansClubIcon=" + this.f473867e + ", isSubscriber=" + this.f473868f + ")";
    }

    static {
        f473862g = new a();
    }

    public c() {
        this(HonorWallElement.TYPE_UNKNOWN, false, null, null, null, false);
    }

    public final int getType() {
        return this.f473863a;
    }

    public c(int r100, boolean r101, ProfileFansClub r102, String r103, k r104, boolean r105) {
        this.f473863a = r100;
        this.f473864b = r101;
        this.f473865c = r102;
        this.f473866d = r103;
        this.f473867e = r104;
        this.f473868f = r105;
    }
}
