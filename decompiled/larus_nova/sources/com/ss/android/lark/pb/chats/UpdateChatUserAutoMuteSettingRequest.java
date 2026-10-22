package com.ss.android.lark.pb.chats;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class UpdateChatUserAutoMuteSettingRequest extends Message<UpdateChatUserAutoMuteSettingRequest, Builder> {
    public static final ProtoAdapter<UpdateChatUserAutoMuteSettingRequest> ADAPTER = null;
    public static final Long DEFAULT_BOT_ID = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mbot_id;
    public final Long mchat_id;
    public final MuteSource msource;
    public final UpdateField mupdate_field;

    public static final class Builder extends Message.Builder<UpdateChatUserAutoMuteSettingRequest, Builder> {
        public Long mbot_id;
        public Long mchat_id;
        public MuteSource msource;
        public UpdateField mupdate_field;

        @Override // com.squareup.wire.Message.Builder
        public UpdateChatUserAutoMuteSettingRequest build() {
            Long r100 = this.mchat_id;
            if (r100 == null) goto L7;
            return new UpdateChatUserAutoMuteSettingRequest(this.mchat_id, this.mbot_id, this.mupdate_field, this.msource, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mchat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder bot_id(Long r100) {
            this.mbot_id = r100;
            return this;
        }

        public Builder chat_id(Long r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder source(MuteSource r100) {
            this.msource = r100;
            return this;
        }

        public Builder update_field(UpdateField r100) {
            this.mupdate_field = r100;
            return this;
        }
    }

    public static final enum MuteSource extends Enum<MuteSource> implements WireEnum {
        private static final /* synthetic */ MuteSource[] $VALUES = null;
        public static final ProtoAdapter<MuteSource> ADAPTER = null;
        public static final MuteSource CHAT_SETTINGS = null;
        public static final MuteSource CHAT_TOP_BANNER = null;
        public static final MuteSource GROUP_MEMBER_ROBOT_LIST = null;
        public static final MuteSource NOISE_REDUCTION_SYS_MSG = null;
        public static final MuteSource RIGHT_CLICK_LIST_OPTIONS = null;
        public static final MuteSource UNKNOWN_SOURCE = null;
        private final int value;

        static {
            MuteSource r100 = new MuteSource("UNKNOWN_SOURCE", 0, 0);
            UNKNOWN_SOURCE = r100;
            MuteSource r101 = new MuteSource("CHAT_TOP_BANNER", 1, 1);
            CHAT_TOP_BANNER = r101;
            MuteSource r102 = new MuteSource("GROUP_MEMBER_ROBOT_LIST", 2, 2);
            GROUP_MEMBER_ROBOT_LIST = r102;
            MuteSource r103 = new MuteSource("NOISE_REDUCTION_SYS_MSG", 3, 3);
            NOISE_REDUCTION_SYS_MSG = r103;
            MuteSource r104 = new MuteSource("RIGHT_CLICK_LIST_OPTIONS", 4, 4);
            RIGHT_CLICK_LIST_OPTIONS = r104;
            MuteSource r105 = new MuteSource("CHAT_SETTINGS", 5, 5);
            CHAT_SETTINGS = r105;
            $VALUES = new MuteSource[]{r100, r101, r102, r103, r104, r105};
            ADAPTER = ProtoAdapter.newEnumAdapter(MuteSource.class);
        }

        public static MuteSource[] values() {
            return (MuteSource[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static MuteSource fromValue(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return CHAT_SETTINGS;
        L18:
            return RIGHT_CLICK_LIST_OPTIONS;
        L20:
            return NOISE_REDUCTION_SYS_MSG;
        L22:
            return GROUP_MEMBER_ROBOT_LIST;
        L24:
            return CHAT_TOP_BANNER;
        L26:
            return UNKNOWN_SOURCE;
        }

        public static MuteSource valueOf(String r100) {
            return (MuteSource) a.a(MuteSource.class, r100);
        }

        private MuteSource(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_UpdateChatUserAutoMuteSettingRequest extends ProtoAdapter<UpdateChatUserAutoMuteSettingRequest> {
        public ProtoAdapter_UpdateChatUserAutoMuteSettingRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateChatUserAutoMuteSettingRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateChatUserAutoMuteSettingRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchat_id = 0L;
            r101.mbot_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.mchat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mbot_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 4) goto L12;
            r101.mupdate_field = UpdateField.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 5) goto L13;
            r101.msource = MuteSource.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UpdateChatUserAutoMuteSettingRequest r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            int r102 = r101.encodedSizeWithTag(1, r100.mchat_id);
            Long r103 = r100.mbot_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            UpdateField r107 = r100.mupdate_field;
            if (r107 == null) goto L9;
            int r108 = UpdateField.ADAPTER.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            MuteSource r110 = r100.msource;
            if (r110 == null) goto L14;
            r104 = MuteSource.ADAPTER.encodedSizeWithTag(5, r110);
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
        public /* bridge */ /* synthetic */ UpdateChatUserAutoMuteSettingRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateChatUserAutoMuteSettingRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateChatUserAutoMuteSettingRequest r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.mchat_id);
            Long r103 = r101.mbot_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            UpdateField r104 = r101.mupdate_field;
            if (r104 == null) goto L8;
            UpdateField.ADAPTER.encodeWithTag(r100, 4, r104);
        L8:
            MuteSource r105 = r101.msource;
            if (r105 == null) goto L11;
            MuteSource.ADAPTER.encodeWithTag(r100, 5, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateChatUserAutoMuteSettingRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum UpdateField extends Enum<UpdateField> implements WireEnum {
        private static final /* synthetic */ UpdateField[] $VALUES = null;
        public static final ProtoAdapter<UpdateField> ADAPTER = null;
        public static final UpdateField CLOSE_BANNER_SHOW = null;
        public static final UpdateField CLOSE_BOT_MUTE = null;
        public static final UpdateField CLOSE_LARGE_CHAT_MUTE = null;
        public static final UpdateField OPEN_BOT_MUTE = null;
        public static final UpdateField UNKNOWN = null;
        private final int value;

        static {
            UpdateField r100 = new UpdateField("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            UpdateField r101 = new UpdateField("CLOSE_LARGE_CHAT_MUTE", 1, 1);
            CLOSE_LARGE_CHAT_MUTE = r101;
            UpdateField r102 = new UpdateField("CLOSE_BOT_MUTE", 2, 2);
            CLOSE_BOT_MUTE = r102;
            UpdateField r103 = new UpdateField("OPEN_BOT_MUTE", 3, 3);
            OPEN_BOT_MUTE = r103;
            UpdateField r104 = new UpdateField("CLOSE_BANNER_SHOW", 4, 4);
            CLOSE_BANNER_SHOW = r104;
            $VALUES = new UpdateField[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(UpdateField.class);
        }

        public static UpdateField[] values() {
            return (UpdateField[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static UpdateField fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return CLOSE_BANNER_SHOW;
        L16:
            return OPEN_BOT_MUTE;
        L18:
            return CLOSE_BOT_MUTE;
        L20:
            return CLOSE_LARGE_CHAT_MUTE;
        L22:
            return UNKNOWN;
        }

        public static UpdateField valueOf(String r100) {
            return (UpdateField) a.a(UpdateField.class, r100);
        }

        private UpdateField(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UpdateChatUserAutoMuteSettingRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_CHAT_ID = 0L;
        DEFAULT_BOT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_id = this.mchat_id;
        r100.mbot_id = this.mbot_id;
        r100.mupdate_field = this.mupdate_field;
        r100.msource = this.msource;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateChatUserAutoMuteSettingRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateChatUserAutoMuteSettingRequest(Long r100, Long r101, UpdateField r102, MuteSource r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UpdateChatUserAutoMuteSettingRequest(Long r100, Long r101, UpdateField r102, MuteSource r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mchat_id = r100;
        this.mbot_id = r101;
        this.mupdate_field = r102;
        this.msource = r103;
    }
}
