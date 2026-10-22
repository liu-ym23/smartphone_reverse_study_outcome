package com.bytedance.lark.pb.contact.v2;

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
public final class SearchContactsDoubaoResponse extends Message<SearchContactsDoubaoResponse, Builder> {
    public static final ProtoAdapter<SearchContactsDoubaoResponse> ADAPTER = null;
    public static final Long DEFAULT_ACTIVE_USER_ID = null;
    public static final ProtoAdapter_SearchContactsDoubaoResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long active_user_id;
    public final Map<String, ByteString> search_token;
    public final List<ContactProfile> user_profiles;

    public static final class Builder extends Message.Builder<SearchContactsDoubaoResponse, Builder> implements d<SearchContactsDoubaoResponse> {
        public Long active_user_id;
        public Map<String, ByteString> search_token;
        public List<ContactProfile> user_profiles;

        @Override // com.squareup.wire.Message.Builder
        public SearchContactsDoubaoResponse build() {
            return new SearchContactsDoubaoResponse(this.user_profiles, this.active_user_id, this.search_token, super.buildUnknownFields());
        }

        public Builder() {
            this.user_profiles = Internal.newMutableList();
            this.search_token = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder active_user_id(Long r100) {
            this.active_user_id = r100;
            return this;
        }

        public Builder search_token(Map<String, ByteString> r100) {
            Internal.checkElementsNotNull(r100);
            this.search_token = r100;
            return this;
        }

        public Builder user_profiles(List<ContactProfile> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_profiles = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchContactsDoubaoResponse extends ProtoAdapter<SearchContactsDoubaoResponse> implements c<SearchContactsDoubaoResponse> {
        private final ProtoAdapter<Map<String, ByteString>> search_token;

        public ProtoAdapter_SearchContactsDoubaoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchContactsDoubaoResponse.class);
            this.search_token = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BYTES);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchContactsDoubaoResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.active_user_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.user_profiles.add(ContactProfile.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.active_user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 100) goto L11;
            r101.search_token.putAll(this.search_token.decode(r100));
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
        public int encodedSize2(SearchContactsDoubaoResponse r100) {
            int r101 = ContactProfile.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.user_profiles);
            Long r102 = r100.active_user_id;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L7:
            return ((r101 + r103) + this.search_token.encodedSizeWithTag(100, r100.search_token)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchContactsDoubaoResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchContactsDoubaoResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchContactsDoubaoResponse r101) throws IOException {
            ContactProfile.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.user_profiles);
            Long r102 = r101.active_user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            this.search_token.encodeWithTag(r100, 100, r101.search_token);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchContactsDoubaoResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SearchContactsDoubaoResponse r100 = new ProtoAdapter_SearchContactsDoubaoResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ACTIVE_USER_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_profiles = Internal.copyOf("user_profiles", this.user_profiles);
        r100.active_user_id = this.active_user_id;
        r100.search_token = Internal.copyOf("search_token", this.search_token);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchContactsDoubaoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchContactsDoubaoResponse(List<ContactProfile> r100, Long r101, Map<String, ByteString> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SearchContactsDoubaoResponse(List<ContactProfile> r100, Long r101, Map<String, ByteString> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.user_profiles = Internal.immutableCopyOf("user_profiles", r100);
        this.active_user_id = r101;
        this.search_token = Internal.immutableCopyOf("search_token", r102);
    }
}
