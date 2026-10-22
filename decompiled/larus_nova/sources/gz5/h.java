package gz5;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015¨\u0006\u001b"}, d2 = {"Lgz5/h;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "", "monitorNormal", "D", "getMonitorNormal", "()D", "setMonitorNormal", "(D)V", "monitorError", "getMonitorError", "setMonitorError", "", "dataTypes", "Ljava/util/List;", "getDataTypes", "()Ljava/util/List;", "", "apiIds", "getApiIds", "skipSysCalls", "getSkipSysCalls", "api_release"}, k = 1, mv = {1, 4, 0})
public final class h {

    @SerializedName("api_ids")
    private final List<Integer> apiIds;

    @SerializedName("data_types")
    private final List<String> dataTypes;

    @SerializedName("monitor_error")
    private double monitorError;

    @SerializedName("monitor_normal")
    private double monitorNormal;

    @SerializedName("name")
    private final String name;

    @SerializedName("skip_sys_calls")
    private final List<String> skipSysCalls;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L18;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
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
        if (Intrinsics.areEqual(this.apiIds, r101.apiIds) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.skipSysCalls, r101.skipSysCalls) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.name;
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
        List<Integer> r110 = this.apiIds;
        if (r110 == null) goto L13;
        int r111 = r110.hashCode();
    L14:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.skipSysCalls;
        if (r113 == null) goto L18;
        r101 = r113.hashCode();
    L18:
        return r112 + r101;
    L13:
        r111 = 0;
        goto L14
    L9:
        r108 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BinderMethodConfig(name=" + this.name + ", monitorNormal=" + this.monitorNormal + ", monitorError=" + this.monitorError + ", dataTypes=" + this.dataTypes + ", apiIds=" + this.apiIds + ", skipSysCalls=" + this.skipSysCalls + ")";
    }

    public h() {
        List<String> r100 = CollectionsKt.emptyList();
        List<Integer> r101 = CollectionsKt.emptyList();
        List<String> r102 = CollectionsKt.emptyList();
        this.name = "";
        this.monitorNormal = -1.0d;
        this.monitorError = -1.0d;
        this.dataTypes = r100;
        this.apiIds = r101;
        this.skipSysCalls = r102;
    }
}
