package com.ss.android.lark.pb.usearch;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.security.AuthEntity;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class SearchResult extends Message<SearchResult, Builder> {
    public static final ProtoAdapter<SearchResult> ADAPTER = null;
    public static final String DEFAULT_AUTHZ_ID = "";
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_BID = "";
    public static final String DEFAULT_ENTITY_TYPE = "";
    public static final String DEFAULT_EXTRAS_HIGHLIGHTED = "";
    public static final String DEFAULT_EXTRA_INFO_SEPARATOR = "";
    public static final String DEFAULT_ID = "";
    public static final Boolean DEFAULT_IS_TRANSLATED = null;
    public static final String DEFAULT_RAW_SUMMARY_HIGHLIGHTED = "";
    public static final String DEFAULT_RAW_TITLE_HIGHLIGHTED = "";
    public static final String DEFAULT_RENDER_DATA = "";
    public static final String DEFAULT_SUMMARY_HIGHLIGHTED = "";
    public static final String DEFAULT_TITLE_HIGHLIGHTED = "";
    public static final String DEFAULT_TRACKING_META = "";
    public static final FieldOptions FIELD_OPTIONS_MAUTHZ_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MRESULT_META = null;
    public static final FieldOptions FIELD_OPTIONS_MTYPE = null;
    private static final long serialVersionUID = 0;
    public final String mauthz_id;
    public final String mavatar_key;
    public final AvatarType mavatar_type;
    public final List<BaikeEntry> mbaike_entries;
    public final String mbid;
    public final String mentity_type;
    public final List<ExplanationTag> mexplanation_tags;
    public final String mextra_info_separator;
    public final List<ExtraInfoBlock> mextra_infos;
    public final String mextras_highlighted;
    public final String mid;
    public final Boolean mis_translated;
    public final List<ParsingInfo> mparsing_infos;
    public final String mraw_summary_highlighted;
    public final String mraw_title_highlighted;
    public final RecallScene mrecall_scene;
    public final String mrender_data;
    public final ResultMeta mresult_meta;
    public final String msummary_highlighted;
    public final String mtitle_highlighted;
    public final String mtracking_meta;
    public final SearchEntityType mtype;

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
        public String mauthz_id;
        public String mavatar_key;
        public AvatarType mavatar_type;
        public List<BaikeEntry> mbaike_entries;
        public String mbid;
        public String mentity_type;
        public List<ExplanationTag> mexplanation_tags;
        public String mextra_info_separator;
        public List<ExtraInfoBlock> mextra_infos;
        public String mextras_highlighted;
        public String mid;
        public Boolean mis_translated;
        public List<ParsingInfo> mparsing_infos;
        public String mraw_summary_highlighted;
        public String mraw_title_highlighted;
        public RecallScene mrecall_scene;
        public String mrender_data;
        public ResultMeta mresult_meta;
        public String msummary_highlighted;
        public String mtitle_highlighted;
        public String mtracking_meta;
        public SearchEntityType mtype;

        @Override // com.squareup.wire.Message.Builder
        public SearchResult build() {
            String r100 = this.mid;
            if (r100 == null) goto L7;
            return new SearchResult(this.mid, this.mtype, this.mtitle_highlighted, this.msummary_highlighted, this.mextras_highlighted, this.mavatar_key, this.mresult_meta, this.mexplanation_tags, this.mextra_infos, this.mextra_info_separator, this.mbaike_entries, this.mis_translated, this.mraw_title_highlighted, this.mraw_summary_highlighted, this.mbid, this.mentity_type, this.mauthz_id, this.mtracking_meta, this.mrender_data, this.mparsing_infos, this.mavatar_type, this.mrecall_scene, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mid"});
        }

        public Builder() {
            this.mexplanation_tags = Internal.newMutableList();
            this.mextra_infos = Internal.newMutableList();
            this.mbaike_entries = Internal.newMutableList();
            this.mparsing_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder authz_id(String r100) {
            this.mauthz_id = r100;
            return this;
        }

        public Builder avatar_key(String r100) {
            this.mavatar_key = r100;
            return this;
        }

        public Builder avatar_type(AvatarType r100) {
            this.mavatar_type = r100;
            return this;
        }

        public Builder baike_entries(List<BaikeEntry> r100) {
            Internal.checkElementsNotNull(r100);
            this.mbaike_entries = r100;
            return this;
        }

        public Builder bid(String r100) {
            this.mbid = r100;
            return this;
        }

        public Builder entity_type(String r100) {
            this.mentity_type = r100;
            return this;
        }

        public Builder explanation_tags(List<ExplanationTag> r100) {
            Internal.checkElementsNotNull(r100);
            this.mexplanation_tags = r100;
            return this;
        }

        public Builder extra_info_separator(String r100) {
            this.mextra_info_separator = r100;
            return this;
        }

        public Builder extra_infos(List<ExtraInfoBlock> r100) {
            Internal.checkElementsNotNull(r100);
            this.mextra_infos = r100;
            return this;
        }

        public Builder extras_highlighted(String r100) {
            this.mextras_highlighted = r100;
            return this;
        }

        public Builder id(String r100) {
            this.mid = r100;
            return this;
        }

        public Builder is_translated(Boolean r100) {
            this.mis_translated = r100;
            return this;
        }

        public Builder parsing_infos(List<ParsingInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mparsing_infos = r100;
            return this;
        }

        public Builder raw_summary_highlighted(String r100) {
            this.mraw_summary_highlighted = r100;
            return this;
        }

        public Builder raw_title_highlighted(String r100) {
            this.mraw_title_highlighted = r100;
            return this;
        }

        public Builder recall_scene(RecallScene r100) {
            this.mrecall_scene = r100;
            return this;
        }

        public Builder render_data(String r100) {
            this.mrender_data = r100;
            return this;
        }

        public Builder result_meta(ResultMeta r100) {
            this.mresult_meta = r100;
            return this;
        }

        public Builder summary_highlighted(String r100) {
            this.msummary_highlighted = r100;
            return this;
        }

        public Builder title_highlighted(String r100) {
            this.mtitle_highlighted = r100;
            return this;
        }

        public Builder tracking_meta(String r100) {
            this.mtracking_meta = r100;
            return this;
        }

        public Builder type(SearchEntityType r100) {
            this.mtype = r100;
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
            r101.mid = "";
            r101.mtitle_highlighted = "";
            r101.msummary_highlighted = "";
            r101.mextras_highlighted = "";
            r101.mavatar_key = "";
            r101.mextra_info_separator = "";
            r101.mis_translated = Boolean.FALSE;
            r101.mraw_title_highlighted = "";
            r101.mraw_summary_highlighted = "";
            r101.mbid = "";
            r101.mentity_type = "";
            r101.mauthz_id = "";
            r101.mtracking_meta = "";
            r101.mrender_data = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L38;
            switch(r103) {
                case 1: goto L37;
                case 2: goto L42;
                case 3: goto L32;
                case 4: goto L31;
                case 5: goto L30;
                case 6: goto L29;
                case 7: goto L28;
                case 8: goto L27;
                case 9: goto L26;
                case 10: goto L25;
                case 11: goto L24;
                case 12: goto L23;
                case 13: goto L22;
                case 14: goto L21;
                case 15: goto L20;
                case 16: goto L19;
                case 17: goto L18;
                case 18: goto L17;
                case 19: goto L16;
                case 20: goto L15;
                case 21: goto L44;
                case 22: goto L40;
                default: goto L6;
            };
        L40:
            r101.mrecall_scene = RecallScene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L42:
            r101.mtype = SearchEntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L35
        L35:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L44:
            r101.mavatar_type = AvatarType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            r101.mparsing_infos.add(ParsingInfo.ADAPTER.decode(r100));
            goto L3
        L16:
            r101.mrender_data = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.mtracking_meta = ProtoAdapter.STRING.decode(r100);
            goto L3
        L18:
            r101.mauthz_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.mentity_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L20:
            r101.mbid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L21:
            r101.mraw_summary_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L22:
            r101.mraw_title_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L23:
            r101.mis_translated = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L24:
            r101.mbaike_entries.add(BaikeEntry.ADAPTER.decode(r100));
            goto L3
        L25:
            r101.mextra_info_separator = ProtoAdapter.STRING.decode(r100);
            goto L3
        L26:
            r101.mextra_infos.add(ExtraInfoBlock.ADAPTER.decode(r100));
            goto L3
        L27:
            r101.mexplanation_tags.add(ExplanationTag.ADAPTER.decode(r100));
            goto L3
        L28:
            r101.mresult_meta = ResultMeta.ADAPTER.decode(r100);
            goto L3
        L29:
            r101.mavatar_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L30:
            r101.mextras_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L31:
            r101.msummary_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L32:
            r101.mtitle_highlighted = ProtoAdapter.STRING.decode(r100);
            goto L3
        L37:
            r101.mid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L38:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SearchResult r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.mid);
            SearchEntityType r103 = r100.mtype;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = SearchEntityType.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.mtitle_highlighted;
            if (r107 == null) goto L9;
            int r108 = r101.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.msummary_highlighted;
            if (r110 == null) goto L13;
            int r111 = r101.encodedSizeWithTag(4, r110);
        L14:
            int r112 = r109 + r111;
            String r113 = r100.mextras_highlighted;
            if (r113 == null) goto L17;
            int r114 = r101.encodedSizeWithTag(5, r113);
        L18:
            int r115 = r112 + r114;
            String r116 = r100.mavatar_key;
            if (r116 == null) goto L21;
            int r117 = r101.encodedSizeWithTag(6, r116);
        L22:
            int r118 = r115 + r117;
            ResultMeta r119 = r100.mresult_meta;
            if (r119 == null) goto L25;
            int r120 = ResultMeta.ADAPTER.encodedSizeWithTag(7, r119);
        L26:
            int r121 = ((r118 + r120) + ExplanationTag.ADAPTER.asRepeated().encodedSizeWithTag(8, r100.mexplanation_tags)) + ExtraInfoBlock.ADAPTER.asRepeated().encodedSizeWithTag(9, r100.mextra_infos);
            String r122 = r100.mextra_info_separator;
            if (r122 == null) goto L29;
            int r123 = r101.encodedSizeWithTag(10, r122);
        L30:
            int r124 = (r121 + r123) + BaikeEntry.ADAPTER.asRepeated().encodedSizeWithTag(11, r100.mbaike_entries);
            Boolean r125 = r100.mis_translated;
            if (r125 == null) goto L33;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r125);
        L34:
            int r127 = r124 + r126;
            String r128 = r100.mraw_title_highlighted;
            if (r128 == null) goto L37;
            int r129 = r101.encodedSizeWithTag(13, r128);
        L38:
            int r130 = r127 + r129;
            String r131 = r100.mraw_summary_highlighted;
            if (r131 == null) goto L41;
            int r132 = r101.encodedSizeWithTag(14, r131);
        L42:
            int r133 = r130 + r132;
            String r134 = r100.mbid;
            if (r134 == null) goto L45;
            int r135 = r101.encodedSizeWithTag(15, r134);
        L46:
            int r136 = r133 + r135;
            String r137 = r100.mentity_type;
            if (r137 == null) goto L49;
            int r138 = r101.encodedSizeWithTag(16, r137);
        L50:
            int r139 = r136 + r138;
            String r140 = r100.mauthz_id;
            if (r140 == null) goto L53;
            int r141 = r101.encodedSizeWithTag(17, r140);
        L54:
            int r142 = r139 + r141;
            String r143 = r100.mtracking_meta;
            if (r143 == null) goto L57;
            int r144 = r101.encodedSizeWithTag(18, r143);
        L58:
            int r145 = r142 + r144;
            String r146 = r100.mrender_data;
            if (r146 == null) goto L61;
            int r147 = r101.encodedSizeWithTag(19, r146);
        L62:
            int r148 = (r145 + r147) + ParsingInfo.ADAPTER.asRepeated().encodedSizeWithTag(20, r100.mparsing_infos);
            AvatarType r149 = r100.mavatar_type;
            if (r149 == null) goto L65;
            int r150 = AvatarType.ADAPTER.encodedSizeWithTag(21, r149);
        L66:
            int r151 = r148 + r150;
            RecallScene r152 = r100.mrecall_scene;
            if (r152 == null) goto L70;
            r104 = RecallScene.ADAPTER.encodedSizeWithTag(22, r152);
        L70:
            return (r151 + r104) + r100.unknownFields().size();
        L65:
            r150 = 0;
            goto L66
        L61:
            r147 = 0;
            goto L62
        L57:
            r144 = 0;
            goto L58
        L53:
            r141 = 0;
            goto L54
        L49:
            r138 = 0;
            goto L50
        L45:
            r135 = 0;
            goto L46
        L41:
            r132 = 0;
            goto L42
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
        public /* bridge */ /* synthetic */ SearchResult decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchResult r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchResult r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.mid);
            SearchEntityType r103 = r101.mtype;
            if (r103 == null) goto L5;
            SearchEntityType.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            String r104 = r101.mtitle_highlighted;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 3, r104);
        L8:
            String r105 = r101.msummary_highlighted;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 4, r105);
        L11:
            String r106 = r101.mextras_highlighted;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 5, r106);
        L14:
            String r107 = r101.mavatar_key;
            if (r107 == null) goto L17;
            r102.encodeWithTag(r100, 6, r107);
        L17:
            ResultMeta r108 = r101.mresult_meta;
            if (r108 == null) goto L20;
            ResultMeta.ADAPTER.encodeWithTag(r100, 7, r108);
        L20:
            ExplanationTag.ADAPTER.asRepeated().encodeWithTag(r100, 8, r101.mexplanation_tags);
            ExtraInfoBlock.ADAPTER.asRepeated().encodeWithTag(r100, 9, r101.mextra_infos);
            String r109 = r101.mextra_info_separator;
            if (r109 == null) goto L23;
            r102.encodeWithTag(r100, 10, r109);
        L23:
            BaikeEntry.ADAPTER.asRepeated().encodeWithTag(r100, 11, r101.mbaike_entries);
            Boolean r110 = r101.mis_translated;
            if (r110 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r110);
        L26:
            String r111 = r101.mraw_title_highlighted;
            if (r111 == null) goto L29;
            r102.encodeWithTag(r100, 13, r111);
        L29:
            String r112 = r101.mraw_summary_highlighted;
            if (r112 == null) goto L32;
            r102.encodeWithTag(r100, 14, r112);
        L32:
            String r113 = r101.mbid;
            if (r113 == null) goto L35;
            r102.encodeWithTag(r100, 15, r113);
        L35:
            String r114 = r101.mentity_type;
            if (r114 == null) goto L38;
            r102.encodeWithTag(r100, 16, r114);
        L38:
            String r115 = r101.mauthz_id;
            if (r115 == null) goto L41;
            r102.encodeWithTag(r100, 17, r115);
        L41:
            String r116 = r101.mtracking_meta;
            if (r116 == null) goto L44;
            r102.encodeWithTag(r100, 18, r116);
        L44:
            String r117 = r101.mrender_data;
            if (r117 == null) goto L47;
            r102.encodeWithTag(r100, 19, r117);
        L47:
            ParsingInfo.ADAPTER.asRepeated().encodeWithTag(r100, 20, r101.mparsing_infos);
            AvatarType r118 = r101.mavatar_type;
            if (r118 == null) goto L50;
            AvatarType.ADAPTER.encodeWithTag(r100, 21, r118);
        L50:
            RecallScene r119 = r101.mrecall_scene;
            if (r119 == null) goto L53;
            RecallScene.ADAPTER.encodeWithTag(r100, 22, r119);
        L53:
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

    static {
        ADAPTER = new ProtoAdapter_SearchResult();
        FieldOptions.Builder r100 = new FieldOptions.Builder();
        Boolean r101 = Boolean.TRUE;
        FIELD_OPTIONS_MTYPE = r100.security_field(r101).security_search_entity_type(r101).build();
        FIELD_OPTIONS_MRESULT_META = new FieldOptions.Builder().security_field(r101).build();
        FIELD_OPTIONS_MAUTHZ_ID = new FieldOptions.Builder().security_field(r101).security_object(new AuthEntity.Builder().build()).build();
        DEFAULT_IS_TRANSLATED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mid = this.mid;
        r100.mtype = this.mtype;
        r100.mtitle_highlighted = this.mtitle_highlighted;
        r100.msummary_highlighted = this.msummary_highlighted;
        r100.mextras_highlighted = this.mextras_highlighted;
        r100.mavatar_key = this.mavatar_key;
        r100.mresult_meta = this.mresult_meta;
        r100.mexplanation_tags = Internal.copyOf("mexplanation_tags", this.mexplanation_tags);
        r100.mextra_infos = Internal.copyOf("mextra_infos", this.mextra_infos);
        r100.mextra_info_separator = this.mextra_info_separator;
        r100.mbaike_entries = Internal.copyOf("mbaike_entries", this.mbaike_entries);
        r100.mis_translated = this.mis_translated;
        r100.mraw_title_highlighted = this.mraw_title_highlighted;
        r100.mraw_summary_highlighted = this.mraw_summary_highlighted;
        r100.mbid = this.mbid;
        r100.mentity_type = this.mentity_type;
        r100.mauthz_id = this.mauthz_id;
        r100.mtracking_meta = this.mtracking_meta;
        r100.mrender_data = this.mrender_data;
        r100.mparsing_infos = Internal.copyOf("mparsing_infos", this.mparsing_infos);
        r100.mavatar_type = this.mavatar_type;
        r100.mrecall_scene = this.mrecall_scene;
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

    public SearchResult(String r210, SearchEntityType r211, String r212, String r213, String r214, String r310, ResultMeta r311, List<ExplanationTag> r312, List<ExtraInfoBlock> r313, String r314, List<BaikeEntry> r315, Boolean r316, String r317, String r318, String r319, String r410, String r411, String r412, String r413, List<ParsingInfo> r414, AvatarType r415, RecallScene r416) {
        this(r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, ByteString.EMPTY);
    }

    public SearchResult(String r100, SearchEntityType r101, String r102, String r103, String r104, String r105, ResultMeta r110, List<ExplanationTag> r111, List<ExtraInfoBlock> r112, String r113, List<BaikeEntry> r114, Boolean r115, String r116, String r117, String r118, String r119, String r210, String r211, String r212, List<ParsingInfo> r213, AvatarType r214, RecallScene r215, ByteString r216) {
        super(ADAPTER, r216);
        this.mid = r100;
        this.mtype = r101;
        this.mtitle_highlighted = r102;
        this.msummary_highlighted = r103;
        this.mextras_highlighted = r104;
        this.mavatar_key = r105;
        this.mresult_meta = r110;
        this.mexplanation_tags = Internal.immutableCopyOf("mexplanation_tags", r111);
        this.mextra_infos = Internal.immutableCopyOf("mextra_infos", r112);
        this.mextra_info_separator = r113;
        this.mbaike_entries = Internal.immutableCopyOf("mbaike_entries", r114);
        this.mis_translated = r115;
        this.mraw_title_highlighted = r116;
        this.mraw_summary_highlighted = r117;
        this.mbid = r118;
        this.mentity_type = r119;
        this.mauthz_id = r210;
        this.mtracking_meta = r211;
        this.mrender_data = r212;
        this.mparsing_infos = Internal.immutableCopyOf("mparsing_infos", r213);
        this.mavatar_type = r214;
        this.mrecall_scene = r215;
    }
}
