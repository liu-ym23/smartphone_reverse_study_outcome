package rg7;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lrg7/c;", "", "", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "", "unitDisable", "I", "d", "()I", "", "patternConfidence", FaceService.girlLabel, "b", "()F", "", "", "patterns", "Ljava/util/List;", "c", "()Ljava/util/List;", "clipboard-suite_release"}, k = 1, mv = {1, 4, 0})
public final class c {

    @SerializedName("expire_time")
    private final long expireTime;

    @SerializedName("pattern_confidence")
    private final float patternConfidence;

    @SerializedName("patterns")
    private final List<String> patterns;

    @SerializedName("unit_disable")
    private final int unitDisable;

    public c() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (this.expireTime == r101.expireTime) goto L8;
        return false;
    L8:
        if (this.unitDisable == r101.unitDisable) goto L10;
        return false;
    L10:
        if (Float.compare(this.patternConfidence, r101.patternConfidence) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.patterns, r101.patterns) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.expireTime;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.unitDisable) * 31) + Float.floatToIntBits(this.patternConfidence)) * 31;
        List<String> r102 = this.patterns;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "TokenConfig(expireTime=" + this.expireTime + ", unitDisable=" + this.unitDisable + ", patternConfidence=" + this.patternConfidence + ", patterns=" + this.patterns + ")";
    }

    public final long a() {
        return this.expireTime;
    }

    public final float b() {
        return this.patternConfidence;
    }

    public final List<String> c() {
        return this.patterns;
    }

    public final int d() {
        return this.unitDisable;
    }

    public c(Object r100) {
        List<String> r101 = CollectionsKt.emptyList();
        this.expireTime = Long.MAX_VALUE;
        this.unitDisable = 0;
        this.patternConfidence = 0.0f;
        this.patterns = r101;
    }
}
