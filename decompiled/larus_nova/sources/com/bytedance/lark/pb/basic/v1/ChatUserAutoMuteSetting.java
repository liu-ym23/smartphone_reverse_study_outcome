package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class ChatUserAutoMuteSetting extends com.squareup.wire.Message<ChatUserAutoMuteSetting, Builder> {
    public static final ProtoAdapter<ChatUserAutoMuteSetting> ADAPTER = null;
    public static final NoticeType DEFAULT_NOTICE_TYPE = null;
    public static final Boolean DEFAULT_SHOW_TOP_BANNER = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final List<BotAutoMuteConfig> bot_auto_mute;
    public final NoticeType notice_type;
    public final Boolean show_top_banner;
    public final Long update_time;
    public final AutoMuteConfig user_auto_mute;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatUserAutoMuteSetting, Builder> {
        public List<BotAutoMuteConfig> bot_auto_mute;
        public NoticeType notice_type;
        public Boolean show_top_banner;
        public Long update_time;
        public AutoMuteConfig user_auto_mute;

        @Override // com.squareup.wire.Message.Builder
        public ChatUserAutoMuteSetting build() {
            return new ChatUserAutoMuteSetting(this.user_auto_mute, this.bot_auto_mute, this.notice_type, this.update_time, this.show_top_banner, super.buildUnknownFields());
        }

        public Builder() {
            this.bot_auto_mute = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder bot_auto_mute(List<BotAutoMuteConfig> r100) {
            Internal.checkElementsNotNull(r100);
            this.bot_auto_mute = r100;
            return this;
        }

        public Builder notice_type(NoticeType r100) {
            this.notice_type = r100;
            return this;
        }

        public Builder show_top_banner(Boolean r100) {
            this.show_top_banner = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder user_auto_mute(AutoMuteConfig r100) {
            this.user_auto_mute = r100;
            return this;
        }
    }

    public static final enum NoticeType extends Enum<NoticeType> implements WireEnum {
        private static final /* synthetic */ NoticeType[] $VALUES = null;
        public static final ProtoAdapter<NoticeType> ADAPTER = null;
        public static final NoticeType DIGITAL_NOTICE = null;
        public static final NoticeType RED_DOT_NOTICE = null;
        public static final NoticeType UNKNOWN = null;
        private final int value;

        static {
            NoticeType r100 = new NoticeType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            NoticeType r101 = new NoticeType("DIGITAL_NOTICE", 1, 1);
            DIGITAL_NOTICE = r101;
            NoticeType r102 = new NoticeType("RED_DOT_NOTICE", 2, 2);
            RED_DOT_NOTICE = r102;
            $VALUES = new NoticeType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(NoticeType.class);
        }

        public static NoticeType[] values() {
            return (NoticeType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static NoticeType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return RED_DOT_NOTICE;
        L12:
            return DIGITAL_NOTICE;
        L14:
            return UNKNOWN;
        }

        public static NoticeType valueOf(String r100) {
            return (NoticeType) a.a(NoticeType.class, r100);
        }

        private NoticeType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_ChatUserAutoMuteSetting extends ProtoAdapter<ChatUserAutoMuteSetting> {
        public ProtoAdapter_ChatUserAutoMuteSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatUserAutoMuteSetting.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatUserAutoMuteSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.notice_type = NoticeType.UNKNOWN;
            r101.update_time = 0L;
            r101.show_top_banner = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.user_auto_mute = AutoMuteConfig.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.bot_auto_mute.add(BotAutoMuteConfig.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.notice_type = NoticeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.show_top_banner = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(ChatUserAutoMuteSetting r100) {
            AutoMuteConfig r101 = r100.user_auto_mute;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = AutoMuteConfig.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + BotAutoMuteConfig.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.bot_auto_mute);
            NoticeType r105 = r100.notice_type;
            if (r105 == null) goto L9;
            int r106 = NoticeType.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            Long r108 = r100.update_time;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.INT64.encodedSizeWithTag(4, r108);
        L14:
            int r110 = r107 + r109;
            Boolean r111 = r100.show_top_banner;
            if (r111 == null) goto L18;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r111);
        L18:
            return (r110 + r102) + r100.unknownFields().size();
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ChatUserAutoMuteSetting decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ChatUserAutoMuteSetting r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ChatUserAutoMuteSetting r101) throws IOException {
            AutoMuteConfig r102 = r101.user_auto_mute;
            if (r102 == null) goto L5;
            AutoMuteConfig.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            BotAutoMuteConfig.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.bot_auto_mute);
            NoticeType r103 = r101.notice_type;
            if (r103 == null) goto L8;
            NoticeType.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            Long r104 = r101.update_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r104);
        L11:
            Boolean r105 = r101.show_top_banner;
            if (r105 == null) goto L14;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ChatUserAutoMuteSetting r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ChatUserAutoMuteSetting();
        DEFAULT_NOTICE_TYPE = NoticeType.UNKNOWN;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_SHOW_TOP_BANNER = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_auto_mute = this.user_auto_mute;
        r100.bot_auto_mute = Internal.copyOf("bot_auto_mute", this.bot_auto_mute);
        r100.notice_type = this.notice_type;
        r100.update_time = this.update_time;
        r100.show_top_banner = this.show_top_banner;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ChatUserAutoMuteSetting.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ChatUserAutoMuteSetting(AutoMuteConfig r100, List<BotAutoMuteConfig> r101, NoticeType r110, Long r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ChatUserAutoMuteSetting(AutoMuteConfig r100, List<BotAutoMuteConfig> r101, NoticeType r102, Long r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.user_auto_mute = r100;
        this.bot_auto_mute = Internal.immutableCopyOf("bot_auto_mute", r101);
        this.notice_type = r102;
        this.update_time = r103;
        this.show_top_banner = r104;
    }
}
