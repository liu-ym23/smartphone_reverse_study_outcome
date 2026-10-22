package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class AppFeedCardButton extends com.squareup.wire.Message<AppFeedCardButton, Builder> {
    public static final ProtoAdapter<AppFeedCardButton> ADAPTER = null;
    public static final ActionType DEFAULT_ACTION_TYPE = null;
    public static final ButtonType DEFAULT_BUTTON_TYPE = null;
    public static final String DEFAULT_ID = "";
    private static final long serialVersionUID = 0;
    public final ActionType action_type;
    public final ButtonType button_type;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253439id;
    public final URL multi_url;
    public final Text text;

    public static final enum ActionType extends Enum<ActionType> implements WireEnum {
        private static final /* synthetic */ ActionType[] $VALUES = null;
        public static final ProtoAdapter<ActionType> ADAPTER = null;
        public static final ActionType UNKNOWN = null;
        public static final ActionType URL_PAGE = null;
        public static final ActionType WEBHOOK = null;
        private final int value;

        static {
            ActionType r100 = new ActionType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            ActionType r101 = new ActionType("URL_PAGE", 1, 1);
            URL_PAGE = r101;
            ActionType r102 = new ActionType("WEBHOOK", 2, 2);
            WEBHOOK = r102;
            $VALUES = new ActionType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ActionType.class);
        }

        public static ActionType[] values() {
            return (ActionType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ActionType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return WEBHOOK;
        L12:
            return URL_PAGE;
        L14:
            return UNKNOWN;
        }

        public static ActionType valueOf(String r100) {
            return (ActionType) a.a(ActionType.class, r100);
        }

        private ActionType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<AppFeedCardButton, Builder> {
        public ActionType action_type;
        public ButtonType button_type;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253440id;
        public URL multi_url;
        public Text text;

        @Override // com.squareup.wire.Message.Builder
        public AppFeedCardButton build() {
            return new AppFeedCardButton(this.f253440id, this.multi_url, this.action_type, this.text, this.button_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder action_type(ActionType r100) {
            this.action_type = r100;
            return this;
        }

        public Builder button_type(ButtonType r100) {
            this.button_type = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253440id = r100;
            return this;
        }

        public Builder multi_url(URL r100) {
            this.multi_url = r100;
            return this;
        }

        public Builder text(Text r100) {
            this.text = r100;
            return this;
        }
    }

    public static final enum ButtonType extends Enum<ButtonType> implements WireEnum {
        private static final /* synthetic */ ButtonType[] $VALUES = null;
        public static final ProtoAdapter<ButtonType> ADAPTER = null;
        public static final ButtonType DEFAULT = null;
        public static final ButtonType PRIMARY = null;
        public static final ButtonType SUCCESS = null;
        private final int value;

        static {
            ButtonType r100 = new ButtonType("DEFAULT", 0, 1);
            DEFAULT = r100;
            ButtonType r101 = new ButtonType("PRIMARY", 1, 2);
            PRIMARY = r101;
            ButtonType r102 = new ButtonType("SUCCESS", 2, 3);
            SUCCESS = r102;
            $VALUES = new ButtonType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(ButtonType.class);
        }

        public static ButtonType[] values() {
            return (ButtonType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static ButtonType fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return SUCCESS;
        L13:
            return PRIMARY;
        L15:
            return DEFAULT;
        }

        public static ButtonType valueOf(String r100) {
            return (ButtonType) a.a(ButtonType.class, r100);
        }

        private ButtonType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_AppFeedCardButton extends ProtoAdapter<AppFeedCardButton> {
        public ProtoAdapter_AppFeedCardButton() {
            super(FieldEncoding.LENGTH_DELIMITED, AppFeedCardButton.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AppFeedCardButton decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253440id = "";
            r101.action_type = ActionType.UNKNOWN;
            r101.button_type = ButtonType.DEFAULT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.f253440id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.multi_url = URL.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.action_type = ActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.text = Text.ADAPTER.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.button_type = ButtonType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(AppFeedCardButton r100) {
            String r101 = r100.f253439id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            URL r104 = r100.multi_url;
            if (r104 == null) goto L9;
            int r105 = URL.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ActionType r107 = r100.action_type;
            if (r107 == null) goto L13;
            int r108 = ActionType.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Text r110 = r100.text;
            if (r110 == null) goto L17;
            int r111 = Text.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ButtonType r113 = r100.button_type;
            if (r113 == null) goto L22;
            r102 = ButtonType.ADAPTER.encodedSizeWithTag(5, r113);
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
        public /* bridge */ /* synthetic */ AppFeedCardButton decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppFeedCardButton r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppFeedCardButton r101) throws IOException {
            String r102 = r101.f253439id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            URL r103 = r101.multi_url;
            if (r103 == null) goto L8;
            URL.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ActionType r104 = r101.action_type;
            if (r104 == null) goto L11;
            ActionType.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            Text r105 = r101.text;
            if (r105 == null) goto L14;
            Text.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            ButtonType r106 = r101.button_type;
            if (r106 == null) goto L17;
            ButtonType.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppFeedCardButton r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Text extends com.squareup.wire.Message<Text, Builder> {
        public static final ProtoAdapter<Text> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        private static final long serialVersionUID = 0;
        public final String content;

        public static final class Builder extends com.squareup.wire.Message.Builder<Text, Builder> {
            public String content;

            @Override // com.squareup.wire.Message.Builder
            public Text build() {
                String r100 = this.content;
                if (r100 == null) goto L7;
                return new Text(this.content, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "content"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Text extends ProtoAdapter<Text> {
            public ProtoAdapter_Text() {
                super(FieldEncoding.LENGTH_DELIMITED, Text.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Text decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.content = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.content = ProtoAdapter.STRING.decode(r100);
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Text r100) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.content) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Text decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Text r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Text r101) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.content);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Text r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Text();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.content = this.content;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Text.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public Text(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public Text(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.content = r100;
        }
    }

    public static final class URL extends com.squareup.wire.Message<URL, Builder> {
        public static final ProtoAdapter<URL> ADAPTER = null;
        public static final String DEFAULT_ANDROID_URL = "";
        public static final String DEFAULT_IOS_URL = "";
        public static final String DEFAULT_PC_URL = "";
        public static final String DEFAULT_URL = "";
        private static final long serialVersionUID = 0;
        public final String android_url;
        public final String ios_url;
        public final String pc_url;
        public final String url;

        public static final class Builder extends com.squareup.wire.Message.Builder<URL, Builder> {
            public String android_url;
            public String ios_url;
            public String pc_url;
            public String url;

            @Override // com.squareup.wire.Message.Builder
            public URL build() {
                String r100 = this.url;
                if (r100 == null) goto L7;
                return new URL(this.url, this.android_url, this.ios_url, this.pc_url, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "url"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder android_url(String r100) {
                this.android_url = r100;
                return this;
            }

            public Builder ios_url(String r100) {
                this.ios_url = r100;
                return this;
            }

            public Builder pc_url(String r100) {
                this.pc_url = r100;
                return this;
            }

            public Builder url(String r100) {
                this.url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_URL extends ProtoAdapter<URL> {
            public ProtoAdapter_URL() {
                super(FieldEncoding.LENGTH_DELIMITED, URL.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public URL decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.url = "";
                r101.android_url = "";
                r101.ios_url = "";
                r101.pc_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.android_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.ios_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.pc_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L13:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(URL r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.encodedSizeWithTag(1, r100.url);
                String r103 = r100.android_url;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(2, r103);
            L6:
                int r106 = r102 + r105;
                String r107 = r100.ios_url;
                if (r107 == null) goto L9;
                int r108 = r101.encodedSizeWithTag(3, r107);
            L10:
                int r109 = r106 + r108;
                String r110 = r100.pc_url;
                if (r110 == null) goto L14;
                r104 = r101.encodedSizeWithTag(4, r110);
            L14:
                return (r109 + r104) + r100.unknownFields().size();
            L9:
                r108 = 0;
                goto L10
            L5:
                r105 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ URL decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(URL r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, URL r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.encodeWithTag(r100, 1, r101.url);
                String r103 = r101.android_url;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                String r104 = r101.ios_url;
                if (r104 == null) goto L8;
                r102.encodeWithTag(r100, 3, r104);
            L8:
                String r105 = r101.pc_url;
                if (r105 == null) goto L11;
                r102.encodeWithTag(r100, 4, r105);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, URL r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_URL();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.url = this.url;
            r100.android_url = this.android_url;
            r100.ios_url = this.ios_url;
            r100.pc_url = this.pc_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return URL.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public URL(String r100, String r101, String r102, String r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public URL(String r100, String r101, String r102, String r103, ByteString r104) {
            super(ADAPTER, r104);
            this.url = r100;
            this.android_url = r101;
            this.ios_url = r102;
            this.pc_url = r103;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppFeedCardButton();
        DEFAULT_ACTION_TYPE = ActionType.UNKNOWN;
        DEFAULT_BUTTON_TYPE = ButtonType.DEFAULT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253440id = this.f253439id;
        r100.multi_url = this.multi_url;
        r100.action_type = this.action_type;
        r100.text = this.text;
        r100.button_type = this.button_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppFeedCardButton.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppFeedCardButton(String r100, URL r101, ActionType r110, Text r111, ButtonType r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public AppFeedCardButton(String r100, URL r101, ActionType r102, Text r103, ButtonType r104, ByteString r105) {
        super(ADAPTER, r105);
        this.f253439id = r100;
        this.multi_url = r101;
        this.action_type = r102;
        this.text = r103;
        this.button_type = r104;
    }
}
