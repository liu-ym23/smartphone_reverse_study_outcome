package com.google.gson;

import androidx.camera.video.AudioStats;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class GsonBuilder {
    private boolean complexMapKeySerialization;
    private String datePattern;
    private int dateStyle;
    private boolean escapeHtmlChars;
    private Excluder excluder;
    private final List<TypeAdapterFactory> factories;
    private FieldNamingStrategy fieldNamingPolicy;
    private boolean generateNonExecutableJson;
    private final List<TypeAdapterFactory> hierarchyFactories;
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private boolean lenient;
    private LongSerializationPolicy longSerializationPolicy;
    private ToNumberStrategy numberToNumberStrategy;
    private ToNumberStrategy objectToNumberStrategy;
    private boolean prettyPrinting;
    private final LinkedList<ReflectionAccessFilter> reflectionFilters;
    private boolean serializeNulls;
    private boolean serializeSpecialFloatingPointValues;
    private int timeStyle;
    private boolean useJdkUnsafe;

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder disableJdkUnsafe() {
        this.useJdkUnsafe = false;
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public Gson create() {
        ArrayList r100 = new ArrayList((this.factories.size() + this.hierarchyFactories.size()) + 3);
        r100.addAll(this.factories);
        Collections.reverse(r100);
        ArrayList r101 = new ArrayList(this.hierarchyFactories);
        Collections.reverse(r101);
        r100.addAll(r101);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, r100);
        return new Gson(this.excluder, this.fieldNamingPolicy, new HashMap(this.instanceCreators), this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.useJdkUnsafe, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, new ArrayList(this.factories), new ArrayList(this.hierarchyFactories), r100, this.objectToNumberStrategy, this.numberToNumberStrategy, new ArrayList(this.reflectionFilters));
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder() {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList();
        this.hierarchyFactories = new ArrayList();
        this.serializeNulls = false;
        this.datePattern = Gson.DEFAULT_DATE_PATTERN;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = Gson.DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
        this.numberToNumberStrategy = Gson.DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
        this.reflectionFilters = new LinkedList();
    }

    public GsonBuilder(Gson r100) {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        HashMap r101 = new HashMap();
        this.instanceCreators = r101;
        ArrayList r102 = new ArrayList();
        this.factories = r102;
        ArrayList r103 = new ArrayList();
        this.hierarchyFactories = r103;
        this.serializeNulls = false;
        this.datePattern = Gson.DEFAULT_DATE_PATTERN;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = Gson.DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
        this.numberToNumberStrategy = Gson.DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
        LinkedList<ReflectionAccessFilter> r104 = new LinkedList();
        this.reflectionFilters = r104;
        this.excluder = r100.excluder;
        this.fieldNamingPolicy = r100.fieldNamingStrategy;
        r101.putAll(r100.instanceCreators);
        this.serializeNulls = r100.serializeNulls;
        this.complexMapKeySerialization = r100.complexMapKeySerialization;
        this.generateNonExecutableJson = r100.generateNonExecutableJson;
        this.escapeHtmlChars = r100.htmlSafe;
        this.prettyPrinting = r100.prettyPrinting;
        this.lenient = r100.lenient;
        this.serializeSpecialFloatingPointValues = r100.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = r100.longSerializationPolicy;
        this.datePattern = r100.datePattern;
        this.dateStyle = r100.dateStyle;
        this.timeStyle = r100.timeStyle;
        r102.addAll(r100.builderFactories);
        r103.addAll(r100.builderHierarchyFactories);
        this.useJdkUnsafe = r100.useJdkUnsafe;
        this.objectToNumberStrategy = r100.objectToNumberStrategy;
        this.numberToNumberStrategy = r100.numberToNumberStrategy;
        r104.addAll(r100.reflectionFilters);
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy r100) {
        Objects.requireNonNull(r100);
        this.excluder = this.excluder.withExclusionStrategy(r100, false, true);
        return this;
    }

    public GsonBuilder addReflectionAccessFilter(ReflectionAccessFilter r100) {
        Objects.requireNonNull(r100);
        this.reflectionFilters.addFirst(r100);
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy r100) {
        Objects.requireNonNull(r100);
        this.excluder = this.excluder.withExclusionStrategy(r100, true, false);
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... r100) {
        Objects.requireNonNull(r100);
        this.excluder = this.excluder.withModifiers(r100);
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory r100) {
        Objects.requireNonNull(r100);
        this.factories.add(r100);
        return this;
    }

    public GsonBuilder setDateFormat(int r100) {
        this.dateStyle = r100;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... r100) {
        Objects.requireNonNull(r100);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ExclusionStrategy r103 = r100[r102];
        this.excluder = this.excluder.withExclusionStrategy(r103, true, true);
        r102 = r102 + 1;
        goto L3
    L5:
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy r100) {
        return setFieldNamingStrategy(r100);
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy r100) {
        Objects.requireNonNull(r100);
        this.fieldNamingPolicy = r100;
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy r100) {
        Objects.requireNonNull(r100);
        this.longSerializationPolicy = r100;
        return this;
    }

    public GsonBuilder setNumberToNumberStrategy(ToNumberStrategy r100) {
        Objects.requireNonNull(r100);
        this.numberToNumberStrategy = r100;
        return this;
    }

    public GsonBuilder setObjectToNumberStrategy(ToNumberStrategy r100) {
        Objects.requireNonNull(r100);
        this.objectToNumberStrategy = r100;
        return this;
    }

    public GsonBuilder setVersion(double r100) {
        if (Double.isNaN(r100) == true) goto L9;
        if (r100 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        this.excluder = this.excluder.withVersion(r100);
        return this;
    L9:
        throw new IllegalArgumentException("Invalid version: " + r100);
    }

    public GsonBuilder setDateFormat(String r100) {
        this.datePattern = r100;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type r100, Object r101) {
        Objects.requireNonNull(r100);
        boolean r102 = r101 instanceof JsonSerializer;
        if (r102 == false) goto L5;
    L12:
        boolean r103 = true;
    L13:
        C$Gson$Preconditions.checkArgument(r103);
        if ((r101 instanceof InstanceCreator) == false) goto L16;
        this.instanceCreators.put(r100, (InstanceCreator) r101);
    L16:
        if (r102 == false) goto L18;
    L19:
        TypeToken<?> r104 = TypeToken.get(r100);
        this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(r104, r101));
    L21:
        if ((r101 instanceof TypeAdapter) == false) goto L23;
        TypeAdapterFactory r105 = TypeAdapters.newFactory(TypeToken.get(r100), (TypeAdapter) r101);
        this.factories.add(r105);
    L23:
        return this;
    L18:
        if ((r101 instanceof JsonDeserializer) == false) goto L21;
    L5:
        if ((r101 instanceof JsonDeserializer) == true) goto L12;
        if ((r101 instanceof InstanceCreator) == true) goto L12;
        if ((r101 instanceof TypeAdapter) == true) goto L12;
        r103 = false;
        goto L13
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> r100, Object r101) {
        Objects.requireNonNull(r100);
        boolean r102 = r101 instanceof JsonSerializer;
        if (r102 == false) goto L5;
    L10:
        boolean r103 = true;
    L11:
        C$Gson$Preconditions.checkArgument(r103);
        if ((r101 instanceof JsonDeserializer) == true) goto L14;
        if (r102 == true) goto L14;
    L16:
        if ((r101 instanceof TypeAdapter) == false) goto L18;
        TypeAdapterFactory r104 = TypeAdapters.newTypeHierarchyFactory(r100, (TypeAdapter) r101);
        this.factories.add(r104);
    L18:
        return this;
    L14:
        this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(r100, r101));
        goto L16
    L5:
        if ((r101 instanceof JsonDeserializer) == true) goto L10;
        if ((r101 instanceof TypeAdapter) == true) goto L10;
        r103 = false;
        goto L11
    }

    public GsonBuilder setDateFormat(int r100, int r101) {
        this.dateStyle = r100;
        this.timeStyle = r101;
        this.datePattern = null;
        return this;
    }

    private void addTypeAdaptersForDate(String r100, int r101, int r102, List<TypeAdapterFactory> r103) {
        boolean r104 = SqlTypesSupport.SUPPORTS_SQL_TYPES;
        TypeAdapterFactory r105 = null;
        if (r100 == null) goto L11;
        if (r100.trim().isEmpty() == true) goto L11;
        TypeAdapterFactory r106 = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(r100);
        if (r104 == false) goto L9;
        r105 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(r100);
        TypeAdapterFactory r107 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(r100);
    L17:
        r103.add(r106);
        if (r104 == false) goto L23;
        r103.add(r105);
        r103.add(r107);
        return;
    L23:
        return;
    L9:
        r107 = null;
    L11:
        if (r101 == 2) goto L21;
        if (r102 == 2) goto L22;
        TypeAdapterFactory r108 = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(r101, r102);
        if (r104 == false) goto L16;
        r105 = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(r101, r102);
        TypeAdapterFactory r109 = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(r101, r102);
        r106 = r108;
        r107 = r109;
        goto L17
    L16:
        r106 = r108;
        goto L9
    L22:
        return;
    }
}
