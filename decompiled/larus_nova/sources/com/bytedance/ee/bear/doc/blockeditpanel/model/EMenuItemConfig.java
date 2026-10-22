package com.bytedance.ee.bear.doc.blockeditpanel.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.doc.blockeditpanel.view.GradientColorConfig;
import com.bytedance.ee.bear.document.knowledgeai.DocsKnowledgeAIType;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.bear.sheet.exportimage.preview.SheetImagePreviewPlugin;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import e0c.k;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final enum EMenuItemConfig extends Enum<EMenuItemConfig> {
    public static final EMenuItemConfig ACTION_PAUSE = null;
    public static final EMenuItemConfig ACTION_PLAY = null;
    public static final EMenuItemConfig ADD_TIME = null;
    public static final EMenuItemConfig AI_REWRITE = null;
    public static final EMenuItemConfig ALIGN = null;
    public static final EMenuItemConfig ALIGN_CENTER = null;
    public static final EMenuItemConfig ALIGN_LEFT = null;
    public static final EMenuItemConfig ALIGN_RIGHT = null;
    public static final EMenuItemConfig ALIGN_TRANSFORM = null;
    public static final EMenuItemConfig ASK_DOUBAO = null;
    public static final EMenuItemConfig BLOCK_ALIGN_CENTER = null;
    public static final EMenuItemConfig BLOCK_ALIGN_LEFT = null;
    public static final EMenuItemConfig BLOCK_ALIGN_RIGHT = null;
    public static final EMenuItemConfig BLOCK_BACKGROUND = null;
    public static final EMenuItemConfig BLOCK_QUOTE = null;
    public static final EMenuItemConfig BOLD = null;
    public static final EMenuItemConfig CANCEL_LINK = null;
    public static final EMenuItemConfig CANCEL_SYNC_TASK = null;
    public static final EMenuItemConfig CAPTION = null;
    public static final EMenuItemConfig CARD_VIEW = null;
    public static final EMenuItemConfig CHECKBOX = null;
    public static final EMenuItemConfig CHECKList = null;
    public static final EMenuItemConfig CHECK_DETAILS = null;
    public static final EMenuItemConfig CODE_BLOCK = null;
    public static final EMenuItemConfig COMMENT = null;
    public static final EMenuItemConfig COPY = null;
    public static final EMenuItemConfig COPY_LINK = null;
    public static final EMenuItemConfig CUT = null;
    public static final EMenuItemConfig DEBUG_BLOCK = null;
    public static final EMenuItemConfig DELETE = null;
    public static final EMenuItemConfig DOUBAO_AI = null;
    public static final EMenuItemConfig EDIT_IMAGE = null;
    public static final EMenuItemConfig EDIT_TIME = null;
    public static final EMenuItemConfig FILE_DOWN_LOAD = null;
    public static final EMenuItemConfig FILE_OPEN_WITH = null;
    public static final EMenuItemConfig FILE_SAVE_TO_DRIVE = null;
    public static final EMenuItemConfig FOCUS_TASK = null;
    public static final EMenuItemConfig FORWARD = null;
    public static final EMenuItemConfig H1 = null;
    public static final EMenuItemConfig H2 = null;
    public static final EMenuItemConfig H3 = null;
    public static final EMenuItemConfig H4 = null;
    public static final EMenuItemConfig H5 = null;
    public static final EMenuItemConfig H6 = null;
    public static final EMenuItemConfig H7 = null;
    public static final EMenuItemConfig H8 = null;
    public static final EMenuItemConfig H9 = null;
    public static final EMenuItemConfig HIGHLIGHT = null;
    public static final EMenuItemConfig HN = null;
    public static final EMenuItemConfig INDENT_LEFT = null;
    public static final EMenuItemConfig INDENT_RIGHT = null;
    public static final EMenuItemConfig INDENT_TRANSFORM = null;
    public static final EMenuItemConfig INLINEAI = null;
    public static final EMenuItemConfig INLINE_CODE = null;
    public static final EMenuItemConfig ITALIC = null;
    public static final EMenuItemConfig MORE = null;
    public static final EMenuItemConfig NEW_LINE_BELOW = null;
    public static final EMenuItemConfig ORDERED_LIST = null;
    public static final EMenuItemConfig PREVIEW_VIEW = null;
    public static final EMenuItemConfig PlainText = null;
    public static final EMenuItemConfig REACTION = null;
    public static final EMenuItemConfig REFRESH_BLOCK = null;
    public static final EMenuItemConfig SEPARATOR = null;
    public static final EMenuItemConfig STRIKE_THROUGH = null;
    public static final EMenuItemConfig STYLE = null;
    public static final EMenuItemConfig SYNCED_SOURCE_BLOCK = null;
    public static final EMenuItemConfig TEXT_BLOCK_TRANSFORM = null;
    public static final EMenuItemConfig TEXT_TRANSFORM = null;
    public static final EMenuItemConfig TEXT_VIEW = null;
    public static final EMenuItemConfig TRANSLATE = null;
    public static final EMenuItemConfig UNDERLINE = null;
    public static final EMenuItemConfig UNKNOWN = null;
    public static final EMenuItemConfig UNORDERED_LIST = null;
    public static final EMenuItemConfig VIEW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, EMenuItemConfig> f217617a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EMenuItemConfig[] f217618b = null;
    public c backgroundGradientColorList;
    public a backgroundStateColorList;
    public int bgRes;
    public a iconStateColorList;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public String f217619id;
    public int imageRes;
    public c textGradientColorList;
    public a textStateColorList;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f217620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f217621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f217622c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f217623d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f217624e;

        public a(b r100) {
            this.f217624e = r100;
            this.f217622c = r100;
            this.f217621b = r100;
            this.f217623d = r100;
            this.f217620a = r100;
        }

        public a(b r100, b r101) {
            this.f217624e = r100;
            this.f217620a = r101;
            this.f217622c = r101;
            this.f217623d = r101;
            this.f217621b = r100;
        }

        public a(b r100, b r101, b r102, b r103, b r104) {
            this.f217620a = r101;
            this.f217621b = r104;
            this.f217623d = r103;
            this.f217624e = r100;
            this.f217622c = r102;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f217625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f217626b;

        public b(int r100) {
            this.f217625a = -1;
            this.f217626b = 1.0f;
            this.f217625a = r100;
        }

        public b(int r100, float r101) {
            this.f217625a = -1;
            this.f217626b = 1.0f;
            this.f217625a = r100;
            this.f217626b = r101;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final GradientColorConfig f217627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final GradientColorConfig f217628b;

        public c(GradientColorConfig r100, GradientColorConfig r101) {
            this.f217627a = r100;
            this.f217628b = r101;
        }
    }

    static {
        EMenuItemConfig r100 = new EMenuItemConfig("STYLE", 0, "style", R.drawable.ud_icon_text_aa_outlined, new a(new b(R.color.ud_N700)), new a(new b(R.color.ud_N600)), new a(new b(R.color.transparent, 0.0f), new b(R.color.ud_N500, 0.1f)));
        STYLE = r100;
        EMenuItemConfig r101 = new EMenuItemConfig("CANCEL_LINK", 1, "cancelRealtimeReference", R.drawable.ud_icon_cancel_link_outlined, new a(new b(R.color.colorful_indigo)), new a(new b(R.color.ud_N600), new b(R.color.colorful_indigo)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_indigo, 0.1f)));
        CANCEL_LINK = r101;
        EMenuItemConfig r102 = new EMenuItemConfig("COMMENT", 2, "comment", R.drawable.ud_icon_add_comment_outlined, new a(new b(R.color.colorful_yellow)), new a(new b(R.color.ud_N600), new b(R.color.ud_Y600)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_yellow, 0.1f)));
        COMMENT = r102;
        EMenuItemConfig r103 = new EMenuItemConfig("ACTION_PLAY", 3, DyPayConstant.KEY_START_TIME, R.drawable.ud_icon_play_round_outlined, new a(new b(R.color.colorful_blue)), new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        ACTION_PLAY = r103;
        EMenuItemConfig r104 = new EMenuItemConfig("ACTION_PAUSE", 4, "pauseTime", R.drawable.ud_icon_pause_round_filled, new a(new b(R.color.colorful_blue)), new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        ACTION_PAUSE = r104;
        EMenuItemConfig r105 = new EMenuItemConfig("ADD_TIME", 5, "editTime", R.drawable.ud_icon_time_outlined, new a(new b(R.color.icon_n1)), new a(new b(R.color.text_caption), new b(R.color.text_caption)), new a(new b(R.color.transparent, 0.0f), new b(R.color.icon_n3, 0.1f)));
        ADD_TIME = r105;
        EMenuItemConfig r106 = new EMenuItemConfig("EDIT_TIME", 6, "addTime", R.drawable.ud_icon_time_outlined, new a(new b(R.color.icon_n1)), new a(new b(R.color.text_caption), new b(R.color.text_caption)), new a(new b(R.color.transparent, 0.0f), new b(R.color.icon_n3, 0.1f)));
        EDIT_TIME = r106;
        EMenuItemConfig r107 = new EMenuItemConfig(CardAdapter.REACTION, 7, "contentReaction", R.drawable.ud_icon_thumbsup_outlined, new a(new b(R.color.colorful_orange)), new a(new b(R.color.ud_N600), new b(R.color.colorful_orange)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_orange, 0.1f)));
        REACTION = r107;
        EMenuItemConfig r108 = new EMenuItemConfig(new c(new GradientColorConfig(Collections.singletonList(Integer.valueOf(R.color.ud_N600))), new GradientColorConfig(Arrays.asList(new Integer[]{Integer.valueOf(R.color.ai_primary_content_default_0), Integer.valueOf(R.color.ai_primary_content_default_1)}))), new c(new GradientColorConfig(Collections.singletonList(Integer.valueOf(R.color.transparent))), new GradientColorConfig(Arrays.asList(new Integer[]{Integer.valueOf(R.color.ai_primary_fill_transparent_01_0), Integer.valueOf(R.color.ai_primary_fill_transparent_01_1)}))));
        INLINEAI = r108;
        EMenuItemConfig r109 = new EMenuItemConfig("COPY_LINK", 9, "copyLink", R.drawable.icon_global_link_nor, new a(new b(R.color.colorful_blue)), new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        COPY_LINK = r109;
        EMenuItemConfig r110 = new EMenuItemConfig("SYNCED_SOURCE_BLOCK", 10, "syncedSource", R.drawable.doc_icon_link_record_outlined, null, new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        SYNCED_SOURCE_BLOCK = r110;
        EMenuItemConfig r111 = new EMenuItemConfig("CUT", 11, BitableAnalytic.MenuClickAction.CUT, R.drawable.ud_icon_screenshots_outlined, new a(new b(R.color.colorful_green)), new a(new b(R.color.ud_N600), new b(R.color.colorful_green)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_green, 0.1f)));
        CUT = r111;
        EMenuItemConfig r112 = new EMenuItemConfig("FORWARD", 12, "forward", R.drawable.ud_icon_forward_outlined, new a(new b(R.color.colorful_wathet)), new a(new b(R.color.ud_N600), new b(R.color.colorful_wathet)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_wathet, 0.1f)));
        FORWARD = r112;
        EMenuItemConfig r113 = new EMenuItemConfig("COPY", 13, "copy", R.drawable.ud_icon_copy_outlined, new a(new b(R.color.colorful_blue)), new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        COPY = r113;
        EMenuItemConfig r114 = new EMenuItemConfig("DELETE", 14, "delete", R.drawable.ud_icon_delete_trash_outlined, new a(new b(R.color.colorful_red)), new a(new b(R.color.ud_N600), new b(R.color.colorful_red)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_red, 0.1f)));
        DELETE = r114;
        EMenuItemConfig r115 = new EMenuItemConfig("ALIGN", 15, "align", R.drawable.ud_icon_typography_outlined, new a(new b(R.color.colorful_blue)), new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        ALIGN = r115;
        EMenuItemConfig r116 = new EMenuItemConfig("VIEW", 16, "view", R.drawable.icon_global_view_outlined, new a(new b(R.color.colorful_blue)), new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        VIEW = r116;
        EMenuItemConfig r117 = new EMenuItemConfig("DEBUG_BLOCK", 17, "DEBUG_BLOCK", R.drawable.icon_calendar_tittle_outlined, new a(new b(R.color.colorful_blue)), new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        DEBUG_BLOCK = r117;
        EMenuItemConfig r118 = new EMenuItemConfig("REFRESH_BLOCK", 18, "REFRESH_BLOCK", R.drawable.icon_replace_outlined, new a(new b(R.color.colorful_blue)), new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        REFRESH_BLOCK = r118;
        EMenuItemConfig r119 = new EMenuItemConfig("FOCUS_TASK", 19, "focusTask", R.drawable.ud_icon_subscribe_add_outlined, new a(new b(R.color.colorful_wathet)), new a(new b(R.color.ud_N600), new b(R.color.colorful_wathet)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_wathet, 0.1f)));
        FOCUS_TASK = r119;
        EMenuItemConfig r120 = new EMenuItemConfig("CHECK_DETAILS", 20, "checkDetails", R.drawable.ud_icon_viewinchat_outlined, new a(new b(R.color.colorful_green)), new a(new b(R.color.ud_N600), new b(R.color.colorful_green)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_green, 0.1f)));
        CHECK_DETAILS = r120;
        EMenuItemConfig r121 = new EMenuItemConfig("CAPTION", 21, "caption", R.drawable.ud_icon_feedback_outlined, new a(new b(R.color.colorful_indigo)), new a(new b(R.color.text_caption), new b(R.color.colorful_indigo)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_indigo, 0.1f)));
        CAPTION = r121;
        EMenuItemConfig r122 = new EMenuItemConfig("CANCEL_SYNC_TASK", 22, "cancelSyncTask", R.drawable.ud_icon_cancel_sync_task_outlined, new a(new b(R.color.colorful_indigo)), new a(new b(R.color.ud_N600), new b(R.color.colorful_indigo)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_indigo, 0.1f)));
        CANCEL_SYNC_TASK = r122;
        EMenuItemConfig r123 = new EMenuItemConfig("MORE", 23, "more", R.drawable.ud_icon_more_outlined, new a(new b(R.color.icon_n1)), new a(new b(R.color.text_caption), new b(R.color.text_caption)), new a(new b(R.color.transparent, 0.0f), new b(R.color.icon_n3, 0.1f)));
        MORE = r123;
        EMenuItemConfig r124 = new EMenuItemConfig("FILE_DOWN_LOAD", 24, "fileDownload", R.drawable.ud_icon_download_outlined, new a(new b(R.color.primary_fill_default)), new a(new b(R.color.text_caption), new b(R.color.text_link_hover)), new a(new b(R.color.transparent, 0.0f), new b(R.color.primary_fill_default, 0.1f)));
        FILE_DOWN_LOAD = r124;
        EMenuItemConfig r125 = new EMenuItemConfig("FILE_OPEN_WITH", 25, "fileOpenWith", R.drawable.ud_icon_window_new_outlined, new a(new b(R.color.colorful_yellow)), new a(new b(R.color.text_caption), new b(R.color.ud_Y600)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_yellow, 0.1f)));
        FILE_OPEN_WITH = r125;
        EMenuItemConfig r126 = new EMenuItemConfig("TRANSLATE", 26, "translate", R.drawable.ud_icon_translate_outlined, new a(new b(R.color.colorful_blue)), new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        TRANSLATE = r126;
        EMenuItemConfig r127 = new EMenuItemConfig("AI_REWRITE", 27, "aiRewrite", -1, null, new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        AI_REWRITE = r127;
        EMenuItemConfig r128 = new EMenuItemConfig("ASK_DOUBAO", 28, "askDouBao", -1, null, new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        ASK_DOUBAO = r128;
        EMenuItemConfig r129 = new EMenuItemConfig("DOUBAO_AI", 29, "doubaoAI", -1, null, new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        DOUBAO_AI = r129;
        EMenuItemConfig r130 = new EMenuItemConfig("FILE_SAVE_TO_DRIVE", 30, "fileSaveToDrive", R.drawable.ud_icon_cloud_upload_outlined, new a(new b(R.color.ud_success_color_6)), new a(new b(R.color.text_caption), new b(R.color.ud_success_color_6)), new a(new b(R.color.transparent, 0.0f), new b(R.color.ud_success_color_6, 0.1f)));
        FILE_SAVE_TO_DRIVE = r130;
        EMenuItemConfig r131 = new EMenuItemConfig("NEW_LINE_BELOW", 31, "newLineBelow", R.drawable.ud_icon_new_join_meeting_outlined, new a(new b(R.color.colorful_blue)), new a(new b(R.color.ud_N600), new b(R.color.colorful_blue)), new a(new b(R.color.transparent, 0.0f), new b(R.color.colorful_blue, 0.1f)));
        NEW_LINE_BELOW = r131;
        EMenuItemConfig r132 = new EMenuItemConfig("EDIT_IMAGE", 32, "editImage", R.drawable.ud_icon_edit_outlined, new a(new b(R.color.ud_T350)), new a(new b(R.color.ud_N600), new b(R.color.ud_T350)), new a(new b(R.color.transparent, 0.0f), new b(R.color.ud_T350, 0.1f)));
        EDIT_IMAGE = r132;
        EMenuItemConfig r133 = new EMenuItemConfig("SEPARATOR", 33, "separator");
        SEPARATOR = r133;
        EMenuItemConfig r134 = new EMenuItemConfig("PlainText", 34, "plainText", R.drawable.ud_icon_text2_outlined, R.drawable.shape_corners_radius_8, b(), a());
        PlainText = r134;
        EMenuItemConfig r135 = new EMenuItemConfig("H1", 35, "h1", R.drawable.ud_icon_h1_outlined, R.drawable.shape_left_corners_radius_8, b(), a());
        H1 = r135;
        EMenuItemConfig r136 = new EMenuItemConfig("H2", 36, "h2", R.drawable.ud_icon_h2_outlined, R.drawable.shape_corners_no_radius, b(), a());
        H2 = r136;
        EMenuItemConfig r137 = new EMenuItemConfig("H3", 37, "h3", R.drawable.ud_icon_h3_outlined, R.drawable.shape_corners_no_radius, b(), a());
        H3 = r137;
        EMenuItemConfig r138 = new EMenuItemConfig("H4", 38, "h4", R.drawable.ud_icon_h4_outlined, R.drawable.shape_corners_no_radius, b(), a());
        H4 = r138;
        EMenuItemConfig r210 = new EMenuItemConfig("H5", 39, "h5", R.drawable.ud_icon_h5_outlined, R.drawable.shape_corners_no_radius, b(), a());
        H5 = r210;
        EMenuItemConfig r211 = new EMenuItemConfig("H6", 40, "h6", R.drawable.ud_icon_h6_outlined, R.drawable.shape_corners_no_radius, b(), a());
        H6 = r211;
        EMenuItemConfig r310 = new EMenuItemConfig("H7", 41, "h7", R.drawable.ud_icon_h7_outlined, R.drawable.shape_corners_no_radius, b(), a());
        H7 = r310;
        EMenuItemConfig r410 = new EMenuItemConfig("H8", 42, "h8", R.drawable.ud_icon_h8_outlined, R.drawable.shape_corners_no_radius, b(), a());
        H8 = r410;
        EMenuItemConfig r411 = new EMenuItemConfig("H9", 43, "h9", R.drawable.ud_icon_h9_outlined, R.drawable.shape_right_corners_radius_8, b(), a());
        H9 = r411;
        EMenuItemConfig r412 = new EMenuItemConfig("HN", 44, "hn", R.drawable.ud_icon_hn_outlined, R.drawable.shape_right_corners_radius_8, b(), a());
        HN = r412;
        EMenuItemConfig r413 = new EMenuItemConfig("BLOCK_QUOTE", 45, "blockquote", R.drawable.ud_icon_reference_outlined, R.drawable.shape_corners_radius_8, b(), a());
        BLOCK_QUOTE = r413;
        EMenuItemConfig r414 = new EMenuItemConfig("CODE_BLOCK", 46, "insertcodeblock", R.drawable.ud_icon_codeblock_outlined, R.drawable.shape_corners_radius_8, b(), a());
        CODE_BLOCK = r414;
        EMenuItemConfig r710 = new EMenuItemConfig("CHECKBOX", 47, "checkbox", R.drawable.ud_icon_todo_outlined, R.drawable.shape_corners_radius_8, b(), a());
        CHECKBOX = r710;
        EMenuItemConfig r610 = new EMenuItemConfig("CHECKList", 48, "checkList", R.drawable.ud_icon_todo_outlined, R.drawable.shape_corners_radius_8, b(), a());
        CHECKList = r610;
        EMenuItemConfig r711 = new EMenuItemConfig("ORDERED_LIST", 49, "insertorderedlist", R.drawable.ud_icon_order_list_outlined, R.drawable.shape_corners_radius_8, b(), a());
        ORDERED_LIST = r711;
        EMenuItemConfig r510 = new EMenuItemConfig("UNORDERED_LIST", 50, "insertunorderedlist", R.drawable.ud_icon_disorder_list_outlined, R.drawable.shape_corners_radius_8, b(), a());
        UNORDERED_LIST = r510;
        EMenuItemConfig r511 = new EMenuItemConfig("BOLD", 51, CommodityText.BOLD, R.drawable.ud_icon_bold_outlined, R.drawable.shape_left_corners_radius_8, b(), a());
        BOLD = r511;
        EMenuItemConfig r611 = new EMenuItemConfig("ITALIC", 52, "italic", R.drawable.ud_icon_italic_outlined, R.drawable.shape_corners_no_radius, b(), a());
        ITALIC = r611;
        EMenuItemConfig r512 = new EMenuItemConfig("UNDERLINE", 53, SegmentStyle.UNDERLINE, R.drawable.ud_icon_underline_outlined, R.drawable.shape_corners_no_radius, b(), a());
        UNDERLINE = r512;
        EMenuItemConfig r513 = new EMenuItemConfig("STRIKE_THROUGH", 54, "strikethrough", R.drawable.ud_icon_horizontal_line_outlined, R.drawable.shape_right_corners_radius_8, b(), a());
        STRIKE_THROUGH = r513;
        EMenuItemConfig r514 = new EMenuItemConfig("INLINE_CODE", 55, "inlinecode", R.drawable.ud_icon_code_outlined, b(), null, a());
        INLINE_CODE = r514;
        EMenuItemConfig r515 = new EMenuItemConfig("HIGHLIGHT", 56, "highlight", R.drawable.ud_icon_fontcolor_outlined, R.drawable.shape_left_corners_radius_8, d(), c());
        HIGHLIGHT = r515;
        EMenuItemConfig r516 = new EMenuItemConfig("BLOCK_BACKGROUND", 57, "blockbackground", R.drawable.ud_icon_style_set_outlined, b(), null, a());
        BLOCK_BACKGROUND = r516;
        EMenuItemConfig r517 = new EMenuItemConfig("INDENT_RIGHT", 58, "indentright", R.drawable.ud_icon_increase_indentation_outlined, R.drawable.shape_right_corners_radius_8, b(), a());
        INDENT_RIGHT = r517;
        EMenuItemConfig r518 = new EMenuItemConfig("INDENT_LEFT", 59, "indentleft", R.drawable.ud_icon_reduce_indentation_outlined, R.drawable.shape_left_corners_radius_8, b(), a());
        INDENT_LEFT = r518;
        EMenuItemConfig r612 = new EMenuItemConfig("ALIGN_LEFT", 60, "alignleft", R.drawable.ud_icon_left_alignment_outlined, R.drawable.shape_left_corners_radius_8, b(), a());
        ALIGN_LEFT = r612;
        EMenuItemConfig r613 = new EMenuItemConfig("ALIGN_CENTER", 61, "aligncenter", R.drawable.ud_icon_center_alignment_outlined, R.drawable.shape_corners_no_radius, b(), a());
        ALIGN_CENTER = r613;
        EMenuItemConfig r614 = new EMenuItemConfig("ALIGN_RIGHT", 62, "alignright", R.drawable.ud_icon_right_alignment_outlined, R.drawable.shape_right_corners_radius_8, b(), a());
        ALIGN_RIGHT = r614;
        EMenuItemConfig r139 = new EMenuItemConfig("INDENT_TRANSFORM", 63, "indentTransform");
        INDENT_TRANSFORM = r139;
        EMenuItemConfig r140 = new EMenuItemConfig("TEXT_TRANSFORM", 64, "textTransform");
        TEXT_TRANSFORM = r140;
        EMenuItemConfig r141 = new EMenuItemConfig("ALIGN_TRANSFORM", 65, "alignTransform");
        ALIGN_TRANSFORM = r141;
        EMenuItemConfig r142 = new EMenuItemConfig("TEXT_BLOCK_TRANSFORM", 66, "textBlockTransform");
        TEXT_BLOCK_TRANSFORM = r142;
        EMenuItemConfig r143 = new EMenuItemConfig("CARD_VIEW", 67, SheetImagePreviewPlugin.SOURCE_CARDVIEW, R.drawable.icon_tool_card_view_nor, f(), g(), e());
        CARD_VIEW = r143;
        EMenuItemConfig r144 = new EMenuItemConfig("TEXT_VIEW", 68, "textview", R.drawable.icon_tool_inline_view_nor, f(), g(), e());
        TEXT_VIEW = r144;
        EMenuItemConfig r145 = new EMenuItemConfig("PREVIEW_VIEW", 69, "previewview", R.drawable.icon_tool_preview_view_nor, f(), g(), e());
        PREVIEW_VIEW = r145;
        EMenuItemConfig r712 = new EMenuItemConfig("BLOCK_ALIGN_LEFT", 70, "blockalignleft", R.drawable.ud_icon_left_alignment_outlined, R.drawable.shape_left_corners_radius_8, b(), a());
        BLOCK_ALIGN_LEFT = r712;
        EMenuItemConfig r810 = new EMenuItemConfig("BLOCK_ALIGN_CENTER", 71, "blockaligncenter", R.drawable.ud_icon_center_alignment_outlined, R.drawable.shape_corners_no_radius, b(), a());
        BLOCK_ALIGN_CENTER = r810;
        EMenuItemConfig r713 = new EMenuItemConfig("BLOCK_ALIGN_RIGHT", 72, "blockalignright", R.drawable.ud_icon_right_alignment_outlined, R.drawable.shape_right_corners_radius_8, b(), a());
        BLOCK_ALIGN_RIGHT = r713;
        EMenuItemConfig r146 = new EMenuItemConfig("UNKNOWN", 73, "unknown");
        UNKNOWN = r146;
        f217618b = new EMenuItemConfig[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r210, r211, r310, r410, r411, r412, r413, r414, r710, r610, r711, r510, r511, r611, r512, r513, r514, r515, r516, r517, r518, r612, r613, r614, r139, r140, r141, r142, r143, r144, r145, r712, r810, r713, r146};
        f217617a = new HashMap();
        EMenuItemConfig[] r147 = values();
        int r148 = r147.length;
        int r149 = 0;
    L3:
        if (r149 >= r148) goto L5;
        EMenuItemConfig r150 = r147[r149];
        ((HashMap) f217617a).put(r150.f217619id, r150);
        r149 = r149 + 1;
        goto L3
    }

    public static a a() {
        return new a(new b(R.color.bg_body_overlay), new b(R.color.fill_pressed, 0.1f), new b(R.color.fill_active, 0.1f), new b(R.color.ud_B900, 0.16f), new b(R.color.bg_body_overlay));
    }

    public static a b() {
        return new a(new b(R.color.icon_n1), new b(R.color.ud_N800), new b(R.color.primary_fill_default), new b(R.color.colorful_blue), new b(R.color.ud_N400));
    }

    public static a c() {
        return new a(new b(R.color.bg_filler), new b(R.color.fill_pressed, 0.1f), new b(R.color.fill_active, 0.15f), new b(R.color.ud_B800, 0.22f), new b(R.color.ud_N300));
    }

    public static a d() {
        return new a(new b(R.color.bg_body_overlay), new b(R.color.fill_pressed, 0.1f), new b(R.color.fill_active, 0.1f), new b(R.color.ud_B900, 0.16f), new b(R.color.ud_N100));
    }

    public static a e() {
        return new a(new b(R.color.transparent, 0.0f), new b(R.color.ud_N900, 0.1f), new b(R.color.colorful_blue, 0.1f), new b(R.color.ud_B900, 0.16f), new b(R.color.transparent, 0.0f));
    }

    public static a f() {
        return new a(new b(R.color.ud_N800), new b(R.color.ud_N800), new b(R.color.colorful_blue), new b(R.color.colorful_blue), new b(R.color.ud_N400));
    }

    public static a g() {
        return new a(new b(R.color.ud_N600), new b(R.color.ud_N600), new b(R.color.colorful_blue), new b(R.color.colorful_blue), new b(R.color.ud_N400));
    }

    public static EMenuItemConfig[] values() {
        return (EMenuItemConfig[]) f217618b.clone();
    }

    public static EMenuItemConfig getMenuItemConfigById(String r100) {
        EMenuItemConfig r101 = (EMenuItemConfig) ((HashMap) f217617a).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return UNKNOWN;
    }

    public static EMenuItemConfig valueOf(String r100) {
        return (EMenuItemConfig) r27.a.a(EMenuItemConfig.class, r100);
    }

    public EMenuItemConfig(c r100, c r101) {
        super("INLINEAI", 8);
        this.bgRes = -1;
        this.f217619id = "inlineAI";
        this.imageRes = R.drawable.ud_icon_myai_colorful;
        this.iconStateColorList = null;
        this.textGradientColorList = r100;
        this.backgroundGradientColorList = r101;
    }

    public Drawable getImageDrawable(Context r100, int r101) {
        if (this != AI_REWRITE) goto L5;
    L10:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L38;
        int r103 = this.imageRes;
        if (r103 != (-1)) goto L16;
        return null;
    L16:
        return AppCompatResources.getDrawable(r100, r103);
    L38:
        com.bytedance.ee.bear.document.knowledgeai.a r104 = (com.bytedance.ee.bear.document.knowledgeai.a) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.document.knowledgeai.a.class);     // Catch: Throwable -> L33
        if (r104 != null) goto L20;
    L29:
        int r105 = this.imageRes;     // Catch: Throwable -> L33
        if (r105 != (-1)) goto L32;
        return null;
    L32:
        return AppCompatResources.getDrawable(r100, r105);
    L20:
        if (r104.d() != DocsKnowledgeAIType.FLOW_AI) goto L29;
        Drawable r106 = r104.b(r100, Math.max(1, r101));     // Catch: Throwable -> L33
        if (r106 != null) goto L40;
        int r107 = this.imageRes;     // Catch: Throwable -> L33
        if (r107 != (-1)) goto L28;
        return null;
    L28:
        return AppCompatResources.getDrawable(r100, r107);
    L40:
        return r106;
    L33:
        th = move-exception;
        tt5.a.d("EMenuItemConfig", "resolve DOUBAO_AI drawable fail: " + th.getMessage());
        int r108 = this.imageRes;
        if (r108 != (-1)) goto L37;
        return null;
    L37:
        return AppCompatResources.getDrawable(r100, r108);
    L5:
        if (this == ASK_DOUBAO) goto L10;
        if (this == DOUBAO_AI) goto L10;
        r102 = false;
        goto L12
    }

    public EMenuItemConfig(String r100, int r101, String r102) {
        super(r100, r101);
        this.imageRes = -1;
        this.bgRes = -1;
        this.f217619id = r102;
    }

    public EMenuItemConfig(String r100, int r101, String r102, int r103, int r104, a r105, a r106) {
        super(r100, r101);
        this.f217619id = r102;
        this.imageRes = r103;
        this.bgRes = r104;
        this.iconStateColorList = r105;
        this.textStateColorList = null;
        this.backgroundStateColorList = r106;
    }

    public EMenuItemConfig(String r100, int r101, String r102, int r103, a r104, a r105, a r106) {
        super(r100, r101);
        this.bgRes = -1;
        this.f217619id = r102;
        this.imageRes = r103;
        this.iconStateColorList = r104;
        this.textStateColorList = r105;
        this.backgroundStateColorList = r106;
    }
}
