package com.ss.android.ugc.aweme.search.filter.view.ui;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/ui/NoPaddingTextView;", "Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NoPaddingTextView extends DmtTextView {
    public NoPaddingTextView(Context r100) {
        this(r100, null);
    }

    public NoPaddingTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Paint.FontMetricsInt r102 = getPaint().getFontMetricsInt();
        int r103 = (int) Math.ceil(Math.abs(((double) (r102.top - r102.ascent)) / 2.0d));
        setGravity(17);
        setPadding(0, -(Math.abs(r102.top - r102.ascent) + r103), 0, r102.top - r102.ascent);
    }
}
