package com.bytedance.ee.bear.sheet.borderline;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BorderStyleAdapter extends RecyclerView.Adapter<b> {
    public String[] a;
    public String b;
    public a c;

    public interface a {
    }

    public class b extends RecyclerView.ViewHolder {
        public final ImageView a;

        public b(View r2) {
            super(r2);
            this.a = (ImageView) r2.findViewById(2131364345);
        }
    }

    public final int getItemCount() {
        String[] r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.length;
    }

    public BorderStyleAdapter() {
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        b r6 = (b) r4;
        String r7 = this.a[r5];
        if (TextUtils.isEmpty(r7) == true) goto L7;
        Resources r0 = ((RecyclerView.ViewHolder) r6).itemView.getContext().getResources();
        r6.a.setImageDrawable(r0.getDrawable(BorderStyleEnum.valueOf(r7).iconRes));
        ((RecyclerView.ViewHolder) r6).itemView.setSelected(TextUtils.equals(r7, this.b));
        ((RecyclerView.ViewHolder) r6).itemView.setOnClickListener(new f(this, r7));
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        return new b(LayoutInflater.from(r2.getContext()).inflate(2131564528, null));
    }
}
