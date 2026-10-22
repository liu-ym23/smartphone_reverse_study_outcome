package com.bytedance.lark.pb.security.v1;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
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
public final class CustomDisplayModelResponse extends Message<CustomDisplayModelResponse, Builder> {
    public static final ProtoAdapter<CustomDisplayModelResponse> ADAPTER = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_CustomDisplayModelResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final CustomDisplayConfig config;
    public final Long update_time;

    public static final class Builder extends Message.Builder<CustomDisplayModelResponse, Builder> implements d<CustomDisplayModelResponse> {
        public CustomDisplayConfig config;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public CustomDisplayModelResponse build() {
            CustomDisplayConfig r100 = this.config;
            if (r100 == null) goto L9;
            if (this.update_time == null) goto L9;
            return new CustomDisplayModelResponse(this.config, this.update_time, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "config", this.update_time, "update_time"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder config(CustomDisplayConfig r100) {
            this.config = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomDisplayModelResponse extends ProtoAdapter<CustomDisplayModelResponse> implements c<CustomDisplayModelResponse> {
        public ProtoAdapter_CustomDisplayModelResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomDisplayModelResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomDisplayModelResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.update_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.config = CustomDisplayConfig.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.update_time = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(CustomDisplayModelResponse r100) {
            return (CustomDisplayConfig.ADAPTER.encodedSizeWithTag(1, r100.config) + ProtoAdapter.INT64.encodedSizeWithTag(2, r100.update_time)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomDisplayModelResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomDisplayModelResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomDisplayModelResponse r101) throws IOException {
            CustomDisplayConfig.ADAPTER.encodeWithTag(r100, 1, r101.config);
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r101.update_time);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomDisplayModelResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CustomDisplayModelResponse r100 = new ProtoAdapter_CustomDisplayModelResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
        DEFAULT_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.config = this.config;
        r100.update_time = this.update_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomDisplayModelResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomDisplayModelResponse(CustomDisplayConfig r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CustomDisplayModelResponse(CustomDisplayConfig r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.config = r100;
        this.update_time = r101;
    }
}
