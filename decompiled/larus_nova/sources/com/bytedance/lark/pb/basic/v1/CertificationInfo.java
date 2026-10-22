package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CertificationInfo extends com.squareup.wire.Message<CertificationInfo, Builder> {
    public static final ProtoAdapter<CertificationInfo> ADAPTER = null;
    public static final CertificateStatus DEFAULT_CERTIFICATE_STATUS = null;
    public static final Boolean DEFAULT_IS_SHOW_CERT_SIGN = null;
    private static final long serialVersionUID = 0;
    public final CertificateStatus certificate_status;
    public final Boolean is_show_cert_sign;

    public static final class Builder extends com.squareup.wire.Message.Builder<CertificationInfo, Builder> {
        public CertificateStatus certificate_status;
        public Boolean is_show_cert_sign;

        @Override // com.squareup.wire.Message.Builder
        public CertificationInfo build() {
            return new CertificationInfo(this.is_show_cert_sign, this.certificate_status, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder certificate_status(CertificateStatus r100) {
            this.certificate_status = r100;
            return this;
        }

        public Builder is_show_cert_sign(Boolean r100) {
            this.is_show_cert_sign = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CertificationInfo extends ProtoAdapter<CertificationInfo> {
        public ProtoAdapter_CertificationInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, CertificationInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CertificationInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_show_cert_sign = Boolean.FALSE;
            r101.certificate_status = CertificateStatus.UNCERTIFICATED;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.is_show_cert_sign = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.certificate_status = CertificateStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(CertificationInfo r100) {
            Boolean r101 = r100.is_show_cert_sign;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            CertificateStatus r104 = r100.certificate_status;
            if (r104 == null) goto L10;
            r102 = CertificateStatus.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CertificationInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CertificationInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CertificationInfo r101) throws IOException {
            Boolean r102 = r101.is_show_cert_sign;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            CertificateStatus r103 = r101.certificate_status;
            if (r103 == null) goto L8;
            CertificateStatus.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CertificationInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CertificationInfo();
        DEFAULT_IS_SHOW_CERT_SIGN = Boolean.FALSE;
        DEFAULT_CERTIFICATE_STATUS = CertificateStatus.UNCERTIFICATED;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_show_cert_sign = this.is_show_cert_sign;
        r100.certificate_status = this.certificate_status;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CertificationInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public CertificationInfo(Boolean r100, CertificateStatus r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CertificationInfo(Boolean r100, CertificateStatus r101, ByteString r102) {
        super(ADAPTER, r102);
        this.is_show_cert_sign = r100;
        this.certificate_status = r101;
    }
}
