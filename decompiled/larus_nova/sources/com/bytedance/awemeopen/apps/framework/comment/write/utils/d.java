package com.bytedance.awemeopen.apps.framework.comment.write.utils;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.bytedance.awemeopen.apps.framework.comment.write.utils.imm.RomUtils;
import com.bytedance.awemeopen.apps.framework.utils.d0;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f194581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f194582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f194583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f194584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f194585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f194586f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Rect f194587g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f194588h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f194589i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f194590j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f194591k;

    public interface a {
        void onClosed();

        void onOpened(int r100);
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f194592a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            super.handleMessage(r100);
            a r101 = this.f194592a.f194589i;
            if (r101 == null) goto L6;
            r101.onOpened(r100.arg1);
            return;
        }

        public b(d r100, Looper r101) {
            this.f194592a = r100;
            super(r101);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        getContentView().getWindowVisibleDisplayFrame(this.f194587g);
        AoLogger.b("write_comment", new Object[]{"KeyboardPopupWindow: layout, rectBottom=" + this.f194587g.bottom + ", scrHeight=" + this.f194584d});
        int r100 = this.f194587g.bottom;
        if (r100 <= this.f194584d) goto L5;
        this.f194584d = r100;
        AoLogger.b("write_comment", new Object[]{"KeyboardPopupWindow: scrHeight=rectBottom=" + this.f194584d});
    L5:
        int r101 = this.f194584d;
        int r102 = r101 - this.f194587g.bottom;
        if (r102 <= (((double) r101) * 0.62d)) goto L12;
        if (this.f194581a.getResources().getConfiguration().orientation == 2) goto L12;
        AoLogger.b("write_comment", new Object[]{"KeyboardPopupWindow: return kbHeight=" + r102 + ", scrHeight=" + this.f194584d});
        return;
    L12:
        if (r102 <= (this.f194584d / this.f194583c)) goto L14;
        boolean r103 = true;
    L15:
        AoLogger.b("write_comment", new Object[]{"KeyboardPopupWindow: visible=" + r103 + ", kbHeight=" + r102});
        if (r103 == false) goto L21;
        this.f194585e = true;
        if (this.f194586f == r102) goto L26;
        this.f194586f = r102;
        AoLogger.b("write_comment", new Object[]{"KeyboardPopupWindow: openKeyboardJustOnce: keyboardHeight=" + r102});
        Message r104 = this.f194588h.obtainMessage(this.f194590j);
        r104.arg1 = r102;
        this.f194588h.removeMessages(this.f194590j);
        this.f194588h.sendMessageDelayed(r104, 0);
        return;
    L26:
        return;
    L21:
        if (this.f194585e == false) goto L28;
        this.f194585e = false;
        this.f194586f = 0;
        a r105 = this.f194589i;
        if (r105 == null) goto L29;
        r105.onClosed();
        return;
    L29:
        return;
    L28:
        return;
    L14:
        r103 = false;
        goto L15
    }

    public final Context getContext() {
        return this.f194581a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v5, types: [com.bytedance.awemeopen.apps.framework.comment.write.utils.c] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.Process] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public d(Context r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "anchorView");
        this.f194581a = r100;
        this.f194582b = r101;
        this.f194583c = 6;
        this.f194584d = d0.c(r100);
        this.f194587g = new Rect();
        this.f194588h = new b(this, Looper.getMainLooper());
        ?? r102 = 3;
        if (RomUtils.f194593a != 3) goto L32;
        ?? r103 = 0;
        String r104 = null;
        r104 = null;
        r104 = null;
        r102 = RomUtils.a(Runtime.getRuntime(), "getprop ro.miui.ui.version.name");     // Catch: Throwable -> L17 IOException -> L19
    L57:
        BufferedReader r105 = new BufferedReader(new InputStreamReader(r102.getInputStream()), 1024);     // Catch: Throwable -> L14 IOException -> L16
        String r106 = r105.readLine();     // Catch: IOException -> L44 Throwable -> L36
        r105.close();     // Catch: IOException -> L44 Throwable -> L36
        r102.destroy();
        r105.close();     // Catch: IOException -> L12
    L13:
        r104 = r106;
    L27:
        if (TextUtils.isEmpty(r104) == true) goto L30;
        int r107 = 1;
    L31:
        RomUtils.f194593a = r107;
        goto L32
    L30:
        r107 = 2;
    L21:
        if (r102 == 0) goto L23;
        r102.destroy();
    L23:
        if (r105 == null) goto L27;
        r105.close();     // Catch: IOException -> L26
        goto L27
    L16:
        r105 = null;
    L14:
        Throwable th10 = th;
        r105 = null;
        ?? r108 = r102;
    L38:
        r103 = r108;
        th = th10;
    L39:
        if (r103 == 0) goto L41;
        r103.destroy();
    L41:
        if (r105 != null) goto L46;
    L43:
        throw th;
    L46:
        r105.close();     // Catch: IOException -> L45
    L36:
        th = move-exception;
        th10 = th;
        r108 = r102;
    L19:
        r102 = 0;
        r105 = null;
    L17:
        th = th;
        r105 = null;
    L32:
        this.f194590j = 1;
        this.f194591k = new c(this);
        setContentView(new View(this.f194581a));
        setWidth(0);
        setHeight(-1);
        setBackgroundDrawable(new ColorDrawable(0));
        setSoftInputMode(16);
        setInputMethodMode(1);
        if (Build.VERSION.SDK_INT < 23) goto L59;
        setWindowLayoutType(1003);
        return;
    }
}
