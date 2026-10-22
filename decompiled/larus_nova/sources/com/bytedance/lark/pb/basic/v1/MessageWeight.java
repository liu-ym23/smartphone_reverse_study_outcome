package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MessageWeight extends com.squareup.wire.Message<MessageWeight, Builder> {
    public static final ProtoAdapter<MessageWeight> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Integer, DisplayWeight> type2weights;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageWeight, Builder> {
        public Map<Integer, DisplayWeight> type2weights;

        @Override // com.squareup.wire.Message.Builder
        public MessageWeight build() {
            return new MessageWeight(this.type2weights, super.buildUnknownFields());
        }

        public Builder() {
            this.type2weights = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder type2weights(Map<Integer, DisplayWeight> r100) {
            Internal.checkElementsNotNull(r100);
            this.type2weights = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageWeight extends ProtoAdapter<MessageWeight> {
        private final ProtoAdapter<Map<Integer, DisplayWeight>> type2weights;

        public ProtoAdapter_MessageWeight() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageWeight.class);
            this.type2weights = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, DisplayWeight.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageWeight decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.type2weights.putAll(this.type2weights.decode(r100));
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
        public int encodedSize2(MessageWeight r100) {
            return this.type2weights.encodedSizeWithTag(1, r100.type2weights) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessageWeight decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageWeight r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageWeight r101) throws IOException {
            this.type2weights.encodeWithTag(r100, 1, r101.type2weights);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageWeight r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageWeight();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type2weights = Internal.copyOf("type2weights", this.type2weights);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageWeight.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageWeight(Map<Integer, DisplayWeight> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MessageWeight(Map<Integer, DisplayWeight> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.type2weights = Internal.immutableCopyOf("type2weights", r100);
    }
}
