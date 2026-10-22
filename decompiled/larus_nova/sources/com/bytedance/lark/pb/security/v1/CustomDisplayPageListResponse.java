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
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CustomDisplayPageListResponse extends Message<CustomDisplayPageListResponse, Builder> {
    public static final ProtoAdapter<CustomDisplayPageListResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_CustomDisplayPageListResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<CustomDisplayConfig> config_list;
    public final Boolean has_more;

    public static final class Builder extends Message.Builder<CustomDisplayPageListResponse, Builder> implements d<CustomDisplayPageListResponse> {
        public List<CustomDisplayConfig> config_list;
        public Boolean has_more;

        @Override // com.squareup.wire.Message.Builder
        public CustomDisplayPageListResponse build() {
            Boolean r100 = this.has_more;
            if (r100 == null) goto L7;
            return new CustomDisplayPageListResponse(this.has_more, this.config_list, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "has_more"});
        }

        public Builder() {
            this.config_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder config_list(List<CustomDisplayConfig> r100) {
            Internal.checkElementsNotNull(r100);
            this.config_list = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomDisplayPageListResponse extends ProtoAdapter<CustomDisplayPageListResponse> implements c<CustomDisplayPageListResponse> {
        public ProtoAdapter_CustomDisplayPageListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomDisplayPageListResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomDisplayPageListResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.has_more = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.config_list.add(CustomDisplayConfig.ADAPTER.decode(r100));
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
        public int encodedSize2(CustomDisplayPageListResponse r100) {
            return (ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.has_more) + CustomDisplayConfig.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.config_list)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomDisplayPageListResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomDisplayPageListResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomDisplayPageListResponse r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.has_more);
            CustomDisplayConfig.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.config_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomDisplayPageListResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CustomDisplayPageListResponse r100 = new ProtoAdapter_CustomDisplayPageListResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.has_more = this.has_more;
        r100.config_list = Internal.copyOf("config_list", this.config_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomDisplayPageListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomDisplayPageListResponse(Boolean r100, List<CustomDisplayConfig> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CustomDisplayPageListResponse(Boolean r100, List<CustomDisplayConfig> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.has_more = r100;
        this.config_list = Internal.immutableCopyOf("config_list", r101);
    }
}
