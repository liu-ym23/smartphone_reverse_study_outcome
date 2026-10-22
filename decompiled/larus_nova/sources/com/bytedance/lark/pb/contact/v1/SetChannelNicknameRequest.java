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
public final class SetChannelNicknameRequest extends Message<SetChannelNicknameRequest, Builder> {
    public static final ProtoAdapter<SetChannelNicknameRequest> ADAPTER = null;
    public static final String DEFAULT_NICKNAME = "";
    public static final ProtoAdapter_SetChannelNicknameRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Channel channel;
    public final String nickname;

    public static final class Builder extends Message.Builder<SetChannelNicknameRequest, Builder> implements d<SetChannelNicknameRequest> {
        public Channel channel;
        public String nickname;

        @Override // com.squareup.wire.Message.Builder
        public SetChannelNicknameRequest build() {
            Channel r100 = this.channel;
            if (r100 == null) goto L7;
            return new SetChannelNicknameRequest(this.channel, this.nickname, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "channel"});
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
    }

    public static final class ProtoAdapter_SetChannelNicknameRequest extends ProtoAdapter<SetChannelNicknameRequest> implements c<SetChannelNicknameRequest> {
        public ProtoAdapter_SetChannelNicknameRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetChannelNicknameRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetChannelNicknameRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.nickname = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.channel = Channel.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.nickname = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SetChannelNicknameRequest r100) {
            int r101 = Channel.ADAPTER.encodedSizeWithTag(1, r100.channel);
            String r102 = r100.nickname;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetChannelNicknameRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetChannelNicknameRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetChannelNicknameRequest r101) throws IOException {
            Channel.ADAPTER.encodeWithTag(r100, 1, r101.channel);
            String r102 = r101.nickname;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetChannelNicknameRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetChannelNicknameRequest r100 = new ProtoAdapter_SetChannelNicknameRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.channel = this.channel;
        r100.nickname = this.nickname;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetChannelNicknameRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetChannelNicknameRequest(Channel r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SetChannelNicknameRequest(Channel r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.channel = r100;
        this.nickname = r101;
    }
}
