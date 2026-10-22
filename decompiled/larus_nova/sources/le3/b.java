package le3;

import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.o0;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {
    public static final o0 b(o0 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$addSourceBtmTokenTOECUrlBuilder");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return r100;
    L11:
        r100.b(PhotoEnterModel.SOURCE_BTM_TOKEN, r101);
        return r100;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }

    public static final Map<String, Object> c(String r100, View r101) {
        PageFinder r102 = PageFinder.via(r101);
        if (r100 == null) goto L6;
        if (r102 == null) goto L6;
        return BtmSDK.INSTANCE.createReportParams(r100, r102);
    L6:
        return null;
    }

    public static final void a(Map r100, String r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$addBtmReportParams");
        Map<String, Object> r103 = c(r101, r102);
        Intrinsics.checkNotNullParameter(r100, "$this$addBtmReportParams");
        if (r103 == null) goto L6;
        r100.putAll(r103);
        return;
    }

    public static final String d(String r100, View r101, BcmParams r102) {
        PageFinder r103 = PageFinder.via(r101);
        if (r100 == null) goto L6;
        if (r103 == null) goto L6;
        return BtmSDK.INSTANCE.createJumpSourceBtmToken(r100, r103, r102);
    L6:
        return null;
    }
}
