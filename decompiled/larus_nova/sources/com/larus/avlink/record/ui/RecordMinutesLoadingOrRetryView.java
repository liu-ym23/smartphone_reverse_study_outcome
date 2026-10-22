package com.larus.avlink.record.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import ba8.c;
import com.larus.avlink.impl.databinding.LayoutRecordLoadingOrRetryViewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0013\u001a\u00020\u000eJ\u0006\u0010\u0014\u001a\u00020\u000eR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/larus/avlink/record/ui/RecordMinutesLoadingOrRetryView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LayoutRecordLoadingOrRetryViewBinding;", "onRetryClick", "Lkotlin/Function0;", "", "getOnRetryClick", "()Lkotlin/jvm/functions/Function0;", "setOnRetryClick", "(Lkotlin/jvm/functions/Function0;)V", "showLoadingView", "showRetryView", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordMinutesLoadingOrRetryView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutRecordLoadingOrRetryViewBinding f294314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f294315b;

    public RecordMinutesLoadingOrRetryView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RecordMinutesLoadingOrRetryView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void R5() {
        this.f294314a.f293336b.setVisibility(0);
        this.f294314a.f293337c.setVisibility(0);
        this.f294314a.f293339e.setVisibility(8);
        this.f294314a.f293338d.setVisibility(8);
    }

    public final void S5() {
        this.f294314a.f293336b.setVisibility(8);
        this.f294314a.f293337c.setVisibility(8);
        this.f294314a.f293339e.setVisibility(0);
        this.f294314a.f293338d.setVisibility(0);
    }

    public final Function0<Unit> getOnRetryClick() {
        return this.f294315b;
    }

    public final void setOnRetryClick(Function0<Unit> r100) {
        this.f294315b = r100;
    }

    public RecordMinutesLoadingOrRetryView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.layout_record_loading_or_retry_view, this, false);
        addView(r103);
        int r104 = R.id.loading;
        ProgressBar r105 = (ProgressBar) ViewBindings.findChildViewById(r103, R.id.loading);
        if (r105 == null) goto L13;
        r104 = R.id.loading_text;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.loading_text);
        if (r106 == null) goto L13;
        r104 = R.id.retry_icon;
        ImageView r107 = (ImageView) ViewBindings.findChildViewById(r103, R.id.retry_icon);
        if (r107 == null) goto L13;
        r104 = R.id.retry_text;
        TextView r108 = (TextView) ViewBindings.findChildViewById(r103, R.id.retry_text);
        if (r108 == null) goto L13;
        this.f294314a = new LayoutRecordLoadingOrRetryViewBinding((ConstraintLayout) r103, r105, r106, r107, r108);
        r107.setOnClickListener(new c(this));
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ RecordMinutesLoadingOrRetryView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
