package le3;

import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.o0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final o0 b(o0 r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$addSourceBtmTokenTOECUrlBuilder");
        if (r2 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return r1;
    L11:
        r1.b("source_btm_token", r2);
        return r1;
    L5:
        if (r2.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static final Map<String, Object> c(String r1, View r2) {
        PageFinder r3 = PageFinder.via(r2);
        if (r1 == null) goto L6;
        if (r3 == null) goto L6;
        return BtmSDK.INSTANCE.createReportParams(r1, r3);
    L6:
        return null;
    }

    public static final void a(Map r1, String r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$addBtmReportParams");
        Map<String, Object> r4 = c(r2, r3);
        Intrinsics.checkNotNullParameter(r1, "$this$addBtmReportParams");
        if (r4 == null) goto L6;
        r1.putAll(r4);
        return;
    }

    public static final String d(String r1, View r2, BcmParams r3) {
        PageFinder r4 = PageFinder.via(r2);
        if (r1 == null) goto L6;
        if (r4 == null) goto L6;
        return BtmSDK.INSTANCE.createJumpSourceBtmToken(r1, r4, r3);
    L6:
        return null;
    }
}
