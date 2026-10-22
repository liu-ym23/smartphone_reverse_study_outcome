package com.bytedance.ee.bear.drive.view.preview.document;

import android.content.Context;
import android.util.AttributeSet;
import c95.c;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;

/* JADX INFO: loaded from: classes16.dex */
public class CsvView extends BaseWebPreviewView {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f224806i = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f224807h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f224808a;

        public a(z r100) {
            this.f224808a = r100;
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView
    public /* bridge */ /* synthetic */ z getPreviewFileModel() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, m85.a
    public String getReleaseKey() {
        return "CsvView";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        getWebView().setVerticalScrollBarEnabled(false);
        getWebView().setHorizontalScrollBarEnabled(false);
        a r100 = this.f224807h;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f224808a == null) goto L15;
        c r101 = this.f224802c;
        if (r101 == null) goto L9;
        r101.onShowStart();
    L9:
        j65.a.b(this.f224803d, "CsvView");
        DriveFilePath r102 = this.f224807h.f224808a.f225836d;
        if (r102.isEmpty() == false) goto L12;
        tt5.a.d("CsvView", "showDocuments filePath is empty");
        return;
    L12:
        tt5.a.h("CsvView", "CsvView show, token = " + du5.b.g(this.f224807h.f224808a.f225847o));
        this.f224800a.addJavascriptInterface(new b(this, r102), "jsObj");
        this.f224800a.loadUrl("file:///android_asset/csv/csv.html");
        return;
    }

    public CsvView(Context r100) {
        super(r100);
    }

    public CsvView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public CsvView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
