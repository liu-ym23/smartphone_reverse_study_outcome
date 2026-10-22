package com.ss.android.lark.docs.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;

/* JADX INFO: loaded from: classes35.dex */
public class DocsLinearLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f420501a;

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        if (this.f420501a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically() == false) goto L7;
        return true;
    }

    public DocsLinearLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.f420501a = true;
    }
}
