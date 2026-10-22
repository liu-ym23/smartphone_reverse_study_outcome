package com.ss.android.lark.feed.app.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0010\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/feed/app/tablayout/RefactoredCurrentGroupIndicator;", "Lcom/ss/android/lark/feed/app/tablayout/RefactoredFeedTabLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "childTextView", "Landroid/widget/TextView;", "onFinishInflate", "", "setText", SRStrategy.MEDIAINFO_KEY_CACHE_SIZE, "", "feed-tab-layout_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class RefactoredCurrentGroupIndicator extends RefactoredFeedTabLayout {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f420793w;

    @Override // com.ss.android.lark.feed.app.tablayout.RefactoredFeedTabLayout, android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r100 = getChildAt(0);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.widget.TextView");
        TextView r101 = (TextView) r100;
        int r102 = ContextCompat.getColor(r101.getContext(), R.color.imtoken_feed_icon_pri_selected);
        r101.setCompoundDrawablesRelative(null, null, UDIconUtils.getIconDrawable(r101.getContext(), R.drawable.ud_icon_close_bold_outlined, r102, new UDDimension.a(zz7.b.g(r101.getContext(), 12))), null);
        r101.setCompoundDrawablePadding(UIUtils.dp2px(r101.getContext(), 8.0f));
        this.f420793w = r101;
    }

    public RefactoredCurrentGroupIndicator(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setText(CharSequence r100) {
        TextView r101 = this.f420793w;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("childTextView");
        r101 = null;
    L5:
        r101.setText(r100);
    }

    public RefactoredCurrentGroupIndicator(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }
}
