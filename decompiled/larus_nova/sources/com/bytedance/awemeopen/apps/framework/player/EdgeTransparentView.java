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
import com.amap.api.col.s.ce;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R.\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/player/EdgeTransparentView;", "Landroid/view/View;", "Landroid/graphics/Bitmap;", "value", "f", "Landroid/graphics/Bitmap;", "getRealDrawBitmap", "()Landroid/graphics/Bitmap;", "setRealDrawBitmap", "(Landroid/graphics/Bitmap;)V", "realDrawBitmap", "", ce.f26391f, "Z", "isBottomEdgeTransparent", "()Z", "setBottomEdgeTransparent", "(Z)V", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class EdgeTransparentView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f197235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f197236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f197237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f197238d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearGradient f197239e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f197240f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f197241g;

    public final Bitmap getRealDrawBitmap() {
        return this.f197240f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        Bitmap r100 = this.f197240f;
        if (r100 == null) goto L9;
        int r101 = r110.saveLayer(0.0f, 0.0f, r100.getWidth(), r100.getHeight(), null);
        r110.drawBitmap(r100, 0.0f, 0.0f, this.f197235a);
        this.f197236b.setShader(this.f197239e);
        if (this.f197241g == false) goto L7;
        float r102 = 2;
        r110.rotate(180.0f, (r100.getWidth() * 1.0f) / r102, (r100.getHeight() * 1.0f) / r102);
    L7:
        r110.drawRect(0.0f, 0.0f, r100.getWidth(), r100.getHeight(), this.f197236b);
        r110.restoreToCount(r101);
        return;
    }

    public final void setBottomEdgeTransparent(boolean r100) {
        this.f197241g = r100;
    }

    public final void setRealDrawBitmap(Bitmap r100) {
        this.f197240f = r100;
        Bitmap r101 = this.f197240f;
        if (r101 == null) goto L5;
        float r102 = r101.getHeight();
    L6:
        this.f197239e = new LinearGradient(0.0f, 0.0f, 0.0f, r102, this.f197237c, this.f197238d, Shader.TileMode.CLAMP);
        invalidate();
        return;
    L5:
        r102 = 0.0f;
        goto L6
    }

    public EdgeTransparentView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        new LinkedHashMap();
        super(r100, r101);
        this.f197235a = new Paint();
        Paint r102 = new Paint();
        r102.setFlags(1);
        r102.setStyle(Paint.Style.FILL);
        r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f197236b = r102;
        this.f197237c = new int[]{-1, 0};
        this.f197238d = new float[]{0.0f, 1.0f};
    }
}
