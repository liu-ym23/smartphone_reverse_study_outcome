package com.bytedance.android.shopping.store.mall.follows.apidata;

import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.utils.k0;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ec.sdk.helper.r;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.mall.follows.FollowStoreResponse;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import hj3.e;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.internal.observers.h;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class FollowStoreApiDataManager {
    public h<FollowStoreResponse> a;
    public final Lazy b;
    public final Lazy c;
    public final e d;
    public final FollowStoreApiDataCacheKey e;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ FollowStoreApiDataManager a;
        public final /* synthetic */ long b;

        public a(FollowStoreApiDataManager r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r10) {
            FollowStoreResponse r11 = (FollowStoreResponse) r10;
            Intrinsics.checkNotNullParameter(r11, "it");
            if (this.b != 0) goto L10;
            if (r11.getStatusCode() != 0) goto L10;
            FollowStoreApiDataManager r0 = this.a;
            r0.getClass();
            if (ECSettingKeys.h0() != 1) goto L10;
            com.bytedance.android.shopping.store.mall.follows.apidata.a r1 = com.bytedance.android.shopping.store.mall.follows.apidata.a.a;
            String r2 = r0.c();
            int r3 = t0.a;
            String r4 = GsonProtectorUtils.toJson(t0.a.a, r11);
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r4, "value");
            Keva.getRepo("follow_store", 1).storeString(r2, r4);
            String r5 = r0.e.getNativeTime();
            String r6 = String.valueOf(System.currentTimeMillis());
            Intrinsics.checkNotNullParameter(r5, "key");
            Intrinsics.checkNotNullParameter(r6, "value");
            Keva.getRepo("follow_store", 1).storeString(r5, r6);
        L10:
            if (r11.getStatusCode() != 0) goto L14;
            e r7 = this.a.d;
            if (r7 == null) goto L14;
            r7.b(this.b, k0.b(r11));
        L14:
            return r11;
        }
    }

    public final String c() {
        return r.a.getCurrentUserId() + '_' + this.e.getNativeData();
    }

    public FollowStoreApiDataManager(e r2, FollowStoreApiDataCacheKey r3) {
        Intrinsics.checkNotNullParameter(r3, "cacheKey");
        this.d = r2;
        this.e = r3;
        this.b = LazyKt.lazy(FollowStoreApiDataManager$momentConfig$2.INSTANCE);
        this.c = LazyKt.lazy(new FollowStoreApiDataManager$localResourceVersion$2(this));
    }

    public final boolean a(com.bytedance.android.ec.store.setting.b r8, Long r9) {
        if (r9 == null) goto L5;
        long r2 = r9.longValue();
    L6:
        if (r8 != null) goto L8;
        return true;
    L8:
        if (r8.c() != null) goto L10;
    L12:
        long r0 = k.y(ECAppInfoService.e.getAppVersion(), 0);
        if (r8.a() == null) goto L18;
        if (r0 >= r8.a().intValue()) goto L18;
        return false;
    L18:
        if (r8.b() == null) goto L26;
        Long r10 = (Long) this.c.getValue();
        if (r10 != null) goto L22;
        return true;
    L22:
        if (r10.longValue() >= r8.b().intValue()) goto L28;
        return false;
    L28:
        return true;
    L26:
        return true;
    L10:
        if (r2 >= r8.c().longValue()) goto L12;
        return false;
    L5:
        r2 = k.y(com.bytedance.android.shopping.store.mall.follows.apidata.a.a.query(this.e.getNativeTime()), 0);
        goto L6
    }

    public final Observable<FollowStoreResponse> b(long r3, HashMap<String, Object> r5) {
        FollowStoreApi.a.getClass();
        FollowStoreApi r0 = FollowStoreApi.a.a;
        if (r0 == null) goto L7;
        Observable<FollowStoreResponse> r6 = r0.getFollowTabFeed(Long.valueOf(r3), r5);
        if (r6 == null) goto L7;
        return r6.map(new a(this, r3));
    L7:
        return null;
    }
}
