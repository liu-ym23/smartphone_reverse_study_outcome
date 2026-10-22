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
public final class PutRenderRouterCardActionRequest extends Message<PutRenderRouterCardActionRequest, Builder> {
    public static final ProtoAdapter<PutRenderRouterCardActionRequest> ADAPTER = null;
    public static final ProtoAdapter_PutRenderRouterCardActionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final PutUniversalCardActionRequestInner inner;

    public static final class Builder extends Message.Builder<PutRenderRouterCardActionRequest, Builder> implements d<PutRenderRouterCardActionRequest> {
        public PutUniversalCardActionRequestInner inner;

        @Override // com.squareup.wire.Message.Builder
        public PutRenderRouterCardActionRequest build() {
            PutUniversalCardActionRequestInner r100 = this.inner;
            if (r100 == null) goto L7;
            return new PutRenderRouterCardActionRequest(this.inner, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, RNParamRegisterEventHandler.SRC_INNER});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder inner(PutUniversalCardActionRequestInner r100) {
            this.inner = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutRenderRouterCardActionRequest extends ProtoAdapter<PutRenderRouterCardActionRequest> implements c<PutRenderRouterCardActionRequest> {
        public ProtoAdapter_PutRenderRouterCardActionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutRenderRouterCardActionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutRenderRouterCardActionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.inner = PutUniversalCardActionRequestInner.ADAPTER.decode(r100);
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
        public int encodedSize2(PutRenderRouterCardActionRequest r100) {
            return PutUniversalCardActionRequestInner.ADAPTER.encodedSizeWithTag(1, r100.inner) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutRenderRouterCardActionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutRenderRouterCardActionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutRenderRouterCardActionRequest r101) throws IOException {
            PutUniversalCardActionRequestInner.ADAPTER.encodeWithTag(r100, 1, r101.inner);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutRenderRouterCardActionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PutRenderRouterCardActionRequest r100 = new ProtoAdapter_PutRenderRouterCardActionRequest();
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
        return PutRenderRouterCardActionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutRenderRouterCardActionRequest(PutUniversalCardActionRequestInner r100) {
        this(r100, ByteString.EMPTY);
    }

    public PutRenderRouterCardActionRequest(PutUniversalCardActionRequestInner r100, ByteString r101) {
        super(ADAPTER, r101);
        this.inner = r100;
    }
}
