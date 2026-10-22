package com.bytedance.lark.pb.search.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class AdvGrammarConf extends Message<AdvGrammarConf, Builder> {
    public static final ProtoAdapter<AdvGrammarConf> ADAPTER = null;
    public static final String DEFAULT_KEY_NAME = "";
    public static final String DEFAULT_REF_APP_ID = "";
    public static final SelectorType DEFAULT_SELECTOR_TYPE = null;
    private static final long serialVersionUID = 0;
    public final List<EnumValue> enum_values;
    public final String key_name;
    public final String ref_app_id;
    public final SelectorType selector_type;

    public static final class Builder extends Message.Builder<AdvGrammarConf, Builder> {
        public List<EnumValue> enum_values;
        public String key_name;
        public String ref_app_id;
        public SelectorType selector_type;

        @Override // com.squareup.wire.Message.Builder
        public AdvGrammarConf build() {
            String r100 = this.key_name;
            if (r100 == null) goto L9;
            if (this.selector_type == null) goto L9;
            return new AdvGrammarConf(this.key_name, this.selector_type, this.enum_values, this.ref_app_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "key_name", this.selector_type, "selector_type"});
        }

        public Builder() {
            this.enum_values = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder enum_values(List<EnumValue> r100) {
            Internal.checkElementsNotNull(r100);
            this.enum_values = r100;
            return this;
        }

        public Builder key_name(String r100) {
            this.key_name = r100;
            return this;
        }

        public Builder ref_app_id(String r100) {
            this.ref_app_id = r100;
            return this;
        }

        public Builder selector_type(SelectorType r100) {
            this.selector_type = r100;
            return this;
        }
    }

    public static final class EnumValue extends Message<EnumValue, Builder> {
        public static final ProtoAdapter<EnumValue> ADAPTER = null;
        public static final String DEFAULT_VALUE_NAME = "";
        private static final long serialVersionUID = 0;
        public final String value_name;

        public static final class Builder extends Message.Builder<EnumValue, Builder> {
            public String value_name;

            @Override // com.squareup.wire.Message.Builder
            public EnumValue build() {
                return new EnumValue(this.value_name, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder value_name(String r100) {
                this.value_name = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_EnumValue extends ProtoAdapter<EnumValue> {
            public ProtoAdapter_EnumValue() {
                super(FieldEncoding.LENGTH_DELIMITED, EnumValue.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public EnumValue decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.value_name = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.value_name = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(EnumValue r100) {
                String r101 = r100.value_name;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ EnumValue decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(EnumValue r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, EnumValue r101) throws IOException {
                String r102 = r101.value_name;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EnumValue r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_EnumValue();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.value_name = this.value_name;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return EnumValue.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public EnumValue(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public EnumValue(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.value_name = r100;
        }
    }

    public static final class ProtoAdapter_AdvGrammarConf extends ProtoAdapter<AdvGrammarConf> {
        public ProtoAdapter_AdvGrammarConf() {
            super(FieldEncoding.LENGTH_DELIMITED, AdvGrammarConf.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AdvGrammarConf decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key_name = "";
            r101.selector_type = SelectorType.ENUM_SELECTOR;
            r101.ref_app_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.key_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.selector_type = SelectorType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.enum_values.add(EnumValue.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.ref_app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AdvGrammarConf r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.key_name) + SelectorType.ADAPTER.encodedSizeWithTag(2, r100.selector_type)) + EnumValue.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.enum_values);
            String r103 = r100.ref_app_id;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(4, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AdvGrammarConf decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AdvGrammarConf r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AdvGrammarConf r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.key_name);
            SelectorType.ADAPTER.encodeWithTag(r100, 2, r101.selector_type);
            EnumValue.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.enum_values);
            String r103 = r101.ref_app_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AdvGrammarConf r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SelectorType extends Enum<SelectorType> implements WireEnum {
        private static final /* synthetic */ SelectorType[] $VALUES = null;
        public static final ProtoAdapter<SelectorType> ADAPTER = null;
        public static final SelectorType CHAT_SELECTOR = null;
        public static final SelectorType ENUM_SELECTOR = null;
        public static final SelectorType MAIL_USER_SELECTOR = null;
        public static final SelectorType SEARCHABLE_SELECTOR = null;
        public static final SelectorType USER_CHAT_SELECTOR = null;
        public static final SelectorType USER_SELECTOR = null;
        private final int value;

        static {
            SelectorType r100 = new SelectorType("ENUM_SELECTOR", 0, 1);
            ENUM_SELECTOR = r100;
            SelectorType r101 = new SelectorType("SEARCHABLE_SELECTOR", 1, 2);
            SEARCHABLE_SELECTOR = r101;
            SelectorType r102 = new SelectorType("USER_SELECTOR", 2, 3);
            USER_SELECTOR = r102;
            SelectorType r103 = new SelectorType("CHAT_SELECTOR", 3, 4);
            CHAT_SELECTOR = r103;
            SelectorType r104 = new SelectorType("USER_CHAT_SELECTOR", 4, 5);
            USER_CHAT_SELECTOR = r104;
            SelectorType r110 = new SelectorType("MAIL_USER_SELECTOR", 5, 6);
            MAIL_USER_SELECTOR = r110;
            $VALUES = new SelectorType[]{r100, r101, r102, r103, r104, r110};
            ADAPTER = ProtoAdapter.newEnumAdapter(SelectorType.class);
        }

        public static SelectorType[] values() {
            return (SelectorType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SelectorType fromValue(int r100) {
            switch(r100) {
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return MAIL_USER_SELECTOR;
        L8:
            return USER_CHAT_SELECTOR;
        L10:
            return CHAT_SELECTOR;
        L12:
            return USER_SELECTOR;
        L14:
            return SEARCHABLE_SELECTOR;
        L16:
            return ENUM_SELECTOR;
        }

        public static SelectorType valueOf(String r100) {
            return (SelectorType) a.a(SelectorType.class, r100);
        }

        private SelectorType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AdvGrammarConf();
        DEFAULT_SELECTOR_TYPE = SelectorType.ENUM_SELECTOR;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key_name = this.key_name;
        r100.selector_type = this.selector_type;
        r100.enum_values = Internal.copyOf("enum_values", this.enum_values);
        r100.ref_app_id = this.ref_app_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AdvGrammarConf.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AdvGrammarConf(String r100, SelectorType r101, List<EnumValue> r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public AdvGrammarConf(String r100, SelectorType r101, List<EnumValue> r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.key_name = r100;
        this.selector_type = r101;
        this.enum_values = Internal.immutableCopyOf("enum_values", r102);
        this.ref_app_id = r103;
    }
}
