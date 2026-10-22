package com.bytedance.common.jato.jit;

import com.bytedance.common.jato.JatoNativeLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class JitCodeCacheExpand {
    private int testField;

    public static native void enableSmallPattern();

    public static native int getCompiledMethodsCount();

    public static native void keepAlive();

    public static native void testSmallPattern();

    public JitCodeCacheExpand testReturnValue() {
        return this;
    }

    public float testReturnValue2() {
        return 0.0f;
    }

    public int testReturnValue3() {
        return 1;
    }

    public boolean testReturnValue4() {
        return false;
    }

    public void print() {
        Objects.toString(testReturnValue());
        testReturnValue2();
        testReturnValue3();
        testReturnValue4();
        testGetter();
    }

    public void stubMethod() {
        System.err.println("stubMethod");
    }

    static {
        JatoNativeLoader.loadLibrary();
    }

    public JitCodeCacheExpand() {
    }

    public int testGetter() {
        return this.testField;
    }

    public JitCodeCacheExpand(int r100) {
        this.testField = r100;
    }

    public static boolean checkClassIsObject(Object r100) {
        if (r100 != null) goto L18;
        return false;
    L18:
        if ((r100 instanceof Method) == false) goto L12;
        if (((Method) r100).getDeclaringClass() != Object.class) goto L19;
        return true;
    L19:
        return false;
    L12:
        if ((r100 instanceof Constructor) == true) goto L14;
        return false;
    L14:
        if (((Constructor) r100).getDeclaringClass() != Object.class) goto L21;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    public static boolean checkReturnTypeIsFloat(Object r100) {
        if (r100 != null) goto L14;
        return false;
    L14:
        if ((r100 instanceof Method) == false) goto L16;
        Class<?> r101 = ((Method) r100).getReturnType();     // Catch: Throwable -> L13
        if (r101 == Float.class) goto L11;
        if (r101 == Float.TYPE) goto L11;
        return false;
    L11:
        return true;
    L16:
        return false;
    L18:
        return false;
    }

    public static boolean checkSuperClassIsObject(Object r100) {
        if (r100 != null) goto L22;
        return false;
    L22:
        if ((r100 instanceof Method) == false) goto L14;
        Method r101 = (Method) r100;     // Catch: Throwable -> L21
        if (r101.getDeclaringClass() != null) goto L10;
        return false;
    L10:
        if (r101.getDeclaringClass().getSuperclass() != Object.class) goto L23;
        return true;
    L23:
        return false;
    L14:
        if ((r100 instanceof Constructor) == false) goto L25;
        Constructor r102 = (Constructor) r100;     // Catch: Throwable -> L21
        if (r102.getDeclaringClass() != null) goto L18;
        return false;
    L18:
        if (r102.getDeclaringClass().getSuperclass() != Object.class) goto L27;
        return true;
    L27:
        return false;
    L25:
        return false;
    L28:
        return false;
    }

    public static long getMethodDexFile(Object r100) {
        if (r100 != null) goto L17;
        return -1;
    L17:
        if ((r100 instanceof Method) == false) goto L9;
        Class<?> r101 = ((Method) r100).getDeclaringClass();     // Catch: Throwable -> L16
    L12:
        if (r101 != null) goto L14;
        return -1;
    L14:
        Field r102 = Class.class.getDeclaredField("dexCache");     // Catch: Throwable -> L16
        r102.setAccessible(true);     // Catch: Throwable -> L16
        Object r103 = r102.get(r101);     // Catch: Throwable -> L16
        Field r104 = r103.getClass().getDeclaredField("dexFile");     // Catch: Throwable -> L16
        r104.setAccessible(true);     // Catch: Throwable -> L16
        return r104.getLong(r103);
    L9:
        if ((r100 instanceof Constructor) == false) goto L11;
        r101 = ((Constructor) r100).getDeclaringClass();     // Catch: Throwable -> L16
        goto L12
    L11:
        r101 = null;
    L19:
        return -1;
    }

    public void testSetter(int r100) {
        this.testField = r100;
    }
}
