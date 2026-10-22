package com.bytedance.ee.bear.imageviewer;

import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import io.reactivex.FlowableEmitter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final class d3 implements mlb.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowableEmitter f226892a;

    public d3(FlowableEmitter r100) {
        this.f226892a = r100;
    }

    @Override // mlb.d.a
    public final void a(ArrayList<QRCodeResultInfo> r100) {
        tt5.a.h("ImageViewer", "initActionSheet() ImageQRCodeKit.scan success");
        if (this.f226892a.isCancelled() == true) goto L6;
        this.f226892a.onNext(r100);
        this.f226892a.onComplete();
        return;
    }

    @Override // mlb.d.a
    public final void onError(String r100) {
        tt5.a.d("ImageViewer", "initActionSheet() ImageQRCodeKit.scan failed: " + r100);
        this.f226892a.tryOnError(new Exception(r100));
    }
}
