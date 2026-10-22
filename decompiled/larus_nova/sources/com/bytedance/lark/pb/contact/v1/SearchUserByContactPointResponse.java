package com.bytedance.lark.pb.contact.v1;

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
public final class SearchUserByContactPointResponse extends Message<SearchUserByContactPointResponse, Builder> {
    public static final ProtoAdapter<SearchUserByContactPointResponse> ADAPTER = null;
    public static final String DEFAULT_ACTIVE_USER_ID = "";
    public static final ProtoAdapter_SearchUserByContactPointResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String active_user_id;
    public final List<GetUserProfileResponse> profiles;
    public final List<UserBriefInfo> users;

    public static final class Builder extends Message.Builder<SearchUserByContactPointResponse, Builder> implements d<SearchUserByContactPointResponse> {
        public String active_user_id;
        public List<GetUserProfileResponse> profiles;
        public List<UserBriefInfo> users;

        @Override // com.squareup.wire.Message.Builder
        public SearchUserByContactPointResponse build() {
            return new SearchUserByContactPointResponse(this.users, this.profiles, this.active_user_id, super.buildUnknownFields());
        }

        public Builder() {
            this.users = Internal.newMutableList();
            this.profiles = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder active_user_id(String r100) {
            this.active_user_id = r100;
            return this;
        }

        public Builder profiles(List<GetUserProfileResponse> r100) {
            Internal.checkElementsNotNull(r100);
            this.profiles = r100;
            return this;
        }

        public Builder users(List<UserBriefInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.users = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchUserByContactPointResponse extends ProtoAdapter<SearchUserByContactPointResponse> implements c<SearchUserByContactPointResponse> {
        public ProtoAdapter_SearchUserByContactPointResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchUserByContactPointResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchUserByContactPointResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.active_user_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.users.add(UserBriefInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.profiles.add(GetUserProfileResponse.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.active_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchUserByContactPointResponse r100) {
            int r101 = UserBriefInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.users) + GetUserProfileResponse.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.profiles);
            String r102 = r100.active_user_id;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchUserByContactPointResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchUserByContactPointResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchUserByContactPointResponse r101) throws IOException {
            UserBriefInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.users);
            GetUserProfileResponse.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.profiles);
            String r102 = r101.active_user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchUserByContactPointResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SearchUserByContactPointResponse r100 = new ProtoAdapter_SearchUserByContactPointResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.users = Internal.copyOf("users", this.users);
        r100.profiles = Internal.copyOf("profiles", this.profiles);
        r100.active_user_id = this.active_user_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchUserByContactPointResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchUserByContactPointResponse(List<UserBriefInfo> r100, List<GetUserProfileResponse> r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SearchUserByContactPointResponse(List<UserBriefInfo> r100, List<GetUserProfileResponse> r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.users = Internal.immutableCopyOf("users", r100);
        this.profiles = Internal.immutableCopyOf("profiles", r101);
        this.active_user_id = r102;
    }
}
