package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterViewItemDecoration;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 :2\u00020\u0001:\u0004:;<=B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010 \u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001cJ\u000e\u0010%\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001cJ\u000e\u0010&\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010'\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010\u0013J\u0010\u0010*\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010\u0015J\u000e\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0017J\u0014\u0010.\u001a\u00020\u00192\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100J\u0014\u00102\u001a\u00020\u00192\f\u0010/\u001a\b\u0012\u0004\u0012\u00020100J\u000e\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u000201J\u000e\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u001cJ\u0006\u00107\u001a\u00020\u0019J\u0006\u00108\u001a\u00020\u0019J\u0006\u00109\u001a\u00020\u0019R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "mResetTv", "Landroid/widget/TextView;", "mFilterRv", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "mGradientBorder", "Landroid/view/View;", "mV2FilterAdapter", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterAdapterV2;", "mOnResetClick", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnResetClick;", "mOnFilterItemClick", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnFilterItemClick;", "mCommonRecFilterShowListener", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilterv2/FilterViewV2$IOnCommonRecFilterItemShow;", "initFilterView", "", "setSelectedArrowColor", "resId", "", "setUnSelectedArrowColor", "setSelectedTextColor", "setUnSelectedTextColor", "setResetTvBgColor", "setGradientBorderBackground", "setRecommendItemBgColor", "setItemSelectedBgColor", "res", "setItemSelectedBgBorderColor", "setItemUnSelectedBgColor", "setItemUnSelectedBgBorderColor", "setOnResetClick", "onResetClick", "setOnFilterItemClick", "onFilterItemClick", "setOnCommonRecFilterShowListener", "l", "addAll", "collection", "", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterData;", "resetAll", "update", "data", "scrollTo", "index", "scrollToLeft", "hide", "show", "Companion", "IOnResetClick", "IOnFilterItemClick", "IOnCommonRecFilterItemShow", "widget-biz-searchfilter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterViewV2 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f460993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommonRecyclerView f460994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f460995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FilterAdapterV2 f460996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f460997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f460998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f460999g;

    public static final class a {
    }

    public interface b {
        void a(cpc.a r100);
    }

    public interface c {
        void a(cpc.a r100);

        void b(cpc.a r100);
    }

    public interface d {
        void a();
    }

    static {
    }

    public final void b() {
        TextView r100 = this.f460993a;
        View r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResetTv");
        r100 = null;
    L5:
        r100.setVisibility(8);
        View r102 = this.f460995c;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mGradientBorder");
    L9:
        r101.setVisibility(8);
        return;
    L8:
        r101 = r102;
        goto L9
    }

    public final void c() {
        TextView r100 = this.f460993a;
        View r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResetTv");
        r100 = null;
    L5:
        r100.setVisibility(0);
        View r102 = this.f460995c;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mGradientBorder");
    L9:
        r101.setVisibility(0);
        return;
    L8:
        r101 = r102;
        goto L9
    }

    public FilterViewV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void a(Collection<? extends cpc.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "collection");
        if ((!r100.isEmpty()) == false) goto L11;
        FilterAdapterV2 r101 = this.f460996d;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r101 = null;
    L7:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "collection");
        if ((!r100.isEmpty()) == false) goto L12;
        ((ArrayList) r101.f460929b).addAll(r100);
        r101.notifyDataSetChanged();
        return;
    L12:
        return;
    }

    public final void setGradientBorderBackground(int r100) {
        View r101 = this.f460995c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mGradientBorder");
        r101 = null;
    L5:
        r101.setBackgroundResource(r100);
    }

    public final void setItemSelectedBgBorderColor(int r100) {
        FilterAdapterV2 r101 = this.f460996d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r101 = null;
    L5:
        Integer r102 = r101.f460984k;
        if (r102 != null) goto L9;
    L10:
        r101.f460984k = Integer.valueOf(r100);
        r101.notifyDataSetChanged();
        return;
    L9:
        if (r102.intValue() != r100) goto L10;
    }

    public final void setItemSelectedBgColor(int r100) {
        FilterAdapterV2 r101 = this.f460996d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r101 = null;
    L5:
        Integer r102 = r101.f460983j;
        if (r102 != null) goto L9;
    L10:
        r101.f460983j = Integer.valueOf(r100);
        r101.notifyDataSetChanged();
        return;
    L9:
        if (r102.intValue() != r100) goto L10;
    }

    public final void setItemUnSelectedBgBorderColor(int r100) {
        FilterAdapterV2 r101 = this.f460996d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r101 = null;
    L5:
        Integer r102 = r101.f460933f;
        if (r102 != null) goto L9;
    L10:
        r101.f460933f = Integer.valueOf(r100);
        r101.notifyDataSetChanged();
        return;
    L9:
        if (r102.intValue() != r100) goto L10;
    }

    public final void setItemUnSelectedBgColor(int r100) {
        FilterAdapterV2 r101 = this.f460996d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r101 = null;
    L5:
        Integer r102 = r101.f460932e;
        if (r102 != null) goto L9;
    L10:
        r101.f460932e = Integer.valueOf(r100);
        r101.notifyDataSetChanged();
        return;
    L9:
        if (r102.intValue() != r100) goto L10;
    }

    public final void setOnCommonRecFilterShowListener(b r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
        this.f460999g = r100;
    }

    public final void setOnFilterItemClick(c r100) {
        this.f460998f = r100;
    }

    public final void setOnResetClick(d r100) {
        this.f460997e = r100;
    }

    public final void setRecommendItemBgColor(int r100) {
        FilterAdapterV2 r101 = this.f460996d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r101 = null;
    L5:
        Integer r102 = r101.f460931d;
        if (r102 != null) goto L9;
    L10:
        r101.f460931d = Integer.valueOf(r100);
        r101.notifyDataSetChanged();
        return;
    L9:
        if (r102.intValue() != r100) goto L10;
    }

    public final void setResetTvBgColor(int r100) {
        TextView r101 = this.f460993a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResetTv");
        r101 = null;
    L5:
        r101.setBackgroundColor(y9c.d.c(getContext(), r100));
    }

    public final void setSelectedArrowColor(int r100) {
        FilterAdapterV2 r101 = this.f460996d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r101 = null;
    L5:
        Integer r102 = r101.f460987n;
        if (r102 != null) goto L9;
    L10:
        r101.f460987n = Integer.valueOf(r100);
        r101.notifyDataSetChanged();
        return;
    L9:
        if (r102.intValue() != r100) goto L10;
    }

    public final void setSelectedTextColor(int r100) {
        FilterAdapterV2 r101 = this.f460996d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r101 = null;
    L5:
        Integer r102 = r101.f460985l;
        if (r102 != null) goto L9;
    L10:
        r101.f460985l = Integer.valueOf(r100);
        r101.notifyDataSetChanged();
        return;
    L9:
        if (r102.intValue() != r100) goto L10;
    }

    public final void setUnSelectedArrowColor(int r100) {
        FilterAdapterV2 r101 = this.f460996d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r101 = null;
    L5:
        Integer r102 = r101.f460988o;
        if (r102 != null) goto L9;
    L10:
        r101.f460988o = Integer.valueOf(r100);
        r101.notifyDataSetChanged();
        return;
    L9:
        if (r102.intValue() != r100) goto L10;
    }

    public final void setUnSelectedTextColor(int r100) {
        FilterAdapterV2 r101 = this.f460996d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r101 = null;
    L5:
        Integer r102 = r101.f460986m;
        if (r102 != null) goto L9;
    L10:
        r101.f460986m = Integer.valueOf(r100);
        r101.notifyDataSetChanged();
        return;
    L9:
        if (r102.intValue() != r100) goto L10;
    }

    public final void update(cpc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        FilterAdapterV2 r101 = this.f460996d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
        r101 = null;
    L5:
        r101.update(r100);
    }

    public FilterViewV2(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        LayoutInflater.from(getContext()).inflate(R.layout.filter_view_layout, this, true);
        this.f460993a = (TextView) findViewById(R.id.filter_reset_tv);
        this.f460994b = (CommonRecyclerView) findViewById(R.id.filter_rv);
        this.f460995c = findViewById(R.id.gradient_border);
        this.f460996d = new FilterAdapterV2(getContext());
        TextView r112 = this.f460993a;
        FilterAdapterV2 r113 = null;
        if (r112 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResetTv");
        r112 = null;
    L5:
        r112.setOnClickListener(new com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.b(this));
        CommonRecyclerView r114 = this.f460994b;
        if (r114 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterRv");
        r114 = null;
    L8:
        r114.setItemAnimator(null);
        CommonRecyclerView r115 = this.f460994b;
        if (r115 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterRv");
        r115 = null;
    L11:
        int r100 = 0;
        r115.setLayoutManager(new LinearLayoutManager(r115.getContext(), 0, false));
        FilterAdapterV2 r101 = this.f460996d;
        if (r101 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mV2FilterAdapter");
    L15:
        r113.f460981h = new com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.c(this);
        r113.f460982i = new com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.d(this);
        r115.setAdapter(r113);
        int r116 = r115.getItemDecorationCount();
    L16:
        if (r100 >= r116) goto L18;
        r115.removeItemDecorationAt(r100);
        r100 = r100 + 1;
        goto L16
    L18:
        r115.addItemDecoration(new FilterViewItemDecoration(UIHelper.dp2px(12.0f), UIHelper.dp2px(12.0f), UIHelper.dp2px(12.0f), UIHelper.dp2px(12.0f), UIHelper.dp2px(10.0f)));
        return;
    L14:
        r113 = r101;
        goto L15
    }
}
