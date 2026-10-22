package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatRefDynamicRule extends com.squareup.wire.Message<ChatRefDynamicRule, Builder> {
    public static final ProtoAdapter<ChatRefDynamicRule> ADAPTER = null;
    public static final Boolean DEFAULT_ALLOW_ALL_EMPLOYEE_TYPE = null;
    public static final Boolean DEFAULT_EDITABLE = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_REF_ID = "";
    public static final String DEFAULT_REF_NAME = "";
    private static final long serialVersionUID = 0;
    public final Boolean mallow_all_employee_type;
    public final Boolean meditable;
    public final List<String> memployee_types;
    public final String mid;
    public final String mref_id;
    public final String mref_name;
    public final RuleType mrule_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatRefDynamicRule, Builder> {
        public Boolean mallow_all_employee_type;
        public Boolean meditable;
        public List<String> memployee_types;
        public String mid;
        public String mref_id;
        public String mref_name;
        public RuleType mrule_type;

        @Override // com.squareup.wire.Message.Builder
        public ChatRefDynamicRule build() {
            RuleType r100 = this.mrule_type;
            if (r100 == null) goto L7;
            return new ChatRefDynamicRule(this.mid, this.mrule_type, this.mref_id, this.mref_name, this.memployee_types, this.mallow_all_employee_type, this.meditable, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mrule_type"});
        }

        public Builder() {
            this.memployee_types = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder allow_all_employee_type(Boolean r100) {
            this.mallow_all_employee_type = r100;
            return this;
        }

        public Builder editable(Boolean r100) {
            this.meditable = r100;
            return this;
        }

        public Builder employee_types(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.memployee_types = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder ref_id(String r100) {
            this.mref_id = r100;
            return this;
        }

        public Builder ref_name(String r100) {
            this.mref_name = r100;
            return this;
        }

        public Builder rule_type(RuleType r100) {
            this.mrule_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatRefDynamicRule extends ProtoAdapter<ChatRefDynamicRule> {
        public ProtoAdapter_ChatRefDynamicRule() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatRefDynamicRule.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatRefDynamicRule decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mref_id = "";
            r101.mref_name = "";
            Boolean r102 = Boolean.FALSE;
            r101.mallow_all_employee_type = r102;
            r101.meditable = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L17;
            switch(r104) {
                case 1: goto L16;
                case 2: goto L19;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r101.mrule_type = RuleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.meditable = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mallow_all_employee_type = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.memployee_types.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.mref_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mref_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ChatRefDynamicRule r100) {
            String r101 = r100.mid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + RuleType.ADAPTER.encodedSizeWithTag(2, r100.mrule_type);
            String r105 = r100.mref_id;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.STRING.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            String r108 = r100.mref_name;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.STRING.encodedSizeWithTag(4, r108);
        L14:
            int r110 = (r107 + r109) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, r100.memployee_types);
            Boolean r111 = r100.mallow_all_employee_type;
            if (r111 == null) goto L17;
            int r112 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r111);
        L18:
            int r113 = r110 + r112;
            Boolean r114 = r100.meditable;
            if (r114 == null) goto L22;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r114);
        L22:
            return (r113 + r102) + r100.unknownFields().size();
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatRefDynamicRule decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatRefDynamicRule r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatRefDynamicRule r101) throws IOException {
            String r102 = r101.mid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            RuleType.ADAPTER.encodeWithTag(r100, 2, r101.mrule_type);
            String r103 = r101.mref_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.mref_name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 5, r101.memployee_types);
            Boolean r105 = r101.mallow_all_employee_type;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r105);
        L14:
            Boolean r106 = r101.meditable;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatRefDynamicRule r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum RuleType extends Enum<RuleType> implements WireEnum {
        private static final /* synthetic */ RuleType[] $VALUES = null;
        public static final ProtoAdapter<RuleType> ADAPTER = null;
        public static final RuleType DEPARTMENT = null;
        public static final RuleType UNKNOWN_RULE = null;
        private final int value;

        static {
            RuleType r100 = new RuleType("UNKNOWN_RULE", 0, 0);
            UNKNOWN_RULE = r100;
            RuleType r101 = new RuleType("DEPARTMENT", 1, 1);
            DEPARTMENT = r101;
            $VALUES = new RuleType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(RuleType.class);
        }

        public static RuleType[] values() {
            return (RuleType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static RuleType fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return DEPARTMENT;
        L10:
            return UNKNOWN_RULE;
        }

        public static RuleType valueOf(String r100) {
            return (RuleType) a.a(RuleType.class, r100);
        }

        private RuleType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatRefDynamicRule();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_ALLOW_ALL_EMPLOYEE_TYPE = r100;
        DEFAULT_EDITABLE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mrule_type = this.mrule_type;
        r100.mref_id = this.mref_id;
        r100.mref_name = this.mref_name;
        r100.memployee_types = Internal.copyOf("memployee_types", this.memployee_types);
        r100.mallow_all_employee_type = this.mallow_all_employee_type;
        r100.meditable = this.meditable;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatRefDynamicRule.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatRefDynamicRule(String r110, RuleType r111, String r112, String r113, List<String> r114, Boolean r115, Boolean r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public ChatRefDynamicRule(String r100, RuleType r101, String r102, String r103, List<String> r104, Boolean r105, Boolean r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mid = r100;
        this.mrule_type = r101;
        this.mref_id = r102;
        this.mref_name = r103;
        this.memployee_types = Internal.immutableCopyOf("memployee_types", r104);
        this.mallow_all_employee_type = r105;
        this.meditable = r106;
    }
}
