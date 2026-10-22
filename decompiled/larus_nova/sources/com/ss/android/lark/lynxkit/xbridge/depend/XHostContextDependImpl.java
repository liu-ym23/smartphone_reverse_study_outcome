package com.ss.android.lark.lynxkit.xbridge.depend;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend;
import com.larksuite.framework.utils.ApkUtil;
import com.ss.android.lark.component.appcontext.ILarkAppContext;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.component.appcontext.model.LarkBuildConfig;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import epb.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s56.b;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\b\u0010!\u001a\u00020\u0018H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0016J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0'H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\b\u00100\u001a\u00020,H\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u00061"}, d2 = {"Lcom/ss/android/lark/lynxkit/xbridge/depend/XHostContextDependImpl;", "Lcom/bytedance/ies/xbridge/base/runtime/depend/IHostContextDepend;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "appContext", "larkAppContext", "Lcom/ss/android/lark/component/appcontext/ILarkAppContext;", "getLarkAppContext", "()Lcom/ss/android/lark/component/appcontext/ILarkAppContext;", "buildConfig", "Lcom/ss/android/lark/component/appcontext/model/LarkBuildConfig;", "getBuildConfig", "()Lcom/ss/android/lark/component/appcontext/model/LarkBuildConfig;", "appIdInfo", "Lcom/ss/android/lark/component/appcontext/model/AppIdInfo;", "getAppIdInfo", "()Lcom/ss/android/lark/component/appcontext/model/AppIdInfo;", "getApplication", "Landroid/app/Application;", "getAppId", "", "getAppName", "", "getChannel", "getDeviceId", "getLanguage", "getVersionName", "getVersionCode", "", "getUpdateVersion", "getPackageName", "getBoeChannel", "getPPEChannel", "getCurrentTelcomCarrier", "getSkinName", "getSkinType", "getSettings", "", "Lcom/bytedance/ies/xbridge/base/runtime/model/SettingValueEntry;", "settingKeys", "Lcom/bytedance/ies/xbridge/base/runtime/model/SettingKeyEntry;", "isBaseMode", "", "isBoeEnable", "isDebuggable", "isPPEEnable", "isTeenMode", "lark-lynx-xbridge_chinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XHostContextDependImpl implements IHostContextDepend {
    private final Context appContext;

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public String getAppName() {
        return "feishu";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public String getBoeChannel() {
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public String getCurrentTelcomCarrier() {
        return null;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public String getPPEChannel() {
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public String getSkinName() {
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public String getSkinType() {
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public boolean isBaseMode() {
        return false;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public boolean isPPEEnable() {
        return false;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public boolean isTeenMode() {
        return false;
    }

    private final ILarkAppContext getLarkAppContext() {
        LarkAppContext.Companion.getClass();
        return LarkAppContext.access$getInstance$cp();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public String getChannel() {
        Bundle r100 = this.appContext.getPackageManager().getApplicationInfo(this.appContext.getPackageName(), 128).metaData;     // Catch: Throwable -> L10
        if (r100 == null) goto L13;
        String r101 = r100.getString("CHANNEL");     // Catch: Throwable -> L10
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L13:
        return "";
    L15:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public String getDeviceId() {
        return ((a) ApiUtils.getApi(a.class)).getDeviceIdFromLocal();
    L4:
        return "";
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public String getPackageName() {
        return this.appContext.getPackageName();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public String getUpdateVersion() {
        return String.valueOf(ApkUtil.getUpdateVersionCode(this.appContext));
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public long getVersionCode() {
        return ApkUtil.getAppVersionCode(this.appContext);
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public String getVersionName() {
        String r100 = ApkUtil.getAppVersionName(this.appContext);
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    private final b8b.a getAppIdInfo() {
        return getLarkAppContext().appIdInfo();
    }

    private final LarkBuildConfig getBuildConfig() {
        return getLarkAppContext().buildConfig();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public int getAppId() {
        return getAppIdInfo().f18218a;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public Application getApplication() {
        return getLarkAppContext().getContext();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public boolean isBoeEnable() {
        return getBuildConfig().getInHouse();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public boolean isDebuggable() {
        return getBuildConfig().getDebug();
    }

    public XHostContextDependImpl(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.appContext = r100.getApplicationContext();
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostContextDepend
    public List<b> getSettings(List<s56.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "settingKeys");
        return new ArrayList();
    }
}
