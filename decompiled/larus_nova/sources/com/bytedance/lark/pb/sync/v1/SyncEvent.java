package com.bytedance.lark.pb.sync.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SyncEvent extends Message<SyncEvent, Builder> {
    public static final ProtoAdapter<SyncEvent> ADAPTER = null;
    public static final ByteString DEFAULT_DATA = null;
    public static final SyncEventType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final ByteString data;
    public final SyncEventType type;

    public static final class Builder extends Message.Builder<SyncEvent, Builder> {
        public ByteString data;
        public SyncEventType type;

        @Override // com.squareup.wire.Message.Builder
        public SyncEvent build() {
            SyncEventType r100 = this.type;
            if (r100 == null) goto L7;
            return new SyncEvent(this.type, this.data, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder data(ByteString r100) {
            this.data = r100;
            return this;
        }

        public Builder type(SyncEventType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SyncEvent extends ProtoAdapter<SyncEvent> {
        public ProtoAdapter_SyncEvent() {
            super(FieldEncoding.LENGTH_DELIMITED, SyncEvent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SyncEvent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.type = SyncEventType.UNKNOWN;
            r101.data = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.type = SyncEventType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SyncEvent r100) {
            int r101 = SyncEventType.ADAPTER.encodedSizeWithTag(1, r100.type);
            ByteString r102 = r100.data;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BYTES.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SyncEvent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SyncEvent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SyncEvent r101) throws IOException {
            SyncEventType.ADAPTER.encodeWithTag(r100, 1, r101.type);
            ByteString r102 = r101.data;
            if (r102 == null) goto L5;
            ProtoAdapter.BYTES.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SyncEvent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SyncEvent();
        DEFAULT_TYPE = SyncEventType.UNKNOWN;
        DEFAULT_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type = this.type;
        r100.data = this.data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SyncEvent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SyncEvent(SyncEventType r100, ByteString r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SyncEvent(SyncEventType r100, ByteString r101, ByteString r102) {
        super(ADAPTER, r102);
        this.type = r100;
        this.data = r101;
    }
}
