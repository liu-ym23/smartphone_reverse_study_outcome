package com.bytedance.ee.bear.drive.view.preview.document;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import c95.c;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import i95.k;
import i95.m;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public class DocumentView extends BaseWebPreviewView {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f224809j = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f224810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f224811i;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final z f224812a;

        public a(z r100) {
            this.f224812a = r100;
        }
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView
    public /* bridge */ /* synthetic */ z getPreviewFileModel() {
        return null;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, m85.a
    public String getReleaseKey() {
        return "DocumentView";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        tt5.a.h("preview_document", "documentview show()");
        a r100 = this.f224810h;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.f224812a == null) goto L15;
        c r101 = this.f224802c;
        if (r101 == null) goto L9;
        r101.onShowStart();
    L9:
        j65.a.b(this.f224803d, "DocumentView");
        DriveFilePath r102 = this.f224810h.f224812a.f225836d;
        if (r102.isEmpty() == false) goto L12;
        tt5.a.d("DocumentView", "showDocuments filePath is empty");
        return;
    L12:
        this.f224800a.addJavascriptInterface(new m(this, r102), "jsObj");
        this.f224800a.loadUrl("file:///android_asset/highlight/drive_highlight.html");
        return;
    }

    public DocumentView(Context r100) {
        super(r100);
        this.f224811i = true;
    }

    public void setHighLight(boolean r100) {
        this.f224811i = r100;
    }

    public DocumentView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f224811i = true;
    }

    public final void f(final ArrayList<String> r100, final int r101) {
        if (isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (r101 >= r100.size()) goto L9;
        this.f224800a.evaluateJavascript(String.format("javascript:setString('%1$s',%2$s)", new Object[]{Base64.encodeToString(((String) ListProtector.get(r100, r101)).getBytes(), 2), String.valueOf(this.f224811i)}), new k(this, r100, r101));
        return;
    }

    public DocumentView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f224811i = true;
    }
}
