package ff9;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f476694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f476695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f476696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f476697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f476698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f476699f;

    public final String toString() {
        return "FlowRTCEncodedAudioFrame(buffer=" + Arrays.toString(this.f476694a) + ", channel=" + this.f476695b + ", sampleRate=" + this.f476696c + ", extra=" + Arrays.toString(this.f476697d) + ", timestamp=" + this.f476698e + ", frameSizeMs=" + this.f476699f + ')';
    }

    public final int hashCode() {
        int r100 = ((((Arrays.hashCode(this.f476694a) * 31) + this.f476695b) * 31) + this.f476696c) * 31;
        byte[] r101 = this.f476697d;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = Arrays.hashCode(r101);
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f476698e;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return ((r104 + r102) * 31) + this.f476699f;
    L5:
        r103 = 0;
        goto L6
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(h.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.im.internal.rtcsdk.service.FlowRTCEncodedAudioFrame");
        h r102 = (h) r100;
        if (Arrays.equals(this.f476694a, r102.f476694a) == true) goto L16;
        return false;
    L16:
        if (this.f476695b == r102.f476695b) goto L19;
        return false;
    L19:
        if (this.f476696c == r102.f476696c) goto L21;
        return false;
    L21:
        byte[] r103 = this.f476697d;
        if (r103 == null) goto L30;
        byte[] r104 = r102.f476697d;
        if (r104 != null) goto L27;
        return false;
    L27:
        if (Arrays.equals(r103, r104) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f476698e, r102.f476698e) == true) goto L36;
        return false;
    L36:
        if (this.f476699f == r102.f476699f) goto L38;
        return false;
    L38:
        return true;
    L30:
        if (r102.f476697d == null) goto L33;
        return false;
    L8:
        r101 = null;
        goto L10
    }

    public h(byte[] r100, int r101, int r102, byte[] r103, Long r104, int r105) {
        Intrinsics.checkNotNullParameter(r100, "buffer");
        this.f476694a = r100;
        this.f476695b = r101;
        this.f476696c = r102;
        this.f476697d = r103;
        this.f476698e = r104;
        this.f476699f = r105;
    }
}
