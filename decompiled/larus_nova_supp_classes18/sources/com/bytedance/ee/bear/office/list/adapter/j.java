package com.bytedance.ee.bear.office.list.adapter;

import android.view.View;
import com.bytedance.ee.bear.office.common.screenmenu.CommonMenu;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.list.menuconfig.OfficeLongPressMenuConfigComposer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class j implements x, FunctionAdapter {
    public final /* synthetic */ OfficeListLongPressActionController a;

    public j(OfficeListLongPressActionController r1) {
        this.a = r1;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof x) == true) goto L5;
        return false;
    L5:
        if ((r3 instanceof FunctionAdapter) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
    }

    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(2, this.a, OfficeListLongPressActionController.class, "updateActionAvailability", "updateActionAvailability(Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressMenuAction;Lcom/bytedance/ee/bear/office/list/adapter/OfficeLongPressLarkActionAvailability;)V", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [android.view.ViewGroup, com.bytedance.ee.bear.office.common.screenmenu.CommonMenu] */
    @Override // com.bytedance.ee.bear.office.list.adapter.x
    public final void a(OfficeLongPressMenuAction r21, z r22) {
        Intrinsics.checkNotNullParameter(r21, "p0");
        Intrinsics.checkNotNullParameter(r22, "p1");
        final OfficeListLongPressActionController r11 = this.a;
        r11.getClass();
        Intrinsics.checkNotNullParameter(r21, "action");
        Intrinsics.checkNotNullParameter(r22, "availability");
        final OfficeListLongPressActionController.f r12 = r11.f;
        if (r12 != null) goto L5;
        tt5.a.h("OfficeLongPressMenu", "skip refresh long press menu availability because show state missing. action=" + r21 + ", availability=" + r22);
        return;
    L5:
        com.bytedance.ee.bear.office.common.screenmenu.j r3 = r11.d;
        if (r3 != null) goto L8;
    L10:
        com.bytedance.ee.bear.office.common.screenmenu.j r10 = null;
    L12:
        if (r10 != null) goto L18;
        StringBuilder r4 = new StringBuilder("skip refresh long press menu availability because screen menu invisible. action=");
        r4.append(r21);
        r4.append(", availability=");
        r4.append(r22);
        r4.append(", hasSession=");
        if (r11.e == null) goto L16;
        boolean r9 = true;
    L17:
        r4.append(r9);
        tt5.a.h("OfficeLongPressMenu", r4.toString());
        return;
    L16:
        r9 = false;
        goto L17
    L18:
        a0 r5 = r12.b;
        if (r5.n == r11.e) goto L26;
        StringBuilder r6 = new StringBuilder("skip refresh long press menu availability because session changed. action=");
        r6.append(r21);
        r6.append(", availability=");
        r6.append(r22);
        r6.append(", hasSession=");
        if (r11.e == null) goto L23;
        boolean r13 = true;
    L24:
        r6.append(r13);
        tt5.a.h("OfficeLongPressMenu", r6.toString());
        return;
    L23:
        r13 = false;
        goto L24
    L26:
        if (r12.f == false) goto L49;
        List<b0> r7 = r12.c.c(r5);
        OfficeListLongPressActionController.m("refresh_main_rules", r7);
        ArrayList r8 = new ArrayList();
        Iterator r14 = ((ArrayList) r7).iterator();
    L29:
        if (r14.hasNext() == false) goto L36;
        Object r15 = r14.next();
        if (((b0) r15).e == OfficeLongPressMenuItemState.HIDDEN) goto L33;
        boolean r16 = true;
    L34:
        if (r16 == false) goto L29;
        r8.add(r15);
        goto L29
    L33:
        r16 = false;
        goto L34
    L36:
        List<b0> r17 = r12.c.d(r12.b);
        OfficeListLongPressActionController.m("refresh_more_rules", r17);
        ArrayList r18 = new ArrayList();
        Iterator r19 = ((ArrayList) r17).iterator();
    L38:
        if (r19.hasNext() == false) goto L45;
        Object r20 = r19.next();
        if (((b0) r20).e == OfficeLongPressMenuItemState.HIDDEN) goto L42;
        boolean r23 = true;
    L43:
        if (r23 == false) goto L38;
        r18.add(r20);
        goto L38
    L42:
        r23 = false;
        goto L43
    L45:
        int r24 = OfficeLongPressMenuConfigComposer.a;
        com.bytedance.ee.bear.widgets.menuconfig.c r25 = com.bytedance.ee.bear.widgets.menuconfig.c.a;
        List<com.bytedance.ee.bear.office.list.menuconfig.a> r26 = OfficeLongPressMenuConfigComposer.a(com.bytedance.ee.bear.widgets.menuconfig.c.b, r8, r18);
        if (r26 != null) goto L48;
        r26 = CollectionsKt.emptyList();
    L48:
        List<com.bytedance.ee.bear.office.list.menuconfig.a> r27 = r26;
        boolean r1 = true;
        OfficeListLongPressActionController.c r28 = new OfficeListLongPressActionController.c(r11.c(r27, r12.b, r12.c, r12.d, r12.e, r12.g, r12.h), r27);
    L50:
        final ?? r2 = r28.a;
        OfficeListLongPressActionController.n("availability_refresh_parent_built", r12.f, "parentMenuChildCount=" + r2.getChildCount());
        if (r2.getChildCount() != 0) goto L53;
        r11.j("availability_refresh_empty_parent_menu");
        return;
    L53:
        OfficeListLongPressActionController.a r29 = r11.h;
        if (Intrinsics.areEqual(r29, OfficeListLongPressActionController.a.c.a) == false) goto L59;
        if (r12.f == true) goto L89;
        final View r30 = r11.f(r12.b, r12.c, r12.g);
    L90:
        if (r30 != null) goto L92;
        OfficeListLongPressActionController.e r31 = null;
    L94:
        if (r31 != null) goto L96;
        r11.h = null;
    L96:
        StringBuilder r32 = new StringBuilder("refresh long press menu availability. action=");
        r32.append(r21);
        r32.append(", availability=");
        r32.append(r22);
        r32.append(", restoreSubMenu=");
        if (r31 != null) goto L100;
        r1 = false;
    L100:
        r32.append(r1);
        r32.append(", activeSubMenuState=");
        r32.append(r11.h);
        tt5.a.h("OfficeLongPressMenu", r32.toString());
        if (r31 == null) goto L103;
        Function0<CommonMenu> r0 = new OfficeListLongPressActionController$updateActionAvailability$1(r2);
    L104:
        if (r31 == null) goto L106;
        Function0<View> r110 = r31.a;
    L107:
        r10.u(r0, r110, new OfficeListLongPressActionController$updateActionAvailability$2(r11, r2));
        return;
    L106:
        r110 = null;
        goto L107
    L103:
        r0 = null;
        goto L104
    L92:
        r31 = new OfficeListLongPressActionController.e(new OfficeListLongPressActionController$buildRestoreSubMenu$1(r30));
    L89:
        r30 = null;
        goto L90
    L59:
        if ((r29 instanceof OfficeListLongPressActionController.a.C0133a) == false) goto L82;
        String r33 = ((OfficeListLongPressActionController.a.C0133a) r29).a;
        List<com.bytedance.ee.bear.office.list.menuconfig.a> r34 = r28.b;
        if (r34 != null) goto L63;
        r34 = CollectionsKt.emptyList();
    L63:
        a0 r35 = r12.b;
        Function2<OfficeLongPressMenuAction, a0, OfficeSpaceActionResult> r36 = r12.g;
        Iterator r37 = ((ArrayList) OfficeListLongPressActionController.v(r34, r1)).iterator();
    L65:
        if (r37.hasNext() == false) goto L76;
        Object r38 = r37.next();
        com.bytedance.ee.bear.office.list.menuconfig.a r39 = (com.bytedance.ee.bear.office.list.menuconfig.a) r38;
        if (Intrinsics.areEqual(r39.a, r33) == true) goto L69;
    L73:
        boolean r40 = false;
    L74:
        if (r40 == false) goto L65;
    L77:
        com.bytedance.ee.bear.office.list.menuconfig.a r41 = (com.bytedance.ee.bear.office.list.menuconfig.a) r38;
        if (r41 == null) goto L89;
        r30 = r11.d(r41, r41.l, r35, r36);
        goto L90
    L69:
        if (r39.e == OfficeLongPressMenuItemState.DISABLED) goto L73;
        if ((r39.l.isEmpty() ^ r1) == false) goto L73;
        r40 = true;
        goto L74
    L76:
        r38 = null;
        goto L77
    L82:
        if (Intrinsics.areEqual(r29, OfficeListLongPressActionController.a.d.a) == true) goto L89;
        if (Intrinsics.areEqual(r29, OfficeListLongPressActionController.a.b.a) == true) goto L89;
        if (r29 == null) goto L89;
        throw new NoWhenBranchMatchedException();
    L49:
        r1 = true;
        final Ref.ObjectRef r42 = new Ref.ObjectRef();
        CommonMenu r43 = r11.e(r12.b, r12.c, r12.d, r12.e, new OfficeListLongPressActionController$buildCurrentParentMenu$1(r11, r42, r12));
        r42.element = r43;
        r28 = new OfficeListLongPressActionController.c(r43, null);
        goto L50
    L8:
        if (r3.m() == false) goto L10;
        r10 = r3;
        goto L12
    }
}
