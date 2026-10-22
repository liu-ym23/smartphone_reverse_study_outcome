package com.bytedance.android.shopping.mall.feed;

import android.content.Context;
import com.bytedance.android.shopping.api.mall.feed.IECMallFeedComponentV3Factory;
import com.bytedance.android.shopping.api.mall.feed.IECMallFeedService;
import com.bytedance.android.shopping.api.mall.mita.MallMitaConfig;
import com.bytedance.android.shopping.api.mall.mita.MallMitaConfigKt;
import com.bytedance.android.shopping.mall.feed.opt.ECMallSaasPrefetchService;
import com.bytedance.android.shopping.mall.settings.MallSettings;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/ECMallFeedService;", "Lcom/bytedance/android/shopping/api/mall/feed/IECMallFeedService;", "<init>", "()V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallFeedService implements IECMallFeedService {
    public final ECMallFeedOptService a;
    public final ECMallSaasPrefetchService b;

    public ECMallFeedService() {
        this.a = new ECMallFeedOptService();
        this.b = new ECMallSaasPrefetchService();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.IECMallFeedService
    public final ECMallFeedOptService c() {
        return this.a;
    }

    public static boolean d(String r4) {
        boolean r1 = false;
        if (((Boolean) MallSettings.d.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        List<String> r0 = ((MallMitaConfig) MallMitaConfigKt.a.getValue()).getEnableMitaGulPageNames();
        List<String> r2 = r0;
        if (r2 != null) goto L8;
    L9:
        r1 = true;
    L10:
        if (r1 == false) goto L13;
        return true;
    L13:
        return r0.contains(r4);
    L8:
        if (r2.isEmpty() == false) goto L10;
        goto L9
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.IECMallFeedService
    public final void a(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter("product_detail", "pageName");
        Single.fromCallable(new c1(r3)).subscribeOn(Schedulers.io()).subscribe();
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.IECMallFeedService
    public final com.bytedance.android.shopping.api.mall.feed.g b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "targetPageName");
        if (d(r2) == false) goto L11;
        IECMallFeedComponentV3Factory r3 = (IECMallFeedComponentV3Factory) ServiceManager.get().getService(IECMallFeedComponentV3Factory.class);
        if (r3 == null) goto L11;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        return r3.homepagePrefetch();
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        Result.box-impl(Result.constructor-impl(ResultKt.createFailure(th)));
    L11:
        return this.b;
    }

    @Override // com.bytedance.android.shopping.api.mall.feed.IECMallFeedService
    public final com.bytedance.android.shopping.api.mall.feed.d createFeedComponent(Context r6, com.bytedance.android.shopping.api.mall.feed.b r7, com.bytedance.android.shopping.api.mall.feed.e r8, com.bytedance.android.shopping.api.mall.feed.f r9) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "containerAbility");
        if (d(r7.a) == false) goto L10;
        IECMallFeedComponentV3Factory r3 = (IECMallFeedComponentV3Factory) ServiceManager.get().getService(IECMallFeedComponentV3Factory.class);
        if (r3 == null) goto L10;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        return r3.createFeedComponent(r6, r7, r8, r9);
    L8:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Result.box-impl(Result.constructor-impl(ResultKt.createFailure(th)));
    L10:
        Lazy r10 = ECMallFeedComponent.p0;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "containerAbility");
        return new ECMallFeedComponent(r6, r7, r8, r9);
    }
}
