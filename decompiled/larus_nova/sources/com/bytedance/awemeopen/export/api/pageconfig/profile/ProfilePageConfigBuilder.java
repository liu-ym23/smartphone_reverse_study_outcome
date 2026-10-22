package com.bytedance.awemeopen.export.api.pageconfig.profile;

import com.bytedance.awemeopen.export.api.pageconfig.feedhome.HostEventParameters;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.ProfileFollowExtra;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 12\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b/\u00100J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0014\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0005J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020 J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020'R\u0018\u0010)\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010+R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010+R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010+R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010+R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010+R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010,R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010+R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010,R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010,R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010,R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010+R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010-R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010.R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010.R\u0016\u0010%\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010,¨\u00063"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pageconfig/profile/ProfilePageConfigBuilder;", "", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "followExtra", "withProfileFollowExtra", "", "hideLongPressTab", "withHideLongPressTab", "uselessFollowChannel", "withUselessFollowChannel", "isCardMode", "withCardMode", "", "openId", "withOpenId", "aid", "withAid", "fromReqId", "withFromReqId", "fromGroupId", "withFromGroupId", "userProfile", "withUserProfile", "isLiveType", "withIsLiveType", "sceneId", "withSceneId", ReportConstant.COMMON_ACTION_TYPE, "withActionType", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;", "hostEventParameters", "withHostEventParameters", "Lorg/json/JSONObject;", "hostCommonParams", "withHostCommonParams", "hostExtraParams", "withHostExtraParams", "hideRecently", "withHideRecently", "Lcom/bytedance/awemeopen/export/api/pageconfig/profile/ProfilePageConfig;", "build", "profileFollowExtra", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "Ljava/lang/String;", "Z", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;", "Lorg/json/JSONObject;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class ProfilePageConfigBuilder {
    public static final String CONFIG_KEY = "PROFILE_PAGE_CONFIG_CONFIG_KEY";
    public static final String CONFIG_KEY_BUNDLE = "PROFILE_PAGE_CONFIG_CONFIG_KEY_BUNDLE";
    public static final a Companion = null;
    private String actionType;
    private String aid;
    private String fromGroupId;
    private String fromReqId;
    private boolean hideLongPressTab;
    private boolean hideRecently;
    private JSONObject hostCommonParams;
    private HostEventParameters hostEventParameters;
    private JSONObject hostExtraParams;
    private boolean isCardMode;
    private boolean isLiveType;
    private String openId;
    private ProfileFollowExtra profileFollowExtra;
    private String sceneId;
    private boolean uselessFollowChannel;
    private String userProfile;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final ProfilePageConfigBuilder withCardMode(boolean r100) {
        return this;
    }

    public final ProfilePageConfig build() {
        ProfilePageConfig r100 = new ProfilePageConfig();
        r100.setProfileFollowExtra(this.profileFollowExtra);
        r100.setHideLongPressTab(this.hideLongPressTab);
        r100.setUselessFollowChannel(this.uselessFollowChannel);
        r100.setAid(this.aid);
        r100.setFromReqId(this.fromReqId);
        r100.setFromGroupId(this.fromGroupId);
        r100.setOpenId(this.openId);
        r100.setLive(Boolean.valueOf(this.isLiveType));
        r100.setSceneId(this.sceneId);
        r100.setUserProfile(this.userProfile);
        r100.setCardMode(this.isCardMode);
        r100.setActionType(this.actionType);
        r100.setHostEventParameters(this.hostEventParameters);
        r100.setHostCommonParams(this.hostCommonParams);
        r100.setHostExtraParams(this.hostExtraParams);
        r100.setHideRecently(this.hideRecently);
        return r100;
    }

    public ProfilePageConfigBuilder() {
        this.hostCommonParams = new JSONObject();
        this.hostExtraParams = new JSONObject();
    }

    public final ProfilePageConfigBuilder withActionType(String r100) {
        this.actionType = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withAid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        this.aid = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withFromGroupId(String r100) {
        this.fromGroupId = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withFromReqId(String r100) {
        this.fromReqId = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withHideLongPressTab(boolean r100) {
        this.hideLongPressTab = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withHideRecently(boolean r100) {
        this.hideRecently = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withHostCommonParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "hostCommonParams");
        this.hostCommonParams = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withHostEventParameters(HostEventParameters r100) {
        Intrinsics.checkNotNullParameter(r100, "hostEventParameters");
        this.hostEventParameters = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withHostExtraParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "hostExtraParams");
        this.hostExtraParams = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withIsLiveType(boolean r100) {
        this.isLiveType = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withOpenId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "openId");
        this.openId = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withProfileFollowExtra(ProfileFollowExtra r100) {
        this.profileFollowExtra = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withSceneId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        this.sceneId = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withUselessFollowChannel(boolean r100) {
        this.uselessFollowChannel = r100;
        return this;
    }

    public final ProfilePageConfigBuilder withUserProfile(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userProfile");
        this.userProfile = r100;
        return this;
    }
}
