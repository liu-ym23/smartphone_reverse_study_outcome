package com.larus.bmhome.chat.trace.appreciable;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.collection.LruCache;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.chat.trace.ChatRenderTrace;
import com.larus.bmhome.chat.trace.imspan.IMSpanManager;
import com.larus.bmhome.instruction.core.model.ActiveSwitchType;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.common.apphost.AppHost;
import com.larus.extension.account_auth.api.FlowAccountAuthServiceDelegate;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMError;
import com.larus.im.depend.ISDKPointCallback;
import com.larus.platform.service.m3;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.spi.message.IObricAppreciablePoint;
import com.obric.trace.ObricActionBarTrackType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;
import wa8.t0;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f310120a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashSet<String> f310121b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashSet<String> f310122c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashSet<String> f310123d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final HashSet<String> f310124e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f310125f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f310126g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map<String, g> f310127h = null;

    public f() {
    }

    static {
        f310120a = new f();
        f310121b = new HashSet();
        f310122c = new HashSet();
        f310123d = new HashSet();
        f310124e = new HashSet();
        f310125f = LazyKt.lazy(new b());
        f310126g = LazyKt.lazy(new c());
        f310127h = new LinkedHashMap();
    }

    public static void c(Message r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        LruCache<String, ChatPageTrace.ChatPageRecord> r102 = ChatPageTrace.f310101a;
        Intrinsics.checkNotNullParameter(r100, "data");
        String r103 = ChatPageTrace.a(r100.getConversationId());
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        ChatPageTrace.ChatPageRecord r104 = ChatPageTrace.f310101a.remove(String.valueOf(r101));
        if (r104 == null) goto L22;
        FLogger.f375446a.i("ChatPageTrace", "onViewBind, cvsId=".concat(r103));
        r104.setOnDataBindTime(Long.valueOf(SystemClock.elapsedRealtime()));
        String r105 = r104.getBotId();
        if (r105 != null) goto L10;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == false) goto L16;
        r104.setBotId(BotInfoCache.INSTANCE.getBotId(r103));
    L16:
        ChatControlTrace r107 = ChatControlTrace.f309996b;
        r107.getClass();
        wc9.e r108 = ChatControlTrace.f310017o.get(r103);
        if (r108 == null) goto L19;
        Integer r109 = r108.f559219v;
    L20:
        BotInfoCache r110 = BotInfoCache.INSTANCE;
        r104.setChatType(r107.g(r109, r110.getBotType(r103), r110.isOwnBot(r103)));
        r104.setBindMessageType(r100.getContentType());
        r104.report();
        return;
    L19:
        r109 = null;
        goto L20
    L10:
        if (r105.length() == 0) goto L13;
        r106 = false;
        goto L14
    }

    public static void g(String r210, ISDKPointCallback.EndMsg r211) {
        Intrinsics.checkNotNullParameter(r210, "sendMsgId");
        Intrinsics.checkNotNullParameter(r211, "endMsg");
        FLogger r100 = FLogger.f375446a;
        r100.i("AppreciablePoint", "onSDKReceiveEnd, sendMsgId=" + r210 + ", endMsg=" + r211);
        nq9.f r101 = m3.f365766a.o();
        if (r101 == null) goto L5;
        r101.e(r210, r211);
    L5:
        String r102 = r211.getId();
        int r103 = r211.getContentType();
        boolean r110 = false;
        if (r102.length() <= 0) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L11;
        return;
    L11:
        if (r211.getHasSuggest() == false) goto L13;
        r102 = com.larus.bmhome.social.userchat.model.b0.k(r102, 1);
        r103 = 2;
    L13:
        int r105 = r211.getStatus();
        long r111 = SystemClock.elapsedRealtime();
        r100.i("AppreciablePoint", "onSDKReceiveEnd, sendMsgId=" + r210 + ", endMsg=" + r102 + ", endMsgContentType=" + r103 + ", endMsgStatus=" + r105);
        CommonParamManager.CommonParam r106 = CommonParamManager.c(r210);
        if (r106 == null) goto L16;
        String r107 = r106.getEndReceiveMsgId();
    L17:
        if (r107 != null) goto L59;
        Intrinsics.checkNotNullParameter(r210, "sendMsgId");
        Intrinsics.checkNotNullParameter(r102, "endReceiveMsgId");
        r100.i("CommonParamManager", "updateEndReceiveMsgId, sendMsgId=" + r210 + ", endReceiveMsgId=" + r102);
        CommonParamManager.CommonParam r108 = CommonParamManager.f310103a.get(r210);
        if (r108 == null) goto L22;
        r108.setEndReceiveMsgId(r102);
    L22:
        int r109 = ChatMessageResultTrace.f310100a;
        Intrinsics.checkNotNullParameter(r210, "sendMsgId");
        if (CommonParamManager.c(r210) == null) goto L25;
        new ChatMessageResultTrace.ReceiveRecord(null, Integer.valueOf(r103), Integer.valueOf(r105), null, null, null, null, 121, null).report(r210, r111);
    L25:
        if (r106 == null) goto L27;
        String r112 = r106.getLocalSendMsgId();
    L28:
        if (r112 != null) goto L30;
        r112 = "";
    L30:
        if (r105 != 0) goto L54;
        ChatMessageCostTrace.f310093a.getClass();
        Intrinsics.checkNotNullParameter(r210, "sendMsgId");
        Intrinsics.checkNotNullParameter(r102, "endMsgId");
        ChatMessageCostTrace.StepRecord r113 = ChatMessageCostTrace.f310095c.get(r210);
        if ((r113 instanceof ChatMessageCostTrace.AllFirstStep) == false) goto L34;
        ChatMessageCostTrace.AllFirstStep r114 = (ChatMessageCostTrace.AllFirstStep) r113;
    L35:
        if (r114 == null) goto L50;
        ConcurrentHashMap<String, ChatMessageCostTrace.ChildStepRecord> r115 = r114.getChildSteps();
        if (r115 == null) goto L50;
        ChatMessageCostTrace.ChildStepRecord r116 = r115.get(r102);
        if (r116 == null) goto L50;
        if ((r116 instanceof ChatMessageCostTrace.ContentCompleteStep) == true) goto L44;
        r116 = null;
    L44:
        if (r116 == null) goto L50;
        Long r117 = r116.getDurationRender();
        if (com.larus.platform.exp.s.f365402f == true) goto L48;
    L49:
        r100.i("ChatMessageCostTrace", "checkAllComplete trigger allComplete");
        ChatMessageCostTrace.c(r210, r102, Long.valueOf(r116.getStepTime()), r117);
        goto L50
    L48:
        if (r116.getRenderTimingResolved() == true) goto L49;
    L50:
        if (r106 == null) goto L52;
        r110 = Intrinsics.areEqual(r106.getLeavedChatPage(), Boolean.TRUE);
    L52:
        if (r110 == false) goto L57;
        IMSpanManager.c(r112, null, null);
        return;
    L57:
        return;
    L34:
        r114 = null;
        goto L35
    L54:
        LruCache<String, String> r118 = IMSpanManager.f310222a;
        IMSpanManager.c(r112, Integer.valueOf(r105), null);
        return;
    L27:
        r112 = null;
        goto L28
    L59:
        return;
    L16:
        r107 = null;
        goto L17
    L8:
        r104 = false;
        goto L9
    }

    public static void j(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "localMessageId");
        ChatMessageCostTrace.f310093a.getClass();
        Intrinsics.checkNotNullParameter(r100, "localMessageId");
        LruCache<String, ChatMessageCostTrace.StepRecord> r102 = ChatMessageCostTrace.f310095c;
        Objects.toString(r102.get(r100));
        ChatMessageCostTrace.StepRecord r103 = r102.get(r100);
        if ((r103 instanceof ChatMessageCostTrace.SdkSendStep) == false) goto L5;
        ChatMessageCostTrace.SdkSendStep r104 = (ChatMessageCostTrace.SdkSendStep) r103;
    L6:
        if (r104 == null) goto L9;
        FLogger.f375446a.i("ChatMessageCostTrace", "onSendMsgOnScreen localId=" + r100 + ", contentType=" + r101);
        ChatMessageCostTrace.SendMsgOnScreenStep r105 = new ChatMessageCostTrace.SendMsgOnScreenStep(Integer.valueOf(r101));
        r102.put(r100, r105);
        r105.report(r100);
        return;
    L9:
        return;
    L5:
        r104 = null;
        goto L6
    }

    public static void m(Message r210, String r211) {
        String r100 = r210.getMessageId();
        String r101 = "";
        if (r100 != null) goto L5;
        String r110 = "";
    L6:
        int r102 = r210.getContentType();
        String r103 = r210.getReplyId();
        if (r103 != null) goto L9;
        String r111 = "";
    L10:
        Map<String, String> r104 = r210.getExt();
        if (r104 == null) goto L13;
        String r105 = r104.get("general_agent");
    L14:
        boolean r106 = Intrinsics.areEqual(r105, "1");
        if (com.larus.im.bean.message.a.f0(r210) == true) goto L19;
        if (r106 == true) goto L19;
        boolean r112 = false;
    L21:
        if (com.larus.bmhome.chat.bean.d.G0(r210) == true) goto L30;
        int r107 = r210.getMessageStatusLocal();
        if (r107 == 20) goto L27;
        if (r107 == 21) goto L27;
        if (r107 == 24) goto L27;
        boolean r108 = false;
    L28:
        if (r108 == false) goto L30;
        boolean r109 = true;
    L32:
        if (r109 == false) goto L67;
        ChatMessageCostTrace.f310093a.getClass();
        Intrinsics.checkNotNullParameter(r210, "msg");
        String r113 = r210.getMessageId();
        if (r113 != null) goto L36;
        r113 = "";
    L36:
        LruCache<String, CommonParamManager.CommonParam> r114 = CommonParamManager.f310103a;
        CommonParamManager.CommonParam r115 = CommonParamManager.c(r210.getReplyId());
        if (r115 == null) goto L39;
        Long r116 = r115.getSendStartTime();
    L41:
        if (r113.length() != 0) goto L43;
        boolean r117 = true;
    L44:
        if (r117 == true) goto L67;
        if (r115 == null) goto L67;
        if (r116 == null) goto L67;
        String r118 = com.larus.im.bean.message.a.F(r210);
        Map<String, String> r119 = r210.getBusinessExt();
        if (r119 == null) goto L51;
        String r120 = r119.get("current_perf_mark");
    L52:
        if (r118 != null) goto L54;
    L57:
        boolean r121 = true;
    L58:
        if (r121 == true) goto L67;
        if (r120 == null) goto L67;
        if (ChatMessageCostTrace.f310094b.contains(r120) == false) goto L67;
        if (Intrinsics.areEqual(r115.getLatestPerfMarkRenderTokens().put(r113, r118), r118) == true) goto L67;
        FLogger.f375446a.d("ChatMessageCostTrace", "recordPerfMarkIfNeeded " + r113 + ' ' + r118 + ' ' + r120);
        long r122 = SystemClock.elapsedRealtime() - r116.longValue();
        if (r122 < 0) goto L67;
        r115.getPerfMarkDurations().putIfAbsent(r120, Long.valueOf(r122));
        goto L67
    L54:
        if (r118.length() == 0) goto L57;
        r121 = false;
        goto L58
    L51:
        r120 = null;
        goto L52
    L43:
        r117 = false;
        goto L44
    L39:
        r116 = null;
    L67:
        int r123 = r210.getMessageStatusLocal();
        if (r123 != 20) goto L70;
        String r124 = r111;
        String r125 = r110;
        ChatRenderTrace.f310039b.getClass();
        ChatRenderTrace.q(r210);
        HashSet<String> r126 = f310123d;
        if (r126.contains(r125) == true) goto L184;
        if (com.larus.im.bean.message.a.r0(r210) == true) goto L184;
        if (r102 == 8) goto L184;
        r126.add(r125);
        ChatMessageCostTrace.d(ChatMessageCostTrace.f310093a, r124, r125, r102, null, r210, !r112, 8);
        com.larus.bmhome.chat.trace.container.b r127 = com.larus.bmhome.chat.trace.container.b.f310187a;
        com.larus.bmhome.chat.trace.container.b.m(r210);
    L184:
        if (r112 == false) goto L199;
        lo8.a.b(r210);
        if (com.larus.bmhome.chat.bean.d.f0(r210) == true) goto L199;
        String r128 = com.larus.bmhome.chat.bean.d.r(r210);
        if (r128 != null) goto L190;
    L193:
        boolean r129 = true;
    L194:
        if (r129 == true) goto L199;
        JSONObject r130 = lo8.a.a(r210, r211);
        if (r130 == null) goto L199;
        ChatMessageCostTrace.f310093a.getClass();
        ChatMessageCostTrace.e(r124, r130);
        goto L199
    L190:
        if (r128.length() == 0) goto L193;
        r129 = false;
    L199:
        if (com.larus.im.bean.message.a.C0(r210) == true) goto L201;
        return;
    L201:
        if (com.larus.bmhome.chat.bean.d.e0(r210) == true) goto L203;
        return;
    L203:
        if (com.larus.bmhome.chat.bean.d.f0(r210) == true) goto L223;
        lo8.a.c(r210);
        return;
    L223:
        return;
    L70:
        if (r123 != 21) goto L72;
        ChatRenderTrace.f310039b.getClass();
        ChatRenderTrace.q(r210);
        if (((Set) f310126g.getValue()).contains(Integer.valueOf(r210.getContentType())) == false) goto L111;
        HashSet<String> r131 = f310123d;
        if (r131.contains(r110) == true) goto L111;
        r131.add(r110);
        ChatMessageCostTrace.d(ChatMessageCostTrace.f310093a, r111, r110, r102, null, r210, !r112, 8);
        com.larus.bmhome.chat.trace.container.b r132 = com.larus.bmhome.chat.trace.container.b.f310187a;
        com.larus.bmhome.chat.trace.container.b.m(r210);
    L111:
        if (r112 == false) goto L126;
        lo8.a.b(r210);
        if (com.larus.bmhome.chat.bean.d.f0(r210) == true) goto L126;
        String r133 = com.larus.bmhome.chat.bean.d.r(r210);
        if (r133 != null) goto L117;
    L120:
        boolean r134 = true;
    L121:
        if (r134 == true) goto L126;
        JSONObject r135 = lo8.a.a(r210, r211);
        if (r135 == null) goto L126;
        ChatMessageCostTrace.f310093a.getClass();
        ChatMessageCostTrace.e(r111, r135);
        goto L126
    L117:
        if (r133.length() == 0) goto L120;
        r134 = false;
    L126:
        if (com.larus.im.bean.message.a.C0(r210) == false) goto L133;
        if (com.larus.bmhome.chat.bean.d.e0(r210) == false) goto L133;
        if (com.larus.bmhome.chat.bean.d.f0(r210) == true) goto L133;
        lo8.a.c(r210);
    L133:
        if (com.larus.bmhome.chat.bean.d.Q0(r210) == true) goto L213;
        HashSet<String> r136 = f310124e;
        if (r136.contains(r110) == true) goto L214;
        r136.add(r110);
        ChatMessageCostTrace r137 = ChatMessageCostTrace.f310093a;
        r137.getClass();
        Intrinsics.checkNotNullParameter(r111, "sendMsgId");
        Intrinsics.checkNotNullParameter(r110, "receiveMsgId");
        Intrinsics.checkNotNullParameter(r210, r7);
        long r138 = SystemClock.elapsedRealtime();
        ChatMessageCostTrace.StepRecord r139 = ChatMessageCostTrace.f310095c.get(r111);
        if ((r139 instanceof ChatMessageCostTrace.AllFirstStep) == false) goto L139;
        ChatMessageCostTrace.AllFirstStep r140 = (ChatMessageCostTrace.AllFirstStep) r139;
    L140:
        if (r140 == null) goto L150;
        ConcurrentHashMap<String, ChatMessageCostTrace.ChildStepRecord> r141 = r140.getChildSteps();
        if (r141.get(r110) != null) goto L144;
        ChatMessageCostTrace.d(r137, r111, r110, r102, Long.valueOf(r138), r210, false, 32);
    L144:
        ChatMessageCostTrace.ChildStepRecord r142 = r141.get(r110);
        if ((r142 instanceof ChatMessageCostTrace.ContentFirstStep) == false) goto L147;
        ChatMessageCostTrace.ContentFirstStep r143 = (ChatMessageCostTrace.ContentFirstStep) r142;
    L148:
        if (r143 == null) goto L150;
        String r144 = null;
        final String r145 = r111;
        final String r146 = r110;
        ChatMessageCostTrace.ContentCompleteStep r147 = new ChatMessageCostTrace.ContentCompleteStep(r111, r110, Integer.valueOf(r102), null, null, null, null, 120, null);
        final long r148 = r138;
        r147.setStepTime(r148);
        r147.setIndex(r143.getIndex());
        r141.put(r146, r147);
        r147.report(r145);
    L151:
        Function1<Long, Unit> r149 = new l(r145, r146, r148);
        List<Function1<Long, Unit>> r150 = ChatMessageCostTrace.f310096d.get();
        if (r150 == null) goto L154;
        r150.add(r149);
    L156:
        if (com.larus.im.bean.message.a.C0(r210) == false) goto L215;
        HashMap<String, lo8.a.C6721a> r151 = lo8.a.f510153a;
        Intrinsics.checkNotNullParameter(r210, "msg");
        LruCache<String, CommonParamManager.CommonParam> r152 = CommonParamManager.f310103a;
        CommonParamManager.CommonParam r153 = CommonParamManager.c(r210.getReplyId());
        if (r153 == null) goto L216;
        Long r154 = r153.getSendStartTime();
        if (r154 == null) goto L217;
        long r155 = r154.longValue();
        HashMap<String, lo8.a.C6721a> r156 = lo8.a.f510153a;
        lo8.a.C6721a r157 = r156.get(r210.getMessageId());
        if (r157 == null) goto L218;
        Long r158 = r157.f510156b;
        if (r158 == null) goto L219;
        long r159 = r158.longValue();
        if (r159 < 0) goto L225;
        lo8.a.C6721a r160 = r156.get(r210.getMessageId());
        if (r160 == null) goto L171;
        r160.f510156b = -1L;
    L171:
        long r161 = r159 - r155;
        long r162 = SystemClock.elapsedRealtime() - r155;
        JSONObject r163 = new JSONObject();
        r163.put(MusicAppletPage.KEY_MESSAGE_ID, r210.getMessageId());
        CommonParamManager.CommonParam r164 = CommonParamManager.c(r210.getReplyId());
        if (r164 == null) goto L174;
        String r165 = r164.getChatType();
    L175:
        r163.put("chat_type", r165);
        r163.put("current_page", r211);
        r163.put("first_token_duration", r161);
        r163.put("total_duration", r162);
        com.larus.platform.service.o.f365780a.reportEvent("thinking_progress_main_text_duration", r163);
        com.larus.bmhome.utils.c.a("thinking_progress_main_text_duration", r163, true);
        return;
    L174:
        r165 = r144;
        goto L175
    L225:
        return;
    L219:
        return;
    L218:
        return;
    L217:
        return;
    L216:
        return;
    L215:
        return;
    L154:
        r149.invoke(r144);
        goto L156
    L147:
        r143 = null;
    L150:
        r148 = r138;
        r145 = r111;
        r146 = r110;
        r144 = null;
        goto L151
    L139:
        r140 = null;
        goto L140
    L214:
        return;
    L213:
        return;
    L72:
        if (r123 == 24) goto L104;
        switch(r123) {
            case 10: goto L92;
            case 11: goto L75;
            case 12: goto L92;
            case 13: goto L92;
            default: goto L224;
        };
    L75:
        HashSet<String> r166 = f310122c;
        if (CollectionsKt.contains(r166, r210.getLocalMessageId()) == false) goto L78;
    L87:
        HashSet<String> r167 = f310121b;
        if (r167.contains(r110) == false) goto L90;
        return;
    L90:
        if (com.larus.bmhome.chat.bean.d.G0(r210) == false) goto L207;
        r167.add(r110);
        ChatMessageCostTrace.f310093a.getClass();
        ChatMessageCostTrace.f(r110, r102);
        return;
    L207:
        return;
    L78:
        if (com.larus.bmhome.chat.bean.d.G0(r210) == false) goto L87;
        String r168 = r210.getLocalMessageId();
        if (r168 != null) goto L82;
        r168 = "";
    L82:
        r166.add(r168);
        String r169 = r210.getLocalMessageId();
        if (r169 == null) goto L86;
        r101 = r169;
    L86:
        j(r101, r210.getContentType());
        goto L87
    L92:
        HashSet<String> r170 = f310122c;
        if (CollectionsKt.contains(r170, r210.getLocalMessageId()) == false) goto L95;
        return;
    L95:
        if (com.larus.bmhome.chat.bean.d.G0(r210) == false) goto L210;
        String r171 = r210.getLocalMessageId();
        if (r171 != null) goto L99;
        r171 = "";
    L99:
        r170.add(r171);
        String r172 = r210.getLocalMessageId();
        if (r172 == null) goto L103;
        r101 = r172;
    L103:
        j(r101, r210.getContentType());
        return;
    L210:
        return;
    L224:
        return;
    L104:
        ChatRenderTrace.f310039b.getClass();
        ChatRenderTrace.q(r210);
        return;
    L27:
        r108 = true;
    L30:
        r109 = false;
    L19:
        r112 = true;
        goto L21
    L13:
        r105 = null;
        goto L14
    L9:
        r111 = r103;
        goto L10
    L5:
        r110 = r100;
        goto L6
    }

    public static void d(List r100, String r101, Function1 r102) {
        Intrinsics.checkNotNullParameter(r100, "list");
        if (r102 != null) goto L9;
        Iterator r103 = CollectionsKt.take(r100, 5).iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Message r104 = (Message) r103.next();
        f310120a.getClass();
        m(r104, r101);
        goto L6
    L8:
        return;
    L9:
        final ArrayList r105 = new ArrayList();
        ChatMessageCostTrace.f310093a.getClass();
        ChatMessageCostTrace.f310096d.set(r105);
        Iterator r106 = CollectionsKt.take(r100, 5).iterator();     // Catch: Throwable -> L25
    L12:
        if (r106.hasNext() == false) goto L15;
        Message r107 = (Message) r106.next();     // Catch: Throwable -> L25
        f310120a.getClass();     // Catch: Throwable -> L25
        m(r107, r101);     // Catch: Throwable -> L25
        goto L12
    L15:
        ChatMessageCostTrace.f310093a.getClass();
        ChatMessageCostTrace.f310096d.remove();
        if (r105.isEmpty() == false) goto L19;
        return;
    L19:
        if (((Boolean) r102.invoke(new e(r105))).booleanValue() == true) goto L24;
        Iterator r108 = r105.iterator();
    L22:
        if (r108.hasNext() == false) goto L34;
        ((Function1) r108.next()).invoke(null);
        goto L22
    L34:
        return;
    L24:
        return;
    L25:
        th = move-exception;
        ChatMessageCostTrace.f310093a.getClass();
        ChatMessageCostTrace.f310096d.remove();
        throw th;
    }

    public static void a(String r100, String r101, String r102, long r103) {
        LruCache<String, ChatPageTrace.ChatPageRecord> r104 = ChatPageTrace.f310101a;
        FLogger.f375446a.i("ChatPageTrace", "onCreated, cvsId=" + r100 + ", botId=" + r101 + ", previousPage=" + r102);
        ChatPageTrace.ChatPageRecord r105 = ChatPageTrace.f310101a.get(String.valueOf(r103));
        if (r105 == null) goto L6;
        r105.setOnCreateTime(Long.valueOf(SystemClock.elapsedRealtime()));
        return;
    }

    public static void b(String r100, String r101, String r102, long r103) {
        LruCache<String, ChatPageTrace.ChatPageRecord> r104 = ChatPageTrace.f310101a;
        FLogger.f375446a.i("ChatPageTrace", "onPageLoad, cvsId=" + r100 + ", botId=" + r101 + ", previousPage=" + r102);
        String r105 = ChatPageTrace.a(r100);
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        ChatPageTrace.ChatPageRecord r106 = ChatPageTrace.f310101a.get(String.valueOf(r103));
        if (r106 == null) goto L15;
        r106.setOnPageLoadTime(Long.valueOf(SystemClock.elapsedRealtime()));
        if (o0.d(r101) == false) goto L10;
        r106.setBotId(r101);
    L10:
        r106.setPreviousPage(r102);
        if (com.larus.platform.exp.c.f365375e == false) goto L13;
        r106.setHasLocal(1);
        return;
    L13:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChatPageTrace$onPageLoad$1$1(r106, r105, null), 2, null);
        return;
    }

    public static void e(String r210, String r211, int r212, IIMError r213, Map r310) {
        Intrinsics.checkNotNullParameter(r210, "localSendMsgId");
        String r100 = null;
        if (r211 == null) goto L5;
        int r101 = 0;
    L20:
        FLogger r102 = FLogger.f375446a;
        r102.i("AppreciablePoint", "onSDKAck, localId=" + r210 + ", msgId=" + r211 + ", contentType=" + r212 + " status = " + r101);
        if (r211 == null) goto L31;
        f310121b.remove(r211);
        LruCache<String, CommonParamManager.CommonParam> r103 = CommonParamManager.f310103a;
        Intrinsics.checkNotNullParameter(r210, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r211, "sendMsgId");
        r102.i("CommonParamManager", "updateSendMsgId, from=" + r210 + " to=" + r211);
        LruCache<String, CommonParamManager.CommonParam> r104 = CommonParamManager.f310103a;
        CommonParamManager.CommonParam r105 = r104.remove(r210);
        if (r105 == null) goto L25;
        r104.put(r211, r105);
        r105.setAckTime(Long.valueOf(SystemClock.elapsedRealtime()));
        r105.setSendMsgId(r211);
    L25:
        AudioServiceDelegate.f288288a.N().d(r211, r210);
        com.larus.bmhome.chat.trace.container.b r106 = com.larus.bmhome.chat.trace.container.b.f310187a;
        com.larus.bmhome.chat.trace.container.b.n(r210, r211);
        HashMap<String, lo8.a.C6721a> r107 = lo8.a.f510153a;
        Intrinsics.checkNotNullParameter(r210, "localMsgId");
        Intrinsics.checkNotNullParameter(r211, RemoteMessageConst.MSGID);
        Map<String, String> r108 = lo8.a.f510154b;
        if (r108.containsKey(r210) == false) goto L28;
        r108.put(r210, r211);
    L28:
        IObricAppreciablePoint.f392896a.getClass();
        IObricAppreciablePoint r109 = IObricAppreciablePoint.a.f392898b;
        if (r109 == null) goto L31;
        r109.a(r210, r211);
    L31:
        int r110 = ChatMessageResultTrace.f310100a;
        if (r211 != null) goto L34;
        String r111 = r210;
    L35:
        Intrinsics.checkNotNullParameter(r111, "sendMsgId");
        if (r213 == null) goto L38;
        Integer r214 = Integer.valueOf(r213.getCode());
    L39:
        if (r213 == null) goto L41;
        Integer r215 = Integer.valueOf(r213.getCode());
    L42:
        if (r213 == null) goto L44;
        String r216 = r213.getTips();
    L45:
        if (r213 == null) goto L49;
        Throwable r112 = r213.getException();
        if (r112 == null) goto L49;
        String r217 = r112.getMessage();
    L51:
        if (r310 == null) goto L56;
        String r113 = (String) r310.get("spring_guide_card_id");
        if (r113 == null) goto L56;
        String r114 = r113;
    L57:
        if (r310 == null) goto L62;
        String r115 = (String) r310.get("is_spring_guide");
        if (r115 == null) goto L62;
        String r116 = r115;
    L63:
        if (r310 == null) goto L68;
        String r117 = (String) r310.get("common_venue_guide_card_id");
        if (r117 == null) goto L68;
        String r118 = r117;
    L69:
        if (r310 == null) goto L74;
        String r119 = (String) r310.get("is_common_venue_guide");
        if (r119 == null) goto L74;
        String r120 = r119;
    L75:
        if (r310 == null) goto L80;
        String r121 = (String) r310.get("delay_request_interval_ms");
        if (r121 == null) goto L80;
        String r122 = r121;
    L81:
        new ChatMessageResultTrace.SendRecord(null, Integer.valueOf(r212), Integer.valueOf(r101), null, null, r114, r116, r118, r120, r122, r214, r215, r216, r217, 25, null).report(r111);
        if (r101 == 0) goto L90;
        LruCache<String, String> r123 = IMSpanManager.f310222a;
        if (r213 == null) goto L86;
        Integer r124 = Integer.valueOf(r213.getCode());
    L87:
        if (r213 == null) goto L89;
        r100 = r213.getTips();
    L89:
        IMSpanManager.c(r210, r124, r100);
        goto L90
    L86:
        r124 = null;
    L90:
        nq9.f r125 = m3.f365766a.o();
        if (r125 == null) goto L94;
        r125.f(r210, r211);
        return;
    L94:
        return;
    L80:
        r122 = "";
    L74:
        r120 = "";
    L68:
        r118 = "";
    L62:
        r116 = "";
    L56:
        r114 = "";
    L49:
        r217 = null;
        goto L51
    L44:
        r216 = null;
        goto L45
    L41:
        r215 = null;
        goto L42
    L38:
        r214 = null;
        goto L39
    L34:
        r111 = r211;
        goto L35
    L5:
        if (r213 == null) goto L7;
        String r126 = r213.getTips();
    L9:
        if (Intrinsics.areEqual(r126, "Timeout") == false) goto L11;
        r101 = 2;
        goto L20
    L11:
        if (r213 == null) goto L19;
        Map<String, String> r127 = r213.getExt();
        if (r127 == null) goto L15;
        String r128 = r127.get("key_is_business_error");
    L17:
        if (Intrinsics.areEqual(r128, "1") == false) goto L19;
        r101 = 7;
        goto L20
    L15:
        r128 = null;
    L19:
        r101 = 1;
        goto L20
    L7:
        r126 = null;
        goto L9
    }

    public static void h(String r110, int r111, String r210, String r211, ModelItemIdentity r212) {
        Intrinsics.checkNotNullParameter(r211, "sendFuncChannel");
        if (r110 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r212, t0.f558889e) == false) goto L8;
        String r100 = "task";
    L23:
        boolean r101 = false;
        if (r111 != 1) goto L27;
        if (r210 == null) goto L27;
        int r102 = r210.length();
    L28:
        ChatMessageCostTrace.f310093a.getClass();
        Intrinsics.checkNotNullParameter(r110, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r211, "sendFuncChannel");
        Intrinsics.checkNotNullParameter(r100, "queryType");
        CommonParamManager.CommonParam r103 = CommonParamManager.c(r110);
        if (r103 == null) goto L31;
        r103.setSendMsgOnBusinessTime(Long.valueOf(SystemClock.elapsedRealtime()));
    L31:
        CommonParamManager.CommonParam r104 = CommonParamManager.c(r110);
        if (r104 == null) goto L34;
        r104.setSendFuncChannel(r211);
    L34:
        FLogger.f375446a.i("ChatMessageCostTrace", "onSdkSendMsg localSendMsgId=".concat(r110));
        LruCache<String, ChatMessageCostTrace.StepRecord> r105 = ChatMessageCostTrace.f310095c;
        ChatMessageCostTrace.StepRecord r106 = r105.get(r110);
        Long r107 = null;
        if ((r106 instanceof ChatMessageCostTrace.SendStartStep) == false) goto L37;
        ChatMessageCostTrace.SendStartStep r108 = (ChatMessageCostTrace.SendStartStep) r106;
    L38:
        if (r108 == null) goto L57;
        r105.remove(r110);
        ChatMessageCostTrace.SdkSendStep r109 = new ChatMessageCostTrace.SdkSendStep(Integer.valueOf(r111), null, null, null, 0, 30, null);
        r105.put(r110, r109);
        CommonParamManager.CommonParam r112 = CommonParamManager.c(r110);
        if (r112 == null) goto L42;
        Long r113 = r112.getSendStartTime();
    L43:
        r109.setStartSendTimeInMillSec(Long.valueOf(ChatMessageCostTrace.g(r113)));
        r109.setSendEndTimeInMillSec(Long.valueOf(ChatMessageCostTrace.g(Long.valueOf(r109.getStepTime()))));
        r109.setQueryType(r100);
        r109.setTextLength(r102);
        if (r112 == null) goto L54;
        Long r114 = r109.getDuration(r110);
        if (r114 != null) goto L48;
    L53:
        r112.setSendToSdkTimeDuration(r107);
        goto L54
    L48:
        if (r114.longValue() <= 0) goto L51;
        r101 = true;
    L51:
        if (Boolean.valueOf(r101).booleanValue() == false) goto L53;
        r107 = r114;
    L54:
        r109.report(r110);
        return;
    L42:
        r113 = null;
        goto L43
    L57:
        return;
    L37:
        r108 = null;
    L27:
        r102 = 0;
        goto L28
    L8:
        if (Intrinsics.areEqual(r212, t0.f558888d) == false) goto L11;
        r100 = "pro";
        goto L23
    L11:
        if (Intrinsics.areEqual(r212, t0.f558886b) == false) goto L14;
        r100 = "deepthinking";
        goto L23
    L14:
        if (Intrinsics.areEqual(r212, t0.f558887c) == false) goto L17;
        r100 = "autocot";
        goto L23
    L17:
        if (Intrinsics.areEqual(r212, t0.f558885a) == false) goto L19;
        r100 = "normal";
        goto L23
    L19:
        if (r212 == null) goto L22;
        r100 = r212.getKey();
        if (r100 != null) goto L23;
    L22:
        r100 = "";
        goto L23
    }

    public static void i(String r100, String r101, int r102, String r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r101, "scene");
        int r105 = p.f310142a;
        Intrinsics.checkNotNullParameter(r100, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r101, "scene");
        if (r103 == null) goto L5;
    L24:
        JSONObject r106 = new JSONObject();
        r106.put("status", r104);
        r106.put("content_type", r102);
        r106.put("error_type", r103);
        JSONObject r107 = a.b(CommonParamManager.c(r100), r106);
        FLogger.f375446a.i("ChatMessageFailedBeforeACKTrace", "onSendFailed, event=message_send_result, param=" + r107);
        com.larus.platform.service.o.f365780a.reportEvent("message_send_result", r107);
        com.larus.bmhome.utils.c.a("message_send_result", r107, true);
        LruCache<String, String> r108 = IMSpanManager.f310222a;
        IMSpanManager.b(r100, "message_send_result", r107);
        return;
    L5:
        switch(r101.hashCode()) {
            case 3143036: goto L19;
            case 92896879: goto L15;
            case 109413407: goto L12;
            case 109641682: goto L8;
            default: goto L23;
        };
    L23:
        String r109 = "msg_send_failed";
    L22:
        r103 = r109;
        goto L24
    L8:
        if (r101.equals(ObricActionBarTrackType.SPEAK) == false) goto L23;
        r109 = "asr_recog_failed";
        goto L22
    L12:
        if (r101.equals("shoot") == false) goto L23;
    L17:
        r109 = "img_upload_failed";
        goto L22
    L15:
        if (r101.equals("album") == true) goto L17;
    L19:
        if (r101.equals("file") == false) goto L23;
        r109 = "file_upload_failed";
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void k(f r310, String r311, String r312, String r313, long r410, String r411) {
        Bundle r210 = null;
        r310.getClass();
        Intrinsics.checkNotNullParameter(r313, "channel");
        Intrinsics.checkNotNullParameter(r411, "schema");
        LruCache<String, ChatPageTrace.ChatPageRecord> r100 = ChatPageTrace.f310101a;
        Intrinsics.checkNotNullParameter(r313, "channel");
        Intrinsics.checkNotNullParameter(r411, "url");
        FLogger.f375446a.i("ChatPageTrace", "onStart, cvsId=" + r311 + ", botId=" + r312);
        String r101 = ChatPageTrace.a(r311);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r110 = r101;
        ChatPageTrace.ChatPageRecord r111 = new ChatPageTrace.ChatPageRecord(r313, null, null, Long.valueOf(r410), r411, null, null, null, null, null, null, null, null == true ? 1 : 0, null == true ? 1 : 0, null, 0, null, null, null, null, null, null, null, null, r210, null, null, null, null, 520093670, null);
        long r102 = SystemClock.elapsedRealtime();
        AppHost.Companion r103 = AppHost.f326268a;
        r111.setDistanceToAppStart(Long.valueOf(r102 - r103.getAppStartTime().getFirst().longValue()));
        r111.setOnStartTime(Long.valueOf(SystemClock.elapsedRealtime()));
        r111.setCvsId(r110);
        r111.setBotId(r312);
        if (r103.isPlugin() == false) goto L12;
        r111.setAuthStatusCode(Integer.valueOf(FlowAccountAuthServiceDelegate.f342480b.a()));
        if (ChatPageTrace.f310102b == false) goto L10;
        int r104 = 1;
    L11:
        r111.setFirstEnter(r104);
        goto L12
    L10:
        r104 = 0;
    L12:
        ChatPageTrace.f310101a.put(String.valueOf(r410), r111);
        ChatPageTrace.f310102b = false;
        com.larus.bmhome.chat.trace.container.b r105 = com.larus.bmhome.chat.trace.container.b.f310187a;
        com.larus.bmhome.chat.trace.container.b.r(r311, r313);
    }

    public static /* synthetic */ void f(f r100, String r101, String r102, int r103, IIMError r104, Map r105, int r106) {
        if ((r106 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r106 & 8) == 0) goto L9;
        r104 = null;
    L9:
        if ((r106 & 16) == 0) goto L11;
        r105 = null;
    L11:
        r100.getClass();
        e(r101, r102, r103, r104, r105);
    }

    public static void l(f r610, final String r611, final String r612, final String r613, int r614, List r615, Map r616, String r710, Long r711, int r712) {
        if ((r712 & 8) == 0) goto L5;
        final int r100 = 1;
    L7:
        if ((r712 & 16) == 0) goto L9;
        List r101 = null;
    L11:
        if ((r712 & 32) == 0) goto L13;
        Map r102 = null;
    L15:
        if ((r712 & 64) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r712 & 128) == 0) goto L21;
        Long r104 = null;
    L22:
        r610.getClass();
        Intrinsics.checkNotNullParameter(r611, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r612, "cvsId");
        Intrinsics.checkNotNullParameter(r613, "scene");
        ReplyOption r105 = com.larus.bmhome.instruction.c.f311900a.a(BotInfoCache.INSTANCE.getBotId(r612), ActiveSwitchType.DEEPTHINK.getValue());
        Object r110 = com.larus.bmhome.view.actionbar.custom.cache.e.f315871a;
        int r111 = com.larus.bmhome.view.actionbar.custom.cache.e.c(r105);
        ChatMessageCostTrace.f310093a.getClass();
        Intrinsics.checkNotNullParameter(r611, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r612, "cvsId");
        Intrinsics.checkNotNullParameter(r613, "scene");
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L31
        if (r102 == null) goto L28;
        String r107 = (String) r102.get("pocket_map");     // Catch: Throwable -> L31
        if (r107 == null) goto L28;
        Map r108 = ChatMessageCostTrace.b(r107);     // Catch: Throwable -> L31
    L29:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L31
    L34:
        if (Result.m9455isFailureimpl(r109) == false) goto L36;
        r109 = null;
    L36:
        Map r112 = (Map) r109;
        if (r112 == null) goto L41;
        Object r113 = r112.get("pocket_id");
        if (r113 == null) goto L41;
        String r114 = r113.toString();
    L42:
        boolean r115 = false;
        if (r112 != null) goto L45;
    L47:
        boolean r116 = false;
    L49:
        if (r116 == false) goto L55;
        c0.f310111a.getClass();
        AppHost.Companion r117 = AppHost.f326268a;
        long r118 = r117.getAppClock().currentTimeMillis();
        FLogger r119 = FLogger.f375446a;
        r119.i("SpringMainVenueMessageTimeRecorder", "[getLastSendMsgByUserMillisDiff] currentTimeMillis = " + r118 + ", lastSendMsgByUserMs = " + c0.f310112b);
        Long r120 = c0.f310112b;
        if (r120 == null) goto L53;
        int r121 = (int) (r118 - r120.longValue());
    L54:
        String r122 = String.valueOf(r121);
        long r123 = r117.getAppClock().currentTimeMillis();
        r119.i("SpringMainVenueMessageTimeRecorder", "[updateLastSendMsgByUserMillis] currentTimeMillis = " + r123 + ", lastSendMsgByUserMs = " + c0.f310112b);
        c0.f310112b = Long.valueOf(r123);
        String r124 = "spring_guide_2026";
        String r125 = r122;
    L56:
        if (r102 == null) goto L58;
        String r126 = (String) r102.get("delay_request_interval_ms");
    L59:
        if (r102 == null) goto L61;
        String r127 = (String) r102.get("pocket_entry_to_send_msg_cost");
    L62:
        final long r128 = System.currentTimeMillis();
        if (r104 == null) goto L65;
        long r129 = r128 - r104.longValue();
    L66:
        ChatMessageCostTrace.SendStartStep r130 = new ChatMessageCostTrace.SendStartStep(Integer.valueOf(r100), Long.valueOf(r129), Integer.valueOf(r111));
        FLogger r131 = FLogger.f375446a;
        r131.i("ChatMessageCostTrace", "onStartSendMsg localSendMsgId=" + r611);
        ChatMessageCostTrace.f310095c.put(r611, r130);
        LruCache<String, CommonParamManager.CommonParam> r132 = CommonParamManager.f310103a;
        long r133 = r130.getStepTime();
        Intrinsics.checkNotNullParameter(r613, "scene");
        Intrinsics.checkNotNullParameter(r611, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r612, "cvsId");
        Intrinsics.checkNotNullParameter(r125, "intervalMs");
        CommonParamManager.CommonParam r134 = new CommonParamManager.CommonParam(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, -1, 63, null);
        CommonParamManager.f310103a.put(r611, r134);
        if (r103 != 0) goto L69;
    L75:
        String r135 = CommonParamManager.b();
    L76:
        r134.setScene(r613);
        r134.setSendStartEpochMs(Long.valueOf(r128));
        r134.setCTraceId(r135);
        Map r136 = MapsKt.createMapBuilder();
        r136.put("c_trace_id", r135);
        r136.put("scene", r613);
        r134.setMessageTrackCommonTags(MapsKt.build(r136));
        if (r114 != 0) goto L79;
        String r137 = "";
    L80:
        r134.setSpringGuideCardId(r137);
        r134.setSpringGuide(r124);
        r134.setDelayRequestIntervalMs(r126);
        r134.setIntervalMs(r125);
        r134.setEntryToSendMsgCost(r127);
        r134.setSendMsgContentType(Integer.valueOf(r100));
        r134.setLocalSendMsgId(r611);
        r134.setCvsId(r612);
        BotInfoCache r138 = BotInfoCache.INSTANCE;
        r134.setBotId(r138.getBotId(r612));
        ChatControlTrace r139 = ChatControlTrace.f309996b;
        r139.getClass();
        wc9.e r140 = ChatControlTrace.f310017o.get(r612);
        if (r140 == null) goto L83;
        String r141 = ic8.n.i(r140);
    L84:
        r134.setConvType(r141);
        if (r140 == null) goto L87;
        Integer r142 = r140.f559219v;
    L88:
        r134.setChatType(r139.g(r142, r138.getBotType(r612), r138.isOwnBot(r612)));
        r134.setSendStartTime(Long.valueOf(r133));
        r131.i("CommonParamManager", "createAndSave, param=" + r134);
        r130.report(r611);
        final List r143 = r101;
        com.larus.utils.t0.a(new d(r611, r612, r613, r100, r143, r128));
        IObricAppreciablePoint.f392896a.getClass();
        IObricAppreciablePoint r144 = IObricAppreciablePoint.a.f392898b;
        if (r144 == null) goto L91;
        r144.b(r611);
    L91:
        com.larus.bmhome.chat.trace.container.b r145 = com.larus.bmhome.chat.trace.container.b.f310187a;
        CommonParamManager.CommonParam r146 = CommonParamManager.c(r611);
        if (r146 == null) goto L94;
        String r147 = r146.getConvType();
    L95:
        if (r147 != null) goto L97;
        r147 = "";
    L97:
        com.larus.bmhome.chat.trace.container.b.o(r611, r147);
        HashMap<String, lo8.a.C6721a> r148 = lo8.a.f510153a;
        Intrinsics.checkNotNullParameter(r611, "localMsgId");
        lo8.a.f510154b.put(r611, null);
        return;
    L94:
        r147 = null;
        goto L95
    L87:
        r142 = null;
        goto L88
    L83:
        r141 = null;
        goto L84
    L79:
        r137 = r114;
        goto L80
    L69:
        if (r103.length() <= 0) goto L71;
        r115 = true;
    L71:
        if (r115 == false) goto L73;
        r135 = r103;
    L74:
        if (r135 != null) goto L76;
    L73:
        r135 = null;
        goto L74
    L65:
        r129 = -1;
        goto L66
    L61:
        r127 = null;
        goto L62
    L58:
        r126 = null;
        goto L59
    L53:
        r121 = -1;
        goto L54
    L55:
        r124 = "";
        r125 = r124;
        goto L56
    L45:
        if ((!r112.isEmpty()) != true) goto L47;
        r116 = true;
    L41:
        r114 = null;
    L28:
        r108 = null;
    L31:
        th = move-exception;
        Result.Companion r149 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L21:
        r104 = r711;
        goto L22
    L17:
        r103 = r710;
        goto L19
    L13:
        r102 = r616;
        goto L15
    L9:
        r101 = r615;
        goto L11
    L5:
        r100 = r614;
        goto L7
    }
}
