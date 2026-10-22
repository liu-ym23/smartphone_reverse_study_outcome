package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class AppFeedCardData extends com.squareup.wire.Message<AppFeedCardData, Builder> {
    public static final ProtoAdapter<AppFeedCardData> ADAPTER = null;
    public static final Long DEFAULT_APP_ID = null;
    public static final String DEFAULT_BIZ_ID = "";
    public static final String DEFAULT_FEED_ID = "";
    public static final String DEFAULT_LINK = "";
    public static final AppFeedCardType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final Long app_id;
    public final Image avatar;
    public final String biz_id;
    public final String feed_id;
    public final String link;
    public final CustomSpeechFile speech_file;
    public final AppFeedCardType type;

    public static final enum AppFeedCardType extends Enum<AppFeedCardType> implements WireEnum {
        private static final /* synthetic */ AppFeedCardType[] $VALUES = null;
        public static final ProtoAdapter<AppFeedCardType> ADAPTER = null;
        public static final AppFeedCardType AI_UNREAD_SUMMARY = null;
        public static final AppFeedCardType CALENDAR = null;
        public static final AppFeedCardType CONTACT = null;
        public static final AppFeedCardType DOUBAO = null;
        public static final AppFeedCardType MAIL = null;
        public static final AppFeedCardType MINUTES = null;
        public static final AppFeedCardType OPEN = null;
        public static final AppFeedCardType UNKNOWN_APP_FEED_CARD_TYPE = null;
        private final int value;

        static {
            AppFeedCardType r100 = new AppFeedCardType("UNKNOWN_APP_FEED_CARD_TYPE", 0, 0);
            UNKNOWN_APP_FEED_CARD_TYPE = r100;
            AppFeedCardType r101 = new AppFeedCardType("MAIL", 1, 1);
            MAIL = r101;
            AppFeedCardType r102 = new AppFeedCardType("CALENDAR", 2, 2);
            CALENDAR = r102;
            AppFeedCardType r103 = new AppFeedCardType("OPEN", 3, 3);
            OPEN = r103;
            AppFeedCardType r104 = new AppFeedCardType("AI_UNREAD_SUMMARY", 4, 4);
            AI_UNREAD_SUMMARY = r104;
            AppFeedCardType r105 = new AppFeedCardType("MINUTES", 5, 5);
            MINUTES = r105;
            AppFeedCardType r110 = new AppFeedCardType("CONTACT", 6, 6);
            CONTACT = r110;
            AppFeedCardType r111 = new AppFeedCardType("DOUBAO", 7, 7);
            DOUBAO = r111;
            $VALUES = new AppFeedCardType[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(AppFeedCardType.class);
        }

        public static AppFeedCardType[] values() {
            return (AppFeedCardType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AppFeedCardType fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return DOUBAO;
        L8:
            return CONTACT;
        L10:
            return MINUTES;
        L12:
            return AI_UNREAD_SUMMARY;
        L14:
            return OPEN;
        L16:
            return CALENDAR;
        L18:
            return MAIL;
        L20:
            return UNKNOWN_APP_FEED_CARD_TYPE;
        }

        public static AppFeedCardType valueOf(String r100) {
            return (AppFeedCardType) a.a(AppFeedCardType.class, r100);
        }

        private AppFeedCardType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends com.squareup.wire.Message.Builder<AppFeedCardData, Builder> {
        public Long app_id;
        public Image avatar;
        public String biz_id;
        public String feed_id;
        public String link;
        public CustomSpeechFile speech_file;
        public AppFeedCardType type;

        @Override // com.squareup.wire.Message.Builder
        public AppFeedCardData build() {
            return new AppFeedCardData(this.feed_id, this.biz_id, this.app_id, this.type, this.link, this.avatar, this.speech_file, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder app_id(Long r100) {
            this.app_id = r100;
            return this;
        }

        public Builder avatar(Image r100) {
            this.avatar = r100;
            return this;
        }

        public Builder biz_id(String r100) {
            this.biz_id = r100;
            return this;
        }

        public Builder feed_id(String r100) {
            this.feed_id = r100;
            return this;
        }

        public Builder link(String r100) {
            this.link = r100;
            return this;
        }

        public Builder speech_file(CustomSpeechFile r100) {
            this.speech_file = r100;
            return this;
        }

        public Builder type(AppFeedCardType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AppFeedCardData extends ProtoAdapter<AppFeedCardData> {
        public ProtoAdapter_AppFeedCardData() {
            super(FieldEncoding.LENGTH_DELIMITED, AppFeedCardData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AppFeedCardData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.feed_id = "";
            r101.biz_id = "";
            r101.app_id = 0L;
            r101.type = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
            r101.link = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L17;
            switch(r103) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L19;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r101.type = AppFeedCardType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.speech_file = CustomSpeechFile.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.avatar = Image.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.link = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.app_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.biz_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.feed_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(AppFeedCardData r100) {
            String r101 = r100.feed_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.biz_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Long r107 = r100.app_id;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            AppFeedCardType r110 = r100.type;
            if (r110 == null) goto L17;
            int r111 = AppFeedCardType.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.link;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Image r116 = r100.avatar;
            if (r116 == null) goto L25;
            int r117 = Image.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            CustomSpeechFile r119 = r100.speech_file;
            if (r119 == null) goto L30;
            r102 = CustomSpeechFile.ADAPTER.encodedSizeWithTag(7, r119);
        L30:
            return (r118 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ AppFeedCardData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AppFeedCardData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AppFeedCardData r101) throws IOException {
            String r102 = r101.feed_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.biz_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            Long r104 = r101.app_id;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L11:
            AppFeedCardType r105 = r101.type;
            if (r105 == null) goto L14;
            AppFeedCardType.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.link;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Image r107 = r101.avatar;
            if (r107 == null) goto L20;
            Image.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            CustomSpeechFile r108 = r101.speech_file;
            if (r108 == null) goto L23;
            CustomSpeechFile.ADAPTER.encodeWithTag(r100, 7, r108);
        L23:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppFeedCardData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AppFeedCardData();
        DEFAULT_APP_ID = 0L;
        DEFAULT_TYPE = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_id = this.feed_id;
        r100.biz_id = this.biz_id;
        r100.app_id = this.app_id;
        r100.type = this.type;
        r100.link = this.link;
        r100.avatar = this.avatar;
        r100.speech_file = this.speech_file;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AppFeedCardData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public AppFeedCardData(String r110, String r111, Long r112, AppFeedCardType r113, String r114, Image r115, CustomSpeechFile r116) {
        this(r110, r111, r112, r113, r114, r115, r116, ByteString.EMPTY);
    }

    public AppFeedCardData(String r100, String r101, Long r102, AppFeedCardType r103, String r104, Image r105, CustomSpeechFile r106, ByteString r107) {
        super(ADAPTER, r107);
        this.feed_id = r100;
        this.biz_id = r101;
        this.app_id = r102;
        this.type = r103;
        this.link = r104;
        this.avatar = r105;
        this.speech_file = r106;
    }
}
