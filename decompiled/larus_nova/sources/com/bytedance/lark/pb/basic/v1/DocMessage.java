package com.bytedance.lark.pb.basic.v1;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class DocMessage extends com.squareup.wire.Message<DocMessage, Builder> {
    public static final ProtoAdapter<DocMessage> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    public static final Long DEFAULT_CREATE_TIME = null;
    public static final String DEFAULT_DOC_FEED_ID = "";
    public static final String DEFAULT_FROM_ID = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_I18N_MESSAGE = null;
    public static final Type DEFAULT_TYPE = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final String content;
    public final Long create_time;
    public final String doc_feed_id;
    public final String from_id;
    public final I18nInfo i18n_info;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253481id;
    public final Boolean is_i18n_message;
    public final RichText rich_text;
    public final Type type;
    public final Long update_time;

    public static final class Builder extends com.squareup.wire.Message.Builder<DocMessage, Builder> {
        public String content;
        public Long create_time;
        public String doc_feed_id;
        public String from_id;
        public I18nInfo i18n_info;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253482id;
        public Boolean is_i18n_message;
        public RichText rich_text;
        public Type type;
        public Long update_time;

        @Override // com.squareup.wire.Message.Builder
        public DocMessage build() {
            String r100 = this.f253482id;
            if (r100 == null) goto L9;
            if (this.doc_feed_id == null) goto L9;
            return new DocMessage(this.f253482id, this.type, this.create_time, this.update_time, this.content, this.doc_feed_id, this.from_id, this.rich_text, this.is_i18n_message, this.i18n_info, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.doc_feed_id, "doc_feed_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.content = r100;
            return this;
        }

        public Builder create_time(Long r100) {
            this.create_time = r100;
            return this;
        }

        public Builder doc_feed_id(String r100) {
            this.doc_feed_id = r100;
            return this;
        }

        public Builder from_id(String r100) {
            this.from_id = r100;
            return this;
        }

        public Builder i18n_info(I18nInfo r100) {
            this.i18n_info = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253482id = r100;
            return this;
        }

        public Builder is_i18n_message(Boolean r100) {
            this.is_i18n_message = r100;
            return this;
        }

        public Builder rich_text(RichText r100) {
            this.rich_text = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.type = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }
    }

    public static final class I18nInfo extends com.squareup.wire.Message<I18nInfo, Builder> {
        public static final ProtoAdapter<I18nInfo> ADAPTER = null;
        public static final Long DEFAULT_TEXT_TMPL_CODE = null;
        public static final String DEFAULT_TEXT_TMPL_KEY = "";
        public static final Long DEFAULT_TITLE_TMPL_CODE = null;
        public static final String DEFAULT_TITLE_TMPL_KEY = "";
        private static final long serialVersionUID = 0;
        public final Map<String, RichText> i18n_richtexts;
        public final Map<String, String> i18n_titles;
        public final Long text_tmpl_code;
        public final String text_tmpl_key;
        public final Map<String, TmplParamElement> text_tmpl_params;
        public final Map<String, TmplParamElement> text_tmpl_params_v2;
        public final Map<String, TmplParamElementList> text_tmpl_params_v3;
        public final Long title_tmpl_code;
        public final String title_tmpl_key;
        public final Map<String, TmplParamElement> title_tmpl_params;

        public static final class Builder extends com.squareup.wire.Message.Builder<I18nInfo, Builder> {
            public Map<String, RichText> i18n_richtexts;
            public Map<String, String> i18n_titles;
            public Long text_tmpl_code;
            public String text_tmpl_key;
            public Map<String, TmplParamElement> text_tmpl_params;
            public Map<String, TmplParamElement> text_tmpl_params_v2;
            public Map<String, TmplParamElementList> text_tmpl_params_v3;
            public Long title_tmpl_code;
            public String title_tmpl_key;
            public Map<String, TmplParamElement> title_tmpl_params;

            @Override // com.squareup.wire.Message.Builder
            public I18nInfo build() {
                return new I18nInfo(this.i18n_titles, this.i18n_richtexts, this.title_tmpl_code, this.text_tmpl_code, this.title_tmpl_params, this.text_tmpl_params, this.title_tmpl_key, this.text_tmpl_key, this.text_tmpl_params_v2, this.text_tmpl_params_v3, super.buildUnknownFields());
            }

            public Builder() {
                this.i18n_titles = Internal.newMutableMap();
                this.i18n_richtexts = Internal.newMutableMap();
                this.title_tmpl_params = Internal.newMutableMap();
                this.text_tmpl_params = Internal.newMutableMap();
                this.text_tmpl_params_v2 = Internal.newMutableMap();
                this.text_tmpl_params_v3 = Internal.newMutableMap();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder i18n_richtexts(Map<String, RichText> r100) {
                Internal.checkElementsNotNull(r100);
                this.i18n_richtexts = r100;
                return this;
            }

            public Builder i18n_titles(Map<String, String> r100) {
                Internal.checkElementsNotNull(r100);
                this.i18n_titles = r100;
                return this;
            }

            public Builder text_tmpl_code(Long r100) {
                this.text_tmpl_code = r100;
                return this;
            }

            public Builder text_tmpl_key(String r100) {
                this.text_tmpl_key = r100;
                return this;
            }

            public Builder text_tmpl_params(Map<String, TmplParamElement> r100) {
                Internal.checkElementsNotNull(r100);
                this.text_tmpl_params = r100;
                return this;
            }

            public Builder text_tmpl_params_v2(Map<String, TmplParamElement> r100) {
                Internal.checkElementsNotNull(r100);
                this.text_tmpl_params_v2 = r100;
                return this;
            }

            public Builder text_tmpl_params_v3(Map<String, TmplParamElementList> r100) {
                Internal.checkElementsNotNull(r100);
                this.text_tmpl_params_v3 = r100;
                return this;
            }

            public Builder title_tmpl_code(Long r100) {
                this.title_tmpl_code = r100;
                return this;
            }

            public Builder title_tmpl_key(String r100) {
                this.title_tmpl_key = r100;
                return this;
            }

            public Builder title_tmpl_params(Map<String, TmplParamElement> r100) {
                Internal.checkElementsNotNull(r100);
                this.title_tmpl_params = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_I18nInfo extends ProtoAdapter<I18nInfo> {
            private final ProtoAdapter<Map<String, RichText>> i18n_richtexts;
            private final ProtoAdapter<Map<String, String>> i18n_titles;
            private final ProtoAdapter<Map<String, TmplParamElement>> text_tmpl_params;
            private final ProtoAdapter<Map<String, TmplParamElement>> text_tmpl_params_v2;
            private final ProtoAdapter<Map<String, TmplParamElementList>> text_tmpl_params_v3;
            private final ProtoAdapter<Map<String, TmplParamElement>> title_tmpl_params;

            public ProtoAdapter_I18nInfo() {
                super(FieldEncoding.LENGTH_DELIMITED, I18nInfo.class);
                ProtoAdapter<String> r100 = ProtoAdapter.STRING;
                this.i18n_titles = ProtoAdapter.newMapAdapter(r100, r100);
                this.i18n_richtexts = ProtoAdapter.newMapAdapter(r100, RichText.ADAPTER);
                ProtoAdapter<TmplParamElement> r101 = TmplParamElement.ADAPTER;
                this.title_tmpl_params = ProtoAdapter.newMapAdapter(r100, r101);
                this.text_tmpl_params = ProtoAdapter.newMapAdapter(r100, r101);
                this.text_tmpl_params_v2 = ProtoAdapter.newMapAdapter(r100, r101);
                this.text_tmpl_params_v3 = ProtoAdapter.newMapAdapter(r100, TmplParamElementList.ADAPTER);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public I18nInfo decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.title_tmpl_code = 0L;
                r101.text_tmpl_code = 0L;
                r101.title_tmpl_key = "";
                r101.text_tmpl_key = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L17;
                switch(r103) {
                    case 1: goto L16;
                    case 2: goto L15;
                    case 3: goto L14;
                    case 4: goto L13;
                    case 5: goto L12;
                    case 6: goto L11;
                    case 7: goto L10;
                    case 8: goto L9;
                    case 9: goto L8;
                    case 10: goto L7;
                    default: goto L6;
                };
            L7:
                r101.text_tmpl_params_v3.putAll(this.text_tmpl_params_v3.decode(r100));
                goto L3
            L8:
                r101.text_tmpl_params_v2.putAll(this.text_tmpl_params_v2.decode(r100));
                goto L3
            L9:
                r101.text_tmpl_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                r101.title_tmpl_key = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                r101.text_tmpl_params.putAll(this.text_tmpl_params.decode(r100));
                goto L3
            L12:
                r101.title_tmpl_params.putAll(this.title_tmpl_params.decode(r100));
                goto L3
            L13:
                r101.text_tmpl_code = ProtoAdapter.INT64.decode(r100);
                goto L3
            L14:
                r101.title_tmpl_code = ProtoAdapter.INT64.decode(r100);
                goto L3
            L15:
                r101.i18n_richtexts.putAll(this.i18n_richtexts.decode(r100));
                goto L3
            L16:
                r101.i18n_titles.putAll(this.i18n_titles.decode(r100));
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L17:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(I18nInfo r100) {
                int r101 = this.i18n_titles.encodedSizeWithTag(1, r100.i18n_titles) + this.i18n_richtexts.encodedSizeWithTag(2, r100.i18n_richtexts);
                Long r102 = r100.title_tmpl_code;
                int r103 = 0;
                if (r102 == null) goto L5;
                int r104 = ProtoAdapter.INT64.encodedSizeWithTag(3, r102);
            L6:
                int r105 = r101 + r104;
                Long r106 = r100.text_tmpl_code;
                if (r106 == null) goto L9;
                int r107 = ProtoAdapter.INT64.encodedSizeWithTag(4, r106);
            L10:
                int r108 = ((r105 + r107) + this.title_tmpl_params.encodedSizeWithTag(5, r100.title_tmpl_params)) + this.text_tmpl_params.encodedSizeWithTag(6, r100.text_tmpl_params);
                String r109 = r100.title_tmpl_key;
                if (r109 == null) goto L13;
                int r110 = ProtoAdapter.STRING.encodedSizeWithTag(7, r109);
            L14:
                int r111 = r108 + r110;
                String r112 = r100.text_tmpl_key;
                if (r112 == null) goto L18;
                r103 = ProtoAdapter.STRING.encodedSizeWithTag(8, r112);
            L18:
                return (((r111 + r103) + this.text_tmpl_params_v2.encodedSizeWithTag(9, r100.text_tmpl_params_v2)) + this.text_tmpl_params_v3.encodedSizeWithTag(10, r100.text_tmpl_params_v3)) + r100.unknownFields().size();
            L13:
                r110 = 0;
                goto L14
            L9:
                r107 = 0;
                goto L10
            L5:
                r104 = 0;
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
                this.i18n_titles.encodeWithTag(r100, 1, r101.i18n_titles);
                this.i18n_richtexts.encodeWithTag(r100, 2, r101.i18n_richtexts);
                Long r102 = r101.title_tmpl_code;
                if (r102 == null) goto L5;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r102);
            L5:
                Long r103 = r101.text_tmpl_code;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 4, r103);
            L8:
                this.title_tmpl_params.encodeWithTag(r100, 5, r101.title_tmpl_params);
                this.text_tmpl_params.encodeWithTag(r100, 6, r101.text_tmpl_params);
                String r104 = r101.title_tmpl_key;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 7, r104);
            L11:
                String r105 = r101.text_tmpl_key;
                if (r105 == null) goto L14;
                ProtoAdapter.STRING.encodeWithTag(r100, 8, r105);
            L14:
                this.text_tmpl_params_v2.encodeWithTag(r100, 9, r101.text_tmpl_params_v2);
                this.text_tmpl_params_v3.encodeWithTag(r100, 10, r101.text_tmpl_params_v3);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, I18nInfo r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_I18nInfo();
            DEFAULT_TITLE_TMPL_CODE = 0L;
            DEFAULT_TEXT_TMPL_CODE = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.i18n_titles = Internal.copyOf("i18n_titles", this.i18n_titles);
            r100.i18n_richtexts = Internal.copyOf("i18n_richtexts", this.i18n_richtexts);
            r100.title_tmpl_code = this.title_tmpl_code;
            r100.text_tmpl_code = this.text_tmpl_code;
            r100.title_tmpl_params = Internal.copyOf("title_tmpl_params", this.title_tmpl_params);
            r100.text_tmpl_params = Internal.copyOf("text_tmpl_params", this.text_tmpl_params);
            r100.title_tmpl_key = this.title_tmpl_key;
            r100.text_tmpl_key = this.text_tmpl_key;
            r100.text_tmpl_params_v2 = Internal.copyOf("text_tmpl_params_v2", this.text_tmpl_params_v2);
            r100.text_tmpl_params_v3 = Internal.copyOf("text_tmpl_params_v3", this.text_tmpl_params_v3);
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

        public I18nInfo(Map<String, String> r110, Map<String, RichText> r111, Long r112, Long r113, Map<String, TmplParamElement> r114, Map<String, TmplParamElement> r115, String r116, String r210, Map<String, TmplParamElement> r211, Map<String, TmplParamElementList> r212) {
            this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
        }

        public I18nInfo(Map<String, String> r100, Map<String, RichText> r101, Long r102, Long r103, Map<String, TmplParamElement> r104, Map<String, TmplParamElement> r105, String r106, String r107, Map<String, TmplParamElement> r110, Map<String, TmplParamElementList> r111, ByteString r112) {
            super(ADAPTER, r112);
            this.i18n_titles = Internal.immutableCopyOf("i18n_titles", r100);
            this.i18n_richtexts = Internal.immutableCopyOf("i18n_richtexts", r101);
            this.title_tmpl_code = r102;
            this.text_tmpl_code = r103;
            this.title_tmpl_params = Internal.immutableCopyOf("title_tmpl_params", r104);
            this.text_tmpl_params = Internal.immutableCopyOf("text_tmpl_params", r105);
            this.title_tmpl_key = r106;
            this.text_tmpl_key = r107;
            this.text_tmpl_params_v2 = Internal.immutableCopyOf("text_tmpl_params_v2", r110);
            this.text_tmpl_params_v3 = Internal.immutableCopyOf("text_tmpl_params_v3", r111);
        }
    }

    public static final class ProtoAdapter_DocMessage extends ProtoAdapter<DocMessage> {
        public ProtoAdapter_DocMessage() {
            super(FieldEncoding.LENGTH_DELIMITED, DocMessage.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DocMessage decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253482id = "";
            r101.type = Type.MENTION;
            r101.create_time = 0L;
            r101.update_time = 0L;
            r101.content = "";
            r101.doc_feed_id = "";
            r101.from_id = "";
            r101.is_i18n_message = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L20;
            switch(r103) {
                case 1: goto L19;
                case 2: goto L22;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L22:
            r101.type = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.i18n_info = I18nInfo.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.is_i18n_message = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.rich_text = RichText.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.from_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.doc_feed_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.content = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L14:
            r101.create_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L19:
            r101.f253482id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L20:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DocMessage r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.f253481id);
            Type r103 = r100.type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = Type.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Long r107 = r100.create_time;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            Long r110 = r100.update_time;
            if (r110 == null) goto L13;
            int r111 = ProtoAdapter.INT64.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.content;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(5, r113);
        L18:
            int r115 = (r112 + r114) + r101.encodedSizeWithTag(6, r100.doc_feed_id);
            String r116 = r100.from_id;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(7, r116);
        L22:
            int r118 = r115 + r117;
            RichText r119 = r100.rich_text;
            if (r119 == null) goto L25;
            int r120 = RichText.ADAPTER.encodedSizeWithTag(8, r119);
        L26:
            int r121 = r118 + r120;
            Boolean r122 = r100.is_i18n_message;
            if (r122 == null) goto L29;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r122);
        L30:
            int r124 = r121 + r123;
            I18nInfo r125 = r100.i18n_info;
            if (r125 == null) goto L34;
            r104 = I18nInfo.ADAPTER.encodedSizeWithTag(10, r125);
        L34:
            return (r124 + r104) + r100.unknownFields().size();
        L29:
            r123 = 0;
            goto L30
        L25:
            r120 = 0;
            goto L26
        L21:
            r117 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ DocMessage decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DocMessage r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DocMessage r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253481id);
            Type r103 = r101.type;
            if (r103 == null) goto L5;
            Type.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            Long r104 = r101.create_time;
            if (r104 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
        L8:
            Long r105 = r101.update_time;
            if (r105 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.content;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            r102.encodeWithTag(r100, 6, r101.doc_feed_id);
            String r107 = r101.from_id;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 7, r107);
        L17:
            RichText r108 = r101.rich_text;
            if (r108 == null) goto L20;
            RichText.ADAPTER.encodeWithTag(r100, 8, r108);
        L20:
            Boolean r109 = r101.is_i18n_message;
            if (r109 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r109);
        L23:
            I18nInfo r110 = r101.i18n_info;
            if (r110 == null) goto L26;
            I18nInfo.ADAPTER.encodeWithTag(r100, 10, r110);
        L26:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocMessage r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum TmplParamElemType extends Enum<TmplParamElemType> implements WireEnum {
        private static final /* synthetic */ TmplParamElemType[] $VALUES = null;
        public static final ProtoAdapter<TmplParamElemType> ADAPTER = null;
        public static final TmplParamElemType I18N_KEY = null;
        public static final TmplParamElemType TEXT = null;
        public static final TmplParamElemType UNKNOWN = null;
        public static final TmplParamElemType USER_ID = null;
        private final int value;

        static {
            TmplParamElemType r100 = new TmplParamElemType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            TmplParamElemType r101 = new TmplParamElemType("USER_ID", 1, 1);
            USER_ID = r101;
            TmplParamElemType r102 = new TmplParamElemType(CardAdapter.TEXT, 2, 2);
            TEXT = r102;
            TmplParamElemType r103 = new TmplParamElemType("I18N_KEY", 3, 3);
            I18N_KEY = r103;
            $VALUES = new TmplParamElemType[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(TmplParamElemType.class);
        }

        public static TmplParamElemType[] values() {
            return (TmplParamElemType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static TmplParamElemType fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return I18N_KEY;
        L14:
            return TEXT;
        L16:
            return USER_ID;
        L18:
            return UNKNOWN;
        }

        public static TmplParamElemType valueOf(String r100) {
            return (TmplParamElemType) a.a(TmplParamElemType.class, r100);
        }

        private TmplParamElemType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class TmplParamElement extends com.squareup.wire.Message<TmplParamElement, Builder> {
        public static final ProtoAdapter<TmplParamElement> ADAPTER = null;
        public static final String DEFAULT_CONTENT = "";
        public static final TmplParamElemType DEFAULT_TYPE = null;
        private static final long serialVersionUID = 0;
        public final String content;
        public final TmplParamElemType type;

        public static final class Builder extends com.squareup.wire.Message.Builder<TmplParamElement, Builder> {
            public String content;
            public TmplParamElemType type;

            @Override // com.squareup.wire.Message.Builder
            public TmplParamElement build() {
                return new TmplParamElement(this.type, this.content, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder content(String r100) {
                this.content = r100;
                return this;
            }

            public Builder type(TmplParamElemType r100) {
                this.type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TmplParamElement extends ProtoAdapter<TmplParamElement> {
            public ProtoAdapter_TmplParamElement() {
                super(FieldEncoding.LENGTH_DELIMITED, TmplParamElement.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TmplParamElement decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.type = TmplParamElemType.UNKNOWN;
                r101.content = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.type = TmplParamElemType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.content = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(TmplParamElement r100) {
                TmplParamElemType r101 = r100.type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = TmplParamElemType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                String r104 = r100.content;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TmplParamElement decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TmplParamElement r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TmplParamElement r101) throws IOException {
                TmplParamElemType r102 = r101.type;
                if (r102 == null) goto L5;
                TmplParamElemType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                String r103 = r101.content;
                if (r103 == null) goto L8;
                ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TmplParamElement r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TmplParamElement();
            DEFAULT_TYPE = TmplParamElemType.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.type = this.type;
            r100.content = this.content;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TmplParamElement.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TmplParamElement(TmplParamElemType r100, String r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public TmplParamElement(TmplParamElemType r100, String r101, ByteString r102) {
            super(ADAPTER, r102);
            this.type = r100;
            this.content = r101;
        }
    }

    public static final class TmplParamElementList extends com.squareup.wire.Message<TmplParamElementList, Builder> {
        public static final ProtoAdapter<TmplParamElementList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<TmplParamElement> tmpl_param_element_list;

        public static final class Builder extends com.squareup.wire.Message.Builder<TmplParamElementList, Builder> {
            public List<TmplParamElement> tmpl_param_element_list;

            @Override // com.squareup.wire.Message.Builder
            public TmplParamElementList build() {
                return new TmplParamElementList(this.tmpl_param_element_list, super.buildUnknownFields());
            }

            public Builder() {
                this.tmpl_param_element_list = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
                return build();
            }

            public Builder tmpl_param_element_list(List<TmplParamElement> r100) {
                Internal.checkElementsNotNull(r100);
                this.tmpl_param_element_list = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TmplParamElementList extends ProtoAdapter<TmplParamElementList> {
            public ProtoAdapter_TmplParamElementList() {
                super(FieldEncoding.LENGTH_DELIMITED, TmplParamElementList.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TmplParamElementList decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.tmpl_param_element_list.add(TmplParamElement.ADAPTER.decode(r100));
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
            public int encodedSize2(TmplParamElementList r100) {
                return TmplParamElement.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.tmpl_param_element_list) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TmplParamElementList decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TmplParamElementList r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TmplParamElementList r101) throws IOException {
                TmplParamElement.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.tmpl_param_element_list);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TmplParamElementList r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TmplParamElementList();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.tmpl_param_element_list = Internal.copyOf("tmpl_param_element_list", this.tmpl_param_element_list);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TmplParamElementList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
            return newBuilder();
        }

        public TmplParamElementList(List<TmplParamElement> r100) {
            this(r100, ByteString.EMPTY);
        }

        public TmplParamElementList(List<TmplParamElement> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.tmpl_param_element_list = Internal.immutableCopyOf("tmpl_param_element_list", r100);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type COMMENT = null;
        public static final Type COMMENT_REACTION = null;
        public static final Type CONTENT_REACTION = null;
        public static final Type MENTION = null;
        public static final Type REOPEN = null;
        public static final Type REPLY = null;
        public static final Type SHARE = null;
        public static final Type SOLVE = null;
        public static final Type TEMPLATE_CARD = null;
        public static final Type UNKNOWN_TYPE = null;
        public static final Type WITHDRAW = null;
        public static final Type WITHDRAW_CONTENT_REACTION = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN_TYPE", 0, 0);
            UNKNOWN_TYPE = r100;
            Type r101 = new Type("MENTION", 1, 1);
            MENTION = r101;
            Type r102 = new Type("COMMENT", 2, 2);
            COMMENT = r102;
            Type r103 = new Type("REPLY", 3, 3);
            REPLY = r103;
            Type r104 = new Type("SOLVE", 4, 4);
            SOLVE = r104;
            Type r105 = new Type("SHARE", 5, 5);
            SHARE = r105;
            Type r110 = new Type("REOPEN", 6, 6);
            REOPEN = r110;
            Type r111 = new Type("COMMENT_REACTION", 7, 7);
            COMMENT_REACTION = r111;
            Type r112 = new Type("TEMPLATE_CARD", 8, 8);
            TEMPLATE_CARD = r112;
            Type r113 = new Type("WITHDRAW", 9, 9);
            WITHDRAW = r113;
            Type r114 = new Type("CONTENT_REACTION", 10, 10);
            CONTENT_REACTION = r114;
            Type r115 = new Type("WITHDRAW_CONTENT_REACTION", 11, 11);
            WITHDRAW_CONTENT_REACTION = r115;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            switch(r100) {
                case 0: goto L28;
                case 1: goto L26;
                case 2: goto L24;
                case 3: goto L22;
                case 4: goto L20;
                case 5: goto L18;
                case 6: goto L16;
                case 7: goto L14;
                case 8: goto L12;
                case 9: goto L10;
                case 10: goto L8;
                case 11: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return WITHDRAW_CONTENT_REACTION;
        L8:
            return CONTENT_REACTION;
        L10:
            return WITHDRAW;
        L12:
            return TEMPLATE_CARD;
        L14:
            return COMMENT_REACTION;
        L16:
            return REOPEN;
        L18:
            return SHARE;
        L20:
            return SOLVE;
        L22:
            return REPLY;
        L24:
            return COMMENT;
        L26:
            return MENTION;
        L28:
            return UNKNOWN_TYPE;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DocMessage();
        DEFAULT_TYPE = Type.MENTION;
        DEFAULT_CREATE_TIME = 0L;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_IS_I18N_MESSAGE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253482id = this.f253481id;
        r100.type = this.type;
        r100.create_time = this.create_time;
        r100.update_time = this.update_time;
        r100.content = this.content;
        r100.doc_feed_id = this.doc_feed_id;
        r100.from_id = this.from_id;
        r100.rich_text = this.rich_text;
        r100.is_i18n_message = this.is_i18n_message;
        r100.i18n_info = this.i18n_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DocMessage.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DocMessage(String r110, Type r111, Long r112, Long r113, String r114, String r115, String r116, RichText r210, Boolean r211, I18nInfo r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public DocMessage(String r100, Type r101, Long r102, Long r103, String r104, String r105, String r106, RichText r107, Boolean r110, I18nInfo r111, ByteString r112) {
        super(ADAPTER, r112);
        this.f253481id = r100;
        this.type = r101;
        this.create_time = r102;
        this.update_time = r103;
        this.content = r104;
        this.doc_feed_id = r105;
        this.from_id = r106;
        this.rich_text = r107;
        this.is_i18n_message = r110;
        this.i18n_info = r111;
    }
}
