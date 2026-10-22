package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class ChatUserAutoMuteSetting extends com.squareup.wire.Message<ChatUserAutoMuteSetting, Builder> {
    public static final ProtoAdapter<ChatUserAutoMuteSetting> ADAPTER = null;
    public static final Boolean DEFAULT_SHOW_TOP_BANNER = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, AutoMuteConfig> mbot_auto_mutes;
    public final AutoMuteConfig mlarge_chat_auto_mute;
    public final NoticeType mnotice_type;
    public final Boolean mshow_top_banner;
    public final Long mupdate_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<ChatUserAutoMuteSetting, Builder> {
        public Map<Long, AutoMuteConfig> mbot_auto_mutes;
        public AutoMuteConfig mlarge_chat_auto_mute;
        public NoticeType mnotice_type;
        public Boolean mshow_top_banner;
        public Long mupdate_time;

        @Override // com.squareup.wire.Message.Builder
        public ChatUserAutoMuteSetting build() {
            return new ChatUserAutoMuteSetting(this.mlarge_chat_auto_mute, this.mbot_auto_mutes, this.mnotice_type, this.mupdate_time, this.mshow_top_banner, super.buildUnknownFields());
        }

        public Builder() {
            this.mbot_auto_mutes = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder bot_auto_mutes(Map<Long, AutoMuteConfig> r100) {
            Internal.checkElementsNotNull(r100);
            this.mbot_auto_mutes = r100;
            return this;
        }

        public Builder large_chat_auto_mute(AutoMuteConfig r100) {
            this.mlarge_chat_auto_mute = r100;
            return this;
        }

        public Builder notice_type(NoticeType r100) {
            this.mnotice_type = r100;
            return this;
        }

        public Builder show_top_banner(Boolean r100) {
            this.mshow_top_banner = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.mupdate_time = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ChatUserAutoMuteSetting extends ProtoAdapter<ChatUserAutoMuteSetting> {
        private final ProtoAdapter<Map<Long, AutoMuteConfig>> mbot_auto_mutes;

        public ProtoAdapter_ChatUserAutoMuteSetting() {
            super(FieldEncoding.LENGTH_DELIMITED, ChatUserAutoMuteSetting.class);
            this.mbot_auto_mutes = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, AutoMuteConfig.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ChatUserAutoMuteSetting decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mupdate_time = 0L;
            r101.mshow_top_banner = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.mlarge_chat_auto_mute = AutoMuteConfig.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mbot_auto_mutes.putAll(this.mbot_auto_mutes.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mnotice_type = NoticeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mupdate_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mshow_top_banner = ProtoAdapter.BOOL.decode(r100);
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
            AutoMuteConfig r101 = r100.mlarge_chat_auto_mute;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = AutoMuteConfig.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + this.mbot_auto_mutes.encodedSizeWithTag(2, r100.mbot_auto_mutes);
            NoticeType r105 = r100.mnotice_type;
            if (r105 == null) goto L9;
            int r106 = NoticeType.ADAPTER.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            Long r108 = r100.mupdate_time;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.INT64.encodedSizeWithTag(4, r108);
        L14:
            int r110 = r107 + r109;
            Boolean r111 = r100.mshow_top_banner;
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
            AutoMuteConfig r102 = r101.mlarge_chat_auto_mute;
            if (r102 == null) goto L5;
            AutoMuteConfig.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            this.mbot_auto_mutes.encodeWithTag(r100, 2, r101.mbot_auto_mutes);
            NoticeType r103 = r101.mnotice_type;
            if (r103 == null) goto L8;
            NoticeType.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            Long r104 = r101.mupdate_time;
            if (r104 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r104);
        L11:
            Boolean r105 = r101.mshow_top_banner;
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
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_SHOW_TOP_BANNER = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mlarge_chat_auto_mute = this.mlarge_chat_auto_mute;
        r100.mbot_auto_mutes = Internal.copyOf("mbot_auto_mutes", this.mbot_auto_mutes);
        r100.mnotice_type = this.mnotice_type;
        r100.mupdate_time = this.mupdate_time;
        r100.mshow_top_banner = this.mshow_top_banner;
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

    public ChatUserAutoMuteSetting(AutoMuteConfig r100, Map<Long, AutoMuteConfig> r101, NoticeType r110, Long r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public ChatUserAutoMuteSetting(AutoMuteConfig r100, Map<Long, AutoMuteConfig> r101, NoticeType r102, Long r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mlarge_chat_auto_mute = r100;
        this.mbot_auto_mutes = Internal.immutableCopyOf("mbot_auto_mutes", r101);
        this.mnotice_type = r102;
        this.mupdate_time = r103;
        this.mshow_top_banner = r104;
    }
}
