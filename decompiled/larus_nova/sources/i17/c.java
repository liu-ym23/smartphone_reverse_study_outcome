package i17;

import android.os.Bundle;
import com.bytedance.lynx.webview.glue.ITTWebPluginManager;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import l17.i;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements ITTWebPluginManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Method> f488006b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f488007a;

    static {
        f488006b = i.a(c.class, "com.bytedance.webview.chromium.plugin.TTWebPluginManager");
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ITTWebPluginManagersdk113
    public final int getMaxAllowPreCreate() {
        Method r100 = (Method) ((HashMap) f488006b).get("getMaxAllowPreCreate");
        Object r101 = this.f488007a;
        if (r101 == null) goto L7;
        if (r100 == null) goto L7;
        return ((Integer) r100.invoke(r101, new Object[0])).intValue();
    L7:
        return 0;
    }

    public c(Object r100) {
        this.f488007a = r100;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ITTWebPluginManagersdk113
    public final void destroyPreCreatePlugin(int r100) {
        Method r101 = (Method) ((HashMap) f488006b).get("destroyPreCreatePlugin");
        Object r102 = this.f488007a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{Integer.valueOf(r100)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ITTWebPluginManagersdk113
    public final void registerListener(Object r100) {
        Method r101 = (Method) ((HashMap) f488006b).get("registerListener");
        Object r102 = this.f488007a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ITTWebPluginManagersdk113
    public final void setMaxAllowPreCreate(int r100) {
        Method r101 = (Method) ((HashMap) f488006b).get("setMaxAllowPreCreate");
        Object r102 = this.f488007a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{Integer.valueOf(r100)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ITTWebPluginManagersdk113
    public final void unregisterListener(Object r100) {
        Method r101 = (Method) ((HashMap) f488006b).get("unregisterListener");
        Object r102 = this.f488007a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{r100});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.ITTWebPluginManager
    public final void registerListener(ITTWebPluginManager.Listener r100) {
        registerListener(r100);
    }

    @Override // com.bytedance.lynx.webview.glue.ITTWebPluginManager
    public final void unregisterListener(ITTWebPluginManager.Listener r100) {
        unregisterListener(r100);
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ITTWebPluginManagersdk113
    public final boolean execute(String r100, Bundle r101) {
        Method r102 = (Method) ((HashMap) f488006b).get("execute");
        Object r103 = this.f488007a;
        if (r103 == null) goto L8;
        if (r102 == null) goto L8;
        return ((Boolean) r102.invoke(r103, new Object[]{r100, r101})).booleanValue();
    L8:
        return false;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ITTWebPluginManagersdk113
    public final int preCreatePlugin(String r100, String r101) {
        if (r100 != null) goto L4;
        return -1;
    L4:
        if (r100.isEmpty() == true) goto L21;
        Method r102 = (Method) ((HashMap) f488006b).get("preCreatePlugin");
        Object r103 = this.f488007a;
        if (r103 == null) goto L12;
        if (r102 != null) goto L17;
        return -2;
    L17:
        return ((Integer) r102.invoke(r103, new Object[]{r100, r101})).intValue();
    L20:
        return -2;
    L12:
        return -2;
    L21:
        return -1;
    }
}
