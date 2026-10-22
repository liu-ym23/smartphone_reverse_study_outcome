package com.bytedance.android.livesdk.lottie;

import com.bytedance.android.live.lottie.ILottieService;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LottieService implements ILottieService {

    public class a implements j {
        public final /* synthetic */ ObservableEmitter a;

        public a(ObservableEmitter r1) {
            this.a = r1;
        }
    }

    public static /* synthetic */ void b(LottieService r0, long r1, boolean r3, ObservableEmitter r4) {
        r0.lambda$tryStartLottieAnimation$0(r1, r3, r4);
    }

    public LottieService() {
        jc1.k.l(ILottieService.class, this);
    }

    public void finishLottieAnimation() {
        xs2.b.a().post(new i());
    }

    public Observable<Integer> tryStartLottieAnimation(final long r2, final boolean r4) {
        return Observable.create(new l(this, r2, r4));
    }

    private /* synthetic */ void lambda$tryStartLottieAnimation$0(long r4, boolean r6, ObservableEmitter r7) throws Exception {
        xs2.b.a().post(new k(r4, r6, new a(r7)));
    }
}
