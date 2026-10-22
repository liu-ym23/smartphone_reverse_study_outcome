package com.sun.jna;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class Function extends Pointer {
    public static final int ALT_CONVENTION = 63;
    public static final int C_CONVENTION = 0;
    static final Integer INTEGER_FALSE = null;
    static final Integer INTEGER_TRUE = null;
    private static final VarArgsChecker IS_VARARGS = null;
    private static final int MASK_CC = 63;
    public static final int MAX_NARGS = 256;
    static final String OPTION_INVOKING_METHOD = "invoking-method";
    public static final int THROW_LAST_ERROR = 64;
    public static final int USE_VARARGS = 255;
    private static final int USE_VARARGS_SHIFT = 7;
    final int callFlags;
    final String encoding;
    private final String functionName;
    private NativeLibrary library;
    final Map<String, ?> options;

    public static class NativeMappedArray extends Memory implements PostCallRead {
        private final NativeMapped[] original;

        @Override // com.sun.jna.Function.PostCallRead
        public void read() {
            getValue(0, this.original.getClass(), this.original);
        }

        public NativeMappedArray(NativeMapped[] r100) {
            super(Native.getNativeSize(r100.getClass(), r100));
            this.original = r100;
            NativeMapped[] r101 = this.original;
            setValue(0, r101, r101.getClass());
        }
    }

    public static class PointerArray extends Memory implements PostCallRead {
        private final Pointer[] original;

        @Override // com.sun.jna.Function.PostCallRead
        public void read() {
            Pointer[] r100 = this.original;
            read(0, r100, 0, r100.length);
        }

        public PointerArray(Pointer[] r100) {
            super(Native.POINTER_SIZE * (r100.length + 1));
            this.original = r100;
            int r101 = 0;
        L4:
            if (r101 >= r100.length) goto L6;
            setPointer(Native.POINTER_SIZE * r101, r100[r101]);
            r101 = r101 + 1;
            goto L4
        L6:
            setPointer(Native.POINTER_SIZE * r100.length, null);
        }
    }

    public interface PostCallRead {
        void read();
    }

    static {
        INTEGER_TRUE = -1;
        INTEGER_FALSE = 0;
        IS_VARARGS = VarArgsChecker.create();
    }

    public int getCallingConvention() {
        return this.callFlags & 63;
    }

    @Override // com.sun.jna.Pointer
    public int hashCode() {
        return (this.callFlags + this.options.hashCode()) + super.hashCode();
    }

    @Override // com.sun.jna.Pointer
    public String toString() {
        if (this.library == null) goto L7;
        return "native function " + this.functionName + "(" + this.library.getName() + ")@0x" + Long.toHexString(this.peer);
    L7:
        return "native function@0x" + Long.toHexString(this.peer);
    }

    public String getName() {
        return this.functionName;
    }

    private void checkCallingConvention(int r100) throws IllegalArgumentException {
        if ((r100 & 63) != r100) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Unrecognized calling convention: " + r100);
    }

    public static Object[] concatenateVarArgs(Object[] r100) {
        if (r100 != null) goto L4;
        return r100;
    L4:
        if (r100.length <= 0) goto L25;
        Object r101 = r100[r100.length - 1];
        if (r101 == null) goto L8;
        Class<?> r102 = r101.getClass();
    L9:
        if (r102 != null) goto L11;
        return r100;
    L11:
        if (r102.isArray() == false) goto L27;
        Object[] r103 = (Object[]) r101;
        int r104 = 0;
    L14:
        if (r104 >= r103.length) goto L19;
        Object r105 = r103[r104];
        if ((r105 instanceof Float) == false) goto L18;
        r103[r104] = Double.valueOf(((Float) r105).floatValue());
    L18:
        r104 = r104 + 1;
        goto L14
    L19:
        int r106 = r100.length + r103.length;
        Object[] r107 = new Object[r106];
        System.arraycopy(r100, 0, r107, 0, r100.length - 1);
        System.arraycopy(r103, 0, r107, r100.length - 1, r103.length);
        r107[r106 - 1] = null;
        return r107;
    L27:
        return r100;
    L8:
        r102 = null;
        goto L9
    L25:
        return r100;
    }

    public static int fixedArgs(Method r100) {
        return IS_VARARGS.fixedArgs(r100);
    }

    public static Function getFunction(Pointer r100) {
        return getFunction(r100, 0, null);
    }

    private boolean isPrimitiveArray(Class<?> r100) {
        if (r100.isArray() == true) goto L5;
    L7:
        return false;
    L5:
        if (r100.getComponentType().isPrimitive() == false) goto L7;
        return true;
    }

    public static boolean isVarArgs(Method r100) {
        return IS_VARARGS.isVarArgs(r100);
    }

    public static Boolean valueOf(boolean r100) {
        if (r100 == false) goto L5;
        return Boolean.TRUE;
    L5:
        return Boolean.FALSE;
    }

    @Override // com.sun.jna.Pointer
    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if (r100.getClass() != getClass()) goto L19;
        Function r101 = (Function) r100;
        if (r101.callFlags == this.callFlags) goto L13;
    L17:
        return false;
    L13:
        if (r101.options.equals(this.options) == false) goto L17;
        if (r101.peer != this.peer) goto L17;
        return true;
    L19:
        return false;
    }

    public void invoke(Object[] r100) {
        invoke(Void.class, r100);
    }

    public double invokeDouble(Object[] r100) {
        return ((Double) invoke(Double.class, r100)).doubleValue();
    }

    public float invokeFloat(Object[] r100) {
        return ((Float) invoke(Float.class, r100)).floatValue();
    }

    public int invokeInt(Object[] r100) {
        return ((Integer) invoke(Integer.class, r100)).intValue();
    }

    public long invokeLong(Object[] r100) {
        return ((Long) invoke(Long.class, r100)).longValue();
    }

    public Object invokeObject(Object[] r100) {
        return invoke(Object.class, r100);
    }

    public Pointer invokePointer(Object[] r100) {
        return (Pointer) invoke(Pointer.class, r100);
    }

    public void invokeVoid(Object[] r100) {
        invoke(Void.class, r100);
    }

    public static Function getFunction(String r100, String r101) {
        return NativeLibrary.getInstance(r100).getFunction(r101);
    }

    private Pointer invokePointer(int r100, Object[] r101) {
        long r102 = Native.invokePointer(this, this.peer, r100, r101);
        if (r102 != 0) goto L6;
        return null;
    L6:
        return new Pointer(r102);
    }

    public Object invoke(Class<?> r100, Object[] r101) {
        return invoke(r100, r101, this.options);
    }

    public String invokeString(Object[] r100, boolean r101) {
        if (r101 == false) goto L4;
        Class<?> r102 = WString.class;
    L5:
        Object r103 = invoke(r102, r100);
        if (r103 != null) goto L10;
        return null;
    L10:
        return r103.toString();
    L4:
        r102 = String.class;
        goto L5
    }

    public static Function getFunction(Pointer r100, int r101) {
        return getFunction(r100, r101, null);
    }

    public Function(Pointer r100, int r101, String r102) {
        checkCallingConvention(r101 & 63);
        if (r100 == null) goto L13;
        if (r100.peer == 0) goto L13;
        this.functionName = r100.toString();
        this.callFlags = r101;
        this.peer = r100.peer;
        this.options = Collections.EMPTY_MAP;
        if (r102 != null) goto L10;
        r102 = Native.getDefaultStringEncoding();
    L10:
        this.encoding = r102;
        return;
    L13:
        throw new NullPointerException("Function address may not be null");
    }

    public static Function getFunction(String r100, String r101, int r102) {
        return NativeLibrary.getInstance(r100).getFunction(r101, r102, null);
    }

    private String invokeString(int r100, Object[] r101, boolean r102) {
        Pointer r103 = invokePointer(r100, r101);
        if (r103 != null) goto L5;
        return null;
    L5:
        if (r102 == false) goto L11;
        return r103.getWideString(0);
    L11:
        return r103.getString(0, this.encoding);
    }

    public Object invoke(Class<?> r100, Object[] r101, Map<String, ?> r110) {
        Method r102 = (Method) r110.get(OPTION_INVOKING_METHOD);
        if (r102 == null) goto L5;
        Class<?>[] r103 = r102.getParameterTypes();
    L7:
        return invoke(r102, r103, r100, r101, r110);
    L5:
        r103 = null;
        goto L7
    }

    public static Function getFunction(Pointer r100, int r101, String r102) {
        return new Function(r100, r101, r102);
    }

    public Object invoke(Object[] r100, Class<?> r101, boolean r102) {
        return invoke(r100, r101, r102, 0);
    }

    public Function(NativeLibrary r100, String r101, int r102, String r103) {
        checkCallingConvention(r102 & 63);
        if (r101 == null) goto L15;
        this.library = r100;
        this.functionName = r101;
        this.callFlags = r102;
        this.options = r100.getOptions();
        if (r103 != null) goto L8;
        r103 = Native.getDefaultStringEncoding();
    L8:
        this.encoding = r103;
        this.peer = r100.getSymbolAddress(r101);     // Catch: UnsatisfiedLinkError -> L11
        return;
    L11:
        e = move-exception;
        throw new UnsatisfiedLinkError("Error looking up function '" + r101 + "': " + e.getMessage());
    L15:
        throw new NullPointerException("Function name must not be null");
    }

    public static Function getFunction(String r100, String r101, int r102, String r103) {
        return NativeLibrary.getInstance(r100).getFunction(r101, r102, r103);
    }

    public Object invoke(Object[] r100, Class<?> r101, boolean r110, int r111) {
        int r102 = this.callFlags | ((r111 & 255) << 7);
        if (r101 != null) goto L5;
    L114:
        Native.invokeVoid(this, this.peer, r102, r100);
        return null;
    L5:
        if (r101 == Void.TYPE) goto L114;
        if (r101 == Void.class) goto L114;
        boolean r103 = true;
        int r104 = 0;
        if (r101 == Boolean.TYPE) goto L110;
        if (r101 == Boolean.class) goto L110;
        if (r101 == Byte.TYPE) goto L137;
        if (r101 == Byte.class) goto L137;
        if (r101 == Short.TYPE) goto L136;
        if (r101 == Short.class) goto L136;
        if (r101 == Character.TYPE) goto L135;
        if (r101 == Character.class) goto L135;
        if (r101 == Integer.TYPE) goto L134;
        if (r101 == Integer.class) goto L134;
        if (r101 == Long.TYPE) goto L133;
        if (r101 == Long.class) goto L133;
        if (r101 == Float.TYPE) goto L132;
        if (r101 == Float.class) goto L132;
        if (r101 == Double.TYPE) goto L131;
        if (r101 == Double.class) goto L131;
        if (r101 != String.class) goto L53;
        return invokeString(r102, r100, false);
    L53:
        if (r101 != WString.class) goto L58;
        String r105 = invokeString(r102, r100, true);
        if (r105 != null) goto L119;
        return null;
    L119:
        return new WString(r105);
    L58:
        if (Pointer.class.isAssignableFrom(r101) == false) goto L62;
        return invokePointer(r102, r100);
    L62:
        if (Structure.class.isAssignableFrom(r101) == false) goto L70;
        if (Structure.ByValue.class.isAssignableFrom(r101) == false) goto L66;
        Structure r112 = Native.invokeStructure(this, this.peer, r102, r100, Structure.newInstance(r101));
        r112.autoRead();
        return r112;
    L66:
        Pointer r113 = invokePointer(r102, r100);
        if (r113 == null) goto L121;
        Structure r114 = Structure.newInstance(r101, r113);
        r114.conditionalAutoRead();
        return r114;
    L121:
        return r113;
    L70:
        if (Callback.class.isAssignableFrom(r101) == false) goto L75;
        Pointer r115 = invokePointer(r102, r100);
        if (r115 != null) goto L124;
        return r115;
    L124:
        return CallbackReference.getCallback(r101, r115);
    L75:
        if (r101 != String[].class) goto L80;
        Pointer r106 = invokePointer(r102, r100);
        if (r106 != null) goto L126;
        return null;
    L126:
        return r106.getStringArray(0, this.encoding);
    L80:
        if (r101 != WString[].class) goto L88;
        Pointer r107 = invokePointer(r102, r100);
        if (r107 == null) goto L127;
        String[] r108 = r107.getWideStringArray(0);
        WString[] r116 = new WString[r108.length];
    L85:
        if (r104 >= r108.length) goto L140;
        r116[r104] = new WString(r108[r104]);
        r104 = r104 + 1;
        goto L85
    L140:
        return r116;
    L127:
        return null;
    L88:
        if (r101 != Pointer[].class) goto L92;
        Pointer r109 = invokePointer(r102, r100);
        if (r109 != null) goto L129;
        return null;
    L129:
        return r109.getPointerArray(0);
    L92:
        if (r110 == false) goto L101;
        Object r117 = Native.invokeObject(this, this.peer, r102, r100);
        if (r117 != null) goto L96;
        return r117;
    L96:
        if (r101.isAssignableFrom(r117.getClass()) == false) goto L99;
        return r117;
    L99:
        throw new ClassCastException("Return type " + r101 + " does not match result " + r117.getClass());
    L101:
        throw new IllegalArgumentException("Unsupported return type " + r101 + " in function " + getName());
    L131:
        return Double.valueOf(Native.invokeDouble(this, this.peer, r102, r100));
    L132:
        return Float.valueOf(Native.invokeFloat(this, this.peer, r102, r100));
    L133:
        return Long.valueOf(Native.invokeLong(this, this.peer, r102, r100));
    L134:
        return Integer.valueOf(Native.invokeInt(this, this.peer, r102, r100));
    L135:
        return Character.valueOf((char) Native.invokeInt(this, this.peer, r102, r100));
    L136:
        return Short.valueOf((short) Native.invokeInt(this, this.peer, r102, r100));
    L137:
        return Byte.valueOf((byte) Native.invokeInt(this, this.peer, r102, r100));
    L110:
        if (Native.invokeInt(this, this.peer, r102, r100) != 0) goto L138;
        r103 = false;
    L138:
        return valueOf(r103);
    }

    public Object invoke(Method r210, Class<?>[] r211, Class<?> r212, Object[] r213, Map<String, ?> r214) {
        Object[] r100 = new Object[0];
        if (r213 != null) goto L5;
        Object[] r110 = r100;
    L10:
        TypeMapper r111 = (TypeMapper) r214.get(Library.OPTION_TYPE_MAPPER);
        boolean r112 = Boolean.TRUE.equals(r214.get(Library.OPTION_ALLOW_OBJECTS));
        if (r110.length <= 0) goto L14;
        if (r210 == null) goto L14;
        boolean r113 = isVarArgs(r210);
    L16:
        if (r110.length <= 0) goto L19;
        if (r210 == null) goto L19;
        int r101 = fixedArgs(r210);
    L20:
        int r102 = 0;
    L21:
        FromNativeConverter r103 = null;
        if (r102 >= r110.length) goto L32;
        if (r210 == null) goto L30;
        if (r113 == true) goto L26;
    L28:
        Class<?> r104 = r211[r102];
    L29:
        Class<?> r114 = r104;
    L31:
        int r115 = r102;
        r110[r115] = convertArgument(r110, r102, r210, r111, r112, r114);
        r102 = r115 + 1;
        r101 = r101;
        goto L21
    L26:
        if (r102 < (r211.length - 1)) goto L28;
        r104 = r211[r211.length - 1].getComponentType();
        goto L29
    L30:
        r114 = null;
        goto L31
    L32:
        int r116 = r101;
        if (NativeMapped.class.isAssignableFrom(r212) == false) goto L35;
        NativeMappedConverter r105 = NativeMappedConverter.getInstance(r212);
        Class<?> r106 = r105.nativeType();
        FromNativeConverter r107 = r105;
    L40:
        Object r108 = invoke(r110, r106, r112, r116);
        if (r107 == null) goto L46;
        if (r210 == null) goto L44;
        FromNativeContext r109 = new MethodResultContext(r212, this, r213, r210);
    L45:
        r108 = r107.fromNative(r108, r109);
        goto L46
    L44:
        r109 = new FunctionResultContext(r212, this, r213);
    L46:
        if (r213 == null) goto L72;
        int r117 = 0;
    L49:
        if (r117 >= r213.length) goto L72;
        Object r118 = r213[r117];
        if (r118 == null) goto L71;
        if ((r118 instanceof Structure) == true) goto L56;
        Object r119 = r110[r117];
        if ((r119 instanceof PostCallRead) == false) goto L69;
        ((PostCallRead) r119).read();
        Object r120 = r110[r117];
        if ((r120 instanceof PointerArray) == false) goto L71;
        PointerArray r121 = (PointerArray) r120;
        if (Structure.ByReference[].class.isAssignableFrom(r118.getClass()) == false) goto L71;
        Class<?> r122 = r118.getClass().getComponentType();
        Structure[] r123 = (Structure[]) r118;
        int r124 = 0;
    L66:
        if (r124 >= r123.length) goto L71;
        r123[r124] = Structure.updateStructureByReference(r122, r123[r124], r121.getPointer(Native.POINTER_SIZE * r124));
        r124 = r124 + 1;
        goto L66
    L69:
        if (Structure[].class.isAssignableFrom(r118.getClass()) == false) goto L71;
        Structure.autoRead((Structure[]) r118);
        goto L71
    L56:
        if ((r118 instanceof Structure.ByValue) == true) goto L71;
        ((Structure) r118).autoRead();
    L71:
        r117 = r117 + 1;
    L72:
        return r108;
    L35:
        if (r111 == null) goto L39;
        FromNativeConverter r125 = r111.getFromNativeConverter(r212);
        r103 = r125;
        if (r125 == null) goto L39;
        r106 = r125.nativeType();
        r107 = r125;
    L39:
        r106 = r212;
        r107 = r103;
    L19:
        r101 = 0;
    L14:
        r113 = false;
        goto L16
    L5:
        if (r213.length > 256) goto L8;
        int r126 = r213.length;
        Object[] r127 = new Object[r126];
        System.arraycopy(r213, 0, r127, 0, r126);
        r110 = r127;
        goto L10
    L8:
        throw new UnsupportedOperationException("Maximum argument count is 256");
    }

    private Object convertArgument(Object[] r100, int r101, Method r102, TypeMapper r103, boolean r110, Class<?> r111) {
        Object r104 = r100[r101];
        if (r104 == null) goto L15;
        Class<?> r105 = r104.getClass();
        if (NativeMapped.class.isAssignableFrom(r105) == false) goto L7;
        ToNativeConverter r106 = NativeMappedConverter.getInstance(r105);
    L10:
        if (r106 == null) goto L15;
        if (r102 == null) goto L13;
        ToNativeContext r107 = new MethodParameterContext(this, r100, r101, r102);
    L14:
        r104 = r106.toNative(r104, r107);
        goto L15
    L13:
        r107 = new FunctionParameterContext(this, r100, r101);
        goto L14
    L7:
        if (r103 == null) goto L9;
        r106 = r103.getToNativeConverter(r105);
        goto L10
    L9:
        r106 = null;
    L15:
        if (r104 != null) goto L17;
    L124:
        return r104;
    L17:
        if (isPrimitiveArray(r104.getClass()) == true) goto L124;
        Class<?> r108 = r104.getClass();
        if ((r104 instanceof Structure) == false) goto L40;
        Structure r109 = (Structure) r104;
        r109.autoWrite();
        if ((r109 instanceof Structure.ByValue) == false) goto L38;
        Class<?> r112 = r109.getClass();
        if (r102 == null) goto L35;
        Class<?>[] r113 = r102.getParameterTypes();
        if (IS_VARARGS.isVarArgs(r102) == true) goto L28;
        r112 = r113[r101];
        goto L35
    L28:
        if (r101 >= (r113.length - 1)) goto L30;
        r112 = r113[r101];
        goto L35
    L30:
        Class<?> r114 = r113[r113.length - 1].getComponentType();
        if (r114 == Object.class) goto L35;
        r112 = r114;
    L35:
        if (Structure.ByValue.class.isAssignableFrom(r112) == false) goto L38;
        return r109;
    L38:
        return r109.getPointer();
    L40:
        if ((r104 instanceof Callback) == false) goto L44;
        return CallbackReference.getFunctionPointer((Callback) r104);
    L44:
        if ((r104 instanceof String) == false) goto L48;
        return new NativeString((String) r104, this.encoding).getPointer();
    L48:
        if ((r104 instanceof WString) == false) goto L52;
        return new NativeString(r104.toString(), true).getPointer();
    L52:
        if ((r104 instanceof Boolean) == false) goto L59;
        if (Boolean.TRUE.equals(r104) == false) goto L57;
        return INTEGER_TRUE;
    L57:
        return INTEGER_FALSE;
    L59:
        if (String[].class != r108) goto L63;
        return new StringArray((String[]) r104, this.encoding);
    L63:
        if (WString[].class != r108) goto L67;
        return new StringArray((WString[]) r104);
    L67:
        if (Pointer[].class != r108) goto L71;
        return new PointerArray((Pointer[]) r104);
    L71:
        if (NativeMapped[].class.isAssignableFrom(r108) == false) goto L75;
        return new NativeMappedArray((NativeMapped[]) r104);
    L75:
        if (Structure[].class.isAssignableFrom(r108) == false) goto L114;
        Structure[] r115 = (Structure[]) r104;
        Class<?> r116 = r108.getComponentType();
        boolean r117 = Structure.ByReference.class.isAssignableFrom(r116);
        int r118 = 0;
        if (r111 != null) goto L79;
    L92:
        if (r117 == false) goto L104;
        Structure.autoWrite(r115);
        Pointer[] r119 = new Pointer[r115.length + 1];
    L95:
        if (r118 >= r115.length) goto L102;
        Structure r120 = r115[r118];
        if (r120 == null) goto L99;
        Pointer r121 = r120.getPointer();
    L100:
        r119[r118] = r121;
        r118 = r118 + 1;
        goto L95
    L99:
        r121 = null;
        goto L100
    L102:
        return new PointerArray(r119);
    L104:
        if (r115.length == 0) goto L112;
        if (r115[0] != null) goto L109;
        Structure.newInstance(r116).toArray(r115);
        return r115[0].getPointer();
    L109:
        Structure.autoWrite(r115);
        return r115[0].getPointer();
    L112:
        throw new IllegalArgumentException("Structure array must have non-zero length");
    L79:
        if (Structure.ByReference[].class.isAssignableFrom(r111) == true) goto L92;
        if (r117 == true) goto L91;
        int r122 = 0;
    L84:
        if (r122 >= r115.length) goto L92;
        if ((r115[r122] instanceof Structure.ByReference) == true) goto L89;
        r122 = r122 + 1;
        goto L84
    L89:
        throw new IllegalArgumentException("Function " + getName() + " declared Structure[] at parameter " + r101 + " but element " + r122 + " is of Structure.ByReference type");
    L91:
        throw new IllegalArgumentException("Function " + getName() + " declared Structure[] at parameter " + r101 + " but array of " + r116 + " was passed");
    L114:
        if (r108.isArray() == true) goto L123;
        if (r110 == false) goto L118;
        return r104;
    L118:
        if (Native.isSupportedNativeType(r104.getClass()) == false) goto L121;
        return r104;
    L121:
        throw new IllegalArgumentException("Unsupported argument type " + r104.getClass().getName() + " at parameter " + r101 + " of function " + getName());
    L123:
        throw new IllegalArgumentException("Unsupported array argument type: " + r108.getComponentType());
    }
}
