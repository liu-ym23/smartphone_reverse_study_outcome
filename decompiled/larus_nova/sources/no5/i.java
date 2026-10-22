package no5;

import android.os.Build;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.canvas.KryptonCamera;
import com.ss.android.lark.utils.LarkContext;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class i extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519970a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ XReadableMap f519971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f519972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f519973c;

        public a(XReadableMap r100, i r101, XBridgeMethod.Callback r102) {
            this.f519971a = r100;
            this.f519972b = r101;
            this.f519973c = r102;
        }

        public final void a() {
            no5.a r100 = no5.a.f519907a;
            Map<String, Object> r101 = this.f519971a.toMap();
            r100.getClass();
            if (r101 != null) goto L5;
            tt5.a.k("TtsLynxModel", "dispatchVibrateAction, params is null.");
        L34:
            this.f519972b.onSuccess(this.f519973c, new LinkedHashMap(), "");
            return;
        L5:
            Object r102 = r101.get("type");
            if ((r102 instanceof String) == false) goto L8;
            String r103 = (String) r102;
        L9:
            if (r103 != null) goto L11;
            tt5.a.k("TtsLynxModel", "dispatchVibrateAction, vibrateType not found.");
            goto L34
        L11:
            StringBuilder r104 = new StringBuilder("dispatchVibrateAction, type: ");
            r104.append(r103);
            r104.append(", androidVersion: ");
            int r105 = Build.VERSION.SDK_INT;
            r104.append(r105);
            tt5.a.h("TtsLynxModel", r104.toString());
            int r106 = -1;
            if (r105 >= 29) goto L15;
            eu5.h.a(LarkContext.getApplication(), 10, -1);
            goto L34
        L15:
            switch(r103.hashCode()) {
                case -1078030475: goto L31;
                case 3535914: goto L29;
                case 99152071: goto L25;
                case 102970646: goto L21;
                case 108511787: goto L18;
                default: goto L32;
            };
        L31:
            r103.equals(KryptonCamera.Config.RESOLUTION_MEDIUM);
        L32:
            r106 = 0;
        L33:
            eu5.h.a(LarkContext.getApplication(), 10, r106);
            goto L34
        L18:
            if (r103.equals("rigid") == false) goto L32;
        L27:
            r106 = 5;
            goto L33
        L21:
            if (r103.equals("light") == false) goto L32;
            r106 = 2;
            goto L33
        L25:
            if (r103.equals("heavy") == true) goto L27;
        L29:
            if (r103.equals("soft") == true) goto L33;
        L8:
            r103 = null;
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
        this.f519970a = "ccm.impactFeedback";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f519970a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        j.f(new a(r100, this, r101));
    }
}
