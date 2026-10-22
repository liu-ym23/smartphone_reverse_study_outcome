package com.larus.bmhome.view.actionbar.bot;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.ChatSender;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.chat.model.strategy.ChatSendUtils;
import com.larus.bmhome.chat.trace.z;
import com.larus.im.bean.conversation.Templates;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActionBarPanelAdapter f315696a;

    public h(ActionBarPanelAdapter r100) {
        this.f315696a = r100;
    }

    @Override // com.larus.bmhome.view.actionbar.bot.g
    public final void a(Templates r210, int r211) {
        Intrinsics.checkNotNullParameter(r210, "templates");
        String r110 = UUID.randomUUID().toString();
        z.f310295a.d(r110);
        RepoDispatcher.f307729a.getClass();
        ChatRepo r100 = RepoDispatcher.f307732d;
        r100.f307632d.b(this.f315696a.f315679a);
        ChatSender r101 = r100.f307633e;
        String r102 = String.valueOf(r210.getTemplateName());
        String r103 = this.f315696a.f315679a;
        ChatSendUtils r104 = ChatSendUtils.f307932a;
        Pair[] r105 = new Pair[1];
        Long r106 = r210.getId();
        long r111 = 0;
        if (r106 == null) goto L5;
        long r107 = r106.longValue();
    L6:
        r105[0] = TuplesKt.to("msg_template_id", String.valueOf(r107));
        r104.getClass();
        Map r108 = ChatSendUtils.p(r105);
        Function0<ChatPageContext> r109 = this.f315696a.f315682d;
        if (r109 == null) goto L9;
        ChatPageContext r112 = r109.invoke();
    L10:
        u1.a.f(r101, r102, r103, "chat_action_bar_discover", r108, null, null, r110, false, null, "ActionBarPanelAdapter", null, r112, null, false, 27496);
        String r113 = String.valueOf(r210.getBotId());
        ChatParam r114 = this.f315696a.f315681c;
        if (r114 == null) goto L15;
        String r115 = r114.f296889a;
        if (r115 == null) goto L15;
        Long r116 = Long.valueOf(k.a(r115));
    L16:
        Long r117 = r210.getId();
        if (r117 == null) goto L19;
        r111 = r117.longValue();
    L19:
        long r118 = ((long) r211) + 1;
        String r119 = r210.getRequestId();
        ChatParam r120 = this.f315696a.f315681c;
        if (r120 == null) goto L22;
        String r121 = r120.f296891c;
    L23:
        if (r120 == null) goto L25;
        String r122 = r120.f296892d;
    L26:
        Long r123 = Long.valueOf(r118);
        Long r124 = Long.valueOf(r111);
        JSONObject r125 = new JSONObject();
        Intrinsics.checkNotNullParameter(r125, "params");
        r125.put("bot_id", r113);     // Catch: JSONException -> L42
        if (r123 == null) goto L30;
        r125.put(BdpAppEventConstant.PARAMS_CLICK_POSITION, r123.longValue());     // Catch: JSONException -> L42
    L30:
        if (r116 == null) goto L32;
        r125.put("conversation_id", r116.longValue());     // Catch: JSONException -> L42
    L32:
        if (r122 == null) goto L34;
        r125.put("current_page", r122);     // Catch: JSONException -> L42
    L34:
        if (r121 == null) goto L36;
        r125.put("previous_page", r121);     // Catch: JSONException -> L42
    L36:
        r125.put("recommend_from", "chat_action_bar_discover");     // Catch: JSONException -> L42
        if (r119 == null) goto L39;
        r125.put("req_id", r119);     // Catch: JSONException -> L42
    L39:
        if (r124 == null) goto L44;
        r125.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, r124.longValue());     // Catch: JSONException -> L42
    L44:
        TrackParams r126 = new TrackParams().merge(r125);
        by7.a r127 = new by7.a("chat_action_bar_discover_click");
        r127.f21463a.merge(r126);
        r127.b();
        this.f315696a.f315683e.invoke(String.valueOf(r210.getTemplateName()));
        Dialog r128 = this.f315696a.f315680b;
        Handler r129 = DialogLancet.resolveDialogHandler(r128);
        if (r129 != null) goto L47;
    L49:
        DialogLancet.beforeDialogDismiss(r128);
        r128.dismiss();     // Catch: Throwable -> L52 Exception -> L54
    L59:
        DialogLancet.afterDialogDismiss(r128);
        return;
    L54:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L52
        Throwable r130 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L52
        if (r130 == null) goto L59;
        com.bytedance.crash.d.d(r130, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r128);
        throw th;
    L47:
        if (Looper.myLooper() == r129.getLooper()) goto L49;
        r129.post(DialogLancet.createDismissRunnable(r128));
        return;
    L42:
        e = move-exception;
        FLogger.f375446a.e("ChatEventHelper", "error in ChatEventHelper chatActionBarDiscoverClick " + e.getLocalizedMessage());
        goto L44
    L25:
        r122 = null;
        goto L26
    L22:
        r121 = null;
    L15:
        r116 = null;
        goto L16
    L9:
        r112 = null;
        goto L10
    L5:
        r107 = 0;
        goto L6
    }
}
