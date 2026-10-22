package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.f;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.call.dora.CommandStatus;
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
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\r\u001f !\"#$%&'()*+B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardComponent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardComponent$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/CardComponent$Type;", "getType", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$Type;", "child_ids", "", "", "getChild_ids", "()Ljava/util/List;", "style", "Lcom/lark/kmp/pb/basic/v1/CardComponent$Style;", "getStyle", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$Style;", "engine", "Lcom/lark/kmp/pb/basic/v1/CardComponent$EngineProperty;", "getEngine", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$EngineProperty;", "flex_layout", "Lcom/lark/kmp/pb/basic/v1/CardComponent$FlexLayoutProperty;", "getFlex_layout", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$FlexLayoutProperty;", "newBuilder", "toString", "Builder", "Companion", "Type", "ValueType", "Value", "Align", "Orientation", "Justify", "Padding", "FlexWrap", "Style", "EngineProperty", "FlexLayoutProperty", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardComponent extends com.lark.wire.Message<CardComponent, a> {
    public static final ProtoAdapter<CardComponent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<String> child_ids;
    private final EngineProperty engine;
    private final FlexLayoutProperty flex_layout;
    private final Style style;
    private final Type type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent$Align;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TOP", "MIDDLE", "BOTTOM", "STRETCH", "BASELINE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Align extends Enum<Align> implements o0 {
        public static final ProtoAdapter<Align> ADAPTER = null;
        public static final Align BASELINE = null;
        public static final Align BOTTOM = null;
        public static final b Companion = null;
        public static final Align MIDDLE = null;
        public static final Align STRETCH = null;
        public static final Align TOP = null;
        public static final /* synthetic */ Align[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Align> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Align.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Align> r1, Syntax r2, Align r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Align a(int r1) {
                if (r1 == 0) goto L17;
                if (r1 == 1) goto L22;
                if (r1 == 2) goto L21;
                if (r1 == 3) goto L20;
                if (r1 == 4) goto L19;
                return null;
            L19:
                return Align.BASELINE;
            L20:
                return Align.STRETCH;
            L21:
                return Align.BOTTOM;
            L22:
                return Align.MIDDLE;
            L17:
                return Align.TOP;
            }
        }

        @JvmStatic
        public static final Align fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Align> getEntries() {
            return b;
        }

        static {
            Align r0 = new Align("TOP", 0, 0);
            TOP = r0;
            Align r1 = new Align("MIDDLE", 1, 1);
            MIDDLE = r1;
            Align r3 = new Align("BOTTOM", 2, 2);
            BOTTOM = r3;
            Align r5 = new Align("STRETCH", 3, 3);
            STRETCH = r5;
            Align r7 = new Align("BASELINE", 4, 4);
            BASELINE = r7;
            Align[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Align.class), Syntax.PROTO_2, r0);
        }

        public static Align[] values() {
            return (Align[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Align valueOf(String r1) {
            return (Align) r27.a.a(Align.class, r1);
        }

        public Align(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u000f\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent$EngineProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardComponent$EngineProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardComponent$EngineProperty$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/CardComponent$EngineProperty$EngineType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$EngineProperty$EngineType;", "newBuilder", "toString", "", "Builder", "Companion", "EngineType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class EngineProperty extends com.lark.wire.Message<EngineProperty, a> {
        public static final ProtoAdapter<EngineProperty> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final EngineType type;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \n2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent$EngineProperty$EngineType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SMARTCARD", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum EngineType extends Enum<EngineType> implements o0 {
            public static final ProtoAdapter<EngineType> ADAPTER = null;
            public static final b Companion = null;
            public static final EngineType SMARTCARD = null;
            public static final /* synthetic */ EngineType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<EngineType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    EngineType.Companion.getClass();
                    if (r2 == 0) goto L7;
                    return null;
                L7:
                    return EngineType.SMARTCARD;
                }

                public a(KClass<EngineType> r1, Syntax r2, EngineType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<EngineType> getEntries() {
                return b;
            }

            static {
                EngineType r0 = new EngineType();
                SMARTCARD = r0;
                EngineType[] r1 = {r0};
                a = r1;
                b = EnumEntriesKt.enumEntries(r1);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(EngineType.class), Syntax.PROTO_2, r0);
            }

            public EngineType() {
                super("SMARTCARD", 0);
                this.value = 0;
            }

            public static EngineType[] values() {
                return (EngineType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final EngineType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L7;
                return null;
            L7:
                return SMARTCARD;
            }

            public static EngineType valueOf(String r1) {
                return (EngineType) r27.a.a(EngineType.class, r1);
            }
        }

        public static final class a extends com.lark.wire.Message.a<EngineProperty, a> {
            public EngineType d;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new EngineProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<EngineProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final EngineProperty c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L13;
                if (r3 != 1) goto L11;
                r0.d = EngineType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L11:
                r9.j(r3);
                goto L3
            L13:
                return new EngineProperty(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(EngineProperty r4) {
                EngineProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + EngineType.ADAPTER.l(1, r5.getType());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, EngineProperty r5) {
                EngineProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                EngineType.ADAPTER.i(r4, 1, r6.getType());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, EngineProperty r4) {
                EngineProperty r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                EngineType.ADAPTER.j(r3, 1, r5.getType());
            }

            public b(FieldEncoding r7, KClass<EngineProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardComponent.EngineProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ EngineProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EngineProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(EngineProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final EngineType getType() {
            return this.type;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public EngineProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
        }

        public /* synthetic */ EngineProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002+,B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010(\u001a\u00020\u0002H\u0016J\b\u0010)\u001a\u00020*H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010#\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&¨\u0006-"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent$FlexLayoutProperty;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardComponent$FlexLayoutProperty$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardComponent$FlexLayoutProperty$Builder;Lokio/ByteString;)V", "orientation", "Lcom/lark/kmp/pb/basic/v1/CardComponent$Orientation;", "getOrientation", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$Orientation;", "flex_wrap", "Lcom/lark/kmp/pb/basic/v1/CardComponent$FlexWrap;", "getFlex_wrap", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$FlexWrap;", "main_axis_spacing", "", "getMain_axis_spacing", "()Ljava/lang/Float;", "Ljava/lang/Float;", "cross_axis_spacing", "getCross_axis_spacing", "padding", "Lcom/lark/kmp/pb/basic/v1/CardComponent$Padding;", "getPadding", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$Padding;", "main_axis_justify", "Lcom/lark/kmp/pb/basic/v1/CardComponent$Justify;", "getMain_axis_justify", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$Justify;", "cross_axis_align", "Lcom/lark/kmp/pb/basic/v1/CardComponent$Align;", "getCross_axis_align", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$Align;", "force_use_compact_mode", "", "getForce_use_compact_mode", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class FlexLayoutProperty extends com.lark.wire.Message<FlexLayoutProperty, a> {
        public static final ProtoAdapter<FlexLayoutProperty> ADAPTER = null;
        public static final c Companion = null;
        public static final Align DEFAULT_CROSS_AXIS_ALIGN = null;
        public static final FlexWrap DEFAULT_FLEX_WRAP = null;
        public static final boolean DEFAULT_FORCE_USE_COMPACT_MODE = false;
        public static final Justify DEFAULT_MAIN_AXIS_JUSTIFY = null;
        public static final Orientation DEFAULT_ORIENTATION = null;
        private static final long serialVersionUID = 0;
        private final Align cross_axis_align;
        private final Float cross_axis_spacing;
        private final FlexWrap flex_wrap;
        private final Boolean force_use_compact_mode;
        private final Justify main_axis_justify;
        private final Float main_axis_spacing;
        private final Orientation orientation;
        private final Padding padding;

        public static final class a extends com.lark.wire.Message.a<FlexLayoutProperty, a> {
            public Orientation d;
            public FlexWrap e;
            public Float f;
            public Float g;
            public Padding h;
            public Justify i;
            public Align j;
            public Boolean k;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new FlexLayoutProperty(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<FlexLayoutProperty> {
            @Override // com.lark.wire.ProtoAdapter
            public final FlexLayoutProperty c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L28;
                switch(r3) {
                    case 1: goto L31;
                    case 2: goto L33;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L35;
                    case 7: goto L29;
                    case 8: goto L7;
                    default: goto L6;
                };
            L29:
                r0.j = Align.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
            L10:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L31:
                r0.d = Orientation.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L25
            L25:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L33:
                r0.e = FlexWrap.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            L21:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r6 = Unit.INSTANCE;
                goto L3
            L35:
                r0.i = Justify.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            L14:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r7 = Unit.INSTANCE;
                goto L3
            L7:
                r0.k = (Boolean) ProtoAdapter.g.c(r9);
                goto L3
            L16:
                r0.h = Padding.ADAPTER.c(r9);
                goto L3
            L17:
                r0.g = (Float) ProtoAdapter.n.c(r9);
                goto L3
            L18:
                r0.f = (Float) ProtoAdapter.n.c(r9);
                goto L3
            L6:
                r9.j(r3);
                goto L3
            L28:
                return new FlexLayoutProperty(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(FlexLayoutProperty r5) {
                FlexLayoutProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = (r6.unknownFields().size() + Orientation.ADAPTER.l(1, r6.getOrientation())) + FlexWrap.ADAPTER.l(2, r6.getFlex_wrap());
                f r1 = ProtoAdapter.n;
                return (((((r0 + r1.l(3, r6.getMain_axis_spacing())) + r1.l(4, r6.getCross_axis_spacing())) + Padding.ADAPTER.l(5, r6.getPadding())) + Justify.ADAPTER.l(6, r6.getMain_axis_justify())) + Align.ADAPTER.l(7, r6.getCross_axis_align())) + ProtoAdapter.g.l(8, r6.getForce_use_compact_mode());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, FlexLayoutProperty r5) {
                FlexLayoutProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                Orientation.ADAPTER.i(r4, 1, r6.getOrientation());
                FlexWrap.ADAPTER.i(r4, 2, r6.getFlex_wrap());
                f r0 = ProtoAdapter.n;
                r0.i(r4, 3, r6.getMain_axis_spacing());
                r0.i(r4, 4, r6.getCross_axis_spacing());
                Padding.ADAPTER.i(r4, 5, r6.getPadding());
                Justify.ADAPTER.i(r4, 6, r6.getMain_axis_justify());
                Align.ADAPTER.i(r4, 7, r6.getCross_axis_align());
                ProtoAdapter.g.i(r4, 8, r6.getForce_use_compact_mode());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, FlexLayoutProperty r5) {
                FlexLayoutProperty r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.g.j(r4, 8, r6.getForce_use_compact_mode());
                Align.ADAPTER.j(r4, 7, r6.getCross_axis_align());
                Justify.ADAPTER.j(r4, 6, r6.getMain_axis_justify());
                Padding.ADAPTER.j(r4, 5, r6.getPadding());
                f r0 = ProtoAdapter.n;
                r0.j(r4, 4, r6.getCross_axis_spacing());
                r0.j(r4, 3, r6.getMain_axis_spacing());
                FlexWrap.ADAPTER.j(r4, 2, r6.getFlex_wrap());
                Orientation.ADAPTER.j(r4, 1, r6.getOrientation());
            }

            public b(FieldEncoding r7, KClass<FlexLayoutProperty> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardComponent.FlexLayoutProperty", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ FlexLayoutProperty(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            DEFAULT_ORIENTATION = Orientation.ROW;
            DEFAULT_FLEX_WRAP = FlexWrap.NO_WRAP;
            DEFAULT_MAIN_AXIS_JUSTIFY = Justify.START;
            DEFAULT_CROSS_AXIS_ALIGN = Align.TOP;
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(FlexLayoutProperty.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.orientation;
            r0.e = this.flex_wrap;
            r0.f = this.main_axis_spacing;
            r0.g = this.cross_axis_spacing;
            r0.h = this.padding;
            r0.i = this.main_axis_justify;
            r0.j = this.cross_axis_align;
            r0.k = this.force_use_compact_mode;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(FlexLayoutProperty.class).getSimpleName() + '@' + hashCode();
        }

        public final Align getCross_axis_align() {
            return this.cross_axis_align;
        }

        public final Float getCross_axis_spacing() {
            return this.cross_axis_spacing;
        }

        public final FlexWrap getFlex_wrap() {
            return this.flex_wrap;
        }

        public final Boolean getForce_use_compact_mode() {
            return this.force_use_compact_mode;
        }

        public final Justify getMain_axis_justify() {
            return this.main_axis_justify;
        }

        public final Float getMain_axis_spacing() {
            return this.main_axis_spacing;
        }

        public final Orientation getOrientation() {
            return this.orientation;
        }

        public final Padding getPadding() {
            return this.padding;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public FlexLayoutProperty(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.orientation = r2.d;
            this.flex_wrap = r2.e;
            this.main_axis_spacing = r2.f;
            this.cross_axis_spacing = r2.g;
            this.padding = r2.h;
            this.main_axis_justify = r2.i;
            this.cross_axis_align = r2.j;
            this.force_use_compact_mode = r2.k;
        }

        public /* synthetic */ FlexLayoutProperty(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent$FlexWrap;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NO_WRAP", "WRAP", "WRAP_REVERSE", "LINEAR_WRAP", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum FlexWrap extends Enum<FlexWrap> implements o0 {
        public static final ProtoAdapter<FlexWrap> ADAPTER = null;
        public static final b Companion = null;
        public static final FlexWrap LINEAR_WRAP = null;
        public static final FlexWrap NO_WRAP = null;
        public static final FlexWrap WRAP = null;
        public static final FlexWrap WRAP_REVERSE = null;
        public static final /* synthetic */ FlexWrap[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<FlexWrap> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                FlexWrap.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return FlexWrap.LINEAR_WRAP;
            L18:
                return FlexWrap.WRAP_REVERSE;
            L19:
                return FlexWrap.WRAP;
            L15:
                return FlexWrap.NO_WRAP;
            }

            public a(KClass<FlexWrap> r1, Syntax r2, FlexWrap r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<FlexWrap> getEntries() {
            return b;
        }

        static {
            FlexWrap r0 = new FlexWrap("NO_WRAP", 0, 0);
            NO_WRAP = r0;
            FlexWrap r1 = new FlexWrap("WRAP", 1, 1);
            WRAP = r1;
            FlexWrap r3 = new FlexWrap("WRAP_REVERSE", 2, 2);
            WRAP_REVERSE = r3;
            FlexWrap r5 = new FlexWrap("LINEAR_WRAP", 3, 3);
            LINEAR_WRAP = r5;
            FlexWrap[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(FlexWrap.class), Syntax.PROTO_2, r0);
        }

        public static FlexWrap[] values() {
            return (FlexWrap[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final FlexWrap fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return LINEAR_WRAP;
        L18:
            return WRAP_REVERSE;
        L19:
            return WRAP;
        L15:
            return NO_WRAP;
        }

        public static FlexWrap valueOf(String r1) {
            return (FlexWrap) r27.a.a(FlexWrap.class, r1);
        }

        public FlexWrap(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent$Justify;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "START", "CENTER", "END", "SPACE_BETWEEN", "SPACE_AROUND", "SPACE_EVENLY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Justify extends Enum<Justify> implements o0 {
        public static final ProtoAdapter<Justify> ADAPTER = null;
        public static final Justify CENTER = null;
        public static final b Companion = null;
        public static final Justify END = null;
        public static final Justify SPACE_AROUND = null;
        public static final Justify SPACE_BETWEEN = null;
        public static final Justify SPACE_EVENLY = null;
        public static final Justify START = null;
        public static final /* synthetic */ Justify[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Justify> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Justify.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Justify> r1, Syntax r2, Justify r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Justify a(int r1) {
                if (r1 == 0) goto L20;
                if (r1 == 1) goto L26;
                if (r1 == 2) goto L25;
                if (r1 == 3) goto L24;
                if (r1 == 4) goto L23;
                if (r1 == 5) goto L22;
                return null;
            L22:
                return Justify.SPACE_EVENLY;
            L23:
                return Justify.SPACE_AROUND;
            L24:
                return Justify.SPACE_BETWEEN;
            L25:
                return Justify.END;
            L26:
                return Justify.CENTER;
            L20:
                return Justify.START;
            }
        }

        @JvmStatic
        public static final Justify fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Justify> getEntries() {
            return b;
        }

        static {
            Justify r0 = new Justify("START", 0, 0);
            START = r0;
            Justify r1 = new Justify("CENTER", 1, 1);
            CENTER = r1;
            Justify r3 = new Justify("END", 2, 2);
            END = r3;
            Justify r5 = new Justify("SPACE_BETWEEN", 3, 3);
            SPACE_BETWEEN = r5;
            Justify r7 = new Justify("SPACE_AROUND", 4, 4);
            SPACE_AROUND = r7;
            Justify r9 = new Justify("SPACE_EVENLY", 5, 5);
            SPACE_EVENLY = r9;
            Justify[] r11 = {r0, r1, r3, r5, r7, r9};
            a = r11;
            b = EnumEntriesKt.enumEntries(r11);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Justify.class), Syntax.PROTO_2, r0);
        }

        public static Justify[] values() {
            return (Justify[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Justify valueOf(String r1) {
            return (Justify) r27.a.a(Justify.class, r1);
        }

        public Justify(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent$Orientation;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ROW", "COLUMN", "ROW_REVERSE", "COLUMN_REVERSE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Orientation extends Enum<Orientation> implements o0 {
        public static final ProtoAdapter<Orientation> ADAPTER = null;
        public static final Orientation COLUMN = null;
        public static final Orientation COLUMN_REVERSE = null;
        public static final b Companion = null;
        public static final Orientation ROW = null;
        public static final Orientation ROW_REVERSE = null;
        public static final /* synthetic */ Orientation[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Orientation> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Orientation.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return Orientation.COLUMN_REVERSE;
            L18:
                return Orientation.ROW_REVERSE;
            L19:
                return Orientation.COLUMN;
            L15:
                return Orientation.ROW;
            }

            public a(KClass<Orientation> r1, Syntax r2, Orientation r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Orientation> getEntries() {
            return b;
        }

        static {
            Orientation r0 = new Orientation("ROW", 0, 0);
            ROW = r0;
            Orientation r1 = new Orientation("COLUMN", 1, 1);
            COLUMN = r1;
            Orientation r3 = new Orientation("ROW_REVERSE", 2, 2);
            ROW_REVERSE = r3;
            Orientation r5 = new Orientation("COLUMN_REVERSE", 3, 3);
            COLUMN_REVERSE = r5;
            Orientation[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Orientation.class), Syntax.PROTO_2, r0);
        }

        public static Orientation[] values() {
            return (Orientation[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Orientation fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return COLUMN_REVERSE;
        L18:
            return ROW_REVERSE;
        L19:
            return COLUMN;
        L15:
            return ROW;
        }

        public static Orientation valueOf(String r1) {
            return (Orientation) r27.a.a(Orientation.class, r1);
        }

        public Orientation(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent$Padding;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardComponent$Padding$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardComponent$Padding$Builder;Lokio/ByteString;)V", "top", "", "getTop", "()Ljava/lang/Float;", "Ljava/lang/Float;", "right", "getRight", "bottom", "getBottom", "left", "getLeft", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Padding extends com.lark.wire.Message<Padding, a> {
        public static final ProtoAdapter<Padding> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Float bottom;
        private final Float left;
        private final Float right;
        private final Float top;

        public static final class a extends com.lark.wire.Message.a<Padding, a> {
            public Float d;
            public Float e;
            public Float f;
            public Float g;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Padding(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Padding> {
            @Override // com.lark.wire.ProtoAdapter
            public final Padding c(g0 r6) {
                Intrinsics.checkNotNullParameter(r6, "reader");
                a r0 = new a();
                long r1 = r6.c();
            L3:
                int r3 = r6.e();
                if (r3 == (-1)) goto L19;
                if (r3 != 1) goto L8;
                r0.d = (Float) ProtoAdapter.n.c(r6);
                goto L3
            L8:
                if (r3 != 2) goto L10;
                r0.e = (Float) ProtoAdapter.n.c(r6);
                goto L3
            L10:
                if (r3 != 3) goto L12;
                r0.f = (Float) ProtoAdapter.n.c(r6);
                goto L3
            L12:
                if (r3 != 4) goto L13;
                r0.g = (Float) ProtoAdapter.n.c(r6);
                goto L3
            L13:
                r6.j(r3);
                Unit r4 = Unit.INSTANCE;
                goto L3
            L19:
                return new Padding(r0, r6.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Padding r5) {
                Padding r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                f r1 = ProtoAdapter.n;
                return (((r0 + r1.l(1, r6.getTop())) + r1.l(2, r6.getRight())) + r1.l(3, r6.getBottom())) + r1.l(4, r6.getLeft());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Padding r5) {
                Padding r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                f r0 = ProtoAdapter.n;
                r0.i(r4, 1, r6.getTop());
                r0.i(r4, 2, r6.getRight());
                r0.i(r4, 3, r6.getBottom());
                r0.i(r4, 4, r6.getLeft());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Padding r5) {
                Padding r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                f r0 = ProtoAdapter.n;
                r0.j(r4, 4, r6.getLeft());
                r0.j(r4, 3, r6.getBottom());
                r0.j(r4, 2, r6.getRight());
                r0.j(r4, 1, r6.getTop());
            }

            public b(FieldEncoding r7, KClass<Padding> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardComponent.Padding", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Padding(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Padding.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.top;
            r0.e = this.right;
            r0.f = this.bottom;
            r0.g = this.left;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Padding.class).getSimpleName() + '@' + hashCode();
        }

        public final Float getBottom() {
            return this.bottom;
        }

        public final Float getLeft() {
            return this.left;
        }

        public final Float getRight() {
            return this.right;
        }

        public final Float getTop() {
            return this.top;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Padding(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.top = r2.d;
            this.right = r2.e;
            this.bottom = r2.f;
            this.left = r2.g;
        }

        public /* synthetic */ Padding(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002$%B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006&"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent$Style;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardComponent$Style$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardComponent$Style$Builder;Lokio/ByteString;)V", "width", "Lcom/lark/kmp/pb/basic/v1/CardComponent$Value;", "getWidth", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$Value;", "height", "getHeight", "max_width", "getMax_width", "max_height", "getMax_height", "min_width", "getMin_width", "min_height", "getMin_height", "grow_weight", "", "getGrow_weight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "shrink_weight", "getShrink_weight", "align_self", "Lcom/lark/kmp/pb/basic/v1/CardComponent$Align;", "getAlign_self", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$Align;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Style extends com.lark.wire.Message<Style, a> {
        public static final ProtoAdapter<Style> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final Align align_self;
        private final Integer grow_weight;
        private final Value height;
        private final Value max_height;
        private final Value max_width;
        private final Value min_height;
        private final Value min_width;
        private final Integer shrink_weight;
        private final Value width;

        public static final class a extends com.lark.wire.Message.a<Style, a> {
            public Value d;
            public Value e;
            public Value f;
            public Value g;
            public Value h;
            public Value i;
            public Integer j;
            public Integer k;
            public Align l;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Style(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Style> {
            @Override // com.lark.wire.ProtoAdapter
            public final Style c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L20;
                switch(r3) {
                    case 1: goto L18;
                    case 2: goto L17;
                    case 3: goto L16;
                    case 4: goto L15;
                    case 5: goto L14;
                    case 6: goto L13;
                    case 7: goto L12;
                    case 8: goto L11;
                    case 9: goto L21;
                    default: goto L6;
                };
            L21:
                r0.l = Align.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
            L9:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L11:
                r0.k = (Integer) ProtoAdapter.h.c(r9);
                goto L3
            L12:
                r0.j = (Integer) ProtoAdapter.h.c(r9);
                goto L3
            L13:
                r0.i = Value.ADAPTER.c(r9);
                goto L3
            L14:
                r0.h = Value.ADAPTER.c(r9);
                goto L3
            L15:
                r0.g = Value.ADAPTER.c(r9);
                goto L3
            L16:
                r0.f = Value.ADAPTER.c(r9);
                goto L3
            L17:
                r0.e = Value.ADAPTER.c(r9);
                goto L3
            L18:
                r0.d = Value.ADAPTER.c(r9);
                goto L3
            L6:
                r9.j(r3);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L20:
                return new Style(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Style r5) {
                Style r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                ProtoAdapter<Value> r1 = Value.ADAPTER;
                int r2 = (((((r0 + r1.l(1, r6.getWidth())) + r1.l(2, r6.getHeight())) + r1.l(3, r6.getMax_width())) + r1.l(4, r6.getMax_height())) + r1.l(5, r6.getMin_width())) + r1.l(6, r6.getMin_height());
                s r3 = ProtoAdapter.h;
                return ((r2 + r3.l(7, r6.getGrow_weight())) + r3.l(8, r6.getShrink_weight())) + Align.ADAPTER.l(9, r6.getAlign_self());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Style r5) {
                Style r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter<Value> r0 = Value.ADAPTER;
                r0.i(r4, 1, r6.getWidth());
                r0.i(r4, 2, r6.getHeight());
                r0.i(r4, 3, r6.getMax_width());
                r0.i(r4, 4, r6.getMax_height());
                r0.i(r4, 5, r6.getMin_width());
                r0.i(r4, 6, r6.getMin_height());
                s r1 = ProtoAdapter.h;
                r1.i(r4, 7, r6.getGrow_weight());
                r1.i(r4, 8, r6.getShrink_weight());
                Align.ADAPTER.i(r4, 9, r6.getAlign_self());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Style r5) {
                Style r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                Align.ADAPTER.j(r4, 9, r6.getAlign_self());
                s r0 = ProtoAdapter.h;
                r0.j(r4, 8, r6.getShrink_weight());
                r0.j(r4, 7, r6.getGrow_weight());
                ProtoAdapter<Value> r1 = Value.ADAPTER;
                r1.j(r4, 6, r6.getMin_height());
                r1.j(r4, 5, r6.getMin_width());
                r1.j(r4, 4, r6.getMax_height());
                r1.j(r4, 3, r6.getMax_width());
                r1.j(r4, 2, r6.getHeight());
                r1.j(r4, 1, r6.getWidth());
            }

            public b(FieldEncoding r7, KClass<Style> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardComponent.Style", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Style(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Style.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.width;
            r0.e = this.height;
            r0.f = this.max_width;
            r0.g = this.max_height;
            r0.h = this.min_width;
            r0.i = this.min_height;
            r0.j = this.grow_weight;
            r0.k = this.shrink_weight;
            r0.l = this.align_self;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Style.class).getSimpleName() + '@' + hashCode();
        }

        public final Align getAlign_self() {
            return this.align_self;
        }

        public final Integer getGrow_weight() {
            return this.grow_weight;
        }

        public final Value getHeight() {
            return this.height;
        }

        public final Value getMax_height() {
            return this.max_height;
        }

        public final Value getMax_width() {
            return this.max_width;
        }

        public final Value getMin_height() {
            return this.min_height;
        }

        public final Value getMin_width() {
            return this.min_width;
        }

        public final Integer getShrink_weight() {
            return this.shrink_weight;
        }

        public final Value getWidth() {
            return this.width;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Style(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.width = r2.d;
            this.height = r2.e;
            this.max_width = r2.f;
            this.max_height = r2.g;
            this.min_width = r2.h;
            this.min_height = r2.i;
            this.grow_weight = r2.j;
            this.shrink_weight = r2.k;
            this.align_self = r2.l;
        }

        public /* synthetic */ Style(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FLEX_LAYOUT", "ENGINE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type ENGINE = null;
        public static final Type FLEX_LAYOUT = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return Type.ENGINE;
            L9:
                return Type.FLEX_LAYOUT;
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
            Type r0 = new Type("FLEX_LAYOUT", 0, 0);
            FLEX_LAYOUT = r0;
            Type r1 = new Type("ENGINE", 1, 1);
            ENGINE = r1;
            Type[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
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

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return ENGINE;
        L9:
            return FLEX_LAYOUT;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent$Value;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CardComponent$Value$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CardComponent$Value$Builder;Lokio/ByteString;)V", "type", "Lcom/lark/kmp/pb/basic/v1/CardComponent$ValueType;", "getType", "()Lcom/lark/kmp/pb/basic/v1/CardComponent$ValueType;", "value", "", "getValue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class Value extends com.lark.wire.Message<Value, a> {
        public static final ProtoAdapter<Value> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final ValueType type;
        private final Float value;

        public static final class a extends com.lark.wire.Message.a<Value, a> {
            public ValueType d;
            public Float e;

            @Override // com.lark.wire.Message.a
            public final com.lark.wire.Message b() {
                return new Value(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<Value> {
            @Override // com.lark.wire.ProtoAdapter
            public final Value c(g0 r9) {
                Intrinsics.checkNotNullParameter(r9, "reader");
                a r0 = new a();
                long r1 = r9.c();
            L3:
                int r3 = r9.e();
                if (r3 == (-1)) goto L16;
                if (r3 != 1) goto L8;
                r0.d = ValueType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r4 = Unit.INSTANCE;
                goto L3
            L8:
                if (r3 != 2) goto L9;
                r0.e = (Float) ProtoAdapter.n.c(r9);
                goto L3
            L9:
                r9.j(r3);
                goto L3
            L16:
                return new Value(r0, r9.d(r1), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(Value r5) {
                Value r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + ValueType.ADAPTER.l(1, r6.getType())) + ProtoAdapter.n.l(2, r6.getValue());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, Value r5) {
                Value r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ValueType.ADAPTER.i(r4, 1, r6.getType());
                ProtoAdapter.n.i(r4, 2, r6.getValue());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, Value r5) {
                Value r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.n.j(r4, 2, r6.getValue());
                ValueType.ADAPTER.j(r4, 1, r6.getType());
            }

            public b(FieldEncoding r7, KClass<Value> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/basic.v1.CardComponent.Value", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ Value(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(Value.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.type;
            r0.e = this.value;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(Value.class).getSimpleName() + '@' + hashCode();
        }

        public final ValueType getType() {
            return this.type;
        }

        public final Float getValue() {
            return this.value;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
            return newBuilder();
        }

        public Value(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.type = r2.d;
            this.value = r2.e;
        }

        public /* synthetic */ Value(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CardComponent$ValueType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AUTO", "POINT", "PERCENTAGE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ValueType extends Enum<ValueType> implements o0 {
        public static final ProtoAdapter<ValueType> ADAPTER = null;
        public static final ValueType AUTO = null;
        public static final b Companion = null;
        public static final ValueType PERCENTAGE = null;
        public static final ValueType POINT = null;
        public static final /* synthetic */ ValueType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ValueType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ValueType.Companion.getClass();
                if (r2 == 0) goto L12;
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L14;
                return null;
            L14:
                return ValueType.PERCENTAGE;
            L15:
                return ValueType.POINT;
            L12:
                return ValueType.AUTO;
            }

            public a(KClass<ValueType> r1, Syntax r2, ValueType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ValueType> getEntries() {
            return b;
        }

        static {
            ValueType r0 = new ValueType("AUTO", 0, 0);
            AUTO = r0;
            ValueType r1 = new ValueType("POINT", 1, 1);
            POINT = r1;
            ValueType r3 = new ValueType("PERCENTAGE", 2, 2);
            PERCENTAGE = r3;
            ValueType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ValueType.class), Syntax.PROTO_2, r0);
        }

        public static ValueType[] values() {
            return (ValueType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ValueType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            return null;
        L14:
            return PERCENTAGE;
        L15:
            return POINT;
        L12:
            return AUTO;
        }

        public static ValueType valueOf(String r1) {
            return (ValueType) r27.a.a(ValueType.class, r1);
        }

        public ValueType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<CardComponent, a> {
        public Type d;
        public List<String> e;
        public Style f;
        public EngineProperty g;
        public FlexLayoutProperty h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new CardComponent(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<CardComponent> {
        @Override // com.lark.wire.ProtoAdapter
        public final CardComponent c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            DefaultConstructorMarker r7 = null;
            if (r5 == (-1)) goto L24;
            if (r5 != 1) goto L8;
            Type r6 = Type.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            Intrinsics.checkNotNullParameter(r6, "type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
            r1.d = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L8:
            if (r5 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r2.add(r11.i());
            goto L3
        L10:
            if (r5 != 3) goto L12;
            r1.f = Style.ADAPTER.c(r11);
            goto L3
        L12:
            if (r5 != 1000) goto L14;
            r1.g = EngineProperty.ADAPTER.c(r11);
            r1.h = null;
            goto L3
        L14:
            if (r5 != 1001) goto L15;
            r1.h = FlexLayoutProperty.ADAPTER.c(r11);
            r1.g = null;
            goto L3
        L15:
            r11.j(r5);
            Unit r9 = Unit.INSTANCE;
            goto L3
        L24:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "child_ids");
            com.lark.wire.internal.a.a(r2);
            r1.e = r2;
            return new CardComponent(r1, r12, r7);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CardComponent r5) {
            CardComponent r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((((r6.unknownFields().size() + Type.ADAPTER.l(1, r6.getType())) + ProtoAdapter.q.a().l(2, r6.getChild_ids())) + Style.ADAPTER.l(3, r6.getStyle())) + EngineProperty.ADAPTER.l(CommandStatus.DORA_TRACE, r6.getEngine())) + FlexLayoutProperty.ADAPTER.l(1001, r6.getFlex_layout());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CardComponent r5) {
            CardComponent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            Type.ADAPTER.i(r4, 1, r6.getType());
            ProtoAdapter.q.a().i(r4, 2, r6.getChild_ids());
            Style.ADAPTER.i(r4, 3, r6.getStyle());
            EngineProperty.ADAPTER.i(r4, CommandStatus.DORA_TRACE, r6.getEngine());
            FlexLayoutProperty.ADAPTER.i(r4, 1001, r6.getFlex_layout());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CardComponent r5) {
            CardComponent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            FlexLayoutProperty.ADAPTER.j(r4, 1001, r6.getFlex_layout());
            EngineProperty.ADAPTER.j(r4, CommandStatus.DORA_TRACE, r6.getEngine());
            Style.ADAPTER.j(r4, 3, r6.getStyle());
            ProtoAdapter.q.a().j(r4, 2, r6.getChild_ids());
            Type.ADAPTER.j(r4, 1, r6.getType());
        }

        public b(FieldEncoding r7, KClass<CardComponent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.CardComponent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CardComponent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CardComponent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.type;
        r0.e = this.child_ids;
        r0.f = this.style;
        r0.g = this.engine;
        r0.h = this.flex_layout;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CardComponent.class).getSimpleName() + '@' + hashCode();
    }

    public final List<String> getChild_ids() {
        return this.child_ids;
    }

    public final EngineProperty getEngine() {
        return this.engine;
    }

    public final FlexLayoutProperty getFlex_layout() {
        return this.flex_layout;
    }

    public final Style getStyle() {
        return this.style;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public CardComponent(a r3, ByteString r4) {
        super(ADAPTER, r4);
        Type r5 = r3.d;
        Intrinsics.checkNotNull(r5);
        this.type = r5;
        this.child_ids = com.lark.wire.internal.a.c("child_ids", r3.e);
        this.style = r3.f;
        EngineProperty r6 = r3.g;
        this.engine = r6;
        FlexLayoutProperty r7 = r3.h;
        this.flex_layout = r7;
        boolean r0 = false;
        if (r6 == null) goto L5;
        int r8 = 1;
    L6:
        if (r7 == null) goto L8;
        int r9 = 1;
    L10:
        if ((r8 + r9) > 1) goto L12;
        r0 = true;
    L12:
        if (r0 == false) goto L15;
        return;
    L15:
        throw new IllegalArgumentException("At most one of engine, flex_layout may be non-null".toString());
    L8:
        r9 = 0;
        goto L10
    L5:
        r8 = 0;
        goto L6
    }

    public /* synthetic */ CardComponent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
