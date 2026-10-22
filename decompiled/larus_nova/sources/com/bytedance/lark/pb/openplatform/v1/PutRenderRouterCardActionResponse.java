package com.bytedance.lark.pb.openplatform.v1;

import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
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
public final class PutRenderRouterCardActionResponse extends Message<PutRenderRouterCardActionResponse, Builder> {
    public static final ProtoAdapter<PutRenderRouterCardActionResponse> ADAPTER = null;
    public static final ProtoAdapter_PutRenderRouterCardActionResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final PutUniversalCardActionResponseInner inner;

    public static final class Builder extends Message.Builder<PutRenderRouterCardActionResponse, Builder> implements d<PutRenderRouterCardActionResponse> {
        public PutUniversalCardActionResponseInner inner;

        @Override // com.squareup.wire.Message.Builder
        public PutRenderRouterCardActionResponse build() {
            PutUniversalCardActionResponseInner r100 = this.inner;
            if (r100 == null) goto L7;
            return new PutRenderRouterCardActionResponse(this.inner, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, RNParamRegisterEventHandler.SRC_INNER});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder inner(PutUniversalCardActionResponseInner r100) {
            this.inner = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutRenderRouterCardActionResponse extends ProtoAdapter<PutRenderRouterCardActionResponse> implements c<PutRenderRouterCardActionResponse> {
        public ProtoAdapter_PutRenderRouterCardActionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutRenderRouterCardActionResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutRenderRouterCardActionResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.inner = PutUniversalCardActionResponseInner.ADAPTER.decode(r100);
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
        public int encodedSize2(PutRenderRouterCardActionResponse r100) {
            return PutUniversalCardActionResponseInner.ADAPTER.encodedSizeWithTag(1, r100.inner) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutRenderRouterCardActionResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutRenderRouterCardActionResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutRenderRouterCardActionResponse r101) throws IOException {
            PutUniversalCardActionResponseInner.ADAPTER.encodeWithTag(r100, 1, r101.inner);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutRenderRouterCardActionResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PutRenderRouterCardActionResponse r100 = new ProtoAdapter_PutRenderRouterCardActionResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.inner = this.inner;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutRenderRouterCardActionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutRenderRouterCardActionResponse(PutUniversalCardActionResponseInner r100) {
        this(r100, ByteString.EMPTY);
    }

    public PutRenderRouterCardActionResponse(PutUniversalCardActionResponseInner r100, ByteString r101) {
        super(ADAPTER, r101);
        this.inner = r100;
    }
}
