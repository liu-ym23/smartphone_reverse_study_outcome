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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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
        this.version = IGNORE_VERSIONS;
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
        Excluder r0 = clone();
        r0.serializeInnerClasses = false;
        return r0;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder r0 = clone();
        r0.requireExpose = true;
        return r0;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m0clone() throws CloneNotSupportedException {
        return clone();
    }

    private boolean excludeClassChecks(Class<?> r7) {
        if (this.version == IGNORE_VERSIONS) goto L8;
        if (isValidVersion((Since) r7.getAnnotation(Since.class), (Until) r7.getAnnotation(Until.class)) == true) goto L8;
        return true;
    L8:
        if (this.serializeInnerClasses == true) goto L13;
        if (isInnerClass(r7) == false) goto L13;
        return true;
    L13:
        return isAnonymousOrNonStaticLocal(r7);
    }

    private boolean isAnonymousOrNonStaticLocal(Class<?> r2) {
        if (Enum.class.isAssignableFrom(r2) == false) goto L5;
    L11:
        return false;
    L5:
        if (isStatic(r2) == true) goto L11;
        if (r2.isAnonymousClass() == false) goto L9;
    L10:
        return true;
    L9:
        if (r2.isLocalClass() == false) goto L11;
        goto L10
    }

    private boolean isInnerClass(Class<?> r2) {
        if (r2.isMemberClass() == true) goto L5;
    L7:
        return false;
    L5:
        if (isStatic(r2) == true) goto L7;
        return true;
    }

    private boolean isStatic(Class<?> r1) {
        if ((r1.getModifiers() & 8) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isValidSince(Since r6) {
        if (r6 == null) goto L9;
        double r1 = r6.value();
        if (this.version >= r1) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    private boolean isValidUntil(Until r6) {
        if (r6 == null) goto L9;
        double r1 = r6.value();
        if (this.version < r1) goto L10;
        return false;
    L10:
        return true;
    L9:
        return true;
    }

    public Excluder withModifiers(int... r6) {
        Excluder r0 = clone();
        int r1 = 0;
        r0.modifiers = 0;
        int r2 = r6.length;
    L3:
        if (r1 >= r2) goto L5;
        r0.modifiers = r6[r1] | r0.modifiers;
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public Excluder withVersion(double r2) {
        Excluder r0 = clone();
        r0.version = r2;
        return r0;
    }

    private boolean excludeClassInStrategy(Class<?> r2, boolean r3) {
        if (r3 == false) goto L4;
        List<ExclusionStrategy> r4 = this.serializationStrategies;
    L5:
        Iterator<ExclusionStrategy> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        if (r5.next().shouldSkipClass(r2) == false) goto L7;
        return true;
    L12:
        return false;
    L4:
        r4 = this.deserializationStrategies;
        goto L5
    }

    private boolean isValidVersion(Since r1, Until r2) {
        if (isValidSince(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (isValidUntil(r2) == false) goto L7;
        return true;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r12, TypeToken<T> r13) {
        Class<? super T> r0 = r13.getRawType();
        boolean r1 = excludeClassChecks(r0);
        if (r1 == false) goto L5;
    L8:
        boolean r8 = true;
    L9:
        if (r1 == false) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r8 == true) goto L20;
        if (r7 == true) goto L20;
        return null;
    L20:
        return new 1(this, r7, r8, r12, r13);
    L11:
        if (excludeClassInStrategy(r0, false) == true) goto L14;
        r7 = false;
        goto L15
    L5:
        if (excludeClassInStrategy(r0, true) == true) goto L8;
        r8 = false;
        goto L9
    }

    public boolean excludeClass(Class<?> r2, boolean r3) {
        if (excludeClassChecks(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (excludeClassInStrategy(r2, r3) == true) goto L8;
        return false;
    }

    public boolean excludeField(Field r7, boolean r8) {
        if ((this.modifiers & r7.getModifiers()) == 0) goto L6;
        return true;
    L6:
        if (this.version == IGNORE_VERSIONS) goto L11;
        if (isValidVersion((Since) r7.getAnnotation(Since.class), (Until) r7.getAnnotation(Until.class)) == true) goto L11;
        return true;
    L11:
        if (r7.isSynthetic() == false) goto L14;
        return true;
    L14:
        if (this.requireExpose == false) goto L25;
        Expose r0 = r7.getAnnotation(Expose.class);
        if (r0 == null) goto L23;
        if (r8 == false) goto L22;
        if (r0.serialize() == true) goto L25;
    L22:
        if (r0.deserialize() == true) goto L25;
    L23:
        return true;
    L25:
        if (this.serializeInnerClasses == true) goto L30;
        if (isInnerClass(r7.getType()) == false) goto L30;
        return true;
    L30:
        if (isAnonymousOrNonStaticLocal(r7.getType()) == false) goto L32;
        return true;
    L32:
        if (r8 == false) goto L34;
        List<ExclusionStrategy> r9 = this.serializationStrategies;
    L36:
        if (r9.isEmpty() == true) goto L43;
        FieldAttributes r1 = new FieldAttributes(r7);
        Iterator<ExclusionStrategy> r10 = r9.iterator();
    L39:
        if (r10.hasNext() == false) goto L48;
        if (r10.next().shouldSkipField(r1) == false) goto L39;
        return true;
    L48:
        return false;
    L43:
        return false;
    L34:
        r9 = this.deserializationStrategies;
        goto L36
    }

    public Excluder withExclusionStrategy(ExclusionStrategy r3, boolean r4, boolean r5) {
        Excluder r0 = clone();
        if (r4 == false) goto L5;
        ArrayList r6 = new ArrayList(this.serializationStrategies);
        r0.serializationStrategies = r6;
        r6.add(r3);
    L5:
        if (r5 == false) goto L7;
        ArrayList r7 = new ArrayList(this.deserializationStrategies);
        r0.deserializationStrategies = r7;
        r7.add(r3);
    L7:
        return r0;
    }
}
