package com.google.protobuf;

import annotation.Debug;
import annotation.Serde;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.IOException;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final class FieldOptions extends com.squareup.wire.Message<FieldOptions, Builder> {
    public static final ProtoAdapter<FieldOptions> ADAPTER = null;
    public static final CType DEFAULT_CTYPE = null;
    public static final Boolean DEFAULT_DEPRECATED = null;
    public static final JSType DEFAULT_JSTYPE = null;
    public static final Boolean DEFAULT_LAZY = null;
    public static final Boolean DEFAULT_PACKED = null;
    public static final Boolean DEFAULT_WEAK = null;
    private static final long serialVersionUID = 0;
    public final CType ctype;
    public final Debug debug;
    public final Boolean deprecated;
    public final JSType jstype;
    public final Boolean lazy;
    public final Boolean packed;
    public final Serde serde;
    public final List<UninterpretedOption> uninterpreted_option;
    public final Boolean weak;

    public static final class Builder extends com.squareup.wire.Message.Builder<FieldOptions, Builder> {
        public CType ctype;
        public Debug debug;
        public Boolean deprecated;
        public JSType jstype;
        public Boolean lazy;
        public Boolean packed;
        public Serde serde;
        public List<UninterpretedOption> uninterpreted_option;
        public Boolean weak;

        @Override // com.squareup.wire.Message.Builder
        public FieldOptions build() {
            return new FieldOptions(this.ctype, this.packed, this.jstype, this.lazy, this.deprecated, this.weak, this.uninterpreted_option, this.debug, this.serde, super.buildUnknownFields());
        }

        public Builder() {
            this.uninterpreted_option = com.squareup.wire.internal.Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder ctype(CType r100) {
            this.ctype = r100;
            return this;
        }

        public Builder debug(Debug r100) {
            this.debug = r100;
            return this;
        }

        public Builder deprecated(Boolean r100) {
            this.deprecated = r100;
            return this;
        }

        public Builder jstype(JSType r100) {
            this.jstype = r100;
            return this;
        }

        public Builder lazy(Boolean r100) {
            this.lazy = r100;
            return this;
        }

        public Builder packed(Boolean r100) {
            this.packed = r100;
            return this;
        }

        public Builder serde(Serde r100) {
            this.serde = r100;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> r100) {
            com.squareup.wire.internal.Internal.checkElementsNotNull(r100);
            this.uninterpreted_option = r100;
            return this;
        }

        public Builder weak(Boolean r100) {
            this.weak = r100;
            return this;
        }
    }

    public static final enum CType extends java.lang.Enum<CType> implements WireEnum {
        private static final /* synthetic */ CType[] $VALUES = null;
        public static final ProtoAdapter<CType> ADAPTER = null;
        public static final CType CORD = null;
        public static final CType STRING = null;
        public static final CType STRING_PIECE = null;
        private final int value;

        static {
            CType r100 = new CType("STRING", 0, 0);
            STRING = r100;
            CType r101 = new CType("CORD", 1, 1);
            CORD = r101;
            CType r102 = new CType("STRING_PIECE", 2, 2);
            STRING_PIECE = r102;
            $VALUES = new CType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(CType.class);
        }

        public static CType[] values() {
            return (CType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static CType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return STRING_PIECE;
        L12:
            return CORD;
        L14:
            return STRING;
        }

        public static CType valueOf(String r100) {
            return (CType) a.a(CType.class, r100);
        }

        private CType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum JSType extends java.lang.Enum<JSType> implements WireEnum {
        private static final /* synthetic */ JSType[] $VALUES = null;
        public static final ProtoAdapter<JSType> ADAPTER = null;
        public static final JSType JS_NORMAL = null;
        public static final JSType JS_NUMBER = null;
        public static final JSType JS_STRING = null;
        private final int value;

        static {
            JSType r100 = new JSType("JS_NORMAL", 0, 0);
            JS_NORMAL = r100;
            JSType r101 = new JSType("JS_STRING", 1, 1);
            JS_STRING = r101;
            JSType r102 = new JSType("JS_NUMBER", 2, 2);
            JS_NUMBER = r102;
            $VALUES = new JSType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(JSType.class);
        }

        public static JSType[] values() {
            return (JSType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static JSType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return JS_NUMBER;
        L12:
            return JS_STRING;
        L14:
            return JS_NORMAL;
        }

        public static JSType valueOf(String r100) {
            return (JSType) a.a(JSType.class, r100);
        }

        private JSType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_FieldOptions extends ProtoAdapter<FieldOptions> {
        public ProtoAdapter_FieldOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, FieldOptions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FieldOptions decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.ctype = CType.STRING;
            Boolean r102 = Boolean.FALSE;
            r101.packed = r102;
            r101.jstype = JSType.JS_NORMAL;
            r101.lazy = r102;
            r101.deprecated = r102;
            r101.weak = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L36;
            if (r104 != 1) goto L8;
            r101.ctype = CType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
        L34:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.packed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.deprecated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 5) goto L14;
            r101.lazy = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r104 != 6) goto L16;
            r101.jstype = JSType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
        L27:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L16:
            if (r104 != 10) goto L18;
            r101.weak = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            if (r104 != 999) goto L19;
            r101.uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(r100));
            goto L3
        L19:
            switch(r104) {
                case 50001: goto L22;
                case 50002: goto L21;
                default: goto L20;
            };
        L21:
            r101.serde = Serde.ADAPTER.decode(r100);
            goto L3
        L22:
            r101.debug = Debug.ADAPTER.decode(r100);
            goto L3
        L20:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L36:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FieldOptions r100) {
            CType r101 = r100.ctype;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = CType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.packed;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            JSType r107 = r100.jstype;
            if (r107 == null) goto L13;
            int r108 = JSType.ADAPTER.encodedSizeWithTag(6, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.lazy;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.deprecated;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.weak;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r116);
        L26:
            int r118 = (r115 + r117) + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, r100.uninterpreted_option);
            Debug r119 = r100.debug;
            if (r119 == null) goto L29;
            int r120 = Debug.ADAPTER.encodedSizeWithTag(TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND, r119);
        L30:
            int r121 = r118 + r120;
            Serde r122 = r100.serde;
            if (r122 == null) goto L34;
            r102 = Serde.ADAPTER.encodedSizeWithTag(TTVideoEngineInterface.ALGO_OPTION_INT_STOP_TASK_END_PLAY, r122);
        L34:
            return (r121 + r102) + r100.unknownFields().size();
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FieldOptions decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FieldOptions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FieldOptions r101) throws IOException {
            CType r102 = r101.ctype;
            if (r102 == null) goto L5;
            CType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.packed;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            JSType r104 = r101.jstype;
            if (r104 == null) goto L11;
            JSType.ADAPTER.encodeWithTag(r100, 6, r104);
        L11:
            Boolean r105 = r101.lazy;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L14:
            Boolean r106 = r101.deprecated;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r106);
        L17:
            Boolean r107 = r101.weak;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r107);
        L20:
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(r100, 999, r101.uninterpreted_option);
            Debug r108 = r101.debug;
            if (r108 == null) goto L23;
            Debug.ADAPTER.encodeWithTag(r100, TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND, r108);
        L23:
            Serde r109 = r101.serde;
            if (r109 == null) goto L26;
            Serde.ADAPTER.encodeWithTag(r100, TTVideoEngineInterface.ALGO_OPTION_INT_STOP_TASK_END_PLAY, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FieldOptions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FieldOptions();
        DEFAULT_CTYPE = CType.STRING;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_PACKED = r100;
        DEFAULT_JSTYPE = JSType.JS_NORMAL;
        DEFAULT_LAZY = r100;
        DEFAULT_DEPRECATED = r100;
        DEFAULT_WEAK = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ctype = this.ctype;
        r100.packed = this.packed;
        r100.jstype = this.jstype;
        r100.lazy = this.lazy;
        r100.deprecated = this.deprecated;
        r100.weak = this.weak;
        r100.uninterpreted_option = com.squareup.wire.internal.Internal.copyOf("uninterpreted_option", this.uninterpreted_option);
        r100.debug = this.debug;
        r100.serde = this.serde;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FieldOptions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public FieldOptions(CType r110, Boolean r111, JSType r112, Boolean r113, Boolean r114, Boolean r115, List<UninterpretedOption> r116, Debug r117, Serde r210) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, r210, okio.ByteString.EMPTY);
    }

    public FieldOptions(CType r100, Boolean r101, JSType r102, Boolean r103, Boolean r104, Boolean r105, List<UninterpretedOption> r106, Debug r107, Serde r110, okio.ByteString r111) {
        super(ADAPTER, r111);
        this.ctype = r100;
        this.packed = r101;
        this.jstype = r102;
        this.lazy = r103;
        this.deprecated = r104;
        this.weak = r105;
        this.uninterpreted_option = com.squareup.wire.internal.Internal.immutableCopyOf("uninterpreted_option", r106);
        this.debug = r107;
        this.serde = r110;
    }
}
