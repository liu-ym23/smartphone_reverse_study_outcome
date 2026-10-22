package com.ss.android.lark.scaffold.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0010J\r\u0010\u0011\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0014J\r\u0010\u0015\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0018J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u001a\u001a\u00020\u000bH\u0014J\b\u0010\u001b\u001a\u00020\u000bH\u0014J\b\u0010\u001c\u001a\u00020\u000bH\u0014J\b\u0010\u001d\u001a\u00020\u000bH\u0014J\b\u0010\u001e\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/scaffold/internal/PluginImpl;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "performCreate", "", "runtime", "Lcom/ss/android/lark/scaffold/PageRuntime;", "performCreate$scaffold_release", "performStart", "performStart$scaffold_release", "performResume", "performResume$scaffold_release", "performPause", "performPause$scaffold_release", "performStop", "performStop$scaffold_release", "performDestroy", "performDestroy$scaffold_release", WidgetCostModule.TYPE_ON_CREATE, WidgetCostModule.TYPE_ON_START, "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "scaffold_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PluginImpl implements LifecycleOwner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleRegistry f439731a;

    public PluginImpl() {
        this.f439731a = new LifecycleRegistry(this);
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f439731a;
    }
}
