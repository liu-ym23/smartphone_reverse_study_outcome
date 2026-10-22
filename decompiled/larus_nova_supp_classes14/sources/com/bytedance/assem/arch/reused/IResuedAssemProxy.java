package com.bytedance.assem.arch.reused;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/assem/arch/reused/IResuedAssemProxy;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/LifecycleOwner;", "assem_release"}, k = 1, mv = {1, 4, 0})
public interface IResuedAssemProxy extends ViewModelStoreOwner, LifecycleOwner {
    BehaviorSubject<a> gl();

    void jz(ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r1);
}
