package com.larus.bmhome.chat.component.ext;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.auth.FeedbackMeta;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.bean.ChatMsgDeleteScene;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.trace.ChatMessageTrace;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.tipoff.TipOffDialogFragment;
import com.larus.bmhome.tipoff.TipOffDialogParams;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MsgFeedbackType;
import com.larus.platform.model.RecommendFrom;
import com.larus.platform.model.SearchMobParam;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class ChatFragmentDelegateDialogExtKt {
    public static void a(CommonDialog r100, FragmentManager r101) {
        LandscapeRestrictionOperation r102 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r100, null, r102);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r101, r100, r102) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r100.show(r101, null);
    }

    public static void b(FragmentManager r110, Message r111, Integer r112, int r113) {
        String r100 = null;
        if ((r113 & 8) == 0) goto L5;
        Boolean r101 = Boolean.FALSE;
    L7:
        if ((r113 & 16) == 0) goto L9;
        r112 = null;
    L9:
        Intrinsics.checkNotNullParameter(r110, "fm");
        Intrinsics.checkNotNullParameter(r111, "chatMessage");
        Fragment r102 = r110.findFragmentByTag("dislikeDialogClose");
        if ((r102 instanceof DialogFragment) == false) goto L12;
        DialogFragment r103 = (DialogFragment) r102;
    L13:
        if (r103 != null) goto L72;
        e0 r104 = AuthModelDelegate.f297134b.e().getValue();
        if (r104 == null) goto L23;
        LaunchInfo r105 = r104.f297186a;
    L24:
        ArrayList<FeedbackMeta> r106 = new ArrayList();
        boolean r107 = false;
        if (r105 == null) goto L38;
        List<FeedbackMeta> r108 = r105.G0();
        if (r108 == null) goto L38;
        ArrayList r109 = new ArrayList();
        Iterator<T> r114 = r108.iterator();
    L30:
        if (r114.hasNext() == false) goto L37;
        Object r115 = r114.next();
        if (((FeedbackMeta) r115).c() != MsgFeedbackType.MsgFeedbackTypeDislike.value) goto L34;
        boolean r116 = true;
    L35:
        if (r116 == false) goto L30;
        r109.add(r115);
        goto L30
    L34:
        r116 = false;
        goto L35
    L37:
        r106.addAll(r109);
    L38:
        Bundle r117 = new Bundle();
        r117.putString(MusicAppletPage.KEY_MESSAGE_ID, r111.getMessageId());
        Map<String, String> r118 = r111.getExt();
        if (r118 == null) goto L41;
        String r119 = r118.get("inner_log_id");
    L42:
        r117.putString("message_log_id", r119);
        Integer r120 = r111.getFeedback();
        if (r120 == null) goto L45;
        int r121 = r120.intValue();
    L46:
        r117.putInt("last_feedback", r121);
        if (r112 == null) goto L49;
        r117.putInt("feedback_scene", r112.intValue());
    L49:
        r117.putString("section_id", r111.getSectionId());
        IObricChatUIService r122 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r122 != null) goto L52;
    L54:
        if (r107 == true) goto L85;
        IAIChatService.Companion r123 = IAIChatService.f365899a;
        if (r105 == null) goto L58;
        r100 = r105.H0();
    L58:
        if (r101 == null) goto L60;
        r117.putBoolean("direct_report_reason", r101.booleanValue());
    L60:
        r117.putBoolean("is_multiple_selection", true);
        Unit r124 = Unit.INSTANCE;
        DialogFragment r125 = r123.k7(r106, r100, r117);
        if (r125.isAdded() == true) goto L86;
        LandscapeRestrictionOperation r126 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L68
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r125, "dislikeDialogClose", r126);     // Catch: Exception -> L68
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r110, r125, r126) == true) goto L88;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L71
    L66:
        r125.show(r110, "dislikeDialogClose");     // Catch: Exception -> L68
        return;
    L88:
        return;
    L68:
        e = move-exception;
        FLogger.f375446a.e("DislikeDialog", "find dislike dialog exception: " + e);
        return;
    L86:
        return;
    L85:
        return;
    L52:
        if (r122.N(r110, r111, r117) != true) goto L54;
        r107 = true;
        goto L54
    L45:
        r121 = MsgFeedbackType.MsgFeedbackTypeDefault.value;
        goto L46
    L41:
        r119 = null;
        goto L42
    L23:
        r105 = null;
        goto L24
    L72:
        r103.dismiss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r127 = DialogFragmentLancet.sLastShowStack;
        if (r127 == null) goto L83;
        com.bytedance.crash.d.d(r127, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L83:
        return;
    L12:
        r103 = null;
        goto L13
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x016c -> B:47:0x0176). Please report as a decompilation issue!!! */
    public static final Object c(List<Message> r210, String r211, JSONObject r212, ChatMsgDeleteScene r213, Integer r310, Continuation<? super Unit> r311) {
        if ((r311 instanceof ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1) == false) goto L7;
        ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1 r100 = (ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        String r105 = (String) r100.L$5;
        List r106 = (List) r100.L$4;
        Integer r107 = (Integer) r100.L$3;
        JSONObject r108 = (JSONObject) r100.L$2;
        String r109 = (String) r100.L$1;
        List<Message> r110 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
        List<Message> r111 = r110;
    L83:
        ChatMessageTrace r112 = ChatMessageTrace.f310037a;
        ChatMessageTrace.d(r111, r109, r107, !r106.isEmpty(), r105, r108);
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Iterator r113 = (Iterator) r100.L$8;
        String r114 = (String) r100.L$7;
        List r115 = (List) r100.L$6;
        String r116 = (String) r100.L$5;
        List<Message> r117 = (List) r100.L$4;
        Integer r118 = (Integer) r100.L$3;
        JSONObject r119 = (JSONObject) r100.L$2;
        String r120 = (String) r100.L$1;
        r111 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L74:
        if (r113.hasNext() == false) goto L78;
        Message r121 = (Message) r113.next();
        ye8.b r122 = ChatInputService.f303327b.f();
        r100.L$0 = r111;
        r100.L$1 = r120;
        r100.L$2 = r119;
        r100.L$3 = r118;
        r100.L$4 = r117;
        r100.L$5 = r116;
        r100.L$6 = r115;
        r100.L$7 = r114;
        r100.L$8 = r113;
        r100.label = 3;
        if (r122.a(r121, r100) != r103) goto L74;
        return r103;
    L78:
        Object r123 = r103;
        r105 = r114;
        r106 = r115;
        String r124 = r116;
        List<Message> r214 = r117;
        r107 = r118;
        r108 = r119;
        r109 = r120;
    L80:
        RepoDispatcher.f307729a.getClass();
        ChatRepo r125 = RepoDispatcher.f307732d;
        r100.L$0 = r111;
        r100.L$1 = r109;
        r100.L$2 = r108;
        r100.L$3 = r107;
        r100.L$4 = r106;
        r100.L$5 = r105;
        r100.L$6 = null;
        r100.L$7 = null;
        r100.L$8 = null;
        r100.label = 4;
        if (r125.C1(r124, r214, true, false, r100) != r123) goto L83;
        return r123;
    L18:
        String r126 = (String) r100.L$7;
        List<Message> r127 = (List) r100.L$6;
        List<Message> r128 = (List) r100.L$5;
        Integer r129 = (Integer) r100.L$4;
        ChatMsgDeleteScene r130 = (ChatMsgDeleteScene) r100.L$3;
        JSONObject r131 = (JSONObject) r100.L$2;
        String r132 = (String) r100.L$1;
        List<Message> r133 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
        List<Message> r134 = r127;
        r111 = r133;
        r120 = r132;
        r119 = r131;
        r118 = r129;
        r116 = r126;
    L70:
        Pair r135 = (Pair) r102;
        r106 = (List) r135.component1();
        r114 = (String) r135.component2();
        FLogger.f375446a.i("DeleteMessagesDialog", "delete msg from cvs id: " + r116 + ", origin size: " + r111.size() + ", real size: " + r128.size() + ", scene: " + r130 + ", success: " + r106 + ", errMsg: " + r114);
        if ((!r106.isEmpty()) == false) goto L79;
        r115 = r106;
        r117 = r134;
        r113 = r111.iterator();
        goto L74
    L79:
        r123 = r103;
        r105 = r114;
        r124 = r116;
        r107 = r118;
        r108 = r119;
        r109 = r120;
        r214 = r134;
        goto L80
    L19:
        Message r136 = (Message) r100.L$8;
        Iterator r137 = (Iterator) r100.L$7;
        List<Message> r138 = (List) r100.L$6;
        List<Message> r139 = (List) r100.L$5;
        Integer r140 = (Integer) r100.L$4;
        ChatMsgDeleteScene r141 = (ChatMsgDeleteScene) r100.L$3;
        JSONObject r142 = (JSONObject) r100.L$2;
        String r143 = (String) r100.L$1;
        List<Message> r144 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
        ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1 r145 = r100;
        String r146 = r143;
        Object r147 = r103;
        JSONObject r148 = r142;
    L47:
        List r149 = (List) r102;
        if (r149.isEmpty() == false) goto L50;
        r139.add(r136);
    L51:
        List<Message> r150 = r144;
        Integer r151 = r140;
        ChatMsgDeleteScene r152 = r141;
        List<Message> r153 = r138;
        List<Message> r154 = r139;
    L22:
        if (r137.hasNext() == false) goto L53;
        Message r155 = (Message) r137.next();
        if (com.larus.bmhome.chat.bean.d.v0(r155) == true) goto L22;
        String r156 = r155.getMessageId();
        boolean r157 = false;
        if (r156 != null) goto L28;
    L31:
        boolean r158 = true;
    L32:
        if (r158 == true) goto L33;
        if (com.larus.bmhome.chat.bean.d.C0(r155) == true) goto L36;
        r154.add(r155);
        goto L22
    L36:
        String r159 = r155.getReplyId();
        if (r159 != null) goto L39;
    L40:
        r157 = true;
    L41:
        if (r157 == false) goto L43;
        r154.add(r155);
        goto L22
    L43:
        RepoDispatcher.f307729a.getClass();
        ChatRepo r160 = RepoDispatcher.f307732d;
        r145.L$0 = r150;
        r145.L$1 = r146;
        r145.L$2 = r148;
        r145.L$3 = r152;
        r145.L$4 = r151;
        r145.L$5 = r154;
        r145.L$6 = r153;
        r145.L$7 = r137;
        r145.L$8 = r155;
        r145.label = 1;
        r160.getClass();
        Object r161 = ChatRepo.c(r155, r145);
        if (r161 != r147) goto L46;
        return r147;
    L46:
        Integer r215 = r151;
        r144 = r150;
        r102 = r161;
        r139 = r154;
        r141 = r152;
        r136 = r155;
        r138 = r153;
        r140 = r215;
        goto L47
    L39:
        if (StringsKt.isBlank(r159) == false) goto L41;
    L33:
        r153.add(r155);
        goto L22
    L28:
        if (r156.length() == 0) goto L31;
        r158 = false;
        goto L32
    L53:
        Iterator<T> r162 = r150.iterator();
    L55:
        if (r162.hasNext() == false) goto L59;
        Object r163 = r162.next();
        if ((!com.larus.bmhome.chat.bean.d.v0((Message) r163)) == false) goto L55;
    L60:
        Message r164 = (Message) r163;
        if (r164 == null) goto L63;
        String r165 = r164.getConversationId();
    L64:
        if (r165 != null) goto L66;
        r165 = "";
    L66:
        String r166 = r165;
        RepoDispatcher.f307729a.getClass();
        ChatRepo r167 = RepoDispatcher.f307732d;
        r145.L$0 = r150;
        r145.L$1 = r146;
        r145.L$2 = r148;
        r145.L$3 = r152;
        r145.L$4 = r151;
        r145.L$5 = r154;
        r145.L$6 = r153;
        r145.L$7 = r166;
        r145.L$8 = null;
        r145.label = 2;
        r134 = r153;
        List<Message> r168 = r154;
        Object r169 = r147;
        Object r170 = r167.C1(r166, r154, false, true, r145);
        if (r170 != r169) goto L69;
        return r169;
    L69:
        r120 = r146;
        r119 = r148;
        r130 = r152;
        r103 = r169;
        r116 = r166;
        r118 = r151;
        r100 = r145;
        r111 = r150;
        r102 = r170;
        r128 = r168;
        goto L70
    L63:
        r165 = null;
        goto L64
    L59:
        r163 = null;
        goto L60
    L50:
        r139.addAll(r149);
        goto L51
    L20:
        ResultKt.throwOnFailure(r102);
        ArrayList r171 = new ArrayList();
        r154 = r171;
        r145 = r100;
        r147 = r103;
        r153 = new ArrayList();
        r137 = r210.iterator();
        r150 = r210;
        r146 = r211;
        r148 = r212;
        r152 = r213;
        r151 = r310;
    L7:
        r100 = new ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1(r311);
        goto L8
    }

    public static final void d(FragmentManager r210, List<Message> r211, RecommendFrom r212, String r213, int r214, String r215, String r310, String r311, SearchMobParam r312, String r313, Integer r314) {
        Intrinsics.checkNotNullParameter(r210, "fm");
        Intrinsics.checkNotNullParameter(r211, "messages");
        Intrinsics.checkNotNullParameter(r215, "conversationId");
        Intrinsics.checkNotNullParameter(r310, "severIndex");
        Message r100 = (Message) CollectionsKt.last(r211);
        boolean r101 = true;
        if (r314 == null) goto L6;
        int r102 = r314.intValue();
    L10:
        if (com.larus.bmhome.chat.bean.d.b0(r100) == false) goto L16;
        String r103 = com.larus.im.bean.message.a.D(r100);
        if (r103 != null) goto L19;
        r103 = r100.getMessageId();
        if (r103 != null) goto L19;
    L18:
        r103 = "";
    L19:
        String r110 = r103;
        String r111 = r100.getSenderId();
        Intrinsics.checkNotNullParameter(r110, "entityId");
        TipOffDialogParams r104 = new TipOffDialogParams(r102, r110, null, null, "", "", 0, null, null, r111, null, null, null, null, null);
        r104.f314696c = r212;
        r104.f314697d = r213;
        r104.f314700g = r214;
        Intrinsics.checkNotNullParameter(r215, "conversationId");
        Intrinsics.checkNotNullParameter(r215, "<set-?>");
        r104.f314698e = r215;
        Intrinsics.checkNotNullParameter(r310, "serverIndex");
        Intrinsics.checkNotNullParameter(r310, "<set-?>");
        r104.f314699f = r310;
        r104.f314702i = r311;
        r104.f314701h = r312;
        Map<String, String> r105 = r100.getExt();
        if (r105 == null) goto L32;
        String r106 = r105.get("asr_log_id");
        if (r106 == null) goto L32;
        if (r106.length() <= 0) goto L26;
        boolean r107 = true;
    L27:
        if (r107 == true) goto L30;
        r106 = null;
    L30:
        if (r106 == null) goto L32;
        Map<String, String> r108 = MapsKt.mapOf(TuplesKt.to("asr_log_id", r106));
    L33:
        r104.f314708o = r108;
        r104.f314704k = r313;
        if (r211.size() <= 1) goto L42;
        ArrayList r109 = new ArrayList();
        Iterator<T> r112 = r211.iterator();
    L37:
        if (r112.hasNext() == false) goto L41;
        String r113 = ((Message) r112.next()).getMessageId();
        if (r113 == null) goto L37;
        r109.add(r113);
        goto L37
    L41:
        Intrinsics.checkNotNullParameter(r109, "batchIds");
        r104.f314706m = r109;
    L42:
        IObricChatUIService r114 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r114 != null) goto L45;
    L47:
        r101 = false;
    L48:
        if (r101 == true) goto L63;
        TipOffDialogFragment.a r115 = new TipOffDialogFragment.a();
        Intrinsics.checkNotNullParameter(r104, "builder");
        r115.f314692a = r104;
        TipOffDialogFragment r116 = r115.a();
        LandscapeRestrictionOperation r117 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r116, null, r117);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r210, r116, r117) == true) goto L64;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L55
    L53:
        r116.show(r210, null);
        return;
    L64:
        return;
    L63:
        return;
    L45:
        if (r114.a(r210, r104, r211) != true) goto L47;
    L26:
        r107 = false;
    L32:
        r108 = null;
        goto L33
    L16:
        r103 = r100.getMessageId();
        if (r103 != null) goto L19;
    L6:
        if (r211.size() <= 1) goto L8;
        r102 = 18;
        goto L10
    L8:
        r102 = 2;
        goto L10
    }
}
