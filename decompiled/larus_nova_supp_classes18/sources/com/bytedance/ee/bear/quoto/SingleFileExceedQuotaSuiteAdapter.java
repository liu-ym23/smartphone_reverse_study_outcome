package com.bytedance.ee.bear.quoto;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SingleFileExceedQuotaSuiteAdapter extends RecyclerView.Adapter<SuiteItemViewHolder> {
    public List<j0> a;

    public static class SuiteItemViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final TextView b;
        public final TextView c;
        public final View d;

        public SuiteItemViewHolder(View r2) {
            super(r2);
            this.a = r2.findViewById(2131387716);
            this.b = (TextView) r2.findViewById(2131391535);
            this.c = (TextView) r2.findViewById(2131391536);
            this.d = r2.findViewById(2131369186);
        }
    }

    public final int getItemCount() {
        return hu5.a.c(this.a);
    }

    public SingleFileExceedQuotaSuiteAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        SuiteItemViewHolder r8 = (SuiteItemViewHolder) r6;
        j0 r9 = (j0) ListProtector.get(this.a, r7);
        String r0 = r9.a;
        String r1 = r9.b;
        String r10 = r9.c;
        TextView r2 = r8.b;
        if (TextUtils.isEmpty(r1) == false) goto L5;
        r1 = "";
    L5:
        r2.setText(r1);
        TextView r3 = r8.c;
        if (TextUtils.isEmpty(r10) == false) goto L8;
        r10 = "";
    L8:
        r3.setText(r10);
        Resources r11 = ((RecyclerView.ViewHolder) r8).itemView.getContext().getResources();
        List<String> r4 = k0.a;
        if (TextUtils.equals(r0, "5") == false) goto L12;
        r8.a.setBackgroundTintList(r11.getColorStateList(2131105552));
        r8.b.setTextColor(r11.getColor(2131105580));
        r8.c.setTextColor(r11.getColor(2131105580));
        r8.d.setBackgroundTintList(r11.getColorStateList(2131105548));
        return;
    L12:
        if (TextUtils.equals(r0, "6") == false) goto L14;
        r8.a.setBackgroundTintList(r11.getColorStateList(2131102161));
        r8.b.setTextColor(r11.getColor(2131102150));
        r8.c.setTextColor(r11.getColor(2131102150));
        r8.d.setBackgroundTintList(r11.getColorStateList(2131102157));
        return;
    L14:
        r8.a.setBackgroundTintList(r11.getColorStateList(2131108937));
        r8.b.setTextColor(r11.getColor(2131106607));
        r8.c.setTextColor(r11.getColor(2131106607));
        r8.d.setBackgroundTintList(r11.getColorStateList(2131108942));
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        return new SuiteItemViewHolder(LayoutInflater.from(r4.getContext()).inflate(2131564909, r4, false));
    }
}
