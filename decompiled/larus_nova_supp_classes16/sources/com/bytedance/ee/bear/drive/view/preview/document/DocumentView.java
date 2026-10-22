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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DocumentView extends BaseWebPreviewView {
    public static final /* synthetic */ int j = 0;
    public a h;
    public boolean i;

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
        return "DocumentView";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        tt5.a.h("preview_document", "documentview show()");
        a r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == null) goto L15;
        c r1 = this.c;
        if (r1 == null) goto L9;
        r1.onShowStart();
    L9:
        j65.a.b(this.d, "DocumentView");
        DriveFilePath r2 = this.h.a.d;
        if (r2.isEmpty() == false) goto L12;
        tt5.a.d("DocumentView", "showDocuments filePath is empty");
        return;
    L12:
        this.a.addJavascriptInterface(new m(this, r2), "jsObj");
        this.a.loadUrl("file:///android_asset/highlight/drive_highlight.html");
        return;
    }

    public DocumentView(Context r1) {
        super(r1);
        this.i = true;
    }

    public void setHighLight(boolean r1) {
        this.i = r1;
    }

    public DocumentView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.i = true;
    }

    public final void f(final ArrayList<String> r4, final int r5) {
        if (isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (r5 >= r4.size()) goto L9;
        this.a.evaluateJavascript(String.format("javascript:setString('%1$s',%2$s)", new Object[]{Base64.encodeToString(((String) ListProtector.get(r4, r5)).getBytes(), 2), String.valueOf(this.i)}), new k(this, r4, r5));
        return;
    }

    public DocumentView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.i = true;
    }
}
