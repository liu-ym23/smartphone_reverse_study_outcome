package com.ss.android.downloadlib.runtime.impl;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.heytap.mcssdk.constant.b;
import com.ss.android.download.api.runtime.IAdSDKMonitorProvider;
import com.ss.android.downloadlib.BuildConfig;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.downloadlib.utils.TTSlardarMonitor;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import l6.f;
import org.json.JSONObject;
import t6.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JR\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000fH\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J*\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J(\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J \u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdSDKMonitorProviderImpl;", "Lcom/ss/android/download/api/runtime/IAdSDKMonitorProvider;", "enableRuntime", "", "(Z)V", "runtimeMonitor", "Lcom/bytedance/framwork/core/sdkmonitor/SDKMonitor;", "registerSDKMonitor", "sdkAid", "", b.C, "", "extraHeads", "", "reportUrls", "", "configUrls", "ttMonitorDuration", "", "serviceName", "duration", "Lorg/json/JSONObject;", "logExtra", "ttMonitorEvent", "category", "metric", "ttMonitorStatusAndDuration", "status", "ttMonitorStatusRate", "Companion", "download-impl_release"}, k = 1, mv = {1, 1, 16})
public final class AdSDKMonitorProviderImpl implements IAdSDKMonitorProvider {
    public static final Companion Companion = null;
    public static final String TAG = "AdSDKMonitorProviderImpl";
    private static AtomicBoolean initialed;
    private final boolean enableRuntime;
    private SDKMonitor runtimeMonitor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/downloadlib/runtime/impl/AdSDKMonitorProviderImpl$Companion;", "", "()V", "TAG", "", "initialed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialed", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setInitialed", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "download-impl_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public final AtomicBoolean getInitialed() {
            return AdSDKMonitorProviderImpl.access$getInitialed$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void setInitialed(AtomicBoolean r100) {
            AdSDKMonitorProviderImpl.access$setInitialed$cp(r100);
        }
    }

    static {
        Companion = new Companion(null);
        initialed = new AtomicBoolean();
    }

    public static final /* synthetic */ AtomicBoolean access$getInitialed$cp() {
        return initialed;
    }

    public AdSDKMonitorProviderImpl(boolean r100) {
        this.enableRuntime = r100;
    }

    public static final /* synthetic */ void access$setInitialed$cp(AtomicBoolean r100) {
        initialed = r100;
    }

    @Override // com.ss.android.download.api.runtime.IAdSDKMonitorProvider
    public void ttMonitorDuration(String r110, JSONObject r111, JSONObject r112) {
        if (this.enableRuntime == true) goto L5;
        TTSlardarMonitor.getInstance().monitorDuration(r110, r111, r112, true);
        return;
    L5:
        if (initialed.get() == false) goto L7;
    L9:
        SDKMonitor r100 = this.runtimeMonitor;
        if (r100 == null) goto L12;
        r100.monitorDuration(r110, r111, r112);
        return;
    L12:
        TTSlardarMonitor.getInstance().monitorDuration(r110, r111, r112, false);
        return;
    L7:
        if (this.runtimeMonitor != null) goto L9;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "ttMonitorDuration", "执行事件时发现还没有初始化,重新进行初始化,只有接入Runtime的场景需要类似逻辑");
        registerSDKMonitor(6103, BuildConfig.SDK_VERSION_NAME, null, null, null);
        goto L9
    }

    @Override // com.ss.android.download.api.runtime.IAdSDKMonitorProvider
    public void ttMonitorStatusRate(String r110, int r111, JSONObject r112) {
        if (this.enableRuntime == true) goto L5;
        TTSlardarMonitor.getInstance().monitorStatusRate(r110, r111, r112, true);
        return;
    L5:
        if (initialed.get() == false) goto L7;
    L9:
        SDKMonitor r100 = this.runtimeMonitor;
        if (r100 == null) goto L12;
        r100.monitorStatusRate(r110, r111, r112);
        return;
    L12:
        TTSlardarMonitor.getInstance().monitorStatusRate(r110, r111, r112, false);
        return;
    L7:
        if (this.runtimeMonitor != null) goto L9;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "ttMonitorStatusRate", "执行事件时发现还没有初始化,重新进行初始化,只有接入Runtime的场景需要类似逻辑");
        registerSDKMonitor(6103, BuildConfig.SDK_VERSION_NAME, null, null, null);
        goto L9
    }

    @Override // com.ss.android.download.api.runtime.IAdSDKMonitorProvider
    public void ttMonitorEvent(String r110, JSONObject r111, JSONObject r112, JSONObject r113) {
        if (this.enableRuntime == true) goto L5;
        TTSlardarMonitor.getInstance().ttMonitorEvent(r110, r111, r112, r113, true);
        return;
    L5:
        if (initialed.get() == true) goto L7;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "ttMonitorEvent", "发送埋点时发现还没有初始化,重新进行初始化,只有接入Runtime的场景需要类似逻辑");
        registerSDKMonitor(6103, BuildConfig.SDK_VERSION_NAME, null, null, null);
    L7:
        TTSlardarMonitor.getInstance().ttMonitorEvent(r110, r111, r112, r113, false);
    }

    @Override // com.ss.android.download.api.runtime.IAdSDKMonitorProvider
    public void ttMonitorStatusAndDuration(String r110, int r111, JSONObject r112, JSONObject r113) {
        if (this.enableRuntime == true) goto L5;
        TTSlardarMonitor.getInstance().monitorStatusAndDuration(r110, r111, r112, r113, true);
        return;
    L5:
        if (initialed.get() == false) goto L7;
    L9:
        SDKMonitor r100 = this.runtimeMonitor;
        if (r100 == null) goto L12;
        r100.monitorStatusAndDuration(r110, r111, r112, r113);
        return;
    L12:
        TTSlardarMonitor.getInstance().monitorStatusAndDuration(r110, r111, r112, r113, false);
        return;
    L7:
        if (this.runtimeMonitor != null) goto L9;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "ttMonitorStatusAndDuration", "执行事件时发现还没有初始化,重新进行初始化,只有接入Runtime的场景需要类似逻辑");
        registerSDKMonitor(6103, BuildConfig.SDK_VERSION_NAME, null, null, null);
        goto L9
    }

    @Override // com.ss.android.download.api.runtime.IAdSDKMonitorProvider
    public SDKMonitor registerSDKMonitor(int r100, String r101, Map<String, String> r102, List<String> r103, List<String> r104) {
        SDKMonitor r105 = null;
        if (this.enableRuntime == false) goto L13;
        if (initialed.get() == true) goto L7;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "registerSDKMonitor", "采用Runtime提供的能力对Slardar进行初始化");
        initialed.set(true);
    L7:
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "registerSDKMonitor", "测试:5.2.4,5020490,5.2.4");
        t6.b r106 = a.f544652a;
        f r107 = (f) a.C7690a.a(f.class, null);
        if (r107 == null) goto L10;
        r105 = r107.a();
    L10:
        this.runtimeMonitor = r105;
        return r105;
    L13:
        if (initialed.get() == true) goto L15;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "registerSDKMonitor", "未采用Runtime能力,由TTDownloader本地进行Slardar能力的初始化");
        TTSlardarMonitor.getInstance().checkInit();
        initialed.set(true);
    L15:
        return null;
    }
}
