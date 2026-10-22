package com.larus.voicecall.impl.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.ChatServiceImpl;
import com.larus.im.bean.bot.BotModel;
import com.larus.nova.NovaApplication;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.utils.RealtimeMobUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.Serializable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class r implements q97.a {

    public static final class a {
    }

    static {
    }

    public r() {
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("Router matchInterceptRules -> ");
        Uri r103 = null;
        if (r100 == null) goto L7;
        Uri r104 = r100.f267530d;
        if (r104 == null) goto L7;
        String r105 = r104.getAuthority();
    L8:
        r102.append(r105);
        r101.d("RealtimeCallGateInterceptor", r102.toString());
        int r106 = com.larus.utils.k0.f375428a;
        if (r100 == null) goto L12;
        r103 = r100.f267530d;
    L12:
        return Intrinsics.areEqual(com.larus.utils.k0.a(String.valueOf(r103)), "//flow/realtime_chat");
    L7:
        r105 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // q97.a
    public final boolean a(Context r210, com.bytedance.router.c r211) {
        FLogger.f375446a.i("RealtimeCallGateInterceptor", "onInterceptRoute");
        if (r211 == null) goto L8;
        Intent r100 = r211.f267528b;
        if (r100 == null) goto L8;
        r100.putExtra("open_timestamp", SystemClock.elapsedRealtime());
    L8:
        if (z2.f365865a.enableMuseumExtensionPack() == false) goto L36;
        if (r211 == null) goto L36;
        Intent r101 = r211.f267528b;
        if (r101 == null) goto L16;
        String r102 = r101.getStringExtra("session_extra");
        if (r102 == null) goto L16;
    L248:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L24
        Object r104 = Result.m9449constructorimpl(Boolean.valueOf(Intrinsics.areEqual(new JSONObject(r102).optString("app_scene"), "museum")));     // Catch: Throwable -> L24
    L26:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r104) == false) goto L30;
        r104 = r105;
    L30:
        if (((Boolean) r104).booleanValue() == false) goto L36;
        Intent r106 = r211.f267528b;
        if (r106 == null) goto L35;
        r106.putExtra("without_chat", "0");
    L35:
        FLogger.f375446a.i("RealtimeCallGateInterceptor", "[forceBackToChatIfMuseumMode] force backToChat for museum realtime call");
    L24:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L16:
        Uri r108 = r211.f267530d;
        if (r108 == null) goto L19;
        r102 = UriProtector.getQueryParameter(r108, "session_extra");
    L20:
        if (r102 != null) goto L248;
    L19:
        r102 = null;
    L36:
        if (r211 == null) goto L40;
        Intent r109 = r211.f267528b;
        if (r109 == null) goto L40;
        Bundle r110 = r109.getExtras();
    L42:
        if (r110 == null) goto L45;
        String r111 = r110.getString("conversation_id");
        if (r111 == null) goto L45;
    L47:
        if (r110 == null) goto L50;
        String r112 = r110.getString("bot_id");
        if (r112 == null) goto L50;
    L51:
        boolean r113 = false;
        if (z2.f365865a.disableMoaStartCall() == false) goto L68;
        IFlowSdkDepend r114 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r114 == null) goto L61;
        r114.P();
        Fragment r115 = ChatServiceImpl.f346124a.f();
        if (r115 == null) goto L61;
        t1a.b r116 = s1a.a.g(r115);
        if (r116 == null) goto L61;
        com.larus.bmhome.instruction.g r117 = (com.larus.bmhome.instruction.g) r116.getAbility(com.larus.bmhome.instruction.g.class);
    L62:
        if (r117 != null) goto L64;
    L66:
        boolean r118 = false;
    L67:
        if (r118 == false) goto L68;
        t19.s r119 = t19.s.f544207a;
        gd9.i r120 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r120);
        NovaApplication r121 = r120.getApplication();
        if (AppHost.f326268a.isOversea() == false) goto L72;
        int r122 = R.string.larus_moa_call_disabled;
    L73:
        r119.getClass();
        t19.s.s(r121, r122);
        FLogger r123 = FLogger.f375446a;
        StringBuilder r124 = new StringBuilder("block realtime call in task mode, conversationId=");
        r124.append(r111);
        r124.append(", botId=");
        r124.append(r112);
        r124.append(", passGate=");
        if (r211 == null) goto L78;
        Intent r125 = r211.f267528b;
        if (r125 == null) goto L78;
        String r126 = r125.getStringExtra("pass_gate");
    L79:
        r124.append(r126);
        r124.append(", originUrl=");
        if (r211 == null) goto L82;
        String r127 = r211.f267527a;
    L83:
        r124.append(r127);
        r123.e("RealtimeCallGateInterceptor", r124.toString());
        boolean r128 = true;
    L84:
        if (r128 == false) goto L86;
        return true;
    L86:
        if (r110 == null) goto L88;
        String r129 = r110.getString("pass_gate");
    L90:
        if (Intrinsics.areEqual(r129, "1") == true) goto L141;
        FLogger r130 = FLogger.f375446a;
        r130.i("RealtimeCallGateInterceptor", "[onInterceptRoute] pass_gate=" + r129);
        if (r211 == null) goto L94;
        r211.b("//flow/realtime_chat_gate");
    L94:
        if (r110 != null) goto L96;
    L98:
        boolean r131 = false;
    L99:
        if (r131 == true) goto L141;
        StringBuilder r132 = new StringBuilder("[onInterceptRoute] send mob router start event, origin_url=");
        if (r211 == null) goto L103;
        String r133 = r211.f267527a;
    L104:
        r132.append(r133);
        r130.i("RealtimeCallGateInterceptor", r132.toString());
        if (r211 == null) goto L109;
        Intent r134 = r211.f267528b;
        if (r134 == null) goto L109;
        r134.putExtra("origin_url", r211.f267527a);
    L109:
        if (r211 == null) goto L113;
        Intent r135 = r211.f267528b;
        if (r135 == null) goto L113;
        r135.putExtra("slardar_router_event_mob_start", 1);
    L113:
        int r136 = RealtimeMobUtil.f379512a;
        if (r211 == null) goto L116;
        String r137 = r211.f267527a;
    L117:
        if (r211 == null) goto L121;
        Intent r138 = r211.f267528b;
        if (r138 == null) goto L121;
        String r139 = r138.getStringExtra("enter_method");
    L122:
        if (r211 == null) goto L126;
        Intent r140 = r211.f267528b;
        if (r140 == null) goto L126;
        String r141 = r140.getStringExtra("bot_id");
    L127:
        if (r211 == null) goto L131;
        Intent r142 = r211.f267528b;
        if (r142 == null) goto L131;
        String r143 = r142.getStringExtra("track_params");
    L132:
        RealtimeMobUtil.b(r137, r139, r141, r143);
        if (r211 == null) goto L141;
        Intent r144 = r211.f267528b;
        if (r144 == null) goto L137;
        String r145 = r144.getStringExtra("avatar_url");
    L139:
        if (TextUtils.isEmpty(r145) == true) goto L141;
        Integer r146 = null;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new RealtimeCallGateInterceptor$tryPreloadRealtimeCallImageToMemory$1$1(r145, r211, null), 2, null);
    L142:
        if (r211 == null) goto L148;
        Intent r147 = r211.f267528b;
        if (r147 == null) goto L148;
        Bundle r148 = r147.getExtras();
        if (r148 == null) goto L148;
        Integer r149 = Integer.valueOf(r148.getInt("bot_type", com.larus.bmhome.utils.i.g(r111) ? 1 : 0));
    L150:
        if (RealtimeCallHelperKt.b(r149) == false) goto L174;
        FLogger.f375446a.i("RealtimeCallGateInterceptor", "[onInterceptRoute] realtime call downgrade");
        t19.s.f544207a.g(r210, R.string.larus_voice_call_downgrade_error, false);
        if (r211 == null) goto L158;
        Intent r150 = r211.f267528b;
        if (r150 == null) goto L158;
        if (r150.getIntExtra("slardar_router_event_mob_start", 0) != 1) goto L158;
        r113 = true;
    L158:
        if (r113 == false) goto L250;
        int r151 = RealtimeMobUtil.f379512a;
        String r152 = r211.f267527a;
        Intent r153 = r211.f267528b;
        if (r153 == null) goto L162;
        String r154 = r153.getStringExtra("enter_method");
    L163:
        Intent r155 = r211.f267528b;
        if (r155 == null) goto L166;
        String r156 = r155.getStringExtra("bot_id");
    L167:
        Intent r157 = r211.f267528b;
        if (r157 == null) goto L170;
        String r212 = r157.getStringExtra("track_params");
    L171:
        RealtimeMobUtil.a(r152, r154, r156, r212, false, "voice_call_downgrade_error");
        return true;
    L170:
        r212 = r146;
        goto L171
    L166:
        r156 = r146;
        goto L167
    L162:
        r154 = r146;
        goto L163
    L250:
        return true;
    L174:
        if (r110 == null) goto L179;
        String r158 = r110.getString("open_vlm");
        if (r158 == null) goto L179;
        String r213 = r158;
    L180:
        if (r110 == null) goto L182;
        Serializable r159 = r110.getSerializable("bot_model");
    L184:
        if ((r159 instanceof BotModel) == false) goto L186;
        BotModel r160 = (BotModel) r159;
    L188:
        if (com.larus.voicecall.impl.utils.f.b(r111, r112, r160) == false) goto L247;
        if (r211 == null) goto L193;
        Intent r161 = r211.f267528b;
        if (r161 == null) goto L193;
        r161.putExtra("need_start_continue_talk", true);
    L193:
        IFlowSdkDepend r162 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r162 == null) goto L243;
        r162.P();
        Fragment r163 = ChatServiceImpl.f346124a.f();
        if (r163 == null) goto L243;
        t1a.b r164 = s1a.a.g(r163);
        com.larus.bmhome.chat.component.cvs.y r165 = (com.larus.bmhome.chat.component.cvs.y) r164.o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.cvs.y.class));
        if (r165 == null) goto L200;
        String r166 = r165.Y1();
    L201:
        if (r165 == null) goto L203;
        String r167 = r165.getBotId();
    L205:
        if ((!StringsKt.isBlank(r111)) == true) goto L207;
    L209:
        boolean r168 = false;
    L211:
        if ((!StringsKt.isBlank(r112)) == true) goto L213;
    L215:
        boolean r169 = false;
    L216:
        if (r169 == false) goto L221;
        if (r168 == true) goto L221;
        if ((!StringsKt.isBlank(r111)) == false) goto L221;
        FLogger.f375446a.i("RealtimeCallGateInterceptor", "judgeCurrentChat, isBotIdEnable=" + r169 + ", isConvIdEnable=" + r168 + ", tarConversationId=" + r111 + ", conv?.conversationId=" + r166 + ", botId=" + r167 + ", tarBotId=" + r112);
    L244:
        boolean r170 = true;
        r113 = true;
    L246:
        return r170 ^ r113;
    L221:
        if (r168 == true) goto L223;
        if (r169 == false) goto L244;
    L223:
        if (r211 == null) goto L227;
        Intent r171 = r211.f267528b;
        if (r171 == null) goto L227;
        String r172 = r171.getStringExtra("call_id");
    L229:
        if (r211 == null) goto L233;
        Intent r173 = r211.f267528b;
        if (r173 == null) goto L233;
        String r174 = r173.getStringExtra("enter_method");
    L234:
        if (r211 == null) goto L238;
        Intent r175 = r211.f267528b;
        if (r175 == null) goto L238;
        Bundle r214 = r175.getExtras();
    L239:
        xa8.e r176 = new xa8.e(r174, r172, r213, r214, false, 16);
        xa8.b r177 = (xa8.b) r164.o(Reflection.getOrCreateKotlinClass(xa8.b.class));
        if (r177 == null) goto L242;
        r177.ai(r176);
    L242:
        r170 = true;
    L238:
        r214 = r146;
    L233:
        r174 = r146;
    L227:
        r172 = r146;
        goto L229
    L213:
        if (Intrinsics.areEqual(r167, r112) == false) goto L215;
        r169 = true;
        goto L216
    L207:
        if (Intrinsics.areEqual(r166, r111) == false) goto L209;
        r168 = true;
        goto L211
    L203:
        r167 = r146;
        goto L205
    L200:
        r166 = r146;
    L243:
        FLogger.f375446a.i("RealtimeCallGateInterceptor", "judgeCurrentChat, currentChrChatFragment is null");
        goto L244
    L247:
        return false;
    L186:
        r160 = r146;
        goto L188
    L182:
        r159 = r146;
    L179:
        r213 = "";
    L148:
        r149 = r146;
        goto L150
    L137:
        r145 = null;
    L131:
        r143 = null;
    L126:
        r141 = null;
    L121:
        r139 = null;
        goto L122
    L116:
        r137 = null;
        goto L117
    L103:
        r133 = null;
        goto L104
    L96:
        if (r110.getInt("from_check_gate", 0) != 1) goto L98;
        r131 = true;
    L141:
        r146 = null;
        goto L142
    L88:
        r129 = null;
        goto L90
    L82:
        r127 = null;
    L78:
        r126 = null;
        goto L79
    L72:
        r122 = R.string.larus_moa_call_disabled2_cn;
        goto L73
    L64:
        if (r117.yW() != true) goto L66;
        r118 = true;
    L61:
        r117 = null;
    L68:
        r128 = false;
    L50:
        r112 = "";
    L45:
        r111 = "";
    L40:
        r110 = null;
        goto L42
    }
}
