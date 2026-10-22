package com.larus.bmhome.chat.thinkmode;

import com.larus.bmhome.actionbar.model.AgentMode;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096@¢\u0006\u0002\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/thinkmode/ThinkModeMemoryReportServiceImpl;", "Lcom/larus/bmhome/chat/thinkmode/IThinkModeMemoryReportService;", "<init>", "()V", "report", "", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "behaviorSource", "Lcom/larus/bmhome/chat/thinkmode/BehaviorSource;", "conversationSource", "Lcom/larus/bmhome/chat/thinkmode/ConversationSource;", "agentMode", "", "(Lcom/larus/bmhome/actionbar/model/ReplyOption;Lcom/larus/bmhome/chat/thinkmode/BehaviorSource;Lcom/larus/bmhome/chat/thinkmode/ConversationSource;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThinkModeMemoryReportServiceImpl implements IThinkModeMemoryReportService {

    public static final class a {
    }

    static {
    }

    public ThinkModeMemoryReportServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.thinkmode.IThinkModeMemoryReportService
    public final Object a(ReplyOption r210, BehaviorSource r211, ConversationSource r212, Integer r213, Continuation<? super Boolean> r214) {
        if ((r214 instanceof ThinkModeMemoryReportServiceImpl$report$1) == false) goto L7;
        ThinkModeMemoryReportServiceImpl$report$1 r100 = (ThinkModeMemoryReportServiceImpl$report$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ThinkModeMemoryReportServiceImpl$report$1 r110 = r100;
        Object r102 = r110.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        Object r111 = null;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L62
    L60:
        Object r105 = Result.m9449constructorimpl((com.larus.network.http.a) r102);     // Catch: Throwable -> L62
    L64:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L68;
        FLogger.f375446a.w("ThinkModeMemoryReport", "think mode memory report failed", r106);
    L68:
        if (Result.m9455isFailureimpl(r105) == true) goto L72;
        r111 = r105;
    L72:
        return Boxing.boxBoolean(((com.larus.network.http.a) r111) instanceof y);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r102);
        boolean r107 = false;
        if (r211 != BehaviorSource.UNKNOWN) goto L18;
    L73:
        FLogger.f375446a.w("ThinkModeMemoryReport", "skip report with unknown source");
        return Boxing.boxBoolean(false);
    L18:
        if (r212 == ConversationSource.UNKNOWN) goto L73;
        ModelItemIdentity r108 = r210.getModel();
        JSONObject r109 = new JSONObject();
        Integer r112 = Boxing.boxInt(r108.getDeprecatedItemId());
        if (r112.intValue() <= 0) goto L23;
        boolean r113 = true;
    L24:
        if (r113 == true) goto L27;
        r112 = null;
    L27:
        if (r112 == null) goto L29;
        r109.put("item_id", String.valueOf(r112.intValue()));
    L29:
        String r114 = r108.getKey();
        if (r114 != null) goto L32;
    L40:
        JSONObject r115 = new JSONObject();
        String r116 = r210.getModeId();
        if (r116 != null) goto L43;
        r116 = "";
    L43:
        r115.put("mode_id", r116);
        r115.put("model_item", r109);
        Integer r117 = r210.getReasoningEffort();
        if (r117 == null) goto L46;
        int r118 = r117.intValue();
    L47:
        r115.put("model_reasoning_effort", r118);
        if (r213 != null) goto L50;
    L57:
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L62
        JSONObject r120 = new JSONObject();     // Catch: Throwable -> L62
        r120.put("memory_scene", "new_chat");     // Catch: Throwable -> L62
        r120.put("memory_item", r115);     // Catch: Throwable -> L62
        r120.put("behavior_source", r211.getValue());     // Catch: Throwable -> L62
        r120.put("conversation_source", r212.getValue());     // Catch: Throwable -> L62
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L62
        r110.label = 1;     // Catch: Throwable -> L62
        r102 = HttpExtKt.k(ServiceType.UGC, Object.class, "/alice/slot/action_bar_v3/thinkmode_memory_report", r120, null, null, true, null, null, null, r110, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);     // Catch: Throwable -> L62
        if (r102 != r103) goto L60;
        return r103;
    L50:
        if (r213.intValue() == AgentMode.UNKNOWN.getValue()) goto L52;
        r107 = true;
    L52:
        if (r107 == false) goto L54;
        Integer r122 = r213;
    L55:
        if (r122 == null) goto L57;
        r115.put("agent_mode", r122.intValue());
        goto L57
    L54:
        r122 = null;
        goto L55
    L46:
        r118 = 0;
        goto L47
    L32:
        if (r114.length() <= 0) goto L34;
        boolean r123 = true;
    L35:
        if (r123 == true) goto L38;
        r114 = null;
    L38:
        if (r114 == null) goto L40;
        r109.put("model_item_key", r114);
        goto L40
    L34:
        r123 = false;
        goto L35
    L23:
        r113 = false;
    L62:
        th = move-exception;
        Result.Companion r124 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new ThinkModeMemoryReportServiceImpl$report$1(this, r214);
        goto L8
    }
}
