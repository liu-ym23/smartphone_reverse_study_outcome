package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TransferFolderInfo extends Message<TransferFolderInfo, Builder> {
    public static final ProtoAdapter<TransferFolderInfo> ADAPTER = null;
    public static final Integer DEFAULT_TOTAL_NUMBER = null;
    public static final Integer DEFAULT_TRANSFERRED_NUMBER = null;
    private static final long serialVersionUID = 0;
    public final Integer total_number;
    public final Integer transferred_number;

    public static final class Builder extends Message.Builder<TransferFolderInfo, Builder> {
        public Integer total_number;
        public Integer transferred_number;

        @Override // com.squareup.wire.Message.Builder
        public TransferFolderInfo build() {
            Integer r100 = this.total_number;
            if (r100 == null) goto L9;
            if (this.transferred_number == null) goto L9;
            return new TransferFolderInfo(this.total_number, this.transferred_number, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "total_number", this.transferred_number, "transferred_number"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder total_number(Integer r100) {
            this.total_number = r100;
            return this;
        }

        public Builder transferred_number(Integer r100) {
            this.transferred_number = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TransferFolderInfo extends ProtoAdapter<TransferFolderInfo> {
        public ProtoAdapter_TransferFolderInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, TransferFolderInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TransferFolderInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.total_number = 0;
            r101.transferred_number = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.total_number = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.transferred_number = ProtoAdapter.INT32.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TransferFolderInfo r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            return (r101.encodedSizeWithTag(1, r100.total_number) + r101.encodedSizeWithTag(2, r100.transferred_number)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TransferFolderInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TransferFolderInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TransferFolderInfo r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.total_number);
            r102.encodeWithTag(r100, 2, r101.transferred_number);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TransferFolderInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TransferFolderInfo();
        DEFAULT_TOTAL_NUMBER = 0;
        DEFAULT_TRANSFERRED_NUMBER = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.total_number = this.total_number;
        r100.transferred_number = this.transferred_number;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TransferFolderInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TransferFolderInfo(Integer r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public TransferFolderInfo(Integer r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.total_number = r100;
        this.transferred_number = r101;
    }
}
