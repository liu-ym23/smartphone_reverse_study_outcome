package com.larus.live.impl.ttlivesdk;

import android.app.Application;
import android.content.Context;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.larus.common.apphost.AppHost;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class p implements IHostContextDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend f355863a;

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final int getAppId() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getAppId();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final String getAppName() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 == null) goto L6;
        String r101 = r100.getAppName();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final Application getApplication() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 == null) goto L7;
        Application r101 = r100.getApplication();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return AppHost.f326268a.getApplication();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final String getBoeChannel() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 == null) goto L6;
        String r101 = r100.getBoeChannel();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final String getChannel() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 == null) goto L6;
        String r101 = r100.getChannel();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final String getCurrentTelcomCarrier() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentTelcomCarrier();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final String getDeviceId() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 == null) goto L6;
        String r101 = r100.getDeviceId();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final String getLanguage() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 == null) goto L6;
        String r101 = r100.getLanguage();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final String getPPEChannel() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 == null) goto L6;
        String r101 = r100.getPPEChannel();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final String getPackageName() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 == null) goto L6;
        String r101 = r100.getPackageName();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final String getSkinName() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 == null) goto L6;
        String r101 = r100.getSkinName();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final String getSkinType() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 == null) goto L6;
        String r101 = r100.getSkinType();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final String getUpdateVersion() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 == null) goto L6;
        String r101 = r100.getUpdateVersion();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final long getVersionCode() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getVersionCode();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final String getVersionName() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 == null) goto L6;
        String r101 = r100.getVersionName();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final boolean isBaseMode() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 != null) goto L7;
        return true;
    L7:
        return r100.isBaseMode();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final boolean isBoeEnable() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isBoeEnable();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final boolean isDebuggable() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isDebuggable();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final boolean isPPEEnable() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isPPEEnable();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final boolean isTeenMode() {
        com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend r100 = this.f355863a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isTeenMode();
    }

    public p() {
        XBaseRuntime.f270095a.getClass();
        this.f355863a = XBaseRuntime.f270100f;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public final List<s56.b> getSettings(List<s56.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "settingKeys");
        return CollectionsKt.emptyList();
    }
}
