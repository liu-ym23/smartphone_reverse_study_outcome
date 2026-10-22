package com.bytedance.ee.bear.list.sort;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FilterTypeAdapter extends RecyclerView.Adapter<ViewHolder> {
    public Context a;
    public final List<FilterType> b;
    public int c;
    public q d;
    public b e;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;

        public ViewHolder(View r2) {
            super(r2);
            this.a = (TextView) r2.findViewById(2131390822);
        }
    }

    public class a extends t {
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ FilterType e;
        public final /* synthetic */ FilterTypeAdapter f;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            if (this.c == false) goto L6;
            Context r4 = this.f.a;
            Toast.showFailureText(r4, r4.getString(2131889467), 0);
            return;
        L6:
            FilterTypeAdapter r5 = this.f;
            r5.c = this.d;
            b r6 = r5.e;
            if (r6 == null) goto L13;
            FilterType r0 = this.e;
            h r7 = ((zd5.l) r6).a;
            r7.s();
            SortTypeAdapter r1 = r7.q;
            r1.d = r0;
            r1.notifyDataSetChanged();
            if (r7.j == true) goto L13;
            com.bytedance.ee.bear.list.sort.a.InterfaceC0035a r2 = r7.r;
            if (r2 == null) goto L13;
            r2.z2(r7.o());
        L13:
            this.f.notifyDataSetChanged();
        }

        public a(FilterTypeAdapter r1, boolean r2, int r3, FilterType r4) {
            this.f = r1;
            this.c = r2;
            this.d = r3;
            this.e = r4;
        }
    }

    public interface b {
    }

    public final int getItemCount() {
        return ((ArrayList) this.b).size();
    }

    public final FilterType y2() {
        return (FilterType) ListProtector.get(this.b, this.c);
    L4:
        e = move-exception;
        tt5.a.d("FilterTypeAdapter", "getSelectedType err " + e.getMessage());
        return FilterType.ALL;
    }

    public FilterTypeAdapter() {
        this.b = new ArrayList();
    }

    public ViewHolder A2(ViewGroup r5) {
        this.a = r5.getContext();
        return new ViewHolder(LayoutInflater.from(this.a).inflate(2131561504, r5, false));
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        z2((ViewHolder) r1, r2);
    }

    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return A2(r1);
    }

    public void z2(ViewHolder r6, int r7) {
        FilterType r0 = (FilterType) ListProtector.get(this.b, r7);
        r6.a.setText(r0.getResId());
        q r1 = this.d;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (this.c != r7) goto L11;
        r6.a.setTextColor(this.a.getResources().getColor(2131105548));
        r6.a.setBackgroundResource(2131243703);
    L16:
        r6.a.setOnClickListener(new a(this, r2, r7, r0));
        return;
    L11:
        TextView r3 = r6.a;
        Resources r4 = this.a.getResources();
        if (r2 == false) goto L14;
        int r5 = 2131106610;
    L15:
        r3.setTextColor(r4.getColor(r5));
        r6.a.setBackgroundResource(2131243700);
        goto L16
    L14:
        r5 = 2131106607;
        goto L15
    L5:
        if (r1.a != r0.getForbiddenSortResId().intValue()) goto L7;
        r2 = true;
        goto L9
    }
}
