package com.bytedance.lark.pb.search.v2;

import androidx.camera.video.AudioStats;
import annotation.Debug;
import com.bytedance.lark.pb.search.resource.ResourceMeta;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class SearchResult extends Message<SearchResult, Builder> {
    public static final ProtoAdapter<SearchResult> ADAPTER = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final AvatarType DEFAULT_AVATAR_TYPE = null;
    public static final String DEFAULT_BID = "";
    public static final String DEFAULT_ENTITY_TYPE = "";
    public static final String DEFAULT_EXTRAS_HIGHLIGHTED = "";
    public static final String DEFAULT_EXTRA_INFO_SEPARATOR = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_TRANSLATED = null;
    public static final String DEFAULT_MATCHED_CHINESE_NAME_SEGMENT = "";
    public static final Double DEFAULT_RANK_SCORE = null;
    public static final String DEFAULT_RAW_SUMMARY_HIGHLIGHTED = "";
    public static final String DEFAULT_RAW_TITLE_HIGHLIGHTED = "";
    public static final RecallScene DEFAULT_RECALL_SCENE = null;
    public static final String DEFAULT_RENDER_DATA = "";
    public static final ResultSourceType DEFAULT_SOURCE_TYPE = null;
    public static final String DEFAULT_SUMMARY_HIGHLIGHTED = "";
    public static final String DEFAULT_TITLE_HIGHLIGHTED = "";
    public static final String DEFAULT_TRACKING_META = "";
    public static final SearchEntityType DEFAULT_TYPE = null;
    private static final long serialVersionUID = 0;
    public final String avatar_key;
    public final AvatarType avatar_type;
    public final String bid;
    public final String entity_type;
    public final List<ExplanationTag> explanation_tags;
    public final String extra_info_separator;
    public final List<ExtraInfoBlock> extra_infos;
    public final String extras_highlighted;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253733id;
    public final Boolean is_translated;
    public final String matched_chinese_name_segment;
    public final Double rank_score;
    public final String raw_summary_highlighted;
    public final String raw_title_highlighted;
    public final RecallScene recall_scene;
    public final String render_data;
    public final ResultMeta result_meta;
    public final ResultSourceType source_type;
    public final String summary_highlighted;
    public final String title_highlighted;
    public final String tracking_meta;
    public final SearchEntityType type;

    public static final enum AvatarType extends Enum<AvatarType> implements WireEnum {
        private static final /* synthetic */ AvatarType[] $VALUES = null;
        public static final ProtoAdapter<AvatarType> ADAPTER = null;
        public static final AvatarType CHAT = null;
        public static final AvatarType CHATTER = null;
        public static final AvatarType UNKNOWN = null;
        private final int value;

        static {
            AvatarType r100 = new AvatarType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            AvatarType r101 = new AvatarType("CHAT", 1, 1);
            CHAT = r101;
            AvatarType r102 = new AvatarType("CHATTER", 2, 2);
            CHATTER = r102;
            $VALUES = new AvatarType[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(AvatarType.class);
        }

        public static AvatarType[] values() {
            return (AvatarType[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static AvatarType fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return CHATTER;
        L12:
            return CHAT;
        L14:
            return UNKNOWN;
        }

        public static AvatarType valueOf(String r100) {
            return (AvatarType) a.a(AvatarType.class, r100);
        }

        private AvatarType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<SearchResult, Builder> {
        public String avatar_key;
        public AvatarType avatar_type;
        public String bid;
        public String entity_type;
        public List<ExplanationTag> explanation_tags;
        public String extra_info_separator;
        public List<ExtraInfoBlock> extra_infos;
        public String extras_highlighted;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253734id;
        public Boolean is_translated;
        public String matched_chinese_name_segment;
        public Double rank_score;
        public String raw_summary_highlighted;
        public String raw_title_highlighted;
        public RecallScene recall_scene;
        public String render_data;
        public ResultMeta result_meta;
        public ResultSourceType source_type;
        public String summary_highlighted;
        public String title_highlighted;
        public String tracking_meta;
        public SearchEntityType type;

        @Override // com.squareup.wire.Message.Builder
        public SearchResult build() {
            ResultSourceType r100 = this.source_type;
            if (r100 == null) goto L9;
            if (this.f253734id == null) goto L9;
            return new SearchResult(this.source_type, this.f253734id, this.type, this.rank_score, this.title_highlighted, this.summary_highlighted, this.avatar_key, this.result_meta, this.extras_highlighted, this.explanation_tags, this.extra_infos, this.extra_info_separator, this.is_translated, this.raw_title_highlighted, this.raw_summary_highlighted, this.bid, this.entity_type, this.render_data, this.tracking_meta, this.avatar_type, this.matched_chinese_name_segment, this.recall_scene, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "source_type", this.f253734id, "id"});
        }

        public Builder() {
            this.explanation_tags = Internal.newMutableList();
            this.extra_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder avatar_key(String r100) {
            this.avatar_key = r100;
            return this;
        }

        public Builder avatar_type(AvatarType r100) {
            this.avatar_type = r100;
            return this;
        }

        public Builder bid(String r100) {
            this.bid = r100;
            return this;
        }

        public Builder entity_type(String r100) {
            this.entity_type = r100;
            return this;
        }

        public Builder explanation_tags(List<ExplanationTag> r100) {
            Internal.checkElementsNotNull(r100);
            this.explanation_tags = r100;
            return this;
        }

        public Builder extra_info_separator(String r100) {
            this.extra_info_separator = r100;
            return this;
        }

        public Builder extra_infos(List<ExtraInfoBlock> r100) {
            Internal.checkElementsNotNull(r100);
            this.extra_infos = r100;
            return this;
        }

        public Builder extras_highlighted(String r100) {
            this.extras_highlighted = r100;
            return this;
        }

        public Builder id(String r100) {
            this.f253734id = r100;
            return this;
        }

        public Builder is_translated(Boolean r100) {
            this.is_translated = r100;
            return this;
        }

        public Builder matched_chinese_name_segment(String r100) {
            this.matched_chinese_name_segment = r100;
            return this;
        }

        public Builder rank_score(Double r100) {
            this.rank_score = r100;
            return this;
        }

        public Builder raw_summary_highlighted(String r100) {
            this.raw_summary_highlighted = r100;
            return this;
        }

        public Builder raw_title_highlighted(String r100) {
            this.raw_title_highlighted = r100;
            return this;
        }

        public Builder recall_scene(RecallScene r100) {
            this.recall_scene = r100;
            return this;
        }

        public Builder render_data(String r100) {
            this.render_data = r100;
            return this;
        }

        public Builder result_meta(ResultMeta r100) {
            this.result_meta = r100;
            return this;
        }

        public Builder source_type(ResultSourceType r100) {
            this.source_type = r100;
            return this;
        }

        public Builder summary_highlighted(String r100) {
            this.summary_highlighted = r100;
            return this;
        }

        public Builder title_highlighted(String r100) {
            this.title_highlighted = r100;
            return this;
        }

        public Builder tracking_meta(String r100) {
            this.tracking_meta = r100;
            return this;
        }

        public Builder type(SearchEntityType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchResult extends ProtoAdapter<SearchResult> {
        public ProtoAdapter_SearchResult() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchResult.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchResult decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.source_type = ResultSourceType.DEFAULT;
            r101.f253734id = "";
            r101.type = SearchEntityType.UNKNOWN;
            r101.rank_score = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
            r101.title_highlighted = "";
            r101.summary_highlighted = "";
            r101.avatar_key = "";
            r101.extras_highlighted = "";
            r101.extra_info_separator = "";
            r101.is_translated = Boolean.FALSE;
            r101.raw_title_highlighted = "";
            r101.raw_summary_highlighted = "";
            r101.bid = "";
            r101.entity_type = "";
            r101.render_data = "";
            r101.tracking_meta = "";
            r101.avatar_type = AvatarType.UNKNOWN;
            r101.matched_chinese_name_segment = "";
            r101.recall_scene = RecallScene.DEFAULT;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L43;
            if (r103 != 100) goto L7;
            r101.source_type = ResultSourceType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L41
        L41:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            switch(r103) {
                case 1: goto L38;
                case 2: goto L49;
                case 3: goto L33;
                case 4: goto L32;
                case 5: goto L31;
                case 6: goto L30;
                case 7: goto L29;
                case 8: goto L28;
                case 9: goto L27;
                case 10: goto L26;
                case 11: goto L25;
                case 12: goto L24;
                case 13: goto L23;
                case 14: goto L22;
                case 15: goto L21;
                case 16: goto L20;
                case 17: goto L19;
                case 18: goto L18;
                case 19: goto L45;
                case 20: goto L13;
                case 21: goto L51;
                default: goto L8;
            };
        L45:
            r101.avatar_type = AvatarType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L49:
            r101.type = SearchEntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L36
        L36:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L51:
            r101.recall_scene = RecallScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            r101.matched_chinese_name_segment = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.tracking_meta = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.render_data = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.entity_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.bid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.raw_summary_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.raw_title_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L24:
            r101.is_translated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L25:
            r101.extra_info_separator = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            r101.extra_infos.add(ExtraInfoBlock.ADAPTER.decode(r100));
            goto L3
        L27:
            r101.explanation_tags.add(ExplanationTag.ADAPTER.decode(r100));
            goto L3
        L28:
            r101.extras_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L29:
            r101.result_meta = ResultMeta.ADAPTER.decode(r100);
            goto L3
        L30:
            r101.avatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.summary_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            r101.title_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L33:
            r101.rank_score = ProtoAdapter.DOUBLE.decode(r100);
            goto L3
        L38:
            r101.f253734id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L43:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchResult r100) {
            int r101 = ResultSourceType.ADAPTER.encodedSizeWithTag(100, r100.source_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.encodedSizeWithTag(1, r100.f253733id);
            SearchEntityType r104 = r100.type;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = SearchEntityType.ADAPTER.encodedSizeWithTag(2, r104);
        L6:
            int r107 = r103 + r106;
            Double r108 = r100.rank_score;
            if (r108 == null) goto L9;
            int r109 = ProtoAdapter.DOUBLE.encodedSizeWithTag(3, r108);
        L10:
            int r110 = r107 + r109;
            String r111 = r100.title_highlighted;
            if (r111 == null) goto L13;
            int r112 = r102.encodedSizeWithTag(4, r111);
        L14:
            int r113 = r110 + r112;
            String r114 = r100.summary_highlighted;
            if (r114 == null) goto L17;
            int r115 = r102.encodedSizeWithTag(5, r114);
        L18:
            int r116 = r113 + r115;
            String r117 = r100.avatar_key;
            if (r117 == null) goto L21;
            int r118 = r102.encodedSizeWithTag(6, r117);
        L22:
            int r119 = r116 + r118;
            ResultMeta r120 = r100.result_meta;
            if (r120 == null) goto L25;
            int r121 = ResultMeta.ADAPTER.encodedSizeWithTag(7, r120);
        L26:
            int r122 = r119 + r121;
            String r123 = r100.extras_highlighted;
            if (r123 == null) goto L29;
            int r124 = r102.encodedSizeWithTag(8, r123);
        L30:
            int r125 = ((r122 + r124) + ExplanationTag.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.explanation_tags)) + ExtraInfoBlock.ADAPTER.asRepeated().encodedSizeWithTag(10, r100.extra_infos);
            String r126 = r100.extra_info_separator;
            if (r126 == null) goto L33;
            int r127 = r102.encodedSizeWithTag(11, r126);
        L34:
            int r128 = r125 + r127;
            Boolean r129 = r100.is_translated;
            if (r129 == null) goto L37;
            int r130 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r129);
        L38:
            int r131 = r128 + r130;
            String r132 = r100.raw_title_highlighted;
            if (r132 == null) goto L41;
            int r133 = r102.encodedSizeWithTag(13, r132);
        L42:
            int r134 = r131 + r133;
            String r135 = r100.raw_summary_highlighted;
            if (r135 == null) goto L45;
            int r136 = r102.encodedSizeWithTag(14, r135);
        L46:
            int r137 = r134 + r136;
            String r138 = r100.bid;
            if (r138 == null) goto L49;
            int r139 = r102.encodedSizeWithTag(15, r138);
        L50:
            int r140 = r137 + r139;
            String r141 = r100.entity_type;
            if (r141 == null) goto L53;
            int r142 = r102.encodedSizeWithTag(16, r141);
        L54:
            int r143 = r140 + r142;
            String r144 = r100.render_data;
            if (r144 == null) goto L57;
            int r145 = r102.encodedSizeWithTag(17, r144);
        L58:
            int r146 = r143 + r145;
            String r147 = r100.tracking_meta;
            if (r147 == null) goto L61;
            int r148 = r102.encodedSizeWithTag(18, r147);
        L62:
            int r149 = r146 + r148;
            AvatarType r150 = r100.avatar_type;
            if (r150 == null) goto L65;
            int r151 = AvatarType.ADAPTER.encodedSizeWithTag(19, r150);
        L66:
            int r152 = r149 + r151;
            String r153 = r100.matched_chinese_name_segment;
            if (r153 == null) goto L69;
            int r154 = r102.encodedSizeWithTag(20, r153);
        L70:
            int r155 = r152 + r154;
            RecallScene r156 = r100.recall_scene;
            if (r156 == null) goto L74;
            r105 = RecallScene.ADAPTER.encodedSizeWithTag(21, r156);
        L74:
            return (r155 + r105) + r100.unknownFields().size();
        L69:
            r154 = 0;
            goto L70
        L65:
            r151 = 0;
            goto L66
        L61:
            r148 = 0;
            goto L62
        L57:
            r145 = 0;
            goto L58
        L53:
            r142 = 0;
            goto L54
        L49:
            r139 = 0;
            goto L50
        L45:
            r136 = 0;
            goto L46
        L41:
            r133 = 0;
            goto L42
        L37:
            r130 = 0;
            goto L38
        L33:
            r127 = 0;
            goto L34
        L29:
            r124 = 0;
            goto L30
        L25:
            r121 = 0;
            goto L26
        L21:
            r118 = 0;
            goto L22
        L17:
            r115 = 0;
            goto L18
        L13:
            r112 = 0;
            goto L14
        L9:
            r109 = 0;
            goto L10
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchResult decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchResult r101) throws IOException {
            ResultSourceType.ADAPTER.encodeWithTag(r100, 100, r101.source_type);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.f253733id);
            SearchEntityType r103 = r101.type;
            if (r103 == null) goto L5;
            SearchEntityType.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            Double r104 = r101.rank_score;
            if (r104 == null) goto L8;
            ProtoAdapter.DOUBLE.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.title_highlighted;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.summary_highlighted;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            String r107 = r101.avatar_key;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 6, r107);
        L17:
            ResultMeta r108 = r101.result_meta;
            if (r108 == null) goto L20;
            ResultMeta.ADAPTER.encodeWithTag(r100, 7, r108);
        L20:
            String r109 = r101.extras_highlighted;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 8, r109);
        L23:
            ExplanationTag.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.explanation_tags);
            ExtraInfoBlock.ADAPTER.asRepeated().encodeWithTag(r100, 10, r101.extra_infos);
            String r110 = r101.extra_info_separator;
            if (r110 == null) goto L26;
            r102.encodeWithTag(r100, 11, r110);
        L26:
            Boolean r111 = r101.is_translated;
            if (r111 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r111);
        L29:
            String r112 = r101.raw_title_highlighted;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 13, r112);
        L32:
            String r113 = r101.raw_summary_highlighted;
            if (r113 == null) goto L35;
            r102.encodeWithTag(r100, 14, r113);
        L35:
            String r114 = r101.bid;
            if (r114 == null) goto L38;
            r102.encodeWithTag(r100, 15, r114);
        L38:
            String r115 = r101.entity_type;
            if (r115 == null) goto L41;
            r102.encodeWithTag(r100, 16, r115);
        L41:
            String r116 = r101.render_data;
            if (r116 == null) goto L44;
            r102.encodeWithTag(r100, 17, r116);
        L44:
            String r117 = r101.tracking_meta;
            if (r117 == null) goto L47;
            r102.encodeWithTag(r100, 18, r117);
        L47:
            AvatarType r118 = r101.avatar_type;
            if (r118 == null) goto L50;
            AvatarType.ADAPTER.encodeWithTag(r100, 19, r118);
        L50:
            String r119 = r101.matched_chinese_name_segment;
            if (r119 == null) goto L53;
            r102.encodeWithTag(r100, 20, r119);
        L53:
            RecallScene r120 = r101.recall_scene;
            if (r120 == null) goto L56;
            RecallScene.ADAPTER.encodeWithTag(r100, 21, r120);
        L56:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchResult r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum RecallScene extends Enum<RecallScene> implements WireEnum {
        private static final /* synthetic */ RecallScene[] $VALUES = null;
        public static final ProtoAdapter<RecallScene> ADAPTER = null;
        public static final RecallScene DEFAULT = null;
        public static final RecallScene MESSAGE_PINYIN_TO_CHINESE_NAME = null;
        private final int value;

        static {
            RecallScene r100 = new RecallScene("DEFAULT", 0, 0);
            DEFAULT = r100;
            RecallScene r101 = new RecallScene("MESSAGE_PINYIN_TO_CHINESE_NAME", 1, 1);
            MESSAGE_PINYIN_TO_CHINESE_NAME = r101;
            $VALUES = new RecallScene[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(RecallScene.class);
        }

        public static RecallScene[] values() {
            return (RecallScene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static RecallScene fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return MESSAGE_PINYIN_TO_CHINESE_NAME;
        L10:
            return DEFAULT;
        }

        public static RecallScene valueOf(String r100) {
            return (RecallScene) a.a(RecallScene.class, r100);
        }

        private RecallScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ResultMeta extends Message<ResultMeta, Builder> {
        public static final ProtoAdapter<ResultMeta> ADAPTER = null;
        public static final FieldOptions FIELD_OPTIONS_AGGRE_MESSAGE_META = null;
        public static final FieldOptions FIELD_OPTIONS_APP_META = null;
        public static final FieldOptions FIELD_OPTIONS_BANNER_META = null;
        public static final FieldOptions FIELD_OPTIONS_BOT_META = null;
        public static final FieldOptions FIELD_OPTIONS_CRYPTO_P2P_CHAT_META = null;
        public static final FieldOptions FIELD_OPTIONS_CUSTOMIZATION_META = null;
        public static final FieldOptions FIELD_OPTIONS_DEPARTMENT_META = null;
        public static final FieldOptions FIELD_OPTIONS_DOC_META = null;
        public static final FieldOptions FIELD_OPTIONS_FACILITY_META = null;
        public static final FieldOptions FIELD_OPTIONS_GROUP_CHAT_META = null;
        public static final FieldOptions FIELD_OPTIONS_MAIL_CONTACT_META = null;
        public static final FieldOptions FIELD_OPTIONS_MESSAGE_FILE_META = null;
        public static final FieldOptions FIELD_OPTIONS_MESSAGE_META = null;
        public static final FieldOptions FIELD_OPTIONS_MY_AI_META = null;
        public static final FieldOptions FIELD_OPTIONS_ONCALL_META = null;
        public static final FieldOptions FIELD_OPTIONS_QA_CARD_META = null;
        public static final FieldOptions FIELD_OPTIONS_RESOURCE_META = null;
        public static final FieldOptions FIELD_OPTIONS_SECTION_META = null;
        public static final FieldOptions FIELD_OPTIONS_SHIELD_P2P_CHAT_META = null;
        public static final FieldOptions FIELD_OPTIONS_SLASH_COMMAND_META = null;
        public static final FieldOptions FIELD_OPTIONS_THREAD_META = null;
        public static final FieldOptions FIELD_OPTIONS_URL_META = null;
        public static final FieldOptions FIELD_OPTIONS_USER_GROUP_META = null;
        public static final FieldOptions FIELD_OPTIONS_USER_META = null;
        public static final FieldOptions FIELD_OPTIONS_WIKI_META = null;
        public static final FieldOptions FIELD_OPTIONS_WIKI_SPACE_META = null;
        private static final long serialVersionUID = 0;
        public final AggregatedMessageMeta aggre_message_meta;
        public final AppMeta app_meta;
        public final BannerMeta banner_meta;
        public final BotMeta bot_meta;
        public final CryptoP2PChatMeta crypto_p2p_chat_meta;
        public final CustomizationMeta customization_meta;
        public final DepartmentMeta department_meta;
        public final DocMeta doc_meta;
        public final FacilityMeta facility_meta;
        public final ChatMeta group_chat_meta;
        public final MailContactMeta mail_contact_meta;
        public final MessageFileMeta message_file_meta;
        public final MessageMeta message_meta;
        public final MyAIMeta my_ai_meta;
        public final OncallMeta oncall_meta;
        public final QaCardMeta qa_card_meta;
        public final ResourceMeta resource_meta;
        public final SectionMeta section_meta;
        public final ShieldP2PChatMeta shield_p2p_chat_meta;
        public final SlashCommandMeta slash_command_meta;
        public final ThreadMeta thread_meta;
        public final URLMeta url_meta;
        public final UserGroupMeta user_group_meta;
        public final UserMeta user_meta;
        public final WikiMeta wiki_meta;
        public final WikiSpaceMeta wiki_space_meta;

        public static final class Builder extends Message.Builder<ResultMeta, Builder> {
            public AggregatedMessageMeta aggre_message_meta;
            public AppMeta app_meta;
            public BannerMeta banner_meta;
            public BotMeta bot_meta;
            public CryptoP2PChatMeta crypto_p2p_chat_meta;
            public CustomizationMeta customization_meta;
            public DepartmentMeta department_meta;
            public DocMeta doc_meta;
            public FacilityMeta facility_meta;
            public ChatMeta group_chat_meta;
            public MailContactMeta mail_contact_meta;
            public MessageFileMeta message_file_meta;
            public MessageMeta message_meta;
            public MyAIMeta my_ai_meta;
            public OncallMeta oncall_meta;
            public QaCardMeta qa_card_meta;
            public ResourceMeta resource_meta;
            public SectionMeta section_meta;
            public ShieldP2PChatMeta shield_p2p_chat_meta;
            public SlashCommandMeta slash_command_meta;
            public ThreadMeta thread_meta;
            public URLMeta url_meta;
            public UserGroupMeta user_group_meta;
            public UserMeta user_meta;
            public WikiMeta wiki_meta;
            public WikiSpaceMeta wiki_space_meta;

            @Override // com.squareup.wire.Message.Builder
            public ResultMeta build() {
                return new ResultMeta(this.user_meta, this.bot_meta, this.group_chat_meta, this.crypto_p2p_chat_meta, this.message_meta, this.oncall_meta, this.thread_meta, this.url_meta, this.qa_card_meta, this.app_meta, this.department_meta, this.doc_meta, this.wiki_meta, this.slash_command_meta, this.section_meta, this.resource_meta, this.customization_meta, this.facility_meta, this.mail_contact_meta, this.banner_meta, this.shield_p2p_chat_meta, this.wiki_space_meta, this.user_group_meta, this.message_file_meta, this.my_ai_meta, this.aggre_message_meta, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder aggre_message_meta(AggregatedMessageMeta r100) {
                this.aggre_message_meta = r100;
                return this;
            }

            public Builder app_meta(AppMeta r100) {
                this.app_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder banner_meta(BannerMeta r100) {
                this.banner_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder bot_meta(BotMeta r100) {
                this.bot_meta = r100;
                this.user_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder crypto_p2p_chat_meta(CryptoP2PChatMeta r100) {
                this.crypto_p2p_chat_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder customization_meta(CustomizationMeta r100) {
                this.customization_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder department_meta(DepartmentMeta r100) {
                this.department_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder doc_meta(DocMeta r100) {
                this.doc_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder facility_meta(FacilityMeta r100) {
                this.facility_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder group_chat_meta(ChatMeta r100) {
                this.group_chat_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder mail_contact_meta(MailContactMeta r100) {
                this.mail_contact_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder message_file_meta(MessageFileMeta r100) {
                this.message_file_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder message_meta(MessageMeta r100) {
                this.message_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder my_ai_meta(MyAIMeta r100) {
                this.my_ai_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                return this;
            }

            public Builder oncall_meta(OncallMeta r100) {
                this.oncall_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder qa_card_meta(QaCardMeta r100) {
                this.qa_card_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder resource_meta(ResourceMeta r100) {
                this.resource_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder section_meta(SectionMeta r100) {
                this.section_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder shield_p2p_chat_meta(ShieldP2PChatMeta r100) {
                this.shield_p2p_chat_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder slash_command_meta(SlashCommandMeta r100) {
                this.slash_command_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder thread_meta(ThreadMeta r100) {
                this.thread_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder url_meta(URLMeta r100) {
                this.url_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder user_group_meta(UserGroupMeta r100) {
                this.user_group_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder user_meta(UserMeta r100) {
                this.user_meta = r100;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder wiki_meta(WikiMeta r100) {
                this.wiki_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.wiki_space_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }

            public Builder wiki_space_meta(WikiSpaceMeta r100) {
                this.wiki_space_meta = r100;
                this.user_meta = null;
                this.bot_meta = null;
                this.group_chat_meta = null;
                this.crypto_p2p_chat_meta = null;
                this.message_meta = null;
                this.oncall_meta = null;
                this.thread_meta = null;
                this.url_meta = null;
                this.qa_card_meta = null;
                this.app_meta = null;
                this.department_meta = null;
                this.doc_meta = null;
                this.wiki_meta = null;
                this.slash_command_meta = null;
                this.section_meta = null;
                this.resource_meta = null;
                this.customization_meta = null;
                this.facility_meta = null;
                this.mail_contact_meta = null;
                this.banner_meta = null;
                this.shield_p2p_chat_meta = null;
                this.user_group_meta = null;
                this.message_file_meta = null;
                this.my_ai_meta = null;
                return this;
            }
        }

        public static final class ProtoAdapter_ResultMeta extends ProtoAdapter<ResultMeta> {
            public ProtoAdapter_ResultMeta() {
                super(FieldEncoding.LENGTH_DELIMITED, ResultMeta.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ResultMeta decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L33;
                switch(r103) {
                    case 1: goto L32;
                    case 2: goto L31;
                    case 3: goto L6;
                    case 4: goto L30;
                    case 5: goto L29;
                    case 6: goto L28;
                    case 7: goto L27;
                    case 8: goto L26;
                    case 9: goto L25;
                    case 10: goto L24;
                    case 11: goto L6;
                    case 12: goto L23;
                    case 13: goto L22;
                    case 14: goto L21;
                    case 15: goto L6;
                    case 16: goto L6;
                    case 17: goto L6;
                    case 18: goto L6;
                    case 19: goto L20;
                    case 20: goto L19;
                    case 21: goto L18;
                    case 22: goto L17;
                    case 23: goto L16;
                    case 24: goto L15;
                    case 25: goto L14;
                    case 26: goto L13;
                    case 27: goto L12;
                    case 28: goto L11;
                    case 29: goto L10;
                    case 30: goto L9;
                    case 31: goto L8;
                    case 32: goto L7;
                    default: goto L6;
                };
            L7:
                r101.my_ai_meta(MyAIMeta.ADAPTER.decode(r100));
                goto L3
            L8:
                r101.message_file_meta(MessageFileMeta.ADAPTER.decode(r100));
                goto L3
            L9:
                r101.user_group_meta(UserGroupMeta.ADAPTER.decode(r100));
                goto L3
            L10:
                r101.wiki_space_meta(WikiSpaceMeta.ADAPTER.decode(r100));
                goto L3
            L11:
                r101.shield_p2p_chat_meta(ShieldP2PChatMeta.ADAPTER.decode(r100));
                goto L3
            L12:
                r101.banner_meta(BannerMeta.ADAPTER.decode(r100));
                goto L3
            L13:
                r101.mail_contact_meta(MailContactMeta.ADAPTER.decode(r100));
                goto L3
            L14:
                r101.aggre_message_meta(AggregatedMessageMeta.ADAPTER.decode(r100));
                goto L3
            L15:
                r101.facility_meta(FacilityMeta.ADAPTER.decode(r100));
                goto L3
            L16:
                r101.resource_meta(ResourceMeta.ADAPTER.decode(r100));
                goto L3
            L17:
                r101.section_meta(SectionMeta.ADAPTER.decode(r100));
                goto L3
            L18:
                r101.department_meta(DepartmentMeta.ADAPTER.decode(r100));
                goto L3
            L19:
                r101.crypto_p2p_chat_meta(CryptoP2PChatMeta.ADAPTER.decode(r100));
                goto L3
            L20:
                r101.group_chat_meta(ChatMeta.ADAPTER.decode(r100));
                goto L3
            L21:
                r101.customization_meta(CustomizationMeta.ADAPTER.decode(r100));
                goto L3
            L22:
                r101.slash_command_meta(SlashCommandMeta.ADAPTER.decode(r100));
                goto L3
            L23:
                r101.wiki_meta(WikiMeta.ADAPTER.decode(r100));
                goto L3
            L24:
                r101.doc_meta(DocMeta.ADAPTER.decode(r100));
                goto L3
            L25:
                r101.app_meta(AppMeta.ADAPTER.decode(r100));
                goto L3
            L26:
                r101.qa_card_meta(QaCardMeta.ADAPTER.decode(r100));
                goto L3
            L27:
                r101.url_meta(URLMeta.ADAPTER.decode(r100));
                goto L3
            L28:
                r101.thread_meta(ThreadMeta.ADAPTER.decode(r100));
                goto L3
            L29:
                r101.oncall_meta(OncallMeta.ADAPTER.decode(r100));
                goto L3
            L30:
                r101.message_meta(MessageMeta.ADAPTER.decode(r100));
                goto L3
            L31:
                r101.bot_meta(BotMeta.ADAPTER.decode(r100));
                goto L3
            L32:
                r101.user_meta(UserMeta.ADAPTER.decode(r100));
                goto L3
            L6:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L33:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ResultMeta r100) {
                UserMeta r101 = r100.user_meta;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = UserMeta.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                BotMeta r104 = r100.bot_meta;
                if (r104 == null) goto L9;
                int r105 = BotMeta.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                ChatMeta r107 = r100.group_chat_meta;
                if (r107 == null) goto L13;
                int r108 = ChatMeta.ADAPTER.encodedSizeWithTag(19, r107);
            L14:
                int r109 = r106 + r108;
                CryptoP2PChatMeta r110 = r100.crypto_p2p_chat_meta;
                if (r110 == null) goto L17;
                int r111 = CryptoP2PChatMeta.ADAPTER.encodedSizeWithTag(20, r110);
            L18:
                int r112 = r109 + r111;
                MessageMeta r113 = r100.message_meta;
                if (r113 == null) goto L21;
                int r114 = MessageMeta.ADAPTER.encodedSizeWithTag(4, r113);
            L22:
                int r115 = r112 + r114;
                OncallMeta r116 = r100.oncall_meta;
                if (r116 == null) goto L25;
                int r117 = OncallMeta.ADAPTER.encodedSizeWithTag(5, r116);
            L26:
                int r118 = r115 + r117;
                ThreadMeta r119 = r100.thread_meta;
                if (r119 == null) goto L29;
                int r120 = ThreadMeta.ADAPTER.encodedSizeWithTag(6, r119);
            L30:
                int r121 = r118 + r120;
                URLMeta r122 = r100.url_meta;
                if (r122 == null) goto L33;
                int r123 = URLMeta.ADAPTER.encodedSizeWithTag(7, r122);
            L34:
                int r124 = r121 + r123;
                QaCardMeta r125 = r100.qa_card_meta;
                if (r125 == null) goto L37;
                int r126 = QaCardMeta.ADAPTER.encodedSizeWithTag(8, r125);
            L38:
                int r127 = r124 + r126;
                AppMeta r128 = r100.app_meta;
                if (r128 == null) goto L41;
                int r129 = AppMeta.ADAPTER.encodedSizeWithTag(9, r128);
            L42:
                int r130 = r127 + r129;
                DepartmentMeta r131 = r100.department_meta;
                if (r131 == null) goto L45;
                int r132 = DepartmentMeta.ADAPTER.encodedSizeWithTag(21, r131);
            L46:
                int r133 = r130 + r132;
                DocMeta r134 = r100.doc_meta;
                if (r134 == null) goto L49;
                int r135 = DocMeta.ADAPTER.encodedSizeWithTag(10, r134);
            L50:
                int r136 = r133 + r135;
                WikiMeta r137 = r100.wiki_meta;
                if (r137 == null) goto L53;
                int r138 = WikiMeta.ADAPTER.encodedSizeWithTag(12, r137);
            L54:
                int r139 = r136 + r138;
                SlashCommandMeta r140 = r100.slash_command_meta;
                if (r140 == null) goto L57;
                int r141 = SlashCommandMeta.ADAPTER.encodedSizeWithTag(13, r140);
            L58:
                int r142 = r139 + r141;
                SectionMeta r143 = r100.section_meta;
                if (r143 == null) goto L61;
                int r144 = SectionMeta.ADAPTER.encodedSizeWithTag(22, r143);
            L62:
                int r145 = r142 + r144;
                ResourceMeta r146 = r100.resource_meta;
                if (r146 == null) goto L65;
                int r147 = ResourceMeta.ADAPTER.encodedSizeWithTag(23, r146);
            L66:
                int r148 = r145 + r147;
                CustomizationMeta r149 = r100.customization_meta;
                if (r149 == null) goto L69;
                int r150 = CustomizationMeta.ADAPTER.encodedSizeWithTag(14, r149);
            L70:
                int r151 = r148 + r150;
                FacilityMeta r152 = r100.facility_meta;
                if (r152 == null) goto L73;
                int r153 = FacilityMeta.ADAPTER.encodedSizeWithTag(24, r152);
            L74:
                int r154 = r151 + r153;
                MailContactMeta r155 = r100.mail_contact_meta;
                if (r155 == null) goto L77;
                int r156 = MailContactMeta.ADAPTER.encodedSizeWithTag(26, r155);
            L78:
                int r157 = r154 + r156;
                BannerMeta r158 = r100.banner_meta;
                if (r158 == null) goto L81;
                int r159 = BannerMeta.ADAPTER.encodedSizeWithTag(27, r158);
            L82:
                int r160 = r157 + r159;
                ShieldP2PChatMeta r161 = r100.shield_p2p_chat_meta;
                if (r161 == null) goto L85;
                int r162 = ShieldP2PChatMeta.ADAPTER.encodedSizeWithTag(28, r161);
            L86:
                int r163 = r160 + r162;
                WikiSpaceMeta r164 = r100.wiki_space_meta;
                if (r164 == null) goto L89;
                int r165 = WikiSpaceMeta.ADAPTER.encodedSizeWithTag(29, r164);
            L90:
                int r166 = r163 + r165;
                UserGroupMeta r167 = r100.user_group_meta;
                if (r167 == null) goto L93;
                int r168 = UserGroupMeta.ADAPTER.encodedSizeWithTag(30, r167);
            L94:
                int r169 = r166 + r168;
                MessageFileMeta r170 = r100.message_file_meta;
                if (r170 == null) goto L97;
                int r171 = MessageFileMeta.ADAPTER.encodedSizeWithTag(31, r170);
            L98:
                int r172 = r169 + r171;
                MyAIMeta r173 = r100.my_ai_meta;
                if (r173 == null) goto L101;
                int r174 = MyAIMeta.ADAPTER.encodedSizeWithTag(32, r173);
            L102:
                int r175 = r172 + r174;
                AggregatedMessageMeta r176 = r100.aggre_message_meta;
                if (r176 == null) goto L106;
                r102 = AggregatedMessageMeta.ADAPTER.encodedSizeWithTag(25, r176);
            L106:
                return (r175 + r102) + r100.unknownFields().size();
            L101:
                r174 = 0;
                goto L102
            L97:
                r171 = 0;
                goto L98
            L93:
                r168 = 0;
                goto L94
            L89:
                r165 = 0;
                goto L90
            L85:
                r162 = 0;
                goto L86
            L81:
                r159 = 0;
                goto L82
            L77:
                r156 = 0;
                goto L78
            L73:
                r153 = 0;
                goto L74
            L69:
                r150 = 0;
                goto L70
            L65:
                r147 = 0;
                goto L66
            L61:
                r144 = 0;
                goto L62
            L57:
                r141 = 0;
                goto L58
            L53:
                r138 = 0;
                goto L54
            L49:
                r135 = 0;
                goto L50
            L45:
                r132 = 0;
                goto L46
            L41:
                r129 = 0;
                goto L42
            L37:
                r126 = 0;
                goto L38
            L33:
                r123 = 0;
                goto L34
            L29:
                r120 = 0;
                goto L30
            L25:
                r117 = 0;
                goto L26
            L21:
                r114 = 0;
                goto L22
            L17:
                r111 = 0;
                goto L18
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
            public /* bridge */ /* synthetic */ ResultMeta decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ResultMeta r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ResultMeta r101) throws IOException {
                UserMeta r102 = r101.user_meta;
                if (r102 == null) goto L5;
                UserMeta.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                BotMeta r103 = r101.bot_meta;
                if (r103 == null) goto L8;
                BotMeta.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                ChatMeta r104 = r101.group_chat_meta;
                if (r104 == null) goto L11;
                ChatMeta.ADAPTER.encodeWithTag(r100, 19, r104);
            L11:
                CryptoP2PChatMeta r105 = r101.crypto_p2p_chat_meta;
                if (r105 == null) goto L14;
                CryptoP2PChatMeta.ADAPTER.encodeWithTag(r100, 20, r105);
            L14:
                MessageMeta r106 = r101.message_meta;
                if (r106 == null) goto L17;
                MessageMeta.ADAPTER.encodeWithTag(r100, 4, r106);
            L17:
                OncallMeta r107 = r101.oncall_meta;
                if (r107 == null) goto L20;
                OncallMeta.ADAPTER.encodeWithTag(r100, 5, r107);
            L20:
                ThreadMeta r108 = r101.thread_meta;
                if (r108 == null) goto L23;
                ThreadMeta.ADAPTER.encodeWithTag(r100, 6, r108);
            L23:
                URLMeta r109 = r101.url_meta;
                if (r109 == null) goto L26;
                URLMeta.ADAPTER.encodeWithTag(r100, 7, r109);
            L26:
                QaCardMeta r110 = r101.qa_card_meta;
                if (r110 == null) goto L29;
                QaCardMeta.ADAPTER.encodeWithTag(r100, 8, r110);
            L29:
                AppMeta r111 = r101.app_meta;
                if (r111 == null) goto L32;
                AppMeta.ADAPTER.encodeWithTag(r100, 9, r111);
            L32:
                DepartmentMeta r112 = r101.department_meta;
                if (r112 == null) goto L35;
                DepartmentMeta.ADAPTER.encodeWithTag(r100, 21, r112);
            L35:
                DocMeta r113 = r101.doc_meta;
                if (r113 == null) goto L38;
                DocMeta.ADAPTER.encodeWithTag(r100, 10, r113);
            L38:
                WikiMeta r114 = r101.wiki_meta;
                if (r114 == null) goto L41;
                WikiMeta.ADAPTER.encodeWithTag(r100, 12, r114);
            L41:
                SlashCommandMeta r115 = r101.slash_command_meta;
                if (r115 == null) goto L44;
                SlashCommandMeta.ADAPTER.encodeWithTag(r100, 13, r115);
            L44:
                SectionMeta r116 = r101.section_meta;
                if (r116 == null) goto L47;
                SectionMeta.ADAPTER.encodeWithTag(r100, 22, r116);
            L47:
                ResourceMeta r117 = r101.resource_meta;
                if (r117 == null) goto L50;
                ResourceMeta.ADAPTER.encodeWithTag(r100, 23, r117);
            L50:
                CustomizationMeta r118 = r101.customization_meta;
                if (r118 == null) goto L53;
                CustomizationMeta.ADAPTER.encodeWithTag(r100, 14, r118);
            L53:
                FacilityMeta r119 = r101.facility_meta;
                if (r119 == null) goto L56;
                FacilityMeta.ADAPTER.encodeWithTag(r100, 24, r119);
            L56:
                MailContactMeta r120 = r101.mail_contact_meta;
                if (r120 == null) goto L59;
                MailContactMeta.ADAPTER.encodeWithTag(r100, 26, r120);
            L59:
                BannerMeta r121 = r101.banner_meta;
                if (r121 == null) goto L62;
                BannerMeta.ADAPTER.encodeWithTag(r100, 27, r121);
            L62:
                ShieldP2PChatMeta r122 = r101.shield_p2p_chat_meta;
                if (r122 == null) goto L65;
                ShieldP2PChatMeta.ADAPTER.encodeWithTag(r100, 28, r122);
            L65:
                WikiSpaceMeta r123 = r101.wiki_space_meta;
                if (r123 == null) goto L68;
                WikiSpaceMeta.ADAPTER.encodeWithTag(r100, 29, r123);
            L68:
                UserGroupMeta r124 = r101.user_group_meta;
                if (r124 == null) goto L71;
                UserGroupMeta.ADAPTER.encodeWithTag(r100, 30, r124);
            L71:
                MessageFileMeta r125 = r101.message_file_meta;
                if (r125 == null) goto L74;
                MessageFileMeta.ADAPTER.encodeWithTag(r100, 31, r125);
            L74:
                MyAIMeta r126 = r101.my_ai_meta;
                if (r126 == null) goto L77;
                MyAIMeta.ADAPTER.encodeWithTag(r100, 32, r126);
            L77:
                AggregatedMessageMeta r127 = r101.aggre_message_meta;
                if (r127 == null) goto L80;
                AggregatedMessageMeta.ADAPTER.encodeWithTag(r100, 25, r127);
            L80:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ResultMeta r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ResultMeta();
            FIELD_OPTIONS_USER_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_BOT_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_GROUP_CHAT_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_CRYPTO_P2P_CHAT_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_MESSAGE_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_ONCALL_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_THREAD_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_URL_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_QA_CARD_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_APP_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_DEPARTMENT_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_DOC_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_WIKI_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_SLASH_COMMAND_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_SECTION_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_RESOURCE_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_CUSTOMIZATION_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_FACILITY_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_MAIL_CONTACT_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_BANNER_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_SHIELD_P2P_CHAT_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_WIKI_SPACE_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_USER_GROUP_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_MESSAGE_FILE_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_MY_AI_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
            FIELD_OPTIONS_AGGRE_MESSAGE_META = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.user_meta = this.user_meta;
            r100.bot_meta = this.bot_meta;
            r100.group_chat_meta = this.group_chat_meta;
            r100.crypto_p2p_chat_meta = this.crypto_p2p_chat_meta;
            r100.message_meta = this.message_meta;
            r100.oncall_meta = this.oncall_meta;
            r100.thread_meta = this.thread_meta;
            r100.url_meta = this.url_meta;
            r100.qa_card_meta = this.qa_card_meta;
            r100.app_meta = this.app_meta;
            r100.department_meta = this.department_meta;
            r100.doc_meta = this.doc_meta;
            r100.wiki_meta = this.wiki_meta;
            r100.slash_command_meta = this.slash_command_meta;
            r100.section_meta = this.section_meta;
            r100.resource_meta = this.resource_meta;
            r100.customization_meta = this.customization_meta;
            r100.facility_meta = this.facility_meta;
            r100.mail_contact_meta = this.mail_contact_meta;
            r100.banner_meta = this.banner_meta;
            r100.shield_p2p_chat_meta = this.shield_p2p_chat_meta;
            r100.wiki_space_meta = this.wiki_space_meta;
            r100.user_group_meta = this.user_group_meta;
            r100.message_file_meta = this.message_file_meta;
            r100.my_ai_meta = this.my_ai_meta;
            r100.aggre_message_meta = this.aggre_message_meta;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ResultMeta.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ResultMeta(UserMeta r210, BotMeta r310, ChatMeta r311, CryptoP2PChatMeta r312, MessageMeta r313, OncallMeta r314, ThreadMeta r315, URLMeta r316, QaCardMeta r317, AppMeta r318, DepartmentMeta r319, DocMeta r410, WikiMeta r411, SlashCommandMeta r412, SectionMeta r413, ResourceMeta r414, CustomizationMeta r415, FacilityMeta r416, MailContactMeta r417, BannerMeta r418, ShieldP2PChatMeta r419, WikiSpaceMeta r510, UserGroupMeta r511, MessageFileMeta r512, MyAIMeta r513, AggregatedMessageMeta r514) {
            this(r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, ByteString.EMPTY);
        }

        public ResultMeta(UserMeta r110, BotMeta r111, ChatMeta r210, CryptoP2PChatMeta r211, MessageMeta r212, OncallMeta r213, ThreadMeta r214, URLMeta r215, QaCardMeta r216, AppMeta r217, DepartmentMeta r218, DocMeta r219, WikiMeta r310, SlashCommandMeta r311, SectionMeta r312, ResourceMeta r313, CustomizationMeta r314, FacilityMeta r315, MailContactMeta r316, BannerMeta r317, ShieldP2PChatMeta r318, WikiSpaceMeta r319, UserGroupMeta r410, MessageFileMeta r411, MyAIMeta r412, AggregatedMessageMeta r413, ByteString r414) {
            super(ADAPTER, r414);
            if (Internal.countNonNull(r110, r111, r210, r211, new Object[]{r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412}) > 1) goto L7;
            this.user_meta = r110;
            this.bot_meta = r111;
            this.group_chat_meta = r210;
            this.crypto_p2p_chat_meta = r211;
            this.message_meta = r212;
            this.oncall_meta = r213;
            this.thread_meta = r214;
            this.url_meta = r215;
            this.qa_card_meta = r216;
            this.app_meta = r217;
            this.department_meta = r218;
            this.doc_meta = r219;
            this.wiki_meta = r310;
            this.slash_command_meta = r311;
            this.section_meta = r312;
            this.resource_meta = r313;
            this.customization_meta = r314;
            this.facility_meta = r315;
            this.mail_contact_meta = r316;
            this.banner_meta = r317;
            this.shield_p2p_chat_meta = r318;
            this.wiki_space_meta = r319;
            this.user_group_meta = r410;
            this.message_file_meta = r411;
            this.my_ai_meta = r412;
            this.aggre_message_meta = r413;
            return;
        L7:
            throw new IllegalArgumentException("at most one of user_meta, bot_meta, group_chat_meta, crypto_p2p_chat_meta, message_meta, oncall_meta, thread_meta, url_meta, qa_card_meta, app_meta, department_meta, doc_meta, wiki_meta, slash_command_meta, section_meta, resource_meta, customization_meta, facility_meta, mail_contact_meta, banner_meta, shield_p2p_chat_meta, wiki_space_meta, user_group_meta, message_file_meta, my_ai_meta may be non-null");
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchResult();
        DEFAULT_SOURCE_TYPE = ResultSourceType.DEFAULT;
        DEFAULT_TYPE = SearchEntityType.UNKNOWN;
        DEFAULT_RANK_SCORE = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        DEFAULT_IS_TRANSLATED = Boolean.FALSE;
        DEFAULT_AVATAR_TYPE = AvatarType.UNKNOWN;
        DEFAULT_RECALL_SCENE = RecallScene.DEFAULT;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_type = this.source_type;
        r100.f253734id = this.f253733id;
        r100.type = this.type;
        r100.rank_score = this.rank_score;
        r100.title_highlighted = this.title_highlighted;
        r100.summary_highlighted = this.summary_highlighted;
        r100.avatar_key = this.avatar_key;
        r100.result_meta = this.result_meta;
        r100.extras_highlighted = this.extras_highlighted;
        r100.explanation_tags = Internal.copyOf("explanation_tags", this.explanation_tags);
        r100.extra_infos = Internal.copyOf("extra_infos", this.extra_infos);
        r100.extra_info_separator = this.extra_info_separator;
        r100.is_translated = this.is_translated;
        r100.raw_title_highlighted = this.raw_title_highlighted;
        r100.raw_summary_highlighted = this.raw_summary_highlighted;
        r100.bid = this.bid;
        r100.entity_type = this.entity_type;
        r100.render_data = this.render_data;
        r100.tracking_meta = this.tracking_meta;
        r100.avatar_type = this.avatar_type;
        r100.matched_chinese_name_segment = this.matched_chinese_name_segment;
        r100.recall_scene = this.recall_scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchResult.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchResult(ResultSourceType r210, String r211, SearchEntityType r212, Double r213, String r214, String r310, String r311, ResultMeta r312, String r313, List<ExplanationTag> r314, List<ExtraInfoBlock> r315, String r316, Boolean r317, String r318, String r319, String r410, String r411, String r412, String r413, AvatarType r414, String r415, RecallScene r416) {
        this(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, ByteString.EMPTY);
    }

    public SearchResult(ResultSourceType r100, String r101, SearchEntityType r102, Double r103, String r104, String r105, String r110, ResultMeta r111, String r112, List<ExplanationTag> r113, List<ExtraInfoBlock> r114, String r115, Boolean r116, String r117, String r118, String r119, String r210, String r211, String r212, AvatarType r213, String r214, RecallScene r215, ByteString r216) {
        super(ADAPTER, r216);
        this.source_type = r100;
        this.f253733id = r101;
        this.type = r102;
        this.rank_score = r103;
        this.title_highlighted = r104;
        this.summary_highlighted = r105;
        this.avatar_key = r110;
        this.result_meta = r111;
        this.extras_highlighted = r112;
        this.explanation_tags = Internal.immutableCopyOf("explanation_tags", r113);
        this.extra_infos = Internal.immutableCopyOf("extra_infos", r114);
        this.extra_info_separator = r115;
        this.is_translated = r116;
        this.raw_title_highlighted = r117;
        this.raw_summary_highlighted = r118;
        this.bid = r119;
        this.entity_type = r210;
        this.render_data = r211;
        this.tracking_meta = r212;
        this.avatar_type = r213;
        this.matched_chinese_name_segment = r214;
        this.recall_scene = r215;
    }
}
