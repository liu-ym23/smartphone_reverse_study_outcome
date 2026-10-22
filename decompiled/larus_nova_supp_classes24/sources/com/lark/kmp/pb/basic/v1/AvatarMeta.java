package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0005./012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\u000fR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\u000fR\u0015\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001a\u0010\u000fR\u0015\u0010\u001b\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001c\u0010\u000fR\u0015\u0010\u001d\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u001e\u0010\u000fR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u00063"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/AvatarMeta;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/AvatarMeta$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/AvatarMeta$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/AvatarMeta$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/AvatarMeta$Type;", "color", "", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "text", "", "getText", "()Ljava/lang/String;", "border_color", "getBorder_color", "background_color", "getBackground_color", "center_color", "getCenter_color", "start_color", "getStart_color", "end_color", "getEnd_color", "style_type", "Lcom/lark/kmp/pb/basic/v1/AvatarMeta$AvatarStyleType;", "getStyle_type", "()Lcom/lark/kmp/pb/basic/v1/AvatarMeta$AvatarStyleType;", "collage_data", "", "Lcom/lark/kmp/pb/basic/v1/AvatarMeta$CollageData;", "getCollage_data", "()Ljava/util/List;", "rich_text", "Lcom/lark/kmp/pb/basic/v1/RichText;", "getRich_text", "()Lcom/lark/kmp/pb/basic/v1/RichText;", "newBuilder", "toString", "Builder", "Companion", "Type", "AvatarStyleType", "CollageData", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AvatarMeta extends com.lark.wire.Message<AvatarMeta, a> {
    public static final ProtoAdapter<AvatarMeta> ADAPTER = null;
    public static final c Companion = null;
    public static final Type DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    private final Integer background_color;
    private final Integer border_color;
    private final Integer center_color;
    private final List<CollageData> collage_data;
    private final Integer color;
    private final Integer end_color;
    private final RichText rich_text;
    private final Integer start_color;
    private final AvatarStyleType style_type;
    private final String text;
    private final Type type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/AvatarMeta$AvatarStyleType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_STYLE", "FILL", "BORDER", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum AvatarStyleType extends Enum<AvatarStyleType> implements o0 {
        public static final ProtoAdapter<AvatarStyleType> ADAPTER = null;
        public static final AvatarStyleType BORDER = null;
        public static final b Companion = null;
        public static final AvatarStyleType FILL = null;
        public static final AvatarStyleType UNKNOWN_STYLE = null;
        public static final /* synthetic */ AvatarStyleType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<AvatarStyleType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                AvatarStyleType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return AvatarStyleType.BORDER;
            L15:
                return AvatarStyleType.FILL;
            L12:
                return AvatarStyleType.UNKNOWN_STYLE;
            }

            public a(KClass<AvatarStyleType> r1, Syntax r2, AvatarStyleType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<AvatarStyleType> getEntries() {
            return b;
        }

        static {
            AvatarStyleType r0 = new AvatarStyleType("UNKNOWN_STYLE", 0, 0);
            UNKNOWN_STYLE = r0;
            AvatarStyleType r1 = new AvatarStyleType("FILL", 1, 1);
            FILL = r1;
            AvatarStyleType r3 = new AvatarStyleType("BORDER", 2, 2);
            BORDER = r3;
            AvatarStyleType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(AvatarStyleType.class), Syntax.PROTO_2, r0);
        }

        public static AvatarStyleType[] values() {
            return (AvatarStyleType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final AvatarStyleType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return BORDER;
        L15:
            return FILL;
        L12:
            return UNKNOWN_STYLE;
        }

        public static AvatarStyleType valueOf(String r1) {
            return (AvatarStyleType) r27.a.a(AvatarStyleType.class, r1);
        }

        public AvatarStyleType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/AvatarMeta$CollageData;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/AvatarMeta$CollageData$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/AvatarMeta$CollageData$Builder;Lokio/ByteString;)V", "user_id", "", "getUser_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "avatar_key", "", "getAvatar_key", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class CollageData extends com.lark.wire.Message<CollageData, a> {
        public static final ProtoAdapter<CollageData> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String avatar_key;
        private final Long user_id;

        public static final class a extends com.lark.wire.Message.a<CollageData, a> {
            public Long d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new CollageData(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<CollageData> {
            @Override // com.lark.wire.ProtoAdapter
            public final CollageData c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                r1.d = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L9:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L13:
                return new CollageData(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(CollageData r5) {
                CollageData r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ProtoAdapter.k.l(1, r6.getUser_id())) + ProtoAdapter.q.l(2, r6.getAvatar_key());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, CollageData r5) {
                CollageData r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.k.i(r4, 1, r6.getUser_id());
                ProtoAdapter.q.i(r4, 2, r6.getAvatar_key());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, CollageData r5) {
                CollageData r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.q.j(r4, 2, r6.getAvatar_key());
                ProtoAdapter.k.j(r4, 1, r6.getUser_id());
            }

            public b(FieldEncoding r7, KClass<CollageData> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.AvatarMeta.CollageData", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ CollageData(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CollageData.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.user_id;
            r0.e = this.avatar_key;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(CollageData.class).getSimpleName() + '@' + hashCode();
        }

        public final String getAvatar_key() {
            return this.avatar_key;
        }

        public final Long getUser_id() {
            return this.user_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public CollageData(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.user_id = r2.d;
            this.avatar_key = r2.e;
        }

        public /* synthetic */ CollageData(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/AvatarMeta$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "RANDOM", "WORDS", "UPLOAD", "COLLAGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type COLLAGE = null;
        public static final b Companion = null;
        public static final Type RANDOM = null;
        public static final Type UNKNOWN = null;
        public static final Type UPLOAD = null;
        public static final Type WORDS = null;
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
            public static Type a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return Type.COLLAGE;
            L20:
                return Type.UPLOAD;
            L21:
                return Type.WORDS;
            L22:
                return Type.RANDOM;
            L17:
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
            Type r1 = new Type("RANDOM", 1, 1);
            RANDOM = r1;
            Type r3 = new Type("WORDS", 2, 2);
            WORDS = r3;
            Type r5 = new Type("UPLOAD", 3, 3);
            UPLOAD = r5;
            Type r7 = new Type("COLLAGE", 4, 4);
            COLLAGE = r7;
            Type[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
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

    public static final class a extends com.lark.wire.Message.a<AvatarMeta, a> {
        public Type d;
        public Integer e;
        public String f;
        public Integer g;
        public Integer h;
        public Integer i;
        public Integer j;
        public Integer k;
        public AvatarStyleType l;
        public List<CollageData> m;
        public RichText n;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new AvatarMeta(this, c(), null);
        }

        public a() {
            this.m = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<AvatarMeta> {
        @Override // com.lark.wire.ProtoAdapter
        public final AvatarMeta c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L24;
            switch(r5) {
                case 1: goto L28;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L6;
                case 5: goto L17;
                case 6: goto L6;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L26;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L26:
            r1.l = AvatarStyleType.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L28:
            Type r7 = Type.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            Intrinsics.checkNotNullParameter(r7, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            r1.d = r7;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L7:
            r1.n = RichText.ADAPTER.c(r11);
            goto L3
        L8:
            r2.add(CollageData.ADAPTER.c(r11));
            goto L3
        L13:
            r1.k = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L14:
            r1.j = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L15:
            r1.i = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L16:
            r1.h = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L17:
            r1.g = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.f = r11.i();
            goto L3
        L19:
            r1.e = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L6:
            r11.j(r5);
            Unit r9 = Unit.INSTANCE;
            goto L3
        L24:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "collage_data");
            com.lark.wire.internal.a.a(r2);
            r1.m = r2;
            return new AvatarMeta(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(AvatarMeta r6) {
            AvatarMeta r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size() + Type.ADAPTER.l(1, r7.getType());
            s r1 = ProtoAdapter.h;
            return (((((((((r0 + r1.l(2, r7.getColor())) + ProtoAdapter.q.l(3, r7.getText())) + r1.l(5, r7.getBorder_color())) + r1.l(7, r7.getBackground_color())) + r1.l(8, r7.getCenter_color())) + r1.l(9, r7.getStart_color())) + r1.l(10, r7.getEnd_color())) + AvatarStyleType.ADAPTER.l(11, r7.getStyle_type())) + CollageData.ADAPTER.a().l(12, r7.getCollage_data())) + RichText.ADAPTER.l(13, r7.getRich_text());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, AvatarMeta r6) {
            AvatarMeta r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            Type.ADAPTER.i(r5, 1, r7.getType());
            s r0 = ProtoAdapter.h;
            r0.i(r5, 2, r7.getColor());
            ProtoAdapter.q.i(r5, 3, r7.getText());
            r0.i(r5, 5, r7.getBorder_color());
            r0.i(r5, 7, r7.getBackground_color());
            r0.i(r5, 8, r7.getCenter_color());
            r0.i(r5, 9, r7.getStart_color());
            r0.i(r5, 10, r7.getEnd_color());
            AvatarStyleType.ADAPTER.i(r5, 11, r7.getStyle_type());
            CollageData.ADAPTER.a().i(r5, 12, r7.getCollage_data());
            RichText.ADAPTER.i(r5, 13, r7.getRich_text());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, AvatarMeta r6) {
            AvatarMeta r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            RichText.ADAPTER.j(r5, 13, r7.getRich_text());
            CollageData.ADAPTER.a().j(r5, 12, r7.getCollage_data());
            AvatarStyleType.ADAPTER.j(r5, 11, r7.getStyle_type());
            s r0 = ProtoAdapter.h;
            r0.j(r5, 10, r7.getEnd_color());
            r0.j(r5, 9, r7.getStart_color());
            r0.j(r5, 8, r7.getCenter_color());
            r0.j(r5, 7, r7.getBackground_color());
            r0.j(r5, 5, r7.getBorder_color());
            ProtoAdapter.q.j(r5, 3, r7.getText());
            r0.j(r5, 2, r7.getColor());
            Type.ADAPTER.j(r5, 1, r7.getType());
        }

        public b(FieldEncoding r7, KClass<AvatarMeta> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.AvatarMeta", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ AvatarMeta(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_TYPE = Type.UNKNOWN;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AvatarMeta.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.e = this.color;
        r0.f = this.text;
        r0.g = this.border_color;
        r0.h = this.background_color;
        r0.i = this.center_color;
        r0.j = this.start_color;
        r0.k = this.end_color;
        r0.l = this.style_type;
        r0.m = this.collage_data;
        r0.n = this.rich_text;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(AvatarMeta.class).getSimpleName() + '@' + hashCode();
    }

    public final Integer getBackground_color() {
        return this.background_color;
    }

    public final Integer getBorder_color() {
        return this.border_color;
    }

    public final Integer getCenter_color() {
        return this.center_color;
    }

    public final List<CollageData> getCollage_data() {
        return this.collage_data;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final Integer getEnd_color() {
        return this.end_color;
    }

    public final RichText getRich_text() {
        return this.rich_text;
    }

    public final Integer getStart_color() {
        return this.start_color;
    }

    public final AvatarStyleType getStyle_type() {
        return this.style_type;
    }

    public final String getText() {
        return this.text;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public AvatarMeta(a r2, ByteString r3) {
        super(ADAPTER, r3);
        Type r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.type = r4;
        this.color = r2.e;
        this.text = r2.f;
        this.border_color = r2.g;
        this.background_color = r2.h;
        this.center_color = r2.i;
        this.start_color = r2.j;
        this.end_color = r2.k;
        this.style_type = r2.l;
        this.collage_data = com.lark.wire.internal.a.c("collage_data", r2.m);
        this.rich_text = r2.n;
    }

    public /* synthetic */ AvatarMeta(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
