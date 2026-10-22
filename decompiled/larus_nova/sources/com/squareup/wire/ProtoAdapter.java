package com.squareup.wire;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ProtoAdapter<E> {
    public static final ProtoAdapter<Boolean> BOOL = null;
    public static final ProtoAdapter<ByteString> BYTES = null;
    public static final ProtoAdapter<Double> DOUBLE = null;
    public static final ProtoAdapter<Integer> FIXED32 = null;
    public static final ProtoAdapter<Long> FIXED64 = null;
    private static final int FIXED_32_SIZE = 4;
    private static final int FIXED_64_SIZE = 8;
    private static final int FIXED_BOOL_SIZE = 1;
    public static final ProtoAdapter<Float> FLOAT = null;
    public static final ProtoAdapter<Integer> INT32 = null;
    public static final ProtoAdapter<Long> INT64 = null;
    public static final ProtoAdapter<Integer> SFIXED32 = null;
    public static final ProtoAdapter<Long> SFIXED64 = null;
    public static final ProtoAdapter<Integer> SINT32 = null;
    public static final ProtoAdapter<Long> SINT64 = null;
    public static final ProtoAdapter<String> STRING = null;
    public static final ProtoAdapter<Integer> UINT32 = null;
    public static final ProtoAdapter<Long> UINT64 = null;
    private final FieldEncoding fieldEncoding;
    final Class<?> javaType;
    ProtoAdapter<List<E>> packedAdapter;
    ProtoAdapter<List<E>> repeatedAdapter;

    /* JADX INFO: loaded from: classes34.dex */
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        public EnumConstantNotFoundException(int r100, Class<?> r101) {
            super("Unknown enum tag " + r100 + " for " + r101.getCanonicalName());
            this.value = r100;
        }
    }

    public static final class MapEntryProtoAdapter<K, V> extends ProtoAdapter<Map.Entry<K, V>> {
        final ProtoAdapter<K> keyAdapter;
        final ProtoAdapter<V> valueAdapter;

        @Override // com.squareup.wire.ProtoAdapter
        public Map.Entry<K, V> decode(ProtoReader r100) {
            throw new UnsupportedOperationException();
        }

        public int encodedSize(Map.Entry<K, V> r100) {
            return this.keyAdapter.encodedSizeWithTag(1, r100.getKey()) + this.valueAdapter.encodedSizeWithTag(2, r100.getValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r100) {
            return encodedSize((Map.Entry) r100);
        }

        public MapEntryProtoAdapter(ProtoAdapter<K> r100, ProtoAdapter<V> r101) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.keyAdapter = r100;
            this.valueAdapter = r101;
        }

        public void encode(ProtoWriter r100, Map.Entry<K, V> r101) throws IOException {
            this.keyAdapter.encodeWithTag(r100, 1, r101.getKey());
            this.valueAdapter.encodeWithTag(r100, 2, r101.getValue());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Object r101) throws IOException {
            encode(r100, (Map.Entry) r101);
        }
    }

    public static final class MapProtoAdapter<K, V> extends ProtoAdapter<Map<K, V>> {
        private final MapEntryProtoAdapter<K, V> entryAdapter;

        @Override // com.squareup.wire.ProtoAdapter
        public Map<K, V> decode(ProtoReader r100) throws IOException {
            long r101 = r100.beginMessage();
            K r102 = null;
            V r103 = null;
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L12;
            if (r104 != 1) goto L8;
            r102 = this.entryAdapter.keyAdapter.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L3;
            r103 = this.entryAdapter.valueAdapter.decode(r100);
            goto L3
        L12:
            r100.endMessage(r101);
            if (r102 == null) goto L20;
            if (r103 == null) goto L18;
            return Collections.singletonMap(r102, r103);
        L18:
            throw new IllegalStateException("Map entry with null value");
        L20:
            throw new IllegalStateException("Map entry with null key");
        }

        public int encodedSize(Map<K, V> r100) {
            throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object redact(Object r100) {
            return redact((Map) r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Object decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Object r100) {
            return encodedSize((Map) r100);
        }

        public Map<K, V> redact(Map<K, V> r100) {
            return Collections.emptyMap();
        }

        public MapProtoAdapter(ProtoAdapter<K> r100, ProtoAdapter<V> r101) {
            super(FieldEncoding.LENGTH_DELIMITED, null);
            this.entryAdapter = new MapEntryProtoAdapter(r100, r101);
        }

        public void encode(ProtoWriter r100, Map<K, V> r101) {
            throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
        }

        public int encodedSizeWithTag(int r100, Map<K, V> r101) {
            Iterator<Map.Entry<K, V>> r102 = r101.entrySet().iterator();
            int r103 = 0;
        L4:
            if (r102.hasNext() == false) goto L6;
            Map.Entry<K, V> r104 = r102.next();
            r103 = r103 + this.entryAdapter.encodedSizeWithTag(r100, r104);
            goto L4
        L6:
            return r103;
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Object r101) throws IOException {
            encode(r100, (Map) r101);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSizeWithTag(int r100, Object r101) {
            return encodedSizeWithTag(r100, (Map) r101);
        }

        public void encodeWithTag(ProtoWriter r100, int r101, Map<K, V> r102) throws IOException {
            Iterator<Map.Entry<K, V>> r103 = r102.entrySet().iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            Map.Entry<K, V> r104 = r103.next();
            this.entryAdapter.encodeWithTag(r100, r101, r104);
            goto L4
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encodeWithTag(ProtoWriter r100, int r101, Object r102) throws IOException {
            encodeWithTag(r100, r101, (Map) r102);
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public abstract E decode(ProtoReader r100) throws IOException;

    public abstract void encode(ProtoWriter r100, E r101) throws IOException;

    public abstract int encodedSize(E r100);

    public E redact(E r100) {
        return null;
    }

    static {
        final FieldEncoding r100 = FieldEncoding.VARINT;
        final Class<Boolean> r101 = Boolean.class;
        BOOL = new AnonymousClass1(r100, r101);
        final Class<Integer> r102 = Integer.class;
        INT32 = new AnonymousClass2(r100, r102);
        final Class<Integer> r103 = Integer.class;
        UINT32 = new AnonymousClass3(r100, r103);
        final Class<Integer> r104 = Integer.class;
        SINT32 = new AnonymousClass4(r100, r104);
        final FieldEncoding r105 = FieldEncoding.FIXED32;
        final Class<Integer> r106 = Integer.class;
        ProtoAdapter<Integer> r107 = new AnonymousClass5(r105, r106);
        FIXED32 = r107;
        SFIXED32 = r107;
        final Class<Long> r108 = Long.class;
        INT64 = new AnonymousClass6(r100, r108);
        final Class<Long> r109 = Long.class;
        UINT64 = new AnonymousClass7(r100, r109);
        final Class<Long> r110 = Long.class;
        SINT64 = new AnonymousClass8(r100, r110);
        final FieldEncoding r111 = FieldEncoding.FIXED64;
        final Class<Long> r112 = Long.class;
        ProtoAdapter<Long> r113 = new AnonymousClass9(r111, r112);
        FIXED64 = r113;
        SFIXED64 = r113;
        final Class<Float> r114 = Float.class;
        FLOAT = new AnonymousClass10(r105, r114);
        final Class<Double> r115 = Double.class;
        DOUBLE = new AnonymousClass11(r111, r115);
        final FieldEncoding r116 = FieldEncoding.LENGTH_DELIMITED;
        final Class<String> r117 = String.class;
        STRING = new AnonymousClass12(r116, r117);
        final Class<ByteString> r118 = ByteString.class;
        BYTES = new AnonymousClass13(r116, r118);
    }

    private ProtoAdapter<List<E>> createPacked() {
        FieldEncoding r100 = this.fieldEncoding;
        final FieldEncoding r101 = FieldEncoding.LENGTH_DELIMITED;
        if (r100 == r101) goto L7;
        final Class<List> r102 = List.class;
        return new AnonymousClass14(this, r101, r102);
    L7:
        throw new IllegalArgumentException("Unable to pack a length-delimited type.");
    }

    private ProtoAdapter<List<E>> createRepeated() {
        final FieldEncoding r100 = this.fieldEncoding;
        final Class<List> r101 = List.class;
        return new AnonymousClass15(this, r100, r101);
    }

    public final ProtoAdapter<List<E>> asPacked() {
        ProtoAdapter<List<E>> r100 = this.packedAdapter;
        if (r100 != null) goto L7;
        ProtoAdapter<List<E>> r101 = createPacked();
        this.packedAdapter = r101;
        return r101;
    L7:
        return r100;
    }

    public final ProtoAdapter<List<E>> asRepeated() {
        ProtoAdapter<List<E>> r100 = this.repeatedAdapter;
        if (r100 != null) goto L7;
        ProtoAdapter<List<E>> r101 = createRepeated();
        this.repeatedAdapter = r101;
        return r101;
    L7:
        return r100;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_squareup_wire_ProtoAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static ProtoAdapter<?> get(String r100) {
        int r101 = r100.indexOf(35);     // Catch: ClassNotFoundException -> L5 Throwable -> L7 IllegalAccessException -> L9
        String r102 = r100.substring(0, r101);     // Catch: ClassNotFoundException -> L5 Throwable -> L7 IllegalAccessException -> L9
        return (ProtoAdapter) INVOKESTATIC_com_squareup_wire_ProtoAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r102).getField(r100.substring(r101 + 1)).get(null);
    L7:
        e = move-exception;
        throw new IllegalArgumentException("failed to access " + r100, e);
    }

    public static <E extends WireEnum> RuntimeEnumAdapter<E> newEnumAdapter(Class<E> r100) {
        return new RuntimeEnumAdapter(r100);
    }

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> ProtoAdapter<M> newMessageAdapter(Class<M> r100) {
        return RuntimeMessageAdapter.create(r100);
    }

    public final E decode(InputStream r100) throws IOException {
        Preconditions.checkNotNull(r100, "stream == null");
        return decode(Okio.buffer(Okio.source(r100)));
    }

    public final byte[] encode(E r100) {
        Preconditions.checkNotNull(r100, "value == null");
        Buffer r101 = new Buffer();
        encode(r101, r100);     // Catch: IOException -> L6
        return r101.readByteArray();
    L6:
        e = move-exception;
        throw new AssertionError(e);
    }

    public String toString(E r100) {
        return r100.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoAdapter<?> withLabel(WireField.Label r100) {
        if (r100.isRepeated() == true) goto L5;
        return this;
    L5:
        if (r100.isPacked() == false) goto L8;
        return asPacked();
    L8:
        return asRepeated();
    }

    public static <M> ProtoAdapter<M> get(Class<M> r100) {
        return (ProtoAdapter) r100.getField("ADAPTER").get(null);
    L6:
        e = move-exception;
        throw new IllegalArgumentException("failed to access " + r100.getName() + "#ADAPTER", e);
    }

    public final E decode(ByteString r100) throws IOException {
        Preconditions.checkNotNull(r100, "bytes == null");
        return decode(new Buffer().write(r100));
    }

    public static <M extends Message> ProtoAdapter<M> get(M r100) {
        return get(r100.getClass());
    }

    public final E decode(byte[] r100) throws IOException {
        Preconditions.checkNotNull(r100, "bytes == null");
        return decode(new Buffer().write(r100));
    }

    public final E decode(BufferedSource r100) throws IOException {
        Preconditions.checkNotNull(r100, "source == null");
        return decode(new ProtoReader(r100));
    }

    public ProtoAdapter(FieldEncoding r100, Class<?> r101) {
        this.fieldEncoding = r100;
        this.javaType = r101;
    }

    public static <K, V> ProtoAdapter<Map<K, V>> newMapAdapter(ProtoAdapter<K> r100, ProtoAdapter<V> r101) {
        return new MapProtoAdapter(r100, r101);
    }

    public final void encode(OutputStream r100, E r101) throws IOException {
        Preconditions.checkNotNull(r101, "value == null");
        Preconditions.checkNotNull(r100, "stream == null");
        BufferedSink r102 = Okio.buffer(Okio.sink(r100));
        encode(r102, r101);
        r102.emit();
    }

    public int encodedSizeWithTag(int r100, E r101) {
        if (r101 != null) goto L5;
        return 0;
    L5:
        int r102 = encodedSize(r101);
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) goto L9;
        r102 = r102 + ProtoWriter.varint32Size(r102);
    L9:
        return r102 + ProtoWriter.tagSize(r100);
    }

    public final void encode(BufferedSink r100, E r101) throws IOException {
        Preconditions.checkNotNull(r101, "value == null");
        Preconditions.checkNotNull(r100, "sink == null");
        encode(new ProtoWriter(r100), r101);
    }

    public void encodeWithTag(ProtoWriter r100, int r101, E r102) throws IOException {
        if (r102 != null) goto L4;
        return;
    L4:
        r100.writeTag(r101, this.fieldEncoding);
        if (this.fieldEncoding != FieldEncoding.LENGTH_DELIMITED) goto L7;
        r100.writeVarint32(encodedSize(r102));
    L7:
        encode(r100, r102);
    }
}
