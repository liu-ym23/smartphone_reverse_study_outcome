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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RichTextEditorWebView extends BridgeWebViewV2 {
    public boolean F;

    public static class a extends InputConnectionWrapper {
        public a(InputConnection r2) {
            super(r2, true);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean sendKeyEvent(KeyEvent r1) {
            return super.sendKeyEvent(r1);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public final boolean deleteSurroundingText(int r18, int r19) {
            if ((r18 - r19) != 1) goto L7;
            long r16 = SystemClock.uptimeMillis();
            super.sendKeyEvent(new KeyEvent(r16, r16, 0, 67, 0, 0, -1, 0, 22));
            super.sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), r16, 1, 67, 0, 0, -1, 0, 22));
            return true;
        L7:
            return super.deleteSurroundingText(r18, r19);
        }
    }

    public String getBizType() {
        return "docs";
    }

    public RichTextEditorWebView(Context r1) {
        super(r1);
        this.F = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final InputConnection onCreateInputConnection(EditorInfo r2) {
        InputConnection r3 = super/*android.webkit.WebView*/.onCreateInputConnection(r2);
        if (this.F == false) goto L8;
        if (r3 != null) goto L7;
        return null;
    L7:
        return new a(r3);
    L8:
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBridgeWebViewClient(com.bytedance.ee.bear.edit.component.richtexteditor.a r1) {
        setWebViewClient(r1);
    }

    public void setUseInputWrapper(boolean r1) {
        this.F = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setWebViewClient(WebViewClient r2) {
        eu5.a.b((Application) getContext().getApplicationContext());
        super/*com.bytedance.ee.larkwebview.base.g*/.setWebViewClient(r2);
    }

    public RichTextEditorWebView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.F = true;
    }

    @Override // com.bytedance.ee.bear.jsbridge.BridgeWebViewV2
    public final void loadUrl(String r1, Map<String, String> r2) {
        super.loadUrl(r1, r2);
    }

    @Override // com.bytedance.ee.bear.jsbridge.BridgeWebViewV2
    public final void p(String r1, boolean r2) {
        super.p(r1, false);
    }
}
