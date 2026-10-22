package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetLatestDoubaoIMFeatureOpenedRequest extends Message<GetLatestDoubaoIMFeatureOpenedRequest, Builder> {
    public static final ProtoAdapter<GetLatestDoubaoIMFeatureOpenedRequest> ADAPTER = null;
    public static final ProtoAdapter_GetLatestDoubaoIMFeatureOpenedRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<GetLatestDoubaoIMFeatureOpenedRequest, Builder> implements d<GetLatestDoubaoIMFeatureOpenedRequest> {
        @Override // com.squareup.wire.Message.Builder
        public GetLatestDoubaoIMFeatureOpenedRequest build() {
            return new GetLatestDoubaoIMFeatureOpenedRequest(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class ProtoAdapter_GetLatestDoubaoIMFeatureOpenedRequest extends ProtoAdapter<GetLatestDoubaoIMFeatureOpenedRequest> implements c<GetLatestDoubaoIMFeatureOpenedRequest> {
        public ProtoAdapter_GetLatestDoubaoIMFeatureOpenedRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetLatestDoubaoIMFeatureOpenedRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetLatestDoubaoIMFeatureOpenedRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L6;
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L6:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetLatestDoubaoIMFeatureOpenedRequest r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetLatestDoubaoIMFeatureOpenedRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetLatestDoubaoIMFeatureOpenedRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetLatestDoubaoIMFeatureOpenedRequest r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetLatestDoubaoIMFeatureOpenedRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetLatestDoubaoIMFeatureOpenedRequest r100 = new ProtoAdapter_GetLatestDoubaoIMFeatureOpenedRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    public GetLatestDoubaoIMFeatureOpenedRequest() {
        this(ByteString.EMPTY);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetLatestDoubaoIMFeatureOpenedRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetLatestDoubaoIMFeatureOpenedRequest(ByteString r100) {
        super(ADAPTER, r100);
    }
}
