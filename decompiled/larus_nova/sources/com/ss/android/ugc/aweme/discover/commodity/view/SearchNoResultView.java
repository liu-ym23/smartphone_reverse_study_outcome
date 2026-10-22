package com.ss.android.ugc.aweme.discover.commodity.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.SearchClickLinkConfig;
import com.ss.android.ugc.aweme.search.filter.utils.ECSearchCommodityThemeHelper;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/view/SearchNoResultView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchNoResultView extends FrameLayout {
    public SearchNoResultView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public SearchNoResultView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.saas_search_commodity_no_result_layout, this);
    }

    public final void a(final SearchClickLinkConfig r110, final String r111, final String r112, final String r113, Integer r114) {
        Intrinsics.checkNotNullParameter(r110, "linkConfig");
        View r100 = findViewById(R.id.root_layout);
        TextView r101 = (TextView) findViewById(R.id.link_title);
        TextView r102 = (TextView) findViewById(R.id.link_button);
        if (r114 == null) goto L31;
        int r115 = r114.intValue();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L29
        if (r100 == null) goto L8;
        r100.setBackgroundColor(ECSearchCommodityThemeHelper.b(ECSearchCommodityThemeHelper.f452965b, getContext(), R.color.BGPrimary, r115));     // Catch: Throwable -> L29
    L8:
        if (r101 == null) goto L10;
        r101.setTextColor(ECSearchCommodityThemeHelper.b(ECSearchCommodityThemeHelper.f452965b, getContext(), R.color.TextTertiary, r115));     // Catch: Throwable -> L29
    L10:
        if (r102 == null) goto L12;
        r102.setTextColor(ECSearchCommodityThemeHelper.b(ECSearchCommodityThemeHelper.f452965b, getContext(), R.color.BGInput4, r115));     // Catch: Throwable -> L29
    L12:
        Drawable r104 = null;
        if (r102 == null) goto L17;
        Drawable r105 = r102.getBackground();     // Catch: Throwable -> L29
        if (r105 == null) goto L17;
        Drawable r106 = r105.mutate();     // Catch: Throwable -> L29
    L19:
        if ((r106 instanceof GradientDrawable) == false) goto L22;
        r104 = r106;
    L22:
        GradientDrawable r107 = (GradientDrawable) r104;     // Catch: Throwable -> L29
        if (r107 == null) goto L25;
        r107.setColor(ECSearchCommodityThemeHelper.b(ECSearchCommodityThemeHelper.f452965b, getContext(), R.color.Secondary2, r115));     // Catch: Throwable -> L29
    L25:
        if (r102 == null) goto L27;
        r102.setBackground(r107);     // Catch: Throwable -> L29
    L27:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L17:
        r106 = null;
    L29:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L31:
        if (r101 == null) goto L33;
        r101.setText(r110.getTitle());
    L33:
        if (r102 == null) goto L35;
        r102.setText(r110.getRedirectTitle());
    L35:
        SearchNoResultViewKt.b(r111, r112, r113, "activity_no_result");
        if (r102 == null) goto L41;
        r102.setOnClickListener(new SearchNoResultView$bind$2(this, r110, r111, r112, r113));
        return;
    }
}
