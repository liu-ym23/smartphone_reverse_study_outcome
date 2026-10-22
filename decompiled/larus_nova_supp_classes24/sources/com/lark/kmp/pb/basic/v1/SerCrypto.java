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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SerCrypto;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/SerCrypto$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/SerCrypto$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/SerCrypto$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/SerCrypto$Type;", "cipher", "Lcom/lark/kmp/pb/basic/v1/Cipher;", "getCipher", "()Lcom/lark/kmp/pb/basic/v1/Cipher;", "newBuilder", "toString", "", "Builder", "Companion", "Type", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class SerCrypto extends com.lark.wire.Message<SerCrypto, a> {
    public static final ProtoAdapter<SerCrypto> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Cipher cipher;
    private final Type type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/SerCrypto$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "AES_256_GCM", "AES_CTR", "CRYPTO_SDK_UNIFIED", "CRYPTO_SDK_DOWNGRADE", "CRYPTO_SDK_THIRDPARTY", "SM4_128", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AES_256_GCM = null;
        public static final Type AES_CTR = null;
        public static final Type CRYPTO_SDK_DOWNGRADE = null;
        public static final Type CRYPTO_SDK_THIRDPARTY = null;
        public static final Type CRYPTO_SDK_UNIFIED = null;
        public static final b Companion = null;
        public static final Type SM4_128 = null;
        public static final Type UNKNOWN = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Type> r1, Syntax r2, Type r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Type a(int r0) {
                switch(r0) {
                    case 0: goto L11;
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L14;
                    case 6: goto L13;
                    default: goto L3;
                };
            L3:
                return null;
            L13:
                return Type.SM4_128;
            L14:
                return Type.CRYPTO_SDK_THIRDPARTY;
            L15:
                return Type.CRYPTO_SDK_DOWNGRADE;
            L16:
                return Type.CRYPTO_SDK_UNIFIED;
            L17:
                return Type.AES_CTR;
            L18:
                return Type.AES_256_GCM;
            L11:
                return Type.UNKNOWN;
            }
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("AES_256_GCM", 1, 1);
            AES_256_GCM = r1;
            Type r3 = new Type("AES_CTR", 2, 2);
            AES_CTR = r3;
            Type r5 = new Type("CRYPTO_SDK_UNIFIED", 3, 3);
            CRYPTO_SDK_UNIFIED = r5;
            Type r7 = new Type("CRYPTO_SDK_DOWNGRADE", 4, 4);
            CRYPTO_SDK_DOWNGRADE = r7;
            Type r9 = new Type("CRYPTO_SDK_THIRDPARTY", 5, 5);
            CRYPTO_SDK_THIRDPARTY = r9;
            Type r11 = new Type("SM4_128", 6, 6);
            SM4_128 = r11;
            Type[] r13 = {r0, r1, r3, r5, r7, r9, r11};
            a = r13;
            b = EnumEntriesKt.enumEntries(r13);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2, r0);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<SerCrypto, a> {
        public Type d;
        public Cipher e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new SerCrypto(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<SerCrypto> {
        @Override // com.lark.wire.ProtoAdapter
        public final SerCrypto c(g0 r9) {
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
            r0.e = Cipher.ADAPTER.c(r9);
            goto L3
        L9:
            r9.j(r3);
            goto L3
        L16:
            return new SerCrypto(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(SerCrypto r5) {
            SerCrypto r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + Type.ADAPTER.l(1, r6.getType())) + Cipher.ADAPTER.l(2, r6.getCipher());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, SerCrypto r5) {
            SerCrypto r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            Type.ADAPTER.i(r4, 1, r6.getType());
            Cipher.ADAPTER.i(r4, 2, r6.getCipher());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, SerCrypto r5) {
            SerCrypto r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            Cipher.ADAPTER.j(r4, 2, r6.getCipher());
            Type.ADAPTER.j(r4, 1, r6.getType());
        }

        public b(FieldEncoding r7, KClass<SerCrypto> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.SerCrypto", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ SerCrypto(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(SerCrypto.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.e = this.cipher;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(SerCrypto.class).getSimpleName() + '@' + hashCode();
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public SerCrypto(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.type = r2.d;
        this.cipher = r2.e;
    }

    public /* synthetic */ SerCrypto(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
