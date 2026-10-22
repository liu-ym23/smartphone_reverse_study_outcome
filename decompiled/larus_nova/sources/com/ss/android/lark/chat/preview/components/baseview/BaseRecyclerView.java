package com.ss.android.lark.chat.preview.components.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes35.dex */
public class BaseRecyclerView extends RecyclerView {
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return false;
    }

    public BaseRecyclerView(Context r100) {
        super(r100);
    }

    public BaseRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public BaseRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
