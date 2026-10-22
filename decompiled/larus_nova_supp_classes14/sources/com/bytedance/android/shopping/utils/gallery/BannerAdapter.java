package com.bytedance.android.shopping.utils.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/utils/gallery/BannerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/shopping/utils/gallery/BannerAdapter$BannerHolder;", "BannerHolder", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BannerAdapter extends RecyclerView.Adapter<BannerHolder> {
    public final List<Function1<Float, Unit>> a;
    public final int b;
    public final Context c;
    public final List<String> d;
    public final int e;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/utils/gallery/BannerAdapter$BannerHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class BannerHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int a = 0;

        public BannerHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
        }

        public static void T3(Float r3, TextView r4, View r5) {
            if (r3 == null) goto L8;
            if (r4 == null) goto L5;
            r4.setAlpha(1 - ((float) Math.sqrt(r3.floatValue())));
        L5:
            if (r5 == null) goto L9;
            r5.setAlpha(r3.floatValue());
            return;
        L9:
            return;
        }
    }

    public final int getItemCount() {
        return this.d.size();
    }

    public final void y2(float r6) {
        int r0 = this.e;
        int r1 = ((int) Math.rint((r6 - (r0 / 2)) / (r0 + this.b))) + 1;
        int r2 = r1 - 1;
        int r3 = r1 + 1;
        if (r2 > r3) goto L9;
    L4:
        int r4 = this.e;
        float r5 = 1.0f - Math.min(1.0f, Math.abs((((r2 - 1) * (this.b + r4)) + (r4 / 2)) - r6) / (this.e + this.b));
        Function1 r7 = (Function1) CollectionsKt.getOrNull(this.a, r2);
        if (r7 == null) goto L7;
        Unit r8 = (Unit) r7.invoke(Float.valueOf(r5));
    L7:
        if (r2 == r3) goto L11;
        r2 = r2 + 1;
        goto L4
    L11:
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r9, int r10) {
        final BannerHolder r11 = (BannerHolder) r9;
        Intrinsics.checkNotNullParameter(r11, "holder");
        List<Function1<Float, Unit>> r0 = this.a;
        String r1 = (String) ListProtector.get(this.d, r10);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r1, "title");
        final TextView r2 = (TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390214);
        final View r3 = ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131363957);
        final TextView r4 = (TextView) ((RecyclerView.ViewHolder) r11).itemView.findViewById(2131390215);
        if (r2 == null) goto L5;
        r2.setText(r1);
    L5:
        if (r4 != null) goto L7;
    L26:
        BannerHolder.T3(Float.valueOf(0.0f), r2, r3);
        ListProtector.set(r0, r10, new BannerAdapter$BannerHolder$bind$1(r11, r2, r4, r3));
        return;
    L7:
        if (r1.length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        String r6 = "";
        if (r5 == false) goto L13;
        String r7 = com.bytedance.android.shopping.extensions.j.c(2131896402) + ' ' + r1;
    L14:
        Intrinsics.checkNotNullParameter(r4, "$this$setNonLineBreakingText");
        ViewParent r8 = r4.getParent();
        if ((r8 instanceof ViewGroup) == true) goto L17;
        r8 = null;
    L17:
        ViewGroup r12 = (ViewGroup) r8;
        if (r12 == null) goto L22;
        if (r7 == null) goto L22;
        r4.setVisibility(4);
        r4.setText(r7);
        r12.post(new b(r4, r12, r7));
    L22:
        if (r7 == null) goto L25;
        r6 = r7;
    L25:
        r4.setText(r6);
        goto L26
    L13:
        r7 = "";
        goto L14
    L9:
        r5 = false;
        goto L10
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        View r5 = th.a.c(r3.getContext(), 2131560519, r3, false);
        r5.post(new a(this, r5));
        return new BannerHolder(r5);
    }

    public BannerAdapter(Context r2, List<String> r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        Intrinsics.checkNotNullParameter(r3, "titles");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        int r5 = getItemCount();
        ArrayList r6 = new ArrayList(r5);
        int r7 = 0;
    L3:
        if (r7 >= r5) goto L5;
        r6.add(null);
        r7 = r7 + 1;
        goto L3
    L5:
        this.a = r6;
        this.b = com.bytedance.android.shopping.extensions.b.b(32);
        k1.n(this.c);
    }
}
