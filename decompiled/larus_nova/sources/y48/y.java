package y48;

import com.larus.asr.config.ChatSpeakerStatus;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f566147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatSpeakerStatus f566148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f566149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f566150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f566151e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f566152f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f566153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Pair<Float, Float> f566154h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (this.f566147a == r101.f566147a) goto L12;
        return false;
    L12:
        if (this.f566148b == r101.f566148b) goto L15;
        return false;
    L15:
        if (this.f566149c == r101.f566149c) goto L18;
        return false;
    L18:
        if (this.f566150d == r101.f566150d) goto L21;
        return false;
    L21:
        if (this.f566151e == r101.f566151e) goto L24;
        return false;
    L24:
        if (this.f566152f == r101.f566152f) goto L27;
        return false;
    L27:
        if (this.f566153g == r101.f566153g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f566154h, r101.f566154h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f566147a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.f566148b.hashCode()) * 31;
        if (this.f566149c == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f566150d == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f566151e == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f566152f == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f566153g == true) goto L26;
        r100 = 1237;
    L26:
        int r111 = (r110 + r100) * 31;
        Pair<Float, Float> r112 = this.f566154h;
        if (r112 != null) goto L29;
        int r113 = 0;
    L31:
        return r111 + r113;
    L29:
        r113 = r112.hashCode();
        goto L31
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ChatSpeakerUiState(visible=" + this.f566147a + ", status=" + this.f566148b + ", isDarkMode=" + this.f566149c + ", isImmerseMode=" + this.f566150d + ", isBlurMode=" + this.f566151e + ", isCountingDown=" + this.f566152f + ", tipsDrivenByHost=" + this.f566153g + ", globalTouchPosition=" + this.f566154h + ')';
    }

    public y(boolean r100, ChatSpeakerStatus r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, Pair<Float, Float> r107) {
        Intrinsics.checkNotNullParameter(r101, "status");
        this.f566147a = r100;
        this.f566148b = r101;
        this.f566149c = r102;
        this.f566150d = r103;
        this.f566151e = r104;
        this.f566152f = r105;
        this.f566153g = r106;
        this.f566154h = r107;
    }
}
