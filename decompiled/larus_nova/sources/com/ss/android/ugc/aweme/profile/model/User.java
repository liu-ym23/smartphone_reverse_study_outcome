package com.ss.android.ugc.aweme.profile.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.utils.GsonUtil;
import com.ss.android.ugc.aweme.ec.search.common.UrlModel;
import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b*\u0010\u0017J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u0012\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u000eR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u000eR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u000eR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u000eR\u0016\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u0019R\u001e\u0010#\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\f\n\u0004\b#\u0010\u000e\u0012\u0004\b$\u0010\u0017R\u0018\u0010%\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0011\u0010(\u001a\u00020'8F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/ss/android/ugc/aweme/profile/model/User;", "Ljava/io/Serializable;", "", "", "Lcom/ss/android/ugc/aweme/profile/model/UserCertInfo;", "getAccountCertInfoStruct", "", "getUid", "getSecUid", "getNickname", "getRemarkName", "", "getFollowStatus", "uid", "Ljava/lang/String;", "roomIdStr", "", "roomId", "J", InstantPlayContext.NICKNAME, "requestId", "customVerify", "getCustomVerify$annotations", "()V", "verificationType", "I", "weiboVerify", "accountCertInfo", "remarkName", "secUid", "followStatus", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "avatarThumb", "Lcom/ss/android/ugc/aweme/ec/search/common/UrlModel;", "commerceUserLevel", "enterpriseVerifyReason", "getEnterpriseVerifyReason$annotations", "accountCertInfoStruct", "Lcom/ss/android/ugc/aweme/profile/model/UserCertInfo;", "", "isLive", "()Z", "<init>", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
public final class User implements Serializable, Cloneable {

    @SerializedName("account_cert_info")
    public String accountCertInfo;
    private transient UserCertInfo accountCertInfoStruct;

    @SerializedName("avatar_thumb")
    public UrlModel avatarThumb;

    @SerializedName("commerce_user_level")
    public int commerceUserLevel;

    @SerializedName("custom_verify")
    public String customVerify;

    @SerializedName("enterprise_verify_reason")
    public String enterpriseVerifyReason;

    @SerializedName("follow_status")
    public int followStatus;

    @SerializedName(InstantPlayContext.NICKNAME)
    public String nickname;

    @SerializedName("remark_name")
    public String remarkName;

    @SerializedName("rid")
    public String requestId;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("room_id_str")
    public String roomIdStr;

    @SerializedName("sec_uid")
    public String secUid;

    @SerializedName("uid")
    public String uid;

    @SerializedName("verification_type")
    public int verificationType;

    @SerializedName("weibo_verify")
    public String weiboVerify;

    @Deprecated(message = "")
    public static /* synthetic */ void getCustomVerify$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getEnterpriseVerifyReason$annotations() {
    }

    public final UserCertInfo getAccountCertInfoStruct() {
        if (this.accountCertInfoStruct != null) goto L20;
    L18:
        this.accountCertInfoStruct = null;
        goto L20
    L5:
        if (GsonUtil.f450786a == null) goto L7;
    L16:
        this.accountCertInfoStruct = (UserCertInfo) GsonUtil.f450786a.fromJson(this.accountCertInfo, UserCertInfo.class);     // Catch: Exception -> L18
        goto L20
    L7:
        monitor-enter(GsonUtil.class);     // Catch: Exception -> L18
    L13:
        th = move-exception;
        throw th;     // Catch: Exception -> L18
    L9:
        if (GsonUtil.f450786a != null) goto L11;
        GsonUtil.f450786a = new Gson();     // Catch: Throwable -> L13
    L11:
        monitor-exit(GsonUtil.class);     // Catch: Throwable -> L13
    L20:
        return this.accountCertInfoStruct;
    }

    public final boolean isLive() {
        if (this.roomId == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Object clone() {
        return super.clone();
    }

    public User() {
    }

    public int getFollowStatus() {
        return this.followStatus;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getRemarkName() {
        return this.remarkName;
    }

    public String getSecUid() {
        return this.secUid;
    }

    public String getUid() {
        return this.uid;
    }
}
