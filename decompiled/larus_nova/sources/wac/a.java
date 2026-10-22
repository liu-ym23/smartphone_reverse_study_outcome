package wac;

import com.ss.android.lark.voiceinput.api.data.config.record.AudioChannel;
import com.ss.android.lark.voiceinput.api.data.config.record.AudioSource;
import com.ss.android.lark.voiceinput.api.data.config.record.PcmEncoding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f558911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioChannel f558912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PcmEncoding f558913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AudioSource f558914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f558915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f558916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f558917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f558918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f558919i;

    /* JADX INFO: renamed from: wac.a$a, reason: collision with other inner class name */
    public static final class C8087a {
    }

    static {
    }

    public a() {
        this(null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f558911a == r101.f558911a) goto L12;
        return false;
    L12:
        if (this.f558912b == r101.f558912b) goto L15;
        return false;
    L15:
        if (this.f558913c == r101.f558913c) goto L18;
        return false;
    L18:
        if (this.f558914d == r101.f558914d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f558915e, r101.f558915e) == true) goto L24;
        return false;
    L24:
        if (this.f558916f == r101.f558916f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f558917g, r101.f558917g) == true) goto L30;
        return false;
    L30:
        if (this.f558918h == r101.f558918h) goto L33;
        return false;
    L33:
        if (this.f558919i == r101.f558919i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(null, null) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f558911a * 31) + this.f558912b.hashCode()) * 31) + this.f558913c.hashCode()) * 31) + this.f558914d.hashCode()) * 31;
        Integer r101 = this.f558915e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f558916f) * 31) + this.f558917g.hashCode()) * 31;
        long r104 = this.f558918h;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f558919i;
        return ((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + 0;
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceRecordConfig(sampleRateHz=" + this.f558911a + ", channel=" + this.f558912b + ", pcmEncoding=" + this.f558913c + ", source=" + this.f558914d + ", bufferSizeInBytes=" + this.f558915e + ", bufferSizeScale=" + this.f558916f + ", psdaToken=" + this.f558917g + ", minDurationMs=" + this.f558918h + ", maxDurationMs=" + this.f558919i + ", storage=null)";
    }

    public a(String r110, int r210) {
        boolean r100 = false;
        if ((r210 & 1) == 0) goto L5;
        int r101 = 16000;
    L7:
        if ((r210 & 2) == 0) goto L9;
        AudioChannel r102 = AudioChannel.Mono;
    L11:
        if ((r210 & 4) == 0) goto L13;
        PcmEncoding r103 = PcmEncoding.Pcm16Bit;
    L15:
        if ((r210 & 8) == 0) goto L17;
        AudioSource r104 = AudioSource.Mic;
    L19:
        if ((r210 & 32) == 0) goto L21;
        int r105 = 1;
    L23:
        if ((r210 & 64) == 0) goto L25;
        String r111 = "";
    L27:
        if ((r210 & 128) == 0) goto L29;
        long r112 = 500;
    L31:
        if ((r210 & 256) == 0) goto L33;
        long r113 = 300000;
    L34:
        Intrinsics.checkNotNullParameter(r102, "channel");
        Intrinsics.checkNotNullParameter(r103, "pcmEncoding");
        Intrinsics.checkNotNullParameter(r104, "source");
        Intrinsics.checkNotNullParameter(r111, "psdaToken");
        this.f558911a = r101;
        this.f558912b = r102;
        this.f558913c = r103;
        this.f558914d = r104;
        this.f558915e = null;
        this.f558916f = r105;
        this.f558917g = r111;
        this.f558918h = r112;
        this.f558919i = r113;
        if (r101 <= 0) goto L37;
        boolean r106 = true;
    L38:
        if (r106 == false) goto L62;
        if (r112 < 0) goto L42;
        boolean r107 = true;
    L43:
        if (r107 == false) goto L60;
        if (r113 < 0) goto L47;
        boolean r108 = true;
    L48:
        if (r108 == false) goto L58;
        if (r113 != 0) goto L51;
    L52:
        r100 = true;
    L53:
        if (r100 == false) goto L56;
        return;
    L56:
        throw new IllegalArgumentException("maxDurationMs must be 0 or greater than or equal to minDurationMs".toString());
    L51:
        if (r113 < r112) goto L53;
    L58:
        throw new IllegalArgumentException("maxDurationMs must be greater than or equal to 0".toString());
    L47:
        r108 = false;
        goto L48
    L60:
        throw new IllegalArgumentException("minDurationMs must be greater than or equal to 0".toString());
    L42:
        r107 = false;
        goto L43
    L62:
        throw new IllegalArgumentException("sampleRateHz must be greater than 0".toString());
    L37:
        r106 = false;
        goto L38
    L33:
        r113 = 0;
        goto L34
    L29:
        r112 = 0;
        goto L31
    L25:
        r111 = r110;
        goto L27
    L21:
        r105 = 0;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = 0;
        goto L7
    }
}
