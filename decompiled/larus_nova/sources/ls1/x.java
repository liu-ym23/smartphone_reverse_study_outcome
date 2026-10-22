package ls1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lls1/x;", "", "", "resolutionPredictMode", "Z", "b", "()Z", "setResolutionPredictMode", "(Z)V", "resolutionPredictAfterSetByRoom", "getResolutionPredictAfterSetByRoom", "setResolutionPredictAfterSetByRoom", "", "resolutionPredictInterval", "I", "getResolutionPredictInterval", "()I", "setResolutionPredictInterval", "(I)V", "recordRoomEnable", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setRecordRoomEnable", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class x {

    @SerializedName("record_room_enable")
    private boolean recordRoomEnable;

    @SerializedName("resolution_predict_after_set_by_room")
    private boolean resolutionPredictAfterSetByRoom;

    @SerializedName("resolution_predict_interval")
    private int resolutionPredictInterval;

    @SerializedName("resolution_predict_mode")
    private boolean resolutionPredictMode;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    public x() {
        this.resolutionPredictInterval = 15;
    }

    public final boolean a() {
        return this.recordRoomEnable;
    }

    public final boolean b() {
        return this.resolutionPredictMode;
    }
}
