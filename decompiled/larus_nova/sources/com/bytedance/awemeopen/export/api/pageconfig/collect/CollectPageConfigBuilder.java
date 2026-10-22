package com.bytedance.awemeopen.export.api.pageconfig.collect;

import com.bytedance.awemeopen.export.api.pageconfig.feedhome.HostEventParameters;
import com.bytedance.awemeopen.export.api.pageconfig.feedhome.ProfileFollowExtra;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0019R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u001dR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u001dR\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001eR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001fR\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010 R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001d¨\u0006%"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pageconfig/collect/CollectPageConfigBuilder;", "", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "followExtra", "withProfileFollowExtra", "", "hideLongPressTab", "withHideLongPressTab", "", "openId", "withOpenId", "aid", "withAid", "isLiveType", "withIsLiveType", "sceneId", "withSceneId", "fromReqId", "withFromReqId", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;", "hostEventParameters", "withHostEventParameters", "Lorg/json/JSONObject;", "hostCommonParams", "withHostCommonParams", "Lcom/bytedance/awemeopen/export/api/pageconfig/collect/CollectPageConfig;", "build", "profileFollowExtra", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/ProfileFollowExtra;", "Ljava/lang/String;", "Z", "Lcom/bytedance/awemeopen/export/api/pageconfig/feedhome/HostEventParameters;", "Lorg/json/JSONObject;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1})
public final class CollectPageConfigBuilder {
    public static final String CONFIG_KEY = "COLLECT_PAGE_CONFIG_CONFIG_KEY";
    public static final a Companion = null;
    private String aid;
    private String fromReqId;
    private boolean hideLongPressTab;
    private JSONObject hostCommonParams;
    private HostEventParameters hostEventParameters;
    private boolean isLiveType;
    private String openId;
    private ProfileFollowExtra profileFollowExtra;
    private String sceneId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final CollectPageConfig build() {
        CollectPageConfig r100 = new CollectPageConfig();
        r100.setProfileFollowExtra(this.profileFollowExtra);
        r100.setHideLongPressTab(this.hideLongPressTab);
        r100.setAid(this.aid);
        r100.setOpenId(this.openId);
        r100.setLive(Boolean.valueOf(this.isLiveType));
        r100.setSceneId(this.sceneId);
        r100.setHostEventParameters(this.hostEventParameters);
        r100.setHostCommonParams(this.hostCommonParams);
        r100.setFromReqId(this.fromReqId);
        return r100;
    }

    public CollectPageConfigBuilder() {
        this.hostCommonParams = new JSONObject();
    }

    public final CollectPageConfigBuilder withAid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "aid");
        this.aid = r100;
        return this;
    }

    public final CollectPageConfigBuilder withFromReqId(String r100) {
        this.fromReqId = r100;
        return this;
    }

    public final CollectPageConfigBuilder withHideLongPressTab(boolean r100) {
        this.hideLongPressTab = r100;
        return this;
    }

    public final CollectPageConfigBuilder withHostCommonParams(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "hostCommonParams");
        this.hostCommonParams = r100;
        return this;
    }

    public final CollectPageConfigBuilder withHostEventParameters(HostEventParameters r100) {
        Intrinsics.checkNotNullParameter(r100, "hostEventParameters");
        this.hostEventParameters = r100;
        return this;
    }

    public final CollectPageConfigBuilder withIsLiveType(boolean r100) {
        this.isLiveType = r100;
        return this;
    }

    public final CollectPageConfigBuilder withOpenId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "openId");
        this.openId = r100;
        return this;
    }

    public final CollectPageConfigBuilder withProfileFollowExtra(ProfileFollowExtra r100) {
        this.profileFollowExtra = r100;
        return this;
    }

    public final CollectPageConfigBuilder withSceneId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneId");
        this.sceneId = r100;
        return this;
    }
}
