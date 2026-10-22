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
public final class CustomDisplayMGetRequest extends Message<CustomDisplayMGetRequest, Builder> {
    public static final ProtoAdapter<CustomDisplayMGetRequest> ADAPTER = null;
    public static final String DEFAULT_LOCALE = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_CustomDisplayMGetRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> id_list;
    public final String locale;

    public static final class Builder extends Message.Builder<CustomDisplayMGetRequest, Builder> implements d<CustomDisplayMGetRequest> {
        public List<String> id_list;
        public String locale;

        @Override // com.squareup.wire.Message.Builder
        public CustomDisplayMGetRequest build() {
            String r100 = this.locale;
            if (r100 == null) goto L7;
            return new CustomDisplayMGetRequest(this.id_list, this.locale, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "locale"});
        }

        public Builder() {
            this.id_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id_list(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.id_list = r100;
            return this;
        }

        public Builder locale(String r100) {
            this.locale = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomDisplayMGetRequest extends ProtoAdapter<CustomDisplayMGetRequest> implements c<CustomDisplayMGetRequest> {
        public ProtoAdapter_CustomDisplayMGetRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomDisplayMGetRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomDisplayMGetRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.locale = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.id_list.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.locale = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CustomDisplayMGetRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.asRepeated().encodedSizeWithTag(1, r100.id_list) + r101.encodedSizeWithTag(2, r100.locale)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomDisplayMGetRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomDisplayMGetRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomDisplayMGetRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.id_list);
            r102.encodeWithTag(r100, 2, r101.locale);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomDisplayMGetRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CustomDisplayMGetRequest r100 = new ProtoAdapter_CustomDisplayMGetRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.id_list = Internal.copyOf("id_list", this.id_list);
        r100.locale = this.locale;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomDisplayMGetRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomDisplayMGetRequest(List<String> r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CustomDisplayMGetRequest(List<String> r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.id_list = Internal.immutableCopyOf("id_list", r100);
        this.locale = r101;
    }
}
