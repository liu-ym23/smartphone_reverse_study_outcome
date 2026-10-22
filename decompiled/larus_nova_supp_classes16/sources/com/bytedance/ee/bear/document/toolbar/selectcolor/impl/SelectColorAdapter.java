package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.widgets.RoundColorView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectColorAdapter extends RecyclerView.Adapter<ColorViewHolder> {
    public String[] a;
    public String b;
    public SelectColorDecoration c;
    public a d;

    public class ColorViewHolder extends RecyclerView.ViewHolder {
        public final RoundColorView a;

        public ColorViewHolder(View r2) {
            super(r2);
            this.a = r2.findViewById(2131367165);
        }
    }

    public interface a {
    }

    public final int getItemCount() {
        String[] r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public SelectColorAdapter() {
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
        ColorViewHolder r5 = (ColorViewHolder) r3;
        String r6 = this.a[r4];
        boolean r0 = TextUtils.equals(r6, "#clear");
        if (r0 == false) goto L5;
        r6 = "#ffffff";
    L5:
        r5.a.setClear(r0);
        r5.a.setColor(r6);
        r5.a.setOnClickListener(new com.bytedance.ee.bear.document.toolbar.selectcolor.impl.a(this, r6));
        if (this.c != null) goto L8;
        return;
    L8:
        if (TextUtils.equals(this.b, r6) == false) goto L12;
        SelectColorDecoration r7 = this.c;
        r7.a = ((RecyclerView.ViewHolder) r5).itemView;
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        return new ColorViewHolder(LayoutInflater.from(r2.getContext()).inflate(2131564497, null));
    }
}
