package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ReflectionHelper {
    private static final RecordHelper RECORD_HELPER = null;

    /* JADX INFO: renamed from: com.google.gson.internal.reflect.ReflectionHelper$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class RecordHelper {
        private RecordHelper() {
        }

        public abstract Method getAccessor(Class<?> r100, Field r101);

        public abstract <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r100);

        public abstract String[] getRecordComponentNames(Class<?> r100);

        public abstract boolean isRecord(Class<?> r100);

        public /* synthetic */ RecordHelper(AnonymousClass1 r100) {
            this();
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class RecordNotSupportedHelper extends RecordHelper {
        private RecordNotSupportedHelper() {
            super(null);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public boolean isRecord(Class<?> r100) {
            return false;
        }

        public /* synthetic */ RecordNotSupportedHelper(AnonymousClass1 r100) {
            this();
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r100) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public String[] getRecordComponentNames(Class<?> r100) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Method getAccessor(Class<?> r100, Field r101) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }
    }

    public static class RecordSupportedHelper extends RecordHelper {
        private final Method getName;
        private final Method getRecordComponents;
        private final Method getType;
        private final Method isRecord;

        private RecordSupportedHelper() throws NoSuchMethodException {
            super(null);
            this.isRecord = Class.class.getMethod("isRecord", new Class[0]);
            Method r100 = Class.class.getMethod("getRecordComponents", new Class[0]);
            this.getRecordComponents = r100;
            Class<?> r101 = r100.getReturnType().getComponentType();
            this.getName = r101.getMethod("getName", new Class[0]);
            this.getType = r101.getMethod("getType", new Class[0]);
        }

        public /* synthetic */ RecordSupportedHelper(AnonymousClass1 r100) throws NoSuchMethodException {
            this();
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r100) {
            Object[] r101 = (Object[]) this.getRecordComponents.invoke(r100, new Object[0]);     // Catch: ReflectiveOperationException -> L8
            Class<?>[] r102 = new Class[r101.length];     // Catch: ReflectiveOperationException -> L8
            int r103 = 0;
        L4:
            if (r103 >= r101.length) goto L6;
            r102[r103] = (Class) this.getType.invoke(r101[r103], new Object[0]);     // Catch: ReflectiveOperationException -> L8
            r103 = r103 + 1;     // Catch: ReflectiveOperationException -> L8
            goto L4
        L6:
            return r100.getDeclaredConstructor(r102);
        L8:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public String[] getRecordComponentNames(Class<?> r100) {
            Object[] r101 = (Object[]) this.getRecordComponents.invoke(r100, new Object[0]);     // Catch: ReflectiveOperationException -> L8
            String[] r102 = new String[r101.length];     // Catch: ReflectiveOperationException -> L8
            int r103 = 0;
        L4:
            if (r103 >= r101.length) goto L7;
            r102[r103] = (String) this.getName.invoke(r101[r103], new Object[0]);     // Catch: ReflectiveOperationException -> L8
            r103 = r103 + 1;
            goto L4
        L7:
            return r102;
        L8:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public boolean isRecord(Class<?> r100) {
            return ((Boolean) this.isRecord.invoke(r100, new Object[0])).booleanValue();
        L4:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }

        @Override // com.google.gson.internal.reflect.ReflectionHelper.RecordHelper
        public Method getAccessor(Class<?> r100, Field r101) {
            return r100.getMethod(r101.getName(), new Class[0]);
        L4:
            e = move-exception;
            throw ReflectionHelper.access$300(e);
        }
    }

    static {
        AnonymousClass1 r100 = null;
        RecordHelper r101 = new RecordSupportedHelper(r100);     // Catch: NoSuchMethodException -> L5
    L6:
        RECORD_HELPER = r101;
        return;
    L5:
        r101 = new RecordNotSupportedHelper(r100);
        goto L6
    }

    private ReflectionHelper() {
    }

    public static /* synthetic */ RuntimeException access$300(ReflectiveOperationException r100) {
        return createExceptionForRecordReflectionException(r100);
    }

    public static String constructorToString(Constructor<?> r100) {
        StringBuilder r101 = new StringBuilder(r100.getDeclaringClass().getName());
        appendExecutableParameters(r100, r101);
        return r101.toString();
    }

    private static RuntimeException createExceptionForRecordReflectionException(ReflectiveOperationException r100) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", r100);
    }

    public static RuntimeException createExceptionForUnexpectedIllegalAccess(IllegalAccessException r100) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", r100);
    }

    public static String fieldToString(Field r100) {
        return r100.getDeclaringClass().getName() + "#" + r100.getName();
    }

    public static <T> Constructor<T> getCanonicalRecordConstructor(Class<T> r100) {
        return RECORD_HELPER.getCanonicalRecordConstructor(r100);
    }

    public static String[] getRecordComponentNames(Class<?> r100) {
        return RECORD_HELPER.getRecordComponentNames(r100);
    }

    public static boolean isRecord(Class<?> r100) {
        return RECORD_HELPER.isRecord(r100);
    }

    public static void makeAccessible(AccessibleObject r100) throws JsonIOException {
        r100.setAccessible(true);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new JsonIOException("Failed making " + getAccessibleObjectDescription(r100, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e);
    }

    public static String tryMakeAccessible(Constructor<?> r100) {
        r100.setAccessible(true);     // Catch: Exception -> L6
        return null;
    L6:
        e = move-exception;
        return "Failed making constructor '" + constructorToString(r100) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e.getMessage();
    }

    private static void appendExecutableParameters(AccessibleObject r100, StringBuilder r101) {
        r101.append('(');
        if ((r100 instanceof Method) == false) goto L5;
        Class<?>[] r102 = ((Method) r100).getParameterTypes();
    L6:
        int r103 = 0;
    L8:
        if (r103 >= r102.length) goto L12;
        if (r103 <= 0) goto L11;
        r101.append(", ");
    L11:
        r101.append(r102[r103].getSimpleName());
        r103 = r103 + 1;
        goto L8
    L12:
        r101.append(')');
        return;
    L5:
        r102 = ((Constructor) r100).getParameterTypes();
        goto L6
    }

    public static String getAccessibleObjectDescription(AccessibleObject r100, boolean r101) {
        if ((r100 instanceof Field) == false) goto L6;
        String r102 = "field '" + fieldToString((Field) r100) + "'";
    L12:
        if (r101 == true) goto L14;
        return r102;
    L14:
        if (Character.isLowerCase(r102.charAt(0)) == true) goto L16;
        return r102;
    L16:
        return Character.toUpperCase(r102.charAt(0)) + r102.substring(1);
    L6:
        if ((r100 instanceof Method) == false) goto L9;
        Method r103 = (Method) r100;
        StringBuilder r104 = new StringBuilder(r103.getName());
        appendExecutableParameters(r103, r104);
        r102 = "method '" + r103.getDeclaringClass().getName() + "#" + r104.toString() + "'";
        goto L12
    L9:
        if ((r100 instanceof Constructor) == false) goto L11;
        r102 = "constructor '" + constructorToString((Constructor) r100) + "'";
        goto L12
    L11:
        r102 = "<unknown AccessibleObject> " + r100.toString();
        goto L12
    }

    public static Method getAccessor(Class<?> r100, Field r101) {
        return RECORD_HELPER.getAccessor(r100, r101);
    }
}
