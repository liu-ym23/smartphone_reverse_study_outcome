package com.bytedance.lark.pb.security.v1;

import annotation.OptionsExt;
import annotation.Serde;
import com.google.protobuf.FieldOptions;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CustomDisplayHandler extends Message<CustomDisplayHandler, Builder> {
    public static final ProtoAdapter<CustomDisplayHandler> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_STYLE = "";
    public static final String DEFAULT_TYPE = "";
    public static final FieldOptions FIELD_OPTIONS_PARAMS = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> link;
    public final String name;
    public final Map<String, String> params;
    public final String style;
    public final String type;

    public static final class Builder extends Message.Builder<CustomDisplayHandler, Builder> {
        public Map<String, String> link;
        public String name;
        public Map<String, String> params;
        public String style;
        public String type;

        @Override // com.squareup.wire.Message.Builder
        public CustomDisplayHandler build() {
            return new CustomDisplayHandler(this.name, this.type, this.style, this.link, this.params, super.buildUnknownFields());
        }

        public Builder() {
            this.link = Internal.newMutableMap();
            this.params = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder link(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.link = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder params(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.params = r100;
            return this;
        }

        public Builder style(String r100) {
            this.style = r100;
            return this;
        }

        public Builder type(String r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomDisplayHandler extends ProtoAdapter<CustomDisplayHandler> {
        private final ProtoAdapter<Map<String, String>> link;
        private final ProtoAdapter<Map<String, String>> params;

        public ProtoAdapter_CustomDisplayHandler() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomDisplayHandler.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.link = ProtoAdapter.newMapAdapter(r100, r100);
            this.params = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomDisplayHandler decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            r101.type = "";
            r101.style = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.style = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.link.putAll(this.link.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.params.putAll(this.params.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CustomDisplayHandler r100) {
            String r101 = r100.name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.type;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.style;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return (((r106 + r102) + this.link.encodedSizeWithTag(4, r100.link)) + this.params.encodedSizeWithTag(5, r100.params)) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomDisplayHandler decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomDisplayHandler r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomDisplayHandler r101) throws IOException {
            String r102 = r101.name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.type;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.style;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            this.link.encodeWithTag(r100, 4, r101.link);
            this.params.encodeWithTag(r100, 5, r101.params);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomDisplayHandler r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomDisplayHandler();
        MessageOptions.Builder r100 = new MessageOptions.Builder();
        OptionsExt.Builder r101 = new OptionsExt.Builder();
        Boolean r102 = Boolean.TRUE;
        MESSAGE_OPTIONS = r100.message_options(r101.serde(r102).build()).build();
        FIELD_OPTIONS_PARAMS = new FieldOptions.Builder().serde(new Serde.Builder().default_(r102).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.type = this.type;
        r100.style = this.style;
        r100.link = Internal.copyOf("link", this.link);
        r100.params = Internal.copyOf("params", this.params);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomDisplayHandler.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomDisplayHandler(String r100, String r101, String r110, Map<String, String> r111, Map<String, String> r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public CustomDisplayHandler(String r100, String r101, String r102, Map<String, String> r103, Map<String, String> r104, ByteString r105) {
        super(ADAPTER, r105);
        this.name = r100;
        this.type = r101;
        this.style = r102;
        this.link = Internal.immutableCopyOf("link", r103);
        this.params = Internal.immutableCopyOf("params", r104);
    }
}
