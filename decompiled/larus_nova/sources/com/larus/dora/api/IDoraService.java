package com.larus.dora.api;

import androidx.fragment.app.FragmentManager;
import com.bytedance.common.wschannel.WsConstants;
import com.larus.avlink.impl.DoraAVLinkServiceImpl;
import com.larus.avlink.impl.l;
import com.larus.dora.api.model.FlowDoraPreCheckResult;
import com.larus.dora.api.model.FlowDoraVideoRecordConfig;
import com.larus.dora.api.model.FlowDoraWifiConnectResult;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.larus.dora.dorag.res.DoraByteCastManager;
import com.larus.dora.impl.DoraRouterInterceptor;
import com.larus.dora.impl.DoraServiceImpl$otaNewVersionChangedFlow$$inlined$map$1;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.HealthService;
import com.larus.dora.impl.serviceimpl.NetworkService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.dora.impl.serviceimpl.r;
import com.larus.dora.impl.serviceimpl.s;
import com.larus.dora.impl.serviceimpl.t;
import com.larus.network.http.ServiceType;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import h49.k;
import h49.m;
import hq9.a1;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.Request;
import org.json.JSONObject;
import t39.n;
import t39.q;
import t39.u;
import t39.w;
import t39.x;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\bg\u0018\u0000 ç\u00012\u00020\u0001:\"ç\u0001è\u0001é\u0001ê\u0001ë\u0001ì\u0001í\u0001î\u0001ï\u0001ð\u0001ñ\u0001ò\u0001ó\u0001ô\u0001õ\u0001ö\u0001÷\u0001J\b\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH&J)\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000fH&J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u0016H&J\b\u0010\u0017\u001a\u00020\tH&J\b\u0010\u0018\u001a\u00020\tH&J\b\u0010\u0019\u001a\u00020\tH&J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\b\u0010!\u001a\u00020\u000fH&J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u0003H&J\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0003H&J\b\u0010&\u001a\u00020\u000fH&J\n\u0010'\u001a\u0004\u0018\u00010\fH&J\n\u0010(\u001a\u0004\u0018\u00010\fH&J\b\u0010)\u001a\u00020\tH&J\b\u0010*\u001a\u00020\tH&J\u0010\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\fH&J\u0010\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020\fH&J\b\u0010.\u001a\u00020\tH&J\u0010\u0010/\u001a\u00020\t2\u0006\u0010,\u001a\u00020\fH&J\u001a\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0201H&J\b\u00103\u001a\u00020\tH&JF\u00104\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u00032\u0006\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\fH&J\u0014\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f02H&J\b\u0010<\u001a\u00020=H&J\b\u0010>\u001a\u00020\u000fH&J\b\u0010?\u001a\u00020\u000fH&J\b\u0010@\u001a\u00020AH&J\b\u0010B\u001a\u00020CH&J\b\u0010D\u001a\u00020EH&J\b\u0010F\u001a\u00020GH&J\b\u0010H\u001a\u00020IH&J\b\u0010J\u001a\u00020KH&J\b\u0010L\u001a\u00020MH&J\b\u0010N\u001a\u00020OH&J\b\u0010P\u001a\u00020QH&J\b\u0010R\u001a\u00020SH&J\b\u0010T\u001a\u00020UH&J\u0010\u0010V\u001a\u00020\u000f2\u0006\u0010W\u001a\u00020XH&J\u0010\u0010Y\u001a\u00020Z2\u0006\u0010W\u001a\u00020XH&J\b\u0010[\u001a\u00020\tH&J\"\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010W\u001a\u00020X2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\fH&J\u0010\u0010a\u001a\u00020\t2\u0006\u0010W\u001a\u00020XH&J\u0010\u0010b\u001a\u00020\t2\u0006\u0010c\u001a\u00020dH&J\u0010\u0010e\u001a\u00020\t2\u0006\u0010c\u001a\u00020dH&J\u0010\u0010f\u001a\u00020\t2\u0006\u0010c\u001a\u00020gH&J\u0010\u0010h\u001a\u00020\t2\u0006\u0010c\u001a\u00020gH&J\n\u0010i\u001a\u0004\u0018\u00010\fH&J\b\u0010j\u001a\u00020\u000fH&J\u0010\u0010k\u001a\u00020\u00032\u0006\u0010l\u001a\u00020\u000fH&J\u0010\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\u000fH&J\b\u0010o\u001a\u00020pH&J\b\u0010q\u001a\u00020rH&J\b\u0010s\u001a\u00020tH&J\b\u0010u\u001a\u00020vH&J\u001c\u0010w\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f022\u0006\u0010x\u001a\u00020yH&J4\u0010z\u001a\u00020\t2\u0006\u0010{\u001a\u00020\u00032\u0006\u0010c\u001a\u00020|2\b\b\u0002\u0010}\u001a\u00020\u000f2\u0006\u0010~\u001a\u00020\u000f2\b\b\u0002\u0010\u007f\u001a\u00020\u000fH'J#\u0010\u0080\u0001\u001a\u00020\t2\u0007\u0010\u0081\u0001\u001a\u00020\f2\u0006\u0010{\u001a\u00020\u00032\u0007\u0010c\u001a\u00030\u0082\u0001H'J\u0013\u0010\u0083\u0001\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010|H&J\t\u0010\u0084\u0001\u001a\u00020\u000fH&J\t\u0010\u0085\u0001\u001a\u00020\u000fH&J\u0010\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020\t0\u0087\u0001H&J\t\u0010\u0088\u0001\u001a\u00020\u000fH&J\t\u0010\u0089\u0001\u001a\u00020\tH&J\t\u0010\u008a\u0001\u001a\u00020\u000fH&J\t\u0010\u008b\u0001\u001a\u00020\tH&J\u001d\u0010\u008c\u0001\u001a\u00020\t2\u0007\u0010\u008d\u0001\u001a\u00020\u00032\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u000fH&J\u0012\u0010\u008f\u0001\u001a\u00020\t2\u0007\u0010\u008d\u0001\u001a\u00020\u0003H&J\t\u0010\u0090\u0001\u001a\u00020\u000fH\u0016J\u0012\u0010\u0091\u0001\u001a\u00020\u000f2\u0007\u0010\u0092\u0001\u001a\u00020\fH&J\u0012\u0010\u0093\u0001\u001a\u00020\t2\u0007\u0010\u0094\u0001\u001a\u00020\fH&J)\u0010\u0095\u0001\u001a\u00020\t2\u0007\u0010\u0096\u0001\u001a\u00020\f2\u0015\u0010\u0097\u0001\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u000102H&J\t\u0010\u0098\u0001\u001a\u00020\u0003H&J\t\u0010\u0099\u0001\u001a\u00020\u0003H&J\t\u0010\u009a\u0001\u001a\u00020\u0003H&J\t\u0010\u009b\u0001\u001a\u00020\u0003H&J'\u0010\u009c\u0001\u001a\u00020\t2\u0007\u0010\u0096\u0001\u001a\u00020\f2\u0013\u0010\u0097\u0001\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000102H&J\u0015\u0010\u009d\u0001\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000102H&J\u0014\u0010\u009e\u0001\u001a\u00020\t2\t\b\u0002\u0010\u009f\u0001\u001a\u00020\fH&J\u0014\u0010 \u0001\u001a\u00020\t2\t\b\u0002\u0010\u009f\u0001\u001a\u00020\fH&J\u0013\u0010¡\u0001\u001a\u00020\t2\b\u0010¢\u0001\u001a\u00030£\u0001H&J\t\u0010¤\u0001\u001a\u00020\u000fH&J\t\u0010¥\u0001\u001a\u00020\u000fH&J\t\u0010¦\u0001\u001a\u00020\u000fH&J\u001a\u0010§\u0001\u001a\u00020\u000f2\t\u0010¨\u0001\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0003\u0010©\u0001J\u001a\u0010ª\u0001\u001a\u0004\u0018\u00010\u00032\u0007\u0010«\u0001\u001a\u00020\fH&¢\u0006\u0003\u0010¬\u0001J\u0012\u0010\u00ad\u0001\u001a\u00020\t2\u0007\u0010c\u001a\u00030®\u0001H&J\u0012\u0010¯\u0001\u001a\u00020\t2\u0007\u0010c\u001a\u00030®\u0001H\u0016J\u0012\u0010°\u0001\u001a\u00020\t2\u0007\u0010c\u001a\u00030®\u0001H&J\u0012\u0010±\u0001\u001a\u00020\t2\u0007\u0010c\u001a\u00030²\u0001H&J\t\u0010³\u0001\u001a\u00020\tH&J\t\u0010´\u0001\u001a\u00020\tH&J\u001e\u0010µ\u0001\u001a\u00020\u000f2\u0013\u0010¶\u0001\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f02H&J\f\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001H&J\u0012\u0010¹\u0001\u001a\u00020\u00032\u0007\u0010º\u0001\u001a\u00020\u0003H&J\n\u0010»\u0001\u001a\u00030¼\u0001H&J\t\u0010½\u0001\u001a\u00020\u000fH&J\u0012\u0010¾\u0001\u001a\u00020\u00032\u0007\u0010¿\u0001\u001a\u00020\u000fH&J\u0013\u0010À\u0001\u001a\u00020\u00032\b\u0010Á\u0001\u001a\u00030¼\u0001H&J\n\u0010Â\u0001\u001a\u00030¼\u0001H&J\u0013\u0010Ã\u0001\u001a\u00020\u00032\b\u0010Á\u0001\u001a\u00030¼\u0001H&J\u0012\u0010Ä\u0001\u001a\u00020\t2\u0007\u0010Å\u0001\u001a\u00020\fH&J\f\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u0001H&J\u0011\u0010È\u0001\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0003\u0010É\u0001J\n\u0010Ê\u0001\u001a\u00030Ë\u0001H&J\t\u0010Ì\u0001\u001a\u00020\u000fH&J\u0012\u0010Í\u0001\u001a\u00020\t2\u0007\u0010\u001b\u001a\u00030Î\u0001H&J\u0012\u0010Ï\u0001\u001a\u00020\t2\u0007\u0010\u001b\u001a\u00030Î\u0001H&J\u0013\u0010Ð\u0001\u001a\u00020\t2\b\u0010Ñ\u0001\u001a\u00030Ò\u0001H&J\t\u0010Ó\u0001\u001a\u00020\u0003H&J\f\u0010Ô\u0001\u001a\u0005\u0018\u00010Ç\u0001H&J\f\u0010Õ\u0001\u001a\u0005\u0018\u00010Ç\u0001H&J\t\u0010Ö\u0001\u001a\u00020\u000fH&J\t\u0010×\u0001\u001a\u00020\u0003H&J\u000b\u0010Ø\u0001\u001a\u0004\u0018\u00010\fH&J\u000b\u0010Ù\u0001\u001a\u0004\u0018\u00010\fH&J\t\u0010Ú\u0001\u001a\u00020\fH&J\t\u0010Û\u0001\u001a\u00020\u000fH&J\u0012\u0010Ü\u0001\u001a\u00020\t2\u0007\u0010Ý\u0001\u001a\u00020\u0003H&J\f\u0010Þ\u0001\u001a\u0005\u0018\u00010ß\u0001H&J\u0012\u0010à\u0001\u001a\u00020\t2\u0007\u0010c\u001a\u00030á\u0001H&J\u0012\u0010â\u0001\u001a\u00020\t2\u0007\u0010c\u001a\u00030á\u0001H&J\t\u0010ã\u0001\u001a\u00020\u000fH&J\t\u0010ä\u0001\u001a\u00020\u000fH\u0016J\t\u0010å\u0001\u001a\u00020\u000fH\u0016J\t\u0010æ\u0001\u001a\u00020\tH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006ø\u0001"}, d2 = {"Lcom/larus/dora/api/IDoraService;", "", "linkState", "", "getLinkState", "()I", "setLinkState", "(I)V", "init", "", "handleDoraAtomicFunction", "cmdValue", "", "reportState", "link", "", "idleState", "currentIdleState", "(ZLjava/lang/Integer;Ljava/lang/Integer;)V", "idleInit", "immediately", "getTranslucentPages", "", "registerAllFlowDoraCallback", "registerAllFlowDoraGCallback", "unregisterAllFlowDoraGCallback", "addDoraWakeStateChangeCallback", "listener", "Lcom/larus/dora/api/wrapper/IDoraWakeStateChangedCallback;", "removeDoraWakeStateChangeCallback", "getWakeState", "getWakeMode", "getQueryState", "isWakeUp", "stopTask", "state", "notifyDoraQueryState", "queryState", "isOnboarding", "getModelPath", "getModelMd5", "requestPreWakeupModelDownload", "onStopListenByVoice", "onTtsStart", "audioType", "onTtsEnd", "onAsrEnd", "onAsrStart", "getCacheVadEvents", "Ljava/util/concurrent/CopyOnWriteArrayList;", "", "onVoiceMonitorTtsStartEvent", "realOnVoiceWakeUp", "mode", "query", "side", "vuiId", "kw", "extra", "appendDoraParam", "getDoraXLinkCommonConfig", "Lcom/larus/platform/model/DoraXLinkCommonConfig;", "isDoraGLocationPollEnabled", "canEnableLocationPoll", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/larus/dora/api/IDoraService$Session;", "audio", "Lcom/larus/dora/api/IDoraService$Audio;", "vision", "Lcom/larus/dora/api/IDoraService$Vision;", "device", "Lcom/larus/dora/api/IDoraService$Device;", "wifi", "Lcom/larus/dora/api/IDoraService$Wifi;", "ability", "Lcom/larus/dora/api/IDoraService$Ability;", "network", "Lcom/larus/dora/api/IDoraService$Network;", "ota", "Lcom/larus/dora/api/IDoraService$OTA;", "debug", "Lcom/larus/dora/api/IDoraService$Debug;", "health", "Lcom/larus/dora/api/IDoraService$Health;", "envObserve", "Lcom/larus/dora/api/IDoraService$EnvObserve;", "isEnabled", "scope", "Lcom/larus/dora/api/DoraEnableScope;", "getResourceState", "Lcom/larus/dora/api/DoraResourceState;", "refreshResourceConfig", "resolveResource", "Lcom/larus/dora/api/DoraServerResource;", "resourceType", "Lcom/larus/dora/api/DoraServerResourceType;", "resourceName", "refreshEnabledState", "addEnabledStateCallback", "callback", "Lcom/larus/dora/api/IDoraService$EnabledStateCallback;", "removeEnabledStateCallback", "addResourceStateCallback", "Lcom/larus/dora/api/IDoraService$ResourceStateCallback;", "removeResourceStateCallback", "getODiaryBetaUrl", "getVoiceWakeupEnable", "setVoiceWakeupEnable", "enabled", "setEnrollingStatus", "enrolling", "getAiQuickNoteConfig", "Lcom/larus/dora/api/entity/QuickNoteConfig;", "llmPlugin", "Lcom/larus/dora/api/IDoraService$LLMPlugin;", "asrPlugin", "Lcom/larus/dora/api/IDoraService$ASRPlugin;", "onboarding", "Lcom/larus/dora/api/IDoraService$Onboarding;", "getDoraHeader", "callBody", "Lorg/json/JSONObject;", "getEarbudsLog", "logType", "Lcom/larus/dora/api/OnGetDoraLogCallback;", "fromFeedback", "pendingUpload", "isManual", "uploadEarbudsLog", "filePath", "Lcom/larus/dora/api/OnUploadDoraLogResult;", "listenAutoGetLog", "hasNewVersion", "shouldEnterObricDeviceManagement", "otaNewVersionChangedFlow", "Lkotlinx/coroutines/flow/Flow;", "isFirstEnterSimulInterpretPage", "enterSimulInterpretPage", "isFirstEnterLabSettings", "syncVUIDataEndEvent", "sendVUIEndEvent", "code", "isSilent", "sendVUIEndSilentEvent", "isDoraFeatureEnable", "isProactivePriorityEnabled", "userId", "traceDoraEntranceShow", "page", "reportDoraAndDoubaoTrace", "event", "params", "getWearCount", "getWakeupCount", "getKeepAliveDismissDuration", "getKeepAliveBubbleCounts", "reportDoraTrace", "getDoubaoBuryPointCustomParams", "tryInitBotConversation", "source", "tryInitBotConversationInMainThread", "showBluetoothSettingDialog", "manager", "Landroidx/fragment/app/FragmentManager;", "hasDoraDevice", "hasDoraEDevice", "hasDoraGDevice", "isDoraG", "productId", "(Ljava/lang/Integer;)Z", "getDoraBizTypeByAppKey", com.heytap.mcssdk.constant.b.f276376z, "(Ljava/lang/String;)Ljava/lang/Integer;", "registerDoraLinkCallback", "Lcom/larus/dora/api/IDoraLinkCallback;", "registerHighPriorityDoraLinkCallback", "unRegisterDoraLinkCallback", "registerDoraBudsCallback", "Lcom/larus/dora/api/IDoraBudsCallback;", "initCompanionDeviceManager", "registerDeviceSwitchCallback", "updateAppletPayload", WsConstants.KEY_PAYLOAD, "getQueryWorkThread", "Ljava/lang/Thread;", "setBudsVersionType", "versionType", "takeRoleSwitchTransmitImageEnable", "", "takeImageOnSpeechEnable", "syncImageOnSpeechEnable", "isChecked", "syncRoleSwitchTransmitImageEnable", "isEnable", "getVpuEnable", "syncVpuEnable", "sendCMD", "cmd", "firstBindDevice", "Lcom/larus/dora/api/DoraDeviceInfo;", "isMultiManageEnabled", "()Ljava/lang/Boolean;", "createDoraRouterInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "isVoiceWakeupEnabled", "addVoiceWakeupStateChangedListener", "Lcom/larus/dora/api/OnVoiceWakeupStateChangedListener;", "removeVoiceWakeupStateChangedListener", "syncAsrEndDeviceTime", "time", "", "getAutoStopTimeConfig", "firstBondedDevice", "managementEntryDevice", "isHeadGestureControlEnabled", "getDoraTitleResId", "getMainBotRealtimeStyleId", "getMainBotStyleId", "getMainBotAudioMetrics", "hasDoraGDeviceJudgedByTraversal", "jumpToManagePage", "routeFlags", "getDeviceStatusInfo", "Lcom/larus/dora/api/DeviceStatusInfo;", "registerConversationGestureCallback", "Lcom/larus/dora/api/IConversationGestureCallback;", "unregisterConversationGestureCallback", "isVideoLiveAIEnabled", "isVideoLiveAIPreInitEnabled", "isVideoLiveAIPreInitP2PEnabled", "incWakeupCount", "Companion", "EnabledStateCallback", "ResourceStateCallback", "Session", ServiceType.AUDIO, "Vision", "Device", "Wifi", "Debug", "Ability", "Health", "Network", FlowDoraWifiScene.OTA, "EnvObserve", "LLMPlugin", "ASRPlugin", "Onboarding", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoraService {
    public static final b B1 = null;

    public interface a {

        /* JADX INFO: renamed from: com.larus.dora.api.IDoraService$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes27.dex */
        public interface InterfaceC4203a {
            void a();

            void b(int r100, boolean r101, boolean r102);
        }

        void a();

        boolean b();

        boolean c();
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f331726a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final CoroutineScope f331727b = null;

        public b() {
        }

        static {
            f331726a = new b();
            f331727b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class c {
        public static /* synthetic */ void a(IDoraService r100, int r101, u r110, boolean r111, boolean r112, boolean r113, int r114) {
            if ((r114 & 4) == 0) goto L5;
            boolean r102 = false;
        L7:
            if ((r114 & 16) == 0) goto L9;
            boolean r103 = false;
        L10:
            r100.C0(r101, r110, r102, r112, r103);
            return;
        L9:
            r103 = r113;
            goto L10
        L5:
            r102 = r111;
            goto L7
        }
    }

    public interface d {
        boolean a();

        int b(int r100);

        void c(m r100);

        void d(m r100);

        boolean e(int r100);

        boolean f();

        boolean shutdown();
    }

    public interface e {
        void a(DoraEnableScope r100);
    }

    public interface f {
        void a(q r100);

        Object b(Continuation<? super b49.j> r100);

        void c(q r100);

        Object d(Continuation<? super Integer> r100);

        Object e(Continuation<? super b49.i> r100);

        Object f(Continuation<? super Boolean> r100);

        Object g(Continuation<? super Integer> r100);
    }

    /* JADX INFO: loaded from: classes27.dex */
    public interface g {
        void a(DoraEnableScope r100, DoraResourceState r101);
    }

    public interface h {

        /* JADX INFO: loaded from: classes27.dex */
        public static final class a {
            public static /* synthetic */ int a(h r100, int r101, int r102) {
                return r100.b(r101, r102, false);
            }
        }

        int a();

        int b(int r100, int r101, boolean r102);
    }

    public interface i {
        void a(h49.g r100);

        FlowDoraVideoRecordConfig b();

        void c(h49.g r100);

        int d(FlowDoraVideoRecordConfig r100);
    }

    public interface j {
        @FlowDoraWifiConnectResult
        Object a(@FlowDoraWifiScene String r100, Continuation<? super String> r101);

        <T> Object b(Request r100, Type r101);

        void c(h49.i r100);

        boolean d(@FlowDoraWifiScene String r100);

        Unit disconnect(@FlowDoraWifiScene String r100);

        void e(h49.i r100);

        Map<String, String> f();

        @FlowDoraPreCheckResult
        Object g();

        String getHost();

        boolean h();
    }

    static {
        B1 = b.f331726a;
    }

    void A();

    void A0(String r100, Map<String, ? extends Object> r101);

    t39.f B(DoraEnableScope r100, DoraServerResourceType r101, String r102);

    boolean B0();

    void C();

    void C0(int r100, u r101, boolean r102, boolean r103, boolean r104);

    void D0();

    void E(String r100);

    DoraRouterInterceptor E0();

    int F();

    void F0();

    void G(n r100);

    CopyOnWriteArrayList<Map<String, String>> G0();

    void H(long r100);

    void H0(int r100);

    void I();

    void I0(int r100);

    boolean J0();

    byte K();

    boolean K0();

    t39.d L();

    void L0(k r100);

    void M(DoraAVLinkServiceImpl.c r100);

    com.larus.dora.impl.serviceimpl.f M0();

    int O();

    void O0(l r100);

    String P();

    boolean Q(String r100);

    String Q0();

    s R();

    void R0(t39.i r100);

    j S();

    DoraResourceState S0(DoraEnableScope r100);

    boolean T();

    boolean T0(DoraEnableScope r100);

    t U();

    DoraServiceImpl$otaNewVersionChangedFlow$$inlined$map$1 U0();

    VisionService V();

    void V0(DoraByteCastManager.c r100);

    void W(x r100);

    int W0();

    boolean X(Integer r100);

    com.larus.dora.impl.serviceimpl.a X0();

    void Y0(int r100);

    void Z(String r100);

    void Z0(boolean r100);

    List<String> a();

    boolean b();

    void b1();

    boolean c();

    void c0();

    void c1();

    SessionService d();

    int d0();

    com.larus.dora.impl.serviceimpl.h debug();

    DeviceService device();

    void e();

    boolean e0();

    boolean f();

    Map<String, String> f0();

    boolean g(Map<String, String> r100);

    void g0(boolean r100, Integer r101, Integer r102);

    r g1();

    a1 getDoraXLinkCommonConfig();

    int getLinkState();

    int h();

    boolean h0();

    void h1(int r100, boolean r101);

    boolean hasDoraDevice();

    void i(boolean r100);

    boolean i0();

    void i1();

    void init();

    boolean j();

    void j0(m59.a r100);

    boolean j1();

    void k(String r100);

    void k0(String r100, int r101, w r102);

    void k1(m59.a r100);

    boolean l();

    t39.c l0();

    void m();

    void m0(String r100);

    void m1(String r100, Map<String, ? extends Object> r101);

    void n(FragmentManager r100);

    void n0(String r100);

    NetworkService network();

    Integer o(String r100);

    AbilityService o0();

    void onAsrEnd();

    void onAsrStart(String r100);

    a49.k p0();

    int q();

    void q0(n r100);

    int r();

    void r0();

    boolean s();

    void s0();

    int t();

    void t0();

    void u0();

    boolean v();

    String v0();

    HealthService w();

    Map<String, String> w0(JSONObject r100);

    void x(k r100);

    t39.d x0();

    String z();

    String z0();
}
