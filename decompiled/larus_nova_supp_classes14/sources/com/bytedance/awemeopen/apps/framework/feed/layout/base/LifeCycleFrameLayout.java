package com.bytedance.awemeopen.apps.framework.feed.layout.base;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B!\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b#\u0010%B\u001b\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b#\u0010&J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\r\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006'"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/layout/base/LifeCycleFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/base/ILifeCycleView;", "Lcom/bytedance/awemeopen/apps/framework/feed/layout/base/IViewModelStoreView;", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "Landroidx/lifecycle/LifecycleRegistry;", "a", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "setLifecycleRegistry", "(Landroidx/lifecycle/LifecycleRegistry;)V", "lifecycleRegistry", "b", "Landroidx/lifecycle/ViewModelStore;", "getMViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "setMViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "mViewModelStore", "Landroidx/lifecycle/ViewModelStoreOwner;", "c", "Landroidx/lifecycle/ViewModelStoreOwner;", "getViewModelStoreOwner", "()Landroidx/lifecycle/ViewModelStoreOwner;", "setViewModelStoreOwner", "(Landroidx/lifecycle/ViewModelStoreOwner;)V", "viewModelStoreOwner", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class LifeCycleFrameLayout extends FrameLayout implements ILifeCycleView, IViewModelStoreView {
    public LifecycleRegistry a;
    public ViewModelStore b;
    public ViewModelStoreOwner c;

    public abstract /* synthetic */ View getView();

    public ViewModelStore getViewModelStore() {
        Activity r0 = this.c;
        if (r0 == null) goto L21;
        if ((r0 instanceof Activity) == false) goto L10;
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.Activity");
        if (r0.isFinishing() == false) goto L10;
        return new ViewModelStore();
    L10:
        Fragment r1 = this.c;
        if ((r1 instanceof Fragment) == false) goto L18;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        if (r1.isDetached() == true) goto L17;
        Fragment r2 = this.c;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        if (r2.getContext() != null) goto L18;
    L17:
        return new ViewModelStore();
    L18:
        ViewModelStoreOwner r3 = this.c;
        Intrinsics.checkNotNull(r3);
        return r3.getViewModelStore();
    L21:
        if ((getContext() instanceof ViewModelStoreOwner) == false) goto L25;
        ViewModelStoreOwner r4 = getContext();
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
        return r4.getViewModelStore();
    L25:
        if (getMViewModelStore() != null) goto L27;
        setMViewModelStore(new ViewModelStore());
    L27:
        ViewModelStore r5 = getMViewModelStore();
        Intrinsics.checkNotNull(r5);
        return r5;
    }

    public Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    public void onDestroy() {
        ILifeCycleView.a.onDestroy(this);
        ViewModelStore r0 = getMViewModelStore();
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.layout.base.ILifeCycleView
    public LifecycleRegistry getLifecycleRegistry() {
        return this.a;
    }

    public ViewModelStore getMViewModelStore() {
        return this.b;
    }

    public final ViewModelStoreOwner getViewModelStoreOwner() {
        return this.c;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        ILifeCycleView.a.onCreate(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        ILifeCycleView.a.onPause(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        ILifeCycleView.a.onResume(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        ILifeCycleView.a.onStart(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        ILifeCycleView.a.onStop(this);
    }

    public LifeCycleFrameLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public void setLifecycleRegistry(LifecycleRegistry r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public void setMViewModelStore(ViewModelStore r1) {
        this.b = r1;
    }

    public final void setViewModelStoreOwner(ViewModelStoreOwner r1) {
        this.c = r1;
    }

    public LifeCycleFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public LifeCycleFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.a = new LifecycleRegistry(this);
    }
}
