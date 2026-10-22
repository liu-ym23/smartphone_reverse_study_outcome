package com.bytedance.ee.bear.list.sort;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SortTypeAdapter extends RecyclerView.Adapter<b> {
    public Context a;
    public final List<q> b;
    public int c;
    public FilterType d;
    public boolean e;
    public a f;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {
        public final LinearLayout a;
        public final ImageView b;
        public final TextView c;

        public b(View r2) {
            super(r2);
            this.a = (LinearLayout) r2.findViewById(2131378723);
            this.b = (ImageView) r2.findViewById(2131376297);
            this.c = (TextView) r2.findViewById(2131390975);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public SortTypeAdapter() {
        this.b = new ArrayList();
        this.e = true;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        b r9 = (b) r7;
        q r0 = (q) ListProtector.get(this.b, r8);
        r9.c.setText(r0.a);
        FilterType r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
    L7:
        boolean r3 = false;
    L9:
        if (this.c != r8) goto L19;
        ImageView r4 = r9.b;
        if (this.e == true) goto L14;
        r2 = 8;
    L14:
        r4.setVisibility(r2);
        r9.c.setTextColor(this.a.getResources().getColor(2131105548));
        r9.a.setBackgroundResource(2131243703);
        ImageView r5 = r9.b;
        if (r0.c == false) goto L17;
        Drawable r6 = this.a.getDrawable(2131255792);
    L18:
        r5.setBackground(r6);
        com.bytedance.ee.util.ui.l.b(r9.b, 2131105548);
    L24:
        r9.a.setOnClickListener(new j(this, r3, r8, r0));
        return;
    L17:
        r6 = this.a.getDrawable(2131255782);
        goto L18
    L19:
        TextView r10 = r9.c;
        Resources r11 = this.a.getResources();
        if (r3 == false) goto L22;
        int r12 = 2131106610;
    L23:
        r10.setTextColor(r11.getColor(r12));
        r9.a.setBackgroundResource(2131243700);
        r9.b.setVisibility(8);
        r9.b.setBackground(null);
        goto L24
    L22:
        r12 = 2131106607;
        goto L23
    L5:
        if (r1.getResId() != r0.e.intValue()) goto L7;
        r3 = true;
        goto L9
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        this.a = r4.getContext();
        return new b(LayoutInflater.from(this.a).inflate(2131563478, r4, false));
    }
}
