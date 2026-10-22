package com.bytedance.lark.pb.im.v1;

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
public final class PatchTeamMembersRoleResponse extends Message<PatchTeamMembersRoleResponse, Builder> {
    public static final ProtoAdapter<PatchTeamMembersRoleResponse> ADAPTER = null;
    public static final ProtoAdapter_PatchTeamMembersRoleResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Long> ordered_weight;
    public final Map<String, TeamMemberMeta> updated_metas;

    public static final class Builder extends Message.Builder<PatchTeamMembersRoleResponse, Builder> implements d<PatchTeamMembersRoleResponse> {
        public Map<String, Long> ordered_weight;
        public Map<String, TeamMemberMeta> updated_metas;

        @Override // com.squareup.wire.Message.Builder
        public PatchTeamMembersRoleResponse build() {
            return new PatchTeamMembersRoleResponse(this.updated_metas, this.ordered_weight, super.buildUnknownFields());
        }

        public Builder() {
            this.updated_metas = Internal.newMutableMap();
            this.ordered_weight = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ordered_weight(Map<String, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.ordered_weight = r100;
            return this;
        }

        public Builder updated_metas(Map<String, TeamMemberMeta> r100) {
            Internal.checkElementsNotNull(r100);
            this.updated_metas = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PatchTeamMembersRoleResponse extends ProtoAdapter<PatchTeamMembersRoleResponse> implements c<PatchTeamMembersRoleResponse> {
        private final ProtoAdapter<Map<String, Long>> ordered_weight;
        private final ProtoAdapter<Map<String, TeamMemberMeta>> updated_metas;

        public ProtoAdapter_PatchTeamMembersRoleResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PatchTeamMembersRoleResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.updated_metas = ProtoAdapter.newMapAdapter(r100, TeamMemberMeta.ADAPTER);
            this.ordered_weight = ProtoAdapter.newMapAdapter(r100, ProtoAdapter.INT64);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PatchTeamMembersRoleResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.updated_metas.putAll(this.updated_metas.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.ordered_weight.putAll(this.ordered_weight.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PatchTeamMembersRoleResponse r100) {
            return (this.updated_metas.encodedSizeWithTag(1, r100.updated_metas) + this.ordered_weight.encodedSizeWithTag(2, r100.ordered_weight)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PatchTeamMembersRoleResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PatchTeamMembersRoleResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PatchTeamMembersRoleResponse r101) throws IOException {
            this.updated_metas.encodeWithTag(r100, 1, r101.updated_metas);
            this.ordered_weight.encodeWithTag(r100, 2, r101.ordered_weight);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PatchTeamMembersRoleResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PatchTeamMembersRoleResponse r100 = new ProtoAdapter_PatchTeamMembersRoleResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.updated_metas = Internal.copyOf("updated_metas", this.updated_metas);
        r100.ordered_weight = Internal.copyOf("ordered_weight", this.ordered_weight);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PatchTeamMembersRoleResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PatchTeamMembersRoleResponse(Map<String, TeamMemberMeta> r100, Map<String, Long> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PatchTeamMembersRoleResponse(Map<String, TeamMemberMeta> r100, Map<String, Long> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.updated_metas = Internal.immutableCopyOf("updated_metas", r100);
        this.ordered_weight = Internal.immutableCopyOf("ordered_weight", r101);
    }
}
