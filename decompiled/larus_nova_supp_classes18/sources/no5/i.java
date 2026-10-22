package no5;

import android.os.Build;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.docsdk.impl.document.service.ContainerThemeWebService;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends XCoreBridgeMethod {
    public final String a;

    public static final class a implements Runnable {
        public final /* synthetic */ XReadableMap a;
        public final /* synthetic */ i b;
        public final /* synthetic */ XBridgeMethod.Callback c;

        public a(XReadableMap r1, i r2, XBridgeMethod.Callback r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            no5.a r0 = no5.a.a;
            Map r1 = this.a.toMap();
            r0.getClass();
            if (r1 != null) goto L5;
            tt5.a.k("TtsLynxModel", "dispatchVibrateAction, params is null.");
        L34:
            this.b.onSuccess(this.c, new LinkedHashMap(), "");
            return;
        L5:
            Object r2 = r1.get(ResourceData.KEY_TYPE);
            if ((r2 instanceof String) == false) goto L8;
            String r3 = (String) r2;
        L9:
            if (r3 != null) goto L11;
            tt5.a.k("TtsLynxModel", "dispatchVibrateAction, vibrateType not found.");
            goto L34
        L11:
            StringBuilder r4 = new StringBuilder("dispatchVibrateAction, type: ");
            r4.append(r3);
            r4.append(", androidVersion: ");
            int r5 = Build.VERSION.SDK_INT;
            r4.append(r5);
            tt5.a.h("TtsLynxModel", r4.toString());
            int r6 = -1;
            if (r5 >= 29) goto L15;
            eu5.h.a(LarkContext.getApplication(), 10, -1);
            goto L34
        L15:
            switch(r3.hashCode()) {
                case -1078030475: goto L31;
                case 3535914: goto L29;
                case 99152071: goto L25;
                case 102970646: goto L21;
                case 108511787: goto L18;
                default: goto L32;
            };
        L31:
            r3.equals("medium");
        L32:
            r6 = 0;
        L33:
            eu5.h.a(LarkContext.getApplication(), 10, r6);
            goto L34
        L18:
            if (r3.equals("rigid") == false) goto L32;
        L27:
            r6 = 5;
            goto L33
        L21:
            if (r3.equals(ContainerThemeWebService.THEME_CONFIG_VALUE_LIGHT) == false) goto L32;
            r6 = 2;
            goto L33
        L25:
            if (r3.equals("heavy") == true) goto L27;
        L29:
            if (r3.equals("soft") == true) goto L33;
        L8:
            r3 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public i() {
        this.a = "ccm.impactFeedback";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r2, XBridgeMethod.Callback r3, XBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        j.f(new a(r2, this, r3));
    }
}
