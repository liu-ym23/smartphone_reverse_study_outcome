package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.selectpanel.OfficeSelectPanelAction;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i0 {
    public static final i0 a = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;
        public static final /* synthetic */ int[] d = null;

        static {
            int[] r0 = new int[OfficeSpaceTab.values().length];
            r0[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L69
        L150:
            r0[OfficeSpaceTab.MINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L70
        L164:
            r0[OfficeSpaceTab.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L71
        L176:
            r0[OfficeSpaceTab.FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L72
        L10:
            a = r0;
            int[] r1 = new int[OfficeSpaceHeaderAction.values().length];
            r1[OfficeSpaceHeaderAction.OPEN_MENU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L73
        L200:
            r1[OfficeSpaceHeaderAction.SEARCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L74
        L116:
            r1[OfficeSpaceHeaderAction.CREATE_DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L75
        L128:
            r1[OfficeSpaceHeaderAction.CREATE_PPT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L76
        L138:
            r1[OfficeSpaceHeaderAction.CREATE_BITABLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L77
        L156:
            r1[OfficeSpaceHeaderAction.CREATE_SHEET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L78
        L174:
            r1[OfficeSpaceHeaderAction.CREATE_FOLDER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L79
        L194:
            r1[OfficeSpaceHeaderAction.UPLOAD_IMAGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L80
        L208:
            r1[OfficeSpaceHeaderAction.UPLOAD_FILE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L81
        L118:
            r1[OfficeSpaceHeaderAction.SELECT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L82
        L27:
            b = r1;
            int[] r2 = new int[OfficeLongPressMenuAction.values().length];
            r2[OfficeLongPressMenuAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L83
        L154:
            r2[OfficeLongPressMenuAction.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L84
        L168:
            r2[OfficeLongPressMenuAction.DOWNLOAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L85
        L180:
            r2[OfficeLongPressMenuAction.EXPORT_AS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L86
        L190:
            r2[OfficeLongPressMenuAction.MULTI_SELECT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L87
        L202:
            r2[OfficeLongPressMenuAction.STAR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L88
        L122:
            r2[OfficeLongPressMenuAction.COPY_LINK.ordinal()] = 7;     // Catch: NoSuchFieldError -> L89
        L130:
            r2[OfficeLongPressMenuAction.MORE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L90
        L140:
            r2[OfficeLongPressMenuAction.RENAME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L91
        L152:
            r2[OfficeLongPressMenuAction.MAKE_COPY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L92
        L186:
            r2[OfficeLongPressMenuAction.MOVE_TO.ordinal()] = 11;     // Catch: NoSuchFieldError -> L93
        L196:
            r2[OfficeLongPressMenuAction.ADD_SHORTCUT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L94
        L198:
            r2[OfficeLongPressMenuAction.SECRET_SETTING.ordinal()] = 13;     // Catch: NoSuchFieldError -> L95
        L120:
            r2[OfficeLongPressMenuAction.DELETE_SOURCE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L96
        L148:
            r2[OfficeLongPressMenuAction.REMOVE_RECENT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L97
        L162:
            r2[OfficeLongPressMenuAction.SORT.ordinal()] = 16;     // Catch: NoSuchFieldError -> L98
        L166:
            r2[OfficeLongPressMenuAction.FILTER.ordinal()] = 17;     // Catch: NoSuchFieldError -> L99
        L178:
            r2[OfficeLongPressMenuAction.TOGGLE_DISPLAY_MODE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L100
        L51:
            c = r2;
            int[] r3 = new int[OfficeSelectPanelAction.values().length];
            r3[OfficeSelectPanelAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L101
        L126:
            r3[OfficeSelectPanelAction.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L102
        L134:
            r3[OfficeSelectPanelAction.DOWNLOAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L103
        L146:
            r3[OfficeSelectPanelAction.RENAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L104
        L160:
            r3[OfficeSelectPanelAction.MOVE_TO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L105
        L172:
            r3[OfficeSelectPanelAction.DELETE_SOURCE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L106
        L184:
            r3[OfficeSelectPanelAction.REMOVE_RECENT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L107
        L192:
            r3[OfficeSelectPanelAction.FAVORITE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L108
        L204:
            r3[OfficeSelectPanelAction.CANCEL_FAVORITE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L109
        L124:
            r3[OfficeSelectPanelAction.COPY_LINK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L110
        L132:
            r3[OfficeSelectPanelAction.CREATE_COPY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L111
        L144:
            r3[OfficeSelectPanelAction.ADD_SHORTCUT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L112
        L158:
            r3[OfficeSelectPanelAction.OFFLINE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L113
        L170:
            r3[OfficeSelectPanelAction.FOLLOW_UPDATE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L114
        L182:
            r3[OfficeSelectPanelAction.SECURITY_LEVEL.ordinal()] = 15;     // Catch: NoSuchFieldError -> L115
        L67:
            d = r3;
        }
    }

    static {
        a = new i0();
    }

    public i0() {
    }

    public static String a(OfficeSpaceTab r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "recent";
    L5:
        if (r2 != 2) goto L7;
        return "mine";
    L7:
        if (r2 != 3) goto L9;
        return "shared";
    L9:
        if (r2 != 4) goto L12;
        return "favorite";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static boolean d(OfficeListSortFilterScene r1) {
        OfficeListSortFilterScene.Kind r2 = r1.a;
        if (r2 != OfficeListSortFilterScene.Kind.SUB_FOLDER) goto L5;
    L8:
        return true;
    L5:
        if (r2 == OfficeListSortFilterScene.Kind.SHARED_FOLDER) goto L8;
        return false;
    }

    public static void e(String r3, JSONObject r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).i(r3, r4);     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L12;
        tt5.a.e("OfficeSpaceTracker", "report failed. event=".concat(r3), r6, false);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public final void g(OfficeSpaceTab r11, String r12, String r13) {
        Intrinsics.checkNotNullParameter(r11, "tab");
        Intrinsics.checkNotNullParameter(r12, "click");
        JSONObject r14 = c(this, a(r11), null, 0, null, null, null, null, 126);
        r14.remove("file_id");
        r14.remove("file_type");
        r14.put("click", r12);
        if (r13 == null) goto L5;
        r14.put("action_type", r13);
    L5:
        e("ccm_space_home_page_click", r14);
    }

    public final void f(OfficeSpaceTab r12, OfficeSpaceHeaderAction r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r12, "tab");
        Intrinsics.checkNotNullParameter(r13, "action");
        String r2 = a(r12);
        int[] r0 = a.b;
        switch(r0[r13.ordinal()]) {
            case 1: goto L12;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L12;
            default: goto L5;
        };
    L6:
        int r1 = sbb.e.l.b;
    L13:
        int r4 = r1;
        if (r14 != null) goto L16;
    L19:
        boolean r3 = true;
    L20:
        String r10 = null;
        if (r3 == true) goto L23;
        String r6 = r14;
    L24:
        if (r14 != null) goto L26;
    L31:
        String r7 = null;
    L32:
        JSONObject r16 = c(this, r2, null, r4, null, r6, r7, null, 74);
        switch(r0[r13.ordinal()]) {
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            case 8: goto L38;
            case 9: goto L37;
            case 10: goto L36;
            default: goto L35;
        };
    L36:
        String r5 = "select";
    L46:
        r16.put("click", r5);
        switch(r0[r13.ordinal()]) {
            case 1: goto L53;
            case 2: goto L53;
            case 3: goto L52;
            case 4: goto L52;
            case 5: goto L52;
            case 6: goto L52;
            case 7: goto L51;
            case 8: goto L50;
            case 9: goto L50;
            case 10: goto L53;
            default: goto L49;
        };
    L50:
        r10 = "ccm_space_file_choose_view";
        goto L53
    L51:
        r10 = "ccm_space_folder_view";
        goto L53
    L52:
        r10 = "ccm_docs_page_view";
    L53:
        if (r10 == null) goto L55;
        r16.put("target", r10);
    L55:
        if (r15 == false) goto L57;
        r16.put("folder_tab", a(r12));
    L57:
        e("ccm_space_create_new_click", r16);
        return;
    L49:
        throw new NoWhenBranchMatchedException();
    L37:
        r5 = "upload_file";
        goto L46
    L38:
        r5 = "upload_image";
        goto L46
    L39:
        r5 = "new_folder";
        goto L46
    L40:
        r5 = "new_sheet";
        goto L46
    L41:
        r5 = "new_bitable";
        goto L46
    L42:
        r5 = "new_ppt";
        goto L46
    L43:
        r5 = "new_doc";
        goto L46
    L44:
        r5 = ThumbGlideUrl.SOURCE_SEARCH;
        goto L46
    L45:
        r5 = "menu";
        goto L46
    L35:
        throw new NoWhenBranchMatchedException();
    L26:
        if (StringsKt.isBlank(r14) == false) goto L29;
        r14 = null;
    L29:
        if (r14 == null) goto L31;
        r7 = DocumentType.FOLDER_NAME;
        goto L32
    L23:
        r6 = null;
        goto L24
    L16:
        if (StringsKt.isBlank(r14) == true) goto L19;
        r3 = false;
        goto L20
    L7:
        r1 = sbb.e.f.b;
        goto L13
    L8:
        r1 = sbb.e.h.b;
        goto L13
    L9:
        r1 = sbb.e.i.b;
        goto L13
    L10:
        r1 = sbb.e.m.b;
        goto L13
    L11:
        r1 = sbb.e.g.b;
        goto L13
    L12:
        r1 = sbb.e.e.b;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void h(OfficeSpaceTab r11, OfficeSelectPanelAction r12, Document r13, Integer r14) {
        Intrinsics.checkNotNullParameter(r11, "tab");
        Intrinsics.checkNotNullParameter(r12, "action");
        String r2 = a(r11);
        String r0 = null;
        if (r13 == null) goto L5;
        String r3 = r13.d;
    L6:
        if (r13 == null) goto L8;
        int r1 = r13.getType();
    L9:
        int r4 = r1;
        if (r13 == null) goto L12;
        String r5 = r13.F;
    L14:
        if (r13 == null) goto L16;
        r0 = t0.m(r13);
    L16:
        JSONObject r6 = c(this, r2, r3, r4, r5, null, null, r0, 48);
        switch(a.d[r12.ordinal()]) {
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L40;
            case 5: goto L39;
            case 6: goto L38;
            case 7: goto L37;
            case 8: goto L27;
            case 9: goto L36;
            case 10: goto L25;
            case 11: goto L24;
            case 12: goto L23;
            case 13: goto L22;
            case 14: goto L21;
            case 15: goto L20;
            default: goto L19;
        };
    L20:
        String r15 = "security_setting";
    L44:
        r6.put("click", r15);
        r6.put("target", "none");
        r6.put("current_page", "ai_space_list");
        if (r14 == null) goto L47;
        r6.put("is_able", r14.intValue());
    L47:
        e("ccm_space_list_operation_panel_click", r6);
        return;
    L21:
        r15 = "follow_update";
        goto L44
    L22:
        r15 = OperationName.OPERATION_OFFLINE_AVAILABLE;
        goto L44
    L23:
        r15 = "add_shortcut";
        goto L44
    L24:
        r15 = "create_copy";
        goto L44
    L25:
        r15 = "copy_link";
    L36:
        r15 = "remove_from_favorites";
        goto L44
    L37:
        r15 = "remove_recent";
        goto L44
    L38:
        r15 = "delete";
        goto L44
    L39:
        r15 = "move_to";
        goto L44
    L40:
        r15 = "rename";
        goto L44
    L41:
        r15 = OperationName.OPERATION_DOWNLOAD;
        goto L44
    L42:
        r15 = "share";
        goto L44
    L43:
        r15 = "ask_doubao";
        goto L44
    L19:
        throw new NoWhenBranchMatchedException();
    L27:
        if (r11 == OfficeSpaceTab.FAVORITE) goto L36;
        if (r13 == null) goto L32;
        boolean r16 = true;
        if (r13.z != true) goto L32;
    L33:
        if (r16 == true) goto L36;
        r15 = "add_to_favorites";
    L32:
        r16 = false;
        goto L33
    L12:
        r5 = null;
        goto L14
    L8:
        r1 = sbb.e.e.b;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public static JSONObject b(String r11, String r12, int r13, String r14, String r15, String r16, String r17) {
        lc5.f.a r0 = lc5.f.a;
        HashMap r1 = lc5.f.a.h(new lc5.g(new JSONObject(), "flow_space", r11, r12, r13, r14, r15, r16, r17));
        JSONObject r2 = new JSONObject();
        Iterator r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        Map.Entry r4 = (Map.Entry) r3.next();
        r2.put((String) r4.getKey(), r4.getValue());
        goto L4
    L6:
        return r2;
    }

    public static JSONObject c(i0 r2, String r3, String r4, int r5, String r6, String r7, String r8, String r9, int r10) {
        if ((r10 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r10 & 4) == 0) goto L9;
        r5 = sbb.e.e.b;
    L9:
        if ((r10 & 8) == 0) goto L12;
        r6 = null;
    L12:
        if ((r10 & 16) == 0) goto L15;
        r7 = null;
    L15:
        if ((r10 & 32) == 0) goto L18;
        r8 = null;
    L18:
        if ((r10 & 64) == 0) goto L20;
        r9 = null;
    L20:
        r2.getClass();
        return b(r3, r4, r5, r6, r7, r8, r9);
    }
}
