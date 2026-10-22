package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = null;
    private static final double IGNORE_VERSIONS = -1.0d;
    private List<ExclusionStrategy> deserializationStrategies;
    private int modifiers;
    private boolean requireExpose;
    private List<ExclusionStrategy> serializationStrategies;
    private boolean serializeInnerClasses;
    private double version;

    static {
        DEFAULT = new Excluder();
    }

    public Excluder() {
        this.version = -1.0d;
        this.modifiers = 136;
        this.serializeInnerClasses = true;
        this.serializationStrategies = Collections.emptyList();
        this.deserializationStrategies = Collections.emptyList();
    }

    public Excluder clone() {
        return (Excluder) super.clone();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public Excluder disableInnerClassSerialization() {
        Excluder r100 = clone();
        r100.serializeInnerClasses = false;
        return r100;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder r100 = clone();
        r100.requireExpose = true;
        return r100;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8530clone() throws CloneNotSupportedException {
        return clone();
    }

    private boolean excludeClassChecks(Class<?> r100) {
        if (this.version == (-1.0d)) goto L8;
        if (isValidVersion((Since) r100.getAnnotation(Since.class), (Until) r100.getAnnotation(Until.class)) == true) goto L8;
        return true;
    L8:
        if (this.serializeInnerClasses == true) goto L13;
        if (isInnerClass(r100) == false) goto L13;
        return true;
    L13:
        return isAnonymousOrNonStaticLocal(r100);
    }

    private boolean isAnonymousOrNonStaticLocal(Class<?> r100) {
        if (Enum.class.isAssignableFrom(r100) == false) goto L5;
    L11:
        return false;
    L5:
        if (isStatic(r100) == true) goto L11;
        if (r100.isAnonymousClass() == false) goto L9;
    L10:
        return true;
    L9:
        if (r100.isLocalClass() == false) goto L11;
        goto L10
    }

    private boolean isInnerClass(Class<?> r100) {
        if (r100.isMemberClass() == true) goto L5;
    L7:
        return false;
    L5:
        if (isStatic(r100) == true) goto L7;
        return true;
    }

    private boolean isStatic(Class<?> r100) {
        if ((r100.getModifiers() & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isValidSince(Since r100) {
        if (r100 == null) goto L9;
        double r101 = r100.value();
        if (this.version >= r101) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private boolean isValidUntil(Until r100) {
        if (r100 == null) goto L9;
        double r101 = r100.value();
        if (this.version < r101) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    public Excluder withModifiers(int... r100) {
        Excluder r101 = clone();
        int r102 = 0;
        r101.modifiers = 0;
        int r103 = r100.length;
    L3:
        if (r102 >= r103) goto L5;
        r101.modifiers = r100[r102] | r101.modifiers;
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public Excluder withVersion(double r100) {
        Excluder r101 = clone();
        r101.version = r100;
        return r101;
    }

    private boolean excludeClassInStrategy(Class<?> r100, boolean r101) {
        if (r101 == false) goto L4;
        List<ExclusionStrategy> r102 = this.serializationStrategies;
    L5:
        Iterator<ExclusionStrategy> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        if (r103.next().shouldSkipClass(r100) == false) goto L7;
        return true;
    L12:
        return false;
    L4:
        r102 = this.deserializationStrategies;
        goto L5
    }

    private boolean isValidVersion(Since r100, Until r101) {
        if (isValidSince(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidUntil(r101) == false) goto L7;
        return true;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson r110, final TypeToken<T> r111) {
        Class<? super T> r100 = r111.getRawType();
        boolean r101 = excludeClassChecks(r100);
        if (r101 == false) goto L5;
    L8:
        final boolean r102 = true;
    L9:
        if (r101 == false) goto L11;
    L14:
        final boolean r103 = true;
    L15:
        if (r102 == true) goto L20;
        if (r103 == true) goto L20;
        return null;
    L20:
        return new AnonymousClass1(this, r103, r102, r110, r111);
    L11:
        if (excludeClassInStrategy(r100, false) == true) goto L14;
        r103 = false;
        goto L15
    L5:
        if (excludeClassInStrategy(r100, true) == true) goto L8;
        r102 = false;
        goto L9
    }

    public boolean excludeClass(Class<?> r100, boolean r101) {
        if (excludeClassChecks(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (excludeClassInStrategy(r100, r101) == true) goto L8;
        return false;
    }

    public boolean excludeField(Field r100, boolean r101) {
        if ((this.modifiers & r100.getModifiers()) == 0) goto L6;
        return true;
    L6:
        if (this.version == (-1.0d)) goto L11;
        if (isValidVersion((Since) r100.getAnnotation(Since.class), (Until) r100.getAnnotation(Until.class)) == true) goto L11;
        return true;
    L11:
        if (r100.isSynthetic() == false) goto L14;
        return true;
    L14:
        if (this.requireExpose == false) goto L25;
        Expose r102 = (Expose) r100.getAnnotation(Expose.class);
        if (r102 == null) goto L23;
        if (r101 == false) goto L22;
        if (r102.serialize() == true) goto L25;
    L22:
        if (r102.deserialize() == true) goto L25;
    L23:
        return true;
    L25:
        if (this.serializeInnerClasses == true) goto L30;
        if (isInnerClass(r100.getType()) == false) goto L30;
        return true;
    L30:
        if (isAnonymousOrNonStaticLocal(r100.getType()) == false) goto L32;
        return true;
    L32:
        if (r101 == false) goto L34;
        List<ExclusionStrategy> r103 = this.serializationStrategies;
    L36:
        if (r103.isEmpty() == true) goto L43;
        FieldAttributes r104 = new FieldAttributes(r100);
        Iterator<ExclusionStrategy> r105 = r103.iterator();
    L39:
        if (r105.hasNext() == false) goto L48;
        if (r105.next().shouldSkipField(r104) == false) goto L39;
        return true;
    L48:
        return false;
    L43:
        return false;
    L34:
        r103 = this.deserializationStrategies;
        goto L36
    }

    public Excluder withExclusionStrategy(ExclusionStrategy r100, boolean r101, boolean r102) {
        Excluder r103 = clone();
        if (r101 == false) goto L5;
        ArrayList r104 = new ArrayList(this.serializationStrategies);
        r103.serializationStrategies = r104;
        r104.add(r100);
    L5:
        if (r102 == false) goto L7;
        ArrayList r105 = new ArrayList(this.deserializationStrategies);
        r103.deserializationStrategies = r105;
        r105.add(r100);
    L7:
        return r103;
    }
}
