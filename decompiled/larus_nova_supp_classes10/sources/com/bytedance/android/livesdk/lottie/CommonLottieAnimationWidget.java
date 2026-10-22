package com.bytedance.android.livesdk.lottie;

import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.livesdk.utils.h3;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/lottie/CommonLottieAnimationWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommonLottieAnimationWidget extends LiveRecyclableWidget {
    public LottieAnimationView a;
    public Disposable b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ CommonLottieAnimationWidget a;

        public a(CommonLottieAnimationWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            final k r6 = (k) r5;
            CommonLottieAnimationWidget r0 = this.a;
            r0.getClass();
            Function0<Long> r1 = new CommonLottieAnimationWidget$onEvent$rootPath$1(r6);
            Intrinsics.checkNotNullParameter(r1, "getAssetId");
            ((SingleSubscribeProxy) Single.create(new h3(new AtomicReference(), r1)).flatMap(new com.bytedance.android.livesdk.lottie.b(new e())).flatMap(new c(r0)).observeOn(AndroidSchedulers.mainThread()).compose(RxUtil.rxSchedulerHelper()).as(AutoDispose.bind(r0))).subscribe(new g(r0, r6), new h(r6));
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ CommonLottieAnimationWidget a;

        public b(CommonLottieAnimationWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CommonLottieAnimationWidget r0 = this.a;
            r0.getClass();
            if (((i) r2).a == false) goto L18;
            Disposable r3 = r0.b;
            if (r3 != null) goto L7;
        L11:
            LottieAnimationView r4 = r0.a;
            if (r4 == null) goto L14;
            r4.cancelAnimation();
        L14:
            LottieAnimationView r5 = r0.a;
            if (r5 == null) goto L19;
            r5.setVisibility(8);
            return;
        L19:
            return;
        L7:
            if (r3.isDisposed() == true) goto L11;
            Disposable r6 = r0.b;
            if (r6 == null) goto L11;
            r6.dispose();
            goto L11
        }
    }

    public final int getLayoutId() {
        return 2131565327;
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        Disposable r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDisposed() == true) goto L11;
        Disposable r1 = this.b;
        if (r1 == null) goto L12;
        r1.dispose();
        return;
    L12:
        return;
    }

    public CommonLottieAnimationWidget() {
    }

    public final void onLoad(Object[] r2) {
        this.a = ((Widget) this).contentView.findViewById(2131379214);
        ((ObservableSubscribeProxy) xs2.b.a().b(k.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new a(this));
        ((ObservableSubscribeProxy) xs2.b.a().b(i.class).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(new b(this));
    }

    public static final void wq(CommonLottieAnimationWidget r2, k r3) {
        r2.getClass();
        ((LottieService.a) r3.c).a.onNext(2);
        if (r3.b == false) goto L7;
        LottieAnimationView r4 = r2.a;
        if (r4 == null) goto L9;
        r4.setVisibility(8);
        return;
    L9:
        return;
    L7:
        r2.b = Observable.timer(4000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.lottie.a(r2));
    }
}
