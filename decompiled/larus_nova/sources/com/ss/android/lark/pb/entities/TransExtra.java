package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class TransExtra extends com.squareup.wire.Message<TransExtra, Builder> {
    public static final ProtoAdapter<TransExtra> ADAPTER = null;
    public static final String DEFAULT_RECEIVER_DEVICE_ID = "";
    public static final String DEFAULT_SENDER_DEVICE_ID = "";
    private static final long serialVersionUID = 0;
    public final String mreceiver_device_id;
    public final String msender_device_id;
    public final TransStatus mstatus;

    public static final class Builder extends com.squareup.wire.Message.Builder<TransExtra, Builder> {
        public String mreceiver_device_id;
        public String msender_device_id;
        public TransStatus mstatus;

        @Override // com.squareup.wire.Message.Builder
        public TransExtra build() {
            return new TransExtra(this.mstatus, this.msender_device_id, this.mreceiver_device_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder receiver_device_id(String r100) {
            this.mreceiver_device_id = r100;
            return this;
        }

        public Builder sender_device_id(String r100) {
            this.msender_device_id = r100;
            return this;
        }

        public Builder status(TransStatus r100) {
            this.mstatus = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TransExtra extends ProtoAdapter<TransExtra> {
        public ProtoAdapter_TransExtra() {
            super(FieldEncoding.LENGTH_DELIMITED, TransExtra.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TransExtra decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msender_device_id = "";
            r101.mreceiver_device_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mstatus = TransStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.msender_device_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mreceiver_device_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(TransExtra r100) {
            TransStatus r101 = r100.mstatus;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = TransStatus.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.msender_device_id;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mreceiver_device_id;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TransExtra decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TransExtra r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TransExtra r101) throws IOException {
            TransStatus r102 = r101.mstatus;
            if (r102 == null) goto L5;
            TransStatus.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.msender_device_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mreceiver_device_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TransExtra r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TransExtra();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mstatus = this.mstatus;
        r100.msender_device_id = this.msender_device_id;
        r100.mreceiver_device_id = this.mreceiver_device_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TransExtra.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TransExtra(TransStatus r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public TransExtra(TransStatus r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mstatus = r100;
        this.msender_device_id = r101;
        this.mreceiver_device_id = r102;
    }
}
