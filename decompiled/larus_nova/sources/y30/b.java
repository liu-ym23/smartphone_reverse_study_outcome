package y30;

import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.live.core.utils.u;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import v80.d;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fu2.a f565730a;

    public b(fu2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "bytedCert");
        this.f565730a = r100;
    }

    public static HashMap a(b r100) {
        r100.getClass();
        HashMap r101 = new HashMap();
        r101.put(ThemeConfig.SCREEN_COLOR, Integer.valueOf(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT)));
        r101.put(ThemeConfig.TEXT_COLOR, Integer.valueOf(ColorProtector.parseColor("#161823")));
        r101.put(ThemeConfig.PROGRESS_BG_COLOR, Integer.valueOf(ColorProtector.parseColor("#14FFFFFF")));
        r101.put(ThemeConfig.PROGRESS_COLOR, Integer.valueOf(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_STROKE_RED)));
        r101.put("IS_FACE_LIVE_BACK", Boolean.TRUE);
        r101.put("IS_WEB_DARK_MODE", Boolean.FALSE);
        r101.put("IS_NEED_INIT_LOADING", true);
        return r101;
    }

    public final void b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "verifyParam");
        com.bytedance.android.live.core.verify.utils.a.g r101 = r100.f553617n;
        if (((IHostContext) k.f(IHostContext.class)) != null) goto L6;
        r101.onVerify(false, new HashMap());
        return;
    L6:
        fu2.a r102 = this.f565730a;
        u.a();
        r102.b();
        HashMap r103 = new HashMap();
        r103.put("scene", r100.f553593b);
        r103.put("mode", r100.f553595d);
        r103.put("ticket", r100.f553594c);
        r103.put("cert_app_id", "1128");
        String r104 = r100.f553597f;
        if (r104 != null) goto L9;
        r104 = "false";
    L9:
        r103.put("use_new_api", r104);
        String r105 = r100.f553596e;
        if (r105 == null) goto L12;
        r103.put(BytedCertConstant.CertKey.FLOW, r105);
    L12:
        this.f565730a.c();
        fu2.a r106 = this.f565730a;
        r100.getContext();
        r106.e();
    }
}
