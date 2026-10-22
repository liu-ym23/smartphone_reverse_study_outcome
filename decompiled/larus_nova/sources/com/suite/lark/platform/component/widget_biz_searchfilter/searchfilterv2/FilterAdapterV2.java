package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterAdapter;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0013J\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0013J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0013J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u0013H\u0016J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0016J\u0018\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020$H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014¨\u00061"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterAdapterV2;", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterAdapter;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onV2FilterItemClick", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnFilterItemClick;", "getOnV2FilterItemClick", "()Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnFilterItemClick;", "setOnV2FilterItemClick", "(Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnFilterItemClick;)V", "commonRecFilterShowListener", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnCommonRecFilterItemShow;", "getCommonRecFilterShowListener", "()Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnCommonRecFilterItemShow;", "setCommonRecFilterShowListener", "(Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnCommonRecFilterItemShow;)V", "selectedBgColor", "", "Ljava/lang/Integer;", "selectedBgBoarderColor", "selectedTextColor", "unSelectedTextColor", "selectedArrowColor", "unSelectedArrowColor", "setItemSelectedBgBorderColor", "", "res", "setItemSelectedBgColor", "setSelectedArrowColor", "resId", "setUnSelectedArrowColor", "setSelectedTextColor", "setUnSelectedTextColor", "onCreateViewHolder", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterAdapter$FilterViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "position", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateItemUISetting", "filterData", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterData;", "widget-biz-searchfilter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterAdapterV2 extends FilterAdapter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f460980g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FilterViewV2.c f460981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FilterViewV2.b f460982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f460983j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f460984k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f460985l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f460986m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f460987n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f460988o;

    public static final class a extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FilterAdapterV2 f460989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ cpc.a f460990b;

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            FilterViewV2.c r101 = this.f460989a.f460981h;
            if (r101 == null) goto L6;
            r101.a(this.f460990b);
            return;
        }

        public a(FilterAdapterV2 r100, cpc.a r101) {
            this.f460989a = r100;
            this.f460990b = r101;
        }
    }

    public static final class b extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FilterAdapterV2 f460991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ cpc.a f460992b;

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            FilterViewV2.c r101 = this.f460991a.f460981h;
            if (r101 == null) goto L6;
            r101.a(this.f460992b);
            return;
        }

        public b(FilterAdapterV2 r100, cpc.a r101) {
            this.f460991a = r100;
            this.f460992b = r101;
        }
    }

    public FilterAdapterV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f460980g = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        super.onAttachedToRecyclerView(r100);
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        y2((FilterAdapter.FilterViewHolder) r100, r101);
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return z2(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterAdapter
    public final void y2(FilterAdapter.FilterViewHolder r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "holder");
        if (r110.f460934a != 0) goto L15;
        cpc.a r112 = (cpc.a) ListProtector.get(this.f460929b, r111);
        String r100 = r112.f464754b;
        if (StringsKt.contains$default(r100, "{{name}}", false, 2, null) == false) goto L7;
        List r101 = StringsKt.split$default(r100, new String[]{"{{name}}"}, false, 0, 6, null);
        ((TextView) r110.itemView.findViewById(R.id.filter_view_pre_tv)).setText((CharSequence) ListProtector.get(r101, 0));
        ((TextView) r110.itemView.findViewById(R.id.filter_view_aft_tv)).setText((CharSequence) ListProtector.get(r101, 1));
    L8:
        ((LKUIRoundedImageView2) r110.itemView.findViewById(R.id.filter_avatar_iv)).setImageBitmap((Bitmap) CollectionsKt.firstOrNull(r112.f464755c));
        TextView r102 = (TextView) r110.itemView.findViewById(R.id.filter_name_tv);
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.SubFilterDataDependency.BaseOnQueryFilterData");
        r102.setText(((cpc.b) r112).a());
        Integer r103 = this.f460931d;
        if (r103 == null) goto L11;
        r110.itemView.findViewById(R.id.filter_view_bg).setBackgroundResource(r103.intValue());
    L11:
        Integer r104 = this.f460932e;
        if (r104 == null) goto L14;
        r110.itemView.findViewById(R.id.filter_right_border).setBackgroundResource(r104.intValue());
    L14:
        r110.itemView.setOnClickListener(new a(this, r112));
        return;
    L7:
        ((TextView) r110.itemView.findViewById(R.id.filter_view_pre_tv)).setText("");
        ((TextView) r110.itemView.findViewById(R.id.filter_view_aft_tv)).setText("");
        goto L8
    L15:
        cpc.a r113 = (cpc.a) ListProtector.get(this.f460929b, r111);
        SearchFilterViewV2 r105 = (SearchFilterViewV2) r110.itemView.findViewById(R.id.filter_view_item_v2);
        r105.setCancelClickListener(new com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.a(this, r113));
        if (r113.f464756d == true) goto L18;
        r105.setRightArrowVisibility(false);
    L20:
        if (r113.a() == false) goto L40;
        String r106 = r113.f464754b;
        List<Bitmap> r107 = r113.f464755c;
        int r108 = r113.b();
        r105.f461001a = true;
        r105.f461000J = r106;
        r105.M = r107;
        if (r108 > 1) goto L24;
        r105.K = null;
    L28:
        r105.requestLayout();
        r105.invalidate();
        Integer r109 = this.f460983j;
        if (r109 == null) goto L31;
        r105.setItemSelectedBgColor(r109.intValue());
    L31:
        Integer r114 = this.f460984k;
        if (r114 == null) goto L34;
        r105.setItemSelectedBgBorderColor(r114.intValue());
    L34:
        Integer r115 = this.f460985l;
        if (r115 == null) goto L37;
        r105.setSelectedTextColor(r115.intValue());
    L37:
        Integer r116 = this.f460987n;
        if (r116 == null) goto L52;
        r105.setSelectedArrowColor(r116.intValue());
    L52:
        r110.itemView.setOnClickListener(new b(this, r113));
        if (r110.f460934a != 1) goto L59;
        FilterViewV2.b r117 = this.f460982i;
        if (r117 == null) goto L60;
        r117.a(r113);
        return;
    L60:
        return;
    L59:
        return;
    L24:
        if (r105.L == false) goto L26;
        r105.K = Marker.ANY_NON_NULL_MARKER + (r108 - 1);
        goto L28
    L26:
        r105.K = UIHelper.mustacheFormat(R.string.Lark_NewFilter_Search_ChoseMoreSearchItems, "SearchOptions", Integer.toString(r108 - 1));
        goto L28
    L40:
        r105.setUnSelectedText(r113.f464754b);
        Integer r118 = this.f460932e;
        if (r118 == null) goto L43;
        r105.setItemUnSelectedBgColor(r118.intValue());
    L43:
        Integer r119 = this.f460933f;
        if (r119 == null) goto L46;
        r105.setItemUnSelectedBgBorderColor(r119.intValue());
    L46:
        Integer r120 = this.f460986m;
        if (r120 == null) goto L49;
        r105.setUnSelectedTextColor(r120.intValue());
    L49:
        Integer r121 = this.f460988o;
        if (r121 == null) goto L52;
        r105.setUnSelectedArrowColor(r121.intValue());
        goto L52
    L18:
        r105.setRightArrowVisibility(true);
        goto L20
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterAdapter
    public final FilterAdapter.FilterViewHolder z2(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        if (r101 != 0) goto L6;
        return new FilterAdapter.FilterViewHolder(LayoutInflater.from(this.f460980g).inflate(R.layout.name_filter_view_layout, r100, false), r101);
    L6:
        return new FilterAdapter.FilterViewHolder(LayoutInflater.from(this.f460980g).inflate(R.layout.filter_view_item_v2, r100, false), r101);
    }
}
