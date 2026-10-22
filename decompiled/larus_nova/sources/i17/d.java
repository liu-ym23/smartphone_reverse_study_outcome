package i17;

import com.bytedance.lynx.webview.glue.ITTWebViewPluginInvoker;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import l17.i;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements ITTWebViewPluginInvoker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Method> f488008b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f488009a;

    static {
        f488008b = i.a(d.class, "com.bytedance.webview.chromium.plugin.TTWebPluginInvoker");
    }

    public d(Object r100) {
        this.f488009a = r100;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.ITTWebViewPluginInvokerSdk112
    public Object query(String r100) {
        Method r101 = (Method) ((HashMap) f488008b).get("query");
        Object r102 = this.f488009a;
        if (r102 == null) goto L8;
        if (r101 != null) goto L11;
        return null;
    L11:
        return r101.invoke(r102, new Object[]{r100});
    L14:
        return null;
    L8:
        return null;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.ITTWebViewPluginInvokerSdk112
    public final boolean inform(String r100, Object r101) {
        Method r102 = (Method) ((HashMap) f488008b).get("inform");
        Object r103 = this.f488009a;
        if (r103 == null) goto L8;
        if (r102 == null) goto L8;
        return ((Boolean) r102.invoke(r103, new Object[]{r100, r101})).booleanValue();
    L8:
        return false;
    }
}
