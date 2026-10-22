package com.obric.assistant.omnidetailpage.blockview.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.obric.assistant.card.databinding.ObricOmniStopButtonBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/base/StopButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniStopButtonBinding;", "setLoading", "", "isLoading", "", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StopButton extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricOmniStopButtonBinding f390614a;

    public StopButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StopButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setLoading(boolean r100) {
        ObricOmniStopButtonBinding r101 = this.f390614a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        r101.f386305b.setVisibility(4);
        r101.f386306c.setVisibility(0);
        setEnabled(false);
        return;
    L7:
        r101.f386305b.setVisibility(0);
        r101.f386306c.setVisibility(8);
        setEnabled(true);
    }

    public StopButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.obric_omni_stop_button, this);
        int r103 = R.id.content_container;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.content_container);
        if (r104 == null) goto L9;
        r103 = R.id.loading_view;
        ProgressBar r105 = (ProgressBar) ViewBindings.findChildViewById(this, R.id.loading_view);
        if (r105 == null) goto L9;
        this.f390614a = new ObricOmniStopButtonBinding(this, r104, r105);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ StopButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
