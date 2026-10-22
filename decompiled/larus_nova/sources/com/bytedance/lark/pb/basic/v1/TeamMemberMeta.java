package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TeamMemberMeta extends com.squareup.wire.Message<TeamMemberMeta, Builder> {
    public static final ProtoAdapter<TeamMemberMeta> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TeamRole> user_roles;

    public static final class Builder extends com.squareup.wire.Message.Builder<TeamMemberMeta, Builder> {
        public List<TeamRole> user_roles;

        @Override // com.squareup.wire.Message.Builder
        public TeamMemberMeta build() {
            return new TeamMemberMeta(this.user_roles, super.buildUnknownFields());
        }

        public Builder() {
            this.user_roles = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder user_roles(List<TeamRole> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_roles = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TeamMemberMeta extends ProtoAdapter<TeamMemberMeta> {
        public ProtoAdapter_TeamMemberMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, TeamMemberMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TeamMemberMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.user_roles.add(TeamRole.ADAPTER.decode(r100));
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
        public int encodedSize2(TeamMemberMeta r100) {
            return TeamRole.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.user_roles) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TeamMemberMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TeamMemberMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TeamMemberMeta r101) throws IOException {
            TeamRole.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.user_roles);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TeamMemberMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TeamMemberMeta();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_roles = Internal.copyOf("user_roles", this.user_roles);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TeamMemberMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TeamMemberMeta(List<TeamRole> r100) {
        this(r100, ByteString.EMPTY);
    }

    public TeamMemberMeta(List<TeamRole> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.user_roles = Internal.immutableCopyOf("user_roles", r100);
    }
}
