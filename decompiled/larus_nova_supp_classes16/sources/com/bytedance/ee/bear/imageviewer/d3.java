package com.bytedance.ee.bear.imageviewer;

import com.ss.android.lark.imageqrcode.QRCodeResultInfo;
import io.reactivex.FlowableEmitter;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d3 implements mlb.d.a {
    public final /* synthetic */ FlowableEmitter a;

    public d3(FlowableEmitter r1) {
        this.a = r1;
    }

    public final void a(ArrayList<QRCodeResultInfo> r3) {
        tt5.a.h("ImageViewer", "initActionSheet() ImageQRCodeKit.scan success");
        if (this.a.isCancelled() == true) goto L6;
        this.a.onNext(r3);
        this.a.onComplete();
        return;
    }

    public final void onError(String r3) {
        tt5.a.d("ImageViewer", "initActionSheet() ImageQRCodeKit.scan failed: " + r3);
        this.a.tryOnError(new Exception(r3));
    }
}
