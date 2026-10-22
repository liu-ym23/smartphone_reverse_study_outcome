package com.bytedance.locallife.poi.media.ui.indicator.base;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.poi.media.ui.indicator.PoiPagerIndicator;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/poi/media/ui/indicator/base/AbsPagerIndicatorAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class AbsPagerIndicatorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f262888a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f262889b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f262890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f262891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<PoiPagerIndicator> f262892e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f262893f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f262894g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f262895h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f262896i;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f262892e).size();
    }

    public final void y2(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        int r102 = this.f262889b;
        if (r102 != Integer.MAX_VALUE) goto L6;
        r100.itemView.setAlpha(1.0f);
        return;
    L6:
        int r103 = Math.max(r102 / 2, 1);
        if (Math.abs(r101 - this.f262893f) >= r103) goto L10;
        r100.itemView.setAlpha(1.0f);
        return;
    L10:
        if (this.f262890c > 0) goto L12;
    L14:
        r100.itemView.setAlpha(0.0f);
        return;
    L12:
        if (Math.abs(r101 - this.f262893f) != r103) goto L14;
        r100.itemView.setAlpha(this.f262891d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, final int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "payloads");
        super.onBindViewHolder(r100, r101, r102);
        boolean r103 = false;
        boolean r104 = true;
        if (r101 >= 0) goto L5;
    L7:
        if (r103 == true) goto L9;
        return;
    L9:
        final PoiPagerIndicator r105 = (PoiPagerIndicator) ListProtector.get(this.f262892e, r101);
        Object r106 = CollectionsKt.firstOrNull(r102);
        if (Intrinsics.areEqual(r106, "pay_loads_indicator_color") == false) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == false) goto L19;
        r100.itemView.setBackground(ly6.b.b(new AnonymousClass1(r105, r101, this)));
        return;
    L19:
        if (Intrinsics.areEqual(r106, "pay_loads_indicator_size") == false) goto L21;
        boolean r109 = true;
    L22:
        if (r109 == false) goto L29;
        ViewGroup.LayoutParams r110 = r100.itemView.getLayoutParams();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r111 = (FrameLayout.LayoutParams) r110;
        if (r101 != this.f262893f) goto L26;
        float r112 = r105.getIndicatorSelectedSize();
    L27:
        r111.width = (int) r112;
        r111.height = (int) r105.getIndicatorSize();
        return;
    L26:
        r112 = r105.getIndicatorSize();
        goto L27
    L29:
        if (Intrinsics.areEqual(r106, "pay_loads_indicator_visible_count") == false) goto L31;
        boolean r113 = true;
    L32:
        if (r113 == true) goto L35;
        r104 = Intrinsics.areEqual(r106, "pay_loads_indicator_edge_alpha");
    L35:
        if (r104 == false) goto L40;
        y2(r100, r101);
        return;
    L40:
        return;
    L31:
        r113 = Intrinsics.areEqual(r106, "pay_loads_indicator_edge_alpha_count");
        goto L32
    L21:
        r109 = Intrinsics.areEqual(r106, "pay_loads_indicator_factor");
        goto L22
    L15:
        r108 = Intrinsics.areEqual(r106, "pay_loads_indicator_radius");
        goto L16
    L12:
        r107 = Intrinsics.areEqual(r106, "pay_loads_indicator_selected_color");
        goto L13
    L5:
        if (r101 >= ((ArrayList) this.f262892e).size()) goto L7;
        r103 = true;
        goto L7
    }

    public AbsPagerIndicatorAdapter(int r100, int r101, int r102, float r103) {
        this.f262888a = r100;
        this.f262889b = r101;
        this.f262890c = r102;
        this.f262891d = r103;
        this.f262892e = new ArrayList();
        this.f262895h = -1;
    }
}
