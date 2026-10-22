package com.larus.ui.arch.component.external.api.receiver;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/larus/ui/arch/component/external/api/receiver/AttachReceiver;", "Lcom/larus/ui/arch/component/external/api/receiver/ViewTreeReceiver;", "Landroidx/lifecycle/ViewModelStoreOwner;", "onAttach", "", "parent", "Landroidx/lifecycle/LifecycleOwner;", "getParent", "()Landroidx/lifecycle/LifecycleOwner;", "illegalStateCutout", "", "getIllegalStateCutout", "()Z", "component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AttachReceiver extends ViewTreeReceiver, ViewModelStoreOwner {
    boolean WI();

    LifecycleOwner getParent();
}
