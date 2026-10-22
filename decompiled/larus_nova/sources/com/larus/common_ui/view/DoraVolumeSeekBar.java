package com.larus.common_ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0014J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0014R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/common_ui/view/DoraVolumeSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tickTexts", "", "", "[Ljava/lang/String;", "tickCount", "", "textPaint", "Landroid/graphics/Paint;", "tickPaint", "height", "tickRadius", "", "tickTextMarginTop", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraVolumeSeekBar extends AppCompatSeekBar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f328222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f328223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f328224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f328225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f328226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f328227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f328228g;

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r100 = (getWidth() - getPaddingStart()) - getPaddingEnd();
        int r101 = this.f328223b;
        float r102 = r100 / r101;
        if (r101 < 0) goto L10;
        int r103 = 0;
    L5:
        float r104 = r103 * r102;
        r110.drawCircle(getPaddingStart() + r104, this.f328226e / 2, this.f328227f, this.f328225d);
        String r105 = (String) ArraysKt.getOrNull(this.f328222a, r103);
        if (r105 == null) goto L8;
        r110.drawText(r105, (r104 - (this.f328224c.measureText(r105) / 2)) + getPaddingStart(), (this.f328226e - this.f328224c.getTextSize()) + this.f328228g, this.f328224c);
    L8:
        if (r103 == r101) goto L10;
        r103 = r103 + 1;
    L10:
        super.onDraw(r110);
    }

    public DoraVolumeSeekBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f328222a = new String[]{"0", "5", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ};
        this.f328223b = 2;
        Paint r102 = new Paint();
        int r103 = j0.f375426a;
        r102.setColor(j0.a(v19.c.b(R.attr.larus_neutral_50, null, R.color.larus_neutral_50)));
        r102.setTextSize(r100.getResources().getDimension(v19.c.b(R.attr.larus_sp_12, r100, R.dimen.larus_sp_12)));
        r102.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
        this.f328224c = r102;
        Paint r104 = new Paint();
        r104.setColor(j0.a(v19.c.b(R.attr.larus_neutral_transparent_1, null, R.color.larus_neutral_transparent_1)));
        this.f328225d = r104;
        this.f328226e = r100.getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_45, r100, R.dimen.larus_dp_45));
        this.f328227f = r100.getResources().getDimension(v19.c.b(R.attr.larus_dp_2, r100, R.dimen.larus_dp_2));
        this.f328228g = r100.getResources().getDimension(v19.c.b(R.attr.larus_dp_8, r100, R.dimen.larus_dp_8));
        Drawable r105 = ContextCompat.getDrawable(r100, v19.c.b(R.attr.larus_dora_volume_seek_bar_progress, r100, R.drawable.larus_dora_volume_seek_bar_progress));
        if (r105 == null) goto L5;
        setProgressDrawable(r105);
    L5:
        Drawable r106 = ContextCompat.getDrawable(r100, v19.c.b(R.attr.larus_dora_volume_seek_bar_thumb, r100, R.drawable.larus_dora_volume_seek_bar_thumb));
        if (r106 == null) goto L9;
        setThumb(r106);
        return;
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        setMeasuredDimension(r100, this.f328226e);
    }
}
