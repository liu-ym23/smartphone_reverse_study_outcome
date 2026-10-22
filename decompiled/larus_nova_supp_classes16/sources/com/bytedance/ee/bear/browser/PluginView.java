package com.bytedance.ee.bear.browser;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.ss.android.lark.officesdk.utils.di.j;
import sa5.a;
import sa5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class PluginView extends FrameLayout implements LifecycleObserver, d, a {
    public PluginHost getPluginHost() {
        return null;
    }

    public static void b() {
        j.f("PluginView", "Not init yet");
    }

    public t getUIContainer() {
        j.c("PluginView", "", new IllegalStateException("getUIContainer while not created yet !"));
        return null;
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        j.e("PluginView", "onBackPressed");
        b();
        return false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        j.e("PluginView", "onCreate");
        b();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        j.e("PluginView", "onDestroy");
        b();
    }

    private FragmentActivity getFragmentActivity() {
        return getContext();
    }

    public final void a() {
        if ((getContext() instanceof FragmentActivity) == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Can only used in a FragmentActivity");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        j.e("PluginView", "onAttachedToWindow");
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j.e("PluginView", "onDetachedFromWindow");
        b();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        throw null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        throw null;
    }

    public PluginView(Context r1) {
        super(r1);
        a();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        b();
    }

    public PluginView(Context r1, AttributeSet r2) {
        super(r1, r2);
        a();
    }

    public PluginView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        a();
    }

    @Override // sa5.a
    public final void onActivityResult(int r1, int r2, Intent r3) {
        j.e("PluginView", "onActivityResult");
        b();
    }
}
