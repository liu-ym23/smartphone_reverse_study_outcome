package com.bytedance.lark.pb.im.v1;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.lark.pb.basic.v1.ExternalDisplayTimezoneSettingType;
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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushChatTimeTipNotify extends Message<PushChatTimeTipNotify, Builder> {
    public static final ProtoAdapter<PushChatTimeTipNotify> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_CHAT_USER_TIME = "";
    public static final String DEFAULT_COPY_WRITING = "";
    public static final String DEFAULT_EXTERNAL_DISPLAY_TIME = "";
    public static final ExternalDisplayTimezoneSettingType DEFAULT_EXTERNAL_DISPLAY_TIMEZONE_TYPE = null;
    public static final TimeTipStatus DEFAULT_STATUS = null;
    public static final ProtoAdapter_PushChatTimeTipNotify RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final String chat_user_time;
    public final String copy_writing;
    public final String external_display_time;
    public final ExternalDisplayTimezoneSettingType external_display_timezone_type;
    public final TimeTipStatus status;

    public static final class Builder extends Message.Builder<PushChatTimeTipNotify, Builder> implements d<PushChatTimeTipNotify> {
        public String chat_id;
        public String chat_user_time;
        public String copy_writing;
        public String external_display_time;
        public ExternalDisplayTimezoneSettingType external_display_timezone_type;
        public TimeTipStatus status;

        @Override // com.squareup.wire.Message.Builder
        public PushChatTimeTipNotify build() {
            TimeTipStatus r100 = this.status;
            if (r100 == null) goto L9;
            if (this.chat_id == null) goto L9;
            return new PushChatTimeTipNotify(this.status, this.copy_writing, this.chat_id, this.chat_user_time, this.external_display_timezone_type, this.external_display_time, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "status", this.chat_id, "chat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chat_user_time(String r100) {
            this.chat_user_time = r100;
            return this;
        }

        public Builder copy_writing(String r100) {
            this.copy_writing = r100;
            return this;
        }

        public Builder external_display_time(String r100) {
            this.external_display_time = r100;
            return this;
        }

        public Builder external_display_timezone_type(ExternalDisplayTimezoneSettingType r100) {
            this.external_display_timezone_type = r100;
            return this;
        }

        public Builder status(TimeTipStatus r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushChatTimeTipNotify extends ProtoAdapter<PushChatTimeTipNotify> implements c<PushChatTimeTipNotify> {
        public ProtoAdapter_PushChatTimeTipNotify() {
            super(FieldEncoding.LENGTH_DELIMITED, PushChatTimeTipNotify.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushChatTimeTipNotify decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status = TimeTipStatus.START;
            r101.copy_writing = "";
            r101.chat_id = "";
            r101.chat_user_time = "";
            r101.external_display_timezone_type = ExternalDisplayTimezoneSettingType.UNKNOWN;
            r101.external_display_time = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L19;
            switch(r103) {
                case 1: goto L21;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L23;
                case 6: goto L7;
                default: goto L6;
            };
        L21:
            r101.status = TimeTipStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L23:
            r101.external_display_timezone_type = ExternalDisplayTimezoneSettingType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.external_display_time = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.chat_user_time = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.copy_writing = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L19:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushChatTimeTipNotify r100) {
            int r101 = TimeTipStatus.ADAPTER.encodedSizeWithTag(1, r100.status);
            String r102 = r100.copy_writing;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            ProtoAdapter<String> r106 = ProtoAdapter.STRING;
            int r107 = r105 + r106.encodedSizeWithTag(3, r100.chat_id);
            String r108 = r100.chat_user_time;
            if (r108 == null) goto L9;
            int r109 = r106.encodedSizeWithTag(4, r108);
        L10:
            int r110 = r107 + r109;
            ExternalDisplayTimezoneSettingType r111 = r100.external_display_timezone_type;
            if (r111 == null) goto L13;
            int r112 = ExternalDisplayTimezoneSettingType.ADAPTER.encodedSizeWithTag(5, r111);
        L14:
            int r113 = r110 + r112;
            String r114 = r100.external_display_time;
            if (r114 == null) goto L18;
            r103 = r106.encodedSizeWithTag(6, r114);
        L18:
            return (r113 + r103) + r100.unknownFields().size();
        L13:
            r112 = 0;
            goto L14
        L9:
            r109 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushChatTimeTipNotify decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushChatTimeTipNotify r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushChatTimeTipNotify r101) throws IOException {
            TimeTipStatus.ADAPTER.encodeWithTag(r100, 1, r101.status);
            String r102 = r101.copy_writing;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            ProtoAdapter<String> r103 = ProtoAdapter.STRING;
            r103.encodeWithTag(r100, 3, r101.chat_id);
            String r104 = r101.chat_user_time;
            if (r104 == null) goto L8;
            r103.encodeWithTag(r100, 4, r104);
        L8:
            ExternalDisplayTimezoneSettingType r105 = r101.external_display_timezone_type;
            if (r105 == null) goto L11;
            ExternalDisplayTimezoneSettingType.ADAPTER.encodeWithTag(r100, 5, r105);
        L11:
            String r106 = r101.external_display_time;
            if (r106 == null) goto L14;
            r103.encodeWithTag(r100, 6, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushChatTimeTipNotify r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TimeTipStatus extends Enum<TimeTipStatus> implements WireEnum {
        private static final /* synthetic */ TimeTipStatus[] $VALUES = null;
        public static final ProtoAdapter<TimeTipStatus> ADAPTER = null;
        public static final TimeTipStatus END = null;
        public static final TimeTipStatus START = null;
        public static final TimeTipStatus UPDATE = null;
        private final int value;

        static {
            TimeTipStatus r100 = new TimeTipStatus(GXAnimation.STATE_START, 0, 0);
            START = r100;
            TimeTipStatus r101 = new TimeTipStatus("UPDATE", 1, 1);
            UPDATE = r101;
            TimeTipStatus r102 = new TimeTipStatus(GXAnimation.STATE_END, 2, 2);
            END = r102;
            $VALUES = new TimeTipStatus[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(TimeTipStatus.class);
        }

        public static TimeTipStatus[] values() {
            return (TimeTipStatus[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TimeTipStatus fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return END;
        L12:
            return UPDATE;
        L14:
            return START;
        }

        public static TimeTipStatus valueOf(String r100) {
            return (TimeTipStatus) a.a(TimeTipStatus.class, r100);
        }

        private TimeTipStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_PushChatTimeTipNotify r100 = new ProtoAdapter_PushChatTimeTipNotify();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATUS = TimeTipStatus.START;
        DEFAULT_EXTERNAL_DISPLAY_TIMEZONE_TYPE = ExternalDisplayTimezoneSettingType.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.status = this.status;
        r100.copy_writing = this.copy_writing;
        r100.chat_id = this.chat_id;
        r100.chat_user_time = this.chat_user_time;
        r100.external_display_timezone_type = this.external_display_timezone_type;
        r100.external_display_time = this.external_display_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushChatTimeTipNotify.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushChatTimeTipNotify(TimeTipStatus r100, String r110, String r111, String r112, ExternalDisplayTimezoneSettingType r113, String r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public PushChatTimeTipNotify(TimeTipStatus r100, String r101, String r102, String r103, ExternalDisplayTimezoneSettingType r104, String r105, ByteString r106) {
        super(ADAPTER, r106);
        this.status = r100;
        this.copy_writing = r101;
        this.chat_id = r102;
        this.chat_user_time = r103;
        this.external_display_timezone_type = r104;
        this.external_display_time = r105;
    }
}
