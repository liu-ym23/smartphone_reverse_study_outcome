package com.bytedance.ee.bear.edit.component.richtexteditor;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.webkit.WebViewClient;
import com.bytedance.ee.bear.jsbridge.BridgeWebViewV2;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class RichTextEditorWebView extends BridgeWebViewV2 {
    public boolean F;

    public static class a extends InputConnectionWrapper {
        public a(InputConnection r100) {
            super(r100, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r100) {
            return super.sendKeyEvent(r100);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r110, int r111) {
            if ((r110 - r111) != 1) goto L7;
            long r112 = SystemClock.uptimeMillis();
            super.sendKeyEvent(new KeyEvent(r112, r112, 0, 67, 0, 0, -1, 0, 22));
            super.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), r112, 1, 67, 0, 0, -1, 0, 22));
            return true;
        L7:
            return super.deleteSurroundingText(r110, r111);
        }
    }

    @Override // com.bytedance.ee.larkwebview.base.LarkWebView, com.bytedance.ee.larkwebview.base.g, ft5.a
    public String getBizType() {
        return "docs";
    }

    public RichTextEditorWebView(Context r100) {
        super(r100);
        this.F = true;
    }

    @Override // android.webkit.WebView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r100) {
        InputConnection r101 = super.onCreateInputConnection(r100);
        if (this.F == false) goto L8;
        if (r101 != null) goto L7;
        return null;
    L7:
        return new a(r101);
    L8:
        return r101;
    }

    public void setBridgeWebViewClient(com.bytedance.ee.bear.edit.component.richtexteditor.a r100) {
        setWebViewClient(r100);
    }

    public void setUseInputWrapper(boolean r100) {
        this.F = r100;
    }

    @Override // com.bytedance.ee.larkwebview.base.g, android.webkit.WebView
    public void setWebViewClient(WebViewClient r100) {
        eu5.a.b((Application) getContext().getApplicationContext());
        super.setWebViewClient(r100);
    }

    public RichTextEditorWebView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.F = true;
    }

    @Override // com.bytedance.ee.bear.jsbridge.BridgeWebViewV2, com.bytedance.ee.larkwebview.base.LarkWebView, com.bytedance.ee.larkwebview.base.g, android.webkit.WebView
    public final void loadUrl(String r100, Map<String, String> r101) {
        super.loadUrl(r100, r101);
    }

    @Override // com.bytedance.ee.bear.jsbridge.BridgeWebViewV2
    public final void p(String r100, boolean r101) {
        super.p(r100, false);
    }
}
