package com.bytedance.awemeopen.export.api.pageconfig.profile;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.HostEventParameters;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.ProfileFollowExtra;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 T2\u00020\u0001:\u0001UB\u0007¢\u0006\u0004\bQ\u0010RB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bQ\u0010SJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R$\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010'\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\"\u0010/\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010'\u001a\u0004\b/\u0010)\"\u0004\b0\u0010+R$\u00101\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0012\u001a\u0004\b2\u0010\u0014\"\u0004\b3\u0010\u0016R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010B\u001a\u00020;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010=\u001a\u0004\bC\u0010?\"\u0004\bD\u0010AR$\u0010E\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0012\u001a\u0004\bF\u0010\u0014\"\u0004\bG\u0010\u0016R$\u0010H\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0012\u001a\u0004\bI\u0010\u0014\"\u0004\bJ\u0010\u0016R\"\u0010K\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010'\u001a\u0004\bL\u0010)\"\u0004\bM\u0010+R\"\u0010N\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010'\u001a\u0004\bO\u0010)\"\u0004\bP\u0010+¨\u0006V"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pageconfig/profile/ProfilePageConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "profileFollowExtra", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "getProfileFollowExtra", "()Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "setProfileFollowExtra", "(Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;)V", "", "sceneId", "Ljava/lang/String;", "getSceneId", "()Ljava/lang/String;", "setSceneId", "(Ljava/lang/String;)V", "openId", "getOpenId", "setOpenId", "aid", "getAid", "setAid", "userProfile", "getUserProfile", "setUserProfile", "", "isLive", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setLive", "(Ljava/lang/Boolean;)V", "hideLongPressTab", "Z", "getHideLongPressTab", "()Z", "setHideLongPressTab", "(Z)V", "uselessFollowChannel", "getUselessFollowChannel", "setUselessFollowChannel", "isCardMode", "setCardMode", ReportConstant.COMMON_ACTION_TYPE, "getActionType", "setActionType", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;", "hostEventParameters", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;", "getHostEventParameters", "()Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;", "setHostEventParameters", "(Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;)V", "Lorg/json/JSONObject;", "hostCommonParams", "Lorg/json/JSONObject;", "getHostCommonParams", "()Lorg/json/JSONObject;", "setHostCommonParams", "(Lorg/json/JSONObject;)V", "hostExtraParams", "getHostExtraParams", "setHostExtraParams", "fromReqId", "getFromReqId", "setFromReqId", "fromGroupId", "getFromGroupId", "setFromGroupId", "hideRecently", "getHideRecently", "setHideRecently", "clearTop", "getClearTop", "setClearTop", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class ProfilePageConfig implements Parcelable {
    public static final a CREATOR = null;
    private String actionType;
    private String aid;
    private boolean clearTop;
    private String fromGroupId;
    private String fromReqId;
    private boolean hideLongPressTab;
    private boolean hideRecently;
    private JSONObject hostCommonParams;
    private HostEventParameters hostEventParameters;
    private JSONObject hostExtraParams;
    private boolean isCardMode;
    private Boolean isLive;
    private String openId;
    private ProfileFollowExtra profileFollowExtra;
    private String sceneId;
    private boolean uselessFollowChannel;
    private String userProfile;

    public static final class a implements Parcelable.Creator<ProfilePageConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProfilePageConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ProfilePageConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ProfilePageConfig[] newArray(int r100) {
            return new ProfilePageConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ProfilePageConfig() {
        this.hostCommonParams = new JSONObject();
        this.hostExtraParams = new JSONObject();
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getAid() {
        return this.aid;
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    public final String getFromGroupId() {
        return this.fromGroupId;
    }

    public final String getFromReqId() {
        return this.fromReqId;
    }

    public final boolean getHideLongPressTab() {
        return this.hideLongPressTab;
    }

    public final boolean getHideRecently() {
        return this.hideRecently;
    }

    public final JSONObject getHostCommonParams() {
        return this.hostCommonParams;
    }

    public final HostEventParameters getHostEventParameters() {
        return this.hostEventParameters;
    }

    public final JSONObject getHostExtraParams() {
        return this.hostExtraParams;
    }

    public final String getOpenId() {
        return this.openId;
    }

    public final ProfileFollowExtra getProfileFollowExtra() {
        return this.profileFollowExtra;
    }

    public final String getSceneId() {
        return this.sceneId;
    }

    public final boolean getUselessFollowChannel() {
        return this.uselessFollowChannel;
    }

    public final String getUserProfile() {
        return this.userProfile;
    }

    public final boolean isCardMode() {
        return this.isCardMode;
    }

    public final Boolean isLive() {
        return this.isLive;
    }

    public ProfilePageConfig(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.profileFollowExtra = (ProfileFollowExtra) r100.readParcelable(ProfileFollowExtra.class.getClassLoader());
        Object r101 = r100.readValue(String.class.getClassLoader());
        Boolean r102 = null;
        if ((r101 instanceof String) == false) goto L5;
        String r103 = (String) r101;
    L6:
        String r104 = "";
        if (r103 != null) goto L9;
        r103 = "";
    L9:
        this.sceneId = r103;
        Object r105 = r100.readValue(String.class.getClassLoader());
        if ((r105 instanceof String) == false) goto L12;
        String r106 = (String) r105;
    L13:
        if (r106 != null) goto L15;
        r106 = "";
    L15:
        this.openId = r106;
        Object r107 = r100.readValue(String.class.getClassLoader());
        if ((r107 instanceof String) == false) goto L18;
        String r108 = (String) r107;
    L19:
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        this.aid = r108;
        this.userProfile = r100.readString();
        Class r109 = Boolean.TYPE;
        Object r110 = r100.readValue(r109.getClassLoader());
        if ((r110 instanceof Boolean) == false) goto L24;
        Boolean r111 = (Boolean) r110;
    L25:
        this.isLive = r111;
        Object r112 = r100.readValue(r109.getClassLoader());
        if ((r112 instanceof Boolean) == false) goto L28;
        Boolean r113 = (Boolean) r112;
    L29:
        boolean r114 = false;
        if (r113 == null) goto L32;
        boolean r115 = r113.booleanValue();
    L33:
        this.hideLongPressTab = r115;
        Object r116 = r100.readValue(r109.getClassLoader());
        if ((r116 instanceof Boolean) == false) goto L36;
        Boolean r117 = (Boolean) r116;
    L37:
        if (r117 == null) goto L39;
        boolean r118 = r117.booleanValue();
    L40:
        this.uselessFollowChannel = r118;
        Object r119 = r100.readValue(r109.getClassLoader());
        if ((r119 instanceof Boolean) == false) goto L43;
        Boolean r120 = (Boolean) r119;
    L44:
        if (r120 == null) goto L46;
        boolean r121 = r120.booleanValue();
    L47:
        this.isCardMode = r121;
        Object r122 = r100.readValue(String.class.getClassLoader());
        if ((r122 instanceof String) == false) goto L50;
        String r123 = (String) r122;
    L51:
        if (r123 != null) goto L53;
        r123 = "";
    L53:
        this.actionType = r123;
        this.hostEventParameters = (HostEventParameters) r100.readParcelable(HostEventParameters.class.getClassLoader());
        String r124 = r100.readString();
        if (r124 != null) goto L56;
        r124 = "";
    L56:
        this.hostCommonParams = new JSONObject(r124);
        String r125 = r100.readString();
        if (r125 != null) goto L59;
        r125 = "";
    L59:
        this.hostExtraParams = new JSONObject(r125);
        Object r126 = r100.readValue(String.class.getClassLoader());
        if ((r126 instanceof String) == false) goto L62;
        String r127 = (String) r126;
    L63:
        if (r127 != null) goto L65;
        r127 = "";
    L65:
        this.fromReqId = r127;
        Object r128 = r100.readValue(String.class.getClassLoader());
        if ((r128 instanceof String) == false) goto L68;
        String r129 = (String) r128;
    L69:
        if (r129 == null) goto L72;
        r104 = r129;
    L72:
        this.fromGroupId = r104;
        Object r130 = r100.readValue(r109.getClassLoader());
        if ((r130 instanceof Boolean) == false) goto L75;
        Boolean r131 = (Boolean) r130;
    L76:
        if (r131 == null) goto L78;
        boolean r132 = r131.booleanValue();
    L79:
        this.hideRecently = r132;
        Object r133 = r100.readValue(r109.getClassLoader());
        if ((r133 instanceof Boolean) == false) goto L82;
        r102 = (Boolean) r133;
    L82:
        if (r102 == null) goto L84;
        r114 = r102.booleanValue();
    L84:
        this.clearTop = r114;
        return;
    L78:
        r132 = false;
        goto L79
    L75:
        r131 = null;
        goto L76
    L68:
        r129 = null;
        goto L69
    L62:
        r127 = null;
        goto L63
    L50:
        r123 = null;
        goto L51
    L46:
        r121 = false;
        goto L47
    L43:
        r120 = null;
        goto L44
    L39:
        r118 = false;
        goto L40
    L36:
        r117 = null;
        goto L37
    L32:
        r115 = false;
        goto L33
    L28:
        r113 = null;
        goto L29
    L24:
        r111 = null;
        goto L25
    L18:
        r108 = null;
        goto L19
    L12:
        r106 = null;
        goto L13
    L5:
        r103 = null;
        goto L6
    }

    public final void setActionType(String r100) {
        this.actionType = r100;
    }

    public final void setAid(String r100) {
        this.aid = r100;
    }

    public final void setCardMode(boolean r100) {
        this.isCardMode = r100;
    }

    public final void setClearTop(boolean r100) {
        this.clearTop = r100;
    }

    public final void setFromGroupId(String r100) {
        this.fromGroupId = r100;
    }

    public final void setFromReqId(String r100) {
        this.fromReqId = r100;
    }

    public final void setHideLongPressTab(boolean r100) {
        this.hideLongPressTab = r100;
    }

    public final void setHideRecently(boolean r100) {
        this.hideRecently = r100;
    }

    public final void setHostCommonParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostCommonParams = r100;
    }

    public final void setHostEventParameters(HostEventParameters r100) {
        this.hostEventParameters = r100;
    }

    public final void setHostExtraParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostExtraParams = r100;
    }

    public final void setLive(Boolean r100) {
        this.isLive = r100;
    }

    public final void setOpenId(String r100) {
        this.openId = r100;
    }

    public final void setProfileFollowExtra(ProfileFollowExtra r100) {
        this.profileFollowExtra = r100;
    }

    public final void setSceneId(String r100) {
        this.sceneId = r100;
    }

    public final void setUselessFollowChannel(boolean r100) {
        this.uselessFollowChannel = r100;
    }

    public final void setUserProfile(String r100) {
        this.userProfile = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeParcelable(this.profileFollowExtra, r101);
        r100.writeValue(this.sceneId);
        r100.writeValue(this.openId);
        r100.writeValue(this.aid);
        r100.writeString(this.userProfile);
        r100.writeValue(this.isLive);
        r100.writeValue(Boolean.valueOf(this.hideLongPressTab));
        r100.writeValue(Boolean.valueOf(this.uselessFollowChannel));
        r100.writeValue(Boolean.valueOf(this.isCardMode));
        r100.writeValue(this.actionType);
        r100.writeParcelable(this.hostEventParameters, r101);
        r100.writeString(this.hostCommonParams.toString());
        r100.writeString(this.hostExtraParams.toString());
        r100.writeValue(this.fromReqId);
        r100.writeValue(this.fromGroupId);
        r100.writeValue(Boolean.valueOf(this.hideRecently));
        r100.writeValue(Boolean.valueOf(this.clearTop));
    }
}
