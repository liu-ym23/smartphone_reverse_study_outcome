package com.google.protobuf.server;

import com.larus.im.internal.network.proto2.AvCmd;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.annotation.Debug;
import com.ss.android.lark.pb.annotation.Serde;
import com.ss.android.lark.pb.security.AuthEntity;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public final class FieldOptions extends Message<FieldOptions, Builder> {
    public static final ProtoAdapter<FieldOptions> ADAPTER = null;
    public static final String DEFAULT_COMPATIBLE_MULTIPLE_ID_TYPES = "";
    public static final Boolean DEFAULT_DEPRECATED = null;
    public static final String DEFAULT_FIELDINFO = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_LAZY = null;
    public static final Boolean DEFAULT_PACKED = null;
    public static final Boolean DEFAULT_SAVEFORDEVICE = null;
    public static final Boolean DEFAULT_SECURITY_FIELD = null;
    public static final Boolean DEFAULT_SECURITY_SEARCH_DATA_SOURCE_ID = null;
    public static final Boolean DEFAULT_SECURITY_SEARCH_ENTITY_TYPE = null;
    public static final Boolean DEFAULT_SECURITY_TENANT_ID = null;
    public static final Boolean DEFAULT_WEAK = null;
    private static final long serialVersionUID = 0;
    public final String mFieldInfo;
    public final Boolean mSaveForDevice;
    public final String mcompatible_multiple_id_types;
    public final CType mctype;
    public final Debug mdebug;
    public final Boolean mdeprecated;
    public final String mid;
    public final JSType mjstype;
    public final Boolean mlazy;
    public final Boolean mpacked;
    public final Boolean msecurity_field;
    public final AuthEntity msecurity_object;
    public final Boolean msecurity_search_data_source_id;
    public final Boolean msecurity_search_entity_type;
    public final Boolean msecurity_tenant_id;
    public final Serde mserde;
    public final List<UninterpretedOption> muninterpreted_option;
    public final Boolean mweak;

    public static final class Builder extends Message.Builder<FieldOptions, Builder> {
        public String mFieldInfo;
        public Boolean mSaveForDevice;
        public String mcompatible_multiple_id_types;
        public CType mctype;
        public Debug mdebug;
        public Boolean mdeprecated;
        public String mid;
        public JSType mjstype;
        public Boolean mlazy;
        public Boolean mpacked;
        public Boolean msecurity_field;
        public AuthEntity msecurity_object;
        public Boolean msecurity_search_data_source_id;
        public Boolean msecurity_search_entity_type;
        public Boolean msecurity_tenant_id;
        public Serde mserde;
        public List<UninterpretedOption> muninterpreted_option;
        public Boolean mweak;

        @Override // com.squareup.wire.Message.Builder
        public FieldOptions build() {
            return new FieldOptions(this.mctype, this.mpacked, this.mjstype, this.mlazy, this.mdeprecated, this.mweak, this.muninterpreted_option, this.mFieldInfo, this.mdebug, this.mserde, this.mSaveForDevice, this.msecurity_object, this.msecurity_tenant_id, this.msecurity_field, this.msecurity_search_entity_type, this.msecurity_search_data_source_id, this.mid, this.mcompatible_multiple_id_types, super.buildUnknownFields());
        }

        public Builder() {
            this.muninterpreted_option = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder FieldInfo(String r100) {
            this.mFieldInfo = r100;
            return this;
        }

        public Builder SaveForDevice(Boolean r100) {
            this.mSaveForDevice = r100;
            return this;
        }

        public Builder compatible_multiple_id_types(String r100) {
            this.mcompatible_multiple_id_types = r100;
            return this;
        }

        public Builder ctype(CType r100) {
            this.mctype = r100;
            return this;
        }

        public Builder debug(Debug r100) {
            this.mdebug = r100;
            return this;
        }

        public Builder deprecated(Boolean r100) {
            this.mdeprecated = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder jstype(JSType r100) {
            this.mjstype = r100;
            return this;
        }

        public Builder lazy(Boolean r100) {
            this.mlazy = r100;
            return this;
        }

        public Builder packed(Boolean r100) {
            this.mpacked = r100;
            return this;
        }

        public Builder security_field(Boolean r100) {
            this.msecurity_field = r100;
            return this;
        }

        public Builder security_object(AuthEntity r100) {
            this.msecurity_object = r100;
            return this;
        }

        public Builder security_search_data_source_id(Boolean r100) {
            this.msecurity_search_data_source_id = r100;
            return this;
        }

        public Builder security_search_entity_type(Boolean r100) {
            this.msecurity_search_entity_type = r100;
            return this;
        }

        public Builder security_tenant_id(Boolean r100) {
            this.msecurity_tenant_id = r100;
            return this;
        }

        public Builder serde(Serde r100) {
            this.mserde = r100;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> r100) {
            Internal.checkElementsNotNull(r100);
            this.muninterpreted_option = r100;
            return this;
        }

        public Builder weak(Boolean r100) {
            this.mweak = r100;
            return this;
        }
    }

    public static final enum CType extends Enum<CType> implements WireEnum {
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

    public static final enum JSType extends Enum<JSType> implements WireEnum {
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
            Boolean r102 = Boolean.FALSE;
            r101.mpacked = r102;
            r101.mlazy = r102;
            r101.mdeprecated = r102;
            r101.mweak = r102;
            r101.mFieldInfo = "";
            r101.mSaveForDevice = r102;
            r101.msecurity_tenant_id = r102;
            r101.msecurity_field = r102;
            r101.msecurity_search_entity_type = r102;
            r101.msecurity_search_data_source_id = r102;
            r101.mid = "";
            r101.mcompatible_multiple_id_types = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L31;
            switch(r104) {
                case 1: goto L35;
                case 2: goto L26;
                case 3: goto L25;
                case 5: goto L24;
                case 6: goto L33;
                case 10: goto L19;
                case 999: goto L18;
                case 32100: goto L17;
                case 50001: goto L16;
                case 50002: goto L15;
                case 51234: goto L14;
                case 51235: goto L13;
                case 51236: goto L12;
                case 51250: goto L11;
                case 51251: goto L10;
                case 54321: goto L9;
                case 60000: goto L8;
                case 60001: goto L7;
                default: goto L6;
            };
        L33:
            r101.mjstype = JSType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L35:
            r101.mctype = CType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L29
        L29:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mcompatible_multiple_id_types = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mFieldInfo = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.msecurity_search_data_source_id = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.msecurity_search_entity_type = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.msecurity_field = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.msecurity_tenant_id = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.msecurity_object = AuthEntity.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.mserde = Serde.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.mdebug = Debug.ADAPTER.decode(r100);
            goto L3
        L17:
            r101.mSaveForDevice = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L18:
            r101.muninterpreted_option.add(UninterpretedOption.ADAPTER.decode(r100));
            goto L3
        L19:
            r101.mweak = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.mlazy = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L25:
            r101.mdeprecated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L26:
            r101.mpacked = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L31:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FieldOptions r100) {
            CType r101 = r100.mctype;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = CType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mpacked;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            JSType r107 = r100.mjstype;
            if (r107 == null) goto L13;
            int r108 = JSType.ADAPTER.encodedSizeWithTag(6, r107);
        L14:
            int r109 = r106 + r108;
            Boolean r110 = r100.mlazy;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.mdeprecated;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.mweak;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r116);
        L26:
            int r118 = (r115 + r117) + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, r100.muninterpreted_option);
            String r119 = r100.mFieldInfo;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(54321, r119);
        L30:
            int r121 = r118 + r120;
            Debug r122 = r100.mdebug;
            if (r122 == null) goto L33;
            int r123 = Debug.ADAPTER.encodedSizeWithTag(TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND, r122);
        L34:
            int r124 = r121 + r123;
            Serde r125 = r100.mserde;
            if (r125 == null) goto L37;
            int r126 = Serde.ADAPTER.encodedSizeWithTag(TTVideoEngineInterface.ALGO_OPTION_INT_STOP_TASK_END_PLAY, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.mSaveForDevice;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(32100, r128);
        L42:
            int r130 = r127 + r129;
            AuthEntity r131 = r100.msecurity_object;
            if (r131 == null) goto L45;
            int r132 = AuthEntity.ADAPTER.encodedSizeWithTag(51234, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.msecurity_tenant_id;
            if (r134 == null) goto L49;
            int r135 = ProtoAdapter.BOOL.encodedSizeWithTag(51235, r134);
        L50:
            int r136 = r133 + r135;
            Boolean r137 = r100.msecurity_field;
            if (r137 == null) goto L53;
            int r138 = ProtoAdapter.BOOL.encodedSizeWithTag(51236, r137);
        L54:
            int r139 = r136 + r138;
            Boolean r140 = r100.msecurity_search_entity_type;
            if (r140 == null) goto L57;
            int r141 = ProtoAdapter.BOOL.encodedSizeWithTag(51250, r140);
        L58:
            int r142 = r139 + r141;
            Boolean r143 = r100.msecurity_search_data_source_id;
            if (r143 == null) goto L61;
            int r144 = ProtoAdapter.BOOL.encodedSizeWithTag(51251, r143);
        L62:
            int r145 = r142 + r144;
            String r146 = r100.mid;
            if (r146 == null) goto L65;
            int r147 = ProtoAdapter.STRING.encodedSizeWithTag(60000, r146);
        L66:
            int r148 = r145 + r147;
            String r149 = r100.mcompatible_multiple_id_types;
            if (r149 == null) goto L70;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(AvCmd.CommandEventType.SPEECH_ONLY_VALUE, r149);
        L70:
            return (r148 + r102) + r100.unknownFields().size();
        L65:
            r147 = 0;
            goto L66
        L61:
            r144 = 0;
            goto L62
        L57:
            r141 = 0;
            goto L58
        L53:
            r138 = 0;
            goto L54
        L49:
            r135 = 0;
            goto L50
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
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
            CType r102 = r101.mctype;
            if (r102 == null) goto L5;
            CType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mpacked;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            JSType r104 = r101.mjstype;
            if (r104 == null) goto L11;
            JSType.ADAPTER.encodeWithTag(r100, 6, r104);
        L11:
            Boolean r105 = r101.mlazy;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L14:
            Boolean r106 = r101.mdeprecated;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r106);
        L17:
            Boolean r107 = r101.mweak;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r107);
        L20:
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(r100, 999, r101.muninterpreted_option);
            String r108 = r101.mFieldInfo;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 54321, r108);
        L23:
            Debug r109 = r101.mdebug;
            if (r109 == null) goto L26;
            Debug.ADAPTER.encodeWithTag(r100, TTVideoEngineInterface.ALGO_OPTION_INT_STOP_BACKGROUND, r109);
        L26:
            Serde r110 = r101.mserde;
            if (r110 == null) goto L29;
            Serde.ADAPTER.encodeWithTag(r100, TTVideoEngineInterface.ALGO_OPTION_INT_STOP_TASK_END_PLAY, r110);
        L29:
            Boolean r111 = r101.mSaveForDevice;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 32100, r111);
        L32:
            AuthEntity r112 = r101.msecurity_object;
            if (r112 == null) goto L35;
            AuthEntity.ADAPTER.encodeWithTag(r100, 51234, r112);
        L35:
            Boolean r113 = r101.msecurity_tenant_id;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 51235, r113);
        L38:
            Boolean r114 = r101.msecurity_field;
            if (r114 == null) goto L41;
            ProtoAdapter.BOOL.encodeWithTag(r100, 51236, r114);
        L41:
            Boolean r115 = r101.msecurity_search_entity_type;
            if (r115 == null) goto L44;
            ProtoAdapter.BOOL.encodeWithTag(r100, 51250, r115);
        L44:
            Boolean r116 = r101.msecurity_search_data_source_id;
            if (r116 == null) goto L47;
            ProtoAdapter.BOOL.encodeWithTag(r100, 51251, r116);
        L47:
            String r117 = r101.mid;
            if (r117 == null) goto L50;
            ProtoAdapter.STRING.encodeWithTag(r100, 60000, r117);
        L50:
            String r118 = r101.mcompatible_multiple_id_types;
            if (r118 == null) goto L53;
            ProtoAdapter.STRING.encodeWithTag(r100, AvCmd.CommandEventType.SPEECH_ONLY_VALUE, r118);
        L53:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FieldOptions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FieldOptions();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_PACKED = r100;
        DEFAULT_LAZY = r100;
        DEFAULT_DEPRECATED = r100;
        DEFAULT_WEAK = r100;
        DEFAULT_SAVEFORDEVICE = r100;
        DEFAULT_SECURITY_TENANT_ID = r100;
        DEFAULT_SECURITY_FIELD = r100;
        DEFAULT_SECURITY_SEARCH_ENTITY_TYPE = r100;
        DEFAULT_SECURITY_SEARCH_DATA_SOURCE_ID = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mctype = this.mctype;
        r100.mpacked = this.mpacked;
        r100.mjstype = this.mjstype;
        r100.mlazy = this.mlazy;
        r100.mdeprecated = this.mdeprecated;
        r100.mweak = this.mweak;
        r100.muninterpreted_option = Internal.copyOf("muninterpreted_option", this.muninterpreted_option);
        r100.mFieldInfo = this.mFieldInfo;
        r100.mdebug = this.mdebug;
        r100.mserde = this.mserde;
        r100.mSaveForDevice = this.mSaveForDevice;
        r100.msecurity_object = this.msecurity_object;
        r100.msecurity_tenant_id = this.msecurity_tenant_id;
        r100.msecurity_field = this.msecurity_field;
        r100.msecurity_search_entity_type = this.msecurity_search_entity_type;
        r100.msecurity_search_data_source_id = this.msecurity_search_data_source_id;
        r100.mid = this.mid;
        r100.mcompatible_multiple_id_types = this.mcompatible_multiple_id_types;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FieldOptions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FieldOptions(CType r210, Boolean r211, JSType r212, Boolean r213, Boolean r214, Boolean r215, List<UninterpretedOption> r216, String r217, Debug r218, Serde r310, Boolean r311, AuthEntity r312, Boolean r313, Boolean r314, Boolean r315, Boolean r316, String r317, String r318) {
        this(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318, ByteString.EMPTY);
    }

    public FieldOptions(CType r100, Boolean r101, JSType r102, Boolean r103, Boolean r104, Boolean r105, List<UninterpretedOption> r110, String r111, Debug r112, Serde r113, Boolean r114, AuthEntity r115, Boolean r116, Boolean r117, Boolean r118, Boolean r119, String r210, String r211, ByteString r212) {
        super(ADAPTER, r212);
        this.mctype = r100;
        this.mpacked = r101;
        this.mjstype = r102;
        this.mlazy = r103;
        this.mdeprecated = r104;
        this.mweak = r105;
        this.muninterpreted_option = Internal.immutableCopyOf("muninterpreted_option", r110);
        this.mFieldInfo = r111;
        this.mdebug = r112;
        this.mserde = r113;
        this.mSaveForDevice = r114;
        this.msecurity_object = r115;
        this.msecurity_tenant_id = r116;
        this.msecurity_field = r117;
        this.msecurity_search_entity_type = r118;
        this.msecurity_search_data_source_id = r119;
        this.mid = r210;
        this.mcompatible_multiple_id_types = r211;
    }
}
