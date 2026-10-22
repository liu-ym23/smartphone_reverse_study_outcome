package com.bytedance.ee.bear.office.list.adapter;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.more.copylink.CopyLinkFailReason;
import com.bytedance.ee.bear.more.office.OfficeLongPressLarkAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceLongPressAction;
import com.larksuite.component.universe_design.toast.UDToast;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u {
    public final Function0<com.bytedance.ee.bear.office.export.space.h> a;
    public final y b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OfficeLongPressMenuAction.values().length];
            r0[OfficeLongPressMenuAction.ASK_DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L63:
            r0[OfficeLongPressMenuAction.MULTI_SELECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L75:
            r0[OfficeLongPressMenuAction.SORT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L47:
            r0[OfficeLongPressMenuAction.FILTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L51:
            r0[OfficeLongPressMenuAction.TOGGLE_DISPLAY_MODE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L59:
            r0[OfficeLongPressMenuAction.MORE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L69:
            r0[OfficeLongPressMenuAction.SHARE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L29
        L55:
            r0[OfficeLongPressMenuAction.STAR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L30
        L65:
            r0[OfficeLongPressMenuAction.COPY_LINK.ordinal()] = 9;     // Catch: NoSuchFieldError -> L31
        L67:
            r0[OfficeLongPressMenuAction.DOWNLOAD.ordinal()] = 10;     // Catch: NoSuchFieldError -> L32
        L43:
            r0[OfficeLongPressMenuAction.EXPORT_AS.ordinal()] = 11;     // Catch: NoSuchFieldError -> L33
        L61:
            r0[OfficeLongPressMenuAction.RENAME.ordinal()] = 12;     // Catch: NoSuchFieldError -> L34
        L73:
            r0[OfficeLongPressMenuAction.MAKE_COPY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L35
        L41:
            r0[OfficeLongPressMenuAction.MOVE_TO.ordinal()] = 14;     // Catch: NoSuchFieldError -> L36
        L53:
            r0[OfficeLongPressMenuAction.ADD_SHORTCUT.ordinal()] = 15;     // Catch: NoSuchFieldError -> L37
        L71:
            r0[OfficeLongPressMenuAction.SECRET_SETTING.ordinal()] = 16;     // Catch: NoSuchFieldError -> L38
        L45:
            r0[OfficeLongPressMenuAction.DELETE_SOURCE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L39
        L49:
            r0[OfficeLongPressMenuAction.REMOVE_RECENT.ordinal()] = 18;     // Catch: NoSuchFieldError -> L40
        L21:
            a = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(Function0<? extends com.bytedance.ee.bear.office.export.space.h> r2, y r3) {
        Intrinsics.checkNotNullParameter(r2, "listenerProvider");
        Intrinsics.checkNotNullParameter(r3, "fallbackDispatcher");
        this.a = r2;
        this.b = r3;
    }

    public final y.b a(OfficeLongPressMenuAction r31, View r32, int r33, a0 r34) {
        Intrinsics.checkNotNullParameter(r31, "action");
        Intrinsics.checkNotNullParameter(r32, "anchor");
        Intrinsics.checkNotNullParameter(r34, "menuContext");
        int[] r8 = a.a;
        switch(r8[r31.ordinal()]) {
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            case 9: goto L6;
            case 10: goto L6;
            case 11: goto L6;
            case 12: goto L6;
            case 13: goto L6;
            case 14: goto L6;
            case 15: goto L6;
            case 16: goto L6;
            case 17: goto L6;
            case 18: goto L6;
            default: goto L5;
        };
    L6:
        boolean r9 = false;
    L9:
        if (r9 == true) goto L11;
        OfficeSpaceActionResult r10 = OfficeSpaceActionResult.NotHandled.INSTANCE;
    L42:
        OfficeSpaceActionResult.Handled r11 = OfficeSpaceActionResult.Handled.INSTANCE;
        if (Intrinsics.areEqual(r10, r11) == false) goto L47;
        return new y.b(r11, null);
    L47:
        if (r31 == OfficeLongPressMenuAction.ASK_DOUBAO) goto L49;
        y r12 = this.b;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r31, "action");
        Intrinsics.checkNotNullParameter(r32, "anchor");
        Intrinsics.checkNotNullParameter(r34, "menuContext");
        Document r6 = r34.b;
        if (r6.b() == true) goto L53;
    L55:
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch long press action start. action=" + r31 + ", position=" + r33 + ", " + y.a(r34));
        int[] r7 = y.c.a;
        switch(r7[r31.ordinal()]) {
            case 1: goto L182;
            case 2: goto L172;
            case 3: goto L133;
            case 4: goto L66;
            case 5: goto L66;
            case 6: goto L66;
            case 7: goto L66;
            case 8: goto L66;
            case 9: goto L66;
            case 10: goto L66;
            case 11: goto L58;
            case 12: goto L58;
            default: goto L57;
        };
    L57:
        UDToast.a r0 = UDToast.build(r32.getContext());
        r0.g(com.bytedance.ee.bear.more.office.f.c());
        r0.b.d = -1;
        r0.h();
        y.b r1 = new y.b(OfficeSpaceActionResult.NotHandled.INSTANCE, null);
    L190:
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch long press action finish. action=" + r31 + ", result=" + r1.a + ", isAble=" + r1.b + ", " + y.a(r34));
        return r1;
    L58:
        com.bytedance.ee.bear.list.list.d.b r5 = (com.bytedance.ee.bear.list.list.d.b) r12.b.invoke();
        if (r5 != null) goto L61;
        r1 = y.d(r32, "delete_listener_missing");
        goto L190
    L61:
        r5.x0(r32, r33, r6, ((Boolean) r12.d.invoke()).booleanValue());
        StringBuilder r3 = new StringBuilder("dispatch delete by slide menu listener. position=");
        r3.append(r33);
        r3.append(", token=");
        String r2 = r6.d;
        if (r2 != null) goto L64;
        r2 = "";
    L64:
        r3.append(du5.b.k(r2));
        r3.append(", type=");
        r3.append(r6.getType());
        r3.append(", realType=");
        r3.append(r6.y1);
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", r3.toString());
        r1 = new y.b(r11, 1);
        goto L190
    L133:
        int r4 = e0.a;
        g0 r13 = e0.a(r34.d);
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch copy link guard result. availability=" + y.b(r13) + ", " + y.a(r34));
        if (Intrinsics.areEqual(r13, g0.c.a) == true) goto L136;
        r1 = y.c(r32, r13, "copy_link_guard_blocked");
        goto L190
    L136:
        int r14 = nj5.a.a;
        nj5.b r15 = new nj5.b(r34.c, r34.e);
        Intrinsics.checkNotNullParameter(r15, "request");
        int r16 = nj5.d.a;     // Catch: Throwable -> L161
        String r17 = nj5.d.a(r15.a);     // Catch: Throwable -> L161
        if (r17 == null) goto L145;
        nj5.e r18 = r15.c;     // Catch: Throwable -> L161
        if (r18 == null) goto L146;
        String r19 = r18.transform(r17);     // Catch: Throwable -> L161
        if (r19 == null) goto L146;
        r17 = r19;
    L146:
        if (r17 != null) goto L148;
    L151:
        boolean r110 = true;
    L152:
        if (r110 == false) goto L194;
        nj5.c r20 = new nj5.c.a(CopyLinkFailReason.EMPTY_URL, null);
    L165:
        if ((r20 instanceof nj5.c.b) == false) goto L168;
        UDToast.a r21 = UDToast.build(r32.getContext());
        r21.b.e(2131887728);
        r21.b.d = -1;
        r21.h();
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch copy link success. " + y.a(r34));
        r1 = new y.b(OfficeSpaceActionResult.Handled.INSTANCE, 1);
        goto L190
    L168:
        if ((r20 instanceof nj5.c.a) == false) goto L171;
        UDToast.a r22 = UDToast.build(r32.getContext());
        r22.b.e(2131887724);
        r22.b.d = -1;
        r22.h();
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch copy link failed. " + y.a(r34));
        r1 = new y.b(OfficeSpaceActionResult.NotHandled.INSTANCE, 0);
        goto L190
    L171:
        throw new NoWhenBranchMatchedException();
    L194:
        if (((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(r17, false, r15.b) == false) goto L158;
        r20 = new nj5.c.b(r17);
        goto L165
    L158:
        r20 = new nj5.c.a(CopyLinkFailReason.CLIPBOARD_FAILED, null);
    L159:
        th = move-exception;
        tt5.a.e("CopyLinkExecutor", "copy link to clipboard failed", th, false);
        nj5.c r23 = new nj5.c.a(CopyLinkFailReason.CLIPBOARD_FAILED, th);
    L163:
        r20 = r23;
        goto L165
    L148:
        if (StringsKt.isBlank(r17) == true) goto L151;
        r110 = false;
        goto L152
    L145:
        r17 = null;
    L161:
        th = move-exception;
        tt5.a.e("CopyLinkExecutor", "resolve copy link failed", th, false);
        r23 = new nj5.c.a(CopyLinkFailReason.INVALID_URL, th);
        goto L163
    L172:
        int r24 = e0.a;
        g0 r25 = e0.f(r32.getContext(), r34.c, r34.f);
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch star guard result. availability=" + y.b(r25) + ", " + y.a(r34));
        if (Intrinsics.areEqual(r25, g0.c.a) == true) goto L175;
        r1 = y.c(r32, r25, "star_guard_blocked");
        goto L190
    L175:
        Fragment r26 = (Fragment) r12.a.invoke();
        if (r26 == null) goto L181;
        FragmentActivity r27 = r26.getActivity();
        if (r27 == null) goto L181;
        t0.z(r27, r6, (String) r12.c.invoke(), t0.o(((Boolean) r12.d.invoke()).booleanValue()));
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch star by DocumentUtils. " + y.a(r34));
        r1 = new y.b(r11, 1);
    L181:
        r1 = y.d(r32, "star_activity_missing");
        goto L190
    L182:
        int r28 = e0.a;
        g0 r29 = e0.d(r32.getContext(), r6, r34.c, r34.f);
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch share guard result. availability=" + y.b(r29) + ", " + y.a(r34));
        if (Intrinsics.areEqual(r29, g0.c.a) == true) goto L185;
        r1 = y.c(r32, r29, "share_guard_blocked");
        goto L190
    L185:
        com.bytedance.ee.bear.list.list.d.b r30 = (com.bytedance.ee.bear.list.list.d.b) r12.b.invoke();
        if (r30 != null) goto L188;
        r1 = y.d(r32, "share_listener_missing");
        goto L190
    L188:
        r30.B0(r32, r33, r6, ((Boolean) r12.d.invoke()).booleanValue());
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch share by slide menu listener. position=" + r33 + ", " + y.a(r34));
        r1 = new y.b(r11, 1);
        goto L190
    L66:
        switch(r7[r31.ordinal()]) {
            case 4: goto L74;
            case 5: goto L73;
            case 6: goto L72;
            case 7: goto L71;
            case 8: goto L70;
            case 9: goto L69;
            case 10: goto L68;
            default: goto L67;
        };
    L67:
        OfficeLongPressLarkAction r35 = null;
    L75:
        if (r35 != null) goto L78;
        r1 = y.d(r32, "lark_action_missing");
        goto L190
    L78:
        if (r35 == OfficeLongPressLarkAction.MOVE_TO) goto L80;
    L82:
        v r36 = r34.n;
        if (r36 == null) goto L132;
        Intrinsics.checkNotNullParameter(r35, "action");
        String r37 = (String) MapsKt.getValue(r36.c, r35);
        if (r37 == null) goto L132;
        com.bytedance.ee.bear.more.office.e r38 = (com.bytedance.ee.bear.more.office.e) r12.e.invoke();
        if (r38 != null) goto L90;
        r1 = y.d(r32, "lark_action_service_missing");
        goto L190
    L90:
        Fragment r111 = (Fragment) r12.a.invoke();
        if (r111 == null) goto L96;
        Fragment r112 = r111.getParentFragment();
        if (r112 == null) goto L96;
        Fragment r210 = r112;
    L97:
        v r113 = r34.n;
        if (r113 == null) goto L100;
        Intrinsics.checkNotNullParameter(r35, "action");
        String r211 = r113.b.get(r35);
    L101:
        if (r111 == null) goto L103;
        FragmentActivity r212 = r111.getActivity();
    L104:
        com.bytedance.ee.bear.more.office.c r114 = new com.bytedance.ee.bear.more.office.c(r37, r35, r211, r212, r210, r34.b, r34.c, (String) r12.c.invoke(), r34.g.toString(), r34.m);
        StringBuilder r39 = new StringBuilder("dispatch action execute. menuAction=");
        r39.append(r31);
        r39.append(", larkAction=");
        r39.append(r35);
        r39.append(", actionId=");
        r39.append(du5.b.k(r37));
        r39.append(", hasActivity=");
        if (r114.getActivity() == null) goto L107;
        boolean r40 = true;
    L108:
        r39.append(r40);
        r39.append(", hasFragment=");
        if (r114.e == null) goto L111;
        boolean r115 = true;
    L112:
        r39.append(r115);
        r39.append(", ");
        r39.append(y.a(r34));
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", r39.toString());
        com.bytedance.ee.bear.more.office.d r41 = r38.b(r114);
        if (Intrinsics.areEqual(r41, com.bytedance.ee.bear.more.office.d.C0117d.a) == false) goto L116;
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch action result. menuAction=" + r31 + ", larkAction=" + r35 + ", result=Handled, " + y.a(r34));
        r1 = new y.b(r11, 1);
        goto L190
    L116:
        if (Intrinsics.areEqual(r41, com.bytedance.ee.bear.more.office.d.a.a) == false) goto L119;
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch action result. menuAction=" + r31 + ", larkAction=" + r35 + ", result=Consumed, " + y.a(r34));
        r1 = new y.b(r11, 0);
        goto L190
    L119:
        if (Intrinsics.areEqual(r41, com.bytedance.ee.bear.more.office.d.f.a) == false) goto L122;
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch action result. menuAction=" + r31 + ", larkAction=" + r35 + ", result=Preparing, " + y.a(r34));
        r1 = new y.b(r11, null);
        goto L190
    L122:
        if (Intrinsics.areEqual(r41, com.bytedance.ee.bear.more.office.d.e.a) == false) goto L125;
        UDToast.a r42 = UDToast.build(r32.getContext());
        r42.g(com.bytedance.ee.bear.more.office.f.c());
        r42.b.d = -1;
        r42.h();
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch action result. menuAction=" + r31 + ", larkAction=" + r35 + ", result=NotHandled, " + y.a(r34));
        r1 = new y.b(OfficeSpaceActionResult.NotHandled.INSTANCE, 0);
        goto L190
    L125:
        if ((r41 instanceof com.bytedance.ee.bear.more.office.d.b) == false) goto L128;
        UDToast.a r43 = UDToast.build(r32.getContext());
        r43.g(((com.bytedance.ee.bear.more.office.d.b) r41).a);
        r43.b.d = -1;
        r43.h();
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch action result. menuAction=" + r31 + ", larkAction=" + r35 + ", result=Disabled, " + y.a(r34));
        r1 = new y.b(OfficeSpaceActionResult.NotHandled.INSTANCE, 0);
        goto L190
    L128:
        if ((r41 instanceof com.bytedance.ee.bear.more.office.d.c) == false) goto L131;
        UDToast.a r44 = UDToast.build(r32.getContext());
        r44.g(((com.bytedance.ee.bear.more.office.d.c) r41).a);
        r44.b.d = -1;
        r44.h();
        tt5.a.h("OfficeLongPressFeishuActionDispatcher", "dispatch action result. menuAction=" + r31 + ", larkAction=" + r35 + ", result=Failed, " + y.a(r34));
        r1 = new y.b(OfficeSpaceActionResult.NotHandled.INSTANCE, 0);
        goto L190
    L131:
        throw new NoWhenBranchMatchedException();
    L111:
        r115 = false;
        goto L112
    L107:
        r40 = false;
        goto L108
    L103:
        r212 = null;
        goto L104
    L100:
        r211 = null;
    L96:
        r210 = r111;
    L132:
        r1 = y.d(r32, "action_session_missing");
        goto L190
    L80:
        if (r34.m == false) goto L82;
        r1 = y.d(r32, "restricted_wiki_home");
        goto L190
    L68:
        r35 = OfficeLongPressLarkAction.MAKE_COPY;
        goto L75
    L69:
        r35 = OfficeLongPressLarkAction.RENAME;
        goto L75
    L70:
        r35 = OfficeLongPressLarkAction.EXPORT_AS;
        goto L75
    L71:
        r35 = OfficeLongPressLarkAction.DOWNLOAD;
        goto L75
    L72:
        r35 = OfficeLongPressLarkAction.SECRET_SETTING;
        goto L75
    L73:
        r35 = OfficeLongPressLarkAction.ADD_SHORTCUT;
        goto L75
    L74:
        r35 = OfficeLongPressLarkAction.MOVE_TO;
        goto L75
    L53:
        if (y.f.contains(r31) == false) goto L55;
        t0.b(r32.getContext(), r6, r31.name().toLowerCase(Locale.ROOT));
        return new y.b(OfficeSpaceActionResult.NotHandled.INSTANCE, 0);
    L49:
        return new y.b(OfficeSpaceActionResult.NotHandled.INSTANCE, null);
    L11:
        switch(r8[r31.ordinal()]) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L18;
            case 14: goto L17;
            case 15: goto L16;
            case 16: goto L15;
            case 17: goto L14;
            case 18: goto L14;
            default: goto L13;
        };
    L14:
        OfficeSpaceLongPressAction r45 = OfficeSpaceLongPressAction.DELETE;
    L31:
        if (r45 == null) goto L40;
        Object r46 = this.a.invoke();
        if ((r46 instanceof com.bytedance.ee.bear.office.export.space.k) == false) goto L35;
        com.bytedance.ee.bear.office.export.space.k r47 = (com.bytedance.ee.bear.office.export.space.k) r46;
    L36:
        if (r47 == null) goto L38;
        r10 = r47.xR(r45, r34.a, r34.g);
    L39:
        if (r10 != null) goto L42;
    L38:
        r10 = null;
        goto L39
    L35:
        r47 = null;
    L40:
        r10 = OfficeSpaceActionResult.NotHandled.INSTANCE;
        goto L42
    L15:
        r45 = OfficeSpaceLongPressAction.SECURITY_SETTING;
        goto L31
    L16:
        r45 = OfficeSpaceLongPressAction.ADD_SHORTCUT;
        goto L31
    L17:
        r45 = OfficeSpaceLongPressAction.MOVE_TO;
        goto L31
    L18:
        r45 = OfficeSpaceLongPressAction.MAKE_COPY;
        goto L31
    L19:
        r45 = OfficeSpaceLongPressAction.RENAME;
        goto L31
    L20:
        r45 = OfficeSpaceLongPressAction.EXPORT_AS;
        goto L31
    L21:
        r45 = OfficeSpaceLongPressAction.DOWNLOAD;
        goto L31
    L22:
        r45 = OfficeSpaceLongPressAction.COPY_LINK;
        goto L31
    L23:
        r45 = OfficeSpaceLongPressAction.FAVORITE;
        goto L31
    L24:
        r45 = OfficeSpaceLongPressAction.SHARE;
        goto L31
    L25:
        r45 = OfficeSpaceLongPressAction.MORE;
        goto L31
    L26:
        r45 = OfficeSpaceLongPressAction.TOGGLE_DISPLAY_MODE;
        goto L31
    L27:
        r45 = OfficeSpaceLongPressAction.FILTER;
        goto L31
    L28:
        r45 = OfficeSpaceLongPressAction.SORT;
        goto L31
    L29:
        r45 = OfficeSpaceLongPressAction.MULTI_SELECT;
        goto L31
    L30:
        r45 = OfficeSpaceLongPressAction.ASK_DOUBAO;
        goto L31
    L13:
        throw new NoWhenBranchMatchedException();
    L7:
        r9 = true;
        goto L9
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
