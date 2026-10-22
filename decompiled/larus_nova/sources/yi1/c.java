package yi1;

import android.app.Activity;
import com.bytedance.android.live.browser.jsbridge.base.LiveAudiencePageCloseAndJumpResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.locallife.cube.PrefetchTiming;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import w20.j2;
import w20.ka;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends j2<ka, LiveAudiencePageCloseAndJumpResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f567853a;

    public static final class a {
    }

    static {
    }

    public c(WeakReference<Activity> r100) {
        this.f567853a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        ka r102 = (ka) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        ALogger.i("ttlive_anchor_swallow_back", "start jsb live.audiencePageCloseAndJump");
        int r103 = yi1.a.f567852a;
        String r104 = r102.a();
        WeakReference<Activity> r105 = this.f567853a;
        if (r105 == null) goto L7;
        Activity r106 = r105.get();
        if (r106 == null) goto L7;
    L8:
        yi1.a.a(r104, r106, PrefetchTiming.JSB);
        finishWithSuccess();
        return;
    L7:
        r106 = r101.getContext();
        goto L8
    }
}
