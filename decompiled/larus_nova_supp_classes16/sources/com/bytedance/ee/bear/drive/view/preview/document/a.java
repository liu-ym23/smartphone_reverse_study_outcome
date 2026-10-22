package com.bytedance.ee.bear.drive.view.preview.document;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import i75.o;
import i95.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends n75.b<String> {
    public final /* synthetic */ DriveFilePath a;
    public final /* synthetic */ BaseWebPreviewView.a b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ BaseWebPreviewView f;

    @Override // n75.b
    public final void a(final n75.a<String> r8) throws Exception {
        DriveFilePath r0 = this.a;
        final BaseWebPreviewView.a r1 = this.b;
        o.a(r0, new c(r8, r1), this.c, this.d, this.e, this.f.f.b);
        r8.onNext(this.b.a("", false));
        r8.onComplete();
    }

    public a(BaseWebPreviewView r1, DriveFilePath r2, BaseWebPreviewView.a r3) {
        this.f = r1;
        this.a = r2;
        this.b = r3;
        this.c = 100000;
        this.d = 110000;
        this.e = false;
    }
}
