package i17;

import com.bytedance.lynx.webview.glue.TTWebViewSettings;
import com.bytedance.lynx.webview.glue.TextSelectedEventListener;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import l17.i;

/* JADX INFO: loaded from: classes21.dex */
public final class e extends TTWebViewSettings {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Method> f488010b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f488011a;

    static {
        f488010b = i.a(TTWebViewSettings.class, "com.bytedance.webview.chromium.glue.TTWebViewSettings");
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.ITTWebViewSettingssdk112
    public final void clearAllActionModeMenuItems() {
        Method r100 = (Method) ((HashMap) f488010b).get("clearAllActionModeMenuItems");
        Object r101 = this.f488011a;
        if (r101 == null) goto L11;
        if (r100 != null) goto L9;
        return;
    L9:
        r100.invoke(r101, new Object[0]);     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    public e(Object r100) {
        this.f488011a = null;
        this.f488011a = r100;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.ITTWebViewSettingssdk113
    public final void setAcceptCookie(boolean r100) {
        Method r101 = (Method) ((HashMap) f488010b).get("setAcceptCookie");
        Object r102 = this.f488011a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{Boolean.valueOf(r100)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ITTWebViewSettingssdk111
    public final void setDisabledActionModeMenuItems(int r100) {
        Method r101 = (Method) ((HashMap) f488010b).get("setDisabledActionModeMenuItems");
        Object r102 = this.f488011a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{Integer.valueOf(r100)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.ITTWebViewSettingssdk112
    public final void setIsNeedShowActionMode(boolean r100) {
        Method r101 = (Method) ((HashMap) f488010b).get("setIsNeedShowActionMode");
        Object r102 = this.f488011a;
        if (r102 == null) goto L11;
        if (r101 != null) goto L9;
        return;
    L9:
        r101.invoke(r102, new Object[]{Boolean.valueOf(r100)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ITTWebViewSettingssdk111
    public final void addActionModeMenuItem(String r100, TextSelectedEventListener r101) {
        addActionModeMenuItem(r100, r101, -1);
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ITTWebViewSettingssdk111
    public final void addActionModeMenuItem(String r100, Object r101, int r102) {
        Method r103 = (Method) ((HashMap) f488010b).get("addActionModeMenuItem");
        Object r104 = this.f488011a;
        if (r104 == null) goto L11;
        if (r103 != null) goto L9;
        return;
    L9:
        r103.invoke(r104, new Object[]{r100, r101, Integer.valueOf(r102)});     // Catch: Exception -> L8
        return;
    L13:
        return;
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.ITTWebViewSettingssdk111
    public final void addActionModeMenuItem(String r100, TextSelectedEventListener r101, int r102) {
        addActionModeMenuItem(r100, r101, r102);
    }
}
