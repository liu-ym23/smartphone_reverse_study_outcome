package com.ss.android.lark.chameleonv2.lkapi.biz.profile;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.lark.chameleon.AbsChameleonHandler;
import com.ss.android.lark.chameleon.Callback;
import com.ss.android.lark.chameleon.LKAPIModules;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class BizProfile extends z0b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f411426a;

    public static final class a {
    }

    public final class b extends AbsChameleonHandler<IBizProfile$OpenProfileRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f411427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BizProfile f411428b;

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final String getName() {
            return this.f411427a;
        }

        public b(BizProfile r100) {
            this.f411428b = r100;
            this.f411427a = LKAPIModules.Biz.Profile.OpenProfile.getValue();
        }

        @Override // com.ss.android.lark.chameleon.AbsChameleonHandler
        public final void handle(IBizProfile$OpenProfileRequest r100, Callback r101) {
            IBizProfile$OpenProfileRequest r102 = r100;
            Intrinsics.checkNotNullParameter(r102, HiAnalyticsConstant.Direction.REQUEST);
            Intrinsics.checkNotNullParameter(r101, "callback");
            RxScheduledExecutor.execInIO(new com.ss.android.lark.chameleonv2.lkapi.biz.profile.a(this.f411428b, r102), new com.ss.android.lark.chameleonv2.lkapi.biz.profile.b(r101, this, r102));
            r101.success(null);
        }
    }

    static {
    }

    @Override // z0b.a
    public final List<AbsChameleonHandler<?>> b() {
        return CollectionsKt.arrayListOf(new b[]{new b(this)});
    }

    public BizProfile() {
        this.f411426a = LazyKt.lazy(new BizProfile$chatterService$2(this));
    }
}
