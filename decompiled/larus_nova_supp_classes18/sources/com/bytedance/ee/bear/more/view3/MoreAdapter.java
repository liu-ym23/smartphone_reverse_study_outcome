package com.bytedance.ee.bear.more.view3;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.more.protocol3.i;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MoreAdapter extends RecyclerView.Adapter<a> {
    public final k a;
    public i b;
    public final c c;

    public static class a extends RecyclerView.ViewHolder {
        public a(View r1) {
            super(r1);
        }
    }

    public final int getItemCount() {
        return this.b.a.size();
    }

    public MoreAdapter() {
        this.b = i.c;
        this.c = new c();
    }

    public MoreAdapter(k r2) {
        this.b = i.c;
        this.c = new c();
        this.a = r2;
    }

    public final int getItemViewType(int r2) {
        k r3 = this.b.a(r2);
        this.c.a = r3;
        return c.a(r3);
    }

    public final void y2(i r4) {
        i r0 = this.b;
        this.b = r4;
        k r1 = this.a;
        Iterator<k> r5 = r4.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().b = r1;
        goto L4
    L6:
        DiffUtil.calculateDiff(new MoreDiffCallback(r0, this.b)).dispatchUpdatesTo(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Integer] */
    public final void z2(Object r11) {
        i r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r11, "uiItem");
        Integer r1 = r0.b.get(r11.a);
        if (r1 == null) goto L5;
        ListProtector.set(r0.a, r1.intValue(), r11);
        boolean r2 = true;
    L6:
        i r3 = this.b;
        String r4 = r11.a;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_ID);
        Integer r5 = r3.b.get(r4);
        if (r5 != null) goto L20;
        Iterator<T> r6 = r3.a.iterator();
        int r7 = 0;
    L10:
        if (r6.hasNext() == false) goto L20;
        int r8 = r7 + 1;
        i r9 = ((k) r6.next()).d();
        if (r9 == null) goto L16;
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_ID);
        Integer r10 = r9.b.get(r4);
        if (r10 == null) goto L16;
        int r12 = r10.intValue();
        k r13 = (k) CollectionsKt.getOrNull(r9.a, r12);
    L17:
        if (r13 != null) goto L23;
        r7 = r8;
    L23:
        if (r7 < 0) goto L30;
        if (r2 == false) goto L26;
        r11 = 0;
    L26:
        notifyItemChanged(r7, r11);
        return;
    L30:
        return;
    L16:
        r13 = null;
    L20:
        if (r5 == null) goto L22;
        r7 = r5.intValue();
        goto L23
    L22:
        r7 = -1;
        goto L23
    L5:
        r2 = false;
        goto L6
    }

    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        a r3 = (a) r1;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        c r0 = this.c;
        k r1 = r0.a;
        if (r1 != null) goto L5;
    L7:
        Iterator<k> r2 = this.b.a.iterator();
    L9:
        if (r2.hasNext() == false) goto L16;
        k r3 = r2.next();
        if (c.a(r3) != r5) goto L9;
        k r6 = r3;
    L14:
        return new a(r6.c(r4));
    L16:
        throw new IllegalStateException("Invalid viewType!");
    L5:
        if (c.a(r1) != r5) goto L7;
        r6 = r0.a;
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3, List r4) {
        a r5 = (a) r2;
        k r6 = this.b.a(r3);
        if (hu5.a.d(r4) == false) goto L5;
    L7:
        r4 = null;
    L8:
        r6.b(((RecyclerView.ViewHolder) r5).itemView, r4);
        return;
    L5:
        if (r4.contains(0) == true) goto L7;
        goto L7
    }
}
