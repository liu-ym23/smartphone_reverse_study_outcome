package com.bytedance.ee.bear.drive.view.preview.markdown;

import android.content.Context;
import android.util.AttributeSet;
import c95.c;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import t95.e;

/* JADX INFO: loaded from: classes16.dex */
public class MarkdownView extends BaseWebPreviewView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f225067i = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f225068h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f225069a;

        public a(z r100) {
            this.f225069a = r100;
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
        a r100 = this.f225068h;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f225069a == null) goto L15;
        c r101 = this.f224802c;
        if (r101 == null) goto L9;
        r101.onShowStart();
    L9:
        j65.a.b(this.f224803d, "MarkdownView");
        DriveFilePath r102 = this.f225068h.f225069a.f225836d;
        if (r102.isEmpty() == false) goto L12;
        tt5.a.d("MarkdownView", "showDocuments filePath is empty");
        return;
    L12:
        this.f224800a.addJavascriptInterface(new e(this, r102), "jsObj");
        this.f224800a.loadUrl("file:///android_asset/markdown/drive_markdown.html");
        return;
    }

    public MarkdownView(Context r100) {
        super(r100);
    }

    public MarkdownView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public MarkdownView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
