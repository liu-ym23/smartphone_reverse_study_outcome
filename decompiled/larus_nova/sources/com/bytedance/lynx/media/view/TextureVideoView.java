package com.bytedance.lynx.media.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.lynx.tasm.base.LLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import m07.b;

/* JADX INFO: loaded from: classes21.dex */
public class TextureVideoView extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Surface f264843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SurfaceTexture f264844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextureView.SurfaceTextureListener f264845c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f264846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f264847e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f264848f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f264849g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f264850h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f264851i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f264852j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f264853k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f264854l;

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        this.f264852j = 0;
        this.f264853k = 0;
        super.onAttachedToWindow();
    }

    public final void b() {
        if (this.f264854l == true) goto L5;
        return;
    L5:
        if (this.f264844b != null) goto L7;
        return;
    L7:
        if (this.f264846d == false) goto L22;
        Surface r100 = this.f264843a;
        if (r100 != null) goto L11;
        return;
    L11:
        if (r100.isValid() == true) goto L13;
        return;
    L13:
        if (this.f264844b == getSurfaceTexture()) goto L25;
        boolean r101 = a(this.f264844b);
        LLog.e("TextureVideoView", "isSurfaceTextureReleased:" + r101);
        if (r101 == true) goto L26;
        setSurfaceTexture(this.f264844b);
        TextureView.SurfaceTextureListener r102 = this.f264845c;
        if (r102 == null) goto L27;
        r102.onSurfaceTextureAvailable(this.f264844b, 0, 0);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    }

    public Surface getSurface() {
        return this.f264843a;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public TextureVideoView(Context r100) {
        this(r100, null);
    }

    public static boolean a(SurfaceTexture r100) {
        if (r100 != null) goto L7;
        return true;
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        Method r101 = null;
        if (TextUtils.isEmpty("isReleased") == true) goto L21;
        LLog.d("TextureVideoView", "thread id : " + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L15
        r101 = SurfaceTexture.class.getMethod("isReleased", null);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        LLog.e("TextureVideoView", "exception in getMethod, pkg : " + SurfaceTexture.class.getName() + ", function : isReleased, " + th.toString());
        r101 = SurfaceTexture.class.getDeclaredMethod("isReleased", null);     // Catch: Throwable -> L19
    L19:
        LLog.e("TextureVideoView", "exception in getMethod fallback " + th.getMessage());
    L21:
        if (r101 == null) goto L37;
        Object r102 = r101.invoke(r100, new Object[0]);     // Catch: InvocationTargetException -> L26 IllegalAccessException -> L28
        if ((r102 instanceof Boolean) == false) goto L38;
    L40:
        return ((Boolean) r102).booleanValue();
    L38:
        return false;
    L28:
        e = move-exception;
        LLog.e("TextureVideoView", "isSurfaceTextureReleased encounter exception " + e.getMessage());
        return false;
    L26:
        e = move-exception;
        LLog.e("TextureVideoView", "isSurfaceTextureReleased encounter exception " + e.getMessage());
        return false;
    L37:
        return false;
    L9:
        return r100.isReleased();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (getVisibility() != 0) goto L7;
        if (r100 != 0) goto L8;
        b();
        return;
    L8:
        return;
    }

    public void setReuseSurfaceTexture(boolean r100) {
        this.f264854l = r100;
        this.f264854l = true;
    }

    @Override // android.view.TextureView
    public void setSurfaceTextureListener(TextureView.SurfaceTextureListener r100) {
        this.f264845c = r100;
    }

    public void setVideoViewLayout(int r100) {
        if (this.f264851i == r100) goto L6;
        this.f264851i = r100;
        requestLayout();
        return;
    }

    public TextureVideoView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = (getSuggestedMinimumWidth() + getPaddingLeft()) + getPaddingRight();
        int r103 = (getSuggestedMinimumHeight() + getPaddingTop()) + getPaddingBottom();
        int r104 = View.MeasureSpec.getMode(r100);
        int r105 = View.MeasureSpec.getSize(r100);
        int r106 = View.MeasureSpec.getMode(r101);
        int r107 = View.MeasureSpec.getSize(r101);
        if (r104 != 1073741824) goto L5;
        r102 = r105;
    L7:
        if (r106 != 1073741824) goto L9;
        r103 = r107;
    L11:
        int r108 = this.f264851i;
        if (r108 == 1) goto L41;
        int r109 = this.f264847e;
        if (r109 <= 0) goto L41;
        int r110 = this.f264848f;
        if (r110 <= 0) goto L41;
        if (r108 != 2) goto L30;
        float r111 = r103;
        float r112 = r102;
        float r113 = r110;
        float r114 = r109;
        if ((r113 / r114) <= (r111 / r112)) goto L23;
        r103 = (int) (r113 * ((r112 * 1.0f) / r114));
    L25:
        if (this.f264852j == r102) goto L27;
    L28:
        this.f264852j = r102;
        this.f264853k = r103;
    L29:
        setMeasuredDimension(r102, r103);
        return;
    L27:
        if (this.f264853k == r103) goto L29;
    L23:
        r102 = (int) (r114 * ((r111 * 1.0f) / r113));
        goto L25
    L30:
        float r115 = r109;
        float r116 = r110;
        int r117 = (int) (((r102 * 1.0f) / r115) * r116);
        if (r117 <= r103) goto L33;
        r102 = (int) (r115 * ((r103 * 1.0f) / r116));
    L35:
        if (this.f264852j == r102) goto L37;
    L38:
        this.f264852j = r102;
        this.f264853k = r103;
    L39:
        setMeasuredDimension(r102, r103);
        return;
    L37:
        if (this.f264853k == r103) goto L39;
    L33:
        r103 = r117;
    L41:
        if (this.f264852j == r102) goto L43;
    L44:
        this.f264852j = r102;
        this.f264853k = r103;
    L45:
        setMeasuredDimension(r102, r103);
        return;
    L43:
        if (this.f264853k == r103) goto L45;
    L9:
        if (r106 != Integer.MIN_VALUE) goto L11;
        r103 = Math.min(r103, r107);
        goto L11
    L5:
        if (r104 != Integer.MIN_VALUE) goto L7;
        r102 = Math.min(r102, r105);
        goto L7
    }

    @Override // android.view.TextureView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);     // Catch: Exception -> L4
    L6:
        if (r100 != this) goto L12;
        if (r101 != 0) goto L13;
        b();
        return;
    L13:
        return;
    L12:
        return;
    L4:
        e = move-exception;
        LLog.e("TextureVideoView", "onVisibilityChanged encounter exception " + e.getMessage());
        goto L6
    }

    public TextureVideoView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f264851i = 2;
        this.f264854l = false;
        setReuseSurfaceTexture(true);
        super.setSurfaceTextureListener(new b(this));
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        int r105 = getWidth();
        int r106 = getHeight();
        if (this.f264849g == r105) goto L5;
    L6:
        this.f264849g = r105;
        this.f264850h = r106;
        return;
    L5:
        if (this.f264850h != r106) goto L6;
    }
}
