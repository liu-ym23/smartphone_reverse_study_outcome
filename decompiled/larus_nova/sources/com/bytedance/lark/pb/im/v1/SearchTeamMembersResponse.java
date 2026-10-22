package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Chat;
import com.bytedance.lark.pb.basic.v1.SearchTeamMemberInfo;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SearchTeamMembersResponse extends Message<SearchTeamMembersResponse, Builder> {
    public static final ProtoAdapter<SearchTeamMembersResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final String DEFAULT_NEXT_OFFSET = "";
    public static final ProtoAdapter_SearchTeamMembersResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean has_more;
    public final Map<Long, Chat> joined_chats;
    public final String next_offset;
    public final List<SearchTeamMemberInfo> team_member_infos;

    public static final class Builder extends Message.Builder<SearchTeamMembersResponse, Builder> implements d<SearchTeamMembersResponse> {
        public Boolean has_more;
        public Map<Long, Chat> joined_chats;
        public String next_offset;
        public List<SearchTeamMemberInfo> team_member_infos;

        @Override // com.squareup.wire.Message.Builder
        public SearchTeamMembersResponse build() {
            return new SearchTeamMembersResponse(this.team_member_infos, this.joined_chats, this.next_offset, this.has_more, super.buildUnknownFields());
        }

        public Builder() {
            this.team_member_infos = Internal.newMutableList();
            this.joined_chats = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder joined_chats(Map<Long, Chat> r100) {
            Internal.checkElementsNotNull(r100);
            this.joined_chats = r100;
            return this;
        }

        public Builder next_offset(String r100) {
            this.next_offset = r100;
            return this;
        }

        public Builder team_member_infos(List<SearchTeamMemberInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.team_member_infos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchTeamMembersResponse extends ProtoAdapter<SearchTeamMembersResponse> implements c<SearchTeamMembersResponse> {
        private final ProtoAdapter<Map<Long, Chat>> joined_chats;

        public ProtoAdapter_SearchTeamMembersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchTeamMembersResponse.class);
            this.joined_chats = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, Chat.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchTeamMembersResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.next_offset = "";
            r101.has_more = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.team_member_infos.add(SearchTeamMemberInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.joined_chats.putAll(this.joined_chats.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.next_offset = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(SearchTeamMembersResponse r100) {
            int r101 = SearchTeamMemberInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.team_member_infos) + this.joined_chats.encodedSizeWithTag(2, r100.joined_chats);
            String r102 = r100.next_offset;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.has_more;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchTeamMembersResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchTeamMembersResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchTeamMembersResponse r101) throws IOException {
            SearchTeamMemberInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.team_member_infos);
            this.joined_chats.encodeWithTag(r100, 2, r101.joined_chats);
            String r102 = r101.next_offset;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r102);
        L5:
            Boolean r103 = r101.has_more;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchTeamMembersResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SearchTeamMembersResponse r100 = new ProtoAdapter_SearchTeamMembersResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.team_member_infos = Internal.copyOf("team_member_infos", this.team_member_infos);
        r100.joined_chats = Internal.copyOf("joined_chats", this.joined_chats);
        r100.next_offset = this.next_offset;
        r100.has_more = this.has_more;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchTeamMembersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchTeamMembersResponse(List<SearchTeamMemberInfo> r100, Map<Long, Chat> r101, String r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SearchTeamMembersResponse(List<SearchTeamMemberInfo> r100, Map<Long, Chat> r101, String r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.team_member_infos = Internal.immutableCopyOf("team_member_infos", r100);
        this.joined_chats = Internal.immutableCopyOf("joined_chats", r101);
        this.next_offset = r102;
        this.has_more = r103;
    }
}
