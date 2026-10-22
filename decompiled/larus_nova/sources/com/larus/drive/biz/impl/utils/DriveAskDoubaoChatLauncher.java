package com.larus.drive.biz.impl.utils;

import android.content.Context;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.cache.BotInfoCache;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.bean.message.Message;
import com.larus.im.service.r;
import com.larus.nova.R;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes27.dex */
public final class DriveAskDoubaoChatLauncher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DriveAskDoubaoChatLauncher f341249a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f341250a = null;

        static {
            int[] r100 = new int[DriveFileType.values().length];
            r100[DriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DriveFileType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f341250a = r100;
        }
    }

    static {
        f341249a = new DriveAskDoubaoChatLauncher();
    }

    public DriveAskDoubaoChatLauncher() {
    }

    public final Object a(Continuation<? super String> r100) {
        if ((r100 instanceof DriveAskDoubaoChatLauncher$getMainBotId$1) == false) goto L7;
        DriveAskDoubaoChatLauncher$getMainBotId$1 r101 = (DriveAskDoubaoChatLauncher$getMainBotId$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L21:
        List r106 = (List) r103;
        if (r106 == null) goto L31;
        String r107 = (String) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L31;
        if ((!StringsKt.isBlank(r107)) == true) goto L29;
        r107 = null;
    L29:
        if (r107 == null) goto L31;
    L40:
        return r107;
    L31:
        e0 r108 = AuthModelDelegate.f297134b.e().getValue();
        if (r108 == null) goto L41;
        LaunchInfo r109 = r108.f297186a;
        if (r109 == null) goto L42;
        r107 = r109.W();
        if (r107 != null) goto L38;
        return null;
    L38:
        if ((!StringsKt.isBlank(r107)) == true) goto L40;
        return null;
    L42:
        return null;
    L41:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        wc9.e r110 = AuthModelDelegate.f297134b.y().getValue();
        if (r110 == null) goto L31;
        String r111 = r110.f559198a;
        if (r111 == null) goto L31;
        r101.label = 1;
        r103 = ic8.n.b(r111, r101);
        if (r103 != r104) goto L21;
        return r104;
    L7:
        r101 = new DriveAskDoubaoChatLauncher$getMainBotId$1(this, r100);
        goto L8
    }

    public final Object b(Context r210, DriveFileItem r211, boolean r212, Continuation<? super Boolean> r213) {
        if ((r213 instanceof DriveAskDoubaoChatLauncher$openAskDoubaoChat$1) == false) goto L7;
        DriveAskDoubaoChatLauncher$openAskDoubaoChat$1 r100 = (DriveAskDoubaoChatLauncher$openAskDoubaoChat$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L23;
        if (r104 == 1) goto L22;
        if (r104 == 2) goto L21;
        if (r104 == 3) goto L20;
        if (r104 == 4) goto L18;
        if (r104 != 5) goto L17;
        ResultKt.throwOnFailure(r102);
    L94:
        return Boxing.boxBoolean(true);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        boolean r105 = r100.Z$0;
        String r106 = (String) r100.L$4;
        BotModel r110 = (BotModel) r100.L$3;
        String r111 = (String) r100.L$2;
        DriveFileItem r112 = (DriveFileItem) r100.L$1;
        Context r113 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
        boolean r114 = r105;
        String r107 = r106;
    L19:
        DriveFileItem r108 = r112;
        Object r109 = CollectionsKt.firstOrNull((List) r102);
        String r115 = (String) r109;
        if (r115 != null) goto L68;
    L71:
        boolean r116 = true;
    L73:
        if (r116 == false) goto L76;
        r109 = null;
    L76:
        String r117 = (String) r109;
        if (r117 != null) goto L79;
        String r118 = r111;
    L81:
        if (StringsKt.isBlank(r107) == false) goto L83;
    L95:
        FLogger.f375446a.i("DriveAskDoubaoLauncher", "openAskDoubaoChat skipped because conversation or bot is invalid, conversationIdEmpty=" + StringsKt.isBlank(r107) + ", botIdEmpty=" + StringsKt.isBlank(r118));
        return Boxing.boxBoolean(false);
    L83:
        if (StringsKt.isBlank(r118) == true) goto L95;
        BotInfoCache.INSTANCE.put(r107, r110);
        LocalSubConvHelper r119 = LocalSubConvHelper.f314106a;
        BotOnBoarding r120 = r110.getOnBoarding();
        if (r120 == null) goto L89;
        List<Message> r121 = r120.getMessageList();
        if (r121 == null) goto L89;
    L90:
        LocalSubConvHelper.j(r107, r121, true);
        MainCoroutineDispatcher r122 = Dispatchers.getMain();
        DriveAskDoubaoChatLauncher$openAskDoubaoChat$2 r123 = new DriveAskDoubaoChatLauncher$openAskDoubaoChat$2(r113, r107, r118, r108, r114, null);
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.L$3 = null;
        r100.L$4 = null;
        r100.label = 5;
        if (BuildersKt.withContext(r122, r123, r100) != r103) goto L94;
        return r103;
    L89:
        r121 = CollectionsKt.emptyList();
        goto L90
    L79:
        r118 = r117;
        goto L81
    L68:
        if (StringsKt.isBlank(r115) == true) goto L71;
        r116 = false;
        goto L73
    L20:
        boolean r124 = r100.Z$0;
        r110 = (BotModel) r100.L$3;
        r111 = (String) r100.L$2;
        r112 = (DriveFileItem) r100.L$1;
        r113 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L57:
        wc9.e r125 = (wc9.e) r102;
        if (r125 == null) goto L60;
        String r126 = r125.f559198a;
        r100.L$0 = r113;
        r100.L$1 = r112;
        r100.L$2 = r111;
        r100.L$3 = r110;
        r100.L$4 = r126;
        r100.Z$0 = r124;
        r100.label = 4;
        Object r127 = ic8.n.b(r126, r100);
        if (r127 != r103) goto L64;
        return r103;
    L64:
        r114 = r124;
        r107 = r126;
        r102 = r127;
        goto L19
    L60:
        return Boxing.boxBoolean(false);
    L21:
        r124 = r100.Z$0;
        r111 = (String) r100.L$2;
        r112 = (DriveFileItem) r100.L$1;
        r113 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L43:
        BotModel r128 = (BotModel) r102;
        if (r128 == null) goto L46;
        r100.L$0 = r113;
        r100.L$1 = r112;
        r100.L$2 = r111;
        r100.L$3 = r128;
        r100.Z$0 = r124;
        r100.label = 3;
        kotlinx.coroutines.j r129 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r129.C();
        if (AccountService.f365697a.isEnterpriseAccount() == false) goto L50;
        int r130 = R.string.larus_new_task_cn;
    L51:
        r.a.a(com.larus.im.d.d(), r128, 3, Boxing.boxInt(1), MapsKt.mapOf(TuplesKt.to("conv_name", r113.getString(r130))), null, new com.larus.drive.biz.impl.utils.a(r129), 16);
        Object r131 = r129.B();
        if (r131 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L54;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L54:
        if (r131 != r103) goto L56;
        return r103;
    L56:
        r110 = r128;
        r102 = r131;
        goto L57
    L50:
        r130 = R.string.larus_new_chat_default;
        goto L51
    L46:
        return Boxing.boxBoolean(false);
    L22:
        r124 = r100.Z$0;
        r112 = (DriveFileItem) r100.L$1;
        r113 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L27:
        String r132 = (String) r102;
        if (r132 != null) goto L30;
    L33:
        boolean r133 = true;
    L34:
        if (r133 == false) goto L37;
        FLogger.f375446a.i("DriveAskDoubaoLauncher", "openAskDoubaoChat skipped because botId is blank.");
        return Boxing.boxBoolean(false);
    L37:
        r100.L$0 = r113;
        r100.L$1 = r112;
        r100.L$2 = r132;
        r100.Z$0 = r124;
        r100.label = 2;
        kotlinx.coroutines.j r134 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r134.C();
        com.larus.im.service.o.a.a(com.larus.im.d.a(), r132, false, "sub", new b(r134), 8);
        Object r135 = r134.B();
        if (r135 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L40;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L40:
        if (r135 != r103) goto L42;
        return r103;
    L42:
        r111 = r132;
        r102 = r135;
        goto L43
    L30:
        if (StringsKt.isBlank(r132) == true) goto L33;
        r133 = false;
        goto L34
    L23:
        ResultKt.throwOnFailure(r102);
        r100.L$0 = r210;
        r100.L$1 = r211;
        r100.Z$0 = r212;
        r100.label = 1;
        Object r136 = a(r100);
        if (r136 != r103) goto L26;
        return r103;
    L26:
        r113 = r210;
        r102 = r136;
        r112 = r211;
        r124 = r212;
    L7:
        r100 = new DriveAskDoubaoChatLauncher$openAskDoubaoChat$1(this, r213);
        goto L8
    }
}
