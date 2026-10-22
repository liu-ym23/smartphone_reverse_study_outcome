package fn6;

import androidx.camera.video.AudioStats;
import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006¨\u0006 "}, d2 = {"Lfn6/c;", "", "", "useBtmCoverInterceptor", "Z", "d", "()Z", "useBtmValidInterceptor", "e", "", "coverSampleRatio", "D", "b", "()D", "validSampleRatio", "h", "", "", "skipCoverIntercept", "Ljava/util/List;", "c", "()Ljava/util/List;", "", "Lfn6/d;", "validConfig", "Ljava/util/Map;", ce.f26391f, "()Ljava/util/Map;", "appendBtmEventConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "useExpoundCardIdInterceptor", "f", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("append_btm_event_config")
    private final List<String> appendBtmEventConfig;

    @SerializedName("cover_sample_ratio")
    private final double coverSampleRatio;

    @SerializedName("skip_cover_intercept")
    private final List<String> skipCoverIntercept;

    @SerializedName("use_btm_cover_interceptor")
    private final boolean useBtmCoverInterceptor;

    @SerializedName("use_btm_valid_interceptor")
    private final boolean useBtmValidInterceptor;

    @SerializedName("use_expound_card_id_interceptor")
    private final boolean useExpoundCardIdInterceptor;

    @SerializedName("valid_config")
    private final Map<String, d> validConfig;

    @SerializedName("valid_sample_ratio")
    private final double validSampleRatio;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.useBtmCoverInterceptor == r101.useBtmCoverInterceptor) goto L12;
        return false;
    L12:
        if (this.useBtmValidInterceptor == r101.useBtmValidInterceptor) goto L15;
        return false;
    L15:
        if (Double.compare(this.coverSampleRatio, r101.coverSampleRatio) == 0) goto L18;
        return false;
    L18:
        if (Double.compare(this.validSampleRatio, r101.validSampleRatio) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.skipCoverIntercept, r101.skipCoverIntercept) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.validConfig, r101.validConfig) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.appendBtmEventConfig, r101.appendBtmEventConfig) == true) goto L30;
        return false;
    L30:
        if (this.useExpoundCardIdInterceptor == r101.useExpoundCardIdInterceptor) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.useBtmCoverInterceptor == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.useBtmValidInterceptor == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        long r105 = Double.doubleToLongBits(this.coverSampleRatio);
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = Double.doubleToLongBits(this.validSampleRatio);
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        List<String> r109 = this.skipCoverIntercept;
        int r110 = 0;
        if (r109 != null) goto L13;
        int r111 = 0;
    L14:
        int r112 = (r108 + r111) * 31;
        Map<String, d> r113 = this.validConfig;
        if (r113 != null) goto L17;
        int r114 = 0;
    L18:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.appendBtmEventConfig;
        if (r116 == null) goto L22;
        r110 = r116.hashCode();
    L22:
        int r117 = (r115 + r110) * 31;
        if (this.useExpoundCardIdInterceptor == true) goto L27;
        r100 = 1237;
    L27:
        return r117 + r100;
    L17:
        r114 = r113.hashCode();
        goto L18
    L13:
        r111 = r109.hashCode();
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "PoiBtmCheckerConfigEntity(useBtmCoverInterceptor=" + this.useBtmCoverInterceptor + ", useBtmValidInterceptor=" + this.useBtmValidInterceptor + ", coverSampleRatio=" + this.coverSampleRatio + ", validSampleRatio=" + this.validSampleRatio + ", skipCoverIntercept=" + this.skipCoverIntercept + ", validConfig=" + this.validConfig + ", appendBtmEventConfig=" + this.appendBtmEventConfig + ", useExpoundCardIdInterceptor=" + this.useExpoundCardIdInterceptor + ')';
    }

    public c() {
        this.useBtmCoverInterceptor = false;
        this.useBtmValidInterceptor = false;
        this.coverSampleRatio = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.validSampleRatio = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.skipCoverIntercept = null;
        this.validConfig = null;
        this.appendBtmEventConfig = null;
        this.useExpoundCardIdInterceptor = true;
    }

    public final List<String> a() {
        return this.appendBtmEventConfig;
    }

    public final double b() {
        return this.coverSampleRatio;
    }

    public final List<String> c() {
        return this.skipCoverIntercept;
    }

    public final boolean d() {
        return this.useBtmCoverInterceptor;
    }

    public final boolean e() {
        return this.useBtmValidInterceptor;
    }

    public final boolean f() {
        return this.useExpoundCardIdInterceptor;
    }

    public final Map<String, d> g() {
        return this.validConfig;
    }

    public final double h() {
        return this.validSampleRatio;
    }
}
