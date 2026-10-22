package com.bytedance.locallife.poi.media.ui.indicator;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.locallife.poi.media.ui.indicator.base.AbsPagerIndicatorAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ly6.b;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/poi/media/ui/indicator/PoiRecyclerIndicatorAdapter;", "Lcom/bytedance/locallife/poi/media/ui/indicator/base/AbsPagerIndicatorAdapter;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "PoiRecyclerIndicatorViewHolder", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiRecyclerIndicatorAdapter extends AbsPagerIndicatorAdapter {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f262854j = 0;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/locallife/poi/media/ui/indicator/PoiRecyclerIndicatorAdapter$PoiRecyclerIndicatorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
    public final class PoiRecyclerIndicatorViewHolder extends RecyclerView.ViewHolder {
        public PoiRecyclerIndicatorViewHolder(View r100) {
            Intrinsics.checkNotNullParameter(r100, "view");
            super(r100);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, final int r110) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        boolean r101 = true;
        if (r110 >= 0) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        PoiRecyclerIndicatorViewHolder r103 = (PoiRecyclerIndicatorViewHolder) r100;
        final PoiPagerIndicator r104 = (PoiPagerIndicator) ListProtector.get(this.f262892e, r110);
        Objects.toString(r104);
        View r105 = r100.itemView;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L13;
        r106.width = (int) r104.getIndicatorSize();
        r106.height = (int) r104.getIndicatorSize();
    L14:
        r105.setLayoutParams(r106);
        View r107 = r100.itemView;
        Drawable r108 = r107.getBackground();
        if (r108 == null) goto L21;
        GradientDrawable r109 = (GradientDrawable) r108;
        r109.setCornerRadius(r104.getIndicatorRadius());
        if (r110 != this.f262893f) goto L19;
        int r111 = r104.getIndicatorSelectedColor();
    L20:
        r109.setColor(r111);
    L22:
        r107.setBackground(r108);
        y2(r100, r110);
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r104, "indicator");
        if (r110 != this.f262893f) goto L35;
        if (this.f262894g == 0.0f) goto L28;
        r101 = false;
    L28:
        if (r101 == false) goto L31;
        this.f262894g = r104.getIndicatorSelectedSize();
    L31:
        if (this.f262888a != 0) goto L33;
        View r112 = r100.itemView;
        ViewGroup.LayoutParams r113 = r112.getLayoutParams();
        r113.width = (int) this.f262894g;
        r112.setLayoutParams(r113);
        return;
    L33:
        View r114 = r100.itemView;
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        r115.height = (int) this.f262894g;
        r114.setLayoutParams(r115);
        return;
    L35:
        if (r110 != this.f262895h) goto L41;
        if (this.f262888a != 0) goto L39;
        View r116 = r100.itemView;
        ViewGroup.LayoutParams r117 = r116.getLayoutParams();
        r117.width = (int) this.f262896i;
        r116.setLayoutParams(r117);
        return;
    L39:
        View r118 = r100.itemView;
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        r119.height = (int) this.f262896i;
        r118.setLayoutParams(r119);
        return;
    L41:
        if (this.f262888a != 0) goto L43;
        View r120 = r100.itemView;
        ViewGroup.LayoutParams r121 = r120.getLayoutParams();
        r121.width = (int) r104.getIndicatorSize();
        r120.setLayoutParams(r121);
        return;
    L43:
        View r122 = r100.itemView;
        ViewGroup.LayoutParams r123 = r122.getLayoutParams();
        r123.height = (int) r104.getIndicatorSize();
        r122.setLayoutParams(r123);
        return;
    L19:
        r111 = r104.getIndicatorColor();
        goto L20
    L21:
        r108 = b.b(new AnonymousClass3(r104, r110, this));
        goto L22
    L13:
        r106 = new ViewGroup.LayoutParams((int) r104.getIndicatorSize(), (int) r104.getIndicatorSize());
        goto L14
    L5:
        if (r110 >= ((ArrayList) this.f262892e).size()) goto L7;
        r102 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        return new PoiRecyclerIndicatorViewHolder(LayoutInflater.from(r100.getContext()).inflate(R.layout.life_poi_media_recycler_pager_indicator_item, r100, false));
    }

    public PoiRecyclerIndicatorAdapter(int r100, int r101, int r102, float r103) {
        super(r100, r101, r102, r103);
    }
}
