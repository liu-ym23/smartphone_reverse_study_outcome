package com.bytedance.common.jato.gfx;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes15.dex */
public class RenderThreadAsyncOpt {
    private static final DrawOnceStateChangeListener drawOnceStateChangeListener = null;
    private static Method getThreadedRenderer = null;
    private static volatile int inited = -1;
    private static Field mNativeProxy = null;
    private static int pauseDrawInited = -1;
    private static final ResumeStateChangeListener resumeStateChangeListener = null;

    public static class DrawOnceStateChangeListener implements View.OnAttachStateChangeListener {
        private DrawOnceStateChangeListener() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r100) {
        }

        public /* synthetic */ DrawOnceStateChangeListener(AnonymousClass1 r100) {
            this();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r100) {
            RenderThreadAsyncOpt.drawOnceWhenPaused(r100);
            r100.removeOnAttachStateChangeListener(this);
        }
    }

    public static class ResumeStateChangeListener implements View.OnAttachStateChangeListener {
        private ResumeStateChangeListener() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r100) {
        }

        public /* synthetic */ ResumeStateChangeListener(AnonymousClass1 r100) {
            this();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r100) {
            RenderThreadAsyncOpt.pauseDraw(r100, false);
            r100.removeOnAttachStateChangeListener(this);
        }
    }

    public RenderThreadAsyncOpt() {
    }

    private static native boolean nativeAsyncDraw(boolean r100);

    private static native void nativeDrawOnceWhenPaused(long r100);

    private static native boolean nativeInit(int r100);

    private static native boolean nativePauseDraw(long r100, boolean r101);

    private static native boolean nativeSkipDraw(float r100, float r101, float r102);

    private static native boolean nativeSkipDrawInit(int r100);

    private static native boolean nativeSkipDrawWhenBusy(int r100, int r101, int r102);

    static {
        AnonymousClass1 r100 = null;
        resumeStateChangeListener = new ResumeStateChangeListener(r100);
        drawOnceStateChangeListener = new DrawOnceStateChangeListener(r100);
    }

    public static boolean checkPauseDrawInit() {
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return false;
    L6:
        if (pauseDrawInited != (-1)) goto L14;
        initPauseDraw();     // Catch: Throwable -> L12
        if (nativeSkipDrawInit(2) == false) goto L10;
        pauseDrawInited = 1;     // Catch: Throwable -> L12
    L17:
        goto L14
    L10:
        pauseDrawInited = 0;     // Catch: Throwable -> L12
    L12:
        pauseDrawInited = 0;
    L14:
        if (pauseDrawInited != 1) goto L20;
        return true;
    L20:
        return false;
    }

    private static void initPauseDraw() throws NoSuchMethodException, NoSuchFieldException {
        Method r100 = View.class.getDeclaredMethod("getThreadedRenderer", new Class[0]);
        r100.setAccessible(true);
        Class<?> r101 = r100.getReturnType();
        if (Build.VERSION.SDK_INT < 29) goto L5;
        Field r102 = r101.getSuperclass().getDeclaredField("mNativeProxy");
    L6:
        r102.setAccessible(true);
        mNativeProxy = r102;
        getThreadedRenderer = r100;
        return;
    L5:
        r102 = r101.getDeclaredField("mNativeProxy");
        goto L6
    }

    public static boolean asyncDraw(boolean r100) {
        if (Process.is64Bit() == true) goto L6;
        return false;
    L6:
        if (inited == 1) goto L9;
        return false;
    L9:
        return nativeAsyncDraw(r100);
    }

    public static boolean drawOnceWhenPaused(View r100) {
        if (r100 != null) goto L5;
    L21:
        return false;
    L5:
        if (checkPauseDrawInit() == false) goto L21;
        Method r101 = getThreadedRenderer;
        Field r102 = mNativeProxy;
        if (r101 == null) goto L21;
        if (r102 == null) goto L21;
        if (r100.isAttachedToWindow() == true) goto L23;
        r100.addOnAttachStateChangeListener(drawOnceStateChangeListener);
        return false;
    L23:
        Object r103 = r101.invoke(r100, new Object[0]);     // Catch: Throwable -> L22
        if (r103 != null) goto L19;
        return false;
    L19:
        nativeDrawOnceWhenPaused(((Long) r102.get(r103)).longValue());     // Catch: Throwable -> L22
    L20:
        return true;
    }

    private static View getDecorView(Activity r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Window r101 = r100.getWindow();
        if (r101 != null) goto L9;
        return null;
    L9:
        return r101.peekDecorView();
    }

    public static boolean init(int r100) {
        if (Process.is64Bit() == true) goto L6;
        return false;
    L6:
        if (inited != (-1)) goto L12;
        if (nativeInit(r100) == false) goto L10;
        inited = 1;
        goto L12
    L10:
        inited = 0;
    L12:
        if (inited != 1) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean drawOnceWhenPaused(Activity r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        View r101 = getDecorView(r100);
        if (r101 != null) goto L9;
        return false;
    L9:
        return drawOnceWhenPaused(r101);
    }

    public static boolean pauseActivity(Activity r100, boolean r101) {
        return pauseDraw(getDecorView(r100), r101);
    }

    public static boolean pauseAllActivity(Application r100, final boolean r101) {
        if (checkPauseDrawInit() == true) goto L6;
        return false;
    L6:
        r100.registerActivityLifecycleCallbacks(new AnonymousClass1(r101));
        return true;
    }

    public static boolean pauseDraw(View r100, boolean r101) {
        if (r100 != null) goto L5;
    L23:
        return false;
    L5:
        if (checkPauseDrawInit() == false) goto L23;
        Method r102 = getThreadedRenderer;
        Field r103 = mNativeProxy;
        if (r102 == null) goto L23;
        if (r103 == null) goto L23;
        if (r100.isAttachedToWindow() == true) goto L25;
        if (r101 == true) goto L15;
        r100.addOnAttachStateChangeListener(resumeStateChangeListener);
        return true;
    L15:
        r100.removeOnAttachStateChangeListener(resumeStateChangeListener);
        return true;
    L25:
        Object r104 = r102.invoke(r100, new Object[0]);     // Catch: Throwable -> L24
        if (r104 != null) goto L21;
        return false;
    L21:
        return nativePauseDraw(((Long) r103.get(r104)).longValue(), r101);
    }

    public static boolean skipDelayDraw(float r100, float r101, float r102) {
        if (Process.is64Bit() == true) goto L7;
        return false;
    L7:
        return nativeSkipDraw(r100, r101, r102);
    }

    public static boolean skipDrawWhenBusy(int r100, int r101, int r102) {
        if (Process.is64Bit() == true) goto L7;
        return false;
    L7:
        return nativeSkipDrawWhenBusy(r100, r101, r102);
    }
}
