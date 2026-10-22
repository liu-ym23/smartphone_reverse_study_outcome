package sv3;

import android.app.Dialog;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ f(Function0 r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r0 = this.a;
        Function1 r1 = this.b;
        if (((Boolean) r0.invoke()).booleanValue() == false) goto L18;
        WeakReference<Dialog> r2 = com.bytedance.applet.aibridge.navi.picker.a.a;
        WeakReference<Dialog> r3 = com.bytedance.applet.aibridge.navi.picker.a.a;
        if (r3 == null) goto L7;
        Dialog r4 = r3.get();
    L8:
        com.bytedance.applet.aibridge.navi.picker.a.a = null;
        Function2<? super String, ? super Integer, Unit> r5 = com.bytedance.applet.aibridge.navi.picker.a.b;
        com.bytedance.applet.aibridge.navi.picker.a.b = null;
        if (r4 != null) goto L11;
    L17:
        com.bytedance.applet.aibridge.navi.picker.a.b(r5, null, null);
    L19:
        boolean r6 = false;
    L27:
        r1.invoke(Boolean.valueOf(r6));     // Catch: RuntimeException -> L22
        return;
    L22:
        e = move-exception;
        int r7 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("nav_map_popup_mgr", "close: onClosed callback threw [" + e.getClass().getSimpleName() + "]: " + e.getMessage(), e);
        return;
    L11:
        if (r4.isShowing() == false) goto L17;
        com.bytedance.applet.aibridge.navi.picker.a.a(r4);     // Catch: RuntimeException -> L14
    L16:
        com.bytedance.applet.aibridge.navi.picker.a.b(r5, null, null);
        com.larus.navigation.api.c.d("nav_map_popup_mgr", "internalClose: dismissed (reason=explicit_close)");
        r6 = true;
    L14:
        e = move-exception;
        int r8 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("nav_map_popup_mgr", "dismiss failed [" + e.getClass().getSimpleName() + "]: " + e.getMessage(), e);
        goto L16
    L7:
        r4 = null;
        goto L8
    L18:
        com.larus.navigation.api.c.d("nav_map_popup_mgr", "close: request superseded before main-thread dismissal");
        goto L19
    }
}
