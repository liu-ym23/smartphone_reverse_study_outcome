package z2;

import android.app.Activity;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class n extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f569755a;

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.bytedance.ai.applet.base.log.a.c("ai_bridge", "[EmbedWebViewService] onHideCustomView");
        this.f569755a.c();
    }

    public n(l r100) {
        this.f569755a = r100;
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r110) {
        com.bytedance.ai.applet.base.log.b r100 = com.bytedance.ai.applet.base.log.a.f34518a;
        StringBuilder r101 = new StringBuilder("[EmbedWebViewService] onPermissionRequest: ");
        if (r110 == null) goto L7;
        String[] r102 = r110.getResources();
        if (r102 == null) goto L7;
        String r103 = ArraysKt.joinToString$default(r102, null, null, null, 0, null, null, 63, null);
    L8:
        r101.append(r103);
        com.bytedance.ai.applet.base.log.a.c("ai_bridge", r101.toString());
        l r104 = this.f569755a;
        r104.getClass();
        if (r110 == null) goto L26;
        String[] r105 = r110.getResources();
        if (r105 == null) goto L15;
        List r106 = ArraysKt.toList(r105);
        if (r106 == null) goto L15;
    L17:
        if (r106.isEmpty() == false) goto L19;
        l.b(r110);
        return;
    L19:
        d r107 = r104.f569743c;
        if (r107 != null) goto L22;
        l.b(r110);
        return;
    L22:
        r107.h(r106, new e(r110), new f(r110));
        return;
    L15:
        r106 = CollectionsKt.emptyList();
        goto L17
    L26:
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        com.bytedance.ai.applet.base.log.a.c("ai_bridge", "[EmbedWebViewService] onShowCustomView");
        l r102 = this.f569755a;
        if (r100 != null) goto L8;
        r102.getClass();
        if (r101 == null) goto L36;
        r101.onCustomViewHidden();
        return;
    L36:
        return;
    L8:
        if (r102.f569748h == null) goto L11;
        if (r101 == null) goto L38;
        r101.onCustomViewHidden();
        return;
    L38:
        return;
    L11:
        Activity r103 = r102.f();
        if (r103 == null) goto L16;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L16;
        View r105 = l.a(r104);
    L18:
        if ((r105 instanceof ViewGroup) == false) goto L20;
        ViewGroup r106 = (ViewGroup) r105;
    L21:
        if (r103 == null) goto L32;
        if (r106 == null) goto L32;
        r102.f569748h = r100;
        r102.f569749i = r101;
        WebView r107 = r102.f569745e;
        int r108 = 0;
        if (r107 == null) goto L27;
        int r109 = r107.getScrollX();
    L28:
        r102.f569750j = r109;
        WebView r110 = r102.f569745e;
        if (r110 == null) goto L31;
        r108 = r110.getScrollY();
    L31:
        r102.f569751k = r108;
        r102.f569752l = Integer.valueOf(r103.getRequestedOrientation());
        r103.setRequestedOrientation(-1);
        r106.addView(r100, new ViewGroup.LayoutParams(-1, -1));
        return;
    L27:
        r109 = 0;
    L32:
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[EmbedWebViewService] cannot find decorView for custom view", null);
        if (r101 == null) goto L41;
        r101.onCustomViewHidden();
        return;
    L41:
        return;
    L20:
        r106 = null;
    L16:
        r105 = null;
        goto L18
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [z2.i] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.ArrayList] */
    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r110, final ValueCallback<Uri[]> r111, WebChromeClient.FileChooserParams r112) {
        com.bytedance.ai.applet.base.log.b r113 = com.bytedance.ai.applet.base.log.a.f34518a;
        StringBuilder r114 = new StringBuilder("[EmbedWebViewService] onShowFileChooser: mode=");
        if (r112 == null) goto L5;
        Integer r100 = Integer.valueOf(r112.getMode());
    L6:
        r114.append(r100);
        r114.append(", acceptTypes=");
        if (r112 == null) goto L11;
        String[] r101 = r112.getAcceptTypes();
        if (r101 == null) goto L11;
        String r102 = ArraysKt.joinToString$default(r101, null, null, null, 0, null, null, 63, null);
    L12:
        r114.append(r102);
        com.bytedance.ai.applet.base.log.a.c("ai_bridge", r114.toString());
        boolean r115 = false;
        if (r111 != null) goto L15;
        return false;
    L15:
        d r103 = this.f569755a.f569743c;
        if (r103 != null) goto L18;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[EmbedWebViewService] no capability, cancel file chooser", null);
        r111.onReceiveValue(null);
    L46:
        return true;
    L18:
        final AtomicBoolean r104 = new AtomicBoolean(false);
        ?? r105 = new i(r104, r111);
        if (r112 != null) goto L21;
    L23:
        boolean r116 = false;
    L24:
        if (r112 == null) goto L33;
        String[] r106 = r112.getAcceptTypes();
        if (r106 == null) goto L33;
        ?? r107 = new ArrayList();
        int r108 = r106.length;
        int r109 = 0;
    L28:
        if (r109 >= r108) goto L34;
        String r117 = r106[r109];
        Intrinsics.checkNotNull(r117);
        if ((!StringsKt.isBlank(r117)) == false) goto L32;
        r107.add(r117);
    L32:
        r109 = r109 + 1;
    L34:
        if (r112 != null) goto L36;
    L38:
        s r118 = new s(r107, r115, r116);
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L41
        r103.i(r118, new j(r105));     // Catch: Throwable -> L41
        Object r120 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L41
    L43:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
        if (r121 == null) goto L46;
        com.bytedance.ai.applet.base.log.b r122 = com.bytedance.ai.applet.base.log.a.f34518a;
        com.bytedance.ai.applet.base.log.a.b("ai_bridge", "[EmbedWebViewService] onChooseFile threw: " + r121, null);
        r105.invoke(CollectionsKt.emptyList());
    L41:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    L36:
        if (r112.isCaptureEnabled() != true) goto L38;
        r115 = true;
    L33:
        r107 = CollectionsKt.emptyList();
        goto L34
    L21:
        if (r112.getMode() != 1) goto L23;
        r116 = true;
    L11:
        r102 = null;
        goto L12
    L5:
        r100 = null;
        goto L6
    }
}
