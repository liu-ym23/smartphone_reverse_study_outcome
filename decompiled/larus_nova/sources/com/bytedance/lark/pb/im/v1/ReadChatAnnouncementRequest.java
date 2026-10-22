package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class ReadChatAnnouncementRequest extends Message<ReadChatAnnouncementRequest, Builder> {
    public static final ProtoAdapter<ReadChatAnnouncementRequest> ADAPTER = null;
    public static final Long DEFAULT_ANNOUNCE_TIME = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final ProtoAdapter_ReadChatAnnouncementRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Long announce_time;
    public final String chat_id;

    public static final class Builder extends Message.Builder<ReadChatAnnouncementRequest, Builder> implements d<ReadChatAnnouncementRequest> {
        public Long announce_time;
        public String chat_id;

        @Override // com.squareup.wire.Message.Builder
        public ReadChatAnnouncementRequest build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new ReadChatAnnouncementRequest(this.chat_id, this.announce_time, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder announce_time(Long r100) {
            this.announce_time = r100;
            return this;
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ReadChatAnnouncementRequest extends ProtoAdapter<ReadChatAnnouncementRequest> implements c<ReadChatAnnouncementRequest> {
        public ProtoAdapter_ReadChatAnnouncementRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ReadChatAnnouncementRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ReadChatAnnouncementRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.announce_time = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.announce_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(ReadChatAnnouncementRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.chat_id);
            Long r102 = r100.announce_time;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ReadChatAnnouncementRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ReadChatAnnouncementRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ReadChatAnnouncementRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.chat_id);
            Long r102 = r101.announce_time;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReadChatAnnouncementRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ReadChatAnnouncementRequest r100 = new ProtoAdapter_ReadChatAnnouncementRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ANNOUNCE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.announce_time = this.announce_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ReadChatAnnouncementRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ReadChatAnnouncementRequest(String r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ReadChatAnnouncementRequest(String r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.chat_id = r100;
        this.announce_time = r101;
    }
}
