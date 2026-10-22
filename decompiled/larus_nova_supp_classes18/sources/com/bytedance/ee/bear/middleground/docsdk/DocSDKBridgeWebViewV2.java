package com.bytedance.ee.bear.middleground.docsdk;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.edit.component.richtexteditor.RichTextEditorWebView;
import of5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class DocSDKBridgeWebViewV2 extends RichTextEditorWebView {
    public DocSDKBridgeWebViewV2(Context r1) {
        super(r1);
    }

    public void setBridgeWebViewClient(c r1) {
        super.setBridgeWebViewClient(r1);
    }

    public DocSDKBridgeWebViewV2(Context r1, AttributeSet r2) {
        super(r1, r2);
    }
}
