package com.bytedance.ee.bear.bitable.celleditor.editor.signature;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<PointF> f209549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Float> f209550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f209551c;

    public d() {
        this.f209549a = new ArrayList();
        this.f209550b = new ArrayList();
        this.f209551c = new Path();
    }

    public final void a(Canvas r110, Paint r111, float r112) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        Intrinsics.checkNotNullParameter(r111, "paint");
        if (((ArrayList) this.f209549a).isEmpty() == false) goto L6;
        return;
    L6:
        if (((ArrayList) this.f209549a).size() != 1) goto L9;
        r111.setStrokeWidth(r112 * ((((Number) ListProtector.get(this.f209550b, 0)).floatValue() * 0.3f) + 0.7f));
        r110.drawPoint(((PointF) ListProtector.get(this.f209549a, 0)).x, ((PointF) ListProtector.get(this.f209549a, 0)).y, r111);
        return;
    L9:
        int r100 = ((ArrayList) this.f209549a).size();
        int r101 = 1;
    L10:
        if (r101 >= r100) goto L16;
        PointF r102 = (PointF) ListProtector.get(this.f209549a, r101 - 1);
        PointF r103 = (PointF) ListProtector.get(this.f209549a, r101);
        float r104 = (r102.x + r103.x) / 2.0f;
        float r105 = (r102.y + r103.y) / 2.0f;
        this.f209551c.rewind();
        if (r101 != 1) goto L14;
        this.f209551c.moveTo(r102.x, r102.y);
        this.f209551c.lineTo(r104, r105);
    L15:
        r111.setStrokeWidth(((((Number) ListProtector.get(this.f209550b, r101)).floatValue() * 0.3f) + 0.7f) * r112);
        r110.drawPath(this.f209551c, r111);
        r101 = r101 + 1;
        goto L10
    L14:
        PointF r106 = (PointF) ListProtector.get(this.f209549a, r101 - 2);
        this.f209551c.moveTo((r106.x + r102.x) / 2.0f, (r106.y + r102.y) / 2.0f);
        this.f209551c.quadTo(r102.x, r102.y, r104, r105);
        goto L15
    }
}
