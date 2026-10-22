package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Team;
import com.bytedance.lark.pb.basic.v1.TeamEntity;
import com.bytedance.lark.pb.basic.v1.TeamMemberMeta;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PatchTeamResponse extends Message<PatchTeamResponse, Builder> {
    public static final ProtoAdapter<PatchTeamResponse> ADAPTER = null;
    public static final ProtoAdapter_PatchTeamResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, TeamMemberMeta> metas;
    public final Map<String, Long> ordered_weight;
    public final Team team;
    public final TeamEntity team_entity;

    public static final class Builder extends Message.Builder<PatchTeamResponse, Builder> implements d<PatchTeamResponse> {
        public Map<String, TeamMemberMeta> metas;
        public Map<String, Long> ordered_weight;
        public Team team;
        public TeamEntity team_entity;

        @Override // com.squareup.wire.Message.Builder
        public PatchTeamResponse build() {
            return new PatchTeamResponse(this.team, this.metas, this.ordered_weight, this.team_entity, super.buildUnknownFields());
        }

        public Builder() {
            this.metas = Internal.newMutableMap();
            this.ordered_weight = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder metas(Map<String, TeamMemberMeta> r100) {
            Internal.checkElementsNotNull(r100);
            this.metas = r100;
            return this;
        }

        public Builder ordered_weight(Map<String, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.ordered_weight = r100;
            return this;
        }

        public Builder team(Team r100) {
            this.team = r100;
            return this;
        }

        public Builder team_entity(TeamEntity r100) {
            this.team_entity = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PatchTeamResponse extends ProtoAdapter<PatchTeamResponse> implements c<PatchTeamResponse> {
        private final ProtoAdapter<Map<String, TeamMemberMeta>> metas;
        private final ProtoAdapter<Map<String, Long>> ordered_weight;

        public ProtoAdapter_PatchTeamResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PatchTeamResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.metas = ProtoAdapter.newMapAdapter(r100, TeamMemberMeta.ADAPTER);
            this.ordered_weight = ProtoAdapter.newMapAdapter(r100, ProtoAdapter.INT64);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PatchTeamResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.team = Team.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.metas.putAll(this.metas.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.ordered_weight.putAll(this.ordered_weight.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.team_entity = TeamEntity.ADAPTER.decode(r100);
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
        public int encodedSize2(PatchTeamResponse r100) {
            Team r101 = r100.team;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = Team.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = (r103 + this.metas.encodedSizeWithTag(2, r100.metas)) + this.ordered_weight.encodedSizeWithTag(3, r100.ordered_weight);
            TeamEntity r105 = r100.team_entity;
            if (r105 == null) goto L10;
            r102 = TeamEntity.ADAPTER.encodedSizeWithTag(4, r105);
        L10:
            return (r104 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PatchTeamResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PatchTeamResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PatchTeamResponse r101) throws IOException {
            Team r102 = r101.team;
            if (r102 == null) goto L5;
            Team.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            this.metas.encodeWithTag(r100, 2, r101.metas);
            this.ordered_weight.encodeWithTag(r100, 3, r101.ordered_weight);
            TeamEntity r103 = r101.team_entity;
            if (r103 == null) goto L8;
            TeamEntity.ADAPTER.encodeWithTag(r100, 4, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PatchTeamResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PatchTeamResponse r100 = new ProtoAdapter_PatchTeamResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.team = this.team;
        r100.metas = Internal.copyOf("metas", this.metas);
        r100.ordered_weight = Internal.copyOf("ordered_weight", this.ordered_weight);
        r100.team_entity = this.team_entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PatchTeamResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PatchTeamResponse(Team r100, Map<String, TeamMemberMeta> r101, Map<String, Long> r102, TeamEntity r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PatchTeamResponse(Team r100, Map<String, TeamMemberMeta> r101, Map<String, Long> r102, TeamEntity r103, ByteString r104) {
        super(ADAPTER, r104);
        this.team = r100;
        this.metas = Internal.immutableCopyOf("metas", r101);
        this.ordered_weight = Internal.immutableCopyOf("ordered_weight", r102);
        this.team_entity = r103;
    }
}
