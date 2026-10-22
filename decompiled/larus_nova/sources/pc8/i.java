package pc8;

import com.larus.bmhome.chat.bubble.floating.BubbleBannerTransitionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f528598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BubbleBannerTransitionType f528599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f528600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f528601d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f528598a, r101.f528598a) == true) goto L12;
        return false;
    L12:
        if (this.f528599b == r101.f528599b) goto L15;
        return false;
    L15:
        if (this.f528600c == r101.f528600c) goto L18;
        return false;
    L18:
        if (this.f528601d == r101.f528601d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f528598a.hashCode() * 31) + this.f528599b.hashCode()) * 31;
        long r101 = this.f528600c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f528601d;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "BubbleBannerTransition(id=" + this.f528598a + ", type=" + this.f528599b + ", startedAtMs=" + this.f528600c + ", durationMs=" + this.f528601d + ')';
    }

    public final BubbleBannerTransitionType getType() {
        return this.f528599b;
    }

    public i(String r100, BubbleBannerTransitionType r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f528598a = r100;
        this.f528599b = r101;
        this.f528600c = r102;
        this.f528601d = 500;
    }
}
