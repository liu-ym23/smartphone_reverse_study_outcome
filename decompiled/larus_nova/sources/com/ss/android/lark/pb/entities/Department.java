package com.ss.android.lark.pb.entities;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Department extends com.squareup.wire.Message<Department, Builder> {
    public static final ProtoAdapter<Department> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Boolean DEFAULT_HAS_CHILD = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_LEADER_ID = "";
    public static final Integer DEFAULT_MEMBER_COUNT = null;
    public static final Integer DEFAULT_MEMBER_COUNT_BY_DISPLAY_RULE = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_PINYIN = "";
    public static final String DEFAULT_PARENT_ID = "";
    public static final Integer DEFAULT_STATUS = null;
    public static final FieldOptions FIELD_OPTIONS_MID = null;
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final List<DepartmentLeader> mdeptLeaders;
    public final Boolean mhas_child;
    public final Map<String, String> mi18n_name;
    public final String mid;
    public final String mleader_id;
    public final Integer mmember_count;
    public final Integer mmember_count_by_display_rule;
    public final String mname;
    public final String mname_pinyin;
    public final String mparent_id;
    public final Integer mstatus;

    public static final class Builder extends com.squareup.wire.Message.Builder<Department, Builder> {
        public String mchat_id;
        public List<DepartmentLeader> mdeptLeaders;
        public Boolean mhas_child;
        public Map<String, String> mi18n_name;
        public String mid;
        public String mleader_id;
        public Integer mmember_count;
        public Integer mmember_count_by_display_rule;
        public String mname;
        public String mname_pinyin;
        public String mparent_id;
        public Integer mstatus;

        @Override // com.squareup.wire.Message.Builder
        public Department build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new Department(this.mid, this.mname, this.mparent_id, this.mleader_id, this.mmember_count, this.mstatus, this.mname_pinyin, this.mchat_id, this.mhas_child, this.mi18n_name, this.mdeptLeaders, this.mmember_count_by_display_rule, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
            this.mi18n_name = Internal.newMutableMap();
            this.mdeptLeaders = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder deptLeaders(List<DepartmentLeader> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdeptLeaders = r100;
            return this;
        }

        public Builder has_child(Boolean r100) {
            this.mhas_child = r100;
            return this;
        }

        public Builder i18n_name(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mi18n_name = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder leader_id(String r100) {
            this.mleader_id = r100;
            return this;
        }

        public Builder member_count(Integer r100) {
            this.mmember_count = r100;
            return this;
        }

        public Builder member_count_by_display_rule(Integer r100) {
            this.mmember_count_by_display_rule = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder name_pinyin(String r100) {
            this.mname_pinyin = r100;
            return this;
        }

        public Builder parent_id(String r100) {
            this.mparent_id = r100;
            return this;
        }

        public Builder status(Integer r100) {
            this.mstatus = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Department extends ProtoAdapter<Department> {
        private final ProtoAdapter<Map<String, String>> mi18n_name;

        public ProtoAdapter_Department() {
            super(FieldEncoding.LENGTH_DELIMITED, Department.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mi18n_name = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Department decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.mname = "";
            r101.mparent_id = "";
            r101.mleader_id = "";
            r101.mmember_count = 0;
            r101.mstatus = 0;
            r101.mname_pinyin = "";
            r101.mchat_id = "";
            r101.mhas_child = Boolean.FALSE;
            r101.mmember_count_by_display_rule = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                case 8: goto L11;
                case 9: goto L10;
                case 10: goto L9;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L7:
            r101.mmember_count_by_display_rule = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            r101.mdeptLeaders.add(DepartmentLeader.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.mi18n_name.putAll(this.mi18n_name.decode(r100));
            goto L3
        L10:
            r101.mhas_child = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.mchat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mname_pinyin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.mstatus = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            r101.mmember_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.mleader_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mparent_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Department r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            String r103 = r100.mname;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.mparent_id;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.mleader_id;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            Integer r113 = r100.mmember_count;
            if (r113 == null) goto L17;
            int r114 = ProtoAdapter.INT32.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            Integer r116 = r100.mstatus;
            if (r116 == null) goto L21;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.mname_pinyin;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(7, r119);
        L26:
            int r121 = r118 + r120;
            String r122 = r100.mchat_id;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(8, r122);
        L30:
            int r124 = r121 + r123;
            Boolean r125 = r100.mhas_child;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L34:
            int r127 = ((r124 + r126) + this.mi18n_name.encodedSizeWithTag(10, r100.mi18n_name)) + DepartmentLeader.ADAPTER.asRepeated().encodedSizeWithTag(11, r100.mdeptLeaders);
            Integer r128 = r100.mmember_count_by_display_rule;
            if (r128 == null) goto L38;
            r104 = ProtoAdapter.INT32.encodedSizeWithTag(12, r128);
        L38:
            return (r127 + r104) + r100.unknownFields().size();
        L33:
            r126 = 0;
            goto L34
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
            r102.encodeWithTag(r100, 1, r101.mid);
            String r103 = r101.mname;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.mparent_id;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.mleader_id;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            Integer r106 = r101.mmember_count;
            if (r106 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 5, r106);
        L14:
            Integer r107 = r101.mstatus;
            if (r107 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L17:
            String r108 = r101.mname_pinyin;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 7, r108);
        L20:
            String r109 = r101.mchat_id;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 8, r109);
        L23:
            Boolean r110 = r101.mhas_child;
            if (r110 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L26:
            this.mi18n_name.encodeWithTag(r100, 10, r101.mi18n_name);
            DepartmentLeader.ADAPTER.asRepeated().encodeWithTag(r100, 11, r101.mdeptLeaders);
            Integer r111 = r101.mmember_count_by_display_rule;
            if (r111 == null) goto L29;
            ProtoAdapter.INT32.encodeWithTag(r100, 12, r111);
        L29:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Department r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Department();
        FIELD_OPTIONS_MID = new FieldOptions.Builder().id("department_id").build();
        DEFAULT_MEMBER_COUNT = 0;
        DEFAULT_STATUS = 0;
        DEFAULT_HAS_CHILD = Boolean.FALSE;
        DEFAULT_MEMBER_COUNT_BY_DISPLAY_RULE = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mname = this.mname;
        r100.mparent_id = this.mparent_id;
        r100.mleader_id = this.mleader_id;
        r100.mmember_count = this.mmember_count;
        r100.mstatus = this.mstatus;
        r100.mname_pinyin = this.mname_pinyin;
        r100.mchat_id = this.mchat_id;
        r100.mhas_child = this.mhas_child;
        r100.mi18n_name = Internal.copyOf("mi18n_name", this.mi18n_name);
        r100.mdeptLeaders = Internal.copyOf("mdeptLeaders", this.mdeptLeaders);
        r100.mmember_count_by_display_rule = this.mmember_count_by_display_rule;
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

    public Department(String r110, String r111, String r112, String r113, Integer r114, Integer r210, String r211, String r212, Boolean r213, Map<String, String> r214, List<DepartmentLeader> r215, Integer r216) {
        this(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216, ByteString.EMPTY);
    }

    public Department(String r100, String r101, String r102, String r103, Integer r104, Integer r105, String r106, String r107, Boolean r110, Map<String, String> r111, List<DepartmentLeader> r112, Integer r113, ByteString r114) {
        super(ADAPTER, r114);
        this.mid = r100;
        this.mname = r101;
        this.mparent_id = r102;
        this.mleader_id = r103;
        this.mmember_count = r104;
        this.mstatus = r105;
        this.mname_pinyin = r106;
        this.mchat_id = r107;
        this.mhas_child = r110;
        this.mi18n_name = Internal.immutableCopyOf("mi18n_name", r111);
        this.mdeptLeaders = Internal.immutableCopyOf("mdeptLeaders", r112);
        this.mmember_count_by_display_rule = r113;
    }
}
