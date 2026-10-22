package com.bytedance.lark.pb.calendar.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class EventMeetingChatExtra extends Message<EventMeetingChatExtra, Builder> {
    public static final ProtoAdapter<EventMeetingChatExtra> ADAPTER = null;
    public static final Boolean DEFAULT_IS_CHAT_OPEN_ENTRY_AUTH = null;
    public static final Boolean DEFAULT_IS_IN_BIND_CHAT = null;
    public static final Boolean DEFAULT_IS_IN_MEETING_CHAT = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_chat_open_entry_auth;
    public final Boolean is_in_bind_chat;
    public final Boolean is_in_meeting_chat;

    public static final class Builder extends Message.Builder<EventMeetingChatExtra, Builder> {
        public Boolean is_chat_open_entry_auth;
        public Boolean is_in_bind_chat;
        public Boolean is_in_meeting_chat;

        @Override // com.squareup.wire.Message.Builder
        public EventMeetingChatExtra build() {
            return new EventMeetingChatExtra(this.is_chat_open_entry_auth, this.is_in_meeting_chat, this.is_in_bind_chat, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_chat_open_entry_auth(Boolean r100) {
            this.is_chat_open_entry_auth = r100;
            return this;
        }

        public Builder is_in_bind_chat(Boolean r100) {
            this.is_in_bind_chat = r100;
            return this;
        }

        public Builder is_in_meeting_chat(Boolean r100) {
            this.is_in_meeting_chat = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EventMeetingChatExtra extends ProtoAdapter<EventMeetingChatExtra> {
        public ProtoAdapter_EventMeetingChatExtra() {
            super(FieldEncoding.LENGTH_DELIMITED, EventMeetingChatExtra.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EventMeetingChatExtra decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.is_chat_open_entry_auth = r102;
            r101.is_in_meeting_chat = r102;
            r101.is_in_bind_chat = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.is_chat_open_entry_auth = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.is_in_meeting_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.is_in_bind_chat = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(EventMeetingChatExtra r100) {
            Boolean r101 = r100.is_chat_open_entry_auth;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.is_in_meeting_chat;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_in_bind_chat;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EventMeetingChatExtra decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EventMeetingChatExtra r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EventMeetingChatExtra r101) throws IOException {
            Boolean r102 = r101.is_chat_open_entry_auth;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.is_in_meeting_chat;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_in_bind_chat;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EventMeetingChatExtra r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EventMeetingChatExtra();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_CHAT_OPEN_ENTRY_AUTH = r100;
        DEFAULT_IS_IN_MEETING_CHAT = r100;
        DEFAULT_IS_IN_BIND_CHAT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_chat_open_entry_auth = this.is_chat_open_entry_auth;
        r100.is_in_meeting_chat = this.is_in_meeting_chat;
        r100.is_in_bind_chat = this.is_in_bind_chat;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EventMeetingChatExtra.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EventMeetingChatExtra(Boolean r100, Boolean r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public EventMeetingChatExtra(Boolean r100, Boolean r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.is_chat_open_entry_auth = r100;
        this.is_in_meeting_chat = r101;
        this.is_in_bind_chat = r102;
    }
}
