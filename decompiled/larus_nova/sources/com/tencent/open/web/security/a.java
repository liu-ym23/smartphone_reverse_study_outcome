package com.tencent.open.web.security;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import com.tencent.open.log.SLog;

/* JADX INFO: loaded from: classes35.dex */
public class a extends InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f461878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f461879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f461880c;

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent r100) {
        if (r100.getAction() != 0) goto L5;
        SLog.i("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
        f461878a = String.valueOf((char) r100.getUnicodeChar());
        f461880c = true;
        SLog.d("openSDK_LOG.CaptureInputConnection", "s: " + f461878a);
    L5:
        SLog.d("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + f461878a);
        return super.sendKeyEvent(r100);
    }

    public a(InputConnection r100, boolean r101) {
        super(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence r100, int r101) {
        f461880c = true;
        f461878a = r100.toString();
        SLog.v("openSDK_LOG.CaptureInputConnection", "-->commitText: " + r100.toString());
        return super.commitText(r100, r101);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence r100, int r101) {
        f461880c = true;
        f461878a = r100.toString();
        SLog.v("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + r100.toString());
        return super.setComposingText(r100, r101);
    }
}
