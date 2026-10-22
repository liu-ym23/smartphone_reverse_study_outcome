package com.larus.ui.arch.component.external.delegate;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.larus.list.arch.IFlowListCell;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import ei9.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/larus/ui/arch/component/external/delegate/BaseCellComponentFeature;", "STATE", "Lcom/larus/list/arch/IFlowListCellState;", "Lcom/larus/list/arch/IFlowListCell;", "Lcom/larus/ui/arch/component/external/api/receiver/AttachReceiver;", "<init>", "()V", "_parent", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "illegalStateCutout", "", "getIllegalStateCutout", "()Z", "setIllegalStateCutout", "(Z)V", "value", "parent", "getParent", "()Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "setParent", "(Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;)V", NewBroadcastMonitor.STAGE.LIFECYCLE, "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseCellComponentFeature<STATE extends f> implements IFlowListCell<STATE>, AttachReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ComponentFeature f375146a;

    public BaseCellComponentFeature() {
    }

    @Override // com.larus.ui.arch.component.external.api.receiver.AttachReceiver
    public final boolean WI() {
        return false;
    }

    @Override // com.larus.list.arch.IFlowListCell
    public void onViewAttachedToWindow() {
    }

    @Override // com.larus.list.arch.IFlowListCell
    public void onViewDetachedFromWindow() {
    }

    @Override // com.larus.list.arch.IFlowListCell
    public void onViewRecycled() {
    }

    public final ComponentFeature e() {
        ComponentFeature r100 = this.f375146a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new UninitializedPropertyAccessException("parent is not initialized, you should get it after onAttach ");
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return e().getLifecycle();
    }

    @Override // com.larus.ui.arch.component.external.api.receiver.AttachReceiver
    public final /* bridge */ /* synthetic */ LifecycleOwner getParent() {
        return e();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return e().getViewModelStore();
    }

    @Override // com.larus.list.arch.IFlowListCell
    public Map<String, Object> appendPerfMonitorParams(STATE r100) {
        return new LinkedHashMap();
    }

    @Override // com.larus.list.arch.IFlowListCell
    public void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // com.larus.list.arch.IFlowListCell
    public void onBindViewInternal(View r100, STATE r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "state");
    }

    @Override // com.larus.list.arch.IFlowListCell
    public boolean shouldBindCell(View r100, STATE r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "state");
        return true;
    }
}
