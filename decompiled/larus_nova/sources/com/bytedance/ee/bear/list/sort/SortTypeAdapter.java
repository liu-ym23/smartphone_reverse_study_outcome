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
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: classes18.dex */
public class SortTypeAdapter extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f229682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<q> f229683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f229684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FilterType f229685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f229686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f229687f;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinearLayout f229688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f229689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f229690c;

        public b(View r100) {
            super(r100);
            this.f229688a = (LinearLayout) r100.findViewById(R.id.ll_item);
            this.f229689b = (ImageView) r100.findViewById(R.id.iv_icon);
            this.f229690c = (TextView) r100.findViewById(R.id.tv_name);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f229683b).size();
    }

    public SortTypeAdapter() {
        this.f229683b = new ArrayList();
        this.f229686e = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        b r102 = (b) r100;
        q r103 = (q) ListProtector.get(this.f229683b, r101);
        r102.f229690c.setText(r103.f571310a);
        FilterType r104 = this.f229685d;
        int r105 = 0;
        if (r104 != null) goto L5;
    L7:
        boolean r106 = false;
    L9:
        if (this.f229684c != r101) goto L19;
        ImageView r107 = r102.f229689b;
        if (this.f229686e == true) goto L14;
        r105 = 8;
    L14:
        r107.setVisibility(r105);
        r102.f229690c.setTextColor(this.f229682a.getResources().getColor(R.color.primary_fill_default));
        r102.f229688a.setBackgroundResource(R.drawable.list_edit_filter_selected_bg);
        ImageView r108 = r102.f229689b;
        if (r103.f571312c == false) goto L17;
        Drawable r109 = this.f229682a.getDrawable(R.drawable.ud_icon_space_up_outlined);
    L18:
        r108.setBackground(r109);
        com.bytedance.ee.util.ui.l.b(r102.f229689b, R.color.primary_fill_default);
    L24:
        r102.f229688a.setOnClickListener(new j(this, r106, r101, r103));
        return;
    L17:
        r109 = this.f229682a.getDrawable(R.drawable.ud_icon_space_down_outlined);
        goto L18
    L19:
        TextView r110 = r102.f229690c;
        Resources r111 = this.f229682a.getResources();
        if (r106 == false) goto L22;
        int r112 = R.color.text_disable;
    L23:
        r110.setTextColor(r111.getColor(r112));
        r102.f229688a.setBackgroundResource(R.drawable.list_edit_filter_default_bg);
        r102.f229689b.setVisibility(8);
        r102.f229689b.setBackground(null);
        goto L24
    L22:
        r112 = R.color.text_caption;
        goto L23
    L5:
        if (r104.getResId() != r103.f571314e.intValue()) goto L7;
        r106 = true;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        this.f229682a = r100.getContext();
        return new b(LayoutInflater.from(this.f229682a).inflate(R.layout.list_filter_sort_item, r100, false));
    }
}
