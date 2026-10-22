package r78;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f536468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f536469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f536470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f536471d;

    public final String toString() {
        return "FlowSamiBlock(dataType=" + this.f536468a + ", numberAudioData=" + this.f536469b + ", audioData=" + Arrays.toString(this.f536470c) + ", userContext=" + this.f536471d + ')';
    }

    public final int hashCode() {
        int r100 = ((((this.f536468a * 31) + this.f536469b) * 31) + Arrays.hashCode(this.f536470c)) * 31;
        Object r101 = this.f536471d;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.audio.sami.FlowSamiBlock");
        a r102 = (a) r100;
        if (this.f536468a == r102.f536468a) goto L16;
        return false;
    L16:
        if (this.f536469b == r102.f536469b) goto L19;
        return false;
    L19:
        if (Arrays.equals(this.f536470c, r102.f536470c) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f536471d, r102.f536471d) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public a(int r100, int r101, Object[] r102, Object r103) {
        Intrinsics.checkNotNullParameter(r102, "audioData");
        this.f536468a = r100;
        this.f536469b = r101;
        this.f536470c = r102;
        this.f536471d = r103;
    }
}
