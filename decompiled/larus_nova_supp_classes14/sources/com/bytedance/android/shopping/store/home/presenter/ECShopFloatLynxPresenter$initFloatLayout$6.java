package com.bytedance.android.shopping.store.home.presenter;

import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.shopping.store.home.entity.ShopMarketingScene;
import com.bytedance.services.apm.api.EnsureManager;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ECShopFloatLynxPresenter$initFloatLayout$6 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ECShopFloatLynxPresenter this$0;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ECShopFloatLynxPresenter$initFloatLayout$6 a;

        public a(ECShopFloatLynxPresenter$initFloatLayout$6 r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Long r4 = (Long) r3;
            this.a.this$0.T().tryUpdateFloatView(ShopMarketingScene.VIEW_UPDATE, new ECShopFloatLynxPresenter$initFloatLayout$6$1$1(this));
        }
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            EnsureManager.ensureNotReachHere((Throwable) r2, "collapseHeaderIfNeed error");
        }
    }

    public ECShopFloatLynxPresenter$initFloatLayout$6(ECShopFloatLynxPresenter r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m121invoke() {
        Lazy r0 = ECStoreSettings.a;
        int r1 = com.bytedance.android.ec.core.opt.ab.p.a;
        Object r2 = new com.bytedance.android.ec.store.setting.i(0);
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
        jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
        Object r5 = jj4.a.a("ec_shop_marketing_config", com.bytedance.android.ec.store.setting.i.class, r2, false);     // Catch: Throwable -> L7
        if (r5 != null) goto L13;
        Intrinsics.throwNpe();     // Catch: Throwable -> L7
    L13:
        com.bytedance.android.ec.store.setting.c r6 = ((com.bytedance.android.ec.store.setting.i) r5).a();
        if (r6 != null) goto L17;
        r6 = new com.bytedance.android.ec.store.setting.c(true, 6000);
    L17:
        if (r6.b() == false) goto L22;
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(Observable.timer(r6.a(), TimeUnit.MILLISECONDS)).subscribe(new a(this), b.a), this.this$0.T());
        return;
    L22:
        return;
    L7:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Object r8 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r8) == true) goto L12;
        r2 = r8;
    L12:
        r5 = r2;
        goto L13
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m121invoke();
        return Unit.INSTANCE;
    }
}
