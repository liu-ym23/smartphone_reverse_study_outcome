package no5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends XCoreBridgeMethod {
    public final String a;
    public final /* synthetic */ c b;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ XReadableMap b;
        public final /* synthetic */ h c;
        public final /* synthetic */ XBridgeMethod.Callback d;

        public a(c r1, XReadableMap r2, h r3, XBridgeMethod.Callback r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            c r0 = this.a;
            this.b.getString("text");
            int r1 = this.b.getInt("width");
            int r2 = this.b.getInt("height");
            int r3 = this.b.getInt("minSize");
            int r4 = this.b.getInt("maxSize");
            float r5 = (float) this.b.getDouble("lineHeightMultiple");
            r0.q = r1;
            r0.r = r2;
            r0.s = r3;
            r0.t = r4;
            r0.u = r5;
            c.a(this.a);
            c.b(this.a);
            HashMap r6 = new HashMap();
            oo5.c r7 = this.a.e;
            if (r7 == null) goto L5;
            int r8 = r7.c;
        L6:
            r6.put("size", Integer.valueOf(r8));
            this.c.onSuccess(this.d, r6, "");
            return;
        L5:
            r8 = 0;
            goto L6
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

    public h(c r1) {
        this.b = r1;
        this.a = "ccm.doc.getFontSize";
    }

    public final void handle(XReadableMap r2, XBridgeMethod.Callback r3, XBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        j.f(new a(this.b, r2, this, r3));
    }
}
