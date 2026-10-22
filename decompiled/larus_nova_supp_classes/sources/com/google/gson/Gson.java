package com.google.gson;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import com.larus.utils.gson.GCKAKotlinxJsonTypeAdapterFactory;
import com.larus.utils.gson.GCKAKotlinxSerializableTypeAdapterFactory;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class Gson {
    static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
    static final String DEFAULT_DATE_PATTERN = null;
    static final boolean DEFAULT_ESCAPE_HTML = true;
    static final FieldNamingStrategy DEFAULT_FIELD_NAMING_STRATEGY = null;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final boolean DEFAULT_LENIENT = false;
    static final ToNumberStrategy DEFAULT_NUMBER_TO_NUMBER_STRATEGY = null;
    static final ToNumberStrategy DEFAULT_OBJECT_TO_NUMBER_STRATEGY = null;
    static final boolean DEFAULT_PRETTY_PRINT = false;
    static final boolean DEFAULT_SERIALIZE_NULLS = false;
    static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
    static final boolean DEFAULT_USE_JDK_UNSAFE = true;
    private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
    final List<TypeAdapterFactory> builderFactories;
    final List<TypeAdapterFactory> builderHierarchyFactories;
    final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;
    final String datePattern;
    final int dateStyle;
    final Excluder excluder;
    final List<TypeAdapterFactory> factories;
    final FieldNamingStrategy fieldNamingStrategy;
    final boolean generateNonExecutableJson;
    final boolean htmlSafe;
    final Map<Type, InstanceCreator<?>> instanceCreators;
    private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
    final boolean lenient;
    final LongSerializationPolicy longSerializationPolicy;
    final ToNumberStrategy numberToNumberStrategy;
    final ToNumberStrategy objectToNumberStrategy;
    final boolean prettyPrinting;
    final List<ReflectionAccessFilter> reflectionFilters;
    final boolean serializeNulls;
    final boolean serializeSpecialFloatingPointValues;
    private final ThreadLocal<Map<TypeToken<?>, TypeAdapter<?>>> threadLocalAdapterResults;
    final int timeStyle;
    private final ConcurrentMap<TypeToken<?>, TypeAdapter<?>> typeTokenCache;
    final boolean useJdkUnsafe;

    public static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {
        private TypeAdapter<T> delegate;

        private TypeAdapter<T> delegate() {
            TypeAdapter<T> r0 = this.delegate;
            if (r0 == null) goto L6;
            return r0;
        L6:
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        public FutureTypeAdapter() {
            this.delegate = null;
        }

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public TypeAdapter<T> getSerializationDelegate() {
            return delegate();
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r2) throws IOException {
            return delegate().read(r2);
        }

        public void setDelegate(TypeAdapter<T> r2) {
            if (this.delegate != null) goto L7;
            this.delegate = r2;
            return;
        L7:
            throw new AssertionError("Delegate is already set");
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r2, T r3) throws IOException {
            delegate().write(r2, r3);
        }
    }

    public TypeAdapter getAdapter(TypeToken r1) {
        return com_google_gson_Gson_com_larus_utils_gson_GsonHook_getAdapter(this, r1);
    }

    static {
        DEFAULT_FIELD_NAMING_STRATEGY = FieldNamingPolicy.IDENTITY;
        DEFAULT_OBJECT_TO_NUMBER_STRATEGY = ToNumberPolicy.DOUBLE;
        DEFAULT_NUMBER_TO_NUMBER_STRATEGY = ToNumberPolicy.LAZILY_PARSED_NUMBER;
    }

    public Gson() {
        this(Excluder.DEFAULT, DEFAULT_FIELD_NAMING_STRATEGY, Collections.emptyMap(), false, false, false, true, false, false, false, true, LongSerializationPolicy.DEFAULT, DEFAULT_DATE_PATTERN, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), DEFAULT_OBJECT_TO_NUMBER_STRATEGY, DEFAULT_NUMBER_TO_NUMBER_STRATEGY, Collections.emptyList());
    }

    public GsonBuilder newBuilder() {
        return new GsonBuilder(this);
    }

    public String toString() {
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
    }

    public Excluder excluder() {
        return this.excluder;
    }

    public FieldNamingStrategy fieldNamingStrategy() {
        return this.fieldNamingStrategy;
    }

    public boolean htmlSafe() {
        return this.htmlSafe;
    }

    public boolean serializeNulls() {
        return this.serializeNulls;
    }

    private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> r1) {
        return new AnonymousClass4(r1).nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> r1) {
        return new AnonymousClass5(r1).nullSafe();
    }

    public static void checkValidFloatingPoint(double r2) {
        if (Double.isNaN(r2) == true) goto L8;
        if (Double.isInfinite(r2) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(r2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    private TypeAdapter<Number> doubleAdapter(boolean r1) {
        if (r1 == false) goto L6;
        return TypeAdapters.DOUBLE;
    L6:
        return new AnonymousClass1(this);
    }

    private TypeAdapter<Number> floatAdapter(boolean r1) {
        if (r1 == false) goto L6;
        return TypeAdapters.FLOAT;
    L6:
        return new AnonymousClass2(this);
    }

    private static TypeAdapter<Number> longAdapter(LongSerializationPolicy r1) {
        if (r1 != LongSerializationPolicy.DEFAULT) goto L7;
        return TypeAdapters.LONG;
    L7:
        return new AnonymousClass3();
    }

    public <T> TypeAdapter<T> com_google_gson_Gson__getAdapter$___twin___(TypeToken<T> r7) {
        Objects.requireNonNull(r7, "type must not be null");
        TypeAdapter<T> r0 = (TypeAdapter) this.typeTokenCache.get(r7);
        if (r0 == null) goto L5;
        return r0;
    L5:
        Map<? extends TypeToken<?>, ? extends TypeAdapter<?>> r1 = this.threadLocalAdapterResults.get();
        if (r1 != null) goto L8;
        r1 = new HashMap();
        this.threadLocalAdapterResults.set((Map<TypeToken<?>, TypeAdapter<?>>) r1);
        boolean r2 = true;
    L30:
        FutureTypeAdapter r3 = new FutureTypeAdapter();     // Catch: Throwable -> L26
        r1.put(r7, r3);     // Catch: Throwable -> L26
        Iterator<TypeAdapterFactory> r4 = this.factories.iterator();     // Catch: Throwable -> L26
        TypeAdapter<T> r5 = null;
    L14:
        if (r4.hasNext() == false) goto L18;
        r5 = r4.next().create(this, r7);     // Catch: Throwable -> L26
        if (r5 == null) goto L14;
        r3.setDelegate(r5);     // Catch: Throwable -> L26
        r1.put(r7, r5);     // Catch: Throwable -> L26
    L18:
        if (r2 == false) goto L20;
        this.threadLocalAdapterResults.remove();
    L20:
        if (r5 == null) goto L25;
        if (r2 == false) goto L23;
        this.typeTokenCache.putAll(r1);
    L23:
        return r5;
    L25:
        throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + r7);
    L26:
        th = move-exception;
        if (r2 == false) goto L29;
        this.threadLocalAdapterResults.remove();
    L29:
        throw th;
    L8:
        TypeAdapter<T> r6 = (TypeAdapter) r1.get(r7);
        if (r6 == null) goto L11;
        return r6;
    L11:
        r2 = false;
        goto L30
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> r1) {
        return getAdapter(TypeToken.get(r1));
    }

    public JsonReader newJsonReader(Reader r2) {
        JsonReader r0 = new JsonReader(r2);
        r0.setLenient(this.lenient);
        return r0;
    }

    public JsonWriter newJsonWriter(Writer r2) throws IOException {
        if (this.generateNonExecutableJson == false) goto L5;
        r2.write(JSON_NON_EXECUTABLE_PREFIX);
    L5:
        JsonWriter r0 = new JsonWriter(r2);
        if (this.prettyPrinting == false) goto L8;
        r0.setIndent("  ");
    L8:
        r0.setHtmlSafe(this.htmlSafe);
        r0.setLenient(this.lenient);
        r0.setSerializeNulls(this.serializeNulls);
        return r0;
    }

    public String toJson(Object r2) {
        if (r2 != null) goto L6;
        return toJson(JsonNull.INSTANCE);
    L6:
        return toJson(r2, r2.getClass());
    }

    public JsonElement toJsonTree(Object r2) {
        if (r2 != null) goto L6;
        return JsonNull.INSTANCE;
    L6:
        return toJsonTree(r2, r2.getClass());
    }

    public String toJson(JsonElement r2) {
        StringWriter r0 = new StringWriter();
        toJson(r2, r0);
        return r0.toString();
    }

    private static void assertFullConsumption(Object r0, JsonReader r1) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            if (r0 == 0) goto L21
            com.google.gson.stream.JsonToken r0 = r1.peek()     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
            com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
            if (r0 != r1) goto Lb
            goto L21
        Lb:
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
            java.lang.String r1 = "JSON document was not fully consumed."
            r0.<init>(r1)     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
            throw r0     // Catch: java.io.IOException -> L13 com.google.gson.stream.MalformedJsonException -> L1a
        L13:
            r0 = move-exception
            com.google.gson.JsonIOException r1 = new com.google.gson.JsonIOException
            r1.<init>(r0)
            throw r1
        L1a:
            r0 = move-exception
            com.google.gson.JsonSyntaxException r1 = new com.google.gson.JsonSyntaxException
            r1.<init>(r0)
            throw r1
        L21:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.assertFullConsumption(java.lang.Object, com.google.gson.stream.JsonReader):void");
    }

    public static TypeAdapter com_google_gson_Gson_com_larus_utils_gson_GsonHook_getAdapter(Gson r8, TypeToken r9) {
        List<TypeAdapterFactory> r0 = r8.factories;
        if (r0 != null) goto L5;
    L30:
        ArrayList r1 = new ArrayList();
        r1.add(GCKAKotlinxSerializableTypeAdapterFactory.a);
        r1.add(GCKAKotlinxJsonTypeAdapterFactory.a);
        r0 = Collections.unmodifiableList(r1);
    L31:
        r8.factories = r0;
        return r8.com_google_gson_Gson__getAdapter$___twin___(r9);
    L5:
        if (r0.isEmpty() == true) goto L30;
        Iterator<TypeAdapterFactory> r2 = r0.iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        TypeAdapterFactory r3 = r2.next();
        if (r3 == GCKAKotlinxJsonTypeAdapterFactory.a) goto L31;
        if (r3 != GCKAKotlinxSerializableTypeAdapterFactory.a) goto L9;
    L15:
        ArrayList r4 = new ArrayList();
        Iterator<TypeAdapterFactory> r5 = r0.iterator();
        boolean r6 = false;
    L17:
        if (r5.hasNext() == false) goto L27;
        TypeAdapterFactory r7 = r5.next();
        GCKAKotlinxJsonTypeAdapterFactory r10 = GCKAKotlinxJsonTypeAdapterFactory.a;
        if (r7 == r10) goto L17;
        GCKAKotlinxSerializableTypeAdapterFactory r11 = GCKAKotlinxSerializableTypeAdapterFactory.a;
        if (r7 == r11) goto L17;
        if (r7 != TypeAdapters.STRING_FACTORY) goto L26;
        r4.add(r11);
        r4.add(r10);
        r6 = true;
    L26:
        r4.add(r7);
        goto L17
    L27:
        if (r6 == true) goto L29;
        ListProtector.add(r4, 0, GCKAKotlinxSerializableTypeAdapterFactory.a);
        ListProtector.add(r4, 0, GCKAKotlinxJsonTypeAdapterFactory.a);
    L29:
        r0 = Collections.unmodifiableList(r4);
        goto L31
    }

    public <T> T fromJson(JsonReader r5, TypeToken<T> r6) throws JsonIOException, JsonSyntaxException {
        boolean r1 = r5.isLenient();
        boolean r2 = true;
        r5.setLenient(true);
        r5.peek();     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11 IllegalStateException -> L14 EOFException -> L17
        r2 = false;
        T r7 = (T) getAdapter(r6).read(r5);
        r5.setLenient(r1);
        return r7;
    L6:
        th = move-exception;
        r5.setLenient(r1);
        throw th;
    L17:
        e = move-exception;
        if (r2 == false) goto L22;
        r5.setLenient(r1);
        return null;
    L22:
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    L11:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    L14:
        e = move-exception;
        throw new JsonSyntaxException(e);     // Catch: Throwable -> L6
    }

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory r4, TypeToken<T> r5) {
        if (this.factories.contains(r4) == true) goto L5;
        r4 = this.jsonAdapterFactory;
    L5:
        Iterator<TypeAdapterFactory> r0 = this.factories.iterator();
        boolean r1 = false;
    L7:
        if (r0.hasNext() == false) goto L16;
        TypeAdapterFactory r2 = r0.next();
        if (r1 == false) goto L10;
        TypeAdapter<T> r3 = r2.create(this, r5);
        if (r3 == null) goto L7;
        return r3;
    L10:
        if (r2 != r4) goto L7;
        r1 = true;
        goto L7
    L16:
        throw new IllegalArgumentException("GSON cannot serialize " + r5);
    }

    public void toJson(JsonElement r7, JsonWriter r8) throws JsonIOException {
        boolean r1 = r8.isLenient();
        r8.setLenient(true);
        boolean r2 = r8.isHtmlSafe();
        r8.setHtmlSafe(this.htmlSafe);
        boolean r3 = r8.getSerializeNulls();
        r8.setSerializeNulls(this.serializeNulls);
        Streams.write(r7, r8);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r8.setLenient(r1);
        r8.setHtmlSafe(r2);
        r8.setSerializeNulls(r3);
        return;
    L6:
        th = move-exception;
        r8.setLenient(r1);
        r8.setHtmlSafe(r2);
        r8.setSerializeNulls(r3);
        throw th;
    L11:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public JsonElement toJsonTree(Object r2, Type r3) {
        JsonTreeWriter r0 = new JsonTreeWriter();
        toJson(r2, r3, r0);
        return r0.get();
    }

    public <T> T fromJson(JsonElement r2, Class<T> r3) throws JsonSyntaxException {
        Object r4 = fromJson(r2, TypeToken.get(r3));
        return (T) Primitives.wrap(r3).cast(r4);
    }

    public void toJson(JsonElement r1, Appendable r2) throws JsonIOException {
        toJson(r1, newJsonWriter(Streams.writerForAppendable(r2)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public <T> T fromJson(Reader r2, Class<T> r3) throws JsonSyntaxException, JsonIOException {
        Object r4 = fromJson(r2, TypeToken.get(r3));
        return (T) Primitives.wrap(r3).cast(r4);
    }

    public void toJson(Object r2, Appendable r3) throws JsonIOException {
        if (r2 == null) goto L4;
        toJson(r2, r2.getClass(), r3);
        return;
    L4:
        toJson(JsonNull.INSTANCE, r3);
    }

    public <T> T fromJson(String r2, Class<T> r3) throws JsonSyntaxException {
        Object r4 = fromJson(r2, TypeToken.get(r3));
        return (T) Primitives.wrap(r3).cast(r4);
    }

    public String toJson(Object r2, Type r3) {
        StringWriter r0 = new StringWriter();
        toJson(r2, r3, r0);
        return r0.toString();
    }

    public <T> T fromJson(JsonElement r2, TypeToken<T> r3) throws JsonSyntaxException {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (T) fromJson(new JsonTreeReader(r2), r3);
    }

    public <T> T fromJson(String r2, TypeToken<T> r3) throws JsonSyntaxException {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (T) fromJson(new StringReader(r2), r3);
    }

    public <T> T fromJson(Reader r1, TypeToken<T> r2) throws JsonIOException, JsonSyntaxException {
        JsonReader r3 = newJsonReader(r1);
        T r4 = (T) fromJson(r3, r2);
        assertFullConsumption(r4, r3);
        return r4;
    }

    public <T> T fromJson(JsonElement r1, Type r2) throws JsonSyntaxException {
        return (T) fromJson(r1, TypeToken.get(r2));
    }

    public <T> T fromJson(JsonReader r1, Type r2) throws JsonIOException, JsonSyntaxException {
        return (T) fromJson(r1, TypeToken.get(r2));
    }

    public <T> T fromJson(Reader r1, Type r2) throws JsonIOException, JsonSyntaxException {
        return (T) fromJson(r1, TypeToken.get(r2));
    }

    public <T> T fromJson(String r1, Type r2) throws JsonSyntaxException {
        return (T) fromJson(r1, TypeToken.get(r2));
    }

    public void toJson(Object r6, Type r7, JsonWriter r8) throws JsonIOException {
        TypeAdapter r9 = getAdapter(TypeToken.get(r7));
        boolean r1 = r8.isLenient();
        r8.setLenient(true);
        boolean r2 = r8.isHtmlSafe();
        r8.setHtmlSafe(this.htmlSafe);
        boolean r3 = r8.getSerializeNulls();
        r8.setSerializeNulls(this.serializeNulls);
        r9.write(r8, r6);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r8.setLenient(r1);
        r8.setHtmlSafe(r2);
        r8.setSerializeNulls(r3);
        return;
    L6:
        th = move-exception;
        r8.setLenient(r1);
        r8.setHtmlSafe(r2);
        r8.setSerializeNulls(r3);
        throw th;
    L11:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public void toJson(Object r1, Type r2, Appendable r3) throws JsonIOException {
        toJson(r1, r2, newJsonWriter(Streams.writerForAppendable(r3)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public Gson(Excluder r14, FieldNamingStrategy r15, Map<Type, InstanceCreator<?>> r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, boolean r24, LongSerializationPolicy r25, String r26, int r28, int r29, List<TypeAdapterFactory> r210, List<TypeAdapterFactory> r30, List<TypeAdapterFactory> r31, ToNumberStrategy r32, ToNumberStrategy r33, List<ReflectionAccessFilter> r34) {
        this.threadLocalAdapterResults = new ThreadLocal();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = r14;
        this.fieldNamingStrategy = r15;
        this.instanceCreators = r16;
        ConstructorConstructor r8 = new ConstructorConstructor(r16, r24, r34);
        this.constructorConstructor = r8;
        this.serializeNulls = r17;
        this.complexMapKeySerialization = r18;
        this.generateNonExecutableJson = r19;
        this.htmlSafe = r20;
        this.prettyPrinting = r21;
        this.lenient = r22;
        this.serializeSpecialFloatingPointValues = r23;
        this.useJdkUnsafe = r24;
        this.longSerializationPolicy = r25;
        this.datePattern = r26;
        this.dateStyle = r28;
        this.timeStyle = r29;
        this.builderFactories = r210;
        this.builderHierarchyFactories = r30;
        this.objectToNumberStrategy = r32;
        this.numberToNumberStrategy = r33;
        this.reflectionFilters = r34;
        ArrayList r10 = new ArrayList();
        r10.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        r10.add(ObjectTypeAdapter.getFactory(r32));
        r10.add(r14);
        r10.addAll(r31);
        r10.add(TypeAdapters.STRING_FACTORY);
        r10.add(TypeAdapters.INTEGER_FACTORY);
        r10.add(TypeAdapters.BOOLEAN_FACTORY);
        r10.add(TypeAdapters.BYTE_FACTORY);
        r10.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> r2 = longAdapter(r25);
        r10.add(TypeAdapters.newFactory(Long.TYPE, Long.class, r2));
        r10.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(r23)));
        r10.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(r23)));
        r10.add(NumberTypeAdapter.getFactory(r33));
        r10.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        r10.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        r10.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(r2)));
        r10.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(r2)));
        r10.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        r10.add(TypeAdapters.CHARACTER_FACTORY);
        r10.add(TypeAdapters.STRING_BUILDER_FACTORY);
        r10.add(TypeAdapters.STRING_BUFFER_FACTORY);
        r10.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        r10.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        r10.add(TypeAdapters.newFactory(LazilyParsedNumber.class, TypeAdapters.LAZILY_PARSED_NUMBER));
        r10.add(TypeAdapters.URL_FACTORY);
        r10.add(TypeAdapters.URI_FACTORY);
        r10.add(TypeAdapters.UUID_FACTORY);
        r10.add(TypeAdapters.CURRENCY_FACTORY);
        r10.add(TypeAdapters.LOCALE_FACTORY);
        r10.add(TypeAdapters.INET_ADDRESS_FACTORY);
        r10.add(TypeAdapters.BIT_SET_FACTORY);
        r10.add(DateTypeAdapter.FACTORY);
        r10.add(TypeAdapters.CALENDAR_FACTORY);
        if (SqlTypesSupport.SUPPORTS_SQL_TYPES == false) goto L5;
        r10.add(SqlTypesSupport.TIME_FACTORY);
        r10.add(SqlTypesSupport.DATE_FACTORY);
        r10.add(SqlTypesSupport.TIMESTAMP_FACTORY);
    L5:
        r10.add(ArrayTypeAdapter.FACTORY);
        r10.add(TypeAdapters.CLASS_FACTORY);
        r10.add(new CollectionTypeAdapterFactory(r8));
        r10.add(new MapTypeAdapterFactory(r8, r18));
        JsonAdapterAnnotationTypeAdapterFactory r3 = new JsonAdapterAnnotationTypeAdapterFactory(r8);
        this.jsonAdapterFactory = r3;
        r10.add(r3);
        r10.add(TypeAdapters.ENUM_FACTORY);
        r10.add(new ReflectiveTypeAdapterFactory(r8, r15, r14, r3, r34));
        this.factories = Collections.unmodifiableList(r10);
    }
}
