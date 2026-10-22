package l5;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ai.applet.render.core.lynx.LynxAIBridgePort;
import com.bytedance.ai.applet.render.core.web.WebViewAIBridgePort;
import com.bytedance.ai.bridge.protocol.WorkerAIBridgePort;
import com.bytedance.ai.monitor.bridge.TraceType;
import java.util.LinkedHashMap;
import java.util.Map;
import m5.b1;
import m5.h1;

/* JADX INFO: loaded from: classes43.dex */
public final class a0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f507364h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h1 f507365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1 f507366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f507367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f507368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f507369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TraceType f507370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f507371g;

    public static final class a {
        public static String a(m4.c r100) {
            if ((r100 instanceof WebViewAIBridgePort) == false) goto L5;
        L11:
            return GXTemplateKey.GAIAX_JS;
        L5:
            if ((r100 instanceof WorkerAIBridgePort) == true) goto L11;
            if ((r100 instanceof LynxAIBridgePort) == false) goto L10;
            return "lynx";
        L10:
            return "null";
        }
    }

    static {
    }

    public a0() {
        this.f507365a = new h1();
        this.f507366b = new b1();
        this.f507369e = new LinkedHashMap();
        this.f507370f = TraceType.NONE;
    }
}
