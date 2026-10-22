package com.bytedance.ee.bear.list.sort;

import android.content.Context;
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
public class SortAdapter extends RecyclerView.Adapter<b> {
    public Context a;
    public final List<q> b;
    public int c;
    public final boolean d;
    public a e;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {
        public final LinearLayout a;
        public final TextView b;
        public final TextView c;
        public final ImageView d;
        public final View e;

        public b(View r2) {
            super(r2);
            this.a = (LinearLayout) r2.findViewById(2131378723);
            this.b = (TextView) r2.findViewById(2131391489);
            this.d = (ImageView) r2.findViewById(2131376623);
            this.c = (TextView) r2.findViewById(2131376624);
            this.e = r2.findViewById(2131369197);
        }
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public SortAdapter(boolean r2) {
        this.b = new ArrayList();
        this.d = r2;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r8, int r9) {
        b r10 = (b) r8;
        q r0 = (q) ListProtector.get(this.b, r9);
        r10.b.setText(r0.a);
        int r1 = getItemCount();
        if (r9 != 0) goto L5;
        boolean r4 = true;
    L7:
        if (r9 != (r1 - 1)) goto L9;
        boolean r2 = true;
    L10:
        if (r4 == false) goto L13;
        if (r2 == false) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        int r3 = 2131235311;
    L21:
        ((RecyclerView.ViewHolder) r10).itemView.setBackgroundResource(r3);
        ((RecyclerView.ViewHolder) r10).itemView.setBackgroundTintList(this.a.getResources().getColorStateList(2131101932));
        if (this.c != r9) goto L46;
        r10.b.setTextColor(this.a.getResources().getColor(2131105548));
        if (r0.c == false) goto L26;
        int r6 = 2131255791;
    L27:
        r10.d.setImageResource(r6);
        com.bytedance.ee.util.ui.l.c(r10.d, 2131105548);
        TextView r7 = r10.c;
        Context r11 = this.a;
        if (r11 == null) goto L44;
        SortAscType r12 = r0.f;
        if (r12 != SortAscType.TITLE) goto L38;
        if (r0.c == false) goto L35;
        int r13 = 2131889595;
    L36:
        String r14 = r11.getString(r13);
    L45:
        r7.setText(r14);
    L48:
        if (r9 != (((ArrayList) this.b).size() - 1)) goto L50;
        r10.e.setVisibility(8);
    L51:
        r10.a.setOnClickListener(new c(this, r9, r0));
        return;
    L50:
        r10.e.setVisibility(0);
        goto L51
    L35:
        r13 = 2131889596;
        goto L36
    L38:
        if (r12 != SortAscType.TIME) goto L44;
        if (r0.c == false) goto L42;
        int r15 = 2131889593;
    L43:
        r14 = r11.getString(r15);
        goto L45
    L42:
        r15 = 2131889606;
    L44:
        r14 = "";
        goto L45
    L26:
        r6 = 2131255780;
        goto L27
    L46:
        r10.b.setTextColor(this.a.getResources().getColor(2131106622));
        r10.d.setImageDrawable(null);
        goto L48
    L16:
        if (r4 == false) goto L18;
        r3 = 2131235323;
        goto L21
    L18:
        if (r2 == false) goto L20;
        r3 = 2131235317;
        goto L21
    L20:
        r3 = 2131235305;
    L13:
        r5 = false;
        goto L14
    L9:
        r2 = false;
        goto L10
    L5:
        r4 = false;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        this.a = r4.getContext();
        return new b(LayoutInflater.from(this.a).inflate(2131563514, r4, false));
    }
}
