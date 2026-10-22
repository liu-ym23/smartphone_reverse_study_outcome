package com.squareup.wire;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.internal.Internal;
import el9.a;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
final class RuntimeMessageAdapter<M extends Message<M, B>, B extends Message.Builder<M, B>> extends ProtoAdapter<M> {
    private static final String REDACTED = "██";
    private final Class<B> builderType;
    private final Map<Integer, FieldBinding<M, B>> fieldBindings;
    private final Class<M> messageType;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public int hashCode() {
        return this.messageType.hashCode();
    }

    public B newBuilder() {
        return this.builderType.newInstance();
    L6:
        e = move-exception;
        throw new AssertionError(e);
    }

    public Map<Integer, FieldBinding<M, B>> fieldBindings() {
        return this.fieldBindings;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_squareup_wire_RuntimeMessageAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static <M extends Message<M, B>, B extends Message.Builder<M, B>> RuntimeMessageAdapter<M, B> create(Class<M> r100) {
        Class r101 = getBuilderType(r100);
        LinkedHashMap r102 = new LinkedHashMap();
        Field[] r103 = r100.getDeclaredFields();
        int r104 = r103.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L9;
        Field r106 = r103[r105];
        WireField r107 = (WireField) r106.getAnnotation(WireField.class);
        if (r107 == null) goto L7;
        r102.put(Integer.valueOf(r107.tag()), new FieldBinding(r107, r106, r101));
    L7:
        r105 = r105 + 1;
        goto L3
    L9:
        return new RuntimeMessageAdapter(r100, r101, Collections.unmodifiableMap(r102));
    }

    private static <M extends Message<M, B>, B extends Message.Builder<M, B>> Class<B> getBuilderType(Class<M> r100) {
        return INVOKESTATIC_com_squareup_wire_RuntimeMessageAdapter_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100.getName().concat("$Builder"));
    L6:
        throw new IllegalArgumentException("No builder class found for message type ".concat(r100.getName()));
    }

    @Override // com.squareup.wire.ProtoAdapter
    public M decode(ProtoReader r100) throws IOException {
        Message.Builder r101 = newBuilder();
        long r102 = r100.beginMessage();
    L3:
        int r103 = r100.nextTag();
        if (r103 == (-1)) goto L16;
        FieldBinding<M, B> r104 = this.fieldBindings.get(Integer.valueOf(r103));
        if (r104 == null) goto L12;
        if (r104.isMap() == false) goto L10;
        ProtoAdapter<?> r105 = r104.adapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
    L11:
        r104.value(r101, r105.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        goto L3
    L10:
        r105 = r104.singleAdapter();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
    L14:
        e = move-exception;
        r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
        goto L3
    L12:
        FieldEncoding r106 = r100.peekFieldEncoding();     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        r101.addUnknownField(r103, r106, r106.rawProtoAdapter().decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        goto L3
    L16:
        r100.endMessage(r102);
        return (M) r101.build();
    }

    public int encodedSize(M r100) {
        int r101 = r100.cachedSerializedSize;
        if (r101 == 0) goto L5;
        return r101;
    L5:
        Iterator<FieldBinding<M, B>> r102 = this.fieldBindings.values().iterator();
        int r103 = 0;
    L7:
        if (r102.hasNext() == false) goto L12;
        FieldBinding<M, B> r104 = r102.next();
        Object r105 = r104.get(r100);
        if (r105 == null) goto L7;
        r103 = r103 + r104.adapter().encodedSizeWithTag(r104.tag, r105);
        goto L7
    L12:
        int r106 = r103 + r100.unknownFields().size();
        r100.cachedSerializedSize = r106;
        return r106;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof RuntimeMessageAdapter) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RuntimeMessageAdapter) r100).messageType != this.messageType) goto L7;
        return true;
    }

    public M redact(M r100) {
        Message.Builder<M, B> r101 = r100.newBuilder();
        Iterator<FieldBinding<M, B>> r102 = this.fieldBindings.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L25;
        FieldBinding<M, B> r103 = r102.next();
        if (r103.redacted == true) goto L8;
    L12:
        boolean r104 = Message.class.isAssignableFrom(r103.singleAdapter().javaType);
        if (r103.redacted == true) goto L22;
        if (r104 == false) goto L18;
        if (r103.label.isRepeated() == false) goto L22;
    L18:
        if (r104 == false) goto L4;
        if (r103.label.isRepeated() == false) goto L4;
        Internal.redactElements((List) r103.getFromBuilder(r101), r103.singleAdapter());
    L22:
        Object r105 = r103.getFromBuilder(r101);
        if (r105 == null) goto L4;
        r103.set(r101, r103.adapter().redact(r105));
        goto L4
    L8:
        if (r103.label != WireField.Label.REQUIRED) goto L12;
        throw new UnsupportedOperationException(String.format("Field '%s' in %s is required and cannot be redacted.", new Object[]{r103.name, this.javaType.getName()}));
    L25:
        r101.clearUnknownFields();
        return (M) r101.build();
    }

    public String toString(M r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator<FieldBinding<M, B>> r102 = this.fieldBindings.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        FieldBinding<M, B> r103 = r102.next();
        Object r104 = r103.get(r100);
        if (r104 == null) goto L4;
        r101.append(", ");
        r101.append(r103.name);
        r101.append(com.alipay.sdk.m.n.a.f25612h);
        if (r103.redacted == false) goto L10;
        r104 = REDACTED;
    L10:
        r101.append(r104);
        goto L4
    L11:
        r101.replace(0, 2, this.messageType.getSimpleName().concat("{"));
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object decode(ProtoReader r100) throws IOException {
        return decode(r100);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ int encodedSize(Object r100) {
        return encodedSize((Message) r100);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ Object redact(Object r100) {
        return redact((Message) r100);
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ String toString(Object r100) {
        return toString((Message) r100);
    }

    public void encode(ProtoWriter r100, M r101) throws IOException {
        Iterator<FieldBinding<M, B>> r102 = this.fieldBindings.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        FieldBinding<M, B> r103 = r102.next();
        Object r104 = r103.get(r101);
        if (r104 == null) goto L4;
        r103.adapter().encodeWithTag(r100, r103.tag, r104);
        goto L4
    L9:
        r100.writeBytes(r101.unknownFields());
    }

    @Override // com.squareup.wire.ProtoAdapter
    public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Object r101) throws IOException {
        encode(r100, (Message) r101);
    }

    public RuntimeMessageAdapter(Class<M> r100, Class<B> r101, Map<Integer, FieldBinding<M, B>> r102) {
        super(FieldEncoding.LENGTH_DELIMITED, r100);
        this.messageType = r100;
        this.builderType = r101;
        this.fieldBindings = r102;
    }
}
