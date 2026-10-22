package com.ss.android.downloadlib.runtime.impl;

import android.content.Context;
import com.ss.android.download.api.model.AppInfo;
import com.ss.android.download.api.runtime.IAdUserInfoProvider;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import t6.a;
import t6.b;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdUserInfoProviderImpl;", "Lcom/ss/android/download/api/runtime/IAdUserInfoProvider;", "Lcom/ss/android/download/api/model/AppInfo;", "getAppUserInfo", "", "getCurrentTelecomCarrier", "", "hasLogin", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lq6/a$a;", "callback", "", "login", "logout", "enableRuntime", "Z", "<init>", "(Z)V", "Companion", "download-impl_release"}, k = 1, mv = {1, 4, 0})
public final class AdUserInfoProviderImpl implements IAdUserInfoProvider {
    public static final Companion Companion = null;
    public static final String TAG = "AdHostUIProviderImpl";
    private final boolean enableRuntime;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdUserInfoProviderImpl$Companion;", "", "()V", "TAG", "", "download-impl_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.ss.android.download.api.runtime.IAdUserInfoProvider
    public String getCurrentTelecomCarrier() {
        if (this.enableRuntime == false) goto L7;
        TTDownloaderLogger.INSTANCE.innerLogD("AdHostUIProviderImpl", "getCurrentTelecomCarrier", "采用Runtime的能力,获取了宿主用户的相关信息,得知了手机运营商信息");
        b r100 = a.f544652a;
        q6.a r101 = (q6.a) a.C7690a.a(q6.a.class, null);
        if (r101 != null) goto L10;
        return null;
    L10:
        return r101.getCurrentTelecomCarrier();
    L7:
        TTDownloaderLogger.INSTANCE.innerLogE("AdHostUIProviderImpl", "getCurrentTelecomCarrier", "未采用Runtime能力,无法获取运营商信息");
        return null;
    }

    @Override // com.ss.android.download.api.runtime.IAdUserInfoProvider
    public boolean hasLogin() {
        if (this.enableRuntime == false) goto L7;
        TTDownloaderLogger.INSTANCE.innerLogD("AdHostUIProviderImpl", "hasLogin", "采用Runtime的能力,获取了宿主用户的相关信息,获取到当前用户是否登陆的信息");
        b r100 = a.f544652a;
        q6.a r101 = (q6.a) a.C7690a.a(q6.a.class, null);
        if (r101 != null) goto L10;
    L8:
        return false;
    L10:
        return r101.hasLogin();
    L7:
        TTDownloaderLogger.INSTANCE.innerLogE("AdHostUIProviderImpl", "hasLogin", "未采用Runtime的能力,无法获取用户是否登陆的状态");
        goto L8
    }

    @Override // com.ss.android.download.api.runtime.IAdUserInfoProvider
    public AppInfo getAppUserInfo() {
        AppInfo r100 = GlobalInfo.getAppInfo();
        if (this.enableRuntime == false) goto L7;
        b r101 = a.f544652a;
        q6.a r102 = (q6.a) a.C7690a.a(q6.a.class, null);
        if (r102 == null) goto L7;
        r102.b();
    L7:
        return r100;
    }

    public AdUserInfoProviderImpl(boolean r100) {
        this.enableRuntime = r100;
    }

    @Override // com.ss.android.download.api.runtime.IAdUserInfoProvider
    public void logout(Context r100) {
        if (this.enableRuntime == false) goto L8;
        TTDownloaderLogger r101 = TTDownloaderLogger.INSTANCE;
        r101.innerLogD("AdHostUIProviderImpl", "hasLogin", "采用Runtime的能力,获取了宿主用户的相关信息,执行登出操作");
        b r102 = a.f544652a;
        q6.a r103 = (q6.a) a.C7690a.a(q6.a.class, null);
        if (r103 == null) goto L7;
        r103.logout();
        return;
    L7:
        r101.innerLogE("AdHostUIProviderImpl", "login", "未注入Runtime能力,无法执行登出操作");
        return;
    L8:
        TTDownloaderLogger.INSTANCE.innerLogE("AdHostUIProviderImpl", "logout", "未采用Runtime的能力,无法执行登出操作");
    }

    @Override // com.ss.android.download.api.runtime.IAdUserInfoProvider
    public void login(Context r100, q6.a.InterfaceC7282a r101) {
        if (this.enableRuntime == false) goto L8;
        TTDownloaderLogger r102 = TTDownloaderLogger.INSTANCE;
        r102.innerLogD("AdHostUIProviderImpl", "login", "采用Runtime的能力,获取了宿主用户的相关信息,执行登陆操作");
        b r103 = a.f544652a;
        q6.a r104 = (q6.a) a.C7690a.a(q6.a.class, null);
        if (r104 == null) goto L7;
        r104.a();
        return;
    L7:
        r102.innerLogE("AdHostUIProviderImpl", "login", "未注入Runtime能力,无法执行登陆操作");
        return;
    L8:
        TTDownloaderLogger.INSTANCE.innerLogE("AdHostUIProviderImpl", "login", "未采用Runtime的能力,无法执行登陆操作");
    }
}
