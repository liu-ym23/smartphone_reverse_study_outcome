package k0;

import android.content.Context;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieTask;

/* JADX INFO: loaded from: classes28.dex */
public final class a extends c<String, LottieTask<LottieComposition>> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // k0.c
    public final String a() {
        return (String) this.f501235a;
    }

    public a(String r100) {
        super(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // k0.c
    public final LottieTask b(Context r100) {
        return LottieCompositionFactory.fromAsset(r100, (String) this.f501235a);
    }
}
