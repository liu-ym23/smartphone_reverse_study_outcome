package com.ss.android.lark.qrcode.ui;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.biz.core.api.IQRCodeScanResultHandler;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes37.dex */
public final /* synthetic */ class e implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f439045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f439046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f439047c;

    public /* synthetic */ e(h r100, int r101, String r102) {
        this.f439045a = r100;
        this.f439046b = r101;
        this.f439047c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        h r100 = this.f439045a;
        int r101 = this.f439046b;
        String r102 = this.f439047c;
        r100.getClass();
        Log.i("QRCodeScanManager", "prepare to handle parse result: *, source: " + r101);
        int r103 = 0;
    L4:
        if (r103 >= ((ArrayList) r100.f439059b).size()) goto L21;
        IQRCodeScanResultHandler r104 = (IQRCodeScanResultHandler) ListProtector.get(r100.f439059b, r103);
        if (r104 == null) goto L20;
        dxa.b r105 = r100.f439060c;
        if (r105 == null) goto L20;
        if (r104.c(r102, r105) == false) goto L20;
        Log.i("QRCodeScanManager", r104.getClass().getName().concat(" handle result success"));
        r100.n();
        if ((r104 instanceof dxa.d) == false) goto L14;
        boolean r106 = ((dxa.d) r104).b();
    L16:
        if ((r104 instanceof dxa.e) == false) goto L18;
        boolean r107 = ((dxa.e) r104).a();
    L52:
        return new y(true, r106, r107);
    L18:
        r107 = true;
        goto L52
    L14:
        r106 = true;
    L20:
        r103 = r103 + 1;
        goto L4
    L21:
        int r108 = 0;
    L23:
        if (r108 >= ((ArrayList) r100.f439058a).size()) goto L40;
        IQRCodeScanResultHandler r109 = (IQRCodeScanResultHandler) ListProtector.get(r100.f439058a, r108);
        if (r109 == null) goto L39;
        dxa.b r110 = r100.f439060c;
        if (r110 == null) goto L39;
        if (r109.c(r102, r110) == false) goto L39;
        Log.i("QRCodeScanManager", r109.getClass().getName().concat(" handle result success"));
        r100.n();
        if ((r109 instanceof dxa.d) == false) goto L33;
        boolean r111 = ((dxa.d) r109).b();
    L35:
        if ((r109 instanceof dxa.e) == false) goto L37;
        boolean r112 = ((dxa.e) r109).a();
    L53:
        return new y(true, r111, r112);
    L37:
        r112 = true;
        goto L53
    L33:
        r111 = true;
    L39:
        r108 = r108 + 1;
        goto L23
    L40:
        Log.i("QRCodeScanManager", "no handler to handle result");
        r100.n();
        return new y(false, false, false);
    }
}
