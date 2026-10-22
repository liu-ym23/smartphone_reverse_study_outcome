package com.bytedance.ee.bear.clip;

import android.webkit.WebView;
import com.bytedance.ee.bear.clip.handlers.ClipFetchHandler;
import com.bytedance.ee.bear.clip.handlers.ClipToastHandler;
import com.bytedance.ee.larkwebview.base.LarkWebView;
import com.bytedance.ee.util.io.FileUtils;
import com.larksuite.component.universe_design.toast.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements bw4.b {

    public static final class a {
    }

    static {
    }

    @Override // bw4.b
    public final long b() {
        long r0 = FileUtils.B(com.bytedance.ee.bear.clip.a.a(null).toFile().getVfsPath());
        tt5.a.h("DocsClip#ClipJsFileManager", "getCleanableSize: " + r0);
        return r0;
    }

    @Override // bw4.b
    public final void a() {
        String r0 = com.bytedance.ee.bear.clip.a.a;
        tt5.a.h("DocsClip#ClipJsFileManager", "cleanCache");
        if (com.suite.lark.component.storage.ext.b.b(com.bytedance.ee.bear.clip.a.a(null).toFile().getVfsPath()) == false) goto L12;
        FileUtils.c(com.bytedance.ee.bear.clip.a.a(null).toFile().getVfsPath());     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        tt5.a.e("DocsClip#ClipJsFileManager", "cleanCache error", th, false);
        return;
    }

    public b() {
        tt5.a.h("DocsClip#ClipService", "ClipService init");
    }

    @Override // bw4.b
    public final void stopClip(WebView r5) {
        Intrinsics.checkNotNullParameter(r5, "webView");
        if ((r5 instanceof LarkWebView) == true) goto L6;
        tt5.a.d("DocsClip#ClipService", "stopClip()... webView is not LarkWebView, so return");
        return;
    L6:
        Map<String, WeakReference<ClipExecutor>> r1 = ClipExecutor.h;
        LarkWebView r6 = (LarkWebView) r5;
        Intrinsics.checkNotNullParameter(r6, "webView");
        String r7 = Integer.toHexString(r6.hashCode());
        WeakReference r8 = (WeakReference) ((LinkedHashMap) ClipExecutor.h).get(r7);
        if (r8 == null) goto L45;
        ClipExecutor r9 = (ClipExecutor) r8.get();
        if (r9 == null) goto L47;
        tt5.a.h("DocsClip#ClipExecutor", "stopClip");
        boolean r0 = false;
        r9.e = false;
        ClipToastHandler r2 = r9.f;
        if (r2 == null) goto L39;
        WeakReference<c> r3 = r2.b;
        if (r3 == null) goto L19;
        c r4 = r3.get();
        if (r4 == null) goto L19;
        if (r4.isShowing() != true) goto L19;
        boolean r10 = true;
    L20:
        if (r10 == false) goto L26;
        WeakReference<c> r11 = r2.b;
        if (r11 == null) goto L26;
        c r12 = r11.get();
        if (r12 == null) goto L26;
        r12.cancel();
    L26:
        WeakReference<c> r13 = r2.a;
        if (r13 == null) goto L33;
        c r14 = r13.get();
        if (r14 == null) goto L33;
        if (r14.isShowing() != true) goto L33;
        r0 = true;
    L33:
        if (r0 == false) goto L39;
        WeakReference<c> r16 = r2.a;
        if (r16 == null) goto L39;
        c r17 = r16.get();
        if (r17 == null) goto L39;
        r17.cancel();
    L19:
        r10 = false;
    L39:
        ClipFetchHandler r18 = r9.g;
        if (r18 == null) goto L48;
        Iterator r19 = new ArrayList(r18.c).iterator();
    L43:
        if (r19.hasNext() == false) goto L49;
        ((Call) r19.next()).cancel();
        goto L43
    L49:
        return;
    L48:
        return;
    L47:
        return;
    }

    @Override // bw4.b
    public final void clip(WebView r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "webView");
        if ((r9 instanceof LarkWebView) == true) goto L7;
        tt5.a.d("DocsClip#ClipService", "clip()... webView is not LarkWebView, so return");
        return;
    L7:
        if (r10 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L16;
        tt5.a.d("DocsClip#ClipService", "url is empty! url = " + r10);
        return;
    L16:
        Map<String, WeakReference<ClipExecutor>> r2 = ClipExecutor.h;
        LarkWebView r11 = (LarkWebView) r9;
        Intrinsics.checkNotNullParameter(r11, "webView");
        Intrinsics.checkNotNullParameter(r10, "url");
        Iterator r0 = ((LinkedHashMap) ClipExecutor.h).entrySet().iterator();
    L18:
        if (r0.hasNext() == false) goto L22;
        Map.Entry r3 = (Map.Entry) r0.next();
        if (((WeakReference) r3.getValue()).get() != null) goto L18;
        tt5.a.h("DocsClip#ClipExecutor", "recycle, key = " + ((String) r3.getKey()));
        r0.remove();
        goto L18
    L22:
        String r1 = Integer.toHexString(r11.hashCode());
        Map<String, WeakReference<ClipExecutor>> r5 = ClipExecutor.h;
        WeakReference r6 = (WeakReference) ((LinkedHashMap) r5).get(r1);
        if (r6 == null) goto L25;
        ClipExecutor r7 = (ClipExecutor) r6.get();
    L26:
        if (r7 != null) goto L28;
        ClipExecutor r8 = new ClipExecutor(r11, r10);
        r5.put(r1, new WeakReference(r8));
    L30:
        if (r8.e == false) goto L32;
        tt5.a.k("DocsClip#ClipExecutor", "already in clip!");
        return;
    L32:
        r8.d = false;
        r8.e = true;
        r8.a.getBridge().a("checkJsReady", null, new bw4.a(r8));     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        tt5.a.e("DocsClip#ClipExecutor", "call checkJsReady exception", th, false);
        r8.b();
        return;
    L28:
        Object r12 = r6.get();
        Intrinsics.checkNotNull(r12);
        ClipExecutor r13 = (ClipExecutor) r12;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r13.b = r10;
        Object r14 = r6.get();
        Intrinsics.checkNotNull(r14);
        r8 = (ClipExecutor) r14;
        goto L30
    L25:
        r7 = null;
        goto L26
    L9:
        if (r10.length() == 0) goto L12;
        r4 = false;
        goto L13
    }
}
