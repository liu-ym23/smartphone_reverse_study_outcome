package com.bytedance.applet.debug;

import android.net.Uri;
import com.bytedance.ai.debug.IAISDKDebugService;
import com.bytedance.ai.utils.g;
import com.bytedance.ies.bullet.service.router.d;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.o0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AppletDebugManager {
    public static boolean a;
    public static final b b = null;

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "PreviewDebugInfo(debugInfo=" + this.a + ", debugToken=" + this.b + ')';
        }

        public a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "debugInfo");
            Intrinsics.checkNotNullParameter(r3, "debugToken");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b implements IAISDKDebugService.a {
        public b() {
        }

        public final void a() {
            boolean r0 = AppletDebugManager.a;
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AppletDebugManager$showDebugModeClosedToast$1(null), 3, null);
        }
    }

    public AppletDebugManager() {
    }

    static {
        b = new b();
    }

    public static a a(Uri r3) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        String r0 = d.a(r3, "debugInfo");
        String r4 = d.a(r3, "securityToken");
        if (o0.d(r0) == false) goto L5;
        String r1 = Uri.decode(r0);
    L7:
        if (o0.d(r4) == false) goto L9;
        String r5 = Uri.decode(r4);
    L10:
        if (r1 == null) goto L13;
        Intrinsics.checkNotNull(r5);
        return new a(r1, r5);
    L13:
        return null;
    L9:
        r5 = "";
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public static boolean b(String r9) {
        Intrinsics.checkNotNullParameter(r9, "result");
        Uri r10 = UriProtector.parse(r9);
        String r0 = d.a(r10, "short_token");
        a r1 = a(r10);
        if (Intrinsics.areEqual(r10.getScheme(), "doubaoapp") == true) goto L5;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == false) goto L13;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AppletDebugManager$isDebugMode$1(r0, r1, null), 3, null);
    L13:
        return r11;
    L5:
        if (Intrinsics.areEqual(r10.getHost(), "debug") == false) goto L10;
        if (o0.d(r0) == true) goto L9;
        if (r1 == null) goto L10;
    L9:
        r11 = true;
        goto L11
    }

    public static void c(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "packageName");
        g.a.i("AppletDebugActivity", "setDebugConfig: " + r3);
        IAISDKDebugService.a.q(r3, r4);
    }
}
