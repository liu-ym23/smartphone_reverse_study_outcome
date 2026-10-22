package no5;

import com.bytedance.ee.util.ui.j;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class h extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f519965b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f519966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XReadableMap f519967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f519968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f519969d;

        public a(c r100, XReadableMap r101, h r102, XBridgeMethod.Callback r103) {
            this.f519966a = r100;
            this.f519967b = r101;
            this.f519968c = r102;
            this.f519969d = r103;
        }

        public final void a() {
            c r100 = this.f519966a;
            this.f519967b.getString("text");
            int r101 = this.f519967b.getInt("width");
            int r102 = this.f519967b.getInt("height");
            int r103 = this.f519967b.getInt("minSize");
            int r104 = this.f519967b.getInt("maxSize");
            float r105 = (float) this.f519967b.getDouble("lineHeightMultiple");
            r100.f519929q = r101;
            r100.f519930r = r102;
            r100.f519931s = r103;
            r100.f519932t = r104;
            r100.f519933u = r105;
            c.a(this.f519966a);
            c.b(this.f519966a);
            HashMap r106 = new HashMap();
            oo5.c r107 = this.f519966a.f519917e;
            if (r107 == null) goto L5;
            int r108 = r107.f524597c;
        L6:
            r106.put("size", Integer.valueOf(r108));
            this.f519968c.onSuccess(this.f519969d, r106, "");
            return;
        L5:
            r108 = 0;
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

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f519964a;
    }

    public h(c r100) {
        this.f519965b = r100;
        this.f519964a = "ccm.doc.getFontSize";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        j.f(new a(this.f519965b, r100, this, r101));
    }
}
