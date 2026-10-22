package com.ss.texturerender;

import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import com.ss.texturerender.effect.EffectConfig;
import com.ss.texturerender.overlay.OverlayVideoTextureRenderer;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: classes40.dex */
class RenderFactory {
    public static final String PICO_VIDEO_VR = "com.ss.texturerenderpicovr.PicoVRVideoTextureRender";

    public RenderFactory() {
    }

    public static TextureRenderer createRender(EffectConfig r100, int r101, EGLContext r102, EGLConfig r110, boolean r111) {
        if ((r101 & 4) <= 0) goto L7;
        return new OverlayVideoTextureRenderer(r100, r101, r102, r110);
    L7:
        if ((r101 & 8) <= 0) goto L21;
        TextureRenderer r103 = null;
        Class<?> r112 = TextureRenderHelper.getClzUsingPluginLoader(0, PICO_VIDEO_VR);     // Catch: Exception -> L17
        if (r112 == null) goto L15;
        Constructor<?> r113 = r112.getConstructor(new Class[]{EffectConfig.class, Integer.TYPE});     // Catch: Exception -> L17
        if (r113 == null) goto L14;
        r103 = (TextureRenderer) r113.newInstance(new Object[]{r100, Integer.valueOf(r101)});     // Catch: Exception -> L17
    L22:
    L19:
        return r103;
    L14:
        TextureRenderLog.e(r101, "PicoTextureRender", "PicoTextureCreate fail constructor is null");     // Catch: Exception -> L17
        goto L22
    L15:
        TextureRenderLog.e(r101, "PicoTextureRender", "PicoTextureCreate fail srClz is null");     // Catch: Exception -> L17
    L17:
        e = move-exception;
        TextureRenderLog.e(r101, "PicoTextureRender", "PicoTextureCreate fail:" + e.toString());
        goto L19
    L21:
        return new VideoTextureRenderer(r100, r101, r102, r110, r111);
    }
}
