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
public final class CheckChattersInChatResponse extends Message<CheckChattersInChatResponse, Builder> {
    public static final ProtoAdapter<CheckChattersInChatResponse> ADAPTER = null;
    public static final ProtoAdapter_CheckChattersInChatResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Boolean> chatters;

    public static final class Builder extends Message.Builder<CheckChattersInChatResponse, Builder> implements d<CheckChattersInChatResponse> {
        public Map<String, Boolean> chatters;

        @Override // com.squareup.wire.Message.Builder
        public CheckChattersInChatResponse build() {
            return new CheckChattersInChatResponse(this.chatters, super.buildUnknownFields());
        }

        public Builder() {
            this.chatters = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatters(Map<String, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatters = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckChattersInChatResponse extends ProtoAdapter<CheckChattersInChatResponse> implements c<CheckChattersInChatResponse> {
        private final ProtoAdapter<Map<String, Boolean>> chatters;

        public ProtoAdapter_CheckChattersInChatResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckChattersInChatResponse.class);
            this.chatters = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BOOL);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CheckChattersInChatResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.chatters.putAll(this.chatters.decode(r100));
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
        public int encodedSize2(CheckChattersInChatResponse r100) {
            return this.chatters.encodedSizeWithTag(1, r100.chatters) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CheckChattersInChatResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CheckChattersInChatResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CheckChattersInChatResponse r101) throws IOException {
            this.chatters.encodeWithTag(r100, 1, r101.chatters);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CheckChattersInChatResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CheckChattersInChatResponse r100 = new ProtoAdapter_CheckChattersInChatResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chatters = Internal.copyOf("chatters", this.chatters);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CheckChattersInChatResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CheckChattersInChatResponse(Map<String, Boolean> r100) {
        this(r100, ByteString.EMPTY);
    }

    public CheckChattersInChatResponse(Map<String, Boolean> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.chatters = Internal.immutableCopyOf("chatters", r100);
    }
}
