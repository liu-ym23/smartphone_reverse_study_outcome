package com.bytedance.common.jato.gc;

import android.os.Build;
import android.os.Process;
import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.common.jato.JatoXL;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public class RefPath {
    private static final AtomicInteger extraId = null;
    private static final ConcurrentHashMap<Integer, Object> extraMap = null;
    private static boolean firstRun;
    private static final Class[] ignoreClasses = null;
    private static final Class[] initClasses = null;

    public static final enum ObjectType extends Enum<ObjectType> {
        private static final /* synthetic */ ObjectType[] $VALUES = null;
        public static final ObjectType activity = null;
        public static final ObjectType fragment = null;
        public static final ObjectType other = null;
        public static final ObjectType view = null;
        private int value;

        static {
            ObjectType r100 = new ObjectType("view", 0, 0);
            view = r100;
            ObjectType r101 = new ObjectType("activity", 1, 1);
            activity = r101;
            ObjectType r102 = new ObjectType(WidgetService.PARAM_FRAGMENT, 2, 2);
            fragment = r102;
            ObjectType r103 = new ObjectType("other", 3, 3);
            other = r103;
            $VALUES = new ObjectType[]{r100, r101, r102, r103};
        }

        public static ObjectType[] values() {
            return (ObjectType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static ObjectType valueOf(String r100) {
            return (ObjectType) a.a(ObjectType.class, r100);
        }

        private ObjectType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static class PrivateStaticClass {
        private PrivateStaticClass() {
        }
    }

    public static final enum RefPathType extends Enum<RefPathType> {
        private static final /* synthetic */ RefPathType[] $VALUES = null;
        public static final RefPathType array = null;
        public static final RefPathType clazz = null;
        public static final RefPathType object = null;
        public static final RefPathType other = null;
        private int value;

        static {
            RefPathType r100 = new RefPathType("object", 0, 0);
            object = r100;
            RefPathType r101 = new RefPathType("clazz", 1, 1);
            clazz = r101;
            RefPathType r102 = new RefPathType("array", 2, 2);
            array = r102;
            RefPathType r103 = new RefPathType("other", 3, 3);
            other = r103;
            $VALUES = new RefPathType[]{r100, r101, r102, r103};
        }

        public static RefPathType[] values() {
            return (RefPathType[]) $VALUES.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static RefPathType valueOf(String r100) {
            return (RefPathType) a.a(RefPathType.class, r100);
        }

        private RefPathType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public RefPath() {
    }

    private static native boolean nativeAddObject(int r100, Object r101);

    private static native boolean nativeAddRootClass(Class r100);

    private static native boolean nativeClearObject();

    private static native int nativeDumpRefPath(int r100, int r101, int r102, String r103, int r104, int r105);

    private static native boolean nativeInit(Class[] r100, Class[] r101, long[] r102);

    static {
        ignoreClasses = new Class[]{int[].class, boolean[].class, byte[].class, char[].class, short[].class, long[].class, float[].class, double[].class, String[].class, String.class, StringBuilder.class, StringBuffer.class, Object.class, Integer.class, Short.class, Long.class, Float.class, Double.class, Boolean.class, Byte.class, Character.class, Void.class};
        initClasses = new Class[]{Integer.TYPE, RefPath.class, String.class, RefPath[].class, Class.class, ClassLoader.class, WeakReference.class, PrivateStaticClass.class};
        extraMap = new ConcurrentHashMap();
        extraId = new AtomicInteger(0);
        firstRun = true;
        init();
        addRootClass(Class.class);
    }

    private static long[] getClassField() {
        return new long[]{getFieldAddress(Class.class, "superClass"), getFieldAddress(Class.class, "vtable"), getFieldAddress(Class.class, "accessFlags"), getFieldAddress(Class.class, "classFlags"), getFieldAddress(Class.class, "classSize"), getFieldAddress(Class.class, "numReferenceInstanceFields"), getFieldAddress(Class.class, "numReferenceStaticFields"), getFieldAddress(Class.class, "objectSize"), getFieldAddress(Class.class, "primitiveType"), getFieldAddress(Class.class, "referenceInstanceOffsets"), getFieldAddress(ClassLoader.class, "classTable")};
    }

    private static boolean init() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L16:
        return false;
    L5:
        if (JatoNativeLoader.loadLibrary() == false) goto L16;
        if (Process.is64Bit() == false) goto L16;
        if (JatoXL.isInited() == false) goto L16;
        if (nativeInit(ignoreClasses, initClasses, getClassField()) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public static boolean addRootClass(Class r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L11:
        return false;
    L5:
        if (JatoNativeLoader.loadLibrary() == false) goto L11;
        if (Process.is64Bit() == false) goto L11;
        if (nativeAddRootClass(r100) == false) goto L11;
        return true;
    }

    private static long getFieldAddress(Class r100, String r101) {
        Field r102 = r100.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L4
    L5:
        if (r102 != null) goto L9;
        return -1;
    L9:
        return yw.a.a().b(r102);
    L4:
        r102 = null;
        goto L5
    }
}
