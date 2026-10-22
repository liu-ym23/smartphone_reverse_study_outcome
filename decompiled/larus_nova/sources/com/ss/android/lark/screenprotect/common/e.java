package com.ss.android.lark.screenprotect.common;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ss.android.lark.screenprotect.userscope.ScreenProtectGlobalManager$registerVCBroadcast$2;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f439784a;

    public static final class a {
    }

    static {
    }

    public final void registerReceiver() {
        IntentFilter r100 = new IntentFilter();
        r100.addAction("action_vc_start_sharescreen");
        r100.addAction("action_vc_stop_sharescreen");
        LocalBroadcastManager.getInstance(com.larksuite.framework.utils.b.f285948a).registerReceiver((BroadcastReceiver) this.f439784a.getValue(), r100);
        ScsLogger.d("ScreenshotProtection_US", "registerReceiver: vc register done");
    }

    public e(final ScreenProtectGlobalManager$registerVCBroadcast$2.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f439784a = LazyKt.lazy(new RegisterVCBroadcast$mReceiver$2(r100));
    }
}
