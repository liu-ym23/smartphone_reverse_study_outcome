package si2;

import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q {
    public static final boolean a(ql.a r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$isSecKillActivity");
        Handler r0 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        long r1 = SystemClock.elapsedRealtime();
        ECUICampaign r6 = r5.getCampaign();
        if (r6 != null) goto L5;
    L11:
        return false;
    L5:
        if (r6.isCampaign().booleanValue() == false) goto L11;
        if (r6.startTime > r1) goto L11;
        if (r1 > r6.endTime) goto L11;
        return true;
    }
}
