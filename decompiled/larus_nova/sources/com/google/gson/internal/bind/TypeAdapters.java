package com.google.gson.internal.bind;

import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.security.AccessController;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes.dex */
public final class TypeAdapters {
    public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN = null;
    public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY = null;
    public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER = null;
    public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY = null;
    public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY = null;
    public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY = null;
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL = null;
    public static final TypeAdapter<BigInteger> BIG_INTEGER = null;
    public static final TypeAdapter<BitSet> BIT_SET = null;
    public static final TypeAdapterFactory BIT_SET_FACTORY = null;
    public static final TypeAdapter<Boolean> BOOLEAN = null;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING = null;
    public static final TypeAdapterFactory BOOLEAN_FACTORY = null;
    public static final TypeAdapter<Number> BYTE = null;
    public static final TypeAdapterFactory BYTE_FACTORY = null;
    public static final TypeAdapter<Calendar> CALENDAR = null;
    public static final TypeAdapterFactory CALENDAR_FACTORY = null;
    public static final TypeAdapter<Character> CHARACTER = null;
    public static final TypeAdapterFactory CHARACTER_FACTORY = null;
    public static final TypeAdapter<Class> CLASS = null;
    public static final TypeAdapterFactory CLASS_FACTORY = null;
    public static final TypeAdapter<Currency> CURRENCY = null;
    public static final TypeAdapterFactory CURRENCY_FACTORY = null;
    public static final TypeAdapter<Number> DOUBLE = null;
    public static final TypeAdapterFactory ENUM_FACTORY = null;
    public static final TypeAdapter<Number> FLOAT = null;
    public static final TypeAdapter<InetAddress> INET_ADDRESS = null;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY = null;
    public static final TypeAdapter<Number> INTEGER = null;
    public static final TypeAdapterFactory INTEGER_FACTORY = null;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT = null;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY = null;
    public static final TypeAdapter<LazilyParsedNumber> LAZILY_PARSED_NUMBER = null;
    public static final TypeAdapter<Locale> LOCALE = null;
    public static final TypeAdapterFactory LOCALE_FACTORY = null;
    public static final TypeAdapter<Number> LONG = null;
    public static final TypeAdapter<Number> SHORT = null;
    public static final TypeAdapterFactory SHORT_FACTORY = null;
    public static final TypeAdapter<String> STRING = null;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER = null;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY = null;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER = null;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY = null;
    public static final TypeAdapterFactory STRING_FACTORY = null;
    public static final TypeAdapter<URI> URI = null;
    public static final TypeAdapterFactory URI_FACTORY = null;
    public static final TypeAdapter<URL> URL = null;
    public static final TypeAdapterFactory URL_FACTORY = null;
    public static final TypeAdapter<UUID> UUID = null;
    public static final TypeAdapterFactory UUID_FACTORY = null;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.TypeAdapters$35, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass35 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r100;
            r100[JsonToken.NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Map<T, String> constantToName;
        private final Map<String, T> nameToConstant;
        private final Map<String, T> stringToConstant;

        public EnumTypeAdapter(final Class<T> r110) {
            this.nameToConstant = new HashMap();
            this.stringToConstant = new HashMap();
            this.constantToName = new HashMap();
            Field[] r111 = (Field[]) AccessController.doPrivileged(new AnonymousClass1(this, r110));     // Catch: IllegalAccessException -> L13
            int r100 = r111.length;     // Catch: IllegalAccessException -> L13
            int r101 = 0;
        L4:
            if (r101 >= r100) goto L12;
            Field r102 = r111[r101];     // Catch: IllegalAccessException -> L13
            Enum r103 = (Enum) r102.get(null);     // Catch: IllegalAccessException -> L13
            String r104 = r103.name();     // Catch: IllegalAccessException -> L13
            String r105 = r103.toString();     // Catch: IllegalAccessException -> L13
            SerializedName r106 = (SerializedName) r102.getAnnotation(SerializedName.class);     // Catch: IllegalAccessException -> L13
            if (r106 == null) goto L10;
            r104 = r106.value();     // Catch: IllegalAccessException -> L13
            String[] r107 = r106.alternate();     // Catch: IllegalAccessException -> L13
            int r108 = r107.length;     // Catch: IllegalAccessException -> L13
            int r109 = 0;
        L8:
            if (r109 >= r108) goto L10;
            String r112 = r107[r109];     // Catch: IllegalAccessException -> L13
            this.nameToConstant.put(r112, (T) r103);     // Catch: IllegalAccessException -> L13
            r109 = r109 + 1;     // Catch: IllegalAccessException -> L13
        L10:
            this.nameToConstant.put(r104, (T) r103);     // Catch: IllegalAccessException -> L13
            this.stringToConstant.put(r105, (T) r103);     // Catch: IllegalAccessException -> L13
            this.constantToName.put((T) r103, r104);     // Catch: IllegalAccessException -> L13
            r101 = r101 + 1;
            goto L4
        L12:
            return;
        L13:
            e = move-exception;
            throw new AssertionError(e);
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r100) throws IOException {
            if (r100.peek() != JsonToken.NULL) goto L6;
            r100.nextNull();
            return null;
        L6:
            String r101 = r100.nextString();
            T r102 = this.nameToConstant.get(r101);
            if (r102 == null) goto L9;
            return r102;
        L9:
            return this.stringToConstant.get(r101);
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ Object read(JsonReader r100) throws IOException {
            return read(r100);
        }

        public void write(JsonWriter r100, T r101) throws IOException {
            if (r101 != null) goto L4;
            String r102 = null;
        L5:
            r100.value(r102);
            return;
        L4:
            r102 = this.constantToName.get(r101);
            goto L5
        }

        @Override // com.google.gson.TypeAdapter
        public /* bridge */ /* synthetic */ void write(JsonWriter r100, Object r101) throws IOException {
            write(r100, (Enum) r101);
        }
    }

    static {
        TypeAdapter<Class> r100 = new AnonymousClass1().nullSafe();
        CLASS = r100;
        CLASS_FACTORY = newFactory(Class.class, r100);
        TypeAdapter<BitSet> r101 = new AnonymousClass2().nullSafe();
        BIT_SET = r101;
        BIT_SET_FACTORY = newFactory(BitSet.class, r101);
        TypeAdapter<Boolean> r102 = new AnonymousClass3();
        BOOLEAN = r102;
        BOOLEAN_AS_STRING = new AnonymousClass4();
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, r102);
        TypeAdapter<Number> r103 = new AnonymousClass5();
        BYTE = r103;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, r103);
        TypeAdapter<Number> r104 = new AnonymousClass6();
        SHORT = r104;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, r104);
        TypeAdapter<Number> r105 = new AnonymousClass7();
        INTEGER = r105;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, r105);
        TypeAdapter<AtomicInteger> r106 = new AnonymousClass8().nullSafe();
        ATOMIC_INTEGER = r106;
        ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, r106);
        TypeAdapter<AtomicBoolean> r107 = new AnonymousClass9().nullSafe();
        ATOMIC_BOOLEAN = r107;
        ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, r107);
        TypeAdapter<AtomicIntegerArray> r108 = new AnonymousClass10().nullSafe();
        ATOMIC_INTEGER_ARRAY = r108;
        ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, r108);
        LONG = new AnonymousClass11();
        FLOAT = new AnonymousClass12();
        DOUBLE = new AnonymousClass13();
        TypeAdapter<Character> r109 = new AnonymousClass14();
        CHARACTER = r109;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, r109);
        TypeAdapter<String> r110 = new AnonymousClass15();
        STRING = r110;
        BIG_DECIMAL = new AnonymousClass16();
        BIG_INTEGER = new AnonymousClass17();
        LAZILY_PARSED_NUMBER = new AnonymousClass18();
        STRING_FACTORY = newFactory(String.class, r110);
        TypeAdapter<StringBuilder> r111 = new AnonymousClass19();
        STRING_BUILDER = r111;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, r111);
        TypeAdapter<StringBuffer> r112 = new AnonymousClass20();
        STRING_BUFFER = r112;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, r112);
        TypeAdapter<URL> r113 = new AnonymousClass21();
        URL = r113;
        URL_FACTORY = newFactory(URL.class, r113);
        TypeAdapter<URI> r114 = new AnonymousClass22();
        URI = r114;
        URI_FACTORY = newFactory(URI.class, r114);
        TypeAdapter<InetAddress> r115 = new AnonymousClass23();
        INET_ADDRESS = r115;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, r115);
        TypeAdapter<UUID> r116 = new AnonymousClass24();
        UUID = r116;
        UUID_FACTORY = newFactory(UUID.class, r116);
        TypeAdapter<Currency> r117 = new AnonymousClass25().nullSafe();
        CURRENCY = r117;
        CURRENCY_FACTORY = newFactory(Currency.class, r117);
        TypeAdapter<Calendar> r118 = new AnonymousClass26();
        CALENDAR = r118;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, r118);
        TypeAdapter<Locale> r119 = new AnonymousClass27();
        LOCALE = r119;
        LOCALE_FACTORY = newFactory(Locale.class, r119);
        TypeAdapter<JsonElement> r120 = new AnonymousClass28();
        JSON_ELEMENT = r120;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, r120);
        ENUM_FACTORY = new AnonymousClass29();
    }

    private TypeAdapters() {
        throw new UnsupportedOperationException();
    }

    public static <TT> TypeAdapterFactory newFactory(final TypeToken<TT> r100, final TypeAdapter<TT> r101) {
        return new AnonymousClass30(r100, r101);
    }

    public static <T1> TypeAdapterFactory newTypeHierarchyFactory(final Class<T1> r100, final TypeAdapter<T1> r101) {
        return new AnonymousClass34(r100, r101);
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> r100, final TypeAdapter<TT> r101) {
        return new AnonymousClass31(r100, r101);
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> r100, final Class<TT> r101, final TypeAdapter<? super TT> r102) {
        return new AnonymousClass32(r100, r101, r102);
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(final Class<TT> r100, final Class<? extends TT> r101, final TypeAdapter<? super TT> r102) {
        return new AnonymousClass33(r100, r101, r102);
    }
}
