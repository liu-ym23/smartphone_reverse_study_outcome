package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.DisplayList;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
class RenderNodeV14Impl extends RenderNodeCompat {
    private static Method sDrawDisplayListMethod;
    private static Method sEndMethod;
    private static Method sIsValidMethod;
    private static Method sOnPostDrawMethod;
    private static Method sOnPreDrawMethod;
    private static Method sSetViewportMethod;
    private static Method sStartMethod;
    int bottom;
    DisplayList displayList;
    int height;
    int left;
    int right;
    Constructor<?> sGLESConstructor;
    int top;
    int width;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sIsValidMethod != null) goto L5;
        Method r100 = DisplayList.class.getDeclaredMethod("isValid", new Class[0]);     // Catch: Exception -> L7
        sIsValidMethod = r100;     // Catch: Exception -> L7
        r100.setAccessible(true);     // Catch: Exception -> L7
    L5:
        return ((Boolean) sIsValidMethod.invoke(this.displayList, new Object[0])).booleanValue();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (this.sGLESConstructor != null) goto L5;
        Constructor<?> r100 = INVOKESTATIC_com_lynx_tasm_rendernode_compat_RenderNodeV14Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.GLES20DisplayList").getConstructor(new Class[0]);     // Catch: Exception -> L7
        this.sGLESConstructor = r100;     // Catch: Exception -> L7
        r100.setAccessible(true);     // Catch: Exception -> L7
    L5:
        this.displayList = (DisplayList) this.sGLESConstructor.newInstance(new Object[0]);     // Catch: Exception -> L7
    }

    public RenderNodeV14Impl() {
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Object getRenderNode() {
        return this.displayList;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_tasm_rendernode_compat_RenderNodeV14Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r100) {
        drawRenderNode(r100, this.displayList);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r100) {
    L14:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sOnPostDrawMethod != null) goto L5;
        Method r101 = Canvas.class.getDeclaredMethod("onPostDraw", new Class[0]);     // Catch: Exception -> L14
        sOnPostDrawMethod = r101;     // Catch: Exception -> L14
        r101.setAccessible(true);     // Catch: Exception -> L14
    L5:
        sOnPostDrawMethod.invoke(r100, new Object[0]);     // Catch: Exception -> L14
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L7:
        if (sEndMethod != null) goto L9;
        Method r102 = DisplayList.class.getDeclaredMethod("end", new Class[0]);     // Catch: Exception -> L11
        sEndMethod = r102;     // Catch: Exception -> L11
        r102.setAccessible(true);     // Catch: Exception -> L11
    L9:
        sEndMethod.invoke(this.displayList, new Object[0]);     // Catch: Exception -> L11
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Canvas beginRecording(int r100, int r101) {
        this.width = r100;
        this.height = r101;
    L16:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (sStartMethod != null) goto L6;
        Method r102 = DisplayList.class.getDeclaredMethod("start", new Class[0]);     // Catch: Exception -> L16
        sStartMethod = r102;     // Catch: Exception -> L16
        r102.setAccessible(true);     // Catch: Exception -> L16
    L6:
        Canvas r103 = (Canvas) sStartMethod.invoke(this.displayList, new Object[0]);     // Catch: Exception -> L16
        setViewport(r100, r101, r103);
    L13:
        e = move-exception;
        throw new RuntimeException(e);
    L9:
        if (sOnPreDrawMethod != null) goto L11;
        Method r104 = Canvas.class.getDeclaredMethod("onPreDraw", new Class[]{Rect.class});     // Catch: Exception -> L13
        sOnPreDrawMethod = r104;     // Catch: Exception -> L13
        r104.setAccessible(true);     // Catch: Exception -> L13
    L11:
        sOnPreDrawMethod.invoke(r103, new Object[]{null});     // Catch: Exception -> L13
        return r103;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r110, Object r111) {
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sDrawDisplayListMethod != null) goto L5;
        Class r100 = Integer.TYPE;     // Catch: Exception -> L7
        Method r101 = Canvas.class.getDeclaredMethod("drawDisplayList", new Class[]{DisplayList.class, r100, r100, Rect.class});     // Catch: Exception -> L7
        sDrawDisplayListMethod = r101;     // Catch: Exception -> L7
        r101.setAccessible(true);     // Catch: Exception -> L7
    L5:
        sDrawDisplayListMethod.invoke(r110, new Object[]{r111, Integer.valueOf(this.width), Integer.valueOf(this.height), null});     // Catch: Exception -> L7
    }

    public void setViewport(int r100, int r101, Canvas r110) {
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (sSetViewportMethod != null) goto L5;
        Class r102 = Integer.TYPE;     // Catch: Exception -> L7
        Method r103 = Canvas.class.getDeclaredMethod("setViewport", new Class[]{r102, r102});     // Catch: Exception -> L7
        sSetViewportMethod = r103;     // Catch: Exception -> L7
        r103.setAccessible(true);     // Catch: Exception -> L7
    L5:
        sSetViewportMethod.invoke(r110, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)});     // Catch: Exception -> L7
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void setPosition(int r100, int r101, int r102, int r103) {
        this.left = r100;
        this.top = r101;
        this.right = r102;
        this.bottom = r103;
    }
}
