package com.bytedance.android.livesdk.livecommerce.promotion.card;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ View a(b r1) {
            return r1.F0(PromotionCardModuleName.Parent);
        }

        public static /* synthetic */ void b(b r1, com.bytedance.android.ec.common.api.jump.model.g r2) {
            r1.A1(r2, UpdateType.UPDATE_ALL);
        }
    }

    void A1(com.bytedance.android.ec.common.api.jump.model.g r1, UpdateType r2);

    View F0(PromotionCardModuleName r1);

    com.bytedance.android.ec.common.api.jump.model.g Y0();

    Map<PromotionCardModuleName, IPromotionUIConfig.d> getUIConfig();

    void release();

    void w2(Map<PromotionCardModuleName, IPromotionUIConfig.d> r1);
}
