package com.larus.drive.sdk.impl.service;

import android.content.Context;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class DriveLocalConversationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DriveLocalConversationHelper f341930a = null;

    static {
        f341930a = new DriveLocalConversationHelper();
    }

    public DriveLocalConversationHelper() {
    }

    public static /* synthetic */ Object b(Context r100, Integer r101, Continuation r102) {
        return f341930a.a(r100, r101, null, r102);
    }

    public final Object a(Context r210, Integer r211, String r212, Continuation<? super wc9.e> r213) {
        if ((r213 instanceof DriveLocalConversationHelper$createLocalSubConversation$1) == false) goto L7;
        DriveLocalConversationHelper$createLocalSubConversation$1 r100 = (DriveLocalConversationHelper$createLocalSubConversation$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = "";
        String r110 = null;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 == 2) goto L18;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L16;
        BotModel r106 = (BotModel) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L71:
        wc9.e r107 = (wc9.e) r102;
        if (r107 == null) goto L74;
        r110 = r107.f559198a;
    L74:
        if (r110 == null) goto L78;
        r105 = r110;
    L78:
        if ((!StringsKt.isBlank(r105)) == false) goto L85;
        BotInfoCache.INSTANCE.put(r105, r106);
        LocalSubConvHelper r108 = LocalSubConvHelper.f314106a;
        BotOnBoarding r109 = r106.getOnBoarding();
        if (r109 == null) goto L83;
        List<Message> r111 = r109.getMessageList();
        if (r111 == null) goto L83;
    L84:
        LocalSubConvHelper.j(r105, r111, true);
    L83:
        r111 = CollectionsKt.emptyList();
    L85:
        return r107;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r112 = (String) r100.L$2;
        Integer r113 = (Integer) r100.L$1;
        Context r114 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
        Integer r115 = r113;
    L45:
        BotModel r116 = (BotModel) r102;
        if (r116 != null) goto L48;
        return null;
    L48:
        r100.L$0 = r116;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 4;
        kotlinx.coroutines.j r117 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r117.C();
        if (AccountService.f365697a.isEnterpriseAccount() == false) goto L51;
        int r118 = R.string.larus_new_task_cn;
    L52:
        Pair[] r119 = new Pair[1];
        if (r114 == null) goto L56;
        String r120 = r114.getString(r118);
        if (r120 == null) goto L56;
    L57:
        r119[0] = TuplesKt.to("conv_name", r120);
        Map r121 = MapsKt.mutableMapOf(r119);
        if (r112 != null) goto L60;
    L65:
        com.larus.im.service.r.a.a(com.larus.im.d.d(), r116, 3, r115, r121, null, new n(r117), 16);
        Object r122 = r117.B();
        if (r122 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L68;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L68:
        if (r122 != r103) goto L70;
        return r103;
    L70:
        r106 = r116;
        r102 = r122;
        goto L71
    L60:
        if ((!StringsKt.isBlank(r112)) == true) goto L63;
        r112 = null;
    L63:
        if (r112 == null) goto L65;
        r121.put("attach_local_msg", "true");
        r121.put("custom_suffix", r112);
    L56:
        r120 = "";
        goto L57
    L51:
        r118 = R.string.larus_new_chat_default;
        goto L52
    L18:
        String r123 = (String) r100.L$2;
        Integer r124 = (Integer) r100.L$1;
        Context r125 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r126 = r123;
        Integer r127 = r124;
    L29:
        String r128 = (String) r102;
        if (r128 != null) goto L32;
    L35:
        boolean r129 = true;
    L36:
        if (r129 == false) goto L39;
        FLogger.f375446a.i("DriveLocalConvHelper", "createLocalSubConversation skipped because botId is empty.");
        return null;
    L39:
        r100.L$0 = r125;
        r100.L$1 = r127;
        r100.L$2 = r126;
        r100.label = 3;
        kotlinx.coroutines.j r130 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r130.C();
        com.larus.im.service.o.a.a(com.larus.im.d.a(), r128, false, "sub", new o(r130), 8);
        r102 = r130.B();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L42;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L42:
        if (r102 != r103) goto L44;
        return r103;
    L44:
        r114 = r125;
        r115 = r127;
        r112 = r126;
        goto L45
    L32:
        if (StringsKt.isBlank(r128) == true) goto L35;
        r129 = false;
        goto L36
    L19:
        ResultKt.throwOnFailure(r102);
    L25:
        return r102;
    L20:
        ResultKt.throwOnFailure(r102);
        if (com.larus.platform.exp.o.a() == false) goto L26;
        LocalSubConvHelper r131 = LocalSubConvHelper.f314106a;
        String r132 = AccountService.f365697a.getSecUserId();
        r100.label = 1;
        r102 = r131.c(r132, null, r100);
        if (r102 != r103) goto L25;
        return r103;
    L26:
        wc9.e r133 = AuthModelDelegate.f297134b.y().getValue();
        LocalSubConvHelper r134 = LocalSubConvHelper.f314106a;
        r125 = r210;
        r100.L$0 = r125;
        r127 = r211;
        r100.L$1 = r127;
        r126 = r212;
        r100.L$2 = r126;
        r100.label = 2;
        r102 = r134.f(r133, r100);
        if (r102 != r103) goto L29;
        return r103;
    L7:
        r100 = new DriveLocalConversationHelper$createLocalSubConversation$1(this, r213);
        goto L8
    }
}
