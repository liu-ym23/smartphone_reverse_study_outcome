package com.lynx.animax.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.lynx.animax.AnimaXPlayer;
import com.lynx.animax.ability.BaseAbility;
import com.lynx.animax.base.VisibilityState;
import com.lynx.animax.composition.AnimaXComposition;
import com.lynx.animax.drawable.AnimaXSurfaceDrawable;
import com.lynx.animax.drawable.FirstFrameAwareSurfaceTexture;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.lottieadapter.LottieAdapterAnimaX;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;
import x4a.c;
import x4a.d;
import x4a.e;
import x4a.f;
import x4a.g;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXView extends TextureView implements TextureView.SurfaceTextureListener, FirstFrameAwareSurfaceTexture.a, g, e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FirstFrameAwareSurfaceTexture f380446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Surface f380447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f380448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AnimaXSurfaceDrawable f380449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f380450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f380451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f380452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f380453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f380454i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f380455j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f380456k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AnimaXPlayer f380457l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f380458m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f380459n;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnimaXView f380460a;

        public final void a() {
            AnimaXLog.b("AnimaXView", "Try to updateSurfaceTexture, mHasDestroyed: " + this.f380460a.f380448c);
            AnimaXView r100 = this.f380460a;
            if (r100.f380448c == true) goto L6;
            r100.f380455j = false;
            r100.setVisibility(r100.f380456k);
            this.f380460a.j();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AnimaXView r100) {
            this.f380460a = r100;
        }
    }

    @Override // x4a.g
    public final /* synthetic */ void d(MotionEvent r100) {
        f.a(this, r100);
    }

    @Override // com.lynx.animax.drawable.FirstFrameAwareSurfaceTexture.a
    public final void onFirstFrameAvailable() {
        setNeedAlphaWorkaround(false);
    }

    @Override // q4a.b
    public final void e() {
        if (this.f380449d == null) goto L5;
        return;
    L5:
        if (this.f380450e == false) goto L10;
        this.f380457l.f380211i = true;
        AnimaXLog.b("AnimaXView", "The Surface has not been created yet; Creating a temporary one.");
        onSurfaceTextureAvailable(null, 1, 1);
        return;
    }

    @Override // android.view.TextureView, android.view.View
    public final void onAttachedToWindow() {
        String r100 = y4a.a.f566160a;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 24) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L23;
        if (this.f380452g == true) goto L23;
        if (this.f380451f != null) goto L16;
        this.f380451f = new c(this);
    L16:
        IntentFilter r103 = new IntentFilter();
        r103.addAction("android.intent.action.SCREEN_OFF");
        f(getContext(), this.f380451f, r103);     // Catch: Exception -> L19
    L21:
        this.f380452g = true;
    L19:
        e = move-exception;
        AnimaXLog.a("AnimaXView", e.getMessage());
        AnimaXLog.a("AnimaXView", "register BoardCastReceiver: " + this.f380451f);
    L23:
        if (this.f380450e == false) goto L25;
        return;
    L25:
        super.onAttachedToWindow();
        this.f380457l.z(true, VisibilityState.ATTACH);
        return;
    L5:
        if (r101 > 29) goto L7;
        r102 = true;
        goto L8
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        String r100 = y4a.a.f566160a;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 24) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L29;
        if (this.f380452g == false) goto L29;
        this.f380452g = false;
        Context r103 = getContext();     // Catch: Exception -> L26
        c r104 = this.f380451f;     // Catch: Exception -> L26
        ReceiverRegisterLancet.loge(r104, false);     // Catch: Exception -> L26
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L34;
        r103.unregisterReceiver(r104);     // Catch: Exception -> L26
        goto L29
    L34:
    L20:
        e = move-exception;
        if (r104 == null) goto L23;
        Npth.addTag("unregisterReceiver", r104.toString());     // Catch: Exception -> L26
    L23:
        e.printStackTrace();     // Catch: Exception -> L26
        goto L29
    L17:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r104, r103) == false) goto L29;
        r103.unregisterReceiver(r104);     // Catch: Exception -> L20
    L26:
        e = move-exception;
        AnimaXLog.a("AnimaXView", e.getMessage());
        AnimaXLog.a("AnimaXView", "unregister BoardCastReceiver: " + this.f380451f);
    L29:
        if (this.f380450e == false) goto L31;
        return;
    L31:
        super.onDetachedFromWindow();
        this.f380457l.z(false, VisibilityState.ATTACH);
        return;
    L5:
        if (r101 > 29) goto L7;
        r102 = true;
        goto L8
    }

    @Override // x4a.g
    public final void release() {
        if (this.f380448c == false) goto L5;
        return;
    L5:
        AnimaXLog.b("AnimaXView", "release: " + this);
        this.f380448c = true;
        this.f380457l.s();
    }

    @Override // x4a.e
    public final void cancel() {
        getPlayer().cancel();
    }

    public AnimaXComposition getComposition() {
        return getPlayer().getComposition();
    }

    @Override // x4a.e
    public double getCurrentFrame() {
        return getPlayer().getCurrentFrame();
    }

    @Override // x4a.e
    public double getDurationMs() {
        return getPlayer().getDurationMs();
    }

    @Override // x4a.e
    public final boolean isAnimating() {
        return getPlayer().isAnimating();
    }

    public final void j() {
        SurfaceTexture r100 = getSurfaceTexture();
        FirstFrameAwareSurfaceTexture r101 = this.f380446a;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.equals(r100) == true) goto L45;
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 26) goto L10;
    L13:
        if (r100 == null) goto L15;
        AnimaXLog.b("AnimaXView", "Init TextureView but it has already another st.");
    L15:
        setSurfaceTexture(this.f380446a);
        FirstFrameAwareSurfaceTexture r103 = this.f380446a;
        r103.getClass();
        if (r102 < 36) goto L43;
        String r104 = y4a.a.f566160a;
        monitor-enter(y4a.a.class);
    L32:
        th = move-exception;
        throw th;
    L21:
        if (y4a.a.f566167h == false) goto L41;
    L24:
        boolean r105 = y4a.a.f566168i;     // Catch: Throwable -> L32
        monitor-exit(y4a.a.class);
        if (r105 == false) goto L46;
        Field r106 = SurfaceTexture.class.getDeclaredField("mTextureViewStub");     // Catch: Throwable -> L30
        r106.setAccessible(true);     // Catch: Throwable -> L30
        FirstFrameAwareSurfaceTexture.b(r106.get(r103));     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        AnimaXLog.a("AnimaXFirstFrameAwareSurfaceTexture", "clearMiuiStubCallbackIfNeeded fail: " + th.getMessage());
        return;
    L46:
        return;
    L41:
        y4a.a.a("miui.os.Build");     // Catch: Throwable -> L36
        y4a.a.f566168i = true;     // Catch: Throwable -> L36
    L23:
        y4a.a.f566167h = true;     // Catch: Throwable -> L32
        goto L24
    L43:
        return;
    L10:
        if (this.f380446a.isReleased() == false) goto L13;
        AnimaXLog.a("AnimaXView", "Failed to updateSurfaceTexture, texture is released.");
        return;
    }

    @Override // x4a.e
    public final void pause() {
        getPlayer().pause();
    }

    @Override // x4a.e
    public final void play() {
        getPlayer().play();
    }

    @Override // x4a.e
    public final void resume() {
        getPlayer().resume();
    }

    @Override // x4a.g, x4a.e
    public d getPlayer() {
        return this.f380457l;
    }

    public AnimaXView(Context r100) {
        super(r100);
        this.f380448c = false;
        this.f380450e = false;
        this.f380453h = 1.0f;
        this.f380455j = false;
        this.f380456k = 0;
        this.f380458m = false;
        this.f380459n = false;
        this.f380457l = new AnimaXPlayer(new AnimaXContext(new AnimaXContext.a(new o4a.c(), r100)));
        h(null);
    }

    private void setNeedAlphaWorkaround(boolean r100) {
        String r101 = y4a.a.f566160a;
        if (Build.VERSION.SDK_INT > 28) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return;
    L8:
        this.f380454i = r100;
        if (r100 == false) goto L11;
        super.setAlpha(0.0f);
        return;
    L11:
        super.setAlpha(this.f380453h);
        return;
    L5:
        r102 = false;
        goto L6
    }

    @Override // x4a.e
    public final void a(int r100) {
        getPlayer().a(r100);
    }

    @Override // x4a.e
    public final void c(LottieAdapterAnimaX.w r100) {
        getPlayer().c(r100);
    }

    public final void h(AttributeSet r100) {
        AnimaXContext r101 = this.f380457l.f380205c;
        if (r101 != null) goto L5;
    L16:
        AnimaXLog.a("AnimaXView", "initView fail, missing AnimaXContext or Ability.");
        return;
    L5:
        if (r101.getAbility() == null) goto L16;
        BaseAbility r102 = r101.getAbility();
        r102.getClass();
        r102.f380238b = new WeakReference(this);
        this.f380459n = y4a.a.e(y4a.a.b("ANIMAX_UPDATE_TEXTURE_WHEN_VISIBLE", r102));
        g(r101.getContext(), r100);     // Catch: NullPointerException -> L10
    L11:
        setOpaque(false);
        setNeedAlphaWorkaround(true);
        setSurfaceTextureListener(this);
        this.f380446a = new FirstFrameAwareSurfaceTexture();
        this.f380447b = new Surface(this.f380446a);
        AnimaXLog.b("AnimaXView", "create Surface: " + this.f380447b);
        this.f380446a.g(this.f380447b);
        this.f380446a.detachFromGLContext();
        FirstFrameAwareSurfaceTexture r103 = this.f380446a;
        r103.getClass();
        r103.f380282a = new WeakReference(this);
        if (r103.f380284c == false) goto L14;
        setNeedAlphaWorkaround(false);
    L14:
        FirstFrameAwareSurfaceTexture r104 = this.f380446a;
        r104.getClass();
        r104.f380285d = new WeakReference(this);
        j();
        return;
    L10:
        AnimaXLog.a("AnimaXView", "initAttributes fail, context's theme is null.");
        goto L11
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture r100) {
        AnimaXLog.b("AnimaXView", "onSurfaceTextureDestroyed: " + r100 + ", mHasDestroyed: " + this.f380448c + ", this: " + this);
        if (y4a.a.f566162c == true) goto L5;
        return false;
    L5:
        if (this.f380448c == true) goto L13;
        AnimaXLog.b("AnimaXView", "needTextureDestroyWorkaround, try to postAtFrontOnUI.");
        this.f380456k = getVisibility();
        this.f380455j = true;
        setVisibility(4);
        a r101 = new a(this);
        Handler r102 = y4a.d.a();
        Message r103 = Message.obtain(r102, r101);
        if (Build.VERSION.SDK_INT < 22) goto L9;
        r103.setAsynchronous(true);
    L9:
        r102.sendMessageAtFrontOfQueue(r103);
        return false;
    L13:
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture r100) {
        BaseAbility r101 = this.f380457l.f380205c.getAbility();
        if (r101.f380243g == null) goto L11;
        Iterator r102 = ((CopyOnWriteArrayList) r101.f380237a).iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        ((t4a.f) r102.next()).o(r101.f380243g);
        goto L6
    L8:
        r101.f380243g = null;
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f380458m == false) goto L6;
        f.a(this, r100);
    L6:
        return super.onTouchEvent(r100);
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean r100) {
        super.onVisibilityAggregated(r100);
        if (this.f380450e == false) goto L5;
        return;
    L5:
        this.f380457l.z(r100, VisibilityState.AGGREGATED);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (this.f380459n == true) goto L5;
        return;
    L5:
        if (getVisibility() != 0) goto L10;
        if (r100 != 0) goto L11;
        j();
        return;
    L11:
        return;
    }

    @Override // android.view.View
    public void setAlpha(float r100) {
        float r101 = getAlpha();
        this.f380453h = r100;
        if (this.f380454i == true) goto L5;
        super.setAlpha(r100);
    L5:
        boolean r102 = false;
        if (r101 <= 0.0f) goto L8;
        boolean r103 = true;
    L10:
        if (r100 <= 0.0f) goto L12;
        r102 = true;
    L12:
        if (r103 == r102) goto L15;
        this.f380457l.z(r102, VisibilityState.OPACITY);
        return;
    L15:
        return;
    L8:
        r103 = false;
        goto L10
    }

    public void setAntiAliasing(boolean r100) {
        getPlayer().l(r100);
    }

    @Override // x4a.e
    public void setAutoPlay(boolean r100) {
        getPlayer().setAutoPlay(r100);
    }

    @Override // x4a.e
    public void setAutoReverse(boolean r100) {
        getPlayer().setAutoReverse(r100);
    }

    @Override // android.view.View
    public void setBackground(Drawable r100) {
        super.setBackground(r100);     // Catch: UnsupportedOperationException -> L4
        return;
    L4:
        e = move-exception;
        AnimaXLog.a("AnimaXView", "setBackground fail, message: " + e.getMessage());
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable r100) {
        super.setBackgroundDrawable(r100);     // Catch: UnsupportedOperationException -> L4
        return;
    L4:
        e = move-exception;
        AnimaXLog.a("AnimaXView", "setBackgroundDrawable fail, message: " + e.getMessage());
    }

    @Override // x4a.e
    public void setComposition(AnimaXComposition r100) {
        getPlayer().setComposition(r100);
    }

    public void setDynamicResource(boolean r100) {
        getPlayer().k(r100);
    }

    public void setEnableAudio(boolean r100) {
        getPlayer().setEnableAudio(r100);
    }

    @Override // x4a.g
    public void setEnableTapLayerEvent(boolean r100) {
        this.f380458m = r100;
    }

    @Override // x4a.e
    public void setEndFrame(int r100) {
        getPlayer().setEndFrame(r100);
    }

    @Override // android.view.TextureView, android.view.View
    public void setForeground(Drawable r100) {
        super.setForeground(r100);     // Catch: UnsupportedOperationException -> L4
        return;
    L4:
        e = move-exception;
        AnimaXLog.a("AnimaXView", "setForeground fail, message: " + e.getMessage());
    }

    public void setFpsEventInterval(long r100) {
        getPlayer().j(r100);
    }

    @Override // x4a.g
    public void setIgnoreAttachStatus(boolean r100) {
        this.f380450e = r100;
    }

    @Override // x4a.e
    public void setImageFolder(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        getPlayer().setImageFolder(r100);
        return;
    }

    @Override // x4a.e
    public void setJson(String r100) {
        getPlayer().setJson(r100);
    }

    public void setKeepLastFrame(boolean r100) {
        getPlayer().e(r100);
    }

    @Override // x4a.e
    public void setLoop(boolean r100) {
        getPlayer().setLoop(r100);
    }

    @Override // x4a.e
    public void setLoopCount(int r100) {
        getPlayer().setLoopCount(r100);
    }

    @Override // x4a.e
    public void setMaxFrameRate(double r100) {
        getPlayer().setMaxFrameRate(r100);
    }

    public void setMuted(boolean r100) {
        getPlayer().setMuted(r100);
    }

    @Override // x4a.e
    public void setObjectFit(ObjectFit r100) {
        getPlayer().setObjectFit(r100);
    }

    public void setObjectPosition(ObjectPosition r100) {
        getPlayer().d(r100);
    }

    @Override // x4a.e
    public void setProgress(float r100) {
        getPlayer().setProgress(r100);
    }

    @Override // x4a.e
    public void setSpeed(float r100) {
        getPlayer().setSpeed(r100);
    }

    @Override // x4a.e
    public void setSrc(String r100) {
        getPlayer().setSrc(r100);
    }

    @Override // x4a.e
    public void setStartFrame(int r100) {
        getPlayer().setStartFrame(r100);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        if (this.f380455j == false) goto L7;
        this.f380456k = r100;
        if (r100 != 0) goto L7;
        AnimaXLog.b("AnimaXView", "Force visiblity to INVISIBLE due to workaround.");
        r100 = 4;
    L7:
        super.setVisibility(r100);
        AnimaXPlayer r101 = this.f380457l;
        if (r100 != 0) goto L10;
        boolean r102 = true;
    L11:
        r101.z(r102, VisibilityState.VISIBLE);
        return;
    L10:
        r102 = false;
        goto L11
    }

    public AnimaXView(AnimaXContext r100) {
        super(r100.getContext());
        this.f380448c = false;
        this.f380450e = false;
        this.f380453h = 1.0f;
        this.f380455j = false;
        this.f380456k = 0;
        this.f380458m = false;
        this.f380459n = false;
        this.f380457l = new AnimaXPlayer(r100);
        h(null);
    }

    public AnimaXView(AnimaXPlayer r100) {
        super(r100.f380205c.getContext());
        this.f380448c = false;
        this.f380450e = false;
        this.f380453h = 1.0f;
        this.f380455j = false;
        this.f380456k = 0;
        this.f380458m = false;
        this.f380459n = false;
        this.f380457l = r100;
        h(null);
    }

    public AnimaXView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f380448c = false;
        this.f380450e = false;
        this.f380453h = 1.0f;
        this.f380455j = false;
        this.f380456k = 0;
        this.f380458m = false;
        this.f380459n = false;
        this.f380457l = new AnimaXPlayer(new AnimaXContext(new AnimaXContext.a(new o4a.c(), r100)));
        h(r101);
    }

    @Override // x4a.e
    public final void b(int[] r100, boolean r101) {
        getPlayer().b(r100, r101);
    }

    public final void g(Context r100, AttributeSet r101) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.getTheme() != null) goto L8;
        AnimaXLog.a("AnimaXView", "initAttributes fail, context's theme is null.");
        return;
    L8:
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.animax_animationUrl, R.attr.animax_autoPlay, R.attr.animax_loop, R.attr.animax_objectFit});
        String r103 = r102.getString(0);
        if (r103 == null) goto L11;
        this.f380457l.setSrc(r103);
    L11:
        this.f380457l.setAutoPlay(r102.getBoolean(1, true));
        this.f380457l.setLoop(r102.getBoolean(2, false));
        String r104 = r102.getString(3);
        if (r104 == null) goto L14;
        this.f380457l.setObjectFit(y4a.c.a(r104));
    L14:
        r102.recycle();
    }

    public final void i(int r100, int r101) {
        AnimaXPlayer r102 = this.f380457l;
        if (r100 <= 0) goto L6;
        if (r101 <= 0) goto L6;
        boolean r103 = true;
    L7:
        r102.z(r103, VisibilityState.SIZE);
        if (r100 <= 0) goto L19;
        if (r101 <= 0) goto L19;
        AnimaXSurfaceDrawable r104 = this.f380449d;
        if (r104 != null) goto L16;
        FirstFrameAwareSurfaceTexture r105 = this.f380446a;
        AnimaXSurfaceDrawable r106 = new AnimaXSurfaceDrawable(r105.c(), r105, null, r100, r101);
        this.f380449d = r106;
        this.f380457l.p(r106);
        return;
    L16:
        if (r104.a(r100, r101) == false) goto L21;
        this.f380457l.y(this.f380449d);
        return;
    L21:
        return;
    L19:
        AnimaXLog.b("AnimaXView", "Skip invalid size: " + r100 + " / " + r101);
        return;
    L6:
        r103 = false;
        goto L7
    }

    @Override // android.view.TextureView, android.view.View
    public final void onVisibilityChanged(View r100, int r101) {
        super.onVisibilityChanged(r100, r101);
        if (this.f380459n == false) goto L8;
        if (r100 != this) goto L9;
        if (r101 != 0) goto L10;
        j();
        return;
    L10:
        return;
    L9:
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void f(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture r100, int r101, int r102) {
        AnimaXLog.b("AnimaXView", "onSurfaceTextureAvailable: " + r100 + ", width: " + r101 + ", height: " + r102 + ", this: " + this);
        if (this.f380448c == false) goto L6;
        AnimaXLog.b("AnimaXView", "onSurfaceTextureAvailable failed as view is destroyed.");
        return;
    L6:
        j();
        i(r101, r102);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture r100, int r101, int r102) {
        AnimaXLog.b("AnimaXView", "onSurfaceTextureSizeChanged: " + r100 + ", width: " + r101 + ", height: " + r102 + ", this: " + this);
        if (this.f380448c == false) goto L6;
        AnimaXLog.b("AnimaXView", "onSurfaceTextureSizeChanged failed as view is destroyed.");
        return;
    L6:
        i(r101, r102);
    }

    @Override // android.view.TextureView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);     // Catch: NullPointerException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        AnimaXLog.a("AnimaXView", "onSizeChanged before added to view tree, may produce npe on some devices");
    }
}
