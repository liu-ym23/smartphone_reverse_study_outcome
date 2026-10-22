package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class I18nInfo extends com.squareup.wire.Message<I18nInfo, Builder> {
    public static final ProtoAdapter<I18nInfo> ADAPTER = null;
    public static final Boolean DEFAULT_IS_I18N_MESSAGE = null;
    public static final String DEFAULT_LOCALE = "zh_cn";
    private static final long serialVersionUID = 0;
    public final Map<String, String> mcontent_language;
    public final Boolean mis_i18n_message;
    public final String mlocale;
    public final Map<String, LocaleInfo> mlocale_info;

    public static final class Builder extends com.squareup.wire.Message.Builder<I18nInfo, Builder> {
        public Map<String, String> mcontent_language;
        public Boolean mis_i18n_message;
        public String mlocale;
        public Map<String, LocaleInfo> mlocale_info;

        @Override // com.squareup.wire.Message.Builder
        public I18nInfo build() {
            return new I18nInfo(this.mis_i18n_message, this.mlocale, this.mcontent_language, this.mlocale_info, super.buildUnknownFields());
        }

        public Builder() {
            this.mcontent_language = Internal.newMutableMap();
            this.mlocale_info = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder content_language(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mcontent_language = r100;
            return this;
        }

        public Builder is_i18n_message(Boolean r100) {
            this.mis_i18n_message = r100;
            return this;
        }

        public Builder locale(String r100) {
            this.mlocale = r100;
            return this;
        }

        public Builder locale_info(Map<String, LocaleInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mlocale_info = r100;
            return this;
        }
    }

    public static final class LocaleInfo extends com.squareup.wire.Message<LocaleInfo, Builder> {
        public static final ProtoAdapter<LocaleInfo> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mcontent_languages;

        public static final class Builder extends com.squareup.wire.Message.Builder<LocaleInfo, Builder> {
            public List<String> mcontent_languages;

            @Override // com.squareup.wire.Message.Builder
            public LocaleInfo build() {
                return new LocaleInfo(this.mcontent_languages, super.buildUnknownFields());
            }

            public Builder() {
                this.mcontent_languages = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content_languages(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mcontent_languages = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_LocaleInfo extends ProtoAdapter<LocaleInfo> {
            public ProtoAdapter_LocaleInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, LocaleInfo.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public LocaleInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mcontent_languages.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(LocaleInfo r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.mcontent_languages) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ LocaleInfo decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(LocaleInfo r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, LocaleInfo r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.mcontent_languages);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, LocaleInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_LocaleInfo();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mcontent_languages = Internal.copyOf("mcontent_languages", this.mcontent_languages);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return LocaleInfo.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public LocaleInfo(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public LocaleInfo(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mcontent_languages = Internal.immutableCopyOf("mcontent_languages", r100);
        }
    }

    public static final class ProtoAdapter_I18nInfo extends ProtoAdapter<I18nInfo> {
        private final ProtoAdapter<Map<String, String>> mcontent_language;
        private final ProtoAdapter<Map<String, LocaleInfo>> mlocale_info;

        public ProtoAdapter_I18nInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, I18nInfo.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mcontent_language = ProtoAdapter.newMapAdapter(r100, r100);
            this.mlocale_info = ProtoAdapter.newMapAdapter(r100, LocaleInfo.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public I18nInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mis_i18n_message = Boolean.FALSE;
            r101.mlocale = "zh_cn";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mis_i18n_message = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mlocale = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mcontent_language.putAll(this.mcontent_language.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mlocale_info.putAll(this.mlocale_info.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(I18nInfo r100) {
            Boolean r101 = r100.mis_i18n_message;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mlocale;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return (((r103 + r102) + this.mcontent_language.encodedSizeWithTag(3, r100.mcontent_language)) + this.mlocale_info.encodedSizeWithTag(4, r100.mlocale_info)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ I18nInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(I18nInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, I18nInfo r101) throws IOException {
            Boolean r102 = r101.mis_i18n_message;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mlocale;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            this.mcontent_language.encodeWithTag(r100, 3, r101.mcontent_language);
            this.mlocale_info.encodeWithTag(r100, 4, r101.mlocale_info);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, I18nInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_I18nInfo();
        DEFAULT_IS_I18N_MESSAGE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mis_i18n_message = this.mis_i18n_message;
        r100.mlocale = this.mlocale;
        r100.mcontent_language = Internal.copyOf("mcontent_language", this.mcontent_language);
        r100.mlocale_info = Internal.copyOf("mlocale_info", this.mlocale_info);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return I18nInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public I18nInfo(Boolean r100, String r101, Map<String, String> r102, Map<String, LocaleInfo> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public I18nInfo(Boolean r100, String r101, Map<String, String> r102, Map<String, LocaleInfo> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mis_i18n_message = r100;
        this.mlocale = r101;
        this.mcontent_language = Internal.immutableCopyOf("mcontent_language", r102);
        this.mlocale_info = Internal.immutableCopyOf("mlocale_info", r103);
    }
}
