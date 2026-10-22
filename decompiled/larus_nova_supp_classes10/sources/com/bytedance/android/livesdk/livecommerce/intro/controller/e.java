package com.bytedance.android.livesdk.livecommerce.intro.controller;

import android.view.View;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends com.bytedance.android.livesdk.livecommerce.intro.manager.a {
    public final /* synthetic */ IntroAuctionWidgetController f;
    public final /* synthetic */ Function0 g;
    public final /* synthetic */ Function0 h;

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void a() {
        dm.a.a("IntroWidgetController").a("[hideCardAnim] animEnd");
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c(">> post card state [null] to vm, from animEnd");
        this.f.c.getCardState().e(null);
        ECContext r0 = this.f.o.r();
        if (r0 != null) goto L5;
    L6:
        if (r0 == null) goto L11;
        m<Boolean> r1 = r0.isBottomCardVisible();
        if (r1 == null) goto L11;
        r1.setValue(Boolean.FALSE);
    L11:
        if (IntroCardLoadOpt.j == false) goto L15;
        qh2.b r2 = this.f.u;
        if (r2 == null) goto L15;
        r2.t(false);
    L15:
        IntroAuctionWidgetController r3 = this.f;
        Disposable r4 = r3.d;
        if (r4 == null) goto L18;
        r4.dispose();
    L18:
        r3.d = null;
        Function0 r5 = this.h;
        if (r5 == null) goto L22;
        Unit r6 = (Unit) r5.invoke();
        return;
    L22:
        return;
    L5:
        if (r0.isCleared() == true) goto L15;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void b() {
        dm.a.a("IntroWidgetController").a("[hideCardAnim] animStart");
        Function0 r0 = this.g;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void c() {
        dm.a.a("IntroWidgetController").a("[hideCardAnim] invalidAnim");
    }

    public e(IntroAuctionWidgetController r1, Function0 r2, Function0 r3, String r4, View r5, Function2 r6) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        super(r4, r5, 1, r6);
    }
}
