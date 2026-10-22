package com.ss.android.lark.pb.usearch;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.DocType;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class QACardMeta extends Message<QACardMeta, Builder> {
    public static final ProtoAdapter<QACardMeta> ADAPTER = null;
    public static final String DEFAULT_CATEGORY_DESC = "";
    public static final String DEFAULT_CATEGORY_NAME = "";
    public static final String DEFAULT_CONTENT_AVATAR_KEY = "";
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_QA_RENDER_META = "";
    public static final String DEFAULT_SOURCE_ID = "";
    public static final String DEFAULT_SOURCE_URL = "";
    public static final Long DEFAULT_UPDATE_TIME = null;
    private static final long serialVersionUID = 0;
    public final String mcategory_desc;
    public final String mcategory_name;
    public final String mcontent_avatar_key;
    public final String mid;
    public final JumpType mjump_type;
    public final String mname;
    public final String mqa_render_meta;
    public final List<String> mrecommended_questions;
    public final String msource_id;
    public final SourceMeta msource_meta;
    public final SourceType msource_type;
    public final String msource_url;
    public final Long mupdate_time;

    public static final class AppMeta extends Message<AppMeta, Builder> {
        public static final ProtoAdapter<AppMeta> ADAPTER = null;
        public static final String DEFAULT_USER_ID = "";
        private static final long serialVersionUID = 0;
        public final String muser_id;

        public static final class Builder extends Message.Builder<AppMeta, Builder> {
            public String muser_id;

            @Override // com.squareup.wire.Message.Builder
            public AppMeta build() {
                return new AppMeta(this.muser_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder user_id(String r100) {
                this.muser_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_AppMeta extends ProtoAdapter<AppMeta> {
            public ProtoAdapter_AppMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, AppMeta.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public AppMeta decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.muser_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.muser_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(AppMeta r100) {
                String r101 = r100.muser_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ AppMeta decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(AppMeta r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, AppMeta r101) throws IOException {
                String r102 = r101.muser_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AppMeta r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_AppMeta();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.muser_id = this.muser_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return AppMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public AppMeta(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public AppMeta(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.muser_id = r100;
        }
    }

    public static final class Builder extends Message.Builder<QACardMeta, Builder> {
        public String mcategory_desc;
        public String mcategory_name;
        public String mcontent_avatar_key;
        public String mid;
        public JumpType mjump_type;
        public String mname;
        public String mqa_render_meta;
        public List<String> mrecommended_questions;
        public String msource_id;
        public SourceMeta msource_meta;
        public SourceType msource_type;
        public String msource_url;
        public Long mupdate_time;

        @Override // com.squareup.wire.Message.Builder
        public QACardMeta build() {
            String r100 = this.mid;
            if (r100 == null) goto L9;
            if (this.msource_meta == null) goto L9;
            return new QACardMeta(this.mid, this.msource_id, this.msource_type, this.msource_meta, this.msource_url, this.mname, this.mcategory_name, this.mcategory_desc, this.mupdate_time, this.mcontent_avatar_key, this.mrecommended_questions, this.mqa_render_meta, this.mjump_type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid", this.msource_meta, "msource_meta"});
        }

        public Builder() {
            this.mrecommended_questions = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder category_desc(String r100) {
            this.mcategory_desc = r100;
            return this;
        }

        public Builder category_name(String r100) {
            this.mcategory_name = r100;
            return this;
        }

        public Builder content_avatar_key(String r100) {
            this.mcontent_avatar_key = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder jump_type(JumpType r100) {
            this.mjump_type = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder qa_render_meta(String r100) {
            this.mqa_render_meta = r100;
            return this;
        }

        public Builder recommended_questions(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mrecommended_questions = r100;
            return this;
        }

        public Builder source_id(String r100) {
            this.msource_id = r100;
            return this;
        }

        public Builder source_meta(SourceMeta r100) {
            this.msource_meta = r100;
            return this;
        }

        public Builder source_type(SourceType r100) {
            this.msource_type = r100;
            return this;
        }

        public Builder source_url(String r100) {
            this.msource_url = r100;
            return this;
        }

        public Builder update_time(Long r100) {
            this.mupdate_time = r100;
            return this;
        }
    }

    public static final class DocMeta extends Message<DocMeta, Builder> {
        public static final ProtoAdapter<DocMeta> ADAPTER = null;
        public static final String DEFAULT_ANCHOR_URL = "";
        private static final long serialVersionUID = 0;
        public final String manchor_url;
        public final DocType mdoc_type;

        public static final class Builder extends Message.Builder<DocMeta, Builder> {
            public String manchor_url;
            public DocType mdoc_type;

            @Override // com.squareup.wire.Message.Builder
            public DocMeta build() {
                return new DocMeta(this.manchor_url, this.mdoc_type, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder anchor_url(String r100) {
                this.manchor_url = r100;
                return this;
            }

            public Builder doc_type(DocType r100) {
                this.mdoc_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_DocMeta extends ProtoAdapter<DocMeta> {
            public ProtoAdapter_DocMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, DocMeta.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public DocMeta decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.manchor_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.manchor_url = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mdoc_type = DocType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
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
            public int encodedSize2(DocMeta r100) {
                String r101 = r100.manchor_url;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                DocType r104 = r100.mdoc_type;
                if (r104 == null) goto L10;
                r102 = DocType.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                return (r103 + r102) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ DocMeta decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(DocMeta r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, DocMeta r101) throws IOException {
                String r102 = r101.manchor_url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                DocType r103 = r101.mdoc_type;
                if (r103 == null) goto L8;
                DocType.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DocMeta r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_DocMeta();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.manchor_url = this.manchor_url;
            r100.mdoc_type = this.mdoc_type;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return DocMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public DocMeta(String r100, DocType r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public DocMeta(String r100, DocType r101, ByteString r102) {
            super(ADAPTER, r102);
            this.manchor_url = r100;
            this.mdoc_type = r101;
        }
    }

    public static final enum JumpType extends Enum<JumpType> implements WireEnum {
        private static final /* synthetic */ JumpType[] $VALUES = null;
        public static final ProtoAdapter<JumpType> ADAPTER = null;
        public static final JumpType ENTERPRISE_QA = null;
        public static final JumpType HELPDESK = null;
        public static final JumpType UNKNOWN = null;
        private final int value;

        static {
            JumpType r100 = new JumpType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            JumpType r101 = new JumpType("ENTERPRISE_QA", 1, 1);
            ENTERPRISE_QA = r101;
            JumpType r102 = new JumpType("HELPDESK", 2, 2);
            HELPDESK = r102;
            $VALUES = new JumpType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(JumpType.class);
        }

        public static JumpType[] values() {
            return (JumpType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static JumpType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return HELPDESK;
        L12:
            return ENTERPRISE_QA;
        L14:
            return UNKNOWN;
        }

        public static JumpType valueOf(String r100) {
            return (JumpType) a.a(JumpType.class, r100);
        }

        private JumpType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class OncallMeta extends Message<OncallMeta, Builder> {
        public static final ProtoAdapter<OncallMeta> ADAPTER = null;
        public static final String DEFAULT_FAQ_ID = "";
        private static final long serialVersionUID = 0;
        public final String mfaq_id;

        public static final class Builder extends Message.Builder<OncallMeta, Builder> {
            public String mfaq_id;

            @Override // com.squareup.wire.Message.Builder
            public OncallMeta build() {
                return new OncallMeta(this.mfaq_id, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder faq_id(String r100) {
                this.mfaq_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_OncallMeta extends ProtoAdapter<OncallMeta> {
            public ProtoAdapter_OncallMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, OncallMeta.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public OncallMeta decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mfaq_id = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mfaq_id = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(OncallMeta r100) {
                String r101 = r100.mfaq_id;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ OncallMeta decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(OncallMeta r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, OncallMeta r101) throws IOException {
                String r102 = r101.mfaq_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, OncallMeta r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_OncallMeta();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mfaq_id = this.mfaq_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return OncallMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public OncallMeta(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public OncallMeta(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mfaq_id = r100;
        }
    }

    public static final class ProtoAdapter_QACardMeta extends ProtoAdapter<QACardMeta> {
        public ProtoAdapter_QACardMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, QACardMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public QACardMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = "";
            r101.msource_id = "";
            r101.msource_url = "";
            r101.mname = "";
            r101.mcategory_name = "";
            r101.mcategory_desc = "";
            r101.mupdate_time = 0L;
            r101.mcontent_avatar_key = "";
            r101.mqa_render_meta = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L26;
            switch(r103) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L28;
                case 4: goto L19;
                case 5: goto L18;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L14;
                case 10: goto L13;
                case 11: goto L12;
                case 12: goto L11;
                case 13: goto L30;
                default: goto L6;
            };
        L28:
            r101.msource_type = SourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r101.mjump_type = JumpType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            r101.mqa_render_meta = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.mrecommended_questions.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            r101.mcontent_avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mupdate_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L15:
            r101.mcategory_desc = ProtoAdapter.STRING.decode(r100);
            goto L3
        L16:
            r101.mcategory_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.mname = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.msource_url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.msource_meta = SourceMeta.ADAPTER.decode(r100);
            goto L3
        L24:
            r101.msource_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L25:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L26:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(QACardMeta r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            String r103 = r100.msource_id;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = r101.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            SourceType r107 = r100.msource_type;
            if (r107 == null) goto L9;
            int r108 = SourceType.ADAPTER.encodedSizeWithTag(3, r107);
        L10:
            int r109 = (r106 + r108) + SourceMeta.ADAPTER.encodedSizeWithTag(4, r100.msource_meta);
            String r110 = r100.msource_url;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(5, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.mname;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(6, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.mcategory_name;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(7, r116);
        L22:
            int r118 = r115 + r117;
            String r119 = r100.mcategory_desc;
            if (r119 == null) goto L25;
            int r120 = r101.encodedSizeWithTag(8, r119);
        L26:
            int r121 = r118 + r120;
            Long r122 = r100.mupdate_time;
            if (r122 == null) goto L29;
            int r123 = ProtoAdapter.INT64.encodedSizeWithTag(9, r122);
        L30:
            int r124 = r121 + r123;
            String r125 = r100.mcontent_avatar_key;
            if (r125 == null) goto L33;
            int r126 = r101.encodedSizeWithTag(10, r125);
        L34:
            int r127 = (r124 + r126) + r101.asRepeated().encodedSizeWithTag(11, r100.mrecommended_questions);
            String r128 = r100.mqa_render_meta;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(12, r128);
        L38:
            int r130 = r127 + r129;
            JumpType r131 = r100.mjump_type;
            if (r131 == null) goto L42;
            r104 = JumpType.ADAPTER.encodedSizeWithTag(13, r131);
        L42:
            return (r130 + r104) + r100.unknownFields().size();
        L37:
            r129 = 0;
            goto L38
        L33:
            r126 = 0;
            goto L34
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
        public /* bridge */ /* synthetic */ QACardMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(QACardMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, QACardMeta r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            String r103 = r101.msource_id;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 2, r103);
        L5:
            SourceType r104 = r101.msource_type;
            if (r104 == null) goto L8;
            SourceType.ADAPTER.encodeWithTag(r100, 3, r104);
        L8:
            SourceMeta.ADAPTER.encodeWithTag(r100, 4, r101.msource_meta);
            String r105 = r101.msource_url;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 5, r105);
        L11:
            String r106 = r101.mname;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 6, r106);
        L14:
            String r107 = r101.mcategory_name;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 7, r107);
        L17:
            String r108 = r101.mcategory_desc;
            if (r108 == null) goto L20;
            r102.encodeWithTag(r100, 8, r108);
        L20:
            Long r109 = r101.mupdate_time;
            if (r109 == null) goto L23;
            ProtoAdapter.INT64.encodeWithTag(r100, 9, r109);
        L23:
            String r110 = r101.mcontent_avatar_key;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 10, r110);
        L26:
            r102.asRepeated().encodeWithTag(r100, 11, r101.mrecommended_questions);
            String r111 = r101.mqa_render_meta;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 12, r111);
        L29:
            JumpType r112 = r101.mjump_type;
            if (r112 == null) goto L32;
            JumpType.ADAPTER.encodeWithTag(r100, 13, r112);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, QACardMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class SourceMeta extends Message<SourceMeta, Builder> {
        public static final ProtoAdapter<SourceMeta> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final AppMeta mapp_meta;
        public final DocMeta mdoc_meta;
        public final OncallMeta moncall_meta;
        public final WikiMeta mwiki_meta;

        public static final class Builder extends Message.Builder<SourceMeta, Builder> {
            public AppMeta mapp_meta;
            public DocMeta mdoc_meta;
            public OncallMeta moncall_meta;
            public WikiMeta mwiki_meta;

            @Override // com.squareup.wire.Message.Builder
            public SourceMeta build() {
                return new SourceMeta(this.moncall_meta, this.mdoc_meta, this.mapp_meta, this.mwiki_meta, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder app_meta(AppMeta r100) {
                this.mapp_meta = r100;
                this.moncall_meta = null;
                this.mdoc_meta = null;
                this.mwiki_meta = null;
                return this;
            }

            public Builder doc_meta(DocMeta r100) {
                this.mdoc_meta = r100;
                this.moncall_meta = null;
                this.mapp_meta = null;
                this.mwiki_meta = null;
                return this;
            }

            public Builder oncall_meta(OncallMeta r100) {
                this.moncall_meta = r100;
                this.mdoc_meta = null;
                this.mapp_meta = null;
                this.mwiki_meta = null;
                return this;
            }

            public Builder wiki_meta(WikiMeta r100) {
                this.mwiki_meta = r100;
                this.moncall_meta = null;
                this.mdoc_meta = null;
                this.mapp_meta = null;
                return this;
            }
        }

        public static final class ProtoAdapter_SourceMeta extends ProtoAdapter<SourceMeta> {
            public ProtoAdapter_SourceMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, SourceMeta.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SourceMeta decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.oncall_meta(OncallMeta.ADAPTER.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.doc_meta(DocMeta.ADAPTER.decode(r100));
                goto L3
            L10:
                if (r103 != 3) goto L12;
                r101.app_meta(AppMeta.ADAPTER.decode(r100));
                goto L3
            L12:
                if (r103 != 4) goto L13;
                r101.wiki_meta(WikiMeta.ADAPTER.decode(r100));
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
            public int encodedSize2(SourceMeta r100) {
                OncallMeta r101 = r100.moncall_meta;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = OncallMeta.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                DocMeta r104 = r100.mdoc_meta;
                if (r104 == null) goto L9;
                int r105 = DocMeta.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                AppMeta r107 = r100.mapp_meta;
                if (r107 == null) goto L13;
                int r108 = AppMeta.ADAPTER.encodedSizeWithTag(3, r107);
            L14:
                int r109 = r106 + r108;
                WikiMeta r110 = r100.mwiki_meta;
                if (r110 == null) goto L18;
                r102 = WikiMeta.ADAPTER.encodedSizeWithTag(4, r110);
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
            public /* bridge */ /* synthetic */ SourceMeta decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(SourceMeta r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, SourceMeta r101) throws IOException {
                OncallMeta r102 = r101.moncall_meta;
                if (r102 == null) goto L5;
                OncallMeta.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                DocMeta r103 = r101.mdoc_meta;
                if (r103 == null) goto L8;
                DocMeta.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                AppMeta r104 = r101.mapp_meta;
                if (r104 == null) goto L11;
                AppMeta.ADAPTER.encodeWithTag(r100, 3, r104);
            L11:
                WikiMeta r105 = r101.mwiki_meta;
                if (r105 == null) goto L14;
                WikiMeta.ADAPTER.encodeWithTag(r100, 4, r105);
            L14:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SourceMeta r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SourceMeta();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.moncall_meta = this.moncall_meta;
            r100.mdoc_meta = this.mdoc_meta;
            r100.mapp_meta = this.mapp_meta;
            r100.mwiki_meta = this.mwiki_meta;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return SourceMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public SourceMeta(OncallMeta r100, DocMeta r101, AppMeta r102, WikiMeta r110) {
            this(r100, r101, r102, r110, ByteString.EMPTY);
        }

        public SourceMeta(OncallMeta r100, DocMeta r101, AppMeta r102, WikiMeta r103, ByteString r104) {
            super(ADAPTER, r104);
            if (Internal.countNonNull(r100, r101, r102, r103, new Object[0]) > 1) goto L7;
            this.moncall_meta = r100;
            this.mdoc_meta = r101;
            this.mapp_meta = r102;
            this.mwiki_meta = r103;
            return;
        L7:
            throw new IllegalArgumentException("at most one of moncall_meta, mdoc_meta, mapp_meta, mwiki_meta may be non-null");
        }
    }

    public static final enum SourceType extends Enum<SourceType> implements WireEnum {
        private static final /* synthetic */ SourceType[] $VALUES = null;
        public static final ProtoAdapter<SourceType> ADAPTER = null;
        public static final SourceType APP = null;
        public static final SourceType DOC = null;
        public static final SourceType ONCALL = null;
        public static final SourceType UNKNOWN_SOURCE = null;
        public static final SourceType WIKI = null;
        private final int value;

        static {
            SourceType r100 = new SourceType("UNKNOWN_SOURCE", 0, 0);
            UNKNOWN_SOURCE = r100;
            SourceType r101 = new SourceType("ONCALL", 1, 1);
            ONCALL = r101;
            SourceType r102 = new SourceType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 2, 2);
            DOC = r102;
            SourceType r103 = new SourceType("APP", 3, 3);
            APP = r103;
            SourceType r104 = new SourceType("WIKI", 4, 4);
            WIKI = r104;
            $VALUES = new SourceType[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(SourceType.class);
        }

        public static SourceType[] values() {
            return (SourceType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SourceType fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return WIKI;
        L16:
            return APP;
        L18:
            return DOC;
        L20:
            return ONCALL;
        L22:
            return UNKNOWN_SOURCE;
        }

        public static SourceType valueOf(String r100) {
            return (SourceType) a.a(SourceType.class, r100);
        }

        private SourceType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class WikiMeta extends Message<WikiMeta, Builder> {
        public static final ProtoAdapter<WikiMeta> ADAPTER = null;
        public static final String DEFAULT_ANCHOR_URL = "";
        private static final long serialVersionUID = 0;
        public final String manchor_url;

        public static final class Builder extends Message.Builder<WikiMeta, Builder> {
            public String manchor_url;

            @Override // com.squareup.wire.Message.Builder
            public WikiMeta build() {
                return new WikiMeta(this.manchor_url, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder anchor_url(String r100) {
                this.manchor_url = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_WikiMeta extends ProtoAdapter<WikiMeta> {
            public ProtoAdapter_WikiMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, WikiMeta.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public WikiMeta decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.manchor_url = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.manchor_url = ProtoAdapter.STRING.decode(r100);
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
            public int encodedSize2(WikiMeta r100) {
                String r101 = r100.manchor_url;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ WikiMeta decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(WikiMeta r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, WikiMeta r101) throws IOException {
                String r102 = r101.manchor_url;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WikiMeta r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WikiMeta();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.manchor_url = this.manchor_url;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return WikiMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public WikiMeta(String r100) {
            this(r100, ByteString.EMPTY);
        }

        public WikiMeta(String r100, ByteString r101) {
            super(ADAPTER, r101);
            this.manchor_url = r100;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_QACardMeta();
        DEFAULT_UPDATE_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.msource_id = this.msource_id;
        r100.msource_type = this.msource_type;
        r100.msource_meta = this.msource_meta;
        r100.msource_url = this.msource_url;
        r100.mname = this.mname;
        r100.mcategory_name = this.mcategory_name;
        r100.mcategory_desc = this.mcategory_desc;
        r100.mupdate_time = this.mupdate_time;
        r100.mcontent_avatar_key = this.mcontent_avatar_key;
        r100.mrecommended_questions = Internal.copyOf("mrecommended_questions", this.mrecommended_questions);
        r100.mqa_render_meta = this.mqa_render_meta;
        r100.mjump_type = this.mjump_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return QACardMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public QACardMeta(String r110, String r111, SourceType r112, SourceMeta r113, String r210, String r211, String r212, String r213, Long r214, String r215, List<String> r216, String r217, JumpType r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public QACardMeta(String r100, String r101, SourceType r102, SourceMeta r103, String r104, String r105, String r106, String r107, Long r110, String r111, List<String> r112, String r113, JumpType r114, ByteString r115) {
        super(ADAPTER, r115);
        this.mid = r100;
        this.msource_id = r101;
        this.msource_type = r102;
        this.msource_meta = r103;
        this.msource_url = r104;
        this.mname = r105;
        this.mcategory_name = r106;
        this.mcategory_desc = r107;
        this.mupdate_time = r110;
        this.mcontent_avatar_key = r111;
        this.mrecommended_questions = Internal.immutableCopyOf("mrecommended_questions", r112);
        this.mqa_render_meta = r113;
        this.mjump_type = r114;
    }
}
