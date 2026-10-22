package na3;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.shopping.buynow.cache.UltimateBuyCacheQueryHelper;
import com.bytedance.android.shopping.buynow.data.remote.LogPB;
import com.bytedance.android.shopping.buynow.monitor.firstscreen.BuyNowFirstScreenMonitor;
import com.bytedance.android.shopping.buynow.monitor.param.BuyNowFirstScreenNode;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ma3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f<T> implements ObservableOnSubscribe {
    public final /* synthetic */ ma3.f a;
    public final /* synthetic */ com.bytedance.android.shopping.buynow.starter.e b;
    public final /* synthetic */ Scheduler c;
    public final /* synthetic */ nl.b d;
    public final /* synthetic */ UltimateBuyCacheQueryHelper e;
    public final /* synthetic */ pa3.a f;

    public static final class a implements Observer<SsResponse<String>> {
        public final /* synthetic */ f a;
        public final /* synthetic */ ObservableEmitter b;

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
        }

        public final void onComplete() {
            this.b.onComplete();
        }

        public final void onError(Throwable r3) {
            Intrinsics.checkNotNullParameter(r3, "e");
            UltimateBuyCacheQueryHelper r0 = this.a.e;
            if (r0 != null) goto L5;
        L7:
            this.b.onError(r3);
            return;
        L5:
            if (r0.f != true) goto L7;
        }

        public final void onNext(Object r11) {
            SsResponse r12 = (SsResponse) r11;
            Intrinsics.checkNotNullParameter(r12, "retrofitResponse");
            UltimateBuyCacheQueryHelper r0 = this.a.e;
            if (r0 != null) goto L5;
        L7:
            long r1 = System.currentTimeMillis();
            pa3.a r2 = this.a.f;
            if (r2 == null) goto L12;
            BuyNowFirstScreenMonitor r3 = r2.a;
            if (r3 == null) goto L12;
            r3.a(BuyNowFirstScreenNode.NATIVE_NET_END, r1);
        L12:
            pa3.a r4 = this.a.f;
            if (r4 == null) goto L17;
            BuyNowFirstScreenMonitor r5 = r4.a;
            if (r5 == null) goto L17;
            r5.a(BuyNowFirstScreenNode.PARSE_RESPONSE_START, System.currentTimeMillis());
        L17:
            int r6 = t0.a;
            ma3.b r7 = (ma3.b) GsonProtectorUtils.fromJson(t0.a.a, (String) r12.body(), ma3.b.class);
            String r8 = l.a(r12);
            pa3.a r9 = this.a.f;
            if (r9 == null) goto L22;
            BuyNowFirstScreenMonitor r10 = r9.a;
            if (r10 == null) goto L22;
            r10.a(BuyNowFirstScreenNode.PARSE_RESPONSE_END, System.currentTimeMillis());
        L22:
            if (r7 == null) goto L35;
            LogPB r13 = r7.h();
            if (r13 == null) goto L35;
            Map<String, Long> r14 = r13.getServerTiming();
            if (r14 == null) goto L35;
            Iterator<Map.Entry<String, Long>> r15 = r14.entrySet().iterator();
        L29:
            if (r15.hasNext() == false) goto L35;
            Map.Entry<String, Long> r16 = r15.next();
            pa3.a r17 = this.a.f;
            if (r17 == null) goto L29;
            BuyNowFirstScreenMonitor r18 = r17.a;
            if (r18 == null) goto L29;
            String r19 = r16.getKey();
            long r20 = k.h(r16.getValue());
            Intrinsics.checkNotNullParameter(r19, "node");
            r18.c(r19, r20);
        L35:
            pa3.a r21 = this.a.f;
            if (r21 == null) goto L40;
            BuyNowFirstScreenMonitor r22 = r21.a;
            if (r22 == null) goto L40;
            r22.a(BuyNowFirstScreenNode.REQUEST_END, System.currentTimeMillis());
        L40:
            if (r7 == null) goto L42;
            Boolean r23 = Boolean.valueOf(com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r7));
        L44:
            if (k.i(r23) == false) goto L50;
            int r24 = ra3.b.a;
            g r25 = g.a;
            ra3.b.a(g.b(this.a.b.c), r12, r1);
            if (this.a.b.c.C() == false) goto L50;
            UltimateBuyCacheQueryHelper r26 = this.a.e;
            if (r26 == null) goto L50;
            r26.a();
        L50:
            pa3.a r27 = this.a.f;
            if (r27 == null) goto L55;
            BuyNowFirstScreenMonitor r28 = r27.a;
            if (r28 == null) goto L55;
            BuyNowFirstScreenMonitor.b(r28, BuyNowFirstScreenNode.FETCH_END);
        L55:
            pa3.a r29 = this.a.f;
            if (r29 == null) goto L60;
            BuyNowFirstScreenMonitor r30 = r29.a;
            if (r30 == null) goto L60;
            r30.a(BuyNowFirstScreenNode.RENDER_START, System.currentTimeMillis());
        L60:
            pa3.a r31 = this.a.f;
            if (r31 == null) goto L65;
            BuyNowFirstScreenMonitor r32 = r31.a;
            if (r32 == null) goto L65;
            r32.a(BuyNowFirstScreenNode.STANDARD_RENDER_START, System.currentTimeMillis());
        L65:
            la3.b r33 = new la3.b(r7, r8, ((String) r12.body()).length(), 0);
            this.b.onNext(r33);
            return;
        L42:
            r23 = null;
            goto L44
        L5:
            if (r0.f != true) goto L7;
        }

        public a(f r1, ObservableEmitter r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public f(ma3.f r1, com.bytedance.android.shopping.buynow.starter.e r2, Scheduler r3, com.bytedance.android.shopping.buynow.cache.a r4, UltimateBuyCacheQueryHelper r5, pa3.a r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public final void subscribe(ObservableEmitter<la3.b> r5) {
        Intrinsics.checkNotNullParameter(r5, "emitter");
        g r0 = g.a;
        Observable r1 = g.c(this.a, this.b.f());
        if (r1 == null) goto L15;
        Scheduler r2 = this.c;
        if (r2 != null) goto L7;
        r2 = Schedulers.newThread();
    L7:
        Observable r3 = r1.subscribeOn(r2);
        if (r3 == null) goto L16;
        Observable r4 = r3.observeOn(Schedulers.io());
        if (r4 == null) goto L17;
        nl.b r6 = this.d;
        Intrinsics.checkNotNullParameter(r4, "$this$putCache");
        Observable r7 = r4.doOnNext(new com.bytedance.android.shopping.buynow.cache.b(r6, false));
        if (r7 == null) goto L18;
        r7.subscribe(new a(this, r5));
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    }
}
