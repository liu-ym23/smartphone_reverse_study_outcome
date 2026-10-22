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
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.List;
import zd5.q;

/* JADX INFO: loaded from: classes18.dex */
public class SortAdapter extends RecyclerView.Adapter<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f229643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<q> f229644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f229645c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f229646d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f229647e;

    public interface a {
    }

    public static class b extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinearLayout f229648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f229649b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f229650c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f229651d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f229652e;

        public b(View r100) {
            super(r100);
            this.f229648a = (LinearLayout) r100.findViewById(R.id.ll_item);
            this.f229649b = (TextView) r100.findViewById(R.id.tv_sort);
            this.f229651d = (ImageView) r100.findViewById(R.id.iv_sort);
            this.f229650c = (TextView) r100.findViewById(R.id.iv_sort_desc);
            this.f229652e = r100.findViewById(R.id.divider);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f229644b).size();
    }

    public SortAdapter(boolean r100) {
        this.f229644b = new ArrayList();
        this.f229646d = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        b r102 = (b) r100;
        q r103 = (q) ListProtector.get(this.f229644b, r101);
        r102.f229649b.setText(r103.f571310a);
        int r104 = getItemCount();
        if (r101 != 0) goto L5;
        boolean r105 = true;
    L7:
        if (r101 != (r104 - 1)) goto L9;
        boolean r106 = true;
    L10:
        if (r105 == false) goto L13;
        if (r106 == false) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L16;
        int r108 = R.drawable.facade_round_around_m;
    L21:
        r102.itemView.setBackgroundResource(r108);
        r102.itemView.setBackgroundTintList(this.f229643a.getResources().getColorStateList(R.color.facade_selector_item_float));
        if (this.f229645c != r101) goto L46;
        r102.f229649b.setTextColor(this.f229643a.getResources().getColor(R.color.primary_fill_default));
        if (r103.f571312c == false) goto L26;
        int r109 = R.drawable.ud_icon_space_up_bold_outlined;
    L27:
        r102.f229651d.setImageResource(r109);
        com.bytedance.ee.util.ui.l.c(r102.f229651d, R.color.primary_fill_default);
        TextView r110 = r102.f229650c;
        Context r111 = this.f229643a;
        if (r111 == null) goto L44;
        SortAscType r112 = r103.f571315f;
        if (r112 != SortAscType.TITLE) goto L38;
        if (r103.f571312c == false) goto L35;
        int r113 = R.string.LarkCCM_NewCM_FromAToZ_Option;
    L36:
        String r114 = r111.getString(r113);
    L45:
        r110.setText(r114);
    L48:
        if (r101 != (((ArrayList) this.f229644b).size() - 1)) goto L50;
        r102.f229652e.setVisibility(8);
    L51:
        r102.f229648a.setOnClickListener(new c(this, r101, r103));
        return;
    L50:
        r102.f229652e.setVisibility(0);
        goto L51
    L35:
        r113 = R.string.LarkCCM_NewCM_FromZToA_Option;
        goto L36
    L38:
        if (r112 != SortAscType.TIME) goto L44;
        if (r103.f571312c == false) goto L42;
        int r115 = R.string.LarkCCM_NewCM_EarliestToLatest_Option;
    L43:
        r114 = r111.getString(r115);
        goto L45
    L42:
        r115 = R.string.LarkCCM_NewCM_LatestToEarliest_Option;
    L44:
        r114 = "";
        goto L45
    L26:
        r109 = R.drawable.ud_icon_space_down_bold_outlined;
        goto L27
    L46:
        r102.f229649b.setTextColor(this.f229643a.getResources().getColor(R.color.text_title));
        r102.f229651d.setImageDrawable(null);
        goto L48
    L16:
        if (r105 == false) goto L18;
        r108 = R.drawable.facade_round_top_m;
        goto L21
    L18:
        if (r106 == false) goto L20;
        r108 = R.drawable.facade_round_bottom_m;
        goto L21
    L20:
        r108 = R.drawable.facade_rectangle;
    L13:
        r107 = false;
        goto L14
    L9:
        r106 = false;
        goto L10
    L5:
        r105 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        this.f229643a = r100.getContext();
        return new b(LayoutInflater.from(this.f229643a).inflate(R.layout.list_sort_item, r100, false));
    }
}
