package tgb;

import android.content.Context;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.RealLaunchData;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chatwindow.launcher.ChatLauncherV2;
import com.ss.android.lark.chatwindow.launcher.starter.BaseStarter;
import com.ss.android.lark.chatwindow.launcher.starter.StartKey;
import com.ss.android.lark.chatwindow.launcher.transform.d;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.threadwindow.i;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@StartKey(RealLaunchData.ChatDirection.THREAD)
public final class b extends BaseStarter {
    @Inject
    public b() {
    }

    @Override // com.ss.android.lark.chatwindow.launcher.starter.BaseStarter
    public final boolean c(ChatLauncherV2.b r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "result");
        ChatBundleV2 r102 = r101.f416987a;
        String r103 = r102.f409992i.f410012a;
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "route open thread window " + r103);
        boolean r104 = false;
        if (r103.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L10;
        Log.e(ChatWindowViewModel.LAUNCHER_TAG, "route open thread window failed, chatId is empty");
        return false;
    L10:
        if (OfficeSDKManager.isAvailable() == true) goto L13;
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "route open thread window " + r103 + ", office sdk not ready");
        return false;
    L13:
        ChatBundle.a r106 = new ChatBundle.a();
        r106.f409934a = r103;
        r106.f409935b = r102.f409992i.f410013b;
        r106.a(Chat.ChatMode.THREAD_V2);
        r106.f409936c = r102.o();
        r106.G = ((Boolean) r102.F.a(ChatBundleV2.H[34])).booleanValue();
        r106.b(Boolean.valueOf(r102.D()));
        ChatBundle r107 = new ChatBundle(r106);
        int r108 = FlowChatModule.f422022d;
        FlowChatModule r109 = FlowChatModule.a.a();
        Context r110 = r100.getContext();
        Intrinsics.checkNotNull(r107);
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r107, "chatBundle");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r107, "chatBundle");
        KeyboardUtils.hideKeyboard(r110);
        String r111 = r107.f409908a;
        if (r111 != null) goto L16;
    L17:
        r104 = true;
    L18:
        if (r104 == false) goto L21;
    L33:
        return true;
    L21:
        if (r107.G == true) goto L23;
    L34:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L27
        i.c(r110, r107);     // Catch: Throwable -> L27
        Object r113 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L30:
        if (Result.m9456isSuccessimpl(r113) == false) goto L32;
        Unit r114 = (Unit) r113;
    L32:
        Result.m9452exceptionOrNullimpl(r113);
    L27:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    L23:
        if (FlowChatModule.c(r107.f409908a) == false) goto L34;
    L16:
        if (r111.length() != 0) goto L18;
    L5:
        r105 = false;
        goto L6
    }
}
