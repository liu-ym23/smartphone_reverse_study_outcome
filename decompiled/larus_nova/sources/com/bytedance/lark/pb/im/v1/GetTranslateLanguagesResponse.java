package com.bytedance.lark.pb.im.v1;

import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetTranslateLanguagesResponse extends Message<GetTranslateLanguagesResponse, Builder> {
    public static final ProtoAdapter<GetTranslateLanguagesResponse> ADAPTER = null;
    public static final Boolean DEFAULT_AUTO_TRANSLATE_GLOBAL_SWITCH = null;
    public static final Integer DEFAULT_SWITCH_SCOPES = null;
    public static final String DEFAULT_TARGET_LANGUAGE = "";
    public static final ProtoAdapter_GetTranslateLanguagesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean auto_translate_global_switch;
    public final List<String> dis_auto_translate_languages_conf;
    public final LanguagesConfiguration global_conf;
    public final List<String> image_language_keys;
    public final List<String> language_keys;
    public final Map<String, LanguagesConfiguration> languages_conf;
    public final Map<Integer, Boolean> scopes;
    public final Map<String, SrcLanguageConfig> src_languages_config;
    public final List<String> src_lanugages;
    public final Map<String, String> supported_languages;
    public final Integer switch_scopes;
    public final String target_language;
    public final Map<String, TrgLanguageConfig> trg_languages_config;
    public final UserMainLanguageConfig user_main_language_config;
    public final List<String> web_language_keys;
    public final WebTranslationConfig web_translation_config;

    public static final class Builder extends Message.Builder<GetTranslateLanguagesResponse, Builder> implements d<GetTranslateLanguagesResponse> {
        public Boolean auto_translate_global_switch;
        public List<String> dis_auto_translate_languages_conf;
        public LanguagesConfiguration global_conf;
        public List<String> image_language_keys;
        public List<String> language_keys;
        public Map<String, LanguagesConfiguration> languages_conf;
        public Map<Integer, Boolean> scopes;
        public Map<String, SrcLanguageConfig> src_languages_config;
        public List<String> src_lanugages;
        public Map<String, String> supported_languages;
        public Integer switch_scopes;
        public String target_language;
        public Map<String, TrgLanguageConfig> trg_languages_config;
        public UserMainLanguageConfig user_main_language_config;
        public List<String> web_language_keys;
        public WebTranslationConfig web_translation_config;

        @Override // com.squareup.wire.Message.Builder
        public GetTranslateLanguagesResponse build() {
            String r100 = this.target_language;
            if (r100 == null) goto L7;
            return new GetTranslateLanguagesResponse(this.target_language, this.language_keys, this.supported_languages, this.languages_conf, this.global_conf, this.dis_auto_translate_languages_conf, this.auto_translate_global_switch, this.switch_scopes, this.src_lanugages, this.src_languages_config, this.web_translation_config, this.trg_languages_config, this.image_language_keys, this.web_language_keys, this.scopes, this.user_main_language_config, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "target_language"});
        }

        public Builder() {
            this.language_keys = Internal.newMutableList();
            this.supported_languages = Internal.newMutableMap();
            this.languages_conf = Internal.newMutableMap();
            this.dis_auto_translate_languages_conf = Internal.newMutableList();
            this.src_lanugages = Internal.newMutableList();
            this.src_languages_config = Internal.newMutableMap();
            this.trg_languages_config = Internal.newMutableMap();
            this.image_language_keys = Internal.newMutableList();
            this.web_language_keys = Internal.newMutableList();
            this.scopes = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder auto_translate_global_switch(Boolean r100) {
            this.auto_translate_global_switch = r100;
            return this;
        }

        public Builder dis_auto_translate_languages_conf(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.dis_auto_translate_languages_conf = r100;
            return this;
        }

        public Builder global_conf(LanguagesConfiguration r100) {
            this.global_conf = r100;
            return this;
        }

        public Builder image_language_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.image_language_keys = r100;
            return this;
        }

        public Builder language_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.language_keys = r100;
            return this;
        }

        public Builder languages_conf(Map<String, LanguagesConfiguration> r100) {
            Internal.checkElementsNotNull(r100);
            this.languages_conf = r100;
            return this;
        }

        public Builder scopes(Map<Integer, Boolean> r100) {
            Internal.checkElementsNotNull(r100);
            this.scopes = r100;
            return this;
        }

        public Builder src_languages_config(Map<String, SrcLanguageConfig> r100) {
            Internal.checkElementsNotNull(r100);
            this.src_languages_config = r100;
            return this;
        }

        public Builder src_lanugages(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.src_lanugages = r100;
            return this;
        }

        public Builder supported_languages(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.supported_languages = r100;
            return this;
        }

        public Builder switch_scopes(Integer r100) {
            this.switch_scopes = r100;
            return this;
        }

        public Builder target_language(String r100) {
            this.target_language = r100;
            return this;
        }

        public Builder trg_languages_config(Map<String, TrgLanguageConfig> r100) {
            Internal.checkElementsNotNull(r100);
            this.trg_languages_config = r100;
            return this;
        }

        public Builder user_main_language_config(UserMainLanguageConfig r100) {
            this.user_main_language_config = r100;
            return this;
        }

        public Builder web_language_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.web_language_keys = r100;
            return this;
        }

        public Builder web_translation_config(WebTranslationConfig r100) {
            this.web_translation_config = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetTranslateLanguagesResponse extends ProtoAdapter<GetTranslateLanguagesResponse> implements c<GetTranslateLanguagesResponse> {
        private final ProtoAdapter<Map<String, LanguagesConfiguration>> languages_conf;
        private final ProtoAdapter<Map<Integer, Boolean>> scopes;
        private final ProtoAdapter<Map<String, SrcLanguageConfig>> src_languages_config;
        private final ProtoAdapter<Map<String, String>> supported_languages;
        private final ProtoAdapter<Map<String, TrgLanguageConfig>> trg_languages_config;

        public ProtoAdapter_GetTranslateLanguagesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetTranslateLanguagesResponse.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.supported_languages = ProtoAdapter.newMapAdapter(r100, r100);
            this.languages_conf = ProtoAdapter.newMapAdapter(r100, LanguagesConfiguration.ADAPTER);
            this.src_languages_config = ProtoAdapter.newMapAdapter(r100, SrcLanguageConfig.ADAPTER);
            this.trg_languages_config = ProtoAdapter.newMapAdapter(r100, TrgLanguageConfig.ADAPTER);
            this.scopes = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, ProtoAdapter.BOOL);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetTranslateLanguagesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.target_language = "";
            r101.auto_translate_global_switch = Boolean.FALSE;
            r101.switch_scopes = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            switch(r103) {
                case 1: goto L22;
                case 2: goto L21;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                case 13: goto L10;
                case 14: goto L9;
                case 15: goto L8;
                case 16: goto L7;
                default: goto L6;
            };
        L7:
            r101.user_main_language_config = UserMainLanguageConfig.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.scopes.putAll(this.scopes.decode(r100));
            goto L3
        L9:
            r101.web_language_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            r101.image_language_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L11:
            r101.trg_languages_config.putAll(this.trg_languages_config.decode(r100));
            goto L3
        L12:
            r101.web_translation_config = WebTranslationConfig.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.src_languages_config.putAll(this.src_languages_config.decode(r100));
            goto L3
        L14:
            r101.src_lanugages.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L15:
            r101.switch_scopes = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.auto_translate_global_switch = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.dis_auto_translate_languages_conf.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L18:
            r101.global_conf = LanguagesConfiguration.ADAPTER.decode(r100);
            goto L3
        L19:
            r101.languages_conf.putAll(this.languages_conf.decode(r100));
            goto L3
        L20:
            r101.supported_languages.putAll(this.supported_languages.decode(r100));
            goto L3
        L21:
            r101.language_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L22:
            r101.target_language = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetTranslateLanguagesResponse r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = ((r101.encodedSizeWithTag(1, r100.target_language) + r101.asRepeated().encodedSizeWithTag(2, r100.language_keys)) + this.supported_languages.encodedSizeWithTag(3, r100.supported_languages)) + this.languages_conf.encodedSizeWithTag(4, r100.languages_conf);
            LanguagesConfiguration r103 = r100.global_conf;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = LanguagesConfiguration.ADAPTER.encodedSizeWithTag(5, r103);
        L6:
            int r106 = (r102 + r105) + r101.asRepeated().encodedSizeWithTag(6, r100.dis_auto_translate_languages_conf);
            Boolean r107 = r100.auto_translate_global_switch;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r107);
        L10:
            int r109 = r106 + r108;
            Integer r110 = r100.switch_scopes;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(8, r110);
        L14:
            int r112 = ((r109 + r111) + r101.asRepeated().encodedSizeWithTag(9, r100.src_lanugages)) + this.src_languages_config.encodedSizeWithTag(10, r100.src_languages_config);
            WebTranslationConfig r113 = r100.web_translation_config;
            if (r113 == null) goto L17;
            int r114 = WebTranslationConfig.ADAPTER.encodedSizeWithTag(11, r113);
        L18:
            int r115 = ((((r112 + r114) + this.trg_languages_config.encodedSizeWithTag(12, r100.trg_languages_config)) + r101.asRepeated().encodedSizeWithTag(13, r100.image_language_keys)) + r101.asRepeated().encodedSizeWithTag(14, r100.web_language_keys)) + this.scopes.encodedSizeWithTag(15, r100.scopes);
            UserMainLanguageConfig r116 = r100.user_main_language_config;
            if (r116 == null) goto L22;
            r104 = UserMainLanguageConfig.ADAPTER.encodedSizeWithTag(16, r116);
        L22:
            return (r115 + r104) + r100.unknownFields().size();
        L17:
            r114 = 0;
            goto L18
        L13:
            r111 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetTranslateLanguagesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetTranslateLanguagesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetTranslateLanguagesResponse r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.target_language);
            r102.asRepeated().encodeWithTag(r100, 2, r101.language_keys);
            this.supported_languages.encodeWithTag(r100, 3, r101.supported_languages);
            this.languages_conf.encodeWithTag(r100, 4, r101.languages_conf);
            LanguagesConfiguration r103 = r101.global_conf;
            if (r103 == null) goto L5;
            LanguagesConfiguration.ADAPTER.encodeWithTag(r100, 5, r103);
        L5:
            r102.asRepeated().encodeWithTag(r100, 6, r101.dis_auto_translate_languages_conf);
            Boolean r104 = r101.auto_translate_global_switch;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r104);
        L8:
            Integer r105 = r101.switch_scopes;
            if (r105 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 8, r105);
        L11:
            r102.asRepeated().encodeWithTag(r100, 9, r101.src_lanugages);
            this.src_languages_config.encodeWithTag(r100, 10, r101.src_languages_config);
            WebTranslationConfig r106 = r101.web_translation_config;
            if (r106 == null) goto L14;
            WebTranslationConfig.ADAPTER.encodeWithTag(r100, 11, r106);
        L14:
            this.trg_languages_config.encodeWithTag(r100, 12, r101.trg_languages_config);
            r102.asRepeated().encodeWithTag(r100, 13, r101.image_language_keys);
            r102.asRepeated().encodeWithTag(r100, 14, r101.web_language_keys);
            this.scopes.encodeWithTag(r100, 15, r101.scopes);
            UserMainLanguageConfig r107 = r101.user_main_language_config;
            if (r107 == null) goto L17;
            UserMainLanguageConfig.ADAPTER.encodeWithTag(r100, 16, r107);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetTranslateLanguagesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetTranslateLanguagesResponse r100 = new ProtoAdapter_GetTranslateLanguagesResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_AUTO_TRANSLATE_GLOBAL_SWITCH = Boolean.FALSE;
        DEFAULT_SWITCH_SCOPES = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.target_language = this.target_language;
        r100.language_keys = Internal.copyOf("language_keys", this.language_keys);
        r100.supported_languages = Internal.copyOf("supported_languages", this.supported_languages);
        r100.languages_conf = Internal.copyOf("languages_conf", this.languages_conf);
        r100.global_conf = this.global_conf;
        r100.dis_auto_translate_languages_conf = Internal.copyOf("dis_auto_translate_languages_conf", this.dis_auto_translate_languages_conf);
        r100.auto_translate_global_switch = this.auto_translate_global_switch;
        r100.switch_scopes = this.switch_scopes;
        r100.src_lanugages = Internal.copyOf("src_lanugages", this.src_lanugages);
        r100.src_languages_config = Internal.copyOf("src_languages_config", this.src_languages_config);
        r100.web_translation_config = this.web_translation_config;
        r100.trg_languages_config = Internal.copyOf("trg_languages_config", this.trg_languages_config);
        r100.image_language_keys = Internal.copyOf("image_language_keys", this.image_language_keys);
        r100.web_language_keys = Internal.copyOf("web_language_keys", this.web_language_keys);
        r100.scopes = Internal.copyOf(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, this.scopes);
        r100.user_main_language_config = this.user_main_language_config;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetTranslateLanguagesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetTranslateLanguagesResponse(String r110, List<String> r210, Map<String, String> r211, Map<String, LanguagesConfiguration> r212, LanguagesConfiguration r213, List<String> r214, Boolean r215, Integer r216, List<String> r217, Map<String, SrcLanguageConfig> r218, WebTranslationConfig r219, Map<String, TrgLanguageConfig> r310, List<String> r311, List<String> r312, Map<Integer, Boolean> r313, UserMainLanguageConfig r314) {
        this(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, ByteString.EMPTY);
    }

    public GetTranslateLanguagesResponse(String r100, List<String> r101, Map<String, String> r102, Map<String, LanguagesConfiguration> r103, LanguagesConfiguration r104, List<String> r105, Boolean r110, Integer r111, List<String> r112, Map<String, SrcLanguageConfig> r113, WebTranslationConfig r114, Map<String, TrgLanguageConfig> r115, List<String> r116, List<String> r117, Map<Integer, Boolean> r118, UserMainLanguageConfig r119, ByteString r210) {
        super(ADAPTER, r210);
        this.target_language = r100;
        this.language_keys = Internal.immutableCopyOf("language_keys", r101);
        this.supported_languages = Internal.immutableCopyOf("supported_languages", r102);
        this.languages_conf = Internal.immutableCopyOf("languages_conf", r103);
        this.global_conf = r104;
        this.dis_auto_translate_languages_conf = Internal.immutableCopyOf("dis_auto_translate_languages_conf", r105);
        this.auto_translate_global_switch = r110;
        this.switch_scopes = r111;
        this.src_lanugages = Internal.immutableCopyOf("src_lanugages", r112);
        this.src_languages_config = Internal.immutableCopyOf("src_languages_config", r113);
        this.web_translation_config = r114;
        this.trg_languages_config = Internal.immutableCopyOf("trg_languages_config", r115);
        this.image_language_keys = Internal.immutableCopyOf("image_language_keys", r116);
        this.web_language_keys = Internal.immutableCopyOf("web_language_keys", r117);
        this.scopes = Internal.immutableCopyOf(ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, r118);
        this.user_main_language_config = r119;
    }
}
