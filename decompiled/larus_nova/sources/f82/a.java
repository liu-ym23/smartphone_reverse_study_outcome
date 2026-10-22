package f82;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.IImageRecognitionService;
import com.bytedance.android.livesdk.interactivity.imagerecognition.util.ImageRecognitionUtil;
import com.bytedance.android.livesdk.interactivity.jsb.ImageRecognitionResultModel;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import q82.d;
import s32.f;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "imageRecognition")
public final class a extends q82.a<d, ImageRecognitionResultModel> {
    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        d r102 = (d) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.b();
        Integer r104 = r102.c();
        if (r103 == null) goto L19;
        if (r104 == null) goto L19;
        ImageRecognitionEntry r105 = ImageRecognitionEntry.Companion.from(r103);
        if (r104.intValue() <= 0) goto L19;
        if (r105 == null) goto L19;
        String r106 = r102.a();
        if (r106 != null) goto L21;
    L14:
        String r107 = null;
    L15:
        IImageRecognitionService r108 = (IImageRecognitionService) k.f(IImageRecognitionService.class);
        if (r108 == null) goto L18;
        r108.recognize(r104.intValue(), r105, r107);
    L18:
        finishWithSuccess();
        return;
    L21:
        int r109 = ImageRecognitionUtil.f136998a;     // Catch: Exception -> L12
        r107 = ImageRecognitionUtil.c(r106, r101.f249269d);     // Catch: Exception -> L12
        int r110 = f.f540454a;     // Catch: Exception -> L12
        f.b("[ImageRecognitionMethod] createBtmToken " + r107 + " with " + r106);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        int r111 = f.f540454a;
        Intrinsics.checkNotNullParameter("[ImageRecognitionMethod] createBtmToken failed", "info");
        Intrinsics.checkNotNullParameter(e, "t");
        ALogger.e("ImageRecognition", "[ImageRecognitionMethod] createBtmToken failed", e);
    L19:
        int r112 = x8.a.f562881a;
        x8.a.d("ImageRecognitionMethod", "invalid params. entry=" + r103 + " scene=" + r104, false);
        finishWithFailure();
    }
}
