package com.obric.assistant.chat.impl;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.bmhome.chat.api.b0;
import com.larus.im.FlowRuntime;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.chat.ObricWindowMessageBubbleConfig;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IClearContextInKeyguardService;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.IQueryAuthenticationService;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.spi.chat.IObricChatSPIService;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.common.applog.EventVerify;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import iga.c;
import iga.d;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DelayKt;
import va8.l;
import va8.m;
import wc9.e;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J4\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0012H\u0096@¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016J\b\u0010\u001e\u001a\u00020\u000bH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u000bH\u0016J\b\u0010!\u001a\u00020\u000bH\u0016J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020#H\u0016J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u000bH\u0016J$\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00070-H\u0016J\u0010\u0010.\u001a\u00020+2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u00020+H\u0002J\u0014\u00101\u001a\u00020\u0007*\u00020+2\u0006\u0010*\u001a\u00020+H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/assistant/chat/impl/ObricChatSPIServiceImpl;", "Lcom/obric/assistant/spi/chat/IObricChatSPIService;", "<init>", "()V", "queryAuthenticationService", "Lcom/obric/assistant/chat/IQueryAuthenticationService;", "tryBreakLatestAnswer", "", "curCvsId", "", "onCheckAsrContentRelative", "", "taskid", "asrContent", "ensureContextSafe", "cvsId", "canRetry", "extra", "", "(Ljava/lang/String;ZLjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onReGenerate", "questionMsg", "Lcom/larus/im/bean/message/Message;", "shouldSkipAsLatestRegenerateMessage", "message", "markChatListBottomReached", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "isEnabledAssistantOpenPageMethod", "isBluetoothHeadSetConnected", "enableLiveTutorAsrOpt", "enableCameraCommandOpt", "enableCameraSuggestedToDeferred", "enableCameraOpenResultPage", "openChatWindowForCameraResult", "Landroid/os/Bundle;", "getCachedMainChatSnapshot", "Lcom/obric/assistant/spi/chat/ObricMainChatSnapshot;", "getWindowInboxBackgroundStyle", "Lcom/obric/assistant/spi/chat/ObricWindowInboxBackgroundStyle;", "isDarkMode", "tryLaunchFilePicker", "defaultIntent", "Landroid/content/Intent;", EventVerify.TYPE_LAUNCH, "Lkotlin/Function1;", "buildFilePickerIntent", "canResolveFilePicker", "intent", "copyAllowedMimeTypes", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatSPIServiceImpl implements IObricChatSPIService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IQueryAuthenticationService f386917a;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean d() {
        return true;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean i() {
        return true;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean j() {
        return true;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean l() {
        return true;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final c c() {
        IObricChatService.f386556a.getClass();
        IObricChatService r100 = IObricChatService.a.a();
        if (r100 != null) goto L6;
        FLogger.f375446a.i("ObricChatSPIServiceImpl", "getCachedMainChatSnapshot: chat service unavailable");
        return null;
    L6:
        e r101 = r100.h();
        BotModel r102 = r100.j0();
        if (r101 == null) goto L42;
        if (r102 == null) goto L10;
        String r103 = r102.getBotId();
    L11:
        boolean r104 = true;
        if (r103 != null) goto L14;
    L17:
        boolean r105 = true;
    L18:
        if (r105 == true) goto L42;
        IAuthModelService r106 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r106 == null) goto L27;
        LiveData<e> r107 = r106.y();
        if (r107 == null) goto L27;
        e r108 = r107.getValue();
        if (r108 == null) goto L27;
        String r109 = r108.f559198a;
    L28:
        if (r109 != null) goto L30;
    L33:
        if (r104 == false) goto L37;
        FLogger.f375446a.i("ObricChatSPIServiceImpl", "getCachedMainChatSnapshot: current main conversation unavailable");
        return null;
    L37:
        if (Intrinsics.areEqual(r101.f559198a, r109) == true) goto L41;
        FLogger.f375446a.w("ObricChatSPIServiceImpl", "getCachedMainChatSnapshot: cached conversation is stale");
        return null;
    L41:
        return new c(r102, r101);
    L30:
        if (StringsKt.isBlank(r109) == true) goto L33;
        r104 = false;
    L27:
        r109 = null;
        goto L28
    L14:
        if (StringsKt.isBlank(r103) == true) goto L17;
        r105 = false;
        goto L18
    L10:
        r103 = null;
    L42:
        FLogger.f375446a.i("ObricChatSPIServiceImpl", "getCachedMainChatSnapshot: chat cache not ready");
        return null;
    }

    public ObricChatSPIServiceImpl() {
        this.f386917a = (IQueryAuthenticationService) ServiceManager.get().getService(IQueryAuthenticationService.class);
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean a() {
        IBluetoothHeadSetAPI r100 = tha.c.a();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.a();
    }

    public static Intent o(Intent r110) {
        Intent r100 = new Intent("com.bytedance.action.PICK_FILE_FROM_FILE_MANAGER");
        r100.setPackage("com.obric.filemanager");
        String r101 = r110.getType();
        if (r101 != null) goto L5;
        r101 = "*/*";
    L5:
        r100.setType(r101);
        String[] r102 = r110.getStringArrayExtra("android.intent.extra.MIME_TYPES");
        boolean r103 = true;
        if (r102 == null) goto L14;
        ArrayList r104 = new ArrayList();
        int r105 = r102.length;
        int r106 = 0;
    L8:
        if (r106 >= r105) goto L13;
        String r107 = r102[r106];
        Intrinsics.checkNotNull(r107);
        if ((!StringsKt.isBlank(r107)) == false) goto L12;
        r104.add(r107);
    L12:
        r106 = r106 + 1;
        goto L8
    L13:
        String[] r108 = (String[]) r104.toArray(new String[0]);
    L15:
        if (r108 != null) goto L17;
    L23:
        if (r103 == true) goto L25;
        r100.putExtra("android.intent.extra.MIME_TYPES", r108);
    L25:
        r100.putExtra("android.intent.extra.ALLOW_MULTIPLE", r110.getBooleanExtra("android.intent.extra.ALLOW_MULTIPLE", false));
        return r100;
    L17:
        if (r108.length != 0) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == true) goto L23;
        r103 = false;
        goto L23
    L19:
        r109 = false;
        goto L20
    L14:
        r108 = null;
        goto L15
    }

    public static boolean p(Intent r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (FlowRuntime.a().getApplication().getPackageManager().queryIntentActivities(r100, 65536).isEmpty() == true) goto L5;
        boolean r102 = true;
    L6:
        Object r103 = Result.m9449constructorimpl(Boolean.valueOf(r102));     // Catch: Throwable -> L8
    L10:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L13;
        FLogger.f375446a.w("ObricChatSPIServiceImpl", "canResolveFilePicker failed, package=" + r100.getPackage() + ", action=" + r100.getAction() + ", message=" + r104.getMessage());
    L13:
        Boolean r105 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r103) == false) goto L17;
        r103 = r105;
    L17:
        return ((Boolean) r103).booleanValue();
    L5:
        r102 = false;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final void b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "questionMsg");
        IQueryAuthenticationService r101 = this.f386917a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final d e(boolean r100) {
        ObricWindowMessageBubbleConfig r101 = z2.f365865a.getObricWindowMessageBubbleConfig();
        if (r101.getEnable() == true) goto L7;
        return null;
    L7:
        return new d(r101.getColorToken(r100));
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "curCvsId");
        IObricChatService.f386556a.getClass();
        IObricChatService r101 = IObricChatService.a.a();
        if (r101 == null) goto L6;
        r101.g();
        MessageApiImpl.f386895a.h(r100);
        return;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean h(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (com.larus.bmhome.chat.bean.d.W0(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (com.larus.bmhome.chat.bean.d.V0(r100) == false) goto L7;
        return true;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final void k(t1a.b r100) {
        Intrinsics.checkNotNullParameter(r100, "vContext");
        m r101 = (m) r100.getAbility(m.class);
        b0 r102 = null;
        if (r101 == null) goto L7;
        l r103 = r101.iX();
        if (r103 == null) goto L7;
        RecyclerView r104 = r103.getMessageList();
    L9:
        if ((r104 instanceof b0) == false) goto L11;
        r102 = (b0) r104;
    L11:
        if (r102 != null) goto L14;
        FLogger.f375446a.w("ObricChatSPIServiceImpl", "markChatListBottomReached: messageList is null");
        return;
    L14:
        r102.setBottomReached(true);
        return;
    L7:
        r104 = null;
        goto L9
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean m(Bundle r110) {
        Intrinsics.checkNotNullParameter(r110, "extra");
        IAssistantChatWindow r100 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r100 != null) goto L6;
        return false;
    L6:
        IAssistantChatWindow.DefaultImpls.openChatWindow$default(r100, "", false, Boolean.FALSE, r110, false, false, null, null, false, false, ISmModel.VERSION_0300, null);
        return true;
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final boolean f(Intent r100, li8.c r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultIntent");
        Intrinsics.checkNotNullParameter(r101, EventVerify.TYPE_LAUNCH);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Intent r103 = o(r100);     // Catch: Throwable -> L9
        if (p(r103) == true) goto L6;
        FLogger.f375446a.w("ObricChatSPIServiceImpl", "tryLaunchFilePicker: custom file picker unavailable");     // Catch: Throwable -> L9
        boolean r104 = false;
    L7:
        Object r105 = Result.m9449constructorimpl(Boolean.valueOf(r104));     // Catch: Throwable -> L9
    L11:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L14;
        FLogger.f375446a.e("ObricChatSPIServiceImpl", "tryLaunchFilePicker failed, message=" + r106.getMessage(), r106);
    L14:
        Boolean r107 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r105) == false) goto L18;
        r105 = r107;
    L18:
        return ((Boolean) r105).booleanValue();
    L6:
        FLogger.f375446a.i("ObricChatSPIServiceImpl", "tryLaunchFilePicker: launch custom file picker");     // Catch: Throwable -> L9
        r101.invoke(r103);     // Catch: Throwable -> L9
        r104 = true;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.obric.assistant.spi.chat.IObricChatSPIService
    public final Object n(String r110, boolean r111, Map<String, String> r112, Continuation<? super Boolean> r210) {
        String r100 = r110;
        if ((r210 instanceof ObricChatSPIServiceImpl$ensureContextSafe$1) == false) goto L7;
        ObricChatSPIServiceImpl$ensureContextSafe$1 r101 = (ObricChatSPIServiceImpl$ensureContextSafe$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = false;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 == 2) goto L18;
        if (r105 == 3) goto L17;
        if (r105 != 4) goto L16;
        ResultKt.throwOnFailure(r103);
    L80:
        if (((Boolean) r103).booleanValue() == true) goto L82;
        r106 = true;
    L82:
        boolean r107 = !r106;
    L83:
        if (r107 == true) goto L86;
        FLogger.f375446a.w("ObricChatSPIServiceImpl", "ensureContextSafe: clear context in keyguard failed");
    L86:
        return Boxing.boxBoolean(r107);
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        IClearContextInKeyguardService r108 = (IClearContextInKeyguardService) r101.L$1;
        String r109 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L75:
        if (r108 == null) goto L82;
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 4;
        r103 = r108.a(r109, r101);
        if (r103 != r104) goto L80;
        return r104;
    L18:
        boolean r113 = r101.Z$0;
        IClearContextInKeyguardService r114 = (IClearContextInKeyguardService) r101.L$1;
        String r115 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L64:
        if (((Boolean) r103).booleanValue() == true) goto L66;
        boolean r116 = true;
    L68:
        r107 = !r116;
        if (r107 == true) goto L83;
        if (r113 == false) goto L83;
        FLogger.f375446a.i("ObricChatSPIServiceImpl", "ensureContextSafe: clear context in keyguard failed, will retry");
        r101.L$0 = r115;
        r101.L$1 = r114;
        r101.label = 3;
        if (DelayKt.delay(700, r101) != r104) goto L74;
        return r104;
    L74:
        r108 = r114;
        r109 = r115;
        goto L75
    L66:
        boolean r117 = r113;
    L67:
        r113 = r117;
        r116 = false;
        goto L68
    L19:
        boolean r118 = r101.Z$0;
        String r119 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r117 = r118;
        r100 = r119;
        Object r120 = r103;
    L33:
        e r121 = (e) r120;
        if (r121 == null) goto L37;
        String r122 = r121.f559198a;
    L38:
        if (r100 != null) goto L40;
    L43:
        boolean r123 = true;
    L44:
        if (r123 == false) goto L48;
        if (r122 != null) goto L47;
        r100 = "";
        goto L48
    L47:
        r115 = r122;
    L50:
        if (Intrinsics.areEqual(r115, r122) == false) goto L87;
        r114 = (IClearContextInKeyguardService) ServiceManager.get().getService(IClearContextInKeyguardService.class);
        if (r114 != null) goto L54;
    L56:
        boolean r124 = false;
    L57:
        if (r124 == false) goto L89;
        if (r114 == null) goto L67;
        r101.L$0 = r115;
        r101.L$1 = r114;
        r101.Z$0 = r117;
        r101.label = 2;
        Object r125 = r114.a(r115, r101);
        if (r125 != r104) goto L62;
        return r104;
    L62:
        boolean r126 = r117;
        r103 = r125;
        r113 = r126;
    L89:
        return Boxing.boxBoolean(true);
    L54:
        if (r114.b() != true) goto L56;
        r124 = true;
        goto L57
    L87:
        FLogger.f375446a.i("ObricChatSPIServiceImpl", "ensureContextSafe: is not main conversation, mainConversationId = " + r122);
    L48:
        r115 = r100;
        goto L50
    L40:
        if (r100.length() == 0) goto L43;
        r123 = false;
    L37:
        r122 = null;
        goto L38
    L20:
        ResultKt.throwOnFailure(r103);
        FLogger r127 = FLogger.f375446a;
        r127.i("ObricChatSPIServiceImpl", "ensureContextSafe: cvsId = " + r100);
        if (r112 == null) goto L23;
        String r128 = r112.get("o_not_clear_context");
    L25:
        if (Intrinsics.areEqual(r128, "1") == false) goto L28;
        r127.i("ObricChatSPIServiceImpl", "has extra, not clear context");
        return Boxing.boxBoolean(true);
    L28:
        IObricChatService r129 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
        if (r129 == null) goto L36;
        r101.L$0 = r100;
        r117 = r111;
        r101.Z$0 = r117;
        r101.label = 1;
        r120 = r129.d(r101);
        if (r120 != r104) goto L33;
        return r104;
    L36:
        r117 = r111;
        goto L37
    L23:
        r128 = null;
    L7:
        r101 = new ObricChatSPIServiceImpl$ensureContextSafe$1(this, r210);
        goto L8
    }
}
