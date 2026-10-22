package com.bytedance.ee.bear.drive.view.preview.document;

import android.webkit.JavascriptInterface;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import i95.d;
import i95.e;
import i95.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public boolean a;
    public final /* synthetic */ DriveFilePath b;
    public final /* synthetic */ CsvView c;

    @JavascriptInterface
    public void webviewIsReady() {
        tt5.a.h("CsvView", "webviewIsReady");
        CsvView r0 = this.c;
        r0.b = r0.e(this.b, new d(this)).subscribe(new e(this), new f(this));
    }

    public b(CsvView r1, DriveFilePath r2) {
        this.c = r1;
        this.b = r2;
        this.a = true;
    }
}
