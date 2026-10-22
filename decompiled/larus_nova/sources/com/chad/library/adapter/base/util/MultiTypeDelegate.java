package com.chad.library.adapter.base.util;

import android.util.SparseIntArray;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public abstract class MultiTypeDelegate<T> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    private boolean autoMode;
    private SparseIntArray layouts;
    private boolean selfMode;

    public abstract int getItemType(T r100);

    public MultiTypeDelegate() {
    }

    public MultiTypeDelegate(SparseIntArray r100) {
        this.layouts = r100;
    }

    private void checkMode(boolean r100) {
        if (r100 == true) goto L5;
        return;
    L5:
        throw new IllegalArgumentException("Don't mess two register mode");
    }

    public final int getLayoutId(int r100) {
        return this.layouts.get(r100, -404);
    }

    public MultiTypeDelegate registerItemTypeAutoIncrease(int... r100) {
        this.autoMode = true;
        checkMode(this.selfMode);
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        addItemType(r101, r100[r101]);
        r101 = r101 + 1;
        goto L4
    L6:
        return this;
    }

    private void addItemType(int r100, int r101) {
        if (this.layouts != null) goto L5;
        this.layouts = new SparseIntArray();
    L5:
        this.layouts.put(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getDefItemViewType(List<T> r100, int r101) {
        Object r102 = ListProtector.get(r100, r101);
        if (r102 != null) goto L7;
        return -255;
    L7:
        return getItemType(r102);
    }

    public MultiTypeDelegate registerItemType(int r100, int r101) {
        this.selfMode = true;
        checkMode(this.autoMode);
        addItemType(r100, r101);
        return this;
    }
}
