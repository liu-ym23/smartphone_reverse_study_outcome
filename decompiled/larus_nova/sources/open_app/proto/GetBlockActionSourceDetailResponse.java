package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class GetBlockActionSourceDetailResponse extends Message<GetBlockActionSourceDetailResponse, Builder> {
    public static final ProtoAdapter<GetBlockActionSourceDetailResponse> ADAPTER = null;
    public static final String DEFAULT_BIZ_TYPE = "";
    private static final long serialVersionUID = 0;
    public final String biz_type;
    public final GetBlockActionSourceDetailContent content;

    public static final class Builder extends Message.Builder<GetBlockActionSourceDetailResponse, Builder> {
        public String biz_type;
        public GetBlockActionSourceDetailContent content;

        @Override // com.squareup.wire.Message.Builder
        public GetBlockActionSourceDetailResponse build() {
            String r100 = this.biz_type;
            if (r100 == null) goto L9;
            if (this.content == null) goto L9;
            return new GetBlockActionSourceDetailResponse(this.biz_type, this.content, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "biz_type", this.content, "content"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder biz_type(String r100) {
            this.biz_type = r100;
            return this;
        }

        public Builder content(GetBlockActionSourceDetailContent r100) {
            this.content = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetBlockActionSourceDetailResponse extends ProtoAdapter<GetBlockActionSourceDetailResponse> {
        public ProtoAdapter_GetBlockActionSourceDetailResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetBlockActionSourceDetailResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public GetBlockActionSourceDetailResponse decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.biz_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.content = GetBlockActionSourceDetailContent.ADAPTER.decode(r100);
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
        public int encodedSize2(GetBlockActionSourceDetailResponse r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.biz_type) + GetBlockActionSourceDetailContent.ADAPTER.encodedSizeWithTag(2, r100.content)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetBlockActionSourceDetailResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetBlockActionSourceDetailResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetBlockActionSourceDetailResponse r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.biz_type);
            GetBlockActionSourceDetailContent.ADAPTER.encodeWithTag(r100, 2, r101.content);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetBlockActionSourceDetailResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetBlockActionSourceDetailResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.biz_type = this.biz_type;
        r100.content = this.content;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetBlockActionSourceDetailResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetBlockActionSourceDetailResponse(String r100, GetBlockActionSourceDetailContent r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetBlockActionSourceDetailResponse(String r100, GetBlockActionSourceDetailContent r101, ByteString r102) {
        super(ADAPTER, r102);
        this.biz_type = r100;
        this.content = r101;
    }
}
