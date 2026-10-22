package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ButtonElement extends Message<ButtonElement, Builder> {
    public static final ProtoAdapter<ButtonElement> ADAPTER = null;
    public static final String DEFAULT_BACKGROUND_COLOR = "";
    public static final String DEFAULT_CALLBACK_EVENT_NAME = "";
    public static final String DEFAULT_LINK = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TEXT_COLOR = "";
    private static final long serialVersionUID = 0;
    public final String mbackground_color;
    public final String mcallback_event_name;
    public final String mlink;
    public final String mname;
    public final String mtext;
    public final String mtext_color;

    public static final class Builder extends Message.Builder<ButtonElement, Builder> {
        public String mbackground_color;
        public String mcallback_event_name;
        public String mlink;
        public String mname;
        public String mtext;
        public String mtext_color;

        @Override // com.squareup.wire.Message.Builder
        public ButtonElement build() {
            return new ButtonElement(this.mname, this.mtext, this.mbackground_color, this.mtext_color, this.mcallback_event_name, this.mlink, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder background_color(String r100) {
            this.mbackground_color = r100;
            return this;
        }

        public Builder callback_event_name(String r100) {
            this.mcallback_event_name = r100;
            return this;
        }

        public Builder link(String r100) {
            this.mlink = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder text(String r100) {
            this.mtext = r100;
            return this;
        }

        public Builder text_color(String r100) {
            this.mtext_color = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ButtonElement extends ProtoAdapter<ButtonElement> {
        public ProtoAdapter_ButtonElement() {
            super(FieldEncoding.LENGTH_DELIMITED, ButtonElement.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ButtonElement decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mname = "";
            r101.mtext = "";
            r101.mbackground_color = "";
            r101.mtext_color = "";
            r101.mcallback_event_name = "";
            r101.mlink = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.mlink = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mcallback_event_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.mtext_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.mbackground_color = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.mtext = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ButtonElement r100) {
            String r101 = r100.mname;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mtext;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mbackground_color;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.mtext_color;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.mcallback_event_name;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            String r116 = r100.mlink;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ButtonElement decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ButtonElement r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ButtonElement r101) throws IOException {
            String r102 = r101.mname;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mtext;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mbackground_color;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.mtext_color;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.mcallback_event_name;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            String r107 = r101.mlink;
            if (r107 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ButtonElement r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ButtonElement();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mname = this.mname;
        r100.mtext = this.mtext;
        r100.mbackground_color = this.mbackground_color;
        r100.mtext_color = this.mtext_color;
        r100.mcallback_event_name = this.mcallback_event_name;
        r100.mlink = this.mlink;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ButtonElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ButtonElement(String r100, String r110, String r111, String r112, String r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public ButtonElement(String r100, String r101, String r102, String r103, String r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.mname = r100;
        this.mtext = r101;
        this.mbackground_color = r102;
        this.mtext_color = r103;
        this.mcallback_event_name = r104;
        this.mlink = r105;
    }
}
