package com.larus.doc.api;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.doc.impl.DocFragment;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import q97.a;
import wc9.e;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\bg\u0018\u0000 i2\u00020\u0001:\u0001iJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J:\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u000fJ \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0011JT\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001bH&J\b\u0010\u001c\u001a\u00020\u001dH&J\b\u0010\u001e\u001a\u00020\u001dH&J\b\u0010\u001f\u001a\u00020\u001dH&J\u0010\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010!H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u000bH&JP\u0010$\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\tH&J \u0010.\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\tH&J?\u00100\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\u00101\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010'\u001a\u0004\u0018\u00010\t2\b\u00102\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u00103J\u0012\u00104\u001a\u00020\u00032\b\u00105\u001a\u0004\u0018\u00010\tH&J\b\u00106\u001a\u00020\u000bH&J\u000e\u00107\u001a\u00020\tH¦@¢\u0006\u0002\u00108J\b\u00109\u001a\u00020\tH&J\b\u0010:\u001a\u00020\tH&J\u000f\u0010;\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020\tH&J\b\u0010>\u001a\u00020\u0016H&J\n\u0010?\u001a\u0004\u0018\u00010\tH&J\b\u0010@\u001a\u00020\u0016H&J\b\u0010A\u001a\u00020\u0016H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u000bH&J\b\u0010D\u001a\u00020\u001dH&J\b\u0010E\u001a\u00020\u001dH&J\b\u0010F\u001a\u00020\u001dH&J\u0010\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\tH&J\b\u0010I\u001a\u00020\u001dH&J\u0012\u0010J\u001a\u00020\u00032\b\u0010K\u001a\u0004\u0018\u00010LH&J\n\u0010M\u001a\u0004\u0018\u00010LH&J\n\u0010N\u001a\u0004\u0018\u00010OH&J\n\u0010P\u001a\u0004\u0018\u00010\tH&J\b\u0010Q\u001a\u00020\u0003H&J\b\u0010R\u001a\u00020\u0003H&J\b\u0010S\u001a\u00020\u000bH&J\b\u0010T\u001a\u00020\u0003H&J\b\u0010U\u001a\u00020\u0003H&J\u0010\u0010V\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\tH&J$\u0010W\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0006\u0010H\u001a\u00020\t2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\tH&J<\u0010X\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\b\u0010Y\u001a\u0004\u0018\u00010\t2\b\u0010Z\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\tH&J\u000f\u0010\\\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0002\u0010<J\n\u0010]\u001a\u0004\u0018\u00010\tH&J\n\u0010^\u001a\u0004\u0018\u00010\tH&J\n\u0010_\u001a\u0004\u0018\u00010\tH&J\n\u0010`\u001a\u0004\u0018\u00010\tH&J\n\u0010a\u001a\u0004\u0018\u00010\tH&J\"\u0010b\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\t2\b\u0010c\u001a\u0004\u0018\u00010\t2\u0006\u0010d\u001a\u00020\u0016H&J@\u0010e\u001a\u00020\u00032\b\u0010f\u001a\u0004\u0018\u00010\t2\u0006\u00101\u001a\u00020\u00162\u0006\u0010g\u001a\u00020\t2\b\u0010h\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010-\u001a\u0004\u0018\u00010\tH&¨\u0006j"}, d2 = {"Lcom/larus/doc/api/IDocService;", "", "init", "", "initDocSdk", "integrateFloatChatFragment", "Landroidx/fragment/app/Fragment;", "parentFragment", "sceneKey", "", "hasBottomTab", "", "useRemoteConv", "bundle", "Landroid/os/Bundle;", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;ZZLandroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshFloatChatRemoteBinding", "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showDownloadPanel", WidgetService.PARAM_FRAGMENT, "resourceId", "resourceVersion", "", "showFrom", "currentPage", "artifactMetaId", "bizExtra", "", "createNewDocRouteInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createDocPasteRouteInterceptor", "createAiEditBackRouteInterceptor", "getVoiceInputStatus", "Lkotlinx/coroutines/flow/StateFlow;", "clickVoiceInput", "enable", "createDocByMessage", "message", "Lcom/larus/im/bean/message/Message;", "conversationId", "isInMainConversation", "botId", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "from", "meetingRecordCreatePlatform", "openDocDetailPage", "page", "tryPrefetchData", "resourceType", "enterMethod", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "tryCloseChatFloatFragment", "docId", "isDocPageShown", "getAppIconUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPageToken", "getArtifactMetaId", "getArtifactType", "()Ljava/lang/Integer;", "getActionBarScene", "isFloatChat", "getSpeakInputHint", "getFloatChatShowPercent", "isDeepThinkingSwitchOn", "setInputTextFocusable", "focusable", "createDocDetailRouteInterceptor", "createOfficeUrlRouterInterceptor", "createFeishuDocLinkInterceptor", "shouldDeferFeishuDocLink", "url", "createOfficeApplyPermissionRouteInterceptor", "saveConv", "conv", "Lcom/larus/im/bean/conversation/Conversation;", "getCurConv", "getCurBot", "Lcom/larus/im/bean/bot/BotModel;", "getCurScene", "createNewDoc", "leaveAIEditMode", "shouldShowBackSegment", "clearReference", "enterStreamEditIfNeeded", "isDoubaoDoc", "doubaoDocUrlJump", "openOfficeDocByToken", "token", "originFileTypeString", "fallbackUrl", "getDocApplyPermissionIconResId", "getFeishuRecordId", "getRecordContentType", "getRecordScene", "getGeneralAgent", "getAgentChatId", "updateDocBrief", "artifactVersionId", "artifactType", "trackDocCreate", "pageToken", "enterFrom", "previousPage", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDocService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f330931a = null;

    /* JADX INFO: loaded from: classes27.dex */
    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\nH\u0096\u0001JO\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u0010\u0017\u001a\u00020\nH\u0096\u0001J\t\u0010\u0018\u001a\u00020\nH\u0096\u0001J\t\u0010\u0019\u001a\u00020\nH\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u001b\u001a\u00020\nH\u0096\u0001J\t\u0010\u001c\u001a\u00020\nH\u0096\u0001J\t\u0010\u001d\u001a\u00020\nH\u0096\u0001J#\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u0010!\u001a\u00020\u0005H\u0096\u0001J\t\u0010\"\u001a\u00020\u000fH\u0096\u0001J\u000b\u0010#\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u000e\u0010$\u001a\u00020\u000fH\u0096A¢\u0006\u0002\u0010%J\t\u0010&\u001a\u00020\u000fH\u0096\u0001J\u0010\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0001¢\u0006\u0002\u0010)J\u000b\u0010*\u001a\u0004\u0018\u00010+H\u0096\u0001J\u000b\u0010,\u001a\u0004\u0018\u00010-H\u0096\u0001J\u000b\u0010.\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0010\u0010/\u001a\u0004\u0018\u00010(H\u0096\u0001¢\u0006\u0002\u0010)J\u000b\u00100\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u00101\u001a\u00020(H\u0096\u0001J\u000b\u00102\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\t\u00103\u001a\u00020\u000fH\u0096\u0001J\u000b\u00104\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u000b\u00105\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u000b\u00106\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u000108H\u0096\u0001J\t\u00109\u001a\u00020\u0005H\u0096\u0001J\t\u0010:\u001a\u00020\u0005H\u0096\u0001J8\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020<2\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\b2\u0006\u0010A\u001a\u00020BH\u0096A¢\u0006\u0002\u0010CJ\t\u0010D\u001a\u00020(H\u0096\u0001J\t\u0010E\u001a\u00020\bH\u0096\u0001J\u0011\u0010F\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000fH\u0096\u0001J\t\u0010G\u001a\u00020(H\u0096\u0001J\t\u0010H\u001a\u00020\u0005H\u0096\u0001J!\u0010I\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010A\u001a\u00020B2\u0006\u0010J\u001a\u00020\u000fH\u0096\u0001J9\u0010K\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010L\u001a\u0004\u0018\u00010\u000f2\b\u0010M\u001a\u0004\u0018\u00010\u000f2\b\u0010N\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u001e\u0010O\u001a\u00020\b2\u0006\u0010=\u001a\u00020<2\u0006\u0010A\u001a\u00020BH\u0096A¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u00020\u00052\b\u0010R\u001a\u0004\u0018\u00010-H\u0096\u0001J\u0011\u0010S\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\bH\u0096\u0001J\u0011\u0010U\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u000fH\u0096\u0001J\t\u0010V\u001a\u00020\bH\u0096\u0001JS\u0010W\u001a\u00020\u00052\u0006\u0010X\u001a\u00020<2\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020(2\u0006\u0010[\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\\\u001a\u0004\u0018\u00010\u000f2\u0014\u0010]\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020_\u0018\u00010^H\u0096\u0001JA\u0010`\u001a\u00020\u00052\b\u0010a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010b\u001a\u00020(2\u0006\u0010c\u001a\u00020\u000f2\b\u0010d\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0013\u0010e\u001a\u00020\u00052\b\u0010f\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J@\u0010g\u001a\u00020\b2\b\u0010Y\u001a\u0004\u0018\u00010\u000f2\b\u0010b\u001a\u0004\u0018\u00010(2\b\u0010\\\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u000fH\u0096\u0001¢\u0006\u0002\u0010hJ#\u0010i\u001a\u00020\u00052\u0006\u0010Y\u001a\u00020\u000f2\b\u0010j\u001a\u0004\u0018\u00010\u000f2\u0006\u0010k\u001a\u00020(H\u0096\u0001¨\u0006l"}, d2 = {"Lcom/larus/doc/api/IDocService$Companion;", "Lcom/larus/doc/api/IDocService;", "<init>", "()V", "clearReference", "", "clickVoiceInput", "enable", "", "createAiEditBackRouteInterceptor", "Lcom/bytedance/router/interceptor/IInterceptor;", "createDocByMessage", "message", "Lcom/larus/im/bean/message/Message;", "conversationId", "", "isInMainConversation", "botId", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "from", "currentPage", "meetingRecordCreatePlatform", "createDocDetailRouteInterceptor", "createDocPasteRouteInterceptor", "createFeishuDocLinkInterceptor", "createNewDoc", "createNewDocRouteInterceptor", "createOfficeApplyPermissionRouteInterceptor", "createOfficeUrlRouterInterceptor", "doubaoDocUrlJump", "url", "enterMethod", "enterStreamEditIfNeeded", "getActionBarScene", "getAgentChatId", "getAppIconUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getArtifactMetaId", "getArtifactType", "", "()Ljava/lang/Integer;", "getCurBot", "Lcom/larus/im/bean/bot/BotModel;", "getCurConv", "Lcom/larus/im/bean/conversation/Conversation;", "getCurScene", "getDocApplyPermissionIconResId", "getFeishuRecordId", "getFloatChatShowPercent", "getGeneralAgent", "getPageToken", "getRecordContentType", "getRecordScene", "getSpeakInputHint", "getVoiceInputStatus", "Lkotlinx/coroutines/flow/StateFlow;", "init", "initDocSdk", "integrateFloatChatFragment", "Landroidx/fragment/app/Fragment;", "parentFragment", "sceneKey", "hasBottomTab", "useRemoteConv", "bundle", "Landroid/os/Bundle;", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;ZZLandroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDeepThinkingSwitchOn", "isDocPageShown", "isDoubaoDoc", "isFloatChat", "leaveAIEditMode", "openDocDetailPage", "page", "openOfficeDocByToken", "token", "originFileTypeString", "fallbackUrl", "refreshFloatChatRemoteBinding", "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveConv", "conv", "setInputTextFocusable", "focusable", "shouldDeferFeishuDocLink", "shouldShowBackSegment", "showDownloadPanel", WidgetService.PARAM_FRAGMENT, "resourceId", "resourceVersion", "showFrom", "artifactMetaId", "bizExtra", "", "", "trackDocCreate", "pageToken", "resourceType", "enterFrom", "previousPage", "tryCloseChatFloatFragment", "docId", "tryPrefetchData", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "updateDocBrief", "artifactVersionId", "artifactType", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IDocService {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Companion f330932c = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IDocService f330933b;

        static {
            f330932c = new Companion();
        }

        @Override // com.larus.doc.api.IDocService
        public final int A() {
            return this.f330933b.A();
        }

        @Override // com.larus.doc.api.IDocService
        public final String F9() {
            return this.f330933b.F9();
        }

        @Override // com.larus.doc.api.IDocService
        public final boolean G9(Context r100, String r101, String r110, String r111, String r112) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return this.f330933b.G9(r100, r101, r110, r111, r112);
        }

        @Override // com.larus.doc.api.IDocService
        public final a H9() {
            return this.f330933b.H9();
        }

        @Override // com.larus.doc.api.IDocService
        public final void I9(String r100, int r110, String r111, String r112, String r113, String r114) {
            Intrinsics.checkNotNullParameter(r111, "enterFrom");
            this.f330933b.I9(r100, r110, r111, r112, r113, r114);
        }

        @Override // com.larus.doc.api.IDocService
        public final a J9() {
            return this.f330933b.J9();
        }

        @Override // com.larus.doc.api.IDocService
        public final int K9() {
            return this.f330933b.K9();
        }

        @Override // com.larus.doc.api.IDocService
        public final a L9() {
            return this.f330933b.L9();
        }

        @Override // com.larus.doc.api.IDocService
        public final void M9(Fragment r100, String r101, Map r102) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r101, "resourceId");
            Intrinsics.checkNotNullParameter("drive", "showFrom");
            this.f330933b.M9(r100, r101, r102);
        }

        @Override // com.larus.doc.api.IDocService
        public final void N9(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "resourceId");
            this.f330933b.N9(r100, r101, r102);
        }

        @Override // com.larus.doc.api.IDocService
        public final void O9() {
            this.f330933b.O9();
        }

        @Override // com.larus.doc.api.IDocService
        public final void P1(e r100) {
            this.f330933b.P1(r100);
        }

        @Override // com.larus.doc.api.IDocService
        public final BotModel P4() {
            return this.f330933b.P4();
        }

        @Override // com.larus.doc.api.IDocService
        public final Integer P9() {
            return this.f330933b.P9();
        }

        @Override // com.larus.doc.api.IDocService
        public final void Q1(Message r110, String r111, boolean r112, String r113, Context r114, String r115, String r116, String r117) {
            Intrinsics.checkNotNullParameter(r111, "conversationId");
            Intrinsics.checkNotNullParameter(r114, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r115, "from");
            Intrinsics.checkNotNullParameter(r116, "currentPage");
            this.f330933b.Q1(r110, r111, r112, r113, r114, r115, r116, r117);
        }

        @Override // com.larus.doc.api.IDocService
        public final boolean Q9() {
            return this.f330933b.Q9();
        }

        @Override // com.larus.doc.api.IDocService
        public final int R() {
            return this.f330933b.R();
        }

        @Override // com.larus.doc.api.IDocService
        public final Object R9(DocFragment r100, Bundle r101, Continuation r102) {
            return this.f330933b.R9(r100, r101, r102);
        }

        @Override // com.larus.doc.api.IDocService
        public final String S9() {
            return this.f330933b.S9();
        }

        @Override // com.larus.doc.api.IDocService
        public final Object T9(DocFragment r100, String r101, boolean r102, Bundle r110, Continuation r111) {
            return this.f330933b.T9(r100, r101, r102, r110, r111);
        }

        @Override // com.larus.doc.api.IDocService
        public final String U0() {
            return this.f330933b.U0();
        }

        @Override // com.larus.doc.api.IDocService
        public final boolean U9(Context r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "url");
            return this.f330933b.U9(r100, r101, r102);
        }

        @Override // com.larus.doc.api.IDocService
        public final a V9() {
            return this.f330933b.V9();
        }

        @Override // com.larus.doc.api.IDocService
        public final String W3() {
            return this.f330933b.W3();
        }

        @Override // com.larus.doc.api.IDocService
        public final a W9() {
            return this.f330933b.W9();
        }

        @Override // com.larus.doc.api.IDocService
        public final void X9() {
            this.f330933b.X9();
        }

        @Override // com.larus.doc.api.IDocService
        public final String Y0() {
            return this.f330933b.Y0();
        }

        @Override // com.larus.doc.api.IDocService
        public final a Y9() {
            return this.f330933b.Y9();
        }

        @Override // com.larus.doc.api.IDocService
        public final void Z9(Context r100, Bundle r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "bundle");
            Intrinsics.checkNotNullParameter(r102, "page");
            this.f330933b.Z9(r100, r101, r102);
        }

        @Override // com.larus.doc.api.IDocService
        public final a aa() {
            return this.f330933b.aa();
        }

        @Override // com.larus.doc.api.IDocService
        public final String b7() {
            return this.f330933b.b7();
        }

        @Override // com.larus.doc.api.IDocService
        public final boolean ba(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            return this.f330933b.ba(r100);
        }

        @Override // com.larus.doc.api.IDocService
        public final boolean ca(String r100, Integer r101, String r102, String r110, String r111) {
            return this.f330933b.ca(r100, r101, r102, r110, r111);
        }

        @Override // com.larus.doc.api.IDocService
        public final void clearReference() {
            this.f330933b.clearReference();
        }

        @Override // com.larus.doc.api.IDocService
        public final String e4() {
            return this.f330933b.e4();
        }

        @Override // com.larus.doc.api.IDocService
        public final void enterStreamEditIfNeeded() {
            this.f330933b.enterStreamEditIfNeeded();
        }

        @Override // com.larus.doc.api.IDocService
        public final Object getAppIconUrl(Continuation<? super String> r100) {
            return this.f330933b.getAppIconUrl(r100);
        }

        @Override // com.larus.doc.api.IDocService
        public final String getCurScene() {
            return this.f330933b.getCurScene();
        }

        @Override // com.larus.doc.api.IDocService
        public final i1<Boolean> getVoiceInputStatus() {
            return this.f330933b.getVoiceInputStatus();
        }

        @Override // com.larus.doc.api.IDocService
        public final void init() {
            this.f330933b.init();
        }

        @Override // com.larus.doc.api.IDocService
        public final e p1() {
            return this.f330933b.p1();
        }

        @Override // com.larus.doc.api.IDocService
        public final String r1() {
            return this.f330933b.r1();
        }

        @Override // com.larus.doc.api.IDocService
        public final boolean shouldShowBackSegment() {
            return this.f330933b.shouldShowBackSegment();
        }

        @Override // com.larus.doc.api.IDocService
        public final String w0() {
            return this.f330933b.w0();
        }

        @Override // com.larus.doc.api.IDocService
        public final Integer w8() {
            return this.f330933b.w8();
        }

        private Companion() {
            this.f330933b = (IDocService) ServiceManager.get().getService(IDocService.class);
        }
    }

    static {
        f330931a = Companion.f330932c;
    }

    int A();

    String F9();

    boolean G9(Context r100, String r101, String r102, String r103, String r104);

    a H9();

    void I9(String r100, int r101, String r102, String r103, String r104, String r105);

    a J9();

    int K9();

    a L9();

    void M9(Fragment r100, String r101, Map r102);

    void N9(String r100, String r101, int r102);

    void O9();

    void P1(e r100);

    BotModel P4();

    Integer P9();

    void Q1(Message r100, String r101, boolean r102, String r103, Context r104, String r105, String r106, String r107);

    boolean Q9();

    int R();

    Object R9(DocFragment r100, Bundle r101, Continuation r102);

    String S9();

    Object T9(DocFragment r100, String r101, boolean r102, Bundle r103, Continuation r104);

    String U0();

    boolean U9(Context r100, String r101, String r102);

    a V9();

    String W3();

    a W9();

    void X9();

    String Y0();

    a Y9();

    void Z9(Context r100, Bundle r101, String r102);

    a aa();

    String b7();

    boolean ba(String r100);

    boolean ca(String r100, Integer r101, String r102, String r103, String r104);

    void clearReference();

    String e4();

    void enterStreamEditIfNeeded();

    Object getAppIconUrl(Continuation<? super String> r100);

    String getCurScene();

    i1<Boolean> getVoiceInputStatus();

    void init();

    e p1();

    String r1();

    boolean shouldShowBackSegment();

    String w0();

    Integer w8();
}
