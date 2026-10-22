package com.larus.dora.impl;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.account.base.api.ILoginService;
import com.larus.audio.AudioServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.impl.util.DoraResourceUtil;
import com.larus.dora.impl.util.PacificInterfaceManager;
import com.larus.dora.impl.util.r;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.push.api.IPushService;
import com.larus.vesdk.api.IVeSDK;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.SAMICoreWakeupParamRequestCallback;
import com.mammon.audiosdk.enums.SAMICoreDataType;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreFirstWakeupProperty;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.mammon.audiosdk.structures.SAMICoreWakeupFingerprintInitParameter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ugc.effectplatform.algorithm.AlgorithmResourceManager;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class DoraPreWakeUpTask {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f331888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f331889e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicBoolean f331890f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f331891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f331892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicBoolean f331893i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Handler f331894j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CoroutineScope f331895k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy<Keva> f331896l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final MutableSharedFlow<Boolean> f331897m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final MutableSharedFlow f331898n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static CommonDialog f331899o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f331900p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AtomicBoolean f331901q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static boolean f331902r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SAMICore f331903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f331904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f331905c;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/DoraPreWakeUpTask$Companion$NetworkChangeReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class NetworkChangeReceiver extends BroadcastReceiver {
            public NetworkChangeReceiver() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context r100, Intent r101) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                Intrinsics.checkNotNullParameter(r101, "intent");
                if (Intrinsics.areEqual("android.net.conn.CONNECTIVITY_CHANGE", r101.getAction()) == false) goto L20;
                Object r102 = r100.getSystemService("connectivity");     // Catch: Exception -> L15
                Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L15
                NetworkInfo r103 = ((ConnectivityManager) r102).getActiveNetworkInfo();     // Catch: Exception -> L15
                if (r103 == null) goto L9;
                boolean r104 = true;
                if (r103.isConnected() != true) goto L9;
            L10:
                if (r104 == true) goto L12;
                return;
            L12:
                if (kj4.a.g().getDoraBondCount() <= 0) goto L22;
                g49.d.d("DoraPreWakeUpTask", "network connected");     // Catch: Exception -> L15
                int r105 = DoraPreWakeUpTask.f331888d;     // Catch: Exception -> L15
                Companion.l();     // Catch: Exception -> L15
                return;
            L22:
                return;
            L9:
                r104 = false;
            L15:
                e = move-exception;
                g49.d.b("DoraPreWakeUpTask", "NetworkChangeReceiver error:" + e);
                return;
            }
        }

        public static final class a implements SAMICoreWakeupParamRequestCallback {
            public a() {
            }

            @Override // com.mammon.audiosdk.SAMICoreWakeupParamRequestCallback
            public final String onWakeupParamRequest(String r110, int r111) {
                Intrinsics.checkNotNullParameter(r110, "business");
                g49.d.b("DoraPreWakeUpTask", "onWakeupParamRequest: business = " + r110 + ", paramType = " + r111);
                AppHost.Companion r112 = AppHost.f326268a;
                String r100 = null;
                File r101 = r112.getApplication().getExternalFilesDir(null);
                String r102 = "";
                if (r101 == null) goto L6;
                String r103 = r101.getAbsolutePath();
                if (r103 == null) goto L6;
            L7:
                String r104 = r103 + File.separator;
                g49.d.d("DoraPreWakeUpTask", "onWakeupParamRequest: externalFilePath = " + r103 + ", dumpFilePath = " + r104);
                DoraDevice r105 = ak4.a.d().f4000a.A;
                JSONObject r106 = new JSONObject();
                int r107 = DoraPreWakeUpTask.f331888d;
                r106.put("model_md5", Companion.h());
                r106.put("model_path", Companion.j());
                JSONObject r108 = new JSONObject();
                if (r112.a().isAppBackground() == false) goto L10;
                int r113 = 1;
            L11:
                r108.put("app_status", r113);
                r108.put(com.bytedance.android.ec.core.event.a.KEY_DID, com.larus.platform.service.o.f365780a.getDeviceId());
                r108.put("model_info", r106);
                JSONObject r109 = new JSONObject();
                IDoraService r114 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
                if (r114 == null) goto L16;
                SessionService r115 = r114.d();
                if (r115 == null) goto L16;
                String r116 = r115.g("dora_full_duplex");
            L17:
                r109.put("app_key", r116);
                r109.put("audio_format", "speech_opus");
                r109.put("business_type", Companion.g());
                r109.put("token", Companion.k());
                r109.put("token_type", 1);
                r109.put("url", "https://audio.doubao.com/internal");
                if (r105 == null) goto L21;
                String r117 = r105.modelVersion;
                if (r117 == null) goto L21;
            L22:
                r108.put("engine_version", r117);
                if (r105 == null) goto L25;
                String r118 = r105.f204390sn;
            L26:
                if (r118 == null) goto L29;
                r102 = r118;
            L29:
                r108.put("sn", r102);
                if (r105 == null) goto L33;
                String r119 = r105.softVersion;
                if (r119 == null) goto L33;
            L34:
                r108.put("fw_version", r119);
                StringBuilder r120 = new StringBuilder("SAMICoreWakeupParamRequest current: productId=");
                if (r105 == null) goto L37;
                Integer r121 = Integer.valueOf(r105.productId);
            L38:
                r120.append(r121);
                r120.append(", sn=");
                if (r105 == null) goto L41;
                String r122 = r105.f204390sn;
            L42:
                r120.append(r122);
                r120.append(", version=");
                if (r105 == null) goto L45;
                String r123 = r105.softVersion;
            L46:
                r120.append(r123);
                r120.append(", modelVersion=");
                if (r105 == null) goto L49;
                r100 = r105.modelVersion;
            L49:
                r120.append(r100);
                g49.d.d("DoraPreWakeUpTask", r120.toString());
                r108.put("model_info", r106);
                r108.put("server_param", r109);
                r108.put("dump_dir", r104);
                return r108.toString();
            L45:
                r123 = null;
                goto L46
            L41:
                r122 = null;
                goto L42
            L37:
                r121 = null;
            L33:
                r119 = "none";
                goto L34
            L25:
                r118 = null;
            L21:
                r117 = "";
            L16:
                r116 = "";
                goto L17
            L10:
                r113 = 3;
            L6:
                r103 = "";
                goto L7
            }
        }

        /* JADX INFO: loaded from: classes27.dex */
        public static final class b implements IEffectPlatformBaseListener<String[]> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f331906a;

            public b(String r100) {
                this.f331906a = r100;
            }

            @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
            public final void onSuccess(String[] r100) {
                final String[] r101 = r100;
                Intrinsics.checkNotNullParameter(r101, "response");
                Handler r102 = DoraPreWakeUpTask.f331894j;
                final String r103 = this.f331906a;
                r102.post(new p(r101, r103));
            }

            @Override // com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener
            public final void onFail(String[] r100, final ExceptionResult r101) {
                Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
                DoraPreWakeUpTask.f331894j.post(new q(r101));
            }
        }

        public static final void a() {
            int r100 = DoraPreWakeUpTask.f331888d;
            AtomicBoolean r101 = DoraPreWakeUpTask.f331901q;
            if (r101.get() == true) goto L26;
            SAMICoreWakeupFingerprintInitParameter r102 = new SAMICoreWakeupFingerprintInitParameter();
            r102.url = "https://audio.doubao.com/internal";
            r102.businessType = g();
            IDoraService r103 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            String r104 = "";
            if (r103 == null) goto L10;
            SessionService r105 = r103.d();
            if (r105 == null) goto L10;
            String r106 = r105.g("dora_full_duplex");
        L11:
            r102.appKey = r106;
            r102.tokenType = 1;
            r102.token = k();
            StringBuilder r107 = new StringBuilder();
            AppHost.Companion r108 = AppHost.f326268a;
            r107.append(r108.getApplication().getFilesDir());
            r107.append("/wakeup_sid/");
            r102.sid_dir = r107.toString();
            r102.uid = ILoginService.f286097a.getAccountInfo().f531530c;
            DoraDevice r109 = ak4.a.d().f4000a.A;
            if (r109 == null) goto L17;
            String r110 = r109.modelVersion;
            if (r110 == null) goto L17;
            r104 = r110;
        L17:
            r102.fw_engine_version = r104;
            String r111 = AlgorithmResourceManager.Companion.getInstance().getResourceFinder().findResourceUri("db_kws_sid_255");
            if (r111 == null) goto L20;
            String r112 = StringsKt.replace$default(r111, MSkiaImageRegionDecoder.FILE_PREFIX, "", false, 4, null);
        L21:
            r102.model_path = r112;
            int r113 = c68.b.f22600a;
            c68.b.d("zhangerwei", r108.getApplication().getFilesDir() + "/wakeup_sid/");
            if (SAMICore.InitWakeupFingerPrintContext(r102) != 0) goto L25;
            r101.set(true);
            return;
        L25:
            return;
        L20:
            r112 = null;
        L10:
            r106 = "";
            goto L11
        }

        public static final void c() {
            int r100 = DoraPreWakeUpTask.f331888d;
            String r101 = AlgorithmResourceManager.Companion.getInstance().getResourceFinder().findResourceUri("db_lp_kws_255");
            if (r101 == null) goto L5;
            String r102 = StringsKt.replace$default(r101, MSkiaImageRegionDecoder.FILE_PREFIX, "", false, 4, null);
        L6:
            DoraPreWakeUpTask.f331891g = r102;
            if (r102 != null) goto L9;
            boolean r103 = false;
        L10:
            g49.d.d("DoraPreWakeUpTask", "model [" + DoraPreWakeUpTask.f331891g + "] exist: " + r103);
            Keva r104 = DoraConfig.f331707a;
            r104.storeBoolean("key_pre_wake_up_model_ready", r103);
            r104.storeBoolean("key_pre_wake_up_enable", r103);
            if (r103 == false) goto L14;
            BuildersKt.launch$default(DoraPreWakeUpTask.f331895k, null, null, new DoraPreWakeUpTask$Companion$setModelPathPropertyAsync$1(null), 3, null);
            return;
        L14:
            return;
        L9:
            String r105 = DoraPreWakeUpTask.f331891g;
            Intrinsics.checkNotNull(r105);
            r103 = new PolarisFileWrapper(r105).exists();
            goto L10
        L5:
            r102 = null;
            goto L6
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.dora.impl.l] */
        public static void d() {
            com.larus.dora.impl.util.b0 r100 = com.larus.dora.impl.util.b0.f338123a;
            String r101 = ILoginService.f286097a.getAccountInfo().f531530c;
            r100.getClass();
            if (com.larus.dora.impl.util.b0.t(r101) == false) goto L6;
            g49.d.d("DoraPreWakeUpTask", "checkToShowDialog multiuserMode true, not need to show");
            return;
        L6:
            ?? r102 = new l();
            CommonDialog.a r103 = new CommonDialog.a();
            int r104 = com.larus.utils.j0.f375426a;
            r103.i(com.larus.utils.j0.d(R.string.larus_dora_fingerprint_push_title_cn));
            r103.g(com.larus.utils.j0.d(R.string.larus_dora_fingerprint_push_desc_cn));
            boolean r105 = false;
            CommonDialog.a.f(r103, new y(r102), com.larus.utils.j0.d(R.string.larus_dora_fingerprint_alert_confirm_cn), false, 12);
            AppHost.Companion r106 = AppHost.f326268a;
            FragmentActivity r107 = null;
            com.larus.common_ui.dialog.f0 r108 = new com.larus.common_ui.dialog.f0(null, Integer.valueOf(ContextCompat.getColor(r106.getApplication(), R.color.larus_primary_50)), null, 5);
            Intrinsics.checkNotNullParameter(r108, "commonDialogTextStyleConfig");
            r103.D = r108;
            CommonDialog.a.e(r103, new z(r102), com.larus.utils.j0.d(R.string.larus_dora_fingerprint_alert_cancel_cn), 4);
            a0 r109 = new a0();
            Intrinsics.checkNotNullParameter(r109, "listener");
            r103.f327195x = r109;
            CommonDialog r110 = r103.a();
            DoraPreWakeUpTask.f331899o = r110;
            if (r110.isVisible() != true) goto L9;
            boolean r111 = true;
        L10:
            if (r111 == true) goto L36;
            Activity r112 = r106.a().getCurrentActivity();
            if ((r112 instanceof FragmentActivity) == false) goto L14;
            r107 = (FragmentActivity) r112;
        L14:
            if (r107 == null) goto L37;
            CommonDialog r113 = DoraPreWakeUpTask.f331899o;
            if (r113 != null) goto L18;
        L20:
            if (r105 == false) goto L23;
            return;
        L23:
            if (r107.getSupportFragmentManager().findFragmentByTag("DoraPreWakeUpTask") != null) goto L40;
            CommonDialog r114 = DoraPreWakeUpTask.f331899o;
            if (r114 == null) goto L38;
            FragmentManager r115 = r107.getSupportFragmentManager();
            LandscapeRestrictionOperation r116 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r114, "DoraPreWakeUpTask", r116);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r115, r114, r116) == true) goto L41;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L33
        L31:
            r114.show(r115, "DoraPreWakeUpTask");
            return;
        L41:
            return;
        L38:
            return;
        L40:
            return;
        L18:
            if (r113.isAdded() != true) goto L20;
            r105 = true;
            goto L20
        L37:
            return;
        L36:
            return;
        L9:
            r111 = false;
            goto L10
        }

        public static void e() {
            DoraResourceUtil r100 = DoraResourceUtil.f338111a;
            String r101 = DoraResourceUtil.g();
            g49.d.d("DoraPreWakeUpTask", "start downloadModel");
            AtomicBoolean r102 = DoraPreWakeUpTask.f331890f;
            if (r102.get() == false) goto L6;
            g49.d.d("DoraPreWakeUpTask", "downloadModel, isDownloading");
            return;
        L6:
            boolean r103 = NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication());
            g49.d.d("DoraPreWakeUpTask", "downloadModel, isNetworkAvailable: " + r103);
            if (r103 == true) goto L10;
            PacificInterfaceManager.d(false);
            return;
        L10:
            AlgorithmResourceManager r104 = f();
            if (r104 != null) goto L13;
            return;
        L13:
            r102.set(true);
            DoraPreWakeUpTask.f331892h = SystemClock.elapsedRealtime();
            r104.fetchResourcesWithModelNames(0, new String[]{"db_lp_first_kws", "db_lp_kws_255", "db_kws_sid_255"}, new com.ss.ugc.effectplatform.a(), new b(r101));
        }

        public static AlgorithmResourceManager f() {
            AlgorithmResourceManager.Companion r100 = AlgorithmResourceManager.Companion;     // Catch: Exception -> L16
            if (r100.isInitialized() == true) goto L6;
            g49.d.e("DoraPreWakeUpTask", "AlgorithmResourceManager not initialized, try init");     // Catch: Exception -> L16
            IVeSDK r101 = (IVeSDK) ServiceManager.get().getService(IVeSDK.class);     // Catch: Exception -> L16
            if (r101 == null) goto L11;
            r101.e();     // Catch: Exception -> L16
        L11:
            if (r100.isInitialized() == true) goto L20;
            g49.d.b("DoraPreWakeUpTask", "AlgorithmResourceManager still not initialized");     // Catch: Exception -> L16
            return null;
        L20:
            return r100.getInstance();
        L6:
            return r100.getInstance();
        L16:
            e = move-exception;
            g49.d.b("DoraPreWakeUpTask", "getAlgorithmResourceManagerOrNull failed: " + e.getMessage());
            return null;
        }

        public static String h() {
            String r100 = DoraPreWakeUpTask.f331891g;
            if (r100 == null) goto L7;
            String r101 = new PolarisFileWrapper(r100).getName();
            Intrinsics.checkNotNull(r101);
            if (StringsKt.contains$default(r101, "md5", false, 2, null) == false) goto L7;
            return StringsKt.take(StringsKt.substringAfter$default(r101, "md5", null, 2, null), 32);
        L7:
            return "";
        }

        public static String j() {
            g49.d.d("DoraPreWakeUpTask", "return modelPath " + DoraPreWakeUpTask.f331891g);
            return DoraPreWakeUpTask.f331891g;
        }

        public static String k() {
            AccountService r100 = AccountService.f365697a;
            if (r100.isLogin().booleanValue() == false) goto L5;
            Map r101 = MapsKt.mapOf(new Pair[]{TuplesKt.to("Passport-Auth", AppbrandHostConstants.SCHEMA_INSPECT.SESSION), TuplesKt.to("sdk-version", "2"), TuplesKt.to("X-tt-Token", String.valueOf(r100.getXTTToken()))});
        L6:
            JSONObject r102 = new JSONObject();
            Iterator r103 = r101.entrySet().iterator();
        L8:
            if (r103.hasNext() == false) goto L11;
            Map.Entry r104 = (Map.Entry) r103.next();
            r102.put((String) r104.getKey(), (String) r104.getValue());
            goto L8
        L11:
            return r102.toString();
        L5:
            r101 = MapsKt.emptyMap();
            goto L6
        }

        public static void l() {
            DoraPreWakeUpTask.f331894j.post(new n());
        }

        public static void m() {
            BuildersKt.launch$default(DoraPreWakeUpTask.f331895k, null, null, new DoraPreWakeUpTask$Companion$updateWakeupHandler$1(null), 3, null);
        }

        public static String g() {
            boolean r100 = false;
            DoraDevice r101 = DoraAdapterExtKt.i(kj4.a.g(), false);
            if (r101 != null) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == false) goto L31;
            Intrinsics.checkNotNullParameter(r101, "<this>");
            if (r101.productId != ProductNameType.H_FREE_BUDS_PRO_5.f204375id) goto L12;
            boolean r103 = true;
        L13:
            if (r103 == false) goto L16;
            return "ExternalH_Sax";
        L16:
            Intrinsics.checkNotNullParameter(r101, "<this>");
            if (r101.productId != ProductNameType.H_GUITAR.f204375id) goto L19;
            boolean r104 = true;
        L20:
            if (r104 == false) goto L23;
            return "ExternalH_Guitar";
        L23:
            Intrinsics.checkNotNullParameter(r101, "<this>");
            if (r101.productId != ProductNameType.H_DOLPHIN.f204375id) goto L26;
            r100 = true;
        L26:
            if (r100 == false) goto L29;
            return "ExternalH_Dolphin";
        L29:
            return "ExternalH";
        L19:
            r104 = false;
            goto L20
        L12:
            r103 = false;
            goto L13
        L31:
            if (r101 == null) goto L33;
            Integer r105 = Integer.valueOf(r101.productId);
        L35:
            if (o59.a.o(r105) == false) goto L37;
            return "DoraG";
        L37:
            if (r101 != null) goto L39;
        L41:
            if (r100 == false) goto L43;
            return "DoraE";
        L43:
            return DoraObricDeviceHomeViewModel.DEFAULT_DEVICE_NAME;
        L39:
            if (r101.productId != ProductNameType.DORA_E.f204375id) goto L41;
            r100 = true;
            goto L41
        L33:
            r105 = null;
            goto L35
        L5:
            if (o59.a.r(r101) != true) goto L7;
            r102 = true;
            goto L8
        }

        public Companion() {
        }

        public static String i(String r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            String r101 = new PolarisFileWrapper(r100).getName();
            Intrinsics.checkNotNull(r101);
            if (StringsKt.contains$default(r101, "md5", false, 2, null) == true) goto L7;
            return "";
        L7:
            return StringsKt.take(StringsKt.substringAfter$default(r101, "md5", null, 2, null), 32);
        }

        public static final void b(boolean r100, long r101) {
            int r102 = DoraPreWakeUpTask.f331888d;
            DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "wakeup_download_algorithm_time", MapsKt.mapOf(new Pair[]{TuplesKt.to("success", Integer.valueOf(r100 ? 1 : 0)), TuplesKt.to("duration", Long.valueOf(r101)), TuplesKt.to("type", 1), TuplesKt.to(EventConstant.Value.RETRY, 3)}), false, 12);
        }
    }

    public static final class a extends com.larus.dora.impl.util.r0 {
        public a() {
        }

        @Override // com.larus.dora.impl.util.r0, mj4.h
        public final void a1(DoraDevice r100, mj4.b r101) {
            Intrinsics.checkNotNullParameter(r101, "state");
            g49.d.d("DoraPreWakeUpTask", "onIdleStateChanged state: " + r101.f514221a);
            int r102 = DoraPreWakeUpTask.f331888d;
            DoraPreWakeUpTask.f331888d = r101.f514221a;
            int r103 = DoraPreWakeUpTask.f331888d;
            Companion.m();
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b implements b59.b {
        public b() {
        }

        @Override // b59.b
        public final void c(byte[] r100) {
        }

        @Override // b59.b
        public final void d(int r100) {
            if (r100 != 3) goto L14;
            g49.d.d("DoraPreWakeUpTask", "play done");
            int r101 = DoraPreWakeUpTask.f331888d;
            AppHost.Companion r102 = AppHost.f326268a;
            if (r102.a().isAppBackground() == false) goto L11;
            DoraPreWakeUpTask.f331900p = true;
            Activity r103 = (Activity) CollectionsKt.lastOrNull(r102.a().g());
            if (r103 == null) goto L12;
            Class<?> r104 = r103.getClass();
            Intent r105 = new Intent(r102.getApplication(), r104);
            r105.addFlags(131072);
            IPushService r106 = (IPushService) ServiceManager.get().getService(IPushService.class);
            if (r106 == null) goto L12;
            Application r107 = r102.getApplication();
            int r108 = com.larus.utils.j0.f375426a;
            r106.b(r107, r105, new ms9.a(com.larus.utils.j0.d(R.string.larus_dora_fingerprint_push_title_cn), com.larus.utils.j0.d(R.string.larus_dora_fingerprint_push_desc_cn), "", 33553267));
        L12:
            DoraPreWakeUpTask.f331902r = false;
            return;
        L11:
            Companion.d();
            goto L12
        }
    }

    static {
        new Companion();
        f331889e = new a();
        f331890f = new AtomicBoolean(false);
        f331893i = new AtomicBoolean(false);
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("DoraPreWakeUpTaskThread");
        ThreadMethodProxy.start(r100);
        f331894j = new Handler(r100.getLooper());
        f331895k = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        f331896l = LazyKt.lazy(new j());
        MutableSharedFlow<Boolean> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        f331897m = r101;
        f331898n = r101;
        f331901q = new AtomicBoolean(false);
    }

    public final void a() {
        BuildersKt.launch$default(this.f331905c, null, null, new DoraPreWakeUpTask$destroy$1(this, null), 3, null);
    }

    public final void e() {
        Integer r100 = this.f331904b;
        if (r100 != null) goto L6;
    L7:
        g49.d.b("DoraPreWakeUpTask", "stop, lastSamiRet != SAMICoreCode.SAMI_OK");
        a();
        return;
    L6:
        if (r100.intValue() != 0) goto L7;
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICore r102 = this.f331903a;
        if (r102 == null) goto L12;
        Integer r103 = Integer.valueOf(r102.SAMICoreGetPropertyById(SAMICorePropertyId.SAMICorePropertyId_LP_KWS_Result, r101));
    L13:
        this.f331904b = r103;
        if (r103 != null) goto L17;
    L18:
        g49.d.b("DoraPreWakeUpTask", "stop SAMICoreGetPropertyById failed, ret " + this.f331904b);
        Integer r104 = this.f331904b;
        if (r104 != null) goto L22;
    L24:
        c(10, "");
    L25:
        a();
        return;
    L22:
        if (r104.intValue() != 100011) goto L24;
        c(11, "");
        goto L25
    L17:
        if (r103.intValue() != 0) goto L18;
        g49.d.d("DoraPreWakeUpTask", "stop SAMICoreGetPropertyById success");
        if (r101.type == SAMICoreDataType.SAMICoreDataType_String) goto L30;
        g49.d.b("DoraPreWakeUpTask", "stop coreProperty.type != SAMICoreDataType.SAMICoreDataType_String, " + r101.type);
    L48:
        a();
        return;
    L30:
        if (r101.dataArrayLen >= 1) goto L33;
        g49.d.b("DoraPreWakeUpTask", "stop coreProperty.dataArrayLen " + r101.dataArrayLen + " < 1");
        c(3, "");
        a();
        return;
    L33:
        String r105 = r101.dataObjectArray[0].toString();
        g49.d.d("DoraPreWakeUpTask", "SAMICoreGetPropertyById result " + r105);
        JSONObject r106 = new JSONObject(r105);     // Catch: JSONException -> L44
        g49.d.a("DoraPreWakeUpTask", "resultJson " + r106);     // Catch: JSONException -> L44
        boolean r107 = JSONObjectProtectorUtils.getBoolean(r106, "result");     // Catch: JSONException -> L44
        String r108 = JSONObjectProtectorUtils.getString(r106, "keywords");     // Catch: JSONException -> L44
        g49.d.d("DoraPreWakeUpTask", "get wakeupResult " + r107);     // Catch: JSONException -> L44
        if (r107 == true) goto L38;
        Intrinsics.checkNotNull(r108);     // Catch: JSONException -> L44
        c(1, r108);     // Catch: JSONException -> L44
        a();     // Catch: JSONException -> L44
        return;
    L38:
        boolean r109 = JSONObjectProtectorUtils.getBoolean(r106, "sid_verify_result");     // Catch: JSONException -> L44
        g49.d.d("DoraPreWakeUpTask", "get voicePrintResult " + r109);     // Catch: JSONException -> L44
        if (r109 == false) goto L42;
        Intrinsics.checkNotNull(r108);     // Catch: JSONException -> L44
        c(0, r108);     // Catch: JSONException -> L44
        a();     // Catch: JSONException -> L44
        return;
    L42:
        Intrinsics.checkNotNull(r108);     // Catch: JSONException -> L44
        b(r108);     // Catch: JSONException -> L44
    L44:
        e = move-exception;
        c(2, "");
        g49.d.c("DoraPreWakeUpTask", "get wakeupResult exception", e);
        a();
        return;
    L12:
        r103 = null;
        goto L13
    }

    public DoraPreWakeUpTask() {
        this.f331904b = 0;
        this.f331905c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    public final void b(String r110) {
        com.larus.dora.impl.util.b0 r100 = com.larus.dora.impl.util.b0.f338123a;
        String r101 = ILoginService.f286097a.getAccountInfo().f531530c;
        r100.getClass();
        boolean r102 = com.larus.dora.impl.util.b0.t(r101);
        g49.d.d("DoraPreWakeUpTask", "multiuserMode " + r102);
        if (r102 == false) goto L6;
        c(0, r110);
        return;
    L6:
        String r103 = "";
        c(1, "");
        long r104 = SystemClock.elapsedRealtime();
        Lazy<Keva> r105 = f331896l;
        long r106 = r105.getValue().getLong("DoraPreWakeUpTask_LastVoicePrintNotMatchTime", 0);
        r105.getValue().storeLong("DoraPreWakeUpTask_LastVoicePrintNotMatchTime", r104);
        if ((r104 - r106) <= 10000) goto L11;
        g49.d.d("DoraPreWakeUpTask", "voicePrintNotMatchTime duration > 10s");
        return;
    L11:
        if (f331902r == false) goto L13;
        return;
    L13:
        f331902r = true;
        b r111 = new b();
        int r107 = com.larus.utils.j0.f375426a;
        String r108 = com.larus.utils.j0.d(R.string.larus_dora_fingerprint_tts_play_cn);
        Object r109 = ServiceManager.get().getService(IDoraService.class);
        String r112 = null;
        if ((r109 instanceof DoraServiceImpl) == false) goto L16;
        DoraServiceImpl r113 = (DoraServiceImpl) r109;
    L17:
        if (r113 == null) goto L21;
        BotModel r114 = r113.F;
        if (r114 == null) goto L21;
        SpeakerVoice r115 = r114.getVoiceType();
    L22:
        if (r115 == null) goto L25;
        String r116 = r.a(r115);
        if (r116 == null) goto L25;
    L26:
        if (r115 == null) goto L28;
        r112 = r115.getAudioMetrics();
    L28:
        if (r112 == null) goto L31;
        r103 = r112;
    L31:
        String r117 = String.valueOf(AudioServiceDelegate.f288288a.a0().b());
        g49.d.d("DoraPreWakeUpTask", "playTTS: " + r108 + ", " + r116);
        b59.a r118 = b59.a.b.f17787a;
        ((CopyOnWriteArraySet) r118.f17783a).add(r111);
        r118.a(r108, r116, r103, r117);
        return;
    L25:
        r116 = "BV001_streaming";
    L21:
        r115 = null;
        goto L22
    L16:
        r113 = null;
        goto L17
    }

    public final Integer d(SAMICoreFirstWakeupProperty r100) {
        Intrinsics.checkNotNullParameter(r100, "wakeupProperty");
        g49.d.d("DoraPreWakeUpTask", "setFirstWakeupInfo, cred = " + r100.type + ", trace = " + r100.traceback);
        SAMICoreProperty r101 = new SAMICoreProperty();
        SAMICorePropertyId r102 = SAMICorePropertyId.SAMICorePropertyId_First_Wakeup_Info;
        r101.f384359id = r102;
        r101.setDataType(504);
        r101.dataObjectArray = new SAMICoreFirstWakeupProperty[]{r100};
        r101.dataArrayLen = 1;
        SAMICore r103 = this.f331903a;
        if (r103 == null) goto L5;
        Integer r104 = Integer.valueOf(r103.SAMICoreSetProperty(r102, r101));
    L6:
        Integer r105 = this.f331904b;
        if (r105 != null) goto L10;
    L11:
        g49.d.b("DoraPreWakeUpTask", "SAMICoreSetProperty SAMICorePropertyId_First_Wakeup_Info failed, ret " + this.f331904b);
    L12:
        return r104;
    L10:
        if (r105.intValue() == 0) goto L12;
    L5:
        r104 = null;
        goto L6
    }

    public static void c(int r100, String r101) {
        kj4.a r102 = kj4.a.g();
        Intrinsics.checkNotNull(r102);
        DoraDevice r103 = DoraAdapterExtKt.i(r102, false);
        StringBuilder r104 = new StringBuilder("sendWakeupResult current(false): resultCode=");
        r104.append(r100);
        r104.append(", productId=");
        String r105 = null;
        if (r103 == null) goto L5;
        Integer r106 = Integer.valueOf(r103.productId);
    L6:
        r104.append(r106);
        r104.append(", sn=");
        if (r103 == null) goto L9;
        String r107 = r103.f204390sn;
    L10:
        r104.append(r107);
        r104.append(", version=");
        if (r103 == null) goto L13;
        String r108 = r103.softVersion;
    L14:
        r104.append(r108);
        r104.append(", modelVersion=");
        if (r103 == null) goto L17;
        r105 = r103.modelVersion;
    L17:
        r104.append(r105);
        g49.d.d("DoraPreWakeUpTask", r104.toString());
        if (r102.getDoraLinkState(r103) != 2) goto L20;
        g49.d.d("DoraPreWakeUpTask", "syncVUIPreWakeUp ret " + kj4.a.g().syncVUIPreWakeUp(r100, r101));
    L20:
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "d_vui_prewakeup", MapsKt.mapOf(TuplesKt.to("pre_code", Integer.valueOf(r100))), false, 12);
        return;
    L13:
        r108 = null;
        goto L14
    L9:
        r107 = null;
        goto L10
    L5:
        r106 = null;
        goto L6
    }
}
