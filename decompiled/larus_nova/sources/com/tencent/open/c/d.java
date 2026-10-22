package com.tencent.open.c;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.tencent.open.log.SLog;
import com.tencent.open.web.security.SecureJsInterface;

/* JADX INFO: loaded from: classes31.dex */
public class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f461748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private KeyEvent f461749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.tencent.open.web.security.a f461750c;

    public d(Context r100) {
        super(r100);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent r100) {
        SLog.d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f461748a);
        if (f461748a == true) goto L7;
        return super.dispatchKeyEvent(r100);
    L7:
        if (r100.getAction() != 0) goto L39;
        int r101 = r100.getKeyCode();
        if (r101 == 4) goto L37;
        if (r101 == 66) goto L35;
        if (r101 != 67) goto L15;
        com.tencent.open.web.security.a.f461879b = true;
        return super.dispatchKeyEvent(r100);
    L15:
        if (r100.getUnicodeChar() != 0) goto L19;
        return super.dispatchKeyEvent(r100);
    L19:
        if (SecureJsInterface.isPWDEdit == false) goto L31;
        int r102 = r100.getUnicodeChar();
        if (r102 < 33) goto L25;
        if (r102 > 95) goto L25;
    L28:
        KeyEvent r103 = new KeyEvent(0, 17);
        this.f461749b = r103;
        return super.dispatchKeyEvent(r103);
    L25:
        if (r102 < 97) goto L31;
        if (r102 <= 125) goto L28;
    L31:
        return super.dispatchKeyEvent(r100);
    L35:
        return super.dispatchKeyEvent(r100);
    L37:
        return super.dispatchKeyEvent(r100);
    L39:
        return super.dispatchKeyEvent(r100);
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo r100) {
        SLog.i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + SecureJsInterface.isPWDEdit);
        InputConnection r101 = super.onCreateInputConnection(r100);
        SLog.v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + r101);
        if (r101 == null) goto L6;
        f461748a = true;
        com.tencent.open.web.security.a r102 = new com.tencent.open.web.security.a(super.onCreateInputConnection(r100), false);
        this.f461750c = r102;
        return r102;
    L6:
        f461748a = false;
        return r101;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r100, KeyEvent r101) {
        SLog.d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f461748a);
        if (f461748a == true) goto L7;
        return super.onKeyDown(r100, r101);
    L7:
        if (r101.getAction() != 0) goto L39;
        int r102 = r101.getKeyCode();
        if (r102 == 4) goto L37;
        if (r102 == 66) goto L35;
        if (r102 != 67) goto L15;
        com.tencent.open.web.security.a.f461879b = true;
        return super.onKeyDown(r100, r101);
    L15:
        if (r101.getUnicodeChar() != 0) goto L19;
        return super.onKeyDown(r100, r101);
    L19:
        if (SecureJsInterface.isPWDEdit == false) goto L31;
        int r103 = r101.getUnicodeChar();
        if (r103 < 33) goto L25;
        if (r103 > 95) goto L25;
    L28:
        KeyEvent r104 = new KeyEvent(0, 17);
        this.f461749b = r104;
        return super.onKeyDown(r104.getKeyCode(), this.f461749b);
    L25:
        if (r103 < 97) goto L31;
        if (r103 <= 125) goto L28;
    L31:
        return super.onKeyDown(r100, r101);
    L35:
        return super.onKeyDown(r100, r101);
    L37:
        return super.onKeyDown(r100, r101);
    L39:
        return super.onKeyDown(r100, r101);
    }
}
