package com.sun.jna;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes40.dex */
public class NativeMappedConverter implements TypeConverter {
    private static final Map<Class<?>, Reference<NativeMappedConverter>> converters = null;
    private final NativeMapped instance;
    private final Class<?> nativeType;
    private final Class<?> type;

    static {
        converters = new WeakHashMap();
    }

    public NativeMapped defaultValue() {
        if (this.type.isEnum() == false) goto L7;
        return (NativeMapped) this.type.getEnumConstants()[0];
    L7:
        return (NativeMapped) Klass.newInstance(this.type);
    }

    @Override // com.sun.jna.FromNativeConverter, com.sun.jna.ToNativeConverter
    public Class<?> nativeType() {
        return this.nativeType;
    }

    public NativeMappedConverter(Class<?> r100) {
        if (NativeMapped.class.isAssignableFrom(r100) == false) goto L7;
        this.type = r100;
        NativeMapped r101 = defaultValue();
        this.instance = r101;
        this.nativeType = r101.nativeType();
        return;
    L7:
        throw new IllegalArgumentException("Type must derive from " + NativeMapped.class);
    }

    public static NativeMappedConverter getInstance(Class<?> r100) {
        Map<Class<?>, Reference<NativeMappedConverter>> r101 = converters;
        monitor-enter(r101);
        Reference<NativeMappedConverter> r102 = r101.get(r100);     // Catch: Throwable -> L12
        if (r102 == null) goto L7;
        NativeMappedConverter r103 = r102.get();     // Catch: Throwable -> L12
    L8:
        if (r103 != null) goto L10;
        r103 = new NativeMappedConverter(r100);     // Catch: Throwable -> L12
        r101.put(r100, new SoftReference(r103));     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
        return r103;
    L7:
        r103 = null;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.sun.jna.FromNativeConverter
    public Object fromNative(Object r100, FromNativeContext r101) {
        return this.instance.fromNative(r100, r101);
    }

    @Override // com.sun.jna.ToNativeConverter
    public Object toNative(Object r100, ToNativeContext r101) {
        if (r100 != null) goto L9;
        if (Pointer.class.isAssignableFrom(this.nativeType) == false) goto L7;
        return null;
    L7:
        r100 = defaultValue();
    L9:
        return ((NativeMapped) r100).toNative();
    }
}
