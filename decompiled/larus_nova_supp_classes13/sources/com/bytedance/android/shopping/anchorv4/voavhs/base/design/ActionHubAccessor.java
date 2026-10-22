package com.bytedance.android.shopping.anchorv4.voavhs.base.design;

import android.view.View;
import com.bytedance.android.ec.core.widget.f;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface ActionHubAccessor {

    public static final class DefaultImpls {
        public static void b(ActionHubAccessor r2) {
            a r0 = r2.actionHub();
            if (r0 == null) goto L6;
            r0.l0(r2.associatedAction(), r2.descriptionVO());
            return;
        }

        public static String c(Action r1) {
            Intrinsics.checkNotNullParameter(r1, "action");
            String r2 = r1.getId();
            if (Intrinsics.areEqual(r2, "action_enter_shop") == false) goto L5;
            return "bind_key_promotion_detail_bottom";
        L5:
            if (Intrinsics.areEqual(r2, "action_im") == false) goto L7;
            return "bind_key_promotion_detail_bottom";
        L7:
            if (Intrinsics.areEqual(r2, "action_enter_cart") == false) goto L9;
            return "bind_key_promotion_detail_bottom";
        L9:
            if (Intrinsics.areEqual(r2, "action_sku") == false) goto L11;
            return "bind_key_promotion_detail_bottom";
        L11:
            if (Intrinsics.areEqual(r2, "action_buy") == true) goto L20;
            return null;
        L20:
            return "bind_key_promotion_detail_bottom";
        }

        public static void a(final ActionHubAccessor r2, final View r3, final Action r4) {
            Intrinsics.checkNotNullParameter(r3, "theView");
            if (r4 != null) goto L5;
            return;
        L5:
            String r0 = r4.getRefId();
            if (r0 == null) goto L8;
            r3.setTag(r0);
        L8:
            f.c(r3, null, r2.getOnLimitClickBindKey(r4), new ActionHubAccessor$configPossibleAction$2(r2, r4, r3, r4), 1);
        }
    }

    a actionHub();

    Action associatedAction();

    Object descriptionVO();

    void dispatchPossibleShow();

    String getOnLimitClickBindKey(Action r1);

    void setActionHub(a r1);
}
