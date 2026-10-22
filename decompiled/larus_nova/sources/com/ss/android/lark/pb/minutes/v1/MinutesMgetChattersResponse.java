package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes37.dex */
public final class MinutesMgetChattersResponse extends Message<MinutesMgetChattersResponse, Builder> {
    public static final ProtoAdapter<MinutesMgetChattersResponse> ADAPTER = null;
    public static final ProtoAdapter_MinutesMgetChattersResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<MinutesChatter> chatters;

    public static final class Builder extends Message.Builder<MinutesMgetChattersResponse, Builder> implements d<MinutesMgetChattersResponse> {
        public List<MinutesChatter> chatters;

        @Override // com.squareup.wire.Message.Builder
        public MinutesMgetChattersResponse build() {
            return new MinutesMgetChattersResponse(this.chatters, super.buildUnknownFields());
        }

        public Builder() {
            this.chatters = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatters(List<MinutesChatter> r100) {
            Internal.checkElementsNotNull(r100);
            this.chatters = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesMgetChattersResponse extends ProtoAdapter<MinutesMgetChattersResponse> implements c<MinutesMgetChattersResponse> {
        public ProtoAdapter_MinutesMgetChattersResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesMgetChattersResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MinutesMgetChattersResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.chatters.add(MinutesChatter.ADAPTER.decode(r100));
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
        public int encodedSize2(MinutesMgetChattersResponse r100) {
            return MinutesChatter.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.chatters) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MinutesMgetChattersResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MinutesMgetChattersResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MinutesMgetChattersResponse r101) throws IOException {
            MinutesChatter.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.chatters);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MinutesMgetChattersResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MinutesMgetChattersResponse r100 = new ProtoAdapter_MinutesMgetChattersResponse();
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
        return MinutesMgetChattersResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MinutesMgetChattersResponse(List<MinutesChatter> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MinutesMgetChattersResponse(List<MinutesChatter> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.chatters = Internal.immutableCopyOf("chatters", r100);
    }
}
