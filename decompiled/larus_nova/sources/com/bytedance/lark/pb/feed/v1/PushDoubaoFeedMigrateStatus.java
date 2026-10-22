package com.bytedance.lark.pb.feed.v1;

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
public final class PushDoubaoFeedMigrateStatus extends Message<PushDoubaoFeedMigrateStatus, Builder> {
    public static final ProtoAdapter<PushDoubaoFeedMigrateStatus> ADAPTER = null;
    public static final DoubaoFeedMigrateStatus DEFAULT_STATUS = null;
    public static final ProtoAdapter_PushDoubaoFeedMigrateStatus RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DoubaoFeedMigrateStatus status;

    public static final class Builder extends Message.Builder<PushDoubaoFeedMigrateStatus, Builder> implements d<PushDoubaoFeedMigrateStatus> {
        public DoubaoFeedMigrateStatus status;

        @Override // com.squareup.wire.Message.Builder
        public PushDoubaoFeedMigrateStatus build() {
            DoubaoFeedMigrateStatus r100 = this.status;
            if (r100 == null) goto L7;
            return new PushDoubaoFeedMigrateStatus(this.status, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "status"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder status(DoubaoFeedMigrateStatus r100) {
            this.status = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushDoubaoFeedMigrateStatus extends ProtoAdapter<PushDoubaoFeedMigrateStatus> implements c<PushDoubaoFeedMigrateStatus> {
        public ProtoAdapter_PushDoubaoFeedMigrateStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, PushDoubaoFeedMigrateStatus.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushDoubaoFeedMigrateStatus decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.status = DoubaoFeedMigrateStatus.MIGRATE_STATUS_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.status = DoubaoFeedMigrateStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushDoubaoFeedMigrateStatus r100) {
            return DoubaoFeedMigrateStatus.ADAPTER.encodedSizeWithTag(1, r100.status) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushDoubaoFeedMigrateStatus decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushDoubaoFeedMigrateStatus r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushDoubaoFeedMigrateStatus r101) throws IOException {
            DoubaoFeedMigrateStatus.ADAPTER.encodeWithTag(r100, 1, r101.status);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushDoubaoFeedMigrateStatus r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushDoubaoFeedMigrateStatus r100 = new ProtoAdapter_PushDoubaoFeedMigrateStatus();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_STATUS = DoubaoFeedMigrateStatus.MIGRATE_STATUS_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.status = this.status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushDoubaoFeedMigrateStatus.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushDoubaoFeedMigrateStatus(DoubaoFeedMigrateStatus r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushDoubaoFeedMigrateStatus(DoubaoFeedMigrateStatus r100, ByteString r101) {
        super(ADAPTER, r101);
        this.status = r100;
    }
}
