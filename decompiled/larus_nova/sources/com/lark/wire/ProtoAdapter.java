package com.lark.wire;

import com.byted.cast.common.Constants;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes24.dex */
public abstract class ProtoAdapter<E> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final l f282718g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final s f282719h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b0 f282720i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final p f282721j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final t f282722k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final c0 f282723l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final q f282724m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final f f282725n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final c f282726o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final m f282727p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final w f282728q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final y f282729r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final x f282730s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final z f282731t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a0 f282732u = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FieldEncoding f282733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass<?> f282734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f282735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Syntax f282736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E f282737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k0 f282738f;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\t¢\u0006\u0004\b\u0007\u0010\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/lark/wire/ProtoAdapter$EnumConstantNotFoundException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "value", "", "type", "Lkotlin/reflect/KClass;", "<init>", "(ILkotlin/reflect/KClass;)V", "Ljava/lang/Class;", "(ILjava/lang/Class;)V", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EnumConstantNotFoundException extends IllegalArgumentException {
        public final int value;

        public EnumConstantNotFoundException(int r100, KClass<?> r101) {
            StringBuilder r102 = new StringBuilder("Unknown enum tag ");
            r102.append(r100);
            r102.append(" for ");
            if (r101 == null) goto L7;
            Class r103 = JvmClassMappingKt.getJavaClass(r101);
            if (r103 == null) goto L7;
            String r104 = r103.getName();
        L8:
            r102.append(r104);
            super(r102.toString());
            this.value = r100;
            return;
        L7:
            r104 = null;
            goto L8
        }

        public EnumConstantNotFoundException(int r100, Class<?> r101) {
            Intrinsics.checkNotNullParameter(r101, "type");
            this(r100, JvmClassMappingKt.getKotlinClass(r101));
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: com.lark.wire.ProtoAdapter$a$a, reason: collision with other inner class name */
        public static final class C3884a extends ProtoAdapter {
            public C3884a() {
                FieldEncoding r100 = FieldEncoding.LENGTH_DELIMITED;
                KClass r101 = Reflection.getOrCreateKotlinClass(Void.class);
                Intrinsics.checkNotNullParameter(r100, "fieldEncoding");
                Syntax r102 = Syntax.PROTO_2;
                Intrinsics.checkNotNullParameter(r100, "fieldEncoding");
                Intrinsics.checkNotNullParameter(r102, "syntax");
                super(r100, r101, r102, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final Object b(h0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.lark.wire.ProtoAdapter
            public final Object c(g0 r100) {
                Intrinsics.checkNotNullParameter(r100, "reader");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Object r100) {
                Intrinsics.checkNotNullParameter((Void) r100, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r100, Object r101) {
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter((Void) r101, "value");
                throw new IllegalStateException("Operation not supported.");
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r100, Object r101) {
                Intrinsics.checkNotNullParameter(r100, "writer");
                Intrinsics.checkNotNullParameter((Void) r101, "value");
                throw new IllegalStateException("Operation not supported.");
            }
        }

        @JvmStatic
        public static j a(ProtoAdapter r100, ProtoAdapter r101) {
            Intrinsics.checkNotNullParameter(r100, "keyAdapter");
            Intrinsics.checkNotNullParameter(r101, "valueAdapter");
            return new j(r100, r101);
        }
    }

    public ProtoAdapter() {
        throw null;
    }

    public abstract E c(g0 r100) throws IOException;

    public abstract void f(j0 r100, E r101) throws IOException;

    public abstract int k(E r100);

    static {
        FieldEncoding r100 = FieldEncoding.VARINT;
        KClass r101 = Reflection.getOrCreateKotlinClass(Boolean.TYPE);
        Syntax r102 = Syntax.PROTO_2;
        l r103 = new l(r100, r101, r102);
        f282718g = r103;
        Class r104 = Integer.TYPE;
        s r105 = new s(r100, Reflection.getOrCreateKotlinClass(r104), r102);
        f282719h = r105;
        new g(r105);
        b0 r106 = new b0(r100, Reflection.getOrCreateKotlinClass(r104), r102);
        f282720i = r106;
        new g(r106);
        new g(new u(r100, Reflection.getOrCreateKotlinClass(r104), r102));
        FieldEncoding r107 = FieldEncoding.FIXED32;
        p r108 = new p(r107, Reflection.getOrCreateKotlinClass(r104), r102);
        f282721j = r108;
        new g(r108);
        new g(new p(r107, Reflection.getOrCreateKotlinClass(r104), r102));
        Class r109 = Long.TYPE;
        t r110 = new t(r100, Reflection.getOrCreateKotlinClass(r109), r102);
        f282722k = r110;
        new h(r110);
        c0 r111 = new c0(r100, Reflection.getOrCreateKotlinClass(r109), r102);
        f282723l = r111;
        new h(r111);
        new h(new v(r100, Reflection.getOrCreateKotlinClass(r109), r102));
        FieldEncoding r112 = FieldEncoding.FIXED64;
        q r113 = new q(r112, Reflection.getOrCreateKotlinClass(r109), r102);
        f282724m = r113;
        new h(r113);
        new h(new q(r112, Reflection.getOrCreateKotlinClass(r109), r102));
        f r114 = new f();
        f282725n = r114;
        new e(r114);
        c r115 = new c();
        f282726o = r115;
        new b(r115);
        FieldEncoding r116 = FieldEncoding.LENGTH_DELIMITED;
        m r117 = new m(r116, Reflection.getOrCreateKotlinClass(ByteString.class), r102, ByteString.EMPTY);
        f282727p = r117;
        w r118 = new w(r116, Reflection.getOrCreateKotlinClass(String.class), r102);
        f282728q = r118;
        KClass r119 = Reflection.getOrCreateKotlinClass(Unit.class);
        Syntax r120 = Syntax.PROTO_3;
        new o(r116, r119, r120);
        f282729r = new y(r116, Reflection.getOrCreateKotlinClass(Map.class), r120);
        f282730s = new x(r116, Reflection.getOrCreateKotlinClass(Map.class), r120);
        f282731t = new z(r100, Reflection.getOrCreateKotlinClass(Void.class), r120);
        f282732u = new a0(r116, Reflection.getOrCreateKotlinClass(Object.class), r120);
        f0.a(r115, "type.googleapis.com/google.protobuf.DoubleValue");
        f0.a(r114, "type.googleapis.com/google.protobuf.FloatValue");
        f0.a(r110, "type.googleapis.com/google.protobuf.Int64Value");
        f0.a(r111, "type.googleapis.com/google.protobuf.UInt64Value");
        f0.a(r105, "type.googleapis.com/google.protobuf.Int32Value");
        f0.a(r106, "type.googleapis.com/google.protobuf.UInt32Value");
        f0.a(r103, "type.googleapis.com/google.protobuf.BoolValue");
        f0.a(r118, "type.googleapis.com/google.protobuf.StringValue");
        f0.a(r117, "type.googleapis.com/google.protobuf.BytesValue");
        new n(r116, Reflection.getOrCreateKotlinClass(Duration.class), r120);     // Catch: NoClassDefFoundError -> L5
    L10:
        new r(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Instant.class), Syntax.PROTO_3);     // Catch: NoClassDefFoundError -> L8
        return;
    L8:
        new a.C3884a();
        return;
    L5:
        new a.C3884a();
        goto L10
    }

    public final k0 a() {
        k0 r100 = this.f282738f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new UnsupportedOperationException("Can't create a repeated adapter from a repeated or packed adapter.");
    }

    public final KClass<?> getType() {
        return this.f282734b;
    }

    public E b(h0 r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "reader");
        return c(r100.i());
    }

    public final E d(ByteString r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        int r101 = r100.size();
        Intrinsics.checkNotNullParameter(r100, "source");
        return b(new com.lark.wire.a(r100.toByteArray(), 0, r101));
    }

    public final E e(byte[] r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        int r101 = r100.length;
        Intrinsics.checkNotNullParameter(r100, "source");
        return b(new com.lark.wire.a(r100, 0, r101));
    }

    public void g(n0 r100, E r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "writer");
        e0 r102 = new e0(this, r101);
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "block");
        r102.invoke((j0) r100.f282778g.getValue());
        r100.d(((Buffer) r100.f282777f.getValue()).readByteString());
    }

    public final void h(BufferedSink r100, E r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        n0 r102 = new n0();
        g(r102, r101);
        Intrinsics.checkNotNullParameter(r100, Constants.ROLE_SINK);
        r102.a();
        r100.writeAll(r102.f282772a);
    }

    public int l(int r100, E r101) {
        if (r101 != null) goto L4;
        return 0;
    L4:
        int r102 = k(r101);
        if (this.f282733a != FieldEncoding.LENGTH_DELIMITED) goto L7;
        int r103 = j0.f282766b;
        r102 = r102 + j0.a.a(r102);
    L7:
        int r104 = j0.f282766b;
        FieldEncoding r105 = FieldEncoding.VARINT;
        Intrinsics.checkNotNullParameter(r105, "fieldEncoding");
        return j0.a.a((r100 << 3) | r105.getValue$wire_runtime()) + r102;
    }

    public final void m(g0 r100, List<E> r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "reader");
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        if (r100.b() == false) goto L6;
        ArrayList r102 = (ArrayList) r101;
        r102.add(c(r100));
        return;
    }

    public void i(j0 r100, int r101, E r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "writer");
        if (r102 == null) goto L9;
        r100.b(r101, this.f282733a);
        if (this.f282733a != FieldEncoding.LENGTH_DELIMITED) goto L7;
        r100.c(k(r102));
    L7:
        f(r100, r102);
        return;
    }

    public void j(n0 r100, int r101, E r102) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "writer");
        if (r102 != null) goto L5;
        return;
    L5:
        if (this.f282733a != FieldEncoding.LENGTH_DELIMITED) goto L7;
        int r103 = r100.b();
        g(r100, r102);
        r100.h(r100.b() - r103);
    L8:
        r100.g(r101, this.f282733a);
        return;
    L7:
        g(r100, r102);
        goto L8
    }

    public ProtoAdapter(FieldEncoding r100, KClass r101, Syntax r102, Object r110) {
        Intrinsics.checkNotNullParameter(r100, "fieldEncoding");
        Intrinsics.checkNotNullParameter(r102, "syntax");
        this(r100, r101, null, r102, r110);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoAdapter(FieldEncoding r100, KClass r101, String r102, Syntax r103, Object r104) {
        Intrinsics.checkNotNullParameter(r100, "fieldEncoding");
        Intrinsics.checkNotNullParameter(r103, "syntax");
        this.f282733a = r100;
        this.f282734b = r101;
        this.f282735c = r102;
        this.f282736d = r103;
        this.f282737e = r104;
        boolean r105 = this instanceof k;
        if (r105 == true) goto L18;
        if ((this instanceof k0) == true) goto L18;
        FieldEncoding r106 = FieldEncoding.LENGTH_DELIMITED;
        if (r100 == r106) goto L18;
        if (r100 == r106) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L16;
        new k(this);
        goto L18
    L16:
        throw new IllegalArgumentException("Unable to pack a length-delimited type.".toString());
    L12:
        r107 = false;
    L18:
        if ((this instanceof k0) == true) goto L22;
        if (r105 == true) goto L22;
        k0 r108 = new k0(this);
    L23:
        this.f282738f = r108;
        return;
    L22:
        r108 = null;
        goto L23
    }

    public /* synthetic */ ProtoAdapter(FieldEncoding r100, KClass r101, String r102, Syntax r110, Object r111, int r112) {
        if ((r112 & 16) == 0) goto L5;
        r111 = null;
    L5:
        this(r100, r101, r102, r110, r111);
    }
}
