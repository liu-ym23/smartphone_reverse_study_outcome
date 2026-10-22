package com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.collection.LruCache;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.utils.FormatSource;
import com.larus.bmhome.utils.s2;
import com.larus.bmhome.view.actionbar.ActionStyle;
import com.larus.bmhome.view.actionbar.MessageActionBarAlign;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.network.http.ServiceType;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.IObricContinuousTalkService;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f306112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.bmhome.chat.api.q0 f306113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.bmhome.chat.api.q0.a f306114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MessageActionBarAlign f306115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CustomMarkdownTextView f306116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Long> f306117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final BotModel f306118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final t1a.b f306119h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Fragment f306120i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f306121j;

    public static final class a {
    }

    static {
    }

    public static String c() {
        return zh8.a.f572196a.getReceiver().c().o6();
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.bmhome.chat.list.cell.text.components.bottom.actionbar.c2] */
    public final rs8.n e(final Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        z2.f365865a.w3();
        MessageActionBarAlign r101 = this.f306115d;
        int r102 = com.larus.utils.j0.f375426a;
        return new rs8.n(r101, com.larus.utils.j0.d(R.string.larus_accessibility_icon_read), new c2(this, r100));
    }

    public final rs8.j f(final Function0 r110) {
        Intrinsics.checkNotNullParameter(r110, "msgGetter");
        Context r100 = this.f306112a;
        Drawable r101 = ContextCompat.getDrawable(r100, v19.c.b(R.attr.larus_ic_msg_blue_tts_action_new, r100, R.drawable.larus_ic_msg_blue_tts_action_new));
        MessageActionBarAlign r111 = this.f306115d;
        int r102 = com.larus.utils.j0.f375426a;
        return new rs8.j("tts", R.id.msg_action_re_tts, "", r101, null, 0.0f, r111, false, false, null, null, com.larus.utils.j0.d(R.string.larus_accessibility_icon_read), new b2(this, r110), 1968);
    }

    public final rs8.g b(PlayStateEnum r110, Function0<Message> r111) {
        Intrinsics.checkNotNullParameter(r111, "msgGetter");
        boolean r100 = false;
        if (r110 == null) goto L5;
        int r112 = r110.getState();
    L6:
        Intrinsics.checkNotNullParameter(r111, "msgGetter");
        Message r101 = r111.invoke();
        IObricContinuousTalkService r102 = (IObricContinuousTalkService) ServiceManager.get().getService(IObricContinuousTalkService.class);
        if (r102 == null) goto L12;
        if (r102.a(r101.getMessageId()) != true) goto L12;
        r100 = true;
    L12:
        if (Intrinsics.areEqual(c(), r101.getMessageId()) == true) goto L15;
        if (r100 == true) goto L15;
        FLogger.f375446a.d("TtsActionCreator", "setup action bar, reading message not equal. reading msg id: " + c() + ", cur msg id: " + r101.getMessageId() + ", replyId: " + r101.getReplyId() + ", obricContinuousTtsPlaying=" + r100 + '.');
        return f(r111);
    L15:
        FLogger.f375446a.i("TtsActionCreator", "setup action bar, reading message equal. reading msg id: " + c() + ", cur msg id: " + r101.getMessageId() + ", replyId: " + r101.getReplyId() + ", state: " + r112 + ", obricContinuousTtsPlaying=" + r100);
        if (r100 == false) goto L19;
        return e(r101);
    L19:
        if (r112 != PlayStateEnum.PLAY_STATE_PLAYING.getState()) goto L22;
        return e(r101);
    L22:
        if (r112 != PlayStateEnum.PLAY_STATE_PREPARE.getState()) goto L25;
        return f(r111);
    L25:
        return f(r111);
    L5:
        r112 = 0;
        goto L6
    }

    public static final Object a(d2 r310, Message r311, Continuation r312) {
        r310.getClass();
        com.larus.bmhome.chat.model.repo.x1 r100 = zh8.a.f572196a.getReceiver().c();
        com.larus.bmhome.chat.api.q0.a r101 = r310.f306114c;
        lw8.l r102 = null;
        if (r101 == null) goto L7;
        com.larus.bmhome.chat.component.cvs.y r103 = r101.u0();
        if (r103 == null) goto L7;
        wc9.e r104 = r103.h();
    L8:
        LruCache<String, wc9.e> r105 = ko8.a.f504531a;
        if (r104 == null) goto L11;
        Integer r106 = r104.f559219v;
    L12:
        BotModel r107 = r310.f306118g;
        if (r107 == null) goto L15;
        Integer r108 = r107.getBotType();
    L16:
        BotModel r109 = r310.f306118g;
        if (r109 == null) goto L21;
        BotCreatorInfo r110 = r109.getBotCreatorInfo();
        if (r110 == null) goto L21;
        String r111 = r110.getId();
    L22:
        String r112 = ko8.a.f(r106, r108, Intrinsics.areEqual(r111, AccountService.f365697a.getUserId()));
        if (com.larus.im.bean.message.a.y0(r311) == true) goto L25;
    L51:
        Object r113 = com.larus.bmhome.chat.model.repo.x1.b.b(r100, r311, null, false, "click_play", r112, TtsScene.Manual_ActionView, r312, 22);
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L55;
        return r113;
    L55:
        return Unit.INSTANCE;
    L25:
        if (com.larus.bmhome.chat.bean.d.j0(r311) == false) goto L51;
        if (r310.f306118g == null) goto L51;
        gw8.c.f483071a.getClass();
        gw8.c r114 = gw8.c.a.b();
        if (r114 == null) goto L44;
        CustomMarkdownTextView r115 = r310.f306116e;
        boolean r116 = true;
        String r117 = hc8.b.a.a(hc8.c.f484552a, r311, r310.f306118g, true, 8);
        if (r311.getMessageStatusLocal() != 23) goto L33;
    L42:
        r102 = gw8.c.b.b(r114, r115, r117, r116, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31));
        goto L44
    L33:
        if (r311.getMessageStatusLocal() == 22) goto L42;
        if (com.larus.bmhome.chat.bean.d.I0(r311) == false) goto L37;
    L41:
        r116 = false;
        goto L42
    L37:
        if (r311.getMessageStatusLocal() == 20) goto L41;
        if (com.larus.bmhome.chat.bean.d.Q0(r311) == true) goto L41;
    L44:
        int r118 = s2.f315111a;
        String r119 = s2.b(r102, FormatSource.TTS, 4);
        String r120 = r310.f306118g.getBotId();
        if (r120 != null) goto L47;
        r120 = "";
    L47:
        Object r121 = com.larus.bmhome.chat.model.repo.x1.b.a(r100, r311, r119, r120, r112, false, null, TtsScene.Manual_ActionView, null, r312, 352);
        if (r121 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L56;
        return r121;
    L56:
        return Unit.INSTANCE;
    L21:
        r111 = null;
        goto L22
    L15:
        r108 = null;
        goto L16
    L11:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    public final void d(Message r710, com.larus.bmhome.chat.api.q0.a r711, String r712, String r713) {
        if (r711 == null) goto L8;
        com.larus.bmhome.chat.component.cvs.y r100 = r711.u0();
        if (r100 == null) goto L8;
        BotModel r101 = r100.j0();
        if (r101 == null) goto L8;
    L9:
        com.larus.bmhome.chat.api.q0 r102 = this.f306113b;
        if (r102 == null) goto L18;
        com.larus.bmhome.chat.api.i0 r103 = r102.N7();
        if (r103 == null) goto L18;
        ry8.b r104 = (ry8.b) r103.invoke();
        if (r104 == null) goto L18;
        Boolean r105 = r104.L9();
        if (r105 == null) goto L18;
        boolean r106 = r105.booleanValue();
    L19:
        com.larus.bmhome.chat.api.q0.a r107 = this.f306114c;
        String r108 = null;
        if (r107 == null) goto L24;
        com.larus.bmhome.chat.component.cvs.y r109 = r107.u0();
        if (r109 == null) goto L24;
        wc9.e r110 = r109.h();
    L25:
        String r111 = r101.getBotId();
        String r112 = r710.getConversationId();
        if (r112 == null) goto L28;
        Long r113 = StringsKt.toLongOrNull(r112);
    L30:
        if (com.larus.bmhome.chat.bean.d.z0(r710) == false) goto L32;
        long r114 = 1;
    L33:
        String r115 = r710.getMessageId();
        if (r106 == false) goto L36;
        String r116 = "1";
    L37:
        String r117 = r116;
        LruCache<String, wc9.e> r118 = ko8.a.f504531a;
        if (r110 == null) goto L40;
        Integer r119 = r110.f559219v;
    L41:
        Integer r120 = r101.getBotType();
        BotCreatorInfo r121 = r101.getBotCreatorInfo();
        if (r121 == null) goto L44;
        r108 = r121.getId();
    L44:
        String r122 = ko8.a.f(r119, r120, Intrinsics.areEqual(r108, AccountService.f365697a.getUserId()));
        boolean r123 = com.larus.bmhome.chat.bean.d.Q0(r710);
        tx9.c0.G(r111, r122, "answer", r113, Long.valueOf(r114), r115, r712, r117, Boolean.valueOf(r123), r713, "main_text", Boolean.valueOf(com.larus.bmhome.chat.bean.d.f0(r710)), Boolean.valueOf(com.larus.bmhome.chat.bean.d.K0(r710)), IAIChatControlTraceService.f365889a.ob(this.f306117f.invoke().longValue()), 262752);
        return;
    L40:
        r119 = null;
        goto L41
    L36:
        r116 = "0";
        goto L37
    L32:
        r114 = 0;
        goto L33
    L28:
        r113 = null;
    L24:
        r110 = null;
    L18:
        r106 = false;
    L8:
        r101 = new BotModel("-1", "unknown", null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -132, Integer.MAX_VALUE, null);
        goto L9
    }

    public d2(Context r100, com.larus.bmhome.chat.api.q0 r101, com.larus.bmhome.chat.api.q0.a r102, MessageActionBarAlign r103, Function0 r104, BotModel r105, t1a.b r106, Fragment r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r104, "chatKey");
        this.f306112a = r100;
        this.f306113b = r101;
        this.f306114c = r102;
        this.f306115d = r103;
        this.f306116e = null;
        this.f306117f = r104;
        this.f306118g = r105;
        this.f306119h = r106;
        this.f306120i = r110;
        this.f306121j = r111;
        ContextCompat.getDrawable(r100, v19.c.b(R.attr.larus_ic_msg_blue_tts_action_new, r100, R.drawable.larus_ic_msg_blue_tts_action_new));
        ActionStyle r107 = ActionStyle.NORMAL;
        rs8.i r108 = new rs8.i();
        Intrinsics.checkNotNullParameter("", "description");
        Intrinsics.checkNotNullParameter(r103, "messageActionBarAlign");
        Intrinsics.checkNotNullParameter(r107, "style");
        Intrinsics.checkNotNullParameter("", "accessibilityContent");
        Intrinsics.checkNotNullParameter(r108, SendEventContainerMethodParamModel.EventKinds.onClick);
        Intrinsics.checkNotNullParameter(ServiceType.MAIN_BOT, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter("ActionCreator", "subModule");
        Intrinsics.checkNotNullParameter("MainBot-ActionCreator", "tag");
    }
}
