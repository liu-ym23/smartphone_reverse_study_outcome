package mea;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.live.receiver.GRIslandReceiver;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f513575a = null;

    static {
        f513575a = new b();
    }

    public b() {
    }

    public static Intent a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intent r101 = new Intent(r100, GRIslandReceiver.class);
        r101.setPackage(r100.getPackageName());
        r101.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r101.putExtra("live_state", -102);
        FLogger.f375446a.e("GRStateActionUtils", "getContentPendingIntent with intent " + r101 + ", extras: " + r101.getExtras());
        return r101;
    }

    public static Intent b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intent r101 = new Intent(r100, GRIslandReceiver.class);
        r101.setPackage(r100.getPackageName());
        r101.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r101.putExtra("live_state", -1007);
        FLogger.f375446a.e("GRStateActionUtils", "getContentPendingIntent with intent " + r101 + ", extras: " + r101.getExtras());
        return r101;
    }

    public static Intent e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intent r101 = new Intent(r100, GRIslandReceiver.class);
        r101.setPackage(r100.getPackageName());
        r101.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r101.putExtra("live_state", -104);
        FLogger.f375446a.e("GRStateActionUtils", "getContentPendingIntent with intent " + r101 + ", extras: " + r101.getExtras());
        return r101;
    }

    public static Intent g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intent r101 = new Intent(r100, GRIslandReceiver.class);
        r101.setPackage(r100.getPackageName());
        r101.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r101.putExtra("live_state", -105);
        FLogger.f375446a.e("GRStateActionUtils", "getContentPendingIntent with intent " + r101 + ", extras: " + r101.getExtras());
        return r101;
    }

    public static Intent c(Context r100, ObricState r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "obricState");
        Intent r102 = new Intent(r100, GRIslandReceiver.class);
        r102.setPackage(r100.getPackageName());
        r102.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r102.putExtra("live_state", -108);
        r102.putExtra("is_complex_task_scene", true);
        sea.b.f541630a.getClass();
        sea.b.f(r102, r101);
        FLogger.f375446a.e("GRStateActionUtils", "getSidecarAuthorizeIntent(), extras: " + r102.getExtras());
        return r102;
    }

    public static Intent d(Context r100, ObricState r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "obricState");
        FLogger r102 = FLogger.f375446a;
        r102.i("GRStateActionUtils", "jumpToChatPage with obricState: " + r101);
        Intent r103 = new Intent(r100, GRIslandReceiver.class);
        r103.setPackage(r100.getPackageName());
        r103.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r103.putExtra("live_state", -106);
        if (r101.getScene() != ObricInteractionScene.COMPLEX_TASK_SCENE) goto L5;
        boolean r104 = true;
    L6:
        r103.putExtra("is_complex_task_scene", r104);
        r102.e("GRStateActionUtils", "getContentPendingIntent with intent " + r103 + ", extras: " + r103.getExtras());
        return r103;
    L5:
        r104 = false;
        goto L6
    }

    public static Intent f(Context r100, boolean r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intent r103 = new Intent(r100, GRIslandReceiver.class);
        r103.setPackage(r100.getPackageName());
        r103.setAction("com.obric.assistant.obric.gr.island.pending.action");
        r103.putExtra("live_state", -107);
        r103.putExtra("auto_enter_call_user", r101);
        f513575a.getClass();
        r103.putExtra("source_from", "dynamic_island");
        sea.b.f541630a.getClass();
        sea.b.e(r103, r102);
        FLogger.f375446a.e("GRStateActionUtils", "getOAutoVirtualScreenIntent(), extras: " + r103.getExtras());
        return r103;
    }
}
