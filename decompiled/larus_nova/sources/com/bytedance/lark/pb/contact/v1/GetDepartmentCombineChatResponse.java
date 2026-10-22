package com.bytedance.lark.pb.contact.v1;

import com.bytedance.lark.pb.basic.v1.Department;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetDepartmentCombineChatResponse extends Message<GetDepartmentCombineChatResponse, Builder> {
    public static final ProtoAdapter<GetDepartmentCombineChatResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IS_SHOW_DEPARTMENT_PRIMARY_MEMBER_COUNT = null;
    public static final Boolean DEFAULT_IS_SHOW_MEMBER_COUNT = null;
    public static final ProtoAdapter_GetDepartmentCombineChatResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DepartmentStructure department_structure;
    public final List<Integer> display_order;
    public final ExtendFields extend_fields;
    public final List<String> in_chat_chatter_ids;
    public final Boolean is_show_department_primary_member_count;
    public final Boolean is_show_member_count;
    public final List<Department> parent_departments;

    public static final class Builder extends Message.Builder<GetDepartmentCombineChatResponse, Builder> implements d<GetDepartmentCombineChatResponse> {
        public DepartmentStructure department_structure;
        public List<Integer> display_order;
        public ExtendFields extend_fields;
        public List<String> in_chat_chatter_ids;
        public Boolean is_show_department_primary_member_count;
        public Boolean is_show_member_count;
        public List<Department> parent_departments;

        @Override // com.squareup.wire.Message.Builder
        public GetDepartmentCombineChatResponse build() {
            return new GetDepartmentCombineChatResponse(this.department_structure, this.in_chat_chatter_ids, this.extend_fields, this.is_show_member_count, this.display_order, this.parent_departments, this.is_show_department_primary_member_count, super.buildUnknownFields());
        }

        public Builder() {
            this.in_chat_chatter_ids = Internal.newMutableList();
            this.display_order = Internal.newMutableList();
            this.parent_departments = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder department_structure(DepartmentStructure r100) {
            this.department_structure = r100;
            return this;
        }

        public Builder display_order(List<Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.display_order = r100;
            return this;
        }

        public Builder extend_fields(ExtendFields r100) {
            this.extend_fields = r100;
            return this;
        }

        public Builder in_chat_chatter_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.in_chat_chatter_ids = r100;
            return this;
        }

        public Builder is_show_department_primary_member_count(Boolean r100) {
            this.is_show_department_primary_member_count = r100;
            return this;
        }

        public Builder is_show_member_count(Boolean r100) {
            this.is_show_member_count = r100;
            return this;
        }

        public Builder parent_departments(List<Department> r100) {
            Internal.checkElementsNotNull(r100);
            this.parent_departments = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetDepartmentCombineChatResponse extends ProtoAdapter<GetDepartmentCombineChatResponse> implements c<GetDepartmentCombineChatResponse> {
        public ProtoAdapter_GetDepartmentCombineChatResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDepartmentCombineChatResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDepartmentCombineChatResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_show_member_count = Boolean.TRUE;
            r101.is_show_department_primary_member_count = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L14;
            switch(r103) {
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L7:
            r101.is_show_department_primary_member_count = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.parent_departments.add(Department.ADAPTER.decode(r100));
            goto L3
        L9:
            r101.display_order.add(ProtoAdapter.INT32.decode(r100));
            goto L3
        L10:
            r101.is_show_member_count = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.extend_fields = ExtendFields.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.in_chat_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            r101.department_structure = DepartmentStructure.ADAPTER.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L14:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetDepartmentCombineChatResponse r100) {
            DepartmentStructure r101 = r100.department_structure;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = DepartmentStructure.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.in_chat_chatter_ids);
            ExtendFields r105 = r100.extend_fields;
            if (r105 == null) goto L9;
            int r106 = ExtendFields.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            Boolean r108 = r100.is_show_member_count;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r108);
        L14:
            int r110 = ((r107 + r109) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(5, r100.display_order)) + Department.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.parent_departments);
            Boolean r111 = r100.is_show_department_primary_member_count;
            if (r111 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r111);
        L18:
            return (r110 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ GetDepartmentCombineChatResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDepartmentCombineChatResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDepartmentCombineChatResponse r101) throws IOException {
            DepartmentStructure r102 = r101.department_structure;
            if (r102 == null) goto L5;
            DepartmentStructure.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.in_chat_chatter_ids);
            ExtendFields r103 = r101.extend_fields;
            if (r103 == null) goto L8;
            ExtendFields.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            Boolean r104 = r101.is_show_member_count;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 5, r101.display_order);
            Department.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.parent_departments);
            Boolean r105 = r101.is_show_department_primary_member_count;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDepartmentCombineChatResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetDepartmentCombineChatResponse r100 = new ProtoAdapter_GetDepartmentCombineChatResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_SHOW_MEMBER_COUNT = Boolean.TRUE;
        DEFAULT_IS_SHOW_DEPARTMENT_PRIMARY_MEMBER_COUNT = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.department_structure = this.department_structure;
        r100.in_chat_chatter_ids = Internal.copyOf("in_chat_chatter_ids", this.in_chat_chatter_ids);
        r100.extend_fields = this.extend_fields;
        r100.is_show_member_count = this.is_show_member_count;
        r100.display_order = Internal.copyOf("display_order", this.display_order);
        r100.parent_departments = Internal.copyOf("parent_departments", this.parent_departments);
        r100.is_show_department_primary_member_count = this.is_show_department_primary_member_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDepartmentCombineChatResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDepartmentCombineChatResponse(DepartmentStructure r110, List<String> r111, ExtendFields r112, Boolean r113, List<Integer> r114, List<Department> r115, Boolean r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public GetDepartmentCombineChatResponse(DepartmentStructure r100, List<String> r101, ExtendFields r102, Boolean r103, List<Integer> r104, List<Department> r105, Boolean r106, ByteString r107) {
        super(ADAPTER, r107);
        this.department_structure = r100;
        this.in_chat_chatter_ids = Internal.immutableCopyOf("in_chat_chatter_ids", r101);
        this.extend_fields = r102;
        this.is_show_member_count = r103;
        this.display_order = Internal.immutableCopyOf("display_order", r104);
        this.parent_departments = Internal.immutableCopyOf("parent_departments", r105);
        this.is_show_department_primary_member_count = r106;
    }
}
