package com.ss.android.lark.chat.chatwindow.chat;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes35.dex */
public class TimeLineDecoration extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        int r103 = r101.getChildCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L9;
        if (r101.getChildAdapterPosition(r101.getChildAt(r104)) != (-1)) goto L8;
        r104 = r104 + 1;
        goto L3
    L8:
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        if (r102.getChildAdapterPosition(r101) != (-1)) goto L7;
        r100.set(0, 0, 0, 0);
        return;
    L7:
        throw null;
    }
}
