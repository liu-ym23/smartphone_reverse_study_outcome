package com.larus.common.mssdk.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.os.SystemClock;
import android.util.EventsUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import bp7.d;
import com.bytedance.keva.Keva;
import com.bytedance.mobsec.metasec.ml.MSConfig;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.ttcnpa.TTCNPA;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ixigua.lib.track.TrackParams;
import com.larus.account.base.api.ILoginService;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.common.audit.SecurityAuditStage;
import com.larus.common.mssdk.api.IAppOpsService;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.SpanableDialog;
import com.larus.common_ui.dialog.i1;
import com.larus.network.HttpConst;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.k3;
import com.larus.platform.service.m2;
import com.larus.platform.service.s;
import com.larus.settings.value.e10;
import com.larus.settings.value.f3;
import com.larus.settings.value.lg;
import com.larus.settings.value.m00;
import com.larus.utils.j0;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import t09.b;
import zv9.c;
import zv9.o;
import zv9.r;
import zv9.t;
import zv9.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001(\b\u0007\u0018\u0000 ¦\u00012\u00020\u0001:\u0002¦\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020,H\u0016J \u0010-\u001a\u00020\n2\u0006\u0010+\u001a\u00020,2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0018\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u000203H\u0016J \u00104\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000103\u0012\u0006\u0012\u0004\u0018\u000103052\u0006\u00106\u001a\u000203H\u0016J\b\u00107\u001a\u00020\nH\u0016J\b\u00108\u001a\u000209H\u0016J\n\u0010:\u001a\u0004\u0018\u00010;H\u0016J \u0010<\u001a\u00020\n2\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u0002032\u0006\u0010=\u001a\u00020\u0005H\u0002J\b\u0010>\u001a\u00020\nH\u0002J\u0018\u0010?\u001a\u00020\n2\u0006\u0010@\u001a\u0002032\u0006\u0010A\u001a\u000203H\u0002J\b\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020\nH\u0002J\u0014\u0010E\u001a\u0004\u0018\u0001032\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J\b\u0010H\u001a\u00020\u0005H\u0016J\b\u0010I\u001a\u000203H\u0016J\u001e\u0010J\u001a\u00020\n2\u0006\u0010K\u001a\u00020L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010N\u001a\u00020\u0005H\u0016J\u0018\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\u0005H\u0016J\u0018\u0010R\u001a\u00020\n2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u000203H\u0016J\b\u0010V\u001a\u00020\nH\u0002J\u0010\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020GH\u0016J\u0010\u0010Y\u001a\u00020\n2\u0006\u0010X\u001a\u00020GH\u0016J\u0010\u0010Z\u001a\u00020\u00052\u0006\u0010[\u001a\u00020\u0017H\u0002J\u0018\u0010\\\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u00182\u0006\u0010^\u001a\u000209H\u0002J\u0010\u0010_\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u0018H\u0002J\u0010\u0010`\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u0018H\u0002J\u0010\u0010a\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u0018H\u0002J\u0018\u0010b\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u00182\u0006\u0010^\u001a\u000209H\u0002J\b\u0010c\u001a\u00020\nH\u0002J\u0010\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020fH\u0002J\u0010\u0010g\u001a\u00020\n2\u0006\u0010e\u001a\u00020fH\u0002J\u0010\u0010h\u001a\u00020\n2\u0006\u0010e\u001a\u00020fH\u0002J\b\u0010i\u001a\u00020\nH\u0002J\b\u0010j\u001a\u00020\nH\u0002J\u0010\u0010k\u001a\u00020\n2\u0006\u0010]\u001a\u00020\u0018H\u0002J \u0010l\u001a\u00020\n2\b\u0010m\u001a\u0004\u0018\u0001032\f\u0010n\u001a\b\u0012\u0004\u0012\u0002030oH\u0016J\b\u0010p\u001a\u00020\nH\u0016J\u0010\u0010q\u001a\u00020\u00052\u0006\u0010r\u001a\u00020\u0017H\u0016J\u0012\u0010s\u001a\u00020\n2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\b\u0010v\u001a\u00020\nH\u0016J\b\u0010w\u001a\u00020\u0005H\u0016J\b\u0010x\u001a\u00020yH\u0016J\u0010\u0010z\u001a\u00020\n2\u0006\u0010X\u001a\u00020{H\u0002J\u0010\u0010|\u001a\u00020\n2\u0006\u0010}\u001a\u00020\rH\u0016J\u0010\u0010~\u001a\u00020\n2\u0006\u0010}\u001a\u00020\rH\u0016J\b\u0010\u007f\u001a\u00020\nH\u0016J\u0011\u0010Q\u001a\u00020\n2\u0007\u0010S\u001a\u00030\u0080\u0001H\u0016J\t\u0010\u0081\u0001\u001a\u00020\u0005H\u0016J\u0014\u0010\u0082\u0001\u001a\u00020\u00052\t\u0010\u0083\u0001\u001a\u0004\u0018\u000103H\u0016J-\u0010\u0084\u0001\u001a\u00020\n2\u0007\u0010\u0083\u0001\u001a\u0002032\b\u00102\u001a\u0004\u0018\u0001032\u000f\u0010\u0085\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010G0\bH\u0016J\u0016\u0010\u0086\u0001\u001a\u0004\u0018\u0001032\t\u0010\u0083\u0001\u001a\u0004\u0018\u000103H\u0016J\t\u0010\u0087\u0001\u001a\u00020\u0005H\u0016J\u0011\u0010\u0088\u0001\u001a\u00020\n2\u0006\u00101\u001a\u00020,H\u0016J\t\u0010\u0089\u0001\u001a\u00020\nH\u0016J\t\u0010\u008a\u0001\u001a\u00020\u0005H\u0016J\u0012\u0010\u008b\u0001\u001a\u00020\u00052\u0007\u0010\u0083\u0001\u001a\u000203H\u0016J\t\u0010\u008c\u0001\u001a\u000203H\u0016J\u0018\u0010\u008d\u0001\u001a\u00020\n2\r\u0010\u008e\u0001\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J:\u0010\u008f\u0001\u001a\u00020\n2\u0007\u0010\u0090\u0001\u001a\u0002032&\u0010\u0091\u0001\u001a!\u0012\u0016\u0012\u00140\u0005¢\u0006\u000f\b\u0093\u0001\u0012\n\b\u0094\u0001\u0012\u0005\b\b(\u0095\u0001\u0012\u0004\u0012\u00020\n0\u0092\u0001H\u0016J\u0012\u0010\u0096\u0001\u001a\u00020\u00052\u0007\u0010\u0090\u0001\u001a\u000203H\u0016JC\u0010\u0097\u0001\u001a\u00020\n2\u0007\u0010\u0090\u0001\u001a\u0002032\u0007\u0010\u0098\u0001\u001a\u00020\u00052&\u0010\u0091\u0001\u001a!\u0012\u0016\u0012\u00140\u0005¢\u0006\u000f\b\u0093\u0001\u0012\n\b\u0094\u0001\u0012\u0005\b\b(\u0095\u0001\u0012\u0004\u0012\u00020\n0\u0092\u0001H\u0002J\u0011\u0010\u0099\u0001\u001a\u00020\n2\u0006\u00102\u001a\u000203H\u0016J\u0012\u0010\u009a\u0001\u001a\u00020\n2\u0007\u0010\u009b\u0001\u001a\u000203H\u0016Jf\u0010\u009c\u0001\u001a\u00020\n2\u0006\u00102\u001a\u0002032\u0007\u0010\u009d\u0001\u001a\u0002032\u0007\u0010\u009e\u0001\u001a\u0002032\u0007\u0010\u009f\u0001\u001a\u00020\u00052\u0007\u0010 \u0001\u001a\u00020\u00052\u0007\u0010¡\u0001\u001a\u0002092\u0007\u0010¢\u0001\u001a\u0002092\u0007\u0010£\u0001\u001a\u0002032\u0007\u0010¤\u0001\u001a\u0002032\u000b\b\u0002\u0010¥\u0001\u001a\u0004\u0018\u000103H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0014\u001a\u0004\b\u001f\u0010 R#\u0010\"\u001a\n \u001e*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0014\u001a\u0004\b$\u0010%R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)¨\u0006§\u0001"}, d2 = {"Lcom/larus/common/mssdk/impl/SecurityServiceImpl;", "Lcom/larus/common/mssdk/api/SecurityService;", "<init>", "()V", "isTtcnpaInitialized", XmlPullParser.NO_NAMESPACE, "isTtcnpaInitializing", "pendingTtcnpaTasks", XmlPullParser.NO_NAMESPACE, "Lkotlin/Function0;", XmlPullParser.NO_NAMESPACE, "basicModeListeners", "Ljava/util/ArrayList;", "Lcom/larus/common/mssdk/api/SecurityService$BasicModeListener;", "Lkotlin/collections/ArrayList;", "basicModeConfig", "Lcom/larus/settings/provider/security/ApiCallConfig;", "getBasicModeConfig", "()Lcom/larus/settings/provider/security/ApiCallConfig;", "basicModeConfig$delegate", "Lkotlin/Lazy;", "freqInfoCheckList", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "Lcom/larus/common/mssdk/impl/FreqInfo;", "freqInfoFileCache", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "netPermission", "repo", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getRepo", "()Lcom/bytedance/keva/Keva;", "repo$delegate", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "didListener", "com/larus/common/mssdk/impl/SecurityServiceImpl$didListener$1", "Lcom/larus/common/mssdk/impl/SecurityServiceImpl$didListener$1;", "msInit", "appContext", "Landroid/content/Context;", "initMsInternal", "isLogin", "privacyAccepted", "msReport", "context", "scene", XmlPullParser.NO_NAMESPACE, "msFrameSign", XmlPullParser.NO_NAMESPACE, "rawStr", "initBdInstall", "getAdIdWaitTime", XmlPullParser.NO_NAMESPACE, "createBdInterceptor", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "report", "withDid", "observeAndUpdateDid", "reportReceiveDid", "did", "iid", "restoreDTraitConfigFromKeva", "Lcom/larus/settings/provider/security/DTraitDetailConfig;", "storeDTraitConfig2Keva", "safelyToJson", "src", XmlPullParser.NO_NAMESPACE, "isPreinstallApp", "getPreinstallChannel", "checkNetPermission", "fm", "Landroidx/fragment/app/FragmentManager;", "doNext", "isBasicMode", "setBasicMode", "isBasic", "restartApp", "showBasicModeExitDialog", "activity", "Landroidx/fragment/app/FragmentActivity;", "targetUrl", "logoutAndRestart", "interceptApiCallRequest", "apiCallInfo", "logApiCallRequestOnline", "shouldProcessFrequencyCheck", "apiId", "handleFreqFirstCall", "freqInfo", "currentTime", "handleFreqInfoCount", "handleFreqInfoMark", "prepareFreqInfoReport", "resetFreqInfo", "initShortTermFreqCache", "initFreqCheckList", "config", "Lcom/larus/settings/provider/security/ShortTermFrequencyControl;", "startFreqWriteCoroutine", "startFreqReadCoroutine", "writeCacheToKeva", "readAndReportFromKeva", "doApiCallReport", "mobPermissionRequest", "page", "permissions", XmlPullParser.NO_NAMESPACE, "initAppOpsConfig", "tryCheckAppOpsByApiID", "apiID", "initPreinstallSdk", "application", "Landroid/app/Application;", "reportPreInstallChannel", "enableTimonLocalInit", "getTimonLocalConfig", "Lcom/google/gson/JsonObject;", "reportInvalidApiStack", "Lcom/bytedance/helios/api/pipeline/ApiCallInfo;", "registerBasicModeListener", "listener", "unRegisterModeListener", "killCurrentProcess", "Landroid/app/Activity;", "enableTTNetEncrypt", "shouldAddTTNetEncryptHeader", "requestUrl", "tryMobTTNetEncryptResult", "responseHeaders", "getTTNetEncryptScene", "forceTTNetRetry", "initAOPEnvironment", "initTTNetAudit", "enableTTNetAuditMock", "shouldAddTTNetAuditMockHeader", "getTTNetAuditMockHeader", "ensureTtcnpaInit", "action", "checkAndFixAIGCMetaDataByPathAsync", "filePath", "completeCB", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "checkAndFixAIGCMetaDataByPathSync", "checkAndFixAIGCMetaDataByPathInternal", "isAsync", "markMetadataCheckScene", "markMetadataDownloadUrl", "url", "trackAigcMetadataEvent", "mediaType", "pid", "isMissingMetadata", "fixSuccess", "readCode", "writeCode", "readDesc", "writeDesc", "downloadUrl", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class SecurityServiceImpl implements SecurityService {
    public static final /* synthetic */ int l = 0;
    public volatile boolean a;
    public boolean b;
    public final List<Function0<Unit>> c;
    public final ArrayList<SecurityService.a> d;
    public final Lazy e;
    public final Map<Integer, com.larus.common.mssdk.impl.a> f;
    public final ConcurrentLinkedQueue<com.larus.common.mssdk.impl.a> g;
    public boolean h;
    public final Lazy i;
    public final Lazy j;
    public final e k;

    public static final class a {
    }

    public static final class e implements v48.e {
        public final /* synthetic */ SecurityServiceImpl a;

        public e(SecurityServiceImpl r1) {
            this.a = r1;
        }

        @Override // v48.e
        public final void onGetId(String r7, String r8, String r9) {
            Intrinsics.checkNotNullParameter(r7, "did");
            Intrinsics.checkNotNullParameter(r8, "iid");
            Intrinsics.checkNotNullParameter(r9, "ssid");
            if (r7.length() <= 0) goto L5;
            boolean r10 = true;
        L6:
            if (r10 == false) goto L9;
            SecurityServiceImpl r11 = this.a;
            int r0 = SecurityServiceImpl.l;
            r11.getClass();
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new reportReceiveDid.1(r7, r8, null), 3, null);
            return;
        L9:
            return;
        L5:
            r10 = false;
            goto L6
        }
    }

    static {
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void a() {
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void g(List r2) {
        Intrinsics.checkNotNullParameter(r2, "permissions");
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void B() {
        IApplog.a.f(new l());
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final boolean D() {
        return s.a.b();
    }

    public final Gson K() {
        return (Gson) this.j.getValue();
    }

    public final Keva L() {
        return (Keva) this.i.getValue();
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final boolean enableTimonLocalInit() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new m00())).booleanValue();
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void h() {
        AtomicBoolean r0 = h09.h.a;
        h09.h.c(SecurityAuditStage.TTNET_INIT);
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final String i() {
        AtomicBoolean r0 = d.g;
        return d.a.a.b();
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final boolean j() {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("enableTTNetAuditMock ");
        Boolean r2 = h09.h.b().j();
        Boolean r3 = Boolean.TRUE;
        r1.append(Intrinsics.areEqual(r2, r3));
        r0.d("SecurityService", r1.toString());
        return Intrinsics.areEqual(h09.h.b().j(), r3);
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final JsonObject l() {
        FLogger r0 = FLogger.a;
        r0.d("SecurityService", "prepare load local config");
        JsonObject r1 = (JsonObject) K().fromJson(TextStreamsKt.readText(new BufferedReader(new InputStreamReader(AppHost.a.getApplication().getAssets().open("timon_local_config.json")))), JsonObject.class);     // Catch: Exception -> L5
        r0.d("SecurityService", "timon load local config succeed");     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r1);     // Catch: Exception -> L5
        return r1;
    L5:
        e = move-exception;
        FLogger.a.e("SecurityService", "timon load local config failed: " + e.getMessage());
        return new JsonObject();
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void o() {
        e10 r0 = e10.a;
        int r1 = l0.a;
        new zv9.d();
        c r2 = (c) l0.a(zv9.d.a(), new lg());
        FLogger.a.i("SecurityService", "initAppOpsConfig enable: " + r2.a());
        IAppOpsService r3 = (IAppOpsService) ServiceManager.get().getService(IAppOpsService.class);
        if (r3 == null) goto L27;
        Application r4 = AppHost.a.getApplication();
        boolean r5 = r2.a();
        HashMap r6 = r2.c();
        if (r6 == null) goto L25;
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator r8 = r6.entrySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L16;
        Map.Entry r9 = (Map.Entry) r8.next();
        Integer r10 = (Integer) r9.getKey();
        String r11 = (String) r9.getValue();
        if (r10 == null) goto L13;
        if (r11 == null) goto L13;
        boolean r12 = true;
    L14:
        if (r12 == false) goto L8;
        r7.put(r9.getKey(), r9.getValue());
    L13:
        r12 = false;
        goto L14
    L16:
        LinkedHashMap r13 = new LinkedHashMap(MapsKt.mapCapacity(r7.size()));
        Iterator r14 = r7.entrySet().iterator();
    L18:
        if (r14.hasNext() == false) goto L20;
        Map.Entry r15 = (Map.Entry) r14.next();
        Object r16 = r15.getKey();
        Intrinsics.checkNotNull(r16);
        r13.put(Integer.valueOf(((Number) r16).intValue()), r15.getValue());
        goto L18
    L20:
        LinkedHashMap r17 = new LinkedHashMap(MapsKt.mapCapacity(r13.size()));
        Iterator r18 = r13.entrySet().iterator();
    L22:
        if (r18.hasNext() == false) goto L24;
        Map.Entry r19 = (Map.Entry) r18.next();
        Object r20 = r19.getKey();
        Object r21 = r19.getValue();
        Intrinsics.checkNotNull(r21);
        r17.put(r20, (String) r21);
        goto L22
    L24:
        HashMap r22 = new HashMap(r17);
    L26:
        r3.b(r4, r5, r22, r2.d(), r2.b());
        goto L27
    L25:
        r22 = new HashMap();
    L27:
        IAppOpsService r23 = (IAppOpsService) ServiceManager.get().getService(IAppOpsService.class);
        if (r23 == null) goto L37;
        List r24 = r2.e();
        if (r24 == null) goto L35;
        List r25 = CollectionsKt.filterNotNull(r24);
        if (r25 == null) goto L35;
        Set r26 = CollectionsKt.toMutableSet(r25);
        if (r26 == null) goto L35;
    L36:
        r23.c(r26);
    L35:
        r26 = new LinkedHashSet();
    L37:
        IAppOpsService r28 = (IAppOpsService) ServiceManager.get().getService(IAppOpsService.class);
        if (r28 == null) goto L55;
        List r29 = r2.f();
        if (r29 == null) goto L45;
        List r30 = CollectionsKt.filterNotNull(r29);
        if (r30 == null) goto L45;
        Set r31 = CollectionsKt.toMutableSet(r30);
        if (r31 == null) goto L45;
    L46:
        r28.a(r31);
        return;
    L45:
        r31 = new LinkedHashSet();
        goto L46
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final boolean u() {
        e10 r0 = e10.a;
        u r1 = e10.r0();
        if (r1.a() == false) goto L12;
        List r2 = r1.c();
        if (r2 != null) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == false) goto L12;
        boolean r4 = true;
    L14:
        if (AppHost.a.isTestChannel() == false) goto L21;
        if (r4 == true) goto L17;
    L19:
        return false;
    L17:
        if (L().getBoolean("force_close", false) == true) goto L19;
        return true;
    L21:
        return r4;
    L7:
        if ((!r2.isEmpty()) != true) goto L9;
        r3 = true;
    L12:
        r4 = false;
        goto L14
    }

    public SecurityServiceImpl() {
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = LazyKt.lazy(new f());
        this.f = new LinkedHashMap();
        this.g = new ConcurrentLinkedQueue();
        this.i = LazyKt.lazy(new g());
        this.j = LazyKt.lazy(new h());
        this.k = new e(this);
        e10 r0 = e10.a;
        int r1 = l0.a;
        new t();
        r r2 = (r) l0.a(t.a(), new f3());
        if (m2.a.a() == true) goto L5;
        return;
    L5:
        if (r2.b() == false) goto L22;
        List<o> r3 = r2.a();
        if (r3 == null) goto L14;
        Iterator<T> r4 = r3.iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        o r5 = (o) r4.next();
        if (r5 == null) goto L10;
        this.f.put(Integer.valueOf(r5.a()), new com.larus.common.mssdk.impl.a(r5.a(), r5.c(), r5.e(), r5.d(), r5.b(), 480));
    L14:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new startFreqWriteCoroutine.1(r2, this, null), 3, null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new startFreqReadCoroutine.1(r2, this, null), 3, null);
        FLogger.a.i("SecurityService", "writeInterval " + r2.d() + "s, readInterval: " + r2.c() + 's');
        return;
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final boolean A() {
        return L().getBoolean("force_retry", false);
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final t74.a F() {
        return new t74.a(new n09.a(P()));
    }

    public final zv9.f P() {
        String r0 = L().getString("dtrait_config", XmlPullParser.NO_NAMESPACE);
        if (o0.d(r0) == false) goto L9;
        return (zv9.f) K().fromJson(r0, zv9.f.class);
    L7:
        return new zv9.f(null);
    L9:
        return new zv9.f(null);
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final boolean isBasicMode() {
        if (L().getBoolean("basic_mode", false) == true) goto L5;
        return false;
    L5:
        if (D() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void p() {
        zv9.f r0 = P();
        SettingsManager.registerListener(new j(this), false);
        n74.a.a = r0.d();
        List r1 = r0.c();
        if (r1 == null) goto L5;
        List r2 = CollectionsKt.filterNotNull(r1);
    L6:
        n74.a.b = r2;
        n74.a.c = r0.b();
        r0.toString();
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void E() {
        AtomicBoolean r0 = h09.h.a;
    }

    public static final void H(SecurityServiceImpl r8) {
        String r0 = r8.L().getString("short_term_freq_cache", XmlPullParser.NO_NAMESPACE);
        Intrinsics.checkNotNull(r0);
        if (r0.length() <= 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L14;
        List r1 = ArraysKt.toList((Object[]) GsonProtectorUtils.fromJson(r8.K(), r0, com.larus.common.mssdk.impl.a[].class));
        Iterator r4 = r1.iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        com.larus.common.mssdk.impl.a r5 = (com.larus.common.mssdk.impl.a) r4.next();
        JSONObject r6 = new JSONObject();
        r6.put("api_id", r5.a);
        r6.put("stack", r5.i);
        IApplog.a.reportEvent("security_short_term_freq_api_call", r6);
        goto L9
    L11:
        r8.L().storeString("short_term_freq_cache", XmlPullParser.NO_NAMESPACE);
        FLogger.a.d("SecurityService", "report frequency total size: " + r1.size());
        return;
    L14:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public static final void I(SecurityServiceImpl r5) {
        r5.getClass();
        ArrayList r0 = new ArrayList();
    L3:
        boolean r2 = true;
        if ((!r5.g.isEmpty()) == false) goto L9;
        com.larus.common.mssdk.impl.a r1 = r5.g.poll();
        if (r1 == null) goto L3;
        r0.add(r1);
        goto L3
    L9:
        if ((!r0.isEmpty()) == false) goto L24;
        String r3 = r5.L().getString("short_term_freq_cache", XmlPullParser.NO_NAMESPACE);
        Intrinsics.checkNotNull(r3);
        if (r3.length() > 0) goto L14;
        r2 = false;
    L14:
        if (r2 == false) goto L16;
        List r4 = ArraysKt.toMutableList((Object[]) GsonProtectorUtils.fromJson(r5.K(), r3, com.larus.common.mssdk.impl.a[].class));
    L17:
        r4.addAll(r0);
        r5.L().storeString("short_term_freq_cache", GsonProtectorUtils.toJson(r5.K(), r4));
        FLogger.a.d("SecurityService", "write cache to keva: " + r0.size() + ", data size: " + r4.size());
        return;
    L16:
        r4 = new ArrayList();
        goto L17
    }

    public static void O(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intent r0 = r2.getPackageManager().getLaunchIntentForPackage(r2.getPackageName());
        if (r0 == null) goto L6;
        r0.addFlags(268468224);
        r2.startActivity(r0);
        r2.finish();
        Process.killProcess(Process.myPid());
        return;
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final boolean G(String r7) {
        boolean r2 = false;
        if (u() == false) goto L37;
        e10 r0 = e10.a;
        List r1 = e10.r0().c();
        List r3 = r1;
        if (r3 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L37;
        if (r7 == null) goto L17;
        Uri r8 = y0.j(r7);
        if (r8 == null) goto L17;
        String r9 = r8.getPath();
    L18:
        if (r9 == null) goto L37;
        List r5 = r1;
        if ((r5 instanceof Collection) == true) goto L22;
    L24:
        Iterator r6 = r5.iterator();
    L26:
        if (r6.hasNext() == false) goto L37;
        zv9.h r10 = (zv9.h) r6.next();
        if (r10 == null) goto L34;
        String r11 = r10.a();
        if (r11 == null) goto L34;
        if (StringsKt.contains$default(r9, r11, false, 2, null) != true) goto L34;
        boolean r12 = true;
    L35:
        if (r12 == false) goto L26;
        r2 = true;
    L34:
        r12 = false;
        goto L35
    L22:
        if (r5.isEmpty() == false) goto L24;
    L17:
        r9 = null;
        goto L18
    L7:
        if (r3.isEmpty() == true) goto L10;
        r4 = false;
    L37:
        if (r2 == true) goto L39;
    L41:
        return r2;
    L39:
        if (o09.a.a == true) goto L41;
        o09.a.a = true;
        FLogger.a.i("TTNet_encrypt", "add Header");
        goto L41
    }

    public final void M(com.larus.common.mssdk.impl.a r19) {
        r19.g = 0;
        int r2 = r19.h + 1;
        r19.h = r2;
        if (r2 < r19.c) goto L6;
        ConcurrentLinkedQueue<com.larus.common.mssdk.impl.a> r3 = this.g;
        String r5 = ExceptionsKt.stackTraceToString(new Throwable());
        int r7 = r19.a;
        int r8 = r19.b;
        int r9 = r19.c;
        int r10 = r19.d;
        boolean r11 = r19.e;
        long r12 = r19.f;
        int r14 = r19.g;
        int r15 = r19.h;
        Intrinsics.checkNotNullParameter(r5, "stack");
        r3.add(new com.larus.common.mssdk.impl.a(r7, r8, r9, r10, r11, r12, r14, r15, r5));
        FLogger.a.d("SecurityService", "prepare report: apiID = " + r19.a);
        r19.h = 0;
    L6:
        FLogger.a.d("SecurityService", "apiID = " + r19.a + ", curMark: " + r19.h);
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final boolean b(kz5.a r8) {
        Intrinsics.checkNotNullParameter(r8, "apiCallInfo");
        boolean r1 = false;
        if (isBasicMode() == false) goto L12;
        List r0 = ((zv9.a) this.e.getValue()).a();
        if (r0 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L12;
        r1 = true;
        goto L12
    L7:
        if (r0.contains(Integer.valueOf(r8.a)) != true) goto L9;
        r2 = true;
    L12:
        if (r1 == true) goto L19;
    L18:
        return r1;
    L19:
        IApplog.Companion r3 = IApplog.a;     // Catch: Throwable -> L16
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L16
        r4.put("api_id", r8.a);     // Catch: Throwable -> L16
        r4.put("from", r8.b);     // Catch: Throwable -> L16
        r4.put("is_basic", isBasicMode());     // Catch: Throwable -> L16
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L16
        r3.reportEvent("blocked_api_call", r4);     // Catch: Throwable -> L16
        EnsureManager.ensureNotReachHere(new Exception("interceptApiCall:" + r8.a), "INTERRUPT_API_CALL");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void d(Application r5) {
        if (r5 == null) goto L8;
        xo7.f r0 = new xo7.f();
        r0.a = new b();
        r0.e = new t09.a();
        r0.c = new t09.d();
        r0.d = new t09.c();
        r0.b = new t09.e();
        boolean r1 = D();
        AtomicBoolean r2 = d.g;
        d r3 = d.a.a;
        r3.getClass();
        SystemClock.elapsedRealtime();
        r3.c = r1;
        if (r3.a != null) goto L6;
        r3.a = r5.getApplicationContext();
    L6:
        bp7.a r6 = bp7.a.a.a;
        r6.a = r0.a;
        r6.b = r0.b;
        r6.c = r0.c;
        r6.d = r0.d;
        r6.e = r0.e;
        r6.b(new bp7.b(r3, r1));
        SystemClock.elapsedRealtime();
        r3.getClass();
        r6.b(new bp7.c(r3));
        return;
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void e(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter("message", "scene");
        N("message", ILoginService.a.getAccountInfo().a);
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final boolean f(String r4) {
        Intrinsics.checkNotNullParameter(r4, "requestUrl");
        FLogger.a.d("SecurityService", "shouldAddTTNetAuditMockHeader result = " + h09.h.d(r4) + ", url = " + r4);
        return h09.h.d(r4);
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void k(FragmentActivity r15) {
        Intrinsics.checkNotNullParameter(r15, "activity");
        Intrinsics.checkNotNullParameter("//flow/privacy_web", "targetUrl");
        int r0 = (int) r15.getResources().getDimension(v19.c.b(2130971289, r15, 2131166947));
        int r1 = j0.a;
        String r2 = j0.d(2131908423);
        Intrinsics.checkNotNullParameter(r2, "title");
        String r3 = j0.d(2131908422);
        Intrinsics.checkNotNullParameter(r3, "message");
        p r4 = new p(this);
        String r5 = j0.d(2131908421);
        Intrinsics.checkNotNullParameter(r4, "listener");
        i1 r6 = new i1(17, 2131103136, 4);
        Intrinsics.checkNotNullParameter(r6, "textStyleConfig");
        q r10 = new q();
        String r11 = j0.d(2131900590);
        Intrinsics.checkNotNullParameter(r10, "listener");
        i1 r12 = new i1(17, 2131103146, 4);
        Intrinsics.checkNotNullParameter(r12, "textStyleConfig");
        s r7 = new s(r15);
        Intrinsics.checkNotNullParameter(r7, "listener");
        SpanableDialog r8 = new SpanableDialog();
        r8.e = r2;
        r8.g = r3;
        r8.h = null;
        r8.i = r0;
        r8.j = r5;
        r8.k = r4;
        r8.l = r11;
        r8.m = r10;
        r8.n = r7;
        r8.q = r12;
        r8.p = r6;
        r8.o = null;
        FragmentManager r16 = r15.getSupportFragmentManager();
        LandscapeRestrictionOperation r9 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, null, r9);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r16, r8, r9) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r8.show(r16, null);
        return;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.larus.common.mssdk.api.SecurityService
    public final void m(Context r13) {
        Intrinsics.checkNotNullParameter(r13, "appContext");
        boolean r0 = ILoginService.a.getAccountInfo().a;
        AppHost.Companion r2 = AppHost.a;
        MSConfig.Builder r1 = new MSConfig.Builder(String.valueOf(r2.getAppId()), "Hgh7rmk3tWWD9tymsFG9WbRF/16OwqDV6AGZNNeGuNZ61ZFEyLB+k1TqvZrWYR/QSmG/dxr0nNoc/U8R70v2JiWBl1fxq9McLeSbfae2/N3gNuV4MJTDbSfWTLLvGNKmzkEJlS5/WLxHcxd2sMXvaSaHHPCraFFUFZSjowZP760flHB1eibEkaxwGYCDKHoE0a/ff8gHtICbK7CJNUZ9g+FJKVU3lpFaChHBdl+gmDw4sHn3dasEeEsjrJRz5u+u89jgY/Cw1c4boNLYglJ+nC1a7rAL5Gc8ATcdzQN9zfRhMKSq", 810);
        r1.addAdvanceInfo("kS1", "1");
        r1.setMsComplianceScene(new d());
        r1.setClientType(0);
        r1.setChannel(r2.getBuildChannel());
        StringBuilder r3 = new StringBuilder("https://");
        HttpConst.a.getClass();
        String r4 = kb9.a.a;
        r3.append(HttpConst.w);
        r1.setDefaultReportHost(r3.toString());
        boolean r5 = true;
        if (r0 == false) goto L10;
        String r6 = IApplog.a.getDeviceId();
        if (r6.length() <= 0) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == false) goto L10;
        r1.setDeviceID(r6);
        int r8 = 1;
    L11:
        IApplog.Companion r9 = IApplog.a;
        String r10 = r9.getInstallId();
        if (r10.length() > 0) goto L15;
        r5 = false;
    L15:
        if (r5 == false) goto L17;
        r1.setInstallID(r10);
    L17:
        MSManagerUtils.init(r13, r1.build());
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new initMsInternal.2(null), 3, null);
        JSONObject r11 = new JSONObject();
        r11.put("with_did", r8);
        r11.put("privacy_accepted", r0 ? 1 : 0);
        Unit r12 = Unit.INSTANCE;
        r9.reportEvent("ms_sdk_init", r11);
        r9.k(this.k);
        r9.j(this.k);
        if (r0 == false) goto L20;
        r9.f(new k(this, r13));
    L23:
        AtomicBoolean r14 = h09.h.a;
        h09.h.c(SecurityAuditStage.SECURITY_INIT);
        return;
    L20:
        N("cold_start", false);
        ILoginService r15 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r15 == null) goto L23;
        r15.f(new g(this, r13), Boolean.FALSE);
        goto L23
    L7:
        r7 = false;
    L10:
        r8 = 0;
        goto L11
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void n(int r6) {
        IAppOpsService r0 = (IAppOpsService) ServiceManager.get().getService(IAppOpsService.class);
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L31;
        com.larus.common.app_ops.a r2 = com.larus.common.app_ops.a.a;
        if (com.larus.common.app_ops.a.b() == true) goto L13;
        return;
    L13:
        if (com.larus.common.app_ops.a.e.get(Integer.valueOf(r6)) == null) goto L34;
        FLogger.a.d("AppOpsUtil", "do tryCheckAppOpsByApiID, apiID: " + r6);
        String r3 = (String) com.larus.common.app_ops.a.e.get(Integer.valueOf(r6));
        if (r3 == null) goto L18;
        Integer r4 = Integer.valueOf(com.larus.common.app_ops.a.a(r3));
    L19:
        JSONObject r5 = new JSONObject();
        r5.put("opCode", com.larus.common.app_ops.a.e.get(Integer.valueOf(r6)));
        r5.put("apiID", r6);
        r5.put("type", "apiID");
        r5.put("check_op", r4);
        if (com.larus.common.app_ops.a.f == false) goto L22;
        r5.put("message", com.larus.common.app_ops.e.b(com.larus.common.app_ops.e.a()));
    L22:
        com.larus.common.app_ops.a.j(r5);
        if (r4 != null) goto L26;
    L27:
        if (r4 == null) goto L35;
        r4.intValue();
        return;
    L35:
        return;
    L26:
        if (r4.intValue() != 1) goto L27;
        return;
    L18:
        r4 = null;
        goto L19
    L34:
        return;
    L31:
        return;
    L5:
        if (r0.isEnable() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final String q(String r8) {
        e10 r0 = e10.a;
        List r1 = e10.r0().c();
        List r2 = r1;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        String r4 = null;
        if (r3 == false) goto L12;
        return null;
    L12:
        if (r8 == null) goto L37;
        Uri r9 = y0.j(r8);
        if (r9 == null) goto L37;
        String r10 = r9.getPath();
        if (r10 == null) goto L37;
        Iterator r5 = r1.iterator();
    L20:
        if (r5.hasNext() == false) goto L32;
        Object r6 = r5.next();
        zv9.h r7 = (zv9.h) r6;
        if (r7 == null) goto L24;
        String r11 = r7.a();
    L25:
        if (r11 == null) goto L29;
        String r12 = r7.a();
        Intrinsics.checkNotNull(r12);
        if (StringsKt.contains$default(r10, r12, false, 2, null) == false) goto L29;
        boolean r13 = true;
    L30:
        if (r13 == false) goto L20;
    L33:
        zv9.h r14 = (zv9.h) r6;
        if (r14 == null) goto L36;
        r4 = r14.b();
    L36:
        FLogger.a.d("TTNet_encrypt", "getScene = " + r4);
    L29:
        r13 = false;
        goto L30
    L24:
        r11 = null;
        goto L25
    L32:
        r6 = null;
    L37:
        return r4;
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void r(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        FLogger r0 = FLogger.a;
        r0.d("SecurityService", "initAOPEnvironment begin");
        IApplog.a.f(new com.larus.common.mssdk.impl.e(r5));
        r0.d("SecurityService", "initAOPEnvironment end");
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void s(kz5.a r15) {
        Intrinsics.checkNotNullParameter(r15, "apiCallInfo");
        FLogger r0 = FLogger.a;
        r0.d("SecurityService", "log apiID = " + r15.a);
        int r1 = r15.a;
        if (m2.a.a() == true) goto L5;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L12;
        return;
    L12:
        r0.d("SecurityService", "prepare log apiID = " + r15.a);
        com.larus.common.mssdk.impl.a r16 = (com.larus.common.mssdk.impl.a) ((LinkedHashMap) this.f).get(Integer.valueOf(r15.a));
        if (r16 != null) goto L15;
        return;
    L15:
        long r6 = System.currentTimeMillis();
        long r8 = r16.f;
        if (r8 != 0) goto L24;
        r16.f = r6;
        r16.g = 1;
        if (r16.e == true) goto L20;
    L22:
        r0.d("SecurityService", "first call API: " + r16.a);
        return;
    L20:
        if (AppHost.a.a().isAppBackground() == false) goto L22;
        M(r16);
        goto L22
    L24:
        if ((r6 - r8) > (((long) r16.d) * 1000)) goto L29;
        int r3 = r16.g + 1;
        r16.g = r3;
        if (r3 < r16.b) goto L28;
        M(r16);
    L28:
        r0.d("SecurityService", "apiID = " + r16.a + ", curCount: " + r16.g);
        return;
    L29:
        r16.f = r6;
        r16.g = 1;
        r16.h = 0;
        r0.d("SecurityService", "reset frequency info: " + r16.a);
        return;
    L5:
        if ((!this.f.isEmpty()) == false) goto L9;
        if (this.f.containsKey(Integer.valueOf(r1)) == false) goto L9;
        r2 = true;
        goto L10
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final Map<String, String> v(String r3) {
        Intrinsics.checkNotNullParameter(r3, "rawStr");
        Map<String, String> r4 = MSManagerUtils.get(String.valueOf(AppHost.a.getAppId())).frameSign(r3, 1);
        if (r4 == null) goto L5;
        return r4;
    L5:
        return MapsKt.emptyMap();
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void w(String r9) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        long r3 = SystemClock.elapsedRealtime();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        FLogger r6 = FLogger.a;     // Catch: Throwable -> L5
        r6.d("SecurityService", "markMetadataCheckScene scene:".concat(r9));     // Catch: Throwable -> L5
        Keva.getRepo("aigc_metadata_repo", 0).storeString("aigc_metadata_check_scene", r9);     // Catch: Throwable -> L5
        r6.i("SecurityService", "markMetadataCheckScene scene=" + r9 + " cost=" + (SystemClock.elapsedRealtime() - r3) + "ms");     // Catch: Throwable -> L5
        Object r0 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r1 = Result.m52exceptionOrNullimpl(r0);
        if (r1 == null) goto L13;
        long r7 = SystemClock.elapsedRealtime() - r3;
        FLogger.a.e("SecurityService", "markMetadataCheckScene failed after " + r7 + "ms scene=" + r9, r1);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r0 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void y(String r6) {
        Intrinsics.checkNotNullParameter(r6, "url");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        FLogger.a.d("SecurityService", "markMetadataDownloadUrl url:" + r6);     // Catch: Throwable -> L5
        Keva.getRepo("aigc_metadata_repo", 0).storeString("aigc_metadata_check_download_url", r6);     // Catch: Throwable -> L5
        Object r1 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r3 = Result.m52exceptionOrNullimpl(r1);
        if (r3 == null) goto L13;
        FLogger.a.e("SecurityService", "markMetadataDownloadUrl failed url=" + r6, r3);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final boolean z(String r5) {
        Intrinsics.checkNotNullParameter(r5, "filePath");
        Ref.BooleanRef r0 = new Ref.BooleanRef();
        CountDownLatch r1 = new CountDownLatch(1);
        J(r5, false, new b(r0, r1));
        r1.await(3, TimeUnit.SECONDS);     // Catch: Exception -> L5
    L8:
        return r0.element;
    L5:
        e = move-exception;
        FLogger.a.e("SecurityService", "checkAndFixAIGCMetaDataByPathSync latch interrupted", e);
        goto L8
    }

    public static void N(String r7, boolean r8) {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new report.1(r8, r7, null), 3, null);
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void c(String r2, Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "filePath");
        Intrinsics.checkNotNullParameter(r3, "completeCB");
        J(r2, true, r3);
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void t(boolean r3, boolean r4) {
        if (isBasicMode() == r3) goto L22;
        L().storeBoolean("basic_mode", r3);
        Iterator<SecurityService.a> r5 = this.d.iterator();
    L6:
        if (r5.hasNext() == false) goto L8;
        r5.next().onChange();
        goto L6
    L8:
        if (r4 == false) goto L23;
        IFlowSdkDepend r6 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r6 == null) goto L12;
        r6.getAccountService();
        boolean r7 = Intrinsics.areEqual(com.larus.home.impl.sdk.d.a.isLogin(), Boolean.TRUE);
    L13:
        if (r7 == false) goto L17;
        IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r8 == null) goto L24;
        r8.getAccountService();
        com.larus.home.impl.sdk.d.a.z("logout_by_basic_mode", new n(this));
        return;
    L24:
        return;
    L17:
        Activity r9 = AppHost.a.a().getCurrentActivity();
        if (r9 == null) goto L26;
        O(r9);
        return;
    L26:
        return;
    L12:
        r7 = false;
        goto L13
    L23:
        return;
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void x(FragmentManager r6, Function0<Unit> r7) {
        Intrinsics.checkNotNullParameter(r6, "fm");
        Intrinsics.checkNotNullParameter(r7, "doNext");
        SecurityService r0 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.D() != true) goto L7;
    L8:
        if (r2 == true) goto L12;
        if (s.a.f() == true) goto L12;
    L18:
        r7.invoke();
        return;
    L12:
        if (this.h == true) goto L18;
        CommonDialog.a r1 = new CommonDialog.a();
        int r3 = j0.a;
        r1.g(j0.d(2131908427));
        CommonDialog.a.e(r1, new c(), j0.d(2131900590), 4);
        CommonDialog.a.f(r1, new d(this, r7), j0.d(2131908426), false, 12);
        CommonDialog r8 = r1.a();
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, null, r4);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r8, r4) == true) goto L24;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L17:
        r8.show(r6, null);
        return;
    L24:
        return;
    L7:
        r2 = false;
        goto L8
    }

    @Override // com.larus.common.mssdk.api.SecurityService
    public final void C(String r8, String r9, List<Object> r10) {
        Intrinsics.checkNotNullParameter(r8, "requestUrl");
        Intrinsics.checkNotNullParameter(r10, "responseHeaders");
        e10 r2 = e10.a;
        if (e10.r0().b() == true) goto L5;
        return;
    L5:
        int r3 = o09.c.a;
        Intrinsics.checkNotNullParameter(r8, "requestUrl");
        Intrinsics.checkNotNullParameter(r10, "responseHeaders");
        List<Object> r11 = r10;
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r11.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        Object r4 = r1.next();
        if ((r4 instanceof Header) == false) goto L7;
        r0.add(r4);
        goto L7
    L11:
        Iterator r5 = r0.iterator();
    L12:
        String r6 = null;
        boolean r7 = true;
        if (r5.hasNext() == false) goto L17;
        Object r12 = r5.next();
        if (StringsKt.equals(((Header) r12).getName(), "x-tt-e-r", true) == false) goto L12;
    L18:
        Header r13 = (Header) r12;
        if (r13 == null) goto L91;
        String r14 = r13.getValue();
        if (Intrinsics.areEqual(r14, "0;0") == false) goto L36;
        int r15 = u09.c.a;
        Integer r16 = Integer.valueOf(EventsUtils.FEAT_TYPE_SHUT_DOWN);
        o09.b r17 = new o09.b(r14, r8, r9);
        Intrinsics.checkNotNullParameter("security_mob_ttnet_encrypt_success", "eventName");
        Intrinsics.checkNotNullParameter(r17, "callback");
        if (r16 == null) goto L35;
        int r18 = u09.a.a;
        int r19 = r16.intValue();
        if (r19 <= 0) goto L32;
        if (r19 != 1) goto L30;
    L33:
        if (r7 == true) goto L35;
        return;
    L30:
        if ((System.currentTimeMillis() % ((long) r19)) == 0) goto L33;
    L32:
        r7 = false;
    L35:
        IApplog.a.reportEvent("security_mob_ttnet_encrypt_success", (JSONObject) r17.invoke());
        return;
    L36:
        int r20 = o09.c.a;
        Intrinsics.checkNotNull(r14);
        Pair r21 = o09.c.a(r14);
        Uri r22 = UriProtector.parse(r8);     // Catch: Exception -> L75
        String r23 = r22.getHost();     // Catch: Exception -> L75
        if (r23 == null) goto L45;
        String r24 = r22.getPath();     // Catch: Exception -> L75
        if (r24 != null) goto L43;
        r24 = "/";
    L43:
        Pair r25 = new Pair(r23, r24);     // Catch: Exception -> L75
    L46:
        JSONObject r26 = new JSONObject();
        r26.put("scene", r9);
        r26.put("error_code_en", r21.getFirst());
        r26.put("error_code_de", r21.getSecond());
        if (r25 == null) goto L49;
        String r28 = (String) r25.getFirst();
    L50:
        r26.put("host", r28);
        if (r25 == null) goto L53;
        String r29 = (String) r25.getSecond();
    L54:
        r26.put("path", r29);
        Iterator<T> r30 = r11.iterator();
    L56:
        if (r30.hasNext() == false) goto L65;
        Object r110 = r30.next();
        if ((r110 instanceof Header) == true) goto L60;
    L62:
        boolean r31 = false;
    L63:
        if (r31 == false) goto L56;
    L66:
        if (r110 != null) goto L68;
    L73:
        r26.put("log_id", r6);
        FLogger.a.e("TTNet_encrypt", "onTTNetEncryptError = " + r25 + ", encryptResult = " + r21);
        IApplog.a.reportEvent("security_mob_ttnet_encrypt_error", r26);
        return;
    L68:
        if ((r110 instanceof Header) == false) goto L70;
        Header r111 = (Header) r110;
    L71:
        if (r111 == null) goto L73;
        r6 = r111.getValue();
        goto L73
    L70:
        r111 = null;
        goto L71
    L60:
        if (StringsKt.equals(((Header) r110).getName(), "x-tt-logid", true) == false) goto L62;
        r31 = true;
        goto L63
    L65:
        r110 = null;
        goto L66
    L53:
        r29 = null;
        goto L54
    L49:
        r28 = null;
    L45:
        r25 = null;
        goto L46
    L91:
        return;
    L17:
        r12 = null;
        goto L18
    }

    public final void J(String r12, boolean r13, Function1<? super Boolean, Unit> r14) {
        e10 r0 = e10.a;
        if (e10.t().b() == true) goto L6;
        FLogger.a.i("SecurityService", "checkAndFixAIGCMetaData skipped because it is disabled in settings.");
        r14.invoke(Boolean.TRUE);
        return;
    L6:
        Keva r1 = Keva.getRepo("aigc_metadata_repo", 0);
        String r4 = r1.getString("aigc_metadata_check_scene", "default_scene");
        String r6 = r1.getString("aigc_metadata_check_download_url", null);
        r1.erase("aigc_metadata_check_scene");
        r1.erase("aigc_metadata_check_download_url");
        i r2 = new i(r4, r12, r6, r14, this, UUID.randomUUID().toString(), r13);
        if (this.a == true) goto L30;
        TTCNPA.a.getClass();
        if (TTCNPA.b == true) goto L30;
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L13:
        if (this.a == false) goto L15;
    L24:
        this.a = true;     // Catch: Throwable -> L27
        r2.invoke();     // Catch: Throwable -> L27
        monitor-exit(this);
    L32:
        return;
    L15:
        if (TTCNPA.b == true) goto L24;
        ((ArrayList) this.c).add(r2);     // Catch: Throwable -> L27
        if (this.b == false) goto L21;
        monitor-exit(this);
        goto L32
    L21:
        this.b = true;     // Catch: Throwable -> L27
        FLogger.a.i("SecurityService", "Initializing TTCNPA SDK...");     // Catch: Throwable -> L27
        k3.a.a("001191110102MACQD9K64010000", XmlPullParser.NO_NAMESPACE, new m(), new c(this));     // Catch: Throwable -> L27
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(this);
    L30:
        this.a = true;
        r2.invoke();
    }

    public static void Q(String r12, String r13, String r14, boolean r15, boolean r16, long r17, long r19, String r21, String r22, String r23) {
        boolean r3 = true;
        if (r15 == true) goto L18;
        e10 r6 = e10.a;
        hq9.e r7 = e10.t();
        if (r7.b() == true) goto L7;
        FLogger.a.d("SecurityService", "trackAigcMetadataEvent: global sampling config is disabled.");
        boolean r8 = false;
    L19:
        if (r8 == true) goto L22;
        FLogger.a.d("SecurityService", "trackAigcMetadataEvent applog skipped due to sampling. scene:" + r12);
        return;
    L22:
        JSONObject r9 = new JSONObject();
        r9.put("scene", r12);
        r9.put("media_type", r13);
        r9.put("pid", r14);
        r9.put("is_missing_metadata", r15);
        r9.put("fix_success", r16);
        r9.put("read_code", r17);
        r9.put("write_code", r19);
        r9.put("read_desc", r21);
        r9.put("write_desc", r22);
        if (r23 != null) goto L25;
    L28:
        if (r3 == true) goto L31;
        if (r15 == false) goto L31;
        r9.put("download_url", r23);
    L31:
        FLogger.a.i("SecurityService", "trackAigcMetadataEvent emitting applog event 'aigc_metadata_check_fix' with params: " + r9);
        TrackParams r0 = new TrackParams().merge(r9);
        by7.a r1 = new by7.a("aigc_metadata_check_fix");
        r1.a.merge(r0);
        r1.b();
        return;
    L25:
        if (r23.length() == 0) goto L28;
        r3 = false;
        goto L28
    L7:
        Map r10 = r7.d();
        if (r10 == null) goto L12;
        Float r11 = (Float) r10.get(r12);
        if (r11 == null) goto L12;
        float r18 = r11.floatValue();
    L13:
        float r20 = Random.Default.nextFloat() * 100.0f;
        if (r20 > r18) goto L16;
        r8 = true;
    L17:
        FLogger.a.d("SecurityService", "trackAigcMetadataEvent sampling check: scene=" + r12 + ", sampleRate=" + r18 + ", randomVal=" + r20 + ", shouldUpload=" + r8);
        goto L19
    L16:
        r8 = false;
    L12:
        r18 = r7.a();
        goto L13
    L18:
        FLogger.a.d("SecurityService", "trackAigcMetadataEvent: metadata is missing, bypassing sampling and uploading directly.");
        r8 = true;
        goto L19
    }
}
