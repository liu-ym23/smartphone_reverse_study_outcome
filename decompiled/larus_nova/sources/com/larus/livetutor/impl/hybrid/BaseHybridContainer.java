package com.larus.livetutor.impl.hybrid;

import android.net.Uri;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.livetutor.impl.LiveTutorActivity;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000202H\u0016J\b\u00104\u001a\u000202H\u0016J\b\u00105\u001a\u000202H\u0016J\b\u00106\u001a\u000207H\u0016J\n\u00108\u001a\u0004\u0018\u000109H\u0016J\n\u0010:\u001a\u0004\u0018\u000109H\u0016J\b\u0010;\u001a\u000202H\u0016J\b\u0010<\u001a\u000202H\u0016J\u001a\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020\u00132\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0018\u0010A\u001a\u0002022\u0006\u0010>\u001a\u00020\u00132\u0006\u0010B\u001a\u00020CH\u0016J<\u0010D\u001a\u0002022\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010(\u001a\u0004\u0018\u00010\u001f2\u0014\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020G\u0018\u00010FH\u0016J\"\u0010H\u001a\u0002022\u0006\u0010I\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u00192\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u001a\u0010M\u001a\u0002022\u0006\u0010>\u001a\u00020\u00132\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J$\u0010N\u001a\u0002022\u0006\u0010>\u001a\u00020\u00132\b\u0010?\u001a\u0004\u0018\u00010@2\b\u0010O\u001a\u0004\u0018\u00010CH\u0016J\b\u0010P\u001a\u000202H\u0017J\b\u0010Q\u001a\u000202H\u0017J\b\u0010R\u001a\u000202H\u0017J\u0010\u0010S\u001a\u0002022\u0006\u0010T\u001a\u00020UH\u0016J\b\u0010V\u001a\u000207H\u0016J\u0006\u0010W\u001a\u000202J\b\u0010X\u001a\u000202H\u0016J\b\u0010Y\u001a\u000202H\u0016J\u0010\u0010Z\u001a\u0002022\u0006\u0010[\u001a\u000207H\u0016J\u001e\u0010\\\u001a\u0002022\u0014\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010G0^H\u0016J\b\u0010_\u001a\u000202H\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R$\u0010(\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R$\u0010+\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R$\u0010.\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001d¨\u0006`"}, d2 = {"Lcom/larus/livetutor/impl/hybrid/BaseHybridContainer;", "Landroidx/lifecycle/LifecycleObserver;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/livetutor/impl/LiveTutorActivity;", "<init>", "(Lcom/larus/livetutor/impl/LiveTutorActivity;)V", "getContext", "()Lcom/larus/livetutor/impl/LiveTutorActivity;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "handler$delegate", "Lkotlin/Lazy;", "lifeScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getLifeScope", "()Landroidx/lifecycle/LifecycleCoroutineScope;", "curPageUrl", "Landroid/net/Uri;", "getCurPageUrl", "()Landroid/net/Uri;", "setCurPageUrl", "(Landroid/net/Uri;)V", "themeRes", "", "getThemeRes", "()I", "setThemeRes", "(I)V", "value", "", "pageName", "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "enterFrom", "getEnterFrom", "setEnterFrom", "subPageName", "getSubPageName", "setSubPageName", "sessionID", "getSessionID", "setSessionID", "exposureSessionID", "getExposureSessionID", "setExposureSessionID", "preCreate", "", WidgetCostModule.TYPE_ON_CREATE, "initData", "initView", "initOuterContainer", "", "provideBulletContainer", "Landroid/view/ViewGroup;", "provideRootLayout", "onLoadModelSuccess", "onActivityLoadUri", "onLoadUriSuccess", "uri", "kitView", "Landroid/view/View;", "onLoadUriFail", "e", "", "updateTracker", "map", "", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onKitViewCreate", "onKitViewDestroy", LynxError.LYNX_THROWABLE, WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBackPressed", VideoEventOneOutSync.END_TYPE_FINISH, "onFinish", "preFinish", "onWindowFocusChanged", "hasFocus", "putBizTrackerCommonParams", "params", "", LiveCommonConstants.REASON_ON_DEDTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseHybridContainer implements LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveTutorActivity f356151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f356152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LifecycleCoroutineScope f356153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f356154d;

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.f356151a.getLifecycle().removeObserver(this);
        ((Handler) this.f356152b.getValue()).removeCallbacksAndMessages(null);
    }

    public final LiveTutorActivity getContext() {
        return this.f356151a;
    }

    public BaseHybridContainer(LiveTutorActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f356151a = r100;
        this.f356152b = LazyKt.lazy(new a());
        this.f356153c = LifecycleOwnerKt.getLifecycleScope(r100);
        this.f356154d = Uri.EMPTY;
        boolean r101 = UtilsKt.f356659a;
        UUID.randomUUID().toString();
        r100.getLifecycle().addObserver(this);
    }
}
