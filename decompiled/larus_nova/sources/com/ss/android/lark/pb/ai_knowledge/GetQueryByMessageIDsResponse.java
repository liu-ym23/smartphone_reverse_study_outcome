package com.ss.android.lark.pb.ai_knowledge;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class GetQueryByMessageIDsResponse extends Message<GetQueryByMessageIDsResponse, Builder> {
    public static final ProtoAdapter<GetQueryByMessageIDsResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IS_ALLOW_ALL_FORWARD = null;
    private static final long serialVersionUID = 0;
    public final Boolean mis_allow_all_forward;
    public final QueryContent mquery;

    public static final class Builder extends Message.Builder<GetQueryByMessageIDsResponse, Builder> {
        public Boolean mis_allow_all_forward;
        public QueryContent mquery;

        @Override // com.squareup.wire.Message.Builder
        public GetQueryByMessageIDsResponse build() {
            return new GetQueryByMessageIDsResponse(this.mquery, this.mis_allow_all_forward, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_allow_all_forward(Boolean r100) {
            this.mis_allow_all_forward = r100;
            return this;
        }

        public Builder query(QueryContent r100) {
            this.mquery = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetQueryByMessageIDsResponse extends ProtoAdapter<GetQueryByMessageIDsResponse> {
        public ProtoAdapter_GetQueryByMessageIDsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetQueryByMessageIDsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetQueryByMessageIDsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mis_allow_all_forward = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mquery = QueryContent.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mis_allow_all_forward = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(GetQueryByMessageIDsResponse r100) {
            QueryContent r101 = r100.mquery;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = QueryContent.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mis_allow_all_forward;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetQueryByMessageIDsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetQueryByMessageIDsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetQueryByMessageIDsResponse r101) throws IOException {
            QueryContent r102 = r101.mquery;
            if (r102 == null) goto L5;
            QueryContent.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mis_allow_all_forward;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetQueryByMessageIDsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetQueryByMessageIDsResponse();
        DEFAULT_IS_ALLOW_ALL_FORWARD = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mquery = this.mquery;
        r100.mis_allow_all_forward = this.mis_allow_all_forward;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetQueryByMessageIDsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetQueryByMessageIDsResponse(QueryContent r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetQueryByMessageIDsResponse(QueryContent r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mquery = r100;
        this.mis_allow_all_forward = r101;
    }
}
