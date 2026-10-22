package j76;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.bytedance.ies.xelement.bytedlottie.LynxBytedLottieView;
import com.lynx.tasm.base.LLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class q implements com.airbnb.lottie.g<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LynxBytedLottieView f497629a;

    @Override // com.airbnb.lottie.g
    public final void onFailed() {
        String r100 = "fetch polyfill bitmap " + this.f497629a.f249831o + " failed";
        LynxBytedLottieView r101 = this.f497629a;
        r101.getClass();
        r101.Z("error", LynxBytedLottieView.S(1, r100));
        LLog.e("byted-lottie", "fetch polyfill Bitmap mSrcUrl=" + this.f497629a.f249825i + ", filePath=" + this.f497629a.f249831o + " not exists.");
    }

    public q(LynxBytedLottieView r100) {
        this.f497629a = r100;
    }

    @Override // com.airbnb.lottie.g
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
        LynxBytedLottieView r101 = this.f497629a;
        LottieAnimationView r102 = (LottieAnimationView) LynxBytedLottieView.O(r101);
        if (r102 == null) goto L5;
        int r103 = r102.getFrame();
    L6:
        LottieAnimationView r104 = (LottieAnimationView) LynxBytedLottieView.O(this.f497629a);
        if (r104 == null) goto L11;
        LottieComposition r105 = r104.getComposition();
        if (r105 == null) goto L11;
        float r106 = r105.getDurationFrames();
    L12:
        LynxBytedLottieView r107 = this.f497629a;
        r101.Z("ready", LynxBytedLottieView.R(r103, (int) r106, r107.f249823g, r107.f249830n));
        LynxBytedLottieView r108 = this.f497629a;
        r108.f249834r.a(r108.f249826j);
        LynxBytedLottieView r109 = this.f497629a;
        if (r109.f249818b == true) goto L15;
        return;
    L15:
        if (r109.f249829m == false) goto L19;
        r109.V();
        return;
    L19:
        return;
    L11:
        r106 = 0.0f;
        goto L12
    L5:
        r103 = 0;
        goto L6
    }
}
