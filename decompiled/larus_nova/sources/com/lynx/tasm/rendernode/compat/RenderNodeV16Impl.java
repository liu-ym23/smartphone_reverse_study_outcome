package com.lynx.tasm.rendernode.compat;

import android.graphics.Canvas;
import android.view.DisplayList;
import android.view.HardwareCanvas;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
class RenderNodeV16Impl extends RenderNodeV14Impl {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public boolean hasDisplayList() {
        return this.displayList.isValid();
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void init() {
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L3:
        if (this.sGLESConstructor != null) goto L5;
        Constructor<?> r100 = INVOKESTATIC_com_lynx_tasm_rendernode_compat_RenderNodeV16Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.view.GLES20DisplayList").getDeclaredConstructor(new Class[]{String.class});     // Catch: Exception -> L7
        this.sGLESConstructor = r100;     // Catch: Exception -> L7
        r100.setAccessible(true);     // Catch: Exception -> L7
    L5:
        this.displayList = (DisplayList) this.sGLESConstructor.newInstance(new Object[]{""});     // Catch: Exception -> L7
    }

    public RenderNodeV16Impl() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_tasm_rendernode_compat_RenderNodeV16Impl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r100) {
        drawRenderNode(r100, this.displayList);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void endRecording(Canvas r100) {
        ((HardwareCanvas) r100).onPostDraw();
        this.displayList.end();
        this.displayList.setCaching(true);
        this.displayList.setLeftTopRightBottom(this.left, this.top, this.right, this.bottom);
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public Canvas beginRecording(int r100, int r101) {
        HardwareCanvas r102 = this.displayList.start();
        setViewport(r100, r101, r102);
        r102.onPreDraw(null);
        return r102;
    }

    @Override // com.lynx.tasm.rendernode.compat.RenderNodeV14Impl, com.lynx.tasm.rendernode.compat.RenderNodeCompat
    public void drawRenderNode(Canvas r100, Object r101) {
        ((HardwareCanvas) r100).drawDisplayList((DisplayList) r101, null, 1);
    }
}
