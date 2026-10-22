package com.bytedance.lark.pb.basic.v1;

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

/* JADX INFO: loaded from: classes20.dex */
public final class TeamUserEntity extends com.squareup.wire.Message<TeamUserEntity, Builder> {
    public static final ProtoAdapter<TeamUserEntity> ADAPTER = null;
    public static final Role DEFAULT_USER_ROLE = null;
    public static final Long DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final Role user_role;
    public final List<TeamRole> user_roles;
    public final Long version;

    public static final class Builder extends com.squareup.wire.Message.Builder<TeamUserEntity, Builder> {
        public Role user_role;
        public List<TeamRole> user_roles;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public TeamUserEntity build() {
            return new TeamUserEntity(this.user_role, this.user_roles, this.version, super.buildUnknownFields());
        }

        public Builder() {
            this.user_roles = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder user_role(Role r100) {
            this.user_role = r100;
            return this;
        }

        public Builder user_roles(List<TeamRole> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_roles = r100;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TeamUserEntity extends ProtoAdapter<TeamUserEntity> {
        public ProtoAdapter_TeamUserEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, TeamUserEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TeamUserEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_role = Role.UNKNOWN;
            r101.version = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.user_role = Role.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.user_roles.add(TeamRole.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 100) goto L11;
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TeamUserEntity r100) {
            Role r101 = r100.user_role;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Role.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + TeamRole.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.user_roles);
            Long r105 = r100.version;
            if (r105 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(100, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TeamUserEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TeamUserEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TeamUserEntity r101) throws IOException {
            Role r102 = r101.user_role;
            if (r102 == null) goto L5;
            Role.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            TeamRole.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.user_roles);
            Long r103 = r101.version;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 100, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TeamUserEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Role extends Enum<Role> implements WireEnum {
        private static final /* synthetic */ Role[] $VALUES = null;
        public static final ProtoAdapter<Role> ADAPTER = null;
        public static final Role MEMBER = null;
        public static final Role OWNER = null;
        public static final Role UNKNOWN = null;
        private final int value;

        static {
            Role r100 = new Role("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Role r101 = new Role("MEMBER", 1, 1);
            MEMBER = r101;
            Role r102 = new Role("OWNER", 2, 2);
            OWNER = r102;
            $VALUES = new Role[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(Role.class);
        }

        public static Role[] values() {
            return (Role[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Role fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return OWNER;
        L12:
            return MEMBER;
        L14:
            return UNKNOWN;
        }

        public static Role valueOf(String r100) {
            return (Role) a.a(Role.class, r100);
        }

        private Role(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TeamUserEntity();
        DEFAULT_USER_ROLE = Role.UNKNOWN;
        DEFAULT_VERSION = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_role = this.user_role;
        r100.user_roles = Internal.copyOf("user_roles", this.user_roles);
        r100.version = this.version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TeamUserEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TeamUserEntity(Role r100, List<TeamRole> r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TeamUserEntity(Role r100, List<TeamRole> r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.user_role = r100;
        this.user_roles = Internal.immutableCopyOf("user_roles", r101);
        this.version = r102;
    }
}
