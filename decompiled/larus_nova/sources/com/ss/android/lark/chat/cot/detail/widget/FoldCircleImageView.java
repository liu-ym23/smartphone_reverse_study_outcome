package com.ss.android.lark.chat.cot.detail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000fH\u0014J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"H\u0014J\u0017\u0010#\u001a\u00020\u001b2\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/widget/FoldCircleImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "borderPaint", "Landroid/graphics/Paint;", "circlePath", "Landroid/graphics/Path;", "borderWidth", "", "borderColor", "", "radius", "borderRadius", "circleBackgroundColor", "circleBackgroundColorInt", "drawBorder", "", "getDrawBorder", "()Z", "setDrawBorder", "(Z)V", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setCircleBackgroundColor", "color", "(Ljava/lang/Integer;)V", "setPaddings", GXTemplateKey.FLEXBOX_PADDING, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FoldCircleImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f415031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f415032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f415033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f415034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f415035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f415036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f415037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f415038h;

    public static final class a {
    }

    static {
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Path r101 = this.f415032b;
        int r102 = r100.save();
        r100.clipPath(r101);
        r100.drawColor(this.f415037g);     // Catch: Throwable -> L8
        super.onDraw(r100);     // Catch: Throwable -> L8
        r100.restoreToCount(r102);
        if (this.f415038h == false) goto L13;
        r100.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, this.f415035e, this.f415031a);
        return;
    L13:
        return;
    L8:
        th = move-exception;
        r100.restoreToCount(r102);
        throw th;
    }

    public FoldCircleImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        Paint r102 = new Paint(1);
        this.f415031a = r102;
        this.f415032b = new Path();
        float r103 = UIUtils.dp2px(r100, 1.0f);
        this.f415033c = r103;
        int r104 = UIUtils.getColor(r100, R.color.bg_body);
        this.f415036f = R.color.bg_body_overlay;
        this.f415037g = UIUtils.getColor(r100, R.color.bg_body_overlay);
        this.f415038h = true;
        r102.setStyle(Paint.Style.STROKE);
        r102.setColor(r104);
        r102.setStrokeWidth(r103);
        r102.setAntiAlias(true);
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = Math.min(r100, r101) / 2.0f;
        this.f415034d = r104;
        this.f415035e = r104 - (this.f415033c / 2.0f);
        this.f415032b.reset();
        this.f415032b.addCircle(r100 / 2.0f, r101 / 2.0f, this.f415034d, Path.Direction.CW);
    }
}
