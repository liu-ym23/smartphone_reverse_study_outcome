package com.bytedance.lark.pb.bitable.v1;

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

/* JADX INFO: loaded from: classes20.dex */
public final class BitableRecordSendDataRequest extends Message<BitableRecordSendDataRequest, Builder> {
    public static final ProtoAdapter<BitableRecordSendDataRequest> ADAPTER = null;
    public static final String DEFAULT_CONTAINER_ID = "";
    public static final String DEFAULT_TOKEN = "";
    public static final ProtoAdapter_BitableRecordSendDataRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String container_id;
    public final List<SimpleRecordOperation> operations;
    public final String token;

    public static final class Builder extends Message.Builder<BitableRecordSendDataRequest, Builder> implements d<BitableRecordSendDataRequest> {
        public String container_id;
        public List<SimpleRecordOperation> operations;
        public String token;

        @Override // com.squareup.wire.Message.Builder
        public BitableRecordSendDataRequest build() {
            return new BitableRecordSendDataRequest(this.container_id, this.token, this.operations, super.buildUnknownFields());
        }

        public Builder() {
            this.operations = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder container_id(String r100) {
            this.container_id = r100;
            return this;
        }

        public Builder operations(List<SimpleRecordOperation> r100) {
            Internal.checkElementsNotNull(r100);
            this.operations = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BitableRecordSendDataRequest extends ProtoAdapter<BitableRecordSendDataRequest> implements c<BitableRecordSendDataRequest> {
        public ProtoAdapter_BitableRecordSendDataRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, BitableRecordSendDataRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BitableRecordSendDataRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.container_id = "";
            r101.token = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.container_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.operations.add(SimpleRecordOperation.ADAPTER.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BitableRecordSendDataRequest r100) {
            String r101 = r100.container_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.token;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + SimpleRecordOperation.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.operations)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BitableRecordSendDataRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BitableRecordSendDataRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BitableRecordSendDataRequest r101) throws IOException {
            String r102 = r101.container_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.token;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            SimpleRecordOperation.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.operations);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BitableRecordSendDataRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_BitableRecordSendDataRequest r100 = new ProtoAdapter_BitableRecordSendDataRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.container_id = this.container_id;
        r100.token = this.token;
        r100.operations = Internal.copyOf("operations", this.operations);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BitableRecordSendDataRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BitableRecordSendDataRequest(String r100, String r101, List<SimpleRecordOperation> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public BitableRecordSendDataRequest(String r100, String r101, List<SimpleRecordOperation> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.container_id = r100;
        this.token = r101;
        this.operations = Internal.immutableCopyOf("operations", r102);
    }
}
