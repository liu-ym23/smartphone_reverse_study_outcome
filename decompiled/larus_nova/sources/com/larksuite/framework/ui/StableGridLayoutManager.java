package com.larksuite.framework.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;

/* JADX INFO: loaded from: classes24.dex */
public class StableGridLayoutManager extends GridLayoutManager {
    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public StableGridLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
