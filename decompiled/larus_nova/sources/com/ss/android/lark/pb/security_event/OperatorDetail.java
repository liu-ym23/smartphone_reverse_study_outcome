package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class OperatorDetail extends Message<OperatorDetail, Builder> {
    public static final ProtoAdapter<OperatorDetail> ADAPTER = null;
    public static final String DEFAULT_OPERATORNAME = "";
    private static final long serialVersionUID = 0;
    public final String mOperatorName;

    public static final class Builder extends Message.Builder<OperatorDetail, Builder> {
        public String mOperatorName;

        @Override // com.squareup.wire.Message.Builder
        public OperatorDetail build() {
            return new OperatorDetail(this.mOperatorName, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder OperatorName(String r100) {
            this.mOperatorName = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_OperatorDetail extends ProtoAdapter<OperatorDetail> {
        public ProtoAdapter_OperatorDetail() {
            super(FieldEncoding.LENGTH_DELIMITED, OperatorDetail.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public OperatorDetail decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mOperatorName = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mOperatorName = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(OperatorDetail r100) {
            String r101 = r100.mOperatorName;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ OperatorDetail decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(OperatorDetail r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, OperatorDetail r101) throws IOException {
            String r102 = r101.mOperatorName;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OperatorDetail r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_OperatorDetail();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mOperatorName = this.mOperatorName;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return OperatorDetail.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public OperatorDetail(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public OperatorDetail(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mOperatorName = r100;
    }
}
