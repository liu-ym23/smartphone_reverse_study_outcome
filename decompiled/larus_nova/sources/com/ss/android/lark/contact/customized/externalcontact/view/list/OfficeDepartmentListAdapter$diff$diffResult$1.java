package com.ss.android.lark.contact.customized.externalcontact.view.list;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"com/ss/android/lark/contact/customized/externalcontact/view/list/OfficeDepartmentListAdapter$diff$diffResult$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeDepartmentListAdapter$diff$diffResult$1 extends DiffUtil.Callback {
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
        if (((mtb.c) ListProtector.get(null, r100)).hashCode() != ((mtb.c) ListProtector.get(null, r101)).hashCode()) goto L5;
        return true;
    L5:
        return false;
    }
}
