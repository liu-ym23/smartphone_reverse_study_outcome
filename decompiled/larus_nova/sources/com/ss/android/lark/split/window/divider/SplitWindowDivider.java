package com.ss.android.lark.split.window.divider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import j08.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000fJ\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/split/window/divider/SplitWindowDivider;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "cornerRadius", "", "rodWidth", "setCornerRadius", "", "dp", "setRodWidth", "onDraw", "canvas", "Landroid/graphics/Canvas;", "split-window_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SplitWindowDivider extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f440605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f440606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f440607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f440608d;

    public SplitWindowDivider(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SplitWindowDivider(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        super.onDraw(r210);
        this.f440606b.reset();
        float r100 = getWidth();
        float r101 = getHeight();
        float r102 = this.f440608d;
        float r110 = 2;
        float r103 = (r100 - r102) / r110;
        float r104 = r103 + r102;
        float r111 = 0;
        this.f440606b.moveTo(r103, r111 - this.f440607c);
        Path r112 = this.f440606b;
        float r105 = this.f440607c;
        r112.arcTo(r103 - (r110 * r105), 0.0f, r103, r110 * r105, 0.0f, -90.0f, false);
        this.f440606b.lineTo(this.f440607c + r104, 0.0f);
        Path r113 = this.f440606b;
        float r106 = this.f440607c;
        r113.arcTo(r104, 0.0f, r104 + (r110 * r106), r110 * r106, 270.0f, -90.0f, false);
        this.f440606b.lineTo(r104, r101 - this.f440607c);
        Path r107 = this.f440606b;
        float r108 = this.f440607c;
        r107.arcTo(r104, r101 - (r110 * r108), r104 + (r108 * r110), r101, 180.0f, -90.0f, false);
        this.f440606b.lineTo(r103 - this.f440607c, r101);
        Path r109 = this.f440606b;
        float r114 = this.f440607c;
        r109.arcTo(r103 - (r110 * r114), r101 - (r110 * r114), r103, r101, 90.0f, -90.0f, false);
        this.f440606b.lineTo(r103, r111 - this.f440607c);
        this.f440606b.close();
        r210.drawPath(this.f440606b, this.f440605a);
    }

    public SplitWindowDivider(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        Paint r103 = new Paint();
        r103.setColor(UDColorUtils.getColor(r100, R.color.text_black));
        r103.setStyle(Paint.Style.FILL);
        r103.setAntiAlias(true);
        this.f440605a = r103;
        this.f440606b = new Path();
        this.f440607c = d.a(r100, 10.0f);
        this.f440608d = d.a(r100, 4.0f);
    }

    public /* synthetic */ SplitWindowDivider(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
