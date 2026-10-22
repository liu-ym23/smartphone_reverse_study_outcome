package com.larus.bmhome.chat.component.list.pipeline.pre_dependent;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.internal.protocol.model.BotLoadingConfig;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f301201a;

    public static final class a {
    }

    static {
    }

    public c(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f301201a = r100;
    }

    public final Message c(List<? extends xc8.b> r100) {
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L38;
        Object r102 = r101.next();
        xc8.b r103 = (xc8.b) r102;
        Message r104 = r103.getMessage();
        boolean r105 = true;
        if (com.larus.bmhome.chat.bean.d.i0(r104) == false) goto L11;
        if (com.larus.bmhome.chat.bean.d.w(r104) == true) goto L11;
    L30:
        boolean r106 = false;
    L31:
        if (r106 == true) goto L33;
    L35:
        r105 = false;
    L36:
        if (r105 == false) goto L4;
    L39:
        xc8.b r107 = (xc8.b) r102;
        if (r107 != null) goto L42;
        return null;
    L42:
        return r107.getMessage();
    L33:
        if (b0.f(r103.getMessage()) == true) goto L35;
    L11:
        if (com.larus.bmhome.chat.bean.d.T(r104) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.p0(r104) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.C0(r104) == true) goto L18;
    L20:
        MessageStatus r108 = r104.getMessageStatus();
        if (r108 != null) goto L23;
    L25:
        boolean r109 = false;
    L26:
        if (r109 == false) goto L28;
    L29:
        r106 = true;
        goto L31
    L28:
        if (b0.f(r104) == false) goto L30;
    L23:
        if (r108.isVisible() != true) goto L25;
        r109 = true;
        goto L26
    L18:
        if (r104.getRegenVisible() == true) goto L20;
    L38:
        r102 = null;
        goto L39
    }

    @Override // td8.c
    public final boolean a(int r110, xc8.b r111, xc8.b r112, List<? extends xc8.b> r113) {
        Intrinsics.checkNotNullParameter(r112, "current");
        Intrinsics.checkNotNullParameter(r113, "input");
        BotModel r114 = this.f301201a.a();
        String r115 = null;
        if (r114 == null) goto L7;
        BotLoadingConfig r116 = r114.getLoadingConf();
        if (r116 == null) goto L7;
        Boolean r117 = r116.getDisableFakeLoading();
    L9:
        if (Intrinsics.areEqual(r117, Boolean.TRUE) == false) goto L12;
        FLogger.f375446a.i("Pipeline_List_Loading", "loading no show because of disableFakeLoading");
        return false;
    L12:
        Message r118 = c(r113);
        if (r118 != null) goto L17;
        FLogger.f375446a.i("Pipeline_List_Loading", "loading no show because of latestVisibleMessage is null");
        return false;
    L17:
        if (com.larus.bmhome.chat.bean.d.m0(r118) == false) goto L20;
        FLogger.f375446a.i("Pipeline_List_Loading", "loading no show because of latestVisibleMessage is illegal asr loading");
        return false;
    L20:
        Map<String, String> r100 = r118.getExt();
        if (r100 == null) goto L23;
        String r101 = r100.get("fork_from_conversation_id");
    L25:
        if (r101 != null) goto L27;
    L30:
        boolean r102 = true;
    L31:
        if (r102 == true) goto L41;
        Map<String, String> r103 = r118.getExt();
        if (r103 != null) goto L35;
    L37:
        boolean r104 = false;
    L38:
        if (r104 == true) goto L41;
        FLogger.f375446a.d("Pipeline_List_Loading", "loading no show because of latestVisibleMessage is copied fork anchor");
        return false;
    L35:
        if (r103.containsKey("modified_from") != true) goto L37;
        r104 = true;
    L41:
        FLogger r105 = FLogger.f375446a;
        r105.i("Pipeline_List_Loading", "latestVisibleMessage is >>> messageId is " + r118.getMessageId() + ", localId is " + r118.getLocalMessageId() + ", contentType is " + r118.getContentType());
        if (com.larus.bmhome.chat.bean.d.C0(r118) == true) goto L55;
        if (this.f301201a.q() == true) goto L55;
        long r106 = this.f301201a.i();
        long r107 = r118.getServerIndex();
        if (1 <= r107) goto L48;
    L50:
        boolean r108 = false;
    L51:
        if (r108 == false) goto L55;
        r105.i("Pipeline_List_Loading", "loading no show because of condition one.isRegen is " + com.larus.bmhome.chat.bean.d.C0(r118) + ", isWaitRegenAnswer is " + this.f301201a.q() + ", isCrowdTestMessage is " + com.larus.bmhome.chat.bean.d.b0(r118) + ", serverIndex is " + r118.getServerIndex() + ", readMessageIndex is " + this.f301201a.i());
        return false;
    L48:
        if (r107 >= r106) goto L50;
        r108 = true;
    L55:
        if (com.larus.bmhome.chat.bean.d.G0(r118) == false) goto L171;
        StringBuilder r109 = new StringBuilder("latestVisibleMessage.messageStatusLocal: ");
        r109.append(r118.getMessageStatusLocal());
        r109.append(", latestVisibleMessage.needTriggerLoading(): ");
        r109.append(b0.i(r118));
        r109.append(", empty_response: ");
        Map<String, String> r119 = r118.getExt();
        if (r119 == null) goto L59;
        String r120 = r119.get("empty_response");
    L60:
        r109.append(r120);
        r109.append(", loading value: ");
        Map<String, String> r121 = r118.getBusinessExt();
        if (r121 == null) goto L63;
        String r122 = r121.get("send_loading");
    L64:
        r109.append(r122);
        r109.append(", latestVisibleMessage.showLoading: ");
        r109.append(com.larus.bmhome.chat.bean.d.M(r118));
        r105.i("Pipeline_List_Loading", r109.toString());
        if (r118.getMessageStatusLocal() == 12) goto L143;
        if (r118.getMessageStatusLocal() == 13) goto L143;
        if (r118.getMessageStatusLocal() == 14) goto L143;
        if (b0.i(r118) == false) goto L143;
        Map<String, String> r123 = r118.getExt();
        if (r123 == null) goto L82;
        String r124 = r123.get("empty_response");
        if (r124 == null) goto L82;
        Integer r125 = StringsKt.toIntOrNull(r124);
        if (r125 == null) goto L82;
        if (r125.intValue() != 1) goto L82;
        boolean r126 = true;
    L83:
        if (r126 == true) goto L143;
        if (ObricFeatureServiceDelegate.f387839b.a() == false) goto L140;
        String r127 = com.larus.im.bean.message.a.g(r118);
        if (r127 == null) goto L136;
        ArrayList r128 = new ArrayList();
        Iterator<T> r129 = r113.iterator();
    L91:
        if (r129.hasNext() == false) goto L96;
        Object r130 = r129.next();
        if (Intrinsics.areEqual(com.larus.im.bean.message.a.g(((xc8.b) r130).getMessage()), r127) == false) goto L91;
        r128.add(r130);
        goto L91
    L96:
        if (r128.isEmpty() == true) goto L136;
        Iterator r131 = r128.iterator();
    L100:
        if (r131.hasNext() == false) goto L136;
        xc8.b r132 = (xc8.b) r131.next();
        Map<String, String> r133 = r132.getMessage().getBusinessExt();
        if (r133 == null) goto L104;
        String r134 = r133.get("send_loading");
    L106:
        if (Intrinsics.areEqual(r134, "0") == true) goto L133;
        List<UplinkFileEntity> r135 = com.larus.bmhome.chat.bean.d.f(r132.getMessage()).getEntities();
        if (r135 == null) goto L129;
        List<UplinkFileEntity> r136 = r135;
        if ((r136 instanceof Collection) == true) goto L112;
    L114:
        Iterator<T> r137 = r136.iterator();
    L116:
        if (r137.hasNext() == false) goto L126;
        Integer r138 = ((UplinkFileEntity) r137.next()).getUpLinkStatus();
        int r139 = UpLinkState.FAIL.getValue();
        if (r138 != null) goto L121;
    L123:
        boolean r140 = false;
    L124:
        if (r140 == false) goto L116;
        boolean r141 = true;
    L127:
        if (r141 != true) goto L129;
        boolean r142 = true;
    L130:
        if (r142 == true) goto L133;
        boolean r143 = false;
    L134:
        if (r143 == false) goto L100;
        boolean r144 = true;
    L137:
        if (r144 == false) goto L140;
        FLogger.f375446a.i("Pipeline_List_Loading", "loading no show because of latestVisibleMessage is self and belong to batch upload file failed");
        return false;
    L121:
        if (r138.intValue() != r139) goto L123;
        r140 = true;
    L126:
        r141 = false;
        goto L127
    L112:
        if (r136.isEmpty() == false) goto L114;
    L129:
        r142 = false;
    L133:
        r143 = true;
        goto L134
    L104:
        r134 = null;
    L136:
        r144 = false;
    L140:
        FLogger.f375446a.i("Pipeline_List_Loading", "loading show because of latestVisibleMessage is self and ext get empty_response != 1");
        return true;
    L82:
        r126 = false;
    L143:
        if (r118.getMessageStatusLocal() == 12) goto L159;
        if (r118.getMessageStatusLocal() == 13) goto L159;
        if (r118.getMessageStatusLocal() == 14) goto L159;
        Map<String, String> r145 = r118.getBusinessExt();
        if (r145 == null) goto L151;
        String r146 = r145.get("send_loading");
    L153:
        if (Intrinsics.areEqual(r146, "0") == true) goto L159;
        if (com.larus.bmhome.chat.bean.d.M(r118) == false) goto L159;
        r105.i("Pipeline_List_Loading", "loading show because of latestVisibleMessage is self and latestVisibleMessage showLoading");
        return true;
    L151:
        r146 = null;
    L159:
        if (AppHost.f326268a.isTestChannel() == false) goto L208;
        StringBuilder r147 = new StringBuilder("loading  show  condition skip because of SKIP1: latestVisibleMessage.messageStatusLocal:");
        r147.append(r118.getMessageStatusLocal());
        r147.append("latestVisibleMessage.messageStatusLocal:");
        r147.append(r118.getMessageStatusLocal());
        r147.append("latestVisibleMessage.businessExt?.get(TRIGGER_SEND_LOADING_KEY)");
        Map<String, String> r148 = r118.getBusinessExt();
        if (r148 == null) goto L163;
        String r149 = r148.get("send_loading");
    L164:
        r147.append(r149);
        r147.append("latestVisibleMessage.showLoading:");
        r147.append(com.larus.bmhome.chat.bean.d.M(r118));
        r147.append("latestVisibleMessage.needTriggerLoading():");
        r147.append(b0.i(r118));
        r147.append("latestVisibleMessage.ext?.get(empty_response)?.toIntOrNull():");
        Map<String, String> r150 = r118.getExt();
        if (r150 == null) goto L169;
        String r151 = r150.get("empty_response");
        if (r151 == null) goto L169;
        r115 = StringsKt.toIntOrNull(r151);
    L169:
        r147.append(r115);
        r105.d("Pipeline_List_Loading", r147.toString());
        goto L208
    L163:
        r149 = null;
    L208:
        r105.i("Pipeline_List_Loading", "loading no show because of default");
        return false;
    L63:
        r122 = null;
        goto L64
    L59:
        r120 = null;
        goto L60
    L171:
        if (com.larus.bmhome.chat.bean.d.o0(r118) == true) goto L175;
        if (com.larus.im.bean.message.a.E(r118) == true) goto L175;
    L178:
        Intrinsics.checkNotNullParameter(r118, "<this>");
        if (r118.getContentType() == 60) goto L181;
    L183:
        boolean r152 = false;
    L184:
        if (r152 == true) goto L186;
    L193:
        Map<String, String> r153 = r118.getBusinessExt();
        if (r153 == null) goto L196;
        String r154 = r153.get("send_loading");
    L198:
        if (Intrinsics.areEqual(r154, "2") == false) goto L201;
        r105.i("Pipeline_List_Loading", "loading show because of businessExt[TRIGGER_SEND_LOADING_KEY] is BOT_SAY_LOADING");
        return true;
    L201:
        Map<String, String> r155 = r118.getBusinessExt();
        if (r155 == null) goto L205;
        r115 = r155.get("send_loading");
    L205:
        if (Intrinsics.areEqual(r115, "5") == false) goto L208;
        r105.i("Pipeline_List_Loading", "loading show because of businessExt[TRIGGER_SEND_LOADING_KEY] is SEND_HIDDEN_MSG_LOADING");
        return true;
    L196:
        r154 = null;
        goto L198
    L186:
        if (r118.getMessageStatusLocal() == 22) goto L193;
        if (r118.getMessageStatusLocal() == 23) goto L193;
        if (IAIChatService.f365899a.V7() == false) goto L193;
        r105.i("Pipeline_List_Loading", "loading show because of latestVisibleMessage is ExpertType");
        return true;
    L181:
        if (r118.getUserType() != 2) goto L183;
        r152 = true;
    L175:
        if (b0.i(r118) == false) goto L178;
        r105.i("Pipeline_List_Loading", "loading show because of latestVisibleMessage is Image4Type");
        return true;
    L27:
        if (StringsKt.isBlank(r101) == true) goto L30;
        r102 = false;
        goto L31
    L23:
        r101 = null;
    L7:
        r117 = null;
        goto L9
    }

    @Override // td8.c
    public final List<xc8.b> b(int r510, xc8.b r511, xc8.b r512, List<xc8.b> r513) {
        Intrinsics.checkNotNullParameter(r512, "current");
        Intrinsics.checkNotNullParameter(r513, "input");
        FLogger r100 = FLogger.f375446a;
        r100.i("Pipeline_List_Loading", "start AddLoadingTask, current input size is " + r513.size());
        Message r101 = c(r513);
        if (r101 == null) goto L47;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (com.larus.bmhome.chat.bean.d.M(r101) == false) goto L7;
        String r102 = "1";
    L12:
        String r110 = null;
        Message r111 = null;
        if (Intrinsics.areEqual(r102, "0") == false) goto L15;
        r100.i("Pipeline_List_Loading", "loading no show because of triggerLoadingType is NO_LOADING");
        int r103 = 0;
    L45:
        if (r111 == null) goto L47;
        r100.i("Pipeline_List_Loading", "loading added, loading message >>>> contentType is " + r111.getContentType() + ", content is " + g2a.d.b(r111.getContent()));
        ListProtector.add(r513, r103, xc8.f.f(r111));
        goto L47
    L15:
        Map<String, String> r104 = r101.getBusinessExt();
        if (r104 == null) goto L19;
        String r105 = r104.get("loading_reply_id");
        if (r105 == null) goto L19;
    L20:
        String r310 = r105;
        int r106 = r102.hashCode();
        if (r106 != 49) goto L23;
        r102.equals("1");
    L36:
        int r410 = 0;
    L37:
        MessageStatus r514 = MessageStatus.MessageStatus_AVAILABLE;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Map<String, String> r107 = r101.getBusinessExt();
        if (r107 == null) goto L41;
        r110 = r107.get("waiting_error");
    L41:
        if (Intrinsics.areEqual(r110, "true") == false) goto L43;
        int r108 = 22;
    L44:
        r103 = 0;
        r111 = b0.j(Message.copy$default(r101, null, null, "", 0, r108, r514, r410, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_mock_receiving", "1"), TuplesKt.to(Constants.KEY_ERROR_CODE, "-1"), TuplesKt.to(LocationMonitorConst.ERR_MSG, "first pkg timeout err"), TuplesKt.to("key_is_business_error", "0")}), null, null, 0, false, 0, r310, null, false, null, null, 0, null, null, null, -272629877, 31, null), 0);
        goto L45
    L43:
        r108 = 0;
        goto L44
    L23:
        if (r106 == 51) goto L32;
        if (r106 != 52) goto L36;
        if (r102.equals("4") == false) goto L36;
        r410 = 3;
        goto L37
    L32:
        if (r102.equals("3") == false) goto L36;
        r410 = 6;
    L19:
        r105 = r101.getLocalMessageId();
        goto L20
    L7:
        Map<String, String> r109 = r101.getBusinessExt();
        if (r109 == null) goto L11;
        r102 = r109.get("send_loading");
        if (r102 != null) goto L12;
    L11:
        r102 = "0";
    L47:
        r100.i("Pipeline_List_Loading", "end AddLoadingTask, current input size is " + r513.size());
        return r513;
    }
}
