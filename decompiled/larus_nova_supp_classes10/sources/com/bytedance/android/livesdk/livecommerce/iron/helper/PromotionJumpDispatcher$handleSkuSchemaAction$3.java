package com.bytedance.android.livesdk.livecommerce.iron.helper;

import android.content.Context;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PromotionJumpDispatcher$handleSkuSchemaAction$3 implements com.bytedance.android.livesdk.livecommerce.room.utils.e {
    public final String a;
    public final /* synthetic */ PromotionJumpDispatcher b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g d;
    public final /* synthetic */ LiveRoomParams e;

    @Override // com.bytedance.android.livesdk.livecommerce.room.utils.e
    public final Function1<Long, Unit> a() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.utils.e
    public final Function2<String[], Long, Unit> b() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.utils.e
    public final Function1<SkuShowAndDismissState, Unit> c() {
        return new PromotionJumpDispatcher$handleSkuSchemaAction$3$skuRestoreState$1(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.utils.e
    public final Function1<Boolean, Unit> e() {
        return new PromotionJumpDispatcher$handleSkuSchemaAction$3$showAndDismissListener$1(this);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.utils.e
    public final Context context() {
        return this.c;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.utils.e
    public final String d() {
        return this.a;
    }

    public PromotionJumpDispatcher$handleSkuSchemaAction$3(PromotionJumpDispatcher r1, Context r2, com.bytedance.android.ec.common.api.jump.model.g r3, LiveRoomParams r4, String r5) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.a = r5;
    }
}
