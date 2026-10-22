package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import com.bytedance.android.ecom.arch.slice.g;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.r;
import com.bytedance.android.ecom.arch.slice.slices.template.SlcTemplateView;
import com.bytedance.android.shopping.anchorv4.helper.SlcTemplateViewHelper;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderSliceModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ScrollContainerFooter;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.c0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.d0;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.w;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/container/HeadAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<HeaderContentModel> a;
    public ScrollContainerFooter b;
    public final b c;
    public final s d;
    public final RecyclerView e;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        int r0 = ((ArrayList) this.a).size();
        if (this.b == null) goto L5;
        int r1 = 1;
    L7:
        return r0 + r1;
    L5:
        r1 = 0;
        goto L7
    }

    public final int getItemViewType(int r2) {
        if (r2 >= ((ArrayList) this.a).size()) goto L5;
        return 0;
    L5:
        return 1;
    }

    public final void onViewAttachedToWindow(RecyclerView.ViewHolder r3) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        super.onViewAttachedToWindow(r3);
        if ((r3 instanceof ItemViewHolder) == false) goto L6;
        y2(r3, (HeaderContentModel) CollectionsKt.getOrNull(this.a, ((ItemViewHolder) r3).getAdapterPosition()));
        return;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "holder");
        if ((r7 instanceof ItemViewHolder) == false) goto L10;
        HeaderContentModel r0 = (HeaderContentModel) ListProtector.get(this.a, r8);
        RoundedFrameLayout r2 = r7.itemView;
        if (r2 == null) goto L8;
        RoundedFrameLayout r3 = (w) r2;
        r3.setTag(Integer.valueOf(r8));
        r3.l(r0, r8, null);
        y2(r7, r0);
    L46:
        this.d.Nw();
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.ItemView");
    L10:
        if ((r7 instanceof FooterViewHolder) == false) goto L46;
        View r9 = r7.itemView;
        if ((r9 instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.a) == true) goto L14;
        r9 = null;
    L14:
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.a r10 = (com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.a) r9;
        if (r10 == null) goto L46;
        ScrollContainerFooter r11 = this.b;
        if (r11 == null) goto L19;
        HeaderSliceModel r12 = r11.getSlice();
    L20:
        if (r12 == null) goto L22;
        g r1 = r12.getGeckoSlice();
    L24:
        if (r1 == null) goto L33;
        c0 r4 = r10.b.yd().b("head-footer", r12.getGeckoSlice());
        if (r4 == null) goto L46;
        if (r4.b == false) goto L30;
        SlcTemplateViewHelper.c(r4.a, r12.getGeckoSlice(), null, 6);
    L30:
        r10.removeAllViews();
        SlcTemplateView r13 = r4.a.b;
        if (r13 == null) goto L46;
        wg.a.a(r13);
        r10.addView(r13, -2, -1);
        goto L46
    L33:
        d0 r5 = r10.b.yd();
        if (r12 == null) goto L36;
        SlcElement r6 = r12.getSliceTemplate();
    L37:
        r r14 = r5.c("head-footer", r6);
        if (r14 == null) goto L45;
        r10.removeAllViews();
        View r15 = r14.c;
        wg.a.a(r15);
        r15.setLayoutParams(new ViewGroup.LayoutParams(-2, -1));
        Unit r16 = Unit.INSTANCE;
        r10.addView(r15);
        if (r12 == null) goto L44;
        Map<String, Object> r17 = r12.getSliceTemplateData();
        if (r17 == null) goto L44;
        r14.a(MapsKt.mapOf(TuplesKt.to("data", r17)), null);
    L44:
        r10.setVisibility(0);
        goto L46
    L45:
        r10.setVisibility(8);
        goto L46
    L36:
        r6 = null;
        goto L37
    L22:
        r1 = null;
        goto L24
    L19:
        r12 = null;
        goto L20
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 != 0) goto L6;
        return new ItemViewHolder(new w(r4.getContext(), this.d, this.c));
    L6:
        return new FooterViewHolder(new com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.a(r4.getContext(), this.d, this.c));
    }

    public final void y2(RecyclerView.ViewHolder r6, HeaderContentModel r7) {
        if ((r6.itemView instanceof com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.a) == true) goto L27;
        if (r7 == null) goto L29;
        boolean r8 = !this.d.isExpanded();
        Object r0 = r6.itemView.getTag();
        Object r2 = null;
        if ((r0 instanceof Integer) == true) goto L9;
        r0 = null;
    L9:
        Integer r1 = (Integer) r0;
        if (r1 == null) goto L12;
        int r3 = r1.intValue();
    L13:
        View r4 = r6.itemView;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if ((r5 instanceof ViewGroup.MarginLayoutParams) == true) goto L16;
        r5 = null;
    L16:
        ViewGroup.MarginLayoutParams r9 = (ViewGroup.MarginLayoutParams) r5;
        if (r9 == null) goto L19;
        r9.width = this.c.l(r8, r3);
        r9.height = this.c.e(r8, r3);
        r9.leftMargin = this.c.g(r8, r3);
        r9.rightMargin = this.c.h(r8, r3);
        r9.topMargin = this.c.j(r8, r3, null);
        r9.bottomMargin = this.c.d(r8, r3, null);
        r4.setLayoutParams(r9);
    L19:
        View r10 = r6.itemView;
        if ((r10 instanceof w) == false) goto L23;
        r2 = r10;
    L23:
        w r11 = (w) r2;
        if (r11 == null) goto L28;
        r11.setRadius(this.c.i(r8, r3));
        return;
    L28:
        return;
    L12:
        r3 = -1;
        goto L13
    L29:
        return;
    }

    public HeadAdapter(b r2, s r3, HeadRecyclerView r4) {
        Intrinsics.checkNotNullParameter(r2, "sizeHelper");
        Intrinsics.checkNotNullParameter(r3, "headAbility");
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = new ArrayList();
    }
}
