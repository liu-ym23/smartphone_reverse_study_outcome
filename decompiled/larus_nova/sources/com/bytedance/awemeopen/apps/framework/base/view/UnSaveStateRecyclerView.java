package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.env.AoEnv;

/* JADX INFO: loaded from: classes14.dex */
public class UnSaveStateRecyclerView extends RecyclerView {
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final Parcelable onSaveInstanceState() {
        if (AoEnv.j() == false) goto L9;
        Parcelable r100 = super.onSaveInstanceState();
        if ((r100 instanceof RecyclerView.SavedState) == true) goto L7;
        return r100;
    L7:
        return ((RecyclerView.SavedState) r100).getSuperState();
    L9:
        return super.onSaveInstanceState();
    }

    public UnSaveStateRecyclerView(Context r100) {
        super(r100);
    }

    public UnSaveStateRecyclerView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public UnSaveStateRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
