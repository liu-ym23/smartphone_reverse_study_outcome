package com.bytedance.awemeopen.apps.framework.utils;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/utils/DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class DiffCallback extends DiffUtil.Callback {
    public final int getNewListSize() {
        throw null;
    }

    public final int getOldListSize() {
        throw null;
    }

    public final boolean areContentsTheSame(int r2, int r3) {
        return Intrinsics.areEqual(ListProtector.get(null, r2), ListProtector.get(null, r3));
    }

    public final boolean areItemsTheSame(int r2, int r3) {
        return Intrinsics.areEqual(ListProtector.get(null, r2), ListProtector.get(null, r3));
    }
}
