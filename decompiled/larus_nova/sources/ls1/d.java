package ls1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\b¨\u0006+"}, d2 = {"Lls1/d;", "", "", "enable", "Z", "getEnable", "()Z", "setEnable", "(Z)V", "enableLiveSecurityFeature", "getEnableLiveSecurityFeature", "setEnableLiveSecurityFeature", "", "predictInterval", "J", "getPredictInterval", "()J", "setPredictInterval", "(J)V", "minPredictInterval", "getMinPredictInterval", "setMinPredictInterval", "enableTimer", "getEnableTimer", "setEnableTimer", "insertFeatureMapEnable", "getInsertFeatureMapEnable", "setInsertFeatureMapEnable", "updateFeaturesEnable", "getUpdateFeaturesEnable", "setUpdateFeaturesEnable", "", "businessName", "Ljava/lang/String;", "getBusinessName", "()Ljava/lang/String;", "setBusinessName", "(Ljava/lang/String;)V", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("business_name")
    private String businessName;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_live_security_feature")
    private boolean enableLiveSecurityFeature;

    @SerializedName("enable_timer_predict")
    private boolean enableTimer;

    @SerializedName("insert_feature_map_enable")
    private boolean insertFeatureMapEnable;

    @SerializedName("min_predict_interval")
    private long minPredictInterval;

    @SerializedName("predict_interval")
    private long predictInterval;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    @SerializedName("update_features_enable")
    private boolean updateFeaturesEnable;

    public d() {
        this.predictInterval = 15000;
        this.minPredictInterval = 2000;
        this.enableTimer = true;
        this.insertFeatureMapEnable = true;
        this.businessName = "aweme_live_feature_manager";
    }
}
