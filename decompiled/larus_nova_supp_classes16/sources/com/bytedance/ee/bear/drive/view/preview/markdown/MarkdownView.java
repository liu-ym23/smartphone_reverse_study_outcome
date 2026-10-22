package com.bytedance.ee.bear.drive.view.preview.markdown;

import android.content.Context;
import android.util.AttributeSet;
import c95.c;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import t95.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class MarkdownView extends BaseWebPreviewView {
    public static final /* synthetic */ int i = 0;
    public a h;

    public static class a {
        public final z a;

        public a(z r1) {
            this.a = r1;
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView
    public /* bridge */ /* synthetic */ z getPreviewFileModel() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, m85.a
    public String getReleaseKey() {
        return "MarkdownView";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        a r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == null) goto L15;
        c r1 = this.c;
        if (r1 == null) goto L9;
        r1.onShowStart();
    L9:
        j65.a.b(this.d, "MarkdownView");
        DriveFilePath r2 = this.h.a.d;
        if (r2.isEmpty() == false) goto L12;
        tt5.a.d("MarkdownView", "showDocuments filePath is empty");
        return;
    L12:
        this.a.addJavascriptInterface(new e(this, r2), "jsObj");
        this.a.loadUrl("file:///android_asset/markdown/drive_markdown.html");
        return;
    }

    public MarkdownView(Context r1) {
        super(r1);
    }

    public MarkdownView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public MarkdownView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
