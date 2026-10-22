package com.bytedance.badger;

import android.content.Context;
import android.os.Build;
import com.bytedance.badger.collect.impl.api.BadgerCollectApi;
import com.bytedance.badger.data.EventReportEnum;
import com.bytedance.badger.module.BadgerModuleBase;
import com.bytedance.badger.monitor.CollectStage;
import com.bytedance.badger.monitor.TriggerStage;
import com.bytedance.badger.network.d0;
import com.bytedance.badger.network.m0;
import com.bytedance.badger.network.v;
import com.bytedance.badger.network.z;
import com.bytedance.badger.network.z0;
import com.bytedance.badger.utils.AppContextBridge;
import com.bytedance.badger.utils.C10462c;
import com.bytedance.badger.z.w0;
import com.bytedance.badger.z.x0;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 \u009a\u00012\u00020\u0001:\u0002\u009b\u0001B\b¢\u0006\u0005\b\u0099\u0001\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J<\u0010*\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042%\u0010)\u001a!\u0012\u0013\u0012\u00110$¢\u0006\f\b%\u0012\b\b&\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00060#j\u0002`(¢\u0006\u0004\b*\u0010+J!\u00100\u001a\u0004\u0018\u00010/2\u0006\u0010-\u001a\u00020,2\b\b\u0002\u0010.\u001a\u00020\u000e¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u00062\b\b\u0002\u00102\u001a\u00020\u000e¢\u0006\u0004\b3\u00104J'\u00106\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0006\u00105\u001a\u00020\u00042\b\b\u0002\u00102\u001a\u00020\u000e¢\u0006\u0004\b6\u00107J\u000f\u00108\u001a\u00020\u000eH\u0016¢\u0006\u0004\b8\u0010\u0018J\u0019\u0010;\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0002H\u0016¢\u0006\u0004\b=\u0010>J\u001d\u0010B\u001a\u00020\u001f2\u0006\u0010?\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020@¢\u0006\u0004\bB\u0010CJ#\u0010H\u001a\u00020\u000e2\n\u0010E\u001a\u00060\u0004j\u0002`D2\u0006\u0010G\u001a\u00020FH\u0016¢\u0006\u0004\bH\u0010IJ1\u0010O\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u001f2\u0006\u0010L\u001a\u00020\u001f2\b\u0010N\u001a\u0004\u0018\u00010MH\u0016¢\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001a\u00020\u00062\u0006\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bS\u0010TJ)\u0010Z\u001a\u00020\u00062\u0006\u0010V\u001a\u00020U2\u0006\u0010W\u001a\u00020\u001f2\b\u0010Y\u001a\u0004\u0018\u00010XH\u0016¢\u0006\u0004\bZ\u0010[J-\u0010Z\u001a\u00020\u00062\u0006\u0010V\u001a\u00020U2\u0014\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0006\u0012\u0004\u0018\u00010X0\\H\u0016¢\u0006\u0004\bZ\u0010^J'\u0010b\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010`\u001a\u00020_2\u0006\u0010)\u001a\u00020aH\u0016¢\u0006\u0004\bb\u0010cJ\u0017\u0010f\u001a\u00020\u00062\u0006\u0010e\u001a\u00020dH\u0016¢\u0006\u0004\bf\u0010gJ\u0017\u0010h\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u001fH\u0016¢\u0006\u0004\bh\u0010iJ\u001d\u0010k\u001a\u00020\u00062\f\u0010j\u001a\b\u0012\u0004\u0012\u00020@0\u0011H\u0016¢\u0006\u0004\bk\u0010\u0014J\u0017\u0010m\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u001fH\u0016¢\u0006\u0004\bm\u0010iJ'\u0010o\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\\2\b\u0010n\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\bo\u0010pJ\r\u0010q\u001a\u00020\u000e¢\u0006\u0004\bq\u0010\u0018J\r\u0010r\u001a\u00020\u001f¢\u0006\u0004\br\u0010!J\r\u0010s\u001a\u00020\u000e¢\u0006\u0004\bs\u0010\u0018J\u001b\u0010u\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010t¢\u0006\u0004\bu\u0010vR$\u0010x\u001a\u0004\u0018\u00010w8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bx\u0010y\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R!\u0010\u007f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110~8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R*\u0010\u0087\u0001\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0017\u00108\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b8\u0010\u008b\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008b\u0001R\u0019\u0010\u008d\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001f\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00118\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0091\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001f\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\t0\u00118\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0090\u0001R\u001f\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00118\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0090\u0001R\u001f\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00118\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0090\u0001R'\u0010\u0096\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0096\u0001\u0010\u0097\u0001R!\u0010\u0098\u0001\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0090\u0001¨\u0006\u009c\u0001"}, d2 = {"Lcom/bytedance/badger/BadgerCore;", "Lcom/bytedance/badger/IBadger;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "appId", "", "initBadgerCollect", "(Landroid/content/Context;I)V", "Lcom/bytedance/badger/network/z;", "getPublicIpAddressInfo", "()Lcom/bytedance/badger/network/z;", "Lcom/bytedance/badger/a;", "initParams", "", "init", "(Lcom/bytedance/badger/a;)Z", "Lkotlin/Function0;", "listener", "addInitListener", "(Lkotlin/jvm/functions/Function0;)V", "startBootReport", "()V", "initCore", "()Z", "Lcom/bytedance/badger/network/v;", "getNetRequestInterface", "()Lcom/bytedance/badger/network/v;", "Lcom/bytedance/badger/network/u;", "getLoginHandler", "()Lcom/bytedance/badger/network/u;", "", "getDeviceId", "()Ljava/lang/String;", "sceneId", "Lkotlin/Function1;", "Lcom/bytedance/badger/data/BadgerUpdateInfo;", "Lkotlin/ParameterName;", "name", "info", "Lcom/bytedance/badger/data/BadgerUpdateCallback;", "callback", "addSceneCompletionCallback", "(ILkotlin/jvm/functions/Function1;)I", "Lz64/c;", HiAnalyticsConstant.Direction.REQUEST, "ignoreCheckForeground", "Lz64/b;", "getBadgerReport", "(Lz64/c;Z)Lz64/b;", "ignoreForeground", "checkReadyForReportAndThrow", "(Z)V", "waitTimeMs", "updateFeatures", "(Lz64/c;IZ)I", "isInitialized", "Lorg/json/JSONObject;", "config", "updateConfig", "(Lorg/json/JSONObject;)V", "getContext", "()Landroid/content/Context;", "challengeKey", "", "timestamp", "genChallenge", "(Ljava/lang/String;J)Ljava/lang/String;", "Lcom/bytedance/badger/module/FeatureID;", "featureId", "Lcom/bytedance/badger/module/BadgerModuleBase;", "badgerModule", "registerBadgerModule", "(ILcom/bytedance/badger/module/BadgerModuleBase;)Z", "level", "tag", "msg", "", "tr", "log", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "Lz64/e;", "action", "notifyUserAction", "(Lz64/e;)V", "Lcom/bytedance/badger/data/EventReportEnum;", "eventName", "key", "", "value", "recordEvent", "(Lcom/bytedance/badger/data/EventReportEnum;Ljava/lang/String;Ljava/lang/Object;)V", "", "values", "(Lcom/bytedance/badger/data/EventReportEnum;Ljava/util/Map;)V", "Lz64/h;", "reportMode", "Lz64/g;", "doBadgerReport", "(ILz64/h;Lz64/g;)V", "Ly64/a;", "defaultConfig", "setDefaultConfig", "(Ly64/a;)V", "setServerTS", "(Ljava/lang/String;)V", ShortVideoSegments.KEY_PROP_PROVIDER, "setServerTSV2Provider", "scene", "updateReport", "path", "getReportHeader", "(Ljava/lang/String;)Ljava/util/Map;", Keys.API_RETURN_KEY_IS_LOGIN, "getLastCollectError", "isAppInForeground", "Lkotlin/Pair;", "getRequestHeaderTag", "()Lkotlin/Pair;", "Lz64/a;", "badgerExtraParams", "Lz64/a;", "getBadgerExtraParams", "()Lz64/a;", "setBadgerExtraParams", "(Lz64/a;)V", "", "initListeners", "Ljava/util/List;", "Ljava/lang/Object;", "initLock", "Ljava/lang/Object;", "fConfig", "Ljava/lang/String;", "<set-?>", "lastUpdateScene", "I", "getLastUpdateScene", "()I", "Z", "isCoreInitialized", "applicationContext", "Landroid/content/Context;", "isAppInForegroundGetter", "Lkotlin/jvm/functions/Function0;", "netRequestInterface", "Lcom/bytedance/badger/network/v;", "publicIpAddressListGetter", "deviceIdGetter", "isLoginGetter", "requestHeaderTag", "Lkotlin/Pair;", "serverTSV2Provider", "<init>", "Companion", "com/bytedance/badger/d", "badger-core_release"}, k = 1, mv = {1, 4, 0})
public final class BadgerCore implements IBadger {
    public static final j Companion = null;
    private static final String TAG = "BadgerCore";
    private static final Lazy instance$delegate = null;
    private volatile Context applicationContext;
    private volatile z64.a badgerExtraParams;
    private volatile Function0 deviceIdGetter;
    private volatile String fConfig;
    private final List initListeners;
    private final Object initLock;
    private volatile Function0 isAppInForegroundGetter;
    private volatile boolean isCoreInitialized;
    private volatile boolean isInitialized;
    private volatile Function0 isLoginGetter;
    private volatile int lastUpdateScene;
    private volatile v netRequestInterface;
    private volatile Function0 publicIpAddressListGetter;
    private volatile Pair requestHeaderTag;
    private volatile Function0 serverTSV2Provider;

    public BadgerCore() {
        this.initListeners = new ArrayList();
        this.initLock = new Object();
        this.lastUpdateScene = -1;
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static final /* synthetic */ Function0 access$getDeviceIdGetter$p(BadgerCore r100) {
        Function0 r101 = r100.deviceIdGetter;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("deviceIdGetter");
    L5:
        return r101;
    }

    public static final /* synthetic */ Lazy access$getInstance$cp() {
        return instance$delegate;
    }

    public static final /* synthetic */ v access$getNetRequestInterface$p(BadgerCore r100) {
        v r101 = r100.netRequestInterface;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("netRequestInterface");
    L5:
        return r101;
    }

    public static final /* synthetic */ boolean access$isCoreInitialized$p(BadgerCore r100) {
        return r100.isCoreInitialized;
    }

    public static final /* synthetic */ void access$setCoreInitialized$p(BadgerCore r100, boolean r101) {
        r100.isCoreInitialized = r101;
    }

    public static final /* synthetic */ void access$setDeviceIdGetter$p(BadgerCore r100, Function0 r101) {
        r100.deviceIdGetter = r101;
    }

    public static final /* synthetic */ void access$setNetRequestInterface$p(BadgerCore r100, v r101) {
        r100.netRequestInterface = r101;
    }

    public static /* synthetic */ void checkReadyForReportAndThrow$default(BadgerCore r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = false;
    L5:
        r100.checkReadyForReportAndThrow(r101);
    }

    public static /* synthetic */ z64.b getBadgerReport$default(BadgerCore r100, z64.c r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return r100.getBadgerReport(r101, r102);
    }

    public static /* synthetic */ int updateFeatures$default(BadgerCore r100, z64.c r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return r100.updateFeatures(r101, r102, r103);
    }

    @Override // com.bytedance.badger.IBadger
    public void addInitListener(Function0 r100) {
        if (this.isInitialized == false) goto L6;
        r100.invoke();
        return;
    L6:
        Object r101 = this.initLock;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L9:
        if (this.isInitialized == false) goto L13;
        r100.invoke();     // Catch: Throwable -> L16
        monitor-exit(r101);
        return;
    L13:
        this.initListeners.add(r100);     // Catch: Throwable -> L16
        monitor-exit(r101);
    }

    public final String genChallenge(String r100, long r101) {
        if (initCore() == false) goto L11;
        String r102 = r100 + r101;
        Charset r103 = Charsets.UTF_8;
        if (r102 == null) goto L9;
        byte[] r104 = r102.getBytes(r103);
        int r105 = com.bytedance.badger.t.a.f199193a;
        return UInt.m9590toStringimpl(UInt.m9544constructorimpl(com.bytedance.badger.t.d.a(com.bytedance.badger.t.a.a(2147173476, null, new g(r104), 2), 0, 3)));
    L9:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L11:
        throw new C10462c("BadgerCore not initialized", -1001, null, null, 12);
    }

    public final z64.a getBadgerExtraParams() {
        return this.badgerExtraParams;
    }

    public final z64.b getBadgerReport(z64.c r110, boolean r111) {
        com.bytedance.badger.v.d.f199322f0.getClass();
        if (com.bytedance.badger.v.d.g() == true) goto L7;
        e.g(TAG, "Badger not enabled");
        return null;
    L7:
        if (this.isInitialized == false) goto L15;
        checkReadyForReportAndThrow(r111);
        int r112 = com.bytedance.badger.t.a.f199193a;
        com.bytedance.badger.t.a.a(1011326284, null, new h(r110), 2);
        String r113 = genChallenge(r110.b(), r110.getTimestamp());
        long r100 = System.nanoTime();
        com.bytedance.badger.t.d r114 = com.bytedance.badger.t.a.a(411949617, null, new i(r113, r110), 2);
        String r101 = com.bytedance.badger.t.d.c(r114, 2, 2);
        int r102 = com.bytedance.badger.t.d.a(r114, 0, 2);
        if (com.bytedance.badger.t.d.a(r114, 1, 2) != 1) goto L11;
        boolean r103 = true;
    L13:
        return new z64.b(r101, r102, r103, System.nanoTime() - r100);
    L11:
        r103 = false;
        goto L13
    L15:
        throw new IllegalStateException("Badger not initialized");
    }

    @Override // com.bytedance.badger.IBadger
    public Context getContext() {
        if (this.isInitialized == false) goto L9;
        Context r100 = this.applicationContext;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
    L7:
        return r100;
    L9:
        throw new IllegalStateException("Badger not initialized");
    }

    public final String getDeviceId() {
        Function0 r100 = this.deviceIdGetter;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("deviceIdGetter");
    L6:
        return (String) r100.invoke();
    }

    public final String getLastCollectError() {
        return com.bytedance.badger.t.d.c(com.bytedance.badger.t.a.a(950472682, null, null, 6), 0, 3);
    }

    public final int getLastUpdateScene() {
        return this.lastUpdateScene;
    }

    @Override // com.bytedance.badger.IBadger
    public com.bytedance.badger.network.u getLoginHandler() {
        return m0.f199122b;
    }

    @Override // com.bytedance.badger.IBadger
    public v getNetRequestInterface() {
        if (this.isInitialized == false) goto L9;
        v r100 = this.netRequestInterface;
        if (r100 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("netRequestInterface");
    L7:
        return r100;
    L9:
        throw new IllegalStateException("Badger not initialized");
    }

    public final z getPublicIpAddressInfo() {
        Function0 r100 = this.publicIpAddressListGetter;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("publicIpAddressListGetter");
    L6:
        return (z) r100.invoke();
    }

    public final Pair getRequestHeaderTag() {
        return this.requestHeaderTag;
    }

    public final boolean isAppInForeground() {
        Function0 r100 = this.isAppInForegroundGetter;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("isAppInForegroundGetter");
    L6:
        return ((Boolean) r100.invoke()).booleanValue();
    }

    @Override // com.bytedance.badger.IBadger
    public boolean isInitialized() {
        return this.isInitialized;
    }

    public final boolean isLogin() {
        Function0 r100 = this.isLoginGetter;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("isLoginGetter");
    L6:
        return ((Boolean) r100.invoke()).booleanValue();
    }

    @Override // com.bytedance.badger.IBadger
    public void recordEvent(EventReportEnum r100, String r101, Object r102) {
        List r103 = com.bytedance.badger.y.g.f199442a;
        com.bytedance.badger.y.g.e(r100, MapsKt.mapOf(TuplesKt.to(r101, r102)));
    }

    @Override // com.bytedance.badger.IBadger
    public void recordEvent(EventReportEnum r100, Map r101) {
        List r102 = com.bytedance.badger.y.g.f199442a;
        com.bytedance.badger.y.g.e(r100, r101);
    }

    @Override // com.bytedance.badger.IBadger
    public boolean registerBadgerModule(int r100, BadgerModuleBase r101) {
        x0.a(r100, r101);     // Catch: IllegalArgumentException -> L4
        return true;
    L4:
        return false;
    }

    public final void setBadgerExtraParams(z64.a r100) {
        this.badgerExtraParams = r100;
    }

    @Override // com.bytedance.badger.IBadger
    public void setServerTS(String r100) {
        if (initCore() == true) goto L5;
        return;
    L5:
        int r101 = com.bytedance.badger.t.a.f199193a;
        com.bytedance.badger.t.a.a(889777159, null, new p(r100), 2);
    }

    @Override // com.bytedance.badger.IBadger
    public void startBootReport() {
        com.bytedance.badger.utils.k.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        e.c(TAG, "startBootReport - unexpected error", th);
    }

    public final int updateFeatures(z64.c r100, int r101, boolean r102) {
        com.bytedance.badger.v.d.f199322f0.getClass();
        if (com.bytedance.badger.v.d.g() == true) goto L7;
        e.g(TAG, "Badger not enabled");
        return -1;
    L7:
        if (this.isInitialized == false) goto L11;
        checkReadyForReportAndThrow(r102);
        int r103 = com.bytedance.badger.t.a.f199193a;
        com.bytedance.badger.t.a.a(1011326284, null, new r(r100), 2);
        this.lastUpdateScene = r100.getSceneId();
        return com.bytedance.badger.t.d.a(com.bytedance.badger.t.a.a(123898926, null, new s(r100, r101), 2), 0, 3);
    L11:
        throw new IllegalStateException("Badger not initialized");
    }

    static {
        Companion = new j();
        instance$delegate = LazyKt.lazy(c.f199027a);
    }

    public final boolean initCore() {
        if (this.isInitialized == true) goto L7;
        e.e(TAG, "initCore called before badger init");
        return false;
    L7:
        if (this.isCoreInitialized == false) goto L9;
        return true;
    L9:
        com.bytedance.badger.v.d.f199322f0.getClass();
        if (com.bytedance.badger.v.d.g() == true) goto L12;
        return false;
    L12:
        Object r100 = this.initLock;
        monitor-enter(r100);
    L61:
        th = move-exception;
        throw th;
    L15:
        if (this.isCoreInitialized == false) goto L69;
        monitor-exit(r100);
        return true;
    L69:
        INVOKESTATIC_com_bytedance_badger_BadgerCore_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bdbadger");     // Catch: Throwable -> L51 UnsatisfiedLinkError -> L56
        e.f(TAG, "load library success");     // Catch: Throwable -> L61
        com.bytedance.badger.v.m r101 = com.bytedance.badger.v.d.f199327k;     // Catch: Throwable -> L46
        KProperty r102 = com.bytedance.badger.v.d.f199311a[10];     // Catch: Throwable -> L46
        Collection r103 = (Collection) r101.a();     // Catch: Throwable -> L46
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L46
        Iterator r105 = r103.iterator();     // Catch: Throwable -> L46
    L22:
        if (r105.hasNext() == false) goto L26;
        Integer r106 = StringsKt.toIntOrNull((String) r105.next());     // Catch: Throwable -> L46
        if (r106 == null) goto L22;
        r104.add(r106);     // Catch: Throwable -> L46
        goto L22
    L26:
        int[] r107 = CollectionsKt.toIntArray(r104);     // Catch: Throwable -> L46
        int r108 = com.bytedance.badger.t.a.f199193a;     // Catch: Throwable -> L46
        com.bytedance.badger.t.a.a(1997249825, null, new m(r107), 2);     // Catch: Throwable -> L46
        com.bytedance.badger.v.d.f199322f0.getClass();     // Catch: Throwable -> L46
        com.bytedance.badger.v.f r109 = com.bytedance.badger.v.d.E;     // Catch: Throwable -> L46
        KProperty[] r110 = com.bytedance.badger.v.d.f199311a;     // Catch: Throwable -> L46
        KProperty r111 = r110[31];     // Catch: Throwable -> L46
        if (((Boolean) r109.a()).booleanValue() == true) goto L30;
        String r112 = "";
    L34:
        com.bytedance.badger.t.a.a(343452195, null, new n(r112), 2);     // Catch: Throwable -> L46
        com.bytedance.badger.v.l r113 = com.bytedance.badger.v.d.f199336t;     // Catch: Throwable -> L46
        KProperty r114 = r110[20];     // Catch: Throwable -> L46
        String r115 = (String) r113.a();     // Catch: Throwable -> L46
        this.fConfig = r115;     // Catch: Throwable -> L46
        com.bytedance.badger.t.a.a(1373026617, null, new o(r115), 2);     // Catch: Throwable -> L46
        if (this.serverTSV2Provider == null) goto L37;
        com.bytedance.badger.t.a.a(2089126272, this.serverTSV2Provider, null, 4);     // Catch: Throwable -> L46
    L37:
        w0.b();     // Catch: Throwable -> L46
        Flipped.invokeHiddenApiRestrictions();     // Catch: Throwable -> L40
    L43:
        this.isCoreInitialized = true;     // Catch: Throwable -> L46
        monitor-exit(r100);     // Catch: Throwable -> L46
        return true;
    L40:
        th = move-exception;
        e.c(TAG, "Failed to invokeHiddenApiRestrictions: " + th.getMessage(), th);     // Catch: Throwable -> L46
        goto L43
    L30:
        if (Build.VERSION.SDK_INT < 24) goto L32;
        File r116 = getContext().getDataDir();     // Catch: Throwable -> L46
    L33:
        r112 = r116.getAbsolutePath();     // Catch: Throwable -> L46
        goto L34
    L32:
        r116 = getContext().getFilesDir();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        e.c(TAG, "Failed to init core: " + th.getMessage(), th);     // Catch: Throwable -> L61
        return false;
    L56:
        e = move-exception;
        e.c(TAG, "Failed to load library: " + e.getMessage(), e);     // Catch: Throwable -> L61
        return false;
    L51:
        th = move-exception;
        e.c(TAG, "Failed to load library, unknown error: " + th.getMessage(), th);     // Catch: Throwable -> L61
        return false;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_badger_BadgerCore_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public final void checkReadyForReportAndThrow(boolean r100) {
        if (r100 == true) goto L11;
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.f r101 = com.bytedance.badger.v.d.f199335s;
        KProperty r102 = com.bytedance.badger.v.d.f199311a[19];
        if (((Boolean) r101.a()).booleanValue() == true) goto L11;
        if (isAppInForeground() == true) goto L11;
        e.g(TAG, "Badger not in foreground");
        throw new C10462c("Badger not in foreground", SpeechEngineDefines.ERR_UNSUPPORT_AUTHENTICATE_TYPE, null, null, 12);
    L11:
        if (initCore() == false) goto L14;
        return;
    L14:
        throw new C10462c("BadgerCore init failed", -1001, null, null, 12);
    }

    @Override // com.bytedance.badger.IBadger
    public Map getReportHeader(String r310) {
        com.bytedance.badger.C.b r100 = x64.b.f562608a;
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.f r101 = com.bytedance.badger.v.d.Q;
        KProperty[] r102 = com.bytedance.badger.v.d.f199311a;
        KProperty r103 = r102[43];
        Integer r110 = null;
        if (((Boolean) r101.a()).booleanValue() == false) goto L84;
        boolean r111 = true;
        if (r310 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L85;
        com.bytedance.badger.v.m r105 = com.bytedance.badger.v.d.U;
        KProperty r106 = r102[47];
        if (((Collection) r105.a()).isEmpty() == true) goto L16;
        KProperty r107 = r102[47];
        if (((Collection) r105.a()).contains(r310) == false) goto L16;
        return null;
    L16:
        com.bytedance.badger.v.m r108 = com.bytedance.badger.v.d.V;
        KProperty r109 = r102[48];
        if (((Collection) r108.a()).contains(r310) == false) goto L89;
        Companion.getClass();
        if (j.a().isInitialized() == true) goto L22;
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.f199044c, TriggerStage.login, new C10462c("get# not init", -1204, null, null, 12), 0, null, 0, 0, 0, null, null, false, 0, null, z64.h.b.f570472a, 4092);
        return null;
    L22:
        HashMap r112 = new HashMap();
        String r113 = j.a().getDeviceId();     // Catch: Exception -> L71
        if (r113.length() != 0) goto L26;
        boolean r114 = true;
    L27:
        if (r114 == false) goto L29;
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.f199044c, TriggerStage.login, new C10462c("get# deviceId is blank", SpeechEngineDefines.ERR_AUTHENTICATION_FAILED, null, null, 12), 0, null, 0, 0, 0, null, null, false, 0, null, z64.h.b.f570472a, 4092);     // Catch: Exception -> L71
        return null;
    L29:
        long r115 = System.currentTimeMillis();     // Catch: Exception -> L71
        int r116 = com.bytedance.badger.utils.n.f199273a;     // Catch: Exception -> L71
        z64.f r117 = new z64.f(UInt.m9590toStringimpl(UInt.m9544constructorimpl(com.bytedance.badger.utils.n.a(r113.getBytes(Charsets.UTF_8)))), r113, System.currentTimeMillis(), r310, 32);     // Catch: Exception -> L71
        com.bytedance.badger.monitor.c r118 = com.bytedance.badger.monitor.c.f199044c;     // Catch: Exception -> L71
        TriggerStage r119 = TriggerStage.login;     // Catch: Exception -> L71
        CollectStage r120 = CollectStage.collect_pre;     // Catch: Exception -> L71
        z64.h.b r121 = z64.h.b.f570472a;     // Catch: Exception -> L71
        com.bytedance.badger.monitor.c.a(r118, r119, r120, r117, null, 0, 0, 0, null, null, false, 0, null, 0, r121, 6544);     // Catch: Exception -> L71
        z64.b r122 = j.a().getBadgerReport(r117, true);     // Catch: Exception -> L71
        if (r122 == null) goto L35;
        String r123 = r122.f570455a;     // Catch: Exception -> L71
        if (r123 == null) goto L35;
        int r311 = r123.length();     // Catch: Exception -> L71
    L36:
        String r124 = "";
        if (r122 == null) goto L41;
        String r125 = r122.f570455a;     // Catch: Exception -> L71
        if (r125 == null) goto L41;
    L43:
        if (r125.length() != 0) goto L45;
        boolean r126 = true;
    L46:
        if (r126 == true) goto L52;
        if (r122 == null) goto L52;
        if (r122.f570456b != 0) goto L52;
        com.bytedance.badger.monitor.c.a(r118, r119, CollectStage.collect_finished, r117, r122, 0, System.currentTimeMillis() - r115, 0, null, null, false, 0, null, r311, r121, 4048);     // Catch: Exception -> L71
    L66:
        int r127 = r125.length();     // Catch: Exception -> L71
        com.bytedance.badger.v.k r128 = com.bytedance.badger.v.d.S;     // Catch: Exception -> L71
        KProperty r129 = r102[45];     // Catch: Exception -> L71
        if (((Number) r128.a()).longValue() == 0) goto L73;
        long r130 = r127;
        KProperty r131 = r102[45];     // Catch: Exception -> L71
        if (r130 < ((Number) r128.a()).longValue()) goto L73;
    L74:
        r112.put("x-bb-data", r124);     // Catch: Exception -> L71
        r112.put("x-bb-signal", String.valueOf(r117.f570468d));     // Catch: Exception -> L71
        r112.put("x-bb-scene", String.valueOf(r117.f570466b));     // Catch: Exception -> L71
    L82:
        return r112;
    L73:
        r124 = r125;
    L52:
        BadgerCore r132 = j.a();     // Catch: Exception -> L71
        com.bytedance.badger.v.h r133 = com.bytedance.badger.v.d.R;     // Catch: Exception -> L71
        KProperty r134 = r102[44];     // Catch: Exception -> L71
        r132.updateFeatures(r117, ((Number) r133.a()).intValue(), true);     // Catch: Exception -> L71
        z64.b r135 = j.a().getBadgerReport(r117, true);     // Catch: Exception -> L71
        if (r135 == null) goto L57;
        r125 = r135.f570455a;     // Catch: Exception -> L71
        if (r125 == null) goto L57;
    L58:
        StringBuilder r136 = new StringBuilder("data is null and backup, is empty?");     // Catch: Exception -> L71
        if (r125.length() == 0) goto L62;
        r111 = false;
    L62:
        r136.append(r111);     // Catch: Exception -> L71
        r136.append(" code=");     // Catch: Exception -> L71
        if (r122 == null) goto L65;
        r110 = Integer.valueOf(r122.f570456b);     // Catch: Exception -> L71
    L65:
        r136.append(r110);     // Catch: Exception -> L71
        com.bytedance.badger.monitor.c.b(r118, r119, new C10462c(r136.toString(), -1204, null, null, 12), 0, null, 0, 0, 0, r117, null, false, 0, null, r121, 3964);     // Catch: Exception -> L71
    L57:
        r125 = "";
        goto L58
    L45:
        r126 = false;
    L41:
        r125 = "";
    L35:
        r311 = 0;
        goto L36
    L26:
        r114 = false;
    L71:
        e = move-exception;
        com.bytedance.badger.monitor.c.b(com.bytedance.badger.monitor.c.f199044c, TriggerStage.login, new C10462c(e.toString(), -1204, null, null, 12), 0, null, 0, 0, 0, null, null, false, 0, null, z64.h.b.f570472a, 4092);
        goto L82
    L89:
        return null;
    L85:
        return null;
    L7:
        if (r310.length() == 0) goto L10;
        r104 = false;
        goto L11
    L84:
        return null;
    }

    @Override // com.bytedance.badger.IBadger
    public boolean init(a r100) {
        if (this.isInitialized == false) goto L5;
        return true;
    L5:
        Object r101 = this.initLock;
        monitor-enter(r101);
    L29:
        th = move-exception;
        throw th;
    L8:
        if (this.isInitialized == false) goto L11;
        monitor-exit(r101);
        return true;
    L11:
        this.applicationContext = r100.getContext().getApplicationContext();     // Catch: Throwable -> L29
        AppContextBridge.set(r100.getContext().getApplicationContext());     // Catch: Throwable -> L29
        this.netRequestInterface = r100.getNetRequestInterface();     // Catch: Throwable -> L29
        this.deviceIdGetter = r100.c();     // Catch: Throwable -> L29
        this.publicIpAddressListGetter = r100.a();     // Catch: Throwable -> L29
        this.badgerExtraParams = r100.getExtraParams();     // Catch: Throwable -> L29
        this.isLoginGetter = r100.d();     // Catch: Throwable -> L29
        this.isAppInForegroundGetter = r100.b();     // Catch: Throwable -> L29
        this.requestHeaderTag = r100.getRequestTagHeader();     // Catch: Throwable -> L29
        com.ss.android.badger.a r102 = r100.getLogger();     // Catch: Throwable -> L29
        if (r102 == null) goto L14;
        d r103 = e.f199030a;     // Catch: Throwable -> L29
        e.f199030a = r102;     // Catch: Throwable -> L29
    L14:
        this.isInitialized = true;     // Catch: Throwable -> L29
        Iterator r104 = this.initListeners.iterator();     // Catch: Throwable -> L29
    L16:
        if (r104.hasNext() == false) goto L23;
        ((Function0) r104.next()).invoke();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        e.c(TAG, "Failed to call init listener: " + th.getMessage(), th);     // Catch: Throwable -> L29
        goto L16
    L23:
        Context r105 = this.applicationContext;     // Catch: Throwable -> L29
        if (r105 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");     // Catch: Throwable -> L29
    L26:
        initBadgerCollect(r105, r100.getAppId());     // Catch: Throwable -> L29
        monitor-exit(r101);
        return true;
    }

    @Override // com.bytedance.badger.IBadger
    public void notifyUserAction(z64.e r100) {
        e.f("BadgerGlobalUserActionHandler", "handle - action: " + r100);
        com.bytedance.badger.utils.k.b(r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        e.c("BadgerGlobalUserActionHandler", "handle - unexpected error", th);
    }

    @Override // com.bytedance.badger.IBadger
    public void setDefaultConfig(y64.a r100) {
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.d.f199315c = r100;
    }

    @Override // com.bytedance.badger.IBadger
    public void setServerTSV2Provider(Function0 r100) {
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.f r101 = com.bytedance.badger.v.d.f199320e0;
        KProperty r102 = com.bytedance.badger.v.d.f199311a[57];
        if (((Boolean) r101.a()).booleanValue() == true) goto L6;
        return;
    L6:
        if (this.isCoreInitialized == false) goto L9;
        com.bytedance.badger.t.a.a(2089126272, r100, null, 4);
        return;
    L9:
        this.serverTSV2Provider = r100;
    }

    @Override // com.bytedance.badger.IBadger
    public void updateConfig(JSONObject r100) {
        com.bytedance.badger.v.d.f199322f0.getClass();
        StringBuilder r101 = new StringBuilder("updateConfig: ");
        if (r100 == null) goto L5;
        Integer r102 = Integer.valueOf(r100.length());
    L6:
        r101.append(r102);
        e.f("BadgerConfig", r101.toString());
        com.bytedance.badger.v.d.f199313b = r100;
        com.bytedance.badger.v.l r103 = com.bytedance.badger.v.d.f199336t;
        KProperty r104 = com.bytedance.badger.v.d.f199311a[20];
        String r105 = (String) r103.a();
        if (this.isCoreInitialized == true) goto L9;
        return;
    L9:
        if ((!Intrinsics.areEqual(r105, this.fConfig)) == false) goto L13;
        this.fConfig = r105;
        int r106 = com.bytedance.badger.t.a.f199193a;
        com.bytedance.badger.t.a.a(1373026617, null, new q(r105), 2);
        return;
    L13:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.badger.IBadger
    public void updateReport(String r210) {
        com.bytedance.badger.C.b r100 = x64.b.f562608a;
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.f r101 = com.bytedance.badger.v.d.Q;
        KProperty r102 = com.bytedance.badger.v.d.f199311a[43];
        if (((Boolean) r101.a()).booleanValue() == false) goto L33;
        Companion.getClass();
        if (j.a().isInitialized() == false) goto L33;
        if (j.a().initCore() == true) goto L12;
        e.e("ReportManager", "updateReport# initCore error");
        com.bytedance.badger.monitor.c r103 = com.bytedance.badger.monitor.c.f199044c;
        TriggerStage r104 = TriggerStage.login;
        C10462c r105 = r5;
        C10462c r106 = new C10462c("update# initCore fail", -1203, null, null, 12);
    L10:
        com.bytedance.badger.monitor.c.b(r103, r104, r105, 0, null, 0, 0, 0, null, null, false, 0, null, z64.h.b.f570472a, 4092);
        return;
    L12:
        if (StringsKt.isBlank(r210) == false) goto L14;
        String r107 = "default";
    L15:
        AtomicReference r108 = x64.b.f562612e;
        if (((String) r108.get()) != null) goto L23;
    L18:
        if (r108.compareAndSet(null, r107) == true) goto L23;
        if (r108.get() == null) goto L18;
    L23:
        if ((!Intrinsics.areEqual((String) r108.get(), r107)) == false) goto L26;
        r103 = com.bytedance.badger.monitor.c.f199044c;
        r104 = TriggerStage.login;
        r105 = r5;
        C10462c r109 = new C10462c("update# scene not match = " + r107, -1203, null, null, 12);
        goto L10
    L26:
        if (j.a().isInitialized() == true) goto L35;
        com.bytedance.badger.monitor.c r110 = com.bytedance.badger.monitor.c.f199044c;
        com.bytedance.badger.monitor.c r111 = r110;
        TriggerStage r112 = TriggerStage.login;
        C10462c r113 = new C10462c("update# not init", -1203, null, null, 12);
    L32:
        com.bytedance.badger.monitor.c.b(r111, r112, r113, 0, null, 0, 0, 0, null, null, false, 0, null, z64.h.b.f570472a, 4092);
        return;
    L35:
        x64.b.c();     // Catch: Exception -> L30
        return;
    L30:
        e = move-exception;
        com.bytedance.badger.monitor.c r114 = com.bytedance.badger.monitor.c.f199044c;
        r111 = r114;
        r112 = TriggerStage.login;
        r113 = new C10462c(e.toString(), -1203, null, null, 12);
        goto L32
    L14:
        r107 = r210;
    L33:
        e.g("ReportManager", "updateReport# not allow");
    }

    private final void initBadgerCollect(Context r100, int r101) {
        u r102 = new u(this);
        Integer r103 = Integer.valueOf(r101);
        com.bytedance.badger.v.d.f199322f0.getClass();
        com.bytedance.badger.v.l r104 = com.bytedance.badger.v.d.K;
        KProperty r105 = com.bytedance.badger.v.d.f199311a[37];
        BadgerCollectApi.init(new BadgerCollectApi.Builder(r100, r103, (String) r104.a(), r102).commonConfig(new l(this)).setLogger(new t()).build());
    }

    public final int addSceneCompletionCallback(int r100, Function1 r110) {
        com.bytedance.badger.v.d.f199322f0.getClass();
        if (com.bytedance.badger.v.d.g() == true) goto L7;
        e.g(TAG, "Badger not enabled");
        return -1;
    L7:
        if (this.isInitialized == false) goto L17;
        if (initCore() == false) goto L15;
        k r101 = new k(r110);
        f r111 = new f(r100);
        com.bytedance.badger.t.c r102 = new com.bytedance.badger.t.c(94276081);
        r111.invoke(r102);
        if (r102.a(r101).e() == false) goto L18;
        return 0;
    L18:
        return -1;
    L15:
        throw new C10462c("BadgerCore not initialized", -1001, null, null, 12);
    L17:
        throw new IllegalStateException("Badger not initialized");
    }

    @Override // com.bytedance.badger.IBadger
    public void doBadgerReport(int r100, z64.h r101, z64.g r102) {
        z0 r103 = d0.f199093a;
        d0.b(r100, r101, r102, false);
    }

    @Override // com.bytedance.badger.IBadger
    public void log(int r100, String r101, String r102, Throwable r103) {
        if (r100 != 3) goto L5;
        StringBuilder r104 = new StringBuilder();
        r104.append(r102);
        if (r103 == null) goto L22;
        String r105 = " " + r103.getMessage();
        if (r105 == null) goto L22;
    L23:
        r104.append(r105);
        e.b(r101, r104.toString());
        return;
    L22:
        r105 = "";
        goto L23
    L5:
        if (r100 != 5) goto L7;
        d r106 = e.f199030a;
        d r107 = e.f199030a;
        if (r106 == null) goto L16;
        r106.w(e.a(r101), r102, r103);
        return;
    L16:
        e.a(r101);
        return;
    L7:
        if (r100 == 6) goto L12;
        d r108 = e.f199030a;
        d r109 = e.f199030a;
        if (r108 == null) goto L11;
        r108.i(e.a(r101), r102, r103);
        return;
    L11:
        e.a(r101);
        return;
    L12:
        e.c(r101, r102, r103);
    }
}
