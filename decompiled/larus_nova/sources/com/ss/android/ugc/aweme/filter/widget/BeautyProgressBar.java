package com.ss.android.ugc.aweme.filter.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cB\u001d\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d¢\u0006\u0004\b\u001b\u0010\u001fB%\b\u0016\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010 \u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\"\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/ss/android/ugc/aweme/filter/widget/BeautyProgressBar;", "Lcom/ss/android/ugc/aweme/filter/widget/FilterBeautySeekBar;", "", "progress", "", "setProgress", "getProgress", "p", "I", "getMinValue", "()I", "setMinValue", "(I)V", "minValue", "q", "getMaxValue", "setMaxValue", "maxValue", "", "r", "Z", "isDoubleDirection", "()Z", "setDoubleDirection", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final class BeautyProgressBar extends FilterBeautySeekBar {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f450848p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f450849q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f450850r;

    @Override // com.ss.android.ugc.aweme.filter.widget.FilterBeautySeekBar, android.widget.ProgressBar
    public int getProgress() {
        int r100 = super.getProgress();
        if (this.f450850r == false) goto L8;
        float r101 = r100;
        if (r101 < (getMax() / 2.0f)) goto L7;
        String r102 = String.valueOf((int) (((this.f450849q / (getMax() / 2.0f)) * r101) - this.f450849q));
    L9:
        this.f450852b = r102;
        return r100;
    L7:
        r102 = String.valueOf((int) ((((-this.f450848p) / (getMax() / 2.0f)) * r101) + this.f450848p));
        goto L9
    L8:
        r102 = String.valueOf((int) ((((this.f450849q - this.f450848p) / getMax()) * r100) + this.f450848p));
        goto L9
    }

    public final int getMaxValue() {
        return this.f450849q;
    }

    public final int getMinValue() {
        return this.f450848p;
    }

    public BeautyProgressBar(Context r100) {
        super(r100);
        b(r100);
    }

    public final void b(Context r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f450853c.setColor(r100.getResources().getColor(R.color.tools_beauty_seek_bar));
        this.f450853c.setFakeBoldText(true);
    }

    public final void setDoubleDirection(boolean r100) {
        this.f450850r = r100;
    }

    public final void setMaxValue(int r100) {
        this.f450849q = r100;
    }

    public final void setMinValue(int r100) {
        this.f450848p = r100;
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int r100) {
        monitor-enter(this);
        int r101 = super.getProgress();     // Catch: Throwable -> L8
        super.setProgress(r100);     // Catch: Throwable -> L8
        if (r101 != super.getProgress()) goto L6;
        invalidate();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public BeautyProgressBar(Context r100, AttributeSet r101) {
        super(r100, r101);
        b(r100);
    }

    public BeautyProgressBar(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        b(r100);
    }
}
