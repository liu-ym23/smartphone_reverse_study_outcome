package com.bytedance.ee.bear.quoto;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class SingleFileExceedQuotaSuiteAdapter extends RecyclerView.Adapter<SuiteItemViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<j0> f236334a;

    public static class SuiteItemViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f236335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f236336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f236337c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f236338d;

        public SuiteItemViewHolder(View r100) {
            super(r100);
            this.f236335a = r100.findViewById(R.id.suite_content);
            this.f236336b = (TextView) r100.findViewById(R.id.tv_suite_size);
            this.f236337c = (TextView) r100.findViewById(R.id.tv_suite_type_name);
            this.f236338d = r100.findViewById(R.id.divide);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return hu5.a.c(this.f236334a);
    }

    public SingleFileExceedQuotaSuiteAdapter() {
        this.f236334a = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        SuiteItemViewHolder r102 = (SuiteItemViewHolder) r100;
        j0 r103 = (j0) ListProtector.get(this.f236334a, r101);
        String r104 = r103.f236410a;
        String r105 = r103.f236411b;
        String r106 = r103.f236412c;
        TextView r107 = r102.f236336b;
        if (TextUtils.isEmpty(r105) == false) goto L5;
        r105 = "";
    L5:
        r107.setText(r105);
        TextView r108 = r102.f236337c;
        if (TextUtils.isEmpty(r106) == false) goto L8;
        r106 = "";
    L8:
        r108.setText(r106);
        Resources r109 = r102.itemView.getContext().getResources();
        List<String> r110 = k0.f236413a;
        if (TextUtils.equals(r104, "5") == false) goto L12;
        r102.f236335a.setBackgroundTintList(r109.getColorStateList(R.color.primary_fill_solid_01));
        r102.f236336b.setTextColor(r109.getColor(R.color.primary_pri_700));
        r102.f236337c.setTextColor(r109.getColor(R.color.primary_pri_700));
        r102.f236338d.setBackgroundTintList(r109.getColorStateList(R.color.primary_fill_default));
        return;
    L12:
        if (TextUtils.equals(r104, "6") == false) goto L14;
        r102.f236335a.setBackgroundTintList(r109.getColorStateList(R.color.function_success_fill_solid_01));
        r102.f236336b.setTextColor(r109.getColor(R.color.function_success_700));
        r102.f236337c.setTextColor(r109.getColor(R.color.function_success_700));
        r102.f236338d.setBackgroundTintList(r109.getColorStateList(R.color.function_success_fill_default));
        return;
    L14:
        r102.f236335a.setBackgroundTintList(r109.getColorStateList(R.color.ud_neutral_color_2));
        r102.f236336b.setTextColor(r109.getColor(R.color.text_caption));
        r102.f236337c.setTextColor(r109.getColor(R.color.text_caption));
        r102.f236338d.setBackgroundTintList(r109.getColorStateList(R.color.ud_neutral_color_7));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new SuiteItemViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.suite_type_item_grid, r100, false));
    }
}
