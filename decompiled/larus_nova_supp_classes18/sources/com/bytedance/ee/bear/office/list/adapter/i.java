package com.bytedance.ee.bear.office.list.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.office.export.space.OfficeListDisplayMode;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceLongPressAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.larksuite.component.universe_design.toast.UDToast;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements View.OnLongClickListener {
    public final /* synthetic */ OfficeDocumentAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Document c;
    public final /* synthetic */ OfficeSpaceItem d;

    public i(OfficeDocumentAdapter r1, int r2, Document r3, OfficeSpaceItem r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(final View r34) {
        final OfficeDocumentAdapter r3 = this.a;
        Intrinsics.checkNotNull(r34);
        final int r4 = this.b;
        final Document r15 = this.c;
        OfficeSpaceItem r9 = this.d;
        int r0 = OfficeDocumentAdapter.C;
        r3.getClass();
        tt5.a.h("OfficeDocumentAdapter", "receive item long click. " + r3.C2(r34, r4, r15));
        if (r3.s == false) goto L10;
        if (r3.F2() == false) goto L10;
        tt5.a.h("OfficeDocumentAdapter", "skip long press menu because select mode toggles item. " + r3.C2(r34, r4, r15));
        ed5.d r1 = r3.e;
        if (r1 == null) goto L124;
        r1.Dt(r15);
    L124:
        return true;
    L10:
        if (r15.b2 == false) goto L12;
        tt5.a.h("OfficeDocumentAdapter", "skip long press menu because secret key invalid. " + r3.C2(r34, r4, r15));
        UDToast.a r2 = UDToast.build(r34.getContext());
        r2.b.e(2131887104);
        r2.b.d = -1;
        r2.h();
        goto L124
    L12:
        com.bytedance.ee.bear.office.export.space.h r5 = (com.bytedance.ee.bear.office.export.space.h) r3.h.invoke(r3.c);
        if (r5 == null) goto L16;
        OfficeSpaceActionResult.NotHandled r6 = r5.XS(r9, new OfficeSpaceEventSource(r3.a, r3.H2(), r4));
        if (r6 == null) goto L16;
    L18:
        if (Intrinsics.areEqual(r6, OfficeSpaceActionResult.Handled.INSTANCE) == false) goto L21;
        tt5.a.h("OfficeDocumentAdapter", "skip long press menu because host handled event. " + r3.C2(r34, r4, r15));
        goto L124
    L21:
        if (r3.b.getEnableLongPressMenu() == false) goto L120;
        tt5.a.h("OfficeDocumentAdapter", "start show long press menu. " + r3.C2(r34, r4, r15));
        OfficeSpaceEventSource r10 = new OfficeSpaceEventSource(r3.a, r3.H2(), r4);
        com.bytedance.ee.bear.office.export.space.h r11 = (com.bytedance.ee.bear.office.export.space.h) r3.h.invoke(r3.c);
        String r19 = null;
        if ((r11 instanceof com.bytedance.ee.bear.office.export.space.e) == false) goto L25;
        com.bytedance.ee.bear.office.export.space.e r7 = (com.bytedance.ee.bear.office.export.space.e) r11;
    L27:
        if ((r11 instanceof com.bytedance.ee.bear.office.export.space.j) == false) goto L29;
        com.bytedance.ee.bear.office.export.space.j r8 = (com.bytedance.ee.bear.office.export.space.j) r11;
    L30:
        OfficeListLongPressActionController r12 = r3.A;
        if (r12 != null) goto L33;
        r12 = new OfficeListLongPressActionController(r34.getContext(), r3.f, r3.k);
        r3.A = r12;
    L33:
        OfficeListLongPressActionController r13 = r12;
        OfficeLongPressActionContextFactory r14 = r3.z;
        Context r16 = r34.getContext();
        OfficeSpaceTab r17 = r3.a;
        if (r7 == null) goto L37;
        boolean r18 = r7.Jk(r9);
    L36:
        boolean r110 = r18;
        OfficeLongPressActionContextFactory.b r20 = r14.b(r16, r17, r15, r9, r10, r11, r110, OfficeDocumentAdapter.I2(), new OfficeDocumentAdapter$showLongPressMenu$contextResult$3(r3), r3.F2(), null, new j(r13));
        o r21 = new o(r3.f, r3.g);
        if (r3.H2() != OfficeListDisplayMode.GRID) goto L55;
        View r22 = r34.findViewById(2131381346);
        if (r22 == null) goto L57;
    L58:
        View r23 = r22;
    L59:
        StringBuilder r24 = new StringBuilder("built long press context. ");
        r24.append(r3.C2(r34, r4, r15));
        r24.append(", anchor=");
        if (r23.getId() != (-1)) goto L133;
        String r25 = "no_id";
    L70:
        r24.append(r25);
        r24.append(", anchorAttached=");
        r24.append(r23.isAttachedToWindow());
        r24.append(", anchorSize=");
        r24.append(r23.getWidth());
        r24.append('x');
        r24.append(r23.getHeight());
        r24.append(", configuredItemsSize=");
        List<com.bytedance.ee.bear.office.list.menuconfig.a> r26 = r20.e;
        if (r26 == null) goto L73;
        Integer r27 = Integer.valueOf(r26.size());
    L74:
        r24.append(r27);
        tt5.a.h("OfficeDocumentAdapter", r24.toString());
        i0 r28 = i0.a;
        a0 r29 = r20.a;
        r28.getClass();
        Intrinsics.checkNotNullParameter(r29, "menuContext");
        Document r30 = r29.b;
        lc5.f.a r111 = lc5.f.a;
        String r210 = i0.a(r29.h);
        String r112 = r30.d;
        int r211 = r30.getType();
        String r113 = r30.F;
        OfficeListSortFilterScene r114 = r29.j;
        if (r114 != null) goto L77;
    L82:
        String r212 = null;
    L83:
        OfficeListSortFilterScene r115 = r29.j;
        if (r115 != null) goto L86;
    L93:
        FolderVersion.a r116 = FolderVersion.Companion;
        int r117 = r30.L1;
        boolean r118 = r30.P1;
        r116.getClass();
        lc5.t r31 = new lc5.t(r210, r112, r211, r113, r212, r19, FolderVersion.a.b(r117, r118), t0.m(r30), i0.a(r29.h));
        Intrinsics.checkNotNullParameter(r31, "clickParam");
        JSONObject r32 = new JSONObject();     // Catch: Exception -> L114
        o r119 = r21;
        String r120 = "menuContext";
        View r121 = r23;
        lc5.f.a.b(r111, new lc5.g(r32, r31.a, r31.b, r31.c, r31.getType(), r31.e, r31.f, r31.g, r31.j));     // Catch: Exception -> L108
        r32.put("is_shared_folder", String.valueOf(r31.h));     // Catch: Exception -> L108
        r32.put("is_follow", String.valueOf(false));     // Catch: Exception -> L108
        if (TextUtils.isEmpty(r31.k) == false) goto L103;
        String r33 = "null";
    L104:
        r32.put("original_location", r33);     // Catch: Exception -> L108
        com.bytedance.ee.bear.contract.d r35 = lc5.f.a.d();     // Catch: Exception -> L108
        if (r35 == null) goto L118;
        r35.i("ccm_space_right_click_menu_view", r32);     // Catch: Exception -> L108
    L118:
        a0 r36 = r20.a;
        c0 r37 = r20.b;
        OfficeListSortFilterScene r38 = r36.j;
        List<com.bytedance.ee.bear.office.list.menuconfig.a> r39 = r20.e;
        Function2<OfficeLongPressMenuAction, a0, OfficeSpaceActionResult> r40 = new OfficeDocumentAdapter$showLongPressMenu$1(r3, r34, r4);
        Function0<Unit> r41 = new OfficeDocumentAdapter$showLongPressMenu$2(r3, r15);
        int r42 = OfficeListLongPressActionController.i;
        OfficeListLongPressActionController$show$2 r43 = OfficeListLongPressActionController$show$2.INSTANCE;
        View r44 = r121;
        Intrinsics.checkNotNullParameter(r44, "anchor");
        Intrinsics.checkNotNullParameter(r36, r120);
        Intrinsics.checkNotNullParameter(r37, "menuRules");
        Intrinsics.checkNotNullParameter(r40, "onMenuActionClick");
        Intrinsics.checkNotNullParameter(r41, "onMultiSelect");
        Intrinsics.checkNotNullParameter(r43, "onDismissed");
        r13.z(r44, r36, r37, r38, r119, r39, r40, r41, r43, true);
        goto L124
    L103:
        r33 = r31.k;     // Catch: Exception -> L108
    L108:
        e = e;
    L117:
        tt5.a.d("ListAnalysis", e.getMessage());
    L110:
        e = e;
        r121 = r23;
    L112:
        e = e;
    L116:
        r121 = r23;
        r120 = "menuContext";
    L114:
        e = e;
        r119 = r21;
        goto L116
    L86:
        if (i0.d(r115) == true) goto L89;
        r115 = null;
    L89:
        if (r115 == null) goto L93;
        if (r115.b == null) goto L93;
        r19 = DocumentType.FOLDER_NAME;
        goto L93
    L77:
        if (i0.d(r114) == true) goto L80;
        r114 = null;
    L80:
        if (r114 == null) goto L82;
        r212 = r114.b;
        goto L83
    L73:
        r27 = null;
        goto L74
    L133:
        Result.Companion r45 = Result.Companion;     // Catch: Throwable -> L64
        Object r46 = Result.constructor-impl(r23.getResources().getResourceEntryName(r23.getId()));     // Catch: Throwable -> L64
    L66:
        String r47 = String.valueOf(r23.getId());
        if (Result.isFailure-impl(r46) == false) goto L69;
        r46 = r47;
    L69:
        r25 = (String) r46;
    L64:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r46 = Result.constructor-impl(ResultKt.createFailure(th));
    L57:
        r23 = r34;
        goto L59
    L55:
        r22 = r34.findViewById(2131381359);
        if (r22 != null) goto L58;
    L37:
        if (r8 != null) goto L39;
    L49:
        r18 = r11 instanceof com.bytedance.ee.bear.office.export.space.k;
        goto L36
    L39:
        switch(OfficeDocumentAdapter.b.a[OfficeLongPressMenuAction.ASK_DOUBAO.ordinal()]) {
            case 1: goto L43;
            case 2: goto L43;
            case 3: goto L43;
            case 4: goto L43;
            case 5: goto L43;
            case 6: goto L42;
            case 7: goto L42;
            case 8: goto L42;
            case 9: goto L42;
            case 10: goto L42;
            case 11: goto L42;
            case 12: goto L42;
            case 13: goto L42;
            case 14: goto L42;
            case 15: goto L42;
            case 16: goto L42;
            case 17: goto L42;
            case 18: goto L42;
            default: goto L41;
        };
    L42:
        boolean r49 = false;
    L44:
        if (r49 == true) goto L47;
        r8 = null;
    L47:
        if (r8 == null) goto L49;
        r18 = r8.Sp(OfficeSpaceLongPressAction.ASK_DOUBAO, r9, r10);
        goto L36
    L43:
        r49 = true;
        goto L44
    L41:
        throw new NoWhenBranchMatchedException();
    L29:
        r8 = null;
        goto L30
    L25:
        r7 = null;
        goto L27
    L120:
        if (r3.F2() == false) goto L124;
        tt5.a.h("OfficeDocumentAdapter", "enter selection because long press menu disabled. " + r3.C2(r34, r4, r15));
        ed5.d r50 = r3.e;
        if (r50 == null) goto L124;
        r50.sT(r15);
    L16:
        r6 = OfficeSpaceActionResult.NotHandled.INSTANCE;
        goto L18
    }
}
