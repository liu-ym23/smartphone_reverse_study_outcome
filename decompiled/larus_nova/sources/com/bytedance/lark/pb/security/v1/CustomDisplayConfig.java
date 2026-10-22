package com.bytedance.lark.pb.security.v1;

import annotation.OptionsExt;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CustomDisplayConfig extends Message<CustomDisplayConfig, Builder> {
    public static final ProtoAdapter<CustomDisplayConfig> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253753id;
    public final CustomDisplayTemplate template;

    public static final class Builder extends Message.Builder<CustomDisplayConfig, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253754id;
        public CustomDisplayTemplate template;

        @Override // com.squareup.wire.Message.Builder
        public CustomDisplayConfig build() {
            String r100 = this.f253754id;
            if (r100 == null) goto L9;
            if (this.template == null) goto L9;
            return new CustomDisplayConfig(this.f253754id, this.template, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.template, ThumbGlideUrl.SOURCE_TEMPLATE});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253754id = r100;
            return this;
        }

        public Builder template(CustomDisplayTemplate r100) {
            this.template = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomDisplayConfig extends ProtoAdapter<CustomDisplayConfig> {
        public ProtoAdapter_CustomDisplayConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomDisplayConfig.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomDisplayConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253754id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.f253754id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.template = CustomDisplayTemplate.ADAPTER.decode(r100);
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
        public int encodedSize2(CustomDisplayConfig r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253753id) + CustomDisplayTemplate.ADAPTER.encodedSizeWithTag(2, r100.template)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomDisplayConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomDisplayConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomDisplayConfig r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253753id);
            CustomDisplayTemplate.ADAPTER.encodeWithTag(r100, 2, r101.template);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomDisplayConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomDisplayConfig();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253754id = this.f253753id;
        r100.template = this.template;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomDisplayConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomDisplayConfig(String r100, CustomDisplayTemplate r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CustomDisplayConfig(String r100, CustomDisplayTemplate r101, ByteString r102) {
        super(ADAPTER, r102);
        this.f253753id = r100;
        this.template = r101;
    }
}
