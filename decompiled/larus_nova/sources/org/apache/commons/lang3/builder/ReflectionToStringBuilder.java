package org.apache.commons.lang3.builder;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes42.dex */
public class ReflectionToStringBuilder extends ToStringBuilder {
    private boolean appendStatics;
    private boolean appendTransients;
    protected String[] excludeFieldNames;
    private boolean excludeNullValues;
    private Class<?> upToClass;

    @Override // org.apache.commons.lang3.builder.ToStringBuilder
    public String toString() {
        if (getObject() == null) goto L5;
        Class<?> r100 = getObject().getClass();
        appendFieldsIn(r100);
    L8:
        if (r100.getSuperclass() == null) goto L13;
        if (r100 == getUpToClass()) goto L13;
        r100 = r100.getSuperclass();
        appendFieldsIn(r100);
    L13:
        return super.toString();
    L5:
        return getStyle().getNullText();
    }

    public Class<?> getUpToClass() {
        return this.upToClass;
    }

    public boolean isAppendStatics() {
        return this.appendStatics;
    }

    public boolean isAppendTransients() {
        return this.appendTransients;
    }

    private static Object checkNotNull(Object r100) {
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        Validate.isTrue(r101, "The Object passed in should not be null.", new Object[0]);
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public boolean accept(Field r100) {
        if (r100.getName().indexOf(36) == (-1)) goto L6;
        return false;
    L6:
        if (Modifier.isTransient(r100.getModifiers()) == false) goto L11;
        if (isAppendTransients() == true) goto L11;
        return false;
    L11:
        if (Modifier.isStatic(r100.getModifiers()) == true) goto L13;
    L15:
        String[] r101 = this.excludeFieldNames;
        if (r101 == null) goto L21;
        if (Arrays.binarySearch(r101, r100.getName()) < 0) goto L21;
        return false;
    L21:
        return !r100.isAnnotationPresent(ToStringExclude.class);
    L13:
        if (isAppendStatics() == true) goto L15;
        return false;
    }

    public void appendFieldsIn(Class<?> r100) {
        if (r100.isArray() == false) goto L6;
        reflectionAppendArray(getObject());
        return;
    L6:
        Field[] r101 = r100.getDeclaredFields();
        AccessibleObject.setAccessible(r101, true);
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L23;
        Field r104 = r101[r103];
        String r105 = r104.getName();
        if (accept(r104) == false) goto L22;
        Object r106 = getValue(r104);     // Catch: IllegalAccessException -> L19
        if (this.excludeNullValues == false) goto L14;
        if (r106 == null) goto L22;
    L14:
        if (r104.isAnnotationPresent(ToStringSummary.class) == true) goto L16;
        boolean r107 = true;
    L17:
        append(r105, r106, r107);     // Catch: IllegalAccessException -> L19
        goto L22
    L16:
        r107 = false;
    L19:
        e = move-exception;
        throw new InternalError("Unexpected IllegalAccessException: " + e.getMessage());
    L22:
        r103 = r103 + 1;
        goto L7
    }

    public Object getValue(Field r100) throws IllegalAccessException {
        return r100.get(getObject());
    }

    public ReflectionToStringBuilder reflectionAppendArray(Object r100) {
        getStyle().reflectionAppendArrayDetail(getStringBuffer(), null, r100);
        return this;
    }

    public void setAppendStatics(boolean r100) {
        this.appendStatics = r100;
    }

    public void setAppendTransients(boolean r100) {
        this.appendTransients = r100;
    }

    public void setUpToClass(Class<?> r100) {
        if (r100 == null) goto L10;
        Object r101 = getObject();
        if (r101 == null) goto L10;
        if (r100.isInstance(r101) == true) goto L10;
        throw new IllegalArgumentException("Specified class is not a superclass of the object");
    L10:
        this.upToClass = r100;
    }

    public static String toString(Object r100, ToStringStyle r101) {
        return toString(r100, r101, false, false, null);
    }

    public static <T> String toString(T r100, ToStringStyle r101, boolean r110, boolean r111, Class<? super T> r112) {
        return new ReflectionToStringBuilder(r100, r101, null, r112, r110, r111).toString();
    }

    public <T> ReflectionToStringBuilder(T r100, ToStringStyle r101, StringBuffer r102, Class<? super T> r103, boolean r104, boolean r105) {
        super(checkNotNull(r100), r101, r102);
        this.appendStatics = false;
        this.appendTransients = false;
        this.upToClass = null;
        setUpToClass(r103);
        setAppendTransients(r104);
        setAppendStatics(r105);
    }
}
