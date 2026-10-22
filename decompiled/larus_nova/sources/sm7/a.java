package sm7;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    @SerializedName("activity_id_list")
    private List<String> mActivityIdList;

    @SerializedName("dataunion_strategies")
    private List<String> mDataunionStrategies;

    @SerializedName("enable_apply_token")
    private boolean mEnableApplyToken;

    @SerializedName("enable_refresh_act_id")
    private boolean mEnableRefreshActId;

    @SerializedName("invalid_keys")
    private List<String> mInvalidKeys;

    @SerializedName("league_packages")
    private List<String> mLeaguePackages;

    @SerializedName("valid_key")
    private String mValidKey;

    public a() {
        this.mLeaguePackages = new ArrayList();
        this.mDataunionStrategies = new ArrayList();
    }

    public final List<String> a() {
        return this.mDataunionStrategies;
    }

    public final List<String> b() {
        return this.mInvalidKeys;
    }

    public final List<String> c() {
        return this.mLeaguePackages;
    }

    public final String d() {
        return this.mValidKey;
    }

    public final boolean e() {
        return this.mEnableApplyToken;
    }

    public final boolean f() {
        return this.mEnableRefreshActId;
    }
}
