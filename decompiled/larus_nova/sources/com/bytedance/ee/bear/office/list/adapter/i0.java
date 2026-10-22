package com.bytedance.ee.bear.office.list.adapter;

import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.selectpanel.OfficeSelectPanelAction;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.doc.sdk.api.VoiceInputFrom;
import com.larus.platform.api.creation.TplType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
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

/* JADX INFO: loaded from: classes18.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f235779a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f235780a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f235781b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f235782c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f235783d = null;

        static {
            int[] r100 = new int[OfficeSpaceTab.values().length];
            r100[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L69
        L150:
            r100[OfficeSpaceTab.MINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L70
        L164:
            r100[OfficeSpaceTab.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L71
        L176:
            r100[OfficeSpaceTab.FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L72
        L10:
            f235780a = r100;
            int[] r101 = new int[OfficeSpaceHeaderAction.values().length];
            r101[OfficeSpaceHeaderAction.OPEN_MENU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L73
        L200:
            r101[OfficeSpaceHeaderAction.SEARCH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L74
        L116:
            r101[OfficeSpaceHeaderAction.CREATE_DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L75
        L128:
            r101[OfficeSpaceHeaderAction.CREATE_PPT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L76
        L138:
            r101[OfficeSpaceHeaderAction.CREATE_BITABLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L77
        L156:
            r101[OfficeSpaceHeaderAction.CREATE_SHEET.ordinal()] = 6;     // Catch: NoSuchFieldError -> L78
        L174:
            r101[OfficeSpaceHeaderAction.CREATE_FOLDER.ordinal()] = 7;     // Catch: NoSuchFieldError -> L79
        L194:
            r101[OfficeSpaceHeaderAction.UPLOAD_IMAGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L80
        L208:
            r101[OfficeSpaceHeaderAction.UPLOAD_FILE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L81
        L118:
            r101[OfficeSpaceHeaderAction.SELECT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L82
        L27:
            f235781b = r101;
            int[] r102 = new int[OfficeLongPressMenuAction.values().length];
            r102[OfficeLongPressMenuAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L83
        L154:
            r102[OfficeLongPressMenuAction.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L84
        L168:
            r102[OfficeLongPressMenuAction.DOWNLOAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L85
        L180:
            r102[OfficeLongPressMenuAction.EXPORT_AS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L86
        L190:
            r102[OfficeLongPressMenuAction.MULTI_SELECT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L87
        L202:
            r102[OfficeLongPressMenuAction.STAR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L88
        L122:
            r102[OfficeLongPressMenuAction.COPY_LINK.ordinal()] = 7;     // Catch: NoSuchFieldError -> L89
        L130:
            r102[OfficeLongPressMenuAction.MORE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L90
        L140:
            r102[OfficeLongPressMenuAction.RENAME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L91
        L152:
            r102[OfficeLongPressMenuAction.MAKE_COPY.ordinal()] = 10;     // Catch: NoSuchFieldError -> L92
        L186:
            r102[OfficeLongPressMenuAction.MOVE_TO.ordinal()] = 11;     // Catch: NoSuchFieldError -> L93
        L196:
            r102[OfficeLongPressMenuAction.ADD_SHORTCUT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L94
        L198:
            r102[OfficeLongPressMenuAction.SECRET_SETTING.ordinal()] = 13;     // Catch: NoSuchFieldError -> L95
        L120:
            r102[OfficeLongPressMenuAction.DELETE_SOURCE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L96
        L148:
            r102[OfficeLongPressMenuAction.REMOVE_RECENT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L97
        L162:
            r102[OfficeLongPressMenuAction.SORT.ordinal()] = 16;     // Catch: NoSuchFieldError -> L98
        L166:
            r102[OfficeLongPressMenuAction.FILTER.ordinal()] = 17;     // Catch: NoSuchFieldError -> L99
        L178:
            r102[OfficeLongPressMenuAction.TOGGLE_DISPLAY_MODE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L100
        L51:
            f235782c = r102;
            int[] r103 = new int[OfficeSelectPanelAction.values().length];
            r103[OfficeSelectPanelAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L101
        L126:
            r103[OfficeSelectPanelAction.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L102
        L134:
            r103[OfficeSelectPanelAction.DOWNLOAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L103
        L146:
            r103[OfficeSelectPanelAction.RENAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L104
        L160:
            r103[OfficeSelectPanelAction.MOVE_TO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L105
        L172:
            r103[OfficeSelectPanelAction.DELETE_SOURCE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L106
        L184:
            r103[OfficeSelectPanelAction.REMOVE_RECENT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L107
        L192:
            r103[OfficeSelectPanelAction.FAVORITE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L108
        L204:
            r103[OfficeSelectPanelAction.CANCEL_FAVORITE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L109
        L124:
            r103[OfficeSelectPanelAction.COPY_LINK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L110
        L132:
            r103[OfficeSelectPanelAction.CREATE_COPY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L111
        L144:
            r103[OfficeSelectPanelAction.ADD_SHORTCUT.ordinal()] = 12;     // Catch: NoSuchFieldError -> L112
        L158:
            r103[OfficeSelectPanelAction.OFFLINE.ordinal()] = 13;     // Catch: NoSuchFieldError -> L113
        L170:
            r103[OfficeSelectPanelAction.FOLLOW_UPDATE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L114
        L182:
            r103[OfficeSelectPanelAction.SECURITY_LEVEL.ordinal()] = 15;     // Catch: NoSuchFieldError -> L115
        L67:
            f235783d = r103;
        }
    }

    static {
        f235779a = new i0();
    }

    public i0() {
    }

    public static String a(OfficeSpaceTab r100) {
        int r101 = a.f235780a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "recent";
    L5:
        if (r101 != 2) goto L7;
        return "mine";
    L7:
        if (r101 != 3) goto L9;
        return "shared";
    L9:
        if (r101 != 4) goto L12;
        return "favorite";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static boolean d(OfficeListSortFilterScene r100) {
        OfficeListSortFilterScene.Kind r101 = r100.f235659a;
        if (r101 != OfficeListSortFilterScene.Kind.SUB_FOLDER) goto L5;
    L8:
        return true;
    L5:
        if (r101 == OfficeListSortFilterScene.Kind.SHARED_FOLDER) goto L8;
        return false;
    }

    public static void e(String r100, JSONObject r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).i(r100, r101);     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L12;
        tt5.a.e("OfficeSpaceTracker", "report failed. event=".concat(r100), r104, false);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public final void g(OfficeSpaceTab r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "tab");
        Intrinsics.checkNotNullParameter(r111, "click");
        JSONObject r113 = c(this, a(r110), null, 0, null, null, null, null, 126);
        r113.remove("file_id");
        r113.remove("file_type");
        r113.put("click", r111);
        if (r112 == null) goto L5;
        r113.put("action_type", r112);
    L5:
        e("ccm_space_home_page_click", r113);
    }

    public final void f(OfficeSpaceTab r110, OfficeSpaceHeaderAction r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "tab");
        Intrinsics.checkNotNullParameter(r111, "action");
        String r100 = a(r110);
        int[] r101 = a.f235781b;
        switch(r101[r111.ordinal()]) {
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
        int r102 = sbb.e.f541301l.f541317b;
    L13:
        int r103 = r102;
        if (r112 != null) goto L16;
    L19:
        boolean r104 = true;
    L20:
        String r114 = null;
        if (r104 == true) goto L23;
        String r105 = r112;
    L24:
        if (r112 != null) goto L26;
    L31:
        String r106 = null;
    L32:
        JSONObject r115 = c(this, r100, null, r103, null, r105, r106, null, 74);
        switch(r101[r111.ordinal()]) {
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
        String r107 = "select";
    L46:
        r115.put("click", r107);
        switch(r101[r111.ordinal()]) {
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
        r114 = "ccm_space_file_choose_view";
        goto L53
    L51:
        r114 = "ccm_space_folder_view";
        goto L53
    L52:
        r114 = "ccm_docs_page_view";
    L53:
        if (r114 == null) goto L55;
        r115.put(PickerReporterConstants.KEY.TARGET, r114);
    L55:
        if (r113 == false) goto L57;
        r115.put("folder_tab", a(r110));
    L57:
        e("ccm_space_create_new_click", r115);
        return;
    L49:
        throw new NoWhenBranchMatchedException();
    L37:
        r107 = "upload_file";
        goto L46
    L38:
        r107 = "upload_image";
        goto L46
    L39:
        r107 = "new_folder";
        goto L46
    L40:
        r107 = "new_sheet";
        goto L46
    L41:
        r107 = "new_bitable";
        goto L46
    L42:
        r107 = "new_ppt";
        goto L46
    L43:
        r107 = VoiceInputFrom.NEW_DOC;
        goto L46
    L44:
        r107 = "search";
        goto L46
    L45:
        r107 = TplType.MENU;
        goto L46
    L35:
        throw new NoWhenBranchMatchedException();
    L26:
        if (StringsKt.isBlank(r112) == false) goto L29;
        r112 = null;
    L29:
        if (r112 == null) goto L31;
        r106 = DocumentType.FOLDER_NAME;
        goto L32
    L23:
        r105 = null;
        goto L24
    L16:
        if (StringsKt.isBlank(r112) == true) goto L19;
        r104 = false;
        goto L20
    L7:
        r102 = sbb.e.f541295f.f541317b;
        goto L13
    L8:
        r102 = sbb.e.f541297h.f541317b;
        goto L13
    L9:
        r102 = sbb.e.f541298i.f541317b;
        goto L13
    L10:
        r102 = sbb.e.f541302m.f541317b;
        goto L13
    L11:
        r102 = sbb.e.f541296g.f541317b;
        goto L13
    L12:
        r102 = sbb.e.f541294e.f541317b;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final void h(OfficeSpaceTab r110, OfficeSelectPanelAction r111, Document r112, Integer r113) {
        Intrinsics.checkNotNullParameter(r110, "tab");
        Intrinsics.checkNotNullParameter(r111, "action");
        String r100 = a(r110);
        String r101 = null;
        if (r112 == null) goto L5;
        String r102 = r112.f227873d;
    L6:
        if (r112 == null) goto L8;
        int r103 = r112.getType();
    L9:
        int r104 = r103;
        if (r112 == null) goto L12;
        String r105 = r112.F;
    L14:
        if (r112 == null) goto L16;
        r101 = t0.m(r112);
    L16:
        JSONObject r106 = c(this, r100, r102, r104, r105, null, null, r101, 48);
        switch(a.f235783d[r111.ordinal()]) {
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
        String r114 = "security_setting";
    L44:
        r106.put("click", r114);
        r106.put(PickerReporterConstants.KEY.TARGET, "none");
        r106.put("current_page", "ai_space_list");
        if (r113 == null) goto L47;
        r106.put("is_able", r113.intValue());
    L47:
        e("ccm_space_list_operation_panel_click", r106);
        return;
    L21:
        r114 = "follow_update";
        goto L44
    L22:
        r114 = OperationName.OPERATION_OFFLINE_AVAILABLE;
        goto L44
    L23:
        r114 = "add_shortcut";
        goto L44
    L24:
        r114 = "create_copy";
        goto L44
    L25:
        r114 = "copy_link";
    L36:
        r114 = "remove_from_favorites";
        goto L44
    L37:
        r114 = "remove_recent";
        goto L44
    L38:
        r114 = "delete";
        goto L44
    L39:
        r114 = "move_to";
        goto L44
    L40:
        r114 = "rename";
        goto L44
    L41:
        r114 = "download";
        goto L44
    L42:
        r114 = "share";
        goto L44
    L43:
        r114 = ShareChannel.ASK_DOUBAO;
        goto L44
    L19:
        throw new NoWhenBranchMatchedException();
    L27:
        if (r110 == OfficeSpaceTab.FAVORITE) goto L36;
        if (r112 == null) goto L32;
        boolean r115 = true;
        if (r112.f227910z != true) goto L32;
    L33:
        if (r115 == true) goto L36;
        r114 = "add_to_favorites";
    L32:
        r115 = false;
        goto L33
    L12:
        r105 = null;
        goto L14
    L8:
        r103 = sbb.e.f541294e.f541317b;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public static JSONObject b(String r110, String r111, int r112, String r113, String r114, String r115, String r116) {
        lc5.f.a r100 = lc5.f.f508440a;
        HashMap r101 = lc5.f.a.h(new lc5.g(new JSONObject(), "flow_space", r110, r111, r112, r113, r114, r115, r116));
        JSONObject r102 = new JSONObject();
        Iterator r103 = r101.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.put((String) r104.getKey(), r104.getValue());
        goto L4
    L6:
        return r102;
    }

    public static JSONObject c(i0 r100, String r101, String r102, int r103, String r104, String r105, String r106, String r107, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r103 = sbb.e.f541294e.f541317b;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r104 = null;
    L12:
        if ((r110 & 16) == 0) goto L15;
        r105 = null;
    L15:
        if ((r110 & 32) == 0) goto L18;
        r106 = null;
    L18:
        if ((r110 & 64) == 0) goto L20;
        r107 = null;
    L20:
        r100.getClass();
        return b(r101, r102, r103, r104, r105, r106, r107);
    }
}
