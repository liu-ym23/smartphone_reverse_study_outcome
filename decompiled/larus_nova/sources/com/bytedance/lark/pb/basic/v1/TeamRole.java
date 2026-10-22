package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class TeamRole extends com.squareup.wire.Message<TeamRole, Builder> {
    public static final ProtoAdapter<TeamRole> ADAPTER = null;
    public static final RoleType DEFAULT_ROLE_TYPE = null;
    private static final long serialVersionUID = 0;
    public final RoleType role_type;

    public static final class Builder extends com.squareup.wire.Message.Builder<TeamRole, Builder> {
        public RoleType role_type;

        @Override // com.squareup.wire.Message.Builder
        public TeamRole build() {
            return new TeamRole(this.role_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder role_type(RoleType r100) {
            this.role_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TeamRole extends ProtoAdapter<TeamRole> {
        public ProtoAdapter_TeamRole() {
            super(FieldEncoding.LENGTH_DELIMITED, TeamRole.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TeamRole decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.role_type = RoleType.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.role_type = RoleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TeamRole r100) {
            RoleType r101 = r100.role_type;
            if (r101 == null) goto L5;
            int r102 = RoleType.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TeamRole decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TeamRole r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TeamRole r101) throws IOException {
            RoleType r102 = r101.role_type;
            if (r102 == null) goto L5;
            RoleType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TeamRole r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum RoleType extends Enum<RoleType> implements WireEnum {
        private static final /* synthetic */ RoleType[] $VALUES = null;
        public static final ProtoAdapter<RoleType> ADAPTER = null;
        public static final RoleType ADMIN = null;
        public static final RoleType OWNER = null;
        public static final RoleType UNKNOWN = null;
        private final int value;

        static {
            RoleType r100 = new RoleType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            RoleType r101 = new RoleType("OWNER", 1, 1);
            OWNER = r101;
            RoleType r102 = new RoleType("ADMIN", 2, 2);
            ADMIN = r102;
            $VALUES = new RoleType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(RoleType.class);
        }

        public static RoleType[] values() {
            return (RoleType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static RoleType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return ADMIN;
        L12:
            return OWNER;
        L14:
            return UNKNOWN;
        }

        public static RoleType valueOf(String r100) {
            return (RoleType) a.a(RoleType.class, r100);
        }

        private RoleType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TeamRole();
        DEFAULT_ROLE_TYPE = RoleType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.role_type = this.role_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TeamRole.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TeamRole(RoleType r100) {
        this(r100, ByteString.EMPTY);
    }

    public TeamRole(RoleType r100, ByteString r101) {
        super(ADAPTER, r101);
        this.role_type = r100;
    }
}
