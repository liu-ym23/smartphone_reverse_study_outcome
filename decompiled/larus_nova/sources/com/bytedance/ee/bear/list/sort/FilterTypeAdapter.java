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
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: classes18.dex */
public class FilterTypeAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f229629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<FilterType> f229630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f229631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f229632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f229633e;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f229634a;

        public ViewHolder(View r100) {
            super(r100);
            this.f229634a = (TextView) r100.findViewById(R.id.tv_item);
        }
    }

    public class a extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f229635c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f229636d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ FilterType f229637e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FilterTypeAdapter f229638f;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            if (this.f229635c == false) goto L6;
            Context r101 = this.f229638f.f229629a;
            Toast.showFailureText(r101, r101.getString(R.string.LarkCCM_Drive_UnsupportedAction_Toast), 0);
            return;
        L6:
            FilterTypeAdapter r102 = this.f229638f;
            r102.f229631c = this.f229636d;
            b r103 = r102.f229633e;
            if (r103 == null) goto L13;
            FilterType r104 = this.f229637e;
            h r105 = ((zd5.l) r103).f571305a;
            r105.s();
            SortTypeAdapter r106 = r105.f229723q;
            r106.f229685d = r104;
            r106.notifyDataSetChanged();
            if (r105.f229716j == true) goto L13;
            com.bytedance.ee.bear.list.sort.a.InterfaceC3282a r107 = r105.f229724r;
            if (r107 == null) goto L13;
            r107.z2(r105.o());
        L13:
            this.f229638f.notifyDataSetChanged();
        }

        public a(FilterTypeAdapter r100, boolean r101, int r102, FilterType r103) {
            this.f229638f = r100;
            this.f229635c = r101;
            this.f229636d = r102;
            this.f229637e = r103;
        }
    }

    public interface b {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f229630b).size();
    }

    public final FilterType y2() {
        return (FilterType) ListProtector.get(this.f229630b, this.f229631c);
    L4:
        e = move-exception;
        tt5.a.d("FilterTypeAdapter", "getSelectedType err " + e.getMessage());
        return FilterType.ALL;
    }

    public FilterTypeAdapter() {
        this.f229630b = new ArrayList();
    }

    public ViewHolder A2(ViewGroup r100) {
        this.f229629a = r100.getContext();
        return new ViewHolder(LayoutInflater.from(this.f229629a).inflate(R.layout.grid_filter_type_item, r100, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        z2((ViewHolder) r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return A2(r100);
    }

    public void z2(ViewHolder r100, int r101) {
        FilterType r102 = (FilterType) ListProtector.get(this.f229630b, r101);
        r100.f229634a.setText(r102.getResId());
        q r103 = this.f229632d;
        if (r103 != null) goto L5;
    L7:
        boolean r104 = false;
    L9:
        if (this.f229631c != r101) goto L11;
        r100.f229634a.setTextColor(this.f229629a.getResources().getColor(R.color.primary_fill_default));
        r100.f229634a.setBackgroundResource(R.drawable.list_edit_filter_selected_bg);
    L16:
        r100.f229634a.setOnClickListener(new a(this, r104, r101, r102));
        return;
    L11:
        TextView r105 = r100.f229634a;
        Resources r106 = this.f229629a.getResources();
        if (r104 == false) goto L14;
        int r107 = R.color.text_disable;
    L15:
        r105.setTextColor(r106.getColor(r107));
        r100.f229634a.setBackgroundResource(R.drawable.list_edit_filter_default_bg);
        goto L16
    L14:
        r107 = R.color.text_caption;
        goto L15
    L5:
        if (r103.f571310a != r102.getForbiddenSortResId().intValue()) goto L7;
        r104 = true;
        goto L9
    }
}
