package d19;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f466442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GLSurfaceView f466443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f466444c;

    public static final class a {
    }

    /* JADX INFO: renamed from: d19.b$b, reason: collision with other inner class name */
    public static final class C5617b implements GLSurfaceView.EGLConfigChooser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f466445a;

        /* JADX INFO: renamed from: d19.b$b$a */
        public static final class a {
        }

        static {
        }

        public C5617b(int r100) {
            this.f466445a = r100;
        }

        public static final List<int[]> a(int r210) {
            return CollectionsKt.listOf(new int[][]{new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 16, 12326, 0, 12352, r210, 12344}, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, r210, 12344}, new int[]{12324, 5, 12323, 6, 12322, 5, 12321, 8, 12325, 0, 12326, 0, 12352, r210, 12344}, new int[]{12321, 8, 12352, r210, 12344}});
        }

        @Override // android.opengl.GLSurfaceView.EGLConfigChooser
        public final EGLConfig chooseConfig(EGL10 r110, EGLDisplay r210) {
            Intrinsics.checkNotNullParameter(r110, "egl");
            Intrinsics.checkNotNullParameter(r210, "display");
            if (this.f466445a < 3) goto L5;
            int r111 = 64;
        L6:
            ArrayList r100 = new ArrayList();
            r100.addAll(a(r111));
            if (this.f466445a < 3) goto L9;
            r100.addAll(a(4));
        L9:
            int[] r112 = new int[1];
            Iterator r113 = r100.iterator();
            int r101 = 0;
        L11:
            if (r113.hasNext() == false) goto L26;
            int r114 = r101 + 1;
            int[] r102 = (int[]) r113.next();
            int r115 = r101;
        L23:
            e = move-exception;
            FLogger.f375446a.e("EdgeEffectEGLManager.SafeEGLConfigChooser", "Exception in eglChooseConfig for fallback level " + r115, e);
        L25:
            r101 = r114;
            goto L11
        L14:
            if (r110.eglChooseConfig(r210, r102, null, 0, r112) == false) goto L21;
            int r103 = r112[0];     // Catch: Exception -> L23
            if (r103 <= 0) goto L21;
            EGLConfig[] r104 = new EGLConfig[r103];     // Catch: Exception -> L23
            if (r110.eglChooseConfig(r210, r102, r104, r103, r112) == false) goto L21;
            FLogger.f375446a.i("EdgeEffectEGLManager.SafeEGLConfigChooser", "eglChooseConfig success with fallback level " + r115);     // Catch: Exception -> L23
            return r104[0];
        L21:
            FLogger.f375446a.w("EdgeEffectEGLManager.SafeEGLConfigChooser", "eglChooseConfig failed for fallback level " + r115);     // Catch: Exception -> L23
            goto L25
        L26:
            FLogger.f375446a.e("EdgeEffectEGLManager.SafeEGLConfigChooser", "All custom fallback specs failed. Using simple default config.");
            ArrayList r105 = new ArrayList();
            r105.add(new int[]{12352, r111, 12344});
            if (this.f466445a < 3) goto L29;
            r105.add(new int[]{12352, 4, 12344});
        L29:
            Iterator r106 = r105.iterator();
        L31:
            if (r106.hasNext() == false) goto L40;
            int[] r116 = (int[]) r106.next();
            if (r110.eglChooseConfig(r210, r116, null, 0, r112) == false) goto L31;
            int r107 = r112[0];
            if (r107 <= 0) goto L31;
            EGLConfig[] r117 = new EGLConfig[r107];
            if (r110.eglChooseConfig(r210, r116, r117, r107, r112) == false) goto L31;
            FLogger.f375446a.i("EdgeEffectEGLManager.SafeEGLConfigChooser", "eglChooseConfig success with default spec");
            return r117[0];
        L40:
            FLogger r108 = FLogger.f375446a;
            r108.w("EdgeEffectEGLManager.SafeEGLConfigChooser", "All specs failed. Trying to get any available EGL configuration.");
            int[] r109 = new int[1];
            if (r110.eglGetConfigs(r210, null, 0, r109) == false) goto L48;
            int r118 = r109[0];
            if (r118 <= 0) goto L48;
            EGLConfig[] r119 = new EGLConfig[r118];
            if (r110.eglGetConfigs(r210, r119, r118, r109) == false) goto L48;
            r108.w("EdgeEffectEGLManager.SafeEGLConfigChooser", "Successfully fallback to the first available EGL configuration");
            return r119[0];
        L48:
            r108.e("EdgeEffectEGLManager.SafeEGLConfigChooser", "Fatal: No EGL configuration available on this device.");
            return null;
        L5:
            r111 = 4;
            goto L6
        }
    }

    public static final class c implements GLSurfaceView.EGLContextFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f466446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function1<Integer, Unit> f466447b;

        public static final class a {
        }

        static {
        }

        public c(int r100, d19.a r101) {
            Intrinsics.checkNotNullParameter(r101, "onVersionResolved");
            this.f466446a = r100;
            this.f466447b = r101;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public final EGLContext createContext(EGL10 r100, EGLDisplay r101, EGLConfig r102) {
            Intrinsics.checkNotNullParameter(r100, "egl");
            Intrinsics.checkNotNullParameter(r101, "display");
            Intrinsics.checkNotNullParameter(r102, "eglConfig");
            if (this.f466446a < 3) goto L13;
            EGLContext r103 = EGL10.EGL_NO_CONTEXT;
            EGLContext r104 = r100.eglCreateContext(r101, r102, r103, new int[]{12440, 3, 12344});
            if (r104 != null) goto L7;
        L12:
            FLogger.f375446a.w("EdgeEffectEGLManager.SafeEGLContextFactory", "Failed to create GLES 3.0 context, falling back to 2.0");
            goto L13
        L7:
            if (r104 == EGL10.EGL_NO_CONTEXT) goto L12;
            if (r100.eglGetError() != 12288) goto L12;
            FLogger.f375446a.i("EdgeEffectEGLManager.SafeEGLContextFactory", "Successfully created GLES 3.0 context");
            this.f466447b.invoke(3);
            return r104;
        L13:
            EGLContext r105 = EGL10.EGL_NO_CONTEXT;
            EGLContext r106 = r100.eglCreateContext(r101, r102, r105, new int[]{12440, 2, 12344});
            if (r106 != null) goto L16;
        L21:
            FLogger.f375446a.e("EdgeEffectEGLManager.SafeEGLContextFactory", "Failed to create any GLES context");
            return null;
        L16:
            if (r106 == EGL10.EGL_NO_CONTEXT) goto L21;
            if (r100.eglGetError() != 12288) goto L21;
            FLogger.f375446a.i("EdgeEffectEGLManager.SafeEGLContextFactory", "Successfully created GLES 2.0 context");
            this.f466447b.invoke(2);
            return r106;
        }

        @Override // android.opengl.GLSurfaceView.EGLContextFactory
        public final void destroyContext(EGL10 r100, EGLDisplay r101, EGLContext r102) {
            Intrinsics.checkNotNullParameter(r100, "egl");
            Intrinsics.checkNotNullParameter(r101, "display");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (r100.eglDestroyContext(r101, r102) == true) goto L6;
            FLogger r103 = FLogger.f375446a;
            r103.e("EdgeEffectEGLManager.SafeEGLContextFactory", "display:" + r101 + " context: " + r102);
            StringBuilder r104 = new StringBuilder("eglDestroyContext failed: ");
            r104.append(r100.eglGetError());
            r103.e("EdgeEffectEGLManager.SafeEGLContextFactory", r104.toString());
            return;
        }
    }

    static {
    }

    public b(Context r100, GLSurfaceView r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "renderer");
        this.f466442a = r100;
        this.f466443b = r101;
        this.f466444c = r102;
    }
}
