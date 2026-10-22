package com.bytedance.ee.bear.document.toolbar.selectcolor.impl;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.widgets.RoundColorView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class SelectColorAdapter extends RecyclerView.Adapter<ColorViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f222352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f222353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SelectColorDecoration f222354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f222355d;

    public class ColorViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RoundColorView f222356a;

        public ColorViewHolder(View r100) {
            super(r100);
            this.f222356a = (RoundColorView) r100.findViewById(R.id.color);
        }
    }

    public interface a {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        String[] r100 = this.f222352a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length;
    }

    public SelectColorAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        ColorViewHolder r102 = (ColorViewHolder) r100;
        String r103 = this.f222352a[r101];
        boolean r104 = TextUtils.equals(r103, "#clear");
        if (r104 == false) goto L5;
        r103 = "#ffffff";
    L5:
        r102.f222356a.setClear(r104);
        r102.f222356a.setColor(r103);
        r102.f222356a.setOnClickListener(new com.bytedance.ee.bear.document.toolbar.selectcolor.impl.a(this, r103));
        if (this.f222354c != null) goto L8;
        return;
    L8:
        if (TextUtils.equals(this.f222353b, r103) == false) goto L12;
        SelectColorDecoration r105 = this.f222354c;
        r105.f222358a = r102.itemView;
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new ColorViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.select_color_item, null));
    }
}
