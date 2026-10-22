package com.ss.android.lark.pb.messages;

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
public final class BatchShareMessageResponse extends Message<BatchShareMessageResponse, Builder> {
    public static final ProtoAdapter<BatchShareMessageResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, com.ss.android.lark.pb.entities.Message> mmessages;

    public static final class Builder extends Message.Builder<BatchShareMessageResponse, Builder> {
        public Map<String, com.ss.android.lark.pb.entities.Message> mmessages;

        @Override // com.squareup.wire.Message.Builder
        public BatchShareMessageResponse build() {
            return new BatchShareMessageResponse(this.mmessages, super.buildUnknownFields());
        }

        public Builder() {
            this.mmessages = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder messages(Map<String, com.ss.android.lark.pb.entities.Message> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmessages = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BatchShareMessageResponse extends ProtoAdapter<BatchShareMessageResponse> {
        private final ProtoAdapter<Map<String, com.ss.android.lark.pb.entities.Message>> mmessages;

        public ProtoAdapter_BatchShareMessageResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, BatchShareMessageResponse.class);
            this.mmessages = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, com.ss.android.lark.pb.entities.Message.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BatchShareMessageResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mmessages.putAll(this.mmessages.decode(r100));
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
        public int encodedSize2(BatchShareMessageResponse r100) {
            return this.mmessages.encodedSizeWithTag(1, r100.mmessages) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BatchShareMessageResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BatchShareMessageResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BatchShareMessageResponse r101) throws IOException {
            this.mmessages.encodeWithTag(r100, 1, r101.mmessages);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BatchShareMessageResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BatchShareMessageResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmessages = Internal.copyOf("mmessages", this.mmessages);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BatchShareMessageResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BatchShareMessageResponse(Map<String, com.ss.android.lark.pb.entities.Message> r100) {
        this(r100, ByteString.EMPTY);
    }

    public BatchShareMessageResponse(Map<String, com.ss.android.lark.pb.entities.Message> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mmessages = Internal.immutableCopyOf("mmessages", r100);
    }
}
