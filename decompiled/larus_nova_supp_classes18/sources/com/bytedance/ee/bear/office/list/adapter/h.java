package com.bytedance.ee.bear.office.list.adapter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.list.t3;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceActionResult;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import uc5.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ OfficeDocumentAdapter a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Document c;
    public final /* synthetic */ OfficeSpaceItem d;

    public h(OfficeDocumentAdapter r1, int r2, Document r3, OfficeSpaceItem r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v6 */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r22) {
        OfficeDocumentAdapter r2 = this.a;
        Intrinsics.checkNotNull(r22);
        int r3 = this.b;
        Document r4 = this.c;
        OfficeSpaceItem r5 = this.d;
        if (r2.s == true) goto L5;
    L9:
        i0 r6 = i0.a;
        OfficeSpaceTab r7 = r2.a;
        int r8 = OfficeListSortFilterScene.e;
        OfficeListSortFilterScene r9 = OfficeListSortFilterScene.a.c(r7, r2.d, (Fragment) r2.f.invoke());
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "tab");
        Intrinsics.checkNotNullParameter(r4, "document");
        if (r9 == null) goto L12;
        OfficeListSortFilterScene.Kind r10 = r9.a;
    L13:
        boolean r12 = false;
        if (r10 == OfficeListSortFilterScene.Kind.SUB_FOLDER) goto L22;
        if (r9 == null) goto L17;
        OfficeListSortFilterScene.Kind r11 = r9.a;
    L19:
        if (r11 == OfficeListSortFilterScene.Kind.SHARED_FOLDER) goto L22;
        ?? r13 = 0;
    L23:
        String r14 = i0.a(r7);
        String r15 = r4.d;
        int r16 = r4.getType();
        String r17 = r4.F;
        if (r9 == null) goto L30;
        if (r13 == 0) goto L27;
        OfficeListSortFilterScene r18 = r9;
    L28:
        if (r18 == null) goto L30;
        String r19 = r18.b;
    L31:
        if (r9 == null) goto L39;
        if (r13 != 0) goto L35;
        r9 = null;
    L35:
        if (r9 == null) goto L39;
        if (r9.b == null) goto L39;
        String r110 = DocumentType.FOLDER_NAME;
    L40:
        JSONObject r20 = i0.b(r14, r15, r16, r17, r19, r110, t0.m(r4));
        r20.put("click", "list_item");
        int r21 = r4.getType();
        sbb.e r111 = sbb.e.f;
        if (r21 != r111.b) goto L43;
        String r23 = "ccm_space_folder_view";
    L44:
        r20.put("target", r23);
        if (t3.a == false) goto L47;
        String r24 = "grid";
    L48:
        r20.put("view_type", r24);
        if (r4.getType() != r111.b) goto L51;
        boolean r25 = true;
    L52:
        r20.put("is_folder", String.valueOf(r25));
        FolderVersion.a r26 = FolderVersion.Companion;
        int r112 = r4.L1;
        boolean r113 = r4.P1;
        r26.getClass();
        r20.put("is_shared_folder", String.valueOf(FolderVersion.a.b(r112, r113)));
        r20.put("is_subfolder", String.valueOf(r13));
        r20.put("folder_lever", r13);
        r20.put("click_from", "ai_space_list");
        if (r13 == 0) goto L55;
        r20.put("folder_tab", i0.a(r7));
    L55:
        if (r13 == 0) goto L57;
        String r27 = "ccm_space_folder_click";
    L58:
        i0.e(r27, r20);
        int r28 = k.a;
        OfficeSpaceTab r29 = r2.a;
        Intrinsics.checkNotNullParameter(r29, "tab");
        Intrinsics.checkNotNullParameter(r5, "item");
        int r30 = k.a.a[r29.ordinal()];
        if (r30 == 1) goto L70;
        if (r30 == 2) goto L70;
        if (r30 == 3) goto L70;
        if (r30 == 4) goto L70;
        throw new NoWhenBranchMatchedException();
    L70:
        if (r5.isFolder() == false) goto L89;
        com.bytedance.ee.bear.office.export.space.h r31 = (com.bytedance.ee.bear.office.export.space.h) r2.h.invoke(r2.c);
        if (r31 == null) goto L75;
        OfficeSpaceActionResult r32 = r31.ne(r5, new OfficeSpaceEventSource(r2.a, r2.H2(), r3));
        if (r32 == null) goto L75;
    L77:
        if (Intrinsics.areEqual(r32, OfficeSpaceActionResult.Handled.INSTANCE) == true) goto L102;
        Fragment r33 = (Fragment) r2.f.invoke();
        if (r33 != null) goto L82;
    L85:
        if (r12 == true) goto L103;
        com.bytedance.ee.bear.list.list.d.a r34 = r2.v;
        if (r34 == null) goto L104;
        r34.D(r22, r3, r4, r2.p);
        return;
    L104:
        return;
    L103:
        return;
    L82:
        if (d1.c(r33, r4, r2.d) == false) goto L84;
        r12 = true;
        goto L85
    L84:
        r12 = com.bytedance.ee.bear.office.list.e.b(r33, r4, r2.d);
        goto L85
    L102:
        return;
    L75:
        r32 = OfficeSpaceActionResult.NotHandled.INSTANCE;
        goto L77
    L89:
        com.bytedance.ee.bear.office.export.space.h r35 = (com.bytedance.ee.bear.office.export.space.h) r2.h.invoke(r2.c);
        if (r35 == null) goto L93;
        OfficeSpaceActionResult r36 = r35.ne(r5, new OfficeSpaceEventSource(r2.a, r2.H2(), r3));
        if (r36 == null) goto L93;
    L95:
        if (Intrinsics.areEqual(r36, OfficeSpaceActionResult.Handled.INSTANCE) == true) goto L106;
        com.bytedance.ee.bear.list.list.d.a r37 = r2.v;
        if (r37 == null) goto L107;
        r37.D(r22, r3, r4, r2.p);
        return;
    L107:
        return;
    L106:
        return;
    L93:
        r36 = OfficeSpaceActionResult.NotHandled.INSTANCE;
        goto L95
    L57:
        r27 = "ccm_space_home_page_click";
        goto L58
    L51:
        r25 = false;
        goto L52
    L47:
        r24 = "list";
        goto L48
    L43:
        r23 = "ccm_docs_page_view";
    L39:
        r110 = null;
        goto L40
    L27:
        r18 = null;
    L30:
        r19 = null;
        goto L31
    L17:
        r11 = null;
    L22:
        r13 = 1;
        goto L23
    L12:
        r10 = null;
        goto L13
    L5:
        if (r2.F2() == false) goto L9;
        ed5.d r1 = r2.e;
        if (r1 == null) goto L100;
        r1.Dt(r4);
        return;
    }
}
