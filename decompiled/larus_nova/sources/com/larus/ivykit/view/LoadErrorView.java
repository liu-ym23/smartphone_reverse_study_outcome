package com.larus.ivykit.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.larus.common_ui.widget.LoadingWithRetryView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0014J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/ivykit/view/LoadErrorView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "retryView", "Lcom/larus/common_ui/widget/LoadingWithRetryView;", "onAttachedToWindow", "", "setOnRetryListener", "listener", "Landroid/view/View$OnClickListener;", "ivykit_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LoadErrorView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadingWithRetryView f351656a;

    public LoadErrorView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LoadErrorView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object r100 = getParent();
        if ((r100 instanceof View) == false) goto L5;
        View r101 = (View) r100;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        Drawable r102 = r101.getBackground();
        if ((r102 instanceof ColorDrawable) == false) goto L12;
        this.f351656a.setBackgroundColor(((ColorDrawable) r102).getColor());
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void setOnRetryListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f351656a.setOnRetryListener(r100);
    }

    public LoadErrorView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LoadingWithRetryView r103 = new LoadingWithRetryView(r100, null);
        this.f351656a = r103;
        addView(r103);
        r103.c(Integer.valueOf(R.string.larus_AI_generate_reload));
        setBackgroundColor(ContextCompat.getColor(r100, c.b(R.attr.larus_base_1, r100, R.color.larus_base_1)));
    }

    public /* synthetic */ LoadErrorView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
