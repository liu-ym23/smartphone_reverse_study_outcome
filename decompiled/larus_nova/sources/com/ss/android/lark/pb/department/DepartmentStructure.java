package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.Chatter;
import com.ss.android.lark.pb.entities.Department;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DepartmentStructure extends Message<DepartmentStructure, Builder> {
    public static final ProtoAdapter<DepartmentStructure> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Boolean DEFAULT_HAS_MORE_DEPARTMENT = null;
    public static final Boolean DEFAULT_IS_USER_EXCEED_LIMIT = null;
    private static final long serialVersionUID = 0;
    public final List<String> madministrator;
    public final ChatInfo mchat_info;
    public final Department mdepartment;
    public final Boolean mhas_more;
    public final Boolean mhas_more_department;
    public final Boolean mis_user_exceed_limit;
    public final Chatter mleader;
    public final List<Department> msub_departments;
    public final List<String> msuper_administrator;
    public final List<Chatter> musers;

    public static final class Builder extends Message.Builder<DepartmentStructure, Builder> {
        public List<String> madministrator;
        public ChatInfo mchat_info;
        public Department mdepartment;
        public Boolean mhas_more;
        public Boolean mhas_more_department;
        public Boolean mis_user_exceed_limit;
        public Chatter mleader;
        public List<Department> msub_departments;
        public List<String> msuper_administrator;
        public List<Chatter> musers;

        @Override // com.squareup.wire.Message.Builder
        public DepartmentStructure build() {
            return new DepartmentStructure(this.mleader, this.mdepartment, this.musers, this.mhas_more, this.msub_departments, this.mchat_info, this.madministrator, this.msuper_administrator, this.mhas_more_department, this.mis_user_exceed_limit, super.buildUnknownFields());
        }

        public Builder() {
            this.musers = Internal.newMutableList();
            this.msub_departments = Internal.newMutableList();
            this.madministrator = Internal.newMutableList();
            this.msuper_administrator = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder administrator(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.madministrator = r100;
            return this;
        }

        public Builder chat_info(ChatInfo r100) {
            this.mchat_info = r100;
            return this;
        }

        public Builder department(Department r100) {
            this.mdepartment = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.mhas_more = r100;
            return this;
        }

        public Builder has_more_department(Boolean r100) {
            this.mhas_more_department = r100;
            return this;
        }

        public Builder is_user_exceed_limit(Boolean r100) {
            this.mis_user_exceed_limit = r100;
            return this;
        }

        public Builder leader(Chatter r100) {
            this.mleader = r100;
            return this;
        }

        public Builder sub_departments(List<Department> r100) {
            Internal.checkElementsNotNull(r100);
            this.msub_departments = r100;
            return this;
        }

        public Builder super_administrator(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.msuper_administrator = r100;
            return this;
        }

        public Builder users(List<Chatter> r100) {
            Internal.checkElementsNotNull(r100);
            this.musers = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DepartmentStructure extends ProtoAdapter<DepartmentStructure> {
        public ProtoAdapter_DepartmentStructure() {
            super(FieldEncoding.LENGTH_DELIMITED, DepartmentStructure.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DepartmentStructure decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.mhas_more = r102;
            r101.mhas_more_department = r102;
            r101.mis_user_exceed_limit = r102;
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
            r101.mis_user_exceed_limit = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mhas_more_department = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.msuper_administrator.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.madministrator.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.mchat_info = ChatInfo.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.msub_departments.add(Department.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.mhas_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            r101.musers.add(Chatter.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.mdepartment = Department.ADAPTER.decode(r100);
            goto L3
        L16:
            r101.mleader = Chatter.ADAPTER.decode(r100);
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
        public int encodedSize2(DepartmentStructure r100) {
            Chatter r101 = r100.mleader;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Chatter.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Department r104 = r100.mdepartment;
            if (r104 == null) goto L9;
            int r105 = Department.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = (r103 + r105) + Chatter.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.musers);
            Boolean r107 = r100.mhas_more;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r107);
        L14:
            int r109 = (r106 + r108) + Department.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.msub_departments);
            ChatInfo r110 = r100.mchat_info;
            if (r110 == null) goto L17;
            int r111 = ChatInfo.ADAPTER.encodedSizeWithTag(6, r110);
        L18:
            int r112 = r109 + r111;
            ProtoAdapter<String> r113 = ProtoAdapter.STRING;
            int r114 = (r112 + r113.asRepeated().encodedSizeWithTag(7, r100.madministrator)) + r113.asRepeated().encodedSizeWithTag(8, r100.msuper_administrator);
            Boolean r115 = r100.mhas_more_department;
            if (r115 == null) goto L21;
            int r116 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r115);
        L22:
            int r117 = r114 + r116;
            Boolean r118 = r100.mis_user_exceed_limit;
            if (r118 == null) goto L26;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r118);
        L26:
            return (r117 + r102) + r100.unknownFields().size();
        L21:
            r116 = 0;
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
        public /* bridge */ /* synthetic */ DepartmentStructure decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DepartmentStructure r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DepartmentStructure r101) throws IOException {
            Chatter r102 = r101.mleader;
            if (r102 == null) goto L5;
            Chatter.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Department r103 = r101.mdepartment;
            if (r103 == null) goto L8;
            Department.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            Chatter.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.musers);
            Boolean r104 = r101.mhas_more;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            Department.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.msub_departments);
            ChatInfo r105 = r101.mchat_info;
            if (r105 == null) goto L14;
            ChatInfo.ADAPTER.encodeWithTag(r100, 6, r105);
        L14:
            ProtoAdapter<String> r106 = ProtoAdapter.STRING;
            r106.asRepeated().encodeWithTag(r100, 7, r101.madministrator);
            r106.asRepeated().encodeWithTag(r100, 8, r101.msuper_administrator);
            Boolean r107 = r101.mhas_more_department;
            if (r107 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r107);
        L17:
            Boolean r108 = r101.mis_user_exceed_limit;
            if (r108 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r108);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DepartmentStructure r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DepartmentStructure();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_HAS_MORE = r100;
        DEFAULT_HAS_MORE_DEPARTMENT = r100;
        DEFAULT_IS_USER_EXCEED_LIMIT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mleader = this.mleader;
        r100.mdepartment = this.mdepartment;
        r100.musers = Internal.copyOf("musers", this.musers);
        r100.mhas_more = this.mhas_more;
        r100.msub_departments = Internal.copyOf("msub_departments", this.msub_departments);
        r100.mchat_info = this.mchat_info;
        r100.madministrator = Internal.copyOf("madministrator", this.madministrator);
        r100.msuper_administrator = Internal.copyOf("msuper_administrator", this.msuper_administrator);
        r100.mhas_more_department = this.mhas_more_department;
        r100.mis_user_exceed_limit = this.mis_user_exceed_limit;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DepartmentStructure.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DepartmentStructure(Chatter r110, Department r111, List<Chatter> r112, Boolean r113, List<Department> r114, ChatInfo r115, List<String> r116, List<String> r210, Boolean r211, Boolean r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public DepartmentStructure(Chatter r100, Department r101, List<Chatter> r102, Boolean r103, List<Department> r104, ChatInfo r105, List<String> r106, List<String> r107, Boolean r110, Boolean r111, ByteString r112) {
        super(ADAPTER, r112);
        this.mleader = r100;
        this.mdepartment = r101;
        this.musers = Internal.immutableCopyOf("musers", r102);
        this.mhas_more = r103;
        this.msub_departments = Internal.immutableCopyOf("msub_departments", r104);
        this.mchat_info = r105;
        this.madministrator = Internal.immutableCopyOf("madministrator", r106);
        this.msuper_administrator = Internal.immutableCopyOf("msuper_administrator", r107);
        this.mhas_more_department = r110;
        this.mis_user_exceed_limit = r111;
    }
}
