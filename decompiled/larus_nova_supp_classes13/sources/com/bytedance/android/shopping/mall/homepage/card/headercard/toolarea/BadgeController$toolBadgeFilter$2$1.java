package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.tools.p;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class BadgeController$toolBadgeFilter$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.ObjectRef $clickedBadge;
    final /* synthetic */ String $storageJSONStr;

    public BadgeController$toolBadgeFilter$2$1(Ref.ObjectRef r1, String r2) {
        this.$clickedBadge = r1;
        this.$storageJSONStr = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1272invoke() {
        Ref.ObjectRef r0 = this.$clickedBadge;
        r0.element = (BadgeStorageStruct) GsonProtectorUtils.fromJson(p.b(), this.$storageJSONStr, BadgeStorageStruct.class);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1272invoke();
        return Unit.INSTANCE;
    }
}
