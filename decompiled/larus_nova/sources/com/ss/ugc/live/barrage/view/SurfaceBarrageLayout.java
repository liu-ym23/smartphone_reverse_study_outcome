package com.ss.ugc.live.barrage.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ugc.live.barrage.controller.AbsBarrageController;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import plc.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"Lcom/ss/ugc/live/barrage/view/SurfaceBarrageLayout;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Lplc/a;", "", "enable", "", "setEnableTouch", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "barrage_release"}, k = 1, mv = {1, 4, 0})
public final class SurfaceBarrageLayout extends SurfaceView implements SurfaceHolder.Callback, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<AbsBarrageController> f458173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AbsBarrageController f458174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f458175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SurfaceHolder f458176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f458177e;

    public SurfaceBarrageLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SurfaceBarrageLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder r100, int r101, int r102, int r103) {
    }

    public final void c() {
        if (this.f458177e == true) goto L5;
        return;
    L5:
        SurfaceHolder r100 = this.f458176d;
        if (r100 == null) goto L8;
        Canvas r101 = r100.lockCanvas();
    L9:
        if (r101 == null) goto L18;
        int r102 = 0;
        r101.drawColor(0, PorterDuff.Mode.CLEAR);
        int r103 = this.f458173a.size();
    L11:
        if (r102 >= r103) goto L13;
        AbsBarrageController r104 = (AbsBarrageController) ListProtector.get(this.f458173a, r102);
        r104.d(r101);
        r104.c(r101);
        r102 = r102 + 1;
        goto L11
    L13:
        SurfaceHolder r105 = this.f458176d;
        if (r105 == null) goto L19;
        r105.unlockCanvasAndPost(r101);
        return;
    L19:
        return;
    L18:
        return;
    L8:
        r101 = null;
        goto L9
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator<AbsBarrageController> r100 = this.f458173a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().m();
        goto L4
    }

    @Override // plc.a
    public final void a(AbsBarrageController r100) {
        int r101 = this.f458173a.size();
        if (r100 == null) goto L6;
        ListProtector.add(this.f458173a, r101, r100);
        return;
    }

    @Override // plc.a
    public final void b(AbsBarrageController r100) {
        if (r100 == null) goto L5;
        this.f458173a.remove(r100);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f458175c == false) goto L35;
        int r101 = r100.getAction();
        if (r101 == 0) goto L25;
        if (r101 != 1) goto L8;
        AbsBarrageController r102 = this.f458174b;
        if (r102 != null) goto L36;
    L33:
        return super.onTouchEvent(r100);
    L36:
        boolean r103 = r102.k(r100);     // Catch: Throwable -> L22
        this.f458174b = null;
        return r103;
    L22:
        th = move-exception;
        this.f458174b = null;
        throw th;
    L8:
        if (r101 != 2) goto L10;
    L12:
        AbsBarrageController r104 = this.f458174b;
        if (r104 == null) goto L33;
        return r104.k(r100);
    L10:
        if (r101 == 3) goto L12;
    L25:
        Iterator<AbsBarrageController> r105 = this.f458173a.iterator();
    L27:
        if (r105.hasNext() == false) goto L33;
        AbsBarrageController r106 = r105.next();
        if (r106.k(r100) == false) goto L27;
        this.f458174b = r106;
        return true;
    L35:
        return super.onTouchEvent(r100);
    }

    @Override // plc.a
    public void setEnableTouch(boolean r100) {
        this.f458175c = r100;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder r100) {
        this.f458177e = true;
        SurfaceHolder r101 = this.f458176d;
        if (r101 == null) goto L5;
        Canvas r102 = r101.lockCanvas();
    L6:
        if (r102 == null) goto L11;
        r102.drawColor(0, PorterDuff.Mode.CLEAR);
        SurfaceHolder r103 = this.f458176d;
        if (r103 == null) goto L12;
        r103.unlockCanvasAndPost(r102);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder r100) {
        this.f458177e = false;
    }

    public SurfaceBarrageLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f458173a = new ArrayList();
        this.f458175c = true;
        setZOrderMediaOverlay(true);
        setWillNotCacheDrawing(true);
        setDrawingCacheEnabled(false);
        setWillNotDraw(true);
        SurfaceHolder r103 = getHolder();
        this.f458176d = r103;
        if (r103 == null) goto L5;
        r103.addCallback(this);
    L5:
        if (r103 == null) goto L8;
        r103.setFormat(-2);
        return;
    }

    public /* synthetic */ SurfaceBarrageLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
