package y81;

import com.airbnb.lottie.LottieAnimationView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f566771a;

    public k(c r100) {
        this.f566771a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        LottieAnimationView r102 = this.f566771a.f566687w;
        if (r102 == null) goto L6;
        r102.playAnimation();
        return;
    }
}
