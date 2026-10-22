package com.ss.android.lark.pb.chatters;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullUserAgreementResponse extends Message<PullUserAgreementResponse, Builder> {
    public static final ProtoAdapter<PullUserAgreementResponse> ADAPTER = null;
    public static final String DEFAULT_AGREEMENT_VERSION = "";
    public static final Boolean DEFAULT_IS_AGREED = null;
    public static final Boolean DEFAULT_IS_NECESSARY = null;
    private static final long serialVersionUID = 0;
    public final String magreement_version;
    public final Boolean mis_agreed;
    public final Boolean mis_necessary;
    public final UserAgreement muser_agreement;

    public static final class Builder extends Message.Builder<PullUserAgreementResponse, Builder> {
        public String magreement_version;
        public Boolean mis_agreed;
        public Boolean mis_necessary;
        public UserAgreement muser_agreement;

        @Override // com.squareup.wire.Message.Builder
        public PullUserAgreementResponse build() {
            return new PullUserAgreementResponse(this.mis_necessary, this.mis_agreed, this.muser_agreement, this.magreement_version, super.buildUnknownFields());
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

        public Builder is_agreed(Boolean r100) {
            this.mis_agreed = r100;
            return this;
        }

        public Builder is_necessary(Boolean r100) {
            this.mis_necessary = r100;
            return this;
        }

        public Builder user_agreement(UserAgreement r100) {
            this.muser_agreement = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullUserAgreementResponse extends ProtoAdapter<PullUserAgreementResponse> {
        public ProtoAdapter_PullUserAgreementResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullUserAgreementResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullUserAgreementResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            Boolean r102 = Boolean.FALSE;
            r101.mis_necessary = r102;
            r101.mis_agreed = r102;
            r101.magreement_version = "";
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            if (r104 != 1) goto L8;
            r101.mis_necessary = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.mis_agreed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.muser_agreement = UserAgreement.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L13;
            r101.magreement_version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullUserAgreementResponse r100) {
            Boolean r101 = r100.mis_necessary;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mis_agreed;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            UserAgreement r107 = r100.muser_agreement;
            if (r107 == null) goto L13;
            int r108 = UserAgreement.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.magreement_version;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullUserAgreementResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullUserAgreementResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullUserAgreementResponse r101) throws IOException {
            Boolean r102 = r101.mis_necessary;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mis_agreed;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            UserAgreement r104 = r101.muser_agreement;
            if (r104 == null) goto L11;
            UserAgreement.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.magreement_version;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullUserAgreementResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class UserAgreement extends Message<UserAgreement, Builder> {
        public static final ProtoAdapter<UserAgreement> ADAPTER = null;
        public static final String DEFAULT_TITLE = "";
        private static final long serialVersionUID = 0;
        public final List<UserAgreementContent> mcontent;
        public final String mtitle;

        public static final class Builder extends Message.Builder<UserAgreement, Builder> {
            public List<UserAgreementContent> mcontent;
            public String mtitle;

            @Override // com.squareup.wire.Message.Builder
            public UserAgreement build() {
                return new UserAgreement(this.mtitle, this.mcontent, super.buildUnknownFields());
            }

            public Builder() {
                this.mcontent = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder content(List<UserAgreementContent> r100) {
                Internal.checkElementsNotNull(r100);
                this.mcontent = r100;
                return this;
            }

            public Builder title(String r100) {
                this.mtitle = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UserAgreement extends ProtoAdapter<UserAgreement> {
            public ProtoAdapter_UserAgreement() {
                super(FieldEncoding.LENGTH_DELIMITED, UserAgreement.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UserAgreement decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mtitle = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mtitle = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mcontent.add(UserAgreementContent.ADAPTER.decode(r100));
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
            public int encodedSize2(UserAgreement r100) {
                String r101 = r100.mtitle;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return (r102 + UserAgreementContent.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.mcontent)) + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UserAgreement decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UserAgreement r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UserAgreement r101) throws IOException {
                String r102 = r101.mtitle;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                UserAgreementContent.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.mcontent);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserAgreement r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final class UserAgreementContent extends Message<UserAgreementContent, Builder> {
            public static final ProtoAdapter<UserAgreementContent> ADAPTER = null;
            public static final String DEFAULT_LINK_URL = "";
            public static final String DEFAULT_TEXT = "";
            private static final long serialVersionUID = 0;
            public final String mlink_url;
            public final String mtext;

            public static final class Builder extends Message.Builder<UserAgreementContent, Builder> {
                public String mlink_url;
                public String mtext;

                @Override // com.squareup.wire.Message.Builder
                public UserAgreementContent build() {
                    return new UserAgreementContent(this.mtext, this.mlink_url, super.buildUnknownFields());
                }

                public Builder() {
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder link_url(String r100) {
                    this.mlink_url = r100;
                    return this;
                }

                public Builder text(String r100) {
                    this.mtext = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_UserAgreementContent extends ProtoAdapter<UserAgreementContent> {
                public ProtoAdapter_UserAgreementContent() {
                    super(FieldEncoding.LENGTH_DELIMITED, UserAgreementContent.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public UserAgreementContent decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.mtext = "";
                    r101.mlink_url = "";
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L12;
                    if (r103 != 1) goto L8;
                    r101.mtext = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L9;
                    r101.mlink_url = ProtoAdapter.STRING.decode(r100);
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
                public int encodedSize2(UserAgreementContent r100) {
                    String r101 = r100.mtext;
                    int r102 = 0;
                    if (r101 == null) goto L5;
                    int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
                L6:
                    String r104 = r100.mlink_url;
                    if (r104 == null) goto L10;
                    r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
                L10:
                    return (r103 + r102) + r100.unknownFields().size();
                L5:
                    r103 = 0;
                    goto L6
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ UserAgreementContent decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(UserAgreementContent r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, UserAgreementContent r101) throws IOException {
                    String r102 = r101.mtext;
                    if (r102 == null) goto L5;
                    ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
                L5:
                    String r103 = r101.mlink_url;
                    if (r103 == null) goto L8;
                    ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
                L8:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UserAgreementContent r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_UserAgreementContent();
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.mtext = this.mtext;
                r100.mlink_url = this.mlink_url;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return UserAgreementContent.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public UserAgreementContent(String r100, String r101) {
                this(r100, r101, ByteString.EMPTY);
            }

            public UserAgreementContent(String r100, String r101, ByteString r102) {
                super(ADAPTER, r102);
                this.mtext = r100;
                this.mlink_url = r101;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UserAgreement();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtitle = this.mtitle;
            r100.mcontent = Internal.copyOf("mcontent", this.mcontent);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UserAgreement.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public UserAgreement(String r100, List<UserAgreementContent> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public UserAgreement(String r100, List<UserAgreementContent> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mtitle = r100;
            this.mcontent = Internal.immutableCopyOf("mcontent", r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullUserAgreementResponse();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_NECESSARY = r100;
        DEFAULT_IS_AGREED = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mis_necessary = this.mis_necessary;
        r100.mis_agreed = this.mis_agreed;
        r100.muser_agreement = this.muser_agreement;
        r100.magreement_version = this.magreement_version;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullUserAgreementResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullUserAgreementResponse(Boolean r100, Boolean r101, UserAgreement r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PullUserAgreementResponse(Boolean r100, Boolean r101, UserAgreement r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mis_necessary = r100;
        this.mis_agreed = r101;
        this.muser_agreement = r102;
        this.magreement_version = r103;
    }
}
