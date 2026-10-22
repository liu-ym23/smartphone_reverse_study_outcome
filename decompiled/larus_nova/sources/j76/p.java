package j76;

import android.graphics.Bitmap;
import com.airbnb.lottie.LottieComposition;
import com.bytedance.ies.xelement.bytedlottie.LynxBytedLottieView;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class p implements LynxBytedLottieView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HashMap<String, Bitmap> f497622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f497623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.airbnb.lottie.g<String> f497624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LottieComposition f497625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ LynxBytedLottieView f497626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ReadableMap f497627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f497628g;

    @Override // com.bytedance.ies.xelement.bytedlottie.LynxBytedLottieView.a
    public final void onFailed(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (StringsKt.isBlank(r100) == true) goto L5;
        LynxBytedLottieView r101 = this.f497626e;
        String r102 = "fetch polyfill bitmap failed, map: " + this.f497627f + ", path: " + this.f497628g.element + ", msg: " + r100;
        String r103 = this.f497628g.element;
        int r104 = LynxBytedLottieView.C;
        r101.T(r102, r103, 1);
    L5:
        this.f497624c.onFailed();
    }

    @Override // com.bytedance.ies.xelement.bytedlottie.LynxBytedLottieView.a
    public final void a(final Bitmap r100, final String r110) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r110, "id");
        final HashMap<String, Bitmap> r101 = this.f497622a;
        final AtomicInteger r102 = this.f497623b;
        final com.airbnb.lottie.g<String> r103 = this.f497624c;
        final LottieComposition r104 = this.f497625d;
        UIThreadUtils.runOnUiThread(new o(r101, r110, r100, r102, r103, r104));
    }

    public p(HashMap<String, Bitmap> r100, AtomicInteger r101, com.airbnb.lottie.g<String> r102, LottieComposition r103, LynxBytedLottieView r104, ReadableMap r105, Ref.ObjectRef<String> r106) {
        this.f497622a = r100;
        this.f497623b = r101;
        this.f497624c = r102;
        this.f497625d = r103;
        this.f497626e = r104;
        this.f497627f = r105;
        this.f497628g = r106;
    }
}
