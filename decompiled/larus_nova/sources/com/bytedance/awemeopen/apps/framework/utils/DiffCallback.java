package com.bytedance.awemeopen.apps.framework.utils;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/utils/DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class DiffCallback extends DiffUtil.Callback {
    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        throw null;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        return Intrinsics.areEqual(ListProtector.get(null, r100), ListProtector.get(null, r101));
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        return Intrinsics.areEqual(ListProtector.get(null, r100), ListProtector.get(null, r101));
    }
}
