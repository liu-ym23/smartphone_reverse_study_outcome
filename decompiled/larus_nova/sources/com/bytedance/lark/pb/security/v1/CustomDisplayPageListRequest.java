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
public final class CustomDisplayPageListRequest extends Message<CustomDisplayPageListRequest, Builder> {
    public static final ProtoAdapter<CustomDisplayPageListRequest> ADAPTER = null;
    public static final Long DEFAULT_COUNT = null;
    public static final String DEFAULT_LOCALE = "";
    public static final Long DEFAULT_OFFSET = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_CustomDisplayPageListRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long count;
    public final String locale;
    public final Long offset;

    public static final class Builder extends Message.Builder<CustomDisplayPageListRequest, Builder> implements d<CustomDisplayPageListRequest> {
        public Long count;
        public String locale;
        public Long offset;

        @Override // com.squareup.wire.Message.Builder
        public CustomDisplayPageListRequest build() {
            Long r100 = this.offset;
            if (r100 == null) goto L11;
            if (this.count == null) goto L11;
            if (this.locale == null) goto L11;
            return new CustomDisplayPageListRequest(this.offset, this.count, this.locale, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "offset", this.count, "count", this.locale, "locale"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder count(Long r100) {
            this.count = r100;
            return this;
        }

        public Builder locale(String r100) {
            this.locale = r100;
            return this;
        }

        public Builder offset(Long r100) {
            this.offset = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomDisplayPageListRequest extends ProtoAdapter<CustomDisplayPageListRequest> implements c<CustomDisplayPageListRequest> {
        public ProtoAdapter_CustomDisplayPageListRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomDisplayPageListRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomDisplayPageListRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.offset = 0L;
            r101.count = 0L;
            r101.locale = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.offset = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.count = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.locale = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CustomDisplayPageListRequest r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            return ((r101.encodedSizeWithTag(1, r100.offset) + r101.encodedSizeWithTag(2, r100.count)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r100.locale)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomDisplayPageListRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomDisplayPageListRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomDisplayPageListRequest r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.offset);
            r102.encodeWithTag(r100, 2, r101.count);
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r101.locale);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomDisplayPageListRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CustomDisplayPageListRequest r100 = new ProtoAdapter_CustomDisplayPageListRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
        DEFAULT_OFFSET = 0L;
        DEFAULT_COUNT = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.offset = this.offset;
        r100.count = this.count;
        r100.locale = this.locale;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomDisplayPageListRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomDisplayPageListRequest(Long r100, Long r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public CustomDisplayPageListRequest(Long r100, Long r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.offset = r100;
        this.count = r101;
        this.locale = r102;
    }
}
