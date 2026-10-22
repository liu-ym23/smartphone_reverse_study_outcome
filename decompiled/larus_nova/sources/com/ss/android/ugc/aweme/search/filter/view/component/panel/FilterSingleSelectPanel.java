package com.ss.android.ugc.aweme.search.filter.view.component.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderItem;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterViewModel;
import com.ss.android.ugc.aweme.search.filter.utils.ECSearchCommodityThemeHelper;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/panel/FilterSingleSelectPanel;", "", "Landroid/content/Context;", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterSingleSelectPanel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f453165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f453166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RecyclerView f453167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FilterSingleSelectPanel$adapter$1 f453168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ECSearchFilterViewModel f453169e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f453170f;

    public final Context getContext() {
        return this.f453170f;
    }

    public final void a(RenderItem r100) {
        Intrinsics.checkNotNullParameter(r100, "renderItems");
        if ((!Intrinsics.areEqual(this.f453168d.f452996a, r100.getChildrenComponent())) == false) goto L8;
        FilterSingleSelectPanel$adapter$1 r101 = this.f453168d;
        List<RenderItem> r102 = r100.getChildrenComponent();
        if (r102 != null) goto L7;
        r102 = new ArrayList();
    L7:
        r101.setData(r102);
    L8:
        Integer r103 = r100.getColumnCount();
        if (r103 == null) goto L11;
        int r104 = r103.intValue();
    L12:
        RecyclerView.LayoutManager r105 = this.f453167c.getLayoutManager();
        if ((r105 instanceof GridLayoutManager) == false) goto L19;
        GridLayoutManager r106 = (GridLayoutManager) r105;
        if (r106.getSpanCount() == r104) goto L21;
        if (r104 >= 1) goto L18;
        r106.setSpanCount(1);
        goto L21
    L18:
        r106.setSpanCount(r104);
    L21:
        if (r100.getNewStyleWithTab() == false) goto L26;
        View r107 = this.f453166b;
        if (r107 == null) goto L25;
        r107.setVisibility(8);
    L25:
        this.f453167c.setPadding(DimenExtensionsKt.b(16), DimenExtensionsKt.b(6), DimenExtensionsKt.b(16), DimenExtensionsKt.b(6));
        return;
    L26:
        View r108 = this.f453166b;
        if (r108 == null) goto L29;
        r108.setVisibility(0);
    L29:
        this.f453167c.setPadding(DimenExtensionsKt.b(16), DimenExtensionsKt.b(6), 0, DimenExtensionsKt.b(14));
        return;
    L19:
        this.f453167c.setLayoutManager(new GridLayoutManager(this.f453170f, r104));
        goto L21
    L11:
        r104 = 1;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.recyclerview.widget.RecyclerView$Adapter, com.ss.android.ugc.aweme.search.filter.view.component.panel.FilterSingleSelectPanel$adapter$1] */
    public FilterSingleSelectPanel(ECSearchFilterViewModel r110, Context r111, Integer r112) {
        Intrinsics.checkNotNullParameter(r110, "viewModel");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f453169e = r110;
        this.f453170f = r111;
        FrameLayout r113 = new FrameLayout(r111);
        this.f453165a = r113;
        View r100 = new View(r111);
        this.f453166b = r100;
        RecyclerView r101 = new RecyclerView(r111);
        this.f453167c = r101;
        ?? r102 = new FilterSingleSelectPanel$adapter$1(this);
        this.f453168d = r102;
        r101.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r101.setPadding(DimenExtensionsKt.b(16), DimenExtensionsKt.b(6), 0, DimenExtensionsKt.b(14));
        r101.setAdapter(r102);
        r101.setLayoutManager(new GridLayoutManager(r111, 1));
        r101.setItemAnimator(null);
        r100.setLayoutParams(new ViewGroup.LayoutParams(-1, DimenExtensionsKt.b(Double.valueOf(0.5d))));
        if (r112 == null) goto L5;
        r100.setBackgroundColor(ECSearchCommodityThemeHelper.b(ECSearchCommodityThemeHelper.f452965b, r100.getContext(), R.color.LinePrimary, r112.intValue()));
    L7:
        if (r112 == null) goto L9;
        r113.setBackgroundColor(ECSearchCommodityThemeHelper.b(ECSearchCommodityThemeHelper.f452965b, r111, R.color.BGPrimary, r112.intValue()));
    L10:
        r113.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r113.addView(r101);
        r113.addView(r100);
        return;
    L9:
        r113.setBackgroundColor(r111.getResources().getColor(R.color.BGPrimary));
        goto L10
    L5:
        r100.setBackgroundColor(r100.getContext().getResources().getColor(R.color.LinePrimary));
        goto L7
    }
}
