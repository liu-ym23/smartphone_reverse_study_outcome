package com.bytedance.lark.pb.sync.v1;

import com.bytedance.android.livesdkapi.minigame.SeiMessageConst;
import com.bytedance.common.wschannel.WsConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SyncMessage extends Message<SyncMessage, Builder> {
    public static final ProtoAdapter<SyncMessage> ADAPTER = null;
    public static final MsgType DEFAULT_MSG_TYPE = null;
    public static final ByteString DEFAULT_PAYLOAD = null;
    public static final Long DEFAULT_SEQ = null;
    public static final String DEFAULT_TOPIC_ID = "";
    private static final long serialVersionUID = 0;
    public final MsgType msg_type;
    public final ByteString payload;
    public final Long seq;
    public final String topic_id;

    public static final class Builder extends Message.Builder<SyncMessage, Builder> {
        public MsgType msg_type;
        public ByteString payload;
        public Long seq;
        public String topic_id;

        @Override // com.squareup.wire.Message.Builder
        public SyncMessage build() {
            String r100 = this.topic_id;
            if (r100 == null) goto L11;
            if (this.payload == null) goto L11;
            if (this.msg_type == null) goto L11;
            return new SyncMessage(this.topic_id, this.payload, this.msg_type, this.seq, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "topic_id", this.payload, WsConstants.KEY_PAYLOAD, this.msg_type, SeiMessageConst.MSG_TYPE});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder msg_type(MsgType r100) {
            this.msg_type = r100;
            return this;
        }

        public Builder payload(ByteString r100) {
            this.payload = r100;
            return this;
        }

        public Builder seq(Long r100) {
            this.seq = r100;
            return this;
        }

        public Builder topic_id(String r100) {
            this.topic_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SyncMessage extends ProtoAdapter<SyncMessage> {
        public ProtoAdapter_SyncMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, SyncMessage.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SyncMessage decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.topic_id = "";
            r101.payload = ByteString.EMPTY;
            r101.msg_type = MsgType.Common;
            r101.seq = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.topic_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.payload = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.msg_type = MsgType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.seq = ProtoAdapter.INT64.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SyncMessage r100) {
            int r101 = (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.topic_id) + ProtoAdapter.BYTES.encodedSizeWithTag(2, r100.payload)) + MsgType.ADAPTER.encodedSizeWithTag(3, r100.msg_type);
            Long r102 = r100.seq;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(4, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SyncMessage decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SyncMessage r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SyncMessage r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.topic_id);
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r101.payload);
            MsgType.ADAPTER.encodeWithTag(r100, 3, r101.msg_type);
            Long r102 = r101.seq;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SyncMessage r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SyncMessage();
        DEFAULT_PAYLOAD = ByteString.EMPTY;
        DEFAULT_MSG_TYPE = MsgType.Common;
        DEFAULT_SEQ = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.topic_id = this.topic_id;
        r100.payload = this.payload;
        r100.msg_type = this.msg_type;
        r100.seq = this.seq;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SyncMessage.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SyncMessage(String r100, ByteString r101, MsgType r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SyncMessage(String r100, ByteString r101, MsgType r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.topic_id = r100;
        this.payload = r101;
        this.msg_type = r102;
        this.seq = r103;
    }
}
