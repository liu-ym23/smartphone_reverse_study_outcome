package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment;
import com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/framework/bottomsheetdialog/AosBottomSheetRecyclerListFragment;", "Model", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListViewModel;", "VM", "Lcom/bytedance/awemeopen/apps/framework/framework/recyclerview/AosRecyclerListFragment;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public abstract class AosBottomSheetRecyclerListFragment<Model, VM extends AosRecyclerListViewModel<Model>> extends AosRecyclerListFragment<Model, VM> {
    public final Map<Integer, View> n;

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final void S90() {
        ((LinkedHashMap) this.n).clear();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.recyclerview.AosRecyclerListFragment, com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public AosBottomSheetRecyclerListFragment() {
        this.n = new LinkedHashMap();
    }

    @Override // com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return super.onCreateView(r2, r3, r4);
    }
}
