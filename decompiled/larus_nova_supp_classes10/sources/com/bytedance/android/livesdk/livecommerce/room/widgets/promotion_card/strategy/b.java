package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import com.bytedance.android.livesdk.livecommerce.model.ECV2DelayParam;
import com.bytedance.android.livesdk.livecommerce.model.ECV2OpenPriceTriggerInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopMsgProductInfo;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;
import si2.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends sg2.a {
    public static final /* synthetic */ int g = 0;
    public int a;
    public int b;
    public long c;
    public ECV2DelayParam d;
    public ECV2PopMsgProductInfo e;
    public ECV2OpenPriceTriggerInfo f;

    public static final class a {
        public static b a(a0 r3) {
            Intrinsics.checkNotNullParameter(r3, "message");
            b r0 = new b();
            r0.a = r3.msgType;
            r0.b = r3.bubbleType;
            r0.c = r3.promotionId;
            r0.d = r3.delayParam;
            r0.e = r3.productInfo;
            r0.f = r3.openPriceTriggerInfo;
            r0.setCommon(r3.getCommon());
            return r0;
        }
    }

    static {
    }

    @Override // sg2.a
    public final String toJsonString() {
        return new Gson().toJson(this);
    L5:
        return toString();
    }

    public b() {
    }
}
