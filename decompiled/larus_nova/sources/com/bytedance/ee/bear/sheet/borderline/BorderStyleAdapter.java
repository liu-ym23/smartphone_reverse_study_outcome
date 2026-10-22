package com.bytedance.ee.bear.sheet.borderline;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public class BorderStyleAdapter extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String[] f237378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f237379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f237380c;

    public interface a {
    }

    public class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImageView f237381a;

        public b(View r100) {
            super(r100);
            this.f237381a = (ImageView) r100.findViewById(R.id.border_style_icon);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        String[] r100 = this.f237378a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.length;
    }

    public BorderStyleAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        b r102 = (b) r100;
        String r103 = this.f237378a[r101];
        if (TextUtils.isEmpty(r103) == true) goto L7;
        Resources r104 = r102.itemView.getContext().getResources();
        r102.f237381a.setImageDrawable(r104.getDrawable(BorderStyleEnum.valueOf(r103).iconRes));
        r102.itemView.setSelected(TextUtils.equals(r103, this.f237379b));
        r102.itemView.setOnClickListener(new f(this, r103));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new b(LayoutInflater.from(r100.getContext()).inflate(R.layout.sheet_border_style_item, null));
    }
}
