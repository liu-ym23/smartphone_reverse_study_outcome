package com.bytedance.widget;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.map.api.monitor.MapMonitorConst;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bM\u0010\u000bJ\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\t\u001a\u00020\u0005H\u0017J\u000f\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\r\u001a\u00020\u0005H\u0017J\u000f\u0010\u000f\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u000e\u0010\u000bJ\b\u0010\u0010\u001a\u00020\u0005H\u0017J\u000f\u0010\u0012\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0005H\u0017J\u000f\u0010\u0015\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0014\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0005H\u0017J\u000f\u0010\u0018\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0017\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u0005H\u0017J\u000f\u0010\u001b\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u001a\u0010\u000bJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u000f\u0010!\u001a\u00020\u001eH\u0000¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"H\u0004J\u001a\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010%H\u0004J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\u0006\u0010(\u001a\u00020'H\u0004J\"\u0010)\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\"2\u0006\u0010(\u001a\u00020'2\b\u0010&\u001a\u0004\u0018\u00010%H\u0004J\"\u0010,\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010.\u001a\u00020-H\u0016R$\u0010/\u001a\u0004\u0018\u00010\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u0010 \"\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010;\u001a\u0004\b<\u0010=\"\u0004\b\b\u0010\u0007R\"\u0010>\u001a\u0002048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b>\u00106\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R\u001b\u0010F\u001a\u00020A8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001b\u0010K\u001a\u00020G8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\bH\u0010C\u001a\u0004\bI\u0010JR\u0011\u0010L\u001a\u0002048F¢\u0006\u0006\u001a\u0004\bL\u00108¨\u0006N"}, d2 = {"Lcom/bytedance/widget/Widget;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleOwner;", "Landroid/view/View;", "contentView", "", "setContentView$widget_release", "(Landroid/view/View;)V", "setContentView", WidgetCostModule.TYPE_ON_CREATE, "create$widget_release", "()V", "create", WidgetCostModule.TYPE_ON_START, "start$widget_release", "start", "onResume", "resume$widget_release", "resume", "onPause", "pause$widget_release", "pause", "onStop", "stop$widget_release", "stop", LiveCommonConstants.REASON_ON_DEDTROY, "destroy$widget_release", MapMonitorConst.EVENT_DESTROY, "", "getHost", "Lcom/bytedance/widget/WidgetHost;", "requireWidgetHost$widget_release", "()Lcom/bytedance/widget/WidgetHost;", "requireWidgetHost", "Landroid/content/Intent;", "intent", "startActivity", "Landroid/os/Bundle;", "options", "", "requestCode", "startActivityForResult", "resultCode", "data", "onActivityResult", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "widgetHost", "Lcom/bytedance/widget/WidgetHost;", "getWidgetHost$widget_release", "setWidgetHost$widget_release", "(Lcom/bytedance/widget/WidgetHost;)V", "", "isDestroyed", "Z", "isDestroyed$widget_release", "()Z", "setDestroyed$widget_release", "(Z)V", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "isFirstLoadedInternal", "isFirstLoadedInternal$widget_release", "setFirstLoadedInternal$widget_release", "Landroidx/lifecycle/LifecycleRegistry;", "lifecycleRegistry$delegate", "Lkotlin/Lazy;", "getLifecycleRegistry", "()Landroid/arch/lifecycle/LifecycleRegistry;", "lifecycleRegistry", "Lcom/bytedance/widget/WidgetManager;", "childWidgetManager$delegate", "getChildWidgetManager$widget_release", "()Lcom/bytedance/widget/WidgetManager;", "childWidgetManager", "isFirstLoaded", "<init>", "widget_release"}, k = 1, mv = {1, 4, 0})
public class Widget implements LifecycleObserver, LifecycleOwner {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final Lazy childWidgetManager$delegate;
    private View contentView;
    private boolean isDestroyed;
    private boolean isFirstLoadedInternal;
    private final Lazy lifecycleRegistry$delegate;
    private WidgetHost widgetHost;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Widget.class), "lifecycleRegistry", "getLifecycleRegistry()Landroid/arch/lifecycle/LifecycleRegistry;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Widget.class), "childWidgetManager", "getChildWidgetManager$widget_release()Lcom/bytedance/widget/WidgetManager;"))};
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        Lazy r100 = this.lifecycleRegistry$delegate;
        KProperty r101 = $$delegatedProperties[0];
        return (LifecycleRegistry) r100.getValue();
    }

    public void onActivityResult(int r100, int r101, Intent r102) {
    }

    public void onCreate() {
        this.isDestroyed = false;
    }

    public void onDestroy() {
        this.isDestroyed = true;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final WidgetHost requireWidgetHost$widget_release() {
        WidgetHost r100 = this.widgetHost;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public Widget() {
        this.isFirstLoadedInternal = true;
        this.lifecycleRegistry$delegate = LazyKt.lazy(new Widget$lifecycleRegistry$2(this));
        this.childWidgetManager$delegate = LazyKt.lazy(new Widget$childWidgetManager$2(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void create$widget_release() {
        onCreate();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void destroy$widget_release() {
        onDestroy();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    public final Object getHost() {
        WidgetHost r100 = requireWidgetHost$widget_release();
        Fragment r101 = r100.getParentFragment();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return r100.requireHost();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void pause$widget_release() {
        onPause();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void resume$widget_release() {
        onResume();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public final void start$widget_release() {
        onStart();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public final void stop$widget_release() {
        onStop();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final boolean isDestroyed$widget_release() {
        return this.isDestroyed;
    }

    public final boolean isFirstLoaded() {
        return this.isFirstLoadedInternal;
    }

    public final void setContentView$widget_release(View r100) {
        this.contentView = r100;
    }

    public final void setFirstLoadedInternal$widget_release(boolean r100) {
        this.isFirstLoadedInternal = r100;
    }

    public final void setWidgetHost$widget_release(WidgetHost r100) {
        this.widgetHost = r100;
    }

    public final void startActivity(Intent r100) {
        requireWidgetHost$widget_release().startActivity(r100);
    }

    public final void startActivity(Intent r100, Bundle r101) {
        requireWidgetHost$widget_release().startActivity(r100, r101);
    }

    public final void startActivityForResult(Intent r100, int r101) {
        requireWidgetHost$widget_release().T90(r100, r101, this);
    }

    public final void startActivityForResult(Intent r100, int r101, Bundle r102) {
        requireWidgetHost$widget_release().S90(r100, r101, r102, this);
    }
}
