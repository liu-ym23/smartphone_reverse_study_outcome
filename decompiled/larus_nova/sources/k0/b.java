package k0;

import android.content.Context;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieTask;

/* JADX INFO: loaded from: classes28.dex */
public final class b extends c<Integer, LottieTask<LottieComposition>> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // k0.c
    public final String a() {
        return Integer.toString(((Integer) this.f501235a).intValue());
    }

    public b(int r100) {
        super(Integer.valueOf(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k0.c
    public final LottieTask b(Context r100) {
        return LottieCompositionFactory.fromRawRes(r100, ((Integer) this.f501235a).intValue());
    }
}
