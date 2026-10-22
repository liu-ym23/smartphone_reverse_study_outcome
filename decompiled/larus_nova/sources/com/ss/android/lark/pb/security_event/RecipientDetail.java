package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class RecipientDetail extends Message<RecipientDetail, Builder> {
    public static final ProtoAdapter<RecipientDetail> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final PermissionActionType mPermissionActionType;

    public static final class Builder extends Message.Builder<RecipientDetail, Builder> {
        public PermissionActionType mPermissionActionType;

        @Override // com.squareup.wire.Message.Builder
        public RecipientDetail build() {
            return new RecipientDetail(this.mPermissionActionType, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder PermissionActionType(PermissionActionType r100) {
            this.mPermissionActionType = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RecipientDetail extends ProtoAdapter<RecipientDetail> {
        public ProtoAdapter_RecipientDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, RecipientDetail.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RecipientDetail decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.mPermissionActionType = PermissionActionType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
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
        public int encodedSize2(RecipientDetail r100) {
            PermissionActionType r101 = r100.mPermissionActionType;
            if (r101 == null) goto L5;
            int r102 = PermissionActionType.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RecipientDetail decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RecipientDetail r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RecipientDetail r101) throws IOException {
            PermissionActionType r102 = r101.mPermissionActionType;
            if (r102 == null) goto L5;
            PermissionActionType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecipientDetail r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RecipientDetail();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mPermissionActionType = this.mPermissionActionType;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RecipientDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RecipientDetail(PermissionActionType r100) {
        this(r100, ByteString.EMPTY);
    }

    public RecipientDetail(PermissionActionType r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mPermissionActionType = r100;
    }
}
