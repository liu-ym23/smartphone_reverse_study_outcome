package com.bytedance.android.shopping.sku.inner.controller;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuYataStatusController {
    public final com.bytedance.android.shopping.sku.inner.container.b a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/sku/inner/controller/SkuYataStatusController$StatusType;", "", "SKELETON", "DOUBLE_BALL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StatusType extends Enum<StatusType> {
        public static final StatusType DOUBLE_BALL = null;
        public static final StatusType SKELETON = null;
        public static final /* synthetic */ StatusType[] a = null;

        static {
            StatusType r1 = new StatusType("SKELETON", 0);
            SKELETON = r1;
            StatusType r2 = new StatusType("DOUBLE_BALL", 1);
            DOUBLE_BALL = r2;
            a = new StatusType[]{r1, r2};
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

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SkuYataStatusController a;

        public a(SkuYataStatusController r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.a.close(0);
        }
    }

    public SkuYataStatusController(com.bytedance.android.shopping.sku.inner.container.b r3) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        this.a = r3;
        if (r3.qn().getSkuParams().getActionType() != 6) goto L10;
        View r4 = r3.i();
        if (r4 == null) goto L11;
        ImageView r5 = (ImageView) r4.findViewById(2131386866);
        if (r5 == null) goto L12;
        r5.setImageResource(2131244013);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        View r0 = this.a.i();
        if (r0 == null) goto L21;
        View r1 = r0.findViewById(2131386839);
        if (r1 == null) goto L7;
        r1.setVisibility(0);
    L7:
        View r2 = r0.findViewById(2131386864);
        if (r2 == null) goto L10;
        r2.setVisibility(8);
    L10:
        View r3 = r0.findViewById(2131386841);
        if (r3 == null) goto L13;
        r3.setVisibility(8);
    L13:
        View r5 = r0.findViewById(2131386849);
        if (r5 == null) goto L16;
        r5.setVisibility(8);
    L16:
        View r6 = r0.findViewById(2131386843);
        if (r6 == null) goto L19;
        r6.setVisibility(8);
    L19:
        Lazy r7 = SkuCommonLog.a;
        SkuCommonLog.c("SkuYataStatusController", "showNone tag:".concat(r4));
        return;
    }

    public final void c(StatusType r6) {
        Intrinsics.checkNotNullParameter(r6, "type");
        View r0 = this.a.i();
        if (r0 == null) goto L33;
        View r1 = r0.findViewById(2131386839);
        boolean r2 = true;
        if (r1 != null) goto L7;
    L11:
        View r3 = r0.findViewById(2131386864);
        if (r3 != null) goto L14;
    L18:
        View r4 = r0.findViewById(2131386841);
        if (r4 != null) goto L21;
    L25:
        View r7 = r0.findViewById(2131386849);
        if (r7 == null) goto L28;
        wg.a.h(r7, false);
    L28:
        View r8 = r0.findViewById(2131386843);
        if (r8 == null) goto L31;
        r8.setVisibility(8);
    L31:
        Lazy r9 = SkuCommonLog.a;
        SkuCommonLog.c("SkuYataStatusController", "showLoading tag:" + r0.getTag());
        StatusType r10 = StatusType.SKELETON;
        return;
    L21:
        if (r6 == StatusType.DOUBLE_BALL) goto L24;
        r2 = false;
    L24:
        wg.a.h(r4, r2);
        goto L25
    L14:
        if (r6 != StatusType.SKELETON) goto L16;
        boolean r5 = true;
    L17:
        wg.a.h(r3, r5);
        goto L18
    L16:
        r5 = false;
        goto L17
    L7:
        if (r6 == StatusType.SKELETON) goto L9;
        boolean r11 = true;
    L10:
        wg.a.h(r1, r11);
        goto L11
    L9:
        r11 = false;
        goto L10
    }

    public final void a(int r11, int r12) {
        View r0 = this.a.i();
        if (r0 == null) goto L61;
        boolean r6 = false;
        if (r12 != SkuBizErrorCode.Invalid.getCode()) goto L18;
        View r13 = r0.findViewById(2131390547);
        if (r13 == null) goto L9;
        r13.setVisibility(8);
    L9:
        View r14 = r0.findViewById(2131390548);
        if (r14 == null) goto L12;
        r14.setVisibility(8);
    L12:
        View r15 = r0.findViewById(2131386832);
        if (r15 == null) goto L15;
        r15.setVisibility(0);
    L15:
        View r16 = r0.findViewById(2131386843);
        if (r16 == null) goto L45;
        r16.setVisibility(8);
    L45:
        View r17 = r0.findViewById(2131386839);
        if (r17 == null) goto L48;
        r17.setVisibility(4);
    L48:
        View r18 = r0.findViewById(2131386864);
        if (r18 == null) goto L51;
        r18.setVisibility(8);
    L51:
        View r19 = r0.findViewById(2131386841);
        if (r19 == null) goto L54;
        r19.setVisibility(8);
    L54:
        View r110 = r0.findViewById(2131386849);
        if (r110 != null) goto L57;
    L60:
        SkuCommonLog.c("SkuYataStatusController", "showError");
        goto L61
    L57:
        if (this.a.qn().getSkuParams().getActionType() == 6) goto L59;
        r6 = true;
    L59:
        wg.a.h(r110, r6);
        goto L60
    L18:
        if (r11 != 0) goto L20;
    L33:
        View r111 = r0.findViewById(2131390547);
        if (r111 == null) goto L36;
        r111.setVisibility(0);
    L36:
        View r112 = r0.findViewById(2131390548);
        if (r112 == null) goto L39;
        r112.setVisibility(0);
    L39:
        View r113 = r0.findViewById(2131386832);
        if (r113 == null) goto L42;
        r113.setVisibility(8);
    L42:
        View r114 = r0.findViewById(2131386843);
        if (r114 == null) goto L45;
        r114.setVisibility(0);
        goto L45
    L20:
        if (com.bytedance.android.ec.core.abtest.d.v().contains(Double.valueOf(r11)) == false) goto L33;
        View r115 = r0.findViewById(2131390547);
        if (r115 == null) goto L24;
        r115.setVisibility(8);
    L24:
        View r116 = r0.findViewById(2131390548);
        if (r116 == null) goto L27;
        r116.setVisibility(8);
    L27:
        View r117 = r0.findViewById(2131386832);
        if (r117 == null) goto L30;
        r117.setVisibility(8);
    L30:
        View r118 = r0.findViewById(2131386843);
        if (r118 == null) goto L45;
        r118.setVisibility(0);
    L61:
        View r119 = this.a.i();
        if (r119 == null) goto L66;
        View r120 = r119.findViewById(2131390547);
        if (r120 == null) goto L66;
        com.bytedance.android.ec.core.widget.f.c(r120, null, null, new SkuYataStatusController$showError$2(this), 3);
    L66:
        View r121 = this.a.i();
        if (r121 == null) goto L72;
        Button r122 = (Button) r121.findViewById(2131386833);
        if (r122 == null) goto L73;
        r122.setOnClickListener(new a(this));
        return;
    L73:
        return;
    }
}
