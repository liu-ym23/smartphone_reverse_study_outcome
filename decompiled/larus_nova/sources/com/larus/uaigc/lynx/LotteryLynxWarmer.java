package com.larus.uaigc.lynx;

import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.e4;
import com.larus.platform.service.c1;
import com.larus.utils.lifecycle.SafeLifecycleObserver;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J\f\u0010\u001d\u001a\u00020\u0016*\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/uaigc/lynx/LotteryLynxWarmer;", "Lcom/larus/utils/lifecycle/SafeLifecycleObserver;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activity", "Landroid/app/Activity;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlinx/coroutines/CoroutineScope;Landroid/app/Activity;)V", "warmUpIvyPluginView", "Lcom/larus/platform/api/IvyPluginView;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "warmUpLynxView", "", LiveCommonConstants.REASON_ON_DEDTROY, "owner", "Landroidx/lifecycle/LifecycleOwner;", "releaseIvyPluginView", "createIvyPluginView", "lynxUrl", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createIvyPluginViewLifeCycle", "Lcom/larus/platform/api/IvyPluginViewLifeCycle;", "releaseSignal", "Lkotlinx/coroutines/CompletableDeferred;", "", "convertToActualUrl", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LotteryLynxWarmer extends SafeLifecycleObserver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f373485b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e4 f373486a;

    public static final class a {
    }

    static {
    }

    public final void d() {
        FLogger.f375446a.i("LotteryLynxWarmer", "releaseIvyPluginView triggered");
        e4 r100 = this.f373486a;
        if (r100 == null) goto L16;
        View r101 = r100.getView();
        if (r101 == null) goto L7;
        ViewParent r102 = r101.getParent();
    L9:
        if ((r102 instanceof ViewGroup) == false) goto L11;
        ViewGroup r103 = (ViewGroup) r102;
    L12:
        if (r103 == null) goto L14;
        r103.removeView(r101);
    L14:
        this.f373486a = null;
        return;
    L11:
        r103 = null;
        goto L12
    L7:
        r102 = null;
        goto L9
    }

    @Override // com.larus.utils.lifecycle.SafeLifecycleObserver, androidx.lifecycle.DefaultLifecycleObserver
    public final void onDestroy(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        d();
    }

    public static final Object c(LotteryLynxWarmer r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof LotteryLynxWarmer$createIvyPluginView$1) == false) goto L7;
        LotteryLynxWarmer$createIvyPluginView$1 r103 = (LotteryLynxWarmer$createIvyPluginView$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        e4 r108 = (e4) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L21:
        if (((Boolean) r105).booleanValue() == false) goto L24;
        return r108;
    L24:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        FLogger.f375446a.i("LotteryLynxWarmer", "createIvyPluginView, lynxUrl: " + r101);
        c1 r109 = c1.f365723a;
        if (r109.d() == true) goto L17;
        r109.f();
    L17:
        Application r110 = AppHost.f326268a.getApplication();
        CompletableDeferred r111 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        r108 = r109.g(r110, r101, "", new b(r111));
        r103.L$0 = r108;
        r103.label = 1;
        r105 = r111.await(r103);
        if (r105 != r106) goto L21;
        return r106;
    L7:
        r103 = new LotteryLynxWarmer$createIvyPluginView$1(r100, r102);
        goto L8
    }
}
