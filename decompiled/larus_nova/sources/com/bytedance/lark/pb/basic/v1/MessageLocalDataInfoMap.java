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
public final class MessageLocalDataInfoMap extends com.squareup.wire.Message<MessageLocalDataInfoMap, Builder> {
    public static final ProtoAdapter<MessageLocalDataInfoMap> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Integer, MessageLocalData> data;

    public static final class Builder extends com.squareup.wire.Message.Builder<MessageLocalDataInfoMap, Builder> {
        public Map<Integer, MessageLocalData> data;

        @Override // com.squareup.wire.Message.Builder
        public MessageLocalDataInfoMap build() {
            return new MessageLocalDataInfoMap(this.data, super.buildUnknownFields());
        }

        public Builder() {
            this.data = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder data(Map<Integer, MessageLocalData> r100) {
            Internal.checkElementsNotNull(r100);
            this.data = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageLocalDataInfoMap extends ProtoAdapter<MessageLocalDataInfoMap> {
        private final ProtoAdapter<Map<Integer, MessageLocalData>> data;

        public ProtoAdapter_MessageLocalDataInfoMap() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageLocalDataInfoMap.class);
            this.data = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, MessageLocalData.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MessageLocalDataInfoMap decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.data.putAll(this.data.decode(r100));
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
        public int encodedSize2(MessageLocalDataInfoMap r100) {
            return this.data.encodedSizeWithTag(1, r100.data) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessageLocalDataInfoMap decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageLocalDataInfoMap r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageLocalDataInfoMap r101) throws IOException {
            this.data.encodeWithTag(r100, 1, r101.data);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageLocalDataInfoMap r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageLocalDataInfoMap();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.data = Internal.copyOf("data", this.data);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageLocalDataInfoMap.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageLocalDataInfoMap(Map<Integer, MessageLocalData> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MessageLocalDataInfoMap(Map<Integer, MessageLocalData> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.data = Internal.immutableCopyOf("data", r100);
    }
}
