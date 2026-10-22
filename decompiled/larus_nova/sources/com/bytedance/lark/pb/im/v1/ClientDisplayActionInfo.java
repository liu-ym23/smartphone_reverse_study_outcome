package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ClientDisplayActionInfo extends Message<ClientDisplayActionInfo, Builder> {
    public static final ProtoAdapter<ClientDisplayActionInfo> ADAPTER = null;
    public static final String DEFAULT_ACTION_BUTTON_TEXT = "";
    public static final String DEFAULT_ACTION_URL = "";
    public static final String DEFAULT_CANCEL_BUTTON_TEXT = "";
    public static final String DEFAULT_CONTENT = "";
    public static final DisplayType DEFAULT_DISPLAY_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String action_button_text;
    public final String action_url;
    public final String cancel_button_text;
    public final String content;
    public final DisplayType display_type;

    public static final class Builder extends Message.Builder<ClientDisplayActionInfo, Builder> {
        public String action_button_text;
        public String action_url;
        public String cancel_button_text;
        public String content;
        public DisplayType display_type;

        @Override // com.squareup.wire.Message.Builder
        public ClientDisplayActionInfo build() {
            return new ClientDisplayActionInfo(this.display_type, this.content, this.action_url, this.action_button_text, this.cancel_button_text, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_button_text(String r100) {
            this.action_button_text = r100;
            return this;
        }

        public Builder action_url(String r100) {
            this.action_url = r100;
            return this;
        }

        public Builder cancel_button_text(String r100) {
            this.cancel_button_text = r100;
            return this;
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder display_type(DisplayType r100) {
            this.display_type = r100;
            return this;
        }
    }

    public static final enum DisplayType extends Enum<DisplayType> implements WireEnum {
        private static final /* synthetic */ DisplayType[] $VALUES = null;
        public static final ProtoAdapter<DisplayType> ADAPTER = null;
        public static final DisplayType POPUP = null;
        public static final DisplayType TOAST = null;
        private final int value;

        static {
            DisplayType r100 = new DisplayType("POPUP", 0, 1);
            POPUP = r100;
            DisplayType r101 = new DisplayType("TOAST", 1, 2);
            TOAST = r101;
            $VALUES = new DisplayType[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(DisplayType.class);
        }

        public static DisplayType[] values() {
            return (DisplayType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DisplayType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return TOAST;
        L11:
            return POPUP;
        }

        public static DisplayType valueOf(String r100) {
            return (DisplayType) a.a(DisplayType.class, r100);
        }

        private DisplayType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ClientDisplayActionInfo extends ProtoAdapter<ClientDisplayActionInfo> {
        public ProtoAdapter_ClientDisplayActionInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ClientDisplayActionInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ClientDisplayActionInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.display_type = DisplayType.POPUP;
            r101.content = "";
            r101.action_url = "";
            r101.action_button_text = "";
            r101.cancel_button_text = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.display_type = DisplayType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.action_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.action_button_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.cancel_button_text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ClientDisplayActionInfo r100) {
            DisplayType r101 = r100.display_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = DisplayType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.content;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.action_url;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.action_button_text;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.cancel_button_text;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ClientDisplayActionInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ClientDisplayActionInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ClientDisplayActionInfo r101) throws IOException {
            DisplayType r102 = r101.display_type;
            if (r102 == null) goto L5;
            DisplayType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.content;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.action_url;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.action_button_text;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.cancel_button_text;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ClientDisplayActionInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ClientDisplayActionInfo();
        DEFAULT_DISPLAY_TYPE = DisplayType.POPUP;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.display_type = this.display_type;
        r100.content = this.content;
        r100.action_url = this.action_url;
        r100.action_button_text = this.action_button_text;
        r100.cancel_button_text = this.cancel_button_text;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ClientDisplayActionInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ClientDisplayActionInfo(DisplayType r100, String r101, String r110, String r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ClientDisplayActionInfo(DisplayType r100, String r101, String r102, String r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.display_type = r100;
        this.content = r101;
        this.action_url = r102;
        this.action_button_text = r103;
        this.cancel_button_text = r104;
    }
}
