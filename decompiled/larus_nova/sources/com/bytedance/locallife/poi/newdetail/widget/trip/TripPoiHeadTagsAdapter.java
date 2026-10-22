package com.bytedance.locallife.poi.newdetail.widget.trip;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.base.utils.CJFontServiceUtils;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.dux.font.DuxFontHelper;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.locallife.poi.experiment.PoiBigFontExperiment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/widget/trip/TripPoiHeadTagsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/locallife/poi/newdetail/widget/trip/TripPoiHeadTagViewHolder;", "<init>", "()V", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class TripPoiHeadTagsAdapter extends RecyclerView.Adapter<TripPoiHeadTagViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f263582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f263583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> f263584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f263585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f263586e;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r100 = this.f263584c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public TripPoiHeadTagsAdapter() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r110, int r111) {
        TripPoiHeadTagViewHolder r100 = (TripPoiHeadTagViewHolder) r110;
        Intrinsics.checkNotNullParameter(r100, "holder");
        List<com.bytedance.locallife.poi.newdetail.widget.contentplayer.i> r101 = this.f263584c;
        if (r101 == null) goto L131;
        if (r111 >= 0) goto L6;
        return;
    L6:
        if (r111 >= r101.size()) goto L133;
        com.bytedance.locallife.poi.newdetail.widget.contentplayer.i r102 = (com.bytedance.locallife.poi.newdetail.widget.contentplayer.i) ListProtector.get(r101, r111);
        int r103 = this.f263583b;
        boolean r104 = this.f263586e;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, MapController.ITEM_LAYER_TAG);
        r100.f263576a.setText(r102.e());
        r100.f263577b.setVisibility(8);
        LinearLayout r105 = r100.f263578c;
        if (r105 == null) goto L10;
        r105.setPadding(0, 0, 0, 0);
    L10:
        int r106 = com.bytedance.locallife.poi.poidetail.container.mob.h.f263875a;
        com.bytedance.locallife.poi.poidetail.container.mob.h.a(r100.f263576a, 10.0f);
        if (r111 != 0) goto L13;
        boolean r107 = true;
    L15:
        if (PoiBigFontExperiment.a() == false) goto L27;
        LinearLayout r108 = r100.f263578c;
        if (r108 == null) goto L19;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
    L20:
        if (r109 == null) goto L23;
        r109.height = MathKt.roundToInt(TypedValue.applyDimension(1, 16 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), TripPoiHeadTagViewHolder.T3(Resources.getSystem())));
    L23:
        LinearLayout r112 = r100.f263578c;
        if (r112 == null) goto L27;
        r112.setLayoutParams(r109);
        goto L27
    L19:
        r109 = null;
    L27:
        Integer r113 = r102.f();
        if (r113 != null) goto L31;
    L32:
        Integer r114 = r102.f();
        if (r114 != null) goto L36;
    L49:
        Integer r115 = r102.f();
        if (r115 != null) goto L53;
    L61:
        r100.f263576a.setTypeface(Typeface.DEFAULT);
    L63:
        if (r111 != r103) goto L111;
        DuxTextView r116 = r100.f263576a;
        int r117 = r100.f263580e;
        r116.setPadding(r117, 0, r117, 0);
        Integer r118 = r102.f();
        if (r118 != null) goto L68;
    L79:
        if (r118 != null) goto L82;
    L101:
        if (r104 == false) goto L107;
        if (r107 == false) goto L107;
        int r119 = com.bytedance.locallife.poi.newdetail.widget.a.f263340a;
        com.bytedance.locallife.poi.newdetail.widget.a.b(r100.f263576a, r100.f263581f);
        GradientDrawable r120 = new GradientDrawable();
        r120.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        r120.setColors(new int[]{com.bytedance.locallife.poi.dito.util.a.a("#47FFD165"), com.bytedance.locallife.poi.dito.util.a.a("#2EFFD165"), com.bytedance.locallife.poi.dito.util.a.a("#2EFFD165"), com.bytedance.locallife.poi.dito.util.a.a("#47FFD165")});
        r120.setStroke(MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.5d, TripPoiHeadTagViewHolder.T3(Resources.getSystem()))), com.bytedance.locallife.poi.dito.util.a.a("#66FFD165"));
        r120.setCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, (float) 9.5d, TripPoiHeadTagViewHolder.T3(Resources.getSystem()))));
        LinearLayout r121 = r100.f263578c;
        if (r121 == null) goto L140;
        r121.setBackground(r120);
        return;
    L140:
        return;
    L107:
        LinearLayout r122 = r100.f263578c;
        if (r122 == null) goto L110;
        r122.setBackgroundResource(R.drawable.bg_trip_head_back_tag_lineargrandient);
    L110:
        r100.f263576a.getPaint().setShader(null);
        r100.f263576a.setTextColor(com.bytedance.locallife.poi.dito.util.a.a(CustomHeaderConfig.COLOR_LIGHT));
        return;
    L82:
        if (r118.intValue() != 1) goto L101;
        String r123 = r102.a();
        if (r123 == null) goto L100;
        LinearLayout r124 = r100.f263578c;
        if (r124 == null) goto L100;
        int r125 = com.bytedance.locallife.poi.newdetail.widget.a.f263340a;
        Intrinsics.checkNotNullParameter(r123, GXTemplateKey.GAIAX_CSS);
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L91
        GradientDrawable r127 = com.bytedance.locallife.poi.newdetail.widget.a.c(r123);     // Catch: Throwable -> L91
    L96:
        if (r127 == null) goto L98;
        r127.setCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, (float) 9.5d, TripPoiHeadTagViewHolder.T3(Resources.getSystem()))));
        r127.setStroke(MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.5d, TripPoiHeadTagViewHolder.T3(Resources.getSystem()))), com.bytedance.locallife.poi.dito.util.a.a("#33FFEAAC"));
        GradientDrawable r128 = r127;
    L99:
        r124.setBackground(r128);
        goto L100
    L98:
        r128 = null;
    L91:
        th = move-exception;
        Result.Companion r129 = Result.Companion;
        Object r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r130) == false) goto L95;
        r130 = null;
    L95:
        r127 = (GradientDrawable) r130;
    L100:
        int r131 = com.bytedance.locallife.poi.poidetail.container.mob.h.f263875a;
        com.bytedance.locallife.poi.poidetail.container.mob.h.a(r100.f263576a, 12.0f);
        return;
    L68:
        if (r118.intValue() != 0) goto L79;
        r100.f263576a.setTextColor(com.bytedance.locallife.poi.dito.util.a.a("#161823"));
        GradientDrawable r132 = new GradientDrawable();
        r132.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        r132.setColors(new int[]{com.bytedance.locallife.poi.dito.util.a.a("#BFFFFFFF"), com.bytedance.locallife.poi.dito.util.a.a(CustomHeaderConfig.COLOR_LIGHT)});
        r132.setCornerRadius(MathKt.roundToInt(TypedValue.applyDimension(1, (float) 9.5d, TripPoiHeadTagViewHolder.T3(Resources.getSystem()))));
        r132.setStroke(MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.5d, TripPoiHeadTagViewHolder.T3(Resources.getSystem()))), com.bytedance.locallife.poi.dito.util.a.a(CustomHeaderConfig.COLOR_LIGHT));
        LinearLayout r133 = r100.f263578c;
        if (r133 == null) goto L73;
        r133.setBackground(r132);
    L73:
        DuxTextView r134 = r100.f263576a;
        r134.setTypeface(r134.getTypeface(), 1);
        com.bytedance.locallife.poi.poidetail.container.mob.h.a(r100.f263576a, 11.0f);
        r100.f263576a.setGravity(17);
        if (r102.d() <= 1) goto L134;
        r100.f263576a.setPadding(0, 0, 0, 0);
        LinearLayout r135 = r100.f263578c;
        if (r135 == null) goto L78;
        int r136 = r100.f263580e;
        r135.setPadding(r136, 0, r136, 0);
    L78:
        DuxTextView r137 = r100.f263577b;
        StringBuilder r138 = new StringBuilder();
        r138.append(r102.f263427b);
        r138.append('/');
        r138.append(r102.d());
        r137.setText(r138.toString());
        r100.f263577b.setVisibility(0);
        return;
    L134:
        return;
    L111:
        if (r104 == false) goto L115;
        if (r107 == false) goto L115;
        int r139 = com.bytedance.locallife.poi.newdetail.widget.a.f263340a;
        com.bytedance.locallife.poi.newdetail.widget.a.b(r100.f263576a, r100.f263581f);
    L117:
        Drawable r140 = null;
    L118:
        DuxTextView r141 = r100.f263576a;
        int r142 = r100.f263579d;
        r141.setPadding(r142, 0, r142, 0);
        r100.f263576a.setBackground(r140);
        LinearLayout r143 = r100.f263578c;
        if (r143 == null) goto L122;
        r143.setBackground(r140);
    L122:
        Integer r144 = r102.f();
        if (r144 != null) goto L126;
        return;
    L126:
        if (r144.intValue() != 0) goto L139;
        r100.f263576a.setTextColor(com.bytedance.locallife.poi.dito.util.a.a("#D9FFFFFF"));
        com.bytedance.locallife.poi.poidetail.container.mob.h.a(r100.f263576a, 11.0f);
        return;
    L139:
        return;
    L115:
        if (r102.f() != null) goto L117;
        r140 = null;
        r100.f263576a.getPaint().setShader(null);
        r100.f263576a.setTextColor(com.bytedance.locallife.poi.dito.util.a.a(CustomHeaderConfig.COLOR_LIGHT));
        goto L118
    L53:
        if (r115.intValue() != 1) goto L61;
        Lazy r145 = DuxFontHelper.f205084a;
        Typeface r146 = DuxFontHelper.c(r100.itemView.getContext(), CJFontServiceUtils.DOUYIN_SANS_BOLD_FONT);
        if (r146 != null) goto L57;
        r146 = Typeface.DEFAULT;
    L57:
        r100.f263576a.setTypeface(r146);
        String r147 = r102.g();
        if (r147 == null) goto L60;
        int r148 = com.bytedance.locallife.poi.newdetail.widget.a.f263340a;
        com.bytedance.locallife.poi.newdetail.widget.a.b(r100.f263576a, r147);
    L60:
        com.bytedance.locallife.poi.poidetail.container.mob.h.a(r100.f263576a, 12.0f);
        goto L63
    L36:
        if (r114.intValue() != 1) goto L49;
    L38:
        if (PoiBigFontExperiment.a() == false) goto L44;
        LinearLayout r149 = r100.f263578c;
        if (r149 == null) goto L49;
        ViewGroup.LayoutParams r150 = r149.getLayoutParams();
        if (r150 == null) goto L49;
        r150.height = MathKt.roundToInt(TypedValue.applyDimension(1, 19 * RangesKt.coerceAtMost(Resources.getSystem().getConfiguration().fontScale, 1.15f), TripPoiHeadTagViewHolder.T3(Resources.getSystem())));
        r100.f263578c.setLayoutParams(r150);
        goto L49
    L44:
        LinearLayout r151 = r100.f263578c;
        if (r151 == null) goto L49;
        ViewGroup.LayoutParams r152 = r151.getLayoutParams();
        if (r152 == null) goto L49;
        r152.height = MathKt.roundToInt(TypedValue.applyDimension(1, 19, TripPoiHeadTagViewHolder.T3(Resources.getSystem())));
        r100.f263578c.setLayoutParams(r152);
        goto L49
    L31:
        if (r113.intValue() == 0) goto L38;
    L13:
        r107 = false;
        goto L15
    L133:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r102 = LayoutInflater.from(r100.getContext()).inflate(R.layout.saas_poi_item_trip_head_image_tag, r100, false);
        TripPoiHeadTagViewHolder r103 = new TripPoiHeadTagViewHolder(r102);
        r102.setOnClickListener(new j(r103, this));
        return r103;
    }
}
