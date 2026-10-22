package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.b0;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004\u0017\u0018\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ThemeColor;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ThemeColor$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ThemeColor$Builder;Lokio/ByteString;)V", "token", "", "getToken", "()Ljava/lang/String;", "key", "Lcom/lark/kmp/pb/basic/v1/ThemeColor$Key;", "getKey", "()Lcom/lark/kmp/pb/basic/v1/ThemeColor$Key;", "value", "", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "Builder", "Companion", "KeyType", "Key", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ThemeColor extends com.lark.wire.Message<ThemeColor, a> {
    public static final ProtoAdapter<ThemeColor> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Key key;
    private final String token;
    private final Integer value;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ThemeColor$Key;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/ThemeColor$Key$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/ThemeColor$Key$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/ThemeColor$KeyType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/ThemeColor$KeyType;", "value", "", "getValue", "()I", "alpha", "getAlpha", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Key extends com.lark.wire.Message<Key, a> {
        public static final ProtoAdapter<Key> ADAPTER = null;
        public static final c Companion = null;
        public static final int DEFAULT_ALPHA = 100;
        private static final long serialVersionUID = 0;
        private final Integer alpha;
        private final KeyType type;
        private final int value;

        public static final class a extends com.lark.wire.Message.a<Key, a> {
            public KeyType d;
            public Integer e;
            public Integer f;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Key(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Key> {
            @Override // com.lark.wire.ProtoAdapter
            public final Key c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L19;
                if (r3 != 1) goto L8;
                KeyType r4 = KeyType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                Intrinsics.checkNotNullParameter(r4, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
                r0.d = r4;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = Integer.valueOf(((Number) ProtoAdapter.i.c(r9)).intValue());
                goto L3
            L10:
                if (r3 != 3) goto L11;
                r0.f = (Integer) ProtoAdapter.i.c(r9);
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L19:
                return new Key(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Key r5) {
                Key r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size() + KeyType.ADAPTER.l(1, r6.getType());
                b0 r1 = ProtoAdapter.i;
                return (r0 + r1.l(2, Integer.valueOf(r6.getValue()))) + r1.l(3, r6.getAlpha());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Key r5) {
                Key r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                KeyType.ADAPTER.i(r4, 1, r6.getType());
                b0 r0 = ProtoAdapter.i;
                r0.i(r4, 2, Integer.valueOf(r6.getValue()));
                r0.i(r4, 3, r6.getAlpha());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Key r5) {
                Key r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                b0 r0 = ProtoAdapter.i;
                r0.j(r4, 3, r6.getAlpha());
                r0.j(r4, 2, Integer.valueOf(r6.getValue()));
                KeyType.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<Key> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.ThemeColor.Key", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Key(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Key.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = Integer.valueOf(this.value);
            r0.f = this.alpha;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Key.class).getSimpleName() + '@' + hashCode();
        }

        public final Integer getAlpha() {
            return this.alpha;
        }

        public final KeyType getType() {
            return this.type;
        }

        public final int getValue() {
            return this.value;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Key(a r2, ByteString r3) {
            super(ADAPTER, r3);
            KeyType r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.type = r4;
            Integer r5 = r2.e;
            Intrinsics.checkNotNull(r5);
            this.value = r5.intValue();
            this.alpha = r2.f;
        }

        public /* synthetic */ Key(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ThemeColor$KeyType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "N", "B", "W", "T", "G", "L", "Y", "S", "O", "R", "C", "V", "P", "I", "STATIC_WHITE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum KeyType extends Enum<KeyType> implements o0 {
        public static final ProtoAdapter<KeyType> ADAPTER = null;
        public static final KeyType B = null;
        public static final KeyType C = null;
        public static final b Companion = null;
        public static final KeyType G = null;
        public static final KeyType I = null;
        public static final KeyType L = null;
        public static final KeyType N = null;
        public static final KeyType O = null;
        public static final KeyType P = null;
        public static final KeyType R = null;
        public static final KeyType S = null;
        public static final KeyType STATIC_WHITE = null;
        public static final KeyType T = null;
        public static final KeyType V = null;
        public static final KeyType W = null;
        public static final KeyType Y = null;
        public static final /* synthetic */ KeyType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<KeyType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                KeyType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<KeyType> r1, Syntax r2, KeyType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static KeyType a(int r0) {
                switch(r0) {
                    case 0: goto L19;
                    case 1: goto L34;
                    case 2: goto L33;
                    case 3: goto L32;
                    case 4: goto L31;
                    case 5: goto L30;
                    case 6: goto L29;
                    case 7: goto L28;
                    case 8: goto L27;
                    case 9: goto L26;
                    case 10: goto L25;
                    case 11: goto L24;
                    case 12: goto L23;
                    case 13: goto L22;
                    case 14: goto L21;
                    default: goto L3;
                };
            L3:
                return null;
            L21:
                return KeyType.STATIC_WHITE;
            L22:
                return KeyType.I;
            L23:
                return KeyType.P;
            L24:
                return KeyType.V;
            L25:
                return KeyType.C;
            L26:
                return KeyType.R;
            L27:
                return KeyType.O;
            L28:
                return KeyType.S;
            L29:
                return KeyType.Y;
            L30:
                return KeyType.L;
            L31:
                return KeyType.G;
            L32:
                return KeyType.T;
            L33:
                return KeyType.W;
            L34:
                return KeyType.B;
            L19:
                return KeyType.N;
            }
        }

        @JvmStatic
        public static final KeyType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<KeyType> getEntries() {
            return b;
        }

        static {
            KeyType r0 = new KeyType("N", 0, 0);
            N = r0;
            KeyType r1 = new KeyType("B", 1, 1);
            B = r1;
            KeyType r3 = new KeyType("W", 2, 2);
            W = r3;
            KeyType r5 = new KeyType("T", 3, 3);
            T = r5;
            KeyType r7 = new KeyType("G", 4, 4);
            G = r7;
            KeyType r9 = new KeyType("L", 5, 5);
            L = r9;
            KeyType r11 = new KeyType("Y", 6, 6);
            Y = r11;
            KeyType r13 = new KeyType("S", 7, 7);
            S = r13;
            KeyType r15 = new KeyType("O", 8, 8);
            O = r15;
            KeyType r14 = new KeyType("R", 9, 9);
            R = r14;
            KeyType r12 = new KeyType("C", 10, 10);
            C = r12;
            KeyType r10 = new KeyType("V", 11, 11);
            V = r10;
            KeyType r8 = new KeyType("P", 12, 12);
            P = r8;
            KeyType r6 = new KeyType("I", 13, 13);
            I = r6;
            KeyType r4 = new KeyType("STATIC_WHITE", 14, 14);
            STATIC_WHITE = r4;
            KeyType[] r2 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(KeyType.class), Syntax.PROTO_2, r0);
        }

        public static KeyType[] values() {
            return (KeyType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static KeyType valueOf(String r1) {
            return (KeyType) r27.a.a(KeyType.class, r1);
        }

        public KeyType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<ThemeColor, a> {
        public String d;
        public Key e;
        public Integer f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new ThemeColor(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<ThemeColor> {
        @Override // com.lark.wire.ProtoAdapter
        public final ThemeColor c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L16;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = Key.ADAPTER.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L11;
            r1.f = (Integer) ProtoAdapter.i.c(r7);
            goto L3
        L11:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L16:
            return new ThemeColor(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(ThemeColor r5) {
            ThemeColor r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getToken())) + Key.ADAPTER.l(2, r6.getKey())) + ProtoAdapter.i.l(3, r6.getValue());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, ThemeColor r5) {
            ThemeColor r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getToken());
            Key.ADAPTER.i(r4, 2, r6.getKey());
            ProtoAdapter.i.i(r4, 3, r6.getValue());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, ThemeColor r5) {
            ThemeColor r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.i.j(r4, 3, r6.getValue());
            Key.ADAPTER.j(r4, 2, r6.getKey());
            ProtoAdapter.q.j(r4, 1, r6.getToken());
        }

        public b(FieldEncoding r7, KClass<ThemeColor> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.ThemeColor", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ ThemeColor(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ThemeColor.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.token;
        r0.e = this.key;
        r0.f = this.value;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(ThemeColor.class).getSimpleName() + '@' + hashCode();
    }

    public final Key getKey() {
        return this.key;
    }

    public final String getToken() {
        return this.token;
    }

    public final Integer getValue() {
        return this.value;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public ThemeColor(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.token = r2.d;
        this.key = r2.e;
        this.value = r2.f;
    }

    public /* synthetic */ ThemeColor(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
