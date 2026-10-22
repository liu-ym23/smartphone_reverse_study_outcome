package com.bytedance.awemeopen.apps.framework.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/player/EdgeTransparentView;", "Landroid/view/View;", "Landroid/graphics/Bitmap;", "value", "f", "Landroid/graphics/Bitmap;", "getRealDrawBitmap", "()Landroid/graphics/Bitmap;", "setRealDrawBitmap", "(Landroid/graphics/Bitmap;)V", "realDrawBitmap", "", "g", "Z", "isBottomEdgeTransparent", "()Z", "setBottomEdgeTransparent", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class EdgeTransparentView extends View {
    public final Paint a;
    public final Paint b;
    public final int[] c;
    public final float[] d;
    public LinearGradient e;
    public Bitmap f;
    public boolean g;

    public final Bitmap getRealDrawBitmap() {
        return this.f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r13) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        super.onDraw(r13);
        Bitmap r0 = this.f;
        if (r0 == null) goto L9;
        int r1 = r13.saveLayer(0.0f, 0.0f, r0.getWidth(), r0.getHeight(), null);
        r13.drawBitmap(r0, 0.0f, 0.0f, this.a);
        this.b.setShader(this.e);
        if (this.g == false) goto L7;
        float r4 = 2;
        r13.rotate(180.0f, (r0.getWidth() * 1.0f) / r4, (r0.getHeight() * 1.0f) / r4);
    L7:
        r13.drawRect(0.0f, 0.0f, r0.getWidth(), r0.getHeight(), this.b);
        r13.restoreToCount(r1);
        return;
    }

    public final void setBottomEdgeTransparent(boolean r1) {
        this.g = r1;
    }

    public final void setRealDrawBitmap(Bitmap r9) {
        this.f = r9;
        Bitmap r0 = this.f;
        if (r0 == null) goto L5;
        float r4 = r0.getHeight();
    L6:
        this.e = new LinearGradient(0.0f, 0.0f, 0.0f, r4, this.c, this.d, Shader.TileMode.CLAMP);
        invalidate();
        return;
    L5:
        r4 = 0.0f;
        goto L6
    }

    public EdgeTransparentView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attributeSet");
        new LinkedHashMap();
        super(r2, r3);
        this.a = new Paint();
        Paint r4 = new Paint();
        r4.setFlags(1);
        r4.setStyle(Paint.Style.FILL);
        r4.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.b = r4;
        this.c = new int[]{-1, 0};
        this.d = new float[]{0.0f, 1.0f};
    }
}
