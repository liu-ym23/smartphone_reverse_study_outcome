package com.bytedance.applet.aibridge.health;

import android.app.Activity;
import android.net.Uri;
import com.bytedance.ai.api.AppletHealthService;
import f3.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nv3.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/applet/aibridge/health/AppletHealthServiceImpl;", "Lcom/bytedance/ai/api/AppletHealthService;", "<init>", "()V", "registerAIBridgeMethods", "", "consumeBusinessDeepLink", "", "activity", "Landroid/app/Activity;", "uri", "Landroid/net/Uri;", "finishAfterConsume", "huawei-health-impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletHealthServiceImpl implements AppletHealthService {
    public AppletHealthServiceImpl() {
    }

    public final void c() {
        k r0 = k.b;
        r0.b(HealthRequestFreeLoginMethod.class);
        r0.b(SyncHuaweiDataMethod.class);
    }

    public final boolean b(Activity r2, Uri r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        if (r4 == false) goto L5;
        o.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "activity");
        return o.a(r2, r3, true);
    L5:
        o.a.getClass();
        Intrinsics.checkNotNullParameter(r2, "activity");
        return o.a(r2, r3, false);
    }
}
