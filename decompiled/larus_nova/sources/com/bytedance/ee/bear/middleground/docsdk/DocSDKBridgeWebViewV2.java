package com.bytedance.ee.bear.middleground.docsdk;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.edit.component.richtexteditor.RichTextEditorWebView;
import of5.c;

/* JADX INFO: loaded from: classes18.dex */
public abstract class DocSDKBridgeWebViewV2 extends RichTextEditorWebView {
    public DocSDKBridgeWebViewV2(Context r100) {
        super(r100);
    }

    public void setBridgeWebViewClient(c r100) {
        super.setBridgeWebViewClient(r100);
    }

    public DocSDKBridgeWebViewV2(Context r100, AttributeSet r101) {
        super(r100, r101);
    }
}
