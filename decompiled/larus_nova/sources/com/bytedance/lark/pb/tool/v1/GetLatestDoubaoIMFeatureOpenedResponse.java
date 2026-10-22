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
public final class GetLatestDoubaoIMFeatureOpenedResponse extends Message<GetLatestDoubaoIMFeatureOpenedResponse, Builder> {
    public static final ProtoAdapter<GetLatestDoubaoIMFeatureOpenedResponse> ADAPTER = null;
    public static final Boolean DEFAULT_IM_FEATURE_OPENED = null;
    public static final Long DEFAULT_UPDATE_TIMESTAMP_MS = null;
    public static final ProtoAdapter_GetLatestDoubaoIMFeatureOpenedResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean im_feature_opened;
    public final Long update_timestamp_ms;

    public static final class Builder extends Message.Builder<GetLatestDoubaoIMFeatureOpenedResponse, Builder> implements d<GetLatestDoubaoIMFeatureOpenedResponse> {
        public Boolean im_feature_opened;
        public Long update_timestamp_ms;

        @Override // com.squareup.wire.Message.Builder
        public GetLatestDoubaoIMFeatureOpenedResponse build() {
            return new GetLatestDoubaoIMFeatureOpenedResponse(this.im_feature_opened, this.update_timestamp_ms, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder im_feature_opened(Boolean r100) {
            this.im_feature_opened = r100;
            return this;
        }

        public Builder update_timestamp_ms(Long r100) {
            this.update_timestamp_ms = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetLatestDoubaoIMFeatureOpenedResponse extends ProtoAdapter<GetLatestDoubaoIMFeatureOpenedResponse> implements c<GetLatestDoubaoIMFeatureOpenedResponse> {
        public ProtoAdapter_GetLatestDoubaoIMFeatureOpenedResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetLatestDoubaoIMFeatureOpenedResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetLatestDoubaoIMFeatureOpenedResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.im_feature_opened = Boolean.FALSE;
            r101.update_timestamp_ms = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.im_feature_opened = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.update_timestamp_ms = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(GetLatestDoubaoIMFeatureOpenedResponse r100) {
            Boolean r101 = r100.im_feature_opened;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.update_timestamp_ms;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetLatestDoubaoIMFeatureOpenedResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetLatestDoubaoIMFeatureOpenedResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetLatestDoubaoIMFeatureOpenedResponse r101) throws IOException {
            Boolean r102 = r101.im_feature_opened;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.update_timestamp_ms;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetLatestDoubaoIMFeatureOpenedResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetLatestDoubaoIMFeatureOpenedResponse r100 = new ProtoAdapter_GetLatestDoubaoIMFeatureOpenedResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IM_FEATURE_OPENED = Boolean.FALSE;
        DEFAULT_UPDATE_TIMESTAMP_MS = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.im_feature_opened = this.im_feature_opened;
        r100.update_timestamp_ms = this.update_timestamp_ms;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetLatestDoubaoIMFeatureOpenedResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetLatestDoubaoIMFeatureOpenedResponse(Boolean r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetLatestDoubaoIMFeatureOpenedResponse(Boolean r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.im_feature_opened = r100;
        this.update_timestamp_ms = r101;
    }
}
