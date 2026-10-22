package com.ss.android.lark.pb.videochat;

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
public final class GetSISettingResponse extends Message<GetSISettingResponse, Builder> {
    public static final ProtoAdapter<GetSISettingResponse> ADAPTER = null;
    public static final Boolean DEFAULT_SUPPORT_SI = null;
    private static final long serialVersionUID = 0;
    public final Boolean msupport_si;
    public final List<Language> msupport_target_lang_list;

    public static final class Builder extends Message.Builder<GetSISettingResponse, Builder> {
        public Boolean msupport_si;
        public List<Language> msupport_target_lang_list;

        @Override // com.squareup.wire.Message.Builder
        public GetSISettingResponse build() {
            return new GetSISettingResponse(this.msupport_si, this.msupport_target_lang_list, super.buildUnknownFields());
        }

        public Builder() {
            this.msupport_target_lang_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder support_si(Boolean r100) {
            this.msupport_si = r100;
            return this;
        }

        public Builder support_target_lang_list(List<Language> r100) {
            Internal.checkElementsNotNull(r100);
            this.msupport_target_lang_list = r100;
            return this;
        }
    }

    public static final class Language extends Message<Language, Builder> {
        public static final ProtoAdapter<Language> ADAPTER = null;
        public static final String DEFAULT_DESCRIPTION = "";
        public static final String DEFAULT_ICON = "";
        public static final String DEFAULT_LANGUAGE = "";
        private static final long serialVersionUID = 0;
        public final String mdescription;
        public final String micon;
        public final String mlanguage;

        public static final class Builder extends Message.Builder<Language, Builder> {
            public String mdescription;
            public String micon;
            public String mlanguage;

            @Override // com.squareup.wire.Message.Builder
            public Language build() {
                return new Language(this.mlanguage, this.mdescription, this.micon, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder description(String r100) {
                this.mdescription = r100;
                return this;
            }

            public Builder icon(String r100) {
                this.micon = r100;
                return this;
            }

            public Builder language(String r100) {
                this.mlanguage = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Language extends ProtoAdapter<Language> {
            public ProtoAdapter_Language() {
                super(FieldEncoding.LENGTH_DELIMITED, Language.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Language decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mlanguage = "";
                r101.mdescription = "";
                r101.micon = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mlanguage = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mdescription = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.micon = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(Language r100) {
                String r101 = r100.mlanguage;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.mdescription;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.micon;
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
            public /* bridge */ /* synthetic */ Language decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Language r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Language r101) throws IOException {
                String r102 = r101.mlanguage;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.mdescription;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.micon;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Language r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Language();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mlanguage = this.mlanguage;
            r100.mdescription = this.mdescription;
            r100.micon = this.micon;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Language.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Language(String r100, String r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Language(String r100, String r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mlanguage = r100;
            this.mdescription = r101;
            this.micon = r102;
        }
    }

    public static final class ProtoAdapter_GetSISettingResponse extends ProtoAdapter<GetSISettingResponse> {
        public ProtoAdapter_GetSISettingResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetSISettingResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetSISettingResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.msupport_si = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.msupport_si = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.msupport_target_lang_list.add(Language.ADAPTER.decode(r100));
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
        public int encodedSize2(GetSISettingResponse r100) {
            Boolean r101 = r100.msupport_si;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + Language.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.msupport_target_lang_list)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetSISettingResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetSISettingResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetSISettingResponse r101) throws IOException {
            Boolean r102 = r101.msupport_si;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            Language.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.msupport_target_lang_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetSISettingResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetSISettingResponse();
        DEFAULT_SUPPORT_SI = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.msupport_si = this.msupport_si;
        r100.msupport_target_lang_list = Internal.copyOf("msupport_target_lang_list", this.msupport_target_lang_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetSISettingResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetSISettingResponse(Boolean r100, List<Language> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetSISettingResponse(Boolean r100, List<Language> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.msupport_si = r100;
        this.msupport_target_lang_list = Internal.immutableCopyOf("msupport_target_lang_list", r101);
    }
}
