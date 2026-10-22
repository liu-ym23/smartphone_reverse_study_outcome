package com.larus.audio.report;

import android.app.Application;
import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.larus.audio.audiov3.report.IAudioEventCommonParams;
import com.larus.audio.audiov3.util.IAudioDeviceHelper;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.c1;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.o;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0014\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006!"}, d2 = {"Lcom/larus/audio/report/AudioEventCommonParamsServiceImpl;", "Lcom/larus/audio/audiov3/report/IAudioEventCommonParams;", "<init>", "()V", "appContext", "Landroid/app/Application;", "enabled", "", "registered", "cachedInfo", "Lcom/larus/audio/audiov3/util/IAudioDeviceHelper$DeviceInfo;", "lastScreenReaderEnabled", "Ljava/lang/Boolean;", "audioDeviceCallback", "Landroid/media/AudioDeviceCallback;", "getAudioDeviceCallback", "()Landroid/media/AudioDeviceCallback;", "audioDeviceCallback$delegate", "Lkotlin/Lazy;", "appBackgroundListener", "com/larus/audio/report/AudioEventCommonParamsServiceImpl$appBackgroundListener$1", "Lcom/larus/audio/report/AudioEventCommonParamsServiceImpl$appBackgroundListener$1;", "updateInfo", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enable", "disable", "updateParamsWhenAppForeground", "currentInfo", "initListener", "application", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioEventCommonParamsServiceImpl implements IAudioEventCommonParams {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f289797g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f289798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f289799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f289800c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile IAudioDeviceHelper.a f289801d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Boolean f289802e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f289803f;

    public static final class a {
    }

    public static final class b implements f09.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioEventCommonParamsServiceImpl f289804a;

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
        }

        @Override // f09.a.b
        public final void onAppForeground() {
            AudioEventCommonParamsServiceImpl r100 = this.f289804a;
            int r101 = AudioEventCommonParamsServiceImpl.f289797g;
            r100.e();
        }

        public b(AudioEventCommonParamsServiceImpl r100) {
            this.f289804a = r100;
        }
    }

    public static final class c extends AudioDeviceCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioEventCommonParamsServiceImpl f289805a;

        public c(AudioEventCommonParamsServiceImpl r100) {
            this.f289805a = r100;
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesAdded(AudioDeviceInfo[] r100) {
            super.onAudioDevicesAdded(r100);
            AudioEventCommonParamsServiceImpl r101 = this.f289805a;
            Application r102 = r101.f289798a;
            if (r102 == null) goto L6;
            r101.d(r102);
            return;
        }

        @Override // android.media.AudioDeviceCallback
        public final void onAudioDevicesRemoved(AudioDeviceInfo[] r100) {
            super.onAudioDevicesRemoved(r100);
            AudioEventCommonParamsServiceImpl r101 = this.f289805a;
            Application r102 = r101.f289798a;
            if (r102 == null) goto L6;
            r101.d(r102);
            return;
        }
    }

    static {
    }

    @Override // com.larus.audio.audiov3.report.IAudioEventCommonParams
    public final IAudioDeviceHelper.a a() {
        if (this.f289799b == true) goto L7;
        return null;
    L7:
        if (this.f289801d != null) goto L21;
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (this.f289801d != null) goto L14;
        Application r100 = this.f289798a;     // Catch: Throwable -> L17
        if (r100 == null) goto L14;
        d(r100);     // Catch: Throwable -> L17
    L14:
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(this);
    L21:
        return this.f289801d;
    }

    @Override // com.larus.audio.audiov3.report.IAudioEventCommonParams
    public final void disable() {
        if (this.f289799b == false) goto L6;
        this.f289799b = false;
        o r100 = o.f365780a;
        r100.c("input_device", new f());
        r100.c("output_device", new f());
        r100.c("bluetooth_device_name", new f());
        return;
    }

    public final void e() {
        IFlowSdkDepend r100 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r100 == null) goto L7;
        r100.S();
        boolean r101 = true;
        if (c1.f346148a.a() != true) goto L7;
    L9:
        if (Intrinsics.areEqual(this.f289802e, Boolean.valueOf(r101)) == false) goto L11;
        return;
    L11:
        this.f289802e = Boolean.valueOf(r101);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AudioEventCommonParamsServiceImpl$updateParamsWhenAppForeground$1(r101, null), 2, null);
        return;
    L7:
        r101 = false;
        goto L9
    }

    public AudioEventCommonParamsServiceImpl() {
        this.f289803f = LazyKt.lazy(new e(this));
        b r100 = new b(this);
        if (z2.f365865a.enableBluetoothDevicesReportEvent() == false) goto L5;
        c(null);
    L5:
        AppHost.f326268a.a().j(r100);
        e();
    }

    @Override // com.larus.audio.audiov3.report.IAudioEventCommonParams
    public final void b(Application r100) {
        if (z2.f365865a.enableBluetoothDevicesReportEvent() == true) goto L7;
        FLogger.f375446a.w("AudioInfoCommonParams", "disabled by config");
        this.f289799b = false;
        return;
    L7:
        if (this.f289800c == true) goto L10;
        this.f289798a = r100;
        c(r100);
    L10:
        if (this.f289799b == true) goto L13;
        o r101 = o.f365780a;
        r101.c("input_device", new com.larus.audio.report.b(this));
        r101.c("output_device", new com.larus.audio.report.c(this));
        r101.c("bluetooth_device_name", new d(this));
        this.f289799b = true;
        return;
    }

    public final void c(Application r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L25
        if (z2.f365865a.enableBluetoothDevicesReportEvent() == true) goto L5;
    L23:
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L35;
        FLogger.f375446a.e("AudioInfoCommonParams", "init error: " + r103.getMessage());
        return;
    L35:
        return;
    L5:
        if (r100 == null) goto L33;
    L16:
        this.f289798a = r100;     // Catch: Throwable -> L25
        if (Build.VERSION.SDK_INT < 23) goto L23;
        Object r104 = r100.getSystemService("audio");     // Catch: Throwable -> L25
        if ((r104 instanceof AudioManager) == false) goto L21;
        AudioManager r105 = (AudioManager) r104;     // Catch: Throwable -> L25
    L22:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AudioEventCommonParamsServiceImpl$initListener$1$1(r105, this, null), 3, null);     // Catch: Throwable -> L25
        this.f289800c = true;     // Catch: Throwable -> L25
        goto L23
    L21:
        r105 = null;
        goto L22
    L33:
        Object r106 = Result.m9449constructorimpl(AppHost.f326268a.getApplication());     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r106) == false) goto L13;
        r106 = null;
    L13:
        r100 = (Application) r106;     // Catch: Throwable -> L25
        if (r100 != null) goto L16;
        return;
    L8:
        th = move-exception;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L25
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    }

    public final void d(Context r100) {
        IAudioDeviceHelper r101 = (IAudioDeviceHelper) ServiceManager.get().getService(IAudioDeviceHelper.class);
        if (r101 != null) goto L5;
        return;
    L5:
        this.f289801d = r101.a(r100);
    }
}
