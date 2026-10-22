package no5;

import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends XCoreBridgeMethod {
    public final String a;
    public final /* synthetic */ c b;

    public static final class a implements Runnable {
        public final /* synthetic */ c a;
        public final /* synthetic */ XReadableMap b;
        public final /* synthetic */ g c;
        public final /* synthetic */ XBridgeMethod.Callback d;

        /* JADX INFO: renamed from: no5.g$a$a, reason: collision with other inner class name */
        public static final class C0277a implements mo5.b {
            public final /* synthetic */ g a;
            public final /* synthetic */ XBridgeMethod.Callback b;

            public C0277a(g r1, XBridgeMethod.Callback r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // mo5.b
            public final void a(TtsResult r5) {
                Intrinsics.checkNotNullParameter(r5, "it");
                String r1 = "";
                if (r5.a() == false) goto L5;
                this.a.onSuccess(this.b, new LinkedHashMap(), "");
                return;
            L5:
                g r0 = this.a;
                XBridgeMethod.Callback r2 = this.b;
                int r3 = r5.a.getCodeNum();
                String r6 = r5.b;
                if (r6 == null) goto L9;
                r1 = r6;
            L9:
                r0.onFailure(r2, r3, r1, new LinkedHashMap());
            }
        }

        public a(c r1, XReadableMap r2, g r3, XBridgeMethod.Callback r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            no5.a r0 = no5.a.a;
            mo5.a r1 = this.a.c;
            Map r2 = this.b.toMap();
            C0277a r3 = new C0277a(this.c, this.d);
            r0.getClass();
            Intrinsics.checkNotNullParameter(r1, "albumVM");
            if (r2 != null) goto L5;
            tt5.a.h("TtsLynxModel", "dispatchSeekAction, params is null");
            return;
        L5:
            Object r5 = r2.get("targetSeconds");
            if ((r5 instanceof Number) == false) goto L8;
            Number r6 = (Number) r5;
        L9:
            if (r6 == null) goto L13;
            long r4 = r6.longValue() * ((long) CCMLynxCardView.ViewType.BANNER);
            tt5.a.h("TtsLynxModel", "dispatchSeekAction, target progressMs: " + r4);
            mo5.g r7 = mo5.h.e(r1);
            if (r7 == null) goto L16;
            r7.t(r4, new b(r1, r3));
            return;
        L16:
            return;
        L13:
            tt5.a.k("TtsLynxModel", "dispatchSeekAction, param 'targetSeconds' not supported: " + r2.get("targetSeconds"));
            return;
        L8:
            r6 = null;
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

    public g(c r1) {
        this.b = r1;
        this.a = "ccm.doc.seekDidFinish";
    }

    public final void handle(XReadableMap r2, XBridgeMethod.Callback r3, XBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        j.f(new a(this.b, r2, this, r3));
    }
}
