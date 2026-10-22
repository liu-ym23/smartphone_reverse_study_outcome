package com.larus.dora.impl.device.manage.holder;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.larus.dora.impl.device.manage.LifecycleUIComponent;
import com.larus.dora.impl.device.manage.p0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/impl/device/manage/holder/LifecycleUIComponentHolder;", "Lcom/larus/dora/impl/device/manage/holder/BaseViewHolder;", "Lcom/larus/dora/impl/device/manage/DoraGDeviceManagementListItem;", "itemView", "Landroid/view/View;", "component", "Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "<init>", "(Landroid/view/View;Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;)V", "getItemView", "()Landroid/view/View;", "getComponent", "()Lcom/larus/dora/impl/device/manage/LifecycleUIComponent;", "onAttach", "", "onDetach", "onBind", "data", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LifecycleUIComponentHolder extends BaseViewHolder<p0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f333798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleUIComponent f333799b;

    @Override // com.larus.dora.impl.device.manage.holder.BaseViewHolder
    public final void T3() {
        LifecycleUIComponent r100 = this.f333799b;
        if (r100.a() == true) goto L5;
        return;
    L5:
        if (r100.getLifecycle().getCurrentState() != Lifecycle.State.CREATED) goto L9;
        r100.onStart();
        return;
    }

    @Override // com.larus.dora.impl.device.manage.holder.BaseViewHolder
    public final void V3() {
        this.f333799b.g();
    }

    @Override // com.larus.dora.impl.device.manage.holder.BaseViewHolder
    public final void U3(p0 r100) {
        p0 r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f333799b.b(r101);
    }

    public LifecycleUIComponentHolder(View r100, LifecycleUIComponent r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "component");
        super(r100);
        this.f333798a = r100;
        this.f333799b = r101;
    }
}
