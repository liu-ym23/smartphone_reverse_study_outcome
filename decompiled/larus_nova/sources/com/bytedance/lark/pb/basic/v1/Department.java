package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Department extends com.squareup.wire.Message<Department, Builder> {
    public static final ProtoAdapter<Department> ADAPTER = null;
    public static final Boolean DEFAULT_CAN_CREATE_DEPARTMENT = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Boolean DEFAULT_HAS_SUB_DEPARTMENTS = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_LEADER_ID = "";
    public static final Integer DEFAULT_MEMBER_COUNT = null;
    public static final Integer DEFAULT_MEMBER_COUNT_BY_DISPLAY_RULE = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_PARENT_ID = "";
    public static final String DEFAULT_REF_PARENT_ID = "";
    private static final long serialVersionUID = 0;
    public final Boolean can_create_department;
    public final String chat_id;
    public final Boolean has_sub_departments;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253477id;
    public final String leader_id;
    public final Integer member_count;
    public final Integer member_count_by_display_rule;
    public final String name;
    public final String parent_id;
    public final String ref_parent_id;

    public static final class Builder extends com.squareup.wire.Message.Builder<Department, Builder> {
        public Boolean can_create_department;
        public String chat_id;
        public Boolean has_sub_departments;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253478id;
        public String leader_id;
        public Integer member_count;
        public Integer member_count_by_display_rule;
        public String name;
        public String parent_id;
        public String ref_parent_id;

        @Override // com.squareup.wire.Message.Builder
        public Department build() {
            String r100 = this.f253478id;
            if (r100 == null) goto L9;
            if (this.name == null) goto L9;
            return new Department(this.f253478id, this.name, this.parent_id, this.leader_id, this.member_count, this.ref_parent_id, this.chat_id, this.has_sub_departments, this.can_create_department, this.member_count_by_display_rule, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.name, "name"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder can_create_department(Boolean r100) {
            this.can_create_department = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder has_sub_departments(Boolean r100) {
            this.has_sub_departments = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253478id = r100;
            return this;
        }

        public Builder leader_id(String r100) {
            this.leader_id = r100;
            return this;
        }

        public Builder member_count(Integer r100) {
            this.member_count = r100;
            return this;
        }

        public Builder member_count_by_display_rule(Integer r100) {
            this.member_count_by_display_rule = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder parent_id(String r100) {
            this.parent_id = r100;
            return this;
        }

        public Builder ref_parent_id(String r100) {
            this.ref_parent_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Department extends ProtoAdapter<Department> {
        public ProtoAdapter_Department() {
            super(FieldEncoding.LENGTH_DELIMITED, Department.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Department decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253478id = "";
            r101.name = "";
            r101.parent_id = "";
            r101.leader_id = "";
            r101.member_count = 0;
            r101.ref_parent_id = "";
            r101.chat_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.has_sub_departments = r102;
            r101.can_create_department = r102;
            r101.member_count_by_display_rule = 0;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L17;
            switch(r104) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.member_count_by_display_rule = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.can_create_department = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.has_sub_departments = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.ref_parent_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.member_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.leader_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.parent_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.f253478id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(Department r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253477id) + r101.encodedSizeWithTag(2, r100.name);
            String r103 = r100.parent_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.leader_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            Integer r110 = r100.member_count;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.ref_parent_id;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.chat_id;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(7, r116);
        L22:
            int r118 = r115 + r117;
            Boolean r119 = r100.has_sub_departments;
            if (r119 == null) goto L25;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r119);
        L26:
            int r121 = r118 + r120;
            Boolean r122 = r100.can_create_department;
            if (r122 == null) goto L29;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r122);
        L30:
            int r124 = r121 + r123;
            Integer r125 = r100.member_count_by_display_rule;
            if (r125 == null) goto L34;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(10, r125);
        L34:
            return (r124 + r104) + r100.unknownFields().size();
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Department decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Department r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Department r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253477id);
            r102.encodeWithTag(r100, 2, r101.name);
            String r103 = r101.parent_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            String r104 = r101.leader_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 4, r104);
        L8:
            Integer r105 = r101.member_count;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r105);
        L11:
            String r106 = r101.ref_parent_id;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 6, r106);
        L14:
            String r107 = r101.chat_id;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 7, r107);
        L17:
            Boolean r108 = r101.has_sub_departments;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
        L20:
            Boolean r109 = r101.can_create_department;
            if (r109 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r109);
        L23:
            Integer r110 = r101.member_count_by_display_rule;
            if (r110 == null) goto L26;
            ProtoAdapter.INT32.encodeWithTag(r100, 10, r110);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Department r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Department();
        DEFAULT_MEMBER_COUNT = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_HAS_SUB_DEPARTMENTS = r100;
        DEFAULT_CAN_CREATE_DEPARTMENT = r100;
        DEFAULT_MEMBER_COUNT_BY_DISPLAY_RULE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253478id = this.f253477id;
        r100.name = this.name;
        r100.parent_id = this.parent_id;
        r100.leader_id = this.leader_id;
        r100.member_count = this.member_count;
        r100.ref_parent_id = this.ref_parent_id;
        r100.chat_id = this.chat_id;
        r100.has_sub_departments = this.has_sub_departments;
        r100.can_create_department = this.can_create_department;
        r100.member_count_by_display_rule = this.member_count_by_display_rule;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Department.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Department(String r110, String r111, String r112, String r113, Integer r114, String r115, String r116, Boolean r210, Boolean r211, Integer r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public Department(String r100, String r101, String r102, String r103, Integer r104, String r105, String r106, Boolean r107, Boolean r110, Integer r111, ByteString r112) {
        super(ADAPTER, r112);
        this.f253477id = r100;
        this.name = r101;
        this.parent_id = r102;
        this.leader_id = r103;
        this.member_count = r104;
        this.ref_parent_id = r105;
        this.chat_id = r106;
        this.has_sub_departments = r107;
        this.can_create_department = r110;
        this.member_count_by_display_rule = r111;
    }
}
