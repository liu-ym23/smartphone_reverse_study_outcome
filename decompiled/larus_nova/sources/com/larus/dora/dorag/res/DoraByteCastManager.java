package com.larus.dora.dorag.res;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.camera.core.RetryPolicy;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import com.byted.cast.common.Dispatcher;
import com.byted.cast.common.Logger;
import com.byted.cast.common.api.CodecType;
import com.byted.cast.common.api.ICastSink;
import com.byted.cast.common.api.ILogger;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.config.IInitListener;
import com.byted.cast.common.sink.CastInfo;
import com.byted.cast.common.sink.IServer;
import com.byted.cast.common.sink.IServerListener;
import com.bytedance.android.shopping.yata.business.ability.common.TriggerTiming;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.applog.api.IApplog;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.avlink.plugins.u2;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IByteCastManager;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.cast.sink.ByteCastSinkImpl$11;
import com.ss.cast.sink.api.ByteCastSink$3;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import t39.s;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000ù\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001H\b\u0007\u0018\u0000  \u00012\u00020\u0001:\u0002 \u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010E\u001a\u00020FH\u0016J\b\u0010J\u001a\u00020\nH\u0016J\b\u0010K\u001a\u00020FH\u0016J\b\u0010L\u001a\u00020FH\u0002J\b\u0010M\u001a\u00020FH\u0002J\b\u0010N\u001a\u00020FH\u0002J\u0010\u0010O\u001a\u00020F2\u0006\u0010P\u001a\u00020\nH\u0002J\u0016\u0010Q\u001a\u00020F2\f\u0010R\u001a\b\u0012\u0004\u0012\u00020F0SH\u0002J\u0010\u0010T\u001a\u00020F2\u0006\u0010U\u001a\u00020\nH\u0002J\u0010\u0010V\u001a\u00020F2\u0006\u0010W\u001a\u00020\u0005H\u0002J\b\u0010X\u001a\u00020FH\u0002J\b\u0010Y\u001a\u00020FH\u0002J\b\u0010Z\u001a\u00020FH\u0016J\b\u0010[\u001a\u00020\nH\u0016J\u0010\u0010\\\u001a\u00020F2\u0006\u0010]\u001a\u00020\nH\u0016J\b\u0010^\u001a\u00020\nH\u0016J\b\u0010_\u001a\u00020\nH\u0016J\b\u0010`\u001a\u00020\nH\u0016J\u0010\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\nH\u0016J\n\u0010c\u001a\u0004\u0018\u00010/H\u0016J\n\u0010d\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010e\u001a\u00020F2\u0006\u0010f\u001a\u00020\u0015H\u0016J\b\u0010g\u001a\u00020FH\u0002J\b\u0010h\u001a\u00020FH\u0002J\u0010\u0010i\u001a\u00020\"2\u0006\u0010j\u001a\u00020%H\u0002J\u001a\u0010k\u001a\u00020F2\b\u0010l\u001a\u0004\u0018\u00010\u00122\u0006\u0010m\u001a\u00020\u0005H\u0002J\b\u0010n\u001a\u00020FH\u0002J\u0012\u0010o\u001a\u00020p2\b\u0010q\u001a\u0004\u0018\u00010rH\u0002J\b\u0010s\u001a\u00020\"H\u0002J\b\u0010t\u001a\u00020FH\u0002J\u0010\u0010u\u001a\u00020-2\u0006\u0010v\u001a\u00020wH\u0002J\u0010\u0010x\u001a\u00020F2\u0006\u0010y\u001a\u00020/H\u0002J\b\u0010z\u001a\u00020FH\u0002J\u0010\u0010{\u001a\u00020F2\u0006\u0010|\u001a\u000202H\u0002J\b\u0010}\u001a\u00020FH\u0002J\b\u0010~\u001a\u00020FH\u0002J\u001b\u0010\u007f\u001a\u00020F2\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0003\u0010\u0081\u0001J(\u0010\u0082\u0001\u001a\u00020F2\u0007\u0010\u0083\u0001\u001a\u00020\u00052\u0014\u0010\u0084\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0085\u0001H\u0002J\u001e\u0010\u0086\u0001\u001a\u00030\u0087\u00012\t\u0010\u0088\u0001\u001a\u0004\u0018\u0001042\u0007\u0010\u0089\u0001\u001a\u00020\u0015H\u0002J\u0013\u0010\u008a\u0001\u001a\u00030\u008b\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u0015H\u0002J\u0012\u0010\u008c\u0001\u001a\u00020F2\u0007\u0010\u0089\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u008d\u0001\u001a\u00020FH\u0002J\u0014\u0010\u008e\u0001\u001a\u0004\u0018\u00010/2\u0007\u0010\u008f\u0001\u001a\u00020wH\u0002J\u001e\u0010\u0090\u0001\u001a\u0004\u0018\u00010\"*\u00020w2\u0007\u0010\u0091\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0003\u0010\u0092\u0001J\u0012\u0010\u0093\u0001\u001a\u00020F2\u0007\u0010\u0094\u0001\u001a\u00020\bH\u0016J\t\u0010\u0095\u0001\u001a\u00020FH\u0016J\t\u0010\u0096\u0001\u001a\u00020FH\u0016J\u0010\u0010\u0097\u0001\u001a\u00020F2\u0007\u0010\u0098\u0001\u001a\u00020\"J\u001b\u0010\u0099\u0001\u001a\u00020F2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0002J\u0007\u0010\u009c\u0001\u001a\u00020FJ\u001b\u0010\u009d\u0001\u001a\u00020F2\u0007\u0010\u009e\u0001\u001a\u00020\u00052\u0007\u0010\u009f\u0001\u001a\u00020wH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020:09X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010A\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0004\n\u0002\u0010I¨\u0006¡\u0001"}, d2 = {"Lcom/larus/dora/dorag/res/DoraByteCastManager;", "Lcom/larus/dora/api/IByteCastManager;", "<init>", "()V", "TAG", "", "VIDEO_DUMP_ENABLE", "dataCallBack", "Lcom/larus/dora/api/IByteCastDataCallBack;", "canSetByteCastRandomPortOption", "", "setByteCastRandomPortLock", "", "byteCastSink", "Lcom/ss/cast/sink/api/ByteCastSink;", "clientId", "videoCodecInfo", "", "", "connectedClientIds", "p2pRTCClientOwnershipVersion", "", "p2pRTCReleaseInProgress", "p2pRTCCompanionRetention", "Ljava/util/concurrent/atomic/AtomicBoolean;", "byteCastThread", "Landroid/os/HandlerThread;", "byteCastHandler", "Landroid/os/Handler;", "getByteCastHandler", "()Landroid/os/Handler;", "byteCastHandler$delegate", "Lkotlin/Lazy;", "transType", "", "byteCastReady", "lastCastInfo", "Lcom/byted/cast/common/sink/CastInfo;", "currentEnableStartUsbServer", "Ljava/lang/Boolean;", "wifiStateReceiver", "Landroid/content/BroadcastReceiver;", "isTransmitting", "()Z", "lastMirrorData", "Lcom/larus/dora/api/MirrorData;", "lastBtMonitorData", "Lcom/larus/dora/api/BluetoothBandwidthMonitorData;", "lastBtMonitorDataTimeMs", "lastBtMonitorSnapshot", "Lcom/larus/dora/api/BluetoothBandwidthMonitorSnapshot;", "lastRtcAverageBitrate", "Lcom/larus/dora/dorag/res/RtcAverageBitrateSample;", "phoneCountRequested", "btRtcNqeEnabled", "mmtTargetBitrateLock", "mmtTargetBitrateSamples", "Ljava/util/ArrayDeque;", "Lcom/larus/dora/dorag/res/TimedMmtTargetBitrate;", "vos", "Ljava/io/FileOutputStream;", "aos", "keva", "Lcom/bytedance/keva/Keva;", "videoDumpEnable", "currentRTCChannelConfigs", "", "Lcom/larus/dora/api/model/DoraRTCChannelConfig;", "callbacksInitialized", "init", "", "doraLinkCallback", "com/larus/dora/dorag/res/DoraByteCastManager$doraLinkCallback$1", "Lcom/larus/dora/dorag/res/DoraByteCastManager$doraLinkCallback$1;", "isInitSuccess", "initAfterAbilityNegotiation", "initAfterAbilityNegotiationInternal", "reRegisterRTCChannel", "registerWifiStateReceiver", "handleWifiStateChanged", "wifiEnabled", "runOnByteCastExecutor", "block", "Lkotlin/Function0;", "initByteCastSink", "enableStartUsbServer", "setByteRandomPortOption", "where", "startServer", "deInitByteCastSink", "finishSession", "getRtcVideoDumpEnable", "syncRtcVideoDumpEnable", "checked", "isBtRtcRunning", "isP2PRTCClientConnected", "invalidateP2PRTCClientOwnership", "updateP2PRTCCompanionRetention", "retain", "getBtBandwidthMonitorData", "getBtBandwidthMonitorSnapshot", "recordMmtTargetBitrate", "targetBitrateBps", "setServerListener", "setMirrorListener", "parseVideoPort", "castInfo", "dumpVideo", "data", "frameType", "closeFile", "getVideoCodecType", "Lcom/larus/im/service/audio/vlm/EncodedVideoCodecType;", "type", "Lcom/byted/cast/common/api/CodecType$VCODEC_ID;", "getVideoRotation", "setMessageListener", "parseMirrorData", "mirrorJson", "Lorg/json/JSONObject;", "handleBtMonitorData", "monitorData", "requestBtConnectedPhoneCount", "reportBtRtcHeartbeat", "snapshot", "clearBtMonitorState", "clearBtMonitorData", "updateBtRtcMetricsState", "forceEnabled", "(Ljava/lang/Boolean;)V", "handleRtcTransferStats", "event", "params", "", "getValidRtcAverageBitrate", "", "sample", TriggerTiming.NOW, "getMmtTargetBitrateSnapshot", "Lcom/larus/dora/dorag/res/MmtTargetBitrateSnapshot;", "trimMmtTargetBitrateSamples", "clearMmtTargetBitrateSamples", "parseBtMonitorData", "monitorJson", "optValidInt", "name", "(Lorg/json/JSONObject;Ljava/lang/String;)Ljava/lang/Integer;", "setDataCallBack", "callBack", "clearDataCallBack", "requestKeyFrame", "changeFps", "fps", "dispatchVideoFrame", "frame", "Lcom/larus/im/service/audio/vlm/EncodedVideoFrameParam;", "changeEncodedModeToH265", "changeSinkConfig", "cmd", "param", "Companion", "dorag-res_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraByteCastManager implements IByteCastManager {
    public static final /* synthetic */ int D = 0;
    public List<b49.c> A;
    public final AtomicBoolean B;
    public final c C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f331811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t39.g f331812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f331813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f331814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ss.cast.sink.api.g f331815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f331816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, byte[]> f331817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Boolean> f331818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f331819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f331820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f331821k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f331822l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f331823m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f331824n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f331825o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CastInfo f331826p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Boolean f331827q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DoraByteCastManager$registerWifiStateReceiver$receiver$1 f331828r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile s f331829s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile p f331830t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f331831u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f331832v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f331833w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ArrayDeque<q> f331834x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PolarisFileOutputStreamWrapper f331835y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f331836z;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f331837a = null;

        static {
            int[] r100 = new int[CodecType.VCODEC_ID.values().length];
            r100[CodecType.VCODEC_ID.H265.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f331837a = r100;
        }
    }

    public static final class c implements t39.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraByteCastManager f331838a;

        public c(DoraByteCastManager r100) {
            this.f331838a = r100;
        }

        @Override // t39.n
        public final void e(final int r100, int r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r102, "productName");
            final DoraByteCastManager r104 = this.f331838a;
            DoraByteCastManager.n(r104, new com.larus.dora.dorag.res.f(r104, r100));
        }
    }

    public static final class d implements f49.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraByteCastManager f331839a;

        @Override // f49.a
        public final void a() {
            final DoraByteCastManager r100 = this.f331839a;
            DoraByteCastManager.n(r100, new g(r100));
        }

        public d(DoraByteCastManager r100) {
            this.f331839a = r100;
        }
    }

    public static final class e implements IInitListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraByteCastManager f331840a;

        @Override // com.byted.cast.common.config.IInitListener
        public final /* synthetic */ void onFail(int r100, String r101, Exception r102) {
            IInitListener.CC.$default$onFail(this, r100, r101, r102);
        }

        @Override // com.byted.cast.common.config.IInitListener
        public final void onSuccess() {
            FLogger r100 = FLogger.f375446a;
            r100.i(this.f331840a.f331811a, "onSuccess: ");
            this.f331840a.f331825o = true;
            DoraByteCastManager r101 = this.f331840a;
            r101.getClass();
            r100.i(r101.f331811a, "startServer: byteCastReady: " + r101.f331825o);
            final com.ss.cast.sink.api.g r102 = r101.f331815e;
            if (r102 == null) goto L6;
            Dispatcher.getInstance().runOnByteCastThread(new com.ss.cast.sink.api.c(r102));
            return;
        }

        public e(DoraByteCastManager r100) {
            this.f331840a = r100;
        }

        @Override // com.byted.cast.common.config.IInitListener
        public final void onError(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "errMsg");
            FLogger.f375446a.i(this.f331840a.f331811a, "onInitCallback ----------->false");
            this.f331840a.f331825o = false;
            this.f331840a.f331827q = null;
        }
    }

    public static final class f implements ILogger {
        public f() {
        }

        @Override // com.byted.cast.common.api.ILogger
        public final void onVerbose(String r100, String r101) {
        }

        @Override // com.byted.cast.common.api.ILogger
        public final void onDebug(String r100, String r101) {
            boolean r102 = false;
            if (r100 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L18;
            if (r101 != null) goto L12;
        L13:
            r102 = true;
        L14:
            if (r102 == true) goto L19;
            FLogger.f375446a.i(r100, r101);
            return;
        L19:
            return;
        L12:
            if (r101.length() != 0) goto L14;
        L18:
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r103 = false;
            goto L9
        }

        @Override // com.byted.cast.common.api.ILogger
        public final void onError(String r100, String r101) {
            boolean r102 = false;
            if (r100 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L18;
            if (r101 != null) goto L12;
        L13:
            r102 = true;
        L14:
            if (r102 == true) goto L19;
            FLogger.f375446a.e(r100, r101);
            return;
        L19:
            return;
        L12:
            if (r101.length() != 0) goto L14;
        L18:
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r103 = false;
            goto L9
        }

        @Override // com.byted.cast.common.api.ILogger
        public final void onInfo(String r100, String r101) {
            boolean r102 = false;
            if (r100 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L18;
            if (r101 != null) goto L12;
        L13:
            r102 = true;
        L14:
            if (r102 == true) goto L19;
            FLogger.f375446a.i(r100, r101);
            return;
        L19:
            return;
        L12:
            if (r101.length() != 0) goto L14;
        L18:
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r103 = false;
            goto L9
        }

        @Override // com.byted.cast.common.api.ILogger
        public final void onWarn(String r100, String r101) {
            boolean r102 = false;
            if (r100 != null) goto L5;
        L8:
            boolean r103 = true;
        L9:
            if (r103 == true) goto L18;
            if (r101 != null) goto L12;
        L13:
            r102 = true;
        L14:
            if (r102 == true) goto L19;
            FLogger.f375446a.w(r100, r101);
            return;
        L19:
            return;
        L12:
            if (r101.length() != 0) goto L14;
        L18:
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r103 = false;
            goto L9
        }

        @Override // com.byted.cast.common.api.ILogger
        public final void onError(String r100, String r101, Throwable r102) {
            boolean r103 = false;
            if (r100 != null) goto L5;
        L8:
            boolean r104 = true;
        L9:
            if (r104 == true) goto L18;
            if (r101 != null) goto L12;
        L13:
            r103 = true;
        L14:
            if (r103 == true) goto L19;
            FLogger.f375446a.e(r100, r101);
            return;
        L19:
            return;
        L12:
            if (r101.length() != 0) goto L14;
        L18:
            return;
        L5:
            if (r100.length() == 0) goto L8;
            r104 = false;
            goto L9
        }
    }

    static {
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void f() {
        this.f331812b = null;
        FLogger.f375446a.i(this.f331811a, "video data callback cleared, subsequent video frames will be dropped");
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean c() {
        Map<String, Boolean> r100 = this.f331818h;
        monitor-enter(r100);
        Collection r101 = ((LinkedHashMap) this.f331818h).values();     // Catch: Throwable -> L17
        boolean r102 = false;
        if ((r101 instanceof Collection) == true) goto L7;
    L9:
        Iterator r103 = r101.iterator();     // Catch: Throwable -> L17
    L10:
        if (r103.hasNext() == false) goto L15;
        if (((Boolean) r103.next()).booleanValue() == false) goto L10;
        r102 = true;
    L15:
        monitor-exit(r100);
        return r102;
    L7:
        if (r101.isEmpty() == false) goto L9;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void c0() {
        FLogger.f375446a.i(this.f331811a, "finishSession: clientId: " + this.f331816f);
        y(Boolean.FALSE);
        this.f331831u = false;
        o();
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean h() {
        Map<String, Boolean> r100 = this.f331818h;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f331820j == false) goto L7;
        boolean r101 = false;
    L10:
        monitor-exit(r100);
        FLogger.f375446a.i(this.f331811a, "invalidateP2PRTCClientOwnership: invalidated=" + r101);
        return r101;
    L7:
        r101 = CollectionsKt.removeAll(((LinkedHashMap) this.f331818h).entrySet(), new com.larus.dora.dorag.res.d());     // Catch: Throwable -> L13
        if (r101 == false) goto L10;
        this.f331819i++;     // Catch: Throwable -> L13
        goto L10
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void init() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.B.compareAndSet(false, true) == true) goto L16;
        return;
    L16:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L10
        r100.o0().n(new d(this));     // Catch: Throwable -> L10
        v();     // Catch: Throwable -> L10
        r100.V0(this.C);     // Catch: Throwable -> L10
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L18;
        this.B.set(false);
        FLogger.f375446a.e(this.f331811a, "init: register callbacks failed", r103);
        return;
    L18:
        return;
    L10:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final void o() {
        PolarisFileOutputStreamWrapper r100 = this.f331835y;
        if (r100 == null) goto L5;
        r100.close();
    L5:
        this.f331835y = null;
    }

    public final void p() {
        if (DoraAVLinkDelegate.f291640b.z1() == false) goto L12;
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 == null) goto L9;
        AbilityService r101 = r100.o0();
        if (r101 == null) goto L9;
        boolean r102 = r101.k();
    L10:
        q(!r102);
        u();
        return;
    L9:
        r102 = false;
        goto L10
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void requestKeyFrame() {
        JSONObject r100 = new JSONObject();
        Intrinsics.checkNotNullParameter("requestIDR", "cmd");
        Intrinsics.checkNotNullParameter(r100, "param");
        JSONObject r101 = new JSONObject();
        r101.put("cmd", "requestIDR");
        Iterator<String> r102 = r100.keys();
    L4:
        if (r102.hasNext() == false) goto L6;
        String r103 = r102.next();
        r101.put(r103, r100.opt(r103));
        goto L4
    L6:
        FLogger.f375446a.i(this.f331811a, "changeSinkConfig: message: " + r101);
        com.ss.cast.sink.api.g r104 = this.f331815e;
        if (r104 == null) goto L17;
        CastInfo r105 = this.f331826p;
        String r106 = r101.toString();
        if (r105 != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(r106) == true) goto L21;
        com.ss.cast.sink.j r107 = r104.f456435a;
        r107.getClass();
        Logger.d("ByteCastSinkImpl", "send CastInfo:" + r105 + ", message:" + r106);
        Iterator r108 = ((ConcurrentHashMap) r107.f456456i).keySet().iterator();
    L15:
        if (r108.hasNext() == false) goto L22;
        ((ICastSink) ((ConcurrentHashMap) r107.f456456i).get((String) r108.next())).send(r105, r106, null);
        goto L15
    L22:
        return;
    L21:
        return;
    }

    public final boolean s() {
        Map<String, Boolean> r100 = this.f331818h;
        monitor-enter(r100);
        boolean r101 = !this.f331818h.isEmpty();
        monitor-exit(r100);
        return r101;
    L8:
        th = move-exception;
        throw th;
    }

    public final void u() {
        List<b49.c> r100 = this.A;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((!r100.isEmpty()) == false) goto L13;
        IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r101 == null) goto L14;
        AbilityService r102 = r101.o0();
        if (r102 == null) goto L15;
        r102.o(r100);
        return;
    L15:
        return;
    L14:
        return;
    }

    public final void v() {
        if (this.f331828r == null) goto L5;
        return;
    L5:
        DoraByteCastManager$registerWifiStateReceiver$receiver$1 r100 = new DoraByteCastManager$registerWifiStateReceiver$receiver$1(this);
        i(AppHost.f326268a.getApplication().getApplicationContext(), r100, new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED"));     // Catch: Exception -> L8
        this.f331828r = r100;     // Catch: Exception -> L8
        FLogger.f375446a.i(this.f331811a, "registerWifiStateReceiver success");     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e(this.f331811a, "registerWifiStateReceiver failed", e);
    }

    public DoraByteCastManager() {
        this.f331811a = "DoraByteCastManager";
        this.f331813c = true;
        this.f331814d = new Object();
        this.f331816f = "";
        this.f331817g = new ConcurrentHashMap();
        this.f331818h = new LinkedHashMap();
        this.f331821k = new AtomicBoolean(false);
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("DoraByteCastManager", -2);
        ThreadMethodProxy.start(r100);
        this.f331822l = r100;
        this.f331823m = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new com.larus.dora.dorag.res.b(this));
        this.f331833w = new Object();
        this.f331834x = new ArrayDeque();
        this.f331836z = Keva.getRepo("dora_byte_cast").getBoolean("video_dump_enable", false);
        this.B = new AtomicBoolean(false);
        this.C = new c(this);
    }

    public final boolean r() {
        if (s() == false) goto L13;
        s r100 = this.f331829s;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r100.f544487h != 0) goto L9;
        r101 = true;
        goto L10
    L13:
        return false;
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean a() {
        return this.f331825o;
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void d() {
        p();
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final boolean b(boolean r100) {
        boolean r101 = this.f331821k.getAndSet(r100);
        FLogger.f375446a.i(this.f331811a, "updateP2PRTCCompanionRetention: previous=" + r101 + ", retain=" + r100);
        return r101;
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void e(long r100) {
        if (r100 > 0) goto L5;
        return;
    L5:
        if (s() == false) goto L42;
        s r101 = this.f331829s;
        boolean r102 = false;
        if (r101 != null) goto L9;
    L14:
        boolean r103 = false;
    L15:
        if (r103 == true) goto L43;
        long r104 = SystemClock.elapsedRealtime();
        Object r105 = this.f331833w;
        monitor-enter(r105);
    L36:
        th = move-exception;
        throw th;
    L20:
        if (s() == false) goto L34;
        s r106 = this.f331829s;     // Catch: Throwable -> L36
        if (r106 != null) goto L24;
    L29:
        if (r102 == true) goto L34;
        this.f331834x.addLast(new q(r100, r104));     // Catch: Throwable -> L36
        x(r104);     // Catch: Throwable -> L36
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L36
        monitor-exit(r105);
        return;
    L24:
        if (r106.f544487h == 0) goto L26;
        boolean r108 = true;
    L27:
        if (r108 != true) goto L29;
        r102 = true;
        goto L29
    L26:
        r108 = false;
    L34:
        monitor-exit(r105);
        return;
    L43:
        return;
    L9:
        if (r101.f544487h == 0) goto L11;
        boolean r109 = true;
    L12:
        if (r109 != true) goto L14;
        r103 = true;
        goto L15
    L11:
        r109 = false;
        goto L12
    }

    @Override // com.larus.dora.api.IByteCastManager
    public final void g(u2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        this.f331812b = r100;
        FLogger.f375446a.i(this.f331811a, "video data callback registered");
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.dora.dorag.res.c] */
    public final void q(boolean r100) {
        Boolean r101 = this.f331827q;
        if (r101 == null) goto L6;
        FLogger.f375446a.i(this.f331811a, "init: reuse UDP/TCP sink, enableStartUsbServer=" + this.f331827q);
        return;
    L6:
        if (r101 == null) goto L13;
        FLogger.f375446a.i(this.f331811a, "init: reinit for transport switch, from enableStartUsbServer=" + this.f331827q + " to " + r100);
        com.ss.cast.sink.api.g r102 = this.f331815e;
        if (r102 == null) goto L10;
        Dispatcher.getInstance().runOnByteCastThread(new com.ss.cast.sink.api.d(r102));
    L10:
        com.ss.cast.sink.api.g r103 = this.f331815e;
        if (r103 == null) goto L13;
        Dispatcher.getInstance().runOnByteCastThread(new com.ss.cast.sink.api.a(r103));
    L13:
        this.f331825o = false;
        this.f331827q = Boolean.valueOf(r100);
        FLogger r104 = FLogger.f375446a;
        r104.i(this.f331811a, "init: enableStartUsbServer=" + r100);
        Config.Builder r105 = new Config.Builder();
        AppHost.Companion r106 = AppHost.f326268a;
        final Config r107 = r105.setAppId(String.valueOf(r106.getAppId())).setProjectId("6b71d18f-1cd1-4399-b411-836187a6c905").setDeviceId(IApplog.f287053a.getDeviceId()).setLicensePath("license/759c752e-b9b6-4339-8364-c53f60b751de.license").setServiceName("PROJECT_W").setLocalProtocols("ByteLink").enableDebug(true).enablePlaying(false).enableCallbackMediaStream(true).enableStartUsbServer(r100).setMonitor(new com.larus.dora.dorag.res.a(new com.larus.dora.dorag.res.c(this))).setLogger(new f()).build();
        this.f331815e = com.ss.cast.sink.api.g.a();
        Object r108 = this.f331814d;
        monitor-enter(r108);
        this.f331813c = false;     // Catch: Throwable -> L60
        com.ss.cast.sink.api.g r109 = this.f331815e;     // Catch: Throwable -> L60
        if (r109 == null) goto L18;
        r109.b(new Object[]{Boolean.TRUE});     // Catch: Throwable -> L60
    L18:
        final com.ss.cast.sink.api.g r110 = this.f331815e;     // Catch: Throwable -> L60
        if (r110 == null) goto L21;
        final Context r111 = r106.getApplication().getApplicationContext();     // Catch: Throwable -> L60
        final e r112 = new e(this);     // Catch: Throwable -> L60
        Dispatcher.getInstance().runOnByteCastThread(new com.ss.cast.sink.api.b(r110, r107, r111, r112));     // Catch: Throwable -> L60
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L60
    L21:
        monitor-exit(r108);
        r104.i(this.f331811a, "setServerListener: byteCastSink: " + this.f331815e);
        com.ss.cast.sink.api.g r114 = this.f331815e;
        if (r114 == null) goto L39;
        final m r115 = new m(this);
        IServerListener r116 = new ByteCastSink$3(r115);
        com.ss.cast.sink.j r117 = r114.f456435a;
        r117.f456468u = r116;
        com.ss.cast.sink.d r118 = new com.ss.cast.sink.d(r117);
        IServer r119 = r117.f456455h;
        if (r119 == null) goto L27;
        r119.setServerListener(r118);
    L27:
        Iterator r120 = ((ConcurrentHashMap) r117.f456456i).keySet().iterator();
    L29:
        if (r120.hasNext() == false) goto L33;
        ICastSink r121 = (ICastSink) ((ConcurrentHashMap) r117.f456456i).get((String) r120.next());
        if (r121 == null) goto L29;
        r121.setServerListener(r118);
        goto L29
    L33:
        Iterator r122 = ((ConcurrentHashMap) r117.f456456i).keySet().iterator();
    L35:
        if (r122.hasNext() == false) goto L39;
        ICastSink r123 = (ICastSink) ((ConcurrentHashMap) r117.f456456i).get((String) r122.next());
        if (r123 == null) goto L35;
        r123.setServerListener(r116);
    L39:
        FLogger r124 = FLogger.f375446a;
        r124.i(this.f331811a, "setMirrorListener: byteCastSink: " + this.f331815e);
        com.ss.cast.sink.api.g r125 = this.f331815e;
        if (r125 == null) goto L47;
        k r126 = new k(this);
        com.ss.cast.sink.j r127 = r125.f456435a;
        r127.getClass();
        ByteCastSinkImpl$11 r128 = new ByteCastSinkImpl$11(r126);
        r127.f456469v = r128;
        ICastSink r129 = r127.f456451d;
        if (r129 == null) goto L44;
        r129.setMirrorListener(r128);
    L44:
        ICastSink r130 = r127.f456450c;
        if (r130 == null) goto L47;
        r130.setMirrorListener(r128);
    L47:
        r124.i(this.f331811a, "setMessageListener: byteCastSink: " + this.f331815e);
        com.ss.cast.sink.api.g r131 = this.f331815e;
        if (r131 == null) goto L58;
        j r132 = new j(this);
        com.ss.cast.sink.j r133 = r131.f456435a;
        ICastSink r134 = r133.f456448a;
        if (r134 == null) goto L52;
        r134.setMessageListener(r132);
    L52:
        ICastSink r135 = r133.f456451d;
        if (r135 == null) goto L55;
        r135.setMessageListener(r132);
    L55:
        ICastSink r136 = r133.f456449b;
        if (r136 == null) goto L58;
        r136.setMessageListener(r132);
    L58:
        w("initByteCastSink");
        return;
    L60:
        th = move-exception;
        throw th;
    }

    public final void w(String r100) {
        Object r101 = this.f331814d;
        monitor-enter(r101);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.f331813c == true) goto L9;
        FLogger.f375446a.i(this.f331811a, "DoraByteCastManager.setByteRandomPortOption: can't set, ignore: ".concat(r100));     // Catch: Throwable -> L23
        monitor-exit(r101);
        return;
    L9:
        IDoraService r102 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L23
        if (r102 == null) goto L16;
        DeviceService r103 = r102.device();     // Catch: Throwable -> L23
        if (r103 == null) goto L16;
        if (r103.n0("bdp") != true) goto L16;
        boolean r104 = true;
    L17:
        com.ss.cast.sink.api.g r105 = this.f331815e;     // Catch: Throwable -> L23
        if (r105 == null) goto L20;
        r105.b(new Object[]{Boolean.valueOf(r104)});     // Catch: Throwable -> L23
    L20:
        FLogger.f375446a.i(this.f331811a, "DoraByteCastManager.setByteRandomPortOption: sink.setOption.enableRandomPort: " + r104 + ", from " + r100);     // Catch: Throwable -> L23
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r101);
        return;
    L16:
        r104 = false;
        goto L17
    }

    public final void x(long r100) {
        long r101 = r100 - 5000;
    L4:
        if (this.f331834x.size() <= 1) goto L9;
        if (((q) CollectionsKt.elementAt(this.f331834x, 1)).f331861b > r101) goto L9;
        this.f331834x.removeFirst();
    L9:
        if (this.f331834x.size() <= 64) goto L11;
        this.f331834x.removeFirst();
        goto L9
    }

    public final void y(Boolean r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100.booleanValue();
    L5:
        if (r101 == true) goto L14;
        Object r102 = this.f331833w;
        monitor-enter(r102);
        this.f331834x.clear();     // Catch: Throwable -> L11
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r102);
        this.f331830t = null;
    L11:
        th = move-exception;
        throw th;
    L14:
        if (r100 == null) goto L16;
    L18:
        IDoraService r104 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r104 == null) goto L23;
        com.larus.dora.impl.serviceimpl.h r105 = r104.debug();
        if (r105 == null) goto L23;
        r105.k(r101);
    L23:
        this.f331832v = r101;
        return;
    L16:
        if (this.f331832v != r101) goto L18;
        return;
    L4:
        r101 = r();
        goto L5
    }

    public static final void k(DoraByteCastManager r210, t39.a r211) {
        r210.getClass();
        long r100 = SystemClock.elapsedRealtime();
        p r101 = r210.f331830t;
        if (r210.r() == true) goto L5;
        r210.y(null);
        return;
    L5:
        r210.y(null);
        IDoraService r102 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r102 == null) goto L10;
        com.larus.dora.impl.serviceimpl.h r103 = r102.debug();
        if (r103 == null) goto L10;
        r103.j();
    L10:
        IDoraService r104 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r104 == null) goto L15;
        com.larus.dora.impl.serviceimpl.h r105 = r104.debug();
        if (r105 == null) goto L15;
        t39.o r106 = r105.b();
    L16:
        Object r107 = r210.f331833w;
        monitor-enter(r107);
        r210.x(r100);     // Catch: Throwable -> L124
        if (r210.f331834x.isEmpty() == false) goto L23;
        n r108 = new n(0);     // Catch: Throwable -> L124
        monitor-exit(r107);
        p r212 = r101;
        t39.o r213 = r106;
    L46:
        if (r213 == null) goto L48;
        t39.o r109 = r213;
        long r110 = r109.f544474e;
    L49:
        if (r109 == null) goto L65;
        Integer r111 = Integer.valueOf(r109.f544473d);
        if (r111.intValue() >= 0) goto L53;
    L59:
        boolean r112 = false;
    L60:
        if (r112 == true) goto L63;
        r111 = null;
    L63:
        if (r111 == null) goto L65;
        int r113 = r111.intValue();
    L66:
        int r114 = r211.f544455a;
        int r115 = r211.f544456b;
        int r116 = r211.f544457c;
        int r117 = r211.f544458d;
        if (r109 == null) goto L70;
        String r118 = r109.f544470a;
        if (r118 == null) goto L70;
    L71:
        if (r109 == null) goto L73;
        int r119 = r109.f544471b;
    L74:
        if (r109 == null) goto L76;
        int r120 = r109.f544472c;
    L77:
        if (r212 == null) goto L100;
        t39.o r214 = r109;
        p r121 = r212;
        Double r122 = Double.valueOf(r121.f331858a);
        double r123 = r122.doubleValue();
        if (Double.isInfinite(r123) == false) goto L81;
    L83:
        boolean r124 = false;
    L84:
        if (r124 == true) goto L86;
    L94:
        boolean r125 = false;
    L95:
        if (r125 == true) goto L98;
        r122 = null;
    L98:
        if (r122 == null) goto L101;
        double r126 = r122.doubleValue();
    L102:
        if (r214 == null) goto L104;
        t39.o r127 = r214;
        int r128 = r127.f544475f;
    L105:
        if (r127 == null) goto L107;
        int r129 = r127.f544476g;
    L108:
        double r130 = r108.f331856a;
        double r131 = r126;
        double r132 = r108.f331857b;
        Intrinsics.checkNotNullParameter(r118, Constants.OperatorKey.KEY_NETWORK_STATUS);
        IDoraService r133 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r133 == null) goto L134;
        Pair[] r134 = new Pair[13];
        r134[0] = TuplesKt.to("bw_avg_kbps", Integer.valueOf(r114));
        int r135 = 1;
        r134[1] = TuplesKt.to("average_bitrate_kbps", Double.valueOf(r131));
        r134[2] = TuplesKt.to("transport_rtt_avg", Integer.valueOf(r128));
        r134[3] = TuplesKt.to("transport_rtt_max", Integer.valueOf(r129));
        r134[4] = TuplesKt.to("mmt_target_bitrate_avg", Double.valueOf(r130));
        r134[5] = TuplesKt.to("mmt_target_bitrate_min", Double.valueOf(r132));
        r134[6] = TuplesKt.to("est_bw", Integer.valueOf(r115));
        if (r116 <= 0) goto L113;
        int r136 = 1;
    L114:
        r134[7] = TuplesKt.to("is_bluetooth_transmit_failed", Integer.valueOf(r136));
        r134[8] = TuplesKt.to("flow_level", Integer.valueOf(r117));
        r134[9] = TuplesKt.to("phone_network_status", r118);
        r134[10] = TuplesKt.to("is_a2dp_playing", Integer.valueOf(r119));
        if (r113 < 0) goto L119;
        if (r113 >= 2) goto L120;
        r135 = 0;
    L120:
        r134[11] = TuplesKt.to("is_glasses_dual_connected", Integer.valueOf(r135));
        r134[12] = TuplesKt.to("bluetooth_connected_device_count", Integer.valueOf(r120));
        r133.m1("dora_bluetooth_rtc_bandwidth", MapsKt.mapOf(r134));
        return;
    L119:
        r135 = -1;
        goto L120
    L113:
        r136 = 0;
        goto L114
    L134:
        return;
    L107:
        r129 = -1;
        goto L108
    L104:
        r127 = r214;
        r128 = -1;
    L101:
        r126 = -1.0d;
        goto L102
    L86:
        if (r123 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L94;
        long r137 = r121.f331859b;
        if (r137 <= 0) goto L94;
        if (r137 > r100) goto L94;
        if ((r100 - r137) > RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS) goto L94;
        r125 = true;
        goto L95
    L81:
        if (Double.isNaN(r123) == true) goto L83;
        r124 = true;
        goto L84
    L100:
        r214 = r109;
        goto L101
    L76:
        r120 = -1;
        goto L77
    L73:
        r119 = -1;
    L70:
        r118 = "unknown";
        goto L71
    L53:
        if (r110 <= 0) goto L59;
        if (r110 > r100) goto L59;
        if ((r100 - r110) > 10000) goto L59;
        r112 = true;
    L65:
        r113 = -1;
        goto L66
    L48:
        r109 = r213;
        r110 = 0;
        goto L49
    L23:
        long r138 = r100 - 5000;
        Iterator<q> r139 = r210.f331834x.iterator();     // Catch: Throwable -> L124
        q r140 = r139.next();     // Catch: Throwable -> L124
        long r141 = Math.max(r138, r140.f331861b);     // Catch: Throwable -> L124
        Object r215 = r107;
        long r142 = Long.MAX_VALUE;
        double r216 = AudioStats.AUDIO_AMPLITUDE_NONE;
        long r217 = 0;
    L128:
    L122:
        th = th;
    L126:
        monitor-exit(r215);
        throw th;
    L27:
        if (r139.hasNext() == false) goto L33;
        q r143 = r139.next();     // Catch: Throwable -> L122
        long r144 = Math.min(r100, r143.f331861b);     // Catch: Throwable -> L122
        if (r144 <= r141) goto L32;
        long r145 = r144 - r141;     // Catch: Throwable -> L122
        long r146 = r140.f331860a;     // Catch: Throwable -> L122
        r216 = r216 + (r146 * r145);     // Catch: Throwable -> L122
        r217 = r217 + r145;     // Catch: Throwable -> L122
        r142 = Math.min(r142, r146);     // Catch: Throwable -> L122
    L32:
        r141 = Math.max(r138, r143.f331861b);     // Catch: Throwable -> L122
        r139 = r139;
        r140 = r143;
        r101 = r101;
        r106 = r106;
        goto L128
    L33:
        r212 = r101;
        r213 = r106;
        if (r100 <= r141) goto L36;
        long r147 = r100 - r141;     // Catch: Throwable -> L122
        long r148 = r140.f331860a;     // Catch: Throwable -> L122
        r216 = r216 + (r148 * r147);     // Catch: Throwable -> L122
        r217 = r217 + r147;     // Catch: Throwable -> L122
        r142 = Math.min(r142, r148);     // Catch: Throwable -> L122
    L36:
        long r149 = r217;
        if (r149 > 0) goto L39;
    L44:
        r108 = new n(0);     // Catch: Throwable -> L122
        monitor-exit(r215);
        goto L46
    L39:
        if (r142 == Long.MAX_VALUE) goto L44;
        n r150 = new n((r216 / r149) / 1000.0d, r142 / 1000.0d);     // Catch: Throwable -> L122
        monitor-exit(r215);
        r108 = r150;
    L124:
        th = th;
        r215 = r107;
    L15:
        r106 = null;
        goto L16
    }

    public static final void l(DoraByteCastManager r100, boolean r101) {
        if (r100.f331825o == true) goto L5;
        FLogger.f375446a.i(r100.f331811a, "handleWifiStateChanged ignored: not ready, wifiEnabled=" + r101);
        return;
    L5:
        IDoraService r102 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r102 == null) goto L10;
        AbilityService r103 = r102.o0();
        if (r103 == null) goto L10;
        boolean r104 = r103.k();
    L11:
        if (r104 == true) goto L13;
    L15:
        if (r104 == false) goto L17;
    L19:
        FLogger.f375446a.i(r100.f331811a, "handleWifiStateChanged skipped: wifiEnabled=" + r101 + ", willUseP2P=" + r104 + ", currentEnableStartUsbServer=" + r100.f331827q);
        return;
    L17:
        if (Intrinsics.areEqual(r100.f331827q, Boolean.FALSE) == false) goto L19;
        FLogger.f375446a.i(r100.f331811a, "wifi off or non-p2p: reinit TCP -> UDP");
        r100.q(true);
        r100.u();
        return;
    L13:
        if (Intrinsics.areEqual(r100.f331827q, Boolean.TRUE) == false) goto L15;
        FLogger.f375446a.i(r100.f331811a, "wifi on & p2p: reinit UDP -> TCP");
        r100.q(false);
        r100.u();
        return;
    L10:
        r104 = false;
        goto L11
    }

    public static final s m(DoraByteCastManager r100, JSONObject r110) {
        r100.getClass();
        return new s(r110.optInt("bwdl_connect_time", 0), r110.optInt("cast_connect_time", 0), r110.optInt("cast_init_time", 0), r110.optInt("cast_start_mirror_time", 0), r110.optInt("height", 0), r110.optInt("mirror_fps", 0), r110.optInt("width", 0), r110.optInt("trans_type", 0));
    }

    public static final void n(final DoraByteCastManager r100, final Function0 r101) {
        ((Handler) r100.f331823m.getValue()).post(new com.larus.dora.dorag.res.e(r101, r100));
    }

    public static Integer t(JSONObject r100, String r101) {
        Object r102 = r100.opt(r101);
        if ((r102 instanceof Number) == false) goto L5;
        Number r103 = (Number) r102;
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        long r104 = r103.longValue();
        Integer r105 = Integer.valueOf((int) r104);
        boolean r106 = false;
        if (r104 == r105.intValue()) goto L11;
    L16:
        if (r106 == true) goto L18;
        return null;
    L18:
        return r105;
    L11:
        if (r103.doubleValue() != r104) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L16;
        r106 = true;
        goto L16
    L13:
        r107 = false;
        goto L14
    L5:
        r103 = null;
        goto L6
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void i(Context r100, DoraByteCastManager$registerWifiStateReceiver$receiver$1 r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    public static final void j(DoraByteCastManager r100, String r101, tf9.a r102) {
        t39.g r103 = r100.f331812b;
        if (r103 != null) goto L5;
        FLogger.f375446a.w(r100.f331811a, "drop video frame: callback not registered, clientId=" + r101 + ", timestampUs=" + r102.f545769c + ", frameType=" + r102.f545774h + ", codec=" + r102.f545773g + ", dataSize=" + r102.f545767a.length);
        return;
    L5:
        r103.b(r102);
    }
}
