package com.larus.bmhome.chat.helper;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.awemeopen.apps.framework.comment.api.constants.CommentPublishScene;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.router.SmartRouter;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.p0;
import com.larus.audio.realtimecall.IRealtimeCallStrategy;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.ChatLandingChannel;
import com.larus.bmhome.chat.bean.ChatPassThroughParams;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.bmhome.chat.model.i1;
import com.larus.bmhome.chat.require.IMainBotService;
import com.larus.bmhome.chat.require.MainBotServiceDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.model.RecommendFrom;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import tx9.x3;

/* JADX INFO: loaded from: classes25.dex */
public final class ConversationClickHelper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f303062f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f303063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f303064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConversationModel f303065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final by7.e f303066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f303067e;

    public static final class a {
    }

    static {
    }

    private final Context getContext() {
        return this.f303063a.getContext();
    }

    public final void e(Bundle r100) {
        if (this.f303067e == false) goto L6;
        ic8.k.b(r100, new ChatPassThroughParams(null, true, false, null, 13, null));
        return;
    }

    public static final void b(ConversationClickHelper r110, ni8.e r111, String r112) {
        r110.getClass();
        if (r111.f519373v == 6) goto L11;
        Integer r100 = r111.f519365n;
        if (r100 != null) goto L8;
    L10:
        boolean r101 = false;
    L13:
        if (r101 == false) goto L22;
        vi8.c.f555352a.getClass();
        if (vi8.c.a() == true) goto L17;
        FLogger.f375446a.i("DouBaoConversationClickHelper", "ignore service bot conversation click because effective gate is disabled");
        return;
    L17:
        com.bytedance.router.i r102 = SmartRouter.buildRoute(r110.getContext(), "//flow/chat_page");
        Bundle r113 = r110.c(r111, r110.f303064b, r112);
        by7.e r114 = r110.f303066d;
        if (r114 == null) goto L20;
        by7.h.k(r113, r114);
    L20:
        r102.f267554c.putExtras(r113);
        r102.f267555d = R.anim.larus_router_slide_in_right;
        r102.f267556e = R.anim.larus_router_no_anim;
        r102.d();
        return;
    L22:
        if (r111.f519356e == true) goto L24;
        Integer r103 = r111.f519363l;
        if (r103 != null) goto L57;
    L62:
        x3.a("conversation_click", "chat_list_blocked", "conversation_type=" + r111.f519363l);
        return;
    L57:
        if (r103.intValue() != 3) goto L62;
        com.bytedance.router.i r104 = SmartRouter.buildRoute(r110.getContext(), "//flow/chat_page");
        r104.f267554c.putExtra("landing_channel", ChatLandingChannel.CHAT_LIST.getChannel());
        Bundle r115 = r110.c(r111, r110.f303064b, r112);
        by7.e r116 = r110.f303066d;
        if (r116 == null) goto L61;
        by7.h.k(r115, r116);
    L61:
        r104.f267554c.putExtras(r115);
        r104.f267555d = R.anim.larus_router_slide_in_right;
        r104.f267556e = R.anim.larus_router_no_anim;
        r104.d();
        return;
    L24:
        if (ic8.l0.a(r111.f519364m) == false) goto L49;
        Context r105 = r110.getContext();
        if (r105 == null) goto L69;
        MainBotServiceDelegate r106 = MainBotServiceDelegate.f308544b;
        Bundle r107 = r110.c(r111, r110.f303064b, r112);
        by7.e r117 = r110.f303066d;
        if (r117 == null) goto L31;
        by7.h.k(r107, r117);
    L31:
        Unit r118 = Unit.INSTANCE;
        ConversationPage r119 = r111.f519359h;
        if (r119 == null) goto L36;
        Integer r120 = r119.getDefaultStatus();
        if (r120 == null) goto L36;
        int r121 = r120.intValue();
    L37:
        int r108 = r121;
        ConversationPage r122 = r111.f519359h;
        if (r122 == null) goto L41;
        List<Integer> r123 = r122.getPageList();
        if (r123 == null) goto L41;
    L42:
        List<Integer> r109 = r123;
        ConversationPage r124 = r111.f519359h;
        if (r124 == null) goto L47;
        Integer r125 = r124.getPagePosition();
        if (r125 == null) goto L47;
        int r126 = r125.intValue();
    L48:
        r106.c(r105, new IMainBotService.a(r107, r108, r109, r126, R.anim.larus_router_slide_in_right, R.anim.larus_router_no_anim, null, 64));
        return;
    L47:
        r126 = 0;
    L41:
        r123 = CollectionsKt.emptyList();
    L36:
        r121 = PageType.Chat.getType();
        goto L37
    L69:
        return;
    L49:
        com.bytedance.router.i r127 = SmartRouter.buildRoute(r110.getContext(), "//flow/chat_page_double_tab");
        Bundle r128 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", r110.f303064b), TuplesKt.to("argConversationId", r111.f519352a), TuplesKt.to("argClickEnterFrom", r111.f519362k), TuplesKt.to("argBotId", r111.f519361j), TuplesKt.to("argBotType", r111.f519365n), TuplesKt.to("argBotRecommendFrom", r111.f519367p), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r111.f519360i)), TuplesKt.to("argBotPosition", r112), TuplesKt.to("default_tab", Integer.valueOf(r111.f519358g)), TuplesKt.to(CommentPublishScene.CONVERSATION_PAGE, r111.f519359h), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("argBotRecommendFrom", r111.f519367p), TuplesKt.to("argBotConversationType", Integer.valueOf(r111.f519373v))});
        r110.e(r128);
        r128.putInt("red_dot_entry_unread_count", r111.f519374w);
        r128.putLong("red_dot_entry_read_message_index", r111.f519375x);
        by7.e r129 = r110.f303066d;
        if (r129 == null) goto L52;
        by7.h.k(r128, r129);
    L52:
        r127.f267554c.putExtras(r128);
        r127.f267555d = R.anim.larus_router_slide_in_right;
        r127.f267556e = R.anim.larus_router_no_anim;
        r127.d();
        return;
    L8:
        if (r100.intValue() != 4) goto L10;
    L11:
        r101 = true;
        goto L13
    }

    public final Bundle c(ni8.e r100, String r101, String r102) {
        Bundle r103 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argPreviousPage", r101), TuplesKt.to("argConversationId", r100.f519352a), TuplesKt.to("argBotId", r100.f519361j), TuplesKt.to("argBotType", r100.f519365n), TuplesKt.to("argClickEnterFrom", r100.f519362k), TuplesKt.to("argCvsBgImgUrl", r100.f519353b), TuplesKt.to("argCvsBgImgColor", r100.f519354c), TuplesKt.to("argCvsBgImgOpen", Boolean.valueOf(r100.f519355d)), TuplesKt.to("is_create_sub_conversation", Boolean.valueOf(r100.f519360i)), TuplesKt.to("argBotPosition", r102), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("enter_from", "bot_list"), TuplesKt.to("navigate_up_from", "chat_list"), TuplesKt.to("argBotRecommendFrom", r100.f519367p), TuplesKt.to("argBotConversationType", Integer.valueOf(r100.f519373v)), TuplesKt.to("is_from_chat_list", Boolean.TRUE), TuplesKt.to("argChatTitle", r100.f519372u)});
        r103.putInt("red_dot_entry_unread_count", r100.f519374w);
        r103.putLong("red_dot_entry_read_message_index", r100.f519375x);
        e(r103);
        return r103;
    }

    public final void d(wh8.a r110, String r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r112, "argPosition");
        BotModel r100 = null;
        wc9.e r101 = null;
        if (r110 == null) goto L9;
        wc9.e r102 = r110.f559708a;
        if (r102 == null) goto L9;
        ConversationPage r103 = r102.f559204g;
        if (r103 == null) goto L9;
        List<Integer> r104 = r103.getPageList();
    L10:
        boolean r105 = ic8.l0.b(r104);
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("name is >>> ");
        if (r110 == null) goto L15;
        wc9.e r108 = r110.f559708a;
        if (r108 == null) goto L15;
        String r109 = r108.f559200c;
    L16:
        r107.append(r109);
        r106.i("DouBaoConversationClickHelper", r107.toString());
        StringBuilder r114 = new StringBuilder("botConversationType is >>> ");
        if (r110 == null) goto L21;
        wc9.e r115 = r110.f559708a;
        if (r115 == null) goto L21;
        Integer r116 = r115.f559219v;
    L22:
        r114.append(r116);
        r106.i("DouBaoConversationClickHelper", r114.toString());
        boolean r117 = true;
        int r118 = 0;
        if (r110 == null) goto L32;
        wc9.e r119 = r110.f559708a;
        if (r119 == null) goto L32;
        Integer r120 = r119.f559219v;
        if (r120 == null) goto L32;
        if (r120.intValue() != 4) goto L32;
        boolean r121 = true;
    L33:
        if (r110 == null) goto L37;
        wc9.e r122 = r110.f559708a;
        if (r122 == null) goto L37;
        String r123 = ic8.n.e(r122);
    L38:
        if (r121 == false) goto L47;
        r106.i("DouBaoConversationClickHelper", "current conversation is douyin");
        if (r110 == null) goto L107;
        wc9.e r124 = r110.f559708a;
        if (r124 == null) goto L108;
        SmartRouter.buildRoute(getContext(), "//flow/douyin_bot").d();
        ConversationModel r125 = this.f303065c;
        if (r125 == null) goto L109;
        r125.reportAwemeConversation(r124);
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L47:
        if (com.larus.utils.o0.d(r123) == false) goto L49;
        SmartRouter.buildRoute(getContext(), r123).d();
        return;
    L49:
        if (r110 == null) goto L51;
        wc9.e r126 = r110.f559708a;
    L53:
        if (ic8.n.q(r126) == false) goto L99;
        JSONObject r127 = new JSONObject();
        if (r110 == null) goto L57;
        wc9.e r128 = r110.f559708a;
    L59:
        if (ic8.n.w(r128) == false) goto L61;
        String r129 = "doubao_pc_history";
    L62:
        r127.put("cell_type", r129);
        if (r110 == null) goto L65;
        String r130 = r110.f559715h;
    L66:
        if (r130 != null) goto L68;
    L71:
        int r131 = 1;
    L72:
        r127.put("if_list_empty", r131);
        tx9.c0.t(r127);
        if (r110 == null) goto L75;
        wc9.e r132 = r110.f559708a;
    L77:
        if (ic8.n.w(r132) == false) goto L93;
        if (r110 == null) goto L80;
        String r133 = r110.f559715h;
    L81:
        if (r133 != null) goto L83;
    L86:
        if (r117 == false) goto L93;
        if (r110 == null) goto L89;
        r101 = r110.f559708a;
    L89:
        String r134 = ic8.n.h(r101);
        if (com.larus.utils.o0.d(r134) == false) goto L93;
        SmartRouter.buildRoute(getContext(), r134).d();
        return;
    L83:
        if (r133.length() == 0) goto L86;
        r117 = false;
        goto L86
    L80:
        r133 = null;
    L93:
        com.bytedance.router.i r135 = SmartRouter.buildRoute(getContext(), "//flow/chat_only_list");
        if (r110 == null) goto L98;
        wc9.e r136 = r110.f559708a;
        if (r136 == null) goto L98;
        r118 = r136.F;
    L98:
        r135.f267554c.putExtra("page_type", r118);
        Bundle r137 = new Bundle();
        e(r137);
        r135.f267554c.putExtras(r137);
        r135.f267555d = R.anim.larus_router_slide_in_right;
        r135.f267556e = R.anim.larus_router_no_anim;
        r135.d();
        return;
    L75:
        r132 = null;
        goto L77
    L68:
        if (r130.length() == 0) goto L71;
        r131 = 0;
        goto L72
    L65:
        r130 = null;
        goto L66
    L61:
        r129 = "unadded_bot_list";
        goto L62
    L57:
        r128 = null;
        goto L59
    L99:
        p0 r138 = AudioServiceDelegate.f288288a.getAudioConfig();
        if (r110 == null) goto L103;
        r100 = r110.f559709b;
    L103:
        if (r138.n(r100) == false) goto L105;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f303063a), null, null, new ConversationClickHelper$handleConversationClick$4(this, r110, r112, r113, null), 3, null);
        return;
    L105:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f303063a), null, null, new ConversationClickHelper$handleConversationClick$5(r110, this, r105, r111, r112, null), 3, null);
        return;
    L51:
        r126 = null;
    L37:
        r123 = null;
    L32:
        r121 = false;
    L21:
        r116 = null;
    L15:
        r109 = null;
    L9:
        r104 = null;
        goto L10
    }

    public ConversationClickHelper(Fragment r100, String r101, ConversationModel r102, by7.e r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "currentPageName");
        this.f303063a = r100;
        this.f303064b = r101;
        this.f303065c = r102;
        this.f303066d = r103;
        this.f303067e = r104;
    }

    public static final Object a(ConversationClickHelper r100, wh8.a r110, String r111, String r112, Continuation r113) {
        r100.getClass();
        if ((r113 instanceof ConversationClickHelper$directToRealtimeCall$1) == false) goto L7;
        ConversationClickHelper$directToRealtimeCall$1 r101 = (ConversationClickHelper$directToRealtimeCall$1) r113;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r114 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        Message r105 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r115 = (String) r101.L$3;
        r112 = (String) r101.L$2;
        r111 = (String) r101.L$1;
        wh8.a r106 = (wh8.a) r101.L$0;
        ResultKt.throwOnFailure(r114);
        String r116 = r115;
        r110 = r106;
        Object r107 = r114;
    L48:
        String r108 = (String) r107;
    L49:
        if (r110 == null) goto L51;
        RecommendFrom r109 = r110.f559713f;
    L53:
        if (r109 == null) goto L55;
        RecommendFrom r117 = r110.f559713f;
    L56:
        com.bytedance.router.i r118 = SmartRouter.buildRoute(r100.getContext(), "//flow/realtime_chat_gate");
        Bundle r119 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argConversationId", r116), TuplesKt.to("argBotRecommendFrom", r117), TuplesKt.to("argPreviousPage", r100.f303064b), TuplesKt.to("enter_method", "click_chat"), TuplesKt.to("enter_from", r100.f303064b), TuplesKt.to("argBotPosition", r111), TuplesKt.to("adapter_fix_bottom_tab", "true"), TuplesKt.to("is_call_bot", "1")});
        IRealtimeCallStrategy.RealtimeCallStrategyDelegate r120 = IRealtimeCallStrategy.f289776a;
        if (r110 == null) goto L59;
        wc9.e r121 = r110.f559708a;
    L60:
        if (r110 == null) goto L62;
        r105 = r110.f559710c;
    L62:
        r119.putAll(r120.a(r121, r105));
        by7.e r122 = r100.f303066d;
        if (r122 == null) goto L65;
        by7.h.k(r119, r122);
    L65:
        r118.f267554c.putExtras(r119);
        r118.d();
        return Unit.INSTANCE;
    L59:
        r121 = null;
        goto L60
    L55:
        r117 = new RecommendFrom(r112, null, null, 6);
        goto L56
    L51:
        r109 = null;
        goto L53
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r114);
        if (r110 == null) goto L19;
        wc9.e r123 = r110.f559708a;
        if (r123 == null) goto L19;
        r116 = r123.f559198a;
    L20:
        if (r116 == null) goto L24;
        Lazy r124 = ic8.n.f489237a;
        Intrinsics.checkNotNullParameter(r116, "<this>");
        if (com.larus.im.j.f(r116) != true) goto L24;
        boolean r125 = true;
    L25:
        if (r125 == false) goto L49;
        if (r110.f559709b == null) goto L49;
        wc9.e r126 = r110.f559708a;
        if (r126 == null) goto L34;
        Map<String, String> r127 = r126.f559221x;
        if (r127 == null) goto L34;
        Map<String, String> r128 = MapsKt.toMutableMap(r127);
        if (r128 == null) goto L34;
    L36:
        if (i1.a(r110) == false) goto L43;
        BotStatusCacheDelegate r129 = BotStatusCacheDelegate.f296446b;
        BotModel r130 = r110.f559709b;
        if (r130 == null) goto L41;
        String r131 = r130.getBotId();
        if (r131 == null) goto L41;
    L42:
        r129.a(r131, true);
    L41:
        r131 = "";
    L43:
        ConversationModel r132 = r100.f303065c;
        if (r132 == null) goto L49;
        BotModel r133 = r110.f559709b;
        r101.L$0 = r110;
        r101.L$1 = r111;
        r101.L$2 = r112;
        r101.L$3 = r116;
        r101.label = 1;
        r107 = r132.createLocalConversation(r133, r128, r101);
        if (r107 != r103) goto L48;
        return r103;
    L34:
        r128 = new HashMap();
    L24:
        r125 = false;
    L19:
        r116 = null;
    L7:
        r101 = new ConversationClickHelper$directToRealtimeCall$1(r100, r113);
        goto L8
    }
}
