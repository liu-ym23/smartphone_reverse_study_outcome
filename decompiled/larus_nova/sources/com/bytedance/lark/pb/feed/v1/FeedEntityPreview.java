package com.bytedance.lark.pb.feed.v1;

import com.bytedance.lark.pb.basic.v1.FeedButtonData;
import com.bytedance.lark.pb.basic.v1.FeedCard;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class FeedEntityPreview extends Message<FeedEntityPreview, Builder> {
    public static final ProtoAdapter<FeedEntityPreview> ADAPTER = null;
    public static final Long DEFAULT_BACKUP_FEED_RANK_TIME = null;
    public static final Long DEFAULT_BACKUP_UPDATE_TIME_MS = null;
    public static final String DEFAULT_BIZ_ID = "";
    public static final Boolean DEFAULT_CHECK_USER = null;
    public static final String DEFAULT_FEED_ID = "";
    public static final FeedCard.FeedType DEFAULT_FEED_TYPE = null;
    public static final Boolean DEFAULT_IS_DELAYED = null;
    public static final Boolean DEFAULT_IS_FAKE = null;
    public static final Boolean DEFAULT_IS_FLAG = null;
    public static final Boolean DEFAULT_IS_PRIORITY_PROCESSING = null;
    public static final Long DEFAULT_NAVIGATION_ID = null;
    public static final Long DEFAULT_ON_TOP_RANK_TIME = null;
    public static final String DEFAULT_PARENT_CARD_ID = "";
    public static final Integer DEFAULT_RANK_LEVEL = null;
    public static final Long DEFAULT_UPDATE_TIME = null;
    public static final Long DEFAULT_USER_ID = null;
    private static final long serialVersionUID = 0;
    public final AppFeedCard app_feed_card_data;
    public final ApplicationInFeedDisplay application_in_feed_display;
    public final Long backup_feed_rank_time;
    public final Long backup_update_time_ms;
    public final String biz_id;
    public final BoxData box_data;
    public final FeedButtonData button_data;
    public final ChatData chat_data;
    public final Boolean check_user;
    public final DocData doc_data;
    public final OpenFeedData doubao_custom_data;
    public final String feed_id;
    public final FeedCard.FeedType feed_type;
    public final Boolean is_delayed;
    public final Boolean is_fake;
    public final Boolean is_flag;
    public final Boolean is_priority_processing;
    public final AppFeedCard knowledge_ai_data;
    public final Long navigation_id;
    public final List<Long> navigation_ids;
    public final Long on_top_rank_time;
    public final OpenAppData open_app_data;
    public final String parent_card_id;
    public final Integer rank_level;
    public final FeedRecommendation recommendation;
    public final SubscriptionsData subscriptions_data;
    public final ThreadData thread_data;
    public final Long update_time;
    public final Long user_id;

    public static final class Builder extends Message.Builder<FeedEntityPreview, Builder> {
        public AppFeedCard app_feed_card_data;
        public ApplicationInFeedDisplay application_in_feed_display;
        public Long backup_feed_rank_time;
        public Long backup_update_time_ms;
        public String biz_id;
        public BoxData box_data;
        public FeedButtonData button_data;
        public ChatData chat_data;
        public Boolean check_user;
        public DocData doc_data;
        public OpenFeedData doubao_custom_data;
        public String feed_id;
        public FeedCard.FeedType feed_type;
        public Boolean is_delayed;
        public Boolean is_fake;
        public Boolean is_flag;
        public Boolean is_priority_processing;
        public AppFeedCard knowledge_ai_data;
        public Long navigation_id;
        public List<Long> navigation_ids;
        public Long on_top_rank_time;
        public OpenAppData open_app_data;
        public String parent_card_id;
        public Integer rank_level;
        public FeedRecommendation recommendation;
        public SubscriptionsData subscriptions_data;
        public ThreadData thread_data;
        public Long update_time;
        public Long user_id;

        @Override // com.squareup.wire.Message.Builder
        public FeedEntityPreview build() {
            String r100 = this.feed_id;
            if (r100 == null) goto L9;
            if (this.update_time == null) goto L9;
            return new FeedEntityPreview(this.feed_id, this.feed_type, this.is_delayed, this.update_time, this.parent_card_id, this.recommendation, this.is_flag, this.application_in_feed_display, this.on_top_rank_time, this.button_data, this.user_id, this.check_user, this.is_priority_processing, this.biz_id, this.rank_level, this.backup_feed_rank_time, this.backup_update_time_ms, this.navigation_id, this.navigation_ids, this.is_fake, this.chat_data, this.doc_data, this.thread_data, this.open_app_data, this.box_data, this.subscriptions_data, this.app_feed_card_data, this.knowledge_ai_data, this.doubao_custom_data, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "feed_id", this.update_time, "update_time"});
        }

        public Builder() {
            this.navigation_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_feed_card_data(AppFeedCard r100) {
            this.app_feed_card_data = r100;
            this.chat_data = null;
            this.doc_data = null;
            this.thread_data = null;
            this.open_app_data = null;
            this.box_data = null;
            this.subscriptions_data = null;
            this.knowledge_ai_data = null;
            this.doubao_custom_data = null;
            return this;
        }

        public Builder application_in_feed_display(ApplicationInFeedDisplay r100) {
            this.application_in_feed_display = r100;
            return this;
        }

        public Builder backup_feed_rank_time(Long r100) {
            this.backup_feed_rank_time = r100;
            return this;
        }

        public Builder backup_update_time_ms(Long r100) {
            this.backup_update_time_ms = r100;
            return this;
        }

        public Builder biz_id(String r100) {
            this.biz_id = r100;
            return this;
        }

        public Builder box_data(BoxData r100) {
            this.box_data = r100;
            this.chat_data = null;
            this.doc_data = null;
            this.thread_data = null;
            this.open_app_data = null;
            this.subscriptions_data = null;
            this.app_feed_card_data = null;
            this.knowledge_ai_data = null;
            this.doubao_custom_data = null;
            return this;
        }

        public Builder button_data(FeedButtonData r100) {
            this.button_data = r100;
            return this;
        }

        public Builder chat_data(ChatData r100) {
            this.chat_data = r100;
            this.doc_data = null;
            this.thread_data = null;
            this.open_app_data = null;
            this.box_data = null;
            this.subscriptions_data = null;
            this.app_feed_card_data = null;
            this.knowledge_ai_data = null;
            this.doubao_custom_data = null;
            return this;
        }

        public Builder check_user(Boolean r100) {
            this.check_user = r100;
            return this;
        }

        public Builder doc_data(DocData r100) {
            this.doc_data = r100;
            this.chat_data = null;
            this.thread_data = null;
            this.open_app_data = null;
            this.box_data = null;
            this.subscriptions_data = null;
            this.app_feed_card_data = null;
            this.knowledge_ai_data = null;
            this.doubao_custom_data = null;
            return this;
        }

        public Builder doubao_custom_data(OpenFeedData r100) {
            this.doubao_custom_data = r100;
            this.chat_data = null;
            this.doc_data = null;
            this.thread_data = null;
            this.open_app_data = null;
            this.box_data = null;
            this.subscriptions_data = null;
            this.app_feed_card_data = null;
            this.knowledge_ai_data = null;
            return this;
        }

        public Builder feed_id(String r100) {
            this.feed_id = r100;
            return this;
        }

        public Builder feed_type(FeedCard.FeedType r100) {
            this.feed_type = r100;
            return this;
        }

        public Builder is_delayed(Boolean r100) {
            this.is_delayed = r100;
            return this;
        }

        public Builder is_fake(Boolean r100) {
            this.is_fake = r100;
            return this;
        }

        public Builder is_flag(Boolean r100) {
            this.is_flag = r100;
            return this;
        }

        public Builder is_priority_processing(Boolean r100) {
            this.is_priority_processing = r100;
            return this;
        }

        public Builder knowledge_ai_data(AppFeedCard r100) {
            this.knowledge_ai_data = r100;
            this.chat_data = null;
            this.doc_data = null;
            this.thread_data = null;
            this.open_app_data = null;
            this.box_data = null;
            this.subscriptions_data = null;
            this.app_feed_card_data = null;
            this.doubao_custom_data = null;
            return this;
        }

        public Builder navigation_id(Long r100) {
            this.navigation_id = r100;
            return this;
        }

        public Builder navigation_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.navigation_ids = r100;
            return this;
        }

        public Builder on_top_rank_time(Long r100) {
            this.on_top_rank_time = r100;
            return this;
        }

        public Builder open_app_data(OpenAppData r100) {
            this.open_app_data = r100;
            this.chat_data = null;
            this.doc_data = null;
            this.thread_data = null;
            this.box_data = null;
            this.subscriptions_data = null;
            this.app_feed_card_data = null;
            this.knowledge_ai_data = null;
            this.doubao_custom_data = null;
            return this;
        }

        public Builder parent_card_id(String r100) {
            this.parent_card_id = r100;
            return this;
        }

        public Builder rank_level(Integer r100) {
            this.rank_level = r100;
            return this;
        }

        public Builder recommendation(FeedRecommendation r100) {
            this.recommendation = r100;
            return this;
        }

        public Builder subscriptions_data(SubscriptionsData r100) {
            this.subscriptions_data = r100;
            this.chat_data = null;
            this.doc_data = null;
            this.thread_data = null;
            this.open_app_data = null;
            this.box_data = null;
            this.app_feed_card_data = null;
            this.knowledge_ai_data = null;
            this.doubao_custom_data = null;
            return this;
        }

        public Builder thread_data(ThreadData r100) {
            this.thread_data = r100;
            this.chat_data = null;
            this.doc_data = null;
            this.open_app_data = null;
            this.box_data = null;
            this.subscriptions_data = null;
            this.app_feed_card_data = null;
            this.knowledge_ai_data = null;
            this.doubao_custom_data = null;
            return this;
        }

        public Builder update_time(Long r100) {
            this.update_time = r100;
            return this;
        }

        public Builder user_id(Long r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedEntityPreview extends ProtoAdapter<FeedEntityPreview> {
        public ProtoAdapter_FeedEntityPreview() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedEntityPreview.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedEntityPreview decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.feed_id = "";
            r101.feed_type = FeedCard.FeedType.UNKNOWN;
            Boolean r102 = Boolean.FALSE;
            r101.is_delayed = r102;
            r101.update_time = 0L;
            r101.parent_card_id = "";
            r101.is_flag = r102;
            r101.on_top_rank_time = 0L;
            r101.user_id = 0L;
            r101.check_user = r102;
            r101.is_priority_processing = r102;
            r101.biz_id = "";
            r101.rank_level = 0;
            r101.backup_feed_rank_time = 0L;
            r101.backup_update_time_ms = 0L;
            r101.navigation_id = 0L;
            r101.is_fake = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L42;
            switch(r104) {
                case 1: goto L41;
                case 2: goto L44;
                case 3: goto L36;
                case 4: goto L35;
                case 5: goto L34;
                case 6: goto L33;
                case 7: goto L32;
                case 8: goto L31;
                case 9: goto L30;
                default: goto L6;
            };
        L44:
            r101.feed_type = FeedCard.FeedType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L39
        L39:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r101.thread_data(ThreadData.ADAPTER.decode(r100));
            goto L3
        L31:
            r101.doc_data(DocData.ADAPTER.decode(r100));
            goto L3
        L32:
            r101.chat_data(ChatData.ADAPTER.decode(r100));
            goto L3
        L33:
            r101.recommendation = FeedRecommendation.ADAPTER.decode(r100);
            goto L3
        L34:
            r101.parent_card_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L35:
            r101.update_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L36:
            r101.is_delayed = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L41:
            r101.feed_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            switch(r104) {
                case 11: goto L29;
                case 12: goto L28;
                case 13: goto L27;
                case 14: goto L26;
                case 15: goto L25;
                case 16: goto L24;
                case 17: goto L23;
                case 18: goto L22;
                default: goto L7;
            };
        L22:
            r101.button_data = FeedButtonData.ADAPTER.decode(r100);
            goto L3
        L23:
            r101.app_feed_card_data(AppFeedCard.ADAPTER.decode(r100));
            goto L3
        L24:
            r101.on_top_rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L25:
            r101.application_in_feed_display = ApplicationInFeedDisplay.ADAPTER.decode(r100);
            goto L3
        L26:
            r101.is_flag = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L27:
            r101.subscriptions_data(SubscriptionsData.ADAPTER.decode(r100));
            goto L3
        L28:
            r101.box_data(BoxData.ADAPTER.decode(r100));
            goto L3
        L29:
            r101.open_app_data(OpenAppData.ADAPTER.decode(r100));
            goto L3
        L7:
            switch(r104) {
                case 20: goto L21;
                case 21: goto L20;
                case 22: goto L19;
                case 23: goto L18;
                case 24: goto L17;
                case 25: goto L16;
                case 26: goto L15;
                default: goto L8;
            };
        L15:
            r101.backup_update_time_ms = ProtoAdapter.INT64.decode(r100);
            goto L3
        L16:
            r101.backup_feed_rank_time = ProtoAdapter.INT64.decode(r100);
            goto L3
        L17:
            r101.rank_level = ProtoAdapter.INT32.decode(r100);
            goto L3
        L18:
            r101.biz_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L19:
            r101.is_priority_processing = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L20:
            r101.check_user = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L21:
            r101.user_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            switch(r104) {
                case 50: goto L14;
                case 51: goto L13;
                case 52: goto L12;
                case 53: goto L11;
                case 54: goto L10;
                default: goto L9;
            };
        L10:
            r101.doubao_custom_data(OpenFeedData.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.knowledge_ai_data(AppFeedCard.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.is_fake = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L13:
            r101.navigation_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L14:
            r101.navigation_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L42:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FeedEntityPreview r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.feed_id);
            FeedCard.FeedType r103 = r100.feed_type;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = FeedCard.FeedType.ADAPTER.encodedSizeWithTag(2, r103);
        L6:
            int r106 = r102 + r105;
            Boolean r107 = r100.is_delayed;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L10:
            int r109 = r106 + r108;
            ProtoAdapter<Long> r110 = ProtoAdapter.INT64;
            int r111 = r109 + r110.encodedSizeWithTag(4, r100.update_time);
            String r112 = r100.parent_card_id;
            if (r112 == null) goto L13;
            int r113 = r101.encodedSizeWithTag(5, r112);
        L14:
            int r114 = r111 + r113;
            FeedRecommendation r115 = r100.recommendation;
            if (r115 == null) goto L17;
            int r116 = FeedRecommendation.ADAPTER.encodedSizeWithTag(6, r115);
        L18:
            int r117 = r114 + r116;
            Boolean r118 = r100.is_flag;
            if (r118 == null) goto L21;
            int r119 = ProtoAdapter.BOOL.encodedSizeWithTag(14, r118);
        L22:
            int r120 = r117 + r119;
            ApplicationInFeedDisplay r121 = r100.application_in_feed_display;
            if (r121 == null) goto L25;
            int r122 = ApplicationInFeedDisplay.ADAPTER.encodedSizeWithTag(15, r121);
        L26:
            int r123 = r120 + r122;
            Long r124 = r100.on_top_rank_time;
            if (r124 == null) goto L29;
            int r125 = r110.encodedSizeWithTag(16, r124);
        L30:
            int r126 = r123 + r125;
            FeedButtonData r127 = r100.button_data;
            if (r127 == null) goto L33;
            int r128 = FeedButtonData.ADAPTER.encodedSizeWithTag(18, r127);
        L34:
            int r129 = r126 + r128;
            Long r130 = r100.user_id;
            if (r130 == null) goto L37;
            int r131 = r110.encodedSizeWithTag(20, r130);
        L38:
            int r132 = r129 + r131;
            Boolean r133 = r100.check_user;
            if (r133 == null) goto L41;
            int r134 = ProtoAdapter.BOOL.encodedSizeWithTag(21, r133);
        L42:
            int r135 = r132 + r134;
            Boolean r136 = r100.is_priority_processing;
            if (r136 == null) goto L45;
            int r137 = ProtoAdapter.BOOL.encodedSizeWithTag(22, r136);
        L46:
            int r138 = r135 + r137;
            String r139 = r100.biz_id;
            if (r139 == null) goto L49;
            int r140 = r101.encodedSizeWithTag(23, r139);
        L50:
            int r141 = r138 + r140;
            Integer r142 = r100.rank_level;
            if (r142 == null) goto L53;
            int r143 = ProtoAdapter.INT32.encodedSizeWithTag(24, r142);
        L54:
            int r144 = r141 + r143;
            Long r145 = r100.backup_feed_rank_time;
            if (r145 == null) goto L57;
            int r146 = r110.encodedSizeWithTag(25, r145);
        L58:
            int r147 = r144 + r146;
            Long r148 = r100.backup_update_time_ms;
            if (r148 == null) goto L61;
            int r149 = r110.encodedSizeWithTag(26, r148);
        L62:
            int r150 = r147 + r149;
            Long r151 = r100.navigation_id;
            if (r151 == null) goto L65;
            int r152 = r110.encodedSizeWithTag(50, r151);
        L66:
            int r153 = (r150 + r152) + r110.asRepeated().encodedSizeWithTag(51, r100.navigation_ids);
            Boolean r154 = r100.is_fake;
            if (r154 == null) goto L69;
            int r155 = ProtoAdapter.BOOL.encodedSizeWithTag(52, r154);
        L70:
            int r156 = r153 + r155;
            ChatData r157 = r100.chat_data;
            if (r157 == null) goto L73;
            int r158 = ChatData.ADAPTER.encodedSizeWithTag(7, r157);
        L74:
            int r159 = r156 + r158;
            DocData r160 = r100.doc_data;
            if (r160 == null) goto L77;
            int r161 = DocData.ADAPTER.encodedSizeWithTag(8, r160);
        L78:
            int r162 = r159 + r161;
            ThreadData r163 = r100.thread_data;
            if (r163 == null) goto L81;
            int r164 = ThreadData.ADAPTER.encodedSizeWithTag(9, r163);
        L82:
            int r165 = r162 + r164;
            OpenAppData r166 = r100.open_app_data;
            if (r166 == null) goto L85;
            int r167 = OpenAppData.ADAPTER.encodedSizeWithTag(11, r166);
        L86:
            int r168 = r165 + r167;
            BoxData r169 = r100.box_data;
            if (r169 == null) goto L89;
            int r170 = BoxData.ADAPTER.encodedSizeWithTag(12, r169);
        L90:
            int r171 = r168 + r170;
            SubscriptionsData r172 = r100.subscriptions_data;
            if (r172 == null) goto L93;
            int r173 = SubscriptionsData.ADAPTER.encodedSizeWithTag(13, r172);
        L94:
            int r174 = r171 + r173;
            AppFeedCard r175 = r100.app_feed_card_data;
            if (r175 == null) goto L97;
            int r176 = AppFeedCard.ADAPTER.encodedSizeWithTag(17, r175);
        L98:
            int r177 = r174 + r176;
            AppFeedCard r178 = r100.knowledge_ai_data;
            if (r178 == null) goto L101;
            int r179 = AppFeedCard.ADAPTER.encodedSizeWithTag(53, r178);
        L102:
            int r180 = r177 + r179;
            OpenFeedData r181 = r100.doubao_custom_data;
            if (r181 == null) goto L106;
            r104 = OpenFeedData.ADAPTER.encodedSizeWithTag(54, r181);
        L106:
            return (r180 + r104) + r100.unknownFields().size();
        L101:
            r179 = 0;
            goto L102
        L97:
            r176 = 0;
            goto L98
        L93:
            r173 = 0;
            goto L94
        L89:
            r170 = 0;
            goto L90
        L85:
            r167 = 0;
            goto L86
        L81:
            r164 = 0;
            goto L82
        L77:
            r161 = 0;
            goto L78
        L73:
            r158 = 0;
            goto L74
        L69:
            r155 = 0;
            goto L70
        L65:
            r152 = 0;
            goto L66
        L61:
            r149 = 0;
            goto L62
        L57:
            r146 = 0;
            goto L58
        L53:
            r143 = 0;
            goto L54
        L49:
            r140 = 0;
            goto L50
        L45:
            r137 = 0;
            goto L46
        L41:
            r134 = 0;
            goto L42
        L37:
            r131 = 0;
            goto L38
        L33:
            r128 = 0;
            goto L34
        L29:
            r125 = 0;
            goto L30
        L25:
            r122 = 0;
            goto L26
        L21:
            r119 = 0;
            goto L22
        L17:
            r116 = 0;
            goto L18
        L13:
            r113 = 0;
            goto L14
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedEntityPreview decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedEntityPreview r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedEntityPreview r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.feed_id);
            FeedCard.FeedType r103 = r101.feed_type;
            if (r103 == null) goto L5;
            FeedCard.FeedType.ADAPTER.encodeWithTag(r100, 2, r103);
        L5:
            Boolean r104 = r101.is_delayed;
            if (r104 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L8:
            ProtoAdapter<Long> r105 = ProtoAdapter.INT64;
            r105.encodeWithTag(r100, 4, r101.update_time);
            String r106 = r101.parent_card_id;
            if (r106 == null) goto L11;
            r102.encodeWithTag(r100, 5, r106);
        L11:
            FeedRecommendation r107 = r101.recommendation;
            if (r107 == null) goto L14;
            FeedRecommendation.ADAPTER.encodeWithTag(r100, 6, r107);
        L14:
            Boolean r108 = r101.is_flag;
            if (r108 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 14, r108);
        L17:
            ApplicationInFeedDisplay r109 = r101.application_in_feed_display;
            if (r109 == null) goto L20;
            ApplicationInFeedDisplay.ADAPTER.encodeWithTag(r100, 15, r109);
        L20:
            Long r110 = r101.on_top_rank_time;
            if (r110 == null) goto L23;
            r105.encodeWithTag(r100, 16, r110);
        L23:
            FeedButtonData r111 = r101.button_data;
            if (r111 == null) goto L26;
            FeedButtonData.ADAPTER.encodeWithTag(r100, 18, r111);
        L26:
            Long r112 = r101.user_id;
            if (r112 == null) goto L29;
            r105.encodeWithTag(r100, 20, r112);
        L29:
            Boolean r113 = r101.check_user;
            if (r113 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 21, r113);
        L32:
            Boolean r114 = r101.is_priority_processing;
            if (r114 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 22, r114);
        L35:
            String r115 = r101.biz_id;
            if (r115 == null) goto L38;
            r102.encodeWithTag(r100, 23, r115);
        L38:
            Integer r116 = r101.rank_level;
            if (r116 == null) goto L41;
            ProtoAdapter.INT32.encodeWithTag(r100, 24, r116);
        L41:
            Long r117 = r101.backup_feed_rank_time;
            if (r117 == null) goto L44;
            r105.encodeWithTag(r100, 25, r117);
        L44:
            Long r118 = r101.backup_update_time_ms;
            if (r118 == null) goto L47;
            r105.encodeWithTag(r100, 26, r118);
        L47:
            Long r119 = r101.navigation_id;
            if (r119 == null) goto L50;
            r105.encodeWithTag(r100, 50, r119);
        L50:
            r105.asRepeated().encodeWithTag(r100, 51, r101.navigation_ids);
            Boolean r120 = r101.is_fake;
            if (r120 == null) goto L53;
            ProtoAdapter.BOOL.encodeWithTag(r100, 52, r120);
        L53:
            ChatData r121 = r101.chat_data;
            if (r121 == null) goto L56;
            ChatData.ADAPTER.encodeWithTag(r100, 7, r121);
        L56:
            DocData r122 = r101.doc_data;
            if (r122 == null) goto L59;
            DocData.ADAPTER.encodeWithTag(r100, 8, r122);
        L59:
            ThreadData r123 = r101.thread_data;
            if (r123 == null) goto L62;
            ThreadData.ADAPTER.encodeWithTag(r100, 9, r123);
        L62:
            OpenAppData r124 = r101.open_app_data;
            if (r124 == null) goto L65;
            OpenAppData.ADAPTER.encodeWithTag(r100, 11, r124);
        L65:
            BoxData r125 = r101.box_data;
            if (r125 == null) goto L68;
            BoxData.ADAPTER.encodeWithTag(r100, 12, r125);
        L68:
            SubscriptionsData r126 = r101.subscriptions_data;
            if (r126 == null) goto L71;
            SubscriptionsData.ADAPTER.encodeWithTag(r100, 13, r126);
        L71:
            AppFeedCard r127 = r101.app_feed_card_data;
            if (r127 == null) goto L74;
            AppFeedCard.ADAPTER.encodeWithTag(r100, 17, r127);
        L74:
            AppFeedCard r128 = r101.knowledge_ai_data;
            if (r128 == null) goto L77;
            AppFeedCard.ADAPTER.encodeWithTag(r100, 53, r128);
        L77:
            OpenFeedData r129 = r101.doubao_custom_data;
            if (r129 == null) goto L80;
            OpenFeedData.ADAPTER.encodeWithTag(r100, 54, r129);
        L80:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedEntityPreview r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedEntityPreview();
        DEFAULT_FEED_TYPE = FeedCard.FeedType.UNKNOWN;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_DELAYED = r100;
        DEFAULT_UPDATE_TIME = 0L;
        DEFAULT_IS_FLAG = r100;
        DEFAULT_ON_TOP_RANK_TIME = 0L;
        DEFAULT_USER_ID = 0L;
        DEFAULT_CHECK_USER = r100;
        DEFAULT_IS_PRIORITY_PROCESSING = r100;
        DEFAULT_RANK_LEVEL = 0;
        DEFAULT_BACKUP_FEED_RANK_TIME = 0L;
        DEFAULT_BACKUP_UPDATE_TIME_MS = 0L;
        DEFAULT_NAVIGATION_ID = 0L;
        DEFAULT_IS_FAKE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.feed_id = this.feed_id;
        r100.feed_type = this.feed_type;
        r100.is_delayed = this.is_delayed;
        r100.update_time = this.update_time;
        r100.parent_card_id = this.parent_card_id;
        r100.recommendation = this.recommendation;
        r100.is_flag = this.is_flag;
        r100.application_in_feed_display = this.application_in_feed_display;
        r100.on_top_rank_time = this.on_top_rank_time;
        r100.button_data = this.button_data;
        r100.user_id = this.user_id;
        r100.check_user = this.check_user;
        r100.is_priority_processing = this.is_priority_processing;
        r100.biz_id = this.biz_id;
        r100.rank_level = this.rank_level;
        r100.backup_feed_rank_time = this.backup_feed_rank_time;
        r100.backup_update_time_ms = this.backup_update_time_ms;
        r100.navigation_id = this.navigation_id;
        r100.navigation_ids = Internal.copyOf("navigation_ids", this.navigation_ids);
        r100.is_fake = this.is_fake;
        r100.chat_data = this.chat_data;
        r100.doc_data = this.doc_data;
        r100.thread_data = this.thread_data;
        r100.open_app_data = this.open_app_data;
        r100.box_data = this.box_data;
        r100.subscriptions_data = this.subscriptions_data;
        r100.app_feed_card_data = this.app_feed_card_data;
        r100.knowledge_ai_data = this.knowledge_ai_data;
        r100.doubao_custom_data = this.doubao_custom_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedEntityPreview.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedEntityPreview(String r310, FeedCard.FeedType r311, Boolean r312, Long r313, String r314, FeedRecommendation r315, Boolean r316, ApplicationInFeedDisplay r317, Long r410, FeedButtonData r411, Long r412, Boolean r413, Boolean r414, String r415, Integer r416, Long r417, Long r418, Long r419, List<Long> r510, Boolean r511, ChatData r512, DocData r513, ThreadData r514, OpenAppData r515, BoxData r516, SubscriptionsData r517, AppFeedCard r518, AppFeedCard r519, OpenFeedData r610) {
        this(r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, ByteString.EMPTY);
    }

    public FeedEntityPreview(String r110, FeedCard.FeedType r111, Boolean r112, Long r113, String r114, FeedRecommendation r115, Boolean r210, ApplicationInFeedDisplay r211, Long r212, FeedButtonData r213, Long r214, Boolean r215, Boolean r216, String r217, Integer r218, Long r219, Long r310, Long r311, List<Long> r312, Boolean r313, ChatData r314, DocData r315, ThreadData r316, OpenAppData r317, BoxData r318, SubscriptionsData r319, AppFeedCard r410, AppFeedCard r411, OpenFeedData r412, ByteString r413) {
        super(ADAPTER, r413);
        if (Internal.countNonNull(r314, r315, r316, r317, new Object[]{r318, r319, r410, r411, r412}) > 1) goto L7;
        this.feed_id = r110;
        this.feed_type = r111;
        this.is_delayed = r112;
        this.update_time = r113;
        this.parent_card_id = r114;
        this.recommendation = r115;
        this.is_flag = r210;
        this.application_in_feed_display = r211;
        this.on_top_rank_time = r212;
        this.button_data = r213;
        this.user_id = r214;
        this.check_user = r215;
        this.is_priority_processing = r216;
        this.biz_id = r217;
        this.rank_level = r218;
        this.backup_feed_rank_time = r219;
        this.backup_update_time_ms = r310;
        this.navigation_id = r311;
        this.navigation_ids = Internal.immutableCopyOf("navigation_ids", r312);
        this.is_fake = r313;
        this.chat_data = r314;
        this.doc_data = r315;
        this.thread_data = r316;
        this.open_app_data = r317;
        this.box_data = r318;
        this.subscriptions_data = r319;
        this.app_feed_card_data = r410;
        this.knowledge_ai_data = r411;
        this.doubao_custom_data = r412;
        return;
    L7:
        throw new IllegalArgumentException("at most one of chat_data, doc_data, thread_data, open_app_data, box_data, subscriptions_data, app_feed_card_data, knowledge_ai_data, doubao_custom_data may be non-null");
    }
}
