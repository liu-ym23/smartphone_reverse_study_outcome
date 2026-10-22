package com.bytedance.ee.bear.drive.view.preview.document;

import android.webkit.JavascriptInterface;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import i95.d;
import i95.e;
import i95.f;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f224819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DriveFilePath f224820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CsvView f224821c;

    @JavascriptInterface
    public void webviewIsReady() {
        tt5.a.h("CsvView", "webviewIsReady");
        CsvView r100 = this.f224821c;
        r100.f224801b = r100.e(this.f224820b, new d(this)).subscribe(new e(this), new f(this));
    }

    public b(CsvView r100, DriveFilePath r101) {
        this.f224821c = r100;
        this.f224820b = r101;
        this.f224819a = true;
    }
}
