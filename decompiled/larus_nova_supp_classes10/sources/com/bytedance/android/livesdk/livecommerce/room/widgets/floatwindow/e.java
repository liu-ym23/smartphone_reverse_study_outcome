package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow;

import android.content.Context;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements f, bk2.d {
    public final FloatWindowView a;
    public final Context b;
    public final ECContext c;
    public final bk2.d d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.a.u(e.a((ECUIPromotion) sh6.c.b((sh6.b) r2)));
        }
    }

    @Override // bk2.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.d.add(r2);
    }

    @Override // bk2.d
    public final void clearDisposable() {
        this.d.clearDisposable();
    }

    @Override // bk2.d
    public final Disposable ignore(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        return this.d.ignore(r2);
    }

    @Override // bk2.d
    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.d.remove(r2);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.f
    public final void load() {
        bk2.c.a(this.c.getExplainPromotion().a().subscribe(new a(this)), this);
        ECUIPromotion r0 = (ECUIPromotion) this.c.getExplainPromotion().getValue();
        if (r0 == null) goto L6;
        this.a.u(a(r0));
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.f
    public final void onDestroy() {
        clearDisposable();
        FloatWindowView r0 = this.a;
        r0.clearDisposable();
        ((QUIManager) r0.b.getValue()).r(kk2.a.class);
    }

    public final Context getContext() {
        return this.b;
    }

    public static c a(ECUIPromotion r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        c r0 = new c();
        r0.a = r2.floatWindowInfo;
        r0.b = r2.getProductId();
        r0.c = r2.getPromotionId();
        r0.d = r2.getEventItemType();
        return r0;
    }

    public e(Context r8, ECContext r9, com.bytedance.android.livesdk.livecommerce.room.api.e r10, LiveRoomParams r11) {
        bk2.b r5 = new bk2.b();
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "ecContext");
        Intrinsics.checkNotNullParameter(r10, "iLiveRoomViewHandler");
        Intrinsics.checkNotNullParameter(r5, "disposableContext");
        this.b = r8;
        this.c = r9;
        this.d = r5;
        this.a = new FloatWindowView(r8, r9, r11, r10, r5);
    }
}
