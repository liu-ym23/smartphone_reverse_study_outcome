package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.TeamMemberInfo;
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
public final class GetTeamChattersResponse extends Message<GetTeamChattersResponse, Builder> {
    public static final ProtoAdapter<GetTeamChattersResponse> ADAPTER = null;
    public static final Boolean DEFAULT_FORBIDDEN_BY_SECURITY = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Long DEFAULT_NEXT_OFFSET = null;
    public static final ProtoAdapter_GetTeamChattersResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean forbidden_by_security;
    public final Boolean has_more;
    public final Long next_offset;
    public final List<TeamMemberInfo> team_member_infos;

    public static final class Builder extends Message.Builder<GetTeamChattersResponse, Builder> implements d<GetTeamChattersResponse> {
        public Boolean forbidden_by_security;
        public Boolean has_more;
        public Long next_offset;
        public List<TeamMemberInfo> team_member_infos;

        @Override // com.squareup.wire.Message.Builder
        public GetTeamChattersResponse build() {
            return new GetTeamChattersResponse(this.team_member_infos, this.next_offset, this.has_more, this.forbidden_by_security, super.buildUnknownFields());
        }

        public Builder() {
            this.team_member_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder forbidden_by_security(Boolean r100) {
            this.forbidden_by_security = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder next_offset(Long r100) {
            this.next_offset = r100;
            return this;
        }

        public Builder team_member_infos(List<TeamMemberInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.team_member_infos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTeamChattersResponse extends ProtoAdapter<GetTeamChattersResponse> implements c<GetTeamChattersResponse> {
        public ProtoAdapter_GetTeamChattersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTeamChattersResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTeamChattersResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.next_offset = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.has_more = r102;
            r101.forbidden_by_security = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.team_member_infos.add(TeamMemberInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.next_offset = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.forbidden_by_security = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetTeamChattersResponse r100) {
            int r101 = TeamMemberInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.team_member_infos);
            Long r102 = r100.next_offset;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.has_more;
            if (r106 == null) goto L9;
            int r107 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Boolean r109 = r100.forbidden_by_security;
            if (r109 == null) goto L14;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTeamChattersResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTeamChattersResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTeamChattersResponse r101) throws IOException {
            TeamMemberInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.team_member_infos);
            Long r102 = r101.next_offset;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            Boolean r103 = r101.has_more;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r103);
        L8:
            Boolean r104 = r101.forbidden_by_security;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTeamChattersResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTeamChattersResponse r100 = new ProtoAdapter_GetTeamChattersResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_NEXT_OFFSET = 0L;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_HAS_MORE = r101;
        DEFAULT_FORBIDDEN_BY_SECURITY = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.team_member_infos = Internal.copyOf("team_member_infos", this.team_member_infos);
        r100.next_offset = this.next_offset;
        r100.has_more = this.has_more;
        r100.forbidden_by_security = this.forbidden_by_security;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTeamChattersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTeamChattersResponse(List<TeamMemberInfo> r100, Long r101, Boolean r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetTeamChattersResponse(List<TeamMemberInfo> r100, Long r101, Boolean r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.team_member_infos = Internal.immutableCopyOf("team_member_infos", r100);
        this.next_offset = r101;
        this.has_more = r102;
        this.forbidden_by_security = r103;
    }
}
