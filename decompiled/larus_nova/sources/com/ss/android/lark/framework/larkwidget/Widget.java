package com.ss.android.lark.framework.larkwidget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010)\u001a\u00020\u0012H&J\u000f\u0010*\u001a\u0004\u0018\u00010+H\u0017¢\u0006\u0002\u0010,J\u0012\u0010-\u001a\u0004\u0018\u00010\u001d2\u0006\u0010.\u001a\u00020\u0017H\u0016J\b\u00103\u001a\u000204H\u0017J\b\u00105\u001a\u000204H\u0017J\b\u00106\u001a\u000204H\u0017J\b\u00107\u001a\u000204H\u0017J\b\u00108\u001a\u000204H\u0017J\b\u00109\u001a\u000204H\u0017J\u001e\u0010:\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020=0<\u0012\u0004\u0012\u00020=\u0018\u00010;H\u0016J\u001c\u0010>\u001a\u0004\u0018\u0001H?\"\n\b\u0000\u0010?\u0018\u0001*\u00020=H\u0087\b¢\u0006\u0002\u0010@J)\u0010>\u001a\u0004\u0018\u0001H?\"\b\b\u0000\u0010?*\u00020=2\u000e\u0010A\u001a\n\u0012\u0006\b\u0001\u0012\u00020=0<H\u0017¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u0002042\u0006\u0010F\u001a\u00020+H\u0004J\u001a\u0010E\u001a\u0002042\u0006\u0010F\u001a\u00020+2\b\u0010G\u001a\u0004\u0018\u00010HH\u0004J\b\u0010I\u001a\u000204H\u0004J\b\u0010J\u001a\u00020\u0012H\u0016J\u0010\u0010K\u001a\u0002042\u0006\u0010L\u001a\u00020MH\u0004J\u0018\u0010N\u001a\u0002042\u0006\u0010L\u001a\u00020M2\u0006\u0010O\u001a\u00020PH\u0004J\u0016\u0010Q\u001a\u0002042\f\u0010R\u001a\b\u0012\u0004\u0012\u0002040SH\u0004J\u0016\u0010T\u001a\u0002042\f\u0010R\u001a\b\u0012\u0004\u0012\u0002040SH\u0004J!\u0010U\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020\u001d2\b\b\u0001\u0010V\u001a\u00020+H\u0004¢\u0006\u0002\u0010WJ\"\u0010X\u001a\b\u0012\u0004\u0012\u0002H?0Y\"\b\b\u0000\u0010?*\u00020\u001d2\b\b\u0001\u0010V\u001a\u00020+H\u0004J\n\u0010Z\u001a\u0004\u0018\u00010[H\u0004J\u0006\u0010\\\u001a\u00020[J\n\u0010]\u001a\u0004\u0018\u00010^H\u0004J\b\u0010_\u001a\u00020^H\u0004J\n\u0010`\u001a\u0004\u0018\u00010aH\u0004J\u0010\u0010b\u001a\u0002042\u0006\u0010c\u001a\u00020HH\u0004J\u001a\u0010b\u001a\u0002042\u0006\u0010c\u001a\u00020H2\b\u0010d\u001a\u0004\u0018\u00010eH\u0004J\u0018\u0010f\u001a\u0002042\u0006\u0010c\u001a\u00020H2\u0006\u0010g\u001a\u00020+H\u0004J\"\u0010f\u001a\u0002042\u0006\u0010c\u001a\u00020H2\u0006\u0010g\u001a\u00020+2\b\u0010d\u001a\u0004\u0018\u00010eH\u0004J%\u0010h\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<H\u0004¢\u0006\u0002\u0010jJ-\u0010h\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\u0006\u0010k\u001a\u00020l2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<H\u0004¢\u0006\u0002\u0010mJ-\u0010h\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<2\u0006\u0010n\u001a\u00020oH\u0004¢\u0006\u0002\u0010pJ5\u0010h\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\u0006\u0010k\u001a\u00020l2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<2\u0006\u0010n\u001a\u00020oH\u0004¢\u0006\u0002\u0010qJ%\u0010r\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<H\u0004¢\u0006\u0002\u0010jJ-\u0010r\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\u0006\u0010k\u001a\u00020l2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<H\u0004¢\u0006\u0002\u0010mJ-\u0010r\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<2\u0006\u0010n\u001a\u00020oH\u0004¢\u0006\u0002\u0010pJ5\u0010r\u001a\u0002H?\"\b\b\u0000\u0010?*\u00020i2\u0006\u0010k\u001a\u00020l2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H?0<2\u0006\u0010n\u001a\u00020oH\u0004¢\u0006\u0002\u0010qJ\"\u0010s\u001a\u0002042\u0006\u0010g\u001a\u00020+2\u0006\u0010F\u001a\u00020+2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010t\u001a\u0002042\u0006\u0010u\u001a\u00020vH\u0016J\u0011\u0010{\u001a\u00020\u0012*\u00020|H\u0000¢\u0006\u0002\b}R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u000200X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0014\u0010w\u001a\u00020x8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\by\u0010z¨\u0006~"}, d2 = {"Lcom/ss/android/lark/framework/larkwidget/Widget;", "Landroidx/lifecycle/LifecycleOwner;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "widgetContext", "Lcom/ss/android/lark/framework/larkwidget/WidgetContext;", "getWidgetContext$lark_widget_release", "()Lcom/ss/android/lark/framework/larkwidget/WidgetContext;", "setWidgetContext$lark_widget_release", "(Lcom/ss/android/lark/framework/larkwidget/WidgetContext;)V", "mainThreadHandler", "Landroid/os/Handler;", "getMainThreadHandler", "()Landroid/os/Handler;", "mainThreadHandler$delegate", "Lkotlin/Lazy;", "isActive", "", "()Z", "setActive", "(Z)V", "containerView", "Landroid/view/ViewGroup;", "getContainerView", "()Landroid/view/ViewGroup;", "setContainerView", "(Landroid/view/ViewGroup;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "widgetCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "hasView", "getLayoutResId", "", "()Ljava/lang/Integer;", "getLayoutView", "parent", "lifecycleObserver", "Landroidx/lifecycle/DefaultLifecycleObserver;", "getLifecycleObserver$lark_widget_release", "()Landroidx/lifecycle/DefaultLifecycleObserver;", WidgetCostModule.TYPE_ON_CREATE, "", WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "provideWidgetExport", "", "Ljava/lang/Class;", "Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "getWidgetExport", ExifInterface.GPS_DIRECTION_TRUE, "()Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "clazz", "(Ljava/lang/Class;)Lcom/ss/android/lark/framework/larkwidget/WidgetExport;", "getSharedData", "Lcom/ss/android/lark/framework/larkwidget/WidgetSharedData;", "setResult", "resultCode", "data", "Landroid/content/Intent;", VideoEventOneOutSync.END_TYPE_FINISH, "onBackPressed", UGCMonitor.TYPE_POST, "runnable", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "runSafely", "block", "Lkotlin/Function0;", "runSafelyOnUI", "findViewById", "id", "(I)Landroid/view/View;", "lazyFindView", "Lkotlin/Lazy;", "getHostContext", "Landroid/content/Context;", "requireHostContext", "getActivity", "Landroid/app/Activity;", "requireActivity", "getWidgetHostFragment", "Landroidx/fragment/app/Fragment;", "startActivity", "intent", "options", "Landroid/os/Bundle;", "startActivityForResult", "requestCode", "getViewModel", "Landroidx/lifecycle/ViewModel;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "key", "", "(Ljava/lang/String;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "factory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Ljava/lang/Class;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/ViewModelProvider$Factory;)Landroidx/lifecycle/ViewModel;", "getActivityViewModel", "onActivityResult", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "isMainThread", "Ljava/lang/Thread;", "isMainThread$lark_widget_release", "lark-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Widget implements LifecycleOwner, CoroutineScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f425736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f425737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f425738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f425739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f425740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineContext f425741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LifecycleRegistry f425742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Widget$lifecycleObserver$1 f425743h;

    public void onCreate() {
        this.f425738c = true;
        LifecycleRegistry r100 = new LifecycleRegistry(this);
        this.f425742g = r100;
        r100.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public void onDestroy() {
        this.f425738c = false;
        LifecycleRegistry r100 = null;
        ((Handler) this.f425737b.getValue()).removeCallbacksAndMessages(null);
        JobKt.cancel$default(getCoroutineContext(), null, 1, null);
        LifecycleRegistry r101 = this.f425742g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
    L6:
        r100.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        return;
    L5:
        r100 = r101;
        goto L6
    }

    public Integer r0() {
        return null;
    }

    public void s0(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
    }

    public abstract boolean v0();

    public void w0(int r100, int r101, Intent r102) {
    }

    public void y0(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    public Map<Class<? extends c>, c> z0() {
        return null;
    }

    public final Context B0() {
        b r100 = this.f425736a;
        if (r100 == null) goto L5;
        Context r101 = r100.getContext();
    L6:
        if (r101 == null) goto L9;
        return r101;
    L9:
        throw new IllegalArgumentException("Required value was null.".toString());
    L5:
        r101 = null;
        goto L6
    }

    public final Activity getActivity() {
        b r100 = this.f425736a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getActivity();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        LifecycleRegistry r100 = this.f425742g;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        return null;
    L6:
        return r100;
    }

    public void onPause() {
        LifecycleRegistry r100 = this.f425742g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r100 = null;
    L5:
        r100.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    public void onResume() {
        LifecycleRegistry r100 = this.f425742g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r100 = null;
    L5:
        r100.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    public void onStart() {
        LifecycleRegistry r100 = this.f425742g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r100 = null;
    L5:
        r100.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    public void onStop() {
        LifecycleRegistry r100 = this.f425742g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("lifecycleRegistry");
        r100 = null;
    L5:
        r100.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.lark.framework.larkwidget.Widget$lifecycleObserver$1] */
    public Widget() {
        this.f425737b = LazyKt.lazy(Widget$mainThreadHandler$2.INSTANCE);
        this.f425741f = SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate());
        this.f425743h = new Widget$lifecycleObserver$1(this);
    }

    public final Activity A0() {
        Activity r100 = getActivity();
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f425741f;
    }

    public final void setResult(int r100) {
        b r101 = this.f425736a;
        Activity r102 = null;
        if (r101 == null) goto L5;
        Context r103 = r101.getContext();
    L7:
        if ((r103 instanceof Activity) == false) goto L9;
        r102 = (Activity) r103;
    L9:
        if (r102 == null) goto L12;
        r102.setResult(r100);
        return;
    L12:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public final void startActivity(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        b r101 = this.f425736a;
        if (r101 == null) goto L7;
        r101.startActivity(r100);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public <T extends c> T u0(Class<? extends c> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        b r101 = this.f425736a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.b(r100);
    }

    public final void setResult(int r100, Intent r101) {
        b r102 = this.f425736a;
        Activity r103 = null;
        if (r102 == null) goto L5;
        Context r104 = r102.getContext();
    L7:
        if ((r104 instanceof Activity) == false) goto L9;
        r103 = (Activity) r104;
    L9:
        if (r103 == null) goto L12;
        r103.setResult(r100, r101);
        return;
    L12:
        return;
    L5:
        r104 = null;
        goto L7
    }

    public final void startActivity(Intent r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        b r102 = this.f425736a;
        if (r102 == null) goto L7;
        r102.startActivity(r100, r101);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void startActivityForResult(Intent r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        b r102 = this.f425736a;
        if (r102 == null) goto L7;
        r102.startActivityForResult(r100, r101);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void startActivityForResult(Intent r100, int r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        b r103 = this.f425736a;
        if (r103 == null) goto L7;
        r103.startActivityForResult(r100, r101, r102);
        return;
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final <T extends ViewModel> T t0(String r100, Class<T> r101, ViewModelProvider.Factory r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "clazz");
        Intrinsics.checkNotNullParameter(r102, "factory");
        b r103 = this.f425736a;
        if (r103 == null) goto L7;
        return (T) r103.a(r100, r101, r102);
    L7:
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
