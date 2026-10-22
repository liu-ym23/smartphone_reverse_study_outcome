package ls1;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u000bR0\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006."}, d2 = {"Lls1/h;", "", "", "enable", "Z", "getEnable", "()Z", "", "firstPredictDelayMs", "J", "getFirstPredictDelayMs", "()J", "", "", "allowedPredictRoomIndexList", "Ljava/util/List;", "getAllowedPredictRoomIndexList", "()Ljava/util/List;", "maxPredictCount", "I", "getMaxPredictCount", "()I", "timerPredictEnable", "getTimerPredictEnable", "timerPredictDuration", "getTimerPredictDuration", "", "", "abParams", "Ljava/util/Map;", "getAbParams", "()Ljava/util/Map;", "setAbParams", "(Ljava/util/Map;)V", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "(Z)V", "predictType", "Ljava/lang/String;", "getPredictType", "()Ljava/lang/String;", "setPredictType", "(Ljava/lang/String;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS)
    private Map<String, ? extends Object> abParams;

    @SerializedName("max_allowed_predict_room_count")
    private final List<Integer> allowedPredictRoomIndexList;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("first_predict_delay_ms")
    private final long firstPredictDelayMs;

    @SerializedName("max_predict_count")
    private final int maxPredictCount;

    @SerializedName("predict_type")
    private String predictType;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    @SerializedName("timer_predict_duration")
    private final long timerPredictDuration;

    @SerializedName("timer_predict_enable")
    private final boolean timerPredictEnable;

    public h() {
        this.allowedPredictRoomIndexList = CollectionsKt.listOf(0);
        this.timerPredictDuration = 5000;
        this.predictType = "inner_first_room_slide";
    }
}
