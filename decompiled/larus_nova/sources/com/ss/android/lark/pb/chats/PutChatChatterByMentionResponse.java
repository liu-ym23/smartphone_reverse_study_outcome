package com.ss.android.lark.pb.chats;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PutChatChatterByMentionResponse extends Message<PutChatChatterByMentionResponse, Builder> {
    public static final ProtoAdapter<PutChatChatterByMentionResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, PutChatChatterByMentionResult> mresults;

    public static final class Builder extends Message.Builder<PutChatChatterByMentionResponse, Builder> {
        public Map<Long, PutChatChatterByMentionResult> mresults;

        @Override // com.squareup.wire.Message.Builder
        public PutChatChatterByMentionResponse build() {
            return new PutChatChatterByMentionResponse(this.mresults, super.buildUnknownFields());
        }

        public Builder() {
            this.mresults = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder results(Map<Long, PutChatChatterByMentionResult> r100) {
            Internal.checkElementsNotNull(r100);
            this.mresults = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutChatChatterByMentionResponse extends ProtoAdapter<PutChatChatterByMentionResponse> {
        private final ProtoAdapter<Map<Long, PutChatChatterByMentionResult>> mresults;

        public ProtoAdapter_PutChatChatterByMentionResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PutChatChatterByMentionResponse.class);
            this.mresults = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, PutChatChatterByMentionResult.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutChatChatterByMentionResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mresults.putAll(this.mresults.decode(r100));
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
        public int encodedSize2(PutChatChatterByMentionResponse r100) {
            return this.mresults.encodedSizeWithTag(1, r100.mresults) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutChatChatterByMentionResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutChatChatterByMentionResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutChatChatterByMentionResponse r101) throws IOException {
            this.mresults.encodeWithTag(r100, 1, r101.mresults);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutChatChatterByMentionResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutChatChatterByMentionResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mresults = Internal.copyOf("mresults", this.mresults);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutChatChatterByMentionResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutChatChatterByMentionResponse(Map<Long, PutChatChatterByMentionResult> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PutChatChatterByMentionResponse(Map<Long, PutChatChatterByMentionResult> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mresults = Internal.immutableCopyOf("mresults", r100);
    }
}
