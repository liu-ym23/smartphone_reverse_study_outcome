package com.bytedance.lark.pb.contact.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SearchUserByContactPointRequest extends Message<SearchUserByContactPointRequest, Builder> {
    public static final ProtoAdapter<SearchUserByContactPointRequest> ADAPTER = null;
    public static final String DEFAULT_CONTACT_CONTENT = "";
    public static final ProtoAdapter_SearchUserByContactPointRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String contact_content;

    public static final class Builder extends Message.Builder<SearchUserByContactPointRequest, Builder> implements d<SearchUserByContactPointRequest> {
        public String contact_content;

        @Override // com.squareup.wire.Message.Builder
        public SearchUserByContactPointRequest build() {
            String r100 = this.contact_content;
            if (r100 == null) goto L7;
            return new SearchUserByContactPointRequest(this.contact_content, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "contact_content"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder contact_content(String r100) {
            this.contact_content = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchUserByContactPointRequest extends ProtoAdapter<SearchUserByContactPointRequest> implements c<SearchUserByContactPointRequest> {
        public ProtoAdapter_SearchUserByContactPointRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchUserByContactPointRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchUserByContactPointRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.contact_content = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.contact_content = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SearchUserByContactPointRequest r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.contact_content) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchUserByContactPointRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchUserByContactPointRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchUserByContactPointRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.contact_content);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchUserByContactPointRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SearchUserByContactPointRequest r100 = new ProtoAdapter_SearchUserByContactPointRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.contact_content = this.contact_content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchUserByContactPointRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchUserByContactPointRequest(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public SearchUserByContactPointRequest(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.contact_content = r100;
    }
}
