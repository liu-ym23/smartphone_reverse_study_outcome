package com.larus.bmhome.chat.service.action;

import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.chat.api.ConversationFeedActionType;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.o0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.v2;

/* JADX INFO: loaded from: classes25.dex */
public abstract class k0 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f308776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f308777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConversationFeedActionType f308778c;

    @Override // com.larus.bmhome.chat.service.action.b
    public final void a(wh8.a r210) {
        Intrinsics.checkNotNullParameter(r210, "data");
        a r100 = this.f308776a;
        com.larus.bmhome.chat.api.i r101 = r100.f308733a;
        ConversationModel r102 = r100.f308734b;
        BotModel r103 = r210.f559709b;
        if (r103 == null) goto L6;
        String r104 = r103.getBotId();
        if (r104 == null) goto L6;
    L7:
        r102.changePinStatusConversation(r104, r210.f559708a, this.f308777b);
        wc9.e r105 = r210.f559708a;
        if (ic8.n.w(r105) == false) goto L11;
        boolean r106 = this.f308777b;
        JSONObject r107 = new JSONObject();
        r107.put("cell_type", "doubao_pc_history");
        Unit r108 = Unit.INSTANCE;
        v2.c(r106, r107);
    L109:
        Function2<ConversationFeedActionType, wh8.a, Unit> r109 = r101.f297217j;
        if (r109 == null) goto L112;
        r109.invoke(this.f308778c, r210);
    L112:
        Function0<Unit> r110 = r101.f297216i;
        if (r110 == null) goto L116;
        r110.invoke();
        return;
    L116:
        return;
    L11:
        if (AudioServiceDelegate.f288288a.getAudioConfig().n(r210.f559709b) == false) goto L13;
        String r111 = "1";
    L15:
        if (this.f308777b == false) goto L62;
        BotModel r112 = r210.f559709b;
        if (r112 == null) goto L19;
        String r113 = r112.getBotId();
    L20:
        if (r113 != null) goto L22;
        r113 = "";
    L22:
        BotModel r114 = r210.f559709b;
        if (r114 == null) goto L25;
        String r115 = r114.getBgImgUrl();
    L27:
        if (o0.d(r115) == false) goto L29;
        String r116 = "1";
    L30:
        String r117 = r101.f297211d;
        String r118 = r101.f297210c;
        if (r105 == null) goto L33;
        String r211 = r105.f559198a;
    L34:
        by7.e r119 = r101.f297209b;
        String r120 = "1";
        ChatControlTrace r121 = ChatControlTrace.f309996b;
        if (r105 == null) goto L37;
        Integer r122 = r105.f559219v;
    L38:
        String r123 = r121.g(r122, c.b(r210), c.a(r210));
        Function1<wh8.a, String> r124 = r101.f297215h;
        if (r124 == null) goto L41;
        String r125 = r124.invoke(r210);
    L42:
        String r126 = r210.f559712e;
        if (r101.f297212e == true) goto L46;
        r120 = "0";
    L46:
        Integer r212 = c.b(r210);
        JSONObject r127 = new JSONObject();
        r127.put("object_type", "chat");
        if (r105 == null) goto L60;
        String r128 = r105.I;
        if (r128 == null) goto L60;
        if (r128.length() <= 0) goto L53;
        boolean r129 = true;
    L54:
        if (r129 == false) goto L56;
        String r130 = r128;
    L57:
        if (r130 == null) goto L60;
        String r131 = r130;
    L61:
        r127.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r131);
        v2.a(r113, r117, r118, r123, r116, r127, r119, r125, r111, r126, r120, r212, r211);
        goto L109
    L56:
        r130 = null;
        goto L57
    L53:
        r129 = false;
    L60:
        r131 = "-";
        goto L61
    L41:
        r125 = null;
        goto L42
    L37:
        r122 = null;
        goto L38
    L33:
        r211 = null;
        goto L34
    L29:
        r116 = "0";
        goto L30
    L25:
        r115 = null;
        goto L27
    L19:
        r113 = null;
        goto L20
    L62:
        String r132 = "1";
        BotModel r133 = r210.f559709b;
        if (r133 == null) goto L65;
        String r134 = r133.getBotId();
    L66:
        if (r134 != null) goto L68;
        String r135 = "";
    L69:
        BotModel r136 = r210.f559709b;
        if (r136 == null) goto L72;
        String r137 = r136.getBgImgUrl();
    L74:
        if (o0.d(r137) == false) goto L76;
        String r138 = r132;
    L77:
        ChatControlTrace r139 = ChatControlTrace.f309996b;
        if (r105 == null) goto L80;
        Integer r140 = r105.f559219v;
    L81:
        String r141 = r139.g(r140, c.b(r210), c.a(r210));
        String r142 = r101.f297211d;
        String r143 = r101.f297210c;
        if (r105 == null) goto L84;
        String r213 = r105.f559198a;
    L85:
        by7.e r144 = r101.f297209b;
        Function1<wh8.a, String> r145 = r101.f297215h;
        if (r145 == null) goto L88;
        String r146 = r145.invoke(r210);
    L89:
        String r147 = r210.f559712e;
        if (r101.f297212e == true) goto L93;
        r132 = "0";
    L93:
        Integer r148 = c.b(r210);
        JSONObject r149 = new JSONObject();
        r149.put("object_type", "chat");
        if (r105 == null) goto L107;
        String r150 = r105.I;
        if (r150 == null) goto L107;
        if (r150.length() <= 0) goto L100;
        boolean r151 = true;
    L101:
        if (r151 == false) goto L103;
        String r152 = r150;
    L104:
        if (r152 == null) goto L107;
        String r153 = r152;
    L108:
        r149.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r153);
        v2.d(r135, r142, r143, r141, r138, r149, r144, r111, r146, r147, r132, r148, r213);
        goto L109
    L103:
        r152 = null;
        goto L104
    L100:
        r151 = false;
    L107:
        r153 = "-";
        goto L108
    L88:
        r146 = null;
        goto L89
    L84:
        r213 = null;
        goto L85
    L80:
        r140 = null;
        goto L81
    L76:
        r138 = "0";
        goto L77
    L72:
        r137 = null;
        goto L74
    L68:
        r135 = r134;
        goto L69
    L65:
        r134 = null;
        goto L66
    L13:
        r111 = "0";
    L6:
        r104 = "";
        goto L7
    }

    public k0(a r100, boolean r101, ConversationFeedActionType r102) {
        Intrinsics.checkNotNullParameter(r100, "executeContext");
        Intrinsics.checkNotNullParameter(r102, ReportConstant.COMMON_ACTION_TYPE);
        this.f308776a = r100;
        this.f308777b = r101;
        this.f308778c = r102;
    }
}
