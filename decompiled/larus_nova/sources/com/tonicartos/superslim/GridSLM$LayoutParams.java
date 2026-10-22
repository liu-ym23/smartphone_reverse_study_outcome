package com.tonicartos.superslim;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes41.dex */
public class GridSLM$LayoutParams extends LayoutManager.LayoutParams {
    public GridSLM$LayoutParams(Context r100, AttributeSet r101) {
        super(r100, r101);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.slm_grid_columnWidth, R.attr.slm_grid_numColumns});
        r102.getInt(1, -1);
        r102.getDimensionPixelSize(0, -1);
        r102.recycle();
    }
}
