package com.bytedance.ee.bear.office.list.adapter;

import android.content.Context;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.more.office.OfficeLongPressDisabledDispatchReason;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.util.info.AppInfoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c0 {
    public static final Set<OfficeLongPressMenuAction> d = null;
    public final Context a;
    public final f b;
    public final boolean c;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeSpaceTab.values().length];
            r0[OfficeSpaceTab.RECENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[OfficeSpaceTab.MINE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[OfficeSpaceTab.SHARED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[OfficeSpaceTab.FAVORITE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
        d = SetsKt.setOf(new OfficeLongPressMenuAction[]{OfficeLongPressMenuAction.SHARE, OfficeLongPressMenuAction.COPY_LINK, OfficeLongPressMenuAction.RENAME, OfficeLongPressMenuAction.MOVE_TO, OfficeLongPressMenuAction.DELETE_SOURCE});
    }

    public static z e(a0 r4) {
        v r0 = r4.n;
        if (r0 != null) goto L7;
        OfficeLongPressMenuAction r1 = OfficeLongPressMenuAction.EXPORT_AS;
        z.a r2 = new z.a(com.bytedance.ee.bear.more.office.f.c(), null);
        g(r4, r1, r2, "action_session_missing");
        return r2;
    L7:
        return r0.a(OfficeLongPressLarkAction.EXPORT_AS);
    }

    public final List<b0> c(a0 r29) {
        Intrinsics.checkNotNullParameter(r29, "menuContext");
        ArrayList r8 = new ArrayList();
        boolean r9 = false;
        if (this.c == true) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (r0 == false) goto L17;
        OfficeLongPressMenuAction r14 = OfficeLongPressMenuAction.ASK_DOUBAO;
        h(r29, r14, "Visible", "ask_doubao_enabled_and_supported_type");
        Context r1 = this.a;
        if (en4.a.j() == false) goto L15;
        int r2 = 2131889389;
    L16:
        r8.add(new b0(r14, 1, r1.getString(r2), 2131233744, null, null, null, null, false, null, 1008));
    L28:
        int r3 = e0.a;
        g0 r4 = e0.d(this.a, r29.b, r29.c, r29.f);
        r8.add(new b0(OfficeLongPressMenuAction.SHARE, 2, this.a.getString(2131889451), 2131244684, f0.b(r4), f0.a(r4), null, null, false, null, 960));
        Document r5 = r29.b;
        if (r5.getType() != sbb.e.l.b) goto L31;
    L36:
        boolean r6 = true;
    L37:
        OfficeListSortFilterScene r15 = null;
        if (r6 == false) goto L44;
        OfficeLongPressMenuAction r7 = OfficeLongPressMenuAction.DOWNLOAD;
        String r10 = this.a.getString(2131889424);
        v r11 = r29.n;
        if (r11 == null) goto L42;
        z r12 = r11.a(OfficeLongPressLarkAction.DOWNLOAD);
    L43:
        r8.add(f(this, r7, 3, r10, 2131244673, r12));
    L46:
        if ((!Intrinsics.areEqual(e(r29), z.b.a)) == false) goto L48;
        r8.add(f(this, OfficeLongPressMenuAction.EXPORT_AS, 3, this.a.getString(2131889424), 2131244673, e(r29)));
    L50:
        if (r29.i == false) goto L52;
        OfficeLongPressMenuAction r13 = OfficeLongPressMenuAction.MULTI_SELECT;
        h(r29, r13, "Visible", "can_multi_select");
        r8.add(new b0(r13, 4, this.a.getString(2131889436), 2131233759, null, null, null, null, false, null, 1008));
    L53:
        g0 r16 = e0.f(this.a, r29.c, r29.f);
        OfficeLongPressMenuAction r17 = OfficeLongPressMenuAction.STAR;
        OfficeSpaceTab r18 = r29.h;
        OfficeSpaceTab r19 = OfficeSpaceTab.FAVORITE;
        if (r18 != r19) goto L56;
    L59:
        String r20 = this.a.getString(2131889631);
        Intrinsics.checkNotNull(r20);
    L60:
        String r110 = r20;
        if (r29.h != r19) goto L63;
    L66:
        int r21 = 2131233733;
    L67:
        r8.add(new b0(r17, 5, r110, r21, f0.b(r16), f0.a(r16), null, null, false, null, 960));
        g0 r22 = e0.a(r29.d);
        r8.add(new b0(OfficeLongPressMenuAction.COPY_LINK, 6, this.a.getString(2131889418), 2131233755, f0.b(r22), f0.a(r22), null, null, false, null, 960));
        OfficeLongPressMenuAction r23 = OfficeLongPressMenuAction.MAKE_COPY;
        String r24 = this.a.getString(2131889431);
        v r25 = r29.n;
        if (r25 == null) goto L70;
        z r26 = r25.a(OfficeLongPressLarkAction.MAKE_COPY);
    L71:
        r8.add(f(this, r23, UserInfo.OWNER_TYPE_AUTO_GRANTED_DEPARTMENT, r24, 2131244681, r26));
        ArrayList r27 = (ArrayList) d(r29);
        if (r27.isEmpty() == true) goto L85;
        Iterator r28 = r27.iterator();
    L76:
        if (r28.hasNext() == false) goto L85;
        b0 r30 = (b0) r28.next();
        if (r30.b != 101) goto L80;
    L82:
        boolean r31 = false;
    L83:
        if (r31 == false) goto L76;
        boolean r32 = true;
    L86:
        if (r32 == false) goto L88;
        OfficeLongPressMenuAction r33 = OfficeLongPressMenuAction.MORE;
        h(r29, r33, "Visible", "has_visible_more_action");
        r8.add(new b0(r33, 7, this.a.getString(2131889435), 2131244683, null, null, 2131233730, null, false, null, 944));
    L89:
        OfficeListSortFilterScene r34 = r29.j;
        if (r34 != null) goto L92;
    L97:
        h(r29, OfficeLongPressMenuAction.SORT, "Hidden", "scene_cannot_sort_or_missing");
    L98:
        OfficeListSortFilterScene r35 = r29.j;
        if (r35 != null) goto L101;
    L105:
        h(r29, OfficeLongPressMenuAction.FILTER, "Hidden", "scene_cannot_filter_or_missing");
    L107:
        if (this.b != null) goto L109;
        OfficeLongPressMenuItemState r36 = OfficeLongPressMenuItemState.DISABLED;
    L110:
        OfficeLongPressMenuItemState r111 = r36;
        OfficeLongPressMenuAction r112 = OfficeLongPressMenuAction.TOGGLE_DISPLAY_MODE;
        String r37 = r111.name();
        if (this.b != null) goto L113;
        String r38 = "display_mode_action_missing";
    L114:
        h(r29, r112, r37, r38);
        Context r39 = this.a;
        if (this.b != null) goto L117;
    L119:
        if (r9 == false) goto L121;
        int r40 = 2131889617;
    L122:
        r8.add(new b0(r112, 10, r39.getString(r40), 2131244682, r111, com.bytedance.ee.bear.more.office.f.c(), null, null, false, null, 960));
        List r41 = b(r29, r8);
        ArrayList r42 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r41, 10));
        Iterator r43 = r41.iterator();
    L124:
        if (r43.hasNext() == false) goto L126;
        r42.add(a(r29, (b0) r43.next()));
        goto L124
    L126:
        return r42;
    L121:
        r40 = 2131889616;
        goto L122
    L117:
        if (t3.a != true) goto L119;
        r9 = true;
        goto L119
    L113:
        r38 = "display_mode_action_ready";
        goto L114
    L109:
        r36 = OfficeLongPressMenuItemState.VISIBLE;
        goto L110
    L101:
        if ((!r35.d.isEmpty()) == false) goto L103;
        r15 = r35;
    L103:
        if (r15 == null) goto L105;
        OfficeLongPressMenuAction r44 = OfficeLongPressMenuAction.FILTER;
        h(r29, r44, "Visible", "scene_can_filter");
        r8.add(new b0(r44, 9, this.a.getString(2131889408), 2131244682, null, null, 2131244679, null, false, null, 944));
        goto L107
    L92:
        if (r34.a() == true) goto L95;
        r34 = null;
    L95:
        if (r34 == null) goto L97;
        OfficeLongPressMenuAction r45 = OfficeLongPressMenuAction.SORT;
        h(r29, r45, "Visible", "scene_can_sort");
        r8.add(new b0(r45, 8, this.a.getString(2131889454), 2131244683, null, null, 2131244679, null, false, null, 944));
        goto L98
    L88:
        h(r29, OfficeLongPressMenuAction.MORE, "Hidden", "no_visible_more_action");
        goto L89
    L80:
        if (r30.e == OfficeLongPressMenuItemState.HIDDEN) goto L82;
        r31 = true;
    L85:
        r32 = false;
        goto L86
    L70:
        r26 = new z.a(com.bytedance.ee.bear.more.office.f.c(), null);
        g(r29, r23, r26, "action_session_missing");
        goto L71
    L63:
        if (r29.b.z == true) goto L66;
        r21 = 2131233732;
        goto L67
    L56:
        if (r29.b.z == true) goto L59;
        r20 = this.a.getString(2131889425);
        Intrinsics.checkNotNull(r20);
        goto L60
    L52:
        h(r29, OfficeLongPressMenuAction.MULTI_SELECT, "Hidden", "can_multi_select_false");
        goto L53
    L48:
        h(r29, OfficeLongPressMenuAction.EXPORT_AS, "Hidden", "export_as_availability_hidden");
        goto L50
    L42:
        r12 = new z.a(com.bytedance.ee.bear.more.office.f.c(), null);
        g(r29, r7, r12, "action_session_missing");
        goto L43
    L44:
        h(r29, OfficeLongPressMenuAction.DOWNLOAD, "Hidden", "not_drive_file_like");
        goto L46
    L31:
        if (r5.getType() == 16) goto L33;
    L35:
        r6 = false;
        goto L37
    L33:
        if (r5.y1 != 12) goto L35;
    L15:
        r2 = 2131889412;
        goto L16
    L17:
        OfficeLongPressMenuAction r46 = OfficeLongPressMenuAction.ASK_DOUBAO;
        if (this.c == true) goto L21;
        String r47 = "ask_doubao_disabled_by_host";
    L27:
        h(r29, r46, "Hidden", r47);
        goto L28
    L21:
        if (r29.b.getType() != sbb.e.f.b) goto L24;
        r47 = "folder_not_supported";
        goto L27
    L24:
        if (r29.b.getType() != 111) goto L26;
        r47 = "wiki_folder_not_supported";
        goto L27
    L26:
        r47 = "ask_doubao_hidden";
        goto L27
    L5:
        if (r29.b.getType() == sbb.e.f.b) goto L9;
        if (r29.b.getType() == 111) goto L9;
        r0 = true;
        goto L11
    }

    public final List<b0> d(a0 r25) {
        Intrinsics.checkNotNullParameter(r25, "menuContext");
        ArrayList r8 = new ArrayList();
        r8.add(new b0(OfficeLongPressMenuAction.MORE, 101, this.a.getString(2131889435), 2131244683, null, null, 2131233730, null, false, null, 944));
        boolean r9 = true;
        if (r25.h != OfficeSpaceTab.SHARED) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L17;
        OfficeLongPressMenuAction r1 = OfficeLongPressMenuAction.RENAME;
        String r3 = this.a.getString(2131889448);
        v r2 = r25.n;
        if (r2 == null) goto L11;
        z r4 = r2.a(OfficeLongPressLarkAction.RENAME);
    L12:
        r8.add(f(this, r1, 107, r3, 2131233742, r4));
        OfficeLongPressMenuAction r5 = OfficeLongPressMenuAction.MOVE_TO;
        String r6 = this.a.getString(2131889143);
        v r7 = r25.n;
        if (r7 == null) goto L15;
        z r10 = r7.a(OfficeLongPressLarkAction.MOVE_TO);
    L16:
        r8.add(f(this, r5, 102, r6, 2131233767, r10));
    L18:
        OfficeLongPressMenuAction r11 = OfficeLongPressMenuAction.ADD_SHORTCUT;
        String r12 = this.a.getString(2131889410);
        v r13 = r25.n;
        if (r13 == null) goto L21;
        z r14 = r13.a(OfficeLongPressLarkAction.ADD_SHORTCUT);
    L22:
        r8.add(f(this, r11, 103, r12, 2131233763, r14));
        if (r25.b.getType() != sbb.e.f.b) goto L25;
    L27:
        boolean r15 = false;
    L28:
        if (r15 == false) goto L34;
        OfficeLongPressMenuAction r16 = OfficeLongPressMenuAction.SECRET_SETTING;
        String r17 = this.a.getString(2131889450);
        v r18 = r25.n;
        if (r18 == null) goto L32;
        z r19 = r18.a(OfficeLongPressLarkAction.SECRET_SETTING);
    L33:
        r8.add(f(this, r16, 104, r17, 2131233737, r19));
    L35:
        int r20 = b.a[r25.h.ordinal()];
        if (r20 != 1) goto L38;
    L47:
        boolean r21 = true;
    L48:
        if (r21 == false) goto L94;
        OfficeSpaceTab r22 = r25.h;
        OfficeSpaceTab r23 = OfficeSpaceTab.RECENT;
        if (r22 == r23) goto L52;
    L54:
        OfficeLongPressMenuAction r24 = OfficeLongPressMenuAction.DELETE_SOURCE;
    L55:
        OfficeLongPressMenuAction r110 = r24;
        Integer r26 = r25.k;
        if (r26 == null) goto L73;
        r26.intValue();
        if (r25.h == r23) goto L61;
        r9 = false;
    L61:
        if (r9 == true) goto L64;
        r26 = null;
    L64:
        if (r26 == null) goto L73;
        r26.intValue();
        if (r25.h == r23) goto L68;
    L70:
        String r27 = this.a.getString(2131889421);
    L71:
        if (r27 == null) goto L73;
    L74:
        String r111 = r27;
        if (r25.m == false) goto L78;
        OfficeLongPressMenuAction r28 = OfficeLongPressMenuAction.DELETE_SOURCE;
        z r29 = z.b.a;
        g(r25, r28, r29, "restricted_wiki_home");
    L82:
        if (r110 != OfficeLongPressMenuAction.REMOVE_RECENT) goto L84;
        int r112 = 106;
    L85:
        OfficeLongPressMenuItemState r113 = w.a(r29);
        String r30 = com.bytedance.ee.bear.more.office.f.c();
        Intrinsics.checkNotNullParameter(r29, "<this>");
        Intrinsics.checkNotNullParameter(r30, "defaultTips");
        if ((r29 instanceof z.c) == false) goto L90;
        String r31 = ((z.c) r29).a;
    L88:
        String r114 = r31;
    L93:
        r8.add(new b0(r110, r112, r111, 2131233764, r113, r114, null, -701883, false, null, 832));
    L95:
        List r32 = b(r25, r8);
        ArrayList r33 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r32, 10));
        Iterator r34 = r32.iterator();
    L97:
        if (r34.hasNext() == false) goto L99;
        r33.add(a(r25, (b0) r34.next()));
        goto L97
    L99:
        return r33;
    L90:
        if ((r29 instanceof z.a) == false) goto L92;
        r31 = ((z.a) r29).a;
        goto L88
    L92:
        r114 = r30;
        goto L93
    L84:
        r112 = 105;
        goto L85
    L78:
        if (((Boolean) r25.f.invoke()).booleanValue() == true) goto L80;
        OfficeLongPressMenuAction r35 = OfficeLongPressMenuAction.DELETE_SOURCE;
        r29 = new z.a(this.a.getString(2131887951), null);
        g(r25, r35, r29, "network_disconnected");
        goto L82
    L80:
        OfficeLongPressMenuAction r36 = OfficeLongPressMenuAction.DELETE_SOURCE;
        r29 = z.d.a;
        g(r25, r36, r29, "delete_rule_visible");
        goto L82
    L68:
        if (r110 != OfficeLongPressMenuAction.REMOVE_RECENT) goto L70;
        r27 = this.a.getString(2131889446);
    L73:
        r27 = this.a.getString(2131889421);
        goto L74
    L52:
        if (r25.l == true) goto L54;
        r24 = OfficeLongPressMenuAction.REMOVE_RECENT;
        goto L55
    L94:
        h(r25, OfficeLongPressMenuAction.DELETE_SOURCE, "Hidden", "delete_entry_hidden_by_tab_" + r25.h);
        goto L95
    L38:
        if (r20 == 2) goto L47;
        if (r20 != 3) goto L42;
    L46:
        r21 = false;
        goto L48
    L42:
        if (r20 == 4) goto L46;
        throw new NoWhenBranchMatchedException();
    L32:
        r19 = new z.a(com.bytedance.ee.bear.more.office.f.c(), null);
        g(r25, r16, r19, "action_session_missing");
        goto L33
    L34:
        h(r25, OfficeLongPressMenuAction.SECRET_SETTING, "Hidden", "secret_entry_unsupported_document_type");
        goto L35
    L25:
        if (r25.b.getType() == 111) goto L27;
        r15 = true;
        goto L28
    L21:
        r14 = new z.a(com.bytedance.ee.bear.more.office.f.c(), null);
        g(r25, r11, r14, "action_session_missing");
        goto L22
    L15:
        r10 = new z.a(com.bytedance.ee.bear.more.office.f.c(), null);
        g(r25, r5, r10, "action_session_missing");
        goto L16
    L11:
        r4 = new z.a(com.bytedance.ee.bear.more.office.f.c(), null);
        g(r25, r1, r4, "action_session_missing");
        goto L12
    L17:
        h(r25, OfficeLongPressMenuAction.RENAME, "Hidden", "shared_tab_mutating_entry_hidden");
        h(r25, OfficeLongPressMenuAction.MOVE_TO, "Hidden", "shared_tab_mutating_entry_hidden");
        goto L18
    L5:
        r0 = false;
        goto L7
    }

    public static b0 a(a0 r14, b0 r15) {
        if (r14.b.b() == true) goto L5;
    L11:
        return r15;
    L5:
        if (r15.e == OfficeLongPressMenuItemState.HIDDEN) goto L11;
        if (d.contains(r15.a) == false) goto L11;
        h(r14, r15.a, "DISABLED", "ai_artifact_folder_unsupported");
        OfficeLongPressMenuItemState r8 = OfficeLongPressMenuItemState.DISABLED;
        String r9 = t0.d();
        OfficeLongPressMenuAction r4 = r15.a;
        int r5 = r15.b;
        String r6 = r15.c;
        int r7 = r15.d;
        Integer r10 = r15.g;
        Integer r11 = r15.h;
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r6, "title");
        Intrinsics.checkNotNullParameter(r8, "state");
        return new b0(r4, r5, r6, r7, r8, r9, r10, r11, false, null);
    }

    public static List b(a0 r5, List r6) {
        Document r7 = r5.b;
        if (AppInfoUtils.f().booleanValue() == true) goto L5;
    L12:
        boolean r8 = false;
    L13:
        if (r8 == true) goto L15;
        return r6;
    L15:
        ArrayList r9 = new ArrayList();
        Iterator r10 = r6.iterator();
    L17:
        if (r10.hasNext() == false) goto L33;
        Object r0 = r10.next();
        OfficeLongPressMenuAction r3 = ((b0) r0).a;
        if (r3 != OfficeLongPressMenuAction.DOWNLOAD) goto L21;
    L30:
        boolean r4 = true;
    L31:
        if (r4 == true) goto L17;
        r9.add(r0);
        goto L17
    L21:
        if (r3 == OfficeLongPressMenuAction.EXPORT_AS) goto L30;
        if (r3 == OfficeLongPressMenuAction.MAKE_COPY) goto L30;
        if (r3 == OfficeLongPressMenuAction.RENAME) goto L30;
        if (r3 == OfficeLongPressMenuAction.ADD_SHORTCUT) goto L30;
        r4 = false;
        goto L31
    L33:
        return r9;
    L5:
        if (idb.f.a().isEnable("apaas.miaoda.migrate_to_ccm") == false) goto L12;
        int r1 = r7.getType();
        int r11 = r7.y1;
        if (r11 <= 0) goto L10;
        r1 = r11;
    L10:
        if (sbb.g.b(r1) == false) goto L12;
        r8 = true;
        goto L13
    }

    public c0(Context r2, f r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static void g(a0 r2, OfficeLongPressMenuAction r3, z r4, String r5) {
        tt5.a.h("OfficeLongPressMenuRules", "long press menu rule availability. action=" + r3 + ", result=" + d0.a(r4) + ", tab=" + r2.h + ", type=" + r2.b.getType() + ", realType=" + r2.b.y1 + ", reason=" + r5);
    }

    public static void h(a0 r2, OfficeLongPressMenuAction r3, String r4, String r5) {
        tt5.a.h("OfficeLongPressMenuRules", "long press menu rule decision. action=" + r3 + ", result=" + r4 + ", tab=" + r2.h + ", type=" + r2.b.getType() + ", realType=" + r2.b.y1 + ", reason=" + r5);
    }

    public static b0 f(c0 r15, OfficeLongPressMenuAction r16, int r17, String r18, int r19, z r20) {
        r15.getClass();
        boolean r1 = r20 instanceof z.a;
        OfficeLongPressDisabledDispatchReason r2 = null;
        if (r1 == false) goto L5;
        z.a r3 = (z.a) r20;
    L6:
        if (r3 == null) goto L8;
        r2 = r3.b;
    L8:
        OfficeLongPressDisabledDispatchReason r13 = r2;
        OfficeLongPressDisabledDispatchReason r4 = OfficeLongPressDisabledDispatchReason.PREFETCH_IN_PROGRESS_RETRY;
        if (r13 != r4) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
        OfficeLongPressMenuItemState r6 = OfficeLongPressMenuItemState.LOADING_BLOCKED;
    L18:
        OfficeLongPressMenuItemState r8 = r6;
        if (r13 != r4) goto L21;
    L24:
        boolean r7 = true;
    L25:
        if (r7 == false) goto L27;
        String r9 = com.bytedance.ee.bear.more.office.f.b();
    L33:
        if (r5 == false) goto L35;
    L43:
        boolean r12 = false;
    L44:
        tt5.a.h("OfficeLongPressMenuRules", "build long press item. action=" + r16 + ", menuId=" + r17 + ", availability=" + d0.a(r20) + ", state=" + r8 + ", disabledReason=" + r13 + ", isPrefetchUnresolved=" + r5 + ", dispatchWhenDisabled=" + r12);
        return new b0(r16, r17, r18, r19, r8, r9, null, null, r12, r13, 192);
    L35:
        if (r13 != OfficeLongPressDisabledDispatchReason.PERMISSION_PLATFORM_ACTION) goto L37;
    L40:
        boolean r10 = true;
    L41:
        if (r10 == false) goto L43;
        r12 = true;
        goto L44
    L37:
        if (r13 == OfficeLongPressDisabledDispatchReason.SECURITY_POLICY_DIALOG) goto L40;
        r10 = false;
        goto L41
    L27:
        String r11 = com.bytedance.ee.bear.more.office.f.c();
        Intrinsics.checkNotNullParameter(r20, "<this>");
        Intrinsics.checkNotNullParameter(r11, "defaultTips");
        if ((r20 instanceof z.c) == false) goto L30;
        r11 = ((z.c) r20).a;
    L32:
        r9 = r11;
        goto L33
    L30:
        if (r1 == false) goto L32;
        r11 = ((z.a) r20).a;
        goto L32
    L21:
        if (r13 == OfficeLongPressDisabledDispatchReason.PREFETCH_FAILED_RETRY) goto L24;
        r7 = false;
        goto L25
    L17:
        r6 = w.a(r20);
        goto L18
    L11:
        if (r13 == OfficeLongPressDisabledDispatchReason.PREFETCH_FAILED_RETRY) goto L14;
        r5 = false;
        goto L15
    L5:
        r3 = null;
        goto L6
    }
}
