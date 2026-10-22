package no5;

import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.util.ui.j;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f519957b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f519958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XReadableMap f519959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f519960c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f519961d;

        /* JADX INFO: renamed from: no5.g$a$a, reason: collision with other inner class name */
        public static final class C6953a implements mo5.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ g f519962a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ XBridgeMethod.Callback f519963b;

            public C6953a(g r100, XBridgeMethod.Callback r101) {
                this.f519962a = r100;
                this.f519963b = r101;
            }

            @Override // mo5.b
            public final void a(TtsResult r100) {
                Intrinsics.checkNotNullParameter(r100, "it");
                String r101 = "";
                if (r100.a() == false) goto L5;
                this.f519962a.onSuccess(this.f519963b, new LinkedHashMap(), "");
                return;
            L5:
                g r102 = this.f519962a;
                XBridgeMethod.Callback r103 = this.f519963b;
                int r104 = r100.f239451a.getCodeNum();
                String r105 = r100.f239452b;
                if (r105 == null) goto L9;
                r101 = r105;
            L9:
                r102.onFailure(r103, r104, r101, new LinkedHashMap());
            }
        }

        public a(c r100, XReadableMap r101, g r102, XBridgeMethod.Callback r103) {
            this.f519958a = r100;
            this.f519959b = r101;
            this.f519960c = r102;
            this.f519961d = r103;
        }

        public final void a() {
            no5.a r100 = no5.a.f519907a;
            mo5.a r101 = this.f519958a.f519915c;
            Map<String, Object> r102 = this.f519959b.toMap();
            C6953a r103 = new C6953a(this.f519960c, this.f519961d);
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "albumVM");
            if (r102 != null) goto L5;
            tt5.a.h("TtsLynxModel", "dispatchSeekAction, params is null");
            return;
        L5:
            Object r104 = r102.get("targetSeconds");
            if ((r104 instanceof Number) == false) goto L8;
            Number r105 = (Number) r104;
        L9:
            if (r105 == null) goto L13;
            long r106 = r105.longValue() * ((long) 1000);
            tt5.a.h("TtsLynxModel", "dispatchSeekAction, target progressMs: " + r106);
            mo5.g r107 = mo5.h.e(r101);
            if (r107 == null) goto L16;
            r107.t(r106, new b(r101, r103));
            return;
        L16:
            return;
        L13:
            tt5.a.k("TtsLynxModel", "dispatchSeekAction, param 'targetSeconds' not supported: " + r102.get("targetSeconds"));
            return;
        L8:
            r105 = null;
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

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f519956a;
    }

    public g(c r100) {
        this.f519957b = r100;
        this.f519956a = "ccm.doc.seekDidFinish";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        j.f(new a(this.f519957b, r100, this, r101));
    }
}
