package com.larus.bmhome.chat.trace;

import android.os.Bundle;
import androidx.collection.LruCache;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.base.weboffline.CJPayWebOfflineWorker;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.ee.bear.bitable.homepage.activity.NoticeInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.trace.appreciable.ChatMessageCostTrace;
import com.larus.bmhome.chat.trace.appreciable.CommonParamManager;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageRenderCompleteRequest;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.im.internal.jni.OmniSDKHelper;
import com.larus.im.internal.jni.callback.NativeIMCallback;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.im.internal.legacy.y3;
import com.larus.im.internal.legacy.z3;
import com.larus.im.internal.tracking.TypeWriterRecorder;
import com.larus.platform.spi.IAIChatRenderTraceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0016J\u001e\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00192\u0006\u0010/\u001a\u00020\u000eH\u0016J \u00102\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000eH\u0016J&\u00105\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001cH\u0016J&\u00107\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0014\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001cH\u0016J\u0018\u00108\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eH\u0016J \u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u001c2\u0006\u0010/\u001a\u00020\u000eH\u0016J \u0010;\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u000eH\u0016J\u001e\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00192\u0006\u0010/\u001a\u00020\u000eH\u0016J\u0006\u0010?\u001a\u00020.J\u0006\u0010@\u001a\u00020.J\u0006\u0010A\u001a\u00020.J\u0006\u0010B\u001a\u00020.J\u0006\u0010C\u001a\u00020.J\u0010\u0010D\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000eH\u0016J\u0018\u0010E\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u000eH\u0016J\u0010\u0010F\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000eH\u0016J\u001e\u0010G\u001a\u00020.2\u0014\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001cH\u0016J\u0018\u0010I\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u001cH\u0016J\b\u0010J\u001a\u00020.H\u0016J\u0010\u0010K\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0016JA\u0010N\u001a\u00020O*\u00020M2.\u0010P\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010R0\u00190Q\"\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010R0\u0019H\u0002¢\u0006\u0002\u0010SJ\u000e\u0010T\u001a\u00020.2\u0006\u0010L\u001a\u00020MJ\u0016\u0010U\u001a\u00020.2\u0006\u0010V\u001a\u00020\u000e2\u0006\u0010W\u001a\u00020\u000eJ\u0010\u0010X\u001a\u00020.2\u0006\u0010Y\u001a\u00020\u000eH\u0016J(\u0010Z\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\t2\u0006\u0010\\\u001a\u00020\u000e2\u0006\u0010]\u001a\u00020\u000eH\u0016J&\u0010^\u001a\u00020.2\u0006\u0010/\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\t2\u0006\u0010_\u001a\u00020\t2\u0006\u0010`\u001a\u00020\u000eJ$\u0010a\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001e2\u0006\u0010/\u001a\u00020\u000eH\u0016J\"\u0010b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001e2\u0006\u0010/\u001a\u00020\u000eJ\u0006\u0010c\u001a\u00020.J\u0006\u0010d\u001a\u00020.J\b\u0010e\u001a\u00020.H\u0016J\u0010\u0010f\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010g\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010h\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010i\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010j\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010k\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010l\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010m\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010n\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010o\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0010\u0010p\u001a\u00020.2\u0006\u0010L\u001a\u00020MH\u0002J\u0012\u0010q\u001a\u00020\u00052\b\u0010r\u001a\u0004\u0018\u00010\u000eH\u0002Js\u0010t\u001a\u00020.2\u0006\u0010u\u001a\u00020\u00052\u0006\u0010v\u001a\u00020\u00052\u0006\u0010w\u001a\u00020\u00052\u0006\u0010x\u001a\u00020\u00052\u0006\u0010y\u001a\u00020\u00052\u0006\u0010z\u001a\u00020\u00052\b\u0010{\u001a\u0004\u0018\u00010\u000e2\b\u0010|\u001a\u0004\u0018\u00010\u000e2\b\u0010}\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010~\u001a\u0004\u0018\u00010\u007f2\u000b\b\u0002\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u007f¢\u0006\u0003\u0010\u0081\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00190\rX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00190\rX\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001b\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001c0\rX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u001d\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u001e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u001f\u001a \u0012\u0004\u0012\u00020\u000e\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\u001e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001c\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b*\u0010+R\u0010\u0010s\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0082\u0001"}, d2 = {"Lcom/larus/bmhome/chat/trace/ChatRenderTrace;", "Lcom/larus/platform/spi/IAIChatRenderTraceService;", "<init>", "()V", "CHARACTER_TYPE_SINGLE", "", "CHARACTER_TYPE_MULTI", "CHARACTER_TYPE_MIXED", "DEFAULT_RENDER_STUCK_INTERVAL", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "replyMap", "", "", "replyEndMap", "messageMap", "lastRenderTime", "audioMap", "templatePromptMap", "autoFillPromptMap", "renderTimes", "hangTask", "Lkotlinx/coroutines/Job;", "creationInfoMap", "Lkotlin/Pair;", "templateInfoMap", "sendMessageTrackExtMap", "", "actionbarRecommendInfoMap", "Lkotlin/Triple;", "actionbarOptionInfoMap", "latestReportedRenderTokens", "Ljava/util/concurrent/ConcurrentHashMap;", "deepThinkOptimizeConfig", "Lcom/larus/platform/model/chat/DeepThinkOptimizeConfig;", "getDeepThinkOptimizeConfig", "()Lcom/larus/platform/model/chat/DeepThinkOptimizeConfig;", "deepThinkOptimizeConfig$delegate", "Lkotlin/Lazy;", "springTraceDataMap", "messageRenderHangInterval", "getMessageRenderHangInterval", "()J", "messageRenderHangInterval$delegate", "setTemplatePromptString", "", "cvsId", "string", "getCreationInfo", "setCreationInfo", "creationId", "creationType", "setSendMessageTrackExtMap", "sendMessageTrackMap", "updateSendMessageTrackExtMap", "removeSendMessageTrackExtMap", "key", "getSendMessageTrackExtMap", "setTemplateInfo", GXTemplateKey.GAIAX_TEMPLATE_ID, GXTemplateKey.GAIAX_TEMPLATE_TYPE, "getTemplateInfo", "resetTemplateInfo", "resetCreationInfo", "resetSendMessageTrackMap", "resetTemplatePromptString", "resetAutoFillPromptString", "getTemplatePromptString", "setAutoFillPromptString", "getAutoFillPromptString", "setSpringTraceDataMap", "traceDataMap", "getSpringTraceDataMap", "clearSpringTraceDataMap", "onRender", "data", "Lcom/larus/im/bean/message/Message;", "trackBundleOf", "Landroid/os/Bundle;", "pairs", "", "", "(Lcom/larus/im/bean/message/Message;[Lkotlin/Pair;)Landroid/os/Bundle;", "reportMessageRenderCompleteIfNeeded", "markReplyEnd", "questionId", "endMessageId", "onReceiveAudioData", DBDefinition.TASK_ID, "setActionbarRecommendInfo", "actionBarItemId", "recommendRequestID", "actionbarRecommendFrom", "setActionbarOptionInfo", "actionbarOptionId", "actionbarOptionText", "getActionbarRecommendInfo", "getActionbarOptionInfo", "resetActionRecommendInfo", "resetActionbarOptionInfo", "clear", "handleMessageRender", "handleReplyRender", "onMessageRenderBegin", "onMessageRender", "onMessageRenderFinish", "checkMessageRenderStuck", "onSendMessageRender", "onAudioMessageRender", "onReplyRenderBegin", "onReplyRenderFinish", "onReplyRenderFinishWithSuggest", "getCharacterType", "content", "lastMessageId", "onScrollAbnormalState", "scrollRange", "scrollOffset", "viewPortHeight", "scrollYDistance", "anchorViewTop", "anchorPosition", "messageId", "conversationId", "contentType", "isSmoothOpt", "", "isAbnormalScroll", "(IIIIIILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatRenderTrace implements IAIChatRenderTraceService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ChatRenderTrace f310039b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineScope f310040c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, Long> f310041d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, String> f310042e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Long> f310043f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, Long> f310044g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, Long> f310045h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map<String, String> f310046i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map<String, String> f310047j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<String, Integer> f310048k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<String, Job> f310049l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Map<String, Pair<String, String>> f310050m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map<String, Pair<String, String>> f310051n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Map<String, Map<String, String>> f310052o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Map<String, Triple<Long, String, String>> f310053p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Map<String, Triple<Long, Long, String>> f310054q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f310055r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Lazy f310056s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f310057t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Lazy f310058u = null;

    public static final class a implements IIMCallback<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f310059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f310060b;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return !y0.a();
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            ChatRenderTrace.f310055r.remove(this.f310059a, this.f310060b);
        }

        @Override // com.larus.im.callback.IIMCallback
        public final /* bridge */ /* synthetic */ void onSuccess(Boolean r100) {
            r100.booleanValue();
        }

        public a(String r100, String r101) {
            this.f310059a = r100;
            this.f310060b = r101;
        }
    }

    private ChatRenderTrace() {
    }

    static {
        f310039b = new ChatRenderTrace();
        f310040c = CoroutineScopeKt.MainScope();
        f310041d = new LinkedHashMap();
        f310042e = new LinkedHashMap();
        f310043f = new LinkedHashMap();
        f310044g = new LinkedHashMap();
        f310045h = new LinkedHashMap();
        f310046i = new LinkedHashMap();
        f310047j = new LinkedHashMap();
        f310048k = new LinkedHashMap();
        f310049l = new LinkedHashMap();
        f310050m = new LinkedHashMap();
        f310051n = new LinkedHashMap();
        f310052o = new LinkedHashMap();
        f310053p = new LinkedHashMap();
        f310054q = new LinkedHashMap();
        f310055r = new ConcurrentHashMap();
        f310056s = LazyKt.lazy(new x());
        f310057t = new ConcurrentHashMap();
        f310058u = LazyKt.lazy(new y());
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void l() {
        f310057t.clear();
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final Map<String, String> i() {
        return f310057t;
    }

    public static Triple a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        return (Triple) ((LinkedHashMap) f310053p).get(r100);
    }

    public static int b(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return -1;
    L9:
        int r102 = 0;
        int r103 = 0;
    L11:
        if (r102 >= r100.length()) goto L19;
        if (String.valueOf(r100.charAt(r102)).getBytes(Charsets.UTF_8).length != 1) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == false) goto L18;
        r103 = r103 + 1;
    L18:
        r102 = r102 + 1;
        goto L11
    L15:
        r104 = false;
        goto L16
    L19:
        double r105 = (((double) r103) * 1.0d) / ((double) r100.length());
        if (r105 < 0.9d) goto L23;
        return 0;
    L23:
        if (r105 <= 0.1d) goto L25;
        return 2;
    L25:
        return 1;
    L5:
        r101 = false;
        goto L6
    }

    public static void o(Message r110) {
        if (r110.getContentType() != 1) goto L5;
    L7:
        Integer r100 = (Integer) ((LinkedHashMap) f310048k).get(r110.getMessageId());
        if (r100 == null) goto L10;
        int r101 = r100.intValue();
    L11:
        String r102 = "";
        if (r101 == 1) goto L16;
        if ((r101 % 100) == 0) goto L16;
    L44:
        Map<String, Job> r103 = f310049l;
        Job r104 = (Job) TypeIntrinsics.asMutableMap(r103).remove(r110.getMessageId());
        if (r104 == null) goto L48;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L48:
        if (r110.getMessageStatusLocal() != 20) goto L50;
    L51:
        String r105 = r110.getMessageId();
        if (r105 == null) goto L55;
        r102 = r105;
    L55:
        r103.put(r102, BuildersKt.launch$default(f310040c, null, null, new ChatRenderTrace$onMessageRender$1(r110, r101, null), 3, null));
        return;
    L50:
        if (com.larus.bmhome.chat.bean.d.Q0(r110) == true) goto L51;
        return;
    L16:
        if (com.larus.im.bean.message.a.b0(r110) == false) goto L18;
        String r106 = com.larus.im.bean.message.a.e(r110);
    L21:
        com.larus.platform.service.o r107 = com.larus.platform.service.o.f365780a;
        Pair[] r108 = new Pair[10];
        r108[0] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r110.getMessageId());
        r108[1] = TuplesKt.to("conversation_id", r110.getConversationId());
        r108[2] = TuplesKt.to("is_onboarding", Integer.valueOf(com.larus.bmhome.chat.bean.d.z0(r110) ? 1 : 0));
        BotInfoCache r109 = BotInfoCache.INSTANCE;
        String r111 = r110.getConversationId();
        if (r111 != null) goto L24;
        r111 = "";
    L24:
        r108[3] = TuplesKt.to("bot_id", r109.getBotId(r111));
        String r112 = r110.getConversationId();
        if (r112 != null) goto L27;
        r112 = "";
    L27:
        r108[4] = TuplesKt.to(AdDownloadModel.JsonKey.MODEL_TYPE, Long.valueOf(r109.getModelType(r112)));
        r108[5] = TuplesKt.to("character_count", Integer.valueOf(r106.length()));
        r108[6] = TuplesKt.to("character_type", Integer.valueOf(b(r106)));
        r108[7] = TuplesKt.to("render_times", Integer.valueOf(r101));
        Map<String, String> r113 = r110.getExt();
        if (r113 == null) goto L30;
        String r114 = r113.get("general_agent");
    L31:
        String r115 = "1";
        if (Intrinsics.areEqual(r114, "1") == false) goto L34;
        Object r116 = "1";
    L35:
        r108[8] = TuplesKt.to("general_agent", r116);
        Map<String, String> r117 = r110.getExt();
        if (r117 == null) goto L38;
        String r118 = r117.get("is_async_task");
    L40:
        if (Intrinsics.areEqual(r118, "1") == true) goto L43;
        r115 = "0";
    L43:
        r108[9] = TuplesKt.to("is_async_task", r115);
        r107.b("stream_message_render", r(r110, r108));
        goto L44
    L38:
        r118 = null;
        goto L40
    L34:
        r116 = "0";
        goto L35
    L30:
        r114 = null;
        goto L31
    L18:
        r106 = com.larus.im.bean.message.a.O(r110);
        if (r106 != null) goto L21;
        r106 = "";
        goto L21
    L10:
        r101 = 0;
        goto L11
    L5:
        if (r110.getContentType() == 9999) goto L7;
    }

    public static void p(Message r210) {
        Intrinsics.checkNotNullParameter(r210, "data");
        String r100 = r210.getMessageId();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        Map<String, Integer> r102 = f310048k;
        Integer r103 = (Integer) ((LinkedHashMap) r102).get(r210.getMessageId());
        if (r103 == null) goto L14;
        int r104 = r103.intValue();
    L15:
        String r105 = r210.getMessageId();
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        r102.put(r105, Integer.valueOf(r104 + 1));
        String r110 = "duration";
        if (com.larus.bmhome.chat.bean.d.H0(r210) == false) goto L34;
        Map<String, Long> r106 = f310045h;
        if (r106.containsKey(r210.getMessageId()) == false) goto L42;
        int r107 = wf9.b.f559489a;
        Intrinsics.checkNotNullParameter(r210, "message");
        String r108 = com.larus.im.bean.message.a.K(r210);
        if (r108 != null) goto L25;
    L28:
        boolean r109 = true;
    L29:
        if (r109 == true) goto L42;
        long r111 = AppHost.f326268a.getAppClock().currentTimeMillis();
        Long r112 = (Long) TypeIntrinsics.asMutableMap(r106).remove(r210.getMessageId());
        if (r112 == null) goto L42;
        com.larus.platform.service.o.f365780a.b("audio_data_to_render", com.larus.utils.f.c(new Pair[]{TuplesKt.to("duration", Long.valueOf(r111 - r112.longValue())), TuplesKt.to(DBDefinition.TASK_ID, r210.getMessageId())}));
        goto L42
    L25:
        if (r108.length() == 0) goto L28;
        r109 = false;
    L42:
        String r211 = "";
        r110 = "duration";
    L226:
        String r113 = r210.getReplyId();
        if (r113 != null) goto L229;
    L232:
        boolean r114 = true;
    L233:
        if (r114 == true) goto L310;
        Map<String, Long> r115 = f310041d;
        boolean r116 = r115.containsKey(r210.getReplyId());
        MessageStatus r117 = r210.getMessageStatus();
        MessageStatus r118 = MessageStatus.MessageStatus_AVAILABLE;
        if (r117 == r118) goto L238;
    L240:
        boolean r119 = false;
    L242:
        if (r210.getMessageStatus() == r118) goto L244;
    L246:
        boolean r120 = false;
    L248:
        if (r210.getContentType() != 2) goto L250;
        boolean r121 = true;
    L251:
        Map<String, String> r122 = f310042e;
        if (Intrinsics.areEqual(((LinkedHashMap) r122).get(r210.getReplyId()), r210.getMessageId()) == true) goto L254;
    L256:
        boolean r123 = false;
    L257:
        if (r116 == true) goto L278;
        if (r119 == false) goto L278;
        String r124 = r210.getReplyId();
        if (r124 != null) goto L262;
    L265:
        boolean r125 = true;
    L266:
        if (r125 == false) goto L268;
        return;
    L268:
        if (com.larus.bmhome.chat.bean.d.r0(r210) == true) goto L311;
        String r126 = r210.getReplyId();
        if (r126 != null) goto L273;
        r126 = r211;
    L273:
        AppHost.Companion r127 = AppHost.f326268a;
        r115.put(r126, Long.valueOf(r127.getAppClock().currentTimeMillis()));
        String r128 = r210.getMessageId();
        if (r128 != null) goto L276;
        String r129 = r211;
    L277:
        r115.put(r129, Long.valueOf(r127.getAppClock().currentTimeMillis()));
        return;
    L276:
        r129 = r128;
        goto L277
    L311:
        return;
    L262:
        if (r124.length() == 0) goto L265;
        r125 = false;
    L278:
        if (r120 == false) goto L304;
        if (r116 == true) goto L281;
        return;
    L281:
        if (r123 == false) goto L294;
        String r130 = r210.getReplyId();
        if (r130 != null) goto L285;
    L288:
        boolean r131 = true;
    L289:
        if (r131 == true) goto L312;
        long r132 = AppHost.f326268a.getAppClock().currentTimeMillis();
        Long r133 = (Long) TypeIntrinsics.asMutableMap(r115).remove(r210.getReplyId());
        if (r133 == null) goto L306;
        long r134 = r132 - r133.longValue();
        TypeIntrinsics.asMutableMap(r122).remove(r210.getReplyId());
        com.larus.platform.service.o.f365780a.b("message_all_render_finish", com.larus.utils.f.c(new Pair[]{TuplesKt.to(r110, Long.valueOf(r134)), TuplesKt.to(NoticeInfo.KEY_REPLY_ID, r210.getReplyId())}));
        return;
    L306:
        return;
    L312:
        return;
    L285:
        if (r130.length() == 0) goto L288;
        r131 = false;
        goto L289
    L294:
        String r135 = r110;
        if (r121 == false) goto L308;
        long r136 = AppHost.f326268a.getAppClock().currentTimeMillis();
        Long r137 = (Long) TypeIntrinsics.asMutableMap(r115).remove(r210.getReplyId());
        if (r137 == null) goto L309;
        com.larus.platform.service.o.f365780a.b("message_all_render_finish_suggest", com.larus.utils.f.c(new Pair[]{TuplesKt.to(r135, Long.valueOf(r136 - r137.longValue())), TuplesKt.to(NoticeInfo.KEY_REPLY_ID, r210.getReplyId())}));
        return;
    L309:
        return;
    L308:
        return;
    L304:
        return;
    L254:
        if (com.larus.bmhome.chat.bean.d.Q0(r210) == true) goto L256;
        r123 = true;
        goto L257
    L250:
        r121 = false;
        goto L251
    L244:
        if (r210.getMessageStatusLocal() != 21) goto L246;
        r120 = true;
        goto L248
    L238:
        if (r210.getMessageStatusLocal() != 20) goto L240;
        r119 = true;
        goto L242
    L310:
        return;
    L229:
        if (r113.length() == 0) goto L232;
        r114 = false;
        goto L233
    L34:
        String r138 = r210.getReplyId();
        if (r138 != null) goto L37;
    L40:
        boolean r139 = true;
    L41:
        if (r139 == true) goto L42;
        Map<String, Long> r140 = f310043f;
        boolean r141 = r140.containsKey(r210.getMessageId());
        MessageStatus r142 = r210.getMessageStatus();
        MessageStatus r143 = MessageStatus.MessageStatus_AVAILABLE;
        if (r142 == r143) goto L46;
    L48:
        boolean r144 = false;
    L50:
        if (r210.getMessageStatus() == r143) goto L52;
    L60:
        boolean r145 = false;
    L62:
        if (r141 == true) goto L81;
        if (r144 == false) goto L81;
        String r146 = r210.getMessageId();
        if (r146 != null) goto L67;
    L70:
        boolean r147 = true;
    L71:
        if (r147 == false) goto L73;
    L207:
        r144 = r144;
        r211 = "";
        r110 = "duration";
    L208:
        if (r144 == true) goto L212;
        if (com.larus.bmhome.chat.bean.d.Q0(r210) == false) goto L226;
    L212:
        if (r210.getContentType() != 1) goto L214;
    L216:
        Map<String, Long> r148 = f310044g;
        Long r149 = (Long) ((LinkedHashMap) r148).get(r210.getMessageId());
        long r150 = AppHost.f326268a.getAppClock().currentTimeMillis();
        if (r149 != null) goto L219;
    L221:
        Long r151 = Long.valueOf(r150);
        String r152 = r210.getMessageId();
        if (r152 != null) goto L224;
        r152 = r211;
    L224:
        r148.put(r152, r151);
    L225:
        o(r210);
        goto L226
    L219:
        if ((r150 - r149.longValue()) <= 1000) goto L221;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new ChatRenderTrace$checkMessageRenderStuck$1(r210, r150, r149, null), 3, null);
        goto L221
    L214:
        if (r210.getContentType() == 9999) goto L216;
    L73:
        if (com.larus.bmhome.chat.bean.d.r0(r210) == true) goto L207;
        if (com.larus.im.bean.message.a.r0(r210) == true) goto L207;
        String r153 = r210.getMessageId();
        if (r153 != null) goto L80;
        r153 = "";
    L80:
        r140.put(r153, Long.valueOf(AppHost.f326268a.getAppClock().currentTimeMillis()));
        goto L207
    L67:
        if (r146.length() == 0) goto L70;
        r147 = false;
    L81:
        if (r141 == false) goto L207;
        if (r145 == false) goto L207;
        long r154 = AppHost.f326268a.getAppClock().currentTimeMillis();
        Long r155 = (Long) TypeIntrinsics.asMutableMap(r140).remove(r210.getMessageId());
        if (r155 == null) goto L205;
        long r156 = r154 - r155.longValue();
        if (r210.getContentType() == 1) goto L90;
        if (r210.getContentType() != 9999) goto L205;
    L90:
        if (com.larus.im.bean.message.a.b0(r210) == false) goto L92;
        String r157 = com.larus.im.bean.message.a.e(r210);
    L95:
        com.larus.platform.service.o r158 = com.larus.platform.service.o.f365780a;
        Pair[] r159 = new Pair[7];
        r159[0] = TuplesKt.to("duration", Long.valueOf(r156));
        r159[1] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r210.getMessageId());
        r159[2] = TuplesKt.to("character_count", Integer.valueOf(r157.length()));
        r159[3] = TuplesKt.to("character_type", Integer.valueOf(b(r157)));
        r159[4] = TuplesKt.to("render_times", ((LinkedHashMap) r102).get(r210.getMessageId()));
        Map<String, String> r160 = r210.getExt();
        String r212 = null;
        if (r160 == null) goto L98;
        String r161 = r160.get("general_agent");
    L99:
        String r162 = "1";
        if (Intrinsics.areEqual(r161, "1") == false) goto L102;
        Object r163 = "1";
    L103:
        r159[5] = TuplesKt.to("general_agent", r163);
        Map<String, String> r164 = r210.getExt();
        if (r164 == null) goto L106;
        String r165 = r164.get("is_async_task");
    L108:
        if (Intrinsics.areEqual(r165, "1") == true) goto L111;
        r162 = "0";
    L111:
        r159[6] = TuplesKt.to("is_async_task", r162);
        r158.b("message_render_finish", r(r210, r159));
        Map<String, String> r166 = r210.getExt();
        if (r166 == null) goto L123;
        String r167 = r166.get("bot_state");
        if (r167 == null) goto L123;
        if (r167.length() <= 0) goto L118;
        boolean r168 = true;
    L119:
        if (r168 == true) goto L122;
        r167 = null;
    L122:
        if (r167 == null) goto L123;
    L300:
        String r169 = new JSONObject(r167).optString("agent_id", "");     // Catch: Exception -> L126
    L128:
        Map<String, String> r170 = r210.getExt();
        if (r170 == null) goto L131;
        String r171 = r170.get("tea_tags_time_cost");
    L132:
        Map<String, String> r172 = r210.getExt();
        if (r172 == null) goto L136;
        String r173 = r172.get("intention");
        if (r173 == null) goto L136;
    L137:
        if (r171 != null) goto L139;
    L142:
        boolean r213 = true;
    L143:
        if (r213 == false) goto L145;
        Map r174 = new LinkedHashMap();
    L146:
        int r175 = r157.length();
        Map<String, String> r176 = r210.getExt();
        r211 = "";
        if (r176 == null) goto L153;
        String r177 = r176.get("answer_statistic_chars");
        if (r177 == null) goto L153;
        Integer r178 = StringsKt.toIntOrNull(r177);
        if (r178 == null) goto L153;
        int r179 = r178.intValue();
    L154:
        Pair[] r180 = new Pair[22];
        r180[0] = TuplesKt.to("duration", Long.valueOf(r156));
        r180[1] = TuplesKt.to(MusicAppletPage.KEY_MESSAGE_ID, r210.getMessageId());
        LruCache<String, CommonParamManager.CommonParam> r181 = CommonParamManager.f310103a;
        CommonParamManager.CommonParam r182 = CommonParamManager.c(r210.getMessageId());
        if (r182 == null) goto L157;
        String r183 = r182.getScene();
    L158:
        r180[2] = TuplesKt.to("scene", r183);
        r180[3] = TuplesKt.to("content_type", Integer.valueOf(r210.getContentType()));
        ChatControlTrace r184 = ChatControlTrace.f309996b;
        r184.getClass();
        LruCache<String, wc9.e> r185 = ChatControlTrace.f310017o;
        String r186 = r210.getConversationId();
        if (r186 != null) goto L161;
        String r187 = r211;
    L162:
        wc9.e r188 = r185.get(r187);
        if (r188 == null) goto L165;
        String r189 = ic8.n.f(r188);
    L166:
        r180[4] = TuplesKt.to("chat_type", r189);
        r180[5] = TuplesKt.to("conversation_id", r210.getConversationId());
        r180[6] = TuplesKt.to("is_onboarding", Integer.valueOf(com.larus.bmhome.chat.bean.d.z0(r210) ? 1 : 0));
        BotInfoCache r190 = BotInfoCache.INSTANCE;
        String r191 = r210.getConversationId();
        if (r191 != null) goto L169;
        r191 = r211;
    L169:
        Map r192 = r174;
        r180[7] = TuplesKt.to("bot_id", r190.getBotId(r191));
        String r193 = r210.getConversationId();
        if (r193 != null) goto L172;
        r193 = r211;
    L172:
        r180[8] = TuplesKt.to(AdDownloadModel.JsonKey.MODEL_TYPE, Long.valueOf(r190.getModelType(r193)));
        r180[9] = TuplesKt.to("character_count", Integer.valueOf(r175));
        r180[10] = TuplesKt.to("character_type", Integer.valueOf(b(r157)));
        r180[11] = TuplesKt.to("render_times", ((LinkedHashMap) f310048k).get(r210.getMessageId()));
        if (r210.getMessageStatusLocal() != 23) goto L175;
    L178:
        int r194 = 1;
    L179:
        r180[12] = TuplesKt.to("is_interrupted", Integer.valueOf(r194));
        if (r210.getMessageStatusLocal() != 21) goto L182;
        String r195 = CJPayWebOfflineWorker.CJ_PAY_WEB_OFFLINE_FINISHED;
    L183:
        r180[13] = TuplesKt.to("result", r195);
        r180[14] = TuplesKt.to("agent_id", r169);
        Map<String, String> r196 = r210.getExt();
        if (r196 == null) goto L186;
        String r197 = r196.get("intention");
    L187:
        r180[15] = TuplesKt.to("intention", r197);
        Map<String, String> r198 = r210.getExt();
        if (r198 == null) goto L190;
        r212 = r198.get("llm_model_type");
    L190:
        r180[16] = TuplesKt.to("llmModelType", r212);
        r180[17] = TuplesKt.to("server_count", Integer.valueOf(r179));
        r180[18] = TuplesKt.to("intention", r173);
        r180[19] = TuplesKt.to("replied_message_id", r210.getReplyId());
        r180[20] = TuplesKt.to("local_message_id", r210.getLocalMessageId());
        com.larus.bmhome.chat.trace.a r199 = r184.gc(ChatControlTrace.f310027y);
        if (r199 == null) goto L194;
        String r200 = r199.f310088j;
        if (r200 == null) goto L194;
    L195:
        r180[21] = TuplesKt.to("current_page", r200);
        Bundle r201 = r(r210, r180);
        if ((!r192.isEmpty()) == false) goto L198;
        com.larus.utils.f.a(r201, r192);
    L198:
        int r202 = com.larus.im.d.f347134a;
        com.larus.im.internal.stream.b r203 = com.larus.im.internal.stream.b.f350138a;
        String r204 = r210.getMessageId();
        if (r204 != null) goto L201;
        r204 = r211;
    L201:
        Intrinsics.checkNotNullParameter(r204, RemoteMessageConst.MSGID);
        TypeWriterRecorder.f350227a.getClass();
        Map r205 = TypeWriterRecorder.e(r204);
        if (r205 == null) goto L204;
        com.larus.utils.f.a(r201, r205);
    L204:
        com.larus.platform.service.o.f365780a.b("stream_message_render_finished", r201);
    L206:
        o(r210);
    L194:
        r200 = "chat";
        goto L195
    L186:
        r197 = null;
        goto L187
    L182:
        r195 = "failed";
        goto L183
    L175:
        if (r210.getMessageStatusLocal() == 13) goto L178;
        r194 = 0;
        goto L179
    L165:
        r189 = null;
        goto L166
    L161:
        r187 = r186;
        goto L162
    L157:
        r183 = null;
    L153:
        r179 = 0;
        goto L154
    L145:
        r174 = com.larus.bmhome.chat.trace.appreciable.z.a(r171, "ChatRenderTrace#onMessageRenderFinish");
        goto L146
    L139:
        if (r171.length() == 0) goto L142;
        r213 = false;
    L136:
        r173 = "default";
        goto L137
    L131:
        r171 = null;
    L126:
        e = move-exception;
        FLogger.f375446a.e("ChatRenderTrace", "Failed to parse agent_id from bot_state", e);
        r169 = "";
        goto L128
    L118:
        r168 = false;
    L123:
        r167 = SliceInitService.DEFAULT_SWITCH;
        goto L300
    L106:
        r165 = null;
        goto L108
    L102:
        r163 = "0";
        goto L103
    L98:
        r161 = null;
        goto L99
    L92:
        r157 = com.larus.im.bean.message.a.O(r210);
        if (r157 != null) goto L95;
        r157 = "";
    L205:
        r211 = "";
        goto L206
    L52:
        if (r210.getMessageStatusLocal() == 21) goto L58;
        if (r210.getMessageStatusLocal() == 23) goto L58;
        if (r210.getMessageStatusLocal() != 22) goto L60;
    L58:
        if (com.larus.bmhome.chat.bean.d.Q0(r210) == true) goto L60;
        r145 = true;
        goto L62
    L46:
        if (r210.getMessageStatusLocal() != 20) goto L48;
        r144 = true;
        goto L50
    L37:
        if (r138.length() == 0) goto L40;
        r139 = false;
        goto L41
    L14:
        r104 = 0;
        goto L15
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static void q(Message r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        String r100 = r110.getMessageId();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L9:
        if (r101 == true) goto L12;
        r100 = null;
    L12:
        if (r100 == null) goto L48;
        String r102 = com.larus.im.bean.message.a.F(r110);
        if (r102 != null) goto L18;
        return;
    L18:
        if (Intrinsics.areEqual(f310055r.put(r100, r102), r102) == false) goto L20;
        return;
    L20:
        String r103 = r110.getReplyId();
        ChatMessageCostTrace.f310093a.getClass();
        boolean r104 = ChatMessageCostTrace.a(r103);
        CommonParamManager.CommonParam r105 = CommonParamManager.c(r103);
        if (r105 != null) goto L23;
    L25:
        boolean r106 = false;
    L26:
        FLogger r107 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("reportMessageRenderComplete messageId=");
        r111.append(r100);
        r111.append(" sendMsgId=");
        r111.append(r103);
        r111.append(" status=");
        r111.append(r110.getMessageStatusLocal());
        r111.append(" renderToken=");
        r111.append(r102);
        r111.append(" perfMark=");
        Map<String, String> r108 = r110.getBusinessExt();
        if (r108 == null) goto L29;
        String r109 = r108.get("current_perf_mark");
    L30:
        r111.append(r109);
        r111.append(" bizTrackContextValid=");
        r111.append(r104);
        r111.append(" hasEnterBackground=");
        r111.append(r106);
        r107.i("ChatMessageCostTrace", r111.toString());
        NativeMessageServiceImpl r112 = com.larus.im.d.e();
        long r113 = System.currentTimeMillis();
        Pair[] r114 = new Pair[2];
        String r115 = "1";
        if (r104 == false) goto L33;
        Object r116 = "1";
    L34:
        r114[0] = TuplesKt.to("biz_track_context_valid", r116);
        if (r106 == true) goto L38;
        r115 = "0";
    L38:
        r114[1] = TuplesKt.to("has_enter_background", r115);
        Map r117 = MapsKt.mapOf(r114);
        TypeWriterRecorder.f350227a.getClass();
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        TypeWriterRecorder.d r118 = TypeWriterRecorder.f350230d.get(r100);
        if (r118 != null) goto L41;
        Map r119 = MapsKt.emptyMap();
    L45:
        final MessageRenderCompleteRequest r120 = new MessageRenderCompleteRequest(r102, r113, MapsKt.plus(r117, r119));
        a r121 = new a(r100, r102);
        r112.getClass();
        Intrinsics.checkNotNullParameter(r120, "request");
        final NativeIMCallback r122 = new NativeIMCallback("reportMessageRenderComplete", "timestamp:" + r120.getRenderCompleteTimestamp() + ",tagKeys:" + r120.getTags().keySet(), r121, new y3());
        OmniSDKHelper.getOmniSDK$default(OmniSDKHelper.INSTANCE, NativeMessageServiceImpl.r(), false, 2, null).withMessageService(new z3(r120, r122));
        return;
    L41:
        long r123 = r118.f350254h;
        if (r123 > 0) goto L44;
        r119 = MapsKt.emptyMap();
        goto L45
    L44:
        r119 = MapsKt.mapOf(new Pair[]{TuplesKt.to("typewriter_callback_timestamp_ms", String.valueOf(r123)), TuplesKt.to("loading_delay_blocking_duration", String.valueOf(r118.D)), TuplesKt.to("render_path", "typewriter")});
        goto L45
    L33:
        r116 = "0";
        goto L34
    L29:
        r109 = null;
        goto L30
    L23:
        if (r105.getHasEnterBackground() != true) goto L25;
        r106 = true;
        goto L26
    L48:
        return;
    L7:
        r101 = false;
        goto L9
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final Map<String, String> d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        return (Map) ((LinkedHashMap) f310052o).get(r100);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final String f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        String r101 = (String) ((LinkedHashMap) f310046i).get(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void h(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "traceDataMap");
        ConcurrentHashMap<String, String> r101 = f310057t;
        LinkedHashMap r102 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L13;
        Map.Entry<String, String> r104 = r103.next();
        if (r104.getKey() != null) goto L8;
    L10:
        boolean r105 = false;
    L11:
        if (r105 == false) goto L4;
        r102.put(r104.getKey(), r104.getValue());
        goto L4
    L8:
        if (r104.getValue() == null) goto L10;
        r105 = true;
        goto L11
    L13:
        r101.putAll(r102);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return;
    L8:
        f310045h.put(r100, Long.valueOf(AppHost.f326268a.getAppClock().currentTimeMillis()));
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final String k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        String r101 = (String) ((LinkedHashMap) f310047j).get(r100);
        if (r101 != null) goto L6;
        return "";
    L6:
        return r101;
    }

    public static Bundle r(Message r100, Pair... r101) {
        Bundle r102 = com.larus.utils.f.c(new Pair[0]);
        com.larus.utils.f.a(r102, com.larus.im.bean.message.a.U(r100));
        Map r103 = MapsKt.mapOf((Pair[]) Arrays.copyOf(r101, r101.length));
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator r105 = r103.entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L11;
        Map.Entry r106 = (Map.Entry) r105.next();
        if (r106.getValue() == null) goto L8;
        boolean r107 = true;
    L9:
        if (r107 == false) goto L4;
        r104.put(r106.getKey(), r106.getValue());
        goto L4
    L8:
        r107 = false;
        goto L9
    L11:
        com.larus.utils.f.a(r102, r104);
        return r102;
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void c(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "sendMessageTrackMap");
        f310052o.put(r100, r101);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void e(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "sendMessageTrackMap");
        Map<String, Map<String, String>> r102 = f310052o;
        Map r103 = (Map) ((LinkedHashMap) r102).get(r100);
        if (r103 == null) goto L5;
        Map<String, String> r104 = MapsKt.toMutableMap(r103);
    L6:
        if (r104 == null) goto L8;
        r104.putAll(r101);
    L8:
        if (r104 == null) goto L11;
        r101 = r104;
    L11:
        r102.put(r100, r101);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "string");
        f310046i.put(r100, r101);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void m(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "string");
        f310047j.put(r100, r101);
    }

    @Override // com.larus.platform.spi.IAIChatRenderTraceService
    public final void n(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cvsId");
        Intrinsics.checkNotNullParameter(r101, "key");
        Map<String, Map<String, String>> r102 = f310052o;
        Map r103 = (Map) ((LinkedHashMap) r102).get(r100);
        if (r103 == null) goto L9;
        Map<String, String> r104 = MapsKt.toMutableMap(r103);
        if (r104 == null) goto L10;
        r104.remove(r101);
        r102.put(r100, r104);
        return;
    L10:
        return;
    }
}
