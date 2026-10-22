package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u extends com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b {
    public final /* synthetic */ RelatedCardWidgetController f;
    public final /* synthetic */ Function0 g;
    public final /* synthetic */ Function0 h;

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b
    public final void c() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b
    public final void a() {
        this.f.f.getPromotionState().e(null);
        if (this.f.f.isFromLive() == false) goto L17;
        int r0 = RoomContextController.h;
        ECContext r1 = RoomContextController.a.a().r();
        if (r1 != null) goto L7;
    L8:
        if (r1 == null) goto L13;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.isBottomCardVisible();
        if (r2 == null) goto L13;
        r2.setValue(Boolean.FALSE);
    L13:
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.j == false) goto L17;
        com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.h r3 = this.f.b;
        if (r3 == null) goto L17;
        r3.q(false);
        goto L17
    L7:
        if (r1.isCleared() != true) goto L8;
    L17:
        RelatedCardWidgetController r4 = this.f;
        Disposable r5 = r4.g;
        if (r5 == null) goto L20;
        r5.dispose();
    L20:
        r4.g = null;
        Function0 r6 = this.h;
        if (r6 == null) goto L24;
        Unit r7 = (Unit) r6.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b
    public final void b() {
        Function0 r0 = this.g;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    public u(RelatedCardWidgetController r1, Function0 r2, Function0 r3, String r4, View r5, Function2 r6) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        super(r4, r5, 1, r6);
    }
}
