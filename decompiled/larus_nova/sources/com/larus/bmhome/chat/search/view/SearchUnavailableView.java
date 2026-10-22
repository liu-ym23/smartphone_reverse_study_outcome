package com.larus.bmhome.chat.search.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import c29.a;
import com.larus.bmhome.chat.layout.widget.RoundFrameLayoutWithLastMotion;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/search/view/SearchUnavailableView;", "Lcom/larus/bmhome/chat/layout/widget/RoundFrameLayoutWithLastMotion;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "textView", "Landroid/widget/TextView;", "setText", "", "text", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchUnavailableView extends RoundFrameLayoutWithLastMotion {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f308695c;

    public SearchUnavailableView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SearchUnavailableView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f308695c.setText(r100);
    }

    public SearchUnavailableView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        TextView r103 = new TextView(r100);
        this.f308695c = r103;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r103.setTextColor(ContextCompat.getColor(r100, R.color.neutral_100));
        r103.setTextSize(0, i5.k());
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-2, -2);
        r104.gravity = 17;
        addView(r103, r104);
        getDelegate().a(c.b(R.attr.larus_base_2, r103.getContext(), R.color.larus_base_2));
        getDelegate().b(c.b(R.attr.larus_neutral_transparent_2, r103.getContext(), R.color.larus_neutral_transparent_2));
        getDelegate().d(12);
        a r105 = getDelegate();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r105.g(ContextCompat.getColor(r100, R.color.press));
        a r106 = getDelegate();
        Resources r107 = r106.f22220b.getResources();
        r106.f22231m = (int) ((1 * WindowDisplayMetricsOverride.apply(r107, r107.getDisplayMetrics()).density) + 0.5f);
        r106.c();
    }

    public /* synthetic */ SearchUnavailableView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
