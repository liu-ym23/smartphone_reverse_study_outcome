package com.ss.android.lark.officesdk.demo.dependency;

import androidx.camera.video.AudioStats;
import dagger.Module;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Module
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f433161a = 0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.demo.dependency.a$a, reason: collision with other inner class name */
    public static final class C5150a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5150a f433162a = null;

        static {
            f433162a = new C5150a();
        }

        public C5150a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) {
            Class<?> r103 = r101.getReturnType();
            if (Intrinsics.areEqual(r103, Boolean.TYPE) == false) goto L6;
            return Boolean.FALSE;
        L6:
            if (Intrinsics.areEqual(r103, Byte.TYPE) == false) goto L9;
            return (byte) 0;
        L9:
            if (Intrinsics.areEqual(r103, Short.TYPE) == false) goto L12;
            return (short) 0;
        L12:
            if (Intrinsics.areEqual(r103, Integer.TYPE) == false) goto L15;
            return 0;
        L15:
            if (Intrinsics.areEqual(r103, Long.TYPE) == false) goto L18;
            return 0L;
        L18:
            if (Intrinsics.areEqual(r103, Float.TYPE) == false) goto L21;
            return Float.valueOf(0.0f);
        L21:
            if (Intrinsics.areEqual(r103, Double.TYPE) == false) goto L24;
            return Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        L24:
            if (Intrinsics.areEqual(r103, Character.TYPE) == true) goto L35;
            return null;
        L35:
            return (char) 0;
        }
    }

    static {
    }

    public static Object a(Class r100) {
        C5150a r101 = C5150a.f433162a;
        return Proxy.newProxyInstance(r100.getClassLoader(), new Class[]{r100}, r101);
    }
}
