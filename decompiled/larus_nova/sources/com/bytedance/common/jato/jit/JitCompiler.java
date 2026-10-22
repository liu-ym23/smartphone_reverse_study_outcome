package com.bytedance.common.jato.jit;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.common.jato.util.ArtVersion;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes15.dex */
public class JitCompiler {
    private static final String TAG = "JitCompiler";
    private static int artVersion = -1;
    private static volatile boolean canForceSaveProfile;
    private static Handler handler;
    private static Field sArtMethodField;
    private static HandlerThread thread;

    public JitCompiler() {
    }

    private static native boolean checkCanJit(long r100, String r101);

    private static native boolean nativeCompile(long r100, String r101);

    private static native boolean nativeCompile14(long r100, String r101);

    private static native void nativeForceSaveProfile();

    private static native boolean nativeHookProfileSaverBug();

    private static native boolean nativeInit();

    public static void forceSaveProfile() {
        if (canForceSaveProfile == true) goto L5;
        return;
    L5:
        nativeForceSaveProfile();
    }

    public static void hookProfileSaverBug() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 29) goto L5;
        return;
    L5:
        if (r100 >= 29) goto L7;
    L9:
        canForceSaveProfile = true;
        return;
    L7:
        if (r100 >= 31) goto L9;
        canForceSaveProfile = nativeHookProfileSaverBug();
    }

    static {
        if (JatoNativeLoader.loadLibrary() == false) goto L14;
    L9:
        sArtMethodField = null;
        return;
    L6:
        if (nativeInit() == false) goto L13;
        artVersion = ArtVersion.getVersion();     // Catch: Throwable -> L9
        Field r100 = Method.class.getSuperclass().getDeclaredField("artMethod");     // Catch: Throwable -> L9
        sArtMethodField = r100;     // Catch: Throwable -> L9
        r100.setAccessible(true);     // Catch: Throwable -> L9
        PthreadHandlerThreadV2 r101 = new PthreadHandlerThreadV2("JatoJitCompiler");     // Catch: Throwable -> L9
        thread = r101;     // Catch: Throwable -> L9
        ThreadMethodProxy.start(r101);     // Catch: Throwable -> L9
        handler = new Handler(thread.getLooper());     // Catch: Throwable -> L9
        return;
    L13:
        return;
    }

    public static /* synthetic */ boolean access$000(Method r100) {
        return compileMethod(r100);
    }

    public static /* synthetic */ boolean access$100(Constructor r100) {
        return compileConstructor(r100);
    }

    public static void compile(final Object r100) {
        if (sArtMethodField != null) goto L5;
        return;
    L5:
        handler.post(new AnonymousClass1(r100));
    }

    private static boolean compileConstructor(Constructor r100) {
        return compileInner(r100);
    }

    private static boolean compileInner(Object r100) {
        int r101 = artVersion;
        if (r101 > 35) goto L5;
    L18:
        long r102 = ((Long) sArtMethodField.get(r100)).longValue();     // Catch: Throwable -> L17
        String r103 = r100.toString();
        if (checkCanJit(r102, r103) == true) goto L12;
        return false;
    L12:
        if (artVersion < 34) goto L16;
        return nativeCompile14(r102, r103);
    L16:
        return nativeCompile(r102, r103);
    L17:
        return false;
    L5:
        if (r101 >= 29) goto L18;
        return false;
    }

    private static boolean compileMethod(Method r100) {
        if (Modifier.isAbstract(r100.getModifiers()) == false) goto L5;
        return false;
    L5:
        if (Modifier.isNative(r100.getModifiers()) == false) goto L7;
        return false;
    L7:
        if (Modifier.isStatic(r100.getModifiers()) == false) goto L10;
        return false;
    L10:
        return compileInner(r100);
    }
}
