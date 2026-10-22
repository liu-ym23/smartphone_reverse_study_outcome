package com.ss.android.lark.pb.chatters;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullUserAgreementRequest extends Message<PullUserAgreementRequest, Builder> {
    public static final ProtoAdapter<PullUserAgreementRequest> ADAPTER = null;
    public static final String DEFAULT_TARGET_USER_ID = "";
    private static final long serialVersionUID = 0;
    public final String mtarget_user_id;
    public final UserAgreementType muser_agreement_type;

    public static final class Builder extends Message.Builder<PullUserAgreementRequest, Builder> {
        public String mtarget_user_id;
        public UserAgreementType muser_agreement_type;

        @Override // com.squareup.wire.Message.Builder
        public PullUserAgreementRequest build() {
            return new PullUserAgreementRequest(this.mtarget_user_id, this.muser_agreement_type, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
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

    public static final class ProtoAdapter_PullUserAgreementRequest extends ProtoAdapter<PullUserAgreementRequest> {
        public ProtoAdapter_PullUserAgreementRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUserAgreementRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullUserAgreementRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mtarget_user_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mtarget_user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.muser_agreement_type = UserAgreementType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
        public int encodedSize2(PullUserAgreementRequest r100) {
            String r101 = r100.mtarget_user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            UserAgreementType r104 = r100.muser_agreement_type;
            if (r104 == null) goto L10;
            r102 = UserAgreementType.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullUserAgreementRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullUserAgreementRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullUserAgreementRequest r101) throws IOException {
            String r102 = r101.mtarget_user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            UserAgreementType r103 = r101.muser_agreement_type;
            if (r103 == null) goto L8;
            UserAgreementType.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullUserAgreementRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUserAgreementRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtarget_user_id = this.mtarget_user_id;
        r100.muser_agreement_type = this.muser_agreement_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullUserAgreementRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullUserAgreementRequest(String r100, UserAgreementType r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PullUserAgreementRequest(String r100, UserAgreementType r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mtarget_user_id = r100;
        this.muser_agreement_type = r101;
    }
}
