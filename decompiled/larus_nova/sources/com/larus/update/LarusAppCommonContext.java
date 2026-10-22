package com.larus.update;

import android.content.Context;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016¨\u0006\u001b"}, d2 = {"Lcom/larus/update/LarusAppCommonContext;", "Lcom/bytedance/services/app/common/context/api/AppCommonContext;", "<init>", "()V", "getContext", "Landroid/content/Context;", "getStringAppName", "", "getAppName", "getVersion", "getFeedbackAppKey", "getChannel", "getTweakedChannel", "getVersionCode", "", "getDeviceId", "getUpdateVersionCode", "getManifestVersionCode", "getManifestVersion", "getAid", "getSdkAppId", "getAbClient", "getAbFlag", "", "getAbVersion", "getAbGroup", "getAbFeature", "bits-impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarusAppCommonContext implements AppCommonContext {
    public LarusAppCommonContext() {
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getAbClient() {
        return "";
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getAbFeature() {
        return "";
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public long getAbFlag() {
        return 0;
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getAbGroup() {
        return "";
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getAbVersion() {
        return "";
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getFeedbackAppKey() {
        return "";
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public int getAid() {
        return AppHost.f326268a.getAppId();
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getAppName() {
        return AppHost.f326268a.getAppName();
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getChannel() {
        return AppHost.f326268a.getBuildChannel();
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public Context getContext() {
        return AppHost.f326268a.getApplication();
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getDeviceId() {
        return IApplog.f287053a.getDeviceId();
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getManifestVersion() {
        return AppHost.f326268a.getManifestVersionName();
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public int getManifestVersionCode() {
        return AppHost.f326268a.getManifestVersionCode();
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getSdkAppId() {
        return String.valueOf(AppHost.f326268a.getAppId());
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getStringAppName() {
        return AppHost.f326268a.getAppStringName();
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getTweakedChannel() {
        return AppHost.f326268a.getBuildChannel();
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public int getUpdateVersionCode() {
        return AppHost.f326268a.getUpdateVersionCode();
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public String getVersion() {
        return AppHost.f326268a.getVersionName();
    }

    @Override // com.bytedance.services.app.common.context.api.AppCommonContext
    public int getVersionCode() {
        return AppHost.f326268a.getVersionCode();
    }
}
