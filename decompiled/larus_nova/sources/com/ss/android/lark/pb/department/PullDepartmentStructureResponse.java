package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Department;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullDepartmentStructureResponse extends Message<PullDepartmentStructureResponse, Builder> {
    public static final ProtoAdapter<PullDepartmentStructureResponse> ADAPTER = null;
    public static final Boolean DEFAULT_SHOW_DEPARTMENT_COUNT = null;
    public static final Boolean DEFAULT_SHOW_DEPARTMENT_PRIMARY_MEMBER_COUNT = null;
    private static final long serialVersionUID = 0;
    public final List<String> mchatters_in_chat_id;
    public final List<Department> mdepartment_path;
    public final DepartmentStructure mdepartment_structure;
    public final List<ContactDisplayModule> mdisplay_order;
    public final ExtendFields mextend_fields;
    public final Boolean mshow_department_count;
    public final Boolean mshow_department_primary_member_count;

    public static final class Builder extends Message.Builder<PullDepartmentStructureResponse, Builder> {
        public List<String> mchatters_in_chat_id;
        public List<Department> mdepartment_path;
        public DepartmentStructure mdepartment_structure;
        public List<ContactDisplayModule> mdisplay_order;
        public ExtendFields mextend_fields;
        public Boolean mshow_department_count;
        public Boolean mshow_department_primary_member_count;

        @Override // com.squareup.wire.Message.Builder
        public PullDepartmentStructureResponse build() {
            return new PullDepartmentStructureResponse(this.mdepartment_structure, this.mchatters_in_chat_id, this.mextend_fields, this.mshow_department_count, this.mdepartment_path, this.mdisplay_order, this.mshow_department_primary_member_count, super.buildUnknownFields());
        }

        public Builder() {
            this.mchatters_in_chat_id = Internal.newMutableList();
            this.mdepartment_path = Internal.newMutableList();
            this.mdisplay_order = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatters_in_chat_id(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mchatters_in_chat_id = r100;
            return this;
        }

        public Builder department_path(List<Department> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdepartment_path = r100;
            return this;
        }

        public Builder department_structure(DepartmentStructure r100) {
            this.mdepartment_structure = r100;
            return this;
        }

        public Builder display_order(List<ContactDisplayModule> r100) {
            Internal.checkElementsNotNull(r100);
            this.mdisplay_order = r100;
            return this;
        }

        public Builder extend_fields(ExtendFields r100) {
            this.mextend_fields = r100;
            return this;
        }

        public Builder show_department_count(Boolean r100) {
            this.mshow_department_count = r100;
            return this;
        }

        public Builder show_department_primary_member_count(Boolean r100) {
            this.mshow_department_primary_member_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullDepartmentStructureResponse extends ProtoAdapter<PullDepartmentStructureResponse> {
        public ProtoAdapter_PullDepartmentStructureResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullDepartmentStructureResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullDepartmentStructureResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.mshow_department_count = r102;
            r101.mshow_department_primary_member_count = r102;
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
                case 6: goto L19;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r101.mdisplay_order.add(ContactDisplayModule.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mshow_department_primary_member_count = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            r101.mdepartment_path.add(Department.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.mshow_department_count = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.mextend_fields = ExtendFields.ADAPTER.decode(r100);
            goto L3
        L15:
            r101.mchatters_in_chat_id.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L16:
            r101.mdepartment_structure = DepartmentStructure.ADAPTER.decode(r100);
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
        public int encodedSize2(PullDepartmentStructureResponse r100) {
            DepartmentStructure r101 = r100.mdepartment_structure;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = DepartmentStructure.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.mchatters_in_chat_id);
            ExtendFields r105 = r100.mextend_fields;
            if (r105 == null) goto L9;
            int r106 = ExtendFields.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            Boolean r108 = r100.mshow_department_count;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r108);
        L14:
            int r110 = ((r107 + r109) + Department.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.mdepartment_path)) + ContactDisplayModule.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.mdisplay_order);
            Boolean r111 = r100.mshow_department_primary_member_count;
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
        public /* bridge */ /* synthetic */ PullDepartmentStructureResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullDepartmentStructureResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullDepartmentStructureResponse r101) throws IOException {
            DepartmentStructure r102 = r101.mdepartment_structure;
            if (r102 == null) goto L5;
            DepartmentStructure.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.mchatters_in_chat_id);
            ExtendFields r103 = r101.mextend_fields;
            if (r103 == null) goto L8;
            ExtendFields.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            Boolean r104 = r101.mshow_department_count;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            Department.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.mdepartment_path);
            ContactDisplayModule.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.mdisplay_order);
            Boolean r105 = r101.mshow_department_primary_member_count;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullDepartmentStructureResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullDepartmentStructureResponse();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SHOW_DEPARTMENT_COUNT = r100;
        DEFAULT_SHOW_DEPARTMENT_PRIMARY_MEMBER_COUNT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mdepartment_structure = this.mdepartment_structure;
        r100.mchatters_in_chat_id = Internal.copyOf("mchatters_in_chat_id", this.mchatters_in_chat_id);
        r100.mextend_fields = this.mextend_fields;
        r100.mshow_department_count = this.mshow_department_count;
        r100.mdepartment_path = Internal.copyOf("mdepartment_path", this.mdepartment_path);
        r100.mdisplay_order = Internal.copyOf("mdisplay_order", this.mdisplay_order);
        r100.mshow_department_primary_member_count = this.mshow_department_primary_member_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullDepartmentStructureResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullDepartmentStructureResponse(DepartmentStructure r110, List<String> r111, ExtendFields r112, Boolean r113, List<Department> r114, List<ContactDisplayModule> r115, Boolean r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public PullDepartmentStructureResponse(DepartmentStructure r100, List<String> r101, ExtendFields r102, Boolean r103, List<Department> r104, List<ContactDisplayModule> r105, Boolean r106, ByteString r107) {
        super(ADAPTER, r107);
        this.mdepartment_structure = r100;
        this.mchatters_in_chat_id = Internal.immutableCopyOf("mchatters_in_chat_id", r101);
        this.mextend_fields = r102;
        this.mshow_department_count = r103;
        this.mdepartment_path = Internal.immutableCopyOf("mdepartment_path", r104);
        this.mdisplay_order = Internal.immutableCopyOf("mdisplay_order", r105);
        this.mshow_department_primary_member_count = r106;
    }
}
