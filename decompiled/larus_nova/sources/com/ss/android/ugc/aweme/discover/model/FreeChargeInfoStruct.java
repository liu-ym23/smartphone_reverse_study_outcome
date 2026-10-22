package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/FreeChargeInfoStruct;", "Ljava/io/Serializable;", "()V", "awardExpireTime", "", "getAwardExpireTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "awardExpiredTitle", "Lcom/ss/android/ugc/aweme/discover/model/AwardText;", "getAwardExpiredTitle", "()Lcom/ss/android/ugc/aweme/discover/model/AwardText;", "awardExpiringDes", "", "getAwardExpiringDes", "()Ljava/util/List;", "doubleAtmosphere", "Lcom/ss/android/ugc/aweme/discover/model/AwardAtmosphere;", "getDoubleAtmosphere", "()Lcom/ss/android/ugc/aweme/discover/model/AwardAtmosphere;", "singleAtmosphere", "getSingleAtmosphere", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FreeChargeInfoStruct implements Serializable {

    @SerializedName("award_expire_time")
    private final Long awardExpireTime;

    @SerializedName("award_expired_title")
    private final AwardText awardExpiredTitle;

    @SerializedName("award_expiring_des")
    private final List<AwardText> awardExpiringDes;

    @SerializedName("double_atmosphere")
    private final AwardAtmosphere doubleAtmosphere;

    @SerializedName("single_atmosphere")
    private final AwardAtmosphere singleAtmosphere;

    public FreeChargeInfoStruct() {
    }

    public final Long getAwardExpireTime() {
        return this.awardExpireTime;
    }

    public final AwardText getAwardExpiredTitle() {
        return this.awardExpiredTitle;
    }

    public final List<AwardText> getAwardExpiringDes() {
        return this.awardExpiringDes;
    }

    public final AwardAtmosphere getDoubleAtmosphere() {
        return this.doubleAtmosphere;
    }

    public final AwardAtmosphere getSingleAtmosphere() {
        return this.singleAtmosphere;
    }
}
