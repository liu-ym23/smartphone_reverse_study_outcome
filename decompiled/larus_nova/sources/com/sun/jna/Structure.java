package com.sun.jna;

import com.alipay.sdk.m.u.i;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;
import tb2.c;

/* JADX INFO: loaded from: classes40.dex */
public abstract class Structure {
    public static final int ALIGN_DEFAULT = 0;
    public static final int ALIGN_GNUC = 2;
    public static final int ALIGN_MSVC = 3;
    public static final int ALIGN_NONE = 1;
    protected static final int CALCULATE_SIZE = -1;
    private static final Logger LOG = null;
    private static final Pointer PLACEHOLDER_MEMORY = null;
    private static final ThreadLocal<Set<Structure>> busy = null;
    static final Map<Class<?>, List<String>> fieldOrder = null;
    static final Map<Class<?>, LayoutInfo> layoutInfo = null;
    private static final ThreadLocal<Map<Pointer, Structure>> reads = null;
    private int actualAlignType;
    private int alignType;
    private Structure[] array;
    private boolean autoRead;
    private boolean autoWrite;
    private String encoding;
    private Pointer memory;
    private final Map<String, NativeStringTracking> nativeStrings;
    private boolean readCalled;
    private int size;
    private int structAlignment;
    private Map<String, StructField> structFields;
    private long typeInfo;
    private TypeMapper typeMapper;

    public static class AutoAllocated extends Memory {
        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return "auto-" + super.toString();
        }

        public AutoAllocated(int r100) {
            super(r100);
            super.clear();
        }
    }

    public interface ByReference {
    }

    public interface ByValue {
    }

    @FieldOrder({"size", "alignment", "type", SlcElement.KEY_ELEMENTS})
    public static class FFIType extends Structure {
        private static final int FFI_TYPE_STRUCT = 13;
        private static final Map<Pointer, FFIType> ffiTypeInfo = null;
        private static final Map<Class, Map<Integer, FFIType>> typeInfoMap = null;
        private static final Map<Class, FFIType> unionHelper = null;
        public short alignment;
        public Pointer elements;
        public size_t size;
        public short type;

        public static class FFITypes {
            private static Pointer ffi_type_double;
            private static Pointer ffi_type_float;
            private static Pointer ffi_type_longdouble;
            private static Pointer ffi_type_pointer;
            private static Pointer ffi_type_sint16;
            private static Pointer ffi_type_sint32;
            private static Pointer ffi_type_sint64;
            private static Pointer ffi_type_sint8;
            private static Pointer ffi_type_uint16;
            private static Pointer ffi_type_uint32;
            private static Pointer ffi_type_uint64;
            private static Pointer ffi_type_uint8;
            private static Pointer ffi_type_void;

            private FFITypes() {
            }

            public static /* synthetic */ Pointer access$1000() {
                return ffi_type_uint8;
            }

            public static /* synthetic */ Pointer access$1100() {
                return ffi_type_sint8;
            }

            public static /* synthetic */ Pointer access$1200() {
                return ffi_type_uint16;
            }

            public static /* synthetic */ Pointer access$1300() {
                return ffi_type_sint16;
            }

            public static /* synthetic */ Pointer access$1400() {
                return ffi_type_uint32;
            }

            public static /* synthetic */ Pointer access$1500() {
                return ffi_type_sint32;
            }

            public static /* synthetic */ Pointer access$1600() {
                return ffi_type_uint64;
            }

            public static /* synthetic */ Pointer access$1700() {
                return ffi_type_sint64;
            }

            public static /* synthetic */ Pointer access$1800() {
                return ffi_type_pointer;
            }

            public static /* synthetic */ Pointer access$1900() {
                return ffi_type_float;
            }

            public static /* synthetic */ Pointer access$2000() {
                return ffi_type_double;
            }

            public static /* synthetic */ Pointer access$2100() {
                return ffi_type_void;
            }

            public static /* synthetic */ Pointer access$2200() {
                return ffi_type_longdouble;
            }
        }

        public static class size_t extends IntegerType {
            private static final long serialVersionUID = 1;

            public size_t() {
                this(0);
            }

            public size_t(long r100) {
                super(Native.SIZE_T_SIZE, r100);
            }
        }

        static {
            typeInfoMap = new WeakHashMap();
            unionHelper = new WeakHashMap();
            HashMap r100 = new HashMap();
            ffiTypeInfo = r100;
            if (Native.POINTER_SIZE == 0) goto L19;
            if (FFITypes.access$2100() == null) goto L17;
            r100.put(FFITypes.access$2100(), Structure.newInstance(FFIType.class, FFITypes.access$2100()));
            r100.put(FFITypes.access$1900(), Structure.newInstance(FFIType.class, FFITypes.access$1900()));
            r100.put(FFITypes.access$2000(), Structure.newInstance(FFIType.class, FFITypes.access$2000()));
            r100.put(FFITypes.access$2200(), Structure.newInstance(FFIType.class, FFITypes.access$2200()));
            r100.put(FFITypes.access$1000(), Structure.newInstance(FFIType.class, FFITypes.access$1000()));
            r100.put(FFITypes.access$1100(), Structure.newInstance(FFIType.class, FFITypes.access$1100()));
            r100.put(FFITypes.access$1200(), Structure.newInstance(FFIType.class, FFITypes.access$1200()));
            r100.put(FFITypes.access$1300(), Structure.newInstance(FFIType.class, FFITypes.access$1300()));
            r100.put(FFITypes.access$1400(), Structure.newInstance(FFIType.class, FFITypes.access$1400()));
            r100.put(FFITypes.access$1500(), Structure.newInstance(FFIType.class, FFITypes.access$1500()));
            r100.put(FFITypes.access$1600(), Structure.newInstance(FFIType.class, FFITypes.access$1600()));
            r100.put(FFITypes.access$1700(), Structure.newInstance(FFIType.class, FFITypes.access$1700()));
            r100.put(FFITypes.access$1800(), Structure.newInstance(FFIType.class, FFITypes.access$1800()));
            Iterator r101 = r100.values().iterator();
        L8:
            if (r101.hasNext() == false) goto L10;
            ((FFIType) r101.next()).read();
            goto L8
        L10:
            Class r102 = Void.TYPE;
            Map<Pointer, FFIType> r103 = ffiTypeInfo;
            storeTypeInfo(r102, r103.get(FFITypes.access$2100()));
            storeTypeInfo(Void.class, r103.get(FFITypes.access$2100()));
            storeTypeInfo(Float.TYPE, r103.get(FFITypes.access$1900()));
            storeTypeInfo(Float.class, r103.get(FFITypes.access$1900()));
            storeTypeInfo(Double.TYPE, r103.get(FFITypes.access$2000()));
            storeTypeInfo(Double.class, r103.get(FFITypes.access$2000()));
            storeTypeInfo(Long.TYPE, r103.get(FFITypes.access$1700()));
            storeTypeInfo(Long.class, r103.get(FFITypes.access$1700()));
            storeTypeInfo(Integer.TYPE, r103.get(FFITypes.access$1500()));
            storeTypeInfo(Integer.class, r103.get(FFITypes.access$1500()));
            storeTypeInfo(Short.TYPE, r103.get(FFITypes.access$1300()));
            storeTypeInfo(Short.class, r103.get(FFITypes.access$1300()));
            if (Native.WCHAR_SIZE != 2) goto L13;
            Pointer r104 = FFITypes.access$1200();
        L14:
            FFIType r105 = r103.get(r104);
            storeTypeInfo(Character.TYPE, r105);
            storeTypeInfo(Character.class, r105);
            storeTypeInfo(Byte.TYPE, r103.get(FFITypes.access$1100()));
            storeTypeInfo(Byte.class, r103.get(FFITypes.access$1100()));
            storeTypeInfo(Pointer.class, r103.get(FFITypes.access$1800()));
            storeTypeInfo(String.class, r103.get(FFITypes.access$1800()));
            storeTypeInfo(WString.class, r103.get(FFITypes.access$1800()));
            storeTypeInfo(Boolean.TYPE, r103.get(FFITypes.access$1400()));
            storeTypeInfo(Boolean.class, r103.get(FFITypes.access$1400()));
            return;
        L13:
            r104 = FFITypes.access$1400();
            goto L14
        L17:
            throw new Error("FFI types not initialized");
        L19:
            throw new Error("Native library not initialized");
        }

        public FFIType() {
            this.type = 13;
        }

        public FFIType(Structure r110) {
            this.type = 13;
            Structure.access$2300(r110, true);
            int r100 = 0;
            if ((r110 instanceof Union) == false) goto L38;
            Iterator<StructField> r101 = r110.fields().values().iterator();
            FFIType r102 = null;
            int r103 = 0;
            boolean r104 = false;
        L6:
            if (r101.hasNext() == false) goto L18;
            StructField r105 = r101.next();
            FFIType r106 = r110.getFieldTypeInfo(r105);
            if (isIntegerType(r106) == false) goto L10;
            r104 = true;
        L10:
            if (r102 == null) goto L16;
            int r107 = r105.size;
            if (r103 < r107) goto L16;
            if (r103 != r107) goto L6;
            if (Structure.class.isAssignableFrom(r105.type) == false) goto L6;
        L16:
            r103 = r105.size;
            r102 = r106;
            goto L6
        L18:
            if (Platform.isIntel() == false) goto L24;
            if (Platform.is64Bit() == false) goto L24;
            if (Platform.isWindows() == true) goto L24;
        L27:
            if (r104 == true) goto L29;
        L37:
            Pointer[] r108 = {r102.getPointer(), null};
            unionHelper.put(r110.getClass(), r102);
        L42:
            init(r108);
            write();
            return;
        L29:
            if (isFloatType(r102) == false) goto L37;
            FFIType r109 = new FFIType(r102);
            if (r109.size.intValue() != 4) goto L34;
            r109.type = ffiTypeInfo.get(FFITypes.access$1400()).type;
        L36:
            r109.write();
            r102 = r109;
            goto L37
        L34:
            if (r109.size.intValue() != 8) goto L36;
            r109.type = ffiTypeInfo.get(FFITypes.access$1600()).type;
        L24:
            if (Platform.isARM() == true) goto L27;
            if (Platform.isLoongArch() == false) goto L37;
        L38:
            r108 = new Pointer[r110.fields().size() + 1];
            Iterator<StructField> r111 = r110.fields().values().iterator();
        L40:
            if (r111.hasNext() == false) goto L42;
            r108[r100] = r110.getFieldTypeInfo(r111.next()).getPointer();
            r100 = r100 + 1;
            goto L40
        }

        public static FFIType get(Object r100) {
            if (r100 != null) goto L12;
            Map<Class, Map<Integer, FFIType>> r101 = typeInfoMap;
            monitor-enter(r101);
            FFIType r102 = getTypeInfo(Pointer.class, 0);     // Catch: Throwable -> L8
            monitor-exit(r101);     // Catch: Throwable -> L8
            return r102;
        L8:
            th = move-exception;
            throw th;
        L12:
            if ((r100 instanceof Class) == false) goto L16;
            return get(null, (Class) r100);
        L16:
            return get(r100, r100.getClass());
        }

        private void init(Pointer[] r100) {
            Memory r101 = new Memory(Native.POINTER_SIZE * r100.length);
            this.elements = r101;
            r101.write(0, r100, 0, r100.length);
            write();
        }

        private static boolean isFloatType(FFIType r100) {
            Pointer r101 = r100.getPointer();
            if (r101.equals(FFITypes.access$1900()) == false) goto L5;
        L8:
            return true;
        L5:
            if (r101.equals(FFITypes.access$2000()) == true) goto L8;
            return false;
        }

        private static boolean isIntegerType(FFIType r100) {
            Pointer r101 = r100.getPointer();
            if (r101.equals(FFITypes.access$1000()) == false) goto L5;
        L22:
            return true;
        L5:
            if (r101.equals(FFITypes.access$1100()) == true) goto L22;
            if (r101.equals(FFITypes.access$1200()) == true) goto L22;
            if (r101.equals(FFITypes.access$1300()) == true) goto L22;
            if (r101.equals(FFITypes.access$1400()) == true) goto L22;
            if (r101.equals(FFITypes.access$1500()) == true) goto L22;
            if (r101.equals(FFITypes.access$1600()) == true) goto L22;
            if (r101.equals(FFITypes.access$1700()) == true) goto L22;
            if (r101.equals(FFITypes.access$1800()) == true) goto L22;
            return false;
        }

        public FFIType(FFIType r100) {
            this.type = 13;
            this.size = r100.size;
            this.alignment = r100.alignment;
            this.type = r100.type;
            this.elements = r100.elements;
        }

        public FFIType(Object r100, Class<?> r101) {
            this.type = 13;
            int r102 = Array.getLength(r100);
            Pointer[] r103 = new Pointer[r102 + 1];
            Pointer r104 = get(null, r101.getComponentType()).getPointer();
            int r105 = 0;
        L3:
            if (r105 >= r102) goto L5;
            r103[r105] = r104;
            r105 = r105 + 1;
            goto L3
        L5:
            init(r103);
            write();
        }

        public static /* synthetic */ FFIType access$900(Object r100, Class r101) {
            return get(r100, r101);
        }

        private static FFIType get(Object r100, Class<?> r101) {
            TypeMapper r102 = Native.getTypeMapper(r101);
            if (r102 == null) goto L7;
            ToNativeConverter r103 = r102.getToNativeConverter(r101);
            if (r103 == null) goto L7;
            r101 = r103.nativeType();
        L7:
            Map<Class, Map<Integer, FFIType>> r104 = typeInfoMap;
            monitor-enter(r104);
        L50:
            th = move-exception;
            throw th;
        L10:
            if (r101.isArray() == false) goto L12;
            int r105 = Array.getLength(r100);     // Catch: Throwable -> L50
        L13:
            FFIType r106 = getTypeInfo(r101, r105);     // Catch: Throwable -> L50
            if (r106 == null) goto L18;
            monitor-exit(r104);     // Catch: Throwable -> L50
            return r106;
        L18:
            if (Platform.HAS_BUFFERS == false) goto L22;
            if (Buffer.class.isAssignableFrom(r101) == false) goto L22;
        L23:
            r104.put(r101, r104.get(Pointer.class));     // Catch: Throwable -> L50
            FFIType r107 = r104.get(Pointer.class).get(0);     // Catch: Throwable -> L50
            monitor-exit(r104);     // Catch: Throwable -> L50
            return r107;
        L22:
            if (Callback.class.isAssignableFrom(r101) == true) goto L23;
            if (Structure.class.isAssignableFrom(r101) == false) goto L39;
            if (r100 != null) goto L31;
            r100 = Structure.newInstance(r101, Structure.access$2400());     // Catch: Throwable -> L50
        L31:
            if (ByReference.class.isAssignableFrom(r101) == false) goto L35;
            r104.put(r101, r104.get(Pointer.class));     // Catch: Throwable -> L50
            FFIType r108 = r104.get(Pointer.class).get(0);     // Catch: Throwable -> L50
            monitor-exit(r104);     // Catch: Throwable -> L50
            return r108;
        L35:
            FFIType r109 = new FFIType((Structure) r100);     // Catch: Throwable -> L50
            storeTypeInfo(r101, r109);     // Catch: Throwable -> L50
            monitor-exit(r104);     // Catch: Throwable -> L50
            return r109;
        L39:
            if (NativeMapped.class.isAssignableFrom(r101) == false) goto L44;
            NativeMappedConverter r110 = NativeMappedConverter.getInstance(r101);     // Catch: Throwable -> L50
            FFIType r111 = get(r110.toNative(r100, new ToNativeContext()), r110.nativeType());     // Catch: Throwable -> L50
            monitor-exit(r104);     // Catch: Throwable -> L50
            return r111;
        L44:
            if (r101.isArray() == false) goto L49;
            FFIType r112 = new FFIType(r100, r101);     // Catch: Throwable -> L50
            storeTypeInfo(r101, Array.getLength(r100), r112);     // Catch: Throwable -> L50
            monitor-exit(r104);     // Catch: Throwable -> L50
            return r112;
        L49:
            throw new IllegalArgumentException("Unsupported type " + r101);     // Catch: Throwable -> L50
        L12:
            r105 = 0;
            goto L13
        }

        private static FFIType getTypeInfo(Class r100, int r101) {
            Map<Integer, FFIType> r102 = typeInfoMap.get(r100);
            if (r102 != null) goto L5;
            return null;
        L5:
            return r102.get(Integer.valueOf(r101));
        }

        private static void storeTypeInfo(Class r100, FFIType r101) {
            storeTypeInfo(r100, 0, r101);
        }

        private static void storeTypeInfo(Class r100, int r101, FFIType r102) {
            Map<Class, Map<Integer, FFIType>> r103 = typeInfoMap;
            monitor-enter(r103);
            Map<Integer, FFIType> r104 = r103.get(r100);     // Catch: Throwable -> L10
            if (r104 != null) goto L7;
            r104 = new HashMap();     // Catch: Throwable -> L10
            r103.put(r100, r104);     // Catch: Throwable -> L10
        L7:
            r104.put(Integer.valueOf(r101), r102);     // Catch: Throwable -> L10
            monitor-exit(r103);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    @Target({ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FieldOrder {
        String[] value();
    }

    public static class LayoutInfo {
        private int alignType;
        private int alignment;
        private final Map<String, StructField> fields;
        private int size;
        private TypeMapper typeMapper;
        private boolean variable;

        private LayoutInfo() {
            this.size = -1;
            this.alignment = 1;
            this.fields = Collections.synchronizedMap(new LinkedHashMap());
            this.alignType = 0;
        }

        public /* synthetic */ LayoutInfo(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ boolean access$200(LayoutInfo r100) {
            return r100.variable;
        }

        public static /* synthetic */ int access$300(LayoutInfo r100) {
            return r100.size;
        }

        public static /* synthetic */ int access$400(LayoutInfo r100) {
            return r100.alignType;
        }

        public static /* synthetic */ TypeMapper access$500(LayoutInfo r100) {
            return r100.typeMapper;
        }

        public static /* synthetic */ int access$600(LayoutInfo r100) {
            return r100.alignment;
        }

        public static /* synthetic */ Map access$700(LayoutInfo r100) {
            return r100.fields;
        }

        public static /* synthetic */ boolean access$202(LayoutInfo r100, boolean r101) {
            r100.variable = r101;
            return r101;
        }

        public static /* synthetic */ int access$302(LayoutInfo r100, int r101) {
            r100.size = r101;
            return r101;
        }

        public static /* synthetic */ int access$402(LayoutInfo r100, int r101) {
            r100.alignType = r101;
            return r101;
        }

        public static /* synthetic */ TypeMapper access$502(LayoutInfo r100, TypeMapper r101) {
            r100.typeMapper = r101;
            return r101;
        }

        public static /* synthetic */ int access$602(LayoutInfo r100, int r101) {
            r100.alignment = r101;
            return r101;
        }
    }

    public static class NativeStringTracking {
        private NativeString peer;
        private final Object value;

        public NativeStringTracking(Object r100) {
            this.value = r100;
        }

        public static /* synthetic */ NativeString access$000(NativeStringTracking r100) {
            return r100.peer;
        }

        public static /* synthetic */ Object access$100(NativeStringTracking r100) {
            return r100.value;
        }

        public static /* synthetic */ NativeString access$002(NativeStringTracking r100, NativeString r101) {
            r100.peer = r101;
            return r101;
        }
    }

    public static class StructField {
        public FromNativeContext context;
        public Field field;
        public boolean isReadOnly;
        public boolean isVolatile;
        public String name;
        public int offset;
        public FromNativeConverter readConverter;
        public int size;
        public Class<?> type;
        public ToNativeConverter writeConverter;

        public String toString() {
            return this.name + "@" + this.offset + "[" + this.size + "] (" + this.type + ")";
        }

        public StructField() {
            this.size = -1;
            this.offset = -1;
        }
    }

    public static class StructureSet extends AbstractCollection<Structure> implements Set<Structure> {
        private int count;
        Structure[] elements;

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Structure> iterator() {
            int r100 = this.count;
            Structure[] r101 = new Structure[r100];
            if (r100 <= 0) goto L6;
            System.arraycopy(this.elements, 0, r101, 0, r100);
        L6:
            return Arrays.asList(r101).iterator();
        }

        public StructureSet() {
        }

        public Structure[] getElements() {
            return this.elements;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.count;
        }

        private void ensureCapacity(int r100) {
            Structure[] r101 = this.elements;
            if (r101 != null) goto L6;
            this.elements = new Structure[(r100 * 3) / 2];
            return;
        L6:
            if (r101.length >= r100) goto L10;
            Structure[] r102 = new Structure[(r100 * 3) / 2];
            System.arraycopy(r101, 0, r102, 0, r101.length);
            this.elements = r102;
            return;
        }

        private int indexOf(Structure r100) {
            int r101 = 0;
        L4:
            if (r101 >= this.count) goto L16;
            Structure r102 = this.elements[r101];
            if (r100 == r102) goto L15;
            if (r100.getClass() != r102.getClass()) goto L14;
            if (r100.size() != r102.size()) goto L14;
            if (r100.getPointer().equals(r102.getPointer()) == true) goto L15;
        L14:
            r101 = r101 + 1;
        L15:
            return r101;
        L16:
            return -1;
        }

        public boolean add(Structure r100) {
            if (contains(r100) == true) goto L6;
            ensureCapacity(this.count + 1);
            Structure[] r101 = this.elements;
            int r102 = this.count;
            this.count = r102 + 1;
            r101[r102] = r100;
            return true;
        L6:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object r100) {
            if (indexOf((Structure) r100) == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r100) {
            int r101 = indexOf((Structure) r100);
            if (r101 == (-1)) goto L8;
            int r102 = this.count - 1;
            this.count = r102;
            if (r102 < 0) goto L7;
            Structure[] r103 = this.elements;
            r103[r101] = r103[r102];
            r103[r102] = null;
        L7:
            return true;
        L8:
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* bridge */ /* synthetic */ boolean add(Object r100) {
            return add((Structure) r100);
        }
    }

    public Structure() {
        this(0);
    }

    public void allocateMemory() {
        allocateMemory(false);
    }

    public void ensureAllocated() {
        ensureAllocated(false);
    }

    static {
        LOG = Logger.getLogger(Structure.class.getName());
        layoutInfo = new WeakHashMap();
        fieldOrder = new WeakHashMap();
        reads = new AnonymousClass1();
        busy = new AnonymousClass2();
        final long r100 = 0;
        PLACEHOLDER_MEMORY = new AnonymousClass3(r100);
    }

    private Class<?> baseClass() {
        if ((this instanceof ByReference) == true) goto L7;
        if ((this instanceof ByValue) == true) goto L7;
    L11:
        return getClass();
    L7:
        if (Structure.class.isAssignableFrom(getClass().getSuperclass()) == false) goto L11;
        return getClass().getSuperclass();
    }

    public static Set<Structure> busy() {
        return busy.get();
    }

    private void layoutChanged() {
        if (this.size == (-1)) goto L9;
        this.size = -1;
        if ((this.memory instanceof AutoAllocated) == false) goto L7;
        this.memory = null;
    L7:
        ensureAllocated();
        return;
    }

    public static Map<Pointer, Structure> reading() {
        return reads.get();
    }

    public void conditionalAutoRead() {
        if (this.readCalled == true) goto L6;
        autoRead();
        return;
    }

    public List<Field> getFieldList() {
        ArrayList r100 = new ArrayList();
        Class<?> r101 = getClass();
    L4:
        if (r101.equals(Structure.class) == true) goto L16;
        ArrayList r102 = new ArrayList();
        Field[] r103 = r101.getDeclaredFields();
        int r104 = 0;
    L7:
        if (r104 >= r103.length) goto L15;
        int r105 = r103[r104].getModifiers();
        if (Modifier.isStatic(r105) == true) goto L14;
        if (Modifier.isPublic(r105) == false) goto L14;
        r102.add(r103[r104]);
    L14:
        r104 = r104 + 1;
        goto L7
    L15:
        r100.addAll(0, r102);
        r101 = r101.getSuperclass();
        goto L4
    L16:
        return r100;
    }

    public List<String> getFieldOrder() {
        LinkedList r100 = new LinkedList();
        Class<?> r101 = getClass();
    L4:
        if (r101 == Structure.class) goto L10;
        FieldOrder r102 = (FieldOrder) r101.getAnnotation(FieldOrder.class);
        if (r102 == null) goto L8;
        r100.addAll(0, Arrays.asList(r102.value()));
    L8:
        r101 = r101.getSuperclass();
        goto L4
    L10:
        return Collections.unmodifiableList(r100);
    }

    public int getStructAlignment() {
        if (this.size != (-1)) goto L6;
        calculateSize(true);
    L6:
        return this.structAlignment;
    }

    public void read() {
        if (this.memory != PLACEHOLDER_MEMORY) goto L5;
        return;
    L5:
        this.readCalled = true;
        ensureAllocated();
        if (busy().add(this) == true) goto L8;
        return;
    L8:
        boolean r100 = this instanceof ByReference;
        if (r100 == false) goto L29;
        reading().put(getPointer(), this);
    L29:
        Iterator<StructField> r101 = fields().values().iterator();     // Catch: Throwable -> L22
    L13:
        if (r101.hasNext() == false) goto L16;
        readField(r101.next());     // Catch: Throwable -> L22
        goto L13
    L16:
        busy().remove(this);
        if (r100 == true) goto L19;
        return;
    L19:
        if (reading().get(getPointer()) != this) goto L34;
        reading().remove(getPointer());
        return;
    L34:
        return;
    L22:
        th = move-exception;
        busy().remove(this);
        if (r100 == true) goto L26;
    L28:
        throw th;
    L26:
        if (reading().get(getPointer()) != this) goto L28;
        reading().remove(getPointer());
        goto L28
    }

    public String toString() {
        return toString(Boolean.getBoolean("jna.dump_memory"));
    }

    public void write() {
        if (this.memory != PLACEHOLDER_MEMORY) goto L5;
        return;
    L5:
        ensureAllocated();
        if ((this instanceof ByValue) == false) goto L9;
        getTypeInfo();
    L9:
        if (busy().add(this) == true) goto L23;
        return;
    L23:
        Iterator<StructField> r100 = fields().values().iterator();     // Catch: Throwable -> L20
    L13:
        if (r100.hasNext() == false) goto L18;
        StructField r101 = r100.next();     // Catch: Throwable -> L20
        if (r101.isVolatile == true) goto L13;
        writeField(r101);     // Catch: Throwable -> L20
        goto L13
    L18:
        busy().remove(this);
        return;
    L20:
        th = move-exception;
        busy().remove(this);
        throw th;
    }

    private List<String> fieldOrder() {
        Class<?> r100 = getClass();
        Map<Class<?>, List<String>> r101 = fieldOrder;
        monitor-enter(r101);
        List<String> r102 = r101.get(r100);     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        r102 = getFieldOrder();     // Catch: Throwable -> L9
        r101.put(r100, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    private void initializeFields() {
        Iterator<Field> r100 = getFieldList().iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        Field r101 = r100.next();
    L10:
        e = move-exception;
        throw new Error("Exception reading field '" + r101.getName() + "' in " + getClass(), e);
    L7:
        if (r101.get(this) != null) goto L4;
        initializeField(r101, r101.getType());     // Catch: Exception -> L10
        goto L4
    }

    private void validateFields() {
        Iterator<Field> r100 = getFieldList().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        Field r101 = r100.next();
        validateField(r101.getName(), r101.getType());
        goto L4
    }

    public void autoRead() {
        if (getAutoRead() == false) goto L10;
        read();
        if (this.array == null) goto L12;
        int r100 = 1;
    L7:
        Structure[] r101 = this.array;
        if (r100 >= r101.length) goto L13;
        r101[r100].autoRead();
        r100 = r100 + 1;
        goto L7
    L13:
        return;
    L12:
        return;
    }

    public void autoWrite() {
        if (getAutoWrite() == false) goto L10;
        write();
        if (this.array == null) goto L12;
        int r100 = 1;
    L7:
        Structure[] r101 = this.array;
        if (r100 >= r101.length) goto L13;
        r101[r100].autoWrite();
        r100 = r100 + 1;
        goto L7
    L13:
        return;
    L12:
        return;
    }

    public void clear() {
        ensureAllocated();
        this.nativeStrings.clear();
        this.memory.clear(size());
    }

    public Pointer getPointer() {
        ensureAllocated();
        return this.memory;
    }

    public Pointer getTypeInfo() {
        Pointer r100 = getTypeInfo(this).getPointer();
        cacheTypeInfo(r100);
        return r100;
    }

    public int hashCode() {
        if (getPointer() == null) goto L7;
        return getPointer().hashCode();
    L7:
        return getClass().hashCode();
    }

    public int size() {
        ensureAllocated();
        return this.size;
    }

    public static /* synthetic */ Pointer access$2400() {
        return PLACEHOLDER_MEMORY;
    }

    public Map<String, StructField> fields() {
        return this.structFields;
    }

    public boolean getAutoRead() {
        return this.autoRead;
    }

    public boolean getAutoWrite() {
        return this.autoWrite;
    }

    public String getStringEncoding() {
        return this.encoding;
    }

    public TypeMapper getTypeMapper() {
        return this.typeMapper;
    }

    public Structure(TypeMapper r100) {
        this(null, 0, r100);
    }

    private int addPadding(int r100) {
        return addPadding(r100, this.structAlignment);
    }

    public static void autoRead(Structure[] r100) {
        structureArrayCheck(r100);
        int r101 = 0;
        Structure r102 = r100[0];
        if (r102.array != r100) goto L6;
        r102.autoRead();
        return;
    L6:
        if (r101 >= r100.length) goto L15;
        Structure r103 = r100[r101];
        if (r103 == null) goto L10;
        r103.autoRead();
    L10:
        r101 = r101 + 1;
        goto L6
    }

    public static void autoWrite(Structure[] r100) {
        structureArrayCheck(r100);
        int r101 = 0;
        Structure r102 = r100[0];
        if (r102.array != r100) goto L6;
        r102.autoWrite();
        return;
    L6:
        if (r101 >= r100.length) goto L15;
        Structure r103 = r100[r101];
        if (r103 == null) goto L10;
        r103.autoWrite();
    L10:
        r101 = r101 + 1;
        goto L6
    }

    public static List<String> createFieldsOrder(String r100) {
        return Collections.unmodifiableList(Collections.singletonList(r100));
    }

    private void ensureAllocated(boolean r100) {
        if (this.memory != null) goto L6;
        allocateMemory(r100);
        return;
    L6:
        if (this.size != (-1)) goto L18;
        int r101 = calculateSize(true, r100);
        this.size = r101;
        Pointer r102 = this.memory;
        if ((r102 instanceof AutoAllocated) == false) goto L16;
        return;
    L16:
        this.memory = r102.share(0, r101);     // Catch: IndexOutOfBoundsException -> L12
        return;
    L12:
        e = move-exception;
        throw new IllegalArgumentException("Structure exceeds provided memory bounds", e);
    }

    private String format(Class<?> r100) {
        String r101 = r100.getName();
        return r101.substring(r101.lastIndexOf(".") + 1);
    }

    private static <T> Constructor<T> getPointerConstructor(Class<T> r100) {
        Object[] r101 = r100.getConstructors();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        Constructor<T> r104 = (Constructor<T>) r101[r103];
        Class<?>[] r105 = r104.getParameterTypes();
        if (r105.length != 1) goto L9;
        if (r105[0].equals(Pointer.class) == false) goto L9;
        return r104;
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        return null;
    }

    public static FFIType getTypeInfo(Object r100) {
        return FFIType.get(r100);
    }

    private void initializeTypeMapper(TypeMapper r100) {
        if (r100 != null) goto L4;
        r100 = Native.getTypeMapper(getClass());
    L4:
        this.typeMapper = r100;
        layoutChanged();
    }

    public static <T extends Structure> T newInstance(Class<T> r100) throws IllegalArgumentException {
        T r101 = (T) Klass.newInstance(r100);
        if ((r101 instanceof ByValue) == false) goto L5;
        r101.allocateMemory();
    L5:
        return r101;
    }

    public static int size(Class<? extends Structure> r100) {
        return size(r100, null);
    }

    private static <T extends Comparable<T>> List<T> sort(Collection<? extends T> r100) {
        ArrayList r101 = new ArrayList(r100);
        Collections.sort(r101);
        return r101;
    }

    private static void structureArrayCheck(Structure[] r100) {
        if (ByReference[].class.isAssignableFrom(r100.getClass()) == false) goto L5;
        return;
    L5:
        Pointer r101 = r100[0].getPointer();
        int r102 = r100[0].size();
        int r103 = 1;
    L7:
        if (r103 >= r100.length) goto L13;
        if (r100[r103].getPointer().peer != (r101.peer + ((long) (r102 * r103)))) goto L12;
        r103 = r103 + 1;
        goto L7
    L12:
        throw new IllegalArgumentException("Structure array elements must use contiguous memory (bad backing address at Structure array index " + r103 + ")");
    }

    public static void validate(Class<? extends Structure> r100) {
        r100.getConstructor(new Class[0]);     // Catch: Throwable -> L5
        return;
    L6:
        throw new IllegalArgumentException("No suitable constructor found for class: ".concat(r100.getName()));
    }

    public void allocateMemory(int r100) {
        if (r100 != (-1)) goto L5;
        r100 = calculateSize(false);
    L6:
        if (r100 == (-1)) goto L16;
        Pointer r101 = this.memory;
        if (r101 != null) goto L10;
    L11:
        this.memory = autoAllocate(r100);
    L12:
        this.size = r100;
        return;
    L10:
        if ((r101 instanceof AutoAllocated) == false) goto L12;
    L16:
        return;
    L5:
        if (r100 > 0) goto L6;
        throw new IllegalArgumentException("Structure size must be greater than zero: " + r100);
    }

    public Memory autoAllocate(int r100) {
        return new AutoAllocated(r100);
    }

    public void cacheTypeInfo(Pointer r100) {
        this.typeInfo = r100.peer;
    }

    public int calculateSize(boolean r100) {
        return calculateSize(r100, false);
    }

    public boolean dataEquals(Structure r100) {
        return dataEquals(r100, false);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof Structure) == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.getClass() != getClass()) goto L9;
        if (((Structure) r100).getPointer().equals(getPointer()) == false) goto L9;
        return true;
    }

    public int fieldOffset(String r100) {
        ensureAllocated();
        StructField r101 = fields().get(r100);
        if (r101 == null) goto L7;
        return r101.offset;
    L7:
        throw new IllegalArgumentException("No such field: " + r100);
    }

    public FFIType getFieldTypeInfo(StructField r100) {
        Class<?> r101 = r100.type;
        Object r102 = getFieldValue(r100.field);
        TypeMapper r103 = this.typeMapper;
        if (r103 == null) goto L8;
        ToNativeConverter r104 = r103.getToNativeConverter(r101);
        if (r104 == null) goto L8;
        r101 = r104.nativeType();
        r102 = r104.toNative(r102, new ToNativeContext());
    L8:
        return FFIType.access$900(r102, r101);
    }

    public Object getFieldValue(Field r100) {
        return r100.get(this);
    L4:
        e = move-exception;
        throw new Error("Exception reading field '" + r100.getName() + "' in " + getClass(), e);
    }

    public List<Field> getFields(boolean r100) {
        List<Field> r101 = getFieldList();
        HashSet r102 = new HashSet();
        Iterator<Field> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(r103.next().getName());
        goto L4
    L6:
        List<String> r104 = fieldOrder();
        if (r104.size() == r101.size()) goto L20;
        if (r101.size() <= 1) goto L20;
        if (r100 == false) goto L17;
        StringBuilder r105 = new StringBuilder("Structure.getFieldOrder() on ");
        r105.append(getClass());
        if (r104.size() >= r101.size()) goto L14;
        String r106 = " does not provide enough";
    L15:
        r105.append(r106);
        r105.append(" names [");
        r105.append(r104.size());
        r105.append("] (");
        r105.append(sort(r104));
        r105.append(") to match declared fields [");
        r105.append(r101.size());
        r105.append("] (");
        r105.append(sort(r102));
        r105.append(")");
        throw new Error(r105.toString());
    L14:
        r106 = " provides too many";
        goto L15
    L17:
        return null;
    L20:
        if (new HashSet(r104).equals(r102) == false) goto L24;
        sortFields(r101, r104);
        return r101;
    L24:
        throw new Error("Structure.getFieldOrder() on " + getClass() + " returns names (" + sort(r104) + ") which do not match declared field names (" + sort(r102) + ")");
    }

    public int getNativeSize(Class<?> r100) {
        return getNativeSize(r100, null);
    }

    public Object readField(StructField r100) {
        int r101 = r100.offset;
        Class<?> r102 = r100.type;
        FromNativeConverter r103 = r100.readConverter;
        if (r103 == null) goto L5;
        r102 = r103.nativeType();
    L5:
        Object r104 = null;
        if (Structure.class.isAssignableFrom(r102) == false) goto L8;
    L21:
        Object r105 = getFieldValue(r100.field);
    L23:
        if (r102 != String.class) goto L28;
        Pointer r106 = this.memory.getPointer(r101);
        if (r106 == null) goto L29;
        r104 = r106.getString(0, this.encoding);
    L29:
        if (r103 == null) goto L36;
        Object r107 = r103.fromNative(r104, r100.context);
        if (r105 != null) goto L33;
    L35:
        r105 = r107;
    L38:
        if (r102.equals(String.class) == false) goto L40;
    L41:
        if (r105 == null) goto L45;
        NativeStringTracking r108 = new NativeStringTracking(r105);
        NativeStringTracking r109 = this.nativeStrings.put(r100.name, r108);
        if (r109 == null) goto L46;
        NativeStringTracking.access$002(r108, NativeStringTracking.access$000(r109));
    L46:
        setFieldValue(r100.field, r105, true);
        return r105;
    L45:
        this.nativeStrings.remove(r100.name);
        goto L46
    L40:
        if (r102.equals(WString.class) == false) goto L46;
    L33:
        if (r105.equals(r107) == false) goto L35;
    L36:
        r105 = r104;
        goto L38
    L28:
        r104 = this.memory.getValue(r101, r102, r105);
        goto L29
    L8:
        if (Callback.class.isAssignableFrom(r102) == true) goto L21;
        if (Platform.HAS_BUFFERS == false) goto L14;
        if (Buffer.class.isAssignableFrom(r102) == true) goto L21;
    L14:
        if (Pointer.class.isAssignableFrom(r102) == true) goto L21;
        if (NativeMapped.class.isAssignableFrom(r102) == true) goto L21;
        if (r102.isArray() == true) goto L21;
        r105 = null;
        goto L23
    }

    public void setAlignType(int r100) {
        this.alignType = r100;
        if (r100 != 0) goto L10;
        r100 = Native.getStructureAlignment(getClass());
        if (r100 != 0) goto L10;
        if (Platform.isWindows() == false) goto L9;
        r100 = 3;
        goto L10
    L9:
        r100 = 2;
    L10:
        this.actualAlignType = r100;
        layoutChanged();
    }

    public void setAutoRead(boolean r100) {
        this.autoRead = r100;
    }

    public void setAutoSynch(boolean r100) {
        setAutoRead(r100);
        setAutoWrite(r100);
    }

    public void setAutoWrite(boolean r100) {
        this.autoWrite = r100;
    }

    public void setStringEncoding(String r100) {
        this.encoding = r100;
    }

    public Structure[] toArray(Structure[] r100) {
        ensureAllocated();
        Pointer r101 = this.memory;
        if ((r101 instanceof AutoAllocated) == false) goto L7;
        int r102 = r100.length * size();
        if (((Memory) r101).size() >= r102) goto L7;
        useMemory(autoAllocate(r102));
    L7:
        r100[0] = this;
        int r103 = size();
        int r104 = 1;
    L9:
        if (r104 >= r100.length) goto L12;
        Structure r105 = newInstance(getClass(), this.memory.share(r104 * r103, r103));
        r100[r104] = r105;
        r105.conditionalAutoRead();
        r104 = r104 + 1;
        goto L9
    L12:
        if ((this instanceof ByValue) == true) goto L14;
        this.array = r100;
    L14:
        return r100;
    }

    public String toString(boolean r100) {
        return toString(0, true, r100);
    }

    public void useMemory(Pointer r100) {
        useMemory(r100, 0);
    }

    public void writeField(String r100) {
        ensureAllocated();
        StructField r101 = fields().get(r100);
        if (r101 == null) goto L7;
        writeField(r101);
        return;
    L7:
        throw new IllegalArgumentException("No such field: " + r100);
    }

    public Structure(int r100) {
        this(null, r100);
    }

    private void allocateMemory(boolean r100) {
        allocateMemory(calculateSize(true, r100));
    }

    public static List<String> createFieldsOrder(String... r100) {
        return Collections.unmodifiableList(Arrays.asList(r100));
    }

    public Object readField(String r100) {
        ensureAllocated();
        StructField r101 = fields().get(r100);
        if (r101 == null) goto L7;
        return readField(r101);
    L7:
        throw new IllegalArgumentException("No such field: " + r100);
    }

    public Structure[] toArray(int r100) {
        return toArray((Structure[]) Array.newInstance(getClass(), r100));
    }

    public void writeField(StructField r100) {
        if (r100.isReadOnly == false) goto L5;
        return;
    L5:
        writeField(r100, getFieldValue(r100.field));
    }

    public Structure(Pointer r100) {
        this(r100, 0);
    }

    public Structure(int r100, TypeMapper r101) {
        this(null, r100, r101);
    }

    public static /* synthetic */ void access$2300(Structure r100, boolean r101) {
        r100.ensureAllocated(r101);
    }

    private int addPadding(int r100, int r101) {
        if (this.actualAlignType == 1) goto L8;
        int r102 = r100 % r101;
        if (r102 != 0) goto L7;
        return r100;
    L7:
        return r100 + (r101 - r102);
    L8:
        return r100;
    }

    public static List<String> createFieldsOrder(List<String> r100, List<String> r101) {
        ArrayList r102 = new ArrayList(r100.size() + r101.size());
        r102.addAll(r100);
        r102.addAll(r101);
        return Collections.unmodifiableList(r102);
    }

    private LayoutInfo deriveLayout(boolean r110, boolean r111) {
        List<Field> r100 = getFields(r110);
        AnonymousClass1 r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        LayoutInfo r102 = new LayoutInfo(r101);
        LayoutInfo.access$402(r102, this.alignType);
        LayoutInfo.access$502(r102, this.typeMapper);
        Iterator<Field> r103 = r100.iterator();
        boolean r104 = true;
        int r105 = 0;
        boolean r106 = true;
    L7:
        if (r103.hasNext() == false) goto L84;
        Field r107 = r103.next();
        int r108 = r107.getModifiers();
        Class<?> r112 = r107.getType();
        if (r112.isArray() == false) goto L11;
        LayoutInfo.access$202(r102, r104);
    L11:
        StructField r113 = new StructField();
        r113.isVolatile = Modifier.isVolatile(r108);
        boolean r109 = Modifier.isFinal(r108);
        r113.isReadOnly = r109;
        if (r109 == true) goto L14;
    L18:
        r113.field = r107;
        r113.name = r107.getName();
        r113.type = r112;
        if (Callback.class.isAssignableFrom(r112) == false) goto L26;
        if (r112.isInterface() == true) goto L26;
        throw new IllegalArgumentException("Structure Callback field '" + r107.getName() + "' must be an interface");
    L26:
        if (r112.isArray() == false) goto L33;
        if (Structure.class.equals(r112.getComponentType()) == false) goto L33;
        throw new IllegalArgumentException("Nested Structure arrays must use a derived Structure type so that the size of the elements can be determined");
    L33:
        if (Modifier.isPublic(r107.getModifiers()) == false) goto L74;
        Object r114 = getFieldValue(r113.field);
        if (r114 != null) goto L44;
        if (r112.isArray() == false) goto L44;
        if (r110 == true) goto L42;
        return null;
    L42:
        throw new IllegalStateException("Array fields must be initialized");
    L44:
        if (NativeMapped.class.isAssignableFrom(r112) == false) goto L46;
        NativeMappedConverter r115 = NativeMappedConverter.getInstance(r112);
        Class<?> r116 = r115.nativeType();
        r113.writeConverter = r115;
        r113.readConverter = r115;
        r113.context = new StructureReadContext(this, r107);
    L62:
        if (r114 != null) goto L93;
        r114 = initializeField(r113.field, r112);
    L93:
        r113.size = getNativeSize(r116, r114);     // Catch: IllegalArgumentException -> L77
        int r117 = getNativeAlignment(r116, r114, r106);     // Catch: IllegalArgumentException -> L77
        if (r117 == 0) goto L76;
        LayoutInfo.access$602(r102, Math.max(LayoutInfo.access$600(r102), r117));
        int r118 = r105 % r117;
        if (r118 == 0) goto L70;
        r105 = r105 + (r117 - r118);
    L70:
        if ((this instanceof Union) == false) goto L72;
        r113.offset = 0;
        r105 = Math.max(r105, r113.size);
    L73:
        LayoutInfo.access$700(r102).put(r113.name, r113);
        goto L74
    L72:
        r113.offset = r105;
        r105 = r105 + r113.size;
        goto L73
    L76:
        throw new Error("Field alignment is zero for field '" + r113.name + "' within " + getClass());
    L77:
        e = move-exception;
        if (r110 == true) goto L83;
        if (this.typeMapper != null) goto L83;
        return null;
    L83:
        throw new IllegalArgumentException("Invalid Structure field in " + getClass() + ", field name '" + r113.name + "' (" + r113.type + "): " + e.getMessage(), e);
    L46:
        TypeMapper r119 = this.typeMapper;
        if (r119 == null) goto L61;
        ToNativeConverter r120 = r119.getToNativeConverter(r112);
        FromNativeConverter r121 = this.typeMapper.getFromNativeConverter(r112);
        if (r120 == null) goto L56;
        if (r121 == null) goto L56;
        r114 = r120.toNative(r114, new StructureWriteContext(this, r113.field));
        if (r114 == null) goto L54;
        Class<?> r122 = r114.getClass();
    L55:
        r113.writeConverter = r120;
        r113.readConverter = r121;
        r113.context = new StructureReadContext(this, r107);
        r116 = r122;
        goto L62
    L54:
        r122 = Pointer.class;
    L56:
        if (r120 != null) goto L60;
        if (r121 == null) goto L61;
    L60:
        throw new IllegalArgumentException("Structures require bidirectional type conversion for " + r112);
    L61:
        r116 = r112;
    L74:
        r104 = true;
        r106 = false;
        goto L7
    L14:
        if (Platform.RO_FIELDS == false) goto L17;
        r107.setAccessible(r104);
        goto L18
    L17:
        throw new IllegalArgumentException("This VM does not support read-only fields (field '" + r107.getName() + "' within " + getClass() + ")");
    L84:
        if (r105 <= 0) goto L92;
        int r123 = addPadding(r105, LayoutInfo.access$600(r102));
        if ((this instanceof ByValue) == false) goto L89;
        if (r111 == true) goto L89;
        getTypeInfo();
    L89:
        LayoutInfo.access$302(r102, r123);
        return r102;
    L92:
        throw new IllegalArgumentException("Structure " + getClass() + " has unknown or zero size (ensure all fields are public)");
    }

    private Object initializeField(Field r100, Class<?> r101) {
        if (Structure.class.isAssignableFrom(r101) == false) goto L12;
        if (ByReference.class.isAssignableFrom(r101) == true) goto L12;
        Structure r102 = newInstance(r101, PLACEHOLDER_MEMORY);     // Catch: IllegalArgumentException -> L8
        setFieldValue(r100, r102);     // Catch: IllegalArgumentException -> L8
        return r102;
    L8:
        e = move-exception;
        throw new IllegalArgumentException("Can't determine size of nested structure", e);
    L12:
        if (NativeMapped.class.isAssignableFrom(r101) == false) goto L14;
        NativeMapped r103 = NativeMappedConverter.getInstance(r101).defaultValue();
        setFieldValue(r100, r103);
        return r103;
    L14:
        return null;
    }

    public static <T extends Structure> T newInstance(Class<T> r100, Pointer r101) throws IllegalArgumentException {
        Constructor r102 = getPointerConstructor(r100);     // Catch: InvocationTargetException -> L6 IllegalAccessException -> L9 InstantiationException -> L12 SecurityException -> L15
        if (r102 == null) goto L16;
        return (T) r102.newInstance(new Object[]{r101});
    L9:
        e = move-exception;
        throw new IllegalArgumentException("Instantiation of " + r100 + " (Pointer) not allowed, is it public?", e);
    L12:
        e = move-exception;
        throw new IllegalArgumentException("Can't instantiate " + r100, e);
    L6:
        e = move-exception;
        throw new IllegalArgumentException("Exception thrown while instantiating an instance of " + r100, e);
    L16:
        T r103 = (T) newInstance(r100);
        if (r101 == PLACEHOLDER_MEMORY) goto L19;
        r103.useMemory(r101);
    L19:
        return r103;
    }

    public static <T extends Structure> int size(Class<T> r100, T r101) {
        Map<Class<?>, LayoutInfo> r102 = layoutInfo;
        monitor-enter(r102);
        LayoutInfo r103 = r102.get(r100);     // Catch: Throwable -> L17
        monitor-exit(r102);     // Catch: Throwable -> L17
        if (r103 != null) goto L9;
    L11:
        int r104 = -1;
    L12:
        if (r104 != (-1)) goto L22;
        if (r101 != null) goto L16;
        r101 = (T) newInstance(r100, PLACEHOLDER_MEMORY);
    L16:
        return r101.size();
    L22:
        return r104;
    L9:
        if (LayoutInfo.access$200(r103) == true) goto L11;
        r104 = LayoutInfo.access$300(r103);
    L17:
        th = move-exception;
        throw th;
    }

    private void validateField(String r100, Class<?> r101) {
        TypeMapper r102 = this.typeMapper;
        if (r102 == null) goto L9;
        ToNativeConverter r103 = r102.getToNativeConverter(r101);
        if (r103 == null) goto L9;
        validateField(r100, r103.nativeType());
        return;
    L9:
        if (r101.isArray() == false) goto L16;
        validateField(r100, r101.getComponentType());
        return;
    L16:
        getNativeSize(r101);     // Catch: IllegalArgumentException -> L13
        return;
    L13:
        e = move-exception;
        throw new IllegalArgumentException("Invalid Structure field in " + getClass() + ", field name '" + r100 + "' (" + r101 + "): " + e.getMessage(), e);
    }

    private void writeField(StructField r100, Object r101) {
        int r102 = r100.offset;
        Class<?> r103 = r100.type;
        ToNativeConverter r104 = r100.writeConverter;
        if (r104 == null) goto L6;
        r101 = r104.toNative(r101, new StructureWriteContext(this, r100.field));
        r103 = r104.nativeType();
    L6:
        if (String.class != r103) goto L8;
    L9:
        if (r101 == null) goto L24;
        NativeStringTracking r105 = new NativeStringTracking(r101);
        NativeStringTracking r106 = this.nativeStrings.put(r100.name, r105);
        if (r106 == null) goto L17;
        if (r101.equals(NativeStringTracking.access$100(r106)) == false) goto L17;
        NativeStringTracking.access$002(r105, NativeStringTracking.access$000(r106));
        return;
    L17:
        if (r103 != WString.class) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
        NativeString r108 = new NativeString(r101.toString(), true);
    L23:
        NativeStringTracking.access$002(r105, r108);
        r101 = r108.getPointer();
    L34:
        this.memory.setValue(r102, r101, r103);     // Catch: IllegalArgumentException -> L27
        return;
    L27:
        e = move-exception;
        StringBuilder r109 = new StringBuilder("Structure field \"");
        r109.append(r100.name);
        r109.append("\" was declared as ");
        r109.append(r100.type);
        if (r100.type != r103) goto L31;
        String r110 = "";
    L32:
        r109.append(r110);
        r109.append(", which is not supported within a Structure");
        throw new IllegalArgumentException(r109.toString(), e);
    L31:
        r110 = " (native type " + r103 + ")";
        goto L32
    L22:
        r108 = new NativeString(r101.toString(), this.encoding);
        goto L23
    L19:
        r107 = false;
        goto L20
    L24:
        this.nativeStrings.remove(r100.name);
        goto L34
    L8:
        if (WString.class != r103) goto L34;
        goto L9
    }

    public int calculateSize(boolean r100, boolean r101) {
        Class<?> r102 = getClass();
        Map<Class<?>, LayoutInfo> r103 = layoutInfo;
        monitor-enter(r103);
        LayoutInfo r104 = r103.get(r102);     // Catch: Throwable -> L31
        monitor-exit(r103);     // Catch: Throwable -> L31
        if (r104 != null) goto L8;
    L11:
        r104 = deriveLayout(r100, r101);
    L12:
        if (r104 == null) goto L29;
        this.structAlignment = LayoutInfo.access$600(r104);
        this.structFields = LayoutInfo.access$700(r104);
        if (LayoutInfo.access$200(r104) == true) goto L38;
        monitor-enter(r103);
    L25:
        th = move-exception;
        throw th;
    L17:
        if (r103.containsKey(r102) == true) goto L19;
    L22:
        r103.put(r102, r104);     // Catch: Throwable -> L25
    L23:
        monitor-exit(r103);     // Catch: Throwable -> L25
        goto L38
    L19:
        if (this.alignType != 0) goto L22;
        if (this.typeMapper == null) goto L23;
    L38:
        return LayoutInfo.access$300(r104);
    L29:
        return -1;
    L8:
        if (this.alignType != LayoutInfo.access$400(r104)) goto L11;
        if (this.typeMapper == LayoutInfo.access$500(r104)) goto L12;
    L31:
        th = move-exception;
        throw th;
    }

    public boolean dataEquals(Structure r100, boolean r101) {
        if (r101 == false) goto L4;
        r100.getPointer().clear(r100.size());
        r100.write();
        getPointer().clear(size());
        write();
    L4:
        byte[] r102 = r100.getPointer().getByteArray(0, r100.size());
        byte[] r103 = getPointer().getByteArray(0, size());
        if (r102.length != r103.length) goto L15;
        int r104 = 0;
    L8:
        if (r104 >= r102.length) goto L13;
        if (r102[r104] != r103[r104]) goto L11;
        r104 = r104 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    L15:
        return false;
    }

    public int getNativeSize(Class<?> r100, Object r101) {
        return Native.getNativeSize(r100, r101);
    }

    public void setFieldValue(Field r100, Object r101) {
        setFieldValue(r100, r101, false);
    }

    public void sortFields(List<Field> r100, List<String> r101) {
        int r102 = 0;
    L4:
        if (r102 >= r101.size()) goto L13;
        String r103 = (String) ListProtector.get(r101, r102);
        int r104 = 0;
    L7:
        if (r104 >= r100.size()) goto L12;
        if (r103.equals(((Field) ListProtector.get(r100, r104)).getName()) == true) goto L10;
        r104 = r104 + 1;
        goto L7
    L10:
        Collections.swap(r100, r102, r104);
    L12:
        r102 = r102 + 1;
        goto L4
    }

    public void useMemory(Pointer r100, int r101) {
        useMemory(r100, r101, false);
    }

    public Structure(Pointer r100, int r101) {
        this(r100, r101, null);
    }

    public static List<String> createFieldsOrder(List<String> r100, String... r101) {
        return createFieldsOrder(r100, Arrays.asList(r101));
    }

    private static <T extends Structure> T newInstance(Class<T> r100, long r101) {
        if (r101 != 0) goto L5;
        Pointer r102 = PLACEHOLDER_MEMORY;     // Catch: Throwable -> L10
    L6:
        T r103 = (T) newInstance(r100, r102);
        if (r101 == 0) goto L9;
        r103.conditionalAutoRead();     // Catch: Throwable -> L10
    L9:
        return r103;
    L5:
        r102 = new Pointer(r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        LOG.log(Level.WARNING, "JNA: Error creating structure", th);
        return null;
    }

    public void writeField(String r100, Object r101) {
        ensureAllocated();
        StructField r102 = fields().get(r100);
        if (r102 == null) goto L7;
        setFieldValue(r102.field, r101);
        writeField(r102, r101);
        return;
    L7:
        throw new IllegalArgumentException("No such field: " + r100);
    }

    public Structure(Pointer r100, int r101, TypeMapper r102) {
        this.size = -1;
        this.nativeStrings = new HashMap(8);
        this.autoRead = true;
        this.autoWrite = true;
        setAlignType(r101);
        setStringEncoding(Native.getStringEncoding(getClass()));
        initializeTypeMapper(r102);
        validateFields();
        if (r100 == null) goto L5;
        useMemory(r100, 0, true);
    L6:
        initializeFields();
        return;
    L5:
        allocateMemory(-1);
        goto L6
    }

    private void setFieldValue(Field r100, Object r101, boolean r102) {
        r100.set(this, r101);     // Catch: IllegalAccessException -> L4
        return;
    L4:
        e = move-exception;
        if (Modifier.isFinal(r100.getModifiers()) == false) goto L13;
        if (r102 == false) goto L11;
        throw new UnsupportedOperationException("This VM does not support Structures with final fields (field '" + r100.getName() + "' within " + getClass() + ")", e);
    L11:
        throw new UnsupportedOperationException("Attempt to write to read-only field '" + r100.getName() + "' within " + getClass(), e);
    L13:
        throw new Error("Unexpectedly unable to write to field '" + r100.getName() + "' within " + getClass(), e);
    }

    private String toString(int r110, boolean r210, boolean r211) {
        ensureAllocated();
        String r100 = System.lineSeparator();
        String r101 = format(getClass()) + "(" + getPointer() + ")";
        if ((getPointer() instanceof Memory) == true) goto L5;
        r101 = r101 + " (" + size() + " bytes)";
    L5:
        String r102 = "";
        int r103 = 0;
    L6:
        if (r103 >= r110) goto L9;
        r102 = r102 + c.DEFAULT_TEXT;
        r103 = r103 + 1;
        goto L6
    L9:
        if (r210 == true) goto L11;
        String r104 = "...}";
    L41:
        if (r110 != 0) goto L63;
        if (r211 == false) goto L63;
        String r105 = r104 + r100 + "memory dump" + r100;
        byte[] r106 = getPointer().getByteArray(0, size());
        int r107 = 0;
    L45:
        if (r107 >= r106.length) goto L61;
        int r108 = r107 % 4;
        if (r108 != 0) goto L49;
        r105 = r105 + "[";
    L49:
        byte r109 = r106[r107];
        if (r109 >= 0) goto L52;
    L54:
        r105 = r105 + Integer.toHexString(r106[r107] & UByte.MAX_VALUE);
        if (r108 != 3) goto L60;
        if (r107 >= (r106.length - 1)) goto L60;
        r105 = r105 + "]" + r100;
    L60:
        r107 = r107 + 1;
        goto L45
    L52:
        if (r109 >= 16) goto L54;
        r105 = r105 + "0";
        goto L54
    L61:
        r104 = r105 + "]";
    L63:
        return r101 + " {" + r104;
    L11:
        Iterator<StructField> r111 = fields().values().iterator();
        String r112 = r100;
    L13:
        if (r111.hasNext() == false) goto L40;
        StructField r113 = r111.next();
        Object r114 = getFieldValue(r113.field);
        String r115 = format(r113.type);
        String r116 = r112 + r102;
        if (r113.type.isArray() == false) goto L18;
        if (r114 == null) goto L18;
        r115 = format(r113.type.getComponentType());
        String r117 = "[" + Array.getLength(r114) + "]";
    L19:
        String r118 = r116 + String.format("  %s %s%s@0x%X", new Object[]{r115, r113.name, r117, Integer.valueOf(r113.offset)});
        if ((r114 instanceof Structure) == false) goto L22;
        r114 = ((Structure) r114).toString(r110 + 1, !(r114 instanceof ByReference), r211);
    L22:
        String r119 = r118 + ContainerUtils.KEY_VALUE_DELIMITER;
        if ((r114 instanceof Long) == false) goto L27;
        String r120 = r119 + String.format("0x%08X", new Object[]{(Long) r114});
    L36:
        String r121 = r120 + r100;
        if (r111.hasNext() == true) goto L39;
        r121 = r121 + r102 + i.f25855d;
    L39:
        r112 = r121;
        goto L13
    L27:
        if ((r114 instanceof Integer) == false) goto L30;
        r120 = r119 + String.format("0x%04X", new Object[]{(Integer) r114});
        goto L36
    L30:
        if ((r114 instanceof Short) == false) goto L33;
        r120 = r119 + String.format("0x%02X", new Object[]{(Short) r114});
        goto L36
    L33:
        if ((r114 instanceof Byte) == false) goto L35;
        r120 = r119 + String.format("0x%01X", new Object[]{(Byte) r114});
        goto L36
    L35:
        r120 = r119 + String.valueOf(r114).trim();
    L18:
        r117 = "";
        goto L19
    L40:
        r104 = r112;
        goto L41
    }

    public static <T extends Structure> T updateStructureByReference(Class<T> r100, T r101, Pointer r102) {
        if (r102 != null) goto L4;
        return null;
    L4:
        if (r101 != null) goto L6;
    L9:
        T r103 = (T) reading().get(r102);
        if (r103 != null) goto L12;
    L14:
        T r104 = (T) newInstance(r100, r102);
        r104.conditionalAutoRead();
        return r104;
    L12:
        if (r100.equals(r103.getClass()) == false) goto L14;
        r103.autoRead();
        return r103;
    L6:
        if (r102.equals(r101.getPointer()) == false) goto L9;
        r101.autoRead();
        return r101;
    }

    public int getNativeAlignment(Class<?> r100, Object r101, boolean r102) {
        if (NativeMapped.class.isAssignableFrom(r100) == false) goto L5;
        NativeMappedConverter r103 = NativeMappedConverter.getInstance(r100);
        Class<?> r104 = r103.nativeType();
        r101 = r103.toNative(r101, new ToNativeContext());
        r100 = r104;
    L5:
        int r105 = Native.getNativeSize(r100, r101);
        if (r100.isPrimitive() == false) goto L8;
    L53:
        int r106 = this.actualAlignType;
        if (r106 != 1) goto L57;
        return 1;
    L57:
        if (r106 != 3) goto L60;
        return Math.min(8, r105);
    L60:
        if (r106 != 2) goto L78;
        if (r102 == true) goto L63;
    L66:
        r105 = Math.min(Native.MAX_ALIGNMENT, r105);
    L67:
        if (r102 == false) goto L69;
        return r105;
    L69:
        if (Platform.isAIX() == true) goto L71;
        return r105;
    L71:
        if (r100 != Double.TYPE) goto L73;
    L74:
        return 4;
    L73:
        if (r100 == Double.class) goto L74;
        return r105;
    L63:
        if (Platform.isMac() == false) goto L66;
        if (Platform.isPPC() == true) goto L67;
    L78:
        return r105;
    L8:
        if (Long.class == r100) goto L53;
        if (Integer.class == r100) goto L53;
        if (Short.class == r100) goto L53;
        if (Character.class == r100) goto L53;
        if (Byte.class == r100) goto L53;
        if (Boolean.class == r100) goto L53;
        if (Float.class == r100) goto L53;
        if (Double.class == r100) goto L53;
        if (Pointer.class.isAssignableFrom(r100) == false) goto L29;
        if (Function.class.isAssignableFrom(r100) == true) goto L29;
    L52:
        r105 = Native.POINTER_SIZE;
    L29:
        if (Platform.HAS_BUFFERS == false) goto L33;
        if (Buffer.class.isAssignableFrom(r100) == true) goto L52;
    L33:
        if (Callback.class.isAssignableFrom(r100) == true) goto L52;
        if (WString.class == r100) goto L52;
        if (String.class == r100) goto L52;
        if (Structure.class.isAssignableFrom(r100) == false) goto L48;
        if (ByReference.class.isAssignableFrom(r100) == false) goto L44;
        r105 = Native.POINTER_SIZE;
        goto L53
    L44:
        if (r101 != null) goto L46;
        r101 = newInstance(r100, PLACEHOLDER_MEMORY);
    L46:
        r105 = ((Structure) r101).getStructAlignment();
        goto L53
    L48:
        if (r100.isArray() == false) goto L51;
        r105 = getNativeAlignment(r100.getComponentType(), null, r102);
        goto L53
    L51:
        throw new IllegalArgumentException("Type " + r100 + " has unknown native alignment");
    }

    public void useMemory(Pointer r100, int r110, boolean r111) {
        this.nativeStrings.clear();     // Catch: IndexOutOfBoundsException -> L15
        if ((this instanceof ByValue) == false) goto L7;
        if (r111 == true) goto L7;
        int r112 = size();     // Catch: IndexOutOfBoundsException -> L15
        byte[] r113 = new byte[r112];     // Catch: IndexOutOfBoundsException -> L15
        r100.read(0, r113, 0, r112);     // Catch: IndexOutOfBoundsException -> L15
        this.memory.write(0, r113, 0, r112);     // Catch: IndexOutOfBoundsException -> L15
    L13:
        this.array = null;     // Catch: IndexOutOfBoundsException -> L15
        this.readCalled = false;     // Catch: IndexOutOfBoundsException -> L15
        return;
    L7:
        if (this.size != (-1)) goto L9;
        this.size = calculateSize(false);     // Catch: IndexOutOfBoundsException -> L15
    L9:
        int r114 = this.size;     // Catch: IndexOutOfBoundsException -> L15
        if (r114 == (-1)) goto L12;
        this.memory = r100.share(r110, r114);     // Catch: IndexOutOfBoundsException -> L15
        goto L13
    L12:
        this.memory = r100.share(r110);     // Catch: IndexOutOfBoundsException -> L15
    L15:
        e = move-exception;
        throw new IllegalArgumentException("Structure exceeds provided memory bounds", e);
    }
}
