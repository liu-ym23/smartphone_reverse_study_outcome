package k42;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f501746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f501747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f501748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f501749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f501750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f501751f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f501746a, r101.f501746a) == true) goto L8;
        return false;
    L8:
        if (this.f501747b == r101.f501747b) goto L10;
        return false;
    L10:
        if (this.f501748c == r101.f501748c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f501749d, r101.f501749d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f501750e, r101.f501750e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f501751f, r101.f501751f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f501746a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = this.f501747b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f501748c;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        String r107 = this.f501749d;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f501750e;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.f501751f;
        if (r113 == null) goto L18;
        r101 = r113.hashCode();
    L18:
        return r112 + r101;
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "VideoPinContent(scene=" + this.f501746a + ", itemId=" + this.f501747b + ", msgId=" + this.f501748c + ", nickname=" + this.f501749d + ", commenterId=" + this.f501750e + ", videoPinId=" + this.f501751f + ")";
    }

    public e(long r100, long r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter("video_highlight", "scene");
        Intrinsics.checkNotNullParameter(r102, InstantPlayContext.NICKNAME);
        Intrinsics.checkNotNullParameter(r103, "commenterId");
        this.f501746a = "video_highlight";
        this.f501747b = r100;
        this.f501748c = r101;
        this.f501749d = r102;
        this.f501750e = r103;
        this.f501751f = null;
    }
}
