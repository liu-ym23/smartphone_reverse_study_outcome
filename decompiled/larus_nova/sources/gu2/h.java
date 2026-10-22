package gu2;

import android.app.Activity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.business.IHostOCRApiProxy;
import com.bytedance.android.livehostapi.business.IHostRealNameAuthorization;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements IHostRealNameAuthorization.BytedCertCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f482758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IHostOCRApiProxy.BytedCertCallback f482759b;

    @Override // com.bytedance.android.livehostapi.business.IHostRealNameAuthorization.BytedCertCallback
    public final void onVerifyResult(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        int r101 = a.f482740a;
        Activity r102 = this.f482758a;
        IHostOCRApiProxy.BytedCertCallback r103 = this.f482759b;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r103, "certH5CloseCallback");
        ALogger.i("face_verify", String.valueOf(r100.optInt("error_code", -1)));
        if (r100.optInt("error_code", -1) != 0) goto L5;
        f2.c("认证成功！", 0);
    L5:
        r103.onH5Close(r100);
    }

    public h(Activity r100, z80.c.a r101) {
        this.f482758a = r100;
        this.f482759b = r101;
    }
}
