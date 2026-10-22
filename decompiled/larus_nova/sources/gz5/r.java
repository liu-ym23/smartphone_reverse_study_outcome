package gz5;

import androidx.camera.video.AudioStats;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0016"}, d2 = {"Lgz5/r;", "", "", "interfaceName", "Ljava/lang/String;", "getInterfaceName", "()Ljava/lang/String;", "", "monitorNormal", "D", "getMonitorNormal", "()D", "monitorError", "getMonitorError", "", "dataTypes", "Ljava/util/List;", "getDataTypes", "()Ljava/util/List;", "Lgz5/h;", "methods", "getMethods", "api_release"}, k = 1, mv = {1, 4, 0})
public final class r {

    @SerializedName("data_types")
    private final List<String> dataTypes;

    @SerializedName("interface")
    private final String interfaceName;

    @SerializedName("methods")
    private final List<h> methods;

    @SerializedName("monitor_error")
    private final double monitorError;

    @SerializedName("monitor_normal")
    private final double monitorNormal;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L16;
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.interfaceName, r101.interfaceName) == true) goto L8;
        return false;
    L8:
        if (Double.compare(this.monitorNormal, r101.monitorNormal) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.monitorError, r101.monitorError) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dataTypes, r101.dataTypes) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.methods, r101.methods) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.interfaceName;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        long r103 = Double.doubleToLongBits(this.monitorNormal);
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = Double.doubleToLongBits(this.monitorError);
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        List<String> r107 = this.dataTypes;
        if (r107 == null) goto L9;
        int r108 = r107.hashCode();
    L10:
        int r109 = (r106 + r108) * 31;
        List<h> r110 = this.methods;
        if (r110 == null) goto L14;
        r101 = r110.hashCode();
    L14:
        return r109 + r101;
    L9:
        r108 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InterestBinderConfig(interfaceName=" + this.interfaceName + ", monitorNormal=" + this.monitorNormal + ", monitorError=" + this.monitorError + ", dataTypes=" + this.dataTypes + ", methods=" + this.methods + ")";
    }

    public r() {
        List<String> r100 = CollectionsKt.emptyList();
        List<h> r101 = CollectionsKt.emptyList();
        this.interfaceName = "";
        this.monitorNormal = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.monitorError = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.dataTypes = r100;
        this.methods = r101;
    }
}
