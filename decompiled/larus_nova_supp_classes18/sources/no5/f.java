package no5;

import android.content.Context;
import com.bytedance.ee.bear.tts.lynx.bean.TtsLynxPlayerAction;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.utils.LarkContext;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f extends XCoreBridgeMethod {
    public final String a;
    public final /* synthetic */ c b;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ XReadableMap b;
        public final /* synthetic */ f c;
        public final /* synthetic */ XBridgeMethod.Callback d;

        public a(c r1, XReadableMap r2, f r3, XBridgeMethod.Callback r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            no5.a r0 = no5.a.a;
            c r1 = this.a;
            Context r2 = r1.b;
            mo5.a r3 = r1.c;
            Map r4 = this.b.toMap();
            r0.getClass();
            if (r4 != null) goto L5;
            tt5.a.h("TtsLynxModel", "dispatchPlayerAction, params is null");
        L36:
            this.c.onSuccess(this.d, new LinkedHashMap(), "");
            return;
        L5:
            Object r5 = r4.get("action");
            String r6 = null;
            if ((r5 instanceof Integer) == false) goto L8;
            Integer r7 = (Integer) r5;
        L9:
            if (r7 == null) goto L35;
            int r8 = r7.intValue();
            TtsLynxPlayerAction.Companion.getClass();
            TtsLynxPlayerAction[] r9 = TtsLynxPlayerAction.values();
            int r10 = r9.length;
            int r11 = 0;
        L11:
            if (r11 >= r10) goto L19;
            TtsLynxPlayerAction r12 = r9[r11];
            if (r12.getValue() != r8) goto L15;
            boolean r13 = true;
        L16:
            if (r13 == true) goto L20;
            r11 = r11 + 1;
        L20:
            if (r12 == null) goto L35;
            po5.a r14 = no5.a.b.get(r12);
            if (r14 == null) goto L25;
            Object r15 = r4.get(ResourceData.KEY_TOKEN);
            if (r15 != null) goto L32;
        L34:
            tt5.a.h("TtsLynxModel", "dispatchPlayerAction, passedToken: " + du5.b.i(r6) + ", albumVM: " + r3 + ", action: " + r12 + ", command: " + r14 + ", result: " + r14.a(r3, r4));
            goto L36
        L32:
            if ((r15 instanceof String) == false) goto L34;
            r6 = (String) r15;
            goto L34
        L25:
            if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L28;
            tt5.a.h("TtsLynxModel", "dispatchPlayerAction, TtsLynxPlayerAction can't be handled: " + r12);
            goto L36
        L28:
            throw new IllegalStateException("TtsLynxPlayerAction can't be handled: " + r12);
        L15:
            r13 = false;
            goto L16
        L19:
            r12 = null;
        L35:
            tt5.a.h("TtsLynxModel", "dispatchPlayerAction, param 'action' not supported: " + r4.get("action"));
            goto L36
        L8:
            r7 = null;
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

    public final String getName() {
        return this.a;
    }

    public f(c r1) {
        this.b = r1;
        this.a = "ccm.doc.playerAction";
    }

    public final void handle(XReadableMap r2, XBridgeMethod.Callback r3, XBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        j.f(new a(this.b, r2, this, r3));
    }
}
