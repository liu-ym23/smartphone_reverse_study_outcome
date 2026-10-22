package com.bytedance.ee.bear.office.list.selectpanel;

import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressMenuAction;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressMenuItemState;
import com.bytedance.ee.bear.office.list.adapter.b0;
import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f236032a = null;

        static {
            int[] r100 = new int[OfficeLongPressMenuAction.values().length];
            r100[OfficeLongPressMenuAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L63:
            r100[OfficeLongPressMenuAction.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L75:
            r100[OfficeLongPressMenuAction.DOWNLOAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L47:
            r100[OfficeLongPressMenuAction.EXPORT_AS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L51:
            r100[OfficeLongPressMenuAction.STAR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L59:
            r100[OfficeLongPressMenuAction.COPY_LINK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L69:
            r100[OfficeLongPressMenuAction.RENAME.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L55:
            r100[OfficeLongPressMenuAction.MAKE_COPY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L65:
            r100[OfficeLongPressMenuAction.MOVE_TO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L67:
            r100[OfficeLongPressMenuAction.ADD_SHORTCUT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L43:
            r100[OfficeLongPressMenuAction.SECRET_SETTING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
        L61:
            r100[OfficeLongPressMenuAction.DELETE_SOURCE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
        L73:
            r100[OfficeLongPressMenuAction.REMOVE_RECENT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
        L41:
            r100[OfficeLongPressMenuAction.MULTI_SELECT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
        L53:
            r100[OfficeLongPressMenuAction.MORE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L37
        L71:
            r100[OfficeLongPressMenuAction.SORT.ordinal()] = 16;     // Catch: NoSuchFieldError -> L38
        L45:
            r100[OfficeLongPressMenuAction.FILTER.ordinal()] = 17;     // Catch: NoSuchFieldError -> L39
        L49:
            r100[OfficeLongPressMenuAction.TOGGLE_DISPLAY_MODE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L40
        L21:
            f236032a = r100;
        }
    }

    public e() {
    }

    public static List a(com.bytedance.ee.bear.office.list.menuconfig.a r110) {
        OfficeLongPressMenuAction r100 = r110.f235929b;
        if (r100 == null) goto L57;
        String r101 = r110.f235928a;
        switch(r101.hashCode()) {
            case -1335458389: goto L52;
            case -934594754: goto L48;
            case -401149172: goto L44;
            case 109400031: goto L40;
            case 1050790300: goto L36;
            case 1243568553: goto L32;
            case 1265821478: goto L28;
            case 1304391286: goto L24;
            case 1427818632: goto L20;
            case 1505434244: goto L16;
            case 1791513537: goto L12;
            case 1901115940: goto L8;
            default: goto L55;
        };
    L55:
        int r102 = 0;
    L56:
        b0 r111 = new b0(r100, r102, r110.f235930c, r110.f235931d, r110.f235932e, r110.f235933f, r110.f235935h, r110.f235934g, r110.f235936i, r110.f235937j);
    L58:
        List r103 = CollectionsKt.listOfNotNull(r111);
        List<com.bytedance.ee.bear.office.list.menuconfig.a> r112 = r110.f235939l;
        ArrayList r104 = new ArrayList();
        Iterator<T> r113 = r112.iterator();
    L60:
        if (r113.hasNext() == false) goto L63;
        CollectionsKt.addAll(r104, a((com.bytedance.ee.bear.office.list.menuconfig.a) r113.next()));
        goto L60
    L63:
        return CollectionsKt.plus(r103, r104);
    L8:
        if (r101.equals("add_shortcut") == false) goto L55;
        r102 = 103;
        goto L56
    L12:
        if (r101.equals("secret_setting") == false) goto L55;
        r102 = 104;
        goto L56
    L16:
        if (r101.equals("copy_link") == false) goto L55;
        r102 = 6;
        goto L56
    L20:
        if (r101.equals("download") == false) goto L55;
        r102 = 3;
        goto L56
    L24:
        if (r101.equals("remove_recent") == false) goto L55;
        r102 = 106;
        goto L56
    L28:
        if (r101.equals("make_copy") == false) goto L55;
        r102 = 108;
        goto L56
    L32:
        if (r101.equals("move_to") == false) goto L55;
        r102 = 102;
        goto L56
    L36:
        if (r101.equals("favorite") == false) goto L55;
        r102 = 5;
        goto L56
    L40:
        if (r101.equals("share") == false) goto L55;
        r102 = 2;
        goto L56
    L44:
        if (r101.equals(ShareChannel.ASK_DOUBAO) == false) goto L55;
        r102 = 1;
        goto L56
    L48:
        if (r101.equals("rename") == false) goto L55;
        r102 = 107;
        goto L56
    L52:
        if (r101.equals("delete") == false) goto L55;
        r102 = 105;
        goto L56
    L57:
        r111 = null;
        goto L58
    }

    public static List b(List r110, List r210, List r211) {
        Intrinsics.checkNotNullParameter(r110, "defaultMainSpecs");
        Intrinsics.checkNotNullParameter(r210, "defaultMoreSpecs");
        if (r211 == null) goto L8;
        Collection r100 = new ArrayList();
        Iterator r101 = r211.iterator();
    L6:
        if (r101.hasNext() == false) goto L9;
        CollectionsKt.addAll(r100, a((com.bytedance.ee.bear.office.list.menuconfig.a) r101.next()));
    L9:
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L11:
        if (r103.hasNext() == false) goto L88;
        b0 r104 = (b0) r103.next();
        if (r104.f235727e != OfficeLongPressMenuItemState.HIDDEN) goto L16;
    L22:
        boolean r105 = false;
    L23:
        d r106 = null;
        if (r105 == false) goto L86;
        OfficeLongPressMenuAction r107 = r104.f235723a;
        int[] r108 = a.f236032a;
        switch(r108[r107.ordinal()]) {
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L41;
            case 4: goto L40;
            case 5: goto L39;
            case 6: goto L38;
            case 7: goto L37;
            case 8: goto L36;
            case 9: goto L35;
            case 10: goto L34;
            case 11: goto L33;
            case 12: goto L32;
            case 13: goto L31;
            case 14: goto L30;
            case 15: goto L30;
            case 16: goto L30;
            case 17: goto L30;
            case 18: goto L30;
            default: goto L29;
        };
    L30:
        OfficeSelectPanelAction r109 = null;
    L45:
        if (r109 == null) goto L86;
        if (r104.f235727e != OfficeLongPressMenuItemState.LOADING_BLOCKED) goto L50;
        boolean r111 = true;
    L51:
        String r112 = r104.f235725c;
        switch(r108[r104.f235723a.ordinal()]) {
            case 1: goto L68;
            case 2: goto L67;
            case 3: goto L66;
            case 4: goto L66;
            case 5: goto L63;
            case 6: goto L61;
            case 7: goto L60;
            case 8: goto L59;
            case 9: goto L58;
            case 10: goto L57;
            case 11: goto L56;
            case 12: goto L55;
            case 13: goto L55;
            case 14: goto L67;
            case 15: goto L67;
            case 16: goto L67;
            case 17: goto L67;
            case 18: goto L67;
            default: goto L54;
        };
    L55:
        int r113 = R.drawable.dbx_ic_trash_fill;
    L70:
        if (r104.f235727e == OfficeLongPressMenuItemState.VISIBLE) goto L74;
        if (r111 == true) goto L74;
        boolean r114 = false;
    L75:
        OfficeLongPressMenuAction r115 = r104.f235723a;
        if (r115 != OfficeLongPressMenuAction.DELETE_SOURCE) goto L78;
    L81:
        boolean r116 = true;
    L82:
        String r117 = r104.f235728f;
        if (r117 != null) goto L85;
        r117 = com.bytedance.ee.bear.more.office.f.c();
    L85:
        r106 = new d(r109, r112, r113, r114, r116, r117, r104.f235723a, r111, r104.f235731i, r104.f235732j);
        goto L86
    L78:
        if (r115 == OfficeLongPressMenuAction.REMOVE_RECENT) goto L81;
        r116 = false;
    L74:
        r114 = true;
        goto L75
    L56:
        r113 = R.drawable.dbx_ic_code_check_fill;
        goto L70
    L57:
        r113 = R.drawable.dbx_ic_shortcut;
        goto L70
    L58:
        r113 = R.drawable.dbx_ic_folder_move_fill;
        goto L70
    L59:
        r113 = R.drawable.dbx_ic_copy_fill;
        goto L70
    L60:
        r113 = R.drawable.dbx_ic_edit_fill;
        goto L70
    L61:
        r113 = R.drawable.dbx_ic_link_bold;
        goto L70
    L66:
        r113 = R.drawable.dbx_ic_download;
        goto L70
    L67:
        r113 = R.drawable.dbx_ic_share_fill;
        goto L70
    L68:
        r113 = R.drawable.dbx_ic_reference;
        goto L70
    L63:
        if (r104.f235726d != R.drawable.dbx_ic_bookmark_delete) goto L65;
        r113 = R.drawable.dbx_ic_bookmark_delete_fill;
        goto L70
    L65:
        r113 = R.drawable.db_ic_book_mark_fill;
        goto L70
    L54:
        throw new NoWhenBranchMatchedException();
    L50:
        r111 = false;
        goto L51
    L31:
        OfficeSelectPanelAction r118 = OfficeSelectPanelAction.REMOVE_RECENT;
    L44:
        r109 = r118;
        goto L45
    L32:
        r118 = OfficeSelectPanelAction.DELETE_SOURCE;
        goto L44
    L33:
        r118 = OfficeSelectPanelAction.SECURITY_LEVEL;
        goto L44
    L34:
        r118 = OfficeSelectPanelAction.ADD_SHORTCUT;
        goto L44
    L35:
        r118 = OfficeSelectPanelAction.MOVE_TO;
        goto L44
    L36:
        r118 = OfficeSelectPanelAction.CREATE_COPY;
        goto L44
    L37:
        r118 = OfficeSelectPanelAction.RENAME;
        goto L44
    L38:
        r118 = OfficeSelectPanelAction.COPY_LINK;
        goto L44
    L39:
        r118 = OfficeSelectPanelAction.FAVORITE;
        goto L44
    L40:
        r118 = OfficeSelectPanelAction.DOWNLOAD;
        goto L44
    L41:
        r118 = OfficeSelectPanelAction.DOWNLOAD;
        goto L44
    L42:
        r118 = OfficeSelectPanelAction.SHARE;
        goto L44
    L43:
        r118 = OfficeSelectPanelAction.ASK_DOUBAO;
        goto L44
    L29:
        throw new NoWhenBranchMatchedException();
    L86:
        if (r106 == null) goto L11;
        r102.add(r106);
        goto L11
    L16:
        switch(a.f236032a[r104.f235723a.ordinal()]) {
            case 1: goto L20;
            case 2: goto L20;
            case 3: goto L20;
            case 4: goto L20;
            case 5: goto L20;
            case 6: goto L20;
            case 7: goto L20;
            case 8: goto L20;
            case 9: goto L20;
            case 10: goto L20;
            case 11: goto L20;
            case 12: goto L20;
            case 13: goto L20;
            case 14: goto L22;
            case 15: goto L22;
            case 16: goto L22;
            case 17: goto L22;
            case 18: goto L22;
            default: goto L18;
        };
    L20:
        if (r104.f235724b == 101) goto L22;
        r105 = true;
        goto L23
    L18:
        throw new NoWhenBranchMatchedException();
    L88:
        return r102;
    L8:
        r100 = CollectionsKt.plus(r110, r210);
        goto L9
    }
}
