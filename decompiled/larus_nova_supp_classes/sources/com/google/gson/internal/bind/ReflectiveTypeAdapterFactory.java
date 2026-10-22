package com.google.gson.internal.bind;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.ReflectionAccessFilter$FilterResult;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.ReflectionAccessFilterHelper;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    private final List<ReflectionAccessFilter> reflectionFilters;

    public static abstract class Adapter<T, A> extends TypeAdapter<T> {
        final Map<String, BoundField> boundFields;

        public abstract A createAccumulator();

        public abstract T finalize(A r1);

        public abstract void readField(A r1, JsonReader r2, BoundField r3) throws IllegalAccessException, IOException;

        public Adapter(Map<String, BoundField> r1) {
            this.boundFields = r1;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r4) throws IOException {
            if (r4.peek() != JsonToken.NULL) goto L6;
            r4.nextNull();
            return null;
        L6:
            A r0 = createAccumulator();
            r4.beginObject();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
        L8:
            if (r4.hasNext() == false) goto L18;
            String r1 = r4.nextName();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            BoundField r2 = this.boundFields.get(r1);     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            if (r2 == null) goto L16;
            if (r2.deserialized == false) goto L16;
            readField(r0, r4, r2);     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
        L16:
            r4.skipValue();     // Catch: IllegalAccessException -> L20 IllegalStateException -> L23
            goto L8
        L18:
            r4.endObject();
            return finalize(r0);
        L20:
            e = move-exception;
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        L23:
            e = move-exception;
            throw new JsonSyntaxException(e);
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r3, T r4) throws IOException {
            if (r4 != null) goto L5;
            r3.nullValue();
            return;
        L5:
            r3.beginObject();
            Iterator<BoundField> r0 = this.boundFields.values().iterator();     // Catch: IllegalAccessException -> L13
        L8:
            if (r0.hasNext() == false) goto L11;
            r0.next().write(r3, r4);     // Catch: IllegalAccessException -> L13
            goto L8
        L11:
            r3.endObject();
            return;
        L13:
            e = move-exception;
            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e);
        }
    }

    public static abstract class BoundField {
        final boolean deserialized;
        final Field field;
        final String fieldName;
        final String name;
        final boolean serialized;

        public abstract void readIntoArray(JsonReader r1, int r2, Object[] r3) throws IOException, JsonParseException;

        public abstract void readIntoField(JsonReader r1, Object r2) throws IOException, IllegalAccessException;

        public abstract void write(JsonWriter r1, Object r2) throws IOException, IllegalAccessException;

        public BoundField(String r1, Field r2, boolean r3, boolean r4) {
            this.name = r1;
            this.field = r2;
            this.fieldName = r2.getName();
            this.serialized = r3;
            this.deserialized = r4;
        }
    }

    public static final class FieldReflectionAdapter<T> extends Adapter<T, T> {
        private final ObjectConstructor<T> constructor;

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public T finalize(T r1) {
            return r1;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public T createAccumulator() {
            return this.constructor.construct();
        }

        public FieldReflectionAdapter(ObjectConstructor<T> r1, Map<String, BoundField> r2) {
            super(r2);
            this.constructor = r1;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public void readField(T r1, JsonReader r2, BoundField r3) throws IllegalAccessException, IOException {
            r3.readIntoField(r2, r1);
        }
    }

    private List<String> getFieldNames(Field r4) {
        SerializedName r0 = (SerializedName) r4.getAnnotation(SerializedName.class);
        if (r0 == null) goto L5;
        String r5 = r0.value();
        String[] r1 = r0.alternate();
        if (r1.length == 0) goto L9;
        ArrayList r2 = new ArrayList(r1.length + 1);
        r2.add(r5);
        Collections.addAll(r2, r1);
        return r2;
    L9:
        return Collections.singletonList(r5);
    L5:
        return Collections.singletonList(this.fieldNamingPolicy.translateName(r4));
    }

    public static /* synthetic */ void access$000(Object r0, AccessibleObject r1) {
        checkAccessible(r0, r1);
    }

    private static <M extends AccessibleObject & Member> void checkAccessible(Object r1, M r2) {
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L6;
        r1 = null;
    L6:
        if (ReflectionAccessFilterHelper.canAccess(r2, r1) == false) goto L9;
        return;
    L9:
        throw new JsonIOException(ReflectionHelper.getAccessibleObjectDescription(r2, true) + " is not accessible and ReflectionAccessFilter does not permit making it accessible. Register a TypeAdapter for the declaring type, adjust the access filter or increase the visibility of the element and its declaring type.");
    }

    private boolean includeField(Field r3, boolean r4) {
        if (this.excluder.excludeClass(r3.getType(), r4) == false) goto L5;
    L7:
        return false;
    L5:
        if (this.excluder.excludeField(r3, r4) == true) goto L7;
        return true;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r11, TypeToken<T> r12) {
        Class<? super T> r6 = r12.getRawType();
        if (Object.class.isAssignableFrom(r6) == true) goto L6;
        return null;
    L6:
        ReflectionAccessFilter$FilterResult r0 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r6);
        if (r0 == ReflectionAccessFilter$FilterResult.BLOCK_ALL) goto L19;
        if (r0 != ReflectionAccessFilter$FilterResult.BLOCK_INACCESSIBLE) goto L11;
        boolean r7 = true;
    L13:
        if (ReflectionHelper.isRecord(r6) == false) goto L17;
        return new RecordAdapter(r6, getBoundFields(r11, r12, r6, r7, true), r7);
    L17:
        return new FieldReflectionAdapter(this.constructorConstructor.get(r12), getBoundFields(r11, r12, r6, r7, false));
    L11:
        r7 = false;
        goto L13
    L19:
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + r6 + ". Register a TypeAdapter for this type or adjust the access filter.");
    }

    public ReflectiveTypeAdapterFactory(ConstructorConstructor r1, FieldNamingStrategy r2, Excluder r3, JsonAdapterAnnotationTypeAdapterFactory r4, List<ReflectionAccessFilter> r5) {
        this.constructorConstructor = r1;
        this.fieldNamingPolicy = r2;
        this.excluder = r3;
        this.jsonAdapterFactory = r4;
        this.reflectionFilters = r5;
    }

    private Map<String, BoundField> getBoundFields(Gson r29, TypeToken<?> r30, Class<?> r31, boolean r32, boolean r33) {
        LinkedHashMap r11 = new LinkedHashMap();
        if (r31.isInterface() == false) goto L5;
        return r11;
    L5:
        TypeToken<?> r12 = r30;
        boolean r0 = r32;
        Class<?> r13 = r31;
    L7:
        if (r13 == Object.class) goto L63;
        Field[] r14 = r13.getDeclaredFields();
        boolean r15 = true;
        boolean r8 = false;
        if (r13 != r31) goto L11;
    L20:
        boolean r16 = r0;
        int r7 = r14.length;
        int r6 = 0;
    L21:
        if (r6 >= r7) goto L62;
        Field r5 = r14[r6];
        boolean r1 = this.includeField(r5, r15);
        boolean r2 = this.includeField(r5, r8);
        if (r1 == true) goto L26;
        if (r2 == true) goto L26;
        int r21 = r6;
        int r26 = r7;
    L59:
        r6 = r21 + 1;
        r7 = r26;
        r8 = false;
        r15 = true;
        ReflectiveTypeAdapterFactory this = this;
    L26:
        BoundField r3 = null;
        if (r33 == true) goto L29;
        boolean r17 = r2;
        Method r18 = null;
    L43:
        if (r16 == true) goto L46;
        if (r18 != null) goto L46;
        ReflectionHelper.makeAccessible(r5);
    L46:
        Type r19 = C$Gson$Types.resolve(r12.getType(), r13, r5.getGenericType());
        List<String> r4 = this.getFieldNames(r5);
        int r9 = r4.size();
        int r10 = 0;
    L47:
        if (r10 >= r9) goto L57;
        String r110 = r4.get(r10);
        if (r10 == 0) goto L51;
        boolean r20 = false;
    L52:
        int r22 = r10;
        BoundField r23 = r3;
        int r24 = r9;
        List<String> r25 = r4;
        Field r28 = r5;
        int r210 = r6;
        int r211 = r7;
        BoundField r34 = (BoundField) r11.put(r110, createBoundField(r29, r5, r18, r110, TypeToken.get(r19), r20, r17, r16));
        if (r23 != null) goto L55;
        r3 = r34;
    L56:
        r10 = r22 + 1;
        r1 = r20;
        r6 = r210;
        r9 = r24;
        r4 = r25;
        r5 = r28;
        r7 = r211;
        goto L47
    L55:
        r3 = r23;
        goto L56
    L51:
        r20 = r1;
        goto L52
    L57:
        BoundField r35 = r3;
        Field r212 = r5;
        r21 = r6;
        r26 = r7;
        if (r35 == null) goto L59;
        throw new IllegalArgumentException("Class " + r31.getName() + " declares multiple JSON fields named '" + r35.name + "'; conflict is caused by fields " + ReflectionHelper.fieldToString(r35.field) + " and " + ReflectionHelper.fieldToString(r212));
    L29:
        if (Modifier.isStatic(r5.getModifiers()) == false) goto L31;
        r18 = null;
        r17 = false;
        goto L43
    L31:
        Method r36 = ReflectionHelper.getAccessor(r13, r5);
        if (r16 == true) goto L35;
        ReflectionHelper.makeAccessible(r36);
    L35:
        if (r36.getAnnotation(SerializedName.class) != null) goto L37;
    L41:
        r17 = r2;
        r18 = r36;
        goto L43
    L37:
        if (r5.getAnnotation(SerializedName.class) != null) goto L41;
        throw new JsonIOException("@SerializedName on " + ReflectionHelper.getAccessibleObjectDescription(r36, r8) + " is not supported");
    L62:
        r12 = TypeToken.get(C$Gson$Types.resolve(r12.getType(), r13, r13.getGenericSuperclass()));
        r13 = r12.getRawType();
        r0 = r16;
        goto L7
    L11:
        if (r14.length <= 0) goto L20;
        ReflectionAccessFilter$FilterResult r37 = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, r13);
        if (r37 == ReflectionAccessFilter$FilterResult.BLOCK_ALL) goto L19;
        if (r37 != ReflectionAccessFilter$FilterResult.BLOCK_INACCESSIBLE) goto L17;
        r0 = true;
        goto L20
    L17:
        r0 = false;
        goto L20
    L19:
        throw new JsonIOException("ReflectionAccessFilter does not permit using reflection for " + r13 + " (supertype of " + r31 + "). Register a TypeAdapter for this type or adjust the access filter.");
    L63:
        return r11;
    }

    private BoundField createBoundField(final Gson r17, final Field r18, final Method r19, final String r20, final TypeToken<?> r21, final boolean r22, final boolean r23, final boolean r24) {
        final boolean r12 = Primitives.isPrimitive(r21.getRawType());
        int r0 = r18.getModifiers();
        if (Modifier.isStatic(r0) == true) goto L5;
    L7:
        final boolean r13 = false;
    L8:
        JsonAdapter r1 = (JsonAdapter) r18.getAnnotation(JsonAdapter.class);
        if (r1 == null) goto L11;
        TypeAdapter<?> r2 = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, r17, r21, r1);
    L12:
        if (r2 == null) goto L14;
        final boolean r8 = true;
    L15:
        if (r2 != null) goto L17;
        r2 = r17.getAdapter(r21);
    L17:
        final TypeAdapter<?> r9 = r2;
        return new AnonymousClass1(this, r20, r18, r22, r23, r24, r19, r8, r9, r17, r21, r12, r13);
    L14:
        r8 = false;
        goto L15
    L11:
        r2 = null;
        goto L12
    L5:
        if (Modifier.isFinal(r0) == false) goto L7;
        r13 = true;
        goto L8
    }
}
