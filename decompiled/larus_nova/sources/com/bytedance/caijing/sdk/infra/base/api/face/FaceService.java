package com.bytedance.caijing.sdk.infra.base.api.face;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.facelive.jsb.JSBCertPluginPreload$realHandle$1$2$preloadCallback$2;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayDoFaceLive;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u0000 \"2\u00020\u0001:\u0002#$J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H&JX\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0017\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\tH\u0016J\u0012\u0010\u001e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\tH\u0016J\u001c\u0010 \u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0016JX\u0010!\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/face/FaceService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", "ctx", "", "", "initMap", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayDoFaceLive$TTCJPayFaceLiveCallback;", "callback", "", "invokeFace", "Lwe4/a;", "Ltd4/a;", "riskSource", "silentInstall", "newApi", "merchantId", "Lcom/bytedance/caijing/sdk/infra/base/api/face/FaceService$c;", "ui", "", "ensurePluginReady", "Landroid/content/Intent;", "intent", PerfLog.PARAM_KEY_CONTEXT_ID, "isExternalTargetSecure", "", "Landroid/app/Activity;", "getHostActivityStack", "()[Landroid/app/Activity;", "isUserAgreePrivacyPolicy", "isPluginAlready", "text", "makeShowSystemToast", "ensureAliYunPluginReady", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface FaceService extends ICJService {
    public static final a Companion = null;
    public static final String boyLabel = "M";
    public static final String girlLabel = "F";
    public static final String neutralLabel = "H";

    /* JADX INFO: loaded from: classes15.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f202221a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Pair<Integer, String> f202222b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Pair<Integer, String> f202223c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Pair<Integer, String> f202224d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Pair<Integer, String> f202225e = null;

        public a() {
        }

        static {
            f202221a = new a();
            f202222b = new Pair(-10000, "服务正在启动，请稍等");
            f202223c = new Pair(-10001, "宿主没有实现插件确保逻辑");
            f202224d = new Pair(-10002, "获取活体插件包名异常");
            f202225e = new Pair(-10003, "无法使用相机，请检查是否打开相机权限");
        }

        public static JSONObject a(int r100, int r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r103, "errorDetail");
            JSONObject r104 = new JSONObject();
            KtSafeMethodExtensionKt.safePut(r104, "success", Boolean.FALSE);
            KtSafeMethodExtensionKt.safePut(r104, "errorCode", Integer.valueOf(r100));
            KtSafeMethodExtensionKt.safePut(r104, "serverCode", Integer.valueOf(r101));
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            KtSafeMethodExtensionKt.safePut(r104, "errorMsg", r102);
            KtSafeMethodExtensionKt.safePut(r104, "errorDetail", r103);
            KtSafeMethodExtensionKt.safePut(r104, "ticket", "");
            KtSafeMethodExtensionKt.safePut(r104, "jsonData", "");
            return r104;
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public static final class b {
        public static /* synthetic */ void a(FaceService r100, Context r101, JSBCertPluginPreload$realHandle$1$2$preloadCallback$2 r110, String r111, boolean r112, String r113, int r114) {
            if ((r114 & 4) == 0) goto L5;
            r111 = "";
        L5:
            String r102 = r111;
            if ((r114 & 8) == 0) goto L8;
            boolean r103 = false;
        L10:
            if ((r114 & 16) == 0) goto L12;
            boolean r104 = false;
        L14:
            if ((r114 & 32) == 0) goto L16;
            r113 = null;
        L16:
            r100.ensurePluginReady(r101, r110, r102, r103, r104, r113, null);
            return;
        L12:
            r104 = true;
            goto L14
        L8:
            r103 = r112;
            goto L10
        }
    }

    /* JADX INFO: loaded from: classes15.dex */
    public interface c {
    }

    static {
        Companion = a.f202221a;
    }

    void ensureAliYunPluginReady(Context r100, we4.a<td4.a> r101, String r102, boolean r103, boolean r104, String r105, c r106);

    void ensurePluginReady(Context r100, we4.a<td4.a> r101, String r102, boolean r103, boolean r104, String r105, c r106);

    Activity[] getHostActivityStack();

    boolean invokeFace(Context r100, Map<String, String> r101, TTCJPayDoFaceLive.TTCJPayFaceLiveCallback r102);

    boolean isExternalTargetSecure(Intent r100, Context r101);

    boolean isPluginAlready(boolean r100);

    boolean isUserAgreePrivacyPolicy();

    boolean makeShowSystemToast(Context r100, String r101);
}
