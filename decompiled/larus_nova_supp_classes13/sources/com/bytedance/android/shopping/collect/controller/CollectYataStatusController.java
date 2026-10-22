package com.bytedance.android.shopping.collect.controller;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import com.bytedance.android.ec.core.abtest.d;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.collect.container.CollectYataFragment;
import com.bytedance.android.shopping.collect.custom_view.CollectGoodsLinkedScrollView;
import com.bytedance.android.shopping.collect.repo.model.CollectParams;
import com.bytedance.android.shopping.collect.util.CollectCommonLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CollectYataStatusController {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final CollectYataFragment d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/collect/controller/CollectYataStatusController$StatusType;", "", "SKELETON", "CENTER_DOUBLE_BALL_LOADING", "BOTTOM_DOUBLE_BALL_LOADING", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StatusType extends Enum<StatusType> {
        public static final StatusType BOTTOM_DOUBLE_BALL_LOADING = null;
        public static final StatusType CENTER_DOUBLE_BALL_LOADING = null;
        public static final StatusType SKELETON = null;
        public static final /* synthetic */ StatusType[] a = null;

        static {
            StatusType r1 = new StatusType("SKELETON", 0);
            SKELETON = r1;
            StatusType r2 = new StatusType("CENTER_DOUBLE_BALL_LOADING", 1);
            CENTER_DOUBLE_BALL_LOADING = r2;
            StatusType r3 = new StatusType("BOTTOM_DOUBLE_BALL_LOADING", 2);
            BOTTOM_DOUBLE_BALL_LOADING = r3;
            a = new StatusType[]{r1, r2, r3};
        }

        public static StatusType valueOf(String r1) {
            return (StatusType) r27.a.a(StatusType.class, r1);
        }

        public static StatusType[] values() {
            return (StatusType[]) a.clone();
        }

        public StatusType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public CollectYataStatusController(CollectYataFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        this.d = r2;
        this.a = "CollectYataStatusController";
        this.b = ECAppInfoService.e.isNightMode();
        CollectParams r3 = r2.o;
        if (r3 == null) goto L7;
        boolean r0 = true;
        if (r3.isFromPersonal() != true) goto L7;
    L8:
        this.c = r0;
        return;
    L7:
        r0 = false;
        goto L8
    }

    public final void a(boolean r4) {
        if (this.c == true) goto L5;
        View r0 = this.d.getView();
        if (r0 == null) goto L26;
        View r1 = r0.findViewById(2131368756);
        if (r1 == null) goto L26;
        r1.setBackgroundResource(2131234319);
    L26:
        View r2 = this.d.getView();
        if (r2 == null) goto L35;
        View r3 = r2.findViewById(2131368756);
        if (r3 == null) goto L36;
        wg.a.h(r3, r4);
        return;
    L36:
        return;
    L35:
        return;
    L5:
        if (this.b == true) goto L11;
        View r5 = this.d.getView();
        if (r5 == null) goto L16;
        View r6 = r5.findViewById(2131368757);
        if (r6 == null) goto L16;
        r6.setBackgroundResource(2131234319);
    L16:
        View r7 = this.d.getView();
        if (r7 == null) goto L32;
        View r8 = r7.findViewById(2131368757);
        if (r8 == null) goto L33;
        wg.a.h(r8, r4);
        return;
    L33:
        return;
    L32:
        return;
    L11:
        View r9 = this.d.getView();
        if (r9 == null) goto L16;
        View r10 = r9.findViewById(2131368757);
        if (r10 == null) goto L16;
        r10.setBackgroundResource(2131234318);
        goto L16
    }

    public final void b(int r8) {
        Lazy r0 = CollectCommonLog.a;
        CollectCommonLog.c(this.a, "showError");
        View r1 = this.d.getView();
        if (r1 != null) goto L5;
    L26:
        CollectGoodsLinkedScrollView r9 = this.d.S90();
        if (r9 == null) goto L29;
        NestedScrollView r10 = r9.getLoadMoreFooterView();
    L30:
        if (r10 == null) goto L35;
        ViewGroup.LayoutParams r3 = r10.getLayoutParams();
        if (r3 == null) goto L34;
        r3.height = 0;
    L34:
        wg.a.h(r10, false);
    L35:
        View r11 = this.d.getView();
        if (r11 == null) goto L41;
        View r12 = r11.findViewById(2131390547);
        if (r12 == null) goto L42;
        f.c(r12, null, null, new CollectYataStatusController$showError$3(this), 3);
        return;
    L42:
        return;
    L41:
        return;
    L29:
        r10 = null;
        goto L30
    L5:
        if (r8 != 0) goto L7;
    L14:
        View r13 = r1.findViewById(2131390547);
        if (r13 == null) goto L17;
        r13.setVisibility(0);
    L17:
        View r14 = r1.findViewById(2131390548);
        if (r14 == null) goto L20;
        r14.setVisibility(0);
    L20:
        View r15 = r1.findViewById(2131367134);
        if (r15 == null) goto L23;
        r15.setVisibility(4);
    L23:
        a(false);
        View r16 = r1.findViewById(2131367141);
        if (r16 == null) goto L26;
        r16.setVisibility(0);
        goto L26
    L7:
        if (d.v().contains(Double.valueOf(r8)) == false) goto L14;
        View r17 = r1.findViewById(2131390547);
        if (r17 == null) goto L11;
        r17.setVisibility(8);
    L11:
        View r18 = r1.findViewById(2131390548);
        if (r18 == null) goto L20;
        r18.setVisibility(8);
        goto L20
    }

    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        Lazy r0 = CollectCommonLog.a;
        CollectCommonLog.c(this.a, "showNone tag:".concat(r4));
        View r5 = this.d.getView();
        if (r5 == null) goto L11;
        View r1 = r5.findViewById(2131367134);
        if (r1 == null) goto L7;
        r1.setVisibility(0);
    L7:
        a(false);
        View r2 = r5.findViewById(2131367141);
        if (r2 == null) goto L10;
        r2.setVisibility(8);
    L10:
        r5.findViewById(2131367138).setVisibility(8);
    L11:
        CollectGoodsLinkedScrollView r6 = this.d.S90();
        if (r6 == null) goto L14;
        NestedScrollView r7 = r6.getLoadMoreFooterView();
    L15:
        if (r7 == null) goto L21;
        ViewGroup.LayoutParams r3 = r7.getLayoutParams();
        if (r3 == null) goto L19;
        r3.height = 0;
    L19:
        wg.a.h(r7, false);
        return;
    L21:
        return;
    L14:
        r7 = null;
        goto L15
    }

    public final void d(StatusType r6) {
        Intrinsics.checkNotNullParameter(r6, "type");
        View r0 = this.d.getView();
        if (r0 == null) goto L25;
        View r2 = r0.findViewById(2131367134);
        boolean r3 = false;
        if (r2 == null) goto L12;
        if (r6 == StatusType.SKELETON) goto L9;
        boolean r4 = true;
    L10:
        wg.a.h(r2, r4);
        goto L12
    L9:
        r4 = false;
    L12:
        if (r6 != StatusType.SKELETON) goto L14;
        boolean r5 = true;
    L15:
        a(r5);
        View r7 = r0.findViewById(2131367138);
        if (r7 != null) goto L18;
    L21:
        View r1 = r0.findViewById(2131367141);
        if (r1 == null) goto L25;
        r1.setVisibility(8);
        goto L25
    L18:
        if (r6 != StatusType.CENTER_DOUBLE_BALL_LOADING) goto L20;
        r3 = true;
    L20:
        wg.a.h(r7, r3);
        goto L21
    L14:
        r5 = false;
    L25:
        if (r6 != StatusType.BOTTOM_DOUBLE_BALL_LOADING) goto L36;
        CollectGoodsLinkedScrollView r8 = this.d.S90();
        if (r8 == null) goto L29;
        NestedScrollView r9 = r8.getLoadMoreFooterView();
    L30:
        if (r9 == null) goto L37;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if (r10 == null) goto L34;
        r10.height = com.bytedance.android.shopping.extensions.b.b(70);
    L34:
        wg.a.h(r9, true);
        return;
    L37:
        return;
    L29:
        r9 = null;
        goto L30
    }
}
