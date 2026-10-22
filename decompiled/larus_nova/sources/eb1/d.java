package eb1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Leb1/d;", "", "", "songScore", "D", "getSongScore", "()D", "setSongScore", "(D)V", "userPitch", "getUserPitch", "setUserPitch", "userNote", "getUserNote", "userCent", "getUserCent", "userOctave", "getUserOctave", "refPitch", "getRefPitch", "refNote", "getRefNote", "refCent", "getRefCent", "sentenceIndex", "b", "setSentenceIndex", "", "progress", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setProgress", "(J)V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f471792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f471793b;

    @SerializedName("time")
    private long progress;

    @SerializedName("ref_cent")
    private final double refCent;

    @SerializedName("ref_note")
    private final double refNote;

    @SerializedName("ref_pitch")
    private final double refPitch;

    @SerializedName("sentence_index")
    private double sentenceIndex;

    @SerializedName("song_score")
    private double songScore;

    @SerializedName("user_cent")
    private final double userCent;

    @SerializedName("user_note")
    private final double userNote;

    @SerializedName("user_octave")
    private final double userOctave;

    @SerializedName("user_pitch")
    private double userPitch;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L30;
        d r101 = (d) r100;
        if (Double.compare(this.f471792a, r101.f471792a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.songScore, r101.songScore) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.userPitch, r101.userPitch) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.userNote, r101.userNote) == 0) goto L14;
        return false;
    L14:
        if (Double.compare(this.userCent, r101.userCent) == 0) goto L16;
        return false;
    L16:
        if (Double.compare(this.userOctave, r101.userOctave) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.refPitch, r101.refPitch) == 0) goto L20;
        return false;
    L20:
        if (Double.compare(this.refNote, r101.refNote) == 0) goto L22;
        return false;
    L22:
        if (Double.compare(this.refCent, r101.refCent) == 0) goto L24;
        return false;
    L24:
        if (Double.compare(this.sentenceIndex, r101.sentenceIndex) == 0) goto L26;
        return false;
    L26:
        if (Double.compare(this.f471793b, r101.f471793b) == 0) goto L28;
        return false;
    L28:
        if (this.progress == r101.progress) goto L46;
        return false;
    L46:
        return true;
    L30:
        return false;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f471792a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.songScore);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = Double.doubleToLongBits(this.userPitch);
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = Double.doubleToLongBits(this.userNote);
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = Double.doubleToLongBits(this.userCent);
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = Double.doubleToLongBits(this.userOctave);
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = Double.doubleToLongBits(this.refPitch);
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = Double.doubleToLongBits(this.refNote);
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = Double.doubleToLongBits(this.refCent);
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = Double.doubleToLongBits(this.sentenceIndex);
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = Double.doubleToLongBits(this.f471793b);
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = this.progress;
        return r121 + ((int) (r122 ^ (r122 >>> 32)));
    }

    public final String toString() {
        return "MidiRecordItemModel(sentenceScore=" + this.f471792a + ", songScore=" + this.songScore + ", userPitch=" + this.userPitch + ", userNote=" + this.userNote + ", userCent=" + this.userCent + ", userOctave=" + this.userOctave + ", refPitch=" + this.refPitch + ", refNote=" + this.refNote + ", refCent=" + this.refCent + ", sentenceIndex=" + this.sentenceIndex + ", timeMilliseconds=" + this.f471793b + ", progress=" + this.progress + ")";
    }

    public d() {
        this(-1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, -1.0d, 0);
    }

    public final long a() {
        return this.progress;
    }

    public final double b() {
        return this.sentenceIndex;
    }

    public d(double r100, double r101, double r102, double r110, double r111, double r112, double r113, double r114, double r210, double r211, double r212, long r213) {
        this.f471792a = r100;
        this.songScore = r101;
        this.userPitch = r102;
        this.userNote = r110;
        this.userCent = r111;
        this.userOctave = r112;
        this.refPitch = r113;
        this.refNote = r114;
        this.refCent = r210;
        this.sentenceIndex = r211;
        this.f471793b = r212;
        this.progress = r213;
    }
}
