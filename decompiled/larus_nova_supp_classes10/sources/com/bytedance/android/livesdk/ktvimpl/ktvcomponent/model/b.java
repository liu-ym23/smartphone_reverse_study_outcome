package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api.KtvComponentApi;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model.b$b, reason: collision with other inner class name */
    public static final class C0018b {
        public static final b a = null;

        static {
            a = new b();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public c(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r7) {
            com.bytedance.android.live.network.response.e r8 = (com.bytedance.android.live.network.response.e) r7;
            mb0.c.a.b(pd2.d.n, LinkMonitorData.APIUpdateKtvComponentSetting, System.currentTimeMillis() - this.a, ((ExtraResponse) r8).logId);
            this.b.invoke(r8);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ long a;
        public final /* synthetic */ Function1 b;

        public d(long r1, Function1 r3) {
            this.a = r1;
            this.b = r3;
        }

        public final void accept(Object r7) {
            Throwable r8 = (Throwable) r7;
            mb0.c.a.a(pd2.d.n, LinkMonitorData.APIUpdateKtvComponentSetting, System.currentTimeMillis() - this.a, r8);
            ExceptionUtils.handleException(s1.getContext(), r8);
            this.b.invoke(r8);
        }
    }

    static {
    }

    public b() {
    }

    public final Disposable a(long r3, long r5, boolean r7, Function1<? super com.bytedance.android.live.network.response.e<k>, Unit> r8, Function1<? super Throwable, Unit> r9) {
        Intrinsics.checkNotNullParameter(r8, "successCallback");
        Intrinsics.checkNotNullParameter(r9, "failCallback");
        return ((KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class)).updateAudienceSingEnableSetting(r5, r7).compose(RxUtil.rxSchedulerHelper()).subscribe(new c(r3, r8), new d(r3, r9));
    }
}
