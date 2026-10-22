package com.ethanhua.skeleton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes22.dex */
public class ShimmerViewHolder extends RecyclerView.ViewHolder {
    public ShimmerViewHolder(LayoutInflater r100, ViewGroup r101, int r102) {
        super(r100.inflate(R.layout.layout_shimmer, r101, false));
        ViewGroup r103 = (ViewGroup) this.itemView;
        View r104 = r100.inflate(r102, r103, false);
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L5;
        r103.setLayoutParams(r105);
    L5:
        r103.addView(r104);
    }
}
