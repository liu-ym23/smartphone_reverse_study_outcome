package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0013\u0014\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Gradient;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Gradient$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Gradient$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/Gradient$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/Gradient$Type;", "linear", "Lcom/lark/kmp/pb/basic/v1/Gradient$Linear;", "getLinear", "()Lcom/lark/kmp/pb/basic/v1/Gradient$Linear;", "newBuilder", "toString", "", "Builder", "Companion", "Type", "Linear", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class Gradient extends com.lark.wire.Message<Gradient, a> {
    public static final ProtoAdapter<Gradient> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Linear linear;
    private final Type type;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00162\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Gradient$Linear;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/Gradient$Linear$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/Gradient$Linear$Builder;Lokio/ByteString;)V", "deg", "", "getDeg", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "colors_v2", "", "Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "getColors_v2", "()Ljava/util/List;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Linear extends com.lark.wire.Message<Linear, a> {
        public static final ProtoAdapter<Linear> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_DEG = 0;
        private static final long serialVersionUID = 0;
        private final List<ThemeColor> colors_v2;
        private final Integer deg;

        public static final class a extends com.lark.wire.Message.a<Linear, a> {
            public Integer d;
            public List<ThemeColor> e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Linear(this, c(), null);
            }

            public a() {
                this.e = CollectionsKt.emptyList();
            }
        }

        public static final class b extends ProtoAdapter<Linear> {
            @Override // com.lark.wire.ProtoAdapter
            public final Linear c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r0 = new a();
                ArrayList r1 = new ArrayList();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L12;
                if (r4 != 1) goto L8;
                r0.d = (Integer) ProtoAdapter.h.c(r7);
                goto L3
            L8:
                if (r4 != 3) goto L9;
                r1.add(ThemeColor.ADAPTER.c(r7));
                goto L3
            L9:
                r7.j(r4);
                goto L3
            L12:
                ByteString r8 = r7.d(r2);
                Intrinsics.checkNotNullParameter(r1, "colors_v2");
                com.lark.wire.internal.a.a(r1);
                r0.e = r1;
                return new Linear(r0, r8, null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Linear r5) {
                Linear r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.h.l(1, r6.getDeg())) + ThemeColor.ADAPTER.a().l(3, r6.getColors_v2());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Linear r5) {
                Linear r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.h.i(r4, 1, r6.getDeg());
                ThemeColor.ADAPTER.a().i(r4, 3, r6.getColors_v2());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Linear r5) {
                Linear r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ThemeColor.ADAPTER.a().j(r4, 3, r6.getColors_v2());
                ProtoAdapter.h.j(r4, 1, r6.getDeg());
            }

            public b(FieldEncoding r7, KClass<Linear> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.Gradient.Linear", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Linear(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Linear.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.deg;
            r0.e = this.colors_v2;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Linear.class).getSimpleName() + '@' + hashCode();
        }

        public final List<ThemeColor> getColors_v2() {
            return this.colors_v2;
        }

        public final Integer getDeg() {
            return this.deg;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Linear(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.deg = r2.d;
            this.colors_v2 = com.lark.wire.internal.a.c("colors_v2", r2.e);
        }

        public /* synthetic */ Linear(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \n2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/Gradient$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LINEAR", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type LINEAR = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                if (r2 == 0) goto L7;
                return null;
            L7:
                return Type.LINEAR;
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type();
            LINEAR = r0;
            Type[] r1 = {r0};
            a = r1;
            b = EnumEntriesKt.enumEntries(r1);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
        }

        public Type() {
            super("LINEAR", 0);
            this.value = 0;
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L7;
            return null;
        L7:
            return LINEAR;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }
    }

    public static final class a extends com.lark.wire.Message.a<Gradient, a> {
        public Type d;
        public Linear e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new Gradient(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<Gradient> {
        @Override // com.lark.wire.ProtoAdapter
        public final Gradient c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L16;
            if (r3 != 1) goto L8;
            r0.d = Type.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.e = Linear.ADAPTER.c(r9);
            goto L3
        L9:
            r9.j(r3);
            goto L3
        L16:
            return new Gradient(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(Gradient r5) {
            Gradient r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + Type.ADAPTER.l(1, r6.getType())) + Linear.ADAPTER.l(2, r6.getLinear());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, Gradient r5) {
            Gradient r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            Type.ADAPTER.i(r4, 1, r6.getType());
            Linear.ADAPTER.i(r4, 2, r6.getLinear());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, Gradient r5) {
            Gradient r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            Linear.ADAPTER.j(r4, 2, r6.getLinear());
            Type.ADAPTER.j(r4, 1, r6.getType());
        }

        public b(FieldEncoding r7, KClass<Gradient> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.Gradient", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ Gradient(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Gradient.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.e = this.linear;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(Gradient.class).getSimpleName() + '@' + hashCode();
    }

    public final Linear getLinear() {
        return this.linear;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public Gradient(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.type = r2.d;
        this.linear = r2.e;
    }

    public /* synthetic */ Gradient(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
