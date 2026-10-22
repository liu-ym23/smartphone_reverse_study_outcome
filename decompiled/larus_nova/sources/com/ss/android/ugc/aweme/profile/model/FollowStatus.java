package com.ss.android.ugc.aweme.profile.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.ec.search.common.CommerceBaseResponse;
import com.ss.android.ugc.aweme.feed.model.LogPbBean;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001XB\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0019\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010S\u001a\u000202J\u0010\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010\u0005J\u0010\u0010W\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001a\u0010\u001a\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u001d\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001c\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u001a\u0010#\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001a\u0010+\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0014\"\u0004\b-\u0010\u0016R\u001c\u0010.\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u000f\"\u0004\b0\u0010\u0011R\u0016\u00101\u001a\u0002028\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b1\u00103R\u0011\u00104\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b4\u00103R\u001e\u00105\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016R\u001a\u00107\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00109R\u001a\u0010:\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00109R\u001e\u0010<\u001a\u0002028\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00103\"\u0004\b=\u00109R\u001a\u0010>\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R \u0010A\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR \u0010G\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u000f\"\u0004\bI\u0010\u0011R\u0011\u0010J\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bK\u0010\u000fR \u0010L\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u000f\"\u0004\bN\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bO\u0010\u000fR\u001e\u0010P\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0014\"\u0004\bR\u0010\u0016¨\u0006Y"}, d2 = {"Lcom/ss/android/ugc/aweme/profile/model/FollowStatus;", "Lcom/ss/android/ugc/aweme/ec/search/common/CommerceBaseResponse;", "Ljava/io/Serializable;", "()V", "userId", "", "followStatus", "", "(Ljava/lang/String;I)V", "statusCode", "(Ljava/lang/String;II)V", "_secUserId", "_userId", "contactName", "getContactName", "()Ljava/lang/String;", "setContactName", "(Ljava/lang/String;)V", "couponStatus", "getCouponStatus", "()I", "setCouponStatus", "(I)V", "enterMethod", "getEnterMethod", "setEnterMethod", "followFrom", "getFollowFrom", "setFollowFrom", "followFromAction", "getFollowFromAction", "setFollowFromAction", "followFromAid", "getFollowFromAid", "setFollowFromAid", "followFromPreviousPage", "getFollowFromPreviousPage", "setFollowFromPreviousPage", "followReqStatus", "getFollowReqStatus", "setFollowReqStatus", "getFollowStatus", "setFollowStatus", "followerStatus", "getFollowerStatus", "setFollowerStatus", "fromScene", "getFromScene", "setFromScene", "isBizAccount", "", "()Z", "isCheating", "isEnterprise", "setEnterprise", "isFollowChange", "setFollowChange", "(Z)V", "isFollowSuccess", "setFollowSuccess", "isPreVerifyCondition", "setPreVerifyCondition", "lastFollowStatus", "getLastFollowStatus", "setLastFollowStatus", "logPb", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "getLogPb", "()Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "setLogPb", "(Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;)V", "mobileKey", "getMobileKey", "setMobileKey", "secUserId", "getSecUserId", "secondVerifyType", "getSecondVerifyType", "setSecondVerifyType", "getUserId", "watchStatus", "getWatchStatus", "setWatchStatus", "getIsEnterprise", "setSecUserId", "", "uid", "setUserId", "Companion", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class FollowStatus extends CommerceBaseResponse {
    public static final Companion Companion = null;
    public static final int STATUS_CODE_CHEATING = 2149;
    public static final int STATUS_FOLLOW = 1;
    public static final int STATUS_FOLLOW_REQUEST = 4;
    public static final int STATUS_FOLLOW_TWOWAY = 2;
    public static final int STATUS_OTHOR_FOLLOW = 3;
    public static final int STATUS_UNFOLLOW = 0;
    public static final int STATUS_UNKNOWN = -1;
    private String _secUserId;
    private String _userId;

    @SerializedName("contact_name")
    private String contactName;

    @SerializedName("coupon_status")
    private int couponStatus;
    private String enterMethod;
    private int followFrom;
    private int followFromAction;
    private String followFromAid;
    private int followFromPreviousPage;
    private int followReqStatus;

    @SerializedName("follow_status")
    private int followStatus;
    private int followerStatus;
    private String fromScene;

    @SerializedName("is_biz_account")
    private final boolean isBizAccount;

    @SerializedName("is_enterprise")
    private int isEnterprise;
    private boolean isFollowChange;
    private boolean isFollowSuccess;

    @SerializedName("pre_verify_condition")
    private boolean isPreVerifyCondition;
    private int lastFollowStatus;

    @SerializedName("log_pb")
    private LogPbBean logPb;

    @SerializedName("mobile_key")
    private String mobileKey;

    @SerializedName("second_verify_type")
    private String secondVerifyType;

    @SerializedName("watch_status")
    private int watchStatus;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/ss/android/ugc/aweme/profile/model/FollowStatus$Companion;", "", "()V", "STATUS_CODE_CHEATING", "", "STATUS_FOLLOW", "STATUS_FOLLOW_REQUEST", "STATUS_FOLLOW_TWOWAY", "STATUS_OTHOR_FOLLOW", "STATUS_UNFOLLOW", "STATUS_UNKNOWN", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public final boolean getIsEnterprise() {
        if (this.isEnterprise == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public FollowStatus() {
        this._userId = "";
        this._secUserId = "";
        this.followReqStatus = -1;
        this.isFollowSuccess = true;
        this.isFollowChange = true;
        this.followerStatus = -1;
        this.lastFollowStatus = -1;
    }

    public final boolean isCheating() {
        if (getStatusCode() != 2149) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final int getCouponStatus() {
        return this.couponStatus;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final int getFollowFrom() {
        return this.followFrom;
    }

    public final int getFollowFromAction() {
        return this.followFromAction;
    }

    public final String getFollowFromAid() {
        return this.followFromAid;
    }

    public final int getFollowFromPreviousPage() {
        return this.followFromPreviousPage;
    }

    public final int getFollowReqStatus() {
        return this.followReqStatus;
    }

    public final int getFollowStatus() {
        return this.followStatus;
    }

    public final int getFollowerStatus() {
        return this.followerStatus;
    }

    public final String getFromScene() {
        return this.fromScene;
    }

    public final int getLastFollowStatus() {
        return this.lastFollowStatus;
    }

    public final LogPbBean getLogPb() {
        return this.logPb;
    }

    public final String getMobileKey() {
        return this.mobileKey;
    }

    public final String getSecUserId() {
        return this._secUserId;
    }

    public final String getSecondVerifyType() {
        return this.secondVerifyType;
    }

    public final String getUserId() {
        return this._userId;
    }

    public final int getWatchStatus() {
        return this.watchStatus;
    }

    public final boolean isBizAccount() {
        return this.isBizAccount;
    }

    public final int isEnterprise() {
        return this.isEnterprise;
    }

    public final boolean isFollowChange() {
        return this.isFollowChange;
    }

    public final boolean isFollowSuccess() {
        return this.isFollowSuccess;
    }

    public final boolean isPreVerifyCondition() {
        return this.isPreVerifyCondition;
    }

    public final void setContactName(String r100) {
        this.contactName = r100;
    }

    public final void setCouponStatus(int r100) {
        this.couponStatus = r100;
    }

    public final void setEnterMethod(String r100) {
        this.enterMethod = r100;
    }

    public final void setEnterprise(int r100) {
        this.isEnterprise = r100;
    }

    public final void setFollowChange(boolean r100) {
        this.isFollowChange = r100;
    }

    public final void setFollowFrom(int r100) {
        this.followFrom = r100;
    }

    public final void setFollowFromAction(int r100) {
        this.followFromAction = r100;
    }

    public final void setFollowFromAid(String r100) {
        this.followFromAid = r100;
    }

    public final void setFollowFromPreviousPage(int r100) {
        this.followFromPreviousPage = r100;
    }

    public final void setFollowReqStatus(int r100) {
        this.followReqStatus = r100;
    }

    public final void setFollowStatus(int r100) {
        this.followStatus = r100;
    }

    public final void setFollowSuccess(boolean r100) {
        this.isFollowSuccess = r100;
    }

    public final void setFollowerStatus(int r100) {
        this.followerStatus = r100;
    }

    public final void setFromScene(String r100) {
        this.fromScene = r100;
    }

    public final void setLastFollowStatus(int r100) {
        this.lastFollowStatus = r100;
    }

    public final void setLogPb(LogPbBean r100) {
        this.logPb = r100;
    }

    public final void setMobileKey(String r100) {
        this.mobileKey = r100;
    }

    public final void setPreVerifyCondition(boolean r100) {
        this.isPreVerifyCondition = r100;
    }

    public final void setSecUserId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this._secUserId = r100;
    }

    public final void setSecondVerifyType(String r100) {
        this.secondVerifyType = r100;
    }

    public final void setUserId(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this._userId = r100;
    }

    public final void setWatchStatus(int r100) {
        this.watchStatus = r100;
    }

    public FollowStatus(String r100, int r101) {
        this._userId = "";
        this._secUserId = "";
        this.followReqStatus = -1;
        this.isFollowSuccess = true;
        this.isFollowChange = true;
        this.followerStatus = -1;
        this.lastFollowStatus = -1;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this._userId = r100;
        this.followStatus = r101;
    }

    public FollowStatus(String r100, int r101, int r102) {
        this._userId = "";
        this._secUserId = "";
        this.followReqStatus = -1;
        this.isFollowSuccess = true;
        this.isFollowChange = true;
        this.followerStatus = -1;
        this.lastFollowStatus = -1;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        this._userId = r100;
        this.followStatus = r101;
        setStatusCode(r102);
    }
}
