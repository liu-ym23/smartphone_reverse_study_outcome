package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.DisplayRule;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.heytap.mcssdk.constant.b;
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
public final class SrcLanguageConfig extends Message<SrcLanguageConfig, Builder> {
    public static final ProtoAdapter<SrcLanguageConfig> ADAPTER = null;
    public static final String DEFAULT_DEFAULT_LOCALE = "en_us";
    public static final String DEFAULT_LANGUAGE = "";
    public static final DisplayRule DEFAULT_RULE = null;
    public static final Integer DEFAULT_SCOPES = null;
    private static final long serialVersionUID = 0;
    public final String default_locale;
    public final Map<String, String> i18n_language;
    public final String language;
    public final DisplayRule rule;
    public final Integer scopes;

    public static final class Builder extends Message.Builder<SrcLanguageConfig, Builder> {
        public String default_locale;
        public Map<String, String> i18n_language;
        public String language;
        public DisplayRule rule;
        public Integer scopes;

        @Override // com.squareup.wire.Message.Builder
        public SrcLanguageConfig build() {
            String r100 = this.default_locale;
            if (r100 == null) goto L13;
            if (this.language == null) goto L13;
            if (this.scopes == null) goto L13;
            if (this.rule == null) goto L13;
            return new SrcLanguageConfig(this.i18n_language, this.default_locale, this.language, this.scopes, this.rule, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "default_locale", this.language, "language", this.scopes, ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, this.rule, b.f276366p});
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

        public Builder rule(DisplayRule r100) {
            this.rule = r100;
            return this;
        }

        public Builder scopes(Integer r100) {
            this.scopes = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SrcLanguageConfig extends ProtoAdapter<SrcLanguageConfig> {
        private final ProtoAdapter<Map<String, String>> i18n_language;

        public ProtoAdapter_SrcLanguageConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, SrcLanguageConfig.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.i18n_language = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SrcLanguageConfig decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.default_locale = "en_us";
            r101.language = "";
            r101.scopes = 0;
            r101.rule = DisplayRule.ONLY_TRANSLATION;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
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
            if (r103 != 4) goto L14;
            r101.scopes = ProtoAdapter.INT32.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.rule = DisplayRule.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SrcLanguageConfig r100) {
            int r101 = this.i18n_language.encodedSizeWithTag(1, r100.i18n_language);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return ((((r101 + r102.encodedSizeWithTag(2, r100.default_locale)) + r102.encodedSizeWithTag(3, r100.language)) + ProtoAdapter.INT32.encodedSizeWithTag(4, r100.scopes)) + DisplayRule.ADAPTER.encodedSizeWithTag(5, r100.rule)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SrcLanguageConfig decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SrcLanguageConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SrcLanguageConfig r101) throws IOException {
            this.i18n_language.encodeWithTag(r100, 1, r101.i18n_language);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.default_locale);
            r102.encodeWithTag(r100, 3, r101.language);
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r101.scopes);
            DisplayRule.ADAPTER.encodeWithTag(r100, 5, r101.rule);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SrcLanguageConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SrcLanguageConfig();
        DEFAULT_SCOPES = 0;
        DEFAULT_RULE = DisplayRule.ONLY_TRANSLATION;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.i18n_language = Internal.copyOf("i18n_language", this.i18n_language);
        r100.default_locale = this.default_locale;
        r100.language = this.language;
        r100.scopes = this.scopes;
        r100.rule = this.rule;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SrcLanguageConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SrcLanguageConfig(Map<String, String> r100, String r101, String r110, Integer r111, DisplayRule r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public SrcLanguageConfig(Map<String, String> r100, String r101, String r102, Integer r103, DisplayRule r104, ByteString r105) {
        super(ADAPTER, r105);
        this.i18n_language = Internal.immutableCopyOf("i18n_language", r100);
        this.default_locale = r101;
        this.language = r102;
        this.scopes = r103;
        this.rule = r104;
    }
}
