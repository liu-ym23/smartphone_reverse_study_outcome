package whb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.bottomsheet.BottomSheetContainerActivity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.flow.bottomsheet.BottomSheetLauncher;
import com.ss.android.lark.flow.forward.ForwardTools;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadActivity;
import com.ss.android.lark.flow.replyinthread.FlowReplyInThreadContainerFragment;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f559723a = 0;

    static {
    }

    @JvmStatic
    public static final void a(Context r100, l1 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        Bundle r102 = r101.a();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "params");
        String r103 = r102.getString("key_params_thread_id");
        if (r103 == null) goto L29;
        RxScheduledExecutor.justInIO(new com.ss.android.lark.flow.forward.a(r103, ForwardTools.RecentVisitTargetType.MSG_THREAD));
        Activity r104 = com.ss.android.lark.appcontext.applifecycle.c.a.f408832a.a();
        if ((r104 instanceof FlowReplyInThreadActivity) == false) goto L11;
        if (TextUtils.equals(((FlowReplyInThreadActivity) r104).getIntent().getStringExtra("key_params_thread_id"), r103) == false) goto L11;
        return;
    L11:
        if (BottomSheetLauncher.a(r100, r102) == true) goto L31;
        Activity r105 = ContextsKt.findActivity(r100);
        if (r105 != null) goto L16;
    L18:
        Intent r106 = new Intent(r100, FlowReplyInThreadActivity.class);
        r106.putExtras(r102);
        if ((r100 instanceof Activity) == true) goto L21;
        r106.addFlags(268435456);
    L21:
        PassportcConvention.e(r106, LarkContext.getApplication());
        if (r102.getBoolean("is_embedded", false) == false) goto L26;
        gza.b r107 = (gza.b) OfficeSDKManager.getHostGlobalService(gza.b.class);
        if (r107 == null) goto L26;
        FlowReplyInThreadContainerFragment r108 = new FlowReplyInThreadContainerFragment();
        r108.setArguments(r106.getExtras());
        r107.O1(r103, r108);
        return;
    L26:
        r100.startActivity(r106);
        return;
    L16:
        if (ChatCoreModule.a().getVcDependency().a(r105.getTaskId()) == false) goto L18;
        r100 = r105;
        goto L18
    L31:
        return;
    }

    @JvmStatic
    public static final void b(Context r100, Fragment r101, l1 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "bundle");
        Bundle r103 = r102.a();
        sua.a r104 = (sua.a) ApiUtils.getApi(sua.a.class);
        String r105 = null;
        if (r101 == null) goto L5;
        FragmentActivity r106 = r101.getActivity();
    L6:
        tua.b r107 = r104.tryGetChainManager(r106);
        if (r107 == null) goto L11;
        yua.d r108 = r107.q();
        if (r108 == null) goto L11;
        Fragment r109 = r108.o2();
    L12:
        Activity r110 = com.ss.android.lark.appcontext.applifecycle.c.a.f408832a.a();
        if ((r109 instanceof FlowReplyInThreadContainerFragment) == false) goto L18;
        Bundle r111 = ((FlowReplyInThreadContainerFragment) r109).getArguments();
        if (r111 == null) goto L22;
        r105 = r111.getString("key_params_thread_id");
    L22:
        if (TextUtils.equals(r105, r103.getString("key_params_thread_id")) == false) goto L24;
        return;
    L24:
        Intrinsics.checkNotNull(r103);
        if (BottomSheetLauncher.a(r100, r103) == false) goto L27;
        return;
    L27:
        PassportcConvention.f(r103, LarkContext.getApplication());
        if (r103.getBoolean("is_embedded", false) == false) goto L36;
        String r112 = r103.getString("key_params_thread_id");
        if (r112 != null) goto L32;
        return;
    L32:
        gza.b r113 = (gza.b) OfficeSDKManager.getHostGlobalService(gza.b.class);
        if (r113 == null) goto L36;
        FlowReplyInThreadContainerFragment r114 = new FlowReplyInThreadContainerFragment();
        r114.setArguments(r103);
        r113.O1(r112, r114);
        return;
    L36:
        a(r100, r102);
        return;
    L18:
        if ((r110 instanceof BottomSheetContainerActivity) == false) goto L20;
        r105 = ((BottomSheetContainerActivity) r110).getIntent().getStringExtra("key_params_thread_id");
        goto L22
    L20:
        r105 = "";
    L11:
        r109 = null;
        goto L12
    L5:
        r106 = null;
        goto L6
    }
}
