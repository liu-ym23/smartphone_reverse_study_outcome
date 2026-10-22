package com.sun.jna;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class DefaultTypeMapper implements TypeMapper {
    private List<Entry> fromNativeConverters;
    private List<Entry> toNativeConverters;

    public static class Entry {
        public Object converter;
        public Class<?> type;

        public Entry(Class<?> r100, Object r101) {
            this.type = r100;
            this.converter = r101;
        }
    }

    public DefaultTypeMapper() {
        this.toNativeConverters = new ArrayList();
        this.fromNativeConverters = new ArrayList();
    }

    private Class<?> getAltClass(Class<?> r100) {
        if (r100 != Boolean.class) goto L7;
        return Boolean.TYPE;
    L7:
        if (r100 != Boolean.TYPE) goto L11;
        return Boolean.class;
    L11:
        if (r100 != Byte.class) goto L15;
        return Byte.TYPE;
    L15:
        if (r100 != Byte.TYPE) goto L19;
        return Byte.class;
    L19:
        if (r100 != Character.class) goto L23;
        return Character.TYPE;
    L23:
        if (r100 != Character.TYPE) goto L27;
        return Character.class;
    L27:
        if (r100 != Short.class) goto L31;
        return Short.TYPE;
    L31:
        if (r100 != Short.TYPE) goto L35;
        return Short.class;
    L35:
        if (r100 != Integer.class) goto L39;
        return Integer.TYPE;
    L39:
        if (r100 != Integer.TYPE) goto L43;
        return Integer.class;
    L43:
        if (r100 != Long.class) goto L47;
        return Long.TYPE;
    L47:
        if (r100 != Long.TYPE) goto L51;
        return Long.class;
    L51:
        if (r100 != Float.class) goto L55;
        return Float.TYPE;
    L55:
        if (r100 != Float.TYPE) goto L59;
        return Float.class;
    L59:
        if (r100 != Double.class) goto L63;
        return Double.TYPE;
    L63:
        if (r100 != Double.TYPE) goto L66;
        return Double.class;
    L66:
        return null;
    }

    @Override // com.sun.jna.TypeMapper
    public FromNativeConverter getFromNativeConverter(Class<?> r100) {
        return (FromNativeConverter) lookupConverter(r100, this.fromNativeConverters);
    }

    @Override // com.sun.jna.TypeMapper
    public ToNativeConverter getToNativeConverter(Class<?> r100) {
        return (ToNativeConverter) lookupConverter(r100, this.toNativeConverters);
    }

    private Object lookupConverter(Class<?> r100, Collection<? extends Entry> r101) {
        Iterator<? extends Entry> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Entry r103 = r102.next();
        if (r103.type.isAssignableFrom(r100) == false) goto L4;
        return r103.converter;
    L9:
        return null;
    }

    public void addFromNativeConverter(Class<?> r100, FromNativeConverter r101) {
        this.fromNativeConverters.add(new Entry(r100, r101));
        Class<?> r102 = getAltClass(r100);
        if (r102 == null) goto L6;
        this.fromNativeConverters.add(new Entry(r102, r101));
        return;
    }

    public void addToNativeConverter(Class<?> r100, ToNativeConverter r101) {
        this.toNativeConverters.add(new Entry(r100, r101));
        Class<?> r102 = getAltClass(r100);
        if (r102 == null) goto L6;
        this.toNativeConverters.add(new Entry(r102, r101));
        return;
    }

    public void addTypeConverter(Class<?> r100, TypeConverter r101) {
        addFromNativeConverter(r100, r101);
        addToNativeConverter(r100, r101);
    }
}
