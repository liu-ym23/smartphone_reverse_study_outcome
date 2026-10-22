package com.larus.uaigc.createpage.bussiness.remove.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.viewbinding.ViewBindings;
import com.larus.nova.R;
import com.larus.uaigc.impl.databinding.LarusWidgetPaintSizeControllerBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0015B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaintSizeControllerView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetPaintSizeControllerBinding;", "config", "Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaintSizeControllerView$Config;", "offset", "step", "setConfig", "", "setProgress", "progress", "currentProgress", "Config", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaintSizeControllerView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusWidgetPaintSizeControllerBinding f371498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f371499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f371500c;

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaintSizeControllerView f371501a;

        public a(PaintSizeControllerView r100) {
            this.f371501a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
            SeekBar.OnSeekBarChangeListener r101 = this.f371501a.f371499b.f371504c;
            if (r101 == null) goto L6;
            r101.onStartTrackingTouch(r100);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            SeekBar.OnSeekBarChangeListener r101 = this.f371501a.f371499b.f371504c;
            if (r101 == null) goto L6;
            r101.onStopTrackingTouch(r100);
            return;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            PaintSizeControllerView r103 = this.f371501a;
            SeekBar.OnSeekBarChangeListener r104 = r103.f371499b.f371504c;
            if (r104 == null) goto L6;
            r104.onProgressChanged(r100, r101 + r103.f371500c, r102);
            return;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f371502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f371503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SeekBar.OnSeekBarChangeListener f371504c;

        public b(int r100, int r101, SeekBar.OnSeekBarChangeListener r102) {
            this.f371502a = r100;
            this.f371503b = r101;
            this.f371504c = r102;
        }
    }

    public PaintSizeControllerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PaintSizeControllerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setConfig(b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f371499b = r100;
        int r101 = r100.f371502a;
        this.f371500c = r101;
        this.f371498a.f373284d.setMax(r100.f371503b + r101);
        RangesKt.coerceAtLeast(1, (r100.f371503b - r100.f371502a) / 5);
        invalidate();
    }

    public final void setProgress(int r100) {
        this.f371498a.f373284d.setProgress(r100 - this.f371500c);
    }

    public PaintSizeControllerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_widget_paint_size_controller, this);
        int r103 = R.id.left_icon;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.left_icon);
        if (r104 == null) goto L11;
        r103 = R.id.right_icon;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.right_icon);
        if (r105 == null) goto L11;
        r103 = R.id.seek_bar;
        SeekBar r106 = (SeekBar) ViewBindings.findChildViewById(this, R.id.seek_bar);
        if (r106 == null) goto L11;
        this.f371498a = new LarusWidgetPaintSizeControllerBinding(this, r104, r105, r106);
        this.f371499b = new b(0, 100, null);
        r106.setOnSeekBarChangeListener(new a(this));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ PaintSizeControllerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
