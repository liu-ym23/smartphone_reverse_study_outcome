package com.bytedance.ee.bear.drive.view.preview.document;

import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.mammon.audiosdk.SAMICoreCode;
import i75.o;
import i95.c;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends n75.b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveFilePath f224813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseWebPreviewView.a f224814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f224815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f224816d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ boolean f224817e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ BaseWebPreviewView f224818f;

    @Override // n75.b
    public final void a(final n75.a<String> r100) throws Exception {
        DriveFilePath r101 = this.f224813a;
        final BaseWebPreviewView.a r102 = this.f224814b;
        o.a(r101, new c(r100, r102), this.f224815c, this.f224816d, this.f224817e, this.f224818f.f224805f.f2278b);
        r100.onNext(this.f224814b.a("", false));
        r100.onComplete();
    }

    public a(BaseWebPreviewView r100, DriveFilePath r101, BaseWebPreviewView.a r102) {
        this.f224818f = r100;
        this.f224813a = r101;
        this.f224814b = r102;
        this.f224815c = 100000;
        this.f224816d = SAMICoreCode.SAMI_PROCESSOR_BASE;
        this.f224817e = false;
    }
}
