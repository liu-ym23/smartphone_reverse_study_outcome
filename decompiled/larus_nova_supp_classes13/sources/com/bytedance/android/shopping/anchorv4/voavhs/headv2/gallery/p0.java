package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p0 extends RecyclerView.Adapter<r0> {
    public final List<s> a;
    public final l b;
    public final Function2<Integer, Integer, Unit> c;

    public final int getItemCount() {
        return this.a.size();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r11, int r12) {
        r0 r13 = (r0) r11;
        Intrinsics.checkNotNullParameter(r13, "holder");
        s r0 = (s) ListProtector.get(this.a, r12);
        int r2 = 0;
        if (r0.a.length() != 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L9;
        r13.a.c.setVisibility(8);
    L11:
        if (r0.f == true) goto L13;
    L15:
        r13.a.c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    L16:
        String r3 = r0.b;
        if (r3 != null) goto L19;
    L21:
        r13.a.setSelected(r0.f);
        r13.a.setOnClickListener(new o0(this, r0, r12));
        q0 r14 = r13.a;
        ViewGroup.LayoutParams r4 = r14.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L24;
        r4 = null;
    L24:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 != null) goto L27;
        r5 = new ViewGroup.MarginLayoutParams(-2, -2);
    L27:
        if (r12 == 0) goto L29;
        r2 = com.bytedance.android.shopping.extensions.b.a(8);
    L29:
        r5.leftMargin = r2;
        Unit r6 = Unit.INSTANCE;
        r14.setLayoutParams(r5);
        m r7 = this.b.g;
        r7.getClass();
        m.d(r7, "pdp_module_show", null, "more_video_item_" + r12, "a1.b34986.c503191.d47097_i" + (r12 + 1), 6);
        return;
    L19:
        if ((!Intrinsics.areEqual(r13.a.d.getTag(), r3)) == false) goto L21;
        r13.a.d.setTag(r3);
        com.bytedance.android.ec.core.utils.y.d(r13.a.d, r3);
        goto L21
    L13:
        if (r0.d == false) goto L15;
        r13.a.c.setCompoundDrawablesWithIntrinsicBounds(2131234640, 0, 0, 0);
        r13.a.c.setCompoundDrawablePadding((int) com.bytedance.android.ec.core.utils.q.a(Double.valueOf(1.5d)));
        goto L16
    L9:
        r13.a.c.setVisibility(0);
        r13.a.c.setText(r0.a);
        goto L11
    L5:
        r1 = false;
        goto L7
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        return new r0(new q0(r2.getContext()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p0(List<s> r2, l r3, Function2<? super Integer, ? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "items");
        Intrinsics.checkNotNullParameter(r3, "galleryCtx");
        Intrinsics.checkNotNullParameter(r4, "trySelectPosition");
        this.b = r3;
        this.c = r4;
        this.a = CollectionsKt.toMutableList(r2);
    }
}
