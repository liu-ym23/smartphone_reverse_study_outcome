package com.ss.android.lark.screenprotect.legacy;

import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Deprecated(message = "no need for user scope")
public final class RegisterVCBroadcast {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AnonymousClass1 f439787a;

    static {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.screenprotect.legacy.RegisterVCBroadcast$registerReceiver$1] */
    public final void registerReceiver() {
        if (f439787a != null) goto L6;
        f439787a = new AnonymousClass1();
        IntentFilter r100 = new IntentFilter();
        r100.addAction("action_vc_start_sharescreen");
        r100.addAction("action_vc_stop_sharescreen");
        LocalBroadcastManager r101 = LocalBroadcastManager.getInstance(com.larksuite.framework.utils.b.f285948a);
        AnonymousClass1 r102 = f439787a;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        r101.registerReceiver(r102, r100);
        ScsLogger.d("ScreenshotProtection", "registerReceiver: vc register done");
        return;
    }
}
