package p78;

import com.larus.audio.quality.AudioCheckerResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioCheckerResult f528048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f528049b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f528048a == r101.f528048a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f528049b, r101.f528049b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        AudioCheckerResult r100 = this.f528048a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f528049b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CheckAudioQualityResult(result=" + this.f528048a + ", returnValue=" + this.f528049b + ')';
    }

    public b(AudioCheckerResult r100, Integer r101) {
        this.f528048a = r100;
        this.f528049b = r101;
    }
}
