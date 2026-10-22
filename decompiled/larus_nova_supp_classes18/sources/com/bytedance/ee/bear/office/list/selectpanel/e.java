package com.bytedance.ee.bear.office.list.selectpanel;

import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressMenuAction;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressMenuItemState;
import com.bytedance.ee.bear.office.list.adapter.b0;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeLongPressMenuAction.values().length];
            r0[OfficeLongPressMenuAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L63:
            r0[OfficeLongPressMenuAction.SHARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L75:
            r0[OfficeLongPressMenuAction.DOWNLOAD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L47:
            r0[OfficeLongPressMenuAction.EXPORT_AS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L51:
            r0[OfficeLongPressMenuAction.STAR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L59:
            r0[OfficeLongPressMenuAction.COPY_LINK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L69:
            r0[OfficeLongPressMenuAction.RENAME.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L55:
            r0[OfficeLongPressMenuAction.MAKE_COPY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L65:
            r0[OfficeLongPressMenuAction.MOVE_TO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L67:
            r0[OfficeLongPressMenuAction.ADD_SHORTCUT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L43:
            r0[OfficeLongPressMenuAction.SECRET_SETTING.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
        L61:
            r0[OfficeLongPressMenuAction.DELETE_SOURCE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
        L73:
            r0[OfficeLongPressMenuAction.REMOVE_RECENT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
        L41:
            r0[OfficeLongPressMenuAction.MULTI_SELECT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
        L53:
            r0[OfficeLongPressMenuAction.MORE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L37
        L71:
            r0[OfficeLongPressMenuAction.SORT.ordinal()] = 16;     // Catch: NoSuchFieldError -> L38
        L45:
            r0[OfficeLongPressMenuAction.FILTER.ordinal()] = 17;     // Catch: NoSuchFieldError -> L39
        L49:
            r0[OfficeLongPressMenuAction.TOGGLE_DISPLAY_MODE.ordinal()] = 18;     // Catch: NoSuchFieldError -> L40
        L21:
            a = r0;
        }
    }

    public e() {
    }

    public static List a(com.bytedance.ee.bear.office.list.menuconfig.a r12) {
        OfficeLongPressMenuAction r1 = r12.b;
        if (r1 == null) goto L57;
        String r0 = r12.a;
        switch(r0.hashCode()) {
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
        int r2 = 0;
    L56:
        b0 r11 = new b0(r1, r2, r12.c, r12.d, r12.e, r12.f, r12.h, r12.g, r12.i, r12.j);
    L58:
        List r3 = CollectionsKt.listOfNotNull(r11);
        List<com.bytedance.ee.bear.office.list.menuconfig.a> r13 = r12.l;
        ArrayList r4 = new ArrayList();
        Iterator<T> r14 = r13.iterator();
    L60:
        if (r14.hasNext() == false) goto L63;
        CollectionsKt.addAll(r4, a((com.bytedance.ee.bear.office.list.menuconfig.a) r14.next()));
        goto L60
    L63:
        return CollectionsKt.plus(r3, r4);
    L8:
        if (r0.equals("add_shortcut") == false) goto L55;
        r2 = 103;
        goto L56
    L12:
        if (r0.equals("secret_setting") == false) goto L55;
        r2 = 104;
        goto L56
    L16:
        if (r0.equals("copy_link") == false) goto L55;
        r2 = 6;
        goto L56
    L20:
        if (r0.equals(OperationName.OPERATION_DOWNLOAD) == false) goto L55;
        r2 = 3;
        goto L56
    L24:
        if (r0.equals("remove_recent") == false) goto L55;
        r2 = 106;
        goto L56
    L28:
        if (r0.equals("make_copy") == false) goto L55;
        r2 = UserInfo.OWNER_TYPE_AUTO_GRANTED_DEPARTMENT;
        goto L56
    L32:
        if (r0.equals("move_to") == false) goto L55;
        r2 = 102;
        goto L56
    L36:
        if (r0.equals("favorite") == false) goto L55;
        r2 = 5;
        goto L56
    L40:
        if (r0.equals("share") == false) goto L55;
        r2 = 2;
        goto L56
    L44:
        if (r0.equals("ask_doubao") == false) goto L55;
        r2 = 1;
        goto L56
    L48:
        if (r0.equals("rename") == false) goto L55;
        r2 = 107;
        goto L56
    L52:
        if (r0.equals("delete") == false) goto L55;
        r2 = 105;
        goto L56
    L57:
        r11 = null;
        goto L58
    }

    public static List b(List r19, List r20, List r21) {
        Intrinsics.checkNotNullParameter(r19, "defaultMainSpecs");
        Intrinsics.checkNotNullParameter(r20, "defaultMoreSpecs");
        if (r21 == null) goto L8;
        Collection r1 = new ArrayList();
        Iterator r0 = r21.iterator();
    L6:
        if (r0.hasNext() == false) goto L9;
        CollectionsKt.addAll(r1, a((com.bytedance.ee.bear.office.list.menuconfig.a) r0.next()));
    L9:
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L11:
        if (r3.hasNext() == false) goto L88;
        b0 r4 = (b0) r3.next();
        if (r4.e != OfficeLongPressMenuItemState.HIDDEN) goto L16;
    L22:
        boolean r5 = false;
    L23:
        d r6 = null;
        if (r5 == false) goto L86;
        OfficeLongPressMenuAction r7 = r4.a;
        int[] r8 = a.a;
        switch(r8[r7.ordinal()]) {
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
        OfficeSelectPanelAction r9 = null;
    L45:
        if (r9 == null) goto L86;
        if (r4.e != OfficeLongPressMenuItemState.LOADING_BLOCKED) goto L50;
        boolean r16 = true;
    L51:
        String r10 = r4.c;
        switch(r8[r4.a.ordinal()]) {
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
        int r11 = 2131233765;
    L70:
        if (r4.e == OfficeLongPressMenuItemState.VISIBLE) goto L74;
        if (r16 == true) goto L74;
        boolean r12 = false;
    L75:
        OfficeLongPressMenuAction r13 = r4.a;
        if (r13 != OfficeLongPressMenuAction.DELETE_SOURCE) goto L78;
    L81:
        boolean r14 = true;
    L82:
        String r15 = r4.f;
        if (r15 != null) goto L85;
        r15 = com.bytedance.ee.bear.more.office.f.c();
    L85:
        r6 = new d(r9, r10, r11, r12, r14, r15, r4.a, r16, r4.i, r4.j);
        goto L86
    L78:
        if (r13 == OfficeLongPressMenuAction.REMOVE_RECENT) goto L81;
        r14 = false;
    L74:
        r12 = true;
        goto L75
    L56:
        r11 = 2131233738;
        goto L70
    L57:
        r11 = 2131233762;
        goto L70
    L58:
        r11 = 2131233752;
        goto L70
    L59:
        r11 = 2131233739;
        goto L70
    L60:
        r11 = 2131233743;
        goto L70
    L61:
        r11 = 2131233756;
        goto L70
    L66:
        r11 = 2131233741;
        goto L70
    L67:
        r11 = 2131233761;
        goto L70
    L68:
        r11 = 2131233760;
        goto L70
    L63:
        if (r4.d != 2131233733) goto L65;
        r11 = 2131233734;
        goto L70
    L65:
        r11 = 2131233728;
        goto L70
    L54:
        throw new NoWhenBranchMatchedException();
    L50:
        r16 = false;
        goto L51
    L31:
        OfficeSelectPanelAction r17 = OfficeSelectPanelAction.REMOVE_RECENT;
    L44:
        r9 = r17;
        goto L45
    L32:
        r17 = OfficeSelectPanelAction.DELETE_SOURCE;
        goto L44
    L33:
        r17 = OfficeSelectPanelAction.SECURITY_LEVEL;
        goto L44
    L34:
        r17 = OfficeSelectPanelAction.ADD_SHORTCUT;
        goto L44
    L35:
        r17 = OfficeSelectPanelAction.MOVE_TO;
        goto L44
    L36:
        r17 = OfficeSelectPanelAction.CREATE_COPY;
        goto L44
    L37:
        r17 = OfficeSelectPanelAction.RENAME;
        goto L44
    L38:
        r17 = OfficeSelectPanelAction.COPY_LINK;
        goto L44
    L39:
        r17 = OfficeSelectPanelAction.FAVORITE;
        goto L44
    L40:
        r17 = OfficeSelectPanelAction.DOWNLOAD;
        goto L44
    L41:
        r17 = OfficeSelectPanelAction.DOWNLOAD;
        goto L44
    L42:
        r17 = OfficeSelectPanelAction.SHARE;
        goto L44
    L43:
        r17 = OfficeSelectPanelAction.ASK_DOUBAO;
        goto L44
    L29:
        throw new NoWhenBranchMatchedException();
    L86:
        if (r6 == null) goto L11;
        r2.add(r6);
        goto L11
    L16:
        switch(a.a[r4.a.ordinal()]) {
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
        if (r4.b == 101) goto L22;
        r5 = true;
        goto L23
    L18:
        throw new NoWhenBranchMatchedException();
    L88:
        return r2;
    L8:
        r1 = CollectionsKt.plus(r19, r20);
        goto L9
    }
}
