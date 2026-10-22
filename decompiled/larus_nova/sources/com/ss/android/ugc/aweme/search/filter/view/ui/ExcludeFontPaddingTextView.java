package com.ss.android.ugc.aweme.search.filter.view.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bytedance.ies.dmt.ui.widget.DmtTextView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/ui/ExcludeFontPaddingTextView;", "Lcom/bytedance/ies/dmt/ui/widget/DmtTextView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExcludeFontPaddingTextView extends DmtTextView {
    public ExcludeFontPaddingTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ExcludeFontPaddingTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.ies.dmt.ui.widget.DmtTextView, android.widget.TextView
    public final void setText(CharSequence r100, TextView.BufferType r101) {
        if (r100 != null) goto L4;
        CharSequence r102 = null;
    L5:
        super.setText(r102, r101);
        return;
    L4:
        SpannableStringBuilder r103 = new SpannableStringBuilder(r100);
        r103.setSpan(new ExcludeFontPaddingTextView$getCustomText$$inlined$apply$lambda$1(this), 0, r100.length(), 33);
        r102 = r103;
        goto L5
    }

    public ExcludeFontPaddingTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setIncludeFontPadding(false);
    }

    public /* synthetic */ ExcludeFontPaddingTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
