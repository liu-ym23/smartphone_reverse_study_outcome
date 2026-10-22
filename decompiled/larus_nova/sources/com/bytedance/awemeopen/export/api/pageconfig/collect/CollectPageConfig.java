package com.bytedance.awemeopen.export.api.pageconfig.collect;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.HostEventParameters;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.ProfileFollowExtra;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\b:\u0010;B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b:\u0010<J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0012\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016¨\u0006?"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pageconfig/collect/CollectPageConfig;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "describeContents", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "profileFollowExtra", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "getProfileFollowExtra", "()Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "setProfileFollowExtra", "(Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;)V", "", "sceneId", "Ljava/lang/String;", "getSceneId", "()Ljava/lang/String;", "setSceneId", "(Ljava/lang/String;)V", "openId", "getOpenId", "setOpenId", "aid", "getAid", "setAid", "", "isLive", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "setLive", "(Ljava/lang/Boolean;)V", "hideLongPressTab", "Z", "getHideLongPressTab", "()Z", "setHideLongPressTab", "(Z)V", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;", "hostEventParameters", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;", "getHostEventParameters", "()Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;", "setHostEventParameters", "(Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;)V", "Lorg/json/JSONObject;", "hostCommonParams", "Lorg/json/JSONObject;", "getHostCommonParams", "()Lorg/json/JSONObject;", "setHostCommonParams", "(Lorg/json/JSONObject;)V", "fromReqId", "getFromReqId", "setFromReqId", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class CollectPageConfig implements Parcelable {
    public static final a CREATOR = null;
    private String aid;
    private String fromReqId;
    private boolean hideLongPressTab;
    private JSONObject hostCommonParams;
    private HostEventParameters hostEventParameters;
    private Boolean isLive;
    private String openId;
    private ProfileFollowExtra profileFollowExtra;
    private String sceneId;

    public static final class a implements Parcelable.Creator<CollectPageConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CollectPageConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new CollectPageConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final CollectPageConfig[] newArray(int r100) {
            return new CollectPageConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CollectPageConfig() {
        this.hostCommonParams = new JSONObject();
    }

    public final String getAid() {
        return this.aid;
    }

    public final String getFromReqId() {
        return this.fromReqId;
    }

    public final boolean getHideLongPressTab() {
        return this.hideLongPressTab;
    }

    public final JSONObject getHostCommonParams() {
        return this.hostCommonParams;
    }

    public final HostEventParameters getHostEventParameters() {
        return this.hostEventParameters;
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

    public final Boolean isLive() {
        return this.isLive;
    }

    public CollectPageConfig(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.profileFollowExtra = (ProfileFollowExtra) r100.readParcelable(ProfileFollowExtra.class.getClassLoader());
        this.sceneId = r100.readString();
        this.openId = r100.readString();
        this.aid = r100.readString();
        Object r101 = r100.readValue(Boolean.TYPE.getClassLoader());
        if ((r101 instanceof Boolean) == false) goto L5;
        Boolean r102 = (Boolean) r101;
    L6:
        this.isLive = r102;
        if (r100.readByte() == 0) goto L9;
        boolean r103 = true;
    L10:
        this.hideLongPressTab = r103;
        this.hostEventParameters = (HostEventParameters) r100.readParcelable(HostEventParameters.class.getClassLoader());
        String r104 = r100.readString();
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        this.hostCommonParams = new JSONObject(r104);
        this.fromReqId = r100.readString();
        return;
    L9:
        r103 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void setAid(String r100) {
        this.aid = r100;
    }

    public final void setFromReqId(String r100) {
        this.fromReqId = r100;
    }

    public final void setHideLongPressTab(boolean r100) {
        this.hideLongPressTab = r100;
    }

    public final void setHostCommonParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostCommonParams = r100;
    }

    public final void setHostEventParameters(HostEventParameters r100) {
        this.hostEventParameters = r100;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeParcelable(this.profileFollowExtra, r101);
        r100.writeString(this.sceneId);
        r100.writeString(this.openId);
        r100.writeString(this.aid);
        r100.writeValue(this.isLive);
        r100.writeByte(this.hideLongPressTab ? 1 : 0);
        r100.writeParcelable(this.hostEventParameters, r101);
        r100.writeString(this.hostCommonParams.toString());
        r100.writeString(this.fromReqId);
    }
}
