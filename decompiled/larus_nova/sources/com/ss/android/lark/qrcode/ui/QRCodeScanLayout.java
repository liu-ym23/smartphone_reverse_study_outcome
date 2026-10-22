package com.ss.android.lark.qrcode.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.core.math.MathUtils;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0014J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&H\u0002R\u0019\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0007X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006'"}, d2 = {"Lcom/ss/android/lark/qrcode/ui/QRCodeScanLayout;", "Landroid/view/View;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "scanningBitmap", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "getScanningBitmap", "()Landroid/graphics/Bitmap;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "dstRect", "Landroid/graphics/RectF;", "getDstRect", "()Landroid/graphics/RectF;", "loopDuration", "getLoopDuration", "()I", DyPayConstant.KEY_START_TIME, "", "getStartTime", "()J", "setStartTime", "(J)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "calculateAlpha", "factor", "", "qrcode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QRCodeScanLayout extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f439007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f439008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f439009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f439010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f439011e;

    public QRCodeScanLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public QRCodeScanLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final RectF getDstRect() {
        return this.f439009c;
    }

    public final int getLoopDuration() {
        return this.f439010d;
    }

    public final Paint getPaint() {
        return this.f439008b;
    }

    public final Bitmap getScanningBitmap() {
        return this.f439007a;
    }

    public final long getStartTime() {
        return this.f439011e;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        if (this.f439011e != 0) goto L5;
        this.f439011e = SystemClock.uptimeMillis();
    L5:
        float r100 = getWidth();
        float r101 = (this.f439007a.getHeight() / this.f439007a.getWidth()) * r100;
        float r102 = (1.0f / this.f439010d) * ((SystemClock.uptimeMillis() - this.f439011e) % ((long) this.f439010d));
        float r103 = (getHeight() - r101) * r102;
        this.f439008b.setAlpha(MathKt.roundToInt(MathUtils.clamp(((double) 3) * Math.sin(((double) r102) * 3.141592653589793d), AudioStats.AUDIO_AMPLITUDE_NONE, 1.0d) * ((double) 255)));
        RectF r104 = this.f439009c;
        r104.top = r103;
        r104.bottom = r101 + r103;
        r104.right = r100;
        r110.drawBitmap(this.f439007a, null, r104, this.f439008b);
        invalidate();
    }

    public final void setStartTime(long r100) {
        this.f439011e = r100;
    }

    public QRCodeScanLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f439007a = BitmapFactory.decodeResource(r100.getResources(), R.drawable.common_scanning);
        this.f439008b = new Paint();
        this.f439009c = new RectF();
        this.f439010d = 3000;
    }

    public /* synthetic */ QRCodeScanLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
