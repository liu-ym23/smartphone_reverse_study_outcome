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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {
    public final Context a;
    public final View b;
    public final int c;
    public int d;
    public boolean e;
    public int f;
    public final Rect g;
    public final b h;
    public a i;
    public final int j;
    public final c k;

    public interface a {
        void onClosed();

        void onOpened(int r1);
    }

    public static final class b extends Handler {
        public final /* synthetic */ d a;

        @Override // android.os.Handler
        public final void handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            super.handleMessage(r2);
            a r0 = this.a.i;
            if (r0 == null) goto L6;
            r0.onOpened(r2.arg1);
            return;
        }

        public b(d r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        getContentView().getWindowVisibleDisplayFrame(this.g);
        AoLogger.b("write_comment", new Object[]{"KeyboardPopupWindow: layout, rectBottom=" + this.g.bottom + ", scrHeight=" + this.d});
        int r1 = this.g.bottom;
        if (r1 <= this.d) goto L5;
        this.d = r1;
        AoLogger.b("write_comment", new Object[]{"KeyboardPopupWindow: scrHeight=rectBottom=" + this.d});
    L5:
        int r2 = this.d;
        int r5 = r2 - this.g.bottom;
        if (r5 <= (((double) r2) * 0.62d)) goto L12;
        if (this.a.getResources().getConfiguration().orientation == 2) goto L12;
        AoLogger.b("write_comment", new Object[]{"KeyboardPopupWindow: return kbHeight=" + r5 + ", scrHeight=" + this.d});
        return;
    L12:
        if (r5 <= (this.d / this.c)) goto L14;
        boolean r3 = true;
    L15:
        AoLogger.b("write_comment", new Object[]{"KeyboardPopupWindow: visible=" + r3 + ", kbHeight=" + r5});
        if (r3 == false) goto L21;
        this.e = true;
        if (this.f == r5) goto L26;
        this.f = r5;
        AoLogger.b("write_comment", new Object[]{"KeyboardPopupWindow: openKeyboardJustOnce: keyboardHeight=" + r5});
        Message r0 = this.h.obtainMessage(this.j);
        r0.arg1 = r5;
        this.h.removeMessages(this.j);
        this.h.sendMessageDelayed(r0, 0);
        return;
    L26:
        return;
    L21:
        if (this.e == false) goto L28;
        this.e = false;
        this.f = 0;
        a r4 = this.i;
        if (r4 == null) goto L29;
        r4.onClosed();
        return;
    L29:
        return;
    L28:
        return;
    L14:
        r3 = false;
        goto L15
    }

    public final Context getContext() {
        return this.a;
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
    public d(Context r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "anchorView");
        this.a = r5;
        this.b = r6;
        this.c = 6;
        this.d = d0.c(r5);
        this.g = new Rect();
        this.h = new b(this, Looper.getMainLooper());
        ?? r7 = 3;
        if (RomUtils.a != 3) goto L32;
        ?? r8 = 0;
        String r9 = null;
        r9 = null;
        r9 = null;
        r7 = RomUtils.a(Runtime.getRuntime(), "getprop ro.miui.ui.version.name");     // Catch: Throwable -> L17 IOException -> L19
    L57:
        BufferedReader r1 = new BufferedReader(new InputStreamReader(r7.getInputStream()), 1024);     // Catch: Throwable -> L14 IOException -> L16
        String r2 = r1.readLine();     // Catch: IOException -> L44 Throwable -> L36
        r1.close();     // Catch: IOException -> L44 Throwable -> L36
        r7.destroy();
        r1.close();     // Catch: IOException -> L12
    L13:
        r9 = r2;
    L27:
        if (TextUtils.isEmpty(r9) == true) goto L30;
        int r10 = 1;
    L31:
        RomUtils.a = r10;
        goto L32
    L30:
        r10 = 2;
    L21:
        if (r7 == 0) goto L23;
        r7.destroy();
    L23:
        if (r1 == null) goto L27;
        r1.close();     // Catch: IOException -> L26
        goto L27
    L16:
        r1 = null;
    L14:
        Throwable th = th;
        r1 = null;
        ?? r11 = r7;
    L38:
        r8 = r11;
        th = th;
    L39:
        if (r8 == 0) goto L41;
        r8.destroy();
    L41:
        if (r1 != null) goto L46;
    L43:
        throw th;
    L46:
        r1.close();     // Catch: IOException -> L45
    L36:
        th = move-exception;
        th = th;
        r11 = r7;
    L19:
        r7 = 0;
        r1 = null;
    L17:
        th = th;
        r1 = null;
    L32:
        this.j = 1;
        this.k = new c(this);
        setContentView(new View(this.a));
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
