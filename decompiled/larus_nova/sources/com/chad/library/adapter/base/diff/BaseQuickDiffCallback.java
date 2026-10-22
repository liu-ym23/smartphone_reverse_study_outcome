package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class BaseQuickDiffCallback<T> extends DiffUtil.Callback {
    private List<T> newList;
    private List<T> oldList;

    public abstract boolean areContentsTheSame(T r100, T r101);

    public abstract boolean areItemsTheSame(T r100, T r101);

    public Object getChangePayload(T r100, T r101) {
        return null;
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getNewListSize() {
        return this.newList.size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public int getOldListSize() {
        return this.oldList.size();
    }

    public List<T> getNewList() {
        return this.newList;
    }

    public List<T> getOldList() {
        return this.oldList;
    }

    public BaseQuickDiffCallback(List<T> r100) {
        if (r100 != null) goto L5;
        r100 = new ArrayList();
    L5:
        this.newList = r100;
    }

    public void setOldList(List<T> r100) {
        if (r100 != null) goto L4;
        r100 = new ArrayList();
    L4:
        this.oldList = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areContentsTheSame(int r100, int r101) {
        return areContentsTheSame(ListProtector.get(this.oldList, r100), ListProtector.get(this.newList, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public boolean areItemsTheSame(int r100, int r101) {
        return areItemsTheSame(ListProtector.get(this.oldList, r100), ListProtector.get(this.newList, r101));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public Object getChangePayload(int r100, int r101) {
        return getChangePayload(ListProtector.get(this.oldList, r100), ListProtector.get(this.newList, r101));
    }
}
