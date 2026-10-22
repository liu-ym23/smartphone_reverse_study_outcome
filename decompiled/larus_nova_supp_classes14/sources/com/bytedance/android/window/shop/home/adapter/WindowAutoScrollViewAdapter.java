package com.bytedance.android.window.shop.home.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import pp3.a;
import uq3.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/window/shop/home/adapter/WindowAutoScrollViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/window/shop/home/adapter/WindowAutoScrollViewHolder;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowAutoScrollViewAdapter extends RecyclerView.Adapter<WindowAutoScrollViewHolder> {
    public final List<p> a;
    public Function1<? super String, Unit> b;

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public WindowAutoScrollViewAdapter() {
        this.a = new ArrayList();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
        WindowAutoScrollViewHolder r7 = (WindowAutoScrollViewHolder) r5;
        Intrinsics.checkNotNullParameter(r7, "holder");
        if (((ArrayList) this.a).size() == 0) goto L10;
        p r8 = (p) ListProtector.get(this.a, r6);
        Function1<? super String, Unit> r0 = this.b;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "vo");
        String r1 = r8.a;
        if (r1 == null) goto L11;
        r7.a.setText(r1);
        r7.b.setText(r8.b);
        int r2 = r7.c.getResources().getColor(2131105971);
        int r3 = r7.c.getResources().getColor(2131105921);
        r7.a.setTextColor(r2);
        r7.b.setTextColor(r2);
        ((TextView) r7.c.findViewById(2131371302)).setTextColor(r3);
        ((TextView) r7.c.findViewById(2131371303)).setTextColor(r3);
        r7.c.setOnClickListener(new a(r0, r8));
        return;
    L11:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new WindowAutoScrollViewHolder(LayoutInflater.from(r2.getContext()).inflate(2131561001, null));
    }
}
