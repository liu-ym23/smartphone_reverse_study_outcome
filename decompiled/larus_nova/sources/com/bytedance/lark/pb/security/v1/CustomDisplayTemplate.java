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

/* JADX INFO: loaded from: classes20.dex */
public final class CustomDisplayTemplate extends Message<CustomDisplayTemplate, Builder> {
    public static final ProtoAdapter<CustomDisplayTemplate> ADAPTER = null;
    public static final String DEFAULT_ICON = "";
    public static final String DEFAULT_LOCALE = "";
    public static final String DEFAULT_RICHTEXT = "";
    public static final String DEFAULT_SUB_RICH_TEXT = "";
    public static final String DEFAULT_SUB_TEXT = "";
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_TOAST_STYLE = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;
    public final List<CustomDisplayContent> content_list;
    public final List<CustomDisplayHandler> handler_list;
    public final String icon;
    public final String locale;
    public final String richText;
    public final String sub_rich_text;
    public final String sub_text;
    public final String text;
    public final String title;
    public final String toast_style;

    public static final class Builder extends Message.Builder<CustomDisplayTemplate, Builder> {
        public List<CustomDisplayContent> content_list;
        public List<CustomDisplayHandler> handler_list;
        public String icon;
        public String locale;
        public String richText;
        public String sub_rich_text;
        public String sub_text;
        public String text;
        public String title;
        public String toast_style;

        @Override // com.squareup.wire.Message.Builder
        public CustomDisplayTemplate build() {
            return new CustomDisplayTemplate(this.icon, this.title, this.text, this.content_list, this.handler_list, this.locale, this.richText, this.toast_style, this.sub_text, this.sub_rich_text, super.buildUnknownFields());
        }

        public Builder() {
            this.content_list = Internal.newMutableList();
            this.handler_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content_list(List<CustomDisplayContent> r100) {
            Internal.checkElementsNotNull(r100);
            this.content_list = r100;
            return this;
        }

        public Builder handler_list(List<CustomDisplayHandler> r100) {
            Internal.checkElementsNotNull(r100);
            this.handler_list = r100;
            return this;
        }

        public Builder icon(String r100) {
            this.icon = r100;
            return this;
        }

        public Builder locale(String r100) {
            this.locale = r100;
            return this;
        }

        public Builder richText(String r100) {
            this.richText = r100;
            return this;
        }

        public Builder sub_rich_text(String r100) {
            this.sub_rich_text = r100;
            return this;
        }

        public Builder sub_text(String r100) {
            this.sub_text = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
            return this;
        }

        public Builder title(String r100) {
            this.title = r100;
            return this;
        }

        public Builder toast_style(String r100) {
            this.toast_style = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CustomDisplayTemplate extends ProtoAdapter<CustomDisplayTemplate> {
        public ProtoAdapter_CustomDisplayTemplate() {
            super(FieldEncoding.LENGTH_DELIMITED, CustomDisplayTemplate.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CustomDisplayTemplate decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.icon = "";
            r101.title = "";
            r101.text = "";
            r101.locale = "";
            r101.richText = "";
            r101.toast_style = "";
            r101.sub_text = "";
            r101.sub_rich_text = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.sub_rich_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.sub_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.toast_style = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.richText = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.locale = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.handler_list.add(CustomDisplayHandler.ADAPTER.decode(r100));
            goto L3
        L13:
            r101.content_list.add(CustomDisplayContent.ADAPTER.decode(r100));
            goto L3
        L14:
            r101.text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            r101.title = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.icon = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CustomDisplayTemplate r100) {
            String r101 = r100.icon;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.title;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.text;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = ((r106 + r108) + CustomDisplayContent.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.content_list)) + CustomDisplayHandler.ADAPTER.asRepeated().encodedSizeWithTag(5, r100.handler_list);
            String r110 = r100.locale;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(6, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.richText;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(7, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.toast_style;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.STRING.encodedSizeWithTag(8, r116);
        L26:
            int r118 = r115 + r117;
            String r119 = r100.sub_text;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.STRING.encodedSizeWithTag(9, r119);
        L30:
            int r121 = r118 + r120;
            String r122 = r100.sub_rich_text;
            if (r122 == null) goto L34;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(10, r122);
        L34:
            return (r121 + r102) + r100.unknownFields().size();
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CustomDisplayTemplate decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CustomDisplayTemplate r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CustomDisplayTemplate r101) throws IOException {
            String r102 = r101.icon;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.title;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.text;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            CustomDisplayContent.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.content_list);
            CustomDisplayHandler.ADAPTER.asRepeated().encodeWithTag(r100, 5, r101.handler_list);
            String r105 = r101.locale;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r105);
        L14:
            String r106 = r101.richText;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 7, r106);
        L17:
            String r107 = r101.toast_style;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 8, r107);
        L20:
            String r108 = r101.sub_text;
            if (r108 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r100, 9, r108);
        L23:
            String r109 = r101.sub_rich_text;
            if (r109 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r100, 10, r109);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CustomDisplayTemplate r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CustomDisplayTemplate();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.icon = this.icon;
        r100.title = this.title;
        r100.text = this.text;
        r100.content_list = Internal.copyOf("content_list", this.content_list);
        r100.handler_list = Internal.copyOf("handler_list", this.handler_list);
        r100.locale = this.locale;
        r100.richText = this.richText;
        r100.toast_style = this.toast_style;
        r100.sub_text = this.sub_text;
        r100.sub_rich_text = this.sub_rich_text;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CustomDisplayTemplate.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CustomDisplayTemplate(String r110, String r111, String r112, List<CustomDisplayContent> r113, List<CustomDisplayHandler> r114, String r115, String r116, String r210, String r211, String r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public CustomDisplayTemplate(String r100, String r101, String r102, List<CustomDisplayContent> r103, List<CustomDisplayHandler> r104, String r105, String r106, String r107, String r110, String r111, ByteString r112) {
        super(ADAPTER, r112);
        this.icon = r100;
        this.title = r101;
        this.text = r102;
        this.content_list = Internal.immutableCopyOf("content_list", r103);
        this.handler_list = Internal.immutableCopyOf("handler_list", r104);
        this.locale = r105;
        this.richText = r106;
        this.toast_style = r107;
        this.sub_text = r110;
        this.sub_rich_text = r111;
    }
}
