package ve9;

import com.ss.ttvideoengine.model.SubInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f554475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f554477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f554478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f554479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f554480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f554481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f554482h;

    public m() {
        this(false, "speech_opus", 80, 16000, 1, 32000, "", "");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f554475a == r101.f554475a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f554476b, r101.f554476b) == true) goto L15;
        return false;
    L15:
        if (this.f554477c == r101.f554477c) goto L18;
        return false;
    L18:
        if (this.f554478d == r101.f554478d) goto L21;
        return false;
    L21:
        if (this.f554479e == r101.f554479e) goto L24;
        return false;
    L24:
        if (this.f554480f == r101.f554480f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f554481g, r101.f554481g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f554482h, r101.f554482h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        if (this.f554475a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((((((((r100 * 31) + this.f554476b.hashCode()) * 31) + this.f554477c) * 31) + this.f554478d) * 31) + this.f554479e) * 31) + this.f554480f) * 31;
        String r102 = this.f554481g;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f554482h;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "SAMIWakeupConfig(enableWakeup=" + this.f554475a + ", format=" + this.f554476b + ", decoderLength=" + this.f554477c + ", sampleRate=" + this.f554478d + ", channel=" + this.f554479e + ", bitrate=" + this.f554480f + ", modelPath=" + this.f554481g + ", modelFileMd5=" + this.f554482h + ')';
    }

    public m(boolean r100, String r101, int r102, int r103, int r104, int r105, String r106, String r107) {
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        this.f554475a = r100;
        this.f554476b = r101;
        this.f554477c = r102;
        this.f554478d = r103;
        this.f554479e = r104;
        this.f554480f = r105;
        this.f554481g = r106;
        this.f554482h = r107;
    }
}
