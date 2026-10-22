package com.bytedance.ee.bear.more.view3;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.more.protocol3.i;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class MoreAdapter extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f235009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f235010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f235011c;

    public static class a extends RecyclerView.ViewHolder {
        public a(View r100) {
            super(r100);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f235010b.f234895a.size();
    }

    public MoreAdapter() {
        this.f235010b = i.f234894c;
        this.f235011c = new c();
    }

    public MoreAdapter(k r100) {
        this.f235010b = i.f234894c;
        this.f235011c = new c();
        this.f235009a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        k r101 = this.f235010b.a(r100);
        this.f235011c.f235023a = r101;
        return c.a(r101);
    }

    public final void y2(i r100) {
        i r101 = this.f235010b;
        this.f235010b = r100;
        k r102 = this.f235009a;
        Iterator<k> r103 = r100.f234895a.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().f234902b = r102;
        goto L4
    L6:
        DiffUtil.calculateDiff(new MoreDiffCallback(r101, this.f235010b)).dispatchUpdatesTo(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Integer] */
    public final void z2(Object r110) {
        i r100 = this.f235010b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "uiItem");
        Integer r101 = r100.f234896b.get(r110.f234901a);
        if (r101 == null) goto L5;
        ListProtector.set(r100.f234895a, r101.intValue(), r110);
        boolean r102 = true;
    L6:
        i r103 = this.f235010b;
        String r104 = r110.f234901a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "id");
        Integer r105 = r103.f234896b.get(r104);
        if (r105 != null) goto L20;
        Iterator<T> r106 = r103.f234895a.iterator();
        int r107 = 0;
    L10:
        if (r106.hasNext() == false) goto L20;
        int r108 = r107 + 1;
        i r109 = ((k) r106.next()).d();
        if (r109 == null) goto L16;
        Intrinsics.checkNotNullParameter(r104, "id");
        Integer r111 = r109.f234896b.get(r104);
        if (r111 == null) goto L16;
        int r112 = r111.intValue();
        k r113 = (k) CollectionsKt.getOrNull(r109.f234895a, r112);
    L17:
        if (r113 != null) goto L23;
        r107 = r108;
    L23:
        if (r107 < 0) goto L30;
        if (r102 == false) goto L26;
        r110 = 0;
    L26:
        notifyItemChanged(r107, r110);
        return;
    L30:
        return;
    L16:
        r113 = null;
    L20:
        if (r105 == null) goto L22;
        r107 = r105.intValue();
        goto L23
    L22:
        r107 = -1;
        goto L23
    L5:
        r102 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        a r102 = (a) r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        c r102 = this.f235011c;
        k r103 = r102.f235023a;
        if (r103 != null) goto L5;
    L7:
        Iterator<k> r104 = this.f235010b.f234895a.iterator();
    L9:
        if (r104.hasNext() == false) goto L16;
        k r105 = r104.next();
        if (c.a(r105) != r101) goto L9;
        k r106 = r105;
    L14:
        return new a(r106.c(r100));
    L16:
        throw new IllegalStateException("Invalid viewType!");
    L5:
        if (c.a(r103) != r101) goto L7;
        r106 = r102.f235023a;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101, List r102) {
        a r103 = (a) r100;
        k r104 = this.f235010b.a(r101);
        if (hu5.a.d(r102) == false) goto L5;
    L7:
        r102 = null;
    L8:
        r104.b(r103.itemView, r102);
        return;
    L5:
        if (r102.contains(0) == true) goto L7;
        goto L7
    }
}
