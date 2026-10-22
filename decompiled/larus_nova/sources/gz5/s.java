package gz5;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lgz5/s;", "", "", "authority", "Ljava/lang/String;", "getAuthority", "()Ljava/lang/String;", "", "monitorNormal", "D", "getMonitorNormal", "()D", "monitorError", "getMonitorError", "", "dataTypes", "Ljava/util/List;", "getDataTypes", "()Ljava/util/List;", "api_release"}, k = 1, mv = {1, 4, 0})
public final class s {

    @SerializedName("authority")
    private final String authority;

    @SerializedName("data_types")
    private final List<String> dataTypes;

    @SerializedName("monitor_error")
    private final double monitorError;

    @SerializedName("monitor_normal")
    private final double monitorNormal;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L14;
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.authority, r101.authority) == true) goto L8;
        return false;
    L8:
        if (Double.compare(this.monitorNormal, r101.monitorNormal) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.monitorError, r101.monitorError) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dataTypes, r101.dataTypes) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.authority;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = Double.doubleToLongBits(this.monitorNormal);
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = Double.doubleToLongBits(this.monitorError);
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        List<String> r107 = this.dataTypes;
        if (r107 == null) goto L10;
        r101 = r107.hashCode();
    L10:
        return r106 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InterestContentProviderConfig(authority=" + this.authority + ", monitorNormal=" + this.monitorNormal + ", monitorError=" + this.monitorError + ", dataTypes=" + this.dataTypes + ")";
    }

    public s() {
        List<String> r100 = CollectionsKt.emptyList();
        this.authority = "";
        this.monitorNormal = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.monitorError = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.dataTypes = r100;
    }
}
