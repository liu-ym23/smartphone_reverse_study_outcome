package com.bytedance.android.shopping.skubuy.module;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.PopupCode;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.WidgetName;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class PopupAdjustModule<STATE extends m, PROPS extends u33.a> extends s33.b<STATE, PROPS> {
    public final String b;

    public final String j() {
        return this.b;
    }

    public PopupAdjustModule(l33.b<STATE, PROPS> r2) {
        Intrinsics.checkNotNullParameter(r2, "containerContext");
        super(r2);
        this.b = "PopupAdjustModule";
    }

    public final void t(z33.a r2, Map<String, ? extends View> r3) {
        Intrinsics.checkNotNullParameter(r3, "containerMap");
        Object r4 = null;
        if (r2 == null) goto L7;
        Map r5 = r2.e();
        if (r5 == null) goto L7;
        Object r6 = r5.get("popup_code");
    L9:
        if ((r6 instanceof String) == true) goto L11;
        r6 = null;
    L11:
        String r7 = (String) r6;
        if (r7 != null) goto L14;
        return;
    L14:
        ((s33.b) this).a.a.getPopup().remove(r7);
        if (((s33.b) this).a.a.getPopup().isEmpty() == false) goto L24;
        Object r8 = ((s33.b) this).a.e.g.get(WidgetName.POPUP.getValue());
        if ((r8 instanceof k43.c) == false) goto L20;
        r4 = r8;
    L20:
        k43.c r9 = (k43.c) r4;
        if (r9 == null) goto L25;
        r9.e(new y33.a(false));
        return;
    L25:
        return;
    L24:
        return;
    L7:
        r6 = null;
        goto L9
    }

    public final void u(z33.a r10, Map<String, ? extends View> r11) {
        Intrinsics.checkNotNullParameter(r10, "renderObject");
        Intrinsics.checkNotNullParameter(r11, "containerMap");
        Map r12 = r10.e();
        Object r13 = null;
        if (r12 == null) goto L5;
        Object r14 = r12.get("popup_code");
    L7:
        if ((r14 instanceof String) == true) goto L9;
        r14 = null;
    L9:
        String r15 = (String) r14;
        if (r15 != null) goto L12;
        r15 = "";
    L12:
        Object r1 = ((s33.b) this).a.d.c().e("popup_mask_click_events");
        if ((r1 instanceof Map) == true) goto L15;
        r1 = null;
    L15:
        Map r2 = (Map) r1;
        if (r2 == null) goto L18;
        Object r16 = r2.get(r15);
    L20:
        if ((r16 instanceof Map) == true) goto L22;
        r16 = null;
    L22:
        Map r17 = (Map) r16;
        if (r17 != null) goto L25;
        return;
    L25:
        Object r3 = r17.get("trigger_type");
        if ((r3 instanceof String) == true) goto L28;
        r3 = null;
    L28:
        String r4 = (String) r3;
        Object r5 = r17.get("match_vo");
        if ((r5 instanceof Map) == true) goto L31;
        r5 = null;
    L31:
        final Map r6 = (Map) r5;
        Object r18 = r17.get("extra");
        if ((r18 instanceof Map) == false) goto L35;
        r13 = r18;
    L35:
        Map r19 = (Map) r13;
        if (r6 != null) goto L38;
        return;
    L38:
        List r110 = ((s33.b) this).a.d.c().o(new PopupAdjustModule$onPopupMaskClick$matchVONodes$1(r6));
        if (r110 == null) goto L48;
        Iterator r111 = r110.iterator();
    L42:
        if (r111.hasNext() == false) goto L52;
        z33.a r7 = (z33.a) r111.next();
        j33.f r8 = ((s33.b) this).a.d.c();
        String r9 = r7.d();
        if (r4 != null) goto L46;
        String r20 = "";
    L47:
        r8.j(null, r9, r20, r19, "popup_mask_click");
        goto L42
    L46:
        r20 = r4;
        goto L47
    L52:
        return;
    L48:
        return;
    L18:
        r16 = null;
        goto L20
    L5:
        r14 = null;
        goto L7
    }

    public final void v(z33.a r4, Map<String, ? extends View> r5) {
        Intrinsics.checkNotNullParameter(r5, "containerMap");
        RecyclerView r0 = null;
        if (r4 == null) goto L7;
        Map r6 = r4.e();
        if (r6 == null) goto L7;
        Object r7 = r6.get("popup_code");
    L9:
        if ((r7 instanceof String) == true) goto L11;
        r7 = null;
    L11:
        String r8 = (String) r7;
        if (r8 != null) goto L14;
        return;
    L14:
        Map r1 = ((s33.b) this).a.a.getPopup();
        RecyclerView r9 = r5.get("body");
        if ((r9 instanceof RecyclerView) == false) goto L18;
        r0 = r9;
    L18:
        r1.put(r8, r0);
        return;
    L7:
        r7 = null;
        goto L9
    }

    public final void w(z33.a r5, ga6.c r6) {
        Intrinsics.checkNotNullParameter(r6, "config");
        Object r0 = null;
        if (r5 == null) goto L7;
        Map r7 = r5.e();
        if (r7 == null) goto L7;
        Object r8 = r7.get("popup_code");
    L9:
        if (Intrinsics.areEqual(r8, PopupCode.PRICE_DETAIL_CARD.getCode()) == false) goto L21;
        Object r9 = ((s33.b) this).a.e.g.get(WidgetName.FOOTER.getValue());
        if ((r9 instanceof bi3.d) == true) goto L13;
        r9 = null;
    L13:
        bi3.d r10 = (bi3.d) r9;
        if (r10 == null) goto L19;
        Intrinsics.checkNotNullParameter(((s33.b) this).a.d.c(), "yataAbility");
        LinearLayout r11 = r10.b;
        View r12 = r11.getChildAt(r11.getChildCount() - 1);
        if (r12 == null) goto L18;
        int r13 = r12.getMeasuredHeight();
    L20:
        ((s33.b) this).a.d.c().k(r6, r13);
        goto L21
    L18:
        r13 = com.bytedance.android.shopping.extensions.b.b(64);
        goto L20
    L19:
        r13 = com.bytedance.android.shopping.extensions.b.b(64);
    L21:
        Object r14 = ((s33.b) this).a.e.g.get(WidgetName.POPUP.getValue());
        if ((r14 instanceof k43.c) == false) goto L25;
        r0 = r14;
    L25:
        k43.c r1 = (k43.c) r0;
        if (r1 == null) goto L29;
        r1.e(new y33.a(true));
        return;
    L29:
        return;
    L7:
        r8 = null;
        goto L9
    }

    public final void s(String r2, RecyclerView r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "popupCode");
        Intrinsics.checkNotNullParameter(r3, "body");
        if (Intrinsics.areEqual(r2, PopupCode.PAY_SWITCH_CARD_POPUP.getCode()) == false) goto L7;
        if (r4 == 0) goto L8;
        ((s33.b) this).a.d.a().b("wallet_cashier_method_page_slide", MapsKt.emptyMap());
        return;
    L8:
        return;
    }
}
