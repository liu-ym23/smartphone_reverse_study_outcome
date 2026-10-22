package com.larus.avlink.record.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RotateDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import ba8.e;
import com.larus.avlink.impl.databinding.LarusLayoutRecordMinutesSyncHeaderBinding;
import com.larus.dora.api.offline.record.d;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/avlink/record/ui/RecordMinutesSyncHeaderView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/avlink/impl/databinding/LarusLayoutRecordMinutesSyncHeaderBinding;", "rotateAnimator", "Landroid/animation/ValueAnimator;", "rotateDrawable", "Landroid/graphics/drawable/RotateDrawable;", ChameleonOpenTracker.Stage.RENDER, "", "state", "Lcom/larus/dora/api/offline/record/DoraOfflineRecordTransferProgress;", "hide", "initRotateDrawable", "startRotationAnimation", "stopRotationAnimation", "onDetachedFromWindow", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecordMinutesSyncHeaderView extends ConstraintLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f294317d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutRecordMinutesSyncHeaderBinding f294318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f294319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RotateDrawable f294320c;

    public RecordMinutesSyncHeaderView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RecordMinutesSyncHeaderView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r100 = this.f294319b;
        if (r100 != null) goto L5;
    L7:
        this.f294319b = null;
        RotateDrawable r101 = this.f294320c;
        if (r101 == null) goto L11;
        r101.setLevel(0);
        return;
    L11:
        return;
    L5:
        if (r100.isRunning() == false) goto L7;
        r100.cancel();
        goto L7
    }

    public final void R5(d r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        boolean r101 = false;
        if (r100.f331787a == true) goto L13;
        setVisibility(8);
        ValueAnimator r102 = this.f294319b;
        if (r102 != null) goto L7;
    L9:
        this.f294319b = null;
        RotateDrawable r103 = this.f294320c;
        if (r103 == null) goto L25;
        r103.setLevel(0);
        return;
    L25:
        return;
    L7:
        if (r102.isRunning() == false) goto L9;
        r102.cancel();
        goto L9
    L13:
        setVisibility(0);
        this.f294318a.f293258c.setText(getContext().getString(R.string.larus_dora_ai_active_record_sync_file_progress_toast_cn, new Object[]{Integer.valueOf(r100.f331789c), Integer.valueOf(r100.f331788b)}));
        this.f294318a.f293257b.setProgress(RangesKt.coerceIn(r100.f331790d, 0, 100));
        ValueAnimator r104 = this.f294319b;
        if (r104 != null) goto L16;
    L18:
        if (r101 == true) goto L26;
        final RotateDrawable r105 = this.f294320c;
        if (r105 == null) goto L27;
        this.f294318a.f293258c.setCompoundDrawablesWithIntrinsicBounds(r105, null, null, null);
        ValueAnimator r106 = ValueAnimator.ofInt(new int[]{0, 10000});
        r106.setDuration(1000);
        r106.setRepeatCount(-1);
        r106.setInterpolator(new LinearInterpolator());
        r106.addUpdateListener(new e(r105));
        r106.start();
        this.f294319b = r106;
        return;
    L27:
        return;
    L26:
        return;
    L16:
        if (r104.isRunning() != true) goto L18;
        r101 = true;
        goto L18
    }

    public RecordMinutesSyncHeaderView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.larus_layout_record_minutes_sync_header, this, false);
        addView(r103);
        int r104 = R.id.sync_progress_bar;
        ProgressBar r105 = (ProgressBar) ViewBindings.findChildViewById(r103, R.id.sync_progress_bar);
        if (r105 == null) goto L9;
        r104 = R.id.sync_title_text;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r103, R.id.sync_title_text);
        if (r106 == null) goto L9;
        this.f294318a = new LarusLayoutRecordMinutesSyncHeaderBinding((ConstraintLayout) r103, r105, r106);
        setVisibility(8);
        Drawable r107 = ContextCompat.getDrawable(getContext(), R.drawable.larus_ic_album_real_sync);
        RotateDrawable r108 = new RotateDrawable();
        r108.setDrawable(r107);
        r108.setFromDegrees(0.0f);
        r108.setToDegrees(360.0f);
        r108.setPivotXRelative(true);
        r108.setPivotYRelative(true);
        r108.setPivotX(0.5f);
        r108.setPivotY(0.5f);
        this.f294320c = r108;
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ RecordMinutesSyncHeaderView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
