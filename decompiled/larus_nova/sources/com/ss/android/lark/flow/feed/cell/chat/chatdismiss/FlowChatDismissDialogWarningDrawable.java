package com.ss.android.lark.flow.feed.cell.chat.chatdismiss;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowChatDismissDialogWarningDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f423275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f423276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f423277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f423278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f423279e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Path f423280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f423281g;

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public final int getOpacity() {
        return -3;
    }

    public final Context getContext() {
        return this.f423275a;
    }

    public FlowChatDismissDialogWarningDrawable(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f423275a = r100;
        Lazy r101 = LazyKt.lazy(new FlowChatDismissDialogWarningDrawable$strokePaintColor$2(this));
        this.f423276b = r101;
        this.f423277c = LazyKt.lazy(new FlowChatDismissDialogWarningDrawable$fillPaintColorRed$2(this));
        Paint r102 = new Paint(1);
        r102.setStyle(Paint.Style.FILL);
        this.f423278d = r102;
        Paint r103 = new Paint(1);
        r103.setStyle(Paint.Style.STROKE);
        r103.setColor(((Number) r101.getValue()).intValue());
        r103.setStrokeWidth(2.0f);
        r103.setStrokeJoin(Paint.Join.ROUND);
        r103.setStrokeCap(Paint.Cap.ROUND);
        this.f423279e = r103;
        this.f423280f = new Path();
        this.f423281g = new Path();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        Rect r100 = getBounds();
        float r101 = Math.min(r100.width(), r100.height()) / 22.0f;
        r210.save();
        r210.translate(r100.left, r100.top);
        r210.scale(r101, r101);
        this.f423278d.setColor(((Number) this.f423277c.getValue()).intValue());
        this.f423280f.reset();
        this.f423280f.moveTo(11.9902f, 1.0f);
        this.f423280f.cubicTo(13.4876f, 1.0f, 14.9109f, 1.28714f, 16.25f, 1.86621f);
        this.f423280f.cubicTo(17.5736f, 2.43859f, 18.7441f, 3.23242f, 19.7559f, 4.24414f);
        this.f423280f.cubicTo(20.7671f, 5.25535f, 21.5605f, 6.42525f, 22.1328f, 7.74805f);
        this.f423280f.lineTo(22.3369f, 8.25293f);
        this.f423280f.cubicTo(22.7803f, 9.43863f, 23.0f, 10.69f, 23.0f, 12.0f);
        this.f423280f.cubicTo(23.0f, 13.4974f, 22.7129f, 14.9207f, 22.1338f, 16.2598f);
        this.f423280f.lineTo(22.1328f, 16.2617f);
        this.f423280f.cubicTo(21.5602f, 17.5786f, 20.7667f, 18.7451f, 19.7559f, 19.7559f);
        this.f423280f.cubicTo(18.7441f, 20.7676f, 17.5736f, 21.5614f, 16.25f, 22.1338f);
        this.f423280f.cubicTo(14.9168f, 22.7131f, 13.4967f, 23.0f, 12.0f, 23.0f);
        this.f423280f.cubicTo(10.5026f, 23.0f, 9.07934f, 22.7129f, 7.74023f, 22.1338f);
        this.f423280f.lineTo(7.73828f, 22.1328f);
        this.f423280f.cubicTo(6.42142f, 21.5602f, 5.25493f, 20.7667f, 4.24414f, 19.7559f);
        this.f423280f.cubicTo(3.23335f, 18.7451f, 2.43976f, 17.5786f, 1.86719f, 16.2617f);
        this.f423280f.lineTo(1.86621f, 16.2598f);
        this.f423280f.cubicTo(1.28714f, 14.9207f, 1.0f, 13.4974f, 1.0f, 12.0f);
        this.f423280f.cubicTo(1.0f, 10.5026f, 1.28733f, 9.08172f, 1.86719f, 7.74805f);
        this.f423280f.cubicTo(2.43885f, 6.42675f, 3.22762f, 5.25709f, 4.23145f, 4.24609f);
        this.f423280f.lineTo(4.23438f, 4.24414f);
        this.f423280f.cubicTo(5.24517f, 3.23335f, 6.41165f, 2.43976f, 7.72852f, 1.86719f);
        this.f423280f.lineTo(7.73047f, 1.86621f);
        this.f423280f.cubicTo(9.06957f, 1.28715f, 10.4929f, 1.0f, 11.9902f, 1.0f);
        this.f423280f.close();
        r210.drawPath(this.f423280f, this.f423278d);
        r210.drawPath(this.f423280f, this.f423279e);
        this.f423278d.setColor(((Number) this.f423276b.getValue()).intValue());
        this.f423281g.reset();
        this.f423281g.moveTo(12.0f, 13.8236f);
        this.f423281g.cubicTo(12.5098f, 13.8236f, 12.768f, 13.5557f, 12.7745f, 13.0197f);
        this.f423281g.lineTo(12.9216f, 7.68638f);
        this.f423281g.cubicTo(12.9281f, 7.43148f, 12.8399f, 7.21906f, 12.6569f, 7.04913f);
        this.f423281g.cubicTo(12.4804f, 6.87266f, 12.2582f, 6.78442f, 11.9902f, 6.78442f);
        this.f423281g.cubicTo(11.7157f, 6.78442f, 11.4902f, 6.86939f, 11.3137f, 7.03933f);
        this.f423281g.cubicTo(11.1438f, 7.20926f, 11.0621f, 7.42168f, 11.0686f, 7.67658f);
        this.f423281g.lineTo(11.1961f, 13.0197f);
        this.f423281g.cubicTo(11.2092f, 13.5557f, 11.4771f, 13.8236f, 12.0f, 13.8236f);
        this.f423281g.close();
        r210.drawPath(this.f423281g, this.f423278d);
        r210.drawCircle(12.0f, 16.05f, 1.05f, this.f423278d);
        r210.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
        this.f423278d.setAlpha(r100);
        this.f423279e.setAlpha(r100);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
        this.f423278d.setColorFilter(r100);
        this.f423279e.setColorFilter(r100);
    }
}
