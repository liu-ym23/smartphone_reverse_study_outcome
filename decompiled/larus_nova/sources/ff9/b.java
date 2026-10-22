package ff9;

import com.larus.im.internal.rtcsdk.service.AudioEncodeType;
import com.larus.im.service.audio.AvAecOutputType;
import com.larus.im.service.audio.AvAecType;
import com.ss.bytertc.engine.data.AudioSourceType;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioSourceType f476672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f476673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f476674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f476675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AudioEncodeType f476676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final he9.a f476677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.larus.im.service.audio.t f476678g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AvAecType f476679h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f476680i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AvAecOutputType f476681j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f476682k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f476672a == r101.f476672a) goto L12;
        return false;
    L12:
        if (this.f476673b == r101.f476673b) goto L15;
        return false;
    L15:
        if (this.f476674c == r101.f476674c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f476675d, r101.f476675d) == true) goto L21;
        return false;
    L21:
        if (this.f476676e == r101.f476676e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f476677f, r101.f476677f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f476678g, r101.f476678g) == true) goto L30;
        return false;
    L30:
        if (this.f476679h == r101.f476679h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f476680i, r101.f476680i) == true) goto L36;
        return false;
    L36:
        if (this.f476681j == r101.f476681j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f476682k, r101.f476682k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f476672a.hashCode() * 31) + this.f476673b) * 31) + this.f476674c) * 31;
        Integer r101 = this.f476675d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f476676e.hashCode()) * 31;
        he9.a r105 = this.f476677f;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        com.larus.im.service.audio.t r108 = this.f476678g;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return ((((((((r107 + r102) * 31) + this.f476679h.hashCode()) * 31) + this.f476680i.hashCode()) * 31) + this.f476681j.hashCode()) * 31) + this.f476682k.hashCode();
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AudioCaptureConfig(sourceType=" + this.f476672a + ", sampleRate=" + this.f476673b + ", channel=" + this.f476674c + ", audioSource=" + this.f476675d + ", encodeType=" + this.f476676e + ", transformer=" + this.f476677f + ", preProcessor=" + this.f476678g + ", aecType=" + this.f476679h + ", speechAecModelPath=" + this.f476680i + ", speechAecOutputType=" + this.f476681j + ", speechAecDumpPath=" + this.f476682k + ')';
    }

    public b(AudioSourceType r100, int r101, int r102, Integer r103, AudioEncodeType r104, he9.a r105, com.larus.im.service.audio.t r106, AvAecType r110, String r111, AvAecOutputType r112, String r113, int r114) {
        if ((r114 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r114 & 16) == 0) goto L9;
        r104 = AudioEncodeType.PCM_16;
    L9:
        if ((r114 & 32) == 0) goto L12;
        r105 = null;
    L12:
        if ((r114 & 64) == 0) goto L15;
        r106 = null;
    L15:
        if ((r114 & 128) == 0) goto L18;
        r110 = AvAecType.NONE;
    L18:
        if ((r114 & 256) == 0) goto L21;
        r111 = "";
    L21:
        if ((r114 & 512) == 0) goto L24;
        r112 = AvAecOutputType.AecMono;
    L24:
        if ((r114 & 1024) == 0) goto L26;
        r113 = "";
    L26:
        Intrinsics.checkNotNullParameter(r100, "sourceType");
        Intrinsics.checkNotNullParameter(r104, "encodeType");
        Intrinsics.checkNotNullParameter(r110, "aecType");
        Intrinsics.checkNotNullParameter(r111, "speechAecModelPath");
        Intrinsics.checkNotNullParameter(r112, "speechAecOutputType");
        Intrinsics.checkNotNullParameter(r113, "speechAecDumpPath");
        this.f476672a = r100;
        this.f476673b = r101;
        this.f476674c = r102;
        this.f476675d = r103;
        this.f476676e = r104;
        this.f476677f = r105;
        this.f476678g = r106;
        this.f476679h = r110;
        this.f476680i = r111;
        this.f476681j = r112;
        this.f476682k = r113;
        Function0 r107 = new a(this);
        Intrinsics.checkNotNullParameter("speechAecOutputType is AecStereo or MicAndAec, channel must be 2", "msg");
        Intrinsics.checkNotNullParameter(r107, "assertBlock");
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L29;
        return;
    L29:
        if (((Boolean) r107.invoke()).booleanValue() == false) goto L32;
        return;
    L32:
        throw new IllegalStateException("speechAecOutputType is AecStereo or MicAndAec, channel must be 2");
    }
}
