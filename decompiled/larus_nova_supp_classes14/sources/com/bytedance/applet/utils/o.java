package com.bytedance.applet.utils;

import com.bytedance.ai.api.OperateResult;
import com.bytedance.applet.impl.l1;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.g0;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o {
    public static long a;
    public static WeakReference<g0> b;
    public static Job c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[OperateResult.values().length];
            r0[OperateResult.CANCEL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[OperateResult.REJECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[OperateResult.SUCCESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class b implements f09.a.b {
        public b() {
        }

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
        }

        public final void onAppForeground() {
            Job r0 = o.c;
            if (r0 == null) goto L5;
            r0.start();
        L5:
            o.c = null;
        }
    }

    static {
        a = -1;
        b r0 = new b();
        AppHost.a.a().j(r0);
    }

    public static void a(com.bytedance.ai.api.p r13, Map r14, boolean r15, String r16, l1 r17) {
        Intrinsics.checkNotNullParameter(r13, "config");
        Intrinsics.checkNotNullParameter(r14, "traceInfo");
        Intrinsics.checkNotNullParameter(r17, "callback");
        FLogger.a.i("FirstPartyAuthManager", "requestFirstPartyAuth, isMiniApplication:" + r15 + ", requiredScope:" + r16 + ", optionalScope:null");
        c = BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getMain(), CoroutineStart.LAZY, new MiniApplicationAuthManager$requestFirstPartyAuth$1(r13, r14, r15, r16, null, r17, null));
        if (AppHost.a.a().isAppBackground() == true) goto L9;
        Job r0 = c;
        if (r0 == null) goto L7;
        r0.start();
    L7:
        c = null;
        return;
    }
}
