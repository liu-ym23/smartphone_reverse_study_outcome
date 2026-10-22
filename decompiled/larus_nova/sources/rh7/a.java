package rh7;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lrh7/a;", "", "", "senseType", "I", "getSenseType", "()I", "isMainProcess", "senseState", "getSenseState", "", "callMethodType", "Ljava/lang/String;", "getCallMethodType", "()Ljava/lang/String;", "useMultiProcess", "getUseMultiProcess", "timonbase_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("call_method_type")
    private final String callMethodType;

    @SerializedName(LocationMonitorConst.IS_MAIN_PROCESS)
    private final int isMainProcess;

    @SerializedName("sense_state")
    private final int senseState;

    @SerializedName("sense_type")
    private final int senseType;

    @SerializedName("use_multi_process")
    private final int useMultiProcess;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (this.senseType == r101.senseType) goto L8;
        return false;
    L8:
        if (this.isMainProcess == r101.isMainProcess) goto L10;
        return false;
    L10:
        if (this.senseState == r101.senseState) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.callMethodType, r101.callMethodType) == true) goto L14;
        return false;
    L14:
        if (this.useMultiProcess == r101.useMultiProcess) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((this.senseType * 31) + this.isMainProcess) * 31) + this.senseState) * 31;
        String r101 = this.callMethodType;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) * 31) + this.useMultiProcess;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "ScenesReportEvent(senseType=" + this.senseType + ", isMainProcess=" + this.isMainProcess + ", senseState=" + this.senseState + ", callMethodType=" + this.callMethodType + ", useMultiProcess=" + this.useMultiProcess + ")";
    }

    public a() {
        this.senseType = -1;
        this.isMainProcess = 0;
        this.senseState = 0;
        this.callMethodType = "";
        this.useMultiProcess = 0;
    }
}
