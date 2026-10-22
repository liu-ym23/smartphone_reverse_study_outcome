package com.bytedance.lark.pb.contact.v1;

import com.bytedance.lark.pb.basic.v1.Channel;
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
public final class PushChannelNickname extends Message<PushChannelNickname, Builder> {
    public static final ProtoAdapter<PushChannelNickname> ADAPTER = null;
    public static final String DEFAULT_NICKNAME = "";
    public static final String DEFAULT_USER_ID = "";
    public static final ProtoAdapter_PushChannelNickname RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Channel channel;
    public final String nickname;
    public final String user_id;

    public static final class Builder extends Message.Builder<PushChannelNickname, Builder> implements d<PushChannelNickname> {
        public Channel channel;
        public String nickname;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public PushChannelNickname build() {
            String r100 = this.user_id;
            if (r100 == null) goto L9;
            if (this.channel == null) goto L9;
            return new PushChannelNickname(this.user_id, this.channel, this.nickname, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "user_id", this.channel, "channel"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder channel(Channel r100) {
            this.channel = r100;
            return this;
        }

        public Builder nickname(String r100) {
            this.nickname = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushChannelNickname extends ProtoAdapter<PushChannelNickname> implements c<PushChannelNickname> {
        public ProtoAdapter_PushChannelNickname() {
            super(FieldEncoding.LENGTH_DELIMITED, PushChannelNickname.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushChannelNickname decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = "";
            r101.nickname = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.nickname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushChannelNickname r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.user_id) + Channel.ADAPTER.encodedSizeWithTag(2, r100.channel);
            String r103 = r100.nickname;
            if (r103 == null) goto L5;
            int r104 = r101.encodedSizeWithTag(3, r103);
        L7:
            return (r102 + r104) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushChannelNickname decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushChannelNickname r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushChannelNickname r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.user_id);
            Channel.ADAPTER.encodeWithTag(r100, 2, r101.channel);
            String r103 = r101.nickname;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 3, r103);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushChannelNickname r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushChannelNickname r100 = new ProtoAdapter_PushChannelNickname();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.channel = this.channel;
        r100.nickname = this.nickname;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushChannelNickname.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushChannelNickname(String r100, Channel r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushChannelNickname(String r100, Channel r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.user_id = r100;
        this.channel = r101;
        this.nickname = r102;
    }
}
