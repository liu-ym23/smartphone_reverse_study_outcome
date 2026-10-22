package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class Ser2CliMessagesResponse extends Message<Ser2CliMessagesResponse, Builder> {
    public static final ProtoAdapter<Ser2CliMessagesResponse> ADAPTER = null;
    public static final ProtoAdapter_Ser2CliMessagesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, com.bytedance.lark.pb.basic.v1.Message> cli_messages;

    public static final class Builder extends Message.Builder<Ser2CliMessagesResponse, Builder> implements d<Ser2CliMessagesResponse> {
        public Map<String, com.bytedance.lark.pb.basic.v1.Message> cli_messages;

        @Override // com.squareup.wire.Message.Builder
        public Ser2CliMessagesResponse build() {
            return new Ser2CliMessagesResponse(this.cli_messages, super.buildUnknownFields());
        }

        public Builder() {
            this.cli_messages = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cli_messages(Map<String, com.bytedance.lark.pb.basic.v1.Message> r100) {
            Internal.checkElementsNotNull(r100);
            this.cli_messages = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Ser2CliMessagesResponse extends ProtoAdapter<Ser2CliMessagesResponse> implements c<Ser2CliMessagesResponse> {
        private final ProtoAdapter<Map<String, com.bytedance.lark.pb.basic.v1.Message>> cli_messages;

        public ProtoAdapter_Ser2CliMessagesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, Ser2CliMessagesResponse.class);
            this.cli_messages = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, com.bytedance.lark.pb.basic.v1.Message.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Ser2CliMessagesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.cli_messages.putAll(this.cli_messages.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Ser2CliMessagesResponse r100) {
            return this.cli_messages.encodedSizeWithTag(1, r100.cli_messages) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Ser2CliMessagesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Ser2CliMessagesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Ser2CliMessagesResponse r101) throws IOException {
            this.cli_messages.encodeWithTag(r100, 1, r101.cli_messages);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Ser2CliMessagesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_Ser2CliMessagesResponse r100 = new ProtoAdapter_Ser2CliMessagesResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cli_messages = Internal.copyOf("cli_messages", this.cli_messages);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Ser2CliMessagesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Ser2CliMessagesResponse(Map<String, com.bytedance.lark.pb.basic.v1.Message> r100) {
        this(r100, ByteString.EMPTY);
    }

    public Ser2CliMessagesResponse(Map<String, com.bytedance.lark.pb.basic.v1.Message> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.cli_messages = Internal.immutableCopyOf("cli_messages", r100);
    }
}
