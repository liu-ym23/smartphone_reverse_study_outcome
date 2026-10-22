package com.bytedance.ies.sdk.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;

/* JADX INFO: loaded from: classes19.dex */
public abstract class Widget implements LifecycleObserver, LifecycleOwner {
    private final String TAG;
    public ViewGroup containerView;
    public View contentView;
    public Context context;
    public DataCenter dataCenter;
    private boolean hasUI;
    private boolean isAsync;
    public boolean isDestroyed;
    private boolean isRecycle;
    public boolean isViewValid;
    public LifecycleRegistry lifecycleRegistry;
    private boolean mergeMode;
    public WidgetManager subWidgetManager;
    public WidgetCallback widgetCallback;

    public interface WidgetCallback {
        Fragment getFragment();

        <T extends ViewModel> T getViewModel(Class<T> r100);

        <T extends ViewModel> T getViewModel(Class<T> r100, ViewModelProvider.Factory r101);

        WidgetManager getWidgetManager();

        void startActivity(Intent r100);

        void startActivity(Intent r100, Bundle r101);

        void startActivityForResult(Intent r100, int r101);

        void startActivityForResult(Intent r100, int r101, Bundle r102);
    }

    public int getLayoutId() {
        return 0;
    }

    public View getLayoutView() {
        return null;
    }

    public void onActivityResult(int r100, int r101, Intent r102) {
    }

    public void onConfigurationChanged(Configuration r100) {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        this.isViewValid = true;
        this.isDestroyed = false;
        this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public void enableSubWidgetManager() {
        if (this.subWidgetManager != null) goto L6;
        this.subWidgetManager = this.widgetCallback.getWidgetManager().createSubWidgetManager();
        return;
    }

    public String getWidgetTag() {
        return getClass().getSimpleName() + "@" + hashCode();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        if (this.subWidgetManager != null) goto L15;
    L13:
        this.isDestroyed = true;
        this.isViewValid = false;
        return;
    L15:
        this.widgetCallback.getWidgetManager().getChildFragmentManager().beginTransaction().remove(this.subWidgetManager).commitNowAllowingStateLoss();     // Catch: IllegalStateException -> L6
    L6:
        e = move-exception;
        String r100 = e.getMessage();
        if (r100 != null) goto L10;
    L12:
        throw e;
    L10:
        if (r100.contains("has not been attached yet") == false) goto L12;
        goto L12
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        this.lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public Widget() {
        this.TAG = getClass().getSimpleName();
        this.lifecycleRegistry = new LifecycleRegistry(this);
        this.mergeMode = false;
        this.isAsync = false;
    }

    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    public boolean getStatusAsync() {
        return this.isAsync;
    }

    public boolean getStatusHasUI() {
        return this.hasUI;
    }

    public boolean getStatusRecycle() {
        return this.isRecycle;
    }

    public boolean isMergeMode() {
        return this.mergeMode;
    }

    public boolean isViewValid() {
        return this.isViewValid;
    }

    public <T extends ViewModel> T getViewModel(Class<T> r100) {
        return (T) this.widgetCallback.getViewModel(r100);
    }

    public WidgetInfo getWidgetInfo(Class r100) {
        WidgetCallback r101 = this.widgetCallback;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.getWidgetManager().getWidgetInfo(r100);
    }

    public void setMergeMode(boolean r100) {
        this.mergeMode = r100;
    }

    public void setStatusAsync(boolean r100) {
        this.isAsync = r100;
    }

    public void setStatusHasUI(boolean r100) {
        this.hasUI = r100;
    }

    public void setStatusRecycle(boolean r100) {
        this.isRecycle = r100;
    }

    public void setWidgetCallback(WidgetCallback r100) {
        this.widgetCallback = r100;
    }

    public void startActivity(Intent r100) {
        this.widgetCallback.startActivity(r100);
    }

    public <T extends ViewModel> T getViewModel(Class<T> r100, ViewModelProvider.Factory r101) {
        return (T) this.widgetCallback.getViewModel(r100, r101);
    }

    public void startActivity(Intent r100, Bundle r101) {
        this.widgetCallback.startActivity(r100, r101);
    }

    public void startActivityForResult(Intent r100, int r101) {
        this.widgetCallback.startActivityForResult(r100, r101);
    }

    public void startActivityForResult(Intent r100, int r101, Bundle r102) {
        this.widgetCallback.startActivityForResult(r100, r101, r102);
    }
}
