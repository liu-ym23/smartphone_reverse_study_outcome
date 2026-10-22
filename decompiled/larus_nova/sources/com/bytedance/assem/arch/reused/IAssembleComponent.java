package com.bytedance.assem.arch.reused;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/assem/arch/reused/IAssembleComponent;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity", "assem_release"}, k = 1, mv = {1, 4, 0})
public interface IAssembleComponent extends LifecycleOwner {
    LifecycleOwner GV();

    FragmentActivity getActivity();
}
