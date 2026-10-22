package eb1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Leb1/a;", "", "", "recordId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "filePath", "c", "", "start", "J", "e", "()J", "duration", "b", "", "deviceAlgDelay", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("device_alg_delay")
    private final int deviceAlgDelay;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("audio_path")
    private final String filePath;

    @SerializedName("id")
    private final String recordId;

    @SerializedName("start")
    private final long start;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.recordId, r101.recordId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.filePath, r101.filePath) == true) goto L10;
        return false;
    L10:
        if (this.start == r101.start) goto L12;
        return false;
    L12:
        if (this.duration == r101.duration) goto L14;
        return false;
    L14:
        if (this.deviceAlgDelay == r101.deviceAlgDelay) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.recordId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.filePath;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.start;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.duration;
        return ((r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31) + this.deviceAlgDelay;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AudioRecordItemModel(recordId=" + this.recordId + ", filePath=" + this.filePath + ", start=" + this.start + ", duration=" + this.duration + ", deviceAlgDelay=" + this.deviceAlgDelay + ")";
    }

    public final int a() {
        return this.deviceAlgDelay;
    }

    public final long b() {
        return this.duration;
    }

    public final String c() {
        return this.filePath;
    }

    public final String d() {
        return this.recordId;
    }

    public final long e() {
        return this.start;
    }

    public a(String r100, String r101, long r102, long r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "recordId");
        Intrinsics.checkNotNullParameter(r101, "filePath");
        this.recordId = r100;
        this.filePath = r101;
        this.start = r102;
        this.duration = r103;
        this.deviceAlgDelay = r104;
    }
}
