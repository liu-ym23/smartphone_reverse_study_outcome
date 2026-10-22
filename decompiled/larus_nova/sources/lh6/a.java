package lh6;

import com.bytedance.kmp.live.livelink.api.model.VideoShowMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public VideoShowMode f509261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VideoShowMode f509262b;

    public a() {
        this(0);
    }

    public final int hashCode() {
        VideoShowMode r100 = this.f509261a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        VideoShowMode r104 = this.f509262b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MutableVideoShowModeStatus(localStatus=" + this.f509261a + ", realStatus=" + this.f509262b + ")";
    }

    public a(int r100) {
        VideoShowMode r101 = VideoShowMode.AUDIO;
        Intrinsics.checkNotNullParameter(r101, "localStatus");
        Intrinsics.checkNotNullParameter(r101, "realStatus");
        this.f509261a = r101;
        this.f509262b = r101;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f509261a, r101.f509261a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f509262b, r101.f509262b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }
}
