package com.bytedance.ee.bear.office.list.selectpanel;

import android.content.Context;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f236033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Document, Boolean> f236034b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f236035a = null;

        static {
            int[] r100 = new int[OfficeSelectPanelAction.values().length];
            r100[OfficeSelectPanelAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L53:
            r100[OfficeSelectPanelAction.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L63:
            r100[OfficeSelectPanelAction.DELETE_SOURCE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[OfficeSelectPanelAction.REMOVE_RECENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[OfficeSelectPanelAction.COPY_LINK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L49:
            r100[OfficeSelectPanelAction.FAVORITE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L59:
            r100[OfficeSelectPanelAction.CANCEL_FAVORITE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L45:
            r100[OfficeSelectPanelAction.CREATE_COPY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L55:
            r100[OfficeSelectPanelAction.RENAME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[OfficeSelectPanelAction.MOVE_TO.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L37:
            r100[OfficeSelectPanelAction.ADD_SHORTCUT.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L51:
            r100[OfficeSelectPanelAction.SECURITY_LEVEL.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L61:
            r100[OfficeSelectPanelAction.DOWNLOAD.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L35:
            r100[OfficeSelectPanelAction.OFFLINE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L43:
            r100[OfficeSelectPanelAction.FOLLOW_UPDATE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L18:
            f236035a = r100;
        }
    }

    public static int b(OfficeSelectPanelAction r100) {
        switch(a.f236035a[r100.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            case 14: goto L6;
            case 15: goto L16;
            default: goto L5;
        };
    L6:
        return R.drawable.dbx_ic_download;
    L7:
        return R.drawable.dbx_ic_code_check_fill;
    L8:
        return R.drawable.dbx_ic_shortcut;
    L9:
        return R.drawable.dbx_ic_folder_move_fill;
    L10:
        return R.drawable.dbx_ic_edit_fill;
    L11:
        return R.drawable.dbx_ic_copy_fill;
    L12:
        return R.drawable.dbx_ic_bookmark_delete_fill;
    L13:
        return R.drawable.db_ic_book_mark_fill;
    L14:
        return R.drawable.dbx_ic_link_bold;
    L15:
        return R.drawable.dbx_ic_trash_fill;
    L16:
        return R.drawable.dbx_ic_share_fill;
    L17:
        return R.drawable.dbx_ic_reference;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Context r100, Function1<? super Document, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "canShowRecentRealDelete");
        this.f236033a = r100;
        this.f236034b = r101;
    }

    public final d a(OfficeSelectPanelAction r100, String r101) {
        return new d(r100, r101, b(r100), this.f236033a.getString(R.string.LarkCCM_Drive_UnsupportedAction_Toast), 960);
    }

    public final String c(OfficeSpaceTab r100, OfficeSelectPanelAction r101) {
        if (r100 == OfficeSpaceTab.RECENT) goto L5;
    L7:
        String r102 = this.f236033a.getString(R.string.LarkCCM_Doubao_Drive_Delete_Button);
        Intrinsics.checkNotNull(r102);
        return r102;
    L5:
        if (r101 != OfficeSelectPanelAction.REMOVE_RECENT) goto L7;
        String r103 = this.f236033a.getString(R.string.LarkCCM_Doubao_Drive_Remove_Button);
        Intrinsics.checkNotNull(r103);
        return r103;
    }

    public final List<d> d(OfficeSpaceTab r110, List<? extends Document> r111) {
        Intrinsics.checkNotNullParameter(r110, "tab");
        Intrinsics.checkNotNullParameter(r111, "selectedDocuments");
        if (r111.isEmpty() == false) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (r111.size() >= 2) goto L9;
        Document r112 = (Document) CollectionsKt.first(r111);
        OfficeSpaceTab r100 = OfficeSpaceTab.RECENT;
        if (r110 == r100) goto L40;
        if (r110 != r100) goto L46;
        OfficeSelectPanelAction r113 = OfficeSelectPanelAction.REMOVE_RECENT;
    L48:
        return CollectionsKt.listOf(a(r113, this.f236033a.getString(R.string.LarkCCM_Doubao_Drive_Delete_Button)));
    L46:
        r113 = OfficeSelectPanelAction.DELETE_SOURCE;
        goto L48
    L40:
        if (this.f236034b.invoke(r112).booleanValue() == false) goto L42;
        OfficeSelectPanelAction r114 = OfficeSelectPanelAction.DELETE_SOURCE;
    L43:
        OfficeSelectPanelAction r101 = r114;
        return CollectionsKt.listOf(new d(r101, c(r110, r101), b(r101), null, 1000));
    L42:
        r114 = OfficeSelectPanelAction.REMOVE_RECENT;
        goto L43
    L9:
        if (r110 != OfficeSpaceTab.RECENT) goto L11;
        OfficeSelectPanelAction r102 = OfficeSelectPanelAction.REMOVE_RECENT;
    L12:
        OfficeSelectPanelAction r103 = r102;
        if (r103 != OfficeSelectPanelAction.DELETE_SOURCE) goto L29;
        List<? extends Document> r115 = r111;
        if ((r115 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r116 = r115.iterator();
    L21:
        if (r116.hasNext() == false) goto L25;
        if (((Document) r116.next()).b() == false) goto L21;
        boolean r117 = true;
    L26:
        if (r117 == false) goto L29;
        d r118 = a(r103, c(r110, r103));
    L36:
        return CollectionsKt.listOf(r118);
    L25:
        r117 = false;
        goto L26
    L17:
        if (r115.isEmpty() == false) goto L19;
    L29:
        if (r110 != OfficeSpaceTab.RECENT) goto L31;
    L34:
        r118 = new d(r103, c(r110, r103), b(r103), null, 1000);
        goto L36
    L31:
        if (r110 == OfficeSpaceTab.MINE) goto L34;
        r118 = a(r103, this.f236033a.getString(R.string.LarkCCM_Doubao_Drive_Delete_Button));
        goto L36
    L11:
        r102 = OfficeSelectPanelAction.DELETE_SOURCE;
        goto L12
    }
}
