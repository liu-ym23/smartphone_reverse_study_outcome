package com.bytedance.android.shopping.widget.ecvideoplayer;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R*\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/widget/ecvideoplayer/TextureRender;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/PlayerDebugView;", "ecDebugView", "", "setDebugView", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", "videoPlayer", "setPlayer", "", "value", "g", "I", "getScaleType", "()I", "setScaleType", "(I)V", "scaleType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TextureRender extends TextureView implements TextureView.SurfaceTextureListener {
    public boolean a;
    public ECVideoPlayer b;
    public SurfaceTexture c;
    public Surface d;
    public PlayerDebugView e;
    public final l f;
    public int g;

    public TextureRender(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public TextureRender(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "surfaceTexture");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r2) {
        Intrinsics.checkNotNullParameter(r2, "surface");
    }

    public final int getScaleType() {
        return this.g;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r2) {
        Intrinsics.checkNotNullParameter(r2, "surfaceTexture");
        PlayerDebugView r3 = this.e;
        if (r3 == null) goto L7;
        TextView r4 = r3.e;
        if (r4 == null) goto L7;
        r4.setText("surface:none");
    L7:
        this.a = false;
        ECVideoPlayer r0 = this.b;
        if (r0 == null) goto L10;
        r0.i();
    L10:
        Surface r1 = this.d;
        if (r1 == null) goto L13;
        r1.release();
    L13:
        SurfaceTexture r5 = this.c;
        if (r5 == null) goto L16;
        r5.release();
    L16:
        this.c = null;
        this.d = null;
        return false;
    }

    public final void setDebugView(PlayerDebugView r2) {
        Intrinsics.checkNotNullParameter(r2, "ecDebugView");
        this.e = r2;
        if (this.a == false) goto L6;
        Surface r0 = this.d;
        Intrinsics.checkNotNull(r0);
        r2.a(r0);
        return;
    }

    public final void setPlayer(ECVideoPlayer r5) {
        Intrinsics.checkNotNullParameter(r5, "videoPlayer");
        this.b = r5;
        l r0 = this.f;
        int r1 = r5.h;
        int r2 = r5.i;
        if (r0.b == r2) goto L5;
    L6:
        r0.b = r2;
        r0.a = r1;
        r0.c.requestLayout();
    L8:
        if (this.a == false) goto L11;
        Surface r3 = this.d;
        Intrinsics.checkNotNull(r3);
        r5.h(r3);
        return;
    L11:
        return;
    L5:
        if (r0.a == r1) goto L8;
        goto L6
    }

    public final void setScaleType(int r1) {
        this.g = r1;
        requestLayout();
    }

    @Override // android.view.View
    public final void onMeasure(int r9, int r10) {
        l r0 = this.f;
        int r1 = this.g;
        r0.getClass();
        int r2 = View.MeasureSpec.getSize(r9);
        int r3 = View.MeasureSpec.getSize(r10);
        float r4 = r0.a / r0.b;
        float r5 = r2;
        float r6 = r3;
        float r7 = r5 / r6;
        if (r1 == 1) goto L5;
        if (r1 == 0) goto L9;
    L12:
        Pair r8 = new Pair(Integer.valueOf(r2), Integer.valueOf(r3));
        if (((Number) r8.getFirst()).intValue() != 0) goto L15;
    L18:
        super.onMeasure(r9, r10);
        return;
    L15:
        if (((Number) r8.getSecond()).intValue() == 0) goto L18;
        setMeasuredDimension(((Number) r8.getFirst()).intValue(), ((Number) r8.getSecond()).intValue());
        return;
    L9:
        if (r4 <= r7) goto L11;
    L10:
        r3 = (int) (r5 / r4);
    L11:
        r2 = (int) (r6 * r4);
        goto L12
    L5:
        if (r4 <= r7) goto L10;
        goto L10
    }

    public TextureRender(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.f = new l(this);
        this.g = 1;
        setSurfaceTextureListener(this);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "surfaceTexture");
        if (this.a == true) goto L11;
        this.c = r1;
        Surface r4 = new Surface(this.c);
        this.d = r4;
        this.a = true;
        ECVideoPlayer r5 = this.b;
        if (r5 == null) goto L7;
        Intrinsics.checkNotNull(r4);
        r5.h(r4);
    L7:
        PlayerDebugView r6 = this.e;
        if (r6 == null) goto L12;
        Surface r7 = this.d;
        Intrinsics.checkNotNull(r7);
        r6.a(r7);
        return;
    L12:
        return;
    }

    public /* synthetic */ TextureRender(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
