package com.ss.android.lark.pb.users;

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

/* JADX INFO: loaded from: classes37.dex */
public final class GroupedManagedDepartments extends Message<GroupedManagedDepartments, Builder> {
    public static final ProtoAdapter<GroupedManagedDepartments> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Group> mgroups;

    public static final class Builder extends Message.Builder<GroupedManagedDepartments, Builder> {
        public List<Group> mgroups;

        @Override // com.squareup.wire.Message.Builder
        public GroupedManagedDepartments build() {
            return new GroupedManagedDepartments(this.mgroups, super.buildUnknownFields());
        }

        public Builder() {
            this.mgroups = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder groups(List<Group> r100) {
            Internal.checkElementsNotNull(r100);
            this.mgroups = r100;
            return this;
        }
    }

    public static final class DepartmentInfo extends Message<DepartmentInfo, Builder> {
        public static final ProtoAdapter<DepartmentInfo> ADAPTER = null;
        public static final String DEFAULT_CODE = "";
        public static final String DEFAULT_ID = "";
        public static final String DEFAULT_LARK_ID = "";
        private static final long serialVersionUID = 0;
        public final String mcode;
        public final String mid;
        public final String mlark_id;
        public final I18nVal mname;

        public static final class Builder extends Message.Builder<DepartmentInfo, Builder> {
            public String mcode;
            public String mid;
            public String mlark_id;
            public I18nVal mname;

            @Override // com.squareup.wire.Message.Builder
            public DepartmentInfo build() {
                return new DepartmentInfo(this.mid, this.mname, this.mlark_id, this.mcode, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder code(String r100) {
                this.mcode = r100;
                return this;
            }

            public Builder id(String r100) {
                this.mid = r100;
                return this;
            }

            public Builder lark_id(String r100) {
                this.mlark_id = r100;
                return this;
            }

            public Builder name(I18nVal r100) {
                this.mname = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DepartmentInfo extends ProtoAdapter<DepartmentInfo> {
            public ProtoAdapter_DepartmentInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, DepartmentInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DepartmentInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mid = "";
                r101.mlark_id = "";
                r101.mcode = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mid = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mname = I18nVal.ADAPTER.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mlark_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.mcode = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(DepartmentInfo r100) {
                String r101 = r100.mid;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                I18nVal r104 = r100.mname;
                if (r104 == null) goto L9;
                int r105 = I18nVal.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mlark_id;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.mcode;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ DepartmentInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DepartmentInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DepartmentInfo r101) throws IOException {
                String r102 = r101.mid;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                I18nVal r103 = r101.mname;
                if (r103 == null) goto L8;
                I18nVal.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mlark_id;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.mcode;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DepartmentInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DepartmentInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mid = this.mid;
            r100.mname = this.mname;
            r100.mlark_id = this.mlark_id;
            r100.mcode = this.mcode;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DepartmentInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DepartmentInfo(String r100, I18nVal r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public DepartmentInfo(String r100, I18nVal r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.mid = r100;
            this.mname = r101;
            this.mlark_id = r102;
            this.mcode = r103;
        }
    }

    public static final class Group extends Message<Group, Builder> {
        public static final ProtoAdapter<Group> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Item> mitems;
        public final SourceType msource_type;
        public final VisibilityType mvisibility_type;

        public static final class Builder extends Message.Builder<Group, Builder> {
            public List<Item> mitems;
            public SourceType msource_type;
            public VisibilityType mvisibility_type;

            @Override // com.squareup.wire.Message.Builder
            public Group build() {
                return new Group(this.msource_type, this.mvisibility_type, this.mitems, super.buildUnknownFields());
            }

            public Builder() {
                this.mitems = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder items(List<Item> r100) {
                Internal.checkElementsNotNull(r100);
                this.mitems = r100;
                return this;
            }

            public Builder source_type(SourceType r100) {
                this.msource_type = r100;
                return this;
            }

            public Builder visibility_type(VisibilityType r100) {
                this.mvisibility_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Group extends ProtoAdapter<Group> {
            public ProtoAdapter_Group() {
                super(FieldEncoding.LENGTH_DELIMITED, Group.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Group decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L21;
                if (r103 != 1) goto L8;
                r101.msource_type = SourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
            L19:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mvisibility_type = VisibilityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mitems.add(Item.ADAPTER.decode(r100));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L21:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Group r100) {
                SourceType r101 = r100.msource_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = SourceType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                VisibilityType r104 = r100.mvisibility_type;
                if (r104 == null) goto L10;
                r102 = VisibilityType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return ((r103 + r102) + Item.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.mitems)) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Group decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Group r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Group r101) throws IOException {
                SourceType r102 = r101.msource_type;
                if (r102 == null) goto L5;
                SourceType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                VisibilityType r103 = r101.mvisibility_type;
                if (r103 == null) goto L8;
                VisibilityType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                Item.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.mitems);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Group r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Group();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.msource_type = this.msource_type;
            r100.mvisibility_type = this.mvisibility_type;
            r100.mitems = Internal.copyOf("mitems", this.mitems);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Group.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Group(SourceType r100, VisibilityType r101, List<Item> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Group(SourceType r100, VisibilityType r101, List<Item> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.msource_type = r100;
            this.mvisibility_type = r101;
            this.mitems = Internal.immutableCopyOf("mitems", r102);
        }
    }

    public static final class Item extends Message<Item, Builder> {
        public static final ProtoAdapter<Item> ADAPTER = null;
        public static final Boolean DEFAULT_ACCESSIBLE = null;
        public static final String DEFAULT_MANAGER_ID = "";
        public static final String DEFAULT_REDIRECT_LINK = "";
        private static final long serialVersionUID = 0;
        public final Boolean maccessible;
        public final DepartmentInfo mdepartment;
        public final String mmanager_id;
        public final String mredirect_link;

        public static final class Builder extends Message.Builder<Item, Builder> {
            public Boolean maccessible;
            public DepartmentInfo mdepartment;
            public String mmanager_id;
            public String mredirect_link;

            @Override // com.squareup.wire.Message.Builder
            public Item build() {
                return new Item(this.mdepartment, this.maccessible, this.mredirect_link, this.mmanager_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder accessible(Boolean r100) {
                this.maccessible = r100;
                return this;
            }

            public Builder department(DepartmentInfo r100) {
                this.mdepartment = r100;
                return this;
            }

            public Builder manager_id(String r100) {
                this.mmanager_id = r100;
                return this;
            }

            public Builder redirect_link(String r100) {
                this.mredirect_link = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Item extends ProtoAdapter<Item> {
            public ProtoAdapter_Item() {
                super(FieldEncoding.LENGTH_DELIMITED, Item.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Item decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.maccessible = Boolean.FALSE;
                r101.mredirect_link = "";
                r101.mmanager_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mdepartment = DepartmentInfo.ADAPTER.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.maccessible = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.mredirect_link = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.mmanager_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Item r100) {
                DepartmentInfo r101 = r100.mdepartment;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = DepartmentInfo.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Boolean r104 = r100.maccessible;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.mredirect_link;
                if (r107 == null) goto L13;
                int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                String r110 = r100.mmanager_id;
                if (r110 == null) goto L18;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
            L18:
                return (r109 + r102) + r100.unknownFields().size();
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
            public /* bridge */ /* synthetic */ Item decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Item r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Item r101) throws IOException {
                DepartmentInfo r102 = r101.mdepartment;
                if (r102 == null) goto L5;
                DepartmentInfo.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Boolean r103 = r101.maccessible;
                if (r103 == null) goto L8;
                ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.mredirect_link;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                String r105 = r101.mmanager_id;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Item r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Item();
            DEFAULT_ACCESSIBLE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mdepartment = this.mdepartment;
            r100.maccessible = this.maccessible;
            r100.mredirect_link = this.mredirect_link;
            r100.mmanager_id = this.mmanager_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Item.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Item(DepartmentInfo r100, Boolean r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public Item(DepartmentInfo r100, Boolean r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.mdepartment = r100;
            this.maccessible = r101;
            this.mredirect_link = r102;
            this.mmanager_id = r103;
        }
    }

    public static final class ProtoAdapter_GroupedManagedDepartments extends ProtoAdapter<GroupedManagedDepartments> {
        public ProtoAdapter_GroupedManagedDepartments() {
            super(FieldEncoding.LENGTH_DELIMITED, GroupedManagedDepartments.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GroupedManagedDepartments decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mgroups.add(Group.ADAPTER.decode(r100));
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
        public int encodedSize2(GroupedManagedDepartments r100) {
            return Group.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mgroups) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GroupedManagedDepartments decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GroupedManagedDepartments r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GroupedManagedDepartments r101) throws IOException {
            Group.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mgroups);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GroupedManagedDepartments r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SourceType extends Enum<SourceType> implements WireEnum {
        private static final /* synthetic */ SourceType[] $VALUES = null;
        public static final ProtoAdapter<SourceType> ADAPTER = null;
        public static final SourceType OTHER_MANAGED = null;
        public static final SourceType SELF_MANAGED = null;
        public static final SourceType SOURCE_TYPE_UNKNOWN = null;
        public static final SourceType SUBORDINATE_MANAGED = null;
        private final int value;

        static {
            SourceType r100 = new SourceType("SOURCE_TYPE_UNKNOWN", 0, 0);
            SOURCE_TYPE_UNKNOWN = r100;
            SourceType r101 = new SourceType("SELF_MANAGED", 1, 1);
            SELF_MANAGED = r101;
            SourceType r102 = new SourceType("SUBORDINATE_MANAGED", 2, 2);
            SUBORDINATE_MANAGED = r102;
            SourceType r103 = new SourceType("OTHER_MANAGED", 3, 3);
            OTHER_MANAGED = r103;
            $VALUES = new SourceType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(SourceType.class);
        }

        public static SourceType[] values() {
            return (SourceType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SourceType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return OTHER_MANAGED;
        L14:
            return SUBORDINATE_MANAGED;
        L16:
            return SELF_MANAGED;
        L18:
            return SOURCE_TYPE_UNKNOWN;
        }

        public static SourceType valueOf(String r100) {
            return (SourceType) a.a(SourceType.class, r100);
        }

        private SourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum VisibilityType extends Enum<VisibilityType> implements WireEnum {
        private static final /* synthetic */ VisibilityType[] $VALUES = null;
        public static final ProtoAdapter<VisibilityType> ADAPTER = null;
        public static final VisibilityType EXTERNAL_HIDDEN = null;
        public static final VisibilityType EXTERNAL_VISIBLE = null;
        public static final VisibilityType VISIBILITY_TYPE_UNKNOWN = null;
        private final int value;

        static {
            VisibilityType r100 = new VisibilityType("VISIBILITY_TYPE_UNKNOWN", 0, 0);
            VISIBILITY_TYPE_UNKNOWN = r100;
            VisibilityType r101 = new VisibilityType("EXTERNAL_VISIBLE", 1, 1);
            EXTERNAL_VISIBLE = r101;
            VisibilityType r102 = new VisibilityType("EXTERNAL_HIDDEN", 2, 2);
            EXTERNAL_HIDDEN = r102;
            $VALUES = new VisibilityType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(VisibilityType.class);
        }

        public static VisibilityType[] values() {
            return (VisibilityType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static VisibilityType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return EXTERNAL_HIDDEN;
        L12:
            return EXTERNAL_VISIBLE;
        L14:
            return VISIBILITY_TYPE_UNKNOWN;
        }

        public static VisibilityType valueOf(String r100) {
            return (VisibilityType) a.a(VisibilityType.class, r100);
        }

        private VisibilityType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GroupedManagedDepartments();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mgroups = Internal.copyOf("mgroups", this.mgroups);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GroupedManagedDepartments.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GroupedManagedDepartments(List<Group> r100) {
        this(r100, ByteString.EMPTY);
    }

    public GroupedManagedDepartments(List<Group> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mgroups = Internal.immutableCopyOf("mgroups", r100);
    }
}
