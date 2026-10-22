package com.google.gson;

import com.alipay.sdk.m.u.i;
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
import tb2.c;

/* JADX INFO: loaded from: classes.dex */
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
            TypeAdapter<T> r100 = this.delegate;
            if (r100 == null) goto L6;
            return r100;
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
        public T read(JsonReader r100) throws IOException {
            return delegate().read(r100);
        }

        public void setDelegate(TypeAdapter<T> r100) {
            if (this.delegate != null) goto L7;
            this.delegate = r100;
            return;
        L7:
            throw new AssertionError("Delegate is already set");
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r100, T r101) throws IOException {
            delegate().write(r100, r101);
        }
    }

    public TypeAdapter getAdapter(TypeToken r100) {
        return com_google_gson_Gson_com_larus_utils_gson_GsonHook_getAdapter(this, r100);
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
        return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + i.f25855d;
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

    private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> r100) {
        return new AnonymousClass4(r100).nullSafe();
    }

    private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> r100) {
        return new AnonymousClass5(r100).nullSafe();
    }

    public static void checkValidFloatingPoint(double r100) {
        if (Double.isNaN(r100) == true) goto L8;
        if (Double.isInfinite(r100) == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException(r100 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
    }

    private TypeAdapter<Number> doubleAdapter(boolean r100) {
        if (r100 == false) goto L6;
        return TypeAdapters.DOUBLE;
    L6:
        return new AnonymousClass1(this);
    }

    private TypeAdapter<Number> floatAdapter(boolean r100) {
        if (r100 == false) goto L6;
        return TypeAdapters.FLOAT;
    L6:
        return new AnonymousClass2(this);
    }

    private static TypeAdapter<Number> longAdapter(LongSerializationPolicy r100) {
        if (r100 != LongSerializationPolicy.DEFAULT) goto L7;
        return TypeAdapters.LONG;
    L7:
        return new AnonymousClass3();
    }

    public <T> TypeAdapter<T> com_google_gson_Gson__getAdapter$___twin___(TypeToken<T> r100) {
        Objects.requireNonNull(r100, "type must not be null");
        TypeAdapter<T> r101 = (TypeAdapter) this.typeTokenCache.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        Map<? extends TypeToken<?>, ? extends TypeAdapter<?>> r102 = this.threadLocalAdapterResults.get();
        if (r102 != null) goto L8;
        r102 = new HashMap();
        this.threadLocalAdapterResults.set((Map<TypeToken<?>, TypeAdapter<?>>) r102);
        boolean r103 = true;
    L30:
        FutureTypeAdapter r104 = new FutureTypeAdapter();     // Catch: Throwable -> L26
        r102.put(r100, r104);     // Catch: Throwable -> L26
        Iterator<TypeAdapterFactory> r105 = this.factories.iterator();     // Catch: Throwable -> L26
        TypeAdapter<T> r106 = null;
    L14:
        if (r105.hasNext() == false) goto L18;
        r106 = r105.next().create(this, r100);     // Catch: Throwable -> L26
        if (r106 == null) goto L14;
        r104.setDelegate(r106);     // Catch: Throwable -> L26
        r102.put(r100, r106);     // Catch: Throwable -> L26
    L18:
        if (r103 == false) goto L20;
        this.threadLocalAdapterResults.remove();
    L20:
        if (r106 == null) goto L25;
        if (r103 == false) goto L23;
        this.typeTokenCache.putAll(r102);
    L23:
        return r106;
    L25:
        throw new IllegalArgumentException("GSON (2.10.1) cannot handle " + r100);
    L26:
        th = move-exception;
        if (r103 == false) goto L29;
        this.threadLocalAdapterResults.remove();
    L29:
        throw th;
    L8:
        TypeAdapter<T> r107 = (TypeAdapter) r102.get(r100);
        if (r107 == null) goto L11;
        return r107;
    L11:
        r103 = false;
        goto L30
    }

    public <T> TypeAdapter<T> getAdapter(Class<T> r100) {
        return getAdapter(TypeToken.get(r100));
    }

    public JsonReader newJsonReader(Reader r100) {
        JsonReader r101 = new JsonReader(r100);
        r101.setLenient(this.lenient);
        return r101;
    }

    public JsonWriter newJsonWriter(Writer r100) throws IOException {
        if (this.generateNonExecutableJson == false) goto L5;
        r100.write(JSON_NON_EXECUTABLE_PREFIX);
    L5:
        JsonWriter r101 = new JsonWriter(r100);
        if (this.prettyPrinting == false) goto L8;
        r101.setIndent(c.DEFAULT_TEXT);
    L8:
        r101.setHtmlSafe(this.htmlSafe);
        r101.setLenient(this.lenient);
        r101.setSerializeNulls(this.serializeNulls);
        return r101;
    }

    public String toJson(Object r100) {
        if (r100 != null) goto L6;
        return toJson(JsonNull.INSTANCE);
    L6:
        return toJson(r100, r100.getClass());
    }

    public JsonElement toJsonTree(Object r100) {
        if (r100 != null) goto L6;
        return JsonNull.INSTANCE;
    L6:
        return toJsonTree(r100, r100.getClass());
    }

    public String toJson(JsonElement r100) {
        StringWriter r101 = new StringWriter();
        toJson(r100, r101);
        return r101.toString();
    }

    private static void assertFullConsumption(Object r100, JsonReader r101) {
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

    public static TypeAdapter com_google_gson_Gson_com_larus_utils_gson_GsonHook_getAdapter(Gson r100, TypeToken r101) {
        List<TypeAdapterFactory> r102 = r100.factories;
        if (r102 != null) goto L5;
    L30:
        ArrayList r103 = new ArrayList();
        r103.add(GCKAKotlinxSerializableTypeAdapterFactory.f375402a);
        r103.add(GCKAKotlinxJsonTypeAdapterFactory.f375396a);
        r102 = Collections.unmodifiableList(r103);
    L31:
        r100.factories = r102;
        return r100.com_google_gson_Gson__getAdapter$___twin___(r101);
    L5:
        if (r102.isEmpty() == true) goto L30;
        Iterator<TypeAdapterFactory> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L15;
        TypeAdapterFactory r105 = r104.next();
        if (r105 == GCKAKotlinxJsonTypeAdapterFactory.f375396a) goto L31;
        if (r105 != GCKAKotlinxSerializableTypeAdapterFactory.f375402a) goto L9;
    L15:
        ArrayList r106 = new ArrayList();
        Iterator<TypeAdapterFactory> r107 = r102.iterator();
        boolean r108 = false;
    L17:
        if (r107.hasNext() == false) goto L27;
        TypeAdapterFactory r109 = r107.next();
        GCKAKotlinxJsonTypeAdapterFactory r110 = GCKAKotlinxJsonTypeAdapterFactory.f375396a;
        if (r109 == r110) goto L17;
        GCKAKotlinxSerializableTypeAdapterFactory r111 = GCKAKotlinxSerializableTypeAdapterFactory.f375402a;
        if (r109 == r111) goto L17;
        if (r109 != TypeAdapters.STRING_FACTORY) goto L26;
        r106.add(r111);
        r106.add(r110);
        r108 = true;
    L26:
        r106.add(r109);
        goto L17
    L27:
        if (r108 == true) goto L29;
        ListProtector.add(r106, 0, GCKAKotlinxSerializableTypeAdapterFactory.f375402a);
        ListProtector.add(r106, 0, GCKAKotlinxJsonTypeAdapterFactory.f375396a);
    L29:
        r102 = Collections.unmodifiableList(r106);
        goto L31
    }

    public <T> T fromJson(JsonReader r100, TypeToken<T> r101) throws JsonIOException, JsonSyntaxException {
        boolean r102 = r100.isLenient();
        boolean r103 = true;
        r100.setLenient(true);
        r100.peek();     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11 IllegalStateException -> L14 EOFException -> L17
        r103 = false;
        T r104 = (T) getAdapter(r101).read(r100);
        r100.setLenient(r102);
        return r104;
    L6:
        th = move-exception;
        r100.setLenient(r102);
        throw th;
    L17:
        e = move-exception;
        if (r103 == false) goto L22;
        r100.setLenient(r102);
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

    public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory r100, TypeToken<T> r101) {
        if (this.factories.contains(r100) == true) goto L5;
        r100 = this.jsonAdapterFactory;
    L5:
        Iterator<TypeAdapterFactory> r102 = this.factories.iterator();
        boolean r103 = false;
    L7:
        if (r102.hasNext() == false) goto L16;
        TypeAdapterFactory r104 = r102.next();
        if (r103 == false) goto L10;
        TypeAdapter<T> r105 = r104.create(this, r101);
        if (r105 == null) goto L7;
        return r105;
    L10:
        if (r104 != r100) goto L7;
        r103 = true;
        goto L7
    L16:
        throw new IllegalArgumentException("GSON cannot serialize " + r101);
    }

    public void toJson(JsonElement r100, JsonWriter r101) throws JsonIOException {
        boolean r102 = r101.isLenient();
        r101.setLenient(true);
        boolean r103 = r101.isHtmlSafe();
        r101.setHtmlSafe(this.htmlSafe);
        boolean r104 = r101.getSerializeNulls();
        r101.setSerializeNulls(this.serializeNulls);
        Streams.write(r100, r101);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r101.setLenient(r102);
        r101.setHtmlSafe(r103);
        r101.setSerializeNulls(r104);
        return;
    L6:
        th = move-exception;
        r101.setLenient(r102);
        r101.setHtmlSafe(r103);
        r101.setSerializeNulls(r104);
        throw th;
    L11:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public JsonElement toJsonTree(Object r100, Type r101) {
        JsonTreeWriter r102 = new JsonTreeWriter();
        toJson(r100, r101, r102);
        return r102.get();
    }

    public <T> T fromJson(JsonElement r100, Class<T> r101) throws JsonSyntaxException {
        Object r102 = fromJson(r100, TypeToken.get(r101));
        return (T) Primitives.wrap(r101).cast(r102);
    }

    public void toJson(JsonElement r100, Appendable r101) throws JsonIOException {
        toJson(r100, newJsonWriter(Streams.writerForAppendable(r101)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public <T> T fromJson(Reader r100, Class<T> r101) throws JsonSyntaxException, JsonIOException {
        Object r102 = fromJson(r100, TypeToken.get(r101));
        return (T) Primitives.wrap(r101).cast(r102);
    }

    public void toJson(Object r100, Appendable r101) throws JsonIOException {
        if (r100 == null) goto L4;
        toJson(r100, r100.getClass(), r101);
        return;
    L4:
        toJson(JsonNull.INSTANCE, r101);
    }

    public <T> T fromJson(String r100, Class<T> r101) throws JsonSyntaxException {
        Object r102 = fromJson(r100, TypeToken.get(r101));
        return (T) Primitives.wrap(r101).cast(r102);
    }

    public String toJson(Object r100, Type r101) {
        StringWriter r102 = new StringWriter();
        toJson(r100, r101, r102);
        return r102.toString();
    }

    public <T> T fromJson(JsonElement r100, TypeToken<T> r101) throws JsonSyntaxException {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (T) fromJson(new JsonTreeReader(r100), r101);
    }

    public <T> T fromJson(String r100, TypeToken<T> r101) throws JsonSyntaxException {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (T) fromJson(new StringReader(r100), r101);
    }

    public <T> T fromJson(Reader r100, TypeToken<T> r101) throws JsonIOException, JsonSyntaxException {
        JsonReader r102 = newJsonReader(r100);
        T r103 = (T) fromJson(r102, r101);
        assertFullConsumption(r103, r102);
        return r103;
    }

    public <T> T fromJson(JsonElement r100, Type r101) throws JsonSyntaxException {
        return (T) fromJson(r100, TypeToken.get(r101));
    }

    public <T> T fromJson(JsonReader r100, Type r101) throws JsonIOException, JsonSyntaxException {
        return (T) fromJson(r100, TypeToken.get(r101));
    }

    public <T> T fromJson(Reader r100, Type r101) throws JsonIOException, JsonSyntaxException {
        return (T) fromJson(r100, TypeToken.get(r101));
    }

    public <T> T fromJson(String r100, Type r101) throws JsonSyntaxException {
        return (T) fromJson(r100, TypeToken.get(r101));
    }

    public void toJson(Object r100, Type r101, JsonWriter r102) throws JsonIOException {
        TypeAdapter r103 = getAdapter(TypeToken.get(r101));
        boolean r104 = r102.isLenient();
        r102.setLenient(true);
        boolean r105 = r102.isHtmlSafe();
        r102.setHtmlSafe(this.htmlSafe);
        boolean r106 = r102.getSerializeNulls();
        r102.setSerializeNulls(this.serializeNulls);
        r103.write(r102, r100);     // Catch: Throwable -> L6 AssertionError -> L8 IOException -> L11
        r102.setLenient(r104);
        r102.setHtmlSafe(r105);
        r102.setSerializeNulls(r106);
        return;
    L6:
        th = move-exception;
        r102.setLenient(r104);
        r102.setHtmlSafe(r105);
        r102.setSerializeNulls(r106);
        throw th;
    L11:
        e = move-exception;
        throw new JsonIOException(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        throw new AssertionError("AssertionError (GSON 2.10.1): " + e.getMessage(), e);     // Catch: Throwable -> L6
    }

    public void toJson(Object r100, Type r101, Appendable r102) throws JsonIOException {
        toJson(r100, r101, newJsonWriter(Streams.writerForAppendable(r102)));     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new JsonIOException(e);
    }

    public Gson(Excluder r110, FieldNamingStrategy r111, Map<Type, InstanceCreator<?>> r112, boolean r113, boolean r114, boolean r115, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, LongSerializationPolicy r215, String r216, int r217, int r218, List<TypeAdapterFactory> r219, List<TypeAdapterFactory> r310, List<TypeAdapterFactory> r311, ToNumberStrategy r312, ToNumberStrategy r313, List<ReflectionAccessFilter> r314) {
        this.threadLocalAdapterResults = new ThreadLocal();
        this.typeTokenCache = new ConcurrentHashMap();
        this.excluder = r110;
        this.fieldNamingStrategy = r111;
        this.instanceCreators = r112;
        ConstructorConstructor r100 = new ConstructorConstructor(r112, r214, r314);
        this.constructorConstructor = r100;
        this.serializeNulls = r113;
        this.complexMapKeySerialization = r114;
        this.generateNonExecutableJson = r115;
        this.htmlSafe = r210;
        this.prettyPrinting = r211;
        this.lenient = r212;
        this.serializeSpecialFloatingPointValues = r213;
        this.useJdkUnsafe = r214;
        this.longSerializationPolicy = r215;
        this.datePattern = r216;
        this.dateStyle = r217;
        this.timeStyle = r218;
        this.builderFactories = r219;
        this.builderHierarchyFactories = r310;
        this.objectToNumberStrategy = r312;
        this.numberToNumberStrategy = r313;
        this.reflectionFilters = r314;
        ArrayList r116 = new ArrayList();
        r116.add(TypeAdapters.JSON_ELEMENT_FACTORY);
        r116.add(ObjectTypeAdapter.getFactory(r312));
        r116.add(r110);
        r116.addAll(r311);
        r116.add(TypeAdapters.STRING_FACTORY);
        r116.add(TypeAdapters.INTEGER_FACTORY);
        r116.add(TypeAdapters.BOOLEAN_FACTORY);
        r116.add(TypeAdapters.BYTE_FACTORY);
        r116.add(TypeAdapters.SHORT_FACTORY);
        TypeAdapter<Number> r101 = longAdapter(r215);
        r116.add(TypeAdapters.newFactory(Long.TYPE, Long.class, r101));
        r116.add(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(r213)));
        r116.add(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(r213)));
        r116.add(NumberTypeAdapter.getFactory(r313));
        r116.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
        r116.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
        r116.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(r101)));
        r116.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(r101)));
        r116.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
        r116.add(TypeAdapters.CHARACTER_FACTORY);
        r116.add(TypeAdapters.STRING_BUILDER_FACTORY);
        r116.add(TypeAdapters.STRING_BUFFER_FACTORY);
        r116.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
        r116.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
        r116.add(TypeAdapters.newFactory(LazilyParsedNumber.class, TypeAdapters.LAZILY_PARSED_NUMBER));
        r116.add(TypeAdapters.URL_FACTORY);
        r116.add(TypeAdapters.URI_FACTORY);
        r116.add(TypeAdapters.UUID_FACTORY);
        r116.add(TypeAdapters.CURRENCY_FACTORY);
        r116.add(TypeAdapters.LOCALE_FACTORY);
        r116.add(TypeAdapters.INET_ADDRESS_FACTORY);
        r116.add(TypeAdapters.BIT_SET_FACTORY);
        r116.add(DateTypeAdapter.FACTORY);
        r116.add(TypeAdapters.CALENDAR_FACTORY);
        if (SqlTypesSupport.SUPPORTS_SQL_TYPES == false) goto L5;
        r116.add(SqlTypesSupport.TIME_FACTORY);
        r116.add(SqlTypesSupport.DATE_FACTORY);
        r116.add(SqlTypesSupport.TIMESTAMP_FACTORY);
    L5:
        r116.add(ArrayTypeAdapter.FACTORY);
        r116.add(TypeAdapters.CLASS_FACTORY);
        r116.add(new CollectionTypeAdapterFactory(r100));
        r116.add(new MapTypeAdapterFactory(r100, r114));
        JsonAdapterAnnotationTypeAdapterFactory r102 = new JsonAdapterAnnotationTypeAdapterFactory(r100);
        this.jsonAdapterFactory = r102;
        r116.add(r102);
        r116.add(TypeAdapters.ENUM_FACTORY);
        r116.add(new ReflectiveTypeAdapterFactory(r100, r111, r110, r102, r314));
        this.factories = Collections.unmodifiableList(r116);
    }
}
