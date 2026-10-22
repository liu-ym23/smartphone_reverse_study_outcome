package ls1;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\nR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R0\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006)"}, d2 = {"Lls1/i;", "", "", "predictType", "I", "getPredictType", "()I", "limitStartTime", "getLimitStartTime", "setLimitStartTime", "(I)V", "limitEndTime", "getLimitEndTime", "setLimitEndTime", "", "", "feedGroupFeaturesList", "Ljava/util/List;", "getFeedGroupFeaturesList", "()Ljava/util/List;", "setFeedGroupFeaturesList", "(Ljava/util/List;)V", "", "feedFeatureMap", "Ljava/util/Map;", "getFeedFeatureMap", "()Ljava/util/Map;", "setFeedFeatureMap", "(Ljava/util/Map;)V", "abParams", "getAbParams", "setAbParams", "", "showToastEnable", "Z", "getShowToastEnable", "()Z", "setShowToastEnable", "(Z)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS)
    private Map<String, ? extends Object> abParams;

    @SerializedName("feed_feature_map")
    private Map<String, ? extends Object> feedFeatureMap;

    @SerializedName("feed_group_features_list")
    private List<String> feedGroupFeaturesList;

    @SerializedName("limit_end_time")
    private int limitEndTime;

    @SerializedName("limit_start_time")
    private int limitStartTime;

    @SerializedName("predict_type")
    private final int predictType;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    public i() {
    }
}
