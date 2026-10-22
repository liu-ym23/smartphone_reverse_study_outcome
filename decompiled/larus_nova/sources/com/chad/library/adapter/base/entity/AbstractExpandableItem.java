package com.chad.library.adapter.base.entity;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class AbstractExpandableItem<T> implements IExpandable<T> {
    protected boolean mExpandable;
    protected List<T> mSubItems;

    public boolean hasSubItem() {
        List<T> r100 = this.mSubItems;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.size() <= 0) goto L7;
        return true;
    }

    public AbstractExpandableItem() {
        this.mExpandable = false;
    }

    @Override // com.chad.library.adapter.base.entity.IExpandable
    public List<T> getSubItems() {
        return this.mSubItems;
    }

    @Override // com.chad.library.adapter.base.entity.IExpandable
    public boolean isExpanded() {
        return this.mExpandable;
    }

    public void addSubItem(T r100) {
        if (this.mSubItems != null) goto L5;
        this.mSubItems = new ArrayList();
    L5:
        this.mSubItems.add(r100);
    }

    public boolean contains(T r100) {
        List<T> r101 = this.mSubItems;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.contains(r100) == false) goto L7;
        return true;
    }

    public T getSubItem(int r100) {
        if (hasSubItem() == true) goto L5;
        return null;
    L5:
        if (r100 < this.mSubItems.size()) goto L7;
        return null;
    L7:
        return (T) ListProtector.get(this.mSubItems, r100);
    }

    public int getSubItemPosition(T r100) {
        List<T> r101 = this.mSubItems;
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.indexOf(r100);
    }

    public boolean removeSubItem(int r100) {
        List<T> r101 = this.mSubItems;
        if (r101 == null) goto L9;
        if (r100 >= 0) goto L6;
        return false;
    L6:
        if (r100 >= r101.size()) goto L12;
        ListProtector.remove(this.mSubItems, r100);
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    @Override // com.chad.library.adapter.base.entity.IExpandable
    public void setExpanded(boolean r100) {
        this.mExpandable = r100;
    }

    public void setSubItems(List<T> r100) {
        this.mSubItems = r100;
    }

    public boolean removeSubItem(T r100) {
        List<T> r101 = this.mSubItems;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.remove(r100) == false) goto L7;
        return true;
    }

    public void addSubItem(int r100, T r101) {
        List<T> r102 = this.mSubItems;
        if (r102 == null) goto L8;
        if (r100 < 0) goto L8;
        if (r100 >= r102.size()) goto L8;
        ListProtector.add(this.mSubItems, r100, r101);
        return;
    L8:
        addSubItem(r101);
    }
}
