package com.ss.android.ttve.model;

import android.opengl.EGLContext;
import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes38.dex */
public class VERenderContext {
    private static final String TAG = "VERenderContext";
    private EGLContext eglContext;
    private RenderEnvType envType;

    public static final enum RenderEnvType extends Enum<RenderEnvType> {
        public static final RenderEnvType VE_RENDER_ENV_COUNT = null;
        public static final RenderEnvType VE_RENDER_ENV_OPENGL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RenderEnvType[] f449903a = null;

        static {
            RenderEnvType r100 = new RenderEnvType("VE_RENDER_ENV_OPENGL", 0);
            VE_RENDER_ENV_OPENGL = r100;
            RenderEnvType r101 = new RenderEnvType("VE_RENDER_ENV_COUNT", 1);
            VE_RENDER_ENV_COUNT = r101;
            f449903a = new RenderEnvType[]{r100, r101};
        }

        public static RenderEnvType[] values() {
            return (RenderEnvType[]) f449903a.clone();
        }

        public static RenderEnvType valueOf(String r100) {
            return (RenderEnvType) r27.a.a(RenderEnvType.class, r100);
        }

        public RenderEnvType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {
    }

    public EGLContext getEGLContext() {
        if (this.envType != RenderEnvType.VE_RENDER_ENV_OPENGL) goto L6;
        VELogUtil.d(TAG, "getEGLContext " + this.eglContext + ", current env type " + this.envType);
        return this.eglContext;
    L6:
        return null;
    }

    private VERenderContext() {
        this.envType = RenderEnvType.VE_RENDER_ENV_OPENGL;
        this.eglContext = null;
    }

    public RenderEnvType getCurrentEnvType() {
        return this.envType;
    }

    public /* synthetic */ VERenderContext(a r100) {
        this();
    }

    public static /* synthetic */ RenderEnvType access$102(VERenderContext r100, RenderEnvType r101) {
        r100.envType = r101;
        return r101;
    }

    public static /* synthetic */ EGLContext access$202(VERenderContext r100, EGLContext r101) {
        r100.eglContext = r101;
        return r101;
    }
}
