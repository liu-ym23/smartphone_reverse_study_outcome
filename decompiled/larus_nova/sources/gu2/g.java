package gu2;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.u;
import com.bytedance.android.live.core.verify.api.ISaaSOcrVerifyApi;
import com.bytedance.android.livehostapi.business.IHostRealNameAuthorization;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f482754a = null;

    public static final class a implements IHostRealNameAuthorization.FaceLiveCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v80.d f482755a;

        public a(v80.d r100) {
            this.f482755a = r100;
        }

        @Override // com.bytedance.android.livehostapi.business.IHostRealNameAuthorization.FaceLiveCallback
        public final void onDetectFaceLiveFinish(boolean r110, int r111, String r112, JSONObject r210) {
            Intrinsics.checkNotNullParameter(r112, "errorMsg");
            Intrinsics.checkNotNullParameter(r210, "data");
            int r100 = f.f482753a;
            v80.d r101 = this.f482755a;
            Intrinsics.checkNotNullParameter(r112, "errorMsg");
            Intrinsics.checkNotNullParameter(r210, "data");
            Intrinsics.checkNotNullParameter(r101, "verifyParam");
            String r102 = "";
            if (TextUtils.equals("true", r101.f553597f) == true) goto L37;
            String r103 = r101.f553594c;
            if (r103 != null) goto L17;
            String r113 = "";
        L18:
            com.bytedance.android.live.core.verify.utils.a.g r104 = r101.f553617n;
            boolean r105 = r101.f553612i;
            if (TextUtils.isEmpty(r101.f553613j) == false) goto L21;
            String r106 = r101.f553593b;
        L22:
            if (r106 != null) goto L24;
            String r114 = "";
        L25:
            String r107 = r101.f553593b;
            if (r107 == null) goto L29;
            r102 = r107;
        L29:
            boolean r115 = r101.f553614k;
            String r116 = r101.f553615l;
            if (TextUtils.isEmpty(r102) == true) goto L32;
            String r117 = r102;
        L33:
            if (r105 == false) goto L35;
            ((ISaaSOcrVerifyApi) com.bytedance.android.live.network.c.b().e(ISaaSOcrVerifyApi.class)).queryPollingStatus("byte", r113, 1, r114, r117, r115, r116).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new gu2.b(r210, r111, r104), new c(r210, r111, r104));
            return;
        L35:
            ((ISaaSOcrVerifyApi) com.bytedance.android.live.network.c.b().e(ISaaSOcrVerifyApi.class)).queryPollingStatus("byte", r113, 2, r114, r117, r115, r116).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r210, r111, r104), new e(r210, r111, r104));
            return;
        L32:
            r117 = "game_webcast_sdk";
            goto L33
        L24:
            r114 = r106;
            goto L25
        L21:
            r106 = r101.f553613j;
            goto L22
        L17:
            r113 = r103;
            goto L18
        L37:
            Pair[] r108 = new Pair[4];     // Catch: Throwable -> L10
            r108[0] = TuplesKt.to("errorCode", Integer.valueOf(r111));     // Catch: Throwable -> L10
            r108[1] = TuplesKt.to("errorMsg", r112);     // Catch: Throwable -> L10
            r108[2] = TuplesKt.to("ticket", r210.optString("ticket", ""));     // Catch: Throwable -> L10
            JSONObject r109 = r210.optJSONObject("ext_data");     // Catch: Throwable -> L10
            if (r109 != null) goto L8;
            r109 = r210;
        L8:
            r108[3] = TuplesKt.to("ext_data", r109);     // Catch: Throwable -> L10
            Map<String, Object> r118 = MapsKt.mapOf(r108);     // Catch: Throwable -> L10
        L11:
            com.bytedance.android.live.core.verify.utils.a.g r119 = r101.f553617n;
            if (r119 == null) goto L39;
            r119.onVerify(r110, r118);
            return;
        L39:
            return;
        L10:
            r118 = null;
            goto L11
        }
    }

    public static final class b implements IHostRealNameAuthorization.BytedCertCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f482756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ILiveFaceCertCallback f482757b;

        @Override // com.bytedance.android.livehostapi.business.IHostRealNameAuthorization.BytedCertCallback
        public final void onVerifyResult(JSONObject r110) {
            Intrinsics.checkNotNullParameter(r110, "data");
            int r100 = gu2.a.f482740a;
            Activity r101 = this.f482756a;
            ILiveFaceCertCallback r102 = this.f482757b;
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r110, "data");
            int r103 = r110.optInt("error_code", -1);
            ALogger.i("face_verify", String.valueOf(r103));
            if (r103 != 0) goto L5;
            f2.c("认证成功！", 0);
        L5:
            JSONObject r104 = r110.optJSONObject("jsonData");
            if (r104 != null) goto L9;
            r104 = r110;
        L9:
            if (r103 != 0) goto L11;
            int r105 = 1;
        L12:
            LiveCertResult r111 = new LiveCertResult(new LiveCertStatus(r105, 0, 0, 6, null), r104.optInt("error_code", -1), r104.optString("error_msg", ""), r110.optString("ticket", ""), r104.optJSONObject("ext_data"));
            if (r102 == null) goto L16;
            r102.onVerifyResult(r111);
            return;
        L16:
            return;
        L11:
            r105 = 0;
            goto L12
        }

        public b(Activity r100, ILiveFaceCertCallback r101) {
            this.f482756a = r100;
            this.f482757b = r101;
        }
    }

    public g() {
    }

    static {
        f482754a = new g();
    }

    public static void a(v80.d r100) {
        Intrinsics.checkNotNullParameter(r100, "verifyParam");
        Context r101 = r100.getContext();
        if (r101 != null) goto L5;
        return;
    L5:
        IHostRealNameAuthorization r102 = (IHostRealNameAuthorization) k.f(IHostRealNameAuthorization.class);
        if (r102 != null) goto L8;
        return;
    L8:
        String r103 = r100.f553610g;
        String r104 = "";
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        String r105 = r100.f553611h;
        if (r105 != null) goto L14;
        r105 = "";
    L14:
        HashMap r106 = new HashMap();
        String r107 = r100.f553593b;
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        r106.put("scene", r107);
        String r108 = r100.f553595d;
        if (r108 != null) goto L20;
        r108 = "";
    L20:
        r106.put("mode", r108);
        String r109 = r100.f553594c;
        if (r109 == null) goto L24;
        r104 = r109;
    L24:
        r106.put("ticket", r104);
        r106.put("cert_app_id", "1128");
        String r110 = r100.f553597f;
        if (r110 != null) goto L27;
        r110 = "false";
    L27:
        r106.put("use_new_api", r110);
        String r111 = r100.f553596e;
        if (r111 == null) goto L30;
        r106.put(BytedCertConstant.CertKey.FLOW, r111);
    L30:
        String r112 = r103;
        r102.doFaceLive(r101, r112, r105, r106, u.a(), new a(r100));
    }

    public static HashMap b(g r100) {
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

    public final void c(Activity r100, HashMap<String, String> r101, ILiveFaceCertCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "dict");
        IHostRealNameAuthorization r103 = (IHostRealNameAuthorization) k.f(IHostRealNameAuthorization.class);
        if (r103 != null) goto L5;
        return;
    L5:
        r103.startBytedCert(r100, r101, b(this), new b(r100, r102));
    }
}
