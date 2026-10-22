package rv5;

import android.text.TextUtils;
import com.baidu.platform.comapi.map.NodeType;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.falconx.statistic.Common;
import com.bytedance.falconx.statistic.InterceptorModel;
import com.bytedance.falconx.statistic.StatisticData;
import com.bytedance.geckox.logger.GeckoLogger;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.tencent.connect.common.Constants;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import nv5.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile d f539484c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f539485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f539486b;

    public class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "StatisticThread$1");
            ThreadMethodProxy.setName(r101, "falconx-io-thread");
            ThreadMethodProxy.setPriority(r101, 3);
            return r101;
        }
    }

    public d() {
        this.f539485a = PThreadExecutorsUtils.newSingleThreadExecutor(new a());
    }

    public static void b(InterceptorModel r100, Common r101) throws Exception {
        JSONObject r102 = new JSONObject();
        r102.put("params_for_special", "gecko");
        String r103 = r100.pageUrl;
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102.put("page_url", r103);
        String r105 = r100.resRootDir;
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r102.put("res_root_dir", r105);
        String r106 = r100.url;
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        r102.put("resource_url", r106);
        String r107 = r100.offlineRule;
        if (r107 == null) goto L15;
        r104 = r107;
    L15:
        r102.put("offline_rule", r104);
        r102.put("mime_type", r100.mimeType);
        r102.put("offline_status", r100.offlineStatus);
        Long r108 = r100.offlineDuration;
        long r109 = 0;
        if (r108 != null) goto L18;
        long r110 = 0;
    L19:
        r102.put("offline_duration", r110);
        Long r111 = r100.onlineDuration;
        if (r111 != null) goto L22;
        long r112 = 0;
    L23:
        r102.put("online_duration", r112);
        r102.put("app_version", r101.appVersion);
        r102.put("sdk_version", r101.sdkVersion);
        Long r113 = r100.pkgVersion;
        if (r113 == null) goto L27;
        r109 = r113.longValue();
    L27:
        r102.put("pkg_version", r109);
        r102.put("access_key", r100.accessKey);
        r102.put("channel", r100.channel);
        r102.put("os", r101.f243225os);
        r102.put("device_id", r101.deviceId);
        r102.put("device_model", r101.deviceModel);
        r102.put(EffectConfiguration.KEY_REGION, r101.region);
        r102.put(TTVideoEngineInterface.PLAY_API_KEY_AC, r100.f243226ac);
        r102.put("err_code", r100.errCode);
        r102.put(LocationMonitorConst.ERR_MSG, r100.errMsg);
        r102.put("log_id", r100.logId);
        return;
    L22:
        r112 = r111.longValue();
        goto L23
    L18:
        r110 = r108.longValue();
        goto L19
    }

    public static void a(d r100, String r101, String r102, String r103, InterceptorModel r104) {
        r100.getClass();
    L22:
        th = move-exception;
        GeckoLogger.w("falconx-report:", th);
        return;
    L4:
        if (TextUtils.isEmpty(r100.f539486b.f520885i) == true) goto L27;
        if (r104 == null) goto L28;
        StatisticData r105 = new StatisticData();     // Catch: Throwable -> L22
        Common r106 = new Common();     // Catch: Throwable -> L22
        r105.mCommon = r106;     // Catch: Throwable -> L22
        r106.appVersion = r101;     // Catch: Throwable -> L22
        r106.deviceId = r102;     // Catch: Throwable -> L22
        r106.region = r103;     // Catch: Throwable -> L22
        String r107 = UUID.randomUUID().toString();     // Catch: Throwable -> L22
        r104.startTime = 0;     // Catch: Throwable -> L22
        r104.logId = r107;     // Catch: Throwable -> L22
        b r108 = r100.f539486b.f520883g;     // Catch: Throwable -> L22
        if (r108 == null) goto L29;
        b(r104, r105.mCommon);     // Catch: Throwable -> L22
        if ((r108 instanceof rv5.a) == true) goto L12;
        return;
    L12:
        if (r104.offlineStatus.intValue() != 1) goto L31;
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L22
        r109.put("aid", String.valueOf(0));     // Catch: Throwable -> L22
        r109.put("gecko_sdk_version", "5.5.3");     // Catch: Throwable -> L22
        r109.put("access_key", r104.accessKey);     // Catch: Throwable -> L22
        r109.put("channel", r104.channel);     // Catch: Throwable -> L22
        r109.put(Constants.PACKAGE_ID, r104.pkgVersion);     // Catch: Throwable -> L22
        r109.put("from", "1");     // Catch: Throwable -> L22
        r109.put("isCombo", r104.isCombo);     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r104.channel) == false) goto L16;
    L20:
        r109.put("offline_rule", r104.offlineRule);     // Catch: Throwable -> L22
        new JSONObject().put("read_duration", r104.offlineDuration);     // Catch: Throwable -> L22
        String.valueOf(NodeType.E_STREET_POI);     // Catch: Throwable -> L22
        ((rv5.a) r108).a();     // Catch: Throwable -> L22
        return;
    L16:
        if (TextUtils.isEmpty(r104.url) == true) goto L20;
        String[] r110 = r104.url.split(r104.channel + HTTP.URL_DEFAULT);     // Catch: Throwable -> L22
        if (r110.length != 2) goto L20;
        r109.put("path", r110[1]);     // Catch: Throwable -> L22
        goto L20
    L31:
        return;
    L29:
        return;
    L28:
        return;
    }
}
