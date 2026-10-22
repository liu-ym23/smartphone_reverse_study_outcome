package com.ss.android.ugc.aweme.search.filter.view.component.area;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.search.filter.ECSearchFilterBoard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/area/SelectAreaFilterBoard;", "Lcom/ss/android/ugc/aweme/search/filter/ECSearchFilterBoard;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectAreaFilterBoard extends ECSearchFilterBoard {
    @Override // com.ss.android.ugc.aweme.search.filter.ECSearchFilterBoard
    public final void c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "contentView");
        removeAllViews();
        addView(r100);
    }

    public SelectAreaFilterBoard(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
