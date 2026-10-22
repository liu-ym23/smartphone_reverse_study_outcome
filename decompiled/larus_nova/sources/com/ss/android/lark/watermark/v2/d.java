package com.ss.android.lark.watermark.v2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class d extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f445540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wbc.a f445541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f445542c;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r210) {
        Intrinsics.checkNotNullParameter(r210, "canvas");
        if (this.f445540a.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        this.f445542c.setEmpty();
        wbc.a r101 = this.f445541b;
        Rect r102 = getBounds();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r210, "canvas");
        Intrinsics.checkNotNullParameter(r102, "canvasBounds");
        wbc.a.c r103 = r101.f559038a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r210, "canvas");
        Intrinsics.checkNotNullParameter(r102, "canvasBounds");
        if (r102.width() == r103.f559042d) goto L11;
    L13:
        r103.f559042d = r102.width();
        r103.f559043e = r102.height();
        ((ArrayList) r103.f559050l).clear();
        ((ArrayList) r103.f559049k).clear();
        r103.f559047i = (r102.width() / ((int) r103.f559053o)) + 1;
        r103.f559048j = (r102.height() / ((int) r103.f559054p)) + 1;
        int r104 = r103.f559047i;
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L16;
        List<vbc.a> r106 = r103.f559050l;
        vbc.a r107 = r103.f559055q;
        double r110 = r107.f554075a;
        double r111 = r105 * r103.f559053o;
        double r112 = r103.f559046h * r111;
        double r113 = r110 + r112;
        double r114 = r107.f554076b;
        double r115 = r111 * r103.f559045g;
        ((ArrayList) r106).add(new vbc.a(r113, r114 - r115, r107.f554077c + r112, r107.f554078d - r115));
        r105 = r105 + 1;
        r104 = r104;
        goto L14
    L16:
        int r108 = r103.f559048j;
        int r109 = 0;
    L17:
        if (r109 >= r108) goto L27;
        int r116 = r103.f559047i;
        int r117 = 0;
    L19:
        if (r117 >= r116) goto L25;
        if ((((r109 % 2) + (r117 % 2)) % 2) != 0) goto L24;
        List<vbc.a> r118 = r103.f559049k;
        float r119 = r109;
        ArrayList r120 = (ArrayList) r118;
        r120.add(new vbc.a((((double) (r103.f559054p * r119)) * r103.f559045g) + ((vbc.a) ListProtector.get(r103.f559050l, r117)).f554075a, ((vbc.a) ListProtector.get(r103.f559050l, r117)).f554076b + (((double) (r103.f559054p * r119)) * r103.f559046h), ((vbc.a) ListProtector.get(r103.f559050l, r117)).f554077c + (((double) (r103.f559054p * r119)) * r103.f559045g), ((vbc.a) ListProtector.get(r103.f559050l, r117)).f554078d + (((double) (r119 * r103.f559054p)) * r103.f559046h)));
    L24:
        r117 = r117 + 1;
        r108 = r108;
        r109 = r109;
        r116 = r116;
        goto L19
    L25:
        r109 = r109 + 1;
    L27:
        if (((ArrayList) r103.f559049k).isEmpty() == false) goto L29;
        Log.i("CustomizedWatermark", "Coordinate is null, draw watermark cancel");
        return;
    L29:
        r210.save();
        r210.rotate(r103.f559044f, (float) ((vbc.a) ListProtector.get(r103.f559049k, 0)).f554075a, (float) ((vbc.a) ListProtector.get(r103.f559049k, 0)).f554076b);
        if (((ArrayList) r103.f559049k).isEmpty() == true) goto L63;
        int r121 = ((ArrayList) r103.f559049k).size();
        int r122 = 0;
    L33:
        if (r122 >= r121) goto L49;
        Path r123 = r103.f559056r;
        List<String> r124 = r103.f559052n;
        vbc.a r125 = (vbc.a) ListProtector.get(r103.f559049k, r122);
        Paint r126 = r103.f559040b;
        int r127 = r103.f559051m;
        monitor-enter(r123);
        Iterator r128 = ((ArrayList) r124).iterator();     // Catch: Throwable -> L46
        int r129 = 0;
    L38:
        if (r128.hasNext() == false) goto L43;
        Object r130 = r128.next();     // Catch: Throwable -> L46
        int r131 = r129 + 1;     // Catch: Throwable -> L46
        if (r129 >= 0) goto L42;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L46
    L42:
        float r132 = r129 * r127;     // Catch: Throwable -> L46
        r123.moveTo((float) r125.f554075a, ((float) r125.f554076b) + r132);     // Catch: Throwable -> L46
        r123.lineTo((float) r125.f554077c, ((float) r125.f554076b) + r132);     // Catch: Throwable -> L46
        r210.drawTextOnPath((String) r130, r123, 0.0f, 0.0f, r126);     // Catch: Throwable -> L46
        r123.reset();     // Catch: Throwable -> L46
        r129 = r131;
        goto L38
    L43:
        Unit r133 = Unit.INSTANCE;     // Catch: Throwable -> L46
        monitor-exit(r123);
        r122 = r122 + 1;
    L46:
        th = move-exception;
        throw th;
    L49:
        r210.restore();
        return;
    L63:
        return;
    L11:
        if (r102.height() != r103.f559043e) goto L13;
    L5:
        r100 = false;
        goto L6
    }

    public d(Context r110, String r111, float r112, float r113, int r114, int r115, float r116, float r117) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "text");
        String r100 = StringsKt.trim(r111).toString();
        this.f445540a = r100;
        if (h18.f.a(r110) == false) goto L5;
        float r101 = r113;
    L6:
        this.f445541b = new wbc.a(r110, r100, r114, r101, r116, r117, r115);
        this.f445542c = new Rect();
        return;
    L5:
        r101 = r112;
        goto L6
    }
}
