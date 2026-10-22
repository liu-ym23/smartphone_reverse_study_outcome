package com.bytedance.ee.bear.drive.view.preview.excel;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView;
import com.bytedance.ee.bear.drive.view.preview.wrapper.PreviewViewModel;
import com.bytedance.ee.bear.drive.view.preview.wrapper.z;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ExcelRenderView extends BaseWebPreviewView {
    public static final /* synthetic */ int k = 0;
    public a h;
    public j i;
    public final CompositeDisposable j;

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
        return "ExcelRenderView";
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final boolean onBackPressed() {
        return false;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, m85.a
    public final void onRelease() {
        super.onRelease();
        PreviewViewModel r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        this.i.i.a();
        CompositeDisposable r1 = this.j;
        if (r1 == null) goto L11;
        r1.dispose();
        return;
    L11:
        return;
    L5:
        if (r0.isBlockViewChanging() == false) goto L7;
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public final void show() {
        getWebView().setOnClickListener(null);
        getWebView().setVerticalScrollBarEnabled(false);
        getWebView().setHorizontalScrollBarEnabled(false);
        a r0 = this.h;
        if (r0 != null) goto L5;
    L10:
        tt5.a.d("ExcelRenderView", "mExcelRenderViewEntity is null or fileModel is null");
        return;
    L5:
        if (r0.a == null) goto L10;
        c95.c r1 = this.c;
        if (r1 == null) goto L9;
        r1.onShowStart();
    L9:
        j65.a.b(this.d, "ExcelRenderView");
        tt5.a.h("ExcelRenderView", "ExcelRenderView show, token = " + du5.b.g(this.h.a.o));
        j r2 = this.i;
        r2.b = this.h.a;
        this.j.add(Flowable.just("").observeOn(fo5.d.b()).map(new h(r2)).observeOn(fo5.d.d()).subscribe(new k(this), new l(this)));
    }

    public ExcelRenderView(Context r1) {
        super(r1);
        this.j = new CompositeDisposable();
    }

    public final void f(Throwable r3) {
        c95.c r0 = this.c;
        if (r0 == null) goto L5;
        r0.a("html_excel", r3);
    L5:
        j65.a.a(this.d, "ExcelRenderView");
    }

    @Override // com.bytedance.ee.bear.drive.view.preview.document.BaseWebPreviewView, com.bytedance.ee.bear.drive.view.preview.wrapper.m
    public void setUserAbility(a95.a r1) {
        super.setUserAbility(r1);
    }

    public ExcelRenderView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.j = new CompositeDisposable();
    }

    public ExcelRenderView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.j = new CompositeDisposable();
    }
}
