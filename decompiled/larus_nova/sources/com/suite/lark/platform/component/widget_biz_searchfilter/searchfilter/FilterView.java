package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter;

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
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 ,2\u00020\u0001:\u0003,-.B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u0013J\u0010\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\u0015J\u0014\u0010\"\u001a\u00020\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u0014\u0010&\u001a\u00020\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u000e\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020%J\u0006\u0010)\u001a\u00020\u0017J\u0006\u0010*\u001a\u00020\u0017J\u0006\u0010+\u001a\u00020\u0017R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "mResetTv", "Landroid/widget/TextView;", "mFilterRv", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "mGradientBorder", "Landroid/view/View;", "mFilterAdapter", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterAdapter;", "mOnResetClick", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterView$IOnResetClick;", "mOnFilterItemClick", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterView$IOnFilterItemClick;", "initFilterView", "", "setGradientBorderBackground", "resId", "", "setRecommendItemBgColor", "setItemUnSelectedBgColor", "setItemUnSelectedBgBorderColor", "setOnResetClick", "onResetClick", "setOnFilterItemClick", "onFilterItemClick", "addAll", "collection", "", "Lcom/suite/lark/platform/component/widget_biz_searchfilter/searchfilter/FilterData;", "resetAll", "update", "data", "scrollToLeft", "hide", "show", "Companion", "IOnResetClick", "IOnFilterItemClick", "widget-biz-searchfilter_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterView extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f460939f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f460940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CommonRecyclerView f460941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f460942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FilterAdapter f460943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f460944e;

    public static final class a {
    }

    public interface b {
        void a(cpc.a r100);
    }

    public interface c {
    }

    static {
    }

    public final void setOnResetClick(c r100) {
    }

    public FilterView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setGradientBorderBackground(int r100) {
        View r101 = this.f460942c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mGradientBorder");
        r101 = null;
    L5:
        r101.setBackgroundResource(r100);
    }

    public final void setItemUnSelectedBgBorderColor(int r100) {
        FilterAdapter r101 = this.f460943d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
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
        FilterAdapter r101 = this.f460943d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
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

    public final void setOnFilterItemClick(b r100) {
        this.f460944e = r100;
    }

    public final void setRecommendItemBgColor(int r100) {
        FilterAdapter r101 = this.f460943d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
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

    public final void update(cpc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        FilterAdapter r101 = this.f460943d;
        CommonRecyclerView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
        r101 = null;
    L5:
        r101.update(r100);
        FilterAdapter r103 = this.f460943d;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
        r103 = null;
    L8:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "data");
        int r104 = ((ArrayList) r103.f460929b).indexOf(r100);
        if (r104 < 0) goto L21;
        FilterAdapter r105 = this.f460943d;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
        r105 = null;
    L14:
        if (r104 >= r105.getItemCount()) goto L22;
        CommonRecyclerView r106 = this.f460941b;
        if (r106 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterRv");
    L19:
        r102.scrollToPosition(r104);
        return;
    L18:
        r102 = r106;
        goto L19
    L22:
        return;
    }

    public FilterView(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        LayoutInflater.from(getContext()).inflate(R.layout.filter_view_layout, this, true);
        this.f460940a = (TextView) findViewById(R.id.filter_reset_tv);
        this.f460941b = (CommonRecyclerView) findViewById(R.id.filter_rv);
        this.f460942c = findViewById(R.id.gradient_border);
        this.f460943d = new FilterAdapter(getContext());
        TextView r112 = this.f460940a;
        FilterAdapter r113 = null;
        if (r112 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mResetTv");
        r112 = null;
    L5:
        r112.setOnClickListener(new com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.a(this));
        CommonRecyclerView r114 = this.f460941b;
        if (r114 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterRv");
        r114 = null;
    L8:
        int r100 = 0;
        r114.setLayoutManager(new LinearLayoutManager(r114.getContext(), 0, false));
        FilterAdapter r101 = this.f460943d;
        if (r101 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mFilterAdapter");
    L12:
        r113.f460930c = new com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.b(this);
        r114.setAdapter(r113);
        int r115 = r114.getItemDecorationCount();
    L13:
        if (r100 >= r115) goto L15;
        r114.removeItemDecorationAt(r100);
        r100 = r100 + 1;
        goto L13
    L15:
        r114.addItemDecoration(new FilterViewItemDecoration(UIHelper.dp2px(16.0f), UIHelper.dp2px(14.0f), UIHelper.dp2px(16.0f), UIHelper.dp2px(14.0f), UIHelper.dp2px(10.0f)));
        return;
    L11:
        r113 = r101;
        goto L12
    }
}
