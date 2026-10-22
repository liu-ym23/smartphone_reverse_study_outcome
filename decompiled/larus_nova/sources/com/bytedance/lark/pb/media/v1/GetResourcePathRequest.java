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
public final class GetResourcePathRequest extends Message<GetResourcePathRequest, Builder> {
    public static final ProtoAdapter<GetResourcePathRequest> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final ProtoAdapter_GetResourcePathRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String key;
    public final RemoteResource resource;

    public static final class Builder extends Message.Builder<GetResourcePathRequest, Builder> implements d<GetResourcePathRequest> {
        public String key;
        public RemoteResource resource;

        @Override // com.squareup.wire.Message.Builder
        public GetResourcePathRequest build() {
            String r100 = this.key;
            if (r100 == null) goto L9;
            if (this.resource == null) goto L9;
            return new GetResourcePathRequest(this.key, this.resource, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "key", this.resource, "resource"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder resource(RemoteResource r100) {
            this.resource = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetResourcePathRequest extends ProtoAdapter<GetResourcePathRequest> implements c<GetResourcePathRequest> {
        public ProtoAdapter_GetResourcePathRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetResourcePathRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetResourcePathRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.resource = RemoteResource.ADAPTER.decode(r100);
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
        public int encodedSize2(GetResourcePathRequest r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.key) + RemoteResource.ADAPTER.encodedSizeWithTag(2, r100.resource)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetResourcePathRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetResourcePathRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetResourcePathRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.key);
            RemoteResource.ADAPTER.encodeWithTag(r100, 2, r101.resource);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetResourcePathRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetResourcePathRequest r100 = new ProtoAdapter_GetResourcePathRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.resource = this.resource;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetResourcePathRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetResourcePathRequest(String r100, RemoteResource r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetResourcePathRequest(String r100, RemoteResource r101, ByteString r102) {
        super(ADAPTER, r102);
        this.key = r100;
        this.resource = r101;
    }
}
