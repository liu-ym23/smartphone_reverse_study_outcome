package com.sun.jna;

import com.sun.jna.internal.ReflectionUtils;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes40.dex */
public interface Library {
    public static final String OPTION_ALLOW_OBJECTS = "allow-objects";
    public static final String OPTION_CALLING_CONVENTION = "calling-convention";
    public static final String OPTION_CLASSLOADER = "classloader";
    public static final String OPTION_FUNCTION_MAPPER = "function-mapper";
    public static final String OPTION_INVOCATION_MAPPER = "invocation-mapper";
    public static final String OPTION_OPEN_FLAGS = "open-flags";
    public static final String OPTION_STRING_ENCODING = "string-encoding";
    public static final String OPTION_STRUCTURE_ALIGNMENT = "structure-alignment";
    public static final String OPTION_SYMBOL_PROVIDER = "symbol-provider";
    public static final String OPTION_TYPE_MAPPER = "type-mapper";

    public static class Handler implements InvocationHandler {
        static final Method OBJECT_EQUALS = null;
        static final Method OBJECT_HASHCODE = null;
        static final Method OBJECT_TOSTRING = null;
        private final Map<Method, FunctionInfo> functions;
        private final Class<?> interfaceClass;
        private final InvocationMapper invocationMapper;
        private final NativeLibrary nativeLibrary;
        private final Map<String, Object> options;

        public static final class FunctionInfo {
            final Function function;
            final InvocationHandler handler;
            final boolean isVarArgs;
            final Object methodHandle;
            final Map<String, ?> options;
            final Class<?>[] parameterTypes;

            public FunctionInfo(Object r100) {
                this.handler = null;
                this.function = null;
                this.isVarArgs = false;
                this.options = null;
                this.parameterTypes = null;
                this.methodHandle = r100;
            }

            public FunctionInfo(InvocationHandler r100, Function r101, Class<?>[] r102, boolean r103, Map<String, ?> r104) {
                this.handler = r100;
                this.function = r101;
                this.isVarArgs = r103;
                this.options = r104;
                this.parameterTypes = r102;
                this.methodHandle = null;
            }
        }

        static {
            OBJECT_TOSTRING = Object.class.getMethod("toString", new Class[0]);     // Catch: Exception -> L4
            OBJECT_HASHCODE = Object.class.getMethod("hashCode", new Class[0]);     // Catch: Exception -> L4
            OBJECT_EQUALS = Object.class.getMethod("equals", new Class[]{Object.class});     // Catch: Exception -> L4
            return;
        L5:
            throw new Error("Error retrieving Object.toString() method");
        }

        public String getLibraryName() {
            return this.nativeLibrary.getName();
        }

        public Class<?> getInterfaceClass() {
            return this.interfaceClass;
        }

        public NativeLibrary getNativeLibrary() {
            return this.nativeLibrary;
        }

        public Handler(String r100, Class<?> r101, Map<String, ?> r102) {
            this.functions = new WeakHashMap();
            if (r100 == null) goto L10;
            if ("".equals(r100.trim()) == false) goto L10;
            throw new IllegalArgumentException("Invalid library name \"" + r100 + "\"");
        L10:
            if (r101.isInterface() == false) goto L24;
            this.interfaceClass = r101;
            HashMap r103 = new HashMap(r102);
            this.options = r103;
            if (AltCallingConvention.class.isAssignableFrom(r101) == false) goto L14;
            int r104 = 63;
        L16:
            if (r103.get(Library.OPTION_CALLING_CONVENTION) != null) goto L19;
            r103.put(Library.OPTION_CALLING_CONVENTION, Integer.valueOf(r104));
        L19:
            if (r103.get(Library.OPTION_CLASSLOADER) != null) goto L21;
            r103.put(Library.OPTION_CLASSLOADER, r101.getClassLoader());
        L21:
            this.nativeLibrary = NativeLibrary.getInstance(r100, this.options);
            this.invocationMapper = (InvocationMapper) r103.get(Library.OPTION_INVOCATION_MAPPER);
            return;
        L14:
            r104 = 0;
            goto L16
        L24:
            throw new IllegalArgumentException(r100 + " does not implement an interface: " + r101.getName());
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r100, Method r110, Object[] r111) throws Throwable {
            if (OBJECT_TOSTRING.equals(r110) == false) goto L7;
            return "Proxy interface to " + this.nativeLibrary;
        L7:
            if (OBJECT_HASHCODE.equals(r110) == false) goto L11;
            return Integer.valueOf(hashCode());
        L11:
            if (OBJECT_EQUALS.equals(r110) == false) goto L23;
            boolean r101 = false;
            Object r112 = r111[0];
            if (r112 == null) goto L22;
            if (Proxy.isProxyClass(r112.getClass()) == false) goto L22;
            if (Proxy.getInvocationHandler(r112) != this) goto L20;
            r101 = true;
        L20:
            return Function.valueOf(r101);
        L22:
            return Boolean.FALSE;
        L23:
            FunctionInfo r102 = this.functions.get(r110);
            if (r102 != null) goto L46;
            Map<Method, FunctionInfo> r103 = this.functions;
            monitor-enter(r103);
            r102 = this.functions.get(r110);     // Catch: Throwable -> L43
            if (r102 == null) goto L30;
        L41:
            monitor-exit(r103);     // Catch: Throwable -> L43
            goto L46
        L30:
            if (ReflectionUtils.isDefault(r110) == true) goto L39;
            boolean r104 = Function.isVarArgs(r110);     // Catch: Throwable -> L43
            InvocationMapper r105 = this.invocationMapper;     // Catch: Throwable -> L43
            if (r105 == null) goto L34;
            InvocationHandler r106 = r105.getInvocationHandler(this.nativeLibrary, r110);     // Catch: Throwable -> L43
        L35:
            if (r106 != null) goto L37;
            Function r107 = this.nativeLibrary.getFunction(r110.getName(), r110);     // Catch: Throwable -> L43
            Class<?>[] r108 = r110.getParameterTypes();     // Catch: Throwable -> L43
            HashMap r109 = new HashMap(this.options);     // Catch: Throwable -> L43
            r109.put("invoking-method", r110);     // Catch: Throwable -> L43
            Class<?>[] r113 = r108;
            HashMap r114 = r109;
            Function r115 = r107;
        L38:
            r102 = new FunctionInfo(r106, r115, r113, r104, r114);     // Catch: Throwable -> L43
        L40:
            this.functions.put(r110, r102);     // Catch: Throwable -> L43
            goto L41
        L37:
            r115 = null;
            r113 = null;
            r114 = null;
            goto L38
        L34:
            r106 = null;
            goto L35
        L39:
            r102 = new FunctionInfo(ReflectionUtils.getMethodHandle(r110));     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            throw th;
        L46:
            Object r116 = r102.methodHandle;
            if (r116 == null) goto L51;
            return ReflectionUtils.invokeDefaultMethod(r100, r116, r111);
        L51:
            if (r102.isVarArgs == false) goto L53;
            r111 = Function.concatenateVarArgs(r111);
        L53:
            Object[] r117 = r111;
            InvocationHandler r118 = r102.handler;
            if (r118 == null) goto L58;
            return r118.invoke(r100, r110, r117);
        L58:
            return r102.function.invoke(r110, r102.parameterTypes, r110.getReturnType(), r117, r102.options);
        }
    }
}
