package no5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends XCoreBridgeMethod {
    public final String a;
    public final /* synthetic */ c b;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ e b;
        public final /* synthetic */ XBridgeMethod.Callback c;

        public a(c r1, e r2, XBridgeMethod.Callback r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            no5.a r0 = no5.a.a;
            mo5.a r1 = this.a.c;
            r0.getClass();
            HashMap<String, Serializable> r2 = no5.a.c(r1).a();
            HashMap<String, Serializable> r3 = null;
            if (TypeIntrinsics.isMutableMap(r2) == true) goto L7;
            r2 = null;
        L7:
            r3 = r2;
        L10:
            if (r3 != null) goto L12;
            r3 = new LinkedHashMap();
        L12:
            this.b.onSuccess(this.c, r3, "");
            c.b(this.a);
            return;
        L8:
            e = move-exception;
            tt5.a.i("TtsLynxViewModel", "registerTtsMethods, convert TtsLynxPlaylistParams to map error:", e);
            goto L10
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

    public e(c r1) {
        this.b = r1;
        this.a = "ccm.doc.fetchPlayList";
    }

    public final void handle(XReadableMap r2, XBridgeMethod.Callback r3, XBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        j.f(new a(this.b, this, r3));
    }
}
