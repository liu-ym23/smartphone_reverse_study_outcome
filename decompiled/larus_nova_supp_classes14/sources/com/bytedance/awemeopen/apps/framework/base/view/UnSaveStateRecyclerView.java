package com.bytedance.awemeopen.apps.framework.base.view;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.env.AoEnv;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class UnSaveStateRecyclerView extends RecyclerView {
    public final Parcelable onSaveInstanceState() {
        if (AoEnv.j() == false) goto L9;
        RecyclerView.SavedState r0 = super.onSaveInstanceState();
        if ((r0 instanceof RecyclerView.SavedState) == true) goto L7;
        return r0;
    L7:
        return r0.getSuperState();
    L9:
        return super.onSaveInstanceState();
    }

    public UnSaveStateRecyclerView(Context r1) {
        super(r1);
    }

    public UnSaveStateRecyclerView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public UnSaveStateRecyclerView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
