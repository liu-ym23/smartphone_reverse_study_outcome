package com.ss.android.lark.widget.photo.preview.ocr;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f447080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f447081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f447082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f447083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f447084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f447085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f447086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f447087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f447088i;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "TextGraphic {Text: " + this.f447080a.f447077a + " , Points: " + this.f447080a.f447079c + ", Offset: " + TuplesKt.to(Float.valueOf(this.f447083d), Float.valueOf(this.f447084e)) + '}';
    }

    public final void a(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Log.d("TextGraphic", "on draw text graphic");
        RectF r101 = this.f447088i;
        r101.set(this.f447080a.f447078b);
        r101.offset(this.f447083d, this.f447084e);
        r100.drawRect(r101, this.f447081b);
        float r102 = this.f447086g;
        float r103 = r101.centerX();
        float r104 = r101.centerY();
        int r105 = r100.save();
        r100.rotate(r102, r103, r104);
        TextDrawUtils.c(r100, this.f447080a.f447077a, r101, this.f447085f, this.f447082c);     // Catch: Throwable -> L6
        r100.restoreToCount(r105);
        return;
    L6:
        th = move-exception;
        r100.restoreToCount(r105);
        throw th;
    }

    public d(TextGraphicOverlay r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "overlay");
        Intrinsics.checkNotNullParameter(r101, "textElement");
        this.f447080a = r101;
        Paint r102 = new Paint();
        this.f447081b = r102;
        Path r103 = new Path();
        List<Point> r104 = r101.f447079c;
        if (r104.size() != 4) goto L6;
        r103.moveTo(((Point) ListProtector.get(r104, 0)).x, ((Point) ListProtector.get(r104, 0)).y);
        r103.lineTo(((Point) ListProtector.get(r104, 1)).x, ((Point) ListProtector.get(r104, 1)).y);
        r103.lineTo(((Point) ListProtector.get(r104, 2)).x, ((Point) ListProtector.get(r104, 2)).y);
        r103.lineTo(((Point) ListProtector.get(r104, 3)).x, ((Point) ListProtector.get(r104, 3)).y);
        r103.lineTo(((Point) ListProtector.get(r104, 0)).x, ((Point) ListProtector.get(r104, 0)).y);
    L6:
        this.f447087h = r103;
        this.f447088i = new RectF();
        r102.setColor(FakePickerAvatarCreator.BLUE);
        r102.setStyle(Paint.Style.STROKE);
        r102.setStrokeWidth(4.0f);
        Paint r105 = new Paint();
        this.f447082c = r105;
        r105.setColor(FakePickerAvatarCreator.BLUE);
        r105.setTextSize(54.0f);
        r100.postInvalidate();
    }
}
