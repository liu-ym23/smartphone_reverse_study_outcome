package com.bytedance.ee.bear.list.sort;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.widgets.t;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zd5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\tH\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ee/bear/list/sort/ListFilterTypeAdapter;", "Lcom/bytedance/ee/bear/list/sort/FilterTypeAdapter;", "<init>", "()V", "onCreateViewHolder", "Lcom/bytedance/ee/bear/list/sort/FilterTypeAdapter$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "initBackground", "contentmanager-list_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListFilterTypeAdapter extends FilterTypeAdapter {

    public static final class a extends t {
        public final /* synthetic */ boolean c;
        public final /* synthetic */ ListFilterTypeAdapter d;
        public final /* synthetic */ int e;
        public final /* synthetic */ FilterType f;

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r3) {
            Intrinsics.checkNotNullParameter(r3, "v");
            if (this.c == false) goto L6;
            Context r4 = this.d.a;
            Toast.showFailureText(r4, r4.getString(2131889467), 0);
            return;
        L6:
            ListFilterTypeAdapter r5 = this.d;
            r5.c = this.e;
            FilterTypeAdapter.b r6 = r5.e;
            if (r6 == null) goto L13;
            FilterType r0 = this.f;
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
            this.d.notifyDataSetChanged();
        }

        public a(boolean r1, ListFilterTypeAdapter r2, int r3, FilterType r4) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
            this.f = r4;
        }
    }

    public ListFilterTypeAdapter() {
    }

    @Override // com.bytedance.ee.bear.list.sort.FilterTypeAdapter
    public final FilterTypeAdapter.ViewHolder A2(ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        this.a = r5.getContext();
        return new FilterTypeAdapter.ViewHolder(LayoutInflater.from(this.a).inflate(2131563479, r5, false));
    }

    @Override // com.bytedance.ee.bear.list.sort.FilterTypeAdapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        z2((FilterTypeAdapter.ViewHolder) r1, r2);
    }

    @Override // com.bytedance.ee.bear.list.sort.FilterTypeAdapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return A2(r1);
    }

    @Override // com.bytedance.ee.bear.list.sort.FilterTypeAdapter
    public final void z2(FilterTypeAdapter.ViewHolder r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "holder");
        FilterType r0 = (FilterType) ListProtector.get(this.b, r9);
        r8.a.setText(r0.getResId());
        int r1 = getItemCount();
        boolean r2 = true;
        if (r9 != 0) goto L5;
        boolean r4 = true;
    L7:
        if (r9 != (r1 - 1)) goto L9;
        boolean r3 = true;
    L10:
        if (r4 == false) goto L13;
        if (r3 == false) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        int r6 = 2131235311;
    L21:
        ((RecyclerView.ViewHolder) r8).itemView.setBackgroundResource(r6);
        View r7 = ((RecyclerView.ViewHolder) r8).itemView;
        Context r10 = this.a;
        if (r10 == null) goto L26;
        Resources r11 = r10.getResources();
        if (r11 == null) goto L26;
        ColorStateList r12 = r11.getColorStateList(2131101932);
    L27:
        r7.setBackgroundTintList(r12);
        if (r3 == false) goto L30;
        ((RecyclerView.ViewHolder) r8).itemView.findViewById(2131369197).setVisibility(8);
    L30:
        ImageView r13 = (ImageView) ((RecyclerView.ViewHolder) r8).itemView.findViewById(2131385840);
        q r14 = this.d;
        if (r14 == null) goto L38;
        int r15 = r14.a;
        Integer r16 = r0.getForbiddenSortResId();
        if (r16 == null) goto L38;
        if (r15 != r16.intValue()) goto L38;
    L40:
        if (this.c != r9) goto L42;
        r8.a.setTextColor(this.a.getResources().getColor(2131105548));
        r13.setVisibility(0);
    L47:
        r8.a.setOnClickListener(new a(r2, this, r9, r0));
        return;
    L42:
        TextView r17 = r8.a;
        Resources r18 = this.a.getResources();
        if (r2 == false) goto L45;
        int r19 = 2131106610;
    L46:
        r17.setTextColor(r18.getColor(r19));
        r13.setVisibility(8);
        goto L47
    L45:
        r19 = 2131106622;
    L38:
        r2 = false;
    L26:
        r12 = null;
        goto L27
    L16:
        if (r4 == false) goto L18;
        r6 = 2131235323;
        goto L21
    L18:
        if (r3 == false) goto L20;
        r6 = 2131235317;
        goto L21
    L20:
        r6 = 2131235305;
    L13:
        r5 = false;
        goto L14
    L9:
        r3 = false;
        goto L10
    L5:
        r4 = false;
        goto L7
    }
}
