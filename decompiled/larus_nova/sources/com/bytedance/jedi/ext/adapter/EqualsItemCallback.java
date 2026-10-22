package com.bytedance.jedi.ext.adapter;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/EqualsItemCallback;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "<init>", "()V", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public final class EqualsItemCallback<T> extends DiffUtil.ItemCallback<T> {
    public EqualsItemCallback() {
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areContentsTheSame(T r100, T r101) {
        return Intrinsics.areEqual(r100, r101);
    }

    @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
    public final boolean areItemsTheSame(T r100, T r101) {
        return Intrinsics.areEqual(r100, r101);
    }
}
