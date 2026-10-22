package com.bytedance.ee.bear.drive.view.preview.htmlrender;

import android.content.Context;
import android.util.AttributeSet;
import c95.c;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import fo5.d;
import io.reactivex.Flowable;
import j95.j;
import j95.k;
import j95.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class HtmlRenderView extends BaseWebPreviewView {
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
        return "HtmlRenderView";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        getWebView().setOnClickListener(null);
        a r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.a == null) goto L15;
        c r1 = this.c;
        if (r1 == null) goto L9;
        r1.onShowStart();
    L9:
        j65.a.b(this.d, "HtmlRenderView");
        DriveFilePath r2 = this.h.a.d;
        if (r2.isEmpty() == false) goto L12;
        tt5.a.d("HtmlRenderView", "showDocuments filePath is empty");
        return;
    L12:
        this.b = Flowable.just(r2).map(new j(this)).subscribeOn(d.b()).observeOn(d.d()).subscribe(new k(this), new l(this));
        return;
    }

    public HtmlRenderView(Context r1) {
        super(r1);
    }

    public HtmlRenderView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public HtmlRenderView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }
}
