package com.bytedance.lark.pb.media.v1;

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
public final class GetPreviewVideoSourceRequest extends Message<GetPreviewVideoSourceRequest, Builder> {
    public static final ProtoAdapter<GetPreviewVideoSourceRequest> ADAPTER = null;
    public static final Boolean DEFAULT_FORCE_UPDATE = null;
    public static final String DEFAULT_URL = "";
    public static final ProtoAdapter_GetPreviewVideoSourceRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean force_update;
    public final String url;

    public static final class Builder extends Message.Builder<GetPreviewVideoSourceRequest, Builder> implements d<GetPreviewVideoSourceRequest> {
        public Boolean force_update;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public GetPreviewVideoSourceRequest build() {
            String r100 = this.url;
            if (r100 == null) goto L7;
            return new GetPreviewVideoSourceRequest(this.url, this.force_update, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "url"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder force_update(Boolean r100) {
            this.force_update = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetPreviewVideoSourceRequest extends ProtoAdapter<GetPreviewVideoSourceRequest> implements c<GetPreviewVideoSourceRequest> {
        public ProtoAdapter_GetPreviewVideoSourceRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetPreviewVideoSourceRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetPreviewVideoSourceRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.url = "";
            r101.force_update = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.force_update = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(GetPreviewVideoSourceRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.url);
            Boolean r102 = r100.force_update;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetPreviewVideoSourceRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetPreviewVideoSourceRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetPreviewVideoSourceRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.url);
            Boolean r102 = r101.force_update;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetPreviewVideoSourceRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetPreviewVideoSourceRequest r100 = new ProtoAdapter_GetPreviewVideoSourceRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_FORCE_UPDATE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.url = this.url;
        r100.force_update = this.force_update;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetPreviewVideoSourceRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetPreviewVideoSourceRequest(String r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetPreviewVideoSourceRequest(String r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.url = r100;
        this.force_update = r101;
    }
}
