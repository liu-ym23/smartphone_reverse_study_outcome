package sv3;

import android.app.Dialog;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f543648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f543649b;

    public /* synthetic */ f(Function0 r100, Function1 r101) {
        this.f543648a = r100;
        this.f543649b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r100 = this.f543648a;
        Function1 r101 = this.f543649b;
        if (((Boolean) r100.invoke()).booleanValue() == false) goto L18;
        WeakReference<Dialog> r102 = com.bytedance.applet.aibridge.navi.picker.a.f191270a;
        WeakReference<Dialog> r103 = com.bytedance.applet.aibridge.navi.picker.a.f191270a;
        if (r103 == null) goto L7;
        Dialog r104 = r103.get();
    L8:
        com.bytedance.applet.aibridge.navi.picker.a.f191270a = null;
        Function2<? super String, ? super Integer, Unit> r105 = com.bytedance.applet.aibridge.navi.picker.a.f191271b;
        com.bytedance.applet.aibridge.navi.picker.a.f191271b = null;
        if (r104 != null) goto L11;
    L17:
        com.bytedance.applet.aibridge.navi.picker.a.b(r105, null, null);
    L19:
        boolean r106 = false;
    L27:
        r101.invoke(Boolean.valueOf(r106));     // Catch: RuntimeException -> L22
        return;
    L22:
        e = move-exception;
        int r107 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("nav_map_popup_mgr", "close: onClosed callback threw [" + e.getClass().getSimpleName() + "]: " + e.getMessage(), e);
        return;
    L11:
        if (r104.isShowing() == false) goto L17;
        com.bytedance.applet.aibridge.navi.picker.a.a(r104);     // Catch: RuntimeException -> L14
    L16:
        com.bytedance.applet.aibridge.navi.picker.a.b(r105, null, null);
        com.larus.navigation.api.c.d("nav_map_popup_mgr", "internalClose: dismissed (reason=explicit_close)");
        r106 = true;
    L14:
        e = move-exception;
        int r108 = com.larus.navigation.api.c.f359656a;
        com.larus.navigation.api.c.c("nav_map_popup_mgr", "dismiss failed [" + e.getClass().getSimpleName() + "]: " + e.getMessage(), e);
        goto L16
    L7:
        r104 = null;
        goto L8
    L18:
        com.larus.navigation.api.c.d("nav_map_popup_mgr", "close: request superseded before main-thread dismissal");
        goto L19
    }
}
