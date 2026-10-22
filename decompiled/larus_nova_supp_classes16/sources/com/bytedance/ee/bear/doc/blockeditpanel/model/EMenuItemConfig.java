package com.bytedance.ee.bear.doc.blockeditpanel.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.doc.blockeditpanel.view.GradientColorConfig;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.document.knowledgeai.DocsKnowledgeAIType;
import com.bytedance.ee.bear.document.offline.file.upload.FileUploadModel;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static final Map<String, EMenuItemConfig> a = null;
    public static final /* synthetic */ EMenuItemConfig[] b = null;
    public c backgroundGradientColorList;
    public a backgroundStateColorList;
    public int bgRes;
    public a iconStateColorList;
    public String id;
    public int imageRes;
    public c textGradientColorList;
    public a textStateColorList;

    public static class a {
        public final b a;
        public final b b;
        public final b c;
        public final b d;
        public final b e;

        public a(b r1) {
            this.e = r1;
            this.c = r1;
            this.b = r1;
            this.d = r1;
            this.a = r1;
        }

        public a(b r1, b r2) {
            this.e = r1;
            this.a = r2;
            this.c = r2;
            this.d = r2;
            this.b = r1;
        }

        public a(b r1, b r2, b r3, b r4, b r5) {
            this.a = r2;
            this.b = r5;
            this.d = r4;
            this.e = r1;
            this.c = r3;
        }
    }

    public static class b {
        public final int a;
        public final float b;

        public b(int r2) {
            this.a = -1;
            this.b = 1.0f;
            this.a = r2;
        }

        public b(int r2, float r3) {
            this.a = -1;
            this.b = 1.0f;
            this.a = r2;
            this.b = r3;
        }
    }

    public static class c {
        public final GradientColorConfig a;
        public final GradientColorConfig b;

        public c(GradientColorConfig r1, GradientColorConfig r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
        EMenuItemConfig r8 = new EMenuItemConfig("STYLE", 0, JSEventListener.STYLE, 2131255990, new a(new b(2131108728)), new a(new b(2131108724)), new a(new b(2131106784, 0.0f), new b(2131108723, 0.1f)));
        STYLE = r8;
        EMenuItemConfig r0 = new EMenuItemConfig("CANCEL_LINK", 1, "cancelRealtimeReference", 2131254029, new a(new b(2131101114)), new a(new b(2131108724), new b(2131101114)), new a(new b(2131106784, 0.0f), new b(2131101114, 0.1f)));
        CANCEL_LINK = r0;
        EMenuItemConfig r1 = new EMenuItemConfig("COMMENT", 2, FileUploadModel.FROM_COMMENT, 2131253538, new a(new b(2131101124)), new a(new b(2131108724), new b(2131108872)), new a(new b(2131106784, 0.0f), new b(2131101124, 0.1f)));
        COMMENT = r1;
        EMenuItemConfig r2 = new EMenuItemConfig("ACTION_PLAY", 3, "startTime", 2131255436, new a(new b(2131101111)), new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        ACTION_PLAY = r2;
        EMenuItemConfig r4 = new EMenuItemConfig("ACTION_PAUSE", 4, "pauseTime", 2131255398, new a(new b(2131101111)), new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        ACTION_PAUSE = r4;
        EMenuItemConfig r5 = new EMenuItemConfig("ADD_TIME", 5, "editTime", 2131256006, new a(new b(2131102418)), new a(new b(2131106607), new b(2131106607)), new a(new b(2131106784, 0.0f), new b(2131102420, 0.1f)));
        ADD_TIME = r5;
        EMenuItemConfig r6 = new EMenuItemConfig("EDIT_TIME", 6, "addTime", 2131256006, new a(new b(2131102418)), new a(new b(2131106607), new b(2131106607)), new a(new b(2131106784, 0.0f), new b(2131102420, 0.1f)));
        EDIT_TIME = r6;
        EMenuItemConfig r7 = new EMenuItemConfig("REACTION", 7, "contentReaction", 2131256003, new a(new b(2131101117)), new a(new b(2131108724), new b(2131101117)), new a(new b(2131106784, 0.0f), new b(2131101117, 0.1f)));
        REACTION = r7;
        EMenuItemConfig r3 = new EMenuItemConfig(new c(new GradientColorConfig(Collections.singletonList(2131108724)), new GradientColorConfig(Arrays.asList(new Integer[]{2131100164, 2131100165}))), new c(new GradientColorConfig(Collections.singletonList(2131106784)), new GradientColorConfig(Arrays.asList(new Integer[]{2131100186, 2131100187}))));
        INLINEAI = r3;
        EMenuItemConfig r9 = new EMenuItemConfig("COPY_LINK", 9, "copyLink", 2131237951, new a(new b(2131101111)), new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        COPY_LINK = r9;
        EMenuItemConfig r10 = new EMenuItemConfig("SYNCED_SOURCE_BLOCK", 10, "syncedSource", 2131233841, null, new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        SYNCED_SOURCE_BLOCK = r10;
        EMenuItemConfig r11 = new EMenuItemConfig("CUT", 11, "cut", 2131255607, new a(new b(2131101113)), new a(new b(2131108724), new b(2131101113)), new a(new b(2131106784, 0.0f), new b(2131101113, 0.1f)));
        CUT = r11;
        EMenuItemConfig r12 = new EMenuItemConfig("FORWARD", 12, "forward", 2131254801, new a(new b(2131101123)), new a(new b(2131108724), new b(2131101123)), new a(new b(2131106784, 0.0f), new b(2131101123, 0.1f)));
        FORWARD = r12;
        EMenuItemConfig r13 = new EMenuItemConfig("COPY", 13, "copy", 2131254165, new a(new b(2131101111)), new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        COPY = r13;
        EMenuItemConfig r14 = new EMenuItemConfig("DELETE", 14, "delete", 2131254201, new a(new b(2131101119)), new a(new b(2131108724), new b(2131101119)), new a(new b(2131106784, 0.0f), new b(2131101119, 0.1f)));
        DELETE = r14;
        EMenuItemConfig r16 = new EMenuItemConfig("ALIGN", 15, "align", 2131256057, new a(new b(2131101111)), new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        ALIGN = r16;
        EMenuItemConfig r17 = new EMenuItemConfig("VIEW", 16, "view", 2131237955, new a(new b(2131101111)), new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        VIEW = r17;
        EMenuItemConfig r18 = new EMenuItemConfig("DEBUG_BLOCK", 17, "DEBUG_BLOCK", 2131237732, new a(new b(2131101111)), new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        DEBUG_BLOCK = r18;
        EMenuItemConfig r19 = new EMenuItemConfig("REFRESH_BLOCK", 18, "REFRESH_BLOCK", 2131238048, new a(new b(2131101111)), new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        REFRESH_BLOCK = r19;
        EMenuItemConfig r20 = new EMenuItemConfig("FOCUS_TASK", 19, "focusTask", 2131255845, new a(new b(2131101123)), new a(new b(2131108724), new b(2131101123)), new a(new b(2131106784, 0.0f), new b(2131101123, 0.1f)));
        FOCUS_TASK = r20;
        EMenuItemConfig r21 = new EMenuItemConfig("CHECK_DETAILS", 20, "checkDetails", 2131256151, new a(new b(2131101113)), new a(new b(2131108724), new b(2131101113)), new a(new b(2131106784, 0.0f), new b(2131101113, 0.1f)));
        CHECK_DETAILS = r21;
        EMenuItemConfig r22 = new EMenuItemConfig("CAPTION", 21, "caption", 2131254352, new a(new b(2131101114)), new a(new b(2131106607), new b(2131101114)), new a(new b(2131106784, 0.0f), new b(2131101114, 0.1f)));
        CAPTION = r22;
        EMenuItemConfig r23 = new EMenuItemConfig("CANCEL_SYNC_TASK", 22, "cancelSyncTask", 2131254036, new a(new b(2131101114)), new a(new b(2131108724), new b(2131101114)), new a(new b(2131106784, 0.0f), new b(2131101114, 0.1f)));
        CANCEL_SYNC_TASK = r23;
        EMenuItemConfig r24 = new EMenuItemConfig("MORE", 23, "more", 2131255147, new a(new b(2131102418)), new a(new b(2131106607), new b(2131106607)), new a(new b(2131106784, 0.0f), new b(2131102420, 0.1f)));
        MORE = r24;
        EMenuItemConfig r26 = new EMenuItemConfig("FILE_DOWN_LOAD", 24, "fileDownload", 2131254269, new a(new b(2131105548)), new a(new b(2131106607), new b(2131106614)), new a(new b(2131106784, 0.0f), new b(2131105548, 0.1f)));
        FILE_DOWN_LOAD = r26;
        EMenuItemConfig r27 = new EMenuItemConfig("FILE_OPEN_WITH", 25, "fileOpenWith", 2131256289, new a(new b(2131101124)), new a(new b(2131106607), new b(2131108872)), new a(new b(2131106784, 0.0f), new b(2131101124, 0.1f)));
        FILE_OPEN_WITH = r27;
        EMenuItemConfig r28 = new EMenuItemConfig("TRANSLATE", 26, "translate", 2131256049, new a(new b(2131101111)), new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        TRANSLATE = r28;
        EMenuItemConfig r29 = new EMenuItemConfig("AI_REWRITE", 27, "aiRewrite", -1, null, new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        AI_REWRITE = r29;
        EMenuItemConfig r110 = new EMenuItemConfig("ASK_DOUBAO", 28, "askDouBao", -1, null, new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        ASK_DOUBAO = r110;
        EMenuItemConfig r30 = new EMenuItemConfig("DOUBAO_AI", 29, "doubaoAI", -1, null, new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        DOUBAO_AI = r30;
        EMenuItemConfig r111 = new EMenuItemConfig("FILE_SAVE_TO_DRIVE", 30, "fileSaveToDrive", 2131254131, new a(new b(2131108978)), new a(new b(2131106607), new b(2131108978)), new a(new b(2131106784, 0.0f), new b(2131108978, 0.1f)));
        FILE_SAVE_TO_DRIVE = r111;
        EMenuItemConfig r31 = new EMenuItemConfig("NEW_LINE_BELOW", 31, "newLineBelow", 2131255213, new a(new b(2131101111)), new a(new b(2131108724), new b(2131101111)), new a(new b(2131106784, 0.0f), new b(2131101111, 0.1f)));
        NEW_LINE_BELOW = r31;
        EMenuItemConfig r32 = new EMenuItemConfig("EDIT_IMAGE", 32, "editImage", 2131254285, new a(new b(2131108810)), new a(new b(2131108724), new b(2131108810)), new a(new b(2131106784, 0.0f), new b(2131108810, 0.1f)));
        EDIT_IMAGE = r32;
        EMenuItemConfig r33 = new EMenuItemConfig("SEPARATOR", 33, "separator");
        SEPARATOR = r33;
        EMenuItemConfig r112 = new EMenuItemConfig("PlainText", 34, "plainText", 2131255989, 2131247715, b(), a());
        PlainText = r112;
        EMenuItemConfig r113 = new EMenuItemConfig("H1", 35, "h1", 2131254843, 2131247721, b(), a());
        H1 = r113;
        EMenuItemConfig r114 = new EMenuItemConfig("H2", 36, "h2", 2131254844, 2131247713, b(), a());
        H2 = r114;
        EMenuItemConfig r115 = new EMenuItemConfig("H3", 37, "h3", 2131254845, 2131247713, b(), a());
        H3 = r115;
        EMenuItemConfig r116 = new EMenuItemConfig("H4", 38, "h4", 2131254846, 2131247713, b(), a());
        H4 = r116;
        EMenuItemConfig r210 = new EMenuItemConfig("H5", 39, "h5", 2131254847, 2131247713, b(), a());
        H5 = r210;
        EMenuItemConfig r211 = new EMenuItemConfig("H6", 40, "h6", 2131254848, 2131247713, b(), a());
        H6 = r211;
        EMenuItemConfig r37 = new EMenuItemConfig("H7", 41, "h7", 2131254849, 2131247713, b(), a());
        H7 = r37;
        EMenuItemConfig r46 = new EMenuItemConfig("H8", 42, "h8", 2131254850, 2131247713, b(), a());
        H8 = r46;
        EMenuItemConfig r47 = new EMenuItemConfig("H9", 43, "h9", 2131254851, 2131247722, b(), a());
        H9 = r47;
        EMenuItemConfig r48 = new EMenuItemConfig("HN", 44, "hn", 2131254883, 2131247722, b(), a());
        HN = r48;
        EMenuItemConfig r49 = new EMenuItemConfig("BLOCK_QUOTE", 45, "blockquote", 2131255526, 2131247715, b(), a());
        BLOCK_QUOTE = r49;
        EMenuItemConfig r410 = new EMenuItemConfig("CODE_BLOCK", 46, "insertcodeblock", 2131254133, 2131247715, b(), a());
        CODE_BLOCK = r410;
        EMenuItemConfig r74 = new EMenuItemConfig("CHECKBOX", 47, "checkbox", 2131256017, 2131247715, b(), a());
        CHECKBOX = r74;
        EMenuItemConfig r66 = new EMenuItemConfig("CHECKList", 48, "checkList", 2131256017, 2131247715, b(), a());
        CHECKList = r66;
        EMenuItemConfig r76 = new EMenuItemConfig("ORDERED_LIST", 49, "insertorderedlist", 2131255256, 2131247715, b(), a());
        ORDERED_LIST = r76;
        EMenuItemConfig r51 = new EMenuItemConfig("UNORDERED_LIST", 50, "insertunorderedlist", 2131254229, 2131247715, b(), a());
        UNORDERED_LIST = r51;
        EMenuItemConfig r52 = new EMenuItemConfig("BOLD", 51, "bold", 2131253866, 2131247721, b(), a());
        BOLD = r52;
        EMenuItemConfig r61 = new EMenuItemConfig("ITALIC", 52, "italic", 2131254942, 2131247713, b(), a());
        ITALIC = r61;
        EMenuItemConfig r53 = new EMenuItemConfig("UNDERLINE", 53, "underline", 2131256061, 2131247713, b(), a());
        UNDERLINE = r53;
        EMenuItemConfig r54 = new EMenuItemConfig("STRIKE_THROUGH", 54, "strikethrough", 2131254887, 2131247722, b(), a());
        STRIKE_THROUGH = r54;
        EMenuItemConfig r56 = new EMenuItemConfig("INLINE_CODE", 55, "inlinecode", 2131254132, b(), null, a());
        INLINE_CODE = r56;
        EMenuItemConfig r57 = new EMenuItemConfig("HIGHLIGHT", 56, "highlight", 2131254786, 2131247721, d(), c());
        HIGHLIGHT = r57;
        EMenuItemConfig r58 = new EMenuItemConfig("BLOCK_BACKGROUND", 57, "blockbackground", 2131255841, b(), null, a());
        BLOCK_BACKGROUND = r58;
        EMenuItemConfig r59 = new EMenuItemConfig("INDENT_RIGHT", 58, "indentright", 2131254912, 2131247722, b(), a());
        INDENT_RIGHT = r59;
        EMenuItemConfig r510 = new EMenuItemConfig("INDENT_LEFT", 59, "indentleft", 2131255523, 2131247721, b(), a());
        INDENT_LEFT = r510;
        EMenuItemConfig r60 = new EMenuItemConfig("ALIGN_LEFT", 60, "alignleft", 2131254994, 2131247721, b(), a());
        ALIGN_LEFT = r60;
        EMenuItemConfig r62 = new EMenuItemConfig("ALIGN_CENTER", 61, "aligncenter", 2131254074, 2131247713, b(), a());
        ALIGN_CENTER = r62;
        EMenuItemConfig r63 = new EMenuItemConfig("ALIGN_RIGHT", 62, "alignright", 2131255561, 2131247722, b(), a());
        ALIGN_RIGHT = r63;
        EMenuItemConfig r117 = new EMenuItemConfig("INDENT_TRANSFORM", 63, "indentTransform");
        INDENT_TRANSFORM = r117;
        EMenuItemConfig r118 = new EMenuItemConfig("TEXT_TRANSFORM", 64, "textTransform");
        TEXT_TRANSFORM = r118;
        EMenuItemConfig r119 = new EMenuItemConfig("ALIGN_TRANSFORM", 65, "alignTransform");
        ALIGN_TRANSFORM = r119;
        EMenuItemConfig r120 = new EMenuItemConfig("TEXT_BLOCK_TRANSFORM", 66, "textBlockTransform");
        TEXT_BLOCK_TRANSFORM = r120;
        EMenuItemConfig r121 = new EMenuItemConfig("CARD_VIEW", 67, "cardview", 2131238080, f(), g(), e());
        CARD_VIEW = r121;
        EMenuItemConfig r122 = new EMenuItemConfig("TEXT_VIEW", 68, "textview", 2131238082, f(), g(), e());
        TEXT_VIEW = r122;
        EMenuItemConfig r123 = new EMenuItemConfig("PREVIEW_VIEW", 69, "previewview", 2131238084, f(), g(), e());
        PREVIEW_VIEW = r123;
        EMenuItemConfig r73 = new EMenuItemConfig("BLOCK_ALIGN_LEFT", 70, "blockalignleft", 2131254994, 2131247721, b(), a());
        BLOCK_ALIGN_LEFT = r73;
        EMenuItemConfig r84 = new EMenuItemConfig("BLOCK_ALIGN_CENTER", 71, "blockaligncenter", 2131254074, 2131247713, b(), a());
        BLOCK_ALIGN_CENTER = r84;
        EMenuItemConfig r77 = new EMenuItemConfig("BLOCK_ALIGN_RIGHT", 72, "blockalignright", 2131255561, 2131247722, b(), a());
        BLOCK_ALIGN_RIGHT = r77;
        EMenuItemConfig r124 = new EMenuItemConfig("UNKNOWN", 73, "unknown");
        UNKNOWN = r124;
        b = new EMenuItemConfig[]{r8, r0, r1, r2, r4, r5, r6, r7, r3, r9, r10, r11, r12, r13, r14, r16, r17, r18, r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r110, r30, r111, r31, r32, r33, r112, r113, r114, r115, r116, r210, r211, r37, r46, r47, r48, r49, r410, r74, r66, r76, r51, r52, r61, r53, r54, r56, r57, r58, r59, r510, r60, r62, r63, r117, r118, r119, r120, r121, r122, r123, r73, r84, r77, r124};
        a = new HashMap();
        EMenuItemConfig[] r34 = values();
        int r36 = r34.length;
        int r38 = 0;
    L3:
        if (r38 >= r36) goto L5;
        EMenuItemConfig r39 = r34[r38];
        ((HashMap) a).put(r39.id, r39);
        r38 = r38 + 1;
        goto L3
    }

    public static a a() {
        return new a(new b(2131100549), new b(2131101953, 0.1f), new b(2131101946, 0.1f), new b(2131108632, 0.16f), new b(2131100549));
    }

    public static a b() {
        return new a(new b(2131102418), new b(2131108729), new b(2131105548), new b(2131101111), new b(2131108721));
    }

    public static a c() {
        return new a(new b(2131100556), new b(2131101953, 0.1f), new b(2131101946, 0.15f), new b(2131108631, 0.22f), new b(2131108718));
    }

    public static a d() {
        return new a(new b(2131100549), new b(2131101953, 0.1f), new b(2131101946, 0.1f), new b(2131108632, 0.16f), new b(2131108712));
    }

    public static a e() {
        return new a(new b(2131106784, 0.0f), new b(2131108730, 0.1f), new b(2131101111, 0.1f), new b(2131108632, 0.16f), new b(2131106784, 0.0f));
    }

    public static a f() {
        return new a(new b(2131108729), new b(2131108729), new b(2131101111), new b(2131101111), new b(2131108721));
    }

    public static a g() {
        return new a(new b(2131108724), new b(2131108724), new b(2131101111), new b(2131101111), new b(2131108721));
    }

    public static EMenuItemConfig[] values() {
        return (EMenuItemConfig[]) b.clone();
    }

    public static EMenuItemConfig getMenuItemConfigById(String r1) {
        EMenuItemConfig r2 = (EMenuItemConfig) ((HashMap) a).get(r1);
        if (r2 == null) goto L5;
        return r2;
    L5:
        return UNKNOWN;
    }

    public static EMenuItemConfig valueOf(String r1) {
        return (EMenuItemConfig) r27.a.a(EMenuItemConfig.class, r1);
    }

    public EMenuItemConfig(c r3, c r4) {
        super("INLINEAI", 8);
        this.bgRes = -1;
        this.id = "inlineAI";
        this.imageRes = 2131255192;
        this.iconStateColorList = null;
        this.textGradientColorList = r3;
        this.backgroundGradientColorList = r4;
    }

    public Drawable getImageDrawable(Context r7, int r8) {
        if (this != AI_REWRITE) goto L5;
    L10:
        boolean r0 = true;
    L12:
        if (r0 == true) goto L38;
        int r9 = this.imageRes;
        if (r9 != (-1)) goto L16;
        return null;
    L16:
        return AppCompatResources.getDrawable(r7, r9);
    L38:
        com.bytedance.ee.bear.document.knowledgeai.a r1 = (com.bytedance.ee.bear.document.knowledgeai.a) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.document.knowledgeai.a.class);     // Catch: Throwable -> L33
        if (r1 != null) goto L20;
    L29:
        int r10 = this.imageRes;     // Catch: Throwable -> L33
        if (r10 != (-1)) goto L32;
        return null;
    L32:
        return AppCompatResources.getDrawable(r7, r10);
    L20:
        if (r1.d() != DocsKnowledgeAIType.FLOW_AI) goto L29;
        Drawable r11 = r1.b(r7, Math.max(1, r8));     // Catch: Throwable -> L33
        if (r11 != null) goto L40;
        int r12 = this.imageRes;     // Catch: Throwable -> L33
        if (r12 != (-1)) goto L28;
        return null;
    L28:
        return AppCompatResources.getDrawable(r7, r12);
    L40:
        return r11;
    L33:
        th = move-exception;
        tt5.a.d("EMenuItemConfig", "resolve DOUBAO_AI drawable fail: " + th.getMessage());
        int r13 = this.imageRes;
        if (r13 != (-1)) goto L37;
        return null;
    L37:
        return AppCompatResources.getDrawable(r7, r13);
    L5:
        if (this == ASK_DOUBAO) goto L10;
        if (this == DOUBAO_AI) goto L10;
        r0 = false;
        goto L12
    }

    public EMenuItemConfig(String r1, int r2, String r3) {
        super(r1, r2);
        this.imageRes = -1;
        this.bgRes = -1;
        this.id = r3;
    }

    public EMenuItemConfig(String r1, int r2, String r3, int r4, int r5, a r6, a r7) {
        super(r1, r2);
        this.id = r3;
        this.imageRes = r4;
        this.bgRes = r5;
        this.iconStateColorList = r6;
        this.textStateColorList = null;
        this.backgroundStateColorList = r7;
    }

    public EMenuItemConfig(String r1, int r2, String r3, int r4, a r5, a r6, a r7) {
        super(r1, r2);
        this.bgRes = -1;
        this.id = r3;
        this.imageRes = r4;
        this.iconStateColorList = r5;
        this.textStateColorList = r6;
        this.backgroundStateColorList = r7;
    }
}
