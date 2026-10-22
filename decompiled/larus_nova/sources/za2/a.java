package za2;

import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class a {

    @SerializedName("request_source")
    public String mRequestSource;

    @SerializedName("target_type")
    public int mTargetType;

    @SerializedName("user_id")
    public String mUserId;

    @SerializedName(ITwitterService.ResponseConstants.USER_NAME)
    public String mUserName;

    public a() {
    }
}
