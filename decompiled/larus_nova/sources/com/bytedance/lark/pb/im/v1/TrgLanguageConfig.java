package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TrgLanguageConfig extends Message<TrgLanguageConfig, Builder> {
    public static final ProtoAdapter<TrgLanguageConfig> ADAPTER = null;
    public static final String DEFAULT_DEFAULT_LOCALE = "en_us";
    public static final String DEFAULT_LANGUAGE = "";
    public static final String DEFAULT_TRANSLATION_DOC = "";
    private static final long serialVersionUID = 0;
    public final String default_locale;
    public final Map<String, String> i18n_language;
    public final String language;
    public final String translation_doc;

    public static final class Builder extends Message.Builder<TrgLanguageConfig, Builder> {
        public String default_locale;
        public Map<String, String> i18n_language;
        public String language;
        public String translation_doc;

        @Override // com.squareup.wire.Message.Builder
        public TrgLanguageConfig build() {
            String r100 = this.default_locale;
            if (r100 == null) goto L11;
            if (this.language == null) goto L11;
            if (this.translation_doc == null) goto L11;
            return new TrgLanguageConfig(this.i18n_language, this.default_locale, this.language, this.translation_doc, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "default_locale", this.language, "language", this.translation_doc, "translation_doc"});
        }

        public Builder() {
            this.i18n_language = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder default_locale(String r100) {
            this.default_locale = r100;
            return this;
        }

        public Builder i18n_language(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.i18n_language = r100;
            return this;
        }

        public Builder language(String r100) {
            this.language = r100;
            return this;
        }

        public Builder translation_doc(String r100) {
            this.translation_doc = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TrgLanguageConfig extends ProtoAdapter<TrgLanguageConfig> {
        private final ProtoAdapter<Map<String, String>> i18n_language;

        public ProtoAdapter_TrgLanguageConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, TrgLanguageConfig.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.i18n_language = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TrgLanguageConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.default_locale = "en_us";
            r101.language = "";
            r101.translation_doc = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.i18n_language.putAll(this.i18n_language.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.default_locale = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.translation_doc = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(TrgLanguageConfig r100) {
            int r101 = this.i18n_language.encodedSizeWithTag(1, r100.i18n_language);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return (((r101 + r102.encodedSizeWithTag(2, r100.default_locale)) + r102.encodedSizeWithTag(3, r100.language)) + r102.encodedSizeWithTag(4, r100.translation_doc)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ TrgLanguageConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TrgLanguageConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TrgLanguageConfig r101) throws IOException {
            this.i18n_language.encodeWithTag(r100, 1, r101.i18n_language);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.default_locale);
            r102.encodeWithTag(r100, 3, r101.language);
            r102.encodeWithTag(r100, 4, r101.translation_doc);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TrgLanguageConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TrgLanguageConfig();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.i18n_language = Internal.copyOf("i18n_language", this.i18n_language);
        r100.default_locale = this.default_locale;
        r100.language = this.language;
        r100.translation_doc = this.translation_doc;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TrgLanguageConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public TrgLanguageConfig(Map<String, String> r100, String r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TrgLanguageConfig(Map<String, String> r100, String r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.i18n_language = Internal.immutableCopyOf("i18n_language", r100);
        this.default_locale = r101;
        this.language = r102;
        this.translation_doc = r103;
    }
}
