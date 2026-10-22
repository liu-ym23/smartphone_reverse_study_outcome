package com.ss.android.lark.inline.ai.creationai;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e0 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f427062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f427063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f427064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f427065d;

    public static final class a {
    }

    static {
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r100) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    public e0(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f427062a = r100;
        Paint r101 = new Paint();
        r101.setAntiAlias(true);
        com.ss.android.lark.storage.a r102 = com.ss.android.lark.inline.ai.logic.b.f427283a;
        r101.setColor(ContextCompat.getColor(r100, R.color.bg_float));
        this.f427063b = r101;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        float r111 = Math.min(getBounds().width(), getBounds().height());
        int r112 = r110.saveLayer(0.0f, 0.0f, getBounds().width(), getBounds().height(), this.f427063b);
        if (this.f427064c <= 0.0f) goto L5;
        float r100 = getBounds().left;
        float r101 = getBounds().top;
        float r102 = getBounds().right;
        float r103 = getBounds().bottom;
        float r104 = this.f427064c;
        r110.drawRoundRect(r100, r101, r102, r103, r104, r104, this.f427063b);
    L6:
        Paint r105 = this.f427063b;
        float r106 = Math.min(getBounds().width(), getBounds().height());
        float r107 = (getBounds().left + r106) / 2.0f;
        float r108 = (getBounds().top + r106) / 2.0f;
        Matrix r109 = new Matrix();
        r109.preRotate(((System.currentTimeMillis() % ((long) 3000)) / 3000.0f) * 360, r107, r108);
        SweepGradient r113 = new SweepGradient(r107, r108, ArraysKt.toIntArray(new Integer[]{Integer.valueOf(UDColorUtils.getColor(this.f427062a, R.color.ai_dynamic_line_0)), Integer.valueOf(UDColorUtils.getColor(this.f427062a, R.color.ai_dynamic_line_1)), Integer.valueOf(UDColorUtils.getColor(this.f427062a, R.color.ai_dynamic_line_1)), Integer.valueOf(UDColorUtils.getColor(this.f427062a, R.color.ai_dynamic_line_0))}), null);
        r113.setLocalMatrix(r109);
        r105.setShader(r113);
        this.f427063b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        if (getBounds().width() <= getBounds().height()) goto L9;
        r110.scale(getBounds().width() / getBounds().height(), 1.0f);
    L10:
        r110.drawRect(getBounds().left, getBounds().top, getBounds().left + r111, getBounds().top + r111, this.f427063b);
        this.f427063b.setShader(null);
        this.f427063b.setXfermode(null);
        r110.restoreToCount(r112);
        if (this.f427064c <= 0.0f) goto L13;
        float r114 = this.f427065d + getBounds().left;
        float r115 = this.f427065d + getBounds().top;
        float r116 = getBounds().right - this.f427065d;
        float r117 = getBounds().bottom;
        float r118 = this.f427065d;
        float r119 = r117 - r118;
        float r120 = this.f427064c;
        r110.drawRoundRect(r114, r115, r116, r119, r120 - r118, r120 - r118, this.f427063b);
        return;
    L13:
        r110.drawRect(this.f427065d + getBounds().left, this.f427065d + getBounds().top, getBounds().right - this.f427065d, getBounds().bottom - this.f427065d, this.f427063b);
        return;
    L9:
        r110.scale(1.0f, getBounds().height() / getBounds().width());
        goto L10
    L5:
        r110.drawRect(getBounds().left, getBounds().top, getBounds().right, getBounds().bottom, this.f427063b);
        goto L6
    }
}
