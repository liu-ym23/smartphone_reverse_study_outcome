package com.bytedance.locallife.model.poi.resp;

import com.bytedance.sdk.account.platform.api.ITiktokService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001%B=\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\"\u0010#J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0003J?\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b!\u0010 ¨\u0006&"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/UserInfo;", "Ljava/io/Serializable;", "Lcom/bytedance/locallife/model/poi/resp/PoiSimpleUserStruct;", "component1", "", "Lcom/bytedance/locallife/model/poi/resp/RateTag;", "component2", "", "component3", "component4", "basicInfo", "userTags", "redirectUrl", "avatarFrameCenterUrl", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/locallife/model/poi/resp/PoiSimpleUserStruct;", "getBasicInfo", "()Lcom/bytedance/locallife/model/poi/resp/PoiSimpleUserStruct;", "setBasicInfo", "(Lcom/bytedance/locallife/model/poi/resp/PoiSimpleUserStruct;)V", "Ljava/util/List;", "getUserTags", "()Ljava/util/List;", "Ljava/lang/String;", "getRedirectUrl", "()Ljava/lang/String;", "getAvatarFrameCenterUrl", "<init>", "(Lcom/bytedance/locallife/model/poi/resp/PoiSimpleUserStruct;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class UserInfo implements Serializable {
    public static final a Companion = null;
    public static final long serialVersionUID = 1;

    @SerializedName("avatar_frame_center_url")
    private final String avatarFrameCenterUrl;

    @SerializedName("user_basic_info")
    private PoiSimpleUserStruct basicInfo;

    @SerializedName(ITiktokService.ResponseConstants.REDIRECT_URL)
    private final String redirectUrl;

    @SerializedName("user_tags_v2")
    private final List<RateTag> userTags;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public UserInfo() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UserInfo copy$default(UserInfo r100, PoiSimpleUserStruct r101, List r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.basicInfo;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.userTags;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.redirectUrl;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.avatarFrameCenterUrl;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final PoiSimpleUserStruct component1() {
        return this.basicInfo;
    }

    public final List<RateTag> component2() {
        return this.userTags;
    }

    public final String component3() {
        return this.redirectUrl;
    }

    public final String component4() {
        return this.avatarFrameCenterUrl;
    }

    public final UserInfo copy(PoiSimpleUserStruct r100, List<RateTag> r101, String r102, String r103) {
        return new UserInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserInfo) == true) goto L8;
        return false;
    L8:
        UserInfo r101 = (UserInfo) r100;
        if (Intrinsics.areEqual(this.basicInfo, r101.basicInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.userTags, r101.userTags) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.redirectUrl, r101.redirectUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatarFrameCenterUrl, r101.avatarFrameCenterUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        PoiSimpleUserStruct r100 = this.basicInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<RateTag> r104 = this.userTags;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.redirectUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.avatarFrameCenterUrl;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "UserInfo(basicInfo=" + this.basicInfo + ", userTags=" + this.userTags + ", redirectUrl=" + this.redirectUrl + ", avatarFrameCenterUrl=" + this.avatarFrameCenterUrl + ')';
    }

    public final String getAvatarFrameCenterUrl() {
        return this.avatarFrameCenterUrl;
    }

    public final PoiSimpleUserStruct getBasicInfo() {
        return this.basicInfo;
    }

    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    public final List<RateTag> getUserTags() {
        return this.userTags;
    }

    public final void setBasicInfo(PoiSimpleUserStruct r100) {
        this.basicInfo = r100;
    }

    public UserInfo(PoiSimpleUserStruct r100, List<RateTag> r101, String r102, String r103) {
        this.basicInfo = r100;
        this.userTags = r101;
        this.redirectUrl = r102;
        this.avatarFrameCenterUrl = r103;
    }

    public /* synthetic */ UserInfo(PoiSimpleUserStruct r100, List r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
