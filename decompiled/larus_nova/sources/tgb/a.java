package tgb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.bundle.ChatForsetiBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.biz.im.api.bundle.v2.base.output.RealLaunchData;
import com.ss.android.lark.chat.chatwindow.chat.perload.c;
import com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chatwindow.launcher.ChatLauncherV2;
import com.ss.android.lark.chatwindow.launcher.starter.BaseStarter;
import com.ss.android.lark.chatwindow.launcher.starter.StartKey;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.flow.bottomsheet.BottomSheetLauncher;
import com.ss.android.lark.flow.chat.FlowChatModule;
import com.ss.android.lark.flow.chat.page.ChatFragment;
import com.ss.android.lark.flow.chat.page.FlowChatActivity;
import com.ss.android.lark.flow.chat.page.FlowChatWindowSelectMessagesActivity;
import com.ss.android.lark.flow.forward.ForwardTools;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import javax.inject.Inject;
import jdb.g;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@StartKey(RealLaunchData.ChatDirection.FLOW_CHAT)
public final class a extends BaseStarter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f545915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f545916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Inject
    public UserSession f545917c;

    @Override // com.ss.android.lark.chatwindow.launcher.starter.BaseStarter
    public final void b(com.ss.android.lark.chatwindow.launcher.transform.d r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r100, "data");
        ChatBundleV2 r101 = r100.f416987a;
        String r102 = r101.f409992i.f410012a;
        RxScheduledExecutor.justInIO(new com.ss.android.lark.flow.forward.a(r102, ForwardTools.RecentVisitTargetType.CHAT));
        PerfLog.start("prepare_chat_window", "");
        c r103 = c.a.f413467a;
        r103.b(new u3b.b(r101));
        r103.b(new u3b.c(r101.getChatId(), r101.o()));
        r103.b(new f6b.b(r102, new f6b.d(r100.f416988b, r101)));
    }

    @Inject
    public a(g r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "fgService");
        Intrinsics.checkNotNullParameter(r101, "dataPreloader");
        this.f545915a = r100;
        this.f545916b = r101;
    }

    @Override // com.ss.android.lark.chatwindow.launcher.starter.BaseStarter
    public final boolean c(ChatLauncherV2.b r110, com.ss.android.lark.chatwindow.launcher.transform.d r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "result");
        ChatBundleV2 r112 = r111.f416987a;
        String r100 = r112.f409992i.f410012a;
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "route open chat " + r100);
        boolean r101 = false;
        if (OfficeSDKManager.isAvailable() == true) goto L6;
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "route open chat " + r100 + ", office sdk not ready");
        return false;
    L6:
        Context r102 = r110.getContext();
        Bundle r103 = r112.F();
        UserSession r104 = this.f545917c;
        UserSession r105 = null;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("userSession");
        r104 = null;
    L10:
        Lazy r106 = BottomSheetLauncher.f421957a;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "params");
        if (r103.getBoolean("key_bottom_sheet_container_start") == false) goto L18;
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.inapppush.reply") == false) goto L18;
        BottomSheetLauncher.a r107 = new BottomSheetLauncher.a(r102);
        Intrinsics.checkNotNullParameter(FlowChatActivity.class, "targetClazz");
        r107.f421960c = FlowChatActivity.class.getName();
        r107.f421961d = r104;
        r107.f421959b = r103;
        r107.a();
        r101 = true;
    L18:
        if (r101 == false) goto L21;
        PerfLog.end("prepare_chat_window", "");
        ChatCoreModule.a().getPerfEnterChatMonitor().l(true);
        return true;
    L21:
        Bundle r108 = r112.getExtraParams();
        if (r108 == null) goto L24;
        Serializable r109 = r108.getSerializable("key_forseti_bundle");
    L26:
        if ((r109 instanceof ChatForsetiBundle) == false) goto L28;
        ChatForsetiBundle r113 = (ChatForsetiBundle) r109;
    L29:
        if (r113 == null) goto L32;
        r113.isOpenChatFullScreenStyle();
    L32:
        if (TextUtils.isEmpty(r112.f409967b.f410043m) == true) goto L34;
        Intent r114 = new Intent(r110.getContext(), FlowChatWindowSelectMessagesActivity.class);
    L35:
        int r115 = r112.f409966a.f410017a;
        if (r115 == (-1)) goto L38;
        r114.setFlags(r115);
    L38:
        r114.putExtras(r112.F());
        r114.putExtra("multi_task_transition", r112.f409966a.f410018b);
        UserSession r116 = this.f545917c;
        if (r116 == null) goto L41;
        r105 = r116;
    L42:
        PassportcConvention.g(r114, r105);
        r114.putExtra("use_chat_container", true);
        int r117 = r112.f409966a.f410018b;
        r112.getExtraParams();
        if (r112.f409973h.f410050b == false) goto L48;
        gza.b r118 = (gza.b) OfficeSDKManager.getHostGlobalService(gza.b.class);
        if (r118 == null) goto L48;
        ChatFragment r119 = new ChatFragment();
        r119.setArguments(r114.getExtras());
        r118.O1(r112.getChatId(), r119);
    L51:
        PerfLog.end("prepare_chat_window", "");
        int r120 = FlowChatModule.f422022d;
        FlowChatModule.a.a().a().getPerfEnterChatMonitor().l(true);
        return true;
    L48:
        if ((r110.getContext() instanceof Activity) == false) goto L50;
        r110.getContext().startActivity(r114);
        goto L51
    L50:
        r114.addFlags(268435456);
        r110.getContext().startActivity(r114);
        goto L51
    L41:
        Intrinsics.throwUninitializedPropertyAccessException("userSession");
        goto L42
    L34:
        r114 = new Intent(r110.getContext(), FlowChatActivity.class);
        goto L35
    L28:
        r113 = null;
        goto L29
    L24:
        r109 = null;
        goto L26
    }
}
