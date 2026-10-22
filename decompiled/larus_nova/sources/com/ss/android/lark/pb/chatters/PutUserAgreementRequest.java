package com.ss.android.lark.pb.chatters;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PutUserAgreementRequest extends Message<PutUserAgreementRequest, Builder> {
    public static final ProtoAdapter<PutUserAgreementRequest> ADAPTER = null;
    public static final String DEFAULT_AGREEMENT_VERSION = "";
    public static final String DEFAULT_TARGET_USER_ID = "";
    private static final long serialVersionUID = 0;
    public final String magreement_version;
    public final String mtarget_user_id;
    public final UserAgreementType muser_agreement_type;

    public static final class Builder extends Message.Builder<PutUserAgreementRequest, Builder> {
        public String magreement_version;
        public String mtarget_user_id;
        public UserAgreementType muser_agreement_type;

        @Override // com.squareup.wire.Message.Builder
        public PutUserAgreementRequest build() {
            return new PutUserAgreementRequest(this.mtarget_user_id, this.muser_agreement_type, this.magreement_version, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder agreement_version(String r100) {
            this.magreement_version = r100;
            return this;
        }

        public Builder target_user_id(String r100) {
            this.mtarget_user_id = r100;
            return this;
        }

        public Builder user_agreement_type(UserAgreementType r100) {
            this.muser_agreement_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutUserAgreementRequest extends ProtoAdapter<PutUserAgreementRequest> {
        public ProtoAdapter_PutUserAgreementRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutUserAgreementRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutUserAgreementRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtarget_user_id = "";
            r101.magreement_version = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mtarget_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.muser_agreement_type = UserAgreementType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.magreement_version = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PutUserAgreementRequest r100) {
            String r101 = r100.mtarget_user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            UserAgreementType r104 = r100.muser_agreement_type;
            if (r104 == null) goto L9;
            int r105 = UserAgreementType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.magreement_version;
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
        public /* bridge */ /* synthetic */ PutUserAgreementRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutUserAgreementRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutUserAgreementRequest r101) throws IOException {
            String r102 = r101.mtarget_user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            UserAgreementType r103 = r101.muser_agreement_type;
            if (r103 == null) goto L8;
            UserAgreementType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.magreement_version;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutUserAgreementRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutUserAgreementRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtarget_user_id = this.mtarget_user_id;
        r100.muser_agreement_type = this.muser_agreement_type;
        r100.magreement_version = this.magreement_version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutUserAgreementRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutUserAgreementRequest(String r100, UserAgreementType r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PutUserAgreementRequest(String r100, UserAgreementType r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mtarget_user_id = r100;
        this.muser_agreement_type = r101;
        this.magreement_version = r102;
    }
}
