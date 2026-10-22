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
public final class CheckPutChatChatterResponse extends Message<CheckPutChatChatterResponse, Builder> {
    public static final ProtoAdapter<CheckPutChatChatterResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, CheckPutChatChatterResult> mresults;

    public static final class Builder extends Message.Builder<CheckPutChatChatterResponse, Builder> {
        public Map<Long, CheckPutChatChatterResult> mresults;

        @Override // com.squareup.wire.Message.Builder
        public CheckPutChatChatterResponse build() {
            return new CheckPutChatChatterResponse(this.mresults, super.buildUnknownFields());
        }

        public Builder() {
            this.mresults = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder results(Map<Long, CheckPutChatChatterResult> r100) {
            Internal.checkElementsNotNull(r100);
            this.mresults = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CheckPutChatChatterResponse extends ProtoAdapter<CheckPutChatChatterResponse> {
        private final ProtoAdapter<Map<Long, CheckPutChatChatterResult>> mresults;

        public ProtoAdapter_CheckPutChatChatterResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckPutChatChatterResponse.class);
            this.mresults = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, CheckPutChatChatterResult.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CheckPutChatChatterResponse decode(ProtoReader r100) throws IOException {
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
        public int encodedSize2(CheckPutChatChatterResponse r100) {
            return this.mresults.encodedSizeWithTag(1, r100.mresults) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CheckPutChatChatterResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CheckPutChatChatterResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CheckPutChatChatterResponse r101) throws IOException {
            this.mresults.encodeWithTag(r100, 1, r101.mresults);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CheckPutChatChatterResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CheckPutChatChatterResponse();
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
        return CheckPutChatChatterResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CheckPutChatChatterResponse(Map<Long, CheckPutChatChatterResult> r100) {
        this(r100, ByteString.EMPTY);
    }

    public CheckPutChatChatterResponse(Map<Long, CheckPutChatChatterResult> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mresults = Internal.immutableCopyOf("mresults", r100);
    }
}
