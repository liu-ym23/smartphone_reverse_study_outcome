package com.ss.android.lark.scaffold.internal.component;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0015J\r\u0010\u0016\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\u0013H\u0000¢\u0006\u0002\b!J\r\u0010\"\u001a\u00020\u0013H\u0000¢\u0006\u0002\b#J\r\u0010$\u001a\u00020\u0013H\u0000¢\u0006\u0002\b%J\r\u0010&\u001a\u00020\u0013H\u0000¢\u0006\u0002\b'J\r\u0010(\u001a\u00020\u0013H\u0000¢\u0006\u0002\b)J\r\u0010*\u001a\u00020\u0013H\u0000¢\u0006\u0002\b+J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH$J\b\u0010-\u001a\u00020\u0013H\u0014J\b\u0010.\u001a\u00020\u0013H\u0014J\b\u0010/\u001a\u00020\u0013H\u0014J\b\u00100\u001a\u00020\u0013H\u0014J\b\u00101\u001a\u00020\u0013H\u0014J\b\u00102\u001a\u00020\u0013H\u0014J\n\u00103\u001a\u0004\u0018\u000104H\u0014J\b\u00105\u001a\u000204H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u000e8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u00066"}, d2 = {"Lcom/ss/android/lark/scaffold/internal/component/ComponentImpl;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "<init>", "()V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "attachedHost", "Lcom/ss/android/lark/scaffold/internal/component/ComponentHost;", "view", "Landroid/view/View;", "contentView", "getContentView", "()Landroid/view/View;", LynxViewpagerItem.BIND_ON_ATTACH, "", "host", "attach$scaffold_release", "detach", "detach$scaffold_release", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "getOrCreateView", "parent", "Landroid/view/ViewGroup;", "getOrCreateView$scaffold_release", "performCreate", "performCreate$scaffold_release", "performStart", "performStart$scaffold_release", "performResume", "performResume$scaffold_release", "performPause", "performPause$scaffold_release", "performStop", "performStop$scaffold_release", "performDestroy", "performDestroy$scaffold_release", "createView", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "getContext", "Landroid/content/Context;", "requireContext", "scaffold_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ComponentImpl implements LifecycleOwner, ViewModelStoreOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f439756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewModelStore f439757b;

    public Context getContext() {
        return null;
    }

    public ComponentImpl() {
        this.f439756a = new LifecycleRegistry(this);
        this.f439757b = new ViewModelStore();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.f439756a;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return this.f439757b;
    }
}
