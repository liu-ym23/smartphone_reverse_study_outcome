package j76;

import com.bytedance.ies.xelement.bytedlottie.LynxBytedLottieView;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class h implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxBytedLottieView f497600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f497601b;

    public /* synthetic */ h(LynxBytedLottieView r100, String r101) {
        this.f497600a = r100;
        this.f497601b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return LynxBytedLottieView.M(this.f497600a, this.f497601b);
    }
}
